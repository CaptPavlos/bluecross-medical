package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.h;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3351a = "c";

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f3352b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected String f3353c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f3354d;
    protected String e;
    private WeakReference<Activity> g;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private int f3355i;

    /* renamed from: l, reason: collision with root package name */
    private String f3358l;

    /* renamed from: m, reason: collision with root package name */
    private String f3359m;

    /* renamed from: n, reason: collision with root package name */
    private int f3360n;

    /* renamed from: p, reason: collision with root package name */
    private WeakReference<Context> f3362p;

    /* renamed from: q, reason: collision with root package name */
    private JSONObject f3363q;

    /* renamed from: s, reason: collision with root package name */
    private String f3365s;
    private final h f = new h();

    /* renamed from: j, reason: collision with root package name */
    private JSONObject f3356j = new JSONObject();

    /* renamed from: k, reason: collision with root package name */
    private boolean f3357k = false;

    /* renamed from: o, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f3361o = new ConcurrentHashMap<>();

    /* renamed from: r, reason: collision with root package name */
    private int f3364r = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.foundation.controller.a$a, reason: collision with other inner class name */
    public interface InterfaceC0026a {
    }

    public abstract void a(InterfaceC0026a interfaceC0026a);

    public final void a(final InterfaceC0026a interfaceC0026a, final Handler handler) throws JSONException {
        if (this.f3357k) {
            return;
        }
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.b.a() && com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                Object objA = an.a(this.f3354d, MBridgeConstans.SP_GA_ID, "");
                Object objA2 = an.a(this.f3354d, MBridgeConstans.SP_GA_ID_LIMIT, 0);
                if (objA instanceof String) {
                    String str = (String) objA;
                    if (TextUtils.isEmpty(str)) {
                        f.c();
                    } else {
                        f.a(str);
                    }
                    if (objA2 instanceof Integer) {
                        f.a(((Integer) objA2).intValue());
                    }
                }
            }
        } catch (Exception e) {
            af.b(f3351a, e.getMessage());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            this.f3363q = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (JSONException e3) {
            af.b(f3351a, e3.getMessage());
        }
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ab.p(a.this.f3354d);
                    a.this.a(interfaceC0026a);
                    a aVar = a.this;
                    com.mbridge.msdk.c.h.a(aVar.f3354d, aVar.f3353c);
                } catch (Exception e7) {
                    af.b(a.f3351a, e7.getMessage());
                }
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    try {
                        ab.c(a.this.f3354d.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled ? 1 : 2);
                    } catch (PackageManager.NameNotFoundException unused) {
                        ab.c(0);
                    } catch (Throwable th) {
                        af.b(a.f3351a, th.getMessage());
                    }
                }
                try {
                    g gVarB = com.mbridge.msdk.c.h.a().b(c.m().k());
                    if (gVarB == null) {
                        com.mbridge.msdk.c.h.a();
                        gVarB = i.a();
                    }
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = gVarB;
                    messageObtain.what = 9;
                    handler.sendMessage(messageObtain);
                } catch (Exception e10) {
                    af.b(a.f3351a, e10.getMessage());
                }
            }
        }).start();
    }

    public final void b(String str) {
        try {
            if (this.f3361o != null && !TextUtils.isEmpty(str) && this.f3361o.containsKey(str)) {
                this.f3361o.remove(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void c(String str) {
        Context context;
        try {
            this.h = str;
            if (TextUtils.isEmpty(str) || (context = this.f3354d) == null) {
                return;
            }
            an.b(context, "applicationIds", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void d(String str) {
        Context context;
        try {
            this.f3353c = str;
            if (TextUtils.isEmpty(str) || (context = this.f3354d) == null) {
                return;
            }
            an.b(context, "sp_appId", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void e(String str) {
        Context context;
        try {
            this.f3358l = str;
            if (TextUtils.isEmpty(str) || (context = this.f3354d) == null) {
                return;
            }
            an.b(context, "sp_appKey", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e = str;
    }

    public final String g() {
        try {
            if (!TextUtils.isEmpty(this.e)) {
                return this.e;
            }
            Context context = this.f3354d;
            if (context == null) {
                return null;
            }
            String packageName = context.getPackageName();
            this.e = packageName;
            return packageName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String h() {
        if (!TextUtils.isEmpty(this.f3359m)) {
            return this.f3359m;
        }
        Context context = this.f3354d;
        if (context != null) {
            return (String) an.a(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public final JSONObject i() {
        return this.f3363q;
    }

    public final int j() {
        return this.f3364r;
    }

    public final String k() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f3353c)) {
            return this.f3353c;
        }
        Context context = this.f3354d;
        if (context != null) {
            return (String) an.a(context, "sp_appId", "");
        }
        return "";
    }

    public final String l() {
        if (!TextUtils.isEmpty(this.f3365s)) {
            return this.f3365s;
        }
        try {
            String md5 = SameMD5.getMD5(c.m().k() + c.m().b());
            this.f3365s = md5;
            return md5;
        } catch (Exception unused) {
            return "";
        }
    }

    public final int f() {
        return this.f3355i;
    }

    public final void c(int i10) {
        this.f3364r = i10;
    }

    public final h d() {
        return this.f;
    }

    public final Context e() {
        WeakReference<Context> weakReference = this.f3362p;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final Context c() {
        return this.f3354d;
    }

    public final void b(int i10) {
        this.f3360n = i10;
    }

    public final String b() {
        if (!TextUtils.isEmpty(this.f3358l)) {
            return this.f3358l;
        }
        Context context = this.f3354d;
        if (context != null) {
            return (String) an.a(context, "sp_appKey", "");
        }
        return null;
    }

    public final void b(Context context) {
        this.f3354d = context;
    }

    public final WeakReference<Activity> a() {
        return this.g;
    }

    public final void a(WeakReference<Activity> weakReference) {
        this.g = weakReference;
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            this.f3362p = new WeakReference<>(context);
        }
    }

    public final void a(int i10) {
        this.f3355i = i10;
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f3359m = str;
            Context context = this.f3354d;
            if (context != null) {
                an.b(context, "sp_wx_appKey", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final BitmapDrawable a(String str, int i10) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        int i11;
        String str2;
        int i12;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f3361o) == null || !concurrentHashMap.containsKey(str) || !ah.a().a("w_m_r_l", true)) {
            return null;
        }
        String str3 = this.f3361o.get(str);
        BitmapDrawable bitmapDrawableN = ak.n(str3);
        int i13 = TextUtils.isEmpty(str3) ? 2 : 1;
        String str4 = TextUtils.isEmpty(str3) ? "get watermark failed" : bitmapDrawableN != null ? "" : "str to bitmap failed";
        if (bitmapDrawableN == null) {
            i11 = 2;
            i12 = i10;
            str2 = str;
        } else {
            i11 = 1;
            str2 = str;
            i12 = i10;
        }
        com.mbridge.msdk.foundation.same.report.i.a(str2, i12, i13, str4, i11, str3);
        return bitmapDrawableN;
    }

    public final void a(JSONObject jSONObject) {
        this.f3363q = jSONObject;
    }

    public final void a(String str, JSONObject jSONObject) throws JSONException {
        if (ah.a().a("w_m_r_l", true)) {
            try {
                if (this.f3356j == null) {
                    this.f3356j = jSONObject;
                } else if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        this.f3356j.put(next, jSONObject.get(next));
                    }
                }
                if (this.f3356j.has(MBridgeConstans.EXTRA_KEY_WM)) {
                    if (this.f3361o == null) {
                        this.f3361o = new ConcurrentHashMap<>();
                    }
                    this.f3361o.put(str, this.f3356j.getString(MBridgeConstans.EXTRA_KEY_WM));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
