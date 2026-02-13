package androidx.privacysandbox.ads.adservices.java.adselection;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionFromOutcomesConfig;
import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.GetAdSelectionDataRequest;
import androidx.privacysandbox.ads.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportEventRequest;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.adselection.UpdateAdCounterHistogramRequest;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import k1.b;
import kotlin.jvm.internal.g;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class AdSelectionManagerFutures {
    public static final Companion Companion = new Companion(null);

    public static final AdSelectionManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract b getAdSelectionDataAsync(GetAdSelectionDataRequest getAdSelectionDataRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract b persistAdSelectionResultAsync(PersistAdSelectionResultRequest persistAdSelectionResultRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract b reportEventAsync(ReportEventRequest reportEventRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract b reportImpressionAsync(ReportImpressionRequest reportImpressionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    public abstract b selectAdsAsync(AdSelectionConfig adSelectionConfig);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext10OptIn
    public abstract b selectAdsAsync(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @ExperimentalFeatures.Ext8OptIn
    public abstract b updateAdCounterHistogramAsync(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final AdSelectionManagerFutures from(Context context) {
            context.getClass();
            AdSelectionManager adSelectionManagerObtain = AdSelectionManager.Companion.obtain(context);
            if (adSelectionManagerObtain != null) {
                return new Api33Ext4JavaImpl(adSelectionManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Api33Ext4JavaImpl extends AdSelectionManagerFutures {
        private final AdSelectionManager mAdSelectionManager;

        public Api33Ext4JavaImpl(AdSelectionManager adSelectionManager) {
            this.mAdSelectionManager = adSelectionManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b getAdSelectionDataAsync(GetAdSelectionDataRequest getAdSelectionDataRequest) {
            getAdSelectionDataRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$getAdSelectionDataAsync$1(this, getAdSelectionDataRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b persistAdSelectionResultAsync(PersistAdSelectionResultRequest persistAdSelectionResultRequest) {
            persistAdSelectionResultRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$persistAdSelectionResultAsync$1(this, persistAdSelectionResultRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b reportEventAsync(ReportEventRequest reportEventRequest) {
            reportEventRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportEventAsync$1(this, reportEventRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b reportImpressionAsync(ReportImpressionRequest reportImpressionRequest) {
            reportImpressionRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(this, reportImpressionRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b selectAdsAsync(AdSelectionConfig adSelectionConfig) {
            adSelectionConfig.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$1(this, adSelectionConfig, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b updateAdCounterHistogramAsync(UpdateAdCounterHistogramRequest updateAdCounterHistogramRequest) {
            updateAdCounterHistogramRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$updateAdCounterHistogramAsync$1(this, updateAdCounterHistogramRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        public b selectAdsAsync(AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig) {
            adSelectionFromOutcomesConfig.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new AdSelectionManagerFutures$Api33Ext4JavaImpl$selectAdsAsync$2(this, adSelectionFromOutcomesConfig, null)), null, 1, null);
        }
    }
}
