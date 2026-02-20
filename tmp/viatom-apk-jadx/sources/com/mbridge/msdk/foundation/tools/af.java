package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f3927a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f3928b = true;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f3929c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f3930d = false;
    public static boolean e = true;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = true;

    static {
        if (MBridgeConstans.DEBUG) {
            return;
        }
        g = false;
        f3927a = false;
        f3929c = false;
        h = false;
        f3928b = false;
        f = false;
        e = false;
        f3930d = false;
    }

    public static void a(String str, String str2) {
        if (!f3927a || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(a(str), str2);
    }

    public static void b(String str, String str2, Throwable th) {
        if (!f3928b || str2 == null || th == null) {
            return;
        }
        Log.e(a(str), str2, th);
    }

    public static void c(String str, String str2) {
        if (!f3929c || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(a(str), str2);
    }

    public static void d(String str, String str2) {
        if (!h || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2);
    }

    public static void b(String str, String str2) {
        if (!f3928b || str2 == null) {
            return;
        }
        Log.e(a(str), str2);
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? a3.a.i("MBRIDGE_", str) : str;
    }

    public static void c(String str, String str2, Throwable th) {
        if (!h || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2, th);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!f3927a || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(a(str), str2, th);
    }

    public static void a(String str, Throwable th) {
        if (!h || th == null) {
            return;
        }
        Log.w(a(str), th);
    }
}
