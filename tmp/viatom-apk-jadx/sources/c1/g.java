package c1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends e2 {

    /* renamed from: b, reason: collision with root package name */
    public Boolean f1226b;

    /* renamed from: c, reason: collision with root package name */
    public String f1227c;

    /* renamed from: d, reason: collision with root package name */
    public f f1228d;
    public Boolean e;

    public final boolean h(String str) {
        return "1".equals(this.f1228d.d(str, "gaia_collection_enabled"));
    }

    public final boolean i(String str) {
        return "1".equals(this.f1228d.d(str, "measurement.event_sampling_enabled"));
    }

    public final boolean j() {
        if (this.f1226b == null) {
            Boolean boolS = s("app_measurement_lite");
            this.f1226b = boolS;
            if (boolS == null) {
                this.f1226b = Boolean.FALSE;
            }
        }
        return this.f1226b.booleanValue() || !this.f1149a.f1476b;
    }

    public final String k(String str) {
        u1 u1Var = this.f1149a;
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            i0.y.g(str2);
            return str2;
        } catch (ClassNotFoundException e) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.c(e, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e3) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f.c(e3, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e7) {
            w0 w0Var3 = u1Var.f;
            u1.m(w0Var3);
            w0Var3.f.c(e7, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e10) {
            w0 w0Var4 = u1Var.f;
            u1.m(w0Var4);
            w0Var4.f.c(e10, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final void l() {
        this.f1149a.getClass();
    }

    public final String m(String str, e0 e0Var) {
        return TextUtils.isEmpty(str) ? (String) e0Var.a(null) : (String) e0Var.a(this.f1228d.d(str, e0Var.f1141a));
    }

    public final long n(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) e0Var.a(null)).longValue();
        }
        String strD = this.f1228d.d(str, e0Var.f1141a);
        if (TextUtils.isEmpty(strD)) {
            return ((Long) e0Var.a(null)).longValue();
        }
        try {
            return ((Long) e0Var.a(Long.valueOf(Long.parseLong(strD)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) e0Var.a(null)).longValue();
        }
    }

    public final int o(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) e0Var.a(null)).intValue();
        }
        String strD = this.f1228d.d(str, e0Var.f1141a);
        if (TextUtils.isEmpty(strD)) {
            return ((Integer) e0Var.a(null)).intValue();
        }
        try {
            return ((Integer) e0Var.a(Integer.valueOf(Integer.parseInt(strD)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) e0Var.a(null)).intValue();
        }
    }

    public final double p(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) e0Var.a(null)).doubleValue();
        }
        String strD = this.f1228d.d(str, e0Var.f1141a);
        if (TextUtils.isEmpty(strD)) {
            return ((Double) e0Var.a(null)).doubleValue();
        }
        try {
            return ((Double) e0Var.a(Double.valueOf(Double.parseDouble(strD)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) e0Var.a(null)).doubleValue();
        }
    }

    public final boolean q(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) e0Var.a(null)).booleanValue();
        }
        String strD = this.f1228d.d(str, e0Var.f1141a);
        return TextUtils.isEmpty(strD) ? ((Boolean) e0Var.a(null)).booleanValue() : ((Boolean) e0Var.a(Boolean.valueOf("1".equals(strD)))).booleanValue();
    }

    public final Bundle r() {
        u1 u1Var = this.f1149a;
        try {
            Context context = u1Var.f1475a;
            Context context2 = u1Var.f1475a;
            w0 w0Var = u1Var.f;
            if (context.getPackageManager() == null) {
                u1.m(w0Var);
                w0Var.f.b("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoA = p0.c.a(context2).a(128, context2.getPackageName());
            if (applicationInfoA != null) {
                return applicationInfoA.metaData;
            }
            u1.m(w0Var);
            w0Var.f.b("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f.c(e, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final Boolean s(String str) {
        i0.y.d(str);
        Bundle bundleR = r();
        if (bundleR != null) {
            if (bundleR.containsKey(str)) {
                return Boolean.valueOf(bundleR.getBoolean(str));
            }
            return null;
        }
        w0 w0Var = this.f1149a.f;
        u1.m(w0Var);
        w0Var.f.b("Failed to load metadata: Metadata bundle is null");
        return null;
    }

    public final boolean t() {
        this.f1149a.getClass();
        Boolean boolS = s("firebase_analytics_collection_deactivated");
        return boolS != null && boolS.booleanValue();
    }

    public final boolean u() {
        Boolean boolS = s("google_analytics_automatic_screen_reporting_enabled");
        return boolS == null || boolS.booleanValue();
    }

    public final h2 v(String str, boolean z9) {
        Object obj;
        i0.y.d(str);
        Bundle bundleR = r();
        u1 u1Var = this.f1149a;
        if (bundleR == null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.b("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleR.get(str);
        }
        h2 h2Var = h2.UNINITIALIZED;
        if (obj == null) {
            return h2Var;
        }
        if (Boolean.TRUE.equals(obj)) {
            return h2.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return h2.DENIED;
        }
        if (z9 && "eu_consent_policy".equals(obj)) {
            return h2.POLICY;
        }
        w0 w0Var2 = u1Var.f;
        u1.m(w0Var2);
        w0Var2.f1540i.c(str, "Invalid manifest metadata for");
        return h2Var;
    }
}
