package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class t implements m {
    public static final t BCE;
    public static final t CE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ t[] f9189a;

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

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f9189a.clone();
    }

    static {
        t tVar = new t("BCE", 0);
        BCE = tVar;
        t tVar2 = new t("CE", 1);
        CE = tVar2;
        f9189a = new t[]{tVar, tVar2};
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
