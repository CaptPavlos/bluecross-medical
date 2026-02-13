package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class AdSelectionOutcome {
    public static final Companion Companion = new Companion(null);
    public static final AdSelectionOutcome NO_OUTCOME;
    private final long adSelectionId;
    private final Uri renderUri;

    static {
        Uri uri = Uri.EMPTY;
        uri.getClass();
        NO_OUTCOME = new AdSelectionOutcome(0L, uri);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AdSelectionOutcome(android.adservices.adselection.AdSelectionOutcome adSelectionOutcome) {
        adSelectionOutcome.getClass();
        long adSelectionId = adSelectionOutcome.getAdSelectionId();
        Uri renderUri = adSelectionOutcome.getRenderUri();
        renderUri.getClass();
        this(adSelectionId, renderUri);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionOutcome)) {
            return false;
        }
        AdSelectionOutcome adSelectionOutcome = (AdSelectionOutcome) obj;
        return this.adSelectionId == adSelectionOutcome.adSelectionId && l.a(this.renderUri, adSelectionOutcome.renderUri);
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final Uri getRenderUri() {
        return this.renderUri;
    }

    @ExperimentalFeatures.Ext10OptIn
    public final boolean hasOutcome() {
        return !equals(NO_OUTCOME);
    }

    public int hashCode() {
        long j10 = this.adSelectionId;
        return this.renderUri.hashCode() + (((int) (j10 ^ (j10 >>> 32))) * 31);
    }

    public String toString() {
        return "AdSelectionOutcome: adSelectionId=" + this.adSelectionId + ", renderUri=" + this.renderUri;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @ExperimentalFeatures.Ext10OptIn
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        @ExperimentalFeatures.Ext10OptIn
        public static /* synthetic */ void getNO_OUTCOME$annotations() {
        }
    }

    public AdSelectionOutcome(long j10, Uri uri) {
        uri.getClass();
        this.adSelectionId = j10;
        this.renderUri = uri;
    }
}
