package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class e implements com.mbridge.msdk.foundation.same.c.c {

    /* renamed from: a, reason: collision with root package name */
    private CampaignEx f6080a;

    /* renamed from: b, reason: collision with root package name */
    protected ImageView f6081b;

    /* renamed from: c, reason: collision with root package name */
    private String f6082c;

    public e(ImageView imageView, CampaignEx campaignEx, String str) {
        this.f6081b = imageView;
        this.f6080a = campaignEx;
        this.f6082c = str;
    }

    @Override // com.mbridge.msdk.foundation.same.c.c
    public void onFailedLoad(final String str, String str2) {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.mbridge.msdk.foundation.db.o oVarA = com.mbridge.msdk.foundation.db.o.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                    if (e.this.f6080a == null) {
                        af.a("ImageLoaderListener", "campaign is null");
                        return;
                    }
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
                    nVar.a("2000044");
                    nVar.a(ab.m(com.mbridge.msdk.foundation.controller.c.m().c()));
                    nVar.e(e.this.f6080a.getId());
                    nVar.p(e.this.f6080a.getImageUrl());
                    nVar.f(e.this.f6080a.getRequestId());
                    nVar.g(e.this.f6080a.getRequestIdNotice());
                    nVar.c(e.this.f6082c);
                    nVar.h(str);
                    oVarA.a(nVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        com.mbridge.msdk.foundation.controller.d.a();
        com.mbridge.msdk.foundation.same.f.a.b().execute(runnable);
        af.b("ImageLoaderListener", "desc:" + str);
    }

    @Override // com.mbridge.msdk.foundation.same.c.c
    public void onSuccessLoad(Bitmap bitmap, String str) {
        try {
            if (bitmap == null) {
                af.b("ImageLoaderListener", "bitmap=null");
            } else {
                if (this.f6081b == null || bitmap.isRecycled()) {
                    return;
                }
                this.f6081b.setImageBitmap(bitmap);
                this.f6081b.setVisibility(0);
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    public e(ImageView imageView) {
        this.f6081b = imageView;
    }
}
