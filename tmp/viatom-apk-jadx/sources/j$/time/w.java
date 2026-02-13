package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class w implements j$.time.temporal.m, j$.time.temporal.o, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f9312c = 0;
    private static final long serialVersionUID = 4183400860270640070L;

    /* renamed from: a, reason: collision with root package name */
    public final int f9313a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9314b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        w wVar = (w) obj;
        int i10 = this.f9313a - wVar.f9313a;
        return i10 == 0 ? this.f9314b - wVar.f9314b : i10;
    }

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.h(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.u.EXCEEDS_PAD);
        nVar.c('-');
        nVar.g(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        nVar.l(Locale.getDefault(), j$.time.format.t.SMART, null);
    }

    public w(int i10, int i11) {
        this.f9313a = i10;
        this.f9314b = i11;
    }

    public final w z(int i10, int i11) {
        return (this.f9313a == i10 && this.f9314b == i11) ? this : new w(i10, i11);
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.YEAR || qVar == j$.time.temporal.a.MONTH_OF_YEAR || qVar == j$.time.temporal.a.PROLEPTIC_MONTH || qVar == j$.time.temporal.a.YEAR_OF_ERA || qVar == j$.time.temporal.a.ERA : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.u.e(1L, this.f9313a <= 0 ? C.NANOS_PER_SECOND : 999999999L);
        }
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        return g(qVar).a(q(qVar), qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        int i10;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i11 = v.f9310a[((j$.time.temporal.a) qVar).ordinal()];
        if (i11 == 1) {
            i10 = this.f9314b;
        } else {
            if (i11 == 2) {
                return v();
            }
            if (i11 == 3) {
                int i12 = this.f9313a;
                if (i12 < 1) {
                    i12 = 1 - i12;
                }
                return i12;
            }
            if (i11 != 4) {
                if (i11 == 5) {
                    return this.f9313a < 1 ? 0 : 1;
                }
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
            }
            i10 = this.f9313a;
        }
        return i10;
    }

    public final long v() {
        return ((this.f9313a * 12) + this.f9314b) - 1;
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final w a(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (w) qVar.j(this, j10);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j10);
        int i10 = v.f9310a[aVar.ordinal()];
        if (i10 == 1) {
            int i11 = (int) j10;
            j$.time.temporal.a.MONTH_OF_YEAR.k(i11);
            return z(this.f9313a, i11);
        }
        if (i10 == 2) {
            return x(j10 - v());
        }
        if (i10 == 3) {
            if (this.f9313a < 1) {
                j10 = 1 - j10;
            }
            int i12 = (int) j10;
            j$.time.temporal.a.YEAR.k(i12);
            return z(i12, this.f9314b);
        }
        if (i10 == 4) {
            int i13 = (int) j10;
            j$.time.temporal.a.YEAR.k(i13);
            return z(i13, this.f9314b);
        }
        if (i10 != 5) {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        if (q(j$.time.temporal.a.ERA) == j10) {
            return this;
        }
        int i14 = 1 - this.f9313a;
        j$.time.temporal.a.YEAR.k(i14);
        return z(i14, this.f9314b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final w b(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (v.f9311b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return x(j10);
                case 2:
                    return y(j10);
                case 3:
                    return y(j$.com.android.tools.r8.a.w(j10, 10));
                case 4:
                    return y(j$.com.android.tools.r8.a.w(j10, 100));
                case 5:
                    return y(j$.com.android.tools.r8.a.w(j10, 1000));
                case 6:
                    j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                    return a(j$.com.android.tools.r8.a.x(q(aVar), j10), aVar);
                default:
                    g.b(sVar, "Unsupported unit: ");
                    return null;
            }
        }
        return (w) sVar.e(this, j10);
    }

    public final w y(long j10) {
        if (j10 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return z(aVar.f9282b.a(this.f9313a + j10, aVar), this.f9314b);
    }

    public final w x(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (this.f9313a * 12) + (this.f9314b - 1) + j10;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j12 = 12;
        return z(aVar.f9282b.a(j$.com.android.tools.r8.a.B(j11, j12), aVar), ((int) j$.com.android.tools.r8.a.A(j11, j12)) + 1);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return j10 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1L, bVar) : b(-j10, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f9301b) {
            return j$.time.chrono.s.f9188c;
        }
        if (aVar == j$.time.temporal.r.f9302c) {
            return j$.time.temporal.b.MONTHS;
        }
        return j$.time.temporal.r.c(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        if (!j$.com.android.tools.r8.a.v(mVar).equals(j$.time.chrono.s.f9188c)) {
            throw new b("Adjustment only supported on ISO date-time");
        }
        return mVar.a(v(), j$.time.temporal.a.PROLEPTIC_MONTH);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.f9313a == wVar.f9313a && this.f9314b == wVar.f9314b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9313a ^ (this.f9314b << 27);
    }

    public final String toString() {
        int iAbs = Math.abs(this.f9313a);
        StringBuilder sb = new StringBuilder(9);
        int i10 = this.f9313a;
        if (iAbs >= 1000) {
            sb.append(i10);
        } else if (i10 < 0) {
            sb.append(i10 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i10 + 10000);
            sb.deleteCharAt(0);
        }
        sb.append(this.f9314b < 10 ? "-0" : "-");
        sb.append(this.f9314b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 12, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return (w) j$.com.android.tools.r8.a.a(hVar, this);
    }
}
