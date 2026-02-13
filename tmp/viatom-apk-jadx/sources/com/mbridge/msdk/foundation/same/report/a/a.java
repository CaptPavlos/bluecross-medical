package com.mbridge.msdk.foundation.same.report.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.tracker.e;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected Context f3776a;

    /* renamed from: b, reason: collision with root package name */
    protected h f3777b;

    public a(h hVar) {
        this.f3777b = hVar;
        Context contextC = c.m().c();
        this.f3776a = contextC;
        if (this.f3777b == null || contextC == null) {
            return;
        }
        int iM = ab.m(contextC);
        this.f3777b.d(iM);
        this.f3777b.c(ab.a(this.f3776a, iM));
    }

    public final void a() {
        if (this.f3777b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", this.f3777b.b());
                jSONObject.put(CampaignEx.JSON_KEY_HB, this.f3777b.h());
                jSONObject.put("fb", this.f3777b.e());
                jSONObject.put("num", this.f3777b.c());
                jSONObject.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, this.f3777b.a());
                jSONObject.put("timeout", this.f3777b.i());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f3777b.d());
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", this.f3777b.g());
                    jSONObject.put("network_str", this.f3777b.f());
                }
                e eVar = new e("2000006");
                eVar.b(0);
                eVar.a(0);
                eVar.a(jSONObject);
                eVar.a(com.mbridge.msdk.foundation.same.report.c.c());
                d.a().c().a(eVar);
            } catch (Throwable unused) {
            }
        }
    }

    public final void b(int i10) {
        h hVar = this.f3777b;
        if (hVar != null) {
            hVar.a(i10);
        }
    }

    public final void c(int i10) {
        h hVar = this.f3777b;
        if (hVar != null) {
            hVar.c(i10);
        }
    }

    public final void b(String str) {
        h hVar = this.f3777b;
        if (hVar != null) {
            hVar.b(str);
        }
    }

    public final void a(int i10) {
        h hVar = this.f3777b;
        if (hVar != null) {
            hVar.b(i10);
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3777b.a(str);
    }
}
