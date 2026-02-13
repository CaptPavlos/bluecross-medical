package j$.time.chrono;

import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes2.dex */
public final class c0 extends d {
    private static final long serialVersionUID = 1300372329181994526L;

    /* renamed from: a, reason: collision with root package name */
    public final transient j$.time.h f9154a;

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final e s(j$.time.k kVar) {
        return new g(this, kVar);
    }

    public c0(j$.time.h hVar) {
        Objects.requireNonNull(hVar, "isoDate");
        this.f9154a = hVar;
    }

    @Override // j$.time.chrono.b
    public final l getChronology() {
        return a0.f9151c;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        a0.f9151c.getClass();
        return this.f9154a.hashCode() ^ (-1990173233);
    }

    @Override // j$.time.chrono.d
    public final m w() {
        return C() >= 1 ? d0.ROC : d0.BEFORE_ROC;
    }

    @Override // j$.time.chrono.d, j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.f(this);
        }
        if (!j$.com.android.tools.r8.a.n(this, qVar)) {
            throw new j$.time.temporal.t(j$.time.c.a("Unsupported field: ", qVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i10 = b0.f9152a[aVar.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return this.f9154a.g(qVar);
        }
        if (i10 != 4) {
            return a0.f9151c.f(aVar);
        }
        j$.time.temporal.u uVar = j$.time.temporal.a.YEAR.f9282b;
        return j$.time.temporal.u.e(1L, C() <= 0 ? (-uVar.f9304a) + 1912 : uVar.f9307d - 1911);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = b0.f9152a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 4) {
                int iC = C();
                if (iC < 1) {
                    iC = 1 - iC;
                }
                return iC;
            }
            if (i10 == 5) {
                return ((C() * 12) + this.f9154a.f9252b) - 1;
            }
            if (i10 == 6) {
                return C();
            }
            if (i10 != 7) {
                return this.f9154a.q(qVar);
            }
            return C() < 1 ? 0 : 1;
        }
        return qVar.g(this);
    }

    public final int C() {
        return this.f9154a.f9251a - 1911;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.chrono.c0 a(long r8, j$.time.temporal.q r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof j$.time.temporal.a
            if (r0 == 0) goto L9f
            r0 = r10
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r7.q(r0)
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 != 0) goto L10
            return r7
        L10:
            int[] r1 = j$.time.chrono.b0.f9152a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L49
            r6 = 5
            if (r2 == r6) goto L25
            if (r2 == r4) goto L49
            if (r2 == r3) goto L49
            goto L5f
        L25:
            j$.time.chrono.a0 r10 = j$.time.chrono.a0.f9151c
            j$.time.temporal.u r10 = r10.f(r0)
            r10.b(r8, r0)
            int r10 = r7.C()
            long r0 = (long) r10
            r2 = 12
            long r0 = r0 * r2
            j$.time.h r10 = r7.f9154a
            short r2 = r10.f9252b
            long r2 = (long) r2
            long r0 = r0 + r2
            r2 = 1
            long r0 = r0 - r2
            long r8 = r8 - r0
            j$.time.h r8 = r10.H(r8)
            j$.time.chrono.c0 r8 = r7.E(r8)
            return r8
        L49:
            j$.time.chrono.a0 r2 = j$.time.chrono.a0.f9151c
            j$.time.temporal.u r2 = r2.f(r0)
            int r2 = r2.a(r8, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L88
            if (r0 == r4) goto L7b
            if (r0 == r3) goto L6a
        L5f:
            j$.time.h r0 = r7.f9154a
            j$.time.h r8 = r0.a(r8, r10)
            j$.time.chrono.c0 r8 = r7.E(r8)
            return r8
        L6a:
            j$.time.h r8 = r7.f9154a
            int r9 = r7.C()
            int r9 = 1912 - r9
            j$.time.h r8 = r8.N(r9)
            j$.time.chrono.c0 r8 = r7.E(r8)
            return r8
        L7b:
            j$.time.h r8 = r7.f9154a
            int r2 = r2 + 1911
            j$.time.h r8 = r8.N(r2)
            j$.time.chrono.c0 r8 = r7.E(r8)
            return r8
        L88:
            j$.time.h r8 = r7.f9154a
            int r9 = r7.C()
            r10 = 1
            if (r9 < r10) goto L94
            int r2 = r2 + 1911
            goto L96
        L94:
            int r2 = 1912 - r2
        L96:
            j$.time.h r8 = r8.N(r2)
            j$.time.chrono.c0 r8 = r7.E(r8)
            return r8
        L9f:
            j$.time.chrono.b r8 = super.a(r8, r10)
            j$.time.chrono.c0 r8 = (j$.time.chrono.c0) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.c0.a(long, j$.time.temporal.q):j$.time.chrono.c0");
    }

    @Override // j$.time.chrono.d
    /* renamed from: B */
    public final b f(j$.time.temporal.o oVar) {
        return (c0) super.f(oVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m f(j$.time.h hVar) {
        return (c0) super.f(hVar);
    }

    @Override // j$.time.chrono.d
    public final b A(long j10) {
        return E(this.f9154a.I(j10));
    }

    @Override // j$.time.chrono.d
    public final b z(long j10) {
        return E(this.f9154a.H(j10));
    }

    @Override // j$.time.chrono.d
    public final b y(long j10) {
        return E(this.f9154a.G(j10));
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b b(long j10, j$.time.temporal.s sVar) {
        return (c0) super.b(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m b(long j10, j$.time.temporal.s sVar) {
        return (c0) super.b(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return (c0) super.n(j10, bVar);
    }

    @Override // j$.time.chrono.d
    /* renamed from: x */
    public final b n(long j10, j$.time.temporal.s sVar) {
        return (c0) super.n(j10, sVar);
    }

    public final c0 E(j$.time.h hVar) {
        return hVar.equals(this.f9154a) ? this : new c0(hVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final long r() {
        return this.f9154a.r();
    }

    @Override // j$.time.chrono.d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            return this.f9154a.equals(((c0) obj).f9154a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 7, this);
    }
}
