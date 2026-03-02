package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.MIMManager;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ak extends n {

    /* renamed from: a, reason: collision with root package name */
    private static int f3948a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static int f3949b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static int f3950c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static int f3951d = 3;
    private static int e = 0;
    private static int f = 7;
    private static int g = 14;
    private static int h = 19;

    /* renamed from: i, reason: collision with root package name */
    private static int f3952i = 16;

    /* renamed from: j, reason: collision with root package name */
    private static int f3953j = 26;

    /* renamed from: k, reason: collision with root package name */
    private static char[] f3954k = {'.', 'X'};

    /* renamed from: l, reason: collision with root package name */
    private static char[] f3955l = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};

    /* renamed from: m, reason: collision with root package name */
    private static int f3956m = 1;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f3957n = true;

    /* renamed from: o, reason: collision with root package name */
    private static volatile Boolean f3958o = null;

    /* renamed from: p, reason: collision with root package name */
    private static String f3959p = "[一-龥]";

    /* renamed from: q, reason: collision with root package name */
    private static Pattern f3960q = Pattern.compile("[一-龥]");

    /* renamed from: r, reason: collision with root package name */
    private static Map<String, String> f3961r;

    /* renamed from: s, reason: collision with root package name */
    private static Map<String, String> f3962s;

    private static String a(String str, Map<String, String> map) {
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                StringBuilder sb = new StringBuilder(str);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        String value = entry.getValue();
                        if (str.contains(entry.getKey())) {
                            sb = value.equals("0") ? new StringBuilder(str.replaceAll("(" + entry.getKey() + "[^&]*)", "")) : new StringBuilder(str.replaceAll("(" + entry.getKey() + "[^&]*)", entry.getKey() + entry.getValue()));
                        } else if (!value.equals("0")) {
                            sb.append(entry.getKey() + entry.getValue());
                        }
                    }
                }
                return sb.toString();
            }
            return str;
        } catch (Exception e3) {
            af.b("SameTools", e3.getMessage());
            return str;
        }
    }

    public static JSONArray b(Context context, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            if (gVarB != null && gVarB.t() == 1) {
                af.c("SameTools", "fqci cfc:" + gVarB.t());
                String[] strArrB = com.mbridge.msdk.foundation.db.a.a.a().b();
                if (strArrB != null) {
                    for (String str2 : strArrB) {
                        af.c("SameTools", "cfc campaignIds:" + strArrB);
                        jSONArray.put(str2);
                    }
                }
            }
            return jSONArray;
        } catch (Exception e3) {
            e3.printStackTrace();
            return jSONArray;
        }
    }

    private static final char[] c(int i10) {
        StringBuilder sb;
        if (i10 == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(aj.f3945a, f)));
            sb.append(f3954k[e]);
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f3945a, f, g)));
            sb.append(f3954k[e]);
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f3945a, g, f3952i)));
            sb.append(f3954k[e]);
            sb.append(String.valueOf(ai.f3941a));
        } else if (i10 == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(aj.f3945a, f)));
            sb.append(f3954k[e]);
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f3945a, f, g)));
            sb.append(f3954k[e]);
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f3945a, h, f3953j)));
        } else if (i10 == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f3945a, f3952i, h)));
            sb.append(String.valueOf(f3955l));
        } else if (i10 != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(aj.f3945a, f3952i, h)));
            sb.append(String.valueOf(ai.f3941a));
        }
        return sb.toString().toCharArray();
    }

    public static String d() {
        String str;
        try {
            str = UUID.randomUUID().toString() + System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
            str = "";
        }
        if (!ap.a(str)) {
            return str;
        }
        return System.currentTimeMillis() + "";
    }

    public static final synchronized String e(String str) {
        String str2;
        int i10;
        boolean zAD;
        int iMax;
        boolean zAI;
        JSONObject jSONObject;
        Map<String, String> map;
        try {
            str2 = com.mbridge.msdk.foundation.controller.c.m().k() + "_" + str;
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB != null) {
                zAD = gVarB.aD();
                zAI = gVarB.aI();
                iMax = Math.max(0, gVarB.ae());
            } else {
                zAD = true;
                iMax = 3;
                zAI = false;
            }
        } catch (Exception e3) {
            af.b("SameTools", e3.getMessage());
        } finally {
        }
        if (zAI && iMax != 0) {
            if (zAD && (map = f3961r) != null && map.containsKey(str2)) {
                return f3961r.get(str2);
            }
            StringBuilder sb = new StringBuilder("");
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                List<String> listA = a(stackTrace);
                Collections.reverse(listA);
                ArrayList arrayList = new ArrayList();
                for (String str3 : listA) {
                    if (!str3.startsWith(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_OS) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_APP) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_REFLECT_METHOD) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_VIEW) && !arrayList.contains(str3)) {
                        arrayList.add(str3);
                    }
                }
                int iMin = Math.min(arrayList.size(), iMax);
                if (iMin > 0) {
                    for (i10 = 0; i10 < iMin; i10++) {
                        sb.append((String) arrayList.get(i10));
                        if (i10 < iMin - 1) {
                            sb.append("|");
                        }
                    }
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    jSONObject = null;
                } else {
                    jSONObject = new JSONObject();
                    jSONObject.put("1", sb.toString());
                }
                if (jSONObject == null || jSONObject.length() <= 0) {
                    return "";
                }
                String strA = a.a(jSONObject.toString());
                if (zAD && !TextUtils.isEmpty(strA)) {
                    if (f3961r == null) {
                        f3961r = new HashMap();
                    }
                    f3961r.put(str2, strA);
                }
                return strA;
            }
            return "";
        }
        return "";
    }

    public static int f(String str) {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", null).invoke(ab.b(str), null)).intValue();
        } catch (Throwable th) {
            af.b("SameTools", th.getMessage());
            return 0;
        }
    }

    public static Object g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", Context.class, String.class).invoke(null, com.mbridge.msdk.foundation.controller.c.m().c(), str);
        } catch (ClassNotFoundException e3) {
            af.b("SameTools", e3.getMessage());
            return null;
        } catch (IllegalAccessException e7) {
            af.b("SameTools", e7.getMessage());
            return null;
        } catch (NoSuchMethodException e10) {
            af.b("SameTools", e10.getMessage());
            return null;
        } catch (InvocationTargetException e11) {
            af.b("SameTools", e11.getMessage());
            return null;
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                String queryParameter = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_CAN_ANIM);
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter.equals("1");
                }
            }
            return false;
        } catch (Exception e3) {
            af.b("SameTools", e3.getMessage());
            return false;
        }
    }

    public static boolean i() {
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().c() == null) {
                return false;
            }
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            int i10 = Integer.parseInt(property2);
            af.a("address = ", property + "~");
            af.a("port = ", i10 + "~");
            return (TextUtils.isEmpty(property) || i10 == -1) ? false : true;
        } catch (Throwable th) {
            af.b("SameTools", th.getMessage());
            return false;
        }
    }

    public static void j() {
        HandlerThread handlerThread = new HandlerThread("mb_db_thread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
        builder.setDatabaseHandler(handler);
        builder.setDatabaseOpenHelper(new IDatabaseOpenHelper() { // from class: com.mbridge.msdk.foundation.tools.ak.2
            @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
            public final SQLiteDatabase getReadableDatabase() {
                return com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()).c();
            }

            @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
            public final SQLiteDatabase getWritableDatabase() {
                return com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()).d();
            }
        });
        builder.setLogger(new ILogger() { // from class: com.mbridge.msdk.foundation.tools.ak.3
            @Override // com.mbridge.msdk.foundation.download.utils.ILogger
            public final void log(String str, Exception exc) {
                af.a(str, exc.getMessage());
            }

            @Override // com.mbridge.msdk.foundation.download.utils.ILogger
            public final void log(String str, String str2) {
                af.a(str, str2);
            }
        });
        MBDownloadManager.getInstance().initialize(com.mbridge.msdk.foundation.controller.c.m().c(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100L).setMaxStorageTime(259200000L).build());
    }

    public static int k(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NumberFormatException {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0;
        }
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                String queryParameter = uri.getQueryParameter("isplayableec");
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter.equals("0");
                }
            }
            return false;
        } catch (Exception e3) {
            af.b("SameTools", e3.getMessage());
            return false;
        }
    }

    public static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                af.b("SameTools", "isNetworkAvailable", e3);
            }
            return false;
        }
    }

    public static boolean n(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return "wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US));
            }
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private static DisplayMetrics o(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th) {
            th.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }

    public static int f(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return o(context).widthPixels;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0;
        }
    }

    public static BitmapDrawable n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapDecodeByteArray);
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                bitmapDrawable.setTileModeXY(tileMode, tileMode);
                return bitmapDrawable;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static double m(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0d;
            }
            return Double.parseDouble(str);
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0.0d;
        }
    }

    public static boolean f() throws ClassNotFoundException {
        if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.c.m().h())) {
            return false;
        }
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
            return true;
        } catch (ClassNotFoundException e3) {
            af.b("SameTools", e3.getMessage());
            return false;
        }
    }

    public static <T extends String> boolean k(T t) {
        return t == null || t.length() == 0;
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0;
        }
    }

    public static boolean l(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static boolean h() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManagerA = w.a();
            if (connectivityManagerA == null || (networkInfo = connectivityManagerA.getNetworkInfo(17)) == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (Exception e3) {
            af.b("SameTools", e3.getMessage());
            return false;
        }
    }

    public static synchronized String d(String str) {
        String str2 = com.mbridge.msdk.foundation.controller.c.m().k() + "_" + str;
        Map<String, String> map = f3962s;
        if (map == null || !map.containsKey(str2)) {
            return null;
        }
        return f3962s.get(str2);
    }

    public static float d(Context context) {
        if (context != null) {
            try {
                float f10 = context.getResources().getDisplayMetrics().density;
                if (f10 == 0.0f) {
                    return 2.5f;
                }
                return f10;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return 2.5f;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized int d(android.content.Context r2, java.lang.String r3) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.ak> r0 = com.mbridge.msdk.foundation.tools.ak.class
            monitor-enter(r0)
            if (r2 == 0) goto L19
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L19
            java.lang.Object r2 = b(r3, r2)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L17
            if (r2 == 0) goto L13
            r2 = 1
            goto L26
        L13:
            r2 = 0
            goto L26
        L15:
            r2 = move-exception
            goto L28
        L17:
            r2 = 3
            goto L26
        L19:
            if (r2 != 0) goto L1d
            r2 = 5
            goto L26
        L1d:
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L25
            r2 = 2
            goto L26
        L25:
            r2 = 4
        L26:
            monitor-exit(r0)
            return r2
        L28:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.d(android.content.Context, java.lang.String):int");
    }

    public static <T extends String> boolean j(T t) {
        return t != null && t.length() > 0;
    }

    public static float j(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0;
        }
    }

    public static boolean g() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L48
            if (r4 == 0) goto L3e
            java.lang.String r0 = "dyview"
            java.lang.String r0 = r4.getQueryParameter(r0)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L48
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L48
            r3 = 1
            if (r2 != 0) goto L2a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L20 java.lang.Throwable -> L48
            goto L21
        L20:
            r0 = -1
        L21:
            int r0 = r0 % 2
            if (r0 != 0) goto L2a
            r0 = r3
            goto L2b
        L27:
            r4 = move-exception
            r0 = r1
            goto L3f
        L2a:
            r0 = r1
        L2b:
            java.lang.String r2 = "natmp"
            java.lang.String r4 = r4.getQueryParameter(r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            if (r4 != 0) goto L38
            goto L39
        L38:
            r3 = r0
        L39:
            return r3
        L3a:
            r1 = r0
            goto L48
        L3c:
            r4 = move-exception
            goto L3f
        L3e:
            return r1
        L3f:
            java.lang.String r2 = "SameTools"
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L3a
            com.mbridge.msdk.foundation.tools.af.b(r2, r4)     // Catch: java.lang.Throwable -> L3a
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.i(java.lang.String):boolean");
    }

    public static float i(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                String queryParameter = uri.getQueryParameter("dyview");
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = uri.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        return Integer.parseInt(queryParameter);
                    } catch (Exception unused) {
                    }
                }
            }
            return -1;
        } catch (Exception e3) {
            af.b("SameTools", e3.getMessage());
            return -1;
        }
    }

    public static String b(int i10) {
        String[] strArrB;
        try {
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            JSONArray jSONArray = new JSONArray();
            if (gVarB != null && gVarB.t() == 1 && (strArrB = com.mbridge.msdk.foundation.db.a.a.a().b()) != null) {
                int length = strArrB.length;
                for (int i11 = (length <= i10 || i10 == 0) ? 0 : length - i10; i11 < length; i11++) {
                    jSONArray.put(strArrB[i11]);
                }
            }
            if (jSONArray.length() <= 0) {
                return "";
            }
            return a(jSONArray);
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static int b(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        if (context == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                packageInfo = WebView.getCurrentWebViewPackage();
            } else {
                packageInfo = context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            }
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            if (packageInfo == null || TextUtils.isEmpty(packageInfo.versionName) || !packageInfo.versionName.equals("77.0.3865.92")) {
                return gVarB.aC();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int b() {
        int i10 = f3956m;
        f3956m = i10 + 1;
        return i10;
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(c(f3948a))).getMethod(String.valueOf(c(f3950c)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(c(f3949b))).getMethod(String.valueOf(c(f3951d)), null).invoke(context, null), str, 8192);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return !TextUtils.isEmpty(campaignEx.getDeepLinkURL());
        }
        return false;
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        String strOptString = jSONArray.optString(i10);
                        if (ap.b(strOptString)) {
                            arrayList.add(strOptString);
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th) {
                af.b("SameTools", th.getMessage(), th);
            }
        }
        return null;
    }

    public static synchronized void b(String str, String str2) {
        try {
            if (f3962s == null) {
                f3962s = new HashMap();
            }
            f3962s.put(com.mbridge.msdk.foundation.controller.c.m().k() + "_" + str, str2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static int b(Context context, float f10) {
        float f11 = 2.5f;
        if (context != null) {
            try {
                float f12 = context.getResources().getDisplayMetrics().density;
                if (f12 != 0.0f) {
                    f11 = f12;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return (int) ((f10 / f11) + 0.5f);
    }

    public static String b(String str, String str2, String str3) throws JSONException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("device");
                if (jSONObject2 != null) {
                    if (jSONObject2.has(str2)) {
                        if (str3.equals("0")) {
                            jSONObject2.remove(str2);
                        } else {
                            jSONObject2.put(str2, str3);
                        }
                    } else if (!str3.equals("0")) {
                        jSONObject2.put(str2, str3);
                    }
                    return jSONObject.toString();
                }
            } catch (Exception e3) {
                af.b("SameTools", e3.getMessage());
            }
        }
        return str;
    }

    public static String a(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                HashMap map = new HashMap();
                map.put(str2, str3);
                return a(str, map);
            }
            return str;
        } catch (Exception e3) {
            af.b("SameTools", e3.getMessage());
            return str;
        }
    }

    public static int a(int i10) {
        if ((i10 > 100 && i10 < 199) || i10 == 2) {
            return 1;
        }
        if ((i10 <= 200 || i10 >= 299) && i10 != 4) {
            return (i10 <= 500 || i10 >= 599) ? -1 : 5;
        }
        return 2;
    }

    public static String a(String str) {
        try {
            if (ap.b(str)) {
                return URLEncoder.encode(str, "utf-8");
            }
            return "";
        } catch (Throwable th) {
            af.b("SameTools", th.getMessage(), th);
            return "";
        }
    }

    public static String c(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMapA;
        List<String> listC;
        if (!TextUtils.isEmpty(str) && (concurrentHashMapA = com.mbridge.msdk.foundation.same.a.b.a(str)) != null && concurrentHashMapA.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (com.mbridge.msdk.foundation.entity.c cVar : concurrentHashMapA.values()) {
                if (cVar != null) {
                    long jE = cVar.e();
                    long jF = cVar.f();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jE <= 0) {
                        com.mbridge.msdk.c.g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(com.mbridge.msdk.c.h.a());
                        if (gVarS == null) {
                            com.mbridge.msdk.c.h.a();
                            gVarS = com.mbridge.msdk.c.i.a();
                        }
                        if ((gVarS.ad() * 1000) + jF >= jCurrentTimeMillis) {
                            listC = cVar.c();
                            if (listC == null) {
                            }
                        }
                    } else if ((jE * 1000) + jF >= jCurrentTimeMillis) {
                        listC = cVar.c();
                        if (listC == null && listC.size() > 0) {
                            arrayList.addAll(listC);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                HashSet hashSet = new HashSet(arrayList);
                arrayList.clear();
                arrayList.addAll(hashSet);
                return arrayList.toString();
            }
            return "";
        }
        return "";
    }

    public static void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            imageView.setImageResource(0);
            imageView.setImageDrawable(null);
            imageView.setImageURI(null);
            imageView.setImageBitmap(null);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    public static final void a(final int i10, final ImageView imageView, final CampaignEx campaignEx, Context context, boolean z9, final com.mbridge.msdk.foundation.d.a aVar) {
        if (imageView == null || campaignEx == null) {
            return;
        }
        af.a("configPrivacyButton", "configPrivacyButton");
        boolean z10 = campaignEx.getPrivacyButtonTemplateVisibility() == 0;
        af.a("configPrivacyButton", "privacyButtonVisibilityGone: " + z10 + " isIgnoreCampaignPrivacyConfig: " + z9);
        if (!z9 && z10) {
            try {
                imageView.setVisibility(8);
                return;
            } catch (Exception e3) {
                af.b("SameTools", e3.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(a(campaignEx))) {
            try {
                imageView.setVisibility(8);
                return;
            } catch (Exception e7) {
                af.b("SameTools", e7.getMessage());
                return;
            }
        }
        try {
            imageView.setVisibility(0);
        } catch (Exception e10) {
            af.b("SameTools", e10.getMessage());
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.tools.ak.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    ak.a(campaignEx, aVar, i10, (String) imageView.getTag());
                } catch (Exception e11) {
                    af.b("SameTools", e11.getMessage());
                }
            }
        });
    }

    public static String a(CampaignEx campaignEx) {
        com.mbridge.msdk.c.g gVarB;
        CampaignEx.a adchoice;
        String privacyUrl = "";
        if (campaignEx != null) {
            try {
                privacyUrl = campaignEx.getPrivacyUrl();
            } catch (Exception e3) {
                af.b("SameTools", e3.getMessage());
                return privacyUrl;
            }
        }
        if (TextUtils.isEmpty(privacyUrl) && campaignEx != null && (adchoice = campaignEx.getAdchoice()) != null) {
            privacyUrl = adchoice.c();
        }
        if (TextUtils.isEmpty(privacyUrl) && (gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k())) != null) {
            privacyUrl = gVarB.j();
        }
        return TextUtils.isEmpty(privacyUrl) ? com.mbridge.msdk.foundation.same.net.e.d.f().f : privacyUrl;
    }

    public static int c(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return 0;
    }

    public static synchronized boolean c(Context context, String str) {
        boolean z9;
        z9 = false;
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (b(str, context) != null) {
                        z9 = true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return z9;
    }

    public static boolean c(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getRetarget_offer() == 1;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    public static void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.d.a aVar, int i10, String str) {
        if (campaignEx == null) {
            return;
        }
        try {
            String str2 = campaignEx.getCampaignUnitId() + "_" + i10;
            com.mbridge.msdk.foundation.d.b.a().c(str2);
            com.mbridge.msdk.foundation.d.b.a().a(str2, campaignEx);
            com.mbridge.msdk.foundation.d.b.a().a(str2, aVar);
            com.mbridge.msdk.foundation.d.b.a().a(str2, i10);
            com.mbridge.msdk.foundation.d.b.a().a(str2, str);
            com.mbridge.msdk.foundation.d.b.a().a(str2).e();
        } catch (Throwable th) {
            af.b("SameTools", "feedback error", th);
        }
    }

    public static int c(String str, String str2) {
        return a(str, str2, 0);
    }

    public static final String c() {
        return MIMManager.a.f3902a.c();
    }

    public static int a(Context context, float f10) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f10 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static double a(Double d8) {
        try {
            String str = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d8);
            if (ap.b(str)) {
                return Double.parseDouble(str);
            }
            return 0.0d;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0.0d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0021 A[EXC_TOP_SPLITTER, PHI: r0 r2
      0x0021: PHI (r0v1 long) = (r0v0 long), (r0v3 long) binds: [B:20:0x002b, B:14:0x001f] A[DONT_GENERATE, DONT_INLINE]
      0x0021: PHI (r2v3 java.io.FileInputStream) = (r2v2 java.io.FileInputStream), (r2v4 java.io.FileInputStream) binds: [B:20:0x002b, B:14:0x001f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L2b
            if (r3 == 0) goto L1c
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L2b
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L2b
            int r4 = r3.available()     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L18
            long r0 = (long) r4
            r2 = r3
            goto L1f
        L15:
            r4 = move-exception
            r2 = r3
            goto L25
        L18:
            r2 = r3
            goto L2b
        L1a:
            r4 = move-exception
            goto L25
        L1c:
            r4.createNewFile()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L2b
        L1f:
            if (r2 == 0) goto L2e
        L21:
            r2.close()     // Catch: java.lang.Exception -> L2e
            goto L2e
        L25:
            if (r2 == 0) goto L2a
            r2.close()     // Catch: java.lang.Exception -> L2a
        L2a:
            throw r4
        L2b:
            if (r2 == 0) goto L2e
            goto L21
        L2e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.a(java.io.File):long");
    }

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            gVarB = com.mbridge.msdk.c.i.a();
        }
        int iZ = gVarB.Z();
        if (jSONArray.length() > iZ) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i10 = 0; i10 < iZ; i10++) {
                try {
                    jSONArray2.put(jSONArray.get(i10));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return jSONArray2.toString();
        }
        return jSONArray.toString();
    }

    public static String a(Context context, String str) {
        String strA;
        strA = "";
        try {
            JSONArray jSONArrayB = b(context, str);
            strA = jSONArrayB.length() > 0 ? a(jSONArrayB) : "";
            af.c("SameTools", "get excludes:" + strA);
            return strA;
        } catch (Exception e3) {
            e3.printStackTrace();
            return strA;
        }
    }

    public static final int a() {
        if (f3958o == null) {
            try {
                f3958o = MIMManager.a.f3902a.d();
            } catch (Exception e3) {
                af.b("SameTools", e3.getMessage());
            }
        }
        if (f3958o != null) {
            return f3958o.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    public static int e(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return o(context).heightPixels;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 0;
        }
    }

    public static int e() {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get(null)).intValue();
        } catch (Throwable th) {
            af.b("SameTools", th.getMessage());
            return 0;
        }
    }

    public static synchronized String a(Context context, String str, String str2) {
        StringBuilder sb;
        sb = new StringBuilder(str2);
        try {
            sb.append(a(str2, context, str));
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x0025
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    private static synchronized java.lang.String a(java.lang.String r2, android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.ak> r0 = com.mbridge.msdk.foundation.tools.ak.class
            monitor-enter(r0)
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            java.util.Set r2 = r2.getQueryParameterNames()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            if (r2 == 0) goto L1d
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            if (r2 <= 0) goto L1d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            goto L2c
        L1b:
            r2 = move-exception
            goto L46
        L1d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            java.lang.String r1 = "?rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            goto L2c
        L25:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b
        L2c:
            java.lang.Object r3 = b(r4, r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L3c
            if (r3 == 0) goto L37
            r3 = 1
            r2.append(r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L3c
            goto L40
        L37:
            r3 = 2
            r2.append(r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L3c
            goto L40
        L3c:
            r3 = 0
            r2.append(r3)     // Catch: java.lang.Throwable -> L1b
        L40:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r0)
            return r2
        L46:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1b
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ak.a(java.lang.String, android.content.Context, java.lang.String):java.lang.String");
    }

    private static List<String> a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                arrayList.add(stackTraceElement.getClassName());
            }
        }
        return arrayList;
    }

    public static ImageView a(ImageView imageView, BitmapDrawable bitmapDrawable, DisplayMetrics displayMetrics) {
        try {
            bitmapDrawable.setTargetDensity(displayMetrics);
            imageView.setBackground(bitmapDrawable);
            imageView.setClickable(false);
            imageView.setFocusable(false);
            return imageView;
        } catch (Exception e3) {
            e3.printStackTrace();
            return imageView;
        }
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setSystemUiVisibility(4102);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, CampaignEx campaignEx, int i10) {
        if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.c.m().c() == null) {
            return;
        }
        com.mbridge.msdk.foundation.db.i iVarA = com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
        fVar.a(System.currentTimeMillis());
        fVar.b(str);
        fVar.a(campaignEx.getId());
        fVar.a(i10);
        iVarA.a(fVar);
    }

    public static boolean a(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean a(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.optInt("v", -1) != -1) ? false : true;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                try {
                    Uri uri = Uri.parse(str2);
                    if (uri != null) {
                        if (!TextUtils.isEmpty(uri.getQueryParameter(str))) {
                            return true;
                        }
                    }
                } catch (Exception e3) {
                    af.b("SameTools", e3.getMessage());
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static int a(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return Integer.parseInt((String) obj);
                }
            } catch (Throwable th) {
                af.b("SameTools", th.getMessage(), th);
            }
        }
        return 0;
    }

    public static int a(String str, String str2, int i10) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri uri = Uri.parse(str);
                if (uri != null) {
                    String queryParameter = uri.getQueryParameter(str2);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        return (int) Math.round(Double.valueOf(String.valueOf(queryParameter)).doubleValue());
                    }
                }
            } catch (Exception e3) {
                af.b("SameTools", e3.getMessage());
                return i10;
            }
        }
        return i10;
    }
}
