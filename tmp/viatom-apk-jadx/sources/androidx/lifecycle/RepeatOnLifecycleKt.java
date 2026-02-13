package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import g7.p;
import r7.i0;
import r7.w;
import r7.y;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {83}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    public static final class AnonymousClass3 extends y6.i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @y6.e(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {161}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends y6.i implements p {
            final /* synthetic */ w $$this$coroutineScope;
            final /* synthetic */ p $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, w wVar, p pVar, w6.c cVar) {
                super(2, cVar);
                this.$this_repeatOnLifecycle = lifecycle;
                this.$state = state;
                this.$$this$coroutineScope = wVar;
                this.$block = pVar;
            }

            @Override // y6.a
            public final w6.c create(Object obj, w6.c cVar) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, cVar);
            }

            @Override // g7.p
            public final Object invoke(w wVar, w6.c cVar) {
                return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x0096  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:41:? A[SYNTHETIC] */
            @Override // y6.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
                /*
                    r13 = this;
                    int r0 = r13.label
                    r1 = 0
                    s6.w r2 = s6.w.f12711a
                    r3 = 1
                    if (r0 == 0) goto L33
                    if (r0 != r3) goto L2c
                    java.lang.Object r0 = r13.L$5
                    g7.p r0 = (g7.p) r0
                    java.lang.Object r0 = r13.L$4
                    r7.w r0 = (r7.w) r0
                    java.lang.Object r0 = r13.L$3
                    androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                    java.lang.Object r0 = r13.L$2
                    androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                    java.lang.Object r0 = r13.L$1
                    r3 = r0
                    kotlin.jvm.internal.x r3 = (kotlin.jvm.internal.x) r3
                    java.lang.Object r0 = r13.L$0
                    r4 = r0
                    kotlin.jvm.internal.x r4 = (kotlin.jvm.internal.x) r4
                    s6.a.e(r14)     // Catch: java.lang.Throwable -> L28
                    goto L90
                L28:
                    r0 = move-exception
                    r14 = r0
                    goto La9
                L2c:
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    androidx.window.layout.c.g(r14)
                    r14 = 0
                    return r14
                L33:
                    s6.a.e(r14)
                    androidx.lifecycle.Lifecycle r14 = r13.$this_repeatOnLifecycle
                    androidx.lifecycle.Lifecycle$State r14 = r14.getCurrentState()
                    androidx.lifecycle.Lifecycle$State r0 = androidx.lifecycle.Lifecycle.State.DESTROYED
                    if (r14 != r0) goto L41
                    goto La4
                L41:
                    kotlin.jvm.internal.x r6 = new kotlin.jvm.internal.x
                    r6.<init>()
                    kotlin.jvm.internal.x r14 = new kotlin.jvm.internal.x
                    r14.<init>()
                    androidx.lifecycle.Lifecycle$State r0 = r13.$state     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.Lifecycle r12 = r13.$this_repeatOnLifecycle     // Catch: java.lang.Throwable -> La5
                    r7.w r7 = r13.$$this$coroutineScope     // Catch: java.lang.Throwable -> La5
                    g7.p r11 = r13.$block     // Catch: java.lang.Throwable -> La5
                    r13.L$0 = r6     // Catch: java.lang.Throwable -> La5
                    r13.L$1 = r14     // Catch: java.lang.Throwable -> La5
                    r13.L$2 = r0     // Catch: java.lang.Throwable -> La5
                    r13.L$3 = r12     // Catch: java.lang.Throwable -> La5
                    r13.L$4 = r7     // Catch: java.lang.Throwable -> La5
                    r13.L$5 = r11     // Catch: java.lang.Throwable -> La5
                    r13.label = r3     // Catch: java.lang.Throwable -> La5
                    r7.g r9 = new r7.g     // Catch: java.lang.Throwable -> La5
                    w6.c r4 = r0.f.F(r13)     // Catch: java.lang.Throwable -> La5
                    r9.<init>(r3, r4)     // Catch: java.lang.Throwable -> La5
                    r9.s()     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.Lifecycle$Event$Companion r3 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.Lifecycle$Event r5 = r3.upTo(r0)     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.Lifecycle$Event r8 = r3.downFrom(r0)     // Catch: java.lang.Throwable -> La5
                    a8.i r10 = a8.j.a()     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r4 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> La5
                    r4.<init>()     // Catch: java.lang.Throwable -> La5
                    r14.f10138a = r4     // Catch: java.lang.Throwable -> La5
                    r12.addObserver(r4)     // Catch: java.lang.Throwable -> La5
                    java.lang.Object r0 = r9.q()     // Catch: java.lang.Throwable -> La5
                    x6.a r3 = x6.a.f13718a
                    if (r0 != r3) goto L8e
                    return r3
                L8e:
                    r3 = r14
                    r4 = r6
                L90:
                    java.lang.Object r14 = r4.f10138a
                    r7.a1 r14 = (r7.a1) r14
                    if (r14 == 0) goto L99
                    r14.a(r1)
                L99:
                    java.lang.Object r14 = r3.f10138a
                    androidx.lifecycle.LifecycleEventObserver r14 = (androidx.lifecycle.LifecycleEventObserver) r14
                    if (r14 == 0) goto La4
                    androidx.lifecycle.Lifecycle r0 = r13.$this_repeatOnLifecycle
                    r0.removeObserver(r14)
                La4:
                    return r2
                La5:
                    r0 = move-exception
                    r3 = r14
                    r14 = r0
                    r4 = r6
                La9:
                    java.lang.Object r0 = r4.f10138a
                    r7.a1 r0 = (r7.a1) r0
                    if (r0 == 0) goto Lb2
                    r0.a(r1)
                Lb2:
                    java.lang.Object r0 = r3.f10138a
                    androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                    if (r0 == 0) goto Lbd
                    androidx.lifecycle.Lifecycle r1 = r13.$this_repeatOnLifecycle
                    r1.removeObserver(r0)
                Lbd:
                    throw r14
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Lifecycle lifecycle, Lifecycle.State state, p pVar, w6.c cVar) {
            super(2, cVar);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$block = pVar;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass3) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                w wVar = (w) this.L$0;
                y7.e eVar = i0.f12407a;
                s7.c cVar = n.f13548a.f12716c;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, wVar, this.$block, null);
                this.label = 1;
                Object objZ = y.z(anonymousClass1, cVar, this);
                x6.a aVar = x6.a.f13718a;
                if (objZ == aVar) {
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

    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, p pVar, w6.c cVar) {
        Object objG;
        if (state == Lifecycle.State.INITIALIZED) {
            com.google.gson.internal.a.n("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
            return null;
        }
        Lifecycle.State currentState = lifecycle.getCurrentState();
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        s6.w wVar = s6.w.f12711a;
        return (currentState != state2 && (objG = y.g(new AnonymousClass3(lifecycle, state, pVar, null), cVar)) == x6.a.f13718a) ? objG : wVar;
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, p pVar, w6.c cVar) {
        Object objRepeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, pVar, cVar);
        return objRepeatOnLifecycle == x6.a.f13718a ? objRepeatOnLifecycle : s6.w.f12711a;
    }
}
