package j$.util.stream;

import j$.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DISTINCT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class z6 {
    public static final z6 DISTINCT;
    public static final z6 ORDERED;
    public static final z6 SHORT_CIRCUIT;
    public static final z6 SIZED;
    public static final z6 SORTED;
    public static final int f;
    public static final int g;
    public static final int h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f9819i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f9820j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f9821k;

    /* renamed from: l, reason: collision with root package name */
    public static final int f9822l;

    /* renamed from: m, reason: collision with root package name */
    public static final int f9823m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f9824n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f9825o;

    /* renamed from: p, reason: collision with root package name */
    public static final int f9826p;

    /* renamed from: q, reason: collision with root package name */
    public static final int f9827q;

    /* renamed from: r, reason: collision with root package name */
    public static final int f9828r;

    /* renamed from: s, reason: collision with root package name */
    public static final int f9829s;
    public static final int t;

    /* renamed from: u, reason: collision with root package name */
    public static final int f9830u;

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ z6[] f9831v;

    /* renamed from: a, reason: collision with root package name */
    public final Map f9832a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9833b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9834c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9835d;
    public final int e;

    public static z6 valueOf(String str) {
        return (z6) Enum.valueOf(z6.class, str);
    }

    public static z6[] values() {
        return (z6[]) f9831v.clone();
    }

    static {
        y6 y6Var = y6.SPLITERATOR;
        j$.time.format.r rVarK = k(y6Var);
        y6 y6Var2 = y6.STREAM;
        rVarK.b(y6Var2);
        y6 y6Var3 = y6.OP;
        ((EnumMap) rVarK.f9245a).put((EnumMap) y6Var3, (y6) 3);
        z6 z6Var = new z6("DISTINCT", 0, 0, rVarK);
        DISTINCT = z6Var;
        j$.time.format.r rVarK2 = k(y6Var);
        rVarK2.b(y6Var2);
        ((EnumMap) rVarK2.f9245a).put((EnumMap) y6Var3, (y6) 3);
        z6 z6Var2 = new z6("SORTED", 1, 1, rVarK2);
        SORTED = z6Var2;
        j$.time.format.r rVarK3 = k(y6Var);
        rVarK3.b(y6Var2);
        ((EnumMap) rVarK3.f9245a).put((EnumMap) y6Var3, (y6) 3);
        y6 y6Var4 = y6.TERMINAL_OP;
        ((EnumMap) rVarK3.f9245a).put((EnumMap) y6Var4, (y6) 2);
        y6 y6Var5 = y6.UPSTREAM_TERMINAL_OP;
        ((EnumMap) rVarK3.f9245a).put((EnumMap) y6Var5, (y6) 2);
        z6 z6Var3 = new z6("ORDERED", 2, 2, rVarK3);
        ORDERED = z6Var3;
        j$.time.format.r rVarK4 = k(y6Var);
        rVarK4.b(y6Var2);
        ((EnumMap) rVarK4.f9245a).put((EnumMap) y6Var3, (y6) 2);
        z6 z6Var4 = new z6("SIZED", 3, 3, rVarK4);
        SIZED = z6Var4;
        j$.time.format.r rVarK5 = k(y6Var3);
        rVarK5.b(y6Var4);
        int i10 = 0;
        z6 z6Var5 = new z6("SHORT_CIRCUIT", 4, 12, rVarK5);
        SHORT_CIRCUIT = z6Var5;
        f9831v = new z6[]{z6Var, z6Var2, z6Var3, z6Var4, z6Var5};
        f = f(y6Var);
        g = f(y6Var2);
        h = f(y6Var3);
        f(y6Var4);
        f(y6Var5);
        for (z6 z6Var6 : values()) {
            i10 |= z6Var6.e;
        }
        f9819i = i10;
        int i11 = g;
        f9820j = i11;
        int i12 = i11 << 1;
        f9821k = i12;
        f9822l = i11 | i12;
        z6 z6Var7 = DISTINCT;
        f9823m = z6Var7.f9834c;
        f9824n = z6Var7.f9835d;
        z6 z6Var8 = SORTED;
        f9825o = z6Var8.f9834c;
        f9826p = z6Var8.f9835d;
        z6 z6Var9 = ORDERED;
        f9827q = z6Var9.f9834c;
        f9828r = z6Var9.f9835d;
        z6 z6Var10 = SIZED;
        f9829s = z6Var10.f9834c;
        t = z6Var10.f9835d;
        f9830u = SHORT_CIRCUIT.f9834c;
    }

    public static j$.time.format.r k(y6 y6Var) {
        j$.time.format.r rVar = new j$.time.format.r(1, new EnumMap(y6.class));
        rVar.b(y6Var);
        return rVar;
    }

    public z6(String str, int i10, int i11, j$.time.format.r rVar) {
        for (y6 y6Var : y6.values()) {
            j$.util.c.t(rVar.f9245a, y6Var, 0);
        }
        this.f9832a = rVar.f9245a;
        int i12 = i11 * 2;
        this.f9833b = i12;
        this.f9834c = 1 << i12;
        this.f9835d = 2 << i12;
        this.e = 3 << i12;
    }

    public final boolean j(int i10) {
        return (i10 & this.e) == this.f9834c;
    }

    public static int f(y6 y6Var) {
        int iIntValue = 0;
        for (z6 z6Var : values()) {
            iIntValue |= ((Integer) z6Var.f9832a.get(y6Var)).intValue() << z6Var.f9833b;
        }
        return iIntValue;
    }

    public static int e(int i10, int i11) {
        int i12;
        if (i10 == 0) {
            i12 = f9819i;
        } else {
            i12 = ~(((f9820j & i10) << 1) | i10 | ((f9821k & i10) >> 1));
        }
        return i10 | (i11 & i12);
    }

    public static int g(Spliterator spliterator) {
        int iCharacteristics = spliterator.characteristics();
        int i10 = iCharacteristics & 4;
        int i11 = f;
        return (i10 == 0 || spliterator.getComparator() == null) ? iCharacteristics & i11 : iCharacteristics & i11 & (-5);
    }
}
