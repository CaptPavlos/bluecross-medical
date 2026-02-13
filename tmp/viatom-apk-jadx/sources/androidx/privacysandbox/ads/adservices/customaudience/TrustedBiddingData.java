package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TrustedBiddingData {
    private final List<String> trustedBiddingKeys;
    private final Uri trustedBiddingUri;

    public TrustedBiddingData(Uri uri, List<String> list) {
        uri.getClass();
        list.getClass();
        this.trustedBiddingUri = uri;
        this.trustedBiddingKeys = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrustedBiddingData)) {
            return false;
        }
        TrustedBiddingData trustedBiddingData = (TrustedBiddingData) obj;
        return l.a(this.trustedBiddingUri, trustedBiddingData.trustedBiddingUri) && l.a(this.trustedBiddingKeys, trustedBiddingData.trustedBiddingKeys);
    }

    public final List<String> getTrustedBiddingKeys() {
        return this.trustedBiddingKeys;
    }

    public final Uri getTrustedBiddingUri() {
        return this.trustedBiddingUri;
    }

    public int hashCode() {
        return this.trustedBiddingKeys.hashCode() + (this.trustedBiddingUri.hashCode() * 31);
    }

    public String toString() {
        return "TrustedBiddingData: trustedBiddingUri=" + this.trustedBiddingUri + " trustedBiddingKeys=" + this.trustedBiddingKeys;
    }
}
