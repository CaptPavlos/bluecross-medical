package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import com.mbridge.msdk.foundation.controller.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class WebGLCheckSignal extends BaseWebGLCheckSignal {
    public void webglState(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            c.m().c(jSONObject.optInt("webgl"));
            c.m().a(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
