#!/usr/bin/env python3
"""Extract Python code blocks from documentation and verify they compile."""

import glob
import os
import re
import sys
import textwrap

DOC_FILES = [
    "README.md",
    "docs/MAPPING_GUIDE.md",
]
DOC_GLOBS = [
    "docs/recipes/*.md",
]

FENCE_OPEN = re.compile(r"^```python\s*$")
FENCE_CLOSE = re.compile(r"^```\s*$")

PLACEHOLDER_RE = re.compile(r"<[a-zA-Z_-]+>")


def collect_markdown_files():
    root = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    files = []
    for path in DOC_FILES:
        full = os.path.join(root, path)
        if os.path.isfile(full):
            files.append(full)
    for pattern in DOC_GLOBS:
        files.extend(sorted(glob.glob(os.path.join(root, pattern))))
    return files


def extract_snippets(filepath):
    """Yield (code, line_number) tuples for each ```python block."""
    snippets = []
    with open(filepath, encoding="utf-8") as f:
        lines = f.readlines()

    inside = False
    block_lines = []
    block_start = 0

    for i, line in enumerate(lines, start=1):
        if not inside:
            if FENCE_OPEN.match(line.strip()):
                inside = True
                block_start = i + 1
                block_lines = []
        else:
            if FENCE_CLOSE.match(line.strip()):
                inside = False
                snippets.append(("\n".join(block_lines), block_start))
            else:
                block_lines.append(line.rstrip("\n"))

    return snippets


def should_skip(code):
    for line in code.splitlines():
        stripped = line.strip()
        if stripped == "# skip-test":
            return True
        if stripped == "...":
            return True
        if PLACEHOLDER_RE.search(stripped):
            return True
    return False


def main():
    files = collect_markdown_files()
    passed = 0
    failed = 0
    skipped = 0
    failures = []

    for filepath in files:
        rel = os.path.relpath(filepath)
        snippets = extract_snippets(filepath)
        for code, lineno in snippets:
            if should_skip(code):
                skipped += 1
                continue

            try:
                compile(textwrap.dedent(code), f"{rel}:{lineno}", "exec")
                passed += 1
            except SyntaxError as exc:
                failed += 1
                failures.append((rel, lineno, exc))

    for rel, lineno, exc in failures:
        print(f"FAIL  {rel}:{lineno}: {exc.msg} (line {exc.lineno})")

    print()
    print(f"{passed} passed, {failed} failed, {skipped} skipped")

    return 1 if failed else 0


if __name__ == "__main__":
    sys.exit(main())
