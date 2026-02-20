package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.SourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import k1.b;
import kotlin.jvm.internal.g;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class MeasurementManagerFutures {
    public static final Companion Companion = new Companion(null);

    public static final MeasurementManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract b deleteRegistrationsAsync(DeletionRequest deletionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract b getMeasurementApiStatusAsync();

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract b registerSourceAsync(Uri uri, InputEvent inputEvent);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @ExperimentalFeatures.RegisterSourceOptIn
    public abstract b registerSourceAsync(SourceRegistrationRequest sourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract b registerTriggerAsync(Uri uri);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract b registerWebSourceAsync(WebSourceRegistrationRequest webSourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract b registerWebTriggerAsync(WebTriggerRegistrationRequest webTriggerRegistrationRequest);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final MeasurementManagerFutures from(Context context) {
            context.getClass();
            MeasurementManager measurementManagerObtain = MeasurementManager.Companion.obtain(context);
            if (measurementManagerObtain != null) {
                return new Api33Ext5JavaImpl(measurementManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {
        private final MeasurementManager mMeasurementManager;

        public Api33Ext5JavaImpl(MeasurementManager measurementManager) {
            measurementManager.getClass();
            this.mMeasurementManager = measurementManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public b deleteRegistrationsAsync(DeletionRequest deletionRequest) {
            deletionRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, deletionRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public b getMeasurementApiStatusAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public b registerSourceAsync(Uri uri, InputEvent inputEvent) {
            uri.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, uri, inputEvent, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public b registerTriggerAsync(Uri uri) {
            uri.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, uri, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public b registerWebSourceAsync(WebSourceRegistrationRequest webSourceRegistrationRequest) {
            webSourceRegistrationRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, webSourceRegistrationRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public b registerWebTriggerAsync(WebTriggerRegistrationRequest webTriggerRegistrationRequest) {
            webTriggerRegistrationRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, webTriggerRegistrationRequest, null)), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        @ExperimentalFeatures.RegisterSourceOptIn
        public b registerSourceAsync(SourceRegistrationRequest sourceRegistrationRequest) {
            sourceRegistrationRequest.getClass();
            return CoroutineAdapterKt.asListenableFuture$default(y.d(y.a(i0.f12407a), new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2(this, sourceRegistrationRequest, null)), null, 1, null);
        }
    }
}
