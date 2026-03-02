package androidx.datastore.core;

import g7.l;
import g7.p;
import h1.b;
import kotlin.jvm.internal.m;
import r0.f;
import r7.a1;
import r7.t;
import r7.w;
import r7.y;
import t7.i;
import t7.j;
import t7.k;
import w6.c;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SimpleActor<T> {
    private final p consumeMessage;
    private final i messageQueue;
    private final AtomicInt remainingMessages;
    private final w scope;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {androidx.constraintlayout.widget.R.styleable.ConstraintSet_transitionEasing, androidx.constraintlayout.widget.R.styleable.ConstraintSet_transitionEasing}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.SimpleActor$offer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends y6.i implements p {
        Object L$0;
        int label;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SimpleActor<T> simpleActor, c cVar) {
            super(2, cVar);
            this.this$0 = simpleActor;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass2(this.this$0, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            if (r0.invoke(r6, r5) != r3) goto L19;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[PHI: r0 r6
          0x0052: PHI (r0v1 g7.p) = (r0v2 g7.p), (r0v4 g7.p) binds: [B:14:0x004f, B:10:0x0017] A[DONT_GENERATE, DONT_INLINE]
          0x0052: PHI (r6v6 java.lang.Object) = (r6v14 java.lang.Object), (r6v0 java.lang.Object) binds: [B:14:0x004f, B:10:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005b -> B:19:0x005e). Please report as a decompilation issue!!! */
        @Override // y6.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                int r0 = r5.label
                r1 = 2
                r2 = 1
                x6.a r3 = x6.a.f13718a
                if (r0 == 0) goto L1f
                if (r0 == r2) goto L17
                if (r0 != r1) goto L10
                s6.a.e(r6)
                goto L5e
            L10:
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                androidx.window.layout.c.g(r6)
            L15:
                r6 = 0
                return r6
            L17:
                java.lang.Object r0 = r5.L$0
                g7.p r0 = (g7.p) r0
                s6.a.e(r6)
                goto L52
            L1f:
                s6.a.e(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
                int r6 = r6.get()
                if (r6 <= 0) goto L6d
            L2e:
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                r7.w r6 = androidx.datastore.core.SimpleActor.access$getScope$p(r6)
                w6.h r6 = r6.getCoroutineContext()
                r7.y.i(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                g7.p r0 = androidx.datastore.core.SimpleActor.access$getConsumeMessage$p(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                t7.i r6 = androidx.datastore.core.SimpleActor.access$getMessageQueue$p(r6)
                r5.L$0 = r0
                r5.label = r2
                java.lang.Object r6 = r6.p(r5)
                if (r6 != r3) goto L52
                goto L5d
            L52:
                r4 = 0
                r5.L$0 = r4
                r5.label = r1
                java.lang.Object r6 = r0.invoke(r6, r5)
                if (r6 != r3) goto L5e
            L5d:
                return r3
            L5e:
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
                int r6 = r6.decrementAndGet()
                if (r6 != 0) goto L2e
                s6.w r6 = s6.w.f12711a
                return r6
            L6d:
                java.lang.String r6 = "Check failed."
                androidx.window.layout.c.g(r6)
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SimpleActor(w wVar, l lVar, p pVar, p pVar2) {
        wVar.getClass();
        lVar.getClass();
        pVar.getClass();
        pVar2.getClass();
        this.scope = wVar;
        this.consumeMessage = pVar2;
        this.messageQueue = f.a(Integer.MAX_VALUE, null, 6);
        this.remainingMessages = new AtomicInt(0);
        a1 a1Var = (a1) wVar.getCoroutineContext().get(t.f12437b);
        if (a1Var != null) {
            a1Var.s(new AnonymousClass1(lVar, this, pVar));
        }
    }

    public final void offer(T t) {
        Object objQ = this.messageQueue.q(t);
        if (objQ instanceof j) {
            Throwable th = ((j) objQ).f12851a;
            if (th != null) {
                throw th;
            }
            throw new b("Channel was closed normally");
        }
        if (objQ instanceof k) {
            androidx.window.layout.c.g("Check failed.");
        } else if (this.remainingMessages.getAndIncrement() == 0) {
            y.q(this.scope, null, null, new AnonymousClass2(this, null), 3);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.core.SimpleActor$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements l {
        final /* synthetic */ l $onComplete;
        final /* synthetic */ p $onUndeliveredElement;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(l lVar, SimpleActor<T> simpleActor, p pVar) {
            super(1);
            this.$onComplete = lVar;
            this.this$0 = simpleActor;
            this.$onUndeliveredElement = pVar;
        }

        public final void invoke(Throwable th) {
            s6.w wVar;
            this.$onComplete.invoke(th);
            ((SimpleActor) this.this$0).messageQueue.k(th);
            do {
                Object objG = ((SimpleActor) this.this$0).messageQueue.g();
                wVar = null;
                if (objG instanceof k) {
                    objG = null;
                }
                if (objG != null) {
                    this.$onUndeliveredElement.invoke(objG, th);
                    wVar = s6.w.f12711a;
                }
            } while (wVar != null);
        }

        @Override // g7.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return s6.w.f12711a;
        }
    }
}
