package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends e {

    /* renamed from: d, reason: collision with root package name */
    private int f2801d;
    private com.mbridge.msdk.foundation.same.e.b g;
    private n h;

    /* renamed from: a, reason: collision with root package name */
    JumpLoaderResult f2798a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f2799b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f2800c = null;
    private f e = null;
    private boolean f = true;

    /* renamed from: i, reason: collision with root package name */
    private Handler f2802i = new Handler(Looper.getMainLooper());

    public d(Context context) {
        this.g = new com.mbridge.msdk.foundation.same.e.b(context);
        this.h = new n(context);
    }

    public final void a(String str, CampaignEx campaignEx, f fVar) {
        this.f2800c = new String(campaignEx.getClickURL());
        this.e = fVar;
        this.f2798a = null;
        this.h.a(campaignEx.getClickURL(), fVar, CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode()), campaignEx.getId(), str, campaignEx, true, false, com.mbridge.msdk.click.a.a.f2769j);
    }

    public final void a(String str, CampaignEx campaignEx, f fVar, String str2, boolean z9, boolean z10, int i10) {
        String id;
        this.f2800c = str2;
        this.e = fVar;
        this.f2798a = null;
        this.f2801d = i10;
        if (campaignEx != null) {
            z = CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode());
            id = campaignEx.getId();
        } else {
            id = "";
        }
        this.h.a(str2, fVar, z, id, str, campaignEx, z9, z10, i10);
    }

    @Override // com.mbridge.msdk.click.e
    public final void a() {
        this.f = false;
    }
}
