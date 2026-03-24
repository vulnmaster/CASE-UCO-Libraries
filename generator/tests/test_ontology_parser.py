"""Tests for ontology parsing edge cases."""

from __future__ import annotations

from pathlib import Path

from case_uco_generator.ontology_parser import parse_ontology


def _write_file(path: Path, contents: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(contents, encoding="utf-8")


def test_parse_separate_shacl_shape_and_union(tmp_path: Path) -> None:
    ontology_root = tmp_path / "ontology"

    ttl = """@prefix ex: <https://example.org/uco/test/> .
@prefix owl: <http://www.w3.org/2002/07/owl#> .
@prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> .
@prefix sh: <http://www.w3.org/ns/shacl#> .
@prefix xsd: <http://www.w3.org/2001/XMLSchema#> .

<https://example.org/uco/test> a owl:Ontology .

ex:Thing a owl:Class ;
    rdfs:label "Thing"@en .

ex:ThingShape a sh:NodeShape ;
    sh:targetClass ex:Thing ;
    sh:property [
        sh:path ex:identifier ;
        sh:minCount "1"^^xsd:integer ;
        sh:or (
            [ sh:datatype xsd:string ]
            [ sh:datatype xsd:anyURI ]
        )
    ] .

ex:identifier a owl:DatatypeProperty ;
    rdfs:comment "Identifier property"@en .
"""

    _write_file(ontology_root / "UCO" / "ontology" / "uco" / "core" / "core.ttl", ttl)
    (ontology_root / "CASE" / "ontology").mkdir(parents=True, exist_ok=True)

    schema = parse_ontology(ontology_root)

    thing = next(cls for cls in schema.classes.values() if cls.name == "Thing")
    assert thing is not None
    assert len(thing.properties) == 1

    prop = thing.properties[0]
    assert prop.name == "identifier"
    assert prop.cardinality.value == "one_or_more"
    assert prop.range_iri == "http://www.w3.org/2001/XMLSchema#string"
    assert prop.alternate_range_iris == ["http://www.w3.org/2001/XMLSchema#anyURI"]
    assert prop.is_union is True
