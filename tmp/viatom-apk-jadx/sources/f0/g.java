package f0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f8005b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f8006c = false;
    public static final /* synthetic */ int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f8004a = new AtomicBoolean();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f8007d = new AtomicBoolean();

    public static boolean a(Context context) {
        try {
            if (!f8006c) {
                try {
                    PackageInfo packageInfoB = p0.c.a(context).b(64, "com.google.android.gms");
                    h.a(context);
                    if (packageInfoB == null || h.d(packageInfoB, false) || !h.d(packageInfoB, true)) {
                        f8005b = false;
                    } else {
                        f8005b = true;
                    }
                    f8006c = true;
                } catch (PackageManager.NameNotFoundException e3) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e3);
                    f8006c = true;
                }
            }
            return f8005b || !"user".equals(Build.TYPE);
        } catch (Throwable th) {
            f8006c = true;
            throw th;
        }
    }
}
