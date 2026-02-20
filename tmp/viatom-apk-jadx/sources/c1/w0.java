package c1;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w0 extends f2 {

    /* renamed from: c, reason: collision with root package name */
    public char f1538c;

    /* renamed from: d, reason: collision with root package name */
    public long f1539d;
    public String e;
    public final u0 f;
    public final u0 g;
    public final u0 h;

    /* renamed from: i, reason: collision with root package name */
    public final u0 f1540i;

    /* renamed from: j, reason: collision with root package name */
    public final u0 f1541j;

    /* renamed from: k, reason: collision with root package name */
    public final u0 f1542k;

    /* renamed from: l, reason: collision with root package name */
    public final u0 f1543l;

    /* renamed from: m, reason: collision with root package name */
    public final u0 f1544m;

    /* renamed from: n, reason: collision with root package name */
    public final u0 f1545n;

    public w0(u1 u1Var) {
        super(u1Var);
        this.f1538c = (char) 0;
        this.f1539d = -1L;
        this.f = new u0(this, 6, false, false);
        this.g = new u0(this, 6, true, false);
        this.h = new u0(this, 6, false, true);
        this.f1540i = new u0(this, 5, false, false);
        this.f1541j = new u0(this, 5, true, false);
        this.f1542k = new u0(this, 5, false, true);
        this.f1543l = new u0(this, 4, false, false);
        this.f1544m = new u0(this, 3, false, false);
        this.f1545n = new u0(this, 2, false, false);
    }

    public static v0 o(String str) {
        if (str == null) {
            return null;
        }
        return new v0(str);
    }

    public static String r(boolean z9, String str, Object obj, Object obj2, Object obj3) {
        String strS = s(obj, z9);
        String strS2 = s(obj2, z9);
        String strS3 = s(obj3, z9);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strS)) {
            sb.append(str2);
            sb.append(strS);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strS2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strS2);
        }
        if (!TextUtils.isEmpty(strS3)) {
            sb.append(str3);
            sb.append(strS3);
        }
        return sb.toString();
    }

    public static String s(Object obj, boolean z9) {
        int iLastIndexOf;
        String className;
        int iLastIndexOf2;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z9) {
                return obj.toString();
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l10.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            int length = String.valueOf(jRound).length();
            String str = cCharAt == '-' ? "-" : "";
            StringBuilder sb = new StringBuilder(str.length() + str.length() + length + 3 + String.valueOf(jRound2).length());
            sb.append(str);
            sb.append(jRound);
            sb.append("...");
            sb.append(str);
            sb.append(jRound2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof v0 ? ((v0) obj).f1509a : z9 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z9 ? th.getClass().getName() : th.toString());
        String canonicalName = u1.class.getCanonicalName();
        String strSubstring = (TextUtils.isEmpty(canonicalName) || (iLastIndexOf = canonicalName.lastIndexOf(46)) == -1) ? "" : canonicalName.substring(0, iLastIndexOf);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length2 = stackTrace.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length2) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i10];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                if (((TextUtils.isEmpty(className) || (iLastIndexOf2 = className.lastIndexOf(46)) == -1) ? "" : className.substring(0, iLastIndexOf2)).equals(strSubstring)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
            }
            i10++;
        }
        return sb2.toString();
    }

    @Override // c1.f2
    public final boolean h() {
        return false;
    }

    public final u0 k() {
        return this.f;
    }

    public final u0 l() {
        return this.f1540i;
    }

    public final u0 m() {
        return this.f1544m;
    }

    public final u0 n() {
        return this.f1545n;
    }

    public final void p(int i10, boolean z9, boolean z10, String str, Object obj, Object obj2, Object obj3) {
        if (!z9 && Log.isLoggable(q(), i10)) {
            Log.println(i10, q(), r(false, str, obj, obj2, obj3));
        }
        if (z10 || i10 < 5) {
            return;
        }
        i0.y.g(str);
        r1 r1Var = this.f1149a.g;
        if (r1Var == null) {
            Log.println(6, q(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!r1Var.f1213b) {
                Log.println(6, q(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i10 >= 9) {
                i10 = 8;
            }
            r1Var.p(new t0(this, i10, str, obj, obj2, obj3));
        }
    }

    public final String q() {
        String str;
        synchronized (this) {
            try {
                if (this.e == null) {
                    this.f1149a.f1478d.f1149a.getClass();
                    this.e = "FA";
                }
                i0.y.g(this.e);
                str = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
