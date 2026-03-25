// OntologyRegistry — runtime introspection for CASE/UCO ontology classes, properties, and vocabularies.
//
// Loads the auto-generated _registry.json from the classpath and exposes search,
// listing, and query methods so developers can discover the right classes without
// leaving their IDE or REPL.
package org.caseontology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Provides runtime discovery of CASE/UCO ontology classes, properties, and
 * vocabulary types. All methods are static and thread-safe after first load.
 */
public final class OntologyRegistry {

    private static volatile Map<String, Object> registry;

    private OntologyRegistry() {}

    @SuppressWarnings("unchecked")
    private static Map<String, Object> getRegistry() {
        if (registry == null) {
            synchronized (OntologyRegistry.class) {
                if (registry == null) {
                    registry = loadRegistry();
                }
            }
        }
        return registry;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> loadRegistry() {
        // Try classpath first (standard for packaged JARs)
        InputStream is = OntologyRegistry.class.getClassLoader()
                .getResourceAsStream("_registry.json");
        if (is != null) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String json = reader.lines().collect(Collectors.joining("\n"));
                return (Map<String, Object>) parseJsonValue(json.trim(), new int[]{0});
            } catch (IOException e) {
                throw new RuntimeException("Failed to read _registry.json from classpath", e);
            }
        }

