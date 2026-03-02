package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class q extends d {
    private static final long serialVersionUID = -5207853542612002020L;

    /* renamed from: a, reason: collision with root package name */
    public final transient o f9183a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f9184b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f9185c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f9186d;

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final e s(j$.time.k kVar) {
        return new g(this, kVar);
    }

    public q(o oVar, int i10, int i11, int i12) {
        oVar.j(i10, i11, i12);
        this.f9183a = oVar;
        this.f9184b = i10;
        this.f9185c = i11;
        this.f9186d = i12;
    }

    public q(o oVar, long j10) {
        int i10 = (int) j10;
        oVar.f();
        if (i10 < oVar.e || i10 >= oVar.f) {
            throw new j$.time.b("Hijrah date out of range");
        }
        int iBinarySearch = Arrays.binarySearch(oVar.f9178d, i10);
        iBinarySearch = iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
        int i11 = oVar.g;
        int[] iArr = {(iBinarySearch + i11) / 12, ((i11 + iBinarySearch) % 12) + 1, (i10 - oVar.f9178d[iBinarySearch]) + 1};
        this.f9183a = oVar;
        this.f9184b = iArr[0];
        this.f9185c = iArr[1];
        this.f9186d = iArr[2];
    }

    @Override // j$.time.chrono.b
    public final l getChronology() {
        return this.f9183a;
    }

    @Override // j$.time.chrono.d
    public final m w() {
        return r.AH;
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
        int i10 = p.f9182a[aVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? this.f9183a.q(aVar) : j$.time.temporal.u.e(1L, 5L) : j$.time.temporal.u.e(1L, this.f9183a.v(this.f9184b, 12)) : j$.time.temporal.u.e(1L, this.f9183a.k(this.f9184b, this.f9185c));
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        switch (p.f9182a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f9186d;
            case 2:
                return C();
            case 3:
                return ((this.f9186d - 1) / 7) + 1;
            case 4:
                return ((int) j$.com.android.tools.r8.a.A(r() + 3, 7)) + 1;
            case 5:
                return ((this.f9186d - 1) % 7) + 1;
            case 6:
                return ((C() - 1) % 7) + 1;
            case 7:
                return r();
            case 8:
                return ((C() - 1) / 7) + 1;
            case 9:
                return this.f9185c;
            case 10:
                return ((this.f9184b * 12) + this.f9185c) - 1;
            case 11:
                return this.f9184b;
            case 12:
                return this.f9184b;
            case 13:
                return this.f9184b <= 1 ? 0 : 1;
            default:
                throw new j$.time.temporal.t(j$.time.c.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final q a(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (q) super.a(j10, qVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        this.f9183a.q(aVar).b(j10, aVar);
        int i10 = (int) j10;
        switch (p.f9182a[aVar.ordinal()]) {
            case 1:
                return F(this.f9184b, this.f9185c, i10);
            case 2:
                return y(Math.min(i10, this.f9183a.v(this.f9184b, 12)) - C());
            case 3:
                return y((j10 - q(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return y(j10 - (((int) j$.com.android.tools.r8.a.A(r() + 3, 7)) + 1));
            case 5:
                return y(j10 - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return y(j10 - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new q(this.f9183a, j10);
            case 8:
                return y((j10 - q(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return F(this.f9184b, i10, this.f9186d);
            case 10:
                return z(j10 - (((this.f9184b * 12) + this.f9185c) - 1));
            case 11:
                if (this.f9184b < 1) {
                    i10 = 1 - i10;
                }
                return F(i10, this.f9185c, this.f9186d);
            case 12:
                return F(i10, this.f9185c, this.f9186d);
            case 13:
                return F(1 - this.f9184b, this.f9185c, this.f9186d);
            default:
                throw new j$.time.temporal.t(j$.time.c.a("Unsupported field: ", qVar));
        }
    }

    public final q F(int i10, int i11, int i12) {
        int iK = this.f9183a.k(i10, i11);
        if (i12 > iK) {
            i12 = iK;
        }
        return new q(this.f9183a, i10, i11, i12);
    }

    @Override // j$.time.chrono.d
    /* renamed from: B */
    public final b f(j$.time.temporal.o oVar) {
        return (q) super.f(oVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m f(j$.time.h hVar) {
        return (q) super.f(hVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final long r() {
        return this.f9183a.j(this.f9184b, this.f9185c, this.f9186d);
    }

    public final int C() {
        return this.f9183a.v(this.f9184b, this.f9185c - 1) + this.f9186d;
    }

    @Override // j$.time.chrono.d
    public final b A(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = this.f9184b + ((int) j10);
        int i10 = (int) j11;
        if (j11 == i10) {
            return F(i10, this.f9185c, this.f9186d);
        }
        throw new ArithmeticException();
    }

    @Override // j$.time.chrono.d
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public final q z(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (this.f9184b * 12) + (this.f9185c - 1) + j10;
        o oVar = this.f9183a;
        long jB = j$.com.android.tools.r8.a.B(j11, 12L);
        int i10 = oVar.g;
        if (jB >= i10 / 12 && jB <= (((oVar.f9178d.length - 1) + i10) / 12) - 1) {
            return F((int) jB, ((int) j$.com.android.tools.r8.a.A(j11, 12L)) + 1, this.f9186d);
        }
        throw new j$.time.b("Invalid Hijrah year: " + jB);
    }

    @Override // j$.time.chrono.d
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final q y(long j10) {
        return new q(this.f9183a, r() + j10);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b b(long j10, j$.time.temporal.s sVar) {
        return (q) super.b(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m b(long j10, j$.time.temporal.s sVar) {
        return (q) super.b(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return (q) super.n(j10, bVar);
    }

    @Override // j$.time.chrono.d
    /* renamed from: x */
    public final b n(long j10, j$.time.temporal.s sVar) {
        return (q) super.n(j10, sVar);
    }

    @Override // j$.time.chrono.d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f9184b == qVar.f9184b && this.f9185c == qVar.f9185c && this.f9186d == qVar.f9186d && this.f9183a.equals(qVar.f9183a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        int i10 = this.f9184b;
        int i11 = this.f9185c;
        int i12 = this.f9186d;
        this.f9183a.getClass();
        return (((i10 << 11) + (i11 << 6)) + i12) ^ ((i10 & (-2048)) ^ 2100100019);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 6, this);
    }
}
