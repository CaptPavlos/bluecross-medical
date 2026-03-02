package t7;

import kotlin.jvm.internal.y;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends e {

    /* renamed from: k, reason: collision with root package name */
    public final a f12854k;

    public o(int i10, a aVar) {
        super(i10);
        this.f12854k = aVar;
        if (aVar == a.f12813a) {
            androidx.core.view.accessibility.a.t(y.a(e.class).c(), "This implementation does not support suspension for senders, use ", " instead");
            throw null;
        }
        if (i10 >= 1) {
            return;
        }
        z8.f.b(a3.a.g(i10, "Buffered channel capacity must be at least 1, but ", " was specified"));
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b5, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            t7.a r1 = r15.f12854k
            t7.a r2 = t7.a.f12815c
            s6.w r8 = s6.w.f12711a
            if (r1 != r2) goto L17
            java.lang.Object r1 = super.q(r16)
            boolean r2 = r1 instanceof t7.k
            if (r2 == 0) goto L16
            boolean r2 = r1 instanceof t7.j
            if (r2 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r1
        L17:
            e2.a r6 = t7.g.f12836d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = t7.e.f
            java.lang.Object r1 = r1.get(r15)
            t7.m r1 = (t7.m) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = t7.e.f12826b
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.v(r2, r7)
            int r9 = t7.g.f12834b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f13555c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            t7.m r2 = t7.e.b(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r1 = r15.s()
            t7.j r2 = new t7.j
            r2.<init>(r1)
            return r2
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = t7.e.d(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb6
            r3 = 1
            if (r12 == r3) goto Lb5
            r3 = 2
            if (r12 == r3) goto L8f
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.a()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = t7.e.f12827c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.a()
        L7e:
            java.lang.Throwable r1 = r15.s()
            t7.j r2 = new t7.j
            r2.<init>(r1)
            return r2
        L88:
            java.lang.String r1 = "unexpected"
            androidx.window.layout.c.g(r1)
            r1 = 0
            return r1
        L8f:
            if (r7 == 0) goto L9e
            r1.h()
            java.lang.Throwable r1 = r15.s()
            t7.j r2 = new t7.j
            r2.<init>(r1)
            return r2
        L9e:
            boolean r3 = r6 instanceof r7.x1
            if (r3 == 0) goto La5
            r7.x1 r6 = (r7.x1) r6
            goto La6
        La5:
            r6 = 0
        La6:
            if (r6 == 0) goto Lad
            int r12 = r2 + r9
            r6.a(r1, r12)
        Lad:
            long r3 = r1.f13555c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.i(r3)
        Lb5:
            return r8
        Lb6:
            r1.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.o.K(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // t7.e, t7.u
    public final Object l(Object obj, w6.c cVar) throws Throwable {
        if (K(obj, true) instanceof j) {
            throw s();
        }
        return w.f12711a;
    }

    @Override // t7.e, t7.u
    public final Object q(Object obj) {
        return K(obj, false);
    }

    @Override // t7.e
    public final boolean y() {
        return this.f12854k == a.f12814b;
    }
}
