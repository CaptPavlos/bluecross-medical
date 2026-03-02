package com.mbridge.msdk.newreward.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements com.mbridge.msdk.newreward.a.b.a {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements com.mbridge.msdk.foundation.same.c.c {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.a f4553a;

        /* renamed from: b, reason: collision with root package name */
        private final b f4554b;

        public a(com.mbridge.msdk.newreward.function.c.a.a aVar, b bVar) {
            this.f4553a = aVar;
            this.f4554b = bVar;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            if (this.f4554b != null && this.f4553a.i().y()) {
                this.f4554b.reqSuccessful(this.f4553a);
            }
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(Bitmap bitmap, String str) {
            if (this.f4554b != null && this.f4553a.i().y()) {
                this.f4554b.reqSuccessful(this.f4553a);
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, b bVar) throws IOException {
        List<CampaignEx.c.a> listA;
        com.mbridge.msdk.newreward.function.c.a.a aVar = (com.mbridge.msdk.newreward.function.c.a.a) obj;
        CampaignEx campaignExH = aVar.h();
        String imageUrl = campaignExH.getImageUrl();
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        com.mbridge.msdk.foundation.same.c.b.a(contextC).a(imageUrl, new a(aVar, bVar));
        com.mbridge.msdk.foundation.same.c.b.a(contextC).a(campaignExH.getIconUrl(), new a(aVar, bVar));
        CampaignEx.c rewardTemplateMode = campaignExH.getRewardTemplateMode();
        if (rewardTemplateMode == null || (listA = rewardTemplateMode.a()) == null) {
            return;
        }
        Iterator<CampaignEx.c.a> it = listA.iterator();
        while (it.hasNext()) {
            List<String> list = it.next().f3509a;
            if (list != null) {
                Iterator<String> it2 = list.iterator();
                while (it2.hasNext()) {
                    com.mbridge.msdk.foundation.same.c.b.a(contextC).a(it2.next(), new a(aVar, bVar));
                }
            }
        }
    }
}
