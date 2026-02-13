package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.GetAdSelectionDataRequest;
import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalFeatures.Ext10OptIn
/* loaded from: classes.dex */
public final class GetAdSelectionDataRequest {
    private final Uri coordinatorOriginUri;
    private final AdTechIdentifier seller;

    public GetAdSelectionDataRequest(AdTechIdentifier adTechIdentifier, Uri uri) {
        adTechIdentifier.getClass();
        this.seller = adTechIdentifier;
        this.coordinatorOriginUri = uri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.GetAdSelectionDataRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        return (adServicesInfo.adServicesVersion() >= 12 || adServicesInfo.extServicesVersionS() >= 12) ? Ext12Impl.Companion.convertGetAdSelectionDataRequest(this) : Ext10Impl.Companion.convertGetAdSelectionDataRequest(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataRequest)) {
            return false;
        }
        GetAdSelectionDataRequest getAdSelectionDataRequest = (GetAdSelectionDataRequest) obj;
        return l.a(this.seller, getAdSelectionDataRequest.seller) && l.a(this.coordinatorOriginUri, getAdSelectionDataRequest.coordinatorOriginUri);
    }

    public final Uri getCoordinatorOriginUri() {
        return this.coordinatorOriginUri;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int iHashCode = this.seller.hashCode() * 31;
        Uri uri = this.coordinatorOriginUri;
        return iHashCode + (uri != null ? uri.hashCode() : 0);
    }

    public String toString() {
        return "GetAdSelectionDataRequest: seller=" + this.seller + ", coordinatorOriginUri=" + this.coordinatorOriginUri;
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

            public final android.adservices.adselection.GetAdSelectionDataRequest convertGetAdSelectionDataRequest(GetAdSelectionDataRequest getAdSelectionDataRequest) {
                getAdSelectionDataRequest.getClass();
                android.adservices.adselection.GetAdSelectionDataRequest getAdSelectionDataRequestBuild = new GetAdSelectionDataRequest.Builder().setSeller(getAdSelectionDataRequest.getSeller().convertToAdServices$ads_adservices_release()).build();
                getAdSelectionDataRequestBuild.getClass();
                return getAdSelectionDataRequestBuild;
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 12), @RequiresExtension(extension = 31, version = 12)})
    public static final class Ext12Impl {
        public static final Companion Companion = new Companion(null);

        private Ext12Impl() {
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final android.adservices.adselection.GetAdSelectionDataRequest convertGetAdSelectionDataRequest(GetAdSelectionDataRequest getAdSelectionDataRequest) {
                getAdSelectionDataRequest.getClass();
                android.adservices.adselection.GetAdSelectionDataRequest getAdSelectionDataRequestBuild = new GetAdSelectionDataRequest.Builder().setSeller(getAdSelectionDataRequest.getSeller().convertToAdServices$ads_adservices_release()).setCoordinatorOriginUri(getAdSelectionDataRequest.getCoordinatorOriginUri()).build();
                getAdSelectionDataRequestBuild.getClass();
                return getAdSelectionDataRequestBuild;
            }

            private Companion() {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GetAdSelectionDataRequest(AdTechIdentifier adTechIdentifier) {
        this(adTechIdentifier, null, 2, 0 == true ? 1 : 0);
        adTechIdentifier.getClass();
    }

    public /* synthetic */ GetAdSelectionDataRequest(AdTechIdentifier adTechIdentifier, Uri uri, int i10, g gVar) {
        this(adTechIdentifier, (i10 & 2) != 0 ? null : uri);
    }

    @ExperimentalFeatures.Ext12OptIn
    public static /* synthetic */ void getCoordinatorOriginUri$annotations() {
    }
}
