package c1;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s4 extends m4 {
    public static final boolean j(String str) {
        String str2 = (String) f0.t.a(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        if (java.lang.Math.abs(r6.hashCode() % 100) < r8.E().p()) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.r4 h(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.s4.h(java.lang.String):c1.r4");
    }

    public final String i(String str) {
        n1 n1Var = this.f1335b.f1518a;
        v4.U(n1Var);
        String strT = n1Var.t(str);
        if (TextUtils.isEmpty(strT)) {
            return (String) f0.f1194r.a(null);
        }
        Uri uri = Uri.parse((String) f0.f1194r.a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        String authority = uri.getAuthority();
        StringBuilder sb = new StringBuilder(String.valueOf(strT).length() + 1 + String.valueOf(authority).length());
        sb.append(strT);
        sb.append(".");
        sb.append(authority);
        builderBuildUpon.authority(sb.toString());
        return builderBuildUpon.build().toString();
    }
}
