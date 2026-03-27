.PHONY: all generate build test clean init lint smoke check venv

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
