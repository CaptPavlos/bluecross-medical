package com.mbridge.msdk.video.dynview.moffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.dynview.endcard.expose.OnItemExposeListener;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.dynview.widget.ObservableScrollView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MOfferModel implements NoProGuard {
    private static final String MOF_LOAD_RESULT_CODE_OFFER_LESS_THAN_5 = "12930014";
    private static final String MOF_LOAD_RESULT_FAILED = "2";
    private static final String MOF_LOAD_RESULT_SUCCESS = "1";
    private static final String TAG = "MOfferModel";
    private int admf;
    private int admftm;
    private List<Integer> cacheImpressionReportList;
    private List<Integer> cacheOnlyImpressionReportList;
    private boolean isShowMoreOffer;
    private CampaignUnit mCampaignUnit;
    private Context mContext;
    private LinearLayout mLinearLayout;
    private CampaignEx mMainOfferCampaignEx;
    private g mMoreOfferLayoutListener;
    private com.mbridge.msdk.video.module.a.a mNotifyListener;
    private ObservableScrollView mObservableScrollView;
    private e mParam;
    private String mRid;
    private String mUnitId;
    private MBridgeRelativeLayout viewMofferLayout;
    private final String VALUE_MOF_TYPE = "1";
    private final String VALUE_H5_TYPE = "1";
    private final String VALUE_MOF = "1";
    private final String VALUE_COUNTRY_CODE = "CN";
    private final String VALUE_MOF_VER = "1";
    private final String VALUE_OFF_SET = "0";
    private final String VALUE_CATEGORY = "0";
    private final String VALUE_ONLY_IMPRESSION = "1";
    private final String VALUE_PING_MODE = "1";
    private final String VALUE_HTTP_REQ = "2";
    private final String VALUE_AD_NUM = "20";
    private final String VALUE_TNUM = "20";
    private final String VALUE_API_VERSION = "2.3";
    private final String VALUE_DEFAULT_VIDEO_TEMP_ID = "404";
    private final String K = CampaignEx.JSON_KEY_AD_K;
    private final String MOF_TEST_UID = "mof_testuid";
    private final String MCC = "mcc";
    private final String MOF_UID = "mof_uid";
    private final String MNC = "mnc";
    private final String RV_TID = "rv_tid";
    private final String EC_ID = "ecid";
    private final String TP_LGP = "tplgp";
    private final String V_FMD5 = "v_fmd5";
    private final String I_FMD5 = "i_fmd5";
    private final String APP_ID = MBridgeConstans.APP_ID;
    private final String SIGN = "sign";
    private final String PARENT_UNIT = "parent_unit";
    private final String E = "e";
    private final String MOF_TYPE = "mof_type";
    private final String H5_TYPE = "h5_type";
    private final String MOF = "mof";
    private final String COUNTRY_CODE = "country_code";
    private final String MOF_VER = "mof_ver";
    private final String CRT_CID = "crt_cid";
    private final String CRT_RID = "crt_rid";
    private final String H5_T = "h5_t";
    private final String MOF_T = "mof_t";
    private final String MOF_DATA = "mof_data";
    private final String OFFER_ID = "offer_id";
    private final String OFF_SET = TypedValues.CycleType.S_WAVE_OFFSET;
    private final String CATEGORY = "category";
    private final String ONLY_IMPRESSION = "only_impression";
    private final String PING_MODE = "ping_mode";
    private final String HTTP_REQ = "http_req";
    private final String AD_NUM = "ad_num";
    private final String TNUM = "tnum";
    private final String API_VERSION = "api_version";
    private final String MOF_DOMAIN = "mof_domain";
    private final String PARENT_ID = "parent_id";
    private final String MOF_PARENT_ID = "mof_parent_id";
    private final String MOF_CALLBACK_DATE = "mcd";
    private final String UC_PARENT_UNIT = "uc_parent_unit";
    private final String DEFAULT_PATH_V3 = "/openapi/ad/v3";
    private final String PARENT_EXCHANGE = "parent_exchange";
    private final String PARENT_AD_TYPE = "parent_ad_type";
    private final String PARENT_TEMPLATE_ID = "parent_template_id";
    private final String ONE_ID = "oneId";
    private final String DY_VIEW = "dy_view";
    private final String MORE_OFFER_DEFAULT_UNIT_ID = "117361";
    private final String MORE_OFFER_DEFAULT_APP_ID = "92762";
    private final String MORE_OFFER_DEFAULT_APP_KEY = "936dcbdd57fe235fd7cf61c2e93da3c4";
    private final String MORE_OFFER_LOAD_SUCCESS = "more offer load success";
    private final String MORE_OFFER_LOAD_FAILED = "more offer load failed";
    private final String MORE_OFFER_SHOW = "more offer show";
    private final String MORE_OFFER_CLICK = "more offer click";
    private final String MORE_OFFER_SHOW_FAILED = "more offer show fail";
    private final String UNIT_ID = MBridgeConstans.PROPERTIES_UNIT_ID;
    private final String R_ID = "r_id";
    private final int DO_ACTION_IMPRESSION = 0;
    private final int DO_ACTION_ONLY_IMPRESSION = 1;
    private volatile boolean hasReportMoreOfferLoad = false;
    private volatile boolean hasReportMoreOfferShow = false;
    private int bitmapSuccessCount = 0;
    private List<Integer> mImpressionId = new ArrayList();
    private int mControlShowSize = 0;
    private boolean isOnlyImpShow = false;
    private boolean mHasReportMofScenes = false;
    private boolean mIsRetry = false;
    private int mFromType = 0;
    private OnItemExposeListener onItemExposeListener = new OnItemExposeListener() { // from class: com.mbridge.msdk.video.dynview.moffer.MOfferModel.1
        @Override // com.mbridge.msdk.video.dynview.endcard.expose.OnItemExposeListener
        public final void onItemViewFirstVisible() {
            if (MOfferModel.this.viewMofferLayout == null || !MOfferModel.this.isOnlyImpShow) {
                return;
            }
            int visibility = MOfferModel.this.viewMofferLayout.getVisibility();
            MOfferModel mOfferModel = MOfferModel.this;
            if (visibility == 0) {
                try {
                    com.mbridge.msdk.video.dynview.f.a.a(mOfferModel.mCampaignUnit, 0, 1, "117361");
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (mOfferModel.cacheOnlyImpressionReportList == null) {
                MOfferModel.this.cacheOnlyImpressionReportList = new ArrayList();
            }
            MOfferModel.this.cacheOnlyImpressionReportList.add(0);
        }

        @Override // com.mbridge.msdk.video.dynview.endcard.expose.OnItemExposeListener
        public final void onItemViewVisible(boolean z9, int i10) {
            if (MOfferModel.this.viewMofferLayout == null) {
                return;
            }
            int visibility = MOfferModel.this.viewMofferLayout.getVisibility();
            MOfferModel mOfferModel = MOfferModel.this;
            if (visibility != 0) {
                if (mOfferModel.cacheImpressionReportList == null) {
                    MOfferModel.this.cacheImpressionReportList = new ArrayList();
                }
                if (MOfferModel.this.cacheImpressionReportList.contains(Integer.valueOf(i10))) {
                    return;
                }
                MOfferModel.this.cacheImpressionReportList.add(Integer.valueOf(i10));
                return;
            }
            if (!mOfferModel.hasReportMoreOfferShow) {
                com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().c(), "more offer show", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                MOfferModel.this.hasReportMoreOfferShow = true;
            }
            try {
                com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, i10, 0, "117361");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private c mMoreOfferShowCallBack = new c() { // from class: com.mbridge.msdk.video.dynview.moffer.MOfferModel.2
        @Override // com.mbridge.msdk.video.dynview.moffer.c
        public final void a(List<View> list) {
            TextView textView;
            if (MOfferModel.this.viewMofferLayout == null || (textView = (TextView) MOfferModel.this.viewMofferLayout.findViewById(MOfferModel.this.findID("mbridge_reward_end_card_like_tv"))) == null) {
                return;
            }
            textView.setVisibility(0);
        }
    };

    public static /* synthetic */ int access$2208(MOfferModel mOfferModel) {
        int i10 = mOfferModel.bitmapSuccessCount;
        mOfferModel.bitmapSuccessCount = i10 + 1;
        return i10;
    }

    private void addLikeTextView() {
        TextView textView;
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout == null || (textView = (TextView) mBridgeRelativeLayout.findViewById(findID("mbridge_reward_end_card_like_tv"))) == null) {
            return;
        }
        textView.setTextColor(Color.parseColor("#FF000000"));
        textView.setTextSize(10.0f);
        if (ab.t(com.mbridge.msdk.foundation.controller.c.m().c()).contains("zh")) {
            textView.setEms(1);
            textView.getLayoutParams().width = com.mbridge.msdk.dycreator.baseview.a.e(30.0f);
            textView.setText("猜你喜欢");
        } else {
            textView.setText("Just\nfor\nYou");
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.dynview.moffer.MOfferModel.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MOfferModel.this.mObservableScrollView != null) {
                    int visibility = MOfferModel.this.mObservableScrollView.getVisibility();
                    MOfferModel mOfferModel = MOfferModel.this;
                    if (visibility == 0) {
                        mOfferModel.mObservableScrollView.setVisibility(8);
                    } else {
                        mOfferModel.mObservableScrollView.setVisibility(0);
                    }
                }
                try {
                    new com.mbridge.msdk.video.dynview.h.b().a(MOfferModel.this.mLinearLayout, 300L);
                } catch (Exception e) {
                    af.b(MOfferModel.TAG, e.getMessage());
                }
            }
        });
    }

    private View buildItemView(final int i10) {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        final View viewInflate = LayoutInflater.from(this.mContext).inflate(x.a(context, "mbridge_reward_end_card_more_offer_item", TtmlNode.TAG_LAYOUT), (ViewGroup) null, false);
        int iA = x.a(this.mContext, "mbridge_reward_end_card_item_iv", "id");
        if (viewInflate == null) {
            return null;
        }
        setOfferData(this.mCampaignUnit.getAds(), i10, (RoundImageView) viewInflate.findViewById(iA), (TextView) viewInflate.findViewById(x.a(this.mContext, "mbridge_reward_end_card_item_title_tv", "id")));
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.dynview.moffer.MOfferModel.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CampaignEx campaignEx;
                try {
                    if (MOfferModel.this.mCampaignUnit == null || MOfferModel.this.mCampaignUnit.ads == null || MOfferModel.this.mCampaignUnit.ads.size() <= 0 || (campaignEx = MOfferModel.this.mCampaignUnit.ads.get(i10)) == null) {
                        return;
                    }
                    if (MOfferModel.this.mNotifyListener != null) {
                        MOfferModel mOfferModel = MOfferModel.this;
                        mOfferModel.callBackClick(mOfferModel.mNotifyListener);
                    }
                    com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().c(), "more offer click", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                    com.mbridge.msdk.video.dynview.f.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, MOfferModel.this.mUnitId, viewInflate);
                } catch (Exception e) {
                    af.b(MOfferModel.TAG, e.getMessage());
                }
            }
        });
        return viewInflate;
    }

    private void buildRequestParams(CampaignEx campaignEx) throws JSONException {
        String str;
        String str2;
        String str3;
        if (campaignEx == null) {
            return;
        }
        this.mParam = new e();
        String campaignUnitId = campaignEx.getCampaignUnitId();
        String id = campaignEx.getId();
        String requestIdNotice = campaignEx.getRequestIdNotice();
        campaignEx.getRequestId();
        String strA = aq.a(campaignEx.getendcard_url(), "mof_testuid");
        if (TextUtils.isEmpty(strA)) {
            strA = aq.a(campaignEx.getendcard_url(), "mof_uid");
        }
        String strK = com.mbridge.msdk.foundation.controller.c.m().k();
        String strR = (TextUtils.isEmpty(strK) || h.a().b(strK) == null) ? "CN" : h.a().b(strK).r();
        String strA2 = aq.a(campaignEx.getendcard_url(), "mcc");
        String strA3 = aq.a(campaignEx.getendcard_url(), "mnc");
        String strA4 = aq.a(campaignEx.getendcard_url(), "rv_tid");
        String strA5 = campaignEx.getendcard_url().contains("ecid") ? aq.a(campaignEx.getendcard_url(), "ecid") : String.valueOf(campaignEx.getEcTemplateId());
        String str4 = strA;
        String strA6 = aq.a(campaignEx.getendcard_url(), "tplgp");
        String str5 = strR;
        String strA7 = aq.a(campaignEx.getendcard_url(), "v_fmd5");
        String strA8 = aq.a(campaignEx.getendcard_url(), "i_fmd5");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().k());
        e eVar = this.mParam;
        StringBuilder sbV = a3.a.v(strK);
        sbV.append(com.mbridge.msdk.foundation.controller.c.m().b());
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "sign", SameMD5.getMD5(sbV.toString()));
        e eVar2 = this.mParam;
        String str6 = "";
        if (TextUtils.isEmpty(requestIdNotice)) {
            str = "sign";
            str2 = "";
        } else {
            str = "sign";
            str2 = requestIdNotice;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar2, "r_id", str2);
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "e", Arrays.toString(new String[]{id}));
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mof_type", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "h5_type", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mof", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "country_code", TextUtils.isEmpty(str5) ? "CN" : str5);
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mof_ver", "1");
        this.mParam.a("parent_exchange", "");
        int adType = campaignEx.getAdType();
        if (adType == 94) {
            str6 = "rewarded_video";
        } else if (adType == 287) {
            str6 = "interstitial_video";
        }
        this.mParam.a("parent_ad_type", str6);
        this.mParam.a("oneId", campaignEx.getReq_ext_data());
        boolean zIsEmpty = TextUtils.isEmpty(strA5);
        e eVar3 = this.mParam;
        if (zIsEmpty) {
            eVar3.a("parent_template_id", "404");
        } else {
            eVar3.a("parent_template_id", strA5);
        }
        boolean zIsEmpty2 = TextUtils.isEmpty(str4);
        e eVar4 = this.mParam;
        if (zIsEmpty2) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar4, "uc_parent_unit", campaignUnitId);
        } else {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar4, "parent_unit", campaignUnitId);
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mnc", strA3);
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mcc", strA2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crt_cid", id);
            jSONObject.put("crt_rid", requestIdNotice);
            jSONObject.put("rv_tid", strA4);
            jSONObject.put("ecid", strA5);
            jSONObject.put("tplgp", strA6);
            jSONObject.put("v_fmd5", strA7);
            jSONObject.put("i_fmd5", strA8);
            jSONObject.put("h5_t", 1);
            jSONObject.put("mof_t", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mof_data", jSONObject.toString());
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "offer_id", id);
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, TypedValues.CycleType.S_WAVE_OFFSET, "0");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "category", "0");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "http_req", "2");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "ad_num", "20");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "tnum", "20");
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "api_version", "2.3");
        if (TextUtils.isEmpty(str4)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, MBridgeConstans.APP_ID, "92762");
            com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, str, SameMD5.getMD5("92762936dcbdd57fe235fd7cf61c2e93da3c4"));
            str3 = "117361";
        } else {
            str3 = str4;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, MBridgeConstans.PROPERTIES_UNIT_ID, str3);
        com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "dy_view", "1");
    }

    private void buildScrollViewGroup() {
        if (this.mContext == null || this.viewMofferLayout == null || this.mMainOfferCampaignEx == null) {
            return;
        }
        this.mLinearLayout = new LinearLayout(this.mContext);
        this.mLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.mLinearLayout.setOrientation(0);
        this.mLinearLayout.setGravity(17);
        for (int i10 = 0; i10 < this.mCampaignUnit.ads.size(); i10++) {
            View viewBuildItemView = buildItemView(i10);
            if (viewBuildItemView != null) {
                this.mLinearLayout.addView(viewBuildItemView);
            }
        }
        this.mObservableScrollView.addView(this.mLinearLayout);
        this.mObservableScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.video.dynview.moffer.MOfferModel.6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                MOfferModel.this.checkViewVisiableState();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackClick(com.mbridge.msdk.video.module.a.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(128, "");
    }

    private void createMoreOfferList() {
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout == null) {
            return;
        }
        this.mObservableScrollView = (ObservableScrollView) mBridgeRelativeLayout.findViewById(findID("mbridge_moreoffer_hls"));
        buildScrollViewGroup();
        addLikeTextView();
        showView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMoreOfferView() {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit == null || this.mContext == null || campaignUnit.getAds() == null || this.mCampaignUnit.getAds().size() == 0) {
            return;
        }
        setMoreOfferLayoutCallBack();
        createMoreOfferList();
    }

    private void doAdmfContorl() {
        try {
            CampaignEx campaignEx = this.mMainOfferCampaignEx;
            if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getMoreOfferJsonData())) {
                JSONObject jSONObject = new JSONObject(this.mMainOfferCampaignEx.getMoreOfferJsonData());
                int i10 = this.mFromType;
                JSONObject jSONObject2 = i10 != 1 ? i10 != 2 ? null : jSONObject.getJSONObject(CampaignEx.ENDCARD_URL) : jSONObject.getJSONObject("template_url");
                if (jSONObject2 == null) {
                    return;
                }
                if (jSONObject2.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM)) {
                    this.admftm = jSONObject2.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                }
                if (jSONObject2.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF)) {
                    this.admf = jSONObject2.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
                }
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doControllableImpOnRequest() {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit == null) {
            return;
        }
        try {
            com.mbridge.msdk.video.dynview.f.a.a(campaignUnit, 0, 1, "117361");
            this.isOnlyImpShow = true;
            if (this.mCampaignUnit.getAds() == null) {
                return;
            }
            int size = this.mCampaignUnit.getAds().size();
            if (this.admf >= size) {
                this.admf = size;
            }
            if (this.mImpressionId == null) {
                this.mImpressionId = new ArrayList();
            }
            for (int i10 = 0; i10 < this.admf; i10++) {
                if (!this.mImpressionId.contains(Integer.valueOf(i10))) {
                    com.mbridge.msdk.video.dynview.f.a.a(this.mCampaignUnit, i10, 0, "117361");
                    this.mImpressionId.add(Integer.valueOf(i10));
                }
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    private void doControllableImpOnShow(int i10) {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            return;
        }
        try {
            int size = this.mCampaignUnit.getAds().size();
            if (this.mControlShowSize == 0) {
                this.mControlShowSize = this.admf + i10;
            }
            if (this.mControlShowSize >= size) {
                this.mControlShowSize = size;
            }
            while (i10 < this.mControlShowSize) {
                if (!this.mImpressionId.contains(Integer.valueOf(i10))) {
                    com.mbridge.msdk.video.dynview.f.a.a(this.mCampaignUnit, i10, 0, "117361");
                    this.mImpressionId.add(Integer.valueOf(i10));
                }
                i10++;
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findID(String str) {
        return x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "id");
    }

    private void initData() throws JSONException {
        CampaignEx campaignEx = this.mMainOfferCampaignEx;
        if (campaignEx == null || this.mContext == null) {
            return;
        }
        buildRequestParams(campaignEx);
        if (this.mParam == null) {
            return;
        }
        com.mbridge.msdk.video.dynview.f.b bVar = new com.mbridge.msdk.video.dynview.f.b(this.mContext);
        com.mbridge.msdk.video.dynview.f.a.a aVar = new com.mbridge.msdk.video.dynview.f.a.a() { // from class: com.mbridge.msdk.video.dynview.moffer.MOfferModel.3
            @Override // com.mbridge.msdk.video.dynview.f.a.a
            public final void a(List<com.mbridge.msdk.tracker.network.h> list, CampaignUnit campaignUnit) {
                if (MOfferModel.this.mParam == null || campaignUnit == null) {
                    a.a().b();
                    return;
                }
                try {
                    MOfferModel mOfferModel = MOfferModel.this;
                    mOfferModel.mUnitId = mOfferModel.mParam.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                    MOfferModel mOfferModel2 = MOfferModel.this;
                    mOfferModel2.mRid = mOfferModel2.mParam.a().get("r_id");
                    if (campaignUnit.getAds() == null || campaignUnit.getAds().size() < 5) {
                        if (!MOfferModel.this.hasReportMoreOfferLoad) {
                            com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().c(), "more offer load failed errorCode: -999 errorMsg: The campaign quantity less than 5.", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                            MOfferModel.this.hasReportMoreOfferLoad = true;
                        }
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a("result", "2");
                        eVar.a("code", MOfferModel.MOF_LOAD_RESULT_CODE_OFFER_LESS_THAN_5);
                        if (MOfferModel.this.mIsRetry) {
                            eVar.a("retry", "1");
                        }
                        com.mbridge.msdk.foundation.same.report.d.d.a().a("m_mof_req_result", MOfferModel.this.mMainOfferCampaignEx, eVar);
                        a.a().b();
                        return;
                    }
                    MOfferModel.this.mCampaignUnit = campaignUnit;
                    if (MOfferModel.this.admf > 0 && MOfferModel.this.admftm == 1) {
                        MOfferModel.this.doControllableImpOnRequest();
                    }
                    if (!MOfferModel.this.hasReportMoreOfferLoad) {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().c(), "more offer load success", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                        MOfferModel.this.hasReportMoreOfferLoad = true;
                    }
                    com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar2.a("result", "1");
                    if (MOfferModel.this.mIsRetry) {
                        eVar2.a("retry", "1");
                    }
                    com.mbridge.msdk.foundation.same.report.d.d.a().a("m_mof_req_result", MOfferModel.this.mMainOfferCampaignEx, eVar2);
                    MOfferModel.this.createMoreOfferView();
                } catch (Exception e) {
                    af.b(MOfferModel.TAG, e.getMessage());
                    a.a().b();
                }
            }

            @Override // com.mbridge.msdk.video.dynview.f.a.a
            public final void a(int i10, String str) {
                if (MOfferModel.this.mParam == null) {
                    a.a().b();
                    return;
                }
                try {
                    MOfferModel mOfferModel = MOfferModel.this;
                    mOfferModel.mUnitId = mOfferModel.mParam.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                    MOfferModel mOfferModel2 = MOfferModel.this;
                    mOfferModel2.mRid = mOfferModel2.mParam.a().get("r_id");
                    if (!MOfferModel.this.hasReportMoreOfferLoad) {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, com.mbridge.msdk.foundation.controller.c.m().c(), "more offer load failed errorCode:" + i10 + "errorMsg:" + str, MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                        MOfferModel.this.hasReportMoreOfferLoad = true;
                    }
                    com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar.a("result", "2");
                    eVar.a("code", i10 + "");
                    if (MOfferModel.this.mIsRetry) {
                        eVar.a("retry", "1");
                    }
                    com.mbridge.msdk.foundation.same.report.d.d.a().a("m_mof_req_result", MOfferModel.this.mMainOfferCampaignEx, eVar);
                    a.a().b();
                } catch (Exception e) {
                    af.b(MOfferModel.TAG, e.getMessage());
                    a.a().b();
                }
            }
        };
        String str = com.mbridge.msdk.foundation.same.net.e.d.f().M;
        if (!TextUtils.isEmpty(this.mMainOfferCampaignEx.getReq_ext_data())) {
            try {
                JSONObject jSONObject = new JSONObject(this.mMainOfferCampaignEx.getReq_ext_data());
                String strOptString = jSONObject.optString("mof_domain");
                if (!TextUtils.isEmpty(strOptString)) {
                    str = strOptString + "/openapi/ad/v3";
                }
                String strOptString2 = jSONObject.optString("parent_id");
                if (!TextUtils.isEmpty(strOptString2)) {
                    com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mof_parent_id", strOptString2);
                }
                String strOptString3 = jSONObject.optString("oneId");
                if (!TextUtils.isEmpty(strOptString3)) {
                    com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "oneId", strOptString3);
                }
                String strOptString4 = jSONObject.optString("mcd");
                if (!TextUtils.isEmpty(strOptString4)) {
                    com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mcd", strOptString4);
                }
                aVar.setUnitId(this.mMainOfferCampaignEx.getCampaignUnitId());
            } catch (Exception e) {
                af.b(TAG, e.getMessage());
                str = com.mbridge.msdk.foundation.same.net.e.d.f().M;
            }
        }
        String str2 = str;
        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
        if (this.mIsRetry) {
            eVar.a("retry", "1");
        }
        com.mbridge.msdk.foundation.same.report.d.d.a().a("m_mof_initiate", this.mMainOfferCampaignEx, eVar);
        bVar.getLoadOrSetting(1, str2, this.mParam, aVar, true, "more_offer", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        doAdmfContorl();
    }

    private void initView() {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        this.viewMofferLayout = (MBridgeRelativeLayout) LayoutInflater.from(this.mContext).inflate(x.a(context, "mbridge_reward_more_offer_view", TtmlNode.TAG_LAYOUT), (ViewGroup) null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        List<Integer> list = this.cacheImpressionReportList;
        if (list != null) {
            list.clear();
            this.cacheImpressionReportList = null;
        }
        List<Integer> list2 = this.cacheOnlyImpressionReportList;
        if (list2 != null) {
            list2.clear();
            this.cacheOnlyImpressionReportList = null;
        }
    }

    private void setCallbackForLogicVisibleView(View view, int i10) {
        if (view == null) {
            return;
        }
        try {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z9 = rect.width() > view.getMeasuredWidth() / 5;
            if (!globalVisibleRect || !z9) {
                if (this.admf != 0) {
                    doControllableImpOnShow(i10);
                    return;
                }
                return;
            }
            List<Integer> list = this.mImpressionId;
            if (list != null && this.onItemExposeListener != null && !list.contains(Integer.valueOf(i10))) {
                this.mImpressionId.add(Integer.valueOf(i10));
                this.onItemExposeListener.onItemViewVisible(true, i10);
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    private void setMoreOfferLayoutCallBack() {
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout == null) {
            return;
        }
        mBridgeRelativeLayout.setMoreOfferCacheReportCallBack(new b() { // from class: com.mbridge.msdk.video.dynview.moffer.MOfferModel.4
            @Override // com.mbridge.msdk.video.dynview.moffer.b
            public final void a() {
                try {
                    if (MOfferModel.this.cacheImpressionReportList != null) {
                        for (int i10 = 0; i10 < MOfferModel.this.cacheImpressionReportList.size(); i10++) {
                            if (!MOfferModel.this.hasReportMoreOfferShow) {
                                com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, MOfferModel.this.mContext, "more offer show", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                                MOfferModel.this.hasReportMoreOfferShow = true;
                            }
                            com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, ((Integer) MOfferModel.this.cacheImpressionReportList.get(i10)).intValue(), 0, "117361");
                        }
                    }
                    if (!MOfferModel.this.isOnlyImpShow && MOfferModel.this.cacheOnlyImpressionReportList != null) {
                        for (int i11 = 0; i11 < MOfferModel.this.cacheOnlyImpressionReportList.size(); i11++) {
                            com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, ((Integer) MOfferModel.this.cacheOnlyImpressionReportList.get(i11)).intValue(), 1, "117361");
                        }
                    }
                    MOfferModel.this.release();
                } catch (Exception e) {
                    af.b(MOfferModel.TAG, e.getMessage());
                }
            }
        });
        this.viewMofferLayout.setMoreOfferShowFailedCallBack(new d() { // from class: com.mbridge.msdk.video.dynview.moffer.MOfferModel.5
            @Override // com.mbridge.msdk.video.dynview.moffer.d
            public final void a() {
                if (MOfferModel.this.viewMofferLayout != null && MOfferModel.this.viewMofferLayout.getVisibility() != 0) {
                    com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, MOfferModel.this.mContext, "more offer show fail", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                }
                MOfferModel.this.release();
            }
        });
    }

    private void setOfferData(List<CampaignEx> list, int i10, final RoundImageView roundImageView, TextView textView) {
        CampaignEx campaignEx;
        if (roundImageView == null || textView == null || list == null || this.mContext == null || this.mMainOfferCampaignEx == null || list.size() <= 0 || (campaignEx = list.get(i10)) == null) {
            return;
        }
        roundImageView.setImageDrawable(null);
        com.mbridge.msdk.foundation.same.c.b.a(this.mContext).a(campaignEx.getIconUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.video.dynview.moffer.MOfferModel.8
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                try {
                    if (roundImageView != null && bitmap != null && !bitmap.isRecycled()) {
                        roundImageView.setBorderRadius(13);
                        roundImageView.setImageBitmap(bitmap);
                    }
                    MOfferModel.access$2208(MOfferModel.this);
                    if (MOfferModel.this.isShowMoreOffer || MOfferModel.this.bitmapSuccessCount < 5 || MOfferModel.this.mMoreOfferShowCallBack == null) {
                        return;
                    }
                    MOfferModel.this.isShowMoreOffer = true;
                    MOfferModel.this.mMoreOfferShowCallBack.a(null);
                } catch (Exception e) {
                    af.b(MOfferModel.TAG, e.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
            }
        });
        if (TextUtils.isEmpty(campaignEx.getAppName())) {
            return;
        }
        String strA = aq.a(this.mMainOfferCampaignEx.getendcard_url(), "mof_textmod");
        if (TextUtils.isEmpty(strA) || !strA.equals("1")) {
            textView.setVisibility(8);
        } else {
            textView.setText(campaignEx.getAppName());
        }
    }

    public void buildMofferAd(CampaignEx campaignEx) throws JSONException {
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        this.mContext = contextC;
        if (contextC == null) {
            return;
        }
        this.mMainOfferCampaignEx = campaignEx;
        initView();
        initData();
    }

    public void checkViewVisiableState() {
        if (this.mLinearLayout == null) {
            return;
        }
        for (int i10 = 0; i10 < this.mLinearLayout.getChildCount(); i10++) {
            try {
                setCallbackForLogicVisibleView(this.mLinearLayout.getChildAt(i10), i10);
            } catch (Exception e) {
                af.b(TAG, e.getMessage());
                return;
            }
        }
    }

    public long getECParentTemplateCode() {
        try {
            e eVar = this.mParam;
            String str = eVar != null ? eVar.a().get("parent_template_id") : "";
            if (TextUtils.isEmpty(str)) {
                return 404L;
            }
            return Long.parseLong(str);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return 404L;
        }
    }

    public CampaignEx getmMainOfferCampaignEx() {
        return this.mMainOfferCampaignEx;
    }

    public void mofDestroy() {
        if (this.mMoreOfferLayoutListener != null) {
            this.mMoreOfferLayoutListener = null;
        }
        if (this.onItemExposeListener != null) {
            this.onItemExposeListener = null;
        }
        if (this.mMoreOfferShowCallBack != null) {
            this.mMoreOfferShowCallBack = null;
        }
        if (this.mNotifyListener != null) {
            this.mNotifyListener = null;
        }
    }

    public void setFromType(int i10) {
        this.mFromType = i10;
    }

    public void setIsRetry(boolean z9) {
        this.mIsRetry = z9;
    }

    public void setMoreOfferListener(g gVar, com.mbridge.msdk.video.module.a.a aVar) {
        this.mMoreOfferLayoutListener = gVar;
        this.mNotifyListener = aVar;
    }

    public void showView() {
        CampaignUnit campaignUnit;
        g gVar = this.mMoreOfferLayoutListener;
        if (gVar == null) {
            return;
        }
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout == null || (campaignUnit = this.mCampaignUnit) == null) {
            gVar.a(-1, "more Offer create fail");
            return;
        }
        gVar.a(mBridgeRelativeLayout, campaignUnit);
        if (!this.isOnlyImpShow) {
            com.mbridge.msdk.video.dynview.f.a.a(this.mCampaignUnit, 0, 1, "117361");
        }
        if (this.mHasReportMofScenes) {
            return;
        }
        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
        eVar.a("scene", this.mFromType + "");
        com.mbridge.msdk.foundation.same.report.d.d.a().a("m_mof_scenes", this.mMainOfferCampaignEx, eVar);
    }
}
