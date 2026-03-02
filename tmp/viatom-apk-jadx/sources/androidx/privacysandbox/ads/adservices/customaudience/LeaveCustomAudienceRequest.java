package androidx.privacysandbox.ads.adservices.customaudience;

import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LeaveCustomAudienceRequest {
    private final AdTechIdentifier buyer;
    private final String name;

    public LeaveCustomAudienceRequest(AdTechIdentifier adTechIdentifier, String str) {
        adTechIdentifier.getClass();
        str.getClass();
        this.buyer = adTechIdentifier;
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LeaveCustomAudienceRequest)) {
            return false;
        }
        LeaveCustomAudienceRequest leaveCustomAudienceRequest = (LeaveCustomAudienceRequest) obj;
        return l.a(this.buyer, leaveCustomAudienceRequest.buyer) && l.a(this.name, leaveCustomAudienceRequest.name);
    }

    public final AdTechIdentifier getBuyer() {
        return this.buyer;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode() + (this.buyer.hashCode() * 31);
    }

    public String toString() {
        return "LeaveCustomAudience: buyer=" + this.buyer + ", name=" + this.name;
    }
}
