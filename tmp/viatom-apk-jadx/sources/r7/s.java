package r7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class s extends w6.a implements w6.e {
    public static final r Key = new r(w6.d.f13522a, new q(0));

    public s() {
        super(w6.d.f13522a);
    }

    public static /* synthetic */ s limitedParallelism$default(s sVar, int i10, String str, int i11, Object obj) {
        if (obj != null) {
            a2.a.m("Super calls with default arguments not supported in this target, function: limitedParallelism");
            return null;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        return sVar.limitedParallelism(i10, str);
    }

    public abstract void dispatch(w6.h hVar, Runnable runnable);

    public void dispatchYield(w6.h hVar, Runnable runnable) {
        dispatch(hVar, runnable);
    }

    @Override // w6.a, w6.h
    public <E extends w6.f> E get(w6.g gVar) {
        E e;
        gVar.getClass();
        if (!(gVar instanceof r)) {
            if (w6.d.f13522a == gVar) {
                return this;
            }
            return null;
        }
        r rVar = (r) gVar;
        w6.g key = getKey();
        key.getClass();
        if ((key == rVar || rVar.f12432b == key) && (e = (E) rVar.f12431a.invoke(this)) != null) {
            return e;
        }
        return null;
    }

    @Override // w6.e
    public final <T> w6.c interceptContinuation(w6.c cVar) {
        return new w7.f(this, cVar);
    }

    public boolean isDispatchNeeded(w6.h hVar) {
        return !(this instanceof u1);
    }

    public s limitedParallelism(int i10, String str) {
        w7.a.a(i10);
        return new w7.g(this, i10, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (((w6.f) r3.f12431a.invoke(r2)) == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        if (w6.d.f13522a == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        return w6.i.f13523a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        return r2;
     */
    @Override // w6.a, w6.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public w6.h minusKey(w6.g r3) {
        /*
            r2 = this;
            r3.getClass()
            boolean r0 = r3 instanceof r7.r
            if (r0 == 0) goto L23
            r7.r r3 = (r7.r) r3
            w6.g r0 = r2.getKey()
            r0.getClass()
            if (r0 == r3) goto L18
            w6.g r1 = r3.f12432b
            if (r1 != r0) goto L17
            goto L18
        L17:
            return r2
        L18:
            g7.l r3 = r3.f12431a
            java.lang.Object r3 = r3.invoke(r2)
            w6.f r3 = (w6.f) r3
            if (r3 == 0) goto L2a
            goto L27
        L23:
            w6.d r0 = w6.d.f13522a
            if (r0 != r3) goto L2a
        L27:
            w6.i r3 = w6.i.f13523a
            return r3
        L2a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.s.minusKey(w6.g):w6.h");
    }

    @Override // w6.e
    public final void releaseInterceptedContinuation(w6.c cVar) {
        cVar.getClass();
        w7.f fVar = (w7.f) cVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = w7.f.h;
        while (atomicReferenceFieldUpdater.get(fVar) == w7.a.f13526c) {
        }
        Object obj = atomicReferenceFieldUpdater.get(fVar);
        g gVar = obj instanceof g ? (g) obj : null;
        if (gVar != null) {
            gVar.m();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + y.m(this);
    }

    public /* synthetic */ s limitedParallelism(int i10) {
        return limitedParallelism(i10, null);
    }

    public final s plus(s sVar) {
        return sVar;
    }
}
