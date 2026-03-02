package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class j extends d {

    /* renamed from: w, reason: collision with root package name */
    public int f4016w;

    /* renamed from: x, reason: collision with root package name */
    public int f4017x;

    public j(Context context) {
        super(context);
        this.f4017x = ab.o();
        this.f4016w = ab.f();
    }

    @Override // com.mbridge.msdk.foundation.tools.d
    public JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dmt", this.f4017x + "");
                jSONObject.put("dmf", this.f4016w);
                return jSONObjectA;
            }
        } catch (JSONException e) {
            if (MBridgeConstans.DEBUG) {
                af.b("DomainDeviceInfo", e.getMessage());
            }
        }
        return jSONObjectA;
    }
}