        // Fall back to file system (development mode)
        Path path = Paths.get("src", "main", "resources", "_registry.json");
        if (!Files.exists(path)) {
            throw new RuntimeException(
                    "Ontology registry not found. Run 'case-uco-generate generate' to produce it.");
        }
        try {
            String json = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            return (Map<String, Object>) parseJsonValue(json.trim(), new int[]{0});
        } catch (IOException e) {
            throw new RuntimeException("Failed to read _registry.json", e);
        }
    }

    /**
     * Search for classes by keyword (case-insensitive substring match on name and description).
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> search(String query) {
        String q = query.toLowerCase();
        Map<String, Object> classes = getClassesMap();
        List<Map<String, Object>> results = new ArrayList<>();

        for (Map.Entry<String, Object> entry : classes.entrySet()) {
            String name = entry.getKey();
            Map<String, Object> cls = (Map<String, Object>) entry.getValue();
            String desc = cls.getOrDefault("description", "").toString();

            if (name.toLowerCase().contains(q) || desc.toLowerCase().contains(q)) {
                Map<String, Object> result = new LinkedHashMap<>(cls);
                result.put("name", name);
                results.add(result);
            }
        }

        results.sort(Comparator
                .comparing((Map<String, Object> m) -> m.getOrDefault("module", "").toString())
                .thenComparing(m -> m.getOrDefault("name", "").toString()));
        return results;
    }

    /**
     * List all module names (e.g. "uco.observable", "case.investigation").
     */
    @SuppressWarnings("unchecked")
    public static List<String> listModules() {
        List<Object> modules = (List<Object>) getRegistry().get("modules");
        List<String> result = new ArrayList<>();
        for (Object m : modules) result.add(m.toString());
        result.sort(String::compareTo);
        return result;
    }

    /**
     * List class names, optionally filtered by module (partial match).
     */
    @SuppressWarnings("unchecked")
    public static List<String> listClasses(String module) {
        Map<String, Object> classes = getClassesMap();
        List<String> results = new ArrayList<>();

        for (Map.Entry<String, Object> entry : classes.entrySet()) {
            if (module == null) {
                results.add(entry.getKey());
                continue;
            }
            Map<String, Object> cls = (Map<String, Object>) entry.getValue();
            String mod = cls.getOrDefault("module", "").toString();
            if (mod.toLowerCase().contains(module.toLowerCase())) {
                results.add(entry.getKey());
            }
        }
        results.sort(String::compareTo);
        return results;
    }

    /** List all class names. */
    public static List<String> listClasses() {
        return listClasses(null);
    }

    /**
     * Get full details for a class by name (case-insensitive).
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getClass(String name) {
        Map<String, Object> classes = getClassesMap();
        for (Map.Entry<String, Object> entry : classes.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name)) {
                Map<String, Object> result = new LinkedHashMap<>(
                        (Map<String, Object>) entry.getValue());
                result.put("name", entry.getKey());
                return result;
            }
        }
        return null;
    }

    /**
     * Find classes that have a property of the given type (case-insensitive).
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> findByPropertyType(String typeName) {
        String t = typeName.toLowerCase();
        Map<String, Object> classes = getClassesMap();
        List<Map<String, Object>> results = new ArrayList<>();

        for (Map.Entry<String, Object> entry : classes.entrySet()) {
            Map<String, Object> cls = (Map<String, Object>) entry.getValue();
            List<Object> props = (List<Object>) cls.get("properties");
            if (props == null) continue;

            boolean match = false;
            for (Object p : props) {
                Map<String, Object> prop = (Map<String, Object>) p;
                String pt = prop.getOrDefault("type", "").toString();
                if (pt.toLowerCase().contains(t)) { match = true; break; }
            }
            if (match) {
                Map<String, Object> result = new LinkedHashMap<>(cls);
                result.put("name", entry.getKey());
                results.add(result);
            }
        }

        results.sort(Comparator.comparing(m -> m.getOrDefault("name", "").toString()));
        return results;
    }

    /**
     * Find all Facet classes (is_facet == true).
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> findFacets() {
        Map<String, Object> classes = getClassesMap();
        List<Map<String, Object>> results = new ArrayList<>();

        for (Map.Entry<String, Object> entry : classes.entrySet()) {
            Map<String, Object> cls = (Map<String, Object>) entry.getValue();
            Object isFacet = cls.get("is_facet");
            if (Boolean.TRUE.equals(isFacet)) {
                Map<String, Object> result = new LinkedHashMap<>(cls);
                result.put("name", entry.getKey());
                results.add(result);
            }
        }

        results.sort(Comparator.comparing(m -> m.getOrDefault("name", "").toString()));
        return results;
    }

    /**
     * List all vocabulary types with their members.
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> listVocabs() {
        Object vocabsObj = getRegistry().get("vocabs");
        if (vocabsObj == null) return new ArrayList<>();
        Map<String, Object> vocabs = (Map<String, Object>) vocabsObj;
        List<Map<String, Object>> results = new ArrayList<>();

        for (Map.Entry<String, Object> entry : vocabs.entrySet()) {
            Map<String, Object> vocab = new LinkedHashMap<>(
                    (Map<String, Object>) entry.getValue());
            vocab.put("name", entry.getKey());
            results.add(vocab);
        }

        results.sort(Comparator.comparing(m -> m.getOrDefault("name", "").toString()));
        return results;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> getClassesMap() {
        return (Map<String, Object>) getRegistry().get("classes");
    }

    // --- Lightweight JSON parser (mirrors CaseGraph's parser) ---

    private static Object parseJsonValue(String json, int[] pos) {
        skipWhitespace(json, pos);
        char c = json.charAt(pos[0]);
        if (c == '{') return parseJsonObject(json, pos);
        if (c == '[') return parseJsonArray(json, pos);
        if (c == '"') return parseJsonString(json, pos);
        int start = pos[0];
        while (pos[0] < json.length() && ",}] \t\r\n".indexOf(json.charAt(pos[0])) == -1) pos[0]++;
        String token = json.substring(start, pos[0]);
        if ("true".equals(token)) return Boolean.TRUE;
        if ("false".equals(token)) return Boolean.FALSE;
        if ("null".equals(token)) return null;
        if (token.contains(".")) return Double.parseDouble(token);
        return Long.parseLong(token);
    }

    private static Map<String, Object> parseJsonObject(String json, int[] pos) {
        Map<String, Object> result = new LinkedHashMap<>();
        pos[0]++;
        skipWhitespace(json, pos);
        if (json.charAt(pos[0]) == '}') { pos[0]++; return result; }
        while (true) {
            skipWhitespace(json, pos);
            String key = parseJsonString(json, pos);
            skipWhitespace(json, pos);
            pos[0]++;
            Object value = parseJsonValue(json, pos);
            result.put(key, value);
            skipWhitespace(json, pos);
            if (json.charAt(pos[0]) == '}') { pos[0]++; return result; }
            pos[0]++;
        }
    }

    private static List<Object> parseJsonArray(String json, int[] pos) {
        List<Object> result = new ArrayList<>();
        pos[0]++;
        skipWhitespace(json, pos);
        if (json.charAt(pos[0]) == ']') { pos[0]++; return result; }
        while (true) {
            result.add(parseJsonValue(json, pos));
            skipWhitespace(json, pos);
            if (json.charAt(pos[0]) == ']') { pos[0]++; return result; }
            pos[0]++;
        }
    }

    private static String parseJsonString(String json, int[] pos) {
        pos[0]++;
        StringBuilder sb = new StringBuilder();
        while (json.charAt(pos[0]) != '"') {
            if (json.charAt(pos[0]) == '\\') {
                pos[0]++;
                switch (json.charAt(pos[0])) {
                    case '"': sb.append('"'); break;
                    case '\\': sb.append('\\'); break;
                    case 'n': sb.append('\n'); break;
                    case 'r': sb.append('\r'); break;
                    case 't': sb.append('\t'); break;
                    default: sb.append(json.charAt(pos[0])); break;
                }
            } else {
                sb.append(json.charAt(pos[0]));
            }
            pos[0]++;
        }
        pos[0]++;
        return sb.toString();
    }

    private static void skipWhitespace(String json, int[] pos) {
        while (pos[0] < json.length() && Character.isWhitespace(json.charAt(pos[0]))) pos[0]++;
    }
}
