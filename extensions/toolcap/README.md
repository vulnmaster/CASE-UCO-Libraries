# Forensic Tool Capability Extension (toolcap)

A CASE/UCO extension for modeling which forensic tools can parse which applications, on which platforms, for which observable types.

## Classes

- **ToolCapability** — Asserts that a forensic tool can parse data from a specific application on a specific platform
- **CapabilityMatrix** — A collection of tool capabilities representing a comparison matrix

## Properties

| Property | Type | Description |
|----------|------|-------------|
| `toolcap:tool` | `uco-tool:Tool` | The forensic tool |
| `toolcap:application` | `uco-observable:ObservableObject` | The application whose data can be parsed |
| `toolcap:supportedPlatform` | `xsd:string` (list) | Platforms (Android, iOS, Windows, etc.) |
| `toolcap:parsedObservableType` | `xsd:string` (list) | Observable types (messages, contacts, etc.) |
| `toolcap:toolVersion` | `xsd:string` | Tool version tested |
| `toolcap:isVerified` | `xsd:boolean` | Whether independently verified |
| `toolcap:lastTestedDate` | `xsd:dateTime` | Last test date |

## Example

```bash
python example_capability_matrix.py
```

See `example_capability_matrix.py` for a complete working example.
