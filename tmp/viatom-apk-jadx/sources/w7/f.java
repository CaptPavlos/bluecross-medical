package w7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import r7.g0;
import r7.n0;
import r7.r1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends g0 implements y6.d, w6.c {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final r7.s f13533d;
    public final w6.c e;
    public Object f;
    public final Object g;

    public f(r7.s sVar, w6.c cVar) {
        super(-1);
        this.f13533d = sVar;
        this.e = cVar;
        this.f = a.f13525b;
        this.g = a.k(cVar.getContext());
    }

    @Override // y6.d
    public final y6.d getCallerFrame() {
        w6.c cVar = this.e;
        if (cVar instanceof y6.d) {
            return (y6.d) cVar;
        }
        return null;
    }

    @Override // w6.c
    public final w6.h getContext() {
        return this.e.getContext();
    }

    @Override // r7.g0
    public final Object i() {
        Object obj = this.f;
        this.f = a.f13525b;
        return obj;
    }

    @Override // w6.c
    public final void resumeWith(Object obj) {
        Throwable thA = s6.k.a(obj);
        Object pVar = thA == null ? obj : new r7.p(false, thA);
        w6.c cVar = this.e;
        w6.h context = cVar.getContext();
        r7.s sVar = this.f13533d;
        if (sVar.isDispatchNeeded(context)) {
            this.f = pVar;
            this.f12400c = 0;
            sVar.dispatch(cVar.getContext(), this);
            return;
        }
        n0 n0VarA = r1.a();
        if (n0VarA.f12416a >= 4294967296L) {
            this.f = pVar;
            this.f12400c = 0;
            n0VarA.n(this);
            return;
        }
        n0VarA.o(true);
        try {
            w6.h context2 = cVar.getContext();
            Object objL = a.l(context2, this.g);
            try {
                cVar.resumeWith(obj);
                while (n0VarA.q()) {
                }
            } finally {
                a.g(context2, objL);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f13533d + ", " + r7.y.w(this.e) + ']';
    }

    @Override // r7.g0
    public final w6.c d() {
        return this;
    }
}
