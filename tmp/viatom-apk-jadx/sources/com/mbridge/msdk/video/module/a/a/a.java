package com.mbridge.msdk.video.module.a.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private Activity f6075a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f6076b;

    public a(Activity activity, CampaignEx campaignEx) {
        this.f6075a = activity;
        this.f6076b = campaignEx;
    }

    @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i10, Object obj) {
        super.a(i10, obj);
        if (i10 != 106 || this.f6075a == null || this.f6076b == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            String strA = com.mbridge.msdk.click.c.a(this.f6076b.getClickURL(), "-999", "-999");
            if (!TextUtils.isEmpty(strA)) {
                intent.setData(Uri.parse(strA));
                this.f6075a.startActivity(intent);
            }
        } catch (Throwable th) {
            af.b("NotifyListener", th.getMessage(), th);
        }
        this.f6075a.finish();
    }
}
