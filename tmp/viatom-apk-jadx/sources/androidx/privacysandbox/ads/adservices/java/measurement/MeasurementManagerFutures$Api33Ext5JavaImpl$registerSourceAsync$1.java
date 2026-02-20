package androidx.privacysandbox.ads.adservices.java.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import g7.p;
import r7.w;
import s6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {143}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1 extends i implements p {
    final /* synthetic */ Uri $attributionSource;
    final /* synthetic */ InputEvent $inputEvent;
    int label;
    final /* synthetic */ MeasurementManagerFutures.Api33Ext5JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(MeasurementManagerFutures.Api33Ext5JavaImpl api33Ext5JavaImpl, Uri uri, InputEvent inputEvent, c cVar) {
        super(2, cVar);
        this.this$0 = api33Ext5JavaImpl;
        this.$attributionSource = uri;
        this.$inputEvent = inputEvent;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this.this$0, this.$attributionSource, this.$inputEvent, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            a.e(obj);
            MeasurementManager measurementManager = this.this$0.mMeasurementManager;
            Uri uri = this.$attributionSource;
            InputEvent inputEvent = this.$inputEvent;
            this.label = 1;
            Object objRegisterSource = measurementManager.registerSource(uri, inputEvent, this);
            x6.a aVar = x6.a.f13718a;
            if (objRegisterSource == aVar) {
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
