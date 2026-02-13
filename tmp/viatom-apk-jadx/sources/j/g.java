package j;

import android.content.SharedPreferences;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import d0.i;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9878a;

    /* renamed from: b, reason: collision with root package name */
    public static final Vector f9879b = new Vector(null, 1, null);

    public static GoogleBasicConsents a() {
        return new GoogleBasicConsents(b("adStorage"), b("adUserData"), b("adPersonalization"), b("analyticsStorage"));
    }

    public static GBCConsentValue b(String str) {
        int iD = d(str);
        Vector vector = f9879b;
        return (vector.contains(iD) && l.a(vector.get(iD), Boolean.TRUE)) ? GBCConsentValue.GRANTED : GBCConsentValue.DENIED;
    }

    public static String c(i iVar) {
        if (!f9878a) {
            return null;
        }
        String strT = iVar.t(93);
        return strT.length() == 0 ? ((SharedPreferences) iVar.f6781b).getBoolean("GBCShown", false) ? "Bounce" : "NA" : strT;
    }

    public static int d(String str) {
        if (str.equals("adStorage")) {
            return 1;
        }
        if (str.equals("adUserData")) {
            return 2;
        }
        if (str.equals("adPersonalization")) {
            return 3;
        }
        return str.equals("analyticsStorage") ? 4 : 0;
    }

    public static String e() {
        if (!f9878a) {
            return null;
        }
        u uVar = new u();
        uVar.f10135a = true;
        f fVar = new f(uVar, 0);
        Vector vector = f9879b;
        vector.forEach(fVar);
        if (uVar.f10135a) {
            return "All";
        }
        u uVar2 = new u();
        uVar2.f10135a = true;
        vector.forEach(new f(uVar2, 1));
        return uVar2.f10135a ? "Reject" : "Partial";
    }
}
