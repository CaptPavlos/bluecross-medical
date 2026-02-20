package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.player.model.MoreOfferModel;
import com.mbridge.msdk.newreward.player.redirect.MoreOfferRedirectModel;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ReceiverAction(id = "MoreOfferPreSendTrackingReceiver", type = com.mbridge.msdk.newreward.function.command.receiver.b.class)
/* loaded from: classes3.dex */
public class MoreOfferPreSendTrackingReceiver implements com.mbridge.msdk.newreward.function.command.receiver.b {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f4871a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f4872b;

    /* renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f4873c;

    /* renamed from: d, reason: collision with root package name */
    private int f4874d;
    private int e;
    private com.mbridge.msdk.newreward.function.command.c f;
    private MoreOfferModel g;
    private MoreOfferRedirectModel h;

    /* renamed from: i, reason: collision with root package name */
    private List<Integer> f4875i;

    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) throws JSONException {
        com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) obj;
        this.f4871a = eVar;
        if (eVar != null) {
            this.f4872b = eVar.U();
            try {
                JSONObject jSONObject = new JSONObject(this.f4872b.getMoreOfferJsonData()).getJSONObject(CampaignEx.ENDCARD_URL);
                if (jSONObject != null) {
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM)) {
                        this.f4874d = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                    }
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF)) {
                        this.e = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
            try {
                com.mbridge.msdk.newreward.function.command.c cVarB = com.mbridge.msdk.newreward.function.command.d.a().b();
                this.f = cVarB;
                this.g = new MoreOfferModel(cVarB);
                if (this.f4871a.E() != null) {
                    this.f4875i = this.f4871a.E().f4970a;
                }
                MoreOfferRedirectModel moreOfferRedirectModel = new MoreOfferRedirectModel();
                this.h = moreOfferRedirectModel;
                moreOfferRedirectModel.setContext(com.mbridge.msdk.foundation.controller.c.m().c());
                this.h.setSettingModel(this.f4871a.x());
                if (this.f4871a.E() != null && this.f4871a.E().b() != null) {
                    this.f4873c = this.f4871a.E().b().E();
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.MoreOfferPreSendTrackingReceiver.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MoreOfferPreSendTrackingReceiver.this.a();
                    }
                });
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public final void a() {
        if (this.f4874d == 1) {
            try {
                int iMin = Math.min(this.e, this.f4873c.size());
                for (int i10 = 0; i10 < iMin; i10++) {
                    this.h.setItemPositionId(i10);
                    if (!this.f4875i.contains(Integer.valueOf(i10))) {
                        this.f4875i.add(Integer.valueOf(i10));
                        if (this.f4871a != null && this.h != null) {
                            try {
                                String str = "117361";
                                CampaignEx campaignEx = this.f4873c.get(i10);
                                String strA = "";
                                if (campaignEx != null) {
                                    this.h.setCampaignEx(campaignEx);
                                    strA = aq.a(campaignEx.getendcard_url(), "mof_testuid");
                                    if (TextUtils.isEmpty(strA)) {
                                        strA = aq.a(campaignEx.getendcard_url(), "mof_uid");
                                    }
                                }
                                if (!TextUtils.isEmpty(strA)) {
                                    str = strA;
                                }
                                this.h.setUnitId(str);
                            } catch (Exception e) {
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        if (i10 == 0) {
                            this.g.eventOnlyImpression(this.h);
                        }
                        this.g.eventImpression(this.h);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
