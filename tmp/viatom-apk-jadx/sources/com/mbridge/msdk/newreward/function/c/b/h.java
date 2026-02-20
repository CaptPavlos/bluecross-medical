package com.mbridge.msdk.newreward.function.c.b;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.tracker.network.ac;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.network.y;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends u<JSONObject> implements w.a {

    /* renamed from: a, reason: collision with root package name */
    public static int f4710a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f4711b = 1;

    /* renamed from: c, reason: collision with root package name */
    private e f4712c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f4713d;
    private Map<String, String> e;

    public h(String str) {
        super(0, str, 0, "setting");
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final w<JSONObject> a(r rVar) {
        if (rVar != null) {
            try {
                byte[] bArr = rVar.f5444b;
                if (bArr != null && bArr.length != 0) {
                    return w.a(new JSONObject(new String(bArr, com.mbridge.msdk.tracker.network.toolbox.f.a(rVar.f5445c))), com.mbridge.msdk.tracker.network.toolbox.f.a(rVar));
                }
            } catch (UnsupportedEncodingException e) {
                af.b("RewardSettingRequest", "parseNetworkResponse UnsupportedEncodingException: ", e);
                return w.a(new com.mbridge.msdk.tracker.network.f(e));
            } catch (Exception e3) {
                af.b("RewardSettingRequest", "parseNetworkResponse Exception: ", e3);
                return w.a(new ac(e3));
            }
        }
        return w.a(new y());
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final Map<String, String> c() {
        Map<String, String> map = this.e;
        if (map != null) {
            map.put("Charset", C.UTF8_NAME);
            return this.e;
        }
        HashMap map2 = new HashMap();
        this.e = map2;
        return map2;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final boolean d() {
        return true;
    }

    public final void a(e eVar) {
        this.f4712c = eVar;
    }

    public final void a(Map<String, String> map) {
        if (this.f4713d == null) {
            this.f4713d = new HashMap<>();
        }
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f4713d.putAll(map);
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final Map<String, String> a() {
        if (this.f4713d == null) {
            this.f4713d = new HashMap<>();
        }
        return this.f4713d;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final /* synthetic */ void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        e eVar = this.f4712c;
        if (eVar == null) {
            return;
        }
        try {
            if (jSONObject2 == null) {
                eVar.a(this, new d(-1));
            } else {
                eVar.a(jSONObject2, this);
            }
        } catch (Exception e) {
            af.b("RewardSettingRequest", "onError Exception: ", e);
        }
    }

    public final void a(String str, String str2) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        this.e.put(str, str2);
    }

    @Override // com.mbridge.msdk.tracker.network.w.a
    public final void a(ad adVar) {
        this.f4712c.a(this, new d(-1, adVar.getMessage()));
    }
}
