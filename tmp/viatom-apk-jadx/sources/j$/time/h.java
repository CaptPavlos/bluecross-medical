package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class h implements j$.time.temporal.m, j$.time.temporal.o, j$.time.chrono.b, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final h f9250d = D(-999999999, 1, 1);
    public static final h e = D(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* renamed from: a, reason: collision with root package name */
    public final int f9251a;

    /* renamed from: b, reason: collision with root package name */
    public final short f9252b;

    /* renamed from: c, reason: collision with root package name */
    public final short f9253c;

    static {
        D(1970, 1, 1);
    }

    public static h D(int i10, int i11, int i12) {
        j$.time.temporal.a.YEAR.k(i10);
        j$.time.temporal.a.MONTH_OF_YEAR.k(i11);
        j$.time.temporal.a.DAY_OF_MONTH.k(i12);
        return w(i10, i11, i12);
    }

    public static h E(long j10) {
        long j11;
        j$.time.temporal.a.EPOCH_DAY.k(j10);
        long j12 = 719468 + j10;
        if (j12 < 0) {
            long j13 = ((j10 + 719469) / 146097) - 1;
            j11 = j13 * 400;
            j12 += (-j13) * 146097;
        } else {
            j11 = 0;
        }
        long j14 = ((j12 * 400) + 591) / 146097;
        long j15 = j12 - ((j14 / 400) + (((j14 / 4) + (j14 * 365)) - (j14 / 100)));
        if (j15 < 0) {
            j14--;
            j15 = j12 - ((j14 / 400) + (((j14 / 4) + (365 * j14)) - (j14 / 100)));
        }
        int i10 = (int) j15;
        int i11 = ((i10 * 5) + 2) / 153;
        int i12 = ((i11 + 2) % 12) + 1;
        int i13 = (i10 - (((i11 * 306) + 5) / 10)) + 1;
        long j16 = j14 + j11 + (i11 / 10);
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new h(aVar.f9282b.a(j16, aVar), i12, i13);
    }

    public static h x(j$.time.temporal.n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        h hVar = (h) nVar.k(j$.time.temporal.r.f);
        if (hVar != null) {
            return hVar;
        }
        throw new b("Unable to obtain LocalDate from TemporalAccessor: " + nVar + " of type " + nVar.getClass().getName());
    }

    public static h w(int i10, int i11, int i12) {
        int i13 = 28;
        if (i12 > 28) {
            if (i11 != 2) {
                i13 = (i11 == 4 || i11 == 6 || i11 == 9 || i11 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.s.f9188c.getClass();
                if (j$.time.chrono.s.f(i10)) {
                    i13 = 29;
                }
            }
            if (i12 > i13) {
                if (i12 == 29) {
                    g.e("Invalid date 'February 29' as '", i10, "' is not a leap year");
                    return null;
                }
                throw new b("Invalid date '" + m.y(i11).name() + " " + i12 + "'");
            }
        }
        return new h(i10, i11, i12);
    }

    public static h J(int i10, int i11, int i12) {
        if (i11 == 2) {
            j$.time.chrono.s.f9188c.getClass();
            i12 = Math.min(i12, j$.time.chrono.s.f((long) i10) ? 29 : 28);
        } else if (i11 == 4 || i11 == 6 || i11 == 9 || i11 == 11) {
            i12 = Math.min(i12, 30);
        }
        return new h(i10, i11, i12);
    }

    public h(int i10, int i11, int i12) {
        this.f9251a = i10;
        this.f9252b = (short) i11;
        this.f9253c = (short) i12;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.n(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.f(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        if (!aVar.isDateBased()) {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        int i10 = f.f9206a[aVar.ordinal()];
        if (i10 == 1) {
            return j$.time.temporal.u.e(1L, C());
        }
        if (i10 == 2) {
            return j$.time.temporal.u.e(1L, B() ? 366 : 365);
        }
        if (i10 != 3) {
            return i10 != 4 ? aVar.f9282b : this.f9251a <= 0 ? j$.time.temporal.u.e(1L, C.NANOS_PER_SECOND) : j$.time.temporal.u.e(1L, 999999999L);
        }
        return j$.time.temporal.u.e(1L, (m.y(this.f9252b) != m.FEBRUARY || B()) ? 5L : 4L);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return y(qVar);
        }
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.EPOCH_DAY) {
                return r();
            }
            if (qVar != j$.time.temporal.a.PROLEPTIC_MONTH) {
                return y(qVar);
            }
            return ((this.f9251a * 12) + this.f9252b) - 1;
        }
        return qVar.g(this);
    }

    public final int y(j$.time.temporal.q qVar) {
        switch (f.f9206a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f9253c;
            case 2:
                return A();
            case 3:
                return ((this.f9253c - 1) / 7) + 1;
            case 4:
                int i10 = this.f9251a;
                return i10 >= 1 ? i10 : 1 - i10;
            case 5:
                return z().getValue();
            case 6:
                return ((this.f9253c - 1) % 7) + 1;
            case 7:
                return ((A() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.t("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((A() - 1) / 7) + 1;
            case 10:
                return this.f9252b;
            case 11:
                throw new j$.time.temporal.t("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.f9251a;
            case 13:
                return this.f9251a >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.l getChronology() {
        return j$.time.chrono.s.f9188c;
    }

    public final int A() {
        return (m.y(this.f9252b).v(B()) + this.f9253c) - 1;
    }

    public final d z() {
        return d.v(((int) j$.com.android.tools.r8.a.A(r() + 3, 7)) + 1);
    }

    public final boolean B() {
        j$.time.chrono.s sVar = j$.time.chrono.s.f9188c;
        long j10 = this.f9251a;
        sVar.getClass();
        return j$.time.chrono.s.f(j10);
    }

    public final int C() {
        short s9 = this.f9252b;
        return s9 != 2 ? (s9 == 4 || s9 == 6 || s9 == 9 || s9 == 11) ? 30 : 31 : B() ? 29 : 28;
    }

    @Override // j$.time.temporal.m
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public final h f(j$.time.temporal.o oVar) {
        if (oVar instanceof h) {
            return (h) oVar;
        }
        return (h) oVar.j(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final h a(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (h) qVar.j(this, j10);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j10);
        switch (f.f9206a[aVar.ordinal()]) {
            case 1:
                int i10 = (int) j10;
                if (this.f9253c != i10) {
                    return D(this.f9251a, this.f9252b, i10);
                }
                return this;
            case 2:
                return M((int) j10);
            case 3:
                return G(j$.com.android.tools.r8.a.w(j10 - q(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH), 7));
            case 4:
                if (this.f9251a < 1) {
                    j10 = 1 - j10;
                }
                return N((int) j10);
            case 5:
                return G(j10 - z().getValue());
            case 6:
                return G(j10 - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return G(j10 - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return E(j10);
            case 9:
                return G(j$.com.android.tools.r8.a.w(j10 - q(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR), 7));
            case 10:
                int i11 = (int) j10;
                if (this.f9252b != i11) {
                    j$.time.temporal.a.MONTH_OF_YEAR.k(i11);
                    return J(this.f9251a, i11, this.f9253c);
                }
                return this;
            case 11:
                return H(j10 - (((this.f9251a * 12) + this.f9252b) - 1));
            case 12:
                return N((int) j10);
            case 13:
                if (q(j$.time.temporal.a.ERA) != j10) {
                    return N(1 - this.f9251a);
                }
                return this;
            default:
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    public final h N(int i10) {
        if (this.f9251a == i10) {
            return this;
        }
        j$.time.temporal.a.YEAR.k(i10);
        return J(i10, this.f9252b, this.f9253c);
    }

    public final h M(int i10) {
        if (A() == i10) {
            return this;
        }
        int i11 = this.f9251a;
        long j10 = i11;
        j$.time.temporal.a.YEAR.k(j10);
        j$.time.temporal.a.DAY_OF_YEAR.k(i10);
        j$.time.chrono.s.f9188c.getClass();
        boolean zF = j$.time.chrono.s.f(j10);
        if (i10 == 366 && !zF) {
            g.e("Invalid date 'DayOfYear 366' as '", i11, "' is not a leap year");
            return null;
        }
        m mVarY = m.y(((i10 - 1) / 31) + 1);
        if (i10 > (mVarY.w(zF) + mVarY.v(zF)) - 1) {
            mVarY = m.f9262a[((((int) 1) + 12) + mVarY.ordinal()) % 12];
        }
        return new h(i11, mVarY.getValue(), (i10 - mVarY.v(zF)) + 1);
    }

    @Override // j$.time.temporal.m
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final h b(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (f.f9207b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return G(j10);
                case 2:
                    return G(j$.com.android.tools.r8.a.w(j10, 7));
                case 3:
                    return H(j10);
                case 4:
                    return I(j10);
                case 5:
                    return I(j$.com.android.tools.r8.a.w(j10, 10));
                case 6:
                    return I(j$.com.android.tools.r8.a.w(j10, 100));
                case 7:
                    return I(j$.com.android.tools.r8.a.w(j10, 1000));
                case 8:
                    j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                    return a(j$.com.android.tools.r8.a.x(q(aVar), j10), aVar);
                default:
                    g.b(sVar, "Unsupported unit: ");
                    return null;
            }
        }
        return (h) sVar.e(this, j10);
    }

    public final h I(long j10) {
        if (j10 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return J(aVar.f9282b.a(this.f9251a + j10, aVar), this.f9252b, this.f9253c);
    }

    public final h H(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = (this.f9251a * 12) + (this.f9252b - 1) + j10;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j12 = 12;
        return J(aVar.f9282b.a(j$.com.android.tools.r8.a.B(j11, j12), aVar), ((int) j$.com.android.tools.r8.a.A(j11, j12)) + 1, this.f9253c);
    }

    public final h G(long j10) {
        if (j10 == 0) {
            return this;
        }
        long j11 = this.f9253c + j10;
        if (j11 > 0) {
            if (j11 <= 28) {
                return new h(this.f9251a, this.f9252b, (int) j11);
            }
            if (j11 <= 59) {
                long jC = C();
                if (j11 <= jC) {
                    return new h(this.f9251a, this.f9252b, (int) j11);
                }
                short s9 = this.f9252b;
                if (s9 < 12) {
                    return new h(this.f9251a, s9 + 1, (int) (j11 - jC));
                }
                j$.time.temporal.a.YEAR.k(this.f9251a + 1);
                return new h(this.f9251a + 1, 1, (int) (j11 - jC));
            }
        }
        return E(j$.com.android.tools.r8.a.x(r(), j10));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j10, j$.time.temporal.b bVar) {
        return j10 == Long.MIN_VALUE ? b(Long.MAX_VALUE, bVar).b(1L, bVar) : b(-j10, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        return aVar == j$.time.temporal.r.f ? this : j$.com.android.tools.r8.a.p(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return j$.com.android.tools.r8.a.a(this, mVar);
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.e s(k kVar) {
        return LocalDateTime.y(this, kVar);
    }

    @Override // j$.time.chrono.b
    public final long r() {
        long j10 = this.f9251a;
        long j11 = this.f9252b;
        long j12 = 365 * j10;
        long j13 = (((367 * j11) - 362) / 12) + (j10 >= 0 ? ((j10 + 399) / 400) + (((3 + j10) / 4) - ((99 + j10) / 100)) + j12 : j12 - ((j10 / (-400)) + ((j10 / (-4)) - (j10 / (-100))))) + (this.f9253c - 1);
        if (j11 > 2) {
            j13 = !B() ? j13 - 2 : j13 - 1;
        }
        return j13 - 719528;
    }

    @Override // java.lang.Comparable
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.b bVar) {
        if (bVar instanceof h) {
            return v((h) bVar);
        }
        return j$.com.android.tools.r8.a.g(this, bVar);
    }

    public final int v(h hVar) {
        int i10 = this.f9251a - hVar.f9251a;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f9252b - hVar.f9252b;
        return i11 == 0 ? this.f9253c - hVar.f9253c : i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && v((h) obj) == 0;
    }

    @Override // j$.time.chrono.b
    public final int hashCode() {
        int i10 = this.f9251a;
        return (((i10 << 11) + (this.f9252b << 6)) + this.f9253c) ^ (i10 & (-2048));
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        int i10 = this.f9251a;
        short s9 = this.f9252b;
        short s10 = this.f9253c;
        int iAbs = Math.abs(i10);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i10 > 9999) {
                sb.append('+');
            }
            sb.append(i10);
        } else if (i10 < 0) {
            sb.append(i10 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i10 + 10000);
            sb.deleteCharAt(0);
        }
        sb.append(s9 < 10 ? "-0" : "-");
        sb.append((int) s9);
        sb.append(s10 < 10 ? "-0" : "-");
        sb.append((int) s10);
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
