// Tests for CaseGraph builder and JSON-LD serialization.
using System.Text.Json;
using CaseUco;
using CaseUco.Uco.Tool;
using CaseUco.Uco.Observable;
using Xunit;

namespace CaseUco.Tests
{
    public class CaseGraphTests
    {
        [Fact]
        public void CreateTool_ProducesValidJsonLd()
        {
            var graph = new CaseGraph();
            var tool = new Tool { Name = "Tool A", Version = "7.0" };
            var id = graph.Add(tool);

            Assert.StartsWith("kb:Tool-", id);
            var json = graph.Serialize();
            Assert.Contains("uco-tool:Tool", json);
            Assert.Contains("uco-core:name", json);
            Assert.DoesNotContain("uco-tool:name", json);
            Assert.Contains("@context", json);
            Assert.Contains("@graph", json);
        }

        [Fact]
        public void GetId_ReturnsAssignedId()
        {
            var graph = new CaseGraph();
            var tool = new Tool();
            var id = graph.Add(tool);
            Assert.Equal(id, graph.GetId(tool));
        }

        [Fact]
        public void AddWithId_UsesDeterministicId()
        {
            var graph = new CaseGraph();
            var tool = new Tool { Name = "Tool A" };
            var id = graph.AddWithId(tool, "kb:Tool-my-stable-id");

            Assert.Equal("kb:Tool-my-stable-id", id);
            Assert.Equal("kb:Tool-my-stable-id", graph.GetId(tool));
            var json = graph.Serialize();
            Assert.Contains("kb:Tool-my-stable-id", json);
        }

        [Fact]
        public void CustomKbPrefix_ReflectedInContext()
        {
            var graph = new CaseGraph("http://mylab.example.org/case/");
            graph.Add(new Tool { Name = "Tool A" });
            var json = graph.Serialize();
            Assert.Contains("http://mylab.example.org/case/", json);
        }

        [Fact]
        public void MultipleObjects_AllSerialized()
        {
            var graph = new CaseGraph();
            graph.Add(new Tool());
            graph.Add(new AnalyticTool());
            var json = graph.Serialize();

            using var doc = JsonDocument.Parse(json);
            var graphArray = doc.RootElement.GetProperty("@graph");
            Assert.Equal(2, graphArray.GetArrayLength());
        }

        [Fact]
        public void BooleanProperties_AreTypedLiterals()
        {
            var graph = new CaseGraph();
            graph.Add(new ObservableObject { HasChanged = true });
            var json = graph.Serialize();
            Assert.Contains("\"@type\":\"xsd:boolean\"", json.Replace(" ", ""));
            Assert.Contains("\"uco-observable:hasChanged\"", json);
        }

        [Fact]
        public void Count_TracksObjects()
        {
            var graph = new CaseGraph();
            Assert.Equal(0, graph.Count);
            graph.Add(new Tool());
            Assert.Equal(1, graph.Count);
            graph.Add(new Tool());
            Assert.Equal(2, graph.Count);
        }

        [Fact]
        public void ContextPrunesUnusedPrefixes()
        {
            var graph = new CaseGraph();
            graph.Add(new Tool { Name = "Tool A" });
            var json = graph.Serialize();

            using var doc = JsonDocument.Parse(json);
            var ctx = doc.RootElement.GetProperty("@context");

            Assert.True(ctx.TryGetProperty("kb", out _), "used prefix kb should be present");
            Assert.True(ctx.TryGetProperty("uco-tool", out _), "used prefix uco-tool should be present");
            Assert.True(ctx.TryGetProperty("uco-core", out _), "used prefix uco-core should be present");

            var unused = new[] { "uco-identity", "uco-location", "uco-role", "uco-victim",
                                 "uco-configuration", "uco-marking", "uco-pattern", "uco-time" };
            foreach (var prefix in unused)
            {
                Assert.False(ctx.TryGetProperty(prefix, out _), $"unused prefix should be pruned: {prefix}");
            }
        }

        [Fact]
        public void EmptyGraphHasEmptyContext()
        {
            var graph = new CaseGraph();
            var json = graph.Serialize();

            using var doc = JsonDocument.Parse(json);
            var ctx = doc.RootElement.GetProperty("@context");
            int count = 0;
            foreach (var _ in ctx.EnumerateObject()) count++;
            Assert.Equal(0, count);
        }

        [Fact]
        public void Load_MergesContextAndObjects()
        {
            var graph = new CaseGraph();
            var inputJson = @"{
                ""@context"": {
                    ""kb"": ""http://example.org/kb/"",
                    ""uco-tool"": ""https://ontology.unifiedcyberontology.org/uco/tool/""
                },
                ""@graph"": [
                    {
                        ""@id"": ""kb:Tool-existing-001"",
                        ""@type"": ""uco-tool:Tool""
                    }
                ]
            }";

            graph.Load(inputJson);
            Assert.Equal(1, graph.Count);

            var json = graph.Serialize();
            Assert.Contains("kb:Tool-existing-001", json);
        }

        [Fact]
        public void Load_ThenAdd_CombinesObjects()
        {
            var graph = new CaseGraph();
            graph.Load(@"{ ""@context"": { ""kb"": ""http://example.org/kb/"" }, ""@graph"": [ { ""@id"": ""kb:Tool-loaded"", ""@type"": ""uco-tool:Tool"" } ] }");
            graph.Add(new Tool { Name = "New Tool" });
            Assert.Equal(2, graph.Count);
        }
    }
}
