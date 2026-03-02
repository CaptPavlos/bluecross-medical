package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements com.mbridge.msdk.newreward.function.command.receiver.a {

    /* renamed from: a, reason: collision with root package name */
    List<CampaignEx> f4885a;

    /* renamed from: b, reason: collision with root package name */
    CampaignEx f4886b;

    /* renamed from: c, reason: collision with root package name */
    String f4887c;

    @Override // com.mbridge.msdk.newreward.function.command.receiver.a
    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        Map map = (Map) bVar.b();
        this.f4885a = ((com.mbridge.msdk.newreward.function.c.a.b) map.get("more_offer_campaign")).E();
        CampaignEx campaignEx = (CampaignEx) map.get("campaign");
        this.f4886b = campaignEx;
        if (campaignEx != null) {
            this.f4887c = aq.a(campaignEx.getendcard_url(), "mof_textmod");
        }
        List<CampaignEx> list = this.f4885a;
        if (list == null || list.isEmpty()) {
            bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(-1, ""));
            return;
        }
        List<CampaignEx> list2 = this.f4885a;
        LinearLayout linearLayout = new LinearLayout(com.mbridge.msdk.foundation.controller.c.m().c());
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        for (CampaignEx campaignEx2 : list2) {
            View view = null;
            View viewInflate = LayoutInflater.from(com.mbridge.msdk.foundation.controller.c.m().c()).inflate(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_end_card_more_offer_item", TtmlNode.TAG_LAYOUT), (ViewGroup) null, false);
            int iA = x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_end_card_item_iv", "id");
            if (viewInflate != null) {
                RoundImageView roundImageView = (RoundImageView) viewInflate.findViewById(iA);
                if (roundImageView != null) {
                    roundImageView.setImageDrawable(null);
                }
                TextView textView = (TextView) viewInflate.findViewById(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_end_card_item_title_tv", "id"));
                if (!TextUtils.isEmpty(campaignEx2.getAppName())) {
                    if (TextUtils.isEmpty(this.f4887c) || !this.f4887c.equals("1")) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(campaignEx2.getAppName());
                    }
                }
                view = viewInflate;
            }
            if (view != null) {
                linearLayout.addView(view);
            }
        }
        bVar2.reqSuccessful(linearLayout);
    }
}
