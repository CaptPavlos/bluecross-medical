package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler;
import com.mbridge.msdk.out.MBRewardVideoHandler;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d f3380c;

    /* renamed from: d, reason: collision with root package name */
    private int f3383d;
    private Map<String, Object> e;
    private FastKV f;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private String f3384i;

    /* renamed from: j, reason: collision with root package name */
    private String f3385j;

    /* renamed from: k, reason: collision with root package name */
    private Context f3386k;

    /* renamed from: l, reason: collision with root package name */
    private String f3387l;

    /* renamed from: m, reason: collision with root package name */
    private com.mbridge.msdk.b.a f3388m;

    /* renamed from: n, reason: collision with root package name */
    private String f3389n;

    /* renamed from: a, reason: collision with root package name */
    public final int f3381a = 2;
    private boolean g = false;

    /* renamed from: b, reason: collision with root package name */
    Handler f3382b = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.foundation.controller.d.6
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            List list;
            List list2;
            try {
                int i10 = message.what;
                if (i10 == 2) {
                    Object obj = message.obj;
                    if (!(obj instanceof List) || (list = (List) obj) == null || list.size() <= 0) {
                        return;
                    }
                    h hVar = new h(d.this.f3386k, 0);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        l lVar = (l) list.get(i11);
                        Boolean bool = Boolean.FALSE;
                        if (i11 == list.size() - 1) {
                            bool = Boolean.TRUE;
                        }
                        hVar.a(lVar, bool);
                    }
                    return;
                }
                if (i10 == 7) {
                    Object obj2 = message.obj;
                    if (obj2 == null || !(obj2 instanceof List) || (list2 = (List) obj2) == null) {
                        return;
                    }
                    list2.size();
                    return;
                }
                if (i10 != 9) {
                    return;
                }
                g gVar = (g) message.obj;
                com.mbridge.msdk.foundation.tools.h hVarD = c.m().d();
                if (hVarD != null && hVarD.b() && gVar != null && gVar.L() == 1) {
                    com.mbridge.msdk.foundation.same.report.b.d.a(d.this.f3386k).b();
                }
                if (hVarD == null || !hVarD.a()) {
                    return;
                }
                com.mbridge.msdk.foundation.same.report.b.c.a();
            } catch (Exception unused) {
                af.b("SDKController", "REPORT HANDLE ERROR!");
            }
        }
    };

    private d() {
    }

    public static /* synthetic */ void b(d dVar) {
        List<com.mbridge.msdk.foundation.entity.a> listN;
        Object objNewInstance;
        Object objNewInstance2;
        try {
            g gVarB = com.mbridge.msdk.c.h.a().b(c.m().k());
            if (gVarB == null || (listN = gVarB.n()) == null || listN.size() <= 0) {
                return;
            }
            for (com.mbridge.msdk.foundation.entity.a aVar : listN) {
                if (aVar.a() == 287) {
                    if (dVar.f3386k != null && (objNewInstance = MBInterstitialVideoHandler.class.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                        MBInterstitialVideoHandler.class.getMethod("loadFormSelfFilling", null).invoke(objNewInstance, null);
                    }
                } else if (aVar.a() == 94 && (objNewInstance2 = MBRewardVideoHandler.class.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                    MBRewardVideoHandler.class.getMethod("loadFormSelfFilling", null).invoke(objNewInstance2, null);
                }
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Map map, final Context context) {
        Object obj;
        String string;
        if (context != null) {
            if (!TextUtils.isEmpty(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE)) {
                c.m().f(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE);
            } else if (map.containsKey(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME) && (obj = map.get(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME)) != null) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    c.m().f(str);
                }
            }
            if (map != null) {
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                    this.h = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPKEY)) {
                    this.f3384i = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPKEY);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_WX_APPID)) {
                    this.f3389n = (String) map.get(MBridgeConstans.ID_MBRIDGE_WX_APPID);
                }
                if (map.containsKey(MBridgeConstans.PACKAGE_NAME_MANIFEST)) {
                    this.f3385j = (String) map.get(MBridgeConstans.PACKAGE_NAME_MANIFEST);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH)) {
                    this.f3387l = (String) map.get(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH);
                }
            }
            this.f3386k = context.getApplicationContext();
            c.m().b(this.f3386k);
            c.m().d(this.h);
            c.m().e(this.f3384i);
            c.m().a(this.f3389n);
            c.m().c(this.f3385j);
            c.m().a(new a.InterfaceC0026a() { // from class: com.mbridge.msdk.foundation.controller.d.4
            }, this.f3382b);
            try {
                com.mbridge.msdk.foundation.same.net.e.d.f().e();
            } catch (Throwable th) {
                af.b("SDKController", th.getMessage());
            }
            if (this.g) {
                return;
            }
            ai.a(this.f3386k);
            Context applicationContext = this.f3386k.getApplicationContext();
            try {
                if (this.f == null) {
                    try {
                        this.f = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), z.a("H+tU+FeXHM==")).build();
                    } catch (Exception unused) {
                        this.f = null;
                    }
                }
                FastKV fastKV = this.f;
                String string2 = "";
                if (fastKV != null) {
                    String string3 = fastKV.getString(z.a("H+tU+bfPhM=="), "");
                    String string4 = this.f.getString(z.a("H+tU+Fz8"), "");
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                        com.mbridge.msdk.foundation.same.a.V = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                        com.mbridge.msdk.foundation.same.a.g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
                    }
                    if (!TextUtils.isEmpty(string3) || !TextUtils.isEmpty(string4)) {
                        com.mbridge.msdk.foundation.same.a.V = string3;
                        com.mbridge.msdk.foundation.same.a.g = string4;
                        com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.g);
                    } else if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                        this.f.putString(z.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                        this.f.putString(z.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                    }
                } else {
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(z.a("H+tU+FeXHM=="), 0);
                    if (sharedPreferences != null) {
                        string2 = sharedPreferences.getString(z.a("H+tU+bfPhM=="), "");
                        string = sharedPreferences.getString(z.a("H+tU+Fz8"), "");
                    } else {
                        string = "";
                    }
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                        com.mbridge.msdk.foundation.same.a.V = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                        com.mbridge.msdk.foundation.same.a.g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
                    }
                    if (!TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string)) {
                        com.mbridge.msdk.foundation.same.a.V = string2;
                        com.mbridge.msdk.foundation.same.a.g = string;
                        com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.g);
                    } else if ((!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) && sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(z.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                        editorEdit.putString(z.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                        editorEdit.apply();
                    }
                }
            } catch (Throwable th2) {
                af.b("SDKController", th2.getMessage(), th2);
            }
            try {
                com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.d.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Looper.prepare();
                        d.a(d.this);
                        d.b(d.this);
                        Looper.loop();
                    }
                });
                com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.d.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        d dVar = d.this;
                        d.a(dVar, dVar.h);
                        if (!TextUtils.isEmpty(d.this.h)) {
                            com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID, d.this.h);
                        }
                        new h(d.this.f3386k).a();
                        d.this.b();
                    }
                });
                i.c();
            } catch (Exception unused2) {
                af.b("SDKController", "get app setting failed");
            }
            this.g = true;
            ab.g(context);
            long jAA = com.mbridge.msdk.c.h.a().a(this.h).aA();
            if (jAA != 1300) {
                this.f3382b.postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ab.e(context);
                    }
                }, jAA);
            }
        }
    }

    public final void c() {
        Handler handler = this.f3382b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void b() {
        if (this.f3386k == null || this.f3382b == null) {
            return;
        }
        try {
            int i10 = ah.a().a("e_r_r_c_t_r_l", false) ? 5 : 1;
            com.mbridge.msdk.foundation.same.report.c.a.a();
            Context context = this.f3386k;
            List<l> listA = (context != null && com.mbridge.msdk.foundation.db.l.a(com.mbridge.msdk.foundation.db.g.a(context)).a() > 0) ? com.mbridge.msdk.foundation.db.l.a(com.mbridge.msdk.foundation.db.g.a(context)).a(i10) : null;
            if (listA == null || listA.size() <= 0) {
                return;
            }
            Message messageObtainMessage = this.f3382b.obtainMessage();
            messageObtainMessage.what = 2;
            messageObtainMessage.obj = listA;
            this.f3382b.sendMessage(messageObtainMessage);
        } catch (Exception unused) {
            if (MBridgeConstans.DEBUG) {
                af.b("SDKController", "report netstate error !");
            }
        }
    }

    public static d a() {
        if (f3380c == null) {
            synchronized (d.class) {
                try {
                    if (f3380c == null) {
                        f3380c = new d();
                    }
                } finally {
                }
            }
        }
        return f3380c;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008b -> B:35:0x008e). Please report as a decompilation issue!!! */
    public final void a(Map<String, Object> map, int i10) {
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() != MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            af.b("SDKController", "preloaad failed,sdk do not inited");
            return;
        }
        this.e = map;
        this.f3383d = i10;
        c.m().k();
        if (map != null) {
            if (this.f3388m == null) {
                this.f3388m = new com.mbridge.msdk.b.a();
            }
            try {
                Map<String, Object> map2 = this.e;
                if (map2 != null && map2.size() > 0 && this.e.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)) {
                    int iIntValue = ((Integer) this.e.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue();
                    if (iIntValue == 0) {
                        Map<String, Object> map3 = this.e;
                        int i11 = this.f3383d;
                        try {
                            Class<?> cls = Class.forName("com.mbridge.msdk.mbnative.f.a");
                            cls.getMethod("preload", Map.class, Integer.TYPE).invoke(cls.newInstance(), map3, Integer.valueOf(i11));
                        } catch (Exception unused) {
                        }
                    } else if (1 != iIntValue && 2 != iIntValue) {
                        af.b("SDKController", "unknow layout type in preload");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void a(d dVar) {
        try {
            com.mbridge.msdk.d.b.class.getDeclaredMethod("start", null).invoke(com.mbridge.msdk.d.b.class.getMethod("getInstance", null).invoke(null, null), null);
        } catch (Throwable th) {
            af.b("SDKController", th.getMessage(), th);
        }
    }

    public static /* synthetic */ void a(d dVar, final String str) {
        if (com.mbridge.msdk.c.h.a() == null) {
            return;
        }
        com.mbridge.msdk.c.h hVarA = com.mbridge.msdk.c.h.a();
        if (hVarA != null) {
            g gVarB = hVarA.b(str);
            if (gVarB != null) {
                MBridgeConstans.OMID_JS_SERVICE_URL = gVarB.X();
                MBridgeConstans.OMID_JS_H5_URL = gVarB.W();
                if (!TextUtils.isEmpty(gVarB.B())) {
                    com.mbridge.msdk.foundation.same.net.e.d.f().h = gVarB.B();
                    com.mbridge.msdk.foundation.same.net.e.d.f().b();
                }
                if (!TextUtils.isEmpty(gVarB.C())) {
                    com.mbridge.msdk.foundation.same.net.e.d.f().f3741l = gVarB.C();
                    com.mbridge.msdk.foundation.same.net.e.d.f().c();
                }
            } else {
                MBridgeConstans.OMID_JS_SERVICE_URL = com.mbridge.msdk.c.a.b.f2643b;
                MBridgeConstans.OMID_JS_H5_URL = com.mbridge.msdk.c.a.b.f2642a;
            }
        }
        if (com.mbridge.msdk.c.h.a().d(str) && com.mbridge.msdk.c.h.a().a(str, 1, (String) null)) {
            if (com.mbridge.msdk.foundation.a.a.a.a().a("is_first_init", 0) == 0) {
                try {
                    com.mbridge.msdk.foundation.a.a.a.a().b("is_first_init", 1);
                    if (TextUtils.isEmpty(f.c())) {
                        dVar.f3382b.postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.d.5
                            @Override // java.lang.Runnable
                            public final void run() {
                                new j().b(d.this.f3386k, str, d.this.f3384i);
                            }
                        }, 350L);
                        return;
                    } else {
                        new j().b(dVar.f3386k, str, dVar.f3384i);
                        return;
                    }
                } catch (Throwable unused) {
                    new j().b(dVar.f3386k, str, dVar.f3384i);
                    return;
                }
            }
            new j().b(dVar.f3386k, str, dVar.f3384i);
        }
    }
}
