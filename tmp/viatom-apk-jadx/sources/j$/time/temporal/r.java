package j$.time.temporal;

import j$.util.Objects;

/* loaded from: classes2.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final j$.time.format.a f9300a = new j$.time.format.a(1);

    /* renamed from: b, reason: collision with root package name */
    public static final j$.time.format.a f9301b = new j$.time.format.a(2);

    /* renamed from: c, reason: collision with root package name */
    public static final j$.time.format.a f9302c = new j$.time.format.a(3);

    /* renamed from: d, reason: collision with root package name */
    public static final j$.time.format.a f9303d = new j$.time.format.a(4);
    public static final j$.time.format.a e = new j$.time.format.a(5);
    public static final j$.time.format.a f = new j$.time.format.a(6);
    public static final j$.time.format.a g = new j$.time.format.a(7);

    public static u d(n nVar, q qVar) {
        if (!(qVar instanceof a)) {
            Objects.requireNonNull(qVar, "field");
            return qVar.f(nVar);
        }
        if (nVar.c(qVar)) {
            return ((a) qVar).f9282b;
        }
        throw new t(j$.time.c.a("Unsupported field: ", qVar));
    }

    public static int a(n nVar, q qVar) {
        u uVarG = nVar.g(qVar);
        if (uVarG.f9304a < -2147483648L || uVarG.f9307d > 2147483647L) {
            throw new t("Invalid field " + qVar + " for get() method, use getLong() instead");
        }
        long jQ = nVar.q(qVar);
        if (uVarG.d(jQ)) {
            return (int) jQ;
        }
        throw new j$.time.b("Invalid value for " + qVar + " (valid values " + uVarG + "): " + jQ);
    }

    public static Object c(n nVar, j$.time.format.a aVar) {
        if (aVar == f9300a || aVar == f9301b || aVar == f9302c) {
            return null;
        }
        return aVar.a(nVar);
    }

    public static m b(m mVar, long j10, s sVar) {
        long j11;
        if (j10 == Long.MIN_VALUE) {
            mVar = mVar.b(Long.MAX_VALUE, sVar);
            j11 = 1;
        } else {
            j11 = -j10;
        }
        return mVar.b(j11, sVar);
    }
}
