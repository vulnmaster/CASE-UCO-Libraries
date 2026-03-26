"""Exhaustive instantiation test — construct every generated CASE/UCO class.

This catches broken imports, missing defaults, and inheritance issues
across the entire generated object model.
"""

import importlib
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent.parent))

from case_uco import registry
from case_uco.registry import _load


def setup_module():
    registry._load()


def _is_core_class(info):
    """Extension classes (ext.*) are registry-only; skip them in instantiation tests."""
    return not info["module"].startswith("ext.")


def test_instantiate_all_classes():
    """Every generated class must be importable and constructible with defaults."""
    reg = _load()
    failures = []

    for name, info in sorted(reg["classes"].items()):
        if not _is_core_class(info):
            continue
        module_path = f"case_uco.{info['module']}"
        try:
            mod = importlib.import_module(module_path)
            cls = getattr(mod, name)
            cls()
        except Exception as exc:
            failures.append(f"{module_path}.{name}: {exc}")

    assert not failures, (
        f"Failed to instantiate {len(failures)} class(es):\n"
        + "\n".join(failures)
    )


def test_all_classes_have_class_iri():
    """Every generated class must expose CLASS_IRI and NAMESPACE_PREFIX."""
    reg = _load()
    failures = []

    for name, info in sorted(reg["classes"].items()):
        if not _is_core_class(info):
            continue
        module_path = f"case_uco.{info['module']}"
        try:
            mod = importlib.import_module(module_path)
            cls = getattr(mod, name)
            instance = cls()
            assert hasattr(instance, "CLASS_IRI"), f"{name} missing CLASS_IRI"
            assert hasattr(instance, "NAMESPACE_PREFIX"), f"{name} missing NAMESPACE_PREFIX"
            assert instance.CLASS_IRI, f"{name} has empty CLASS_IRI"
        except Exception as exc:
            failures.append(f"{module_path}.{name}: {exc}")

    assert not failures, (
        f"Failed on {len(failures)} class(es):\n"
        + "\n".join(failures)
    )


def test_all_classes_addable_to_graph():
    """Every generated class must be accepted by CASEGraph.add()."""
    from case_uco.graph import CASEGraph

    reg = _load()
    graph = CASEGraph()
    failures = []

    for name, info in sorted(reg["classes"].items()):
        if not _is_core_class(info):
            continue
        module_path = f"case_uco.{info['module']}"
        try:
            mod = importlib.import_module(module_path)
            cls = getattr(mod, name)
            instance = cls()
            graph.add(instance)
        except ValueError:
            pass  # required field validation is expected
        except Exception as exc:
            failures.append(f"{module_path}.{name}: {exc}")

    assert not failures, (
        f"Failed to add {len(failures)} class(es) to graph:\n"
        + "\n".join(failures)
    )
