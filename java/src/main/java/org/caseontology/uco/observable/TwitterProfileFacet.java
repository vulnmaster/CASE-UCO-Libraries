// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A twitter profile facet is a grouping of characteristics unique to an explicit digital representation of identity and characteristics of the owner of a single Twitter user account. [based on https://e */
public class TwitterProfileFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/TwitterProfileFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long favoritesCount;
    private Long followersCount;
    private Long friendsCount;
    private Long listedCount;
    private List<Hash> profileBackgroundHash;
    private ObservableObject profileBackgroundLocation;
    private List<Hash> profileBannerHash;
    private ObservableObject profileBannerLocation;
    private List<Hash> profileImageHash;
    private ObservableObject profileImageLocation;
    private Boolean profileIsProtected;
    private Boolean profileIsVerified;
    private Long statusesCount;
    private String twitterHandle;
    private String twitterId;
    private String userLocationString;

    public TwitterProfileFacet() {
        this.profileBackgroundHash = new ArrayList<>();
        this.profileBannerHash = new ArrayList<>();
        this.profileImageHash = new ArrayList<>();
    }

    public Long getFavoritesCount() { return this.favoritesCount; }
    public TwitterProfileFacet setFavoritesCount(Long value) { this.favoritesCount = value; return this; }

    public Long getFollowersCount() { return this.followersCount; }
    public TwitterProfileFacet setFollowersCount(Long value) { this.followersCount = value; return this; }

    public Long getFriendsCount() { return this.friendsCount; }
    public TwitterProfileFacet setFriendsCount(Long value) { this.friendsCount = value; return this; }

    public Long getListedCount() { return this.listedCount; }
    public TwitterProfileFacet setListedCount(Long value) { this.listedCount = value; return this; }

    public List<Hash> getProfileBackgroundHash() { return this.profileBackgroundHash; }
    public TwitterProfileFacet setProfileBackgroundHash(List<Hash> value) { this.profileBackgroundHash = value; return this; }

    public ObservableObject getProfileBackgroundLocation() { return this.profileBackgroundLocation; }
    public TwitterProfileFacet setProfileBackgroundLocation(ObservableObject value) { this.profileBackgroundLocation = value; return this; }

    public List<Hash> getProfileBannerHash() { return this.profileBannerHash; }
    public TwitterProfileFacet setProfileBannerHash(List<Hash> value) { this.profileBannerHash = value; return this; }

    public ObservableObject getProfileBannerLocation() { return this.profileBannerLocation; }
    public TwitterProfileFacet setProfileBannerLocation(ObservableObject value) { this.profileBannerLocation = value; return this; }

    public List<Hash> getProfileImageHash() { return this.profileImageHash; }
    public TwitterProfileFacet setProfileImageHash(List<Hash> value) { this.profileImageHash = value; return this; }

    public ObservableObject getProfileImageLocation() { return this.profileImageLocation; }
    public TwitterProfileFacet setProfileImageLocation(ObservableObject value) { this.profileImageLocation = value; return this; }

    public Boolean getProfileIsProtected() { return this.profileIsProtected; }
    public TwitterProfileFacet setProfileIsProtected(Boolean value) { this.profileIsProtected = value; return this; }

    public Boolean getProfileIsVerified() { return this.profileIsVerified; }
    public TwitterProfileFacet setProfileIsVerified(Boolean value) { this.profileIsVerified = value; return this; }

    public Long getStatusesCount() { return this.statusesCount; }
    public TwitterProfileFacet setStatusesCount(Long value) { this.statusesCount = value; return this; }

    public String getTwitterHandle() { return this.twitterHandle; }
    public TwitterProfileFacet setTwitterHandle(String value) { this.twitterHandle = value; return this; }

    public String getTwitterId() { return this.twitterId; }
    public TwitterProfileFacet setTwitterId(String value) { this.twitterId = value; return this; }

    public String getUserLocationString() { return this.userLocationString; }
    public TwitterProfileFacet setUserLocationString(String value) { this.userLocationString = value; return this; }

}