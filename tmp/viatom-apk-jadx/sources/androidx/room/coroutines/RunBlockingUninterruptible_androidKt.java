package androidx.room.coroutines;

import g7.p;
import r7.i0;
import r7.l;
import r7.m;
import r7.o1;
import r7.w;
import r7.x;
import r7.y;
import s6.j;
import s6.k;
import w6.c;
import w6.d;
import w6.f;
import w6.h;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RunBlockingUninterruptible_androidKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1", f = "RunBlockingUninterruptible.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ p $block;
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @e(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1", f = "RunBlockingUninterruptible.android.kt", l = {52}, m = "invokeSuspend")
        /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00161 extends i implements p {
            final /* synthetic */ p $block;
            final /* synthetic */ l $deferred;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00161(l lVar, p pVar, c cVar) {
                super(2, cVar);
                this.$deferred = lVar;
                this.$block = pVar;
            }

            @Override // y6.a
            public final c create(Object obj, c cVar) {
                C00161 c00161 = new C00161(this.$deferred, this.$block, cVar);
                c00161.L$0 = obj;
                return c00161;
            }

            @Override // g7.p
            public final Object invoke(w wVar, c cVar) {
                return ((C00161) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v0, types: [int] */
            /* JADX WARN: Type inference failed for: r0v1 */
            /* JADX WARN: Type inference failed for: r0v2 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            @Override // y6.a
            public final Object invokeSuspend(Object obj) {
                ?? r02 = this.label;
                try {
                    if (r02 == 0) {
                        s6.a.e(obj);
                        w wVar = (w) this.L$0;
                        l lVar = this.$deferred;
                        p pVar = this.$block;
                        this.L$0 = lVar;
                        this.label = 1;
                        obj = pVar.invoke(wVar, this);
                        x6.a aVar = x6.a.f13718a;
                        r02 = lVar;
                        if (obj == aVar) {
                            return aVar;
                        }
                    } else {
                        if (r02 != 1) {
                            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        l lVar2 = (l) this.L$0;
                        s6.a.e(obj);
                        r02 = lVar2;
                    }
                } catch (Throwable th) {
                    obj = new j(th);
                }
                Throwable thA = k.a(obj);
                m mVar = (m) r02;
                if (thA == null) {
                    mVar.P(obj);
                } else {
                    mVar.getClass();
                    mVar.P(new r7.p(false, thA));
                }
                return s6.w.f12711a;
            }
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @e(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2", f = "RunBlockingUninterruptible.android.kt", l = {58}, m = "invokeSuspend")
        /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends i implements p {
            final /* synthetic */ l $deferred;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(l lVar, c cVar) {
                super(2, cVar);
                this.$deferred = lVar;
            }

            @Override // y6.a
            public final c create(Object obj, c cVar) {
                return new AnonymousClass2(this.$deferred, cVar);
            }

            @Override // g7.p
            public final Object invoke(w wVar, c cVar) {
                return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            }

            @Override // y6.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                l lVar = this.$deferred;
                this.label = 1;
                Object objV = ((m) lVar).v(this);
                x6.a aVar = x6.a.f13718a;
                return objV == aVar ? aVar : objV;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(p pVar, c cVar) {
            super(2, cVar);
            this.$block = pVar;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // g7.p
        public final Object invoke(w wVar, c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            h coroutineContext = ((w) this.L$0).getCoroutineContext();
            d dVar = d.f13522a;
            f fVar = coroutineContext.get(dVar);
            fVar.getClass();
            w6.e eVar = (w6.e) fVar;
            m mVar = new m(true);
            mVar.L(null);
            C00161 c00161 = new C00161(mVar, this.$block, null);
            h hVarJ = y.j(w6.i.f13523a, eVar, true);
            y7.e eVar2 = i0.f12407a;
            if (hVarJ != eVar2 && hVarJ.get(dVar) == null) {
                hVarJ = hVarJ.plus(eVar2);
            }
            r7.a o1Var = new o1(hVarJ, true);
            o1Var.e0(x.f12448d, o1Var, c00161);
            while (!mVar.N()) {
                try {
                    return y.u(eVar, new AnonymousClass2(mVar, null));
                } catch (InterruptedException unused) {
                }
            }
            return mVar.E();
        }
    }

    public static final <T> T runBlockingUninterruptible(p pVar) {
        pVar.getClass();
        Thread.interrupted();
        return (T) y.u(w6.i.f13523a, new AnonymousClass1(pVar, null));
    }
}
