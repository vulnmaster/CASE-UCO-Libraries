.PHONY: all generate build test clean init lint smoke check venv \
       test-proposal validate-proposal sparql-test-proposal \
       test-extension-compat test-extension-main test-extension-develop test-extension-develop2

VENV := .venv
PYTHON := $(VENV)/bin/python
PIP := $(VENV)/bin/pip

all: init generate build test

venv: $(VENV)/bin/activate

$(VENV)/bin/activate:
	python3 -m venv $(VENV)
	$(PIP) install --upgrade pip
	$(PIP) install -r requirements.txt

init: venv
	git submodule update --init --recursive
	$(PIP) install -e generator/
	$(PIP) install -e python/

generate:
	$(PYTHON) -m case_uco_generator generate --lang all

build: build-python build-csharp build-java build-rust

build-python:
	$(PIP) install -e python/

build-csharp:
	cd csharp && dotnet build

build-java:
	cd java && mvn package -q

build-rust:
	cd rust && cargo build

test: test-generator test-python test-csharp test-java test-rust

test-generator:
	PYTHONPATH=generator/src $(PYTHON) -m pytest generator/tests/ -v

test-python:
	cd python && $(abspath $(PYTHON)) -m pytest tests/ -v

test-csharp:
	cd csharp && dotnet test

test-java:
	cd java && mvn test -q

test-rust:
	cd rust && cargo test

lint: typecheck-python lint-csharp lint-java lint-rust

typecheck-python:
	cd python && $(abspath $(PYTHON)) -m mypy case_uco/ --ignore-missing-imports

lint-csharp:
	cd csharp && dotnet build --no-restore /p:TreatWarningsAsErrors=true

lint-java:
	cd java && mvn compile -q

lint-rust:
	cd rust && cargo clippy -- -D warnings

smoke: smoke-csharp smoke-java smoke-rust

smoke-csharp:
	cd csharp && dotnet run --project CaseUco.Smoke

smoke-java:
	cd java && mvn -q compile exec:java

smoke-rust:
	cd rust && cargo run --example smoke

check: generate build test lint smoke

