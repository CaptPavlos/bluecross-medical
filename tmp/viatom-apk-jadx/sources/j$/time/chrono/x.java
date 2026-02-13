package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes2.dex */
public final class x extends d {

    /* renamed from: d, reason: collision with root package name */
    public static final j$.time.h f9193d = j$.time.h.D(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* renamed from: a, reason: collision with root package name */
    public final transient j$.time.h f9194a;

    /* renamed from: b, reason: collision with root package name */
    public final transient y f9195b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f9196c;

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final e s(j$.time.k kVar) {
        return new g(this, kVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x(j$.time.h r6) {
        /*
            r5 = this;
            r5.<init>()
            j$.time.h r0 = j$.time.chrono.x.f9193d
            boolean r1 = j$.time.c.b(r0)
            r2 = 1
            if (r1 == 0) goto L16
            r6.getClass()
            int r0 = r6.v(r0)
            if (r0 >= 0) goto L24
            goto L22
        L16:
            long r3 = r6.r()
            long r0 = r0.r()
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L24
        L22:
            r0 = r2
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 != 0) goto L3a
            j$.time.chrono.y r0 = j$.time.chrono.y.d(r6)
            r5.f9195b = r0
            int r1 = r6.f9251a
            j$.time.h r0 = r0.f9199b
            int r0 = r0.f9251a
            int r1 = r1 - r0
            int r1 = r1 + r2
            r5.f9196c = r1
            r5.f9194a = r6
            return
        L3a:
            j$.time.b r6 = new j$.time.b
            java.lang.String r0 = "JapaneseDate before Meiji 6 is not supported"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.<init>(j$.time.h):void");
    }

    @Override // j$.time.chrono.b
    public final l getChronology() {
        return v.f9191c;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        v.f9191c.getClass();
        return this.f9194a.hashCode() ^ (-688086063);
    }

    @Override // j$.time.chrono.d
    public final m w() {
        return this.f9195b;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).isDateBased();
        }
        return qVar != null && qVar.e(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    @Override // j$.time.chrono.d, j$.time.temporal.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.temporal.u g(j$.time.temporal.q r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof j$.time.temporal.a
            if (r0 == 0) goto L99
            boolean r0 = r5.c(r6)
            if (r0 == 0) goto L8d
            j$.time.temporal.a r6 = (j$.time.temporal.a) r6
            int[] r0 = j$.time.chrono.w.f9192a
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 1
            if (r0 == r1) goto L81
            r4 = 2
            if (r0 == r4) goto L48
            r4 = 3
            if (r0 == r4) goto L26
            j$.time.chrono.v r0 = j$.time.chrono.v.f9191c
            j$.time.temporal.u r6 = r0.f(r6)
            return r6
        L26:
            j$.time.chrono.y r6 = r5.f9195b
            j$.time.h r0 = r6.f9199b
            int r0 = r0.f9251a
            j$.time.chrono.y r6 = r6.i()
            if (r6 == 0) goto L3e
            j$.time.h r6 = r6.f9199b
            int r6 = r6.f9251a
            int r6 = r6 - r0
            int r6 = r6 + r1
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L3e:
            r6 = 999999999(0x3b9ac9ff, float:0.004723787)
            int r6 = r6 - r0
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L48:
            j$.time.chrono.y r6 = r5.f9195b
            j$.time.chrono.y r6 = r6.i()
            if (r6 == 0) goto L60
            j$.time.h r6 = r6.f9199b
            int r0 = r6.f9251a
            j$.time.h r4 = r5.f9194a
            int r4 = r4.f9251a
            if (r0 != r4) goto L60
            int r6 = r6.A()
            int r6 = r6 - r1
            goto L6d
        L60:
            j$.time.h r6 = r5.f9194a
            boolean r6 = r6.B()
            if (r6 == 0) goto L6b
            r6 = 366(0x16e, float:5.13E-43)
            goto L6d
        L6b:
            r6 = 365(0x16d, float:5.11E-43)
        L6d:
            int r0 = r5.f9196c
            if (r0 != r1) goto L7b
            j$.time.chrono.y r0 = r5.f9195b
            j$.time.h r0 = r0.f9199b
            int r0 = r0.A()
            int r0 = r0 - r1
            int r6 = r6 - r0
        L7b:
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L81:
            j$.time.h r6 = r5.f9194a
            int r6 = r6.C()
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L8d:
            j$.time.temporal.t r0 = new j$.time.temporal.t
            java.lang.String r1 = "Unsupported field: "
            java.lang.String r6 = j$.time.c.a(r1, r6)
            r0.<init>(r6)
            throw r0
        L99:
            j$.time.temporal.u r6 = r6.f(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.g(j$.time.temporal.q):j$.time.temporal.u");
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        switch (w.f9192a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 2:
                int i10 = this.f9196c;
                j$.time.h hVar = this.f9194a;
                return i10 == 1 ? (hVar.A() - this.f9195b.f9199b.A()) + 1 : hVar.A();
            case 3:
                return this.f9196c;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new j$.time.temporal.t(j$.time.c.a("Unsupported field: ", qVar));
            case 8:
                return this.f9195b.f9198a;
            default:
                return this.f9194a.q(qVar);
        }
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public final x a(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            if (q(aVar) == j10) {
                return this;
            }
            int[] iArr = w.f9192a;
            int i10 = iArr[aVar.ordinal()];
            if (i10 == 3 || i10 == 8 || i10 == 9) {
                int iA = v.f9191c.f(aVar).a(j10, aVar);
                int i11 = iArr[aVar.ordinal()];
                if (i11 == 3) {
                    return E(this.f9195b, iA);
                }
                if (i11 == 8) {
                    return E(y.l(iA), this.f9196c);
                }
                if (i11 == 9) {
                    return D(this.f9194a.N(iA));
                }
            }
            return D(this.f9194a.a(j10, qVar));
        }
        return (x) super.a(j10, qVar);
    }

    @Override // j$.time.chrono.d
    /* renamed from: B */
    public final b f(j$.time.temporal.o oVar) {
        return (x) super.f(oVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m f(j$.time.h hVar) {
        return (x) super.f(hVar);
    }

    public final x E(y yVar, int i10) {
        v.f9191c.getClass();
        if (yVar == null) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int i11 = yVar.f9199b.f9251a;
        int i12 = (i11 + i10) - 1;
        if (i10 != 1 && (i12 < -999999999 || i12 > 999999999 || i12 < i11 || yVar != y.d(j$.time.h.D(i12, 1, 1)))) {
            throw new j$.time.b("Invalid yearOfEra value");
        }
        return D(this.f9194a.N(i12));
    }

    @Override // j$.time.chrono.d
    public final b A(long j10) {
        return D(this.f9194a.I(j10));
    }

    @Override // j$.time.chrono.d
    public final b z(long j10) {
        return D(this.f9194a.H(j10));
    }

    @Override // j$.time.chrono.d
    public final b y(long j10) {
        return D(this.f9194a.G(j10));
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b b(long j10, j$.time.temporal.s sVar) {
        return (x) super.b(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m b(long j10, j$.time.temporal.s sVar) {
        return (x) super.b(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return (x) super.n(j10, bVar);
    }

    @Override // j$.time.chrono.d
    /* renamed from: x */
    public final b n(long j10, j$.time.temporal.s sVar) {
        return (x) super.n(j10, sVar);
    }

    public final x D(j$.time.h hVar) {
        return hVar.equals(this.f9194a) ? this : new x(hVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final long r() {
        return this.f9194a.r();
    }

    @Override // j$.time.chrono.d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f9194a.equals(((x) obj).f9194a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 4, this);
    }
}
