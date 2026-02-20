package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes.dex */
public final class UpdateAdCounterHistogramRequest {
    private final int adEventType;
    private final long adSelectionId;
    private final AdTechIdentifier callerAdTech;

    public UpdateAdCounterHistogramRequest(long j10, int i10, AdTechIdentifier adTechIdentifier) {
        adTechIdentifier.getClass();
        this.adSelectionId = j10;
        this.adEventType = i10;
        this.callerAdTech = adTechIdentifier;
        if (i10 == 0) {
            com.google.gson.internal.a.n("Win event types cannot be manually updated.");
            throw null;
        }
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return;
        }
        com.google.gson.internal.a.n("Ad event type must be one of AD_EVENT_TYPE_IMPRESSION, AD_EVENT_TYPE_VIEW, or AD_EVENT_TYPE_CLICK");
        throw null;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.UpdateAdCounterHistogramRequest convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.UpdateAdCounterHistogramRequest updateAdCounterHistogramRequestBuild = new UpdateAdCounterHistogramRequest.Builder(this.adSelectionId, this.adEventType, this.callerAdTech.convertToAdServices$ads_adservices_release()).build();
        updateAdCounterHistogramRequestBuild.getClass();
        return updateAdCounterHistogramRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateAdCounterHistogramRequest)) {
            return false;
        }
        UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest = (UpdateAdCounterHistogramRequest) obj;
        return this.adSelectionId == updateAdCounterHistogramRequest.adSelectionId && this.adEventType == updateAdCounterHistogramRequest.adEventType && l.a(this.callerAdTech, updateAdCounterHistogramRequest.callerAdTech);
    }

    public final int getAdEventType() {
        return this.adEventType;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final AdTechIdentifier getCallerAdTech() {
        return this.callerAdTech;
    }

    public int hashCode() {
        long j10 = this.adSelectionId;
        return this.callerAdTech.hashCode() + (((((int) (j10 ^ (j10 >>> 32))) * 31) + this.adEventType) * 31);
    }

    public String toString() {
        int i10 = this.adEventType;
        return "UpdateAdCounterHistogramRequest: adSelectionId=" + this.adSelectionId + ", adEventType=" + (i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "Invalid ad event type" : "AD_EVENT_TYPE_CLICK" : "AD_EVENT_TYPE_VIEW" : "AD_EVENT_TYPE_IMPRESSION" : "AD_EVENT_TYPE_WIN") + ", callerAdTech=" + this.callerAdTech;
    }
}