clean:
	rm -rf python/case_uco/uco/*.py python/case_uco/case/*.py
	rm -rf csharp/CaseUco/Uco/*.cs csharp/CaseUco/Case/*.cs
	find java/src/main/java/org/caseontology -name "*.java" -not -name "CaseGraph.java" -not -name "SmokeTest.java" -delete
	rm -rf rust/src/uco/*.rs rust/src/case/*.rs

clean-venv:
	rm -rf $(VENV)

# ---------------------------------------------------------------------------
# Change proposal testing
# ---------------------------------------------------------------------------
# Usage:
#   make test-proposal PROPOSAL=cryptocurrency-address-and-sanctions-designation
#
# Expects:
#   change_proposals/<PROPOSAL>.md          — the proposal markdown
#   change_proposals/<PROPOSAL>.jsonld      — example instance data (JSON-LD)
#   change_proposals/<PROPOSAL>.sparql      — SPARQL queries (optional, one per file or multi-query)
#   change_proposals/<PROPOSAL>.ttl         — extension ontology (optional, for validation)
#   change_proposals/<PROPOSAL>-shapes.ttl  — SHACL shapes (optional, for validation)

PROPOSAL ?= example
PROPOSAL_DIR := change_proposals
PROPOSAL_JSONLD := $(PROPOSAL_DIR)/$(PROPOSAL).jsonld
PROPOSAL_SPARQL := $(PROPOSAL_DIR)/$(PROPOSAL).sparql
PROPOSAL_TTL := $(PROPOSAL_DIR)/$(PROPOSAL).ttl
PROPOSAL_SHAPES := $(PROPOSAL_DIR)/$(PROPOSAL)-shapes.ttl

validate-proposal:
	@echo "=== Validating proposal graph: $(PROPOSAL_JSONLD) ==="
	@if [ -f "$(PROPOSAL_JSONLD)" ]; then \
		VALIDATE_ARGS="--built-version case-1.4.0"; \
		if [ -f "$(PROPOSAL_TTL)" ]; then \
			VALIDATE_ARGS="$$VALIDATE_ARGS --ontology-graph $(PROPOSAL_TTL)"; \
		fi; \
		if [ -f "$(PROPOSAL_SHAPES)" ]; then \
			VALIDATE_ARGS="$$VALIDATE_ARGS --ontology-graph $(PROPOSAL_SHAPES)"; \
		fi; \
		$(VENV)/bin/case_validate $$VALIDATE_ARGS $(PROPOSAL_JSONLD); \
	else \
		echo "No .jsonld file found at $(PROPOSAL_JSONLD) — skipping validation"; \
	fi

sparql-test-proposal:
	@echo "=== Testing SPARQL queries for proposal: $(PROPOSAL) ==="
	@if [ -f "$(PROPOSAL_SPARQL)" ] && [ -f "$(PROPOSAL_JSONLD)" ]; then \
		echo "Running SPARQL queries from $(PROPOSAL_SPARQL) against $(PROPOSAL_JSONLD)"; \
		$(PYTHON) -c " \
import rdflib, sys; \
g = rdflib.Graph(); \
g.parse('$(PROPOSAL_JSONLD)', format='json-ld'); \
print(f'Loaded {len(g)} triples from $(PROPOSAL_JSONLD)'); \
sparql_text = open('$(PROPOSAL_SPARQL)').read(); \
queries = [q.strip() for q in sparql_text.split('# ---') if q.strip()]; \
if len(queries) <= 1: queries = [sparql_text]; \
passed = 0; failed = 0; \
for i, q in enumerate(queries, 1): \
    lines = [l for l in q.strip().splitlines() if not l.startswith('#')]; \
    query = '\n'.join(lines); \
    if not query.strip(): continue; \
    try: \
        results = list(g.query(query)); \
        print(f'  Query {i}: {len(results)} result(s) — OK'); \
        passed += 1; \
    except Exception as e: \
        print(f'  Query {i}: FAILED — {e}'); \
        failed += 1; \
print(f'\nSPARQL test summary: {passed} passed, {failed} failed'); \
sys.exit(1 if failed > 0 else 0); \
		"; \
	else \
		echo "No .sparql or .jsonld file found for proposal $(PROPOSAL) — skipping SPARQL tests"; \
	fi

test-proposal: validate-proposal sparql-test-proposal
	@echo ""
	@echo "=== Proposal testing complete for: $(PROPOSAL) ==="

# ---------------------------------------------------------------------------
# Extension compatibility testing
# ---------------------------------------------------------------------------
# Tests extension ontologies against multiple CASE/UCO branches to help
# ontologists review change proposals.
#
# Usage:
#   make test-extension-compat EXT_TTL=extensions/toolcap/toolcap.ttl EXT_SHAPES=extensions/toolcap/toolcap-shapes.ttl EXT_DATA=extensions/toolcap/toolcap-exemplar.ttl
#
# Runs validation against:
#   - CASE/UCO main branch (current stable release)
#   - CASE/UCO develop branch (currently targeting v1.5.0)
#   - CASE/UCO develop-2.0.0 branch (targeting v2.0.0)

EXT_TTL ?= extensions/toolcap/toolcap.ttl
EXT_SHAPES ?= extensions/toolcap/toolcap-shapes.ttl
EXT_DATA ?= extensions/toolcap/toolcap-exemplar.ttl
UCO_REPO := ontology/UCO
CASE_REPO := ontology/CASE

define test_extension_branch
	@echo ""
	@echo "=== Testing extension against $(1) branch ==="
	@CURRENT_UCO=$$(cd $(UCO_REPO) && git rev-parse HEAD); \
	CURRENT_CASE=$$(cd $(CASE_REPO) && git rev-parse HEAD); \
	cd $(UCO_REPO) && git fetch origin $(1) 2>/dev/null && git checkout FETCH_HEAD --quiet 2>/dev/null; \
	cd ../../$(CASE_REPO) && git fetch origin $(1) 2>/dev/null && git checkout FETCH_HEAD --quiet 2>/dev/null; \
	echo "UCO branch: $(1) ($$(cd $(UCO_REPO) && git rev-parse --short HEAD))"; \
	echo "CASE branch: $(1) ($$(cd $(CASE_REPO) && git rev-parse --short HEAD))"; \
	VALIDATE_ARGS=""; \
	if [ -f "$(EXT_TTL)" ]; then VALIDATE_ARGS="$$VALIDATE_ARGS --ontology-graph $(EXT_TTL)"; fi; \
	if [ -f "$(EXT_SHAPES)" ]; then VALIDATE_ARGS="$$VALIDATE_ARGS --ontology-graph $(EXT_SHAPES)"; fi; \
	if [ -f "$(EXT_DATA)" ]; then \
		$(VENV)/bin/case_validate $$VALIDATE_ARGS $(EXT_DATA) && \
		echo "  Result: PASS" || echo "  Result: FAIL"; \
	else \
		echo "  No exemplar data file found at $(EXT_DATA) — skipping"; \
	fi; \
	cd $(UCO_REPO) && git checkout $$CURRENT_UCO --quiet 2>/dev/null; \
	cd ../../$(CASE_REPO) && git checkout $$CURRENT_CASE --quiet 2>/dev/null
endef

test-extension-main:
	$(call test_extension_branch,main)

test-extension-develop:
	$(call test_extension_branch,develop)

test-extension-develop2:
	$(call test_extension_branch,develop-2.0.0)

test-extension-compat: test-extension-main test-extension-develop test-extension-develop2
	@echo ""
	@echo "=== Extension compatibility testing complete ==="
	@echo "Tested: $(EXT_TTL)"
	@echo "Against: main, develop (v1.5.0), develop-2.0.0 (v2.0.0)"
