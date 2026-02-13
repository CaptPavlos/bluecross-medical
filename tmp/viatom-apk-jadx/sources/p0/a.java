package p0;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f11873a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f11874b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f11873a;
        if (context2 != null && (bool = f11874b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f11874b = null;
        if (n0.b.a()) {
            f11874b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f11874b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f11874b = Boolean.FALSE;
            }
        }
        f11873a = applicationContext;
        return f11874b.booleanValue();
    }
}
