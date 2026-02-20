package com.mbridge.msdk.video.signal.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class l extends d {

    /* renamed from: o, reason: collision with root package name */
    public boolean f6165o = true;

    private com.mbridge.msdk.click.a q() {
        if (this.f6139l == null) {
            this.f6139l = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f6137j);
        }
        return this.f6139l;
    }

    public final void a(CampaignEx campaignEx, Context context) {
        String queryParameter;
        try {
            queryParameter = Uri.parse(campaignEx.getNoticeUrl()).getQueryParameter(com.mbridge.msdk.foundation.same.a.f3609m);
        } catch (Throwable unused) {
        }
        this.f6140m.a((!TextUtils.isEmpty(queryParameter) ? Integer.parseInt(queryParameter) : 0) == 2);
        q().a(this.f6140m);
        q().a(campaignEx);
        com.mbridge.msdk.video.module.b.b.d(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx);
    }

    public final void a(JSONObject jSONObject) {
        try {
            jSONObject.put("device", new com.mbridge.msdk.foundation.tools.i(com.mbridge.msdk.foundation.controller.c.m().c()).a());
        } catch (JSONException e) {
            com.google.gson.internal.a.j(e);
        }
    }
}
