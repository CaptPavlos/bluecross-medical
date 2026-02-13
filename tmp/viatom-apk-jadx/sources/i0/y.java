package i0;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f8956a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f8957b;

    /* renamed from: c, reason: collision with root package name */
    public static int f8958c;

    public static void a(String str, boolean z9) {
        if (z9) {
            return;
        }
        com.google.gson.internal.a.n(str);
    }

    public static void b(boolean z9) {
        if (z9) {
            return;
        }
        z8.f.a();
    }

    public static void c(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            androidx.window.layout.c.i("Must be called on ", handler.getLooper().getThread().getName(), " thread, but got ", looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper", ".");
        }
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.gson.internal.a.n("Given String is empty or null");
        }
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.google.gson.internal.a.n(str2);
        }
    }

    public static void f(String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return;
        }
        androidx.window.layout.c.g(str);
    }

    public static void g(Object obj) {
        if (obj != null) {
            return;
        }
        androidx.window.layout.c.k("null reference");
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        androidx.window.layout.c.k(str);
    }

    public static void i(boolean z9, String str) {
        if (z9) {
            return;
        }
        androidx.window.layout.c.g(str);
    }

    public static boolean j(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
