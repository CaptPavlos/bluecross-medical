package com.mbridge.msdk.foundation.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.b;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f3999a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f4000b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f4001c = false;

    /* renamed from: d, reason: collision with root package name */
    public static int f4002d = 0;
    private static String e = "";
    private static boolean f = false;
    private static String g = "";
    private static boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f4003i = false;

    public static /* synthetic */ void a(Context context, String str, int i10) {
        try {
            if (ap.b(str)) {
                an.b(context, MBridgeConstans.SP_GA_ID, str);
            }
            an.b(context, MBridgeConstans.SP_GA_ID_LIMIT, Integer.valueOf(i10));
        } catch (Exception e3) {
            af.b("DomainSameDiTool", e3.getMessage());
        }
    }

    public static String b() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.k() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
            return TextUtils.isEmpty(f4000b) ? "" : f4000b;
        }
        if (!TextUtils.isEmpty(f4000b)) {
            return !com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? f4002d == 0 ? f4000b : "" : f4000b;
        }
        if (!f4001c) {
            a(com.mbridge.msdk.foundation.controller.c.m().c());
            f4001c = true;
        }
        return "";
    }

    public static String c() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.k() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
            return TextUtils.isEmpty(f3999a) ? "" : f3999a;
        }
        if (!TextUtils.isEmpty(f3999a)) {
            return !com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? f4002d == 0 ? f3999a : "" : f3999a;
        }
        ab.j();
        if (!f4001c) {
            a(com.mbridge.msdk.foundation.controller.c.m().c());
            f4001c = true;
        }
        return TextUtils.isEmpty(f3999a) ? "" : f3999a;
    }

    public static String d() {
        if (TextUtils.isEmpty(g) && !f) {
            e();
        }
        return g;
    }

    public static String e() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.k() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (f) {
            return e;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                ContentResolver contentResolver = com.mbridge.msdk.foundation.controller.c.m().c().getContentResolver();
                int i10 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, i10);
                jSONObject.put("amazonId", string);
                String string2 = jSONObject.toString();
                if (!TextUtils.isEmpty(string2)) {
                    g = string2;
                    e = z.b(string2);
                }
            } catch (Settings.SettingNotFoundException e3) {
                af.b("DomainSameDiTool", e3.getMessage());
            }
        } catch (Throwable th) {
            af.b("DomainSameDiTool", th.getMessage());
        }
        f = true;
        return e;
    }

    public static void a(int i10) {
        f4002d = i10;
    }

    public static void a(final Context context) {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.f.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID) && com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
                    try {
                        a0.a aVarA = a0.b.a(context);
                        String str = aVarA.f5b;
                        f.a(str);
                        boolean z9 = aVarA.f6c;
                        f.f4002d = z9 ? 1 : 0;
                        f.a(context, str, z9 ? 1 : 0);
                    } catch (Exception unused) {
                        af.d("DomainSameDiTool", "GET ADID ERROR TRY TO GET FROM GOOGLE PLAY APP");
                        try {
                            b.a aVarA2 = new b().a(context);
                            f.a(aVarA2.a());
                            f.f4002d = aVarA2.b() ? 1 : 0;
                            f.a(context, aVarA2.a(), f.f4002d);
                        } catch (Exception unused2) {
                            af.d("DomainSameDiTool", "GET ADID FROM GOOGLE PLAY APP ERROR");
                        }
                    } catch (Throwable th) {
                        af.b("DomainSameDiTool", th.getMessage());
                    }
                }
            }
        }).start();
    }

    public static void a(String str) {
        f4000b = z.b(str);
        f3999a = str;
    }

    public static int a() {
        return f4002d;
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        try {
            WebEnvCheckEntry.class.getMethod("check", Context.class).invoke(WebEnvCheckEntry.class.newInstance(), context);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static boolean c(Context context) {
        try {
        } catch (Exception unused) {
            h = false;
        }
        if (f4003i) {
            return h;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            h = context.getPackageManager().checkPermission(z.a("DkP3hrKuHoPMH+zwL+fALkK/WQc5x5zH+TcincKNNVfWNVJcVM=="), context.getPackageName()) == 0;
        } else {
            h = true;
        }
        f4003i = true;
        return h;
    }
}
