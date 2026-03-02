package com.mbridge.msdk.foundation.tools;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ah;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public final class ab extends k {
    private static String A = "";
    private static Object B = null;
    private static int C = 0;
    private static int D = 0;
    private static String E = "";
    private static String e = "";
    private static String f = "";
    private static int g = -1;
    private static String h = "";

    /* renamed from: i, reason: collision with root package name */
    private static int f3905i = -1;

    /* renamed from: j, reason: collision with root package name */
    private static int f3906j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static String f3907k = "";

    /* renamed from: l, reason: collision with root package name */
    private static int f3908l = -1;

    /* renamed from: m, reason: collision with root package name */
    private static String f3909m = "";

    /* renamed from: n, reason: collision with root package name */
    private static String f3910n = "";

    /* renamed from: o, reason: collision with root package name */
    private static volatile int f3911o = -1;

    /* renamed from: p, reason: collision with root package name */
    private static String f3912p = "";

    /* renamed from: q, reason: collision with root package name */
    private static String f3913q = "";

    /* renamed from: r, reason: collision with root package name */
    private static int f3914r = -1;

    /* renamed from: s, reason: collision with root package name */
    private static int f3915s = -1;
    private static int t = 0;

    /* renamed from: u, reason: collision with root package name */
    private static String f3916u = "";

    /* renamed from: v, reason: collision with root package name */
    private static String f3917v = null;

    /* renamed from: w, reason: collision with root package name */
    private static int f3918w = 0;

    /* renamed from: x, reason: collision with root package name */
    private static String f3919x = "";
    private static int y = -1;

    /* renamed from: z, reason: collision with root package name */
    private static int f3920z;

    private static String A(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f = "";
            } else if (TextUtils.isEmpty(f)) {
                f = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            f = "";
        }
        return f;
    }

    private static void B() {
        String str = Build.VERSION.RELEASE;
        String strH = h();
        String str2 = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(strH)) {
            f3919x = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            return;
        }
        StringBuilder sb = new StringBuilder("Mozilla/5.0 (Linux; Android ");
        sb.append(str);
        sb.append("; ");
        sb.append(strH);
        sb.append(" Build/");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        f3919x = a3.a.o(sb, str2, ") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
    }

    private static long C() {
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (contextC == null) {
            return 0L;
        }
        ActivityManager activityManager = (ActivityManager) contextC.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static String D() {
        String str;
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", null).invoke(cls, null);
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage());
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str) || !str.equals("harmony")) {
                h = "android";
            } else {
                jSONObject.put("osType", str);
                try {
                    Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
                    jSONObject.put("version", (String) cls2.getMethod("getVersion", null).invoke(cls2, null));
                } catch (Throwable th2) {
                    af.b("SameDiTool", th2.getMessage());
                }
                try {
                    jSONObject.put("pure_state", Settings.Secure.getInt(com.mbridge.msdk.foundation.controller.c.m().c().getContentResolver(), "pure_mode_state", -1));
                } catch (Throwable th3) {
                    af.b("SameDiTool", th3.getMessage());
                }
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    string = z.b(string);
                }
                h = string;
            }
        } catch (Throwable th4) {
            af.b("SameDiTool", th4.getMessage());
        }
        return h;
    }

    public static String a(String str, Context context) {
        try {
        } catch (Exception e3) {
            af.b("SameDiTool", e3.getMessage(), e3);
        }
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        if (!TextUtils.isEmpty(str) && context != null) {
            e = context.getPackageManager().getInstallerPackageName(str);
            af.a("SameDiTool", "PKGSource:" + e);
        }
        return e;
    }

    public static int b(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    public static int c(String str) {
        if (D == 0) {
            D = ak.f(str);
        }
        return D;
    }

    public static void e(final Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                f.b(context);
            } else {
                new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.ab.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.b(context);
                    }
                });
            }
        } catch (Exception e3) {
            af.b("SameDiTool", "", e3);
        }
    }

    public static int f() {
        try {
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage(), th);
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return 0;
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        long j10 = 0;
        long jLongValue = ((Long) an.a(contextC, "FreeRamSize", 0L)).longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jLongValue > 1800000 || f3914r == -1) {
            Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
            if (contextC2 != null) {
                ActivityManager activityManager = (ActivityManager) contextC2.getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                j10 = memoryInfo.availMem;
            }
            f3914r = Long.valueOf((j10 / 1000) / 1000).intValue();
            an.b(contextC, "FreeRamSize", Long.valueOf(jCurrentTimeMillis));
        }
        return f3914r;
    }

    public static String g(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return null;
        }
        if (TextUtils.isEmpty(f3919x)) {
            try {
                f3919x = an.a(context, "mbridge_ua", "").toString();
            } catch (Throwable th) {
                af.b("SameDiTool", th.getMessage(), th);
            }
        }
        try {
            if (Looper.myLooper() != Looper.getMainLooper() || MBridgeConstans.DNT_GUA_ON_UI) {
                if (TextUtils.isEmpty(f3919x)) {
                    B();
                }
                y(context);
            } else if (TextUtils.isEmpty(f3919x)) {
                try {
                    f3919x = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(f3919x)) {
                    try {
                        Constructor declaredConstructor = WebSettings.class.getDeclaredConstructor(Context.class, WebView.class);
                        declaredConstructor.setAccessible(true);
                        f3919x = ((WebSettings) declaredConstructor.newInstance(context, null)).getUserAgentString();
                        declaredConstructor.setAccessible(false);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    if (TextUtils.isEmpty(f3919x)) {
                        try {
                            f3919x = new WebView(context).getSettings().getUserAgentString();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(f3919x)) {
                        B();
                    }
                }
            } else {
                y(context);
            }
        } catch (Throwable th4) {
            af.b("SameDiTool", th4.getMessage(), th4);
        }
        z(context);
        return f3919x;
    }

    public static int h(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap mapI = i(context);
            return mapI.get("height") == null ? displayMetrics.heightPixels : ((Integer) mapI.get("height")).intValue();
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0;
        }
    }

    public static HashMap i(Context context) {
        HashMap map = new HashMap();
        if (context == null) {
            return map;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            map.put("height", Integer.valueOf(displayMetrics.heightPixels));
            map.put("width", Integer.valueOf(displayMetrics.widthPixels));
            return map;
        } catch (Exception e3) {
            af.b("SameDiTool", e3.getMessage(), e3);
            return map;
        }
    }

    public static void j() {
        try {
            Object objA = an.a(com.mbridge.msdk.foundation.controller.c.m().c(), MBridgeConstans.SP_GA_ID, "");
            Object objA2 = an.a(com.mbridge.msdk.foundation.controller.c.m().c(), MBridgeConstans.SP_GA_ID_LIMIT, 0);
            if (objA instanceof String) {
                String str = (String) objA;
                if (!TextUtils.isEmpty(str)) {
                    f.a(str);
                }
                if (objA2 instanceof Integer) {
                    f.f4002d = ((Integer) objA2).intValue();
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                af.b("SameDiTool", e3.getMessage());
            }
        }
    }

    public static String k(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f3909m = "";
            } else if (TextUtils.isEmpty(f3909m)) {
                if (context == null) {
                    f3909m = "";
                    return "";
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (ak.j(simOperator)) {
                    f3909m = simOperator.substring(0, Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            f3909m = "";
        }
        return f3909m;
    }

    public static String l(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f3910n = "";
            } else if (TextUtils.isEmpty(f3910n)) {
                if (context == null) {
                    f3910n = "";
                    return f3909m;
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (ak.j(simOperator)) {
                    f3910n = simOperator.substring(Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            f3910n = "";
        }
        return f3910n;
    }

    @SuppressLint({"MissingPermission"})
    public static int m(Context context) {
        try {
            final Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return f3911o;
            }
            if (contextC == null) {
                return f3911o;
            }
            if (f3911o == -1) {
                f3911o = 0;
                return f3911o;
            }
            try {
                Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.ab.3
                    @Override // java.lang.Runnable
                    @SuppressLint({"MissingPermission"})
                    public final void run() {
                        try {
                            ConnectivityManager connectivityManager = (ConnectivityManager) contextC.getSystemService("connectivity");
                            if (connectivityManager != null && com.mbridge.msdk.foundation.same.a.f3620z) {
                                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                if (activeNetworkInfo == null) {
                                    int unused = ab.f3911o = 0;
                                    return;
                                }
                                if (activeNetworkInfo.getType() == 1) {
                                    int unused2 = ab.f3911o = 9;
                                    return;
                                }
                                TelephonyManager telephonyManager = (TelephonyManager) contextC.getSystemService("phone");
                                if (telephonyManager == null) {
                                    int unused3 = ab.f3911o = 0;
                                } else {
                                    int unused4 = ab.f3911o = ab.b(telephonyManager.getNetworkType());
                                }
                            }
                        } catch (Exception e3) {
                            af.b("SameDiTool", e3.getMessage(), e3);
                            int unused5 = ab.f3911o = 0;
                        }
                    }
                };
                if (com.mbridge.msdk.foundation.same.f.a.d().getActiveCount() < 1) {
                    com.mbridge.msdk.foundation.same.f.a.d().execute(runnable);
                }
            } catch (Throwable th) {
                af.b("SameDiTool", th.getMessage());
            }
            return f3911o;
        } catch (Exception e3) {
            af.b("SameDiTool", e3.getMessage(), e3);
            f3911o = 0;
            return f3911o;
        }
    }

    public static String n() throws JSONException {
        Context contextC;
        long jA;
        long jC;
        String strA;
        String str;
        String str2;
        String strA2 = "";
        try {
            contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            jA = aa.a();
            jC = C();
            strA = A(contextC);
            str = "app_tki_" + jA + "_" + jC + "_" + strA;
            str2 = (String) an.a(contextC, str, "");
            try {
            } catch (Exception e3) {
                e = e3;
                strA2 = str2;
                e.printStackTrace();
                return strA2;
            }
        } catch (Exception e7) {
            e = e7;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("1", strA);
            jSONObject.put("2", String.valueOf(jC));
            jSONObject.put(ExifInterface.GPS_MEASUREMENT_3D, String.valueOf(jA));
            jSONObject.put("4", "");
            jSONObject.put(CampaignEx.CLICKMODE_ON, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        strA2 = a.a(jSONObject.toString());
        an.b(contextC, str, strA2);
        return strA2;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x008c A[EXC_TOP_SPLITTER, PHI: r3 r4
      0x008c: PHI (r3v4 java.io.BufferedReader) = (r3v2 java.io.BufferedReader), (r3v5 java.io.BufferedReader) binds: [B:42:0x008a, B:55:0x00b0] A[DONT_GENERATE, DONT_INLINE]
      0x008c: PHI (r4v5 java.io.FileReader) = (r4v3 java.io.FileReader), (r4v6 java.io.FileReader) binds: [B:42:0x008a, B:55:0x00b0] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String o(android.content.Context r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "SameDiTool"
            com.mbridge.msdk.foundation.controller.authoritycontroller.c r1 = com.mbridge.msdk.foundation.controller.authoritycontroller.c.j()
            java.lang.String r2 = "authority_general_data"
            boolean r1 = r1.c(r2)
            java.lang.String r2 = ""
            if (r1 != 0) goto L11
            return r2
        L11:
            if (r9 != 0) goto L14
            return r2
        L14:
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.ab.f3917v
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1f
            java.lang.String r9 = com.mbridge.msdk.foundation.tools.ab.f3917v
            return r9
        L1f:
            java.lang.String r1 = "/proc/meminfo"
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            r5 = 8192(0x2000, float:1.148E-41)
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            r5 = 1
            r3 = r3[r5]     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            long r5 = r3.longValue()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            r7 = 1024(0x400, double:5.06E-321)
            long r5 = r5 * r7
            java.lang.String r9 = android.text.format.Formatter.formatFileSize(r9, r5)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            com.mbridge.msdk.foundation.tools.ab.f3917v = r9     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L68
            r1.close()     // Catch: java.io.IOException -> L50
            goto L58
        L50:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r2, r1)
        L58:
            r4.close()     // Catch: java.io.IOException -> L5c
            goto L64
        L5c:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r2, r1)
        L64:
            return r9
        L65:
            r9 = move-exception
            r3 = r1
            goto L75
        L68:
            r9 = move-exception
            r3 = r1
            goto L9b
        L6b:
            r9 = move-exception
            goto L75
        L6d:
            r9 = move-exception
            goto L9b
        L6f:
            r9 = move-exception
            r4 = r3
            goto L75
        L72:
            r9 = move-exception
            r4 = r3
            goto L9b
        L75:
            java.lang.String r1 = r9.getMessage()     // Catch: java.lang.Throwable -> L99
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)     // Catch: java.lang.Throwable -> L99
            if (r3 == 0) goto L8a
            r3.close()     // Catch: java.io.IOException -> L82
            goto L8a
        L82:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)
        L8a:
            if (r4 == 0) goto Lb3
        L8c:
            r4.close()     // Catch: java.io.IOException -> L90
            goto Lb3
        L90:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)
            goto Lb3
        L99:
            r9 = move-exception
            goto Lb4
        L9b:
            java.lang.String r1 = r9.getMessage()     // Catch: java.lang.Throwable -> L99
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)     // Catch: java.lang.Throwable -> L99
            if (r3 == 0) goto Lb0
            r3.close()     // Catch: java.io.IOException -> La8
            goto Lb0
        La8:
            r9 = move-exception
            java.lang.String r1 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r9)
        Lb0:
            if (r4 == 0) goto Lb3
            goto L8c
        Lb3:
            return r2
        Lb4:
            if (r3 == 0) goto Lc2
            r3.close()     // Catch: java.io.IOException -> Lba
            goto Lc2
        Lba:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r2, r1)
        Lc2:
            if (r4 == 0) goto Ld0
            r4.close()     // Catch: java.io.IOException -> Lc8
            goto Ld0
        Lc8:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r2, r1)
        Ld0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ab.o(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006a A[EXC_TOP_SPLITTER, PHI: r1 r4
      0x006a: PHI (r1v13 java.io.BufferedReader) = 
      (r1v10 java.io.BufferedReader)
      (r1v11 java.io.BufferedReader)
      (r1v18 java.io.BufferedReader)
      (r1v18 java.io.BufferedReader)
     binds: [B:37:0x0093, B:44:0x00a4, B:56:0x006a, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r4v6 java.io.FileReader) = (r4v3 java.io.FileReader), (r4v4 java.io.FileReader), (r4v7 java.io.FileReader), (r4v7 java.io.FileReader) binds: [B:37:0x0093, B:44:0x00a4, B:56:0x006a, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String p() throws java.io.IOException {
        /*
            java.lang.String r0 = "SameDiTool"
            com.mbridge.msdk.foundation.controller.authoritycontroller.c r1 = com.mbridge.msdk.foundation.controller.authoritycontroller.c.j()
            java.lang.String r2 = "authority_general_data"
            boolean r1 = r1.c(r2)
            if (r1 != 0) goto L11
            java.lang.String r0 = ""
            return r0
        L11:
            int r1 = com.mbridge.msdk.foundation.tools.ab.f3918w
            java.lang.String r2 = "GB"
            if (r1 <= 0) goto L23
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.mbridge.msdk.foundation.tools.ab.f3918w
            java.lang.String r0 = a3.a.n(r0, r2, r1)
            return r0
        L23:
            java.lang.String r1 = "/proc/meminfo"
            r3 = 0
            com.mbridge.msdk.foundation.tools.ab.f3918w = r3
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L78
            r5 = 8192(0x2000, float:1.148E-41)
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L78
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r5 = 1
            r3 = r3[r5]     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r1.close()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            if (r3 == 0) goto L67
            java.lang.Float r5 = new java.lang.Float     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            float r3 = r3.floatValue()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r6 = 1233125376(0x49800000, float:1048576.0)
            float r3 = r3 / r6
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            double r5 = r5.doubleValue()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            double r5 = java.lang.Math.ceil(r5)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            int r3 = (int) r5     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            com.mbridge.msdk.foundation.tools.ab.f3918w = r3     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            goto L67
        L63:
            r3 = move-exception
            goto L87
        L65:
            r3 = move-exception
            goto L98
        L67:
            r4.close()     // Catch: java.io.IOException -> L6a
        L6a:
            r1.close()     // Catch: java.io.IOException -> L6e
            goto La7
        L6e:
            r0 = move-exception
            r0.printStackTrace()
            goto La7
        L73:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L87
        L78:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L98
        L7d:
            r1 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L87
        L82:
            r1 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L98
        L87:
            java.lang.String r5 = r3.getMessage()     // Catch: java.lang.Throwable -> L96
            com.mbridge.msdk.foundation.tools.af.b(r0, r5, r3)     // Catch: java.lang.Throwable -> L96
            if (r4 == 0) goto L93
            r4.close()     // Catch: java.io.IOException -> L93
        L93:
            if (r1 == 0) goto La7
            goto L6a
        L96:
            r0 = move-exception
            goto Lb3
        L98:
            java.lang.String r5 = r3.getMessage()     // Catch: java.lang.Throwable -> L96
            com.mbridge.msdk.foundation.tools.af.b(r0, r5, r3)     // Catch: java.lang.Throwable -> L96
            if (r4 == 0) goto La4
            r4.close()     // Catch: java.io.IOException -> La4
        La4:
            if (r1 == 0) goto La7
            goto L6a
        La7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.mbridge.msdk.foundation.tools.ab.f3918w
            java.lang.String r0 = a3.a.n(r0, r2, r1)
            return r0
        Lb3:
            if (r4 == 0) goto Lb8
            r4.close()     // Catch: java.io.IOException -> Lb8
        Lb8:
            if (r1 == 0) goto Lc2
            r1.close()     // Catch: java.io.IOException -> Lbe
            goto Lc2
        Lbe:
            r1 = move-exception
            r1.printStackTrace()
        Lc2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ab.p():java.lang.String");
    }

    public static int q() {
        try {
        } catch (Exception e3) {
            f3906j = 0;
            af.b("SameDiTool", e3.getMessage());
        }
        if (!ah.a.f3940a.a("v_a_d_p", false)) {
            return 0;
        }
        if (ak.h()) {
            f3906j = 1;
        } else if (ak.i()) {
            f3906j = 2;
        } else {
            f3906j = 0;
        }
        return f3906j;
    }

    public static int r(Context context) {
        if (context == null) {
            return f3920z;
        }
        int i10 = f3920z;
        if (i10 != 0) {
            return i10;
        }
        try {
            int i11 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            f3920z = i11;
            return i11;
        } catch (Exception e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public static int s(Context context) {
        Configuration configuration;
        return (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null || configuration.orientation != 2) ? 1 : 2;
    }

    public static String t(Context context) {
        Locale locale;
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(f3907k)) {
            if (context == null) {
                return "en-US";
            }
            try {
                if (context.getResources() == null || context.getResources().getConfiguration() == null || (locale = context.getResources().getConfiguration().locale) == null) {
                    return "en-US";
                }
                String languageTag = locale.toLanguageTag();
                f3907k = languageTag;
                return languageTag;
            } catch (Throwable th) {
                af.a("SameDiTool", th.getMessage());
                f3907k = "en-US";
            }
        }
        return f3907k;
    }

    public static int u(Context context) {
        if (context == null) {
            return t;
        }
        if (t == 0) {
            try {
                t = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e3) {
                af.b("SameDiTool", e3.getMessage());
            }
        }
        return t;
    }

    public static int v(Context context) {
        if (g == -1) {
            g = ak.c(context, "com.tencent.mm") ? 1 : 0;
        }
        return g;
    }

    public static String w() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(f3912p)) {
            f3912p = s() + "";
        }
        return f3912p;
    }

    public static String x() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BRAND;
    }

    public static String y() {
        try {
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage(), th);
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
            return "";
        }
        if (TextUtils.isEmpty(f3916u)) {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.ab.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        String unused = ab.f3916u = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }).start();
            return f3916u;
        }
        return f3916u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(Context context) {
        try {
            an.b(context, "mbridge_ua", f3919x);
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage(), th);
        }
    }

    public static void c(int i10) {
        f3908l = i10;
    }

    public static Object b(String str) {
        if (B == null) {
            B = ak.g(str);
        }
        return B;
    }

    public static int v() {
        return f3908l;
    }

    public static int z() {
        if (f3905i == -1) {
            f3905i = ak.f() ? 1 : 0;
        }
        return f3905i;
    }

    public static int s() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0;
        }
    }

    public static int u() {
        if (C == 0) {
            C = ak.e();
        }
        return C;
    }

    public static int r() {
        try {
            if (ak.h()) {
                return 1;
            }
            return ak.i() ? 2 : 0;
        } catch (Exception e3) {
            af.b("SameDiTool", e3.getMessage());
            return 0;
        }
    }

    public static boolean w(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private static void y(final Context context) {
        try {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.ab.2
                @Override // java.lang.Runnable
                public final void run() {
                    String defaultUserAgent;
                    try {
                        defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    } catch (Throwable unused) {
                        defaultUserAgent = null;
                    }
                    try {
                        if (TextUtils.isEmpty(defaultUserAgent) || defaultUserAgent.equals(ab.f3919x)) {
                            return;
                        }
                        String unused2 = ab.f3919x = defaultUserAgent;
                        ab.z(context);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static String q(Context context) {
        if (context == null) {
            return A;
        }
        try {
            if (TextUtils.isEmpty(A)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                A = str;
                return str;
            }
            return A;
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String h() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MODEL;
    }

    public static String i() {
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA);
        return "";
    }

    public static String a(Context context, int i10) {
        TelephonyManager telephonyManager;
        if (i10 != 0 && i10 != 9) {
            try {
                if (!com.mbridge.msdk.foundation.same.a.f3620z || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                    return "";
                }
                return String.valueOf(telephonyManager.getNetworkType());
            } catch (Throwable th) {
                af.b("SameDiTool", th.getMessage(), th);
            }
        }
        return "";
    }

    public static int k() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return Build.VERSION.SDK_INT;
        }
        return -1;
    }

    public static String l() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER;
    }

    public static int j(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap mapI = i(context);
            return mapI.get("width") == null ? displayMetrics.widthPixels : ((Integer) mapI.get("width")).intValue();
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0;
        }
    }

    public static int t() {
        return y;
    }

    public static String m() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String f(Context context) {
        if (context == null) {
            return f3913q;
        }
        try {
            if (TextUtils.isEmpty(f3913q)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                f3913q = str;
                return str;
            }
            return f3913q;
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String n(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "time_12_24");
        } catch (Exception e3) {
            af.b("SameDiTool", e3.getMessage(), e3);
            return "";
        } catch (Throwable th) {
            af.b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    public static void p(Context context) {
        try {
            f.a(context);
            w();
            f(context);
            q(context);
            r(context);
            s(context);
            h();
            x();
            t(context);
            y();
            com.mbridge.msdk.foundation.same.a.B = false;
            com.mbridge.msdk.foundation.same.a.f3620z = ak.a("android.permission.ACCESS_NETWORK_STATE", context);
            u(context);
            D();
            f.e();
            try {
                com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.ab.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.mbridge.msdk.e.c.a();
                        } catch (Exception e3) {
                            af.b("SameDiTool", e3.getMessage());
                        }
                    }
                });
            } catch (Throwable th) {
                af.b("SameDiTool", th.getMessage());
            }
        } catch (Throwable th2) {
            af.b("SameDiTool", th2.getMessage());
        }
    }

    public static String g() {
        if (TextUtils.isEmpty(f3919x)) {
            g(com.mbridge.msdk.foundation.controller.c.m().c());
        }
        return f3919x;
    }

    public static int o() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return 0;
        }
        if (f3915s < 1) {
            try {
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                long jLongValue = ((Long) an.a(contextC, "TotalRamSize", 0L)).longValue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - jLongValue > 1800000 || f3915s == -1) {
                    f3915s = Long.valueOf((C() / 1000) / 1000).intValue();
                    an.b(contextC, "TotalRamSize", Long.valueOf(jCurrentTimeMillis));
                }
            } catch (Throwable th) {
                af.b("SameDiTool", th.getMessage(), th);
            }
        }
        return f3915s;
    }
}
