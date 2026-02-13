package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class u implements j$.time.temporal.m, j$.time.temporal.o, Comparable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f9308b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* renamed from: a, reason: collision with root package name */
    public final int f9309a;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f9309a - ((u) obj).f9309a;
    }

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.h(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.u.EXCEEDS_PAD);
        nVar.l(Locale.getDefault(), j$.time.format.t.SMART, null);
    }

    public static u v(int i10) {
        j$.time.temporal.a.YEAR.k(i10);
        return new u(i10);
    }

    public u(int i10) {
        this.f9309a = i10;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.YEAR || qVar == j$.time.temporal.a.YEAR_OF_ERA || qVar == j$.time.temporal.a.ERA : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.u.e(1L, this.f9309a <= 0 ? C.NANOS_PER_SECOND : 999999999L);
        }
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        return g(qVar).a(q(qVar), qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i10 = t.f9278a[((j$.time.temporal.a) qVar).ordinal()];
        if (i10 == 1) {
            int i11 = this.f9309a;
            if (i11 < 1) {
                i11 = 1 - i11;
            }
            return i11;
        }
        if (i10 == 2) {
            return this.f9309a;
        }
        if (i10 == 3) {
            return this.f9309a < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
    }

    @Override // j$.time.temporal.m
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final u a(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (u) qVar.j(this, j10);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j10);
        int i10 = t.f9278a[aVar.ordinal()];
        if (i10 == 1) {
            if (this.f9309a < 1) {
                j10 = 1 - j10;
            }
            return v((int) j10);
        }
        if (i10 == 2) {
            return v((int) j10);
        }
        if (i10 == 3) {
            return q(j$.time.temporal.a.ERA) == j10 ? this : v(1 - this.f9309a);
        }
        throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final u b(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            int i10 = t.f9279b[((j$.time.temporal.b) sVar).ordinal()];
            if (i10 == 1) {
                return x(j10);
            }
            if (i10 == 2) {
                return x(j$.com.android.tools.r8.a.w(j10, 10));
            }
            if (i10 == 3) {
                return x(j$.com.android.tools.r8.a.w(j10, 100));
            }
            if (i10 == 4) {
                return x(j$.com.android.tools.r8.a.w(j10, 1000));
            }
            if (i10 == 5) {
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return a(j$.com.android.tools.r8.a.x(q(aVar), j10), aVar);
            }
            g.b(sVar, "Unsupported unit: ");
            return null;
        }
        return (u) sVar.e(this, j10);
    }

    public final u x(long j10) {
        if (j10 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return v(aVar.f9282b.a(this.f9309a + j10, aVar));
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
            return j$.time.temporal.b.YEARS;
        }
        return j$.time.temporal.r.c(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        if (!j$.com.android.tools.r8.a.v(mVar).equals(j$.time.chrono.s.f9188c)) {
            throw new b("Adjustment only supported on ISO date-time");
        }
        return mVar.a(this.f9309a, j$.time.temporal.a.YEAR);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && this.f9309a == ((u) obj).f9309a;
    }

    public final int hashCode() {
        return this.f9309a;
    }

    public final String toString() {
        return Integer.toString(this.f9309a);
    }

    private Object writeReplace() {
        return new s((byte) 11, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return (u) j$.com.android.tools.r8.a.a(hVar, this);
    }
}
