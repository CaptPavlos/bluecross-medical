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
public final class PausingDispatcherKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.jvm.kt", l = {213}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    public static final class AnonymousClass2 extends y6.i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ Lifecycle.State $minState;
        final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Lifecycle lifecycle, Lifecycle.State state, p pVar, w6.c cVar) {
            super(2, cVar);
            this.$this_whenStateAtLeast = lifecycle;
            this.$minState = state;
            this.$block = pVar;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            LifecycleController lifecycleController;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lifecycleController = (LifecycleController) this.L$0;
                try {
                    s6.a.e(obj);
                    lifecycleController.finish();
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController.finish();
                    throw th;
                }
            }
            s6.a.e(obj);
            a1 a1Var = (a1) ((w) this.L$0).getCoroutineContext().get(t.f12437b);
            if (a1Var == null) {
                androidx.window.layout.c.g("when[State] methods should have a parent job");
                return null;
            }
            PausingDispatcher pausingDispatcher = new PausingDispatcher();
            LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, a1Var);
            try {
                p pVar = this.$block;
                this.L$0 = lifecycleController2;
                this.label = 1;
                obj = y.z(pVar, pausingDispatcher, this);
                x6.a aVar = x6.a.f13718a;
                if (obj == aVar) {
                    return aVar;
                }
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                throw th;
            }
        }
    }

    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, p pVar, w6.c cVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, p pVar, w6.c cVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, p pVar, w6.c cVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, p pVar, w6.c cVar) {
        y7.e eVar = i0.f12407a;
        return y.z(new AnonymousClass2(lifecycle, state, pVar, null), n.f13548a.f12716c, cVar);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, p pVar, w6.c cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, cVar);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, p pVar, w6.c cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, cVar);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, p pVar, w6.c cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, cVar);
    }
}
