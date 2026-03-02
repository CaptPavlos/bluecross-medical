package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.broadcast.NetWorkChangeReceiver;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    IntentFilter f4035a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f4036b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.c.j f4037c;

    /* renamed from: d, reason: collision with root package name */
    private long f4038d;
    private final BroadcastReceiver e;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final v f4039a = new v();
    }

    private v() {
        this.f4036b = new JSONObject();
        this.e = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        this.f4035a = intentFilter;
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public final void a(String str) {
        if (this.f4036b == null) {
            this.f4036b = new JSONObject();
        }
        try {
            if (!this.f4036b.optString("KEY_INFO", "").equals(str)) {
                this.f4036b.put("KEY_INFO", str);
                c.b(com.mbridge.msdk.foundation.controller.c.m().c(), "KEY_INFO", str);
            }
        } catch (Exception e) {
            af.b("NetAddressManager", e.getMessage());
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f4036b.put("KEY_TIME", jCurrentTimeMillis);
            c.b(com.mbridge.msdk.foundation.controller.c.m().c(), "KEY_TIME", Long.valueOf(jCurrentTimeMillis));
        } catch (Exception e3) {
            af.b("NetAddressManager", e3.getMessage());
        }
    }

    public final String b() throws JSONException {
        try {
            if (this.f4036b == null) {
                this.f4036b = new JSONObject();
            }
            if (this.f4036b.length() < 2) {
                try {
                    this.f4036b.put("KEY_INFO", (String) c.a(com.mbridge.msdk.foundation.controller.c.m().c(), "KEY_INFO", ""));
                } catch (Exception e) {
                    af.b("NetAddressManager", e.getMessage());
                }
                try {
                    this.f4036b.put("KEY_TIME", ((Long) c.a(com.mbridge.msdk.foundation.controller.c.m().c(), "KEY_TIME", 0L)).longValue());
                } catch (Exception e3) {
                    af.b("NetAddressManager", e3.getMessage());
                }
            }
            String strOptString = this.f4036b.optString("KEY_INFO");
            if (TextUtils.isEmpty(strOptString)) {
                return "";
            }
            com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
            return System.currentTimeMillis() - this.f4036b.optLong("KEY_TIME") > (gVarA != null ? gVarA.c() : 3600L) * 1000 ? "" : strOptString;
        } catch (Exception e7) {
            af.b("NetAddressManager", e7.getMessage());
            return "";
        }
    }

    public final void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f4038d > 3000) {
            if (this.f4037c == null) {
                this.f4037c = new com.mbridge.msdk.c.j();
            }
            this.f4037c.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.foundation.controller.c.m().k(), com.mbridge.msdk.foundation.controller.c.m().b());
            this.f4038d = jCurrentTimeMillis;
        }
    }

    public final void d() {
        Context contextC;
        try {
            if (com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k()).a() != 1 || (contextC = com.mbridge.msdk.foundation.controller.c.m().c()) == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            this.f4035a = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextC.registerReceiver(this.e, this.f4035a);
        } catch (Exception e) {
            af.b("NetAddressManager", e.getMessage());
        }
    }

    public final void e() {
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (contextC != null) {
            try {
                contextC.unregisterReceiver(this.e);
            } catch (Exception e) {
                af.b("NetAddressManager", e.getMessage());
            }
        }
    }

    public static v a() {
        return a.f4039a;
    }
}
