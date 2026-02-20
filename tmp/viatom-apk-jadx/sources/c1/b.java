package c1;

import com.google.android.gms.internal.measurement.o5;
import com.google.android.gms.internal.measurement.v7;
import j$.util.DesugarCollections;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1010a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1011b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f1012c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f1013d;
    public Long e;
    public Long f;
    public final /* synthetic */ int g;
    public final /* synthetic */ c h;

    /* renamed from: i, reason: collision with root package name */
    public final o5 f1014i;

    public b(c cVar, String str, int i10, o5 o5Var, int i11) {
        this.g = i11;
        this.h = cVar;
        this.f1010a = str;
        this.f1011b = i10;
        this.f1014i = o5Var;
    }

    public static Boolean c(Boolean bool, boolean z9) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z9);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Boolean d(String str, com.google.android.gms.internal.measurement.x1 x1Var, w0 w0Var) {
        List listU;
        i0.y.g(x1Var);
        if (str != null && x1Var.p() && x1Var.x() != 1 && (x1Var.x() != 7 ? x1Var.q() : x1Var.v() != 0)) {
            int iX = x1Var.x();
            boolean zT = x1Var.t();
            String strR = (zT || iX == 2 || iX == 7) ? x1Var.r() : x1Var.r().toUpperCase(Locale.ENGLISH);
            if (x1Var.v() == 0) {
                listU = null;
            } else {
                listU = x1Var.u();
                if (!zT) {
                    ArrayList arrayList = new ArrayList(listU.size());
                    Iterator it = listU.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                    }
                    listU = DesugarCollections.unmodifiableList(arrayList);
                }
            }
            String str2 = iX == 2 ? strR : null;
            if (iX != 7 ? strR != null : listU != null && !listU.isEmpty()) {
                if (!zT && iX != 2) {
                    str = str.toUpperCase(Locale.ENGLISH);
                }
                switch (iX - 1) {
                    case 1:
                        if (str2 != null) {
                            try {
                                return Boolean.valueOf(Pattern.compile(str2, true != zT ? 66 : 0).matcher(str).matches());
                            } catch (PatternSyntaxException unused) {
                                if (w0Var != null) {
                                    w0Var.f1540i.c(str2, "Invalid regular expression in REGEXP audience filter. expression");
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        return Boolean.valueOf(str.startsWith(strR));
                    case 3:
                        return Boolean.valueOf(str.endsWith(strR));
                    case 4:
                        return Boolean.valueOf(str.contains(strR));
                    case 5:
                        return Boolean.valueOf(str.equals(strR));
                    case 6:
                        if (listU != null) {
                            return Boolean.valueOf(listU.contains(str));
                        }
                        break;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Boolean e(java.math.BigDecimal r8, com.google.android.gms.internal.measurement.u1 r9, double r10) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.b.e(java.math.BigDecimal, com.google.android.gms.internal.measurement.u1, double):java.lang.Boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03c4 A[EDGE_INSN: B:234:0x03c4->B:161:0x03c4 BREAK  A[LOOP:3: B:89:0x0241->B:238:0x0241], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.Long r22, java.lang.Long r23, com.google.android.gms.internal.measurement.c3 r24, long r25, c1.s r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 1080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.b.a(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.c3, long, c1.s, boolean):boolean");
    }

    public boolean b(Long l10, Long l11, com.google.android.gms.internal.measurement.t3 t3Var, boolean z9) {
        boolean z10;
        Boolean boolC;
        Boolean boolE;
        Boolean boolE2;
        Boolean boolE3;
        v7.a();
        u1 u1Var = this.h.f1149a;
        g gVar = u1Var.f1478d;
        q0 q0Var = u1Var.f1480j;
        w0 w0Var = u1Var.f;
        boolean zQ = gVar.q(this.f1010a, f0.E0);
        com.google.android.gms.internal.measurement.w1 w1Var = (com.google.android.gms.internal.measurement.w1) this.f1014i;
        boolean zT = w1Var.t();
        boolean zU = w1Var.u();
        boolean zW = w1Var.w();
        boolean z11 = zT || zU || zW;
        if (z9 && !z11) {
            u1.m(w0Var);
            w0Var.f1545n.d(Integer.valueOf(this.f1011b), "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", w1Var.p() ? Integer.valueOf(w1Var.q()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.r1 r1VarS = w1Var.s();
        boolean zU2 = r1VarS.u();
        if (!t3Var.u()) {
            z10 = zW;
            if (!t3Var.y()) {
                if (!t3Var.s()) {
                    u1.m(w0Var);
                    w0Var.f1540i.c(q0Var.c(t3Var.r()), "User property has no value, property");
                } else if (r1VarS.p()) {
                    String strT = t3Var.t();
                    com.google.android.gms.internal.measurement.x1 x1VarQ = r1VarS.q();
                    u1.m(w0Var);
                    boolC = c(d(strT, x1VarQ, w0Var), zU2);
                } else if (!r1VarS.r()) {
                    u1.m(w0Var);
                    w0Var.f1540i.c(q0Var.c(t3Var.r()), "No string or number filter defined. property");
                } else if (a1.M(t3Var.t())) {
                    String strT2 = t3Var.t();
                    com.google.android.gms.internal.measurement.u1 u1VarS = r1VarS.s();
                    if (a1.M(strT2)) {
                        try {
                            boolE = e(new BigDecimal(strT2), u1VarS, 0.0d);
                        } catch (NumberFormatException unused) {
                        }
                        boolC = c(boolE, zU2);
                    } else {
                        boolE = null;
                        boolC = c(boolE, zU2);
                    }
                } else {
                    u1.m(w0Var);
                    w0Var.f1540i.d(q0Var.c(t3Var.r()), "Invalid user property value for Numeric number filter. property, value", t3Var.t());
                }
                boolC = null;
            } else if (r1VarS.r()) {
                double dZ = t3Var.z();
                try {
                    boolE2 = e(new BigDecimal(dZ), r1VarS.s(), Math.ulp(dZ));
                } catch (NumberFormatException unused2) {
                    boolE2 = null;
                }
                boolC = c(boolE2, zU2);
            } else {
                u1.m(w0Var);
                w0Var.f1540i.c(q0Var.c(t3Var.r()), "No number filter for double property. property");
                boolC = null;
            }
        } else if (r1VarS.r()) {
            z10 = zW;
            try {
                boolE3 = e(new BigDecimal(t3Var.v()), r1VarS.s(), 0.0d);
            } catch (NumberFormatException unused3) {
                boolE3 = null;
            }
            boolC = c(boolE3, zU2);
        } else {
            u1.m(w0Var);
            w0Var.f1540i.c(q0Var.c(t3Var.r()), "No number filter for long property. property");
            z10 = zW;
            boolC = null;
        }
        u1.m(w0Var);
        w0Var.f1545n.c(boolC == null ? "null" : boolC, "Property filter result");
        if (boolC == null) {
            return false;
        }
        this.f1012c = Boolean.TRUE;
        if (!z10 || boolC.booleanValue()) {
            if (!z9 || w1Var.t()) {
                this.f1013d = boolC;
            }
            if (boolC.booleanValue() && z11 && t3Var.p()) {
                long jQ = t3Var.q();
                if (l10 != null) {
                    jQ = l10.longValue();
                }
                if (zQ && w1Var.t() && !w1Var.u() && l11 != null) {
                    jQ = l11.longValue();
                }
                if (w1Var.u()) {
                    this.f = Long.valueOf(jQ);
                } else {
                    this.e = Long.valueOf(jQ);
                }
            }
        }
        return true;
    }
}
