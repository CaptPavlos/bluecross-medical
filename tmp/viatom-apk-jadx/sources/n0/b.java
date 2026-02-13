package n0;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import f0.g;
import f0.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f11267a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f11268b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f11269c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f11270d;
    public static Boolean e;
    public static Boolean f;

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean b(Context context, int i10) throws PackageManager.NameNotFoundException {
        if (d(context, i10, "com.google.android.gms")) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                h hVarA = h.a(context);
                hVarA.getClass();
                if (packageInfo != null) {
                    if (!h.d(packageInfo, false)) {
                        if (h.d(packageInfo, true)) {
                            if (!g.a(hVarA.f8009a)) {
                                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                            }
                        }
                    }
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f11269c == null) {
            f11269c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (f11269c.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (f11270d == null) {
            f11270d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (f11270d.booleanValue()) {
            return !a() || Build.VERSION.SDK_INT >= 30;
        }
        return false;
    }

    public static boolean d(Context context, int i10, String str) {
        p0.b bVarA = p0.c.a(context);
        bVarA.getClass();
        try {
            AppOpsManager appOpsManager = (AppOpsManager) bVarA.f11875a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i10, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
