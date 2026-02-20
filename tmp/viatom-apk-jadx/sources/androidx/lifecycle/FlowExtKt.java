package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import g7.p;
import r7.w;
import t7.r;
import t7.s;
import u7.i0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FlowExtKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements p {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ u7.h $this_flowWithLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @y6.e(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00071 extends y6.i implements p {
            final /* synthetic */ s $$this$callbackFlow;
            final /* synthetic */ u7.h $this_flowWithLifecycle;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00071(u7.h hVar, s sVar, w6.c cVar) {
                super(2, cVar);
                this.$this_flowWithLifecycle = hVar;
                this.$$this$callbackFlow = sVar;
            }

            @Override // y6.a
            public final w6.c create(Object obj, w6.c cVar) {
                return new C00071(this.$this_flowWithLifecycle, this.$$this$callbackFlow, cVar);
            }

            @Override // g7.p
            public final Object invoke(w wVar, w6.c cVar) {
                return ((C00071) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            }

            @Override // y6.a
            public final Object invokeSuspend(Object obj) {
                int i10 = this.label;
                if (i10 == 0) {
                    s6.a.e(obj);
                    u7.h hVar = this.$this_flowWithLifecycle;
                    final s sVar = this.$$this$callbackFlow;
                    u7.i iVar = new u7.i() { // from class: androidx.lifecycle.FlowExtKt.flowWithLifecycle.1.1.1
                        @Override // u7.i
                        public final Object emit(T t, w6.c cVar) {
                            Object objL = ((r) sVar).f12859d.l(t, cVar);
                            return objL == x6.a.f13718a ? objL : s6.w.f12711a;
                        }
                    };
                    this.label = 1;
                    Object objCollect = hVar.collect(iVar, this);
                    x6.a aVar = x6.a.f13718a;
                    if (objCollect == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return s6.w.f12711a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, u7.h hVar, w6.c cVar) {
            super(2, cVar);
            this.$lifecycle = lifecycle;
            this.$minActiveState = state;
            this.$this_flowWithLifecycle = hVar;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // g7.p
        public final Object invoke(s sVar, w6.c cVar) {
            return ((AnonymousClass1) create(sVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            s sVar;
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                sVar = (s) this.L$0;
                Lifecycle lifecycle = this.$lifecycle;
                Lifecycle.State state = this.$minActiveState;
                C00071 c00071 = new C00071(this.$this_flowWithLifecycle, sVar, null);
                this.L$0 = sVar;
                this.label = 1;
                Object objRepeatOnLifecycle = RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, c00071, this);
                x6.a aVar = x6.a.f13718a;
                if (objRepeatOnLifecycle == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                sVar = (s) this.L$0;
                s6.a.e(obj);
            }
            ((r) sVar).k(null);
            return s6.w.f12711a;
        }
    }

    public static final <T> u7.h flowWithLifecycle(u7.h hVar, Lifecycle lifecycle, Lifecycle.State state) {
        hVar.getClass();
        lifecycle.getClass();
        state.getClass();
        return i0.d(new AnonymousClass1(lifecycle, state, hVar, null));
    }

    public static /* synthetic */ u7.h flowWithLifecycle$default(u7.h hVar, Lifecycle lifecycle, Lifecycle.State state, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(hVar, lifecycle, state);
    }
}
