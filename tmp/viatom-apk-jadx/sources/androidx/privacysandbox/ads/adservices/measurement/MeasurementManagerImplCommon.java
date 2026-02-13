package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import g7.p;
import java.util.Iterator;
import java.util.List;
import r0.f;
import r7.g;
import r7.w;
import r7.y;
import s6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class MeasurementManagerImplCommon extends MeasurementManager {
    private final android.adservices.measurement.MeasurementManager mMeasurementManager;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon$registerSource$4", f = "MeasurementManagerImplCommon.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon$registerSource$4, reason: invalid class name */
    public static final class AnonymousClass4 extends i implements p {
        final /* synthetic */ SourceRegistrationRequest $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MeasurementManagerImplCommon this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(SourceRegistrationRequest sourceRegistrationRequest, MeasurementManagerImplCommon measurementManagerImplCommon, c cVar) {
            super(2, cVar);
            this.$request = sourceRegistrationRequest;
            this.this$0 = measurementManagerImplCommon;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$request, this.this$0, cVar);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // g7.p
        public final Object invoke(w wVar, c cVar) {
            return ((AnonymousClass4) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
            w wVar = (w) this.L$0;
            List<Uri> registrationUris = this.$request.getRegistrationUris();
            MeasurementManagerImplCommon measurementManagerImplCommon = this.this$0;
            SourceRegistrationRequest sourceRegistrationRequest = this.$request;
            Iterator<T> it = registrationUris.iterator();
            while (it.hasNext()) {
                y.q(wVar, null, null, new MeasurementManagerImplCommon$registerSource$4$1$1(measurementManagerImplCommon, (Uri) it.next(), sourceRegistrationRequest, null), 3);
            }
            return s6.w.f12711a;
        }
    }

    public MeasurementManagerImplCommon(android.adservices.measurement.MeasurementManager measurementManager) {
        measurementManager.getClass();
        this.mMeasurementManager = measurementManager;
    }

    @DoNotInline
    public static Object deleteRegistrations$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, DeletionRequest deletionRequest, c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        measurementManagerImplCommon.getMMeasurementManager().deleteRegistrations(deletionRequest.convertToAdServices$ads_adservices_release(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        Object objQ = gVar.q();
        return objQ == x6.a.f13718a ? objQ : s6.w.f12711a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object getMeasurementApiStatus$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        measurementManagerImplCommon.getMMeasurementManager().getMeasurementApiStatus(new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        return gVar.q();
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object registerSource$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, InputEvent inputEvent, c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        measurementManagerImplCommon.getMMeasurementManager().registerSource(uri, inputEvent, new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        Object objQ = gVar.q();
        return objQ == x6.a.f13718a ? objQ : s6.w.f12711a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object registerTrigger$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        measurementManagerImplCommon.getMMeasurementManager().registerTrigger(uri, new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        Object objQ = gVar.q();
        return objQ == x6.a.f13718a ? objQ : s6.w.f12711a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object registerWebSource$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, WebSourceRegistrationRequest webSourceRegistrationRequest, c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        measurementManagerImplCommon.getMMeasurementManager().registerWebSource(webSourceRegistrationRequest.convertToAdServices$ads_adservices_release(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        Object objQ = gVar.q();
        return objQ == x6.a.f13718a ? objQ : s6.w.f12711a;
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public static Object registerWebTrigger$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, WebTriggerRegistrationRequest webTriggerRegistrationRequest, c cVar) {
        g gVar = new g(1, f.F(cVar));
        gVar.s();
        measurementManagerImplCommon.getMMeasurementManager().registerWebTrigger(webTriggerRegistrationRequest.convertToAdServices$ads_adservices_release(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
        Object objQ = gVar.q();
        return objQ == x6.a.f13718a ? objQ : s6.w.f12711a;
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @DoNotInline
    public Object deleteRegistrations(DeletionRequest deletionRequest, c cVar) {
        return deleteRegistrations$suspendImpl(this, deletionRequest, cVar);
    }

    public final android.adservices.measurement.MeasurementManager getMMeasurementManager() {
        return this.mMeasurementManager;
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object getMeasurementApiStatus(c cVar) {
        return getMeasurementApiStatus$suspendImpl(this, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerSource(Uri uri, InputEvent inputEvent, c cVar) {
        return registerSource$suspendImpl(this, uri, inputEvent, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerTrigger(Uri uri, c cVar) {
        return registerTrigger$suspendImpl(this, uri, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, c cVar) {
        return registerWebSource$suspendImpl(this, webSourceRegistrationRequest, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    public Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, c cVar) {
        return registerWebTrigger$suspendImpl(this, webTriggerRegistrationRequest, cVar);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @ExperimentalFeatures.RegisterSourceOptIn
    public Object registerSource(SourceRegistrationRequest sourceRegistrationRequest, c cVar) {
        return registerSource$suspendImpl(this, sourceRegistrationRequest, cVar);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @DoNotInline
    @ExperimentalFeatures.RegisterSourceOptIn
    public static Object registerSource$suspendImpl(MeasurementManagerImplCommon measurementManagerImplCommon, SourceRegistrationRequest sourceRegistrationRequest, c cVar) {
        Object objG = y.g(new AnonymousClass4(sourceRegistrationRequest, measurementManagerImplCommon, null), cVar);
        return objG == x6.a.f13718a ? objG : s6.w.f12711a;
    }
}
