package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class ReportImpressionRequest {
    private final AdSelectionConfig adSelectionConfig;
    private final long adSelectionId;

    public ReportImpressionRequest(long j10, AdSelectionConfig adSelectionConfig) {
        adSelectionConfig.getClass();
        this.adSelectionId = j10;
        this.adSelectionConfig = adSelectionConfig;
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.ReportImpressionRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        return (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) ? Ext10Impl.Companion.convertReportImpressionRequest(this) : Ext4Impl.Companion.convertReportImpressionRequest(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportImpressionRequest)) {
            return false;
        }
        ReportImpressionRequest reportImpressionRequest = (ReportImpressionRequest) obj;
        return this.adSelectionId == reportImpressionRequest.adSelectionId && l.a(this.adSelectionConfig, reportImpressionRequest.adSelectionConfig);
    }

    public final AdSelectionConfig getAdSelectionConfig() {
        return this.adSelectionConfig;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        long j10 = this.adSelectionId;
        return this.adSelectionConfig.hashCode() + (((int) (j10 ^ (j10 >>> 32))) * 31);
    }

    public String toString() {
        return "ReportImpressionRequest: adSelectionId=" + this.adSelectionId + ", adSelectionConfig=" + this.adSelectionConfig;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    public static final class Ext10Impl {
        public static final Companion Companion = new Companion(null);

        private Ext10Impl() {
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final android.adservices.adselection.ReportImpressionRequest convertReportImpressionRequest(ReportImpressionRequest reportImpressionRequest) {
                reportImpressionRequest.getClass();
                if (l.a(reportImpressionRequest.getAdSelectionConfig(), AdSelectionConfig.Companion.getEMPTY())) {
                    b.b();
                    return a.a(reportImpressionRequest.getAdSelectionId());
                }
                b.b();
                return b.a(reportImpressionRequest.getAdSelectionId(), reportImpressionRequest.getAdSelectionConfig().convertToAdServices$ads_adservices_release());
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public static final class Ext4Impl {
        public static final Companion Companion = new Companion(null);

        private Ext4Impl() {
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final android.adservices.adselection.ReportImpressionRequest convertReportImpressionRequest(ReportImpressionRequest reportImpressionRequest) {
                reportImpressionRequest.getClass();
                if (l.a(reportImpressionRequest.getAdSelectionConfig(), AdSelectionConfig.Companion.getEMPTY())) {
                    a2.a.m("adSelectionConfig is mandatory forAPI versions lower than ext 10");
                    return null;
                }
                b.b();
                return b.a(reportImpressionRequest.getAdSelectionId(), reportImpressionRequest.getAdSelectionConfig().convertToAdServices$ads_adservices_release());
            }

            private Companion() {
            }
        }
    }

    @ExperimentalFeatures.Ext8OptIn
    public ReportImpressionRequest(long j10) {
        this(j10, AdSelectionConfig.Companion.getEMPTY());
    }
}
