package com.mbridge.msdk.video.dynview.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.video.dynview.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {
    public final com.mbridge.msdk.video.dynview.c a(View view, CampaignEx campaignEx, boolean z9) {
        String strE;
        int iF;
        String str;
        if (campaignEx == null) {
            return null;
        }
        try {
            List<String> arrayList = new ArrayList<>();
            String campaignUnitId = campaignEx.getCampaignUnitId();
            if (campaignEx.getRewardTemplateMode() != null) {
                iF = campaignEx.getRewardTemplateMode().f();
                strE = campaignEx.getRewardTemplateMode().e();
            } else {
                strE = "";
                iF = 0;
            }
            int iA = ak.a(strE, "ia_tp", -5);
            if (!z9) {
                str = "mbridge_reward_videoview_item";
            } else if (iF == 0 || iF == 102 || iF == 202) {
                str = "mbridge_reward_layer_floor";
            } else {
                str = "mbridge_reward_layer_floor_" + iF;
            }
            if (!TextUtils.isEmpty(strE)) {
                String strA = o.a(1, iF + "", strE);
                StringBuilder sb = new StringBuilder("template_");
                sb.append(iF);
                arrayList = ad.a(strA, sb.toString());
            }
            boolean zA = com.mbridge.msdk.video.dynview.i.a.a(strE);
            String strA2 = com.mbridge.msdk.video.dynview.i.a.a(strE, "whs_chn");
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignUnitId, false);
            int iG = cVarA != null ? cVarA.g() : 0;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(campaignEx);
            return new c.a().a(str).a(2).a(arrayList2).a(view.getContext()).a(view).c(iG).f(iA).b(ab.s(view.getContext())).d(iF).a(zA).c(strA2).b(arrayList).e(campaignEx.getDynamicTempCode()).a();
        } catch (Exception e) {
            af.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c b(Context context, List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    float f = ak.f(com.mbridge.msdk.foundation.controller.c.m().c());
                    float fE = ak.e(com.mbridge.msdk.foundation.controller.c.m().c());
                    List<String> arrayList = new ArrayList<>();
                    int dynamicTempCode = list.get(0).getDynamicTempCode();
                    int mof_tplid = list.get(0).getMof_tplid();
                    String mof_template_url = list.get(0).getMof_template_url();
                    int iS = ab.s(context);
                    if (mof_tplid != 0 && !TextUtils.isEmpty(mof_template_url)) {
                        arrayList = ad.a(o.a(0, mof_tplid + "", mof_template_url), "template_" + mof_tplid + "_" + iS);
                    }
                    return new c.a().a(iS == 1 ? "mbridge_order_layout_list_portrait" : "mbridge_order_layout_list_landscape").a(5).a(context).a(fE).b(f).a(list).b(iS).b(arrayList).e(dynamicTempCode).d(mof_tplid).a();
                }
            } catch (Exception e) {
                af.b("ViewOptionWrapper", e.getMessage());
            }
        }
        return null;
    }

    public final com.mbridge.msdk.video.dynview.c b(View view, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignEx.getCampaignUnitId(), false);
            int iG = cVarA != null ? cVarA.g() : 0;
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            return new c.a().a("mbridge_reward_layer_floor_bottom").a(3).a(arrayList).a(view.getContext()).a(view).c(iG).b(ab.s(view.getContext())).a();
        } catch (Exception e) {
            af.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c b(Context context, CampaignEx campaignEx, int i10, String str) {
        if (campaignEx == null) {
            return null;
        }
        try {
            long ecTemplateId = campaignEx.getEcTemplateId();
            int iS = ab.s(context);
            int iA = ak.a(campaignEx.getendcard_url(), "n_logo", 1);
            String str2 = iS == 1 ? "mbridge_reward_endcard_native_half_portrait" : "mbridge_reward_endcard_native_half_landscape";
            String str3 = "template_" + str + iS + "_" + ecTemplateId + "_half";
            List<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                arrayList = ad.a(o.a(2, i10 + "", campaignEx.getendcard_url()), str3);
            }
            return new c.a().a(str2).a(4).a(context).b(ab.s(context)).b(arrayList).e(campaignEx.getDynamicTempCode()).d(i10).b(str).g(iA).a();
        } catch (Exception e) {
            af.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c a(View view, CampaignEx campaignEx) {
        String strE;
        int iF;
        String str;
        if (campaignEx == null) {
            return null;
        }
        try {
            List<String> arrayList = new ArrayList<>();
            String campaignUnitId = campaignEx.getCampaignUnitId();
            if (campaignEx.getRewardTemplateMode() != null) {
                iF = campaignEx.getRewardTemplateMode().f();
                strE = campaignEx.getRewardTemplateMode().e();
            } else {
                strE = "";
                iF = 0;
            }
            int iA = ak.a(strE, "ia_tp", -5);
            if (iF != 0 && iF != 102 && iF != 202) {
                str = "mbridge_reward_layer_floor_" + iF;
            } else {
                str = "mbridge_reward_layer_floor";
            }
            if (!TextUtils.isEmpty(strE)) {
                String strA = o.a(1, iF + "", strE);
                StringBuilder sb = new StringBuilder("template_");
                sb.append(iF);
                arrayList = ad.a(strA, sb.toString());
            }
            boolean zA = com.mbridge.msdk.video.dynview.i.a.a(strE);
            String strA2 = com.mbridge.msdk.video.dynview.i.a.a(strE, "whs_chn");
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignUnitId, false);
            int iG = cVarA != null ? cVarA.g() : 0;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(campaignEx);
            return new c.a().a(str).a(2).a(arrayList2).a(view.getContext()).a(view).c(iG).f(iA).b(ab.s(view.getContext())).d(iF).a(zA).c(strA2).b(arrayList).e(campaignEx.getDynamicTempCode()).a();
        } catch (Exception e) {
            af.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c a(Context context, CampaignEx campaignEx, int i10, String str) {
        String str2;
        String str3;
        if (campaignEx == null) {
            return null;
        }
        try {
            long ecTemplateId = campaignEx.getEcTemplateId();
            int iS = ab.s(context);
            int iA = ak.a(campaignEx.getendcard_url(), "n_logo", 1);
            if (ecTemplateId == 1302) {
                if (iS != 1) {
                    str2 = "mbridge_reward_end_card_layout_landscape_" + ecTemplateId;
                } else {
                    str2 = "mbridge_reward_end_card_layout_portrait_" + ecTemplateId;
                }
                str3 = "template_" + str + iS + "_" + ecTemplateId;
            } else {
                str2 = iS == 1 ? "mbridge_reward_end_card_layout_portrait" : "mbridge_reward_end_card_layout_landscape";
                str3 = "template_" + str + iS;
            }
            List<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                arrayList = ad.a(o.a(2, i10 + "", campaignEx.getendcard_url()), str3);
            }
            return new c.a().a(str2).a(4).a(context).b(ab.s(context)).b(arrayList).e(campaignEx.getDynamicTempCode()).d(i10).b(str).g(iA).a();
        } catch (Exception e) {
            af.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public final com.mbridge.msdk.video.dynview.c a(Context context, List<CampaignEx> list) {
        String mof_template_url;
        int iB;
        int mof_tplid;
        int dynamicTempCode;
        if (list == null) {
            return null;
        }
        try {
            float f = ak.f(com.mbridge.msdk.foundation.controller.c.m().c());
            float fE = ak.e(com.mbridge.msdk.foundation.controller.c.m().c());
            List<String> arrayList = new ArrayList<>();
            if (list.size() <= 0 || list.get(0) == null) {
                mof_template_url = "";
                iB = 1;
                mof_tplid = 0;
                dynamicTempCode = 0;
            } else {
                CampaignEx campaignEx = list.get(0);
                iB = (campaignEx == null || campaignEx.getRewardTemplateMode() == null) ? 1 : campaignEx.getRewardTemplateMode().b();
                mof_tplid = list.get(0).getMof_tplid();
                mof_template_url = list.get(0).getMof_template_url();
                dynamicTempCode = list.get(0).getDynamicTempCode();
            }
            if (mof_tplid != 0 && !TextUtils.isEmpty(mof_template_url)) {
                arrayList = ad.a(o.a(0, mof_tplid + "", mof_template_url), "template_" + mof_tplid + "_" + iB);
            }
            String str = "mbridge_same_choice_one_layout_portrait";
            if (iB != 1) {
                if (iB == 2) {
                    str = "mbridge_same_choice_one_layout_landscape";
                } else if (context.getResources().getConfiguration().orientation == 2) {
                    str = "mbridge_same_choice_one_layout_landscape";
                    iB = 2;
                } else {
                    iB = 1;
                }
            }
            return new c.a().a(context).a(str).a(1).a(fE).b(f).a(list).b(iB).b(arrayList).e(dynamicTempCode).d(mof_tplid).a();
        } catch (Exception e) {
            af.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }
}
