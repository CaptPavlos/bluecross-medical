package t7;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends w7.s {
    public final e e;
    public final /* synthetic */ AtomicReferenceArray f;

    public m(long j10, m mVar, e eVar, int i10) {
        super(j10, mVar, i10);
        this.e = eVar;
        this.f = new AtomicReferenceArray(g.f12834b * 2);
    }

    @Override // w7.s
    public final int f() {
        return g.f12834b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0047, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004a, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004c, code lost:
    
        r2.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // w7.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r5, w6.h r6) {
        /*
            r4 = this;
            int r6 = t7.g.f12834b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.k(r5)
            boolean r1 = r6 instanceof r7.x1
            t7.e r2 = r4.e
            r3 = 0
            if (r1 != 0) goto L50
            boolean r1 = r6 instanceof t7.v
            if (r1 == 0) goto L21
            goto L50
        L21:
            e2.a r1 = t7.g.f12838j
            if (r6 == r1) goto L47
            e2.a r1 = t7.g.f12839k
            if (r6 != r1) goto L2a
            goto L47
        L2a:
            e2.a r1 = t7.g.g
            if (r6 == r1) goto L11
            e2.a r1 = t7.g.f
            if (r6 != r1) goto L33
            goto L11
        L33:
            e2.a r5 = t7.g.f12837i
            if (r6 == r5) goto L6a
            e2.a r5 = t7.g.f12836d
            if (r6 != r5) goto L3c
            goto L6a
        L3c:
            e2.a r5 = t7.g.f12840l
            if (r6 != r5) goto L41
            goto L6a
        L41:
            java.lang.String r5 = "unexpected state: "
            p8.u.i(r6, r5)
            return
        L47:
            r4.m(r5, r3)
            if (r0 == 0) goto L6a
            r2.getClass()
            return
        L50:
            if (r0 == 0) goto L55
            e2.a r1 = t7.g.f12838j
            goto L57
        L55:
            e2.a r1 = t7.g.f12839k
        L57:
            boolean r6 = r4.j(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L6a
            r2.getClass()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.m.g(int, w6.h):void");
    }

    public final boolean j(int i10, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i11 = (i10 * 2) + 1;
        do {
            atomicReferenceArray = this.f;
            if (atomicReferenceArray.compareAndSet(i11, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i11) == obj);
        return false;
    }

    public final Object k(int i10) {
        return this.f.get((i10 * 2) + 1);
    }

    public final void l(int i10, boolean z9) {
        if (z9) {
            e eVar = this.e;
            eVar.getClass();
            eVar.J((this.f13555c * g.f12834b) + i10);
        }
        h();
    }

    public final void m(int i10, Object obj) {
        this.f.set(i10 * 2, obj);
    }

    public final void n(int i10, Object obj) {
        this.f.set((i10 * 2) + 1, obj);
    }
}
