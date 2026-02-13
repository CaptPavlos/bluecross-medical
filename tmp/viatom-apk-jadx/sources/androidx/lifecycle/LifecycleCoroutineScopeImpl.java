package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import g7.p;
import r7.a1;
import r7.i0;
import r7.t;
import r7.w;
import r7.y;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final w6.h coroutineContext;
    private final Lifecycle lifecycle;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements p {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            AnonymousClass1 anonymousClass1 = LifecycleCoroutineScopeImpl.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            w wVar = (w) this.L$0;
            if (LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_common().addObserver(LifecycleCoroutineScopeImpl.this);
            } else {
                a1 a1Var = (a1) wVar.getCoroutineContext().get(t.f12437b);
                if (a1Var != null) {
                    a1Var.a(null);
                }
            }
            return s6.w.f12711a;
        }
    }

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, w6.h hVar) {
        a1 a1Var;
        lifecycle.getClass();
        hVar.getClass();
        this.lifecycle = lifecycle;
        this.coroutineContext = hVar;
        if (getLifecycle$lifecycle_common().getCurrentState() != Lifecycle.State.DESTROYED || (a1Var = (a1) getCoroutineContext().get(t.f12437b)) == null) {
            return;
        }
        a1Var.a(null);
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope, r7.w
    public w6.h getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        lifecycleOwner.getClass();
        event.getClass();
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            a1 a1Var = (a1) getCoroutineContext().get(t.f12437b);
            if (a1Var != null) {
                a1Var.a(null);
            }
        }
    }

    public final void register() {
        y7.e eVar = i0.f12407a;
        y.q(this, n.f13548a.f12716c, null, new AnonymousClass1(null), 2);
    }
}
