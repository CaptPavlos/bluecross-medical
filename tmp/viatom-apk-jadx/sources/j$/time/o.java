package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class o implements j$.time.temporal.n, j$.time.temporal.o, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f9265c = 0;
    private static final long serialVersionUID = -939150713474957432L;

    /* renamed from: a, reason: collision with root package name */
    public final int f9266a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9267b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        o oVar = (o) obj;
        int i10 = this.f9266a - oVar.f9266a;
        return i10 == 0 ? this.f9267b - oVar.f9267b : i10;
    }

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.d("--");
        nVar.g(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        nVar.c('-');
        nVar.g(j$.time.temporal.a.DAY_OF_MONTH, 2);
        nVar.l(Locale.getDefault(), j$.time.format.t.SMART, null);
    }

    public o(int i10, int i11) {
        this.f9266a = i10;
        this.f9267b = i11;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.MONTH_OF_YEAR || qVar == j$.time.temporal.a.DAY_OF_MONTH : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return qVar.range();
        }
        if (qVar != j$.time.temporal.a.DAY_OF_MONTH) {
            return j$.time.temporal.r.d(this, qVar);
        }
        m mVarY = m.y(this.f9266a);
        mVarY.getClass();
        int i10 = l.f9261a[mVarY.ordinal()];
        return j$.time.temporal.u.f(i10 != 1 ? (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) ? 30 : 31 : 28, m.y(this.f9266a).x());
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
        int i11 = n.f9264a[((j$.time.temporal.a) qVar).ordinal()];
        if (i11 == 1) {
            i10 = this.f9267b;
        } else {
            if (i11 != 2) {
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
            }
            i10 = this.f9266a;
        }
        return i10;
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f9301b) {
            return j$.time.chrono.s.f9188c;
        }
        return j$.time.temporal.r.c(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        if (!j$.com.android.tools.r8.a.v(mVar).equals(j$.time.chrono.s.f9188c)) {
            throw new b("Adjustment only supported on ISO date-time");
        }
        j$.time.temporal.m mVarA = mVar.a(this.f9266a, j$.time.temporal.a.MONTH_OF_YEAR);
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return mVarA.a(Math.min(mVarA.g(aVar).f9307d, this.f9267b), aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f9266a == oVar.f9266a && this.f9267b == oVar.f9267b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f9266a << 6) + this.f9267b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.f9266a < 10 ? "0" : "");
        sb.append(this.f9266a);
        sb.append(this.f9267b < 10 ? "-0" : "-");
        sb.append(this.f9267b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
