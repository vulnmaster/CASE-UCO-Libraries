# Cross-Language Parity Contract

This document defines what is intentionally identical across all four SDK languages (Python, C#, Java, Rust) and what is intentionally language-idiomatic. It serves as a reference for contributors, AI coding assistants, and developers switching between languages.

## Canonical Mental Model

Every language follows the same three-step workflow:

1. **Create a graph** — a container for CASE/UCO objects with a JSON-LD context
2. **Add typed objects** — instantiate ontology classes and insert them into the graph
3. **Serialize** — write the graph as JSON-LD

## Identical Across All Languages

### Core Operations

These operations exist in every language with parallel naming (adjusted only for language casing conventions):

| Operation | Python | C# | Java | Rust |
|-----------|--------|----|------|------|
| Create graph | `CASEGraph()` | `new CaseGraph()` | `new CaseGraph()` | `CaseGraph::new()` |
| Add object | `graph.create(Type, ...)` | `graph.Add(obj)` | `graph.add(obj)` | `graph.create(&obj)` |
| Add with ID | `graph.create(Type, id=...)` | `graph.AddWithId(obj, id)` | `graph.addWithId(obj, id)` | `graph.create_with_id(id, &obj)` |
| Serialize | `graph.serialize()` | `graph.Serialize()` | `graph.serialize()` | `graph.serialize()` |
| Write to file | `graph.write(path)` | `graph.Write(path)` | `graph.write(path)` | `graph.write(path)` |
| Load from string | `graph.load(json)` | `graph.Load(json)` | `graph.load(json)` | `graph.load(json)` |
| Load from file | `graph.load_file(path)` | `graph.LoadFile(path)` | `graph.loadFile(path)` | `graph.load_file(path)` |
| Object count | `len(graph)` | `graph.Count` | `graph.size()` | `graph.len()` |
| Estimate triples | `graph.estimate_triples()` | `graph.EstimateTriples()` | `graph.estimateTriples()` | `graph.estimate_triples()` |
| Split graph | `graph.split(n)` | `graph.Split(n)` | `graph.split(n)` | `graph.split(n)` |
| Merge files | `CASEGraph.merge_files(paths)` | `CaseGraph.MergeFiles(paths)` | `CaseGraph.mergeFiles(paths)` | `CaseGraph::merge_files(paths)` |
| Validate | `graph.validate()` | `graph.ValidateGraph()` | `graph.validate()` | `graph.validate()` |

### Registry / Discovery

| Operation | Python | C# | Java | Rust |
|-----------|--------|----|------|------|
| Search classes | `search(query)` | `OntologyRegistry.Search(query)` | `OntologyRegistry.search(query)` | `registry::search(query)` |
| Get class details | `get_class(name)` | `OntologyRegistry.GetClass(name)` | `OntologyRegistry.getClass(name)` | `registry::get_class(name)` |
| List modules | `list_modules()` | `OntologyRegistry.ListModules()` | `OntologyRegistry.listModules()` | `registry::list_modules()` |
| List classes | `list_classes()` | `OntologyRegistry.ListClasses()` | `OntologyRegistry.listClasses()` | `registry::list_classes()` |
| Find facets | `find_facets()` | `OntologyRegistry.FindFacets()` | `OntologyRegistry.findFacets()` | `registry::find_facets()` |
| Find by property type | `find_by_property_type(t)` | `OntologyRegistry.FindByPropertyType(t)` | `OntologyRegistry.findByPropertyType(t)` | `registry::find_by_property_type(t)` |
| List vocabs | `list_vocabs()` | `OntologyRegistry.ListVocabs()` | `OntologyRegistry.listVocabs()` | `registry::list_vocabs()` |

### Provenance Metadata

Every language exposes the ontology versions used to generate the SDK:

| Metadata | Python | C# | Java | Rust |
|----------|--------|----|------|------|
| UCO version | `case_uco.UCO_VERSION` | `CaseUcoMeta.UcoVersion` | `CaseUcoMeta.UCO_VERSION` | `case_uco::UCO_VERSION` |
| CASE version | `case_uco.CASE_VERSION` | `CaseUcoMeta.CaseVersion` | `CaseUcoMeta.CASE_VERSION` | `case_uco::CASE_VERSION` |

### JSON-LD Output

All four languages produce byte-identical JSON-LD output for the same input. This includes:
- The same 18 namespace prefixes in the `@context`
- The same `@type` IRIs
- The same property names (JSON-LD key names are ontology IRIs, not language-native names)
- The same `@id` format (`kb:TypeName-UUID`)

### Validation Behavior

- **Required-field validation** is enforced at graph insertion time in all four languages. If an ontology-mandated property is missing, the `create()`/`add()` call raises an error.
- Fields are optional at construction time; validation is deferred to graph insertion.

## Intentionally Language-Idiomatic

These differences follow each language's conventions and are not bugs:

### Object Construction

| Language | Pattern | Rationale |
|----------|---------|-----------|
| Python | `graph.create(Tool, name="My Tool")` | Keyword arguments; class passed as first arg |
| C# | `var t = new Tool { Name = "..." }; graph.Add(t);` | Object initializer syntax; PascalCase properties |
| Java | `var t = new Tool(); t.setName("..."); graph.add(t);` | JavaBean setter pattern; camelCase methods |
| Rust | `let t = Tool::builder().build(); graph.create(&t);` | Builder pattern; snake_case; borrow semantics |

### Naming Conventions

| Convention | Python | C# | Java | Rust |
|------------|--------|----|------|------|
| Methods | `snake_case` | `PascalCase` | `camelCase` | `snake_case` |
| Properties | `snake_case` | `PascalCase` | `camelCase` (getters/setters) | `snake_case` |
| Types/Classes | `PascalCase` | `PascalCase` | `PascalCase` | `PascalCase` |
| Modules/Namespaces | `snake_case` | `PascalCase` | `lowercase.dot.separated` | `snake_case` |

### Features with Asymmetric Support

| Feature | Python | C# | Java | Rust | Notes |
|---------|--------|----|------|------|-------|
| Typed deserialization | `from_jsonld()` | `FromJsonLd()` | `fromJsonLd()` | `from_jsonld()` | Python returns typed objects; C#/Java use reflection; Rust returns serde_json::Value |
| Graph validation wrapper | `graph.validate()` | `graph.ValidateGraph()` | `graph.validate()` | `graph.validate()` | Wraps case_validate; requires case-utils on PATH |
| Smoke test binary | — | `CaseUco.Smoke` | `SmokeTest` | `examples/smoke` | Python uses pytest instead |

### Why `create()` vs `Add()`

Python's `graph.create(Tool, ...)` both constructs and inserts in one call. C# and Java separate construction from insertion because their object initializer / setter patterns make single-call construction less natural. Rust uses `graph.create(&tool)` with a borrow because Rust's ownership model requires the caller to own the object.

The operation count differs (1 call in Python, 2+ in C#/Java, 2 in Rust), but the mental model is the same: build an object, put it in the graph.

## Stability Guarantees

- **Stable**: All operations listed in "Identical Across All Languages" above. These will not be renamed or removed without a major version bump.
- **Stable**: JSON-LD output format. The `@context`, `@type`, and property key names are defined by the ontology and will not change within an ontology version.
- **Unstable**: Internal module structure (e.g., which generated file a class lives in). Import paths may change between releases.
- **Unstable**: Features listed as asymmetric above may be added to additional languages in future releases.

## Migration Notes

When upgrading between SDK versions:
- Check the [CHANGELOG.md](../CHANGELOG.md) for breaking changes
- Regenerated code may move classes between internal modules — update import paths accordingly
- New required properties added by ontology updates will cause validation errors on existing code
