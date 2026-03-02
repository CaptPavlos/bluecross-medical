package j$.time.temporal;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.Duration;

/* loaded from: classes2.dex */
public enum b implements s {
    NANOS("Nanos"),
    MICROS("Micros"),
    MILLIS("Millis"),
    SECONDS("Seconds"),
    MINUTES("Minutes"),
    HOURS("Hours"),
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months"),
    YEARS("Years"),
    DECADES("Decades"),
    CENTURIES("Centuries"),
    MILLENNIA("Millennia"),
    ERAS("Eras"),
    FOREVER("Forever");


    /* renamed from: a, reason: collision with root package name */
    public final String f9284a;

    static {
        Duration.f(1L);
        Duration.f(1000L);
        Duration.f(1000000L);
        Duration.e(1L, 0);
        Duration.e(60L, 0);
        Duration.e(3600L, 0);
        Duration.e(43200L, 0);
        Duration.e(86400L, 0);
        Duration.e(604800L, 0);
        Duration.e(2629746L, 0);
        Duration.e(31556952L, 0);
        Duration.e(315569520L, 0);
        Duration.e(3155695200L, 0);
        Duration.e(31556952000L, 0);
        Duration.e(31556952000000000L, 0);
        Duration.e(j$.com.android.tools.r8.a.x(Long.MAX_VALUE, j$.com.android.tools.r8.a.B(999999999L, C.NANOS_PER_SECOND)), (int) j$.com.android.tools.r8.a.A(999999999L, C.NANOS_PER_SECOND));
    }

    b(String str) {
        this.f9284a = str;
    }

    @Override // j$.time.temporal.s
    public final m e(m mVar, long j10) {
        return mVar.b(j10, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f9284a;
    }
}
