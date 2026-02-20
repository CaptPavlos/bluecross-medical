package com.mbridge.msdk.reward.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.reward.adapter.RewardUnitCacheManager;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.activity.AbstractJSActivity;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBRewardVideoActivity extends AbstractJSActivity {
    public static String INTENT_EXTRADATA = "extraData";
    public static String INTENT_ISBID = "isBid";
    public static String INTENT_ISBIG_OFFER = "isBigOffer";
    public static String INTENT_ISIV = "isIV";
    public static String INTENT_IVREWARD_MODETYPE = "ivRewardMode";
    public static String INTENT_IVREWARD_VALUE = "ivRewardValue";
    public static String INTENT_IVREWARD_VALUETYPE = "ivRewardValueType";
    public static String INTENT_LOCAL_REQUEST_ID = "lRid";
    public static String INTENT_MUTE = "mute";
    public static String INTENT_REWARD = "reward";
    public static String INTENT_UNITID = "unitId";
    public static String INTENT_USERID = "userId";
    public static String SAVE_STATE_KEY_REPORT = "hasRelease";
    private boolean A;
    private String I;
    private c J;
    private boolean L;

    /* renamed from: a, reason: collision with root package name */
    private String f5291a;

    /* renamed from: b, reason: collision with root package name */
    private String f5292b;

    /* renamed from: c, reason: collision with root package name */
    private String f5293c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.b.c f5294d;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private int f5295i;

    /* renamed from: j, reason: collision with root package name */
    private int f5296j;

    /* renamed from: m, reason: collision with root package name */
    private h f5299m;

    /* renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f5300n;

    /* renamed from: q, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f5303q;

    /* renamed from: r, reason: collision with root package name */
    private CampaignEx f5304r;

    /* renamed from: s, reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.download.a> f5305s;
    private List<CampaignEx> t;

    /* renamed from: u, reason: collision with root package name */
    private MBTempContainer f5306u;

    /* renamed from: v, reason: collision with root package name */
    private MBridgeBTContainer f5307v;

    /* renamed from: w, reason: collision with root package name */
    private WindVaneWebView f5308w;

    /* renamed from: x, reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.a.a f5309x;
    private String y;

    /* renamed from: z, reason: collision with root package name */
    private String f5310z;
    private int e = 2;
    private boolean f = false;
    private boolean g = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5297k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5298l = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5301o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5302p = false;
    private int B = 1;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private boolean K = false;
    private t3.b M = null;
    private u3.b N = null;
    private t3.a O = null;
    private long P = 0;
    private String Q = "";
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private com.mbridge.msdk.video.dynview.e.a U = new com.mbridge.msdk.video.dynview.e.a() { // from class: com.mbridge.msdk.reward.player.MBRewardVideoActivity.1
        @Override // com.mbridge.msdk.video.dynview.e.a
        public final void a(Map<String, Object> map) {
            if (map == null) {
                return;
            }
            if (map.containsKey(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                MBRewardVideoActivity.this.e = ((Integer) map.get(CampaignEx.JSON_NATIVE_VIDEO_MUTE)).intValue();
            }
            if (map.containsKey("position")) {
                int iIntValue = ((Integer) map.get("position")).intValue();
                if (MBRewardVideoActivity.this.t == null || MBRewardVideoActivity.this.t.size() <= 0 || iIntValue < 1) {
                    return;
                }
                MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                mBRewardVideoActivity.f5304r = (CampaignEx) mBRewardVideoActivity.t.get(iIntValue);
                MBRewardVideoActivity.b(MBRewardVideoActivity.this);
                int i10 = iIntValue - 1;
                if (MBRewardVideoActivity.this.t.get(i10) != null) {
                    MBRewardVideoActivity.this.C -= ((CampaignEx) MBRewardVideoActivity.this.t.get(i10)).getVideoLength();
                }
                MBRewardVideoActivity mBRewardVideoActivity2 = MBRewardVideoActivity.this;
                MBRewardVideoActivity.this.f5304r.setVideoCompleteTime(mBRewardVideoActivity2.a(mBRewardVideoActivity2.f5304r.getVideoCompleteTime(), MBRewardVideoActivity.this.B));
                MBRewardVideoActivity.this.f5304r.setShowIndex(MBRewardVideoActivity.this.B);
                MBRewardVideoActivity.this.f5304r.setShowType(1);
                MBRewardVideoActivity mBRewardVideoActivity3 = MBRewardVideoActivity.this;
                mBRewardVideoActivity3.b(mBRewardVideoActivity3.f5304r);
            }
        }
    };
    private d V = new d() { // from class: com.mbridge.msdk.reward.player.MBRewardVideoActivity.2
        @Override // com.mbridge.msdk.video.dynview.e.d
        public final void countDownClick() throws JSONException {
            if (MBRewardVideoActivity.this.f5307v != null) {
                new com.mbridge.msdk.video.dynview.h.b().b(MBRewardVideoActivity.this.f5307v, 500L);
            }
            MBRewardVideoActivity.this.f5297k = true;
            MBRewardVideoActivity.this.b();
            if (MBRewardVideoActivity.this.f5306u != null) {
                MBRewardVideoActivity.this.f5306u.setNotchPadding(MBRewardVideoActivity.this.H, MBRewardVideoActivity.this.D, MBRewardVideoActivity.this.F, MBRewardVideoActivity.this.E, MBRewardVideoActivity.this.G);
            }
        }

        @Override // com.mbridge.msdk.video.dynview.e.d
        public final void itemClick(CampaignEx campaignEx) {
            MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
            if (campaignEx == null) {
                mBRewardVideoActivity.a("campaign is null");
                return;
            }
            if (mBRewardVideoActivity.f5307v != null) {
                new com.mbridge.msdk.video.dynview.h.b().b(MBRewardVideoActivity.this.f5307v, 500L);
            }
            MBRewardVideoActivity.this.f5304r = campaignEx;
            MBRewardVideoActivity.this.f5304r.setShowType(2);
            MBRewardVideoActivity mBRewardVideoActivity2 = MBRewardVideoActivity.this;
            mBRewardVideoActivity2.b(mBRewardVideoActivity2.f5304r);
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f5315a;

        /* renamed from: b, reason: collision with root package name */
        private final String f5316b;

        /* renamed from: c, reason: collision with root package name */
        private final String f5317c;

        public a(List<com.mbridge.msdk.videocommon.download.a> list, String str, String str2) {
            this.f5315a = list;
            this.f5316b = str;
            this.f5317c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f5315a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f5315a) {
                    if (aVar != null && aVar.l() != null) {
                        CampaignEx campaignExL = aVar.l();
                        try {
                            AppletModelManager.getInstance().remove(campaignExL);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("MBRewardVideoActivity", "AppletModelManager remove error", e);
                            }
                        }
                        String str = campaignExL.getRequestId() + campaignExL.getId() + campaignExL.getVideoUrlEncode();
                        j jVarC = com.mbridge.msdk.videocommon.download.b.getInstance().c(this.f5316b);
                        if (jVarC != null) {
                            try {
                                jVarC.b(str);
                            } catch (Exception e3) {
                                if (MBridgeConstans.DEBUG) {
                                    af.b("DownLoadManager", e3.getMessage());
                                }
                            }
                        }
                        if (campaignExL.getRewardTemplateMode() != null) {
                            if (!TextUtils.isEmpty(campaignExL.getRewardTemplateMode().e())) {
                                com.mbridge.msdk.videocommon.a.b(this.f5316b + "_" + campaignExL.getId() + "_" + this.f5317c + "_" + campaignExL.getRewardTemplateMode().e());
                                com.mbridge.msdk.videocommon.a.b(campaignExL.getAdType(), campaignExL);
                            }
                            if (!TextUtils.isEmpty(campaignExL.getCMPTEntryUrl())) {
                                com.mbridge.msdk.videocommon.a.b(this.f5316b + "_" + this.f5317c + "_" + campaignExL.getCMPTEntryUrl());
                            }
                            com.mbridge.msdk.videocommon.a.a.a().a(campaignExL);
                        }
                    }
                }
            } catch (Exception e7) {
                af.a("MBRewardVideoActivity", e7.getMessage());
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f5318a;

        /* renamed from: b, reason: collision with root package name */
        private final String f5319b;

        public b(String str, List<com.mbridge.msdk.videocommon.download.a> list) {
            this.f5318a = list;
            this.f5319b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f5318a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f5318a) {
                    if (aVar != null && aVar.l() != null) {
                        com.mbridge.msdk.videocommon.a.a.a().a(aVar.l(), this.f5319b);
                    }
                }
            } catch (Throwable th) {
                af.b("MBRewardVideoActivity", th.getMessage());
            }
        }
    }

    private void a(List<CampaignEx> list) {
        int dynamicTempCode;
        if (list == null) {
            a("no available campaign");
            return;
        }
        if (list.size() == 0) {
            a("no available campaign");
            return;
        }
        if (list.get(0) != null) {
            dynamicTempCode = list.get(0).getDynamicTempCode();
            this.I = list.get(0).getCurrentLocalRid();
        } else {
            dynamicTempCode = 0;
        }
        if (dynamicTempCode != 5) {
            c();
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null) {
                this.C = campaignEx.getVideoLength() + this.C;
            }
        }
        CampaignEx campaignEx2 = list.get(0);
        if (campaignEx2 == null) {
            a("campaign is less");
            return;
        }
        int iA = a(campaignEx2.getVideoCompleteTime(), this.B);
        this.f5304r = campaignEx2;
        campaignEx2.setCampaignIsFiltered(true);
        this.B = 1;
        this.f5304r.setVideoCompleteTime(iA);
        this.f5304r.setShowIndex(this.B);
        this.f5304r.setShowType(1);
        b(this.f5304r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        List<CampaignEx> list;
        RewardPlus rewardPlus;
        CampaignEx campaignEx;
        List<CampaignEx> list2;
        int iFindID = findID("mbridge_temp_container");
        if (iFindID < 0) {
            a("no id mbridge_bt_container in mbridge_more_offer_activity layout");
        }
        MBTempContainer mBTempContainer = (MBTempContainer) findViewById(iFindID);
        this.f5306u = mBTempContainer;
        if (mBTempContainer == null) {
            a("env error");
        }
        List<CampaignEx> list3 = this.t;
        if (list3 == null || list3.size() <= 0 || !this.t.get(0).isDynamicView()) {
            this.f5306u.setVisibility(0);
        } else {
            new com.mbridge.msdk.video.dynview.h.b().c(this.f5306u, 500L);
        }
        changeHalfScreenPadding(-1);
        this.f5306u.setActivity(this);
        this.f5306u.setBidCampaign(this.g);
        this.f5306u.setBigOffer(this.f5297k);
        this.f5306u.setUnitId(this.f5291a);
        this.f5306u.setCampaign(this.f5304r);
        if (this.f5304r.getDynamicTempCode() == 5 && (list2 = this.t) != null && list2.size() > 1) {
            View viewFindViewById = findViewById(findID("mbridge_reward_root_container"));
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.f5306u.removeAllViews();
            this.f5306u.setCampOrderViewData(this.t, this.C);
            this.f5306u.setCamPlayOrderCallback(this.U, this.B);
        }
        this.f5306u.setCampaignDownLoadTask(this.f5303q);
        this.f5306u.setIV(this.f);
        CampaignEx campaignEx2 = this.f5304r;
        if (campaignEx2 == null || campaignEx2.getAdSpaceT() != 2) {
            this.f5306u.setIVRewardEnable(this.h, this.f5295i, this.f5296j);
        } else {
            this.f5306u.setIVRewardEnable(0, 0, 0);
        }
        this.f5306u.setMute(this.e);
        CampaignEx campaignEx3 = this.f5304r;
        if (((campaignEx3 != null && (rewardPlus = campaignEx3.getRewardPlus()) != null) || ((list = this.t) != null && list.size() > 0 && this.t.get(0) != null && (rewardPlus = this.t.get(0).getRewardPlus()) != null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.f5294d = cVar;
        }
        this.f5306u.setReward(this.f5294d);
        this.f5306u.setRewardUnitSetting(this.f5300n);
        this.f5306u.setPlacementId(this.f5292b);
        this.f5306u.setUserId(this.f5293c);
        this.f5306u.setShowRewardListener(this.f5299m);
        this.f5306u.setDeveloperExtraData(this.f5310z);
        this.f5306u.init(this);
        this.f5306u.setAdSession(this.M);
        this.f5306u.setAdEvents(this.O);
        this.f5306u.setVideoEvents(this.N);
        this.f5306u.onCreate();
        if (!com.mbridge.msdk.e.b.a() || (campaignEx = this.f5304r) == null) {
            return;
        }
        c(campaignEx);
    }

    private void c() {
        RewardPlus rewardPlus;
        List<CampaignEx> list;
        int iFindID = findID("mbridge_bt_container");
        if (iFindID < 0) {
            a("no mbridge_webview_framelayout in mbridge_more_offer_activity layout");
        }
        MBridgeBTContainer mBridgeBTContainer = (MBridgeBTContainer) findViewById(iFindID);
        this.f5307v = mBridgeBTContainer;
        if (mBridgeBTContainer == null) {
            a("env error");
        }
        this.f5307v.setVisibility(0);
        com.mbridge.msdk.video.bt.module.a.a aVarD = d();
        this.f5309x = aVarD;
        this.f5307v.setBTContainerCallback(aVarD);
        this.f5307v.setShowRewardVideoListener(this.f5299m);
        this.f5307v.setChoiceOneCallback(this.V);
        this.f5307v.setCampaigns(this.t);
        this.f5307v.setCampaignDownLoadTasks(this.f5305s);
        this.f5307v.setRewardUnitSetting(this.f5300n);
        this.f5307v.setUnitId(this.f5291a);
        this.f5307v.setPlacementId(this.f5292b);
        this.f5307v.setUserId(this.f5293c);
        this.f5307v.setActivity(this);
        CampaignEx campaignEx = this.f5304r;
        if (((campaignEx != null && (rewardPlus = campaignEx.getRewardPlus()) != null) || (this.t.get(0) != null && (rewardPlus = this.t.get(0).getRewardPlus()) != null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.f5294d = cVar;
        }
        this.f5307v.setReward(this.f5294d);
        this.f5307v.setIVRewardEnable(this.h, this.f5295i, this.f5296j);
        this.f5307v.setIV(this.f);
        this.f5307v.setMute(this.e);
        this.f5307v.setJSFactory((com.mbridge.msdk.video.signal.factory.b) this.jsFactory);
        this.f5307v.setDeveloperExtraData(this.f5310z);
        this.f5307v.init(this);
        this.f5307v.setAdSession(this.M);
        this.f5307v.setVideoEvents(this.N);
        this.f5307v.setAdEvents(this.O);
        this.f5307v.onCreate(this.K);
        if (!com.mbridge.msdk.e.b.a() || (list = this.t) == null || list.size() <= 0 || this.t.get(0) == null) {
            return;
        }
        c(this.t.get(0));
    }

    private void d(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c());
                campaignEx.getImageUrl();
            }
            if (TextUtils.isEmpty(campaignEx.getIconUrl())) {
                return;
            }
            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c());
            campaignEx.getIconUrl();
        }
    }

    private void e() {
        try {
            List<CampaignEx> list = this.t;
            if (list != null && list.size() > 0) {
                Iterator<CampaignEx> it = this.t.iterator();
                while (it.hasNext()) {
                    d(it.next());
                }
            }
            CampaignEx campaignEx = this.f5304r;
            if (campaignEx != null) {
                d(campaignEx);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    public void changeHalfScreenPadding(int i10) {
        int iE;
        int iF;
        int iF2;
        float f;
        try {
            CampaignEx campaignEx = this.f5304r;
            if (campaignEx == null || campaignEx.getAdSpaceT() != 2) {
                return;
            }
            getWindow().getDecorView().setBackgroundColor(-1728053248);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5306u.getLayoutParams();
            layoutParams.gravity = 17;
            if (this.f5304r.getRewardTemplateMode().b() == 0) {
                if (i10 == 2) {
                    iE = (int) (ak.e(this) * 0.6f);
                    iF2 = ak.f(this);
                    f = iF2 * 0.6f;
                } else {
                    iE = (int) (ak.e(this) * 0.6f);
                    iF = ak.f(this);
                    f = iF * 0.7f;
                }
            } else if (this.f5304r.getRewardTemplateMode().b() == 2) {
                iE = (int) (ak.e(this) * 0.6f);
                iF2 = ak.f(this);
                f = iF2 * 0.6f;
            } else {
                iE = (int) (ak.e(this) * 0.6f);
                iF = ak.f(this);
                f = iF * 0.7f;
            }
            int i11 = (int) f;
            layoutParams.height = iE;
            layoutParams.width = i11;
            this.f5306u.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            af.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    public int findID(String str) {
        return x.a(getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    @Override // android.app.Activity
    public void finish() {
        this.S = true;
        if (this.M != null) {
            af.b("omsdk", "mbrewardvideoac finish");
            this.M.e();
            this.M.c();
            this.M = null;
        }
        com.mbridge.msdk.foundation.controller.c.m().b(0);
        MBTempContainer mBTempContainer = this.f5306u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f5306u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.f5307v = null;
        }
        com.mbridge.msdk.foundation.d.b.a().c(this.f5291a);
        super.finish();
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onBackPressed() {
        this.T = true;
        super.onBackPressed();
        MBTempContainer mBTempContainer = this.f5306u;
        if (mBTempContainer != null) {
            mBTempContainer.onBackPressed();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onBackPressed();
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f5306u != null) {
            changeHalfScreenPadding(configuration.orientation);
            this.f5306u.onConfigurationChanged(configuration);
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onConfigurationChanged(configuration);
        }
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        List<com.mbridge.msdk.videocommon.download.a> list;
        String cMPTEntryUrl = "";
        super.onCreate(bundle);
        MBridgeConstans.isRewardActivityShowing = true;
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        this.P = SystemClock.elapsedRealtime();
        this.Q = TextUtils.isEmpty(this.Q) ? "onCreate" : a3.a.o(new StringBuilder(), this.Q, "_onCreate");
        try {
            Intent intent = getIntent();
            this.f5291a = intent.getStringExtra(INTENT_UNITID);
            this.f5292b = intent.getStringExtra(MBridgeConstans.PLACEMENT_ID);
            this.f5294d = com.mbridge.msdk.videocommon.b.c.b(intent.getStringExtra(INTENT_REWARD));
            this.f5293c = intent.getStringExtra(INTENT_USERID);
            this.e = intent.getIntExtra(INTENT_MUTE, 2);
            this.f = intent.getBooleanExtra(INTENT_ISIV, false);
            com.mbridge.msdk.foundation.controller.c.m().b(this.f ? 287 : 94);
            this.g = intent.getBooleanExtra(INTENT_ISBID, false);
            this.f5310z = intent.getStringExtra(INTENT_EXTRADATA);
            boolean booleanExtra = intent.getBooleanExtra("is_refactor", false);
            this.K = booleanExtra;
            if (booleanExtra) {
                this.f5299m = MBridgeGlobalCommon.showRewardListenerMap.get(this.f5291a);
            } else {
                this.f5299m = com.mbridge.msdk.reward.b.a.f.get(this.f5291a);
            }
            if (this.f) {
                this.h = intent.getIntExtra(INTENT_IVREWARD_MODETYPE, 0);
                this.f5295i = intent.getIntExtra(INTENT_IVREWARD_VALUETYPE, 0);
                this.f5296j = intent.getIntExtra(INTENT_IVREWARD_VALUE, 0);
            }
            this.f5297k = intent.getBooleanExtra(INTENT_ISBIG_OFFER, false);
            this.f5305s = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f5291a);
            this.t = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f5291a);
            int iFindLayout = findLayout("mbridge_more_offer_activity");
            if (iFindLayout < 0) {
                a("no mbridge_more_offer_activity layout");
                return;
            }
            setContentView(iFindLayout);
            if (TextUtils.isEmpty(this.f5291a)) {
                a("data empty error");
                return;
            }
            IJSFactory bVar = new com.mbridge.msdk.video.signal.factory.b(this);
            this.jsFactory = bVar;
            registerJsFactory(bVar);
            if (this.f5299m == null) {
                a("showRewardListener is null");
                return;
            }
            com.mbridge.msdk.videocommon.d.c cVar = RewardUnitCacheManager.getInstance().get(this.f5292b, this.f5291a);
            this.f5300n = cVar;
            if (cVar == null) {
                com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f5291a);
                this.f5300n = cVarA;
                if (cVarA == null) {
                    this.f5300n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f5291a, this.f);
                }
            }
            com.mbridge.msdk.videocommon.d.c cVar2 = this.f5300n;
            if (cVar2 != null) {
                this.f5294d.a(cVar2.m());
                this.f5294d.a(this.f5300n.n());
            }
            com.mbridge.msdk.videocommon.b.c cVar3 = this.f5294d;
            if (cVar3 != null && cVar3.b() <= 0) {
                this.f5294d.a(1);
            }
            int iA = x.a(this, "mbridge_reward_activity_open", "anim");
            int iA2 = x.a(this, "mbridge_reward_activity_stay", "anim");
            if (iA > 1 && iA2 > 1) {
                overridePendingTransition(iA, iA2);
            }
            if (bundle != null) {
                try {
                    this.f5302p = bundle.getBoolean(SAVE_STATE_KEY_REPORT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            af.a("DynamicViewCampaignResourceDownloader", "进入 show，大模板 " + this.f5297k);
            if (!this.f5297k) {
                List<com.mbridge.msdk.videocommon.download.a> list2 = this.f5305s;
                if (list2 != null && list2.size() > 0) {
                    this.f5303q = this.f5305s.get(0);
                }
                com.mbridge.msdk.videocommon.download.a aVar = this.f5303q;
                if (aVar != null) {
                    this.f5304r = aVar.l();
                    this.f5303q.e(true);
                    this.f5303q.f(false);
                    CampaignEx campaignEx = this.f5304r;
                    if (campaignEx != null) {
                        this.I = campaignEx.getCurrentLocalRid();
                        this.f5304r.setShowIndex(1);
                        this.f5304r.setShowType(1);
                        com.mbridge.msdk.reward.b.a.f5213b = this.f5304r.getEcppv();
                        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f5304r.getMaitve(), this.f5304r.getMaitve_src());
                    }
                }
                if (this.f5303q == null || this.f5304r == null || this.f5294d == null) {
                    a("data empty error");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f5304r);
                b(arrayList);
                a(this.f5304r);
                b();
                if (com.mbridge.msdk.e.b.a()) {
                    return;
                }
                a();
                return;
            }
            b(this.t);
            this.y = "";
            List<CampaignEx> list3 = this.t;
            if (list3 != null && list3.size() > 0) {
                CampaignEx campaignEx2 = this.t.get(0);
                a(campaignEx2);
                cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                this.y = campaignEx2.getRequestId();
                this.I = campaignEx2.getCurrentLocalRid();
                com.mbridge.msdk.reward.b.a.f5213b = campaignEx2.getEcppv();
                com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx2.getMaitve(), campaignEx2.getMaitve_src());
            }
            a.C0071a c0071aA = com.mbridge.msdk.videocommon.a.a(this.f5291a + "_" + this.y + "_" + cMPTEntryUrl);
            WindVaneWebView windVaneWebViewA = c0071aA != null ? c0071aA.a() : null;
            this.f5308w = windVaneWebViewA;
            if (windVaneWebViewA == null) {
                if (this.f5303q == null && (list = this.f5305s) != null && list.size() > 0) {
                    this.f5303q = this.f5305s.get(0);
                }
                if (this.f5303q == null) {
                    com.mbridge.msdk.videocommon.download.b bVar2 = com.mbridge.msdk.videocommon.download.b.getInstance();
                    int i10 = this.f ? 287 : 94;
                    String str = this.f5291a;
                    boolean z9 = this.g;
                    j jVarC = bVar2.c(str);
                    this.f5303q = jVarC != null ? jVarC.b(i10, z9) : null;
                }
                com.mbridge.msdk.videocommon.download.a aVar2 = this.f5303q;
                if (aVar2 != null) {
                    this.f5304r = aVar2.l();
                    this.f5303q.e(true);
                    this.f5303q.f(false);
                }
                if (this.f5303q != null && this.f5304r != null && this.f5294d != null) {
                    this.f5297k = false;
                    List<CampaignEx> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.t);
                    if (listA == null) {
                        a("no available campaign");
                        return;
                    }
                    int size = listA.size();
                    if (size == 0) {
                        a("no available campaign");
                        return;
                    }
                    if (listA.get(0) == null || !listA.get(0).isDynamicView()) {
                        b();
                    } else if (size == 1) {
                        CampaignEx campaignEx3 = listA.get(0);
                        this.f5304r = campaignEx3;
                        if (campaignEx3 != null) {
                            this.I = campaignEx3.getCurrentLocalRid();
                            this.f5304r.setCampaignIsFiltered(true);
                        }
                        b(this.f5304r);
                    } else {
                        a(listA);
                    }
                }
                a("data empty error");
                return;
            }
            a(this.t.get(0));
            WindVaneWebView windVaneWebView = this.f5308w;
            if (windVaneWebView != null) {
                try {
                    k kVar = (k) windVaneWebView.getObject();
                    kVar.a(this.O);
                    kVar.a(this.M);
                    kVar.a(this.N);
                    this.f5308w.setObject(kVar);
                } catch (Exception e3) {
                    af.b("MBRewardVideoActivity", e3.getMessage());
                }
            }
            c();
            if (com.mbridge.msdk.e.b.a()) {
                return;
            }
            a();
        } catch (Throwable th) {
            b(this.t);
            a("onCreate error" + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onDestroy() {
        h hVar;
        this.Q = TextUtils.isEmpty(this.Q) ? "onDestroy" : a3.a.o(new StringBuilder(), this.Q, "_onDestroy");
        super.onDestroy();
        h hVar2 = this.f5299m;
        if (hVar2 != null && (hVar2 instanceof com.mbridge.msdk.video.bt.module.b.b)) {
            try {
                com.mbridge.msdk.video.bt.module.b.b bVar = (com.mbridge.msdk.video.bt.module.b.b) hVar2;
                if (!bVar.f5667b && !bVar.f5668c) {
                    this.R = true;
                }
            } catch (Throwable th) {
                af.b("MBRewardVideoActivity", th.getMessage());
            }
        }
        e eVar = new e();
        eVar.a("activity_life_cycle", TextUtils.isEmpty(this.Q) ? "unKnown" : this.Q);
        eVar.a("activity_duration", Long.valueOf(SystemClock.elapsedRealtime() - this.P));
        eVar.a("is_unexpected_destroy", Integer.valueOf(this.R ? 1 : 2));
        eVar.a("is_listener_null", Integer.valueOf(this.f5299m == null ? 1 : 2));
        eVar.a("is_called_finish", Integer.valueOf(this.S ? 1 : 2));
        eVar.a("is_back_pressed", Integer.valueOf(this.T ? 1 : 2));
        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000151", this.f5304r, eVar);
        try {
            if (this.R && (hVar = this.f5299m) != null) {
                hVar.a(this.J, "show fail : unexpected destroy");
            }
        } catch (Throwable th2) {
            af.b("MBRewardVideoActivity", th2.getMessage());
        }
        com.mbridge.msdk.video.module.b.b.a(this.f5291a);
        e();
        MBTempContainer mBTempContainer = this.f5306u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f5306u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.f5307v = null;
        }
        this.U = null;
        this.V = null;
        com.mbridge.msdk.foundation.d.b.a().c(this.f5291a + "_1");
        com.mbridge.msdk.foundation.d.b.a().c(this.f5291a + "_2");
        com.mbridge.msdk.foundation.same.f.a.b().execute(new a(this.f5305s, this.f5291a, this.y));
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.Q = TextUtils.isEmpty(this.Q) ? "onPause" : a3.a.o(new StringBuilder(), this.Q, "_onPause");
        MBTempContainer mBTempContainer = this.f5306u;
        if (mBTempContainer != null) {
            mBTempContainer.onPause();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onPause();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        this.Q = TextUtils.isEmpty(this.Q) ? "onRestart" : a3.a.o(new StringBuilder(), this.Q, "_onRestart");
        MBTempContainer mBTempContainer = this.f5306u;
        if (mBTempContainer != null) {
            mBTempContainer.onRestart();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onRestart();
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onResume() {
        MBridgeVideoView mBridgeVideoView;
        super.onResume();
        this.Q = TextUtils.isEmpty(this.Q) ? "onResume" : a3.a.o(new StringBuilder(), this.Q, "_onResume");
        if (com.mbridge.msdk.foundation.d.b.f3437c) {
            MBTempContainer mBTempContainer = this.f5306u;
            if (mBTempContainer == null || (mBridgeVideoView = mBTempContainer.mbridgeVideoView) == null) {
                return;
            }
            mBridgeVideoView.setCover(false);
            return;
        }
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        try {
            com.mbridge.msdk.foundation.same.f.a.b().execute(new b(this.f5291a, this.f5305s));
        } catch (Throwable th) {
            af.b("MBRewardVideoActivity", th.getMessage());
        }
        MBTempContainer mBTempContainer2 = this.f5306u;
        if (mBTempContainer2 != null) {
            mBTempContainer2.onResume();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(SAVE_STATE_KEY_REPORT, this.f5302p);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.Q = TextUtils.isEmpty(this.Q) ? "onStart" : a3.a.o(new StringBuilder(), this.Q, "_onStart");
        if (com.mbridge.msdk.foundation.d.b.f3437c) {
            return;
        }
        new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.reward.player.MBRewardVideoActivity.4
            @Override // com.mbridge.msdk.foundation.d.a
            public final void close() {
                MBRewardVideoActivity.this.onResume();
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void showed() {
                MBRewardVideoActivity.this.onPause();
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void summit(String str) {
                MBRewardVideoActivity.this.onResume();
            }
        };
        MBTempContainer mBTempContainer = this.f5306u;
        if (mBTempContainer != null) {
            mBTempContainer.onStart();
            this.f5304r.setCampaignUnitId(this.f5291a);
            com.mbridge.msdk.foundation.d.b.a().a(a3.a.o(new StringBuilder(), this.f5291a, "_1"), this.f5304r);
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStart();
            List<CampaignEx> list = this.t;
            if (list != null && list.size() > 0) {
                CampaignEx campaignEx = this.t.get(0);
                campaignEx.setCampaignUnitId(this.f5291a);
                com.mbridge.msdk.foundation.d.b.a().a(this.f5291a + "_1", campaignEx);
            }
        }
        if (this.A) {
            return;
        }
        com.mbridge.msdk.foundation.d.b.a().a(this.f5291a + "_1", 1);
        com.mbridge.msdk.foundation.d.b.a().c(this.f5291a + "_2");
        this.A = true;
    }

    @Override // android.app.Activity
    public void onStop() {
        this.Q = TextUtils.isEmpty(this.Q) ? "onStop" : a3.a.o(new StringBuilder(), this.Q, "_onStop");
        MBridgeConstans.isRewardActivityShowing = false;
        super.onStop();
        MBTempContainer mBTempContainer = this.f5306u;
        if (mBTempContainer != null) {
            mBTempContainer.onStop();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStop();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        super.setTheme(x.a(this, "mbridge_transparent_theme", TtmlNode.TAG_STYLE));
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity
    public void setTopControllerPadding(int i10, int i11, int i12, int i13, int i14) throws JSONException {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        this.D = i11;
        this.F = i12;
        this.E = i13;
        this.G = i14;
        this.H = i10;
        MBTempContainer mBTempContainer = this.f5306u;
        if (mBTempContainer != null) {
            mBTempContainer.setNotchPadding(i10, i11, i12, i13, i14);
            i19 = i14;
            i18 = i13;
            i17 = i12;
            i16 = i11;
            i15 = i10;
        } else {
            i15 = i10;
            i16 = i11;
            i17 = i12;
            i18 = i13;
            i19 = i14;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f5307v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.setNotchPadding(i15, i16, i17, i18, i19);
        }
        int i20 = i15;
        int i21 = i16;
        int i22 = i17;
        com.mbridge.msdk.video.dynview.a.a.e = i20;
        com.mbridge.msdk.video.dynview.a.a.f5682a = i21;
        com.mbridge.msdk.video.dynview.a.a.f5683b = i22;
        com.mbridge.msdk.video.dynview.a.a.f5684c = i18;
        com.mbridge.msdk.video.dynview.a.a.f5685d = i19;
    }

    private com.mbridge.msdk.video.bt.module.a.a d() {
        if (this.f5309x == null) {
            this.f5309x = new com.mbridge.msdk.video.bt.module.a.a() { // from class: com.mbridge.msdk.reward.player.MBRewardVideoActivity.3
                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a() {
                    if (MBRewardVideoActivity.this.f5299m != null) {
                        MBRewardVideoActivity.this.f5299m.a(MBRewardVideoActivity.this.J);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void b(String str, String str2) {
                    if (MBRewardVideoActivity.this.f5299m != null) {
                        MBRewardVideoActivity.this.f5299m.b(str, str2);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(boolean z9, com.mbridge.msdk.videocommon.b.c cVar) {
                    if (MBRewardVideoActivity.this.f5299m != null) {
                        MBRewardVideoActivity.this.f5299m.a(MBRewardVideoActivity.this.J, z9, cVar);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(boolean z9, int i10) {
                    if (MBRewardVideoActivity.this.f5299m != null) {
                        MBRewardVideoActivity.this.f5299m.a(z9, i10);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(String str) {
                    if (MBRewardVideoActivity.this.f5299m != null) {
                        MBRewardVideoActivity.this.f5299m.a(MBRewardVideoActivity.this.J, str);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(boolean z9, String str, String str2) {
                    if (MBRewardVideoActivity.this.f5299m != null) {
                        MBRewardVideoActivity.this.f5299m.a(z9, str, str2);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(String str, String str2) {
                    if (MBRewardVideoActivity.this.f5299m != null) {
                        MBRewardVideoActivity.this.f5299m.a(str, str2);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(int i10, String str, String str2) {
                    if (MBRewardVideoActivity.this.f5299m != null) {
                        MBRewardVideoActivity.this.f5299m.a(i10, str, str2);
                    }
                }
            };
        }
        return this.f5309x;
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isActiveOm() && this.M == null) {
                    t3.b bVarA = com.mbridge.msdk.a.b.a(getApplicationContext(), false, campaignEx.getOmid(), campaignEx.getRequestId(), campaignEx.getId(), this.f5291a, campaignEx.getVideoUrlEncode(), campaignEx.getRequestIdNotice());
                    this.M = bVarA;
                    if (bVarA != null) {
                        this.O = t3.a.a(bVarA);
                        this.N = u3.b.b(this.M);
                    }
                }
            } catch (Throwable th) {
                af.b("MBRewardVideoActivity", th.getMessage());
            }
        }
    }

    private void a() {
        try {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            BitmapDrawable bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(this.f5291a, this.f ? 287 : 94);
            if (bitmapDrawableA != null) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                ak.a(imageView, bitmapDrawableA, getResources().getDisplayMetrics());
                ((ViewGroup) ((ViewGroup) ((ViewGroup) viewGroup.getChildAt(0)).getChildAt(1)).getChildAt(0)).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        af.b("MBRewardVideoActivity", str);
        b(this.t);
        h hVar = this.f5299m;
        if (hVar != null) {
            hVar.a(this.J, str);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i10, int i11) {
        List<CampaignEx> list = this.t;
        if (list != null && list.size() != 0) {
            int videoLength = 0;
            int videoCompleteTime = 0;
            for (int i12 = 0; i12 < this.t.size(); i12++) {
                if (this.t.get(0) != null) {
                    if (i12 == 0) {
                        videoCompleteTime = this.t.get(0).getVideoCompleteTime();
                    }
                    videoLength += this.t.get(i12).getVideoLength();
                }
            }
            if (i11 == 1) {
                if (i10 == 0) {
                    if (videoLength >= 45) {
                        return 45;
                    }
                } else if (videoLength > i10) {
                    if (i10 > 45) {
                        return 45;
                    }
                }
                return videoLength;
            }
            int videoLength2 = 0;
            for (int i13 = 0; i13 < i11 - 1; i13++) {
                if (this.t.get(i13) != null) {
                    videoLength2 += this.t.get(i13).getVideoLength();
                }
            }
            if (videoCompleteTime > videoLength2) {
                return videoCompleteTime - videoLength2;
            }
            return 0;
        }
        return i10;
    }

    private void c(CampaignEx campaignEx) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx) {
        CampaignEx campaignExL;
        try {
            List<com.mbridge.msdk.videocommon.download.a> list = this.f5305s;
            if (list != null && list.size() > 0) {
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f5305s) {
                    if (aVar != null && (campaignExL = aVar.l()) != null && TextUtils.equals(campaignExL.getId(), campaignEx.getId()) && TextUtils.equals(campaignExL.getRequestId(), campaignEx.getRequestId())) {
                        this.f5303q = aVar;
                    }
                }
            }
            this.f5297k = true;
            b();
            MBTempContainer mBTempContainer = this.f5306u;
            if (mBTempContainer != null) {
                mBTempContainer.setNotchPadding(this.H, this.D, this.F, this.E, this.G);
            }
        } catch (Exception e) {
            af.b("MBRewardVideoActivity", e.getMessage());
            a("more offer to one offer exception");
        }
    }

    public static /* synthetic */ int b(MBRewardVideoActivity mBRewardVideoActivity) {
        int i10 = mBRewardVideoActivity.B;
        mBRewardVideoActivity.B = i10 + 1;
        return i10;
    }

    private void b(List<CampaignEx> list) {
        String currentLocalRid;
        CampaignEx campaignEx;
        if (this.L) {
            return;
        }
        List<CampaignEx> list2 = list;
        if (list == null) {
            try {
                if (this.f5297k) {
                    list2 = this.t;
                } else {
                    ArrayList arrayList = new ArrayList();
                    List<com.mbridge.msdk.videocommon.download.a> list3 = this.f5305s;
                    list2 = arrayList;
                    if (list3 != null) {
                        list2 = arrayList;
                        if (list3.get(0) != null) {
                            list2 = arrayList;
                            if (this.f5305s.get(0).l() != null) {
                                arrayList.add(this.f5305s.get(0).l());
                                list2 = arrayList;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (list2 == null || list2.isEmpty() || (campaignEx = list2.get(0)) == null) {
            currentLocalRid = "";
        } else {
            currentLocalRid = campaignEx.getCurrentLocalRid();
        }
        if (!TextUtils.isEmpty(currentLocalRid)) {
            this.J = com.mbridge.msdk.foundation.same.report.d.d.a().a(currentLocalRid, "");
        }
        if (this.J == null) {
            this.J = new c();
            e eVar = new e();
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f5291a);
            eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(this.g ? 1 : 0));
            eVar.a("adtp", Integer.valueOf(this.f ? 287 : 94));
            eVar.a("lrid", this.I);
            eVar.a("his_reason", "show campaign is null");
            this.J.a("2000129", eVar);
        }
        if (list2 != null) {
            this.J.b(list2);
        }
        this.L = true;
        com.mbridge.msdk.reward.c.a.a.a().a("2000129", this.J);
    }
}
