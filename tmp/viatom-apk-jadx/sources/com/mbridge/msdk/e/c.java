package com.mbridge.msdk.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import f0.f;
import f0.g;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f3308a = "";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f3309b = false;

    public static void a() {
        if (ah.a().a("cronet_env_check", false)) {
            try {
                Object obj = f0.e.f8000c;
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                int i10 = g.e;
                try {
                    int i11 = contextC.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
                }
                f.c(com.mbridge.msdk.foundation.controller.c.m().c());
                try {
                    String strB = b();
                    boolean zIsEmpty = TextUtils.isEmpty(strB);
                    f3309b = !zIsEmpty;
                    if (zIsEmpty) {
                        return;
                    }
                    f3308a = strB;
                } catch (Throwable th) {
                    af.b("CronetEnvCheckUtil", th.getMessage());
                }
            } catch (Throwable th2) {
                af.b("CronetEnvCheckUtil", th2.getMessage());
                f3309b = false;
            }
        }
    }

    private static String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create(1, "org.chromium.net.impl.JavaCronetProvider"));
        arrayList.add(Pair.create(2, "org.chromium.net.impl.NativeCronetProvider"));
        arrayList.add(Pair.create(3, "com.google.android.gms.net.PlayServicesCronetProvider"));
        arrayList.add(Pair.create(4, "com.google.android.gms.net.GmsCoreCronetProvider"));
        try {
            StringBuilder sb = new StringBuilder();
            ClassLoader classLoader = com.mbridge.msdk.foundation.controller.c.m().c().getClassLoader();
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                Pair pair = (Pair) obj;
                try {
                    if (!TextUtils.isEmpty(classLoader.loadClass((String) pair.second).getConstructor(Context.class).newInstance(com.mbridge.msdk.foundation.controller.c.m().c()).getClass().getName())) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(pair.first);
                    }
                } catch (Throwable th) {
                    af.b("CronetEnvCheckUtil", th.getMessage());
                }
            }
            return sb.toString();
        } catch (Throwable th2) {
            af.b("CronetEnvCheckUtil", th2.getMessage());
            return "";
        }
    }
}
