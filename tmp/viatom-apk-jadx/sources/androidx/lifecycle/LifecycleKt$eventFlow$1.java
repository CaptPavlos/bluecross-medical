package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import g7.p;
import s6.w;
import t7.r;
import t7.s;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@y6.e(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", l = {373}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LifecycleKt$eventFlow$1 extends y6.i implements p {
    final /* synthetic */ Lifecycle $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleKt$eventFlow$1(Lifecycle lifecycle, w6.c cVar) {
        super(2, cVar);
        this.$this_eventFlow = lifecycle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(s sVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        r rVar = (r) sVar;
        rVar.q(event);
        if (event == Lifecycle.Event.ON_DESTROY) {
            rVar.k(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w invokeSuspend$lambda$1(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        lifecycle.removeObserver(lifecycleEventObserver);
        return w.f12711a;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.$this_eventFlow, cVar);
        lifecycleKt$eventFlow$1.L$0 = obj;
        return lifecycleKt$eventFlow$1;
    }

    @Override // g7.p
    public final Object invoke(s sVar, w6.c cVar) {
        return ((LifecycleKt$eventFlow$1) create(sVar, cVar)).invokeSuspend(w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            s6.a.e(obj);
            s sVar = (s) this.L$0;
            final g gVar = new g(sVar, 0);
            this.$this_eventFlow.addObserver(gVar);
            final Lifecycle lifecycle = this.$this_eventFlow;
            g7.a aVar = new g7.a() { // from class: androidx.lifecycle.h
                @Override // g7.a
                public final Object invoke() {
                    return LifecycleKt$eventFlow$1.invokeSuspend$lambda$1(lifecycle, gVar);
                }
            };
            this.label = 1;
            Object objH = t1.h(sVar, aVar, this);
            x6.a aVar2 = x6.a.f13718a;
            if (objH == aVar2) {
                return aVar2;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return w.f12711a;
    }
}
