package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import j$.time.Instant;
import j$.time.TimeConversions;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalFeatures.Ext10OptIn
/* loaded from: classes.dex */
public final class FetchAndJoinCustomAudienceRequest {
    private final Instant activationTime;
    private final Instant expirationTime;
    private final Uri fetchUri;
    private final String name;
    private final AdSelectionSignals userBiddingSignals;

    public /* synthetic */ FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, int i10, g gVar) {
        this(uri, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : instant, (i10 & 8) != 0 ? null : instant2, (i10 & 16) != 0 ? null : adSelectionSignals);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.customaudience.FetchAndJoinCustomAudienceRequest convertToAdServices$ads_adservices_release() {
        FetchAndJoinCustomAudienceRequest.Builder expirationTime = new FetchAndJoinCustomAudienceRequest.Builder(this.fetchUri).setName(this.name).setActivationTime(TimeConversions.convert(this.activationTime)).setExpirationTime(TimeConversions.convert(this.expirationTime));
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        android.adservices.customaudience.FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequestBuild = expirationTime.setUserBiddingSignals(adSelectionSignals != null ? adSelectionSignals.convertToAdServices$ads_adservices_release() : null).build();
        fetchAndJoinCustomAudienceRequestBuild.getClass();
        return fetchAndJoinCustomAudienceRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchAndJoinCustomAudienceRequest)) {
            return false;
        }
        FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest = (FetchAndJoinCustomAudienceRequest) obj;
        return l.a(this.fetchUri, fetchAndJoinCustomAudienceRequest.fetchUri) && l.a(this.name, fetchAndJoinCustomAudienceRequest.name) && l.a(this.activationTime, fetchAndJoinCustomAudienceRequest.activationTime) && l.a(this.expirationTime, fetchAndJoinCustomAudienceRequest.expirationTime) && l.a(this.userBiddingSignals, fetchAndJoinCustomAudienceRequest.userBiddingSignals);
    }

    public final Instant getActivationTime() {
        return this.activationTime;
    }

    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    public final Uri getFetchUri() {
        return this.fetchUri;
    }

    public final String getName() {
        return this.name;
    }

    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int iHashCode = this.fetchUri.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Instant instant = this.activationTime;
        int iHashCode3 = (iHashCode2 + (instant != null ? instant.hashCode() : 0)) * 31;
        Instant instant2 = this.expirationTime;
        int iHashCode4 = (iHashCode3 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        return iHashCode4 + (adSelectionSignals != null ? adSelectionSignals.hashCode() : 0);
    }

    public String toString() {
        return "FetchAndJoinCustomAudienceRequest: fetchUri=" + this.fetchUri + ", name=" + this.name + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", userBiddingSignals=" + this.userBiddingSignals;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri, String str) {
        this(uri, str, null, null, null, 28, null);
        uri.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant) {
        this(uri, str, instant, null, null, 24, null);
        uri.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2) {
        this(uri, str, instant, instant2, null, 16, null);
        uri.getClass();
    }

    public FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals) {
        uri.getClass();
        this.fetchUri = uri;
        this.name = str;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FetchAndJoinCustomAudienceRequest(Uri uri) {
        this(uri, null, null, null, null, 30, null);
        uri.getClass();
    }
}
