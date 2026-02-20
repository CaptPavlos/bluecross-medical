package j$.time.temporal;

import j$.time.Duration;

/* loaded from: classes2.dex */
public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* renamed from: a, reason: collision with root package name */
    public final String f9289a;

    static {
        Duration.e(31556952L, 0);
        Duration.e(7889238L, 0);
    }

    i(String str) {
        this.f9289a = str;
    }

    @Override // j$.time.temporal.s
    public final m e(m mVar, long j10) {
        int i10 = c.f9285a[ordinal()];
        if (i10 == 1) {
            return mVar.a(j$.com.android.tools.r8.a.x(mVar.e(r0), j10), j.f9292c);
        }
        if (i10 == 2) {
            return mVar.b(j10 / 4, b.YEARS).b((j10 % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f9289a;
    }
}
