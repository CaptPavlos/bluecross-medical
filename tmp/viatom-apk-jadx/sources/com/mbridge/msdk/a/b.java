package com.mbridge.msdk.a;

import android.app.ActivityManager;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t1.c;
import t3.d;
import t3.g;
import t3.i;
import t3.j;
import w3.k;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2618a = DomainNameUtils.VERIFICATION_URL;

    public static t3.b a(Context context, boolean z9, String str, String str2, String str3, String str4, String str5, String str6) throws JSONException {
        Context context2;
        String str7;
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = a();
        }
        j jVarB = null;
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) || TextUtils.isEmpty(str)) {
            af.a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(str) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
            new h(context).a(str2, str6, str3, str4, "failed, OMID_JS_SERVICE_CONTENT null or omid null");
            return null;
        }
        try {
            try {
                c(context);
                try {
                    t1.c("Mintegral", "Name is null or empty");
                    t1.c(MBConfiguration.SDK_VERSION, "Version is null or empty");
                    t3.h hVar = new t3.h(0);
                    d dVar = z9 ? d.NATIVE_DISPLAY : d.VIDEO;
                    g gVar = g.NATIVE;
                    if (z9) {
                        gVar = g.NONE;
                    }
                    c cVarD = c.d(dVar, gVar);
                    context2 = context;
                    try {
                        try {
                            str7 = str2;
                        } catch (IllegalArgumentException e) {
                            e = e;
                            af.b("OMSDK", e.getMessage());
                            new h(context2).a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
                            return jVarB;
                        } catch (Exception e3) {
                            e = e3;
                            str7 = str2;
                            af.b("OMSDK", e.getMessage());
                            new h(context2).a(str7, str6, str3, str4, "failed, exception " + e.getMessage());
                            return jVarB;
                        }
                        try {
                            jVarB = t3.b.b(cVarD, b9.h.k(hVar, MBridgeConstans.OMID_JS_SERVICE_CONTENT, a(str, context2, str2, str3, str4, str6), str5, str7));
                            af.a("OMSDK", "adSession create success");
                            return jVarB;
                        } catch (IllegalArgumentException e7) {
                            e = e7;
                            af.b("OMSDK", e.getMessage());
                            new h(context2).a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
                            return jVarB;
                        } catch (Exception e10) {
                            e = e10;
                            af.b("OMSDK", e.getMessage());
                            new h(context2).a(str7, str6, str3, str4, "failed, exception " + e.getMessage());
                            return jVarB;
                        }
                    } catch (IllegalArgumentException e11) {
                        e = e11;
                    } catch (Exception e12) {
                        e = e12;
                        str7 = str2;
                    }
                } catch (IllegalArgumentException e13) {
                    e = e13;
                    context2 = context;
                }
            } catch (IllegalArgumentException e14) {
                e = e14;
                context2 = context;
            }
        } catch (Exception e15) {
            e = e15;
            context2 = context;
        }
    }

    public static void b(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_URL)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = "";
            new h(context).a("", "", "", "", "fetch OM failed, OMID_JS_H5_URL null");
        } else {
            if (context == null) {
                return;
            }
            try {
                new a(context.getApplicationContext()).get(0, MBridgeConstans.OMID_JS_H5_URL, (e) null, new com.mbridge.msdk.foundation.same.net.b.a() { // from class: com.mbridge.msdk.a.b.3
                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void a(String str) throws JSONException {
                        af.a("OMSDK", "fetch OMJSH5Content failed, errorCode = " + str);
                        new h(context).a("", "", "", "", "fetch OM H5 failed, request failed");
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void b(String str) {
                        MBridgeConstans.OMID_JS_H5_CONTENT = str;
                        b.b(str);
                    }
                }, "om_sdk", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            } catch (Exception e) {
                af.b("OMSDK", e.getMessage());
            }
        }
    }

    private static void c(Context context) {
        s3.b bVar = s3.a.f12529a;
        if (bVar.f12530a) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        t1.b(applicationContext, "Application Context cannot be null");
        if (bVar.f12530a) {
            return;
        }
        bVar.f12530a = true;
        w3.j jVarB = w3.j.b();
        t3.h hVar = jVarB.f13513b;
        jVarB.f13514c = new v3.a(new Handler(), applicationContext, new t3.h(7), jVarB);
        boolean z9 = applicationContext instanceof Application;
        if (z9) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(w3.b.f13497d);
        }
        l1.b.f10167a = (UiModeManager) applicationContext.getSystemService("uimode");
        WindowManager windowManager = z3.b.f14402a;
        z3.b.f14404c = applicationContext.getResources().getDisplayMetrics().density;
        z3.b.f14402a = (WindowManager) applicationContext.getSystemService("window");
        applicationContext.registerReceiver(new i5.a(3), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        w3.h.f13509b.f13510a = applicationContext.getApplicationContext();
        w3.a aVar = w3.a.f;
        w3.e eVar = aVar.f13496d;
        if (!aVar.f13495c) {
            eVar.getClass();
            if (z9) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(eVar);
            }
            eVar.f13503c = aVar;
            eVar.f13501a = true;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            eVar.f13502b = runningAppProcessInfo.importance == 100;
            aVar.e = eVar.f13502b;
            aVar.f13495c = true;
        }
        k.f13516d.f13517a = new WeakReference(applicationContext);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        applicationContext.registerReceiver(new i5.a(2), intentFilter);
    }

    private static String b() {
        try {
            File file = new File(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
            if (!file.exists()) {
                return "";
            }
            return ad.b(file);
        } catch (Exception e) {
            af.a("OMSDK", e.getMessage());
            return "";
        }
    }

    public static void b(final String str) {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.a.b.4
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                try {
                    File file = new File(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    ad.a(str.getBytes(), file);
                } catch (Exception e) {
                    af.a("OMSDK", e.getMessage());
                }
            }
        }).start();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        return TextUtils.isEmpty(str) ? str : str.replace("/*OMSDK_INSERT_HERE*/", MBridgeConstans.OMID_JS_H5_CONTENT).replace("[INSERT RESOURCE URL]", f2618a);
    }

    private static String a() {
        try {
            return ad.b(new File(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt"));
        } catch (Exception e) {
            af.a("OMSDK", e.getMessage());
            return "";
        }
    }

    private static List<i> a(String str, Context context, String str2, String str3, String str4, String str5) throws JSONException {
        String str6;
        String str7;
        MalformedURLException malformedURLException;
        String str8;
        String str9;
        IllegalArgumentException illegalArgumentException;
        i iVarA;
        ArrayList arrayList = new ArrayList();
        try {
            try {
            } catch (JSONException e) {
                af.b("OMSDK", e.getMessage());
                new h(context).a(str2, str5, str3, str4, "failed, exception " + e.getMessage());
            }
        } catch (IllegalArgumentException e3) {
            str8 = str2;
            str9 = str5;
            illegalArgumentException = e3;
        } catch (MalformedURLException e7) {
            str6 = str2;
            str7 = str5;
            malformedURLException = e7;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (str != null) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                    String strOptString = jSONObjectOptJSONObject.optString("vkey", "");
                    URL url = new URL(jSONObjectOptJSONObject.optString("et_url", ""));
                    String strOptString2 = jSONObjectOptJSONObject.optString("verification_p", "");
                    if (TextUtils.isEmpty(strOptString2)) {
                        if (TextUtils.isEmpty(strOptString)) {
                            iVarA = new i(null, url, null);
                        } else {
                            iVarA = new i(null, url, null);
                        }
                    } else {
                        iVarA = i.a(strOptString, url, strOptString2);
                    }
                    arrayList.add(iVarA);
                }
            }
        } catch (IllegalArgumentException e10) {
            illegalArgumentException = e10;
            str8 = str2;
            str9 = str5;
            af.b("OMSDK", illegalArgumentException.getMessage());
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            new h(context).a(str8, str9, str3, str4, "failed, exception " + illegalArgumentException2.getMessage());
            return arrayList;
        } catch (MalformedURLException e11) {
            malformedURLException = e11;
            str6 = str2;
            str7 = str5;
            af.b("OMSDK", malformedURLException.getMessage());
            MalformedURLException malformedURLException2 = malformedURLException;
            new h(context).a(str6, str7, str3, str4, "failed, exception " + malformedURLException2.getMessage());
            return arrayList;
        }
        return arrayList;
    }

    public static t3.b a(Context context, WebView webView, String str, CampaignEx campaignEx) throws JSONException {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = a();
        }
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        if (!TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) && !TextUtils.isEmpty(campaignEx.getOmid())) {
            c(context);
            c cVarD = c.d(d.HTML_DISPLAY, g.NONE);
            t1.c("Mintegral", "Name is null or empty");
            t1.c(MBConfiguration.SDK_VERSION, "Version is null or empty");
            t3.h hVar = new t3.h(0);
            t1.b(webView, "WebView is null");
            j jVarB = t3.b.b(cVarD, new b9.h(hVar, webView, (String) null, (List) null, (String) null, (String) null, t3.c.HTML));
            jVarB.d(webView);
            return jVarB;
        }
        af.a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(campaignEx.getOmid()) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
        new h(context).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), campaignEx.getCampaignUnitId(), "failed, OMID_JS_SERVICE_CONTENT null or omid null");
        return null;
    }

    public static void a(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = "";
            new h(context).a("", "", "", "", "fetch OM failed, OMID_JS_SERVICE_URL null");
        } else {
            if (context == null) {
                return;
            }
            try {
                new a(context.getApplicationContext()).get(0, MBridgeConstans.OMID_JS_SERVICE_URL, (e) null, new com.mbridge.msdk.foundation.same.net.b.a() { // from class: com.mbridge.msdk.a.b.1
                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void a(String str) throws JSONException {
                        af.a("OMSDK", "fetch OMJSContent failed, errorCode = " + str);
                        new h(context).a("", "", "", "", "fetch OM failed, request failed");
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void b(String str) {
                        MBridgeConstans.OMID_JS_SERVICE_CONTENT = str;
                        b.a(str);
                    }
                }, "om_sdk", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            } catch (Exception e) {
                af.b("OMSDK", e.getMessage());
            }
        }
    }

    public static void a(final String str) {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.a.b.2
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                try {
                    File file = new File(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    ad.a(str.getBytes(), file);
                } catch (Exception e) {
                    af.a("OMSDK", e.getMessage());
                }
            }
        }).start();
    }
}
