package c1;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k2 {

    /* renamed from: c, reason: collision with root package name */
    public static final k2 f1301c = new k2(100);

    /* renamed from: a, reason: collision with root package name */
    public final EnumMap f1302a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1303b;

    public k2(int i10) {
        EnumMap enumMap = new EnumMap(j2.class);
        this.f1302a = enumMap;
        j2 j2Var = j2.AD_STORAGE;
        h2 h2Var = h2.UNINITIALIZED;
        enumMap.put((EnumMap) j2Var, (j2) h2Var);
        enumMap.put((EnumMap) j2.ANALYTICS_STORAGE, (j2) h2Var);
        this.f1303b = i10;
    }

    public static String a(int i10) {
        return i10 != -30 ? i10 != -20 ? i10 != -10 ? i10 != 0 ? i10 != 30 ? i10 != 90 ? i10 != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static k2 b(int i10, Bundle bundle) {
        if (bundle == null) {
            return new k2(i10);
        }
        EnumMap enumMap = new EnumMap(j2.class);
        for (j2 j2Var : i2.STORAGE.f1273a) {
            enumMap.put((EnumMap) j2Var, (j2) d(bundle.getString(j2Var.f1290a)));
        }
        return new k2(enumMap, i10);
    }

    public static k2 c(int i10, String str) {
        EnumMap enumMap = new EnumMap(j2.class);
        j2[] j2VarArr = i2.STORAGE.f1273a;
        for (int i11 = 0; i11 < j2VarArr.length; i11++) {
            String str2 = str == null ? "" : str;
            j2 j2Var = j2VarArr[i11];
            int i12 = i11 + 2;
            if (i12 < str2.length()) {
                enumMap.put((EnumMap) j2Var, (j2) e(str2.charAt(i12)));
            } else {
                enumMap.put((EnumMap) j2Var, (j2) h2.UNINITIALIZED);
            }
        }
        return new k2(enumMap, i10);
    }

    public static h2 d(String str) {
        h2 h2Var = h2.UNINITIALIZED;
        return str == null ? h2Var : str.equals("granted") ? h2.GRANTED : str.equals("denied") ? h2.DENIED : h2Var;
    }

    public static h2 e(char c10) {
        return c10 != '+' ? c10 != '0' ? c10 != '1' ? h2.UNINITIALIZED : h2.GRANTED : h2.DENIED : h2.POLICY;
    }

    public static char h(h2 h2Var) {
        if (h2Var == null) {
            return '-';
        }
        int iOrdinal = h2Var.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static boolean l(int i10, int i11) {
        int i12 = -30;
        if (i10 == -20) {
            if (i11 == -30) {
                return true;
            }
            i10 = -20;
        }
        if (i10 != -30) {
            i12 = i10;
        } else if (i11 == -20) {
            return true;
        }
        return i12 == i11 || i10 < i11;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k2) {
            k2 k2Var = (k2) obj;
            j2[] j2VarArr = i2.STORAGE.f1273a;
            int length = j2VarArr.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    j2 j2Var = j2VarArr[i10];
                    if (this.f1302a.get(j2Var) != k2Var.f1302a.get(j2Var)) {
                        break;
                    }
                    i10++;
                } else if (this.f1303b == k2Var.f1303b) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            c1.i2 r1 = c1.i2.STORAGE
            c1.j2[] r1 = r1.f1273a
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L38
            r4 = r1[r3]
            java.util.EnumMap r5 = r7.f1302a
            java.lang.Object r4 = r5.get(r4)
            c1.h2 r4 = (c1.h2) r4
            r5 = 45
            if (r4 == 0) goto L32
            int r4 = r4.ordinal()
            if (r4 == 0) goto L32
            r6 = 1
            if (r4 == r6) goto L30
            r6 = 2
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L30
            goto L32
        L2d:
            r5 = 48
            goto L32
        L30:
            r5 = 49
        L32:
            r0.append(r5)
            int r3 = r3 + 1
            goto Ld
        L38:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.k2.f():java.lang.String");
    }

    public final String g() {
        StringBuilder sb = new StringBuilder("G1");
        for (j2 j2Var : i2.STORAGE.f1273a) {
            sb.append(h((h2) this.f1302a.get(j2Var)));
        }
        return sb.toString();
    }

    public final int hashCode() {
        Iterator it = this.f1302a.values().iterator();
        int iHashCode = this.f1303b * 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((h2) it.next()).hashCode();
        }
        return iHashCode;
    }

    public final boolean i(j2 j2Var) {
        return ((h2) this.f1302a.get(j2Var)) != h2.DENIED;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.k2 j(c1.k2 r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<c1.j2> r1 = c1.j2.class
            r0.<init>(r1)
            c1.i2 r1 = c1.i2.STORAGE
            c1.j2[] r1 = r1.f1273a
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L48
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f1302a
            java.lang.Object r5 = r5.get(r4)
            c1.h2 r5 = (c1.h2) r5
            java.util.EnumMap r6 = r9.f1302a
            java.lang.Object r6 = r6.get(r4)
            c1.h2 r6 = (c1.h2) r6
            if (r5 != 0) goto L24
            goto L31
        L24:
            if (r6 == 0) goto L40
            c1.h2 r7 = c1.h2.UNINITIALIZED
            if (r5 != r7) goto L2b
            goto L31
        L2b:
            if (r6 == r7) goto L40
            c1.h2 r7 = c1.h2.POLICY
            if (r5 != r7) goto L33
        L31:
            r5 = r6
            goto L40
        L33:
            if (r6 == r7) goto L40
            c1.h2 r7 = c1.h2.DENIED
            if (r5 == r7) goto L3f
            if (r6 != r7) goto L3c
            goto L3f
        L3c:
            c1.h2 r5 = c1.h2.GRANTED
            goto L40
        L3f:
            r5 = r7
        L40:
            if (r5 == 0) goto L45
            r0.put(r4, r5)
        L45:
            int r3 = r3 + 1
            goto Ld
        L48:
            c1.k2 r9 = new c1.k2
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.k2.j(c1.k2):c1.k2");
    }

    public final k2 k(k2 k2Var) {
        EnumMap enumMap = new EnumMap(j2.class);
        for (j2 j2Var : i2.STORAGE.f1273a) {
            h2 h2Var = (h2) this.f1302a.get(j2Var);
            if (h2Var == h2.UNINITIALIZED) {
                h2Var = (h2) k2Var.f1302a.get(j2Var);
            }
            if (h2Var != null) {
                enumMap.put((EnumMap) j2Var, (j2) h2Var);
            }
        }
        return new k2(enumMap, this.f1303b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(a(this.f1303b));
        for (j2 j2Var : i2.STORAGE.f1273a) {
            sb.append(",");
            sb.append(j2Var.f1290a);
            sb.append("=");
            h2 h2Var = (h2) this.f1302a.get(j2Var);
            if (h2Var == null) {
                h2Var = h2.UNINITIALIZED;
            }
            sb.append(h2Var);
        }
        return sb.toString();
    }

    public k2(EnumMap enumMap, int i10) {
        EnumMap enumMap2 = new EnumMap(j2.class);
        this.f1302a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f1303b = i10;
    }
}
