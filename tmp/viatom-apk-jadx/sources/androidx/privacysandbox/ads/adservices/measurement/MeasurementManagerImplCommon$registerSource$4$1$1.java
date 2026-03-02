package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import androidx.core.os.OutcomeReceiverKt;
import g7.p;
import r0.f;
import r7.g;
import r7.w;
import s6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon$registerSource$4$1$1", f = "MeasurementManagerImplCommon.kt", l = {131}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MeasurementManagerImplCommon$registerSource$4$1$1 extends i implements p {
    final /* synthetic */ SourceRegistrationRequest $request;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MeasurementManagerImplCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeasurementManagerImplCommon$registerSource$4$1$1(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, SourceRegistrationRequest sourceRegistrationRequest, c cVar) {
        super(2, cVar);
        this.this$0 = measurementManagerImplCommon;
        this.$uri = uri;
        this.$request = sourceRegistrationRequest;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new MeasurementManagerImplCommon$registerSource$4$1$1(this.this$0, this.$uri, this.$request, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((MeasurementManagerImplCommon$registerSource$4$1$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            a.e(obj);
            MeasurementManagerImplCommon measurementManagerImplCommon = this.this$0;
            Uri uri = this.$uri;
            SourceRegistrationRequest sourceRegistrationRequest = this.$request;
            this.L$0 = measurementManagerImplCommon;
            this.L$1 = uri;
            this.L$2 = sourceRegistrationRequest;
            this.label = 1;
            g gVar = new g(1, f.F(this));
            gVar.s();
            measurementManagerImplCommon.getMMeasurementManager().registerSource(uri, sourceRegistrationRequest.getInputEvent(), new androidx.arch.core.executor.a(2), OutcomeReceiverKt.asOutcomeReceiver(gVar));
            Object objQ = gVar.q();
            x6.a aVar = x6.a.f13718a;
            if (objQ == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
        }
        return s6.w.f12711a;
    }
}
