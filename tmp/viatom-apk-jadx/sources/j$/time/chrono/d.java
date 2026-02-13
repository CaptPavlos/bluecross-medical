package j$.time.chrono;

import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class d implements b, j$.time.temporal.m, j$.time.temporal.o, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public abstract b A(long j10);

    @Override // j$.time.chrono.b, j$.time.temporal.n
    public /* synthetic */ boolean c(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.n(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ int e(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public /* synthetic */ j$.time.temporal.u g(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.o
    public final /* synthetic */ j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return j$.com.android.tools.r8.a.a(this, mVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ Object k(j$.time.format.a aVar) {
        return j$.com.android.tools.r8.a.p(this, aVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: u */
    public final /* synthetic */ int compareTo(b bVar) {
        return j$.com.android.tools.r8.a.g(this, bVar);
    }

    public abstract b y(long j10);

    public abstract b z(long j10);

    public static b v(l lVar, j$.time.temporal.m mVar) {
        b bVar = (b) mVar;
        if (lVar.equals(bVar.getChronology())) {
            return bVar;
        }
        j$.time.g.f("Chronology mismatch, expected: ", lVar.d(), bVar.getChronology().d());
        return null;
    }

    @Override // j$.time.chrono.b
    public e s(j$.time.k kVar) {
        return new g(this, kVar);
    }

    @Override // j$.time.temporal.m
    public b b(long j10, j$.time.temporal.s sVar) {
        boolean z9 = sVar instanceof j$.time.temporal.b;
        if (!z9) {
            if (z9) {
                j$.time.g.b(sVar, "Unsupported unit: ");
                return null;
            }
            return v(getChronology(), sVar.e(this, j10));
        }
        switch (c.f9153a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return y(j10);
            case 2:
                return y(j$.com.android.tools.r8.a.w(j10, 7));
            case 3:
                return z(j10);
            case 4:
                return A(j10);
            case 5:
                return A(j$.com.android.tools.r8.a.w(j10, 10));
            case 6:
                return A(j$.com.android.tools.r8.a.w(j10, 100));
            case 7:
                return A(j$.com.android.tools.r8.a.w(j10, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return a(j$.com.android.tools.r8.a.x(q(aVar), j10), (j$.time.temporal.q) aVar);
            default:
                j$.time.g.b(sVar, "Unsupported unit: ");
                return null;
        }
    }

    public m w() {
        return getChronology().l(j$.time.temporal.r.a(this, j$.time.temporal.a.ERA));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && j$.com.android.tools.r8.a.g(this, (b) obj) == 0;
    }

    @Override // j$.time.chrono.b
    public int hashCode() {
        long jR = r();
        return ((int) (jR ^ (jR >>> 32))) ^ getChronology().hashCode();
    }

    @Override // j$.time.temporal.m
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public b f(j$.time.temporal.o oVar) {
        return v(getChronology(), oVar.j(this));
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        long jQ = q(j$.time.temporal.a.YEAR_OF_ERA);
        long jQ2 = q(j$.time.temporal.a.MONTH_OF_YEAR);
        long jQ3 = q(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(getChronology().toString());
        sb.append(" ");
        sb.append(w());
        sb.append(" ");
        sb.append(jQ);
        sb.append(jQ2 < 10 ? "-0" : "-");
        sb.append(jQ2);
        sb.append(jQ3 < 10 ? "-0" : "-");
        sb.append(jQ3);
        return sb.toString();
    }

    @Override // j$.time.temporal.m
    public b a(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(j$.time.c.a("Unsupported field: ", qVar));
        }
        return v(getChronology(), qVar.j(this, j10));
    }

    @Override // j$.time.temporal.m
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public b n(long j10, j$.time.temporal.s sVar) {
        return v(getChronology(), j$.time.temporal.r.b(this, j10, sVar));
    }

    @Override // j$.time.chrono.b
    public long r() {
        return q(j$.time.temporal.a.EPOCH_DAY);
    }
}
