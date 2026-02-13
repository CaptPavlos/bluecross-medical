package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class j0 implements m {
    public static final j0 BE;
    public static final j0 BEFORE_BE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ j0[] f9171a;

    @Override // j$.time.temporal.n
    public final /* synthetic */ boolean c(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.o(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ int e(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.l(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ Object k(j$.time.format.a aVar) {
        return j$.com.android.tools.r8.a.s(this, aVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ long q(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.m(this, qVar);
    }

    public static j0 valueOf(String str) {
        return (j0) Enum.valueOf(j0.class, str);
    }

    public static j0[] values() {
        return (j0[]) f9171a.clone();
    }

    static {
        j0 j0Var = new j0("BEFORE_BE", 0);
        BEFORE_BE = j0Var;
        j0 j0Var2 = new j0("BE", 1);
        BE = j0Var2;
        f9171a = new j0[]{j0Var, j0Var2};
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return ordinal();
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(getValue(), j$.time.temporal.a.ERA);
    }
}
