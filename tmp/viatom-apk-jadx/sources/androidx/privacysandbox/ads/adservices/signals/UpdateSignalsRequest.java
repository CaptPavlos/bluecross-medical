package androidx.privacysandbox.ads.adservices.signals;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalFeatures.Ext12OptIn
/* loaded from: classes.dex */
public final class UpdateSignalsRequest {
    private final Uri updateUri;

    public UpdateSignalsRequest(Uri uri) {
        uri.getClass();
        this.updateUri = uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateSignalsRequest) {
            return l.a(this.updateUri, ((UpdateSignalsRequest) obj).updateUri);
        }
        return false;
    }

    public final Uri getUpdateUri() {
        return this.updateUri;
    }

    public int hashCode() {
        return this.updateUri.hashCode();
    }

    public String toString() {
        return "UpdateSignalsRequest: updateUri=" + this.updateUri;
    }
}
