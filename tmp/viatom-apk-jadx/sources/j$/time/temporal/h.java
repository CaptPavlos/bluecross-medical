package j$.time.temporal;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class h implements q {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f9286a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f9287b;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f9287b.clone();
    }

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.q
            public final u range() {
                return u.f(90L, 92L);
            }

            @Override // j$.time.temporal.q
            public final boolean e(n nVar) {
                if (!nVar.c(a.DAY_OF_YEAR) || !nVar.c(a.MONTH_OF_YEAR) || !nVar.c(a.YEAR)) {
                    return false;
                }
                h hVar2 = j.f9290a;
                return j$.com.android.tools.r8.a.v(nVar).equals(j$.time.chrono.s.f9188c);
            }

            @Override // j$.time.temporal.q
            public final u f(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                long jQ = nVar.q(h.QUARTER_OF_YEAR);
                if (jQ == 1) {
                    long jQ2 = nVar.q(a.YEAR);
                    j$.time.chrono.s.f9188c.getClass();
                    return j$.time.chrono.s.f(jQ2) ? u.e(1L, 91L) : u.e(1L, 90L);
                }
                if (jQ == 2) {
                    return u.e(1L, 91L);
                }
                if (jQ == 3 || jQ == 4) {
                    return u.e(1L, 92L);
                }
                return range();
            }

            @Override // j$.time.temporal.q
            public final long g(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                int iE = nVar.e(a.DAY_OF_YEAR);
                int iE2 = nVar.e(a.MONTH_OF_YEAR);
                long jQ = nVar.q(a.YEAR);
                int i10 = (iE2 - 1) / 3;
                j$.time.chrono.s.f9188c.getClass();
                return iE - h.f9286a[i10 + (j$.time.chrono.s.f(jQ) ? 4 : 0)];
            }

            @Override // j$.time.temporal.q
            public final m j(m mVar, long j10) {
                long jG = g(mVar);
                range().b(j10, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.a((j10 - jG) + mVar.q(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.q
            public final u range() {
                return u.e(1L, 4L);
            }

            @Override // j$.time.temporal.q
            public final boolean e(n nVar) {
                if (!nVar.c(a.MONTH_OF_YEAR)) {
                    return false;
                }
                h hVar3 = j.f9290a;
                return j$.com.android.tools.r8.a.v(nVar).equals(j$.time.chrono.s.f9188c);
            }

            @Override // j$.time.temporal.q
            public final long g(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return (nVar.q(a.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.q
            public final u f(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return range();
            }

            @Override // j$.time.temporal.q
            public final m j(m mVar, long j10) {
                long jG = g(mVar);
                range().b(j10, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.a(((j10 - jG) * 3) + mVar.q(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.q
            public final u range() {
                return u.f(52L, 53L);
            }

            @Override // j$.time.temporal.q
            public final boolean e(n nVar) {
                if (!nVar.c(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar4 = j.f9290a;
                return j$.com.android.tools.r8.a.v(nVar).equals(j$.time.chrono.s.f9188c);
            }

            @Override // j$.time.temporal.q
            public final u f(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: WeekOfWeekBasedYear");
                }
                return u.e(1L, h.q(h.n(j$.time.h.x(nVar))));
            }

            @Override // j$.time.temporal.q
            public final long g(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.k(j$.time.h.x(nVar));
            }

            @Override // j$.time.temporal.q
            public final m j(m mVar, long j10) {
                range().b(j10, this);
                return mVar.b(j$.com.android.tools.r8.a.C(j10, g(mVar)), b.WEEKS);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.q
            public final u range() {
                return a.YEAR.f9282b;
            }

            @Override // j$.time.temporal.q
            public final boolean e(n nVar) {
                if (!nVar.c(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.f9290a;
                return j$.com.android.tools.r8.a.v(nVar).equals(j$.time.chrono.s.f9188c);
            }

            @Override // j$.time.temporal.q
            public final long g(n nVar) {
                if (e(nVar)) {
                    return h.n(j$.time.h.x(nVar));
                }
                throw new t("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final u f(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                return a.YEAR.f9282b;
            }

            @Override // j$.time.temporal.q
            public final m j(m mVar, long j10) {
                if (!e(mVar)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.f9282b.a(j10, h.WEEK_BASED_YEAR);
                j$.time.h hVarX = j$.time.h.x(mVar);
                int iE = hVarX.e(a.DAY_OF_WEEK);
                int iK = h.k(hVarX);
                if (iK == 53 && h.q(iA) == 52) {
                    iK = 52;
                }
                return mVar.f(j$.time.h.D(iA, 1, 4).G(((iK - 1) * 7) + (iE - r6.e(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f9287b = new h[]{hVar, hVar2, hVar3, hVar4};
        f9286a = new int[]{0, 90, 181, FloatWebTemplateView.FLOAT_MINI_CARD, 0, 91, 182, 274};
    }

    public static int q(int i10) {
        j$.time.h hVarD = j$.time.h.D(i10, 1, 1);
        if (hVarD.z() != j$.time.d.THURSDAY) {
            return (hVarD.z() == j$.time.d.WEDNESDAY && hVarD.B()) ? 53 : 52;
        }
        return 53;
    }

    public static int k(j$.time.h hVar) {
        int iOrdinal = hVar.z().ordinal();
        int iA = hVar.A() - 1;
        int i10 = (3 - iOrdinal) + iA;
        int i11 = i10 - ((i10 / 7) * 7);
        int i12 = i11 - 3;
        if (i12 < -3) {
            i12 = i11 + 4;
        }
        if (iA < i12) {
            return (int) u.e(1L, q(n(hVar.M(SubsamplingScaleImageView.ORIENTATION_180).I(-1L)))).f9307d;
        }
        int i13 = ((iA - i12) / 7) + 1;
        if (i13 != 53 || i12 == -3 || (i12 == -2 && hVar.B())) {
            return i13;
        }
        return 1;
    }

    public static int n(j$.time.h hVar) {
        int i10 = hVar.f9251a;
        int iA = hVar.A();
        if (iA <= 3) {
            return iA - hVar.z().ordinal() < -2 ? i10 - 1 : i10;
        }
        if (iA >= 363) {
            return ((iA - 363) - (hVar.B() ? 1 : 0)) - hVar.z().ordinal() >= 0 ? i10 + 1 : i10;
        }
        return i10;
    }
}
