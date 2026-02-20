package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements com.mbridge.msdk.newreward.function.command.receiver.b {

    /* renamed from: a, reason: collision with root package name */
    com.mbridge.msdk.newreward.a.e f4861a;

    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) {
        com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) ((com.mbridge.msdk.newreward.function.command.b) obj).b();
        this.f4861a = eVar;
        if (eVar != null) {
            try {
                com.mbridge.msdk.newreward.function.c.a.b bVarB = eVar.D().b();
                a aVar = new a(bVarB, this.f4861a);
                try {
                    String str = MBRewardVideoActivity.INTENT_UNITID;
                    Intent intent = new Intent(com.mbridge.msdk.foundation.controller.c.m().c(), (Class<?>) MBRewardVideoActivity.class);
                    intent.putExtra(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f4861a.H());
                    intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.f4861a.C());
                    intent.putExtra(CampaignEx.JSON_NATIVE_VIDEO_MUTE, this.f4861a.O());
                    boolean z9 = this.f4861a.h() == 287;
                    intent.putExtra("isIV", z9);
                    intent.putExtra("isBid", TextUtils.isEmpty(this.f4861a.J()));
                    if (z9) {
                        intent.putExtra("ivRewardMode", this.f4861a.t());
                        intent.putExtra("ivRewardValueType", this.f4861a.u());
                        intent.putExtra("ivRewardValue", this.f4861a.v());
                    }
                    intent.putExtra("isBigOffer", !TextUtils.isEmpty(bVarB.B()));
                    intent.putExtra("is_refactor", true);
                    List<com.mbridge.msdk.newreward.function.c.a.a> listU = bVarB.u();
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.a> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                    for (com.mbridge.msdk.newreward.function.c.a.a aVar2 : listU) {
                        CampaignEx campaignExH = aVar2.h();
                        campaignExH.setReady_rate(100);
                        copyOnWriteArrayList.add(campaignExH);
                        com.mbridge.msdk.videocommon.download.a aVar3 = new com.mbridge.msdk.videocommon.download.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignExH, this.f4861a.H(), 1);
                        aVar3.d(this.f4861a.h());
                        aVar3.d(campaignExH.getVideoUrlEncode());
                        n nVarD = aVar2.d();
                        if (nVarD != null) {
                            aVar3.c(nVarD.g().getPath());
                        }
                        copyOnWriteArrayList2.add(aVar3);
                        try {
                            n nVarD2 = aVar2.d();
                            if (nVarD2 != null) {
                                nVarD2.l().a(1, null);
                            }
                        } catch (Exception e) {
                            af.b("ShowReceiver", "downloadVideoForShow", e);
                        }
                    }
                    com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f4861a.H(), copyOnWriteArrayList);
                    com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f4861a.H(), copyOnWriteArrayList2);
                    intent.addFlags(268435456);
                    MBridgeGlobalCommon.showRewardListenerMap.put(this.f4861a.H(), aVar);
                    com.mbridge.msdk.foundation.controller.c.m().c().startActivity(intent);
                } catch (Exception unused) {
                    aVar.a(new com.mbridge.msdk.foundation.same.report.d.c(), "activity not found");
                }
            } catch (Exception e3) {
                af.b("ShowReceiver", "show", e3);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a extends com.mbridge.msdk.video.bt.module.b.b {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f4862a;

        /* renamed from: d, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.e f4863d;

        public a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.a.e eVar) {
            this.f4862a = bVar;
            this.f4863d = eVar;
            this.f5667b = false;
            this.f5668c = false;
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
            int iA;
            int iB;
            try {
                this.f5668c = true;
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f4862a.c(), this.f4862a.d(), this.f4862a.e(), this.f4862a.g(), 7);
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("reason", str);
                com.mbridge.msdk.newreward.a.e eVar2 = this.f4863d;
                if (eVar2 != null) {
                    int filterCallBackState = 0;
                    if (eVar2.D() == null || this.f4863d.D().b() == null) {
                        iA = 0;
                        iB = 0;
                    } else {
                        com.mbridge.msdk.newreward.function.c.a.b bVarB = this.f4863d.D().b();
                        iA = bVarB.a();
                        iB = bVarB.b();
                        if (bVarB.E() != null && !bVarB.E().isEmpty()) {
                            filterCallBackState = bVarB.E().get(0).getFilterCallBackState();
                        }
                    }
                    eVar.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState));
                    eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA));
                    eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB));
                }
                cVar.a("2000131", eVar);
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000131", cVar);
                com.mbridge.msdk.newreward.a.e eVar3 = this.f4863d;
                RewardVideoListener rewardVideoListenerK = eVar3 != null ? eVar3.K() : null;
                if (rewardVideoListenerK != null) {
                    rewardVideoListenerK.onShowFail(new MBridgeIds(this.f4863d.C(), this.f4863d.H()), str);
                }
            } catch (Exception e) {
                af.b("DefaultShowRewardListener", "onShowFail", e);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void b(String str, String str2) {
            try {
                com.mbridge.msdk.foundation.d.b.a().a(str2 + "_2", 2);
                com.mbridge.msdk.newreward.a.e eVar = this.f4863d;
                RewardVideoListener rewardVideoListenerK = eVar != null ? eVar.K() : null;
                if (rewardVideoListenerK != null) {
                    rewardVideoListenerK.onEndcardShow(new MBridgeIds(this.f4863d.C(), this.f4863d.H()));
                }
            } catch (Exception e) {
                af.b("DefaultShowRewardListener", "onEndcardShow", e);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
            RewardVideoListener rewardVideoListenerK;
            int iA;
            int iB;
            try {
                this.f5667b = true;
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f4862a.c(), this.f4862a.d(), this.f4862a.e(), this.f4862a.g(), 6);
                com.mbridge.msdk.newreward.a.e eVar = this.f4863d;
                if (eVar != null) {
                    rewardVideoListenerK = eVar.K();
                    com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                    int filterCallBackState = 0;
                    if (this.f4863d.D() == null || this.f4863d.D().b() == null) {
                        iA = 0;
                        iB = 0;
                    } else {
                        com.mbridge.msdk.newreward.function.c.a.b bVarB = this.f4863d.D().b();
                        iA = bVarB.a();
                        iB = bVarB.b();
                        if (bVarB.E() != null && !bVarB.E().isEmpty()) {
                            filterCallBackState = bVarB.E().get(0).getFilterCallBackState();
                        }
                    }
                    eVar2.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState));
                    eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(iA));
                    eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(iB));
                    cVar.a("2000130", eVar2);
                } else {
                    rewardVideoListenerK = null;
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000130", cVar);
                if (rewardVideoListenerK != null) {
                    rewardVideoListenerK.onAdShow(new MBridgeIds(this.f4863d.C(), this.f4863d.H()));
                }
            } catch (Exception e) {
                af.b("DefaultShowRewardListener", "onAdShow", e);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z9, com.mbridge.msdk.videocommon.b.c cVar2) {
            try {
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000152", cVar);
                com.mbridge.msdk.newreward.a.e eVar = this.f4863d;
                RewardVideoListener rewardVideoListenerK = eVar != null ? eVar.K() : null;
                if (rewardVideoListenerK != null) {
                    rewardVideoListenerK.onAdClose(new MBridgeIds(this.f4863d.C(), this.f4863d.H()), new RewardInfo(z9, cVar2.a(), String.valueOf(cVar2.b())));
                }
            } catch (Exception e) {
                af.b("DefaultShowRewardListener", "onAdClose", e);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(int i10, String str, String str2) {
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z9, String str, String str2) {
            try {
                com.mbridge.msdk.newreward.a.e eVar = this.f4863d;
                RewardVideoListener rewardVideoListenerK = eVar != null ? eVar.K() : null;
                if (rewardVideoListenerK != null) {
                    rewardVideoListenerK.onVideoAdClicked(new MBridgeIds(this.f4863d.C(), this.f4863d.H()));
                }
            } catch (Exception e) {
                af.b("DefaultShowRewardListener", "onVideoAdClicked", e);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(String str, String str2) {
            try {
                com.mbridge.msdk.newreward.a.e eVar = this.f4863d;
                RewardVideoListener rewardVideoListenerK = eVar != null ? eVar.K() : null;
                if (rewardVideoListenerK != null) {
                    rewardVideoListenerK.onVideoComplete(new MBridgeIds(this.f4863d.C(), this.f4863d.H()));
                }
            } catch (Exception e) {
                af.b("DefaultShowRewardListener", "onVideoComplete", e);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z9, int i10) {
            try {
                com.mbridge.msdk.newreward.a.e eVar = this.f4863d;
                RewardVideoListener rewardVideoListenerK = eVar != null ? eVar.K() : null;
                if (rewardVideoListenerK != null) {
                    rewardVideoListenerK.onAdCloseWithIVReward(new MBridgeIds(this.f4863d.C(), this.f4863d.H()), z9, i10);
                }
            } catch (Exception e) {
                af.b("DefaultShowRewardListener", "onAdCloseWithIVReward", e);
            }
        }
    }
}
