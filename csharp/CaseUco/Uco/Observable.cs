// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-observable

using System;
using System.Collections.Generic;
using CaseUco.Uco.Action;
using CaseUco.Uco.Configuration;
using CaseUco.Uco.Core;
using CaseUco.Uco.Identity;
using CaseUco.Uco.Location;
using CaseUco.Uco.Types;

namespace CaseUco.Uco.Observable
{
    /// <summary>Vocabulary: WhoisDNSSECTypeVocab</summary>
    public static class WhoisDNSSECTypeVocab
    {
        public const string IRI = "https://ontology.unifiedcyberontology.org/uco/vocabulary/WhoisDNSSECTypeVocab";
        public const string Signed = "Signed";
        public const string Unsigned = "Unsigned";
    }

    /// <summary>Vocabulary: WindowsVolumeAttributeVocab</summary>
    public static class WindowsVolumeAttributeVocab
    {
        public const string IRI = "https://ontology.unifiedcyberontology.org/uco/vocabulary/WindowsVolumeAttributeVocab";
        public const string Hidden = "Hidden";
        public const string NoDefaultDriveLetter = "NoDefaultDriveLetter";
        public const string ReadOnly = "ReadOnly";
        public const string ShadowCopy = "ShadowCopy";
    }

    /// <summary>An API (application programming interface) is a computing interface that defines interactions between multiple software or mixed hardware-software intermediaries. It defines the kinds of calls or requ</summary>
    public class API : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/API";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An ARP cache is a collection of Address Resolution Protocol (ARP) entries (mostly dynamic) that are created when an IP address is resolved to a MAC address (so the computer can effectively communicate</summary>
    public class ARPCache : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ARPCache";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An ARP cache entry is a single Address Resolution Protocol (ARP) response record that is created when an IP address is resolved to a MAC address (so the computer can effectively communicate with the I</summary>
    public class ARPCacheEntry : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ARPCacheEntry";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An account is an arrangement with an entity to enable and control the provision of some capability or service.</summary>
    public class Account : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Account";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An account authentication facet is a grouping of characteristics unique to the mechanism of accessing an account.</summary>
    public class AccountAuthenticationFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AccountAuthenticationFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Password { get; set; }
        public DateTime? PasswordLastChanged { get; set; }
        public string PasswordType { get; set; }
    }

    /// <summary>An account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of some capability or service.</summary>
    public class AccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string AccountIdentifier { get; set; }
        public UcoObject AccountIssuer { get; set; }
        public List<string> AccountType { get; set; }
        public DateTime? ExpirationTime { get; set; }
        public bool? IsActive { get; set; }
        public DateTime? ModifiedTime { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public UcoObject Owner { get; set; }
    }

    /// <summary>An adaptor is a device that physically converts the pin outputs but does not alter the underlying protocol (e.g. uSD to SD, CF to ATA, etc.)</summary>
    public class Adaptor : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Adaptor";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An address is an identifier assigned to enable routing and management of information.</summary>
    public class Address : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Address";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An alternate data stream is data content stored within an NTFS file that is independent of the standard content stream of the file and is hidden from access by default NTFS file viewing mechanisms.</summary>
    public class AlternateDataStream : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AlternateDataStream";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An alternate data stream facet is a grouping of characteristics unique to data content stored within an NTFS file that is independent of the standard content stream of the file and is hidden from acce</summary>
    public class AlternateDataStreamFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AlternateDataStreamFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Name { get; set; }
        public Hash Hashes { get; set; }
        public long? Size { get; set; }
    }

    /// <summary>An Android device is a device running the Android operating system. [based on https://en.wikipedia.org/wiki/Android_(operating_system)]</summary>
    public class AndroidDevice : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AndroidDevice";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An Android device facet is a grouping of characteristics unique to an Android device. [based on https://en.wikipedia.org/wiki/Android_(operating_system)]</summary>
    public class AndroidDeviceFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AndroidDeviceFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string AndroidFingerprint { get; set; }
        public byte[] AndroidID { get; set; }
        public string AndroidVersion { get; set; }
        public bool? IsADBRootEnabled { get; set; }
        public bool? IsSURootEnabled { get; set; }
    }

    /// <summary>An android phone is a smart phone that applies the Android mobile operating system.</summary>
    public class AndroidPhone : AndroidDevice
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AndroidPhone";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An antenna alignment facet contains the metadata surrounding the cell tower's antenna position.</summary>
    public class AntennaFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AntennaFacet";
        public new const string NamespacePrefix = "uco-observable";
        public decimal? AntennaHeight { get; set; }
        public decimal? Azimuth { get; set; }
        public decimal? Elevation { get; set; }
        public decimal? HorizontalBeamWidth { get; set; }
        public decimal? SignalStrength { get; set; }
        public decimal? Skew { get; set; }
    }

    /// <summary>An apple device is a smart device that applies either the MacOS or iOS operating system.</summary>
    public class AppleDevice : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AppleDevice";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An appliance is a purpose-built computer with software or firmware that is designed to provide a specific computing capability or resource. [based on https://en.wikipedia.org/wiki/Computer_appliance]</summary>
    public class Appliance : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Appliance";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An application is a particular software program designed for end users.</summary>
    public class Application : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Application";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An application account is an account within a particular software program designed for end users.</summary>
    public class ApplicationAccount : DigitalAccount
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ApplicationAccount";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An application account facet is a grouping of characteristics unique to an account within a particular software program designed for end users.</summary>
    public class ApplicationAccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ApplicationAccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
    }

    /// <summary>An application facet is a grouping of characteristics unique to a particular software program designed for end users.</summary>
    public class ApplicationFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ApplicationFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string ApplicationIdentifier { get; set; }
        public List<ApplicationVersion> InstalledVersionHistory { get; set; }
        public long? NumberOfLaunches { get; set; }
        public ObservableObject OperatingSystem { get; set; }
        public string Version { get; set; }
    }

    /// <summary>An application version is a grouping of characteristics unique to a particular software program version.</summary>
    public class ApplicationVersion : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ApplicationVersion";
        public new const string NamespacePrefix = "uco-observable";
        public DateTime? InstallDate { get; set; }
        public DateTime? UninstallDate { get; set; }
        public string Version { get; set; }
    }

    /// <summary>An archive file is a file that is composed of one or more computer files along with metadata.</summary>
    public class ArchiveFile : File
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ArchiveFile";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An archive file facet is a grouping of characteristics unique to a file that is composed of one or more computer files along with metadata.</summary>
    public class ArchiveFileFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ArchiveFileFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string ArchiveType { get; set; }
        public string Comment { get; set; }
        public string Version { get; set; }
    }

    /// <summary>Audio is a digital representation of sound.</summary>
    public class Audio : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Audio";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An audio facet is a grouping of characteristics unique to a digital representation of sound.</summary>
    public class AudioFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AudioFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string AudioType { get; set; }
        public long? BitRate { get; set; }
        public long? Duration { get; set; }
        public string Format { get; set; }
    }

    /// <summary>An autonomous system is a collection of connected Internet Protocol (IP) routing prefixes under the control of one or more network operators on behalf of a single administrative entity or domain that </summary>
    public class AutonomousSystem : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AutonomousSystem";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An autonomous system facet is a grouping of characteristics unique to a collection of connected Internet Protocol (IP) routing prefixes under the control of one or more network operators on behalf of </summary>
    public class AutonomousSystemFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/AutonomousSystemFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string AsHandle { get; set; }
        public long? Number { get; set; }
        public List<string> RegionalInternetRegistry { get; set; }
    }

    /// <summary>A blackberry phone is a smart phone that applies the Blackberry OS mobile operating system. (Blackberry 10 re-introduces Blackberry OS, prior to that the OS was Android.)</summary>
    public class BlackberryPhone : SmartPhone
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/BlackberryPhone";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A block device node is a UNIX filesystem special file that serves as a conduit to communicate with devices, providing buffered randomly accesible input and output. Block device nodes are used to apply</summary>
    public class BlockDeviceNode : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/BlockDeviceNode";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Bluetooth address is a Bluetooth standard conformant identifier assigned to a Bluetooth device to enable routing and management of Bluetooth standards conformant communication to or from that device</summary>
    public class BluetoothAddress : MACAddress
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/BluetoothAddress";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Bluetooth address facet is a grouping of characteristics unique to a Bluetooth standard conformant identifier assigned to a Bluetooth device to enable routing and management of Bluetooth standards c</summary>
    public class BluetoothAddressFacet : MACAddressFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/BluetoothAddressFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A bot configuration is a set of contextual settings for a software application that runs automated tasks (scripts) over the Internet at a much higher rate than would be possible for a human alone.</summary>
    public class BotConfiguration : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/BotConfiguration";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A browser bookmark is a saved shortcut that directs a WWW (World Wide Web) browser software program to a particular WWW accessible resource. [based on https://techterms.com/definition/bookmark]</summary>
    public class BrowserBookmark : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/BrowserBookmark";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A browser bookmark facet is a grouping of characteristics unique to a saved shortcut that directs a WWW (World Wide Web) browser software program to a particular WWW accessible resource. [based on htt</summary>
    public class BrowserBookmarkFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/BrowserBookmarkFacet";
        public new const string NamespacePrefix = "uco-observable";
        public DateTime? AccessedTime { get; set; }
        public ObservableObject Application { get; set; }
        public string BookmarkPath { get; set; }
        public DateTime? ModifiedTime { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public List<Uri> UrlTargeted { get; set; }
        public long? VisitCount { get; set; }
    }

    /// <summary>A browser cookie is a piece of of data sent from a website and stored on the user's computer by the user's web browser while the user is browsing. [based on https://en.wikipedia.org/wiki/HTTP_cookie]</summary>
    public class BrowserCookie : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/BrowserCookie";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A browser cookie facet is a grouping of characteristics unique to a piece of data sent from a website and stored on the user's computer by the user's web browser while the user is browsing. [based on </summary>
    public class BrowserCookieFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/BrowserCookieFacet";
        public new const string NamespacePrefix = "uco-observable";
        public DateTime? AccessedTime { get; set; }
        public ObservableObject Application { get; set; }
        public ObservableObject CookieDomain { get; set; }
        public string CookieName { get; set; }
        public string CookiePath { get; set; }
        public DateTime? ExpirationTime { get; set; }
        public bool? IsSecure { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
    }

    /// <summary>A calendar is a collection of appointments, meetings, and events.</summary>
    public class Calendar : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Calendar";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A calendar entry is an appointment, meeting or event within a collection of appointments, meetings and events.</summary>
    public class CalendarEntry : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CalendarEntry";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A calendar entry facet is a grouping of characteristics unique to an appointment, meeting, or event within a collection of appointments, meetings, and events.</summary>
    public class CalendarEntryFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CalendarEntryFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
        public List<Identity> Attendant { get; set; }
        public long? Duration { get; set; }
        public DateTime? EndTime { get; set; }
        public string EventStatus { get; set; }
        public string EventType { get; set; }
        public bool? IsPrivate { get; set; }
        public Location Location { get; set; }
        public DateTime? ModifiedTime { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public UcoObject Owner { get; set; }
        public string Recurrence { get; set; }
        public DateTime? RemindTime { get; set; }
        public DateTime? StartTime { get; set; }
        public string Subject { get; set; }
    }

    /// <summary>A calendar facet is a grouping of characteristics unique to a collection of appointments, meetings, and events.</summary>
    public class CalendarFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CalendarFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
        public UcoObject Owner { get; set; }
    }

    /// <summary>A call is a connection as part of a realtime cyber communication between one or more parties.</summary>
    public class Call : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Call";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A call facet is a grouping of characteristics unique to a connection as part of a realtime cyber communication between one or more parties.</summary>
    public class CallFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CallFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
        public string CallType { get; set; }
        public long? Duration { get; set; }
        public DateTime? EndTime { get; set; }
        public ObservableObject From { get; set; }
        public List<ObservableObject> Participant { get; set; }
        public DateTime? StartTime { get; set; }
        public List<ObservableObject> To { get; set; }
    }

    /// <summary>CapturedTelecommunicationsInformation</summary>
    public class CapturedTelecommunicationsInformation : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CapturedTelecommunicationsInformation";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A captured telecommunications information facet represents certain information within captured or intercepted telecommunications data.</summary>
    public class CapturedTelecommunicationsInformationFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CapturedTelecommunicationsInformationFacet";
        public new const string NamespacePrefix = "uco-observable";
        public CellSite CaptureCellSite { get; set; }
        public DateTime? EndTime { get; set; }
        public string InterceptedCallState { get; set; }
        public DateTime? StartTime { get; set; }
    }

    /// <summary>CellSite</summary>
    public class CellSite : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CellSite";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A cell site facet contains the metadata surrounding the cell site.</summary>
    public class CellSiteFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CellSiteFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string CellSiteCountryCode { get; set; }
        public string CellSiteIdentifier { get; set; }
        public string CellSiteLocationAreaCode { get; set; }
        public string CellSiteNetworkCode { get; set; }
        public string CellSiteType { get; set; }
    }

    /// <summary>A character device node is a UNIX filesystem special file that serves as a conduit to communicate with devices, providing only a serial stream of input or accepting a serial stream of output. Characte</summary>
    public class CharacterDeviceNode : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CharacterDeviceNode";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>Code is a direct representation (source, byte or binary) of a collection of computer instructions that form software which tell a computer how to work. [based on https://en.wikipedia.org/wiki/Software</summary>
    public class Code : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Code";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A compressed stream facet is a grouping of characteristics unique to the application of a size-reduction process to a body of data content.</summary>
    public class CompressedStreamFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CompressedStreamFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string CompressionMethod { get; set; }
        public decimal? CompressionRatio { get; set; }
    }

    /// <summary>A computer is an electronic device for storing and processing data, typically in binary, according to instructions given to it in a variable program. [based on 'Computer.' Oxford English Dictionary, O</summary>
    public class Computer : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Computer";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A computer specification is the hardware and software of a programmable electronic device that can store, retrieve, and process data. {based on merriam-webster.com/dictionary/computer]</summary>
    public class ComputerSpecification : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ComputerSpecification";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A computer specificaiton facet is a grouping of characteristics unique to the hardware and software of a programmable electronic device that can store, retrieve, and process data. [based on merriam-we</summary>
    public class ComputerSpecificationFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ComputerSpecificationFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? AvailableRam { get; set; }
        public DateTime? BiosDate { get; set; }
        public string BiosManufacturer { get; set; }
        public DateTime? BiosReleaseDate { get; set; }
        public string BiosSerialNumber { get; set; }
        public string BiosVersion { get; set; }
        public string Cpu { get; set; }
        public string CpuFamily { get; set; }
        public DateTime? CurrentSystemDate { get; set; }
        public string Gpu { get; set; }
        public string GpuFamily { get; set; }
        public string Hostname { get; set; }
        public DateTime? LocalTime { get; set; }
        public List<ObservableObject> NetworkInterface { get; set; }
        public string ProcessorArchitecture { get; set; }
        public DateTime? SystemTime { get; set; }
        public string TimezoneDST { get; set; }
        public string TimezoneStandard { get; set; }
        public long? TotalRam { get; set; }
        public string Uptime { get; set; }
    }

    /// <summary>A ConfiguredSoftware is a Software that is known to be configured to run in a more specified manner than some unconfigured or less-configured Software.</summary>
    public class ConfiguredSoftware : Software
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ConfiguredSoftware";
        public new const string NamespacePrefix = "uco-observable";
        public Software IsConfigurationOf { get; set; }
        public Configuration UsesConfiguration { get; set; }
    }

    /// <summary>A contact is a set of identification and communication related details for a single entity.</summary>
    public class Contact : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Contact";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A contact address is a grouping of characteristics unique to a geolocation address of a contact entity.</summary>
    public class ContactAddress : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactAddress";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> ContactAddressScope { get; set; }
        public Location GeolocationAddress { get; set; }
    }

    /// <summary>A contact affiliation is a grouping of characteristics unique to details of an organizational affiliation for a single contact entity.</summary>
    public class ContactAffiliation : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactAffiliation";
        public new const string NamespacePrefix = "uco-observable";
        public List<ContactEmail> ContactEmail { get; set; }
        public List<ContactMessaging> ContactMessaging { get; set; }
        public Organization ContactOrganization { get; set; }
        public List<ContactPhone> ContactPhone { get; set; }
        public List<ContactProfile> ContactProfile { get; set; }
        public List<ContactURL> ContactURL { get; set; }
        public string OrganizationDepartment { get; set; }
        public List<ContactAddress> OrganizationLocation { get; set; }
        public string OrganizationPosition { get; set; }
    }

    /// <summary>A contact email is a grouping of characteristics unique to details for contacting a contact entity by email.</summary>
    public class ContactEmail : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactEmail";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> ContactEmailScope { get; set; }
        public ObservableObject EmailAddress { get; set; }
    }

    /// <summary>A contact facet is a grouping of characteristics unique to a set of identification and communication related details for a single entity.</summary>
    public class ContactFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactFacet";
        public new const string NamespacePrefix = "uco-observable";
        public DateTime? Birthdate { get; set; }
        public List<ContactAddress> ContactAddress { get; set; }
        public List<ContactAffiliation> ContactAffiliation { get; set; }
        public List<ContactEmail> ContactEmail { get; set; }
        public List<string> ContactGroup { get; set; }
        public string ContactID { get; set; }
        public List<ContactMessaging> ContactMessaging { get; set; }
        public List<string> ContactNote { get; set; }
        public List<ContactPhone> ContactPhone { get; set; }
        public List<ContactProfile> ContactProfile { get; set; }
        public List<ContactSIP> ContactSIP { get; set; }
        public List<ContactURL> ContactURL { get; set; }
        public string DisplayName { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public DateTime? LastTimeContacted { get; set; }
        public string MiddleName { get; set; }
        public string NamePhonetic { get; set; }
        public string NamePrefix { get; set; }
        public string NameSuffix { get; set; }
        public List<string> Nickname { get; set; }
        public long? NumberTimesContacted { get; set; }
        public ObservableObject SourceApplication { get; set; }
    }

    /// <summary>A contact list is a set of multiple individual contacts such as that found in a digital address book.</summary>
    public class ContactList : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactList";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A contact list facet is a grouping of characteristics unique to a set of multiple individual contacts such as that found in a digital address book.</summary>
    public class ContactListFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactListFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<ObservableObject> Contact { get; set; }
        public ObservableObject SourceApplication { get; set; }
    }

    /// <summary>A contact messaging is a grouping of characteristics unique to details for contacting a contact entity by digital messaging.</summary>
    public class ContactMessaging : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactMessaging";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject ContactMessagingPlatform { get; set; }
        public ObservableObject MessagingAddress { get; set; }
    }

    /// <summary>A contact phone is a grouping of characteristics unique to details for contacting a contact entity by telephone.</summary>
    public class ContactPhone : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactPhone";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject ContactPhoneNumber { get; set; }
        public List<string> ContactPhoneScope { get; set; }
    }

    /// <summary>A contact profile is a grouping of characteristics unique to details for contacting a contact entity by online service.</summary>
    public class ContactProfile : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactProfile";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject ContactProfilePlatform { get; set; }
        public ObservableObject Profile { get; set; }
    }

    /// <summary>A contact SIP is a grouping of characteristics unique to details for contacting a contact entity by Session Initiation Protocol (SIP).</summary>
    public class ContactSIP : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactSIP";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> ContactSIPScope { get; set; }
        public ObservableObject SipAddress { get; set; }
    }

    /// <summary>A contact URL is a grouping of characteristics unique to details for contacting a contact entity by Uniform Resource Locator (URL).</summary>
    public class ContactURL : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContactURL";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> ContactURLScope { get; set; }
        public ObservableObject Url { get; set; }
    }

    /// <summary>Content data is a block of digital data.</summary>
    public class ContentData : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContentData";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A content data facet is a grouping of characteristics unique to a block of digital data.</summary>
    public class ContentDataFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ContentDataFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> ByteOrder { get; set; }
        public string DataPayload { get; set; }
        public ObservableObject DataPayloadReferenceURL { get; set; }
        public decimal? Entropy { get; set; }
        public List<Hash> Hash { get; set; }
        public bool? IsEncrypted { get; set; }
        public string MagicNumber { get; set; }
        public string MimeClass { get; set; }
        public List<string> MimeType { get; set; }
        public long? SizeInBytes { get; set; }
    }

    /// <summary>A cookie history is the stored web cookie history for a particular web browser.</summary>
    public class CookieHistory : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CookieHistory";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A credential is a single specific login and password combination for authorization of access to a digital account or system.</summary>
    public class Credential : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Credential";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A credential dump is a collection (typically forcibly extracted from a system) of specific login and password combinations for authorization of access to a digital account or system.</summary>
    public class CredentialDump : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/CredentialDump";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An DNS cache is a temporary locally stored collection of previous Domain Name System (DNS) query results (created when an domain name is resolved to a IP address) for a particular computer.</summary>
    public class DNSCache : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DNSCache";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A DNS record is a single Domain Name System (DNS) artifact specifying information of a particular type (routing, authority, responsibility, security, etc.) for a specific Internet domain name.</summary>
    public class DNSRecord : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DNSRecord";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A data range facet is a grouping of characteristics unique to a particular contiguous scope within a block of digital data.</summary>
    public class DataRangeFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DataRangeFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? RangeOffset { get; set; }
        public string RangeOffsetType { get; set; }
        public long? RangeSize { get; set; }
    }

    /// <summary>A defined effect facet is a grouping of characteristics unique to the effect of an observable action in relation to one or more observable objects.</summary>
    public class DefinedEffectFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DefinedEffectFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A device is a piece of equipment or a mechanism designed to serve a special purpose or perform a special function. [based on https://www.merriam-webster.com/dictionary/device]</summary>
    public class Device : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Device";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A device facet is a grouping of characteristics unique to a piece of equipment or a mechanism designed to serve a special purpose or perform a special function. [based on https://www.merriam-webster.c</summary>
    public class DeviceFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DeviceFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Cpeid { get; set; }
        public string DeviceType { get; set; }
        public Identity Manufacturer { get; set; }
        public string Model { get; set; }
        public string SerialNumber { get; set; }
    }

    /// <summary>A digital account is an arrangement with an entity to enable and control the provision of some capability or service within the digital domain.</summary>
    public class DigitalAccount : Account
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalAccount";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A digital account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of some capability or service within the digital domain.</summary>
    public class DigitalAccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalAccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> AccountLogin { get; set; }
        public string DisplayName { get; set; }
        public DateTime? FirstLoginTime { get; set; }
        public bool? IsDisabled { get; set; }
        public DateTime? LastLoginTime { get; set; }
    }

    /// <summary>A digital address is an identifier assigned to enable routing and management of digital communication.</summary>
    public class DigitalAddress : Address
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalAddress";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A digital address facet is a grouping of characteristics unique to an identifier assigned to enable routing and management of digital communication.</summary>
    public class DigitalAddressFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalAddressFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string AddressValue { get; set; }
        public string DisplayName { get; set; }
    }

    /// <summary>A digital camera is a camera that captures photographs in digital memory as opposed to capturing images on photographic film.</summary>
    public class DigitalCamera : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalCamera";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A digital signature info is a value calculated via a mathematical scheme for demonstrating the authenticity of an electronic message or document.</summary>
    public class DigitalSignatureInfo : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalSignatureInfo";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A digital signature info facet is a grouping of characteristics unique to a value calculated via a mathematical scheme for demonstrating the authenticity of an electronic message or document.</summary>
    public class DigitalSignatureInfoFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalSignatureInfoFacet";
        public new const string NamespacePrefix = "uco-observable";
        public Identity CertificateIssuer { get; set; }
        public UcoObject CertificateSubject { get; set; }
        public string SignatureDescription { get; set; }
        public bool? SignatureExists { get; set; }
        public bool? SignatureVerified { get; set; }
    }

    /// <summary>A directory is a file system cataloging structure which contains references to other computer files, and possibly other directories. On many computers, directories are known as folders, or drawers, an</summary>
    public class Directory : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Directory";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A disk is a storage mechanism where data is recorded by various electronic, magnetic, optical, or mechanical changes to a surface layer of one or more rotating disks.</summary>
    public class Disk : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Disk";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A disk facet is a grouping of characteristics unique to a storage mechanism where data is recorded by various electronic, magnetic, optical, or mechanical changes to a surface layer of one or more rot</summary>
    public class DiskFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DiskFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? DiskSize { get; set; }
        public string DiskType { get; set; }
        public long? FreeSpace { get; set; }
        public List<ObservableObject> Partition { get; set; }
    }

    /// <summary>A disk partition is a particular managed region on a storage mechanism where data is recorded by various electronic, magnetic, optical, or mechanical changes to a surface layer of one or more rotating</summary>
    public class DiskPartition : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DiskPartition";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A disk partition facet is a grouping of characteristics unique to a particular managed region on a storage mechanism.</summary>
    public class DiskPartitionFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DiskPartitionFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string DiskPartitionType { get; set; }
        public string MountPoint { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public string PartitionID { get; set; }
        public long? PartitionLength { get; set; }
        public long? PartitionOffset { get; set; }
        public long? SpaceLeft { get; set; }
        public long? SpaceUsed { get; set; }
        public long? TotalSpace { get; set; }
    }

    /// <summary>A domain name is an identification string that defines a realm of administrative autonomy, authority or control within the Internet. [based on https://en.wikipedia.org/wiki/Domain_name]</summary>
    public class DomainName : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DomainName";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A domain name facet is a grouping of characteristics unique to an identification string that defines a realm of administrative autonomy, authority or control within the Internet. [based on https://en.</summary>
    public class DomainNameFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/DomainNameFacet";
        public new const string NamespacePrefix = "uco-observable";
        public bool? IsTLD { get; set; }
        public string Value { get; set; }
    }

    /// <summary>A drone, unmanned aerial vehicle (UAV), is an aircraft without a human pilot, crew, or passengers that typically involve a ground-based controller and a system for communications with the UAV.</summary>
    public class Drone : MobileDevice
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Drone";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An EXIF (exchangeable image file format) facet is a grouping of characteristics unique to the formats for images, sound, and ancillary tags used by digital cameras (including smartphones), scanners an</summary>
    public class EXIFFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EXIFFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<ControlledDictionary> ExifData { get; set; }
    }

    /// <summary>An email account is an arrangement with an entity to enable and control the provision of electronic mail (email) capabilities or services.</summary>
    public class EmailAccount : DigitalAccount
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EmailAccount";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An email account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of electronic mail (email) capabilities or services.</summary>
    public class EmailAccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EmailAccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject EmailAddress { get; set; }
    }

    /// <summary>An email address is an identifier for an electronic mailbox to which electronic mail messages (conformant to the Simple Mail Transfer Protocol (SMTP)) are sent from and delivered to.</summary>
    public class EmailAddress : DigitalAddress
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EmailAddress";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An email address facet is a grouping of characteristics unique to an identifier for an electronic mailbox to which electronic mail messages (conformant to the Simple Mail Transfer Protocol (SMTP)) are</summary>
    public class EmailAddressFacet : DigitalAddressFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EmailAddressFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An email message is a message that is an instance of an electronic mail correspondence conformant to the internet message format described in RFC 5322 and related RFCs.</summary>
    public class EmailMessage : Message
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EmailMessage";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An email message facet is a grouping of characteristics unique to a message that is an instance of an electronic mail correspondence conformant to the internet message format described in RFC 5322 and</summary>
    public class EmailMessageFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EmailMessageFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
        public List<ObservableObject> Bcc { get; set; }
        public string Body { get; set; }
        public List<MimePartType> BodyMultipart { get; set; }
        public ObservableObject BodyRaw { get; set; }
        public List<string> Categories { get; set; }
        public List<ObservableObject> Cc { get; set; }
        public string ContentDisposition { get; set; }
        public string ContentType { get; set; }
        public ObservableObject From { get; set; }
        public ObservableObject HeaderRaw { get; set; }
        public string InReplyTo { get; set; }
        public bool? IsMimeEncoded { get; set; }
        public bool? IsMultipart { get; set; }
        public bool? IsRead { get; set; }
        public List<string> Labels { get; set; }
        public string MessageID { get; set; }
        public DateTime? ModifiedTime { get; set; }
        public Dictionary OtherHeaders { get; set; }
        public string Priority { get; set; }
        public List<string> ReceivedLines { get; set; }
        public DateTime? ReceivedTime { get; set; }
        public List<ObservableObject> References { get; set; }
        public ObservableObject Sender { get; set; }
        public DateTime? SentTime { get; set; }
        public string Subject { get; set; }
        public List<ObservableObject> To { get; set; }
        public string XMailer { get; set; }
        public ObservableObject XOriginatingIP { get; set; }
    }

    /// <summary>An embedded device is a highly specialized microprocessor device meant for one or very few specific purposes and is usually embedded or included within another object or as part of a larger system. Ex</summary>
    public class EmbeddedDevice : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EmbeddedDevice";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An encoded stream facet is a grouping of characteristics unique to the conversion of a body of data content from one form to another form.</summary>
    public class EncodedStreamFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EncodedStreamFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string EncodingMethod { get; set; }
    }

    /// <summary>An encrypted stream facet is a grouping of characteristics unique to the conversion of a body of data content from one form to another obfuscated form in such a way that reversing the conversion to ob</summary>
    public class EncryptedStreamFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EncryptedStreamFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> EncryptionIV { get; set; }
        public List<string> EncryptionKey { get; set; }
        public string EncryptionMethod { get; set; }
        public string EncryptionMode { get; set; }
    }

    /// <summary>An environment variable is a grouping of characteristics unique to a dynamic-named value that can affect the way running processes will behave on a computer. [based on https://en.wikipedia.org/wiki/En</summary>
    public class EnvironmentVariable : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EnvironmentVariable";
        public new const string NamespacePrefix = "uco-observable";
        public string Name { get; set; }
        public string Value { get; set; }
    }

    /// <summary>An event log is a collection of event records.</summary>
    public class EventLog : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EventLog";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An event record is something that happens in a digital context (e.g., operating system events).</summary>
    public class EventRecord : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EventRecord";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An event record facet is a grouping of characteristics unique to something that happens in a digital context (e.g., operating system events).</summary>
    public class EventRecordFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/EventRecordFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Account { get; set; }
        public ObservableObject Application { get; set; }
        public ObservableAction CyberAction { get; set; }
        public DateTime? EndTime { get; set; }
        public string EventID { get; set; }
        public ObservableObject EventRecordDevice { get; set; }
        public string EventRecordID { get; set; }
        public string EventRecordRaw { get; set; }
        public string EventRecordServiceName { get; set; }
        public string EventRecordText { get; set; }
        public string EventType { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public DateTime? StartTime { get; set; }
    }

    /// <summary>An extInode facet is a grouping of characteristics unique to a file system object (file, directory, etc.) conformant to the extended file system (EXT or related derivations) specification.</summary>
    public class ExtInodeFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ExtInodeFacet";
        public new const string NamespacePrefix = "uco-observable";
        public DateTime? ExtDeletionTime { get; set; }
        public long? ExtFileType { get; set; }
        public long? ExtFlags { get; set; }
        public long? ExtHardLinkCount { get; set; }
        public DateTime? ExtInodeChangeTime { get; set; }
        public long? ExtInodeID { get; set; }
        public long? ExtPermissions { get; set; }
        public long? ExtSGID { get; set; }
        public long? ExtSUID { get; set; }
    }

    /// <summary>An extracted string is a grouping of characteristics unique to a series of characters pulled from an observable object.</summary>
    public class ExtractedString : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ExtractedString";
        public new const string NamespacePrefix = "uco-observable";
        public byte[] ByteStringValue { get; set; }
        public string Encoding { get; set; }
        public string EnglishTranslation { get; set; }
        public string Language { get; set; }
        public long? Length { get; set; }
        public string StringValue { get; set; }
    }

    /// <summary>An extracted strings facet is a grouping of characteristics unique to one or more sequences of characters pulled from an observable object.</summary>
    public class ExtractedStringsFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ExtractedStringsFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<ExtractedString> Strings { get; set; }
    }

    /// <summary>A file is a computer resource for recording data discretely on a computer storage device.</summary>
    public class File : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/File";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A file facet is a grouping of characteristics unique to the storage of a file (computer resource for recording data discretely in a computer storage device) on a file system (process that manages how </summary>
    public class FileFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/FileFacet";
        public new const string NamespacePrefix = "uco-observable";
        public DateTime? AccessedTime { get; set; }
        public string AllocationStatus { get; set; }
        public string Extension { get; set; }
        public List<string> FileName { get; set; }
        public List<string> FilePath { get; set; }
        public List<bool> IsDirectory { get; set; }
        public DateTime? MetadataChangeTime { get; set; }
        public DateTime? ModifiedTime { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public long? SizeInBytes { get; set; }
    }

    /// <summary>A file permissions facet is a grouping of characteristics unique to the access rights (e.g., view, change, navigate, execute) of a file on a file system.</summary>
    public class FilePermissionsFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/FilePermissionsFacet";
        public new const string NamespacePrefix = "uco-observable";
        public UcoObject Owner { get; set; }
    }

    /// <summary>A file system is the process that manages how and where data on a storage medium is stored, accessed and managed. [based on https://www.techopedia.com/definition/5510/file-system]</summary>
    public class FileSystem : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/FileSystem";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A file system facet is a grouping of characteristics unique to the process that manages how and where data on a storage medium is stored, accessed and managed. [based on https://www.techopedia.com/def</summary>
    public class FileSystemFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/FileSystemFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? ClusterSize { get; set; }
        public string FileSystemType { get; set; }
    }

    /// <summary>A file system object is an informational object represented and managed within a file system.</summary>
    public class FileSystemObject : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/FileSystemObject";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A forum post is message submitted by a user account to an online forum where the message content (and typically metadata including who posted it and when) is viewable by any party with viewing permiss</summary>
    public class ForumPost : Message
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ForumPost";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A forum private message (aka PM or DM (direct message)) is a one-to-one message from one specific user account to another specific user account on an online form where transmission is managed by the o</summary>
    public class ForumPrivateMessage : Message
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ForumPrivateMessage";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A fragment facet is a grouping of characteristics unique to an individual piece of the content of a file.</summary>
    public class FragmentFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/FragmentFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<long> FragmentIndex { get; set; }
        public List<long> TotalFragments { get; set; }
    }

    /// <summary>A GUI is a graphical user interface that allows users to interact with electronic devices through graphical icons and audio indicators such as primary notation, instead of text-based user interfaces, </summary>
    public class GUI : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GUI";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A gaming console (video game console or game console) is an electronic system that connects to a display, typically a TV or computer monitor, for the primary purpose of playing video games.</summary>
    public class GamingConsole : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GamingConsole";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A generic observable object is an article or unit within the digital domain.</summary>
    public class GenericObservableObject : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GenericObservableObject";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A geolocation entry is a single application-specific geolocation entry.</summary>
    public class GeoLocationEntry : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GeoLocationEntry";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A geolocation entry facet is a grouping of characteristics unique to a single application-specific geolocation entry.</summary>
    public class GeoLocationEntryFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GeoLocationEntryFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
        public Location Location { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
    }

    /// <summary>A geolocation log is a record containing geolocation tracks and/or geolocation entries.</summary>
    public class GeoLocationLog : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GeoLocationLog";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A geolocation log facet is a grouping of characteristics unique to a record containing geolocation tracks and/or geolocation entries.</summary>
    public class GeoLocationLogFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GeoLocationLogFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
    }

    /// <summary>A geolocation track is a set of contiguous geolocation entries representing a path/track taken.</summary>
    public class GeoLocationTrack : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GeoLocationTrack";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A geolocation track facet is a grouping of characteristics unique to a set of contiguous geolocation entries representing a path/track taken.</summary>
    public class GeoLocationTrackFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GeoLocationTrackFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
        public DateTime? EndTime { get; set; }
        public List<ObservableObject> GeoLocationEntry { get; set; }
        public DateTime? StartTime { get; set; }
    }

    /// <summary>A global flag type is a grouping of characteristics unique to the Windows systemwide global variable named NtGlobalFlag that enables various internal debugging, tracing, and validation support in the </summary>
    public class GlobalFlagType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/GlobalFlagType";
        public new const string NamespacePrefix = "uco-observable";
        public string Abbreviation { get; set; }
        public string Destination { get; set; }
        public List<byte[]> HexadecimalValue { get; set; }
        public string SymbolicName { get; set; }
    }

    /// <summary>An HTTP connection is network connection that is conformant to the Hypertext Transfer Protocol (HTTP) standard.</summary>
    public class HTTPConnection : NetworkConnection
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/HTTPConnection";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An HTTP connection facet is a grouping of characteristics unique to portions of a network connection that are conformant to the Hypertext Transfer Protocol (HTTP) standard.</summary>
    public class HTTPConnectionFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/HTTPConnectionFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? HttpMesageBodyLength { get; set; }
        public ObservableObject HttpMessageBodyData { get; set; }
        public Dictionary HttpRequestHeader { get; set; }
        public string RequestMethod { get; set; }
        public string RequestValue { get; set; }
        public string RequestVersion { get; set; }
    }

    /// <summary>A hostname is a label that is assigned to a device connected to a computer network and that is used to identify the device in various forms of electronic communication, such as the World Wide Web. A h</summary>
    public class Hostname : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Hostname";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An ICMP connection is a network connection that is conformant to the Internet Control Message Protocol (ICMP) standard.</summary>
    public class ICMPConnection : NetworkConnection
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ICMPConnection";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An ICMP connection facet is a grouping of characteristics unique to portions of a network connection that are conformant to the Internet Control Message Protocol (ICMP) standard.</summary>
    public class ICMPConnectionFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ICMPConnectionFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<byte[]> IcmpCode { get; set; }
        public List<byte[]> IcmpType { get; set; }
    }

    /// <summary>An IComHandler action type is a grouping of characteristics unique to a Windows Task-related action that fires a Windows COM handler (smart code in the client address space that can optimize calls bet</summary>
    public class IComHandlerActionType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IComHandlerActionType";
        public new const string NamespacePrefix = "uco-observable";
        public string ComClassID { get; set; }
        public string ComData { get; set; }
    }

    /// <summary>An IExec action type is a grouping of characteristics unique to an action that executes a command-line operation on a Windows operating system. [based on https://docs.microsoft.com/en-us/windows/win32</summary>
    public class IExecActionType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IExecActionType";
        public new const string NamespacePrefix = "uco-observable";
        public string ExecArguments { get; set; }
        public List<Hash> ExecProgramHashes { get; set; }
        public string ExecProgramPath { get; set; }
        public string ExecWorkingDirectory { get; set; }
    }

    /// <summary>An IP address is an Internet Protocol (IP) standards conformant identifier assigned to a device to enable routing and management of IP standards conformant communication to or from that device.</summary>
    public class IPAddress : DigitalAddress
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IPAddress";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An IP address facet is a grouping of characteristics unique to an Internet Protocol (IP) standards conformant identifier assigned to a device to enable routing and management of IP standards conforman</summary>
    public class IPAddressFacet : DigitalAddressFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IPAddressFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An IP netmask is a 32-bit 'mask' used to divide an IP address into subnets and specify the network's available hosts.</summary>
    public class IPNetmask : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IPNetmask";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An iPhone is a smart phone that applies the iOS mobile operating system.</summary>
    public class IPhone : AppleDevice
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IPhone";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An IPv4 (Internet Protocol version 4) address is an IPv4 standards conformant identifier assigned to a device to enable routing and management of IPv4 standards conformant communication to or from tha</summary>
    public class IPv4Address : IPAddress
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IPv4Address";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An IPv4 (Internet Protocol version 4) address facet is a grouping of characteristics unique to an IPv4 standards conformant identifier assigned to a device to enable routing and management of IPv4 sta</summary>
    public class IPv4AddressFacet : IPAddressFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IPv4AddressFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An IPv6 (Internet Protocol version 6) address is an IPv6 standards conformant identifier assigned to a device to enable routing and management of IPv6 standards conformant communication to or from tha</summary>
    public class IPv6Address : IPAddress
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IPv6Address";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An IPv6 (Internet Protocol version 6) address facet is a grouping of characteristics unique to an IPv6 standards conformant identifier assigned to a device to enable routing and management of IPv6 sta</summary>
    public class IPv6AddressFacet : IPAddressFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IPv6AddressFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An IShow message action type is a grouping of characteristics unique to an action that shows a message box when a task is activate. [based on https://docs.microsoft.com/en-us/windows/win32/api/tasksch</summary>
    public class IShowMessageActionType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/IShowMessageActionType";
        public new const string NamespacePrefix = "uco-observable";
        public string ShowMessageBody { get; set; }
        public string ShowMessageTitle { get; set; }
    }

    /// <summary>An image is a complete copy of a hard disk, memory, or other digital media.</summary>
    public class Image : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Image";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An image facet is a grouping of characteristics unique to a complete copy of a hard disk, memory, or other digital media.</summary>
    public class ImageFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ImageFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string ImageType { get; set; }
    }

    /// <summary>InstantMessagingAddress</summary>
    public class InstantMessagingAddress : DigitalAddress
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/InstantMessagingAddress";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An instant messaging address facet is a grouping of characteristics unique to an identifier assigned to enable routing and management of instant messaging digital communication.</summary>
    public class InstantMessagingAddressFacet : DigitalAddressFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/InstantMessagingAddressFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A junction is a specific NTFS (New Technology File System) reparse point to redirect a directory access to another directory which can be on the same volume or another volume. A junction is similar to</summary>
    public class Junction : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Junction";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A laptop, laptop computer, or notebook computer is a small, portable personal computer with a screen and alphanumeric keyboard. These typically have a clam shell form factor with the screen mounted on</summary>
    public class Laptop : Computer
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Laptop";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A library is a suite of data and programming code that is used to develop software programs and applications. [based on https://www.techopedia.com/definition/3828/software-library]</summary>
    public class Library : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Library";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A library facet is a grouping of characteristics unique to a suite of data and programming code that is used to develop software programs and applications. [based on https://www.techopedia.com/definit</summary>
    public class LibraryFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/LibraryFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string LibraryType { get; set; }
    }

    /// <summary>A MAC address is a media access control standards conformant identifier assigned to a network interface to enable routing and management of communications at the data link layer of a network segment.</summary>
    public class MACAddress : DigitalAddress
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MACAddress";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A MAC address facet is a grouping of characteristics unique to a media access control standards conformant identifier assigned to a network interface to enable routing and management of communications</summary>
    public class MACAddressFacet : DigitalAddressFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MACAddressFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>Memory is a particular region of temporary information storage (e.g., RAM (random access memory), ROM (read only memory)) on a digital device.</summary>
    public class Memory : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Memory";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A memory facet is a grouping of characteristics unique to a particular region of temporary information storage (e.g., RAM (random access memory), ROM (read only memory)) on a digital device.</summary>
    public class MemoryFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MemoryFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> BlockType { get; set; }
        public bool? IsInjected { get; set; }
        public bool? IsMapped { get; set; }
        public bool? IsProtected { get; set; }
        public bool? IsVolatile { get; set; }
        public List<byte[]> RegionEndAddress { get; set; }
        public long? RegionSize { get; set; }
        public List<byte[]> RegionStartAddress { get; set; }
    }

    /// <summary>A message is a discrete unit of electronic communication intended by the source for consumption by some recipient or group of recipients. [based on https://en.wikipedia.org/wiki/Message]</summary>
    public class Message : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Message";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A message facet is a grouping of characteristics unique to a discrete unit of electronic communication intended by the source for consumption by some recipient or group of recipients. [based on https:</summary>
    public class MessageFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MessageFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
        public ObservableObject From { get; set; }
        public string MessageID { get; set; }
        public string MessageText { get; set; }
        public string MessageType { get; set; }
        public DateTime? SentTime { get; set; }
        public string SessionID { get; set; }
        public List<ObservableObject> To { get; set; }
    }

    /// <summary>A message thread is a running commentary of electronic messages pertaining to one topic or question.</summary>
    public class MessageThread : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MessageThread";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A message thread facet is a grouping of characteristics unique to a running commentary of electronic messages pertaining to one topic or question.</summary>
    public class MessageThreadFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MessageThreadFacet";
        public new const string NamespacePrefix = "uco-observable";
        public Thread MessageThread { get; set; }
        public List<ObservableObject> Participant { get; set; }
        public bool? Visibility { get; set; }
    }

    /// <summary>An MFT record facet is a grouping of characteristics unique to the details of a single file as managed in an NTFS (new technology filesystem) master file table (which is a collection of information ab</summary>
    public class MftRecordFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MftRecordFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? MftFileID { get; set; }
        public DateTime? MftFileNameAccessedTime { get; set; }
        public DateTime? MftFileNameCreatedTime { get; set; }
        public long? MftFileNameLength { get; set; }
        public DateTime? MftFileNameModifiedTime { get; set; }
        public DateTime? MftFileNameRecordChangeTime { get; set; }
        public long? MftFlags { get; set; }
        public long? MftParentID { get; set; }
        public DateTime? MftRecordChangeTime { get; set; }
        public long? NtfsHardLinkCount { get; set; }
        public string NtfsOwnerID { get; set; }
        public string NtfsOwnerSID { get; set; }
    }

    /// <summary>A mime part type is a grouping of characteristics unique to a component of a multi-part email body.</summary>
    public class MimePartType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MimePartType";
        public new const string NamespacePrefix = "uco-observable";
        public string Body { get; set; }
        public ObservableObject BodyRaw { get; set; }
        public string ContentDisposition { get; set; }
        public string ContentType { get; set; }
    }

    /// <summary>A mobile account is an arrangement with an entity to enable and control the provision of some capability or service on a portable computing device. [based on https://www.lexico.com/definition/mobile_d</summary>
    public class MobileAccount : DigitalAccount
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MobileAccount";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A mobile account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of some capability or service on a portable computing device. [based</summary>
    public class MobileAccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MobileAccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string IMSI { get; set; }
        public string MSISDN { get; set; }
        public string MSISDNType { get; set; }
    }

    /// <summary>A mobile device is a portable computing device. [based on https://www.lexico.com.definition/mobile_device]</summary>
    public class MobileDevice : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MobileDevice";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A mobile device facet is a grouping of characteristics unique to a portable computing device. [based on https://www.lexico.com/definition/mobile_device]</summary>
    public class MobileDeviceFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MobileDeviceFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string ESN { get; set; }
        public List<string> IMEI { get; set; }
        public string BluetoothDeviceName { get; set; }
        public DateTime? ClockSetting { get; set; }
        public string KeypadUnlockCode { get; set; }
        public bool? MockLocationsAllowed { get; set; }
        public string Network { get; set; }
        public DateTime? PhoneActivationTime { get; set; }
        public long? StorageCapacityInBytes { get; set; }
    }

    /// <summary>A mobile phone is a portable telephone that at least can make and receive calls over a radio frequency link while the user is moving within a telephone service area. This category encompasses all type</summary>
    public class MobilePhone : MobileDevice
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MobilePhone";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A mutex is a mechanism that enforces limits on access to a resource when there are many threads of execution. A mutex is designed to enforce a mutual exclusion concurrency control policy, and with a v</summary>
    public class Mutex : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Mutex";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A mutex facet is a grouping of characteristics unique to a mechanism that enforces limits on access to a resource when there are many threads of execution. A mutex is designed to enforce a mutual excl</summary>
    public class MutexFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/MutexFacet";
        public new const string NamespacePrefix = "uco-observable";
        public bool? IsNamed { get; set; }
        public string MutexName { get; set; }
    }

    /// <summary>An NTFS file is a New Technology File System (NTFS) file.</summary>
    public class NTFSFile : File
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NTFSFile";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An NTFS file facet is a grouping of characteristics unique to a file on an NTFS (new technology filesystem) file system.</summary>
    public class NTFSFileFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NTFSFileFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<AlternateDataStream> AlternateDataStreams { get; set; }
        public long? EntryID { get; set; }
        public string Sid { get; set; }
    }

    /// <summary>An NTFS file permissions facet is a grouping of characteristics unique to the access rights (e.g., view, change, navigate, execute) of a file on an NTFS (new technology filesystem) file system.</summary>
    public class NTFSFilePermissionsFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NTFSFilePermissionsFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A named pipe is a mechanism for FIFO (first-in-first-out) inter-process communication. It is persisted as a filesystem object (that can be deleted like any other file), can be written to or read from </summary>
    public class NamedPipe : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NamedPipe";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A network appliance is a purpose-built computer with software or firmware that is designed to provide a specific network management function.</summary>
    public class NetworkAppliance : Appliance
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkAppliance";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A network connection is a connection (completed or attempted) across a digital network (a group of two or more computer systems linked together). [based on https://www.webopedia.com/TERM/N/network.htm</summary>
    public class NetworkConnection : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkConnection";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A network connection facet is a grouping of characteristics unique to a connection (complete or attempted) accross a digital network (a group of two or more computer systems linked together). [based o</summary>
    public class NetworkConnectionFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkConnectionFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? DestinationPort { get; set; }
        public List<ObservableObject> Dst { get; set; }
        public DateTime? EndTime { get; set; }
        public bool? IsActive { get; set; }
        public ControlledDictionary Protocols { get; set; }
        public long? SourcePort { get; set; }
        public List<UcoObject> Src { get; set; }
        public DateTime? StartTime { get; set; }
    }

    /// <summary>A network flow is a sequence of data transiting one or more digital network (a group or two or more computer systems linked together) connections. [based on https://www.webopedia.com/TERM/N/network.ht</summary>
    public class NetworkFlow : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkFlow";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A network flow facet is a grouping of characteristics unique to a sequence of data transiting one or more digital network (a group of two or more computer systems linked together) connections. [based </summary>
    public class NetworkFlowFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkFlowFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? DstBytes { get; set; }
        public long? DstPackets { get; set; }
        public ObservableObject DstPayload { get; set; }
        public Dictionary Ipfix { get; set; }
        public long? SrcBytes { get; set; }
        public long? SrcPackets { get; set; }
        public ObservableObject SrcPayload { get; set; }
    }

    /// <summary>A network interface is a software or hardware interface between two pieces of equipment or protocol layers in a computer network.</summary>
    public class NetworkInterface : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkInterface";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A network interface facet is a grouping of characteristics unique to a software or hardware interface between two pieces of equipment or protocol layers in a computer network.</summary>
    public class NetworkInterfaceFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkInterfaceFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string AdapterName { get; set; }
        public DateTime? DhcpLeaseExpires { get; set; }
        public DateTime? DhcpLeaseObtained { get; set; }
        public List<ObservableObject> DhcpServer { get; set; }
        public List<ObservableObject> Ip { get; set; }
        public List<ObservableObject> IpGateway { get; set; }
        public ObservableObject MacAddress { get; set; }
    }

    /// <summary>A network protocol is an established set of structured rules that determine how data is transmitted between different devices in the same network. Essentially, it allows connected devices to communica</summary>
    public class NetworkProtocol : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkProtocol";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A network route is a specific path (of specific network nodes, connections and protocols) for traffic in a network or between or across multiple networks.</summary>
    public class NetworkRoute : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkRoute";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A network subnet is a logical subdivision of an IP network. [based on https://en.wikipedia.org/wiki/Subnetwork]</summary>
    public class NetworkSubnet : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkSubnet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A note is a brief textual record.</summary>
    public class Note : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Note";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A note facet is a grouping of characteristics unique to a brief textual record.</summary>
    public class NoteFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/NoteFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Application { get; set; }
        public DateTime? ModifiedTime { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public string Text { get; set; }
    }

    /// <summary>An observable is a characterizable item or action within the digital domain.</summary>
    public class Observable : UcoObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Observable";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An observable action is a grouping of characteristics unique to something that may be done or performed within the digital domain.</summary>
    public class ObservableAction : Action
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ObservableAction";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An observable object is a grouping of characteristics unique to a distinct article or unit within the digital domain.</summary>
    public class ObservableObject : Item
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ObservableObject";
        public new const string NamespacePrefix = "uco-observable";
        public bool? HasChanged { get; set; }
        public string State { get; set; }
    }

    /// <summary>An observable pattern is a grouping of characteristics unique to a logical pattern composed of observable object and observable action properties.</summary>
    public class ObservablePattern : Observable
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ObservablePattern";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An observable relationship is a grouping of characteristics unique to an assertion of an association between two observable objects.</summary>
    public class ObservableRelationship : Relationship
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ObservableRelationship";
        public new const string NamespacePrefix = "uco-observable";
        public List<Observable> Source { get; set; }
        public List<Observable> Target { get; set; }
    }

    /// <summary>An observation is a temporal perception of an observable.</summary>
    public class Observation : Action
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Observation";
        public new const string NamespacePrefix = "uco-observable";
        public string Name { get; set; }
    }

    /// <summary>An online service is a particular provision mechanism of information access, distribution or manipulation over the Internet.</summary>
    public class OnlineService : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/OnlineService";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An online service facet is a grouping of characteristics unique to a particular provision mechanism of information access, distribution or manipulation over the Internet.</summary>
    public class OnlineServiceFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/OnlineServiceFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Name { get; set; }
        public List<ObservableObject> InetLocation { get; set; }
        public List<Location> Location { get; set; }
    }

    /// <summary>An operating system is the software that manages computer hardware, software resources, and provides common services for computer programs. [based on https://en.wikipedia.org/wiki/Operating_system]</summary>
    public class OperatingSystem : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/OperatingSystem";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An operating system facet is a grouping of characteristics unique to the software that manages computer hardware, software resources, and provides common services for computer programs. [based on http</summary>
    public class OperatingSystemFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/OperatingSystemFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> AdvertisingID { get; set; }
        public string Bitness { get; set; }
        public Dictionary EnvironmentVariables { get; set; }
        public DateTime? InstallDate { get; set; }
        public bool? IsLimitAdTrackingEnabled { get; set; }
        public Identity Manufacturer { get; set; }
        public string Version { get; set; }
    }

    /// <summary>A PDF file is a Portable Document Format (PDF) file.</summary>
    public class PDFFile : File
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/PDFFile";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A PDF file facet is a grouping of characteristics unique to a PDF (Portable Document Format) file.</summary>
    public class PDFFileFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/PDFFileFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ControlledDictionary DocumentInformationDictionary { get; set; }
        public bool? IsOptimized { get; set; }
        public DateTime? PdfCreationDate { get; set; }
        public List<string> PdfId0 { get; set; }
        public string PdfId1 { get; set; }
        public DateTime? PdfModDate { get; set; }
        public string Version { get; set; }
    }

    /// <summary>A path relation facet is a grouping of characteristics unique to the location of one object within another containing object.</summary>
    public class PathRelationFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/PathRelationFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> Path { get; set; }
    }

    /// <summary>A payment card is a physical token that is part of a payment system issued by financial institutions, such as a bank, to a customer that enables its owner (the cardholder) to access the funds in the c</summary>
    public class PaymentCard : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/PaymentCard";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A phone account is an arrangement with an entity to enable and control the provision of a telephony capability or service.</summary>
    public class PhoneAccount : DigitalAccount
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/PhoneAccount";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A phone account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of a telephony capability or service.</summary>
    public class PhoneAccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/PhoneAccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string PhoneNumber { get; set; }
    }

    /// <summary>A pipe is a mechanism for one-way inter-process communication using message passing where data written by one process is buffered by the operating system until it is read by the next process, and this</summary>
    public class Pipe : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Pipe";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A post is message submitted to an online discussion/publishing site (forum, blog, etc.).</summary>
    public class Post : Message
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Post";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A process is an instance of a computer program executed on an operating system.</summary>
    public class Process : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Process";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A process facet is a grouping of characteristics unique to an instance of a computer program executed on an operating system.</summary>
    public class ProcessFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ProcessFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> Arguments { get; set; }
        public ObservableObject Binary { get; set; }
        public ObservableObject CreatorUser { get; set; }
        public string CurrentWorkingDirectory { get; set; }
        public Dictionary EnvironmentVariables { get; set; }
        public long? ExitStatus { get; set; }
        public DateTime? ExitTime { get; set; }
        public bool? IsHidden { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public ObservableObject Parent { get; set; }
        public long? Pid { get; set; }
        public string Status { get; set; }
    }

    /// <summary>A process thread is the smallest sequence of programmed instructions that can be managed independently by a scheduler on a computer, which is typically a part of the operating system. It is a componen</summary>
    public class ProcessThread : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ProcessThread";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A profile is an explicit digital representation of identity and characteristics of the owner of a single user account associated with an online service or application. [based on https://en.wikipedia.o</summary>
    public class Profile : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Profile";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A profile facet is a grouping of characteristics unique to an explicit digital representation of identity and characteristics of the owner of a single user account associated with an online service or</summary>
    public class ProfileFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ProfileFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Name { get; set; }
        public ContactAddress ContactAddress { get; set; }
        public ContactEmail ContactEmail { get; set; }
        public ContactMessaging ContactMessaging { get; set; }
        public ContactPhone ContactPhone { get; set; }
        public ContactURL ContactURL { get; set; }
        public string DisplayName { get; set; }
        public ObservableObject ProfileAccount { get; set; }
        public DateTime? ProfileCreated { get; set; }
        public Identity ProfileIdentity { get; set; }
        public List<string> ProfileLanguage { get; set; }
        public ObservableObject ProfileService { get; set; }
        public ObservableObject ProfileWebsite { get; set; }
    }

    /// <summary>A properties enumerated effect facet is a grouping of characteristics unique to the effects of actions upon observable objects where a characteristic of the observable object is enumerated. An example</summary>
    public class PropertiesEnumeratedEffectFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/PropertiesEnumeratedEffectFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Properties { get; set; }
    }

    /// <summary>A properties read effect facet is a grouping of characteristics unique to the effects of actions upon observable objects where a characteristic is read from an observable object. An example of this wo</summary>
    public class PropertyReadEffectFacet : DefinedEffectFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/PropertyReadEffectFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string PropertyName { get; set; }
        public string Value { get; set; }
    }

    /// <summary>A protocol converter is a device that converts from one protocol to another (e.g. SD to USB, SATA to USB, etc.</summary>
    public class ProtocolConverter : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ProtocolConverter";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A raster picture is a raster (or bitmap) image.</summary>
    public class RasterPicture : File
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/RasterPicture";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A raster picture facet is a grouping of characteristics unique to a raster (or bitmap) image.</summary>
    public class RasterPictureFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/RasterPictureFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? BitsPerPixel { get; set; }
        public ObservableObject Camera { get; set; }
        public string ImageCompressionMethod { get; set; }
        public long? PictureHeight { get; set; }
        public string PictureType { get; set; }
        public long? PictureWidth { get; set; }
    }

    /// <summary>An observable object that was the result of a recovery operation.</summary>
    public class RecoveredObject : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/RecoveredObject";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>Recoverability status of name, metadata, and content.</summary>
    public class RecoveredObjectFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/RecoveredObjectFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> ContentRecoveredStatus { get; set; }
        public List<string> MetadataRecoveredStatus { get; set; }
        public List<string> NameRecoveredStatus { get; set; }
    }

    /// <summary>A reparse point is a type of NTFS (New Technology File System) object which is an optional attribute of files and directories meant to define some sort of preprocessing before accessing the said file </summary>
    public class ReparsePoint : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ReparsePoint";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A SIM card is a subscriber identification module card intended to securely store the international mobile subscriber identity (IMSI) number and its related key, which are used to identify and authenti</summary>
    public class SIMCard : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SIMCard";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A SIM card facet is a grouping of characteristics unique to a subscriber identification module card intended to securely store the international mobile subscriber identity (IMSI) number and its relate</summary>
    public class SIMCardFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SIMCardFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string ICCID { get; set; }
        public string IMSI { get; set; }
        public string PIN { get; set; }
        public string PUK { get; set; }
        public string SIMForm { get; set; }
        public string SIMType { get; set; }
        public Identity Carrier { get; set; }
        public long? StorageCapacityInBytes { get; set; }
    }

    /// <summary>A SIP address is an identifier for Session Initiation Protocol (SIP) communication.</summary>
    public class SIPAddress : DigitalAddress
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SIPAddress";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A SIP address facet is a grouping of characteristics unique to a Session Initiation Protocol (SIP) standards conformant identifier assigned to a user to enable routing and management of SIP standards </summary>
    public class SIPAddressFacet : DigitalAddressFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SIPAddressFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An SMS message is a message conformant to the short message service (SMS) communication protocol standards.</summary>
    public class SMSMessage : Message
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SMSMessage";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A SMS message facet is a grouping of characteristics unique to a message conformant to the short message service (SMS) communication protocol standards.</summary>
    public class SMSMessageFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SMSMessageFacet";
        public new const string NamespacePrefix = "uco-observable";
        public bool? IsRead { get; set; }
    }

    /// <summary>An SQLite blob is a blob (binary large object) of data within an SQLite database. [based on https://en.wikipedia.org/wiki/SQLite]</summary>
    public class SQLiteBlob : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SQLiteBlob";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An SQLite blob facet is a grouping of characteristics unique to a blob (binary large object) of data within an SQLite database. [based on https://en.wikipedia.org/wiki/SQLite]</summary>
    public class SQLiteBlobFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SQLiteBlobFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string ColumnName { get; set; }
        public string RowCondition { get; set; }
        public List<ulong> RowIndex { get; set; }
        public string TableName { get; set; }
    }

    /// <summary>A security appliance is a purpose-built computer with software or firmware that is designed to provide a specific security function to protect computer networks.</summary>
    public class SecurityAppliance : Appliance
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SecurityAppliance";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A semaphore is a variable or abstract data type used to control access to a common resource by multiple processes and avoid critical section problems in a concurrent system such as a multitasking oper</summary>
    public class Semaphore : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Semaphore";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A send control code effect facet is a grouping of characteristics unique to the effects of actions upon observable objects where a control code, or other control-oriented communication signal, is sent</summary>
    public class SendControlCodeEffectFacet : DefinedEffectFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SendControlCodeEffectFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string ControlCode { get; set; }
    }

    /// <summary>A server is a server rack-mount based computer, minicomputer, supercomputer, etc.</summary>
    public class Server : Computer
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Server";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A shop listing is a listing of offered products on an online marketplace/shop.</summary>
    public class ShopListing : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ShopListing";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A smart device is a microprocessor IoT device that is expected to be connected directly to cloud-based networks or via smartphone</summary>
    public class SmartDevice : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SmartDevice";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A smartphone is a portable device that combines mobile telephone and computing functions into one unit.  Examples include iPhone, Samsung Galaxy, Huawei, Blackberry. (Inferred by model and OperatingSy</summary>
    public class SmartPhone : Computer
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SmartPhone";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A snapshot is a file system object representing a snapshot of the contents of a part of a file system at a point in time.</summary>
    public class Snapshot : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Snapshot";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A socket is a special file used for inter-process communication, which enables communication between two processes. In addition to sending data, processes can send file descriptors across a Unix domai</summary>
    public class Socket : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Socket";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A socket address (combining and IP address and a port number) is a composite identifier for a network socket endpoint supporting internet protocol communications.</summary>
    public class SocketAddress : Address
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SocketAddress";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>Software is a definitely scoped instance of a collection of data or computer instructions that tell the computer how to work. [based on https://en.wikipedia.org/wiki/Software]</summary>
    public class Software : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Software";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A software facet is a grouping of characteristics unique to a software program (a definitively scoped instance of a collection of data or computer instructions that tell the computer how to work). [ba</summary>
    public class SoftwareFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SoftwareFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Cpeid { get; set; }
        public string Language { get; set; }
        public Identity Manufacturer { get; set; }
        public string Swid { get; set; }
        public string Version { get; set; }
    }

    /// <summary>A state change effect facet is a grouping of characteristics unique to the effects of actions upon observable objects where a state of the observable object is changed.</summary>
    public class StateChangeEffectFacet : DefinedEffectFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/StateChangeEffectFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject NewObject { get; set; }
        public ObservableObject OldObject { get; set; }
    }

    /// <summary>A storage medium is any digital storage device that applies electromagnetic or optical surfaces, or depends solely on electronic circuits as solid state storage, for storing digital data. Examples inc</summary>
    public class StorageMedium : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/StorageMedium";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A storage medium facet is a grouping of characteristics unique to a the storage capabilities of a piece of equipment or a mechanism designed to serve a special purpose or perform a special function.</summary>
    public class StorageMediumFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/StorageMediumFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? TotalStorageCapacityInBytes { get; set; }
    }

    /// <summary>A symbolic link is a file that contains a reference to another file or directory in the form of an absolute or relative path and that affects pathname resolution. [based on https://en.wikipedia.org/wi</summary>
    public class SymbolicLink : FileSystemObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SymbolicLink";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A symbolic link facet is a grouping of characteristics unique to a file that contains a reference to another file or directory in the form of an absolute or relative path and that affects pathname res</summary>
    public class SymbolicLinkFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/SymbolicLinkFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject TargetFile { get; set; }
    }

    /// <summary>A TCP connection is a network connection that is conformant to the Transfer </summary>
    public class TCPConnection : NetworkConnection
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/TCPConnection";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A TCP connection facet is a grouping of characteristics unique to portions of a network connection that are conformant to the Transmission Control Protocl (TCP) standard.</summary>
    public class TCPConnectionFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/TCPConnectionFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<byte[]> DestinationFlags { get; set; }
        public List<byte[]> SourceFlags { get; set; }
    }

    /// <summary>A database table field and its associated value contained within a relational database.</summary>
    public class TableField : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/TableField";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A database record facet contains properties associated with a specific table record value from a database.</summary>
    public class TableFieldFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/TableFieldFacet";
        public new const string NamespacePrefix = "uco-observable";
        public bool? RecordFieldIsNull { get; set; }
        public string RecordFieldName { get; set; }
        public object RecordFieldValue { get; set; }
        public object RecordRowID { get; set; }
        public string TableName { get; set; }
        public string TableSchema { get; set; }
    }

    /// <summary>A tablet is a mobile computer that is primarily operated by touching the screen. (Devices categorized by their manufacturer as a Tablet)</summary>
    public class Tablet : Computer
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Tablet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A task action type is a grouping of characteristics for a scheduled action to be completed.</summary>
    public class TaskActionType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/TaskActionType";
        public new const string NamespacePrefix = "uco-observable";
        public string ActionID { get; set; }
        public List<string> ActionType { get; set; }
        public IComHandlerActionType IComHandlerAction { get; set; }
        public ObservableObject IEmailAction { get; set; }
        public IExecActionType IExecAction { get; set; }
        public IShowMessageActionType IShowMessageAction { get; set; }
    }

    /// <summary>A trigger type is a grouping of characterizes unique to a set of criteria that, when met, starts the execution of a task within a Windows operating system. [based on https://docs.microsoft.com/en-us/w</summary>
    public class TriggerType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/TriggerType";
        public new const string NamespacePrefix = "uco-observable";
        public bool? IsEnabled { get; set; }
        public DateTime? TriggerBeginTime { get; set; }
        public string TriggerDelay { get; set; }
        public DateTime? TriggerEndTime { get; set; }
        public List<string> TriggerFrequency { get; set; }
        public string TriggerMaxRunTime { get; set; }
        public string TriggerSessionChangeType { get; set; }
        public List<string> TriggerType { get; set; }
    }

    /// <summary>A tweet is message submitted by a Twitter user account to the Twitter microblogging platform.</summary>
    public class Tweet : Message
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Tweet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A twitter profile facet is a grouping of characteristics unique to an explicit digital representation of identity and characteristics of the owner of a single Twitter user account. [based on https://e</summary>
    public class TwitterProfileFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/TwitterProfileFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ulong? FavoritesCount { get; set; }
        public ulong? FollowersCount { get; set; }
        public ulong? FriendsCount { get; set; }
        public long? ListedCount { get; set; }
        public List<Hash> ProfileBackgroundHash { get; set; }
        public ObservableObject ProfileBackgroundLocation { get; set; }
        public List<Hash> ProfileBannerHash { get; set; }
        public ObservableObject ProfileBannerLocation { get; set; }
        public List<Hash> ProfileImageHash { get; set; }
        public ObservableObject ProfileImageLocation { get; set; }
        public bool? ProfileIsProtected { get; set; }
        public bool? ProfileIsVerified { get; set; }
        public ulong? StatusesCount { get; set; }
        public string TwitterHandle { get; set; }
        public string TwitterId { get; set; }
        public string UserLocationString { get; set; }
    }

    /// <summary>A UNIX account is an account on a UNIX operating system.</summary>
    public class UNIXAccount : DigitalAccount
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXAccount";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A UNIX account facet is a grouping of characteristics unique to an account on a UNIX operating system.</summary>
    public class UNIXAccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXAccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? Gid { get; set; }
        public string Shell { get; set; }
    }

    /// <summary>A UNIX file is a file pertaining to the UNIX operating system.</summary>
    public class UNIXFile : File
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXFile";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A UNIX file permissions facet is a grouping of characteristics unique to the access rights (e.g., view, change, navigate, execute) of a file on a UNIX file system.</summary>
    public class UNIXFilePermissionsFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXFilePermissionsFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A UNIX process is an instance of a computer program executed on a UNIX operating system.</summary>
    public class UNIXProcess : Process
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXProcess";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A UNIX process facet is a grouping of characteristics unique to an instance of a computer program executed on a UNIX operating system.</summary>
    public class UNIXProcessFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXProcessFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<long> OpenFileDescriptor { get; set; }
        public List<ulong> Ruid { get; set; }
    }

    /// <summary>A UNIX volume facet is a grouping of characteristics unique to a single accessible storage area (volume) with a single UNIX file system. [based on https://en.wikipedia.org/wiki/Volume_(computing)]</summary>
    public class UNIXVolumeFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXVolumeFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string MountPoint { get; set; }
        public string Options { get; set; }
    }

    /// <summary>A URL is a uniform resource locator (URL) acting as a resolvable address to a particular WWW (World Wide Web) accessible resource.</summary>
    public class URL : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/URL";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A URL facet is a grouping of characteristics unique to a uniform resource locator (URL) acting as a resolvable address to a particular WWW (World Wide Web) accessible resource.</summary>
    public class URLFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/URLFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Fragment { get; set; }
        public string FullValue { get; set; }
        public ObservableObject Host { get; set; }
        public string Password { get; set; }
        public string Path { get; set; }
        public long? Port { get; set; }
        public string Query { get; set; }
        public string Scheme { get; set; }
        public string UserName { get; set; }
    }

    /// <summary>A URL history characterizes the stored URL history for a particular web browser</summary>
    public class URLHistory : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/URLHistory";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A URL history entry is a grouping of characteristics unique to the properties of a single URL history entry for a particular browser.</summary>
    public class URLHistoryEntry : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/URLHistoryEntry";
        public new const string NamespacePrefix = "uco-observable";
        public string BrowserUserProfile { get; set; }
        public DateTime? ExpirationTime { get; set; }
        public DateTime? FirstVisit { get; set; }
        public string Hostname { get; set; }
        public List<string> KeywordSearchTerm { get; set; }
        public DateTime? LastVisit { get; set; }
        public ulong? ManuallyEnteredCount { get; set; }
        public string PageTitle { get; set; }
        public List<ObservableObject> ReferrerUrl { get; set; }
        public ObservableObject Url { get; set; }
        public long? VisitCount { get; set; }
    }

    /// <summary>A URL history facet is a grouping of characteristics unique to the stored URL history for a particular web browser</summary>
    public class URLHistoryFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/URLHistoryFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject BrowserInformation { get; set; }
        public List<URLHistoryEntry> UrlHistoryEntry { get; set; }
    }

    /// <summary>A URL visit characterizes the properties of a visit of a URL within a particular browser.</summary>
    public class URLVisit : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/URLVisit";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A URL visit facet is a grouping of characteristics unique to the properties of a visit of a URL within a particular browser.</summary>
    public class URLVisitFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/URLVisitFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject BrowserInformation { get; set; }
        public ObservableObject FromURLVisit { get; set; }
        public ObservableObject Url { get; set; }
        public List<string> UrlTransitionType { get; set; }
        public TimeSpan? VisitDuration { get; set; }
        public DateTime? VisitTime { get; set; }
    }

    /// <summary>A user account is an account controlling a user's access to a network, system or platform.</summary>
    public class UserAccount : DigitalAccount
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UserAccount";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A user account facet is a grouping of characteristics unique to an account controlling a user's access to a network, system, or platform.</summary>
    public class UserAccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UserAccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public bool? CanEscalatePrivs { get; set; }
        public string HomeDirectory { get; set; }
        public bool? IsPrivileged { get; set; }
        public bool? IsServiceAccount { get; set; }
    }

    /// <summary>A user session is a temporary and interactive information interchange between two or more communicating devices within the managed scope of a single user. [based on https://en.wikipedia.org/wiki/Sessi</summary>
    public class UserSession : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UserSession";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A user session facet is a grouping of characteristics unique to a temporary and interactive information interchange between two or more communicating devices within the managed scope of a single user.</summary>
    public class UserSessionFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/UserSessionFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string EffectiveGroup { get; set; }
        public string EffectiveGroupID { get; set; }
        public ObservableObject EffectiveUser { get; set; }
        public DateTime? LoginTime { get; set; }
        public DateTime? LogoutTime { get; set; }
    }

    /// <summary>A values enumerated effect facet is a grouping of characteristics unique to the effects of actions upon observable objects where a value of the observable object is enumerated. An example of this woul</summary>
    public class ValuesEnumeratedEffectFacet : DefinedEffectFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/ValuesEnumeratedEffectFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Values { get; set; }
    }

    /// <summary>A volume is a single accessible storage area (volume) with a single file system. [based on https://en.wikipedia.org/wiki/Volume_(computing)]</summary>
    public class Volume : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Volume";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A volume facet is a grouping of characteristics unique to a single accessible storage area (volume) with a single file system. [based on https://en.wikipedia.org/wiki/Volume_(computing)]</summary>
    public class VolumeFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/VolumeFacet";
        public new const string NamespacePrefix = "uco-observable";
        public long? SectorSize { get; set; }
        public string VolumeID { get; set; }
    }

    /// <summary>A wearable device is an electronic device that is designed to be worn on a person's body.</summary>
    public class WearableDevice : SmartDevice
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WearableDevice";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A web page is a specific collection of information provided by a website and displayed to a user in a web browser. A website typically consists of many web pages linked together in a coherent fashion.</summary>
    public class WebPage : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WebPage";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>WhoIs is a response record conformant to the WHOIS protocol standard (RFC 3912). [based on https://en.wikipedia.org/wiki/WHOIS]</summary>
    public class WhoIs : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WhoIs";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A whois facet is a grouping of characteristics unique to a response record conformant to the WHOIS protocol standard (RFC 3912). [based on https://en.wikipedia.org/wiki/WHOIS]</summary>
    public class WhoIsFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WhoIsFacet";
        public new const string NamespacePrefix = "uco-observable";
        public DateTime? CreationDate { get; set; }
        public WhoisDNSSECTypeVocab Dnssec { get; set; }
        public string DomainID { get; set; }
        public ObservableObject DomainName { get; set; }
        public DateTime? ExpirationDate { get; set; }
        public ObservableObject IpAddress { get; set; }
        public DateTime? LookupDate { get; set; }
        public List<ObservableObject> NameServer { get; set; }
        public List<string> RegionalInternetRegistry { get; set; }
        public ObservableObject RegistrantContactInfo { get; set; }
        public List<string> RegistrantIDs { get; set; }
        public WhoisRegistrarInfoType RegistrarInfo { get; set; }
        public string Remarks { get; set; }
        public ObservableObject ServerName { get; set; }
        public string SponsoringRegistrar { get; set; }
        public List<string> Status { get; set; }
        public DateTime? UpdatedDate { get; set; }
    }

    /// <summary>A Whois contact type is a grouping of characteristics unique to contact-related information present in a response record conformant to the WHOIS protocol standard (RFC 3912). [based on https://en.wiki</summary>
    public class WhoisContactFacet : ContactFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WhoisContactFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> WhoisContactType { get; set; }
    }

    /// <summary>A Whois registrar info type is a grouping of characteristics unique to registrar-related information present in a response record conformant to the WHOIS protocol standard (RFC 3912). [based on https:</summary>
    public class WhoisRegistrarInfoType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WhoisRegistrarInfoType";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject ContactPhoneNumber { get; set; }
        public ObservableObject EmailAddress { get; set; }
        public Location GeolocationAddress { get; set; }
        public ObservableObject ReferralURL { get; set; }
        public string RegistrarGUID { get; set; }
        public string RegistrarID { get; set; }
        public string RegistrarName { get; set; }
        public ObservableObject WhoisServer { get; set; }
    }

    /// <summary>A Wi-Fi address is a media access control (MAC) standards-conformant identifier assigned to a device network interface to enable routing and management of IEEE 802.11 standards-conformant communicatio</summary>
    public class WifiAddress : MACAddress
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WifiAddress";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Wi-Fi address facet is a grouping of characteristics unique to a media access control (MAC) standards conformant identifier assigned to a device network interface to enable routing and management of</summary>
    public class WifiAddressFacet : MACAddressFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WifiAddressFacet";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A wiki is an online hypertext publication collaboratively edited and managed by its own audience directly using a web browser. A typical wiki contains multiple pages/articles for the subjects or scope</summary>
    public class Wiki : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/Wiki";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A wiki article is one or more pages in a wiki focused on characterizing a particular topic.</summary>
    public class WikiArticle : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WikiArticle";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows account is a user account on a Windows operating system.</summary>
    public class WindowsAccount : DigitalAccount
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsAccount";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows account facet is a grouping of characteristics unique to a user account on a Windows operating system.</summary>
    public class WindowsAccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsAccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> Groups { get; set; }
    }

    /// <summary>A Windows Active Directory account is an account managed by directory-based identity-related services of a Windows operating system.</summary>
    public class WindowsActiveDirectoryAccount : DigitalAccount
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsActiveDirectoryAccount";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows Active Directory account facet is a grouping of characteristics unique to an account managed by directory-based identity-related services of a Windows operating system.</summary>
    public class WindowsActiveDirectoryAccountFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsActiveDirectoryAccountFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> ActiveDirectoryGroups { get; set; }
        public string ObjectGUID { get; set; }
    }

    /// <summary>A Windows computer specification is the hardware ans software of a programmable electronic device that can store, retrieve, and process data running a Microsoft Windows operating system. [based on mer</summary>
    public class WindowsComputerSpecification : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsComputerSpecification";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows computer specification facet is a grouping of characteristics unique to the hardware and software of a programmable electronic device that can store, retrieve, and process data running a Mic</summary>
    public class WindowsComputerSpecificationFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsComputerSpecificationFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> Domain { get; set; }
        public List<GlobalFlagType> GlobalFlagList { get; set; }
        public DateTime? LastShutdownDate { get; set; }
        public string MsProductID { get; set; }
        public string MsProductName { get; set; }
        public string NetBIOSName { get; set; }
        public DateTime? OsInstallDate { get; set; }
        public DateTime? OsLastUpgradeDate { get; set; }
        public Identity RegisteredOrganization { get; set; }
        public Identity RegisteredOwner { get; set; }
        public ObservableObject WindowsDirectory { get; set; }
        public ObservableObject WindowsSystemDirectory { get; set; }
        public ObservableObject WindowsTempDirectory { get; set; }
    }

    /// <summary>A Windows critical section is a Windows object that provides synchronization similar to that provided by a mutex object, except that a critical section can be used only by the threads of a single proc</summary>
    public class WindowsCriticalSection : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsCriticalSection";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows event is a notification record of an occurance of interest (system, security, application, etc.) on a Windows operating system.</summary>
    public class WindowsEvent : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsEvent";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows file mapping is the association of a file's contents with a portion of the virtual address space of a process within a Windows operating system. The system creates a file mapping object (als</summary>
    public class WindowsFilemapping : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsFilemapping";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows handle is an abstract reference to a resource within the Windows operating system, such as a window, memory, an open file or a pipe. It is the mechanism by which applications interact with s</summary>
    public class WindowsHandle : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsHandle";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows hook is a mechanism by which an application can intercept events, such as messages, mouse actions, and keystrokes within the Windows operating system. A function that intercepts a particular</summary>
    public class WindowsHook : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsHook";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows mailslot is is a pseudofile that resides in memory, and may be accessed using standard file functions. The data in a mailslot message can be in any form, but cannot be larger than 424 bytes </summary>
    public class WindowsMailslot : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsMailslot";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows network share is a Windows computer resource made available from one host to other hosts on a computer network. It is a device or piece of information on a computer that can be remotely acce</summary>
    public class WindowsNetworkShare : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsNetworkShare";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows PE binary file is a Windows portable executable (PE) file.</summary>
    public class WindowsPEBinaryFile : File
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPEBinaryFile";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows PE binary file facet is a grouping of characteristics unique to a Windows portable executable (PE) file.</summary>
    public class WindowsPEBinaryFileFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPEBinaryFileFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<ushort> Characteristics { get; set; }
        public List<Hash> FileHeaderHashes { get; set; }
        public string ImpHash { get; set; }
        public List<string> Machine { get; set; }
        public long? NumberOfSections { get; set; }
        public long? NumberOfSymbols { get; set; }
        public WindowsPEOptionalHeader OptionalHeader { get; set; }
        public string PeType { get; set; }
        public List<byte[]> PointerToSymbolTable { get; set; }
        public List<WindowsPESection> Sections { get; set; }
        public long? SizeOfOptionalHeader { get; set; }
        public DateTime? TimeDateStamp { get; set; }
    }

    /// <summary>A Windows PE file header is a grouping of characteristics unique to the 'header' of a Windows PE (Portable Executable) file, consisting of a collection of metadata about the overall nature and structu</summary>
    public class WindowsPEFileHeader : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPEFileHeader";
        public new const string NamespacePrefix = "uco-observable";
        public DateTime? TimeDateStamp { get; set; }
    }

    /// <summary>A Windows PE optional header is a grouping of characteristics unique to the 'optional header' of a Windows PE (Portable Executable) file, consisting of a collection of metadata about the executable co</summary>
    public class WindowsPEOptionalHeader : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPEOptionalHeader";
        public new const string NamespacePrefix = "uco-observable";
        public List<uint> AddressOfEntryPoint { get; set; }
        public List<uint> BaseOfCode { get; set; }
        public List<uint> Checksum { get; set; }
        public List<ushort> DllCharacteristics { get; set; }
        public List<uint> FileAlignment { get; set; }
        public List<uint> ImageBase { get; set; }
        public List<uint> LoaderFlags { get; set; }
        public List<ushort> Magic { get; set; }
        public List<ushort> MajorImageVersion { get; set; }
        public List<sbyte> MajorLinkerVersion { get; set; }
        public List<ushort> MajorOSVersion { get; set; }
        public List<ushort> MajorSubsystemVersion { get; set; }
        public List<ushort> MinorImageVersion { get; set; }
        public List<sbyte> MinorLinkerVersion { get; set; }
        public List<ushort> MinorOSVersion { get; set; }
        public List<ushort> MinorSubsystemVersion { get; set; }
        public List<uint> NumberOfRVAAndSizes { get; set; }
        public List<uint> SectionAlignment { get; set; }
        public List<uint> SizeOfCode { get; set; }
        public List<uint> SizeOfHeaders { get; set; }
        public List<uint> SizeOfHeapCommit { get; set; }
        public List<uint> SizeOfHeapReserve { get; set; }
        public List<uint> SizeOfImage { get; set; }
        public List<uint> SizeOfInitializedData { get; set; }
        public List<uint> SizeOfStackCommit { get; set; }
        public List<uint> SizeOfStackReserve { get; set; }
        public List<uint> SizeOfUninitializedData { get; set; }
        public List<ushort> Subsystem { get; set; }
        public List<uint> Win32VersionValue { get; set; }
    }

    /// <summary>A Windows PE section is a grouping of characteristics unique to a specific default or custom-defined region of a Windows PE (Portable Executable) file, consisting of an individual portion of the actua</summary>
    public class WindowsPESection : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPESection";
        public new const string NamespacePrefix = "uco-observable";
        public string Name { get; set; }
        public decimal? Entropy { get; set; }
        public List<Hash> Hashes { get; set; }
        public long? Size { get; set; }
    }

    /// <summary>The Windows prefetch contains entries in a Windows prefetch file (used to speed up application startup starting with Windows XP).</summary>
    public class WindowsPrefetch : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPrefetch";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows prefetch facet is a grouping of characteristics unique to entries in the Windows prefetch file (used to speed up application startup starting with Windows XP).</summary>
    public class WindowsPrefetchFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPrefetchFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<ObservableObject> AccessedDirectory { get; set; }
        public List<ObservableObject> AccessedFile { get; set; }
        public string ApplicationFileName { get; set; }
        public DateTime? FirstRun { get; set; }
        public DateTime? LastRun { get; set; }
        public string PrefetchHash { get; set; }
        public long? TimesExecuted { get; set; }
        public ObservableObject Volume { get; set; }
    }

    /// <summary>A Windows process is a program running on a Windows operating system.</summary>
    public class WindowsProcess : Process
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsProcess";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows process facet is a grouping of characteristics unique to a program running on a Windows operating system.</summary>
    public class WindowsProcessFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsProcessFacet";
        public new const string NamespacePrefix = "uco-observable";
        public bool? AslrEnabled { get; set; }
        public bool? DepEnabled { get; set; }
        public string OwnerSID { get; set; }
        public string Priority { get; set; }
        public Dictionary StartupInfo { get; set; }
        public string WindowTitle { get; set; }
    }

    /// <summary>The Windows registry hive is a particular logical group of keys, subkeys, and values in a Windows registry (a hierarchical database that stores low-level settings for the Microsoft Windows operating s</summary>
    public class WindowsRegistryHive : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsRegistryHive";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows registry hive facet is a grouping of characteristics unique to a particular logical group of keys, subkeys, and values in a Windows registry (a hierarchical database that stores low-level se</summary>
    public class WindowsRegistryHiveFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsRegistryHiveFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string HiveType { get; set; }
    }

    /// <summary>A Windows registry key is a particular key within a Windows registry (a hierarchical database that stores low-level settings for the Microsoft Windows operating system and for applications that opt to</summary>
    public class WindowsRegistryKey : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsRegistryKey";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows registry key facet is a grouping of characteristics unique to a particular key within a Windows registry (A hierarchical database that stores low-level settings for the Microsoft Windows ope</summary>
    public class WindowsRegistryKeyFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsRegistryKeyFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Creator { get; set; }
        public string Key { get; set; }
        public DateTime? ModifiedTime { get; set; }
        public long? NumberOfSubkeys { get; set; }
        public List<WindowsRegistryValue> RegistryValues { get; set; }
    }

    /// <summary>A Windows registry value is a grouping of characteristics unique to a particular value within a Windows registry (a hierarchical database that stores low-level settings for the Microsoft Windows opera</summary>
    public class WindowsRegistryValue : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsRegistryValue";
        public new const string NamespacePrefix = "uco-observable";
        public string Name { get; set; }
        public string Data { get; set; }
        public string DataType { get; set; }
    }

    /// <summary>A Windows service is a specific Windows service (a computer program that operates in the background of a Windows operating system, similar to the way a UNIX daemon runs on UNIX). [based on https://en.</summary>
    public class WindowsService : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsService";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows service facet is a grouping of characteristics unique to a specific Windows service (a computer program that operates in the background of a Windows operating system, similar to the way a UN</summary>
    public class WindowsServiceFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsServiceFacet";
        public new const string NamespacePrefix = "uco-observable";
        public List<string> Descriptions { get; set; }
        public string DisplayName { get; set; }
        public string GroupName { get; set; }
        public string ServiceName { get; set; }
        public string ServiceStatus { get; set; }
        public string ServiceType { get; set; }
        public string StartCommandLine { get; set; }
        public string StartType { get; set; }
    }

    /// <summary>A Windows system restore is a capture of a Windows computer's state (including system files, installed applications, Windows Registry, and system settings) at a particular point in time such that the </summary>
    public class WindowsSystemRestore : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsSystemRestore";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows task is a process that is scheduled to execute on a Windows operating system by the Windows Task Scheduler. [based on http://msdn.microsoft.com/en-us/library/windows/desktop/aa381311(v=vs.85</summary>
    public class WindowsTask : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsTask";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows Task facet is a grouping of characteristics unique to a Windows Task (a process that is scheduled to execute on a Windows operating system by the Windows Task Scheduler). [based on http://ms</summary>
    public class WindowsTaskFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsTaskFacet";
        public new const string NamespacePrefix = "uco-observable";
        public ObservableObject Account { get; set; }
        public string AccountLogonType { get; set; }
        public string AccountRunLevel { get; set; }
        public List<TaskActionType> ActionList { get; set; }
        public ObservableObject Application { get; set; }
        public long? ExitCode { get; set; }
        public List<string> Flags { get; set; }
        public string ImageName { get; set; }
        public long? MaxRunTime { get; set; }
        public DateTime? MostRecentRunTime { get; set; }
        public DateTime? NextRunTime { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public string Parameters { get; set; }
        public List<object> Priority { get; set; }
        public List<string> Status { get; set; }
        public string TaskComment { get; set; }
        public string TaskCreator { get; set; }
        public List<TriggerType> TriggerList { get; set; }
        public ObservableObject WorkItemData { get; set; }
        public ObservableObject WorkingDirectory { get; set; }
    }

    /// <summary>A Windows thread is a single thread of execution within a Windows process.</summary>
    public class WindowsThread : ProcessThread
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsThread";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A Windows thread facet is a grouping os characteristics unique to a single thread of execution within a Windows process.</summary>
    public class WindowsThreadFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsThreadFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string Context { get; set; }
        public List<uint> CreationFlags { get; set; }
        public DateTime? CreationTime { get; set; }
        public DateTime? ObservableCreatedTime { get; set; }
        public List<byte[]> ParameterAddress { get; set; }
        public long? Priority { get; set; }
        public string RunningStatus { get; set; }
        public string SecurityAttributes { get; set; }
        public List<ulong> StackSize { get; set; }
        public List<byte[]> StartAddress { get; set; }
        public List<ulong> ThreadID { get; set; }
    }

    /// <summary>A Windows volume facet is a grouping of characteristics unique to a single accessible storage area (volume) with a single Windows file system. [based on https://en.wikipedia.org/wiki/Volume_(computing</summary>
    public class WindowsVolumeFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsVolumeFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string DriveLetter { get; set; }
        public List<string> DriveType { get; set; }
        public List<WindowsVolumeAttributeVocab> WindowsVolumeAttributes { get; set; }
    }

    /// <summary>A Windows waitable timer is a synchronization object within the Windows operating system whose state is set to signaled when a specified due time arrives. There are two types of waitable timers that c</summary>
    public class WindowsWaitableTime : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsWaitableTime";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A wireless network connection is a connection (completed or attempted) across an IEEE 802.11 standards-confromant digital network (a group of two or more computer systems linked together). [based on h</summary>
    public class WirelessNetworkConnection : NetworkConnection
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WirelessNetworkConnection";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A wireless network connection facet is a grouping of characteristics unique to a connection (completed or attempted) across an IEEE 802.11 standards-conformant digital network (a group of two or more </summary>
    public class WirelessNetworkConnectionFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WirelessNetworkConnectionFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string BaseStation { get; set; }
        public string Password { get; set; }
        public string Ssid { get; set; }
        public List<string> WirelessNetworkSecurityMode { get; set; }
    }

    /// <summary>A write blocker is a device that allows read-only access to storage mediums in order to preserve the integrity of the data being analyzed. Examples include Tableau, Cellibrite, Talon, etc.</summary>
    public class WriteBlocker : Device
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/WriteBlocker";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A X.509 certificate is a public key digital identity certificate conformant to the X.509 PKI (Public Key Infrastructure) standard.</summary>
    public class X509Certificate : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/X509Certificate";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>A X.509 certificate facet is a grouping of characteristics unique to a public key digital identity certificate conformant to the X.509 PKI (Public Key Infrastructure) standard. </summary>
    public class X509CertificateFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/X509CertificateFacet";
        public new const string NamespacePrefix = "uco-observable";
        public bool? IsSelfSigned { get; set; }
        public string Issuer { get; set; }
        public Hash IssuerHash { get; set; }
        public string SerialNumber { get; set; }
        public string Signature { get; set; }
        public string SignatureAlgorithm { get; set; }
        public string Subject { get; set; }
        public Hash SubjectHash { get; set; }
        public string SubjectPublicKeyAlgorithm { get; set; }
        public long? SubjectPublicKeyExponent { get; set; }
        public string SubjectPublicKeyModulus { get; set; }
        public Hash ThumbprintHash { get; set; }
        public DateTime? ValidityNotAfter { get; set; }
        public DateTime? ValidityNotBefore { get; set; }
        public string Version { get; set; }
        public X509V3ExtensionsFacet X509v3extensions { get; set; }
    }

    /// <summary>An X.509 v3 certificate is a public key digital identity certificate conformant to the X.509 v3 PKI (Public Key Infrastructure) standard. </summary>
    public class X509V3Certificate : ObservableObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/X509V3Certificate";
        public new const string NamespacePrefix = "uco-observable";
    }

    /// <summary>An X.509 v3 certificate extensions facet is a grouping of characteristics unique to a public key digital identity certificate conformant to the X.509 v3 PKI (Public Key Infrastructure) standard.</summary>
    public class X509V3ExtensionsFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/observable/X509V3ExtensionsFacet";
        public new const string NamespacePrefix = "uco-observable";
        public string AuthorityKeyIdentifier { get; set; }
        public string BasicConstraints { get; set; }
        public string CertificatePolicies { get; set; }
        public string CrlDistributionPoints { get; set; }
        public string ExtendedKeyUsage { get; set; }
        public string InhibitAnyPolicy { get; set; }
        public string IssuerAlternativeName { get; set; }
        public string KeyUsage { get; set; }
        public string NameConstraints { get; set; }
        public string PolicyConstraints { get; set; }
        public string PolicyMappings { get; set; }
        public DateTime? PrivateKeyUsagePeriodNotAfter { get; set; }
        public DateTime? PrivateKeyUsagePeriodNotBefore { get; set; }
        public string SubjectAlternativeName { get; set; }
        public string SubjectDirectoryAttributes { get; set; }
        public string SubjectKeyIdentifier { get; set; }
    }

}