package j$.time;

import androidx.constraintlayout.widget.R;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class m implements j$.time.temporal.n, j$.time.temporal.o {
    public static final m APRIL;
    public static final m AUGUST;
    public static final m DECEMBER;
    public static final m FEBRUARY;
    public static final m JANUARY;
    public static final m JULY;
    public static final m JUNE;
    public static final m MARCH;
    public static final m MAY;
    public static final m NOVEMBER;
    public static final m OCTOBER;
    public static final m SEPTEMBER;

    /* renamed from: a, reason: collision with root package name */
    public static final m[] f9262a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ m[] f9263b;

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f9263b.clone();
    }

    static {
        m mVar = new m("JANUARY", 0);
        JANUARY = mVar;
        m mVar2 = new m("FEBRUARY", 1);
        FEBRUARY = mVar2;
        m mVar3 = new m("MARCH", 2);
        MARCH = mVar3;
        m mVar4 = new m("APRIL", 3);
        APRIL = mVar4;
        m mVar5 = new m("MAY", 4);
        MAY = mVar5;
        m mVar6 = new m("JUNE", 5);
        JUNE = mVar6;
        m mVar7 = new m("JULY", 6);
        JULY = mVar7;
        m mVar8 = new m("AUGUST", 7);
        AUGUST = mVar8;
        m mVar9 = new m("SEPTEMBER", 8);
        SEPTEMBER = mVar9;
        m mVar10 = new m("OCTOBER", 9);
        OCTOBER = mVar10;
        m mVar11 = new m("NOVEMBER", 10);
        NOVEMBER = mVar11;
        m mVar12 = new m("DECEMBER", 11);
        DECEMBER = mVar12;
        f9263b = new m[]{mVar, mVar2, mVar3, mVar4, mVar5, mVar6, mVar7, mVar8, mVar9, mVar10, mVar11, mVar12};
        f9262a = values();
    }

    public static m y(int i10) {
        if (i10 < 1 || i10 > 12) {
            g.d("Invalid value for MonthOfYear: ", i10);
            return null;
        }
        return f9262a[i10 - 1];
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.MONTH_OF_YEAR : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return qVar.range();
        }
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return getValue();
        }
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return getValue();
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        return qVar.g(this);
    }

    public final int w(boolean z9) {
        int i10 = l.f9261a[ordinal()];
        return i10 != 1 ? (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) ? 30 : 31 : z9 ? 29 : 28;
    }

    public final int x() {
        int i10 = l.f9261a[ordinal()];
        if (i10 != 1) {
            return (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) ? 30 : 31;
        }
        return 29;
    }

    public final int v(boolean z9) {
        switch (l.f9261a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z9 ? 1 : 0) + 91;
            case 3:
                return (z9 ? 1 : 0) + 152;
            case 4:
                return (z9 ? 1 : 0) + 244;
            case 5:
                return (z9 ? 1 : 0) + 305;
            case 6:
                return 1;
            case 7:
                return (z9 ? 1 : 0) + 60;
            case 8:
                return (z9 ? 1 : 0) + R.styleable.ConstraintSet_transitionEasing;
            case 9:
                return (z9 ? 1 : 0) + 182;
            case 10:
                return (z9 ? 1 : 0) + 213;
            case 11:
                return (z9 ? 1 : 0) + 274;
            default:
                return (z9 ? 1 : 0) + 335;
        }
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f9301b) {
            return j$.time.chrono.s.f9188c;
        }
        if (aVar == j$.time.temporal.r.f9302c) {
            return j$.time.temporal.b.MONTHS;
        }
        return j$.time.temporal.r.c(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        if (!j$.com.android.tools.r8.a.v(mVar).equals(j$.time.chrono.s.f9188c)) {
            throw new b("Adjustment only supported on ISO date-time");
        }
        return mVar.a(getValue(), j$.time.temporal.a.MONTH_OF_YEAR);
    }
}
