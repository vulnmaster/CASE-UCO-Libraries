// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-location

using System;
using System.Collections.Generic;

namespace CaseUco.Uco.Location
{
    /// <summary>A GPS coordinates facet is a grouping of characteristics unique to the expression of quantified dilution of precision (DOP) for an asserted set of geolocation coordinates typically associated with sat</summary>
    public class GPSCoordinatesFacet : Facet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/location/GPSCoordinatesFacet";
        public const string NamespacePrefix = "uco-location";
        public decimal? Hdop { get; set; }
        public decimal? Pdop { get; set; }
        public decimal? Tdop { get; set; }
        public decimal? Vdop { get; set; }
    }

    /// <summary>A lat long coordinates facet is a grouping of characteristics unique to the expression of a geolocation as the intersection of specific latitude, longitude, and altitude values.</summary>
    public class LatLongCoordinatesFacet : Facet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/location/LatLongCoordinatesFacet";
        public const string NamespacePrefix = "uco-location";
        public decimal? Altitude { get; set; }
        public decimal? Latitude { get; set; }
        public decimal? Longitude { get; set; }
    }

    /// <summary>A location is a geospatial place, site, or position.</summary>
    public class Location : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/location/Location";
        public const string NamespacePrefix = "uco-location";
    }

    /// <summary>A simple address facet is a grouping of characteristics unique to a geolocation expressed as an administrative address.</summary>
    public class SimpleAddressFacet : Facet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/location/SimpleAddressFacet";
        public const string NamespacePrefix = "uco-location";
        public string? AddressType { get; set; }
        public string? Country { get; set; }
        public string? Locality { get; set; }
        public string? PostalCode { get; set; }
        public string? Region { get; set; }
        public string? Street { get; set; }
    }

}