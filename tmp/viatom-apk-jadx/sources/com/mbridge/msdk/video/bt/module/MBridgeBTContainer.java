package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.signal.a.a;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeBTContainer extends AbstractJSContainer implements c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5598a = "MBridgeBTContainer";
    private boolean A;
    private String B;
    private boolean C;
    private List<CampaignEx> D;
    private List<com.mbridge.msdk.videocommon.download.a> E;
    private com.mbridge.msdk.video.bt.module.a.a F;
    private h G;
    private h H;
    private com.mbridge.msdk.video.bt.module.a.b I;
    private String J;
    private String K;
    private String L;
    private boolean M;
    private int N;
    private String O;
    private d P;
    private com.mbridge.msdk.foundation.same.report.d.c Q;
    private t3.b R;
    private u3.b S;
    private t3.a T;

    /* renamed from: b, reason: collision with root package name */
    private int f5599b;

    /* renamed from: c, reason: collision with root package name */
    private int f5600c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f5601d;
    private MBridgeBTLayout e;
    private WindVaneWebView f;
    private LayoutInflater g;
    private Context h;

    /* renamed from: x, reason: collision with root package name */
    private TextView f5602x;
    private ImageView y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f5603z;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private List<CampaignEx> f5608a;

        /* renamed from: b, reason: collision with root package name */
        private Context f5609b;

        /* renamed from: c, reason: collision with root package name */
        private String f5610c;

        /* renamed from: d, reason: collision with root package name */
        private String f5611d;

        public a(List<CampaignEx> list, Context context, String str, String str2) {
            this.f5608a = list;
            this.f5609b = context;
            this.f5610c = str;
            this.f5611d = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<CampaignEx> list = this.f5608a;
            if (list == null || list.size() <= 0) {
                return;
            }
            try {
                e.a(g.a(this.f5609b)).a(this.f5610c, this.f5608a);
                com.mbridge.msdk.videocommon.a.a.a().c(this.f5611d, this.f5608a.get(0).getAdType());
            } catch (Exception unused) {
                af.a(MBridgeBTContainer.f5598a, "remove campaign failed");
            }
        }
    }

    public MBridgeBTContainer(Context context) {
        super(context);
        this.f5599b = 0;
        this.f5600c = 1;
        this.f5603z = false;
        this.A = true;
        this.C = false;
        this.R = null;
        this.S = null;
        this.T = null;
        init(context);
    }

    public static /* synthetic */ void a(MBridgeBTContainer mBridgeBTContainer, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                HashMap map = new HashMap();
                List<com.mbridge.msdk.foundation.entity.d> listA = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getCampaignUnitId(), campaignEx.getRequestId());
                if (listA == null || listA.size() <= 0 || listA.get(0) == null) {
                    return;
                }
                int iC = listA.get(0).c();
                String strB = listA.get(0).b();
                if (iC == 1) {
                    map.put("encrypt_p=", "encrypt_p=" + strB);
                    map.put("irlfa=", "irlfa=1");
                    for (Map.Entry entry : map.entrySet()) {
                        campaignEx.setOnlyImpressionURL(campaignEx.getOnlyImpressionURL().replaceAll((String) entry.getKey(), (String) entry.getValue()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private com.mbridge.msdk.video.bt.module.a.b c() {
        if (this.I == null) {
            this.I = new com.mbridge.msdk.video.bt.module.a.b() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.3
                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, boolean z9, com.mbridge.msdk.videocommon.b.c cVar) throws JSONException {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            if (cVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(RewardPlus.NAME, cVar.a());
                                jSONObject3.put(RewardPlus.AMOUNT, cVar.b());
                                jSONObject2.put("reward", jSONObject3);
                            }
                            jSONObject2.put("isComplete", z9);
                            jSONObject2.put("convert", z9 ? 1 : 2);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            af.a(MBridgeBTContainer.f5598a, " BT Call H5 onAdClose " + jSONObject.toString());
                        } catch (JSONException e) {
                            af.a(MBridgeBTContainer.f5598a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewDismissed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void b(String str, String str2, String str3) throws JSONException {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("convert", true);
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            af.a(MBridgeBTContainer.f5598a, " BT Call H5 onVideoComplete " + jSONObject.toString());
                        } catch (JSONException e) {
                            af.a(MBridgeBTContainer.f5598a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayCompleted", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void c(String str, String str2, String str3) throws JSONException {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            af.a(MBridgeBTContainer.f5598a, " BT Call H5 onEndcardShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            af.a(MBridgeBTContainer.f5598a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewEndcardShowSuccess", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str) throws JSONException {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, ((AbstractJSContainer) MBridgeBTContainer.this).f6451k);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, ((AbstractJSContainer) MBridgeBTContainer.this).f6450j);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            af.a(MBridgeBTContainer.f5598a, " BT Call H5 onAdShow " + jSONObject.toString());
                        } catch (JSONException e) {
                            af.a(MBridgeBTContainer.f5598a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayStart", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(boolean z9, int i10) {
                    MBridgeBTContainer.this.M = z9;
                    MBridgeBTContainer.this.N = i10;
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, String str2) throws JSONException {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, ((AbstractJSContainer) MBridgeBTContainer.this).f6451k);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, ((AbstractJSContainer) MBridgeBTContainer.this).f6450j);
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str2);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            af.a(MBridgeBTContainer.f5598a, " BT Call H5 onShowFail " + jSONObject.toString());
                        } catch (JSONException e) {
                            af.a(MBridgeBTContainer.f5598a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewPlayFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, String str2, String str3) throws JSONException {
                    if (MBridgeBTContainer.this.f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            af.a(MBridgeBTContainer.f5598a, " BT Call H5 onVideoAdClicked " + jSONObject.toString());
                        } catch (JSONException e) {
                            af.a(MBridgeBTContainer.f5598a, e.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onSubPlayTemplateViewClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, int i10, String str2, String str3) {
                    if (MBridgeBTContainer.this.G != null) {
                        MBridgeBTContainer.this.G.a(i10, str2, str3);
                    }
                }
            };
        }
        return this.I;
    }

    private com.mbridge.msdk.videocommon.download.a d(CampaignEx campaignEx) {
        List<com.mbridge.msdk.videocommon.download.a> list = this.E;
        if (list == null || campaignEx == null) {
            return null;
        }
        for (com.mbridge.msdk.videocommon.download.a aVar : list) {
            if (aVar.l().getId().equals(campaignEx.getId())) {
                af.a(f5598a, "tempContainer task initSuccess");
                return aVar;
            }
        }
        return null;
    }

    public void addNativeCloseButtonWhenWebViewCrash() {
        try {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
            int iA = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 48.0f);
            int iA2 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 20.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.setMargins(iA2, iA2, iA2, iA2);
            layoutParams.gravity = 5;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_close", "drawable"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeBTContainer.this.onAdClose();
                }
            });
            addView(imageView);
        } catch (Throwable th) {
            af.b(f5598a, th.getMessage());
        }
    }

    public void appendSubView(MBridgeBTContainer mBridgeBTContainer, MBTempContainer mBTempContainer, JSONObject jSONObject) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                int iOptInt = jSONObject.optInt(TtmlNode.LEFT, -999);
                int iOptInt2 = jSONObject.optInt("top", -999);
                int iOptInt3 = jSONObject.optInt(TtmlNode.RIGHT, -999);
                int iOptInt4 = jSONObject.optInt("bottom", -999);
                if (iOptInt != -999 && contextC != null) {
                    layoutParams.leftMargin = ak.a(contextC, iOptInt);
                }
                if (iOptInt2 != -999 && contextC != null) {
                    layoutParams.topMargin = ak.a(contextC, iOptInt2);
                }
                if (iOptInt3 != -999 && contextC != null) {
                    layoutParams.rightMargin = ak.a(contextC, iOptInt3);
                }
                if (iOptInt4 != -999 && contextC != null) {
                    layoutParams.bottomMargin = ak.a(contextC, iOptInt4);
                }
                int iOptInt5 = jSONObject.optInt("width");
                int iOptInt6 = jSONObject.optInt("height");
                if (iOptInt5 > 0) {
                    layoutParams.width = iOptInt5;
                }
                if (iOptInt6 > 0) {
                    layoutParams.height = iOptInt6;
                }
            }
            mBridgeBTContainer.addView(mBTempContainer, layoutParams);
            mBTempContainer.setActivity(this.f6449i);
            mBTempContainer.setMute(this.f6456p);
            mBTempContainer.setBidCampaign(this.f5603z);
            mBTempContainer.setIV(this.f6457q);
            mBTempContainer.setBigOffer(this.A);
            mBTempContainer.setIVRewardEnable(this.f6459s, this.t, this.f6460u);
            mBTempContainer.setShowRewardListener(this.H);
            mBTempContainer.setCampaignDownLoadTask(d(mBTempContainer.getCampaign()));
            mBTempContainer.setMBridgeTempCallback(c());
            mBTempContainer.setWebViewFront(getJSCommon().a());
            mBTempContainer.init(this.h);
            mBTempContainer.onCreate();
        } catch (Throwable th) {
            af.a(f5598a, th.getMessage());
        }
    }

    public void broadcast(String str, JSONObject jSONObject) throws JSONException {
        if (this.f != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", this.f5599b);
                jSONObject2.put("id", this.B);
                jSONObject2.put("eventName", str);
                jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.mbridge.msdk.video.bt.a.d.c().a((WebView) this.f, "broadcast", this.B);
            }
        }
    }

    public int findID(String str) {
        return x.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public t3.a getAdEvents() {
        return this.T;
    }

    public t3.b getAdSession() {
        return this.R;
    }

    public List<CampaignEx> getCampaigns() {
        return this.D;
    }

    public u3.b getVideoEvents() {
        return this.S;
    }

    public void init(Context context) {
        this.h = context;
        this.g = LayoutInflater.from(context);
    }

    public void onAdClose() {
        Activity activity = this.f6449i;
        if (activity != null) {
            activity.finish();
        }
    }

    public void onBackPressed() {
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onBackPressed();
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onBackPressed();
                } else if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).onBackPressed();
                }
            }
        } catch (Throwable th) {
            af.a(f5598a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onConfigurationChanged(configuration);
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onConfigurationChanged(configuration);
                } else if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).onConfigurationChanged(configuration);
                }
            }
        } catch (Throwable th) {
            af.a(f5598a, th.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(boolean z9) {
        String cMPTEntryUrl;
        WindVaneWebView windVaneWebViewA;
        CampaignEx campaignEx;
        try {
            int iFindLayout = findLayout("mbridge_bt_container");
            if (iFindLayout < 0) {
                a("mbridge_bt_container layout null");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) this.g.inflate(iFindLayout, this);
            this.f5601d = frameLayout;
            if (frameLayout == null) {
                a("ViewIds null");
                return;
            }
            this.K = "";
            List<CampaignEx> list = this.D;
            if (list == null || list.size() <= 0) {
                cMPTEntryUrl = "";
            } else {
                CampaignEx campaignEx2 = this.D.get(0);
                cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                this.K = campaignEx2.getRequestId();
                this.L = campaignEx2.getCurrentLocalRid();
            }
            a.C0071a c0071aA = com.mbridge.msdk.videocommon.a.a(this.f6450j + "_" + this.K + "_" + cMPTEntryUrl);
            RelativeLayout.LayoutParams layoutParams = null;
            if (c0071aA != null) {
                this.B = c0071aA.b();
                af.a(f5598a, "get BT wraper.getTag = " + this.B);
                c0071aA.a("");
                windVaneWebViewA = c0071aA.a();
            } else {
                windVaneWebViewA = null;
            }
            this.f = windVaneWebViewA;
            com.mbridge.msdk.videocommon.a.b(this.f6450j + "_" + this.K + "_" + cMPTEntryUrl);
            t3.b bVar = this.R;
            if (bVar != null) {
                try {
                    bVar.d(this);
                    this.R.f();
                    af.a("omsdk", "btc:  adSession.start();");
                    if (this.T != null) {
                        af.a("omsdk", "btc:   adEvents.loaded");
                        this.T.c(new t3.h(4));
                        af.a("omsdk", "btc:   adEvents.impressionOccurred");
                        this.T.b();
                    }
                } catch (Exception e) {
                    af.a("omsdk", e.getMessage());
                }
            }
            WindVaneWebView windVaneWebView = this.f;
            if (windVaneWebView == null) {
                List<CampaignEx> list2 = this.D;
                if (list2 == null || list2.size() <= 0 || (campaignEx = this.D.get(0)) == null || !(z9 || campaignEx.isDynamicView())) {
                    a("big template webview is null");
                    return;
                }
                Context context = this.h;
                if (this.P == null) {
                    a("ChoiceOneCallback is null");
                    return;
                }
                HashMap map = new HashMap();
                map.put("choice_one_callback", this.P);
                com.mbridge.msdk.video.dynview.b.a();
                new com.mbridge.msdk.video.dynview.h.a(context, this.D, new com.mbridge.msdk.video.dynview.e.h() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.2
                    @Override // com.mbridge.msdk.video.dynview.e.h
                    public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                        String str;
                        if (aVar != null) {
                            str = "errorCode:" + aVar.a() + "Msg:" + aVar.b();
                        } else {
                            str = "";
                        }
                        MBridgeBTContainer.this.a("nativeview is null".concat(str));
                    }

                    @Override // com.mbridge.msdk.video.dynview.e.h
                    public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                        CampaignEx campaignEx3;
                        String string;
                        if (aVar != null) {
                            if (MBridgeBTContainer.this.f5601d == null || aVar.a() == null) {
                                MBridgeBTContainer.this.a("nativeview is null");
                                return;
                            }
                            MBridgeBTContainer.this.f5601d.removeAllViews();
                            MBridgeBTContainer.this.f5601d.addView(aVar.a());
                            MBridgeBTContainer mBridgeBTContainer = MBridgeBTContainer.this;
                            mBridgeBTContainer.f5602x = (TextView) mBridgeBTContainer.findViewById(mBridgeBTContainer.findID("mbridge_choice_one_countdown_tv"));
                            MBridgeBTContainer mBridgeBTContainer2 = MBridgeBTContainer.this;
                            mBridgeBTContainer2.y = (ImageView) mBridgeBTContainer2.findViewById(mBridgeBTContainer2.findID("mbridge_iv_link"));
                            if (MBridgeBTContainer.this.F != null) {
                                MBridgeBTContainer.this.F.a();
                                MBridgeBTContainer.this.F.a(2, ((AbstractJSContainer) MBridgeBTContainer.this).f6451k, ((AbstractJSContainer) MBridgeBTContainer.this).f6450j);
                            }
                            if (MBridgeBTContainer.this.D == null || MBridgeBTContainer.this.D.size() <= 0 || (campaignEx3 = (CampaignEx) MBridgeBTContainer.this.D.get(0)) == null) {
                                return;
                            }
                            if (campaignEx3.isBidCampaign()) {
                                MBridgeBTContainer.a(MBridgeBTContainer.this, campaignEx3);
                            }
                            String onlyImpressionURL = campaignEx3.getOnlyImpressionURL();
                            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), ((AbstractJSContainer) MBridgeBTContainer.this).f6450j);
                            int iY = cVarA != null ? cVarA.y() : 1;
                            if (campaignEx3.getSpareOfferFlag() == 1) {
                                StringBuilder sbW = a3.a.w(onlyImpressionURL, "&to=1&cbt=");
                                sbW.append(campaignEx3.getCbt());
                                sbW.append("&tmorl=");
                                sbW.append(iY);
                                string = sbW.toString();
                            } else {
                                StringBuilder sbW2 = a3.a.w(onlyImpressionURL, "&to=0&cbt=");
                                sbW2.append(campaignEx3.getCbt());
                                sbW2.append("&tmorl=");
                                sbW2.append(iY);
                                string = sbW2.toString();
                            }
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx3, ((AbstractJSContainer) MBridgeBTContainer.this).f6450j, string, false, true, com.mbridge.msdk.click.a.a.h);
                            com.mbridge.msdk.foundation.same.a.b.f3630k.put(campaignEx3.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
                            MBridgeBTContainer.this.a(campaignEx3);
                            try {
                                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "choseFromTwoShow");
                                com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx3, eVar);
                            } catch (Exception e3) {
                                if (MBridgeConstans.DEBUG) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                    }
                }, map);
                return;
            }
            com.mbridge.msdk.video.signal.factory.b bVar2 = new com.mbridge.msdk.video.signal.factory.b(this.f6449i, this, windVaneWebView);
            registerJsFactory(bVar2);
            this.f.setApiManagerJSFactory(bVar2);
            if (this.f.getParent() != null) {
                a("preload template webview is null or load error");
                return;
            }
            if (this.f.getObject() instanceof k) {
                bVar2.a((k) this.f.getObject());
                if (this.f != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f3608l, ak.d(getContext()));
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(RewardPlus.NAME, this.f6454n.a());
                        jSONObject2.put(RewardPlus.AMOUNT, this.f6454n.b());
                        jSONObject2.put("id", this.f6455o);
                        jSONObject.put("userId", this.f6453m);
                        jSONObject.put("reward", jSONObject2);
                        jSONObject.put("playVideoMute", this.f6456p);
                        jSONObject.put("extra", this.O);
                    } catch (JSONException e3) {
                        af.a(f5598a, e3.getMessage());
                    } catch (Exception e7) {
                        af.a(f5598a, e7.getMessage());
                    }
                    this.H = new com.mbridge.msdk.video.bt.module.b.c(c(), "");
                    String string = jSONObject.toString();
                    try {
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000133", this.D, eVar);
                    } catch (Exception unused) {
                    }
                    getJSNotifyProxy().a(string);
                    getJSCommon().b(true);
                    getJSCommon().a(new b());
                }
                ((com.mbridge.msdk.video.signal.a.d) getJSCommon()).f6140m.a();
            }
            this.f.setBackgroundColor(0);
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K);
            if (linkedHashMapB == null || !linkedHashMapB.containsKey(this.B)) {
                a("big template webviewLayout is null");
                return;
            }
            View view = linkedHashMapB.get(this.B);
            if (view instanceof MBridgeBTLayout) {
                MBridgeBTLayout mBridgeBTLayout = (MBridgeBTLayout) view;
                this.e = mBridgeBTLayout;
                try {
                    WindVaneWebView windVaneWebView2 = (WindVaneWebView) mBridgeBTLayout.getBtWebView();
                    k kVar = (k) windVaneWebView2.getObject();
                    kVar.a(this.T);
                    kVar.a(this.S);
                    kVar.a(this.R);
                    windVaneWebView2.setObject(kVar);
                } catch (Exception e10) {
                    af.b(f5598a, e10.getMessage());
                }
                com.mbridge.msdk.foundation.d.b.a().a(this.f6450j + "_1", new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.1
                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void close() {
                        String string2;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject3.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string2 = jSONObject3.toString();
                        } catch (Throwable th) {
                            af.b(MBridgeBTContainer.f5598a, th.getMessage(), th);
                            string2 = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string2.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void showed() {
                        String string2;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject3.put(NotificationCompat.CATEGORY_STATUS, 1);
                            }
                            string2 = jSONObject3.toString();
                        } catch (Throwable th) {
                            af.b(MBridgeBTContainer.f5598a, th.getMessage(), th);
                            string2 = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string2.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void summit(String str) {
                        String string2;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject3.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string2 = jSONObject3.toString();
                        } catch (Throwable th) {
                            af.b(MBridgeBTContainer.f5598a, th.getMessage(), th);
                            string2 = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string2.getBytes(), 2));
                    }
                });
                this.e.addView(this.f, 0, new FrameLayout.LayoutParams(-1, -1));
                com.mbridge.msdk.foundation.d.b.a().c(this.f6450j + "_2");
                FeedBackButton feedBackButtonB = com.mbridge.msdk.foundation.d.b.a().b(this.f6450j + "_1");
                if (com.mbridge.msdk.foundation.d.b.a().b() && feedBackButtonB != null) {
                    try {
                        layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.d.b.f3436b, com.mbridge.msdk.foundation.d.b.f3435a);
                    }
                    layoutParams.topMargin = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 10.0f);
                    layoutParams.leftMargin = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 10.0f);
                    feedBackButtonB.setLayoutParams(layoutParams);
                    ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(feedBackButtonB);
                    }
                    this.e.addView(feedBackButtonB);
                }
                this.e.setTag(this.B);
                linkedHashMapB.put(this.B, this.e);
                Iterator<View> it = linkedHashMapB.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    View next = it.next();
                    if (next instanceof MBridgeBTRootLayout) {
                        MBridgeBTRootLayout mBridgeBTRootLayout = (MBridgeBTRootLayout) next;
                        this.J = mBridgeBTRootLayout.getInstanceId();
                        this.f5601d.addView(mBridgeBTRootLayout, new FrameLayout.LayoutParams(-1, -1));
                        break;
                    }
                }
                linkedHashMapB.remove(this.J);
                linkedHashMapB.put(this.J, this);
            }
            com.mbridge.msdk.video.bt.a.d.c().a(this.f6450j, this.f6456p);
            com.mbridge.msdk.video.bt.a.d.c().a(this.B, this.K);
            com.mbridge.msdk.video.bt.a.d.c().a(this.J, this.K);
            com.mbridge.msdk.video.bt.a.d.c().a(this.f6450j + "_" + this.K, this.f6449i);
            try {
                com.mbridge.msdk.foundation.same.f.a.b().execute(new a(this.D, getContext().getApplicationContext(), this.f6450j, this.f6451k));
            } catch (Throwable unused2) {
                af.a(f5598a, "remove campaign failed");
            }
            List<CampaignEx> list3 = this.D;
            if (list3 == null || list3.size() <= 0) {
                return;
            }
            a(this.f6452l, this.D.get(0));
        } catch (Throwable th) {
            a("onCreate exception " + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.C) {
            return;
        }
        this.C = true;
        if (this.R != null) {
            af.b("omsdk", "btc onDestroy");
            this.R.c();
        }
        super.onDestroy();
        com.mbridge.msdk.video.bt.a.d.c().d(this.f6450j + "_" + this.K);
        try {
            WindVaneWebView windVaneWebView = this.f;
            if (windVaneWebView != null) {
                ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.f.clearWebView();
                this.f.release();
            }
            if (this.I != null) {
                this.I = null;
            }
            if (this.F != null) {
                this.F = null;
            }
            if (this.h != null) {
                this.h = null;
            }
            List<CampaignEx> list = this.D;
            if (list != null && list.size() > 0) {
                for (CampaignEx campaignEx : this.D) {
                    if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
                        com.mbridge.msdk.videocommon.a.b(this.f6450j + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    }
                }
                com.mbridge.msdk.video.dynview.b.a.a().b();
            }
            com.mbridge.msdk.video.bt.a.d.c().f(this.B);
            com.mbridge.msdk.video.bt.a.d.c().g(this.f6450j);
            com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K).remove(this.B);
            com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K).remove(this.J);
            com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K).clear();
        } catch (Throwable th) {
            af.a(f5598a, th.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onPause() {
        CampaignEx campaignEx;
        com.mbridge.msdk.video.dynview.d.a aVar;
        super.onPause();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView() && (aVar = com.mbridge.msdk.video.dynview.b.a.a().f5689a) != null) {
            aVar.b();
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onPause();
                }
            }
        } catch (Throwable th) {
            af.a(f5598a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onResume() {
        CampaignEx campaignEx;
        com.mbridge.msdk.video.dynview.d.a aVar;
        super.onResume();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView() && (aVar = com.mbridge.msdk.video.dynview.b.a.a().f5689a) != null) {
            aVar.a();
        }
        if (com.mbridge.msdk.foundation.d.b.f3437c) {
            return;
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onResume();
                }
            }
        } catch (Throwable th) {
            af.a(f5598a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onStop() {
        CampaignEx campaignEx;
        super.onStop();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.b.a.a().b();
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onStop();
                }
            }
        } catch (Throwable th) {
            af.a(f5598a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.c
    public void reactDeveloper(Object obj, String str) {
        int i10;
        if (this.F == null || TextUtils.isEmpty(str)) {
            a(obj, "listener is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, getUnitId());
            String strOptString2 = jSONObject.optString(MBridgeConstans.PLACEMENT_ID, getPlacementId());
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            CampaignEx campaignEx = this.D.get(0);
            boolean z9 = true;
            if (iOptInt == 1 && jSONObjectOptJSONObject != null) {
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("expired");
                if (campaignEx != null) {
                    if (zOptBoolean) {
                        campaignEx.setSpareOfferFlag(1);
                    } else {
                        campaignEx.setSpareOfferFlag(0);
                    }
                }
            }
            setCBT(campaignEx);
            switch (iOptInt) {
                case 1:
                    this.F.a();
                    this.F.a(2, strOptString2, strOptString);
                    a(obj);
                    break;
                case 2:
                    jSONObjectOptJSONObject = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_ERROR) : null;
                    this.F.a(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(NotificationCompat.CATEGORY_MESSAGE) : "");
                    this.F.a(4, strOptString2, strOptString);
                    a(obj);
                    break;
                case 3:
                    this.F.a(strOptString2, strOptString);
                    this.F.a(5, strOptString2, strOptString);
                    a(obj);
                    break;
                case 4:
                    try {
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000147", this.D, eVar);
                    } catch (Throwable th) {
                        af.b(f5598a, th.getMessage());
                    }
                    this.F.b(strOptString2, strOptString);
                    this.F.a(6, strOptString2, strOptString);
                    a(obj);
                    break;
                case 5:
                    this.F.a(jSONObject.optBoolean("isAutoClick"), strOptString2, strOptString);
                    a(obj);
                    break;
                case 6:
                    if (jSONObjectOptJSONObject != null) {
                        if (jSONObjectOptJSONObject.optInt("convert") != 1) {
                            z9 = false;
                        }
                        jSONObjectOptJSONObject = jSONObjectOptJSONObject.optJSONObject("reward");
                        String strOptString3 = jSONObjectOptJSONObject.optString("extra");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            this.O = strOptString3;
                        }
                    } else {
                        z9 = false;
                    }
                    CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject.optJSONObject("campaign"));
                    com.mbridge.msdk.videocommon.b.c cVarA = com.mbridge.msdk.videocommon.b.c.a(jSONObjectOptJSONObject);
                    if (cVarA == null) {
                        cVarA = this.f6454n;
                    }
                    this.F.a(7, strOptString2, strOptString);
                    try {
                        com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar2.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000152", campaignWithBackData, eVar2);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (this.f6457q && ((i10 = this.f6459s) == com.mbridge.msdk.foundation.same.a.H || i10 == com.mbridge.msdk.foundation.same.a.I)) {
                        this.F.a(this.M, this.N);
                    }
                    if (!z9) {
                        cVarA.a(0);
                        af.a("omsdk", "bt videoEvents :" + this.S);
                        u3.b bVar = this.S;
                        if (bVar != null) {
                            try {
                                bVar.d();
                            } catch (Exception e3) {
                                af.a("omsdk", e3.getMessage());
                            }
                        }
                    }
                    this.F.a(z9, cVarA);
                    af.a(f5598a, "sendToServerRewardInfo");
                    if (!this.f6457q && z9) {
                        String str2 = this.f6453m;
                        if (campaignWithBackData != null) {
                            com.mbridge.msdk.video.module.b.b.a(campaignWithBackData, cVarA, strOptString, str2, this.O);
                        } else {
                            com.mbridge.msdk.video.module.b.b.a(campaignEx, cVarA, strOptString, str2, this.O);
                        }
                    }
                    com.mbridge.msdk.foundation.same.report.d.d.a().a("2000134", campaignWithBackData);
                    a(obj);
                    break;
                default:
                    a(obj);
                    break;
            }
        } catch (JSONException e7) {
            a(obj, e7.getMessage());
            af.a(f5598a, e7.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.c
    public void reportUrls(Object obj, String str) {
        af.a(f5598a, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                int iOptInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                String strA = ak.a(jSONObject.optString("url"), "&tun=", ab.q() + "");
                int iOptInt2 = jSONObject.optInt("report");
                if (iOptInt2 == 0) {
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list = this.D;
                    com.mbridge.msdk.click.a.a(contextC, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list2 = this.D;
                    com.mbridge.msdk.click.a.a(contextC2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString("".getBytes(), 2));
        } catch (Throwable th) {
            af.b(f5598a, "reportUrls", th);
        }
    }

    public void setAdEvents(t3.a aVar) {
        this.T = aVar;
    }

    public void setAdSession(t3.b bVar) {
        this.R = bVar;
    }

    public void setBTContainerCallback(com.mbridge.msdk.video.bt.module.a.a aVar) {
        this.F = aVar;
    }

    public void setCBT(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (campaignEx.getSpareOfferFlag() != 1) {
                campaignEx.setCbt(0);
                return;
            }
            com.mbridge.msdk.videocommon.d.c cVar = this.f6452l;
            if (cVar != null) {
                if (cVar.y() == 1) {
                    campaignEx.setCbt(1);
                } else {
                    campaignEx.setCbt(0);
                }
            }
        }
    }

    public void setCampaignDownLoadTasks(List<com.mbridge.msdk.videocommon.download.a> list) {
        this.E = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCampaigns(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r4) {
        /*
            r3 = this;
            r3.D = r4
            java.lang.String r0 = ""
            if (r4 == 0) goto L1c
            int r1 = r4.size()     // Catch: java.lang.Exception -> L1a
            if (r1 <= 0) goto L1c
            r1 = 0
            java.lang.Object r1 = r4.get(r1)     // Catch: java.lang.Exception -> L1a
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch: java.lang.Exception -> L1a
            if (r1 == 0) goto L1c
            java.lang.String r1 = r1.getCurrentLocalRid()     // Catch: java.lang.Exception -> L1a
            goto L1d
        L1a:
            r4 = move-exception
            goto L43
        L1c:
            r1 = r0
        L1d:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L1a
            if (r2 != 0) goto L2d
            com.mbridge.msdk.foundation.same.report.d.d r2 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch: java.lang.Exception -> L1a
            com.mbridge.msdk.foundation.same.report.d.c r0 = r2.a(r1, r0)     // Catch: java.lang.Exception -> L1a
            r3.Q = r0     // Catch: java.lang.Exception -> L1a
        L2d:
            com.mbridge.msdk.foundation.same.report.d.c r0 = r3.Q     // Catch: java.lang.Exception -> L1a
            if (r0 != 0) goto L38
            com.mbridge.msdk.foundation.same.report.d.c r0 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch: java.lang.Exception -> L1a
            r0.<init>()     // Catch: java.lang.Exception -> L1a
            r3.Q = r0     // Catch: java.lang.Exception -> L1a
        L38:
            com.mbridge.msdk.foundation.same.report.d.c r0 = r3.Q     // Catch: java.lang.Exception -> L1a
            r0.c(r1)     // Catch: java.lang.Exception -> L1a
            com.mbridge.msdk.foundation.same.report.d.c r0 = r3.Q     // Catch: java.lang.Exception -> L1a
            r0.b(r4)     // Catch: java.lang.Exception -> L1a
            return
        L43:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L4a
            r4.printStackTrace()
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.setCampaigns(java.util.List):void");
    }

    public void setChoiceOneCallback(d dVar) {
        this.P = dVar;
    }

    public void setDeveloperExtraData(String str) {
        this.O = str;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.f6462w = bVar;
    }

    public void setNotchPadding(int i10, int i11, int i12, int i13, int i14) {
        TextView textView;
        FrameLayout.LayoutParams layoutParams;
        int i15 = i14;
        try {
            String strA = s.a(i10, i11, i12, i13, i14);
            af.b(f5598a, strA);
            WindVaneWebView windVaneWebView = this.f;
            if (windVaneWebView != null && (windVaneWebView.getObject() instanceof k) && !TextUtils.isEmpty(strA)) {
                ((k) this.f.getObject()).b(strA);
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f, "oncutoutfetched", Base64.encodeToString(strA.getBytes(), 0));
            }
            List<CampaignEx> list = this.D;
            if (list != null && list.size() > 0) {
                try {
                    if (this.D.get(0).isDynamicView() && (textView = this.f5602x) != null && (layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams()) != null) {
                        if (i11 > 0) {
                            layoutParams.leftMargin = i11;
                        }
                        if (i12 > 0) {
                            layoutParams.rightMargin = i12;
                        }
                        if (i13 > 0) {
                            layoutParams.topMargin = i13;
                        }
                        if (i15 > 0) {
                            layoutParams.bottomMargin = i15;
                        }
                        this.f5602x.setLayoutParams(layoutParams);
                        if (this.y != null) {
                            try {
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.y.getLayoutParams());
                                layoutParams2.leftMargin = layoutParams.rightMargin;
                                layoutParams2.topMargin = layoutParams.topMargin;
                                this.y.setLayoutParams(layoutParams2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e3) {
                    af.b(f5598a, e3.getMessage());
                }
            }
            com.mbridge.msdk.video.bt.a.d.c().a(i10, i11, i12, i13, i15);
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f6450j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).setNotchPadding(i11, i12, i13, i15);
                }
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).setNotchPadding(i10, i11, i12, i13, i15);
                }
                if ((view instanceof WindVaneWebView) && !TextUtils.isEmpty(strA)) {
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(view, "oncutoutfetched", Base64.encodeToString(strA.getBytes(), 0));
                }
                i15 = i14;
            }
        } catch (Throwable th) {
            af.a(f5598a, th.getMessage());
        }
    }

    public void setShowRewardVideoListener(h hVar) {
        this.G = hVar;
    }

    public void setVideoEvents(u3.b bVar) {
        this.S = bVar;
    }

    public MBridgeBTContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5599b = 0;
        this.f5600c = 1;
        this.f5603z = false;
        this.A = true;
        this.C = false;
        this.R = null;
        this.S = null;
        this.T = null;
        init(context);
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void click(int i10, String str) {
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i10, String str) {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class b extends a.C0070a {
        private b() {
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void a(boolean z9) {
            super.a(z9);
            if (MBridgeBTContainer.this.S != null) {
                try {
                    MBridgeBTContainer.this.S.a();
                    af.a("omsdk", "btc adUserInteraction click");
                } catch (Exception e) {
                    af.a("omsdk", e.getMessage());
                }
            }
            MBridgeBTContainer.this.H.a(z9, ((AbstractJSContainer) MBridgeBTContainer.this).f6451k, ((AbstractJSContainer) MBridgeBTContainer.this).f6450j);
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void b() {
            super.b();
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            aj.a(campaign, MBridgeBTContainer.this.f5601d);
            if (campaign == null || !(campaign instanceof CampaignEx)) {
                return;
            }
            try {
                CampaignEx campaignEx = (CampaignEx) campaign;
                String strOptString = new JSONObject(MBridgeBTContainer.this.getJSVideoModule().getCurrentProgress()).optString("progress", "");
                if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && strOptString.equals(BuildConfig.VERSION_NAME) && ((AbstractJSContainer) MBridgeBTContainer.this).f6449i != null) {
                    boolean z9 = MBridgeBTContainer.this.A;
                    MBridgeBTContainer mBridgeBTContainer = MBridgeBTContainer.this;
                    if (z9) {
                        mBridgeBTContainer.onAdClose();
                    } else {
                        ((AbstractJSContainer) mBridgeBTContainer).f6449i.finish();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            aj.a(campaign, MBridgeBTContainer.this.f5601d);
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            aj.b(campaign, MBridgeBTContainer.this.f5601d);
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void a() {
            super.a();
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void a(int i10, String str) {
            super.a(i10, str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public final void a(String str) {
        h hVar = this.G;
        if (hVar != null) {
            hVar.a(this.Q, str);
        }
        super.a(str);
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    CampaignEx campaignEx2 = campaignEx;
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx2, this.f6450j, it.next(), false, true);
                    campaignEx = campaignEx2;
                }
            } catch (Throwable th) {
                af.b(f5598a, th.getMessage());
            }
        }
    }
}
