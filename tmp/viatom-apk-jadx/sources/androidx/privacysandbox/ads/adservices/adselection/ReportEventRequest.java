package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.ReportEventRequest;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.InputEvent;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes.dex */
public final class ReportEventRequest {
    public static final Companion Companion = new Companion(null);
    public static final int FLAG_REPORTING_DESTINATION_BUYER = 2;
    public static final int FLAG_REPORTING_DESTINATION_SELLER = 1;
    private final long adSelectionId;
    private final String eventData;
    private final String eventKey;
    private final InputEvent inputEvent;
    private final int reportingDestinations;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ReportingDestination {
    }

    public ReportEventRequest(long j10, String str, String str2, int i10, InputEvent inputEvent) {
        str.getClass();
        str2.getClass();
        this.adSelectionId = j10;
        this.eventKey = str;
        this.eventData = str2;
        this.reportingDestinations = i10;
        this.inputEvent = inputEvent;
        if (i10 <= 0 || i10 > 3) {
            com.google.gson.internal.a.n("Invalid reporting destinations bitfield.");
            throw null;
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.ReportEventRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        return (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) ? Ext10Impl.Companion.convertReportEventRequest(this) : Ext8Impl.Companion.convertReportEventRequest(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportEventRequest)) {
            return false;
        }
        ReportEventRequest reportEventRequest = (ReportEventRequest) obj;
        return this.adSelectionId == reportEventRequest.adSelectionId && l.a(this.eventKey, reportEventRequest.eventKey) && l.a(this.eventData, reportEventRequest.eventData) && this.reportingDestinations == reportEventRequest.reportingDestinations && l.a(this.inputEvent, reportEventRequest.inputEvent);
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final String getEventData() {
        return this.eventData;
    }

    public final String getEventKey() {
        return this.eventKey;
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final int getReportingDestinations() {
        return this.reportingDestinations;
    }

    public int hashCode() {
        long j10 = this.adSelectionId;
        int iO = (androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o(((int) (j10 ^ (j10 >>> 32))) * 31, 31, this.eventKey), 31, this.eventData) + this.reportingDestinations) * 31;
        InputEvent inputEvent = this.inputEvent;
        return iO + (inputEvent != null ? inputEvent.hashCode() : 0);
    }

    public String toString() {
        return "ReportEventRequest: adSelectionId=" + this.adSelectionId + ", eventKey=" + this.eventKey + ", eventData=" + this.eventData + ", reportingDestinations=" + this.reportingDestinations + "inputEvent=" + this.inputEvent;
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

            public final android.adservices.adselection.ReportEventRequest convertReportEventRequest(ReportEventRequest reportEventRequest) {
                reportEventRequest.getClass();
                android.adservices.adselection.ReportEventRequest reportEventRequestBuild = new ReportEventRequest.Builder(reportEventRequest.getAdSelectionId(), reportEventRequest.getEventKey(), reportEventRequest.getEventData(), reportEventRequest.getReportingDestinations()).setInputEvent(reportEventRequest.getInputEvent()).build();
                reportEventRequestBuild.getClass();
                return reportEventRequestBuild;
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    public static final class Ext8Impl {
        public static final Companion Companion = new Companion(null);

        private Ext8Impl() {
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final android.adservices.adselection.ReportEventRequest convertReportEventRequest(ReportEventRequest reportEventRequest) {
                reportEventRequest.getClass();
                if (reportEventRequest.getInputEvent() != null) {
                    Log.w("ReportEventRequest", "inputEvent is ignored. Min version to use inputEvent is API 31 ext 10");
                }
                android.adservices.adselection.ReportEventRequest reportEventRequestBuild = new ReportEventRequest.Builder(reportEventRequest.getAdSelectionId(), reportEventRequest.getEventKey(), reportEventRequest.getEventData(), reportEventRequest.getReportingDestinations()).build();
                reportEventRequestBuild.getClass();
                return reportEventRequestBuild;
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    @ExperimentalFeatures.Ext10OptIn
    public static /* synthetic */ void getInputEvent$annotations() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReportEventRequest(long j10, String str, String str2, int i10) {
        this(j10, str, str2, i10, null, 16, null);
        str.getClass();
        str2.getClass();
    }

    public /* synthetic */ ReportEventRequest(long j10, String str, String str2, int i10, InputEvent inputEvent, int i11, g gVar) {
        this(j10, str, str2, i10, (i11 & 16) != 0 ? null : inputEvent);
    }
}
