package j$.time.temporal;

/* loaded from: classes2.dex */
public enum k implements q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;

    /* renamed from: a, reason: collision with root package name */
    public final transient String f9294a;

    /* renamed from: b, reason: collision with root package name */
    public final transient u f9295b;

    /* renamed from: c, reason: collision with root package name */
    public final transient long f9296c;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j10) {
        this.f9294a = str;
        this.f9295b = u.e((-365243219162L) + j10, 365241780471L + j10);
        this.f9296c = j10;
    }

    @Override // j$.time.temporal.q
    public final m j(m mVar, long j10) {
        if (!this.f9295b.d(j10)) {
            throw new j$.time.b("Invalid value: " + this.f9294a + " " + j10);
        }
        return mVar.a(j$.com.android.tools.r8.a.C(j10, this.f9296c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u range() {
        return this.f9295b;
    }

    @Override // j$.time.temporal.q
    public final boolean e(n nVar) {
        return nVar.c(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u f(n nVar) {
        if (nVar.c(a.EPOCH_DAY)) {
            return this.f9295b;
        }
        j$.time.g.h(this, "Unsupported field: ");
        return null;
    }

    @Override // j$.time.temporal.q
    public final long g(n nVar) {
        return nVar.q(a.EPOCH_DAY) + this.f9296c;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f9294a;
    }
}
