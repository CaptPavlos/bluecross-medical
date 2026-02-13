package com.mbridge.msdk.foundation.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class CampaignEx extends DomainCampaignEx implements NoProGuard, Serializable {
    public static final int CAMPAIN_NV_T2_VALUE_3 = 3;
    public static final int CAMPAIN_NV_T2_VALUE_4 = 4;
    public static final String CLICKMODE_ON = "5";
    public static final int CLICK_TIMEOUT_INTERVAL_DEFAULT_VALUE = 2;
    public static final int C_UA_DEFAULT_VALUE = 1;
    private static final int DEFAULT_READY_RATE = 100;
    public static final String ENDCARD_URL = "endcard_url";
    public static final int FLAG_DEFAULT_SPARE_OFFER = -1;
    public static final int FLAG_IS_SPARE_OFFER = 1;
    public static final int FLAG_NOT_SPARE_OFFER = 0;
    public static final int IMP_UA_DEFAULT_VALUE = 1;
    public static final int IV_RV_DEFAULT_PROGRESS_BAR_SHOW_STATE = 0;
    public static final int IV_RV_DEFAULT_USE_SKIP_TIME = 0;
    public static final String JSON_AD_IMP_KEY = "sec";
    public static final String JSON_AD_IMP_VALUE = "url";
    public static final String JSON_KEY_AAB = "aab";
    public static final String JSON_KEY_ADVIMP = "adv_imp";
    public static final String JSON_KEY_AD_AKS = "aks";
    public static final String JSON_KEY_AD_AL = "al";
    public static final String JSON_KEY_AD_HTML = "ad_html";
    public static final String JSON_KEY_AD_K = "k";
    public static final String JSON_KEY_AD_MP = "mp";
    public static final String JSON_KEY_AD_Q = "q";
    public static final String JSON_KEY_AD_R = "r";
    public static final String JSON_KEY_AD_SOURCE_ID = "ad_source_id";
    public static final String JSON_KEY_AD_TMP_IDS = "tmp_ids";
    public static final String JSON_KEY_AD_TRACKING_DROPOUT_TRACK = "dropout_track";
    public static final String JSON_KEY_AD_TRACKING_IMPRESSION_T2 = "impression_t2";
    public static final String JSON_KEY_AD_TRACKING_PLYCMPT_TRACK = "plycmpt_track";
    public static final String JSON_KEY_AD_URL_LIST = "ad_url_list";
    public static final String JSON_KEY_AD_ZIP = "ad_tpl_url";
    public static final String JSON_KEY_APP_SIZE = "app_size";
    public static final String JSON_KEY_AUTO_SHOW_MINI_CARD = "auto_mc";
    public static final String JSON_KEY_BANNER_HTML = "banner_html";
    public static final String JSON_KEY_BANNER_URL = "banner_url";
    public static final String JSON_KEY_BTY = "ctype";
    public static final String JSON_KEY_CAMPAIGN_UNITID = "unitId";
    public static final String JSON_KEY_CLICK_INTERVAL = "c_ct";
    public static final String JSON_KEY_CLICK_MODE = "click_mode";
    public static final String JSON_KEY_CLICK_TIMEOUT_INTERVAL = "c_toi";
    public static final String JSON_KEY_CLICK_URL = "click_url";
    public static final String JSON_KEY_CREATIVE_ID = "creative_id";
    public static final String JSON_KEY_CTA_TEXT = "ctatext";
    public static final String JSON_KEY_C_C_TIME = "c_c_time";
    public static final String JSON_KEY_C_UA = "c_ua";
    public static final String JSON_KEY_DEEP_LINK_URL = "deep_link";
    public static final String JSON_KEY_DESC = "desc";
    public static final String JSON_KEY_ECPPV = "encrypt_ecppv";
    public static final String JSON_KEY_EC_CREATIVE_ID = "ec_crtv_id";
    public static final String JSON_KEY_EC_TEMP_ID = "ec_temp_id";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_ENDCARD_CLICK = "endcard_click_result";
    public static final String JSON_KEY_EXT_DATA = "ext_data";
    public static final String JSON_KEY_FAC = "fac";
    public static final String JSON_KEY_FCA = "fca";
    public static final String JSON_KEY_FCB = "fcb";
    public static final String JSON_KEY_FLB = "flb";
    public static final String JSON_KEY_FLB_SKIP_TIME = "flb_skiptime";
    public static final String JSON_KEY_GIF_URL = "gif_url";
    public static final String JSON_KEY_GUIDELINES = "guidelines";
    public static final String JSON_KEY_HASMBTPLMARK = "hasMBTplMark";
    public static final String JSON_KEY_HB = "hb";
    public static final String JSON_KEY_ICON_URL = "icon_url";
    public static final String JSON_KEY_ID = "id";
    public static final String JSON_KEY_IMAGE_SIZE = "image_size";
    public static final String JSON_KEY_IMAGE_URL = "image_url";
    public static final String JSON_KEY_IMPRESSION_URL = "impression_url";
    public static final String JSON_KEY_IMP_REPORT_TYPE = "imp_report_type";
    public static final String JSON_KEY_IMP_UA = "imp_ua";
    public static final String JSON_KEY_JM_PD = "jm_pd";
    public static final String JSON_KEY_LANDING_TYPE = "landing_type";
    public static final String JSON_KEY_LINK_TYPE = "link_type";
    public static final String JSON_KEY_LOCAL_REQUEST_ID = "local_rid";
    public static final String JSON_KEY_MAITVE = "maitve";
    public static final String JSON_KEY_MAITVESRC = "maitve_src";
    public static final String JSON_KEY_MRAID = "mraid";
    public static final String JSON_KEY_MRAIDFORH5 = "mraid_src";
    public static final String JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T = "adspace_t";
    public static final String JSON_KEY_NEW_INTERSTITIAL_CBD = "cbd";
    public static final String JSON_KEY_NEW_INTERSTITIAL_VST = "vst";
    public static final String JSON_KEY_NOTICE_URL = "notice_url";
    public static final String JSON_KEY_NUMBER_RATING = "number_rating";
    public static final String JSON_KEY_NV_T2 = "nv_t2";
    public static final String JSON_KEY_OFFER_TYPE = "offer_type";
    public static final String JSON_KEY_PACKAGE_NAME = "package_name";
    public static final String JSON_KEY_PLCT = "plct";
    public static final String JSON_KEY_PLCTB = "plctb";
    public static final String JSON_KEY_PRIVACY_URL = "privacy_url";
    public static final String JSON_KEY_PROG_BAR = "prog_bar";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_READY_RATE = "ready_rate";
    public static final String JSON_KEY_RETARGET_OFFER = "retarget_offer";
    public static final String JSON_KEY_RETARGET_TYPE = "rtins_type";
    public static final String JSON_KEY_REWARD_AMOUNT = "reward_amount";
    public static final String JSON_KEY_REWARD_NAME = "reward_name";
    public static final String JSON_KEY_REWARD_PLUS = "rw_pl";
    public static final String JSON_KEY_REWARD_TEMPLATE = "rv";
    public static final String JSON_KEY_REWARD_VIDEO_MD5 = "md5_file";
    public static final String JSON_KEY_RS_IGNORE_CHECK_RULE = "rs_ignc_r";
    public static final String JSON_KEY_SHOW_MINI_CARD_DELAY_TIME = "mc_trig_t";
    public static final String JSON_KEY_STAR = "rating";
    public static final String JSON_KEY_ST_IEX = "iex";
    public static final String JSON_KEY_ST_TS = "ts";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TIMESTAMP = "timestamp";
    public static final String JSON_KEY_TITLE = "title";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_TP_OFFER = "tp_offer";
    public static final String JSON_KEY_T_IMP = "t_imp";
    public static final String JSON_KEY_USER_ACTIVATION = "user_activation";
    public static final String JSON_KEY_USE_SKIP_TIME = "use_skip_time";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String JSON_KEY_VIDEO_CHECK_TYPE = "vck_t";
    public static final String JSON_KEY_VIDEO_COMPLETE_TIME = "view_com_time";
    public static final String JSON_KEY_VIDEO_CREATIVE_ID = "vid_crtv_id";
    public static final String JSON_KEY_VIDEO_CTN_TYPE = "vctn_t";
    public static final String JSON_KEY_VIDEO_LENGTHL = "video_length";
    public static final String JSON_KEY_VIDEO_RESOLUTION = "video_resolution";
    public static final String JSON_KEY_VIDEO_SIZE = "video_size";
    public static final String JSON_KEY_VIDEO_URL = "video_url";
    public static final String JSON_KEY_WATCH_MILE = "watch_mile";
    public static final String JSON_KEY_WITHOUT_INSTALL_CHECK = "wtick";
    public static final String JSON_NATIVE_VIDEO_AD_TRACKING = "ad_tracking";
    public static final String JSON_NATIVE_VIDEO_CLICK = "click";
    public static final String JSON_NATIVE_VIDEO_CLOSE = "close";
    public static final String JSON_NATIVE_VIDEO_COMPLETE = "complete";
    public static final String JSON_NATIVE_VIDEO_ENDCARD = "endcard";
    public static final String JSON_NATIVE_VIDEO_ENDCARD_SHOW = "endcard_show";
    public static final String JSON_NATIVE_VIDEO_ERROR = "error";
    public static final String JSON_NATIVE_VIDEO_FIRST_QUARTILE = "first_quartile";
    public static final String JSON_NATIVE_VIDEO_MIDPOINT = "midpoint";
    public static final String JSON_NATIVE_VIDEO_MUTE = "mute";
    public static final String JSON_NATIVE_VIDEO_PAUSE = "pause";
    public static final String JSON_NATIVE_VIDEO_PLAY_PERCENTAGE = "play_percentage";
    public static final String JSON_NATIVE_VIDEO_RESUME = "resume";
    public static final String JSON_NATIVE_VIDEO_START = "start";
    public static final String JSON_NATIVE_VIDEO_THIRD_QUARTILE = "third_quartile";
    public static final String JSON_NATIVE_VIDEO_UNMUTE = "unmute";
    public static final String JSON_NATIVE_VIDEO_VIDEO_CLICK = "video_click";
    public static final String JSON_NATIVE_VIDOE_IMPRESSION = "impression";
    public static final String KEY_ACTIVITY_CHECK_SWITCH = "ac_s";
    public static final String KEY_ACTIVITY_PATH_AND_NAME = "ac";
    public static final String KEY_ADCHOICE = "adchoice";
    public static final String KEY_AD_TYPE = "ad_type";
    public static final String KEY_CLICK_TEMP_SOURCE = "click_temp_source";
    public static final String KEY_EC_TEMP_DISPLAY_TYPE = "ec_temp_display_type";
    public static final String KEY_IA_CACHE = "ia_cache";
    public static final String KEY_IA_EXT1 = "ia_ext1";
    public static final String KEY_IA_EXT2 = "ia_ext2";
    public static final String KEY_IA_ICON = "ia_icon";
    public static final String KEY_IA_ORI = "ia_ori";
    public static final String KEY_IA_RST = "ia_rst";
    public static final String KEY_IA_URL = "ia_url";
    public static final String KEY_IS_CMPT_ENTRY = "cmpt=1";
    public static final String KEY_IS_DOWNLOAD = "is_download_zip";
    public static final String KEY_OC_TIME = "oc_time";
    public static final String KEY_OC_TYPE = "oc_type";
    public static final String KEY_OMID = "omid";
    public static final String KEY_PLAY_TEMP_DISPLAY_TYPE = "play_temp_display_type";
    public static final String KEY_SECOND_REQUEST_CALLBACK_STATE = "i_s_c_t";
    public static final String KEY_SHOW_INDEX = "show_index";
    public static final String KEY_SHOW_TYPE = "show_type";
    public static final String KEY_TRIGGER_CLICK_SOURCE = "trigger_click_source";
    public static final String KEY_T_LIST = "t_list";
    public static final int LANDING_TYPE_VALUE_OPEN_BROWSER = 1;
    public static final int LANDING_TYPE_VALUE_OPEN_GP_BY_PACKAGE = 3;
    public static final int LANDING_TYPE_VALUE_OPEN_WEBVIEW = 2;
    public static final int LINK_TYPE_1 = 1;
    public static final int LINK_TYPE_2 = 2;
    public static final int LINK_TYPE_3 = 3;
    public static final int LINK_TYPE_4 = 4;
    public static final int LINK_TYPE_8 = 8;
    public static final int LINK_TYPE_9 = 9;
    public static final int LINK_TYPE_MINI_PROGRAM = 12;
    public static final int NEW_INTERSTITIAL_DEFAULT_AD_SPACE_T = 1;
    public static final int NEW_INTERSTITIAL_DEFAULT_CBD = -2;
    public static final int NEW_INTERSTITIAL_DEFAULT_VST = -2;
    public static final String PLAYABLE_ADS_WITHOUT_VIDEO = "playable_ads_without_video";
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_DEFAULT = 1;
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_ENDCARD = 2;
    public static final String PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH = "show_privacy_btn";
    public static final int RETAR_GETING_IS = 1;
    public static final int RETAR_GETING_NOT = 2;
    public static final int RTINS_TYPE_DONE = 1;
    public static final int RTINS_TYPE_NOT_DONE = 2;
    public static final String TAG = "CampaignEx";
    public static final String URL_KEY_EXP_IDS = "exp_ids";
    public static final String VIDEO_END_TYPE = "video_end_type";
    public static final int VIDEO_END_TYPE_BROWSER = 5;
    public static final int VIDEO_END_TYPE_DEFAULT = 2;
    public static final int VIDEO_END_TYPE_FINISH = 1;
    public static final int VIDEO_END_TYPE_NATIVE = 100;
    public static final int VIDEO_END_TYPE_REULSE = 2;
    public static final int VIDEO_END_TYPE_VAST = 3;
    public static final int VIDEO_END_TYPE_WEBVIEW = 4;
    private static final long serialVersionUID = 1;
    private String CMPTEntryUrl;
    private AabEntity aabEntity;
    private int adSpaceT;
    private int adType;
    private String ad_url_list;
    private a adchoice;
    private String advImp;
    private HashMap<String, String> aks;
    private String al;
    private int autoShowStoreMiniCard;
    private int bty;
    private long cVersionCode;
    private int cacheLevel;
    private String campaignUnitId;
    private int cbt;
    private int clickInterval;
    private String click_mode;
    private String ecppv;
    private String endScreenUrl;
    private int endcard_click_result;
    private String endcard_url;
    private String expIds;
    private String ext_data;
    private int fca;
    private int fcb;
    private int flb;
    private int flbSkipTime;
    private String gifUrl;
    private String guidelines;
    private boolean hasMBTplMark;
    private String htmlUrl;
    private String ia_ext1;
    private String ia_ext2;
    private int iex;
    private String interactiveCache;
    private int isAddSuccesful;
    private boolean isBidCampaign;
    private boolean isCallbacked;
    private int isClick;
    private int isDeleted;
    private int isDownLoadZip;
    private boolean isMraid;
    private boolean isReport;
    private boolean isReportClick;
    private int jmPd;
    private JumpLoaderResult jumpResult;

    /* renamed from: k, reason: collision with root package name */
    private String f3487k;
    private String keyIaIcon;
    private int keyIaOri;
    private int keyIaRst;
    private String keyIaUrl;
    private String label;
    private String landingType;
    private int linkType;
    private String localRequestId;
    private int maitve;
    private String maitve_src;
    private b mediaViewHolder;
    private String mof_template_url;
    private int mof_tplid;
    private String mp;
    private String mraid;
    private String n_lrid;
    private String n_rid;
    private j nativeVideoTracking;
    private String nativeVideoTrackingString;
    private int oc_time;
    private int offerType;
    private String pkgSource;
    private String placementId;
    private int progressBarShow;
    private List<String> pv_urls;

    /* renamed from: q, reason: collision with root package name */
    private String f3488q;

    /* renamed from: r, reason: collision with root package name */
    private String f3489r;
    private String reasond;
    private String req_ext_data;
    private String requestId;
    private String requestIdNotice;
    private int retarget_offer;
    private int rewardAmount;
    private int rewardPlayStatus;
    public RewardPlus rewardPlus;
    private c rewardTemplateMode;
    private String reward_name;
    private ArrayList<Integer> rsIgnoreCheckRule;
    private int rtinsType;
    private int showCount;
    private int showStoreMiniCardDelayTime;
    private int t_imp;
    private String t_list;
    private int template;
    private long ts;
    private int useSkipTime;
    private String videoResolution;
    private int videoSize;
    private int watchMile;
    public boolean isRewardPopViewShowed = false;
    public boolean mMoreOfferImpShow = false;
    public String videoMD5Value = "";
    private String adHtml = "";
    private String adZip = "";
    private String bannerHtml = "";
    private String bannerUrl = "";
    private String bidToken = "";
    private int cUA = 1;
    private boolean campaignIsFiltered = false;
    private boolean canStart2C1Anim = false;
    private boolean canStartMoreOfferAnim = false;
    private int cbd = -2;
    private int clickTimeOutInterval = 2;
    private String clickURL = "";
    private long creativeId = 0;
    private String deepLinkUrl = "";
    private int dynamicTempCode = 0;
    private long ecCrtvId = 0;
    private long ecTemplateId = 0;
    private String encryptPrice = "";
    private int typed = -1;
    private int fac = 0;
    private boolean hasReportAdTrackPause = false;
    private String imageSize = "";
    private int impReportType = 0;
    private int impUA = 1;
    private String impressionURL = "";
    private boolean isCallBackImpression = false;
    private boolean isDynamicView = false;
    private boolean isReady = false;
    private int isTimeoutCheckVideoStatus = -1;
    private int loadTimeoutState = 0;
    private String moreOfferJsonData = "";
    private String noticeUrl = "";
    private int nscpt = 1;
    private int nvT2 = 6;
    private int oc_type = 0;
    private String omid = null;
    private String onlyImpressionURL = "";
    private int playable_ads_without_video = 1;
    private long plct = 0;
    private long plctb = 0;
    private long candidateCacheTime = 0;
    private int privacyButtonTemplateVisibility = 0;
    private String privacyUrl = "";
    private int readyState = 1;
    private int ready_rate = -1;
    private int spareOfferFlag = -1;
    private int tab = -1;
    private int tokenRule = 0;
    private int tpOffer = 0;
    private int trackingTcpPort = 9377;
    private boolean userActivation = false;
    private int vcn = 0;
    private long vidCrtvId = 0;
    private int videoCheckType = 2;
    private int videoCompleteTime = 0;
    private int videoCtnType = 1;
    private int videoPlayProgress = 0;
    private String videoUrlEncode = "";
    private int video_end_type = 2;
    private int vst = -2;
    private int wtick = 0;
    private int showIndex = com.mbridge.msdk.foundation.same.report.d.a.f3800a;
    private int showType = com.mbridge.msdk.foundation.same.report.d.a.f3802c;
    private int clickTempSource = 0;
    private int clickType = 2;
    private int triggerClickSource = 0;
    private boolean isTemplateRenderSucc = true;
    private boolean isECTemplateRenderSucc = true;
    private int ac_s = 1;
    private String ac = "";
    private int filterCallBackState = 0;
    private String netAddress = "";

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class b implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public Map<Integer, String> f3497a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3498b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3499c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f3500d = false;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3501i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f3502j = false;

        /* renamed from: k, reason: collision with root package name */
        public boolean f3503k = false;

        /* renamed from: l, reason: collision with root package name */
        public boolean f3504l = false;
    }

    public static j TrackingStr2Object(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                j jVar = new j();
                jVar.o(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDOE_IMPRESSION)));
                jVar.d(processNativeVideoTrackingArray(jSONObject.optJSONArray("start")));
                jVar.e(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_FIRST_QUARTILE)));
                jVar.f(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_MIDPOINT)));
                jVar.g(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_THIRD_QUARTILE)));
                jVar.h(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_COMPLETE)));
                jVar.a(parsePlayCentage(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PLAY_PERCENTAGE)));
                jVar.i(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_MUTE)));
                jVar.j(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_UNMUTE)));
                jVar.k(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_CLICK)));
                jVar.l(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PAUSE)));
                jVar.m(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_RESUME)));
                jVar.n(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ERROR)));
                jVar.p(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD)));
                jVar.r(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_CLOSE)));
                jVar.q(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD_SHOW)));
                jVar.s(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_VIDEO_CLICK)));
                jVar.c(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_IMPRESSION_T2)));
                jVar.a(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_DROPOUT_TRACK)));
                jVar.b(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_PLYCMPT_TRACK)));
                return DomainCampaignEx.trackingStr2Object(jSONObject, jVar);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", campaignEx.getId());
        jSONObject.put(JSON_KEY_FLB, campaignEx.getFlb());
        jSONObject.put(JSON_KEY_FLB_SKIP_TIME, campaignEx.getFlbSkipTime());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_VST, campaignEx.getVst());
        jSONObject.put(JSON_KEY_USE_SKIP_TIME, campaignEx.getUseSkipTime());
        jSONObject.put(JSON_KEY_PROG_BAR, campaignEx.getProgressBarShow());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_CBD, campaignEx.getCbd());
        if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
            jSONObject.put(JSON_KEY_CAMPAIGN_UNITID, campaignEx.getCampaignUnitId());
        }
        if (!TextUtils.isEmpty(campaignEx.getExt_data())) {
            try {
                jSONObject.put(JSON_KEY_EXT_DATA, new JSONObject(campaignEx.getExt_data()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getReq_ext_data())) {
            try {
                jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA, new JSONObject(campaignEx.getReq_ext_data()));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = campaignEx.getPv_urls().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("pv_urls", jSONArray);
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
            jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID, campaignEx.getMof_tplid());
            jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT, campaignEx.getNscpt());
        }
        jSONObject.put(JSON_KEY_READY_RATE, campaignEx.getReady_rate());
        jSONObject.put(JSON_KEY_TITLE, campaignEx.getAppName());
        jSONObject.put(JSON_KEY_DESC, campaignEx.getAppDesc());
        jSONObject.put(JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
        jSONObject.put(JSON_KEY_RETARGET_TYPE, campaignEx.getRtinsType());
        jSONObject.put(JSON_KEY_ICON_URL, campaignEx.getIconUrl());
        jSONObject.put(JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
        jSONObject.put(JSON_KEY_APP_SIZE, campaignEx.getSize());
        jSONObject.put(JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
        jSONObject.put(JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
        jSONObject.put(JSON_KEY_CLICK_URL, campaignEx.getClickURL());
        if (campaignEx.getRewardPlus() != null) {
            jSONObject.put(JSON_KEY_REWARD_PLUS, campaignEx.getRewardPlus().toJsonObject());
        }
        jSONObject.put(JSON_KEY_WITHOUT_INSTALL_CHECK, campaignEx.getWtick());
        jSONObject.put(JSON_KEY_DEEP_LINK_URL, campaignEx.getDeepLinkURL());
        jSONObject.put(JSON_KEY_USER_ACTIVATION, campaignEx.getUserActivation());
        jSONObject.put(JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
        jSONObject.put("template", campaignEx.getTemplate());
        jSONObject.put(JSON_KEY_AD_SOURCE_ID, campaignEx.getType());
        jSONObject.put(JSON_KEY_FCA, campaignEx.getFca());
        jSONObject.put(JSON_KEY_FCB, campaignEx.getFcb());
        jSONObject.put(JSON_KEY_STAR, campaignEx.getRating() + "");
        jSONObject.put(JSON_KEY_NUMBER_RATING, campaignEx.getNumberRating());
        jSONObject.put(JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
        jSONObject.put(JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
        jSONObject.put(JSON_KEY_LINK_TYPE, campaignEx.getLinkType());
        jSONObject.put(JSON_KEY_CLICK_INTERVAL, campaignEx.getClickInterval());
        jSONObject.put(JSON_KEY_CTA_TEXT, campaignEx.getAdCall());
        jSONObject.put(JSON_KEY_ENDCARD_CLICK, campaignEx.getEndcard_click_result());
        jSONObject.put(JSON_KEY_RETARGET_OFFER, campaignEx.getRetarget_offer());
        jSONObject.put(JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
        jSONObject.put(JSON_KEY_VIDEO_LENGTHL, campaignEx.getVideoLength());
        jSONObject.put(JSON_KEY_VIDEO_SIZE, campaignEx.getVideoSize());
        jSONObject.put(JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
        jSONObject.put(JSON_KEY_WATCH_MILE, campaignEx.getWatchMile());
        jSONObject.put(JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
        jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ONLY_IMPRESSION_URL, campaignEx.getOnlyImpressionURL());
        jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I, campaignEx.getNetAddress());
        jSONObject.put(KEY_ACTIVITY_CHECK_SWITCH, campaignEx.getAc_s());
        jSONObject.put(JSON_KEY_ECPPV, campaignEx.getEcppv());
        jSONObject.put(JSON_KEY_BTY, campaignEx.getBty());
        jSONObject.put(JSON_KEY_T_IMP, campaignEx.getTImp());
        jSONObject.put(JSON_KEY_ADVIMP, campaignEx.getAdvImp());
        jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
        jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
        jSONObject.put(JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
        jSONObject.put(JSON_KEY_OFFER_TYPE, campaignEx.getOfferType());
        jSONObject.put(JSON_KEY_REWARD_AMOUNT, campaignEx.getRewardAmount());
        jSONObject.put(JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
        jSONObject.put(JSON_KEY_GIF_URL, campaignEx.getGifUrl());
        if (ap.b(campaignEx.getNativeVideoTrackingString())) {
            jSONObject.put(JSON_NATIVE_VIDEO_AD_TRACKING, new JSONObject(campaignEx.getNativeVideoTrackingString()));
        }
        jSONObject.put(VIDEO_END_TYPE, campaignEx.getVideo_end_type());
        jSONObject.put(ENDCARD_URL, campaignEx.getendcard_url());
        jSONObject.put(PLAYABLE_ADS_WITHOUT_VIDEO, campaignEx.getPlayable_ads_without_video());
        if (campaignEx.getRewardTemplateMode() != null && ap.b(campaignEx.getRewardTemplateMode().d())) {
            jSONObject.put(JSON_KEY_REWARD_TEMPLATE, new JSONObject(campaignEx.getRewardTemplateMode().d()));
        }
        jSONObject.put(JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
        jSONObject.put(JSON_KEY_CLICK_TIMEOUT_INTERVAL, campaignEx.getClickTimeOutInterval());
        jSONObject.put(JSON_KEY_C_UA, campaignEx.getcUA());
        jSONObject.put(JSON_KEY_IMP_UA, campaignEx.getImpUA());
        jSONObject.put(JSON_KEY_JM_PD, campaignEx.getJmPd());
        jSONObject.put("ia_icon", campaignEx.getKeyIaIcon());
        jSONObject.put("ia_rst", campaignEx.getKeyIaRst());
        jSONObject.put("ia_url", campaignEx.getKeyIaUrl());
        jSONObject.put("ia_ori", campaignEx.getKeyIaOri());
        jSONObject.put("ad_type", campaignEx.getAdType());
        jSONObject.put(KEY_IA_EXT1, campaignEx.getIa_ext1());
        jSONObject.put(KEY_IA_EXT2, campaignEx.getIa_ext2());
        jSONObject.put(KEY_IS_DOWNLOAD, campaignEx.getIsDownLoadZip());
        jSONObject.put(KEY_IA_CACHE, campaignEx.getInteractiveCache());
        jSONObject.put(KEY_OC_TYPE, campaignEx.getOc_type());
        jSONObject.put(KEY_OC_TIME, campaignEx.getOc_time());
        jSONObject.put(KEY_T_LIST, campaignEx.getT_list());
        a adchoice = campaignEx.getAdchoice();
        if (adchoice != null) {
            jSONObject.put(KEY_ADCHOICE, new JSONObject(adchoice.a()));
        }
        jSONObject.put(JSON_KEY_PLCT, campaignEx.getPlct());
        jSONObject.put(JSON_KEY_PLCTB, campaignEx.getPlctb());
        jSONObject.put(JSON_KEY_C_C_TIME, campaignEx.getCandidateCacheTime());
        jSONObject.put(KEY_OMID, campaignEx.getOmid());
        jSONObject.put(JSON_KEY_CREATIVE_ID, campaignEx.getCreativeId());
        jSONObject.put("cam_html", campaignEx.getBannerHtml());
        jSONObject.put("cam_tpl_url", campaignEx.getBannerUrl() != null ? campaignEx.getBannerUrl() : campaignEx.getAdZip());
        jSONObject.put(JSON_KEY_MRAID, campaignEx.getMraid());
        jSONObject.put(JSON_KEY_MRAIDFORH5, campaignEx.getMraid());
        jSONObject.put(JSON_KEY_TIMESTAMP, campaignEx.getTimestamp());
        jSONObject.put(JSON_KEY_HB, campaignEx.isBidCampaign);
        jSONObject.put(MBridgeConstans.PLACEMENT_ID, campaignEx.getPlacementId());
        jSONObject.put(JSON_KEY_MAITVE, campaignEx.getMaitve());
        jSONObject.put(JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
        jSONObject.put("vcn", campaignEx.getVcn());
        jSONObject.put("token_r", campaignEx.getTokenRule());
        jSONObject.put("encrypt_p", campaignEx.getEncryptPrice());
        jSONObject.put(JSON_KEY_VIDEO_COMPLETE_TIME, campaignEx.getVideoCompleteTime());
        jSONObject.put(JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRule());
        jSONObject.put(JSON_KEY_VIDEO_CHECK_TYPE, campaignEx.getVideoCheckType());
        jSONObject.put(JSON_KEY_VIDEO_CTN_TYPE, campaignEx.getVideoCtnType());
        jSONObject.put(JSON_KEY_TP_OFFER, campaignEx.getTpOffer());
        jSONObject.put(JSON_KEY_FAC, campaignEx.getFac());
        jSONObject.put(JSON_KEY_LOCAL_REQUEST_ID, campaignEx.getLocalRequestId());
        jSONObject.put(JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
        jSONObject.put(PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH, campaignEx.getPrivacyButtonTemplateVisibility());
        try {
            jSONObject.put("misk_spt", ak.a());
            jSONObject.put("misk_spt_det", ak.c());
        } catch (JSONException unused) {
        }
        if (campaignEx.getAabEntity() != null) {
            jSONObject.put(JSON_KEY_AAB, campaignEx.getAabEntity().toJson());
        }
        jSONObject.put(JSON_KEY_VIDEO_CREATIVE_ID, campaignEx.getVidCrtvId());
        jSONObject.put(JSON_KEY_EC_CREATIVE_ID, campaignEx.getEcCrtvId());
        jSONObject.put(JSON_KEY_EC_TEMP_ID, campaignEx.getEcTemplateId());
        jSONObject.put(JSON_KEY_IMP_REPORT_TYPE, campaignEx.getImpReportType());
        jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_TK_TCP_PORT, campaignEx.getTrackingTcpPort());
        jSONObject.put(JSON_KEY_AUTO_SHOW_MINI_CARD, campaignEx.getAutoShowStoreMiniCard());
        jSONObject.put(JSON_KEY_SHOW_MINI_CARD_DELAY_TIME, campaignEx.getShowStoreMiniCardDelayTime());
        jSONObject.put(KEY_SHOW_INDEX, campaignEx.getShowIndex());
        jSONObject.put(KEY_SHOW_TYPE, campaignEx.getShowType());
        jSONObject.put(KEY_CLICK_TEMP_SOURCE, campaignEx.getClickTempSource());
        jSONObject.put(KEY_PLAY_TEMP_DISPLAY_TYPE, campaignEx.isTemplateRenderSucc());
        jSONObject.put(KEY_EC_TEMP_DISPLAY_TYPE, campaignEx.isECTemplateRenderSucc());
        jSONObject.put(KEY_TRIGGER_CLICK_SOURCE, campaignEx.getTriggerClickSource());
        jSONObject.put(KEY_ACTIVITY_PATH_AND_NAME, campaignEx.getAc());
        jSONObject.put(KEY_SECOND_REQUEST_CALLBACK_STATE, campaignEx.getFilterCallBackState());
        return DomainCampaignEx.campaignToJsonObject(jSONObject, campaignEx);
    }

    private void checkAndReSetDynamicViewState(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(this.mof_template_url) || !this.isDynamicView) {
            boolean zI = ak.i(str);
            int iB = ak.b(str);
            if (zI) {
                setDynamicView(true);
                setDynamicTempCode(iB);
            }
        }
    }

    private static JSONObject dealV5Temp(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        try {
            if (jSONObject.has(JSON_KEY_AD_TMP_IDS) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(JSON_KEY_AD_TMP_IDS)) != null && jSONArrayOptJSONArray.length() > 0) {
                jSONObject.remove(JSON_KEY_AD_TMP_IDS);
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    JSONObject jSONObjectA = com.mbridge.msdk.foundation.db.a.b.a().a(jSONArrayOptJSONArray.getString(i10));
                    if (jSONObjectA != null) {
                        Iterator<String> itKeys = jSONObjectA.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject.put(next, jSONObjectA.opt(next));
                        }
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private Map<Integer, String> generateAdImpression(String str) {
        HashMap map = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    HashMap map2 = new HashMap();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        try {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                            int iOptInt = jSONObjectOptJSONObject.optInt(JSON_AD_IMP_KEY);
                            map2.put(Integer.valueOf(iOptInt), jSONObjectOptJSONObject.optString("url"));
                        } catch (Exception e) {
                            e = e;
                            map = map2;
                            e.printStackTrace();
                            return map;
                        }
                    }
                    return map2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return map;
    }

    private static boolean isBreakCampainOrSetItByEndCard(CampaignEx campaignEx, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.mbridge.msdk.foundation.controller.c.m().j() == 2 && "1".equals(Uri.parse(str).getQueryParameter("dpwgl"))) {
            return true;
        }
        campaignEx.setendcard_url(str);
        return false;
    }

    public static String object2TrackingStr(j jVar) throws JSONException {
        if (jVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (jVar.p() != null) {
                    jSONObject.put(JSON_NATIVE_VIDOE_IMPRESSION, processNativeVideoTrackingArray2Json(jVar.p()));
                }
                if (jVar.d() != null) {
                    jSONObject.put("start", processNativeVideoTrackingArray2Json(jVar.d()));
                }
                if (jVar.e() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_FIRST_QUARTILE, processNativeVideoTrackingArray2Json(jVar.e()));
                }
                if (jVar.f() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_MIDPOINT, processNativeVideoTrackingArray2Json(jVar.f()));
                }
                if (jVar.g() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_THIRD_QUARTILE, processNativeVideoTrackingArray2Json(jVar.g()));
                }
                if (jVar.h() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_COMPLETE, processNativeVideoTrackingArray2Json(jVar.h()));
                }
                if (jVar.i() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_PLAY_PERCENTAGE, reparsePlayCentage(jVar.i()));
                }
                if (jVar.j() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_MUTE, processNativeVideoTrackingArray2Json(jVar.j()));
                }
                if (jVar.k() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_UNMUTE, processNativeVideoTrackingArray2Json(jVar.k()));
                }
                if (jVar.l() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_CLICK, processNativeVideoTrackingArray2Json(jVar.l()));
                }
                if (jVar.m() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_PAUSE, processNativeVideoTrackingArray2Json(jVar.m()));
                }
                if (jVar.n() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_RESUME, processNativeVideoTrackingArray2Json(jVar.n()));
                }
                if (jVar.o() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_ERROR, processNativeVideoTrackingArray2Json(jVar.o()));
                }
                if (jVar.q() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_ENDCARD, processNativeVideoTrackingArray2Json(jVar.q()));
                }
                if (jVar.s() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_CLOSE, processNativeVideoTrackingArray2Json(jVar.s()));
                }
                if (jVar.r() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_ENDCARD_SHOW, processNativeVideoTrackingArray2Json(jVar.r()));
                }
                if (jVar.t() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_VIDEO_CLICK, processNativeVideoTrackingArray2Json(jVar.q()));
                }
                if (jVar.c() != null) {
                    jSONObject.put(JSON_KEY_AD_TRACKING_IMPRESSION_T2, processNativeVideoTrackingArray2Json(jVar.c()));
                }
                if (jVar.a() != null) {
                    jSONObject.put(JSON_KEY_AD_TRACKING_DROPOUT_TRACK, processNativeVideoTrackingArray2Json(jVar.a()));
                }
                if (jVar.b() != null) {
                    jSONObject.put(JSON_KEY_AD_TRACKING_PLYCMPT_TRACK, processNativeVideoTrackingArray2Json(jVar.b()));
                }
                JSONObject jSONObjectObject2TrackingStr = DomainCampaignEx.object2TrackingStr(jSONObject, jVar);
                return jSONObjectObject2TrackingStr == null ? "" : jSONObjectObject2TrackingStr.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.out.Campaign] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    public static CampaignEx parseCampaign(JSONObject jSONObject, String str, String str2, String str3, boolean z9, CampaignUnit campaignUnit, String str4, String str5) throws JSONException {
        CampaignEx campaign;
        CampaignEx campaignEx;
        ?? arrayList;
        JSONObject jSONObjectDealV5Temp = dealV5Temp(jSONObject);
        if (jSONObjectDealV5Temp == null) {
            return null;
        }
        try {
            ?? campaignEx2 = new CampaignEx();
            try {
                String strOptString = jSONObjectDealV5Temp.optString(JSON_KEY_AD_AKS);
                if (TextUtils.isEmpty(strOptString)) {
                    campaignEx = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    HashMap map = new HashMap();
                    for (Iterator<String> itKeys = jSONObject2.keys(); itKeys != null && itKeys.hasNext(); itKeys = itKeys) {
                        String next = itKeys.next();
                        map.put(next, jSONObject2.optString(next));
                    }
                    campaignEx = null;
                    campaignEx2.setAks(map);
                }
                if (!TextUtils.isEmpty(str4)) {
                    campaignEx2.setBidToken(str4);
                    campaignEx2.setIsBidCampaign(true);
                }
                try {
                    campaignEx2.setReady_rate(jSONObjectDealV5Temp.optInt(JSON_KEY_READY_RATE, -1));
                    JSONObject jSONObjectOptJSONObject = jSONObjectDealV5Temp.optJSONObject(JSON_KEY_EXT_DATA);
                    if (jSONObjectOptJSONObject != null) {
                        campaignEx2.setExt_data(jSONObjectOptJSONObject.toString());
                    }
                    campaignEx2.setMof_tplid(jSONObjectDealV5Temp.optInt(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID));
                    campaignEx2.setMof_template_url(jSONObjectDealV5Temp.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL));
                    campaignEx2.setNscpt(jSONObjectDealV5Temp.optInt(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT));
                    new JSONArray();
                    JSONArray jSONArrayOptJSONArray = jSONObjectDealV5Temp.optJSONArray("pv_urls");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        arrayList = campaignEx;
                    } else {
                        arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i10));
                        }
                    }
                    campaignEx2.setPv_urls(arrayList);
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectDealV5Temp.optJSONObject(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA);
                    if (jSONObjectOptJSONObject2 != null) {
                        campaignEx2.setReq_ext_data(jSONObjectOptJSONObject2.toString());
                    }
                } catch (Exception unused) {
                }
                campaignEx2.setId(jSONObjectDealV5Temp.optString("id"));
                campaignEx2.setAppName(jSONObjectDealV5Temp.optString(JSON_KEY_TITLE));
                campaignEx2.setCampaignUnitId(jSONObjectDealV5Temp.optString(JSON_KEY_CAMPAIGN_UNITID, ""));
                campaignEx2.setAppDesc(jSONObjectDealV5Temp.optString(JSON_KEY_DESC));
                campaignEx2.setPackageName(jSONObjectDealV5Temp.optString(JSON_KEY_PACKAGE_NAME));
                campaignEx2.setRtinsType(jSONObjectDealV5Temp.optInt(JSON_KEY_RETARGET_TYPE));
                campaignEx2.setIconUrl(jSONObjectDealV5Temp.optString(JSON_KEY_ICON_URL));
                campaignEx2.setImageUrl(jSONObjectDealV5Temp.optString(JSON_KEY_IMAGE_URL));
                campaignEx2.setSize(jSONObjectDealV5Temp.optString(JSON_KEY_APP_SIZE));
                campaignEx2.setImageSize(jSONObjectDealV5Temp.optString(JSON_KEY_IMAGE_SIZE));
                campaignEx2.setImpressionURL(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, jSONObjectDealV5Temp.optString(JSON_KEY_IMPRESSION_URL)));
                campaignEx2.setClickURL(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, jSONObjectDealV5Temp.optString(JSON_KEY_CLICK_URL)));
                campaignEx2.setRewardPlus(RewardPlus.parseByString(jSONObjectDealV5Temp.optString(JSON_KEY_REWARD_PLUS)));
                campaignEx2.setWtick(jSONObjectDealV5Temp.optInt(JSON_KEY_WITHOUT_INSTALL_CHECK));
                campaignEx2.setDeepLinkUrl(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, jSONObjectDealV5Temp.optString(JSON_KEY_DEEP_LINK_URL)));
                campaignEx2.setUserActivation(jSONObjectDealV5Temp.optBoolean(JSON_KEY_USER_ACTIVATION, false));
                campaignEx2.setNoticeUrl(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, jSONObjectDealV5Temp.optString(JSON_KEY_NOTICE_URL)));
                campaignEx2.setTemplate(jSONObjectDealV5Temp.optInt("template"));
                campaignEx2.setType(jSONObjectDealV5Temp.optInt(JSON_KEY_AD_SOURCE_ID, 1));
                campaignEx2.setFca(jSONObjectDealV5Temp.optInt(JSON_KEY_FCA));
                campaignEx2.setFcb(jSONObjectDealV5Temp.optInt(JSON_KEY_FCB));
                campaignEx2.setEndcard_click_result(jSONObjectDealV5Temp.optInt(JSON_KEY_ENDCARD_CLICK));
                if (!TextUtils.isEmpty(jSONObjectDealV5Temp.optString(JSON_KEY_STAR))) {
                    campaignEx2.setRating(Double.parseDouble(jSONObjectDealV5Temp.optString(JSON_KEY_STAR, "0")));
                }
                if (!TextUtils.isEmpty(jSONObjectDealV5Temp.optString(JSON_KEY_NUMBER_RATING))) {
                    campaignEx2.setNumberRating(jSONObjectDealV5Temp.optInt(JSON_KEY_NUMBER_RATING, 333333));
                }
                campaignEx2.setClick_mode(jSONObjectDealV5Temp.optString(JSON_KEY_CLICK_MODE));
                campaignEx2.setLandingType(jSONObjectDealV5Temp.optString(JSON_KEY_LANDING_TYPE));
                campaignEx2.setLinkType(jSONObjectDealV5Temp.optInt(JSON_KEY_LINK_TYPE, 4));
                campaignEx2.setClickInterval(jSONObjectDealV5Temp.optInt(JSON_KEY_CLICK_INTERVAL));
                campaignEx2.setAdCall(jSONObjectDealV5Temp.optString(JSON_KEY_CTA_TEXT));
                campaignEx2.setAd_url_list(jSONObjectDealV5Temp.optString(JSON_KEY_AD_URL_LIST));
                campaignEx2.setRetarget_offer(jSONObjectDealV5Temp.optInt(JSON_KEY_RETARGET_OFFER, 2));
                String strOptString2 = jSONObjectDealV5Temp.optString(JSON_KEY_VIDEO_URL);
                if (!TextUtils.isEmpty(strOptString2)) {
                    if (z9) {
                        campaignEx2.setVideoUrlEncode(strOptString2);
                    } else {
                        campaignEx2.setVideoUrlEncode(z.a(strOptString2));
                    }
                }
                campaignEx2.setVideoCompleteTime(jSONObjectDealV5Temp.optInt(JSON_KEY_VIDEO_COMPLETE_TIME));
                campaignEx2.setVideoLength(jSONObjectDealV5Temp.optInt(JSON_KEY_VIDEO_LENGTHL));
                campaignEx2.setVideoSize(jSONObjectDealV5Temp.optInt(JSON_KEY_VIDEO_SIZE));
                campaignEx2.setVideoResolution(jSONObjectDealV5Temp.optString(JSON_KEY_VIDEO_RESOLUTION));
                campaignEx2.setWatchMile(jSONObjectDealV5Temp.optInt(JSON_KEY_WATCH_MILE));
                campaignEx2.setTimestamp(System.currentTimeMillis());
                campaignEx2.setOnlyImpressionURL(DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, str));
                try {
                    if (!TextUtils.isEmpty(str5)) {
                        campaignEx2.setEcppv(str5);
                    }
                    campaignEx2.setAc_s(jSONObjectDealV5Temp.optInt(KEY_ACTIVITY_CHECK_SWITCH, 1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                campaignEx2.setBty(jSONObjectDealV5Temp.optInt(JSON_KEY_BTY));
                campaignEx2.setAdvImp(jSONObjectDealV5Temp.optString(JSON_KEY_ADVIMP));
                campaignEx2.setTImp(jSONObjectDealV5Temp.optInt(JSON_KEY_T_IMP));
                campaignEx2.setHtmlUrl(str2);
                campaignEx2.setEndScreenUrl(str3);
                campaignEx2.setGuidelines(jSONObjectDealV5Temp.optString(JSON_KEY_GUIDELINES));
                campaignEx2.setOfferType(jSONObjectDealV5Temp.optInt(JSON_KEY_OFFER_TYPE));
                campaignEx2.setRewardName(jSONObjectDealV5Temp.optString(JSON_KEY_REWARD_NAME));
                campaignEx2.setRewardAmount(jSONObjectDealV5Temp.optInt(JSON_KEY_REWARD_AMOUNT));
                try {
                    String strReplaceValueByKey = DomainCampaignEx.replaceValueByKey(campaignUnit, campaignEx2, jSONObjectDealV5Temp.optString(JSON_NATIVE_VIDEO_AD_TRACKING));
                    if (!TextUtils.isEmpty(strReplaceValueByKey)) {
                        campaignEx2.setNativeVideoTrackingString(strReplaceValueByKey);
                        campaignEx2.setNativeVideoTracking(TrackingStr2Object(strReplaceValueByKey));
                    }
                } catch (Exception unused2) {
                }
                campaignEx2.setVideo_end_type(jSONObjectDealV5Temp.optInt(VIDEO_END_TYPE, 2));
                if (isBreakCampainOrSetItByEndCard(campaignEx2, jSONObjectDealV5Temp.optString(ENDCARD_URL))) {
                    return campaignEx;
                }
                campaignEx2.setPlayable_ads_without_video(jSONObjectDealV5Temp.optInt(PLAYABLE_ADS_WITHOUT_VIDEO, 1));
                campaignEx2.setVideoMD5Value("");
                if (jSONObjectDealV5Temp.has(JSON_KEY_NV_T2)) {
                    campaignEx2.setNvT2(jSONObjectDealV5Temp.optInt(JSON_KEY_NV_T2));
                }
                if (jSONObjectDealV5Temp.has(JSON_KEY_GIF_URL)) {
                    campaignEx2.setGifUrl(jSONObjectDealV5Temp.optString(JSON_KEY_GIF_URL));
                }
                campaignEx2.setRewardTemplateMode(c.a(jSONObjectDealV5Temp.optJSONObject(JSON_KEY_REWARD_TEMPLATE)));
                campaignEx2.setClickTimeOutInterval(jSONObjectDealV5Temp.optInt(JSON_KEY_CLICK_TIMEOUT_INTERVAL, 2));
                campaignEx2.setImpUA(jSONObjectDealV5Temp.optInt(JSON_KEY_IMP_UA, 1));
                campaignEx2.setcUA(jSONObjectDealV5Temp.optInt(JSON_KEY_C_UA, 1));
                campaignEx2.setJmPd(jSONObjectDealV5Temp.optInt(JSON_KEY_JM_PD));
                campaignEx2.setKeyIaIcon(jSONObjectDealV5Temp.optString("ia_icon"));
                campaignEx2.setKeyIaRst(jSONObjectDealV5Temp.optInt("ia_rst"));
                campaignEx2.setKeyIaUrl(jSONObjectDealV5Temp.optString("ia_url"));
                campaignEx2.setKeyIaOri(jSONObjectDealV5Temp.optInt("ia_ori"));
                campaignEx2.setAdType(campaignUnit.getAdType());
                campaignEx2.setTpOffer(jSONObjectDealV5Temp.optInt(JSON_KEY_TP_OFFER));
                campaignEx2.setFac(jSONObjectDealV5Temp.optInt(JSON_KEY_FAC));
                campaignEx2.setIa_ext1(jSONObjectDealV5Temp.optString(KEY_IA_EXT1));
                campaignEx2.setIa_ext2(jSONObjectDealV5Temp.optString(KEY_IA_EXT2));
                campaignEx2.setIsDownLoadZip(jSONObjectDealV5Temp.optInt(KEY_IS_DOWNLOAD));
                campaignEx2.setInteractiveCache(jSONObjectDealV5Temp.optString(KEY_IA_CACHE));
                campaignEx2.setOc_time(jSONObjectDealV5Temp.optInt(KEY_OC_TIME));
                campaignEx2.setOc_type(jSONObjectDealV5Temp.optInt(KEY_OC_TYPE));
                campaignEx2.setT_list(jSONObjectDealV5Temp.optString(KEY_T_LIST));
                campaignEx2.setAdchoice(a.a(jSONObjectDealV5Temp.optString(KEY_ADCHOICE, "")));
                campaignEx2.setPlct(jSONObjectDealV5Temp.optLong(JSON_KEY_PLCT));
                campaignEx2.setCandidateCacheTime(jSONObjectDealV5Temp.optLong(JSON_KEY_C_C_TIME));
                campaignEx2.setPlctb(jSONObjectDealV5Temp.optLong(JSON_KEY_PLCTB));
                campaignEx2.setCreativeId(jSONObjectDealV5Temp.optLong(JSON_KEY_CREATIVE_ID));
                campaignEx2.setVidCrtvId(jSONObjectDealV5Temp.optLong(JSON_KEY_VIDEO_CREATIVE_ID));
                campaignEx2.setEcCrtvId(jSONObjectDealV5Temp.optLong(JSON_KEY_EC_CREATIVE_ID));
                campaignEx2.setEcTemplateId(jSONObjectDealV5Temp.optLong(JSON_KEY_EC_TEMP_ID));
                String strOptString3 = jSONObjectDealV5Temp.optString("cam_tpl_url");
                Uri uri = Uri.parse(strOptString3);
                if (TextUtils.isEmpty(uri.getPath()) || !(uri.getPath().endsWith(".zip") || uri.getPath().endsWith(".ZIP"))) {
                    campaignEx2.setBannerUrl(strOptString3);
                } else {
                    campaignEx2.setAdZip(strOptString3);
                }
                campaignEx2.setBannerHtml(jSONObjectDealV5Temp.optString("cam_html"));
                campaignEx2.setAdHtml(jSONObjectDealV5Temp.optString("cam_html"));
                String strOptString4 = jSONObjectDealV5Temp.optString(JSON_KEY_MRAID);
                if (!TextUtils.isEmpty(strOptString4)) {
                    campaignEx2.setIsMraid(true);
                    campaignEx2.setMraid(strOptString4);
                } else if (TextUtils.isEmpty(campaignEx2.getAdHtml()) || campaignEx2.getAdHtml().contains("<MBTPLMARK>")) {
                    campaignEx2.setIsMraid(false);
                } else {
                    campaignEx2.setIsMraid(true);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectDealV5Temp.optJSONArray(KEY_OMID);
                if (jSONArrayOptJSONArray2 != null) {
                    campaignEx2.setOmid(jSONArrayOptJSONArray2.toString());
                } else if (TextUtils.isEmpty(jSONObjectDealV5Temp.optString(KEY_OMID))) {
                    campaignEx2.setOmid(campaignEx);
                } else {
                    campaignEx2.setOmid(jSONObjectDealV5Temp.optString(KEY_OMID));
                }
                campaignEx2.setPlacementId(jSONObjectDealV5Temp.optString(MBridgeConstans.PLACEMENT_ID));
                campaignEx2.setMaitve(jSONObjectDealV5Temp.optInt(JSON_KEY_MAITVE));
                campaignEx2.setMaitve_src(jSONObjectDealV5Temp.optString(JSON_KEY_MAITVESRC));
                campaignEx2.setFlb(jSONObjectDealV5Temp.optInt(JSON_KEY_FLB));
                campaignEx2.setCbd(jSONObjectDealV5Temp.optInt(JSON_KEY_NEW_INTERSTITIAL_CBD, -2));
                campaignEx2.setVst(jSONObjectDealV5Temp.optInt(JSON_KEY_NEW_INTERSTITIAL_VST, -2));
                campaignEx2.setUseSkipTime(jSONObjectDealV5Temp.optInt(JSON_KEY_USE_SKIP_TIME, 0));
                campaignEx2.setProgressBarShow(jSONObjectDealV5Temp.optInt(JSON_KEY_PROG_BAR, 0));
                campaignEx2.setAdSpaceT(jSONObjectDealV5Temp.optInt(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, 1));
                campaignEx2.setFlbSkipTime(jSONObjectDealV5Temp.optInt(JSON_KEY_FLB_SKIP_TIME));
                campaign = DomainCampaignEx.parseCampaign(jSONObjectDealV5Temp, campaignEx2);
                try {
                    try {
                        campaign.setImpressionURL(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaign.getPackageName(), campaign.getImpressionURL()));
                    } catch (Exception e3) {
                        af.b("campaign", e3.getMessage());
                    }
                    campaign.setVideoCheckType(jSONObjectDealV5Temp.optInt(JSON_KEY_VIDEO_CHECK_TYPE, 2));
                    campaign.setVideoCtnType(jSONObjectDealV5Temp.optInt(JSON_KEY_VIDEO_CTN_TYPE, 1));
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectDealV5Temp.optJSONArray(JSON_KEY_RS_IGNORE_CHECK_RULE);
                    if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                        ArrayList<Integer> arrayList2 = new ArrayList<>();
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray3.length(); i11++) {
                            arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray3.optInt(i11)));
                        }
                        if (arrayList2.size() > 0) {
                            campaign.setRsIgnoreCheckRule(arrayList2);
                        }
                    }
                    if (jSONObjectDealV5Temp.has(JSON_KEY_AAB)) {
                        campaign.setAabEntity(AabEntity.parser(jSONObjectDealV5Temp.getString(JSON_KEY_AAB)));
                    }
                    try {
                        campaign.setPrivacyUrl(jSONObjectDealV5Temp.optString(JSON_KEY_PRIVACY_URL, ""));
                        campaign.setPrivacyButtonTemplateVisibility(jSONObjectDealV5Temp.optInt(PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH, 0));
                    } catch (Exception e7) {
                        af.b("campaign", e7.getMessage());
                    }
                    campaign.setImpReportType(jSONObjectDealV5Temp.optInt(JSON_KEY_IMP_REPORT_TYPE, 0));
                    campaign.setAutoShowStoreMiniCard(jSONObjectDealV5Temp.optInt(JSON_KEY_AUTO_SHOW_MINI_CARD, 0));
                    campaign.setShowStoreMiniCardDelayTime(jSONObjectDealV5Temp.optInt(JSON_KEY_SHOW_MINI_CARD_DELAY_TIME, 0));
                    String strOptString5 = jSONObjectDealV5Temp.optString(KEY_ACTIVITY_PATH_AND_NAME);
                    if (!TextUtils.isEmpty(strOptString5)) {
                        try {
                            campaign.setAc(strOptString5);
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    campaign.setFilterCallBackState(jSONObjectDealV5Temp.optInt(KEY_SECOND_REQUEST_CALLBACK_STATE, 2));
                    return campaign;
                } catch (Exception e11) {
                    e = e11;
                    e.printStackTrace();
                    return campaign;
                }
            } catch (Exception e12) {
                e = e12;
                campaign = campaignEx2;
            }
        } catch (Exception e13) {
            e = e13;
            campaign = null;
        }
    }

    public static CampaignEx parseCampaignWithBackData(JSONObject jSONObject) {
        CampaignEx campaignEx;
        String str;
        ArrayList arrayList;
        if (jSONObject == null) {
            return null;
        }
        try {
            CampaignEx campaignEx2 = new CampaignEx();
            try {
                campaignEx2.setId(jSONObject.optString("id"));
                campaignEx2.setAppName(jSONObject.optString(JSON_KEY_TITLE));
                campaignEx2.setAppDesc(jSONObject.optString(JSON_KEY_DESC));
                campaignEx2.setPackageName(jSONObject.optString(JSON_KEY_PACKAGE_NAME));
                campaignEx2.setRtinsType(jSONObject.optInt(JSON_KEY_RETARGET_TYPE));
                campaignEx2.setIconUrl(jSONObject.optString(JSON_KEY_ICON_URL));
                campaignEx2.setImageUrl(jSONObject.optString(JSON_KEY_IMAGE_URL));
                campaignEx2.setSize(jSONObject.optString(JSON_KEY_APP_SIZE));
                campaignEx2.setImageSize(jSONObject.optString(JSON_KEY_IMAGE_SIZE));
                campaignEx2.setImpressionURL(jSONObject.optString(JSON_KEY_IMPRESSION_URL));
                campaignEx2.setClickURL(jSONObject.optString(JSON_KEY_CLICK_URL));
                campaignEx2.setRewardPlus(RewardPlus.parseByString(jSONObject.optString(JSON_KEY_REWARD_PLUS)));
                campaignEx2.setWtick(jSONObject.optInt(JSON_KEY_WITHOUT_INSTALL_CHECK));
                campaignEx2.setDeepLinkUrl(jSONObject.optString(JSON_KEY_DEEP_LINK_URL));
                campaignEx2.setUserActivation(jSONObject.optBoolean(JSON_KEY_USER_ACTIVATION, false));
                campaignEx2.setNoticeUrl(jSONObject.optString(JSON_KEY_NOTICE_URL));
                campaignEx2.setTemplate(jSONObject.optInt("template"));
                campaignEx2.setType(jSONObject.optInt(JSON_KEY_AD_SOURCE_ID, 1));
                campaignEx2.setFca(jSONObject.optInt(JSON_KEY_FCA));
                campaignEx2.setFcb(jSONObject.optInt(JSON_KEY_FCB));
                campaignEx2.setEndcard_click_result(jSONObject.optInt(JSON_KEY_ENDCARD_CLICK));
                if (TextUtils.isEmpty(jSONObject.optString(JSON_KEY_STAR))) {
                    str = JSON_KEY_NOTICE_URL;
                } else {
                    String strOptString = jSONObject.optString(JSON_KEY_STAR, "0");
                    str = JSON_KEY_NOTICE_URL;
                    campaignEx2.setRating(Double.parseDouble(strOptString));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(JSON_KEY_NUMBER_RATING))) {
                    campaignEx2.setNumberRating(jSONObject.optInt(JSON_KEY_NUMBER_RATING, 333333));
                }
                campaignEx2.setClick_mode(jSONObject.optString(JSON_KEY_CLICK_MODE));
                campaignEx2.setLandingType(jSONObject.optString(JSON_KEY_LANDING_TYPE));
                campaignEx2.setLinkType(jSONObject.optInt(JSON_KEY_LINK_TYPE, 4));
                campaignEx2.setClickInterval(jSONObject.optInt(JSON_KEY_CLICK_INTERVAL));
                campaignEx2.setAdCall(jSONObject.optString(JSON_KEY_CTA_TEXT));
                campaignEx2.setAd_url_list(jSONObject.optString(JSON_KEY_AD_URL_LIST));
                campaignEx2.setRetarget_offer(jSONObject.optInt(JSON_KEY_RETARGET_OFFER, 2));
                campaignEx2.setVideoUrlEncode(jSONObject.optString(JSON_KEY_VIDEO_URL));
                campaignEx2.setVideoLength(jSONObject.optInt(JSON_KEY_VIDEO_LENGTHL));
                campaignEx2.setVideoSize(jSONObject.optInt(JSON_KEY_VIDEO_SIZE));
                campaignEx2.setVideoResolution(jSONObject.optString(JSON_KEY_VIDEO_RESOLUTION));
                campaignEx2.setWatchMile(jSONObject.optInt(JSON_KEY_WATCH_MILE));
                campaignEx2.setTimestamp(System.currentTimeMillis());
                campaignEx2.setBty(jSONObject.optInt(JSON_KEY_BTY));
                campaignEx2.setAdvImp(jSONObject.optString(JSON_KEY_ADVIMP));
                campaignEx2.setTImp(jSONObject.optInt(JSON_KEY_T_IMP));
                campaignEx2.setHtmlUrl(jSONObject.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_HTML_URL));
                campaignEx2.setEndScreenUrl(jSONObject.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_END_SCREEN_URL));
                campaignEx2.setGuidelines(jSONObject.optString(JSON_KEY_GUIDELINES));
                campaignEx2.setOfferType(jSONObject.optInt(JSON_KEY_OFFER_TYPE));
                campaignEx2.setRewardName(jSONObject.optString(JSON_KEY_REWARD_NAME));
                campaignEx2.setRewardAmount(jSONObject.optInt(JSON_KEY_REWARD_AMOUNT));
                try {
                    if (jSONObject.has(JSON_NATIVE_VIDEO_AD_TRACKING)) {
                        String strOptString2 = jSONObject.optString(JSON_NATIVE_VIDEO_AD_TRACKING);
                        if (!TextUtils.isEmpty(strOptString2)) {
                            campaignEx2.setNativeVideoTrackingString(strOptString2);
                            campaignEx2.setNativeVideoTracking(TrackingStr2Object(strOptString2));
                        }
                    }
                } catch (Exception unused) {
                }
                try {
                    campaignEx2.setReady_rate(jSONObject.optInt(JSON_KEY_READY_RATE, -1));
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(JSON_KEY_EXT_DATA);
                    if (jSONObjectOptJSONObject != null) {
                        campaignEx2.setExt_data(jSONObjectOptJSONObject.toString());
                    } else {
                        String strOptString3 = jSONObject.optString(JSON_KEY_EXT_DATA);
                        if (!TextUtils.isEmpty(strOptString3)) {
                            campaignEx2.setExt_data(strOptString3);
                        }
                    }
                    campaignEx2.setMof_tplid(jSONObject.optInt(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TPLID));
                    campaignEx2.setMof_template_url(jSONObject.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_MOF_TEMPLATE_URL));
                    campaignEx2.setNscpt(jSONObject.optInt(com.mbridge.msdk.foundation.entity.b.JSON_KEY_NSCPT));
                    new JSONArray();
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pv_urls");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i10));
                        }
                    }
                    campaignEx2.setPv_urls(arrayList);
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.mbridge.msdk.foundation.entity.b.JSON_KEY_REQ_EXT_DATA);
                    if (jSONObjectOptJSONObject2 != null) {
                        campaignEx2.setReq_ext_data(jSONObjectOptJSONObject2.toString());
                    }
                } catch (Exception unused2) {
                }
                campaignEx2.setVideo_end_type(jSONObject.optInt(VIDEO_END_TYPE, 2));
                if (isBreakCampainOrSetItByEndCard(campaignEx2, jSONObject.optString(ENDCARD_URL))) {
                    return null;
                }
                campaignEx2.setPlayable_ads_without_video(jSONObject.optInt(PLAYABLE_ADS_WITHOUT_VIDEO, 1));
                campaignEx2.setVideoMD5Value("");
                if (jSONObject.has(JSON_KEY_NV_T2)) {
                    campaignEx2.setNvT2(jSONObject.optInt(JSON_KEY_NV_T2));
                }
                if (jSONObject.has(JSON_KEY_GIF_URL)) {
                    campaignEx2.setGifUrl(jSONObject.optString(JSON_KEY_GIF_URL));
                }
                try {
                    JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(JSON_KEY_REWARD_TEMPLATE);
                    if (jSONObjectOptJSONObject3 != null) {
                        campaignEx2.setRewardTemplateMode(c.a(jSONObjectOptJSONObject3));
                    } else {
                        String strOptString4 = jSONObject.optString(JSON_KEY_REWARD_TEMPLATE);
                        if (!TextUtils.isEmpty(strOptString4)) {
                            campaignEx2.setRewardTemplateMode(c.a(new JSONObject(strOptString4)));
                        }
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
                campaignEx2.setClickTimeOutInterval(jSONObject.optInt(JSON_KEY_CLICK_TIMEOUT_INTERVAL, 2));
                campaignEx2.setImpUA(jSONObject.optInt(JSON_KEY_IMP_UA, 1));
                campaignEx2.setcUA(jSONObject.optInt(JSON_KEY_C_UA, 1));
                campaignEx2.setJmPd(jSONObject.optInt(JSON_KEY_JM_PD));
                campaignEx2.setKeyIaIcon(jSONObject.optString("ia_icon"));
                campaignEx2.setKeyIaRst(jSONObject.optInt("ia_rst"));
                campaignEx2.setKeyIaUrl(jSONObject.optString("ia_url"));
                campaignEx2.setKeyIaOri(jSONObject.optInt("ia_ori"));
                campaignEx2.setAdType(jSONObject.optInt("ad_type"));
                campaignEx2.setTpOffer(jSONObject.optInt(JSON_KEY_TP_OFFER));
                campaignEx2.setFac(jSONObject.optInt(JSON_KEY_FAC));
                campaignEx2.setIa_ext1(jSONObject.optString(KEY_IA_EXT1));
                campaignEx2.setIa_ext2(jSONObject.optString(KEY_IA_EXT2));
                campaignEx2.setIsDownLoadZip(jSONObject.optInt(KEY_IS_DOWNLOAD));
                campaignEx2.setInteractiveCache(jSONObject.optString(KEY_IA_CACHE));
                campaignEx2.setOc_time(jSONObject.optInt(KEY_OC_TIME));
                campaignEx2.setOc_type(jSONObject.optInt(KEY_OC_TYPE));
                campaignEx2.setT_list(jSONObject.optString(KEY_T_LIST));
                campaignEx2.setAdchoice(a.a(jSONObject.optString(KEY_ADCHOICE, "")));
                campaignEx2.setPlct(jSONObject.optLong(JSON_KEY_PLCT));
                campaignEx2.setPlctb(jSONObject.optLong(JSON_KEY_PLCTB));
                campaignEx2.setCandidateCacheTime(jSONObject.optLong(JSON_KEY_C_C_TIME));
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(KEY_OMID);
                if (jSONArrayOptJSONArray2 != null) {
                    campaignEx2.setOmid(jSONArrayOptJSONArray2.toString());
                } else if (TextUtils.isEmpty(jSONObject.optString(KEY_OMID))) {
                    campaignEx2.setOmid(null);
                } else {
                    campaignEx2.setOmid(jSONObject.optString(KEY_OMID));
                }
                campaignEx2.setCreativeId(jSONObject.optLong(JSON_KEY_CREATIVE_ID));
                campaignEx2.setVidCrtvId(jSONObject.optLong(JSON_KEY_VIDEO_CREATIVE_ID));
                campaignEx2.setEcCrtvId(jSONObject.optLong(JSON_KEY_EC_CREATIVE_ID));
                campaignEx2.setEcTemplateId(jSONObject.optLong(JSON_KEY_EC_TEMP_ID));
                campaignEx2.setLocalRequestId(jSONObject.optString(JSON_KEY_LOCAL_REQUEST_ID, ""));
                String strOptString5 = jSONObject.optString("cam_tpl_url");
                Uri uri = Uri.parse(strOptString5);
                if (TextUtils.isEmpty(uri.getPath()) || !(uri.getPath().endsWith(".zip") || uri.getPath().endsWith(".ZIP"))) {
                    campaignEx2.setBannerUrl(strOptString5);
                } else {
                    campaignEx2.setAdZip(strOptString5);
                }
                campaignEx2.setBannerHtml(jSONObject.optString("cam_html"));
                campaignEx2.setAdHtml(jSONObject.optString("cam_html"));
                campaignEx2.setCampaignUnitId(jSONObject.optString(JSON_KEY_CAMPAIGN_UNITID));
                String strOptString6 = jSONObject.optString(JSON_KEY_MRAID);
                if (TextUtils.isEmpty(strOptString6)) {
                    strOptString6 = jSONObject.optString(JSON_KEY_MRAIDFORH5);
                }
                if (!TextUtils.isEmpty(strOptString6)) {
                    campaignEx2.setIsMraid(true);
                    campaignEx2.setMraid(strOptString6);
                } else if (TextUtils.isEmpty(campaignEx2.getAdHtml()) || campaignEx2.getAdHtml().contains("<MBTPLMARK>")) {
                    campaignEx2.setIsMraid(false);
                } else {
                    campaignEx2.setIsMraid(true);
                }
                campaignEx2.setNetAddress(jSONObject.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I));
                try {
                    String strOptString7 = jSONObject.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ONLY_IMPRESSION_URL);
                    if (!TextUtils.isEmpty(strOptString7)) {
                        campaignEx2.setOnlyImpressionURL(strOptString7);
                        Uri uri2 = Uri.parse(strOptString7);
                        if (uri2 != null) {
                            campaignEx2.setRequestId(uri2.getQueryParameter(JSON_KEY_AD_K));
                        }
                    }
                    String strOptString8 = jSONObject.optString(str);
                    if (!TextUtils.isEmpty(strOptString8)) {
                        campaignEx2.setNoticeUrl(strOptString8);
                        Uri uri3 = Uri.parse(strOptString8);
                        if (uri3 != null) {
                            campaignEx2.setRequestIdNotice(uri3.getQueryParameter(JSON_KEY_AD_K));
                        }
                    }
                    try {
                        String strOptString9 = jSONObject.optString(JSON_KEY_ECPPV);
                        if (!TextUtils.isEmpty(strOptString9)) {
                            campaignEx2.setEcppv(strOptString9);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    campaignEx2.setAc_s(jSONObject.optInt(KEY_ACTIVITY_CHECK_SWITCH, 1));
                } catch (Exception unused3) {
                }
                campaignEx2.setIsBidCampaign(jSONObject.optBoolean(JSON_KEY_HB, false));
                campaignEx2.setPlacementId(jSONObject.optString(MBridgeConstans.PLACEMENT_ID));
                campaignEx2.setMaitve(jSONObject.optInt(JSON_KEY_MAITVE));
                campaignEx2.setMaitve_src(jSONObject.optString(JSON_KEY_MAITVESRC));
                campaignEx2.setFlb(jSONObject.optInt(JSON_KEY_FLB));
                campaignEx2.setFlbSkipTime(jSONObject.optInt(JSON_KEY_FLB_SKIP_TIME));
                campaignEx2.setCbd(jSONObject.optInt(JSON_KEY_NEW_INTERSTITIAL_CBD, -2));
                campaignEx2.setVst(jSONObject.optInt(JSON_KEY_NEW_INTERSTITIAL_VST, -2));
                campaignEx2.setUseSkipTime(jSONObject.optInt(JSON_KEY_USE_SKIP_TIME, 0));
                campaignEx2.setProgressBarShow(jSONObject.optInt(JSON_KEY_PROG_BAR, 0));
                campaignEx2.setAdSpaceT(jSONObject.optInt(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, 1));
                CampaignEx campaignWithBackData = DomainCampaignEx.parseCampaignWithBackData(jSONObject, campaignEx2);
                try {
                    campaignWithBackData.setVcn(jSONObject.optInt("vcn"));
                    campaignWithBackData.setTokenRule(jSONObject.optInt("token_r"));
                    campaignWithBackData.setEncryptPrice(jSONObject.optString("encrypt_p"));
                    campaignWithBackData.setVideoCompleteTime(jSONObject.optInt(JSON_KEY_VIDEO_COMPLETE_TIME));
                    campaignWithBackData.setVideoCheckType(jSONObject.optInt(JSON_KEY_VIDEO_CHECK_TYPE, 2));
                    campaignWithBackData.setVideoCtnType(jSONObject.optInt(JSON_KEY_VIDEO_CTN_TYPE, 1));
                    JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(JSON_KEY_RS_IGNORE_CHECK_RULE);
                    if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                        ArrayList<Integer> arrayList2 = new ArrayList<>();
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray3.length(); i11++) {
                            arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray3.optInt(i11)));
                        }
                        if (arrayList2.size() > 0) {
                            campaignWithBackData.setRsIgnoreCheckRule(arrayList2);
                        }
                    }
                    if (jSONObject.has(JSON_KEY_AAB)) {
                        campaignWithBackData.setAabEntity(AabEntity.parser(jSONObject.getString(JSON_KEY_AAB)));
                    }
                    try {
                        campaignWithBackData.setPrivacyUrl(jSONObject.optString(JSON_KEY_PRIVACY_URL, ""));
                        campaignWithBackData.setPrivacyButtonTemplateVisibility(jSONObject.optInt(PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH, 0));
                    } catch (Exception e7) {
                        af.b("campaign", e7.getMessage());
                    }
                    campaignWithBackData.setImpReportType(jSONObject.optInt(JSON_KEY_IMP_REPORT_TYPE, 0));
                    campaignWithBackData.setTrackingTcpPort(jSONObject.optInt(com.mbridge.msdk.foundation.entity.b.JSON_KEY_TK_TCP_PORT, 9377));
                    campaignWithBackData.setAutoShowStoreMiniCard(jSONObject.optInt(JSON_KEY_AUTO_SHOW_MINI_CARD, 0));
                    campaignWithBackData.setShowStoreMiniCardDelayTime(jSONObject.optInt(JSON_KEY_SHOW_MINI_CARD_DELAY_TIME, 0));
                    campaignWithBackData.setShowIndex(jSONObject.optInt(KEY_SHOW_INDEX, 1));
                    campaignWithBackData.setShowType(jSONObject.optInt(KEY_SHOW_TYPE, 1));
                    campaignWithBackData.setClickTempSource(jSONObject.optInt(KEY_CLICK_TEMP_SOURCE));
                    campaignWithBackData.setTemplateRenderSucc(jSONObject.optBoolean(KEY_PLAY_TEMP_DISPLAY_TYPE));
                    campaignWithBackData.setECTemplateRenderSucc(jSONObject.optBoolean(KEY_EC_TEMP_DISPLAY_TYPE));
                    campaignWithBackData.setTriggerClickSource(jSONObject.optInt(KEY_TRIGGER_CLICK_SOURCE));
                    String strOptString10 = jSONObject.optString(KEY_ACTIVITY_PATH_AND_NAME);
                    if (!TextUtils.isEmpty(strOptString10)) {
                        try {
                            campaignWithBackData.setAc(strOptString10);
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    campaignWithBackData.setFilterCallBackState(jSONObject.optInt(KEY_SECOND_REQUEST_CALLBACK_STATE, 2));
                    return campaignWithBackData;
                } catch (Exception e11) {
                    e = e11;
                    campaignEx = campaignWithBackData;
                    e.printStackTrace();
                    return campaignEx;
                }
            } catch (Exception e12) {
                e = e12;
                campaignEx = campaignEx2;
            }
        } catch (Exception e13) {
            e = e13;
            campaignEx = null;
        }
    }

    public static JSONArray parseCamplistToJson(List<CampaignEx> list) {
        JSONArray jSONArray = null;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        Iterator<CampaignEx> it = list.iterator();
                        while (it.hasNext()) {
                            try {
                                jSONArray2.put(campaignToJsonObject(it.next()));
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        return jSONArray2;
                    } catch (Exception e) {
                        e = e;
                        jSONArray = jSONArray2;
                        e.printStackTrace();
                        return jSONArray;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return jSONArray;
    }

    private static List<Map<Integer, String>> parsePlayCentage(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    String string = jSONArray.getString(i10);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        HashMap map = new HashMap();
                        int i11 = jSONObject.getInt("rate");
                        map.put(Integer.valueOf(i11), jSONObject.getString("url"));
                        arrayList.add(map);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public static CampaignEx parseSettingCampaign(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        campaignEx.setId(jSONObject.optString("campaignid"));
        campaignEx.setPackageName(jSONObject.optString("packageName"));
        campaignEx.setAppName(jSONObject.optString(JSON_KEY_TITLE));
        campaignEx.setAdCall(jSONObject.optString("cta"));
        campaignEx.setAppDesc(jSONObject.optString(JSON_KEY_DESC));
        campaignEx.setImpressionURL(jSONObject.optString(JSON_KEY_IMPRESSION_URL));
        campaignEx.setImageUrl(jSONObject.optString(JSON_KEY_IMAGE_URL));
        campaignEx.setPlct(jSONObject.optLong(JSON_KEY_PLCT));
        campaignEx.setPlctb(jSONObject.optLong(JSON_KEY_PLCTB));
        campaignEx.setCandidateCacheTime(jSONObject.optLong(JSON_KEY_C_C_TIME));
        campaignEx.setAdHtml(jSONObject.optString(JSON_KEY_AD_HTML));
        campaignEx.setAdZip(jSONObject.optString(JSON_KEY_AD_ZIP));
        campaignEx.setBannerUrl(jSONObject.optString(JSON_KEY_BANNER_URL));
        campaignEx.setBannerHtml(jSONObject.optString(JSON_KEY_BANNER_HTML));
        campaignEx.setCreativeId(jSONObject.optLong(JSON_KEY_CREATIVE_ID));
        campaignEx.setVidCrtvId(jSONObject.optLong(JSON_KEY_VIDEO_CREATIVE_ID));
        campaignEx.setEcCrtvId(jSONObject.optLong(JSON_KEY_EC_CREATIVE_ID));
        campaignEx.setEcTemplateId(jSONObject.optLong(JSON_KEY_EC_TEMP_ID));
        campaignEx.setPlacementId(jSONObject.optString(MBridgeConstans.PLACEMENT_ID));
        return campaignEx;
    }

    public static String[] processNativeVideoTrackingArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            strArr[i10] = jSONArray.optString(i10);
        }
        return strArr;
    }

    public static JSONArray processNativeVideoTrackingArray2Json(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : strArr) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    private static JSONArray reparsePlayCentage(List<Map<Integer, String>> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                try {
                    Map<Integer, String> map = list.get(i10);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("rate", map.keySet().iterator().next());
                    jSONObject.put("url", map.values().iterator().next());
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    private void setMoreOfferAdControl(String str, String str2) throws JSONException {
        try {
            int iC = ak.c(str, MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
            if (iC == 0) {
                return;
            }
            JSONObject jSONObject = TextUtils.isEmpty(this.moreOfferJsonData) ? new JSONObject() : new JSONObject(this.moreOfferJsonData);
            int iC2 = ak.c(str, MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF, iC);
            jSONObject2.put(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM, iC2);
            jSONObject.put(str2, jSONObject2);
            this.moreOfferJsonData = jSONObject.toString();
        } catch (Exception e) {
            af.a(TAG, e.getMessage());
        }
    }

    public AabEntity getAabEntity() {
        return this.aabEntity;
    }

    public String getAc() {
        return this.ac;
    }

    public int getAc_s() {
        return this.ac_s;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public int getAdSpaceT() {
        return this.adSpaceT;
    }

    public int getAdType() {
        return this.adType;
    }

    public List<String> getAdUrlList() {
        Exception e;
        ArrayList arrayList;
        String ad_url_list = getAd_url_list();
        try {
            if (TextUtils.isEmpty(ad_url_list)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(ad_url_list);
            arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    arrayList.add(jSONArray.optString(i10));
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e7) {
            e = e7;
            arrayList = null;
        }
    }

    public String getAdZip() {
        return this.adZip;
    }

    public String getAd_url_list() {
        return this.ad_url_list;
    }

    public a getAdchoice() {
        return this.adchoice;
    }

    public String getAdvImp() {
        return this.advImp;
    }

    public Map<Integer, String> getAdvImpList() {
        return generateAdImpression(this.advImp);
    }

    public HashMap<String, String> getAks() {
        return this.aks;
    }

    public String getAl() {
        return this.al;
    }

    public int getAutoShowStoreMiniCard() {
        return this.autoShowStoreMiniCard;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public int getBty() {
        return this.bty;
    }

    public String getCMPTEntryUrl() {
        return this.CMPTEntryUrl;
    }

    public int getCacheLevel() {
        return this.cacheLevel;
    }

    public String getCampaignUnitId() {
        return this.campaignUnitId;
    }

    public boolean getCanStart2C1Anim() {
        return this.canStart2C1Anim;
    }

    public boolean getCanStartMoreOfferAnim() {
        return this.canStartMoreOfferAnim;
    }

    public long getCandidateCacheTime() {
        return this.candidateCacheTime;
    }

    public int getCbd() {
        return this.cbd;
    }

    public int getCbt() {
        return this.cbt;
    }

    public int getClickInterval() {
        return this.clickInterval;
    }

    public int getClickTempSource() {
        return this.clickTempSource;
    }

    public int getClickTimeOutInterval() {
        return this.clickTimeOutInterval;
    }

    public int getClickType() {
        return this.clickType;
    }

    public String getClickURL() {
        return this.clickURL;
    }

    public String getClick_mode() {
        return this.click_mode;
    }

    @Override // com.mbridge.msdk.out.Campaign, com.mbridge.msdk.out.BaseCampaign
    public long getCreativeId() {
        return this.creativeId;
    }

    public String getCurrentLocalRid() {
        return TextUtils.isEmpty(this.n_lrid) ? this.localRequestId : this.n_lrid;
    }

    public String getDeepLinkURL() {
        return this.deepLinkUrl;
    }

    public int getDynamicTempCode() {
        return this.dynamicTempCode;
    }

    public long getEcCrtvId() {
        return this.ecCrtvId;
    }

    public long getEcTemplateId() {
        return this.ecTemplateId;
    }

    public String getEcppv() {
        return this.ecppv;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public String getEndScreenUrl() {
        return this.endScreenUrl;
    }

    public int getEndcard_click_result() {
        return this.endcard_click_result;
    }

    public String getExpIds() {
        return this.expIds;
    }

    public String getExt_data() {
        return this.ext_data;
    }

    public int getFac() {
        return this.fac;
    }

    public int getFca() {
        return this.fca;
    }

    public int getFcb() {
        return this.fcb;
    }

    public int getFilterCallBackState() {
        return this.filterCallBackState;
    }

    public int getFlb() {
        return this.flb;
    }

    public int getFlbSkipTime() {
        return this.flbSkipTime;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public String getGuidelines() {
        return this.guidelines;
    }

    public String getHost() {
        if (TextUtils.isEmpty(getNoticeUrl())) {
            return "";
        }
        try {
            Uri uri = Uri.parse(getNoticeUrl());
            if (uri == null) {
                return "";
            }
            return uri.getScheme() + "://" + uri.getHost();
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
            return "";
        }
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getIa_ext1() {
        return this.ia_ext1;
    }

    public String getIa_ext2() {
        return this.ia_ext2;
    }

    public int getIex() {
        return this.iex;
    }

    public String getImageSize() {
        return this.imageSize;
    }

    public int getImpReportType() {
        return this.impReportType;
    }

    public int getImpUA() {
        return this.impUA;
    }

    public String getImpressionURL() {
        try {
            if (ah.a().a("v_a_d_p", false)) {
                String strA = ak.a(this.impressionURL, "&tun=", ab.q() + "");
                this.impressionURL = strA;
                return strA;
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
        return this.impressionURL;
    }

    public String getInteractiveCache() {
        return this.interactiveCache;
    }

    public int getIsAddSuccesful() {
        return this.isAddSuccesful;
    }

    public int getIsClick() {
        return this.isClick;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDownLoadZip() {
        return this.isDownLoadZip;
    }

    public int getIsTimeoutCheckVideoStatus() {
        return this.isTimeoutCheckVideoStatus;
    }

    public int getJmPd() {
        return this.jmPd;
    }

    public JumpLoaderResult getJumpResult() {
        return this.jumpResult;
    }

    public String getK() {
        return this.f3487k;
    }

    public String getKeyIaIcon() {
        return this.keyIaIcon;
    }

    public int getKeyIaOri() {
        return this.keyIaOri;
    }

    public int getKeyIaRst() {
        return this.keyIaRst;
    }

    public String getKeyIaUrl() {
        return this.keyIaUrl;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLandingType() {
        return this.landingType;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public int getLoadTimeoutState() {
        return this.loadTimeoutState;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public int getMaitve() {
        return this.maitve;
    }

    public String getMaitve_src() {
        return this.maitve_src;
    }

    public b getMediaViewHolder() {
        return this.mediaViewHolder;
    }

    public String getMof_template_url() {
        return this.mof_template_url;
    }

    public int getMof_tplid() {
        return this.mof_tplid;
    }

    public String getMoreOfferJsonData() {
        return this.moreOfferJsonData;
    }

    public String getMp() {
        return this.mp;
    }

    public String getMraid() {
        return this.mraid;
    }

    public String getNLRid() {
        return this.n_lrid;
    }

    public String getNRid() {
        return this.n_rid;
    }

    public j getNativeVideoTracking() {
        return this.nativeVideoTracking;
    }

    public String getNativeVideoTrackingString() {
        return this.nativeVideoTrackingString;
    }

    public String getNetAddress() {
        return this.netAddress;
    }

    public String getNoticeUrl() {
        try {
            if (ah.a().a("v_a_d_p", false)) {
                String strA = ak.a(this.noticeUrl, "&tun=", ab.q() + "");
                this.noticeUrl = strA;
                return strA;
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
        return this.noticeUrl;
    }

    public int getNscpt() {
        return this.nscpt;
    }

    public int getNvT2() {
        return this.nvT2;
    }

    public int getOc_time() {
        return this.oc_time;
    }

    public int getOc_type() {
        return this.oc_type;
    }

    public int getOfferType() {
        return this.offerType;
    }

    public String getOmid() {
        return this.omid;
    }

    public String getOnlyImpressionURL() {
        try {
            if (ah.a().a("v_a_d_p", false)) {
                String strA = ak.a(this.onlyImpressionURL, "&tun=", ab.q() + "");
                this.onlyImpressionURL = strA;
                return strA;
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
        return this.onlyImpressionURL;
    }

    public String getPkgSource() {
        return this.pkgSource;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public int getPlayable_ads_without_video() {
        return this.playable_ads_without_video;
    }

    public long getPlct() {
        return this.plct;
    }

    public long getPlctb() {
        return this.plctb;
    }

    public int getPrivacyButtonTemplateVisibility() {
        return this.privacyButtonTemplateVisibility;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public int getProgressBarShow() {
        return this.progressBarShow;
    }

    public List<String> getPv_urls() {
        return this.pv_urls;
    }

    public String getQ() {
        return this.f3488q;
    }

    public String getR() {
        return this.f3489r;
    }

    public int getReadyState() {
        return this.readyState;
    }

    public int getReady_rate() {
        return this.ready_rate;
    }

    public String getReasond() {
        return this.reasond;
    }

    public String getReq_ext_data() {
        return this.req_ext_data;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionURL)) {
                return null;
            }
            Uri uri = Uri.parse(this.onlyImpressionURL);
            if (uri != null) {
                String queryParameter = uri.getQueryParameter(JSON_KEY_AD_K);
                this.requestId = queryParameter;
                setRequestId(queryParameter);
            }
            return this.requestId;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getRequestIdNotice() {
        try {
            if (!TextUtils.isEmpty(this.requestIdNotice)) {
                return this.requestIdNotice;
            }
            if (TextUtils.isEmpty(this.noticeUrl)) {
                return "";
            }
            Uri uri = Uri.parse(this.noticeUrl);
            if (uri != null) {
                String queryParameter = uri.getQueryParameter(JSON_KEY_AD_K);
                this.requestIdNotice = queryParameter;
                setRequestIdNotice(queryParameter);
            }
            return this.requestIdNotice;
        } catch (Exception unused) {
            return "";
        }
    }

    public int getRetarget_offer() {
        return this.retarget_offer;
    }

    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.reward_name;
    }

    public int getRewardPlayStatus() {
        return this.rewardPlayStatus;
    }

    public RewardPlus getRewardPlus() {
        return this.rewardPlus;
    }

    public c getRewardTemplateMode() {
        return this.rewardTemplateMode;
    }

    public ArrayList<Integer> getRsIgnoreCheckRule() {
        return this.rsIgnoreCheckRule;
    }

    public String getRsIgnoreCheckRuleString() {
        if (getRsIgnoreCheckRule() == null || getRsIgnoreCheckRule().size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            ArrayList<Integer> rsIgnoreCheckRule = getRsIgnoreCheckRule();
            int size = rsIgnoreCheckRule.size();
            int i10 = 0;
            while (i10 < size) {
                Integer num = rsIgnoreCheckRule.get(i10);
                i10++;
                sb.append(num);
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
            return !TextUtils.isEmpty(sb) ? sb.toString() : "";
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return "";
        }
    }

    public int getRtinsType() {
        return this.rtinsType;
    }

    public int getShowCount() {
        return this.showCount;
    }

    public int getShowIndex() {
        return this.showIndex;
    }

    public int getShowStoreMiniCardDelayTime() {
        return this.showStoreMiniCardDelayTime;
    }

    public int getShowType() {
        return this.showType;
    }

    public int getSpareOfferFlag() {
        return this.spareOfferFlag;
    }

    public int getTImp() {
        return this.t_imp;
    }

    public String getT_list() {
        return this.t_list;
    }

    public int getTab() {
        return this.tab;
    }

    public int getTemplate() {
        return this.template;
    }

    public int getTokenRule() {
        int i10 = this.tokenRule;
        if (i10 == 1) {
            return i10;
        }
        return 0;
    }

    public int getTpOffer() {
        return this.tpOffer;
    }

    public int getTrackingTcpPort() {
        return this.trackingTcpPort;
    }

    public int getTriggerClickSource() {
        return this.triggerClickSource;
    }

    public long getTs() {
        return this.ts;
    }

    public int getTyped() {
        return this.typed;
    }

    public int getUseSkipTime() {
        return this.useSkipTime;
    }

    public boolean getUserActivation() {
        return this.userActivation;
    }

    public int getVcn() {
        int i10 = this.vcn;
        if (i10 > 0) {
            return i10;
        }
        return 1;
    }

    public long getVidCrtvId() {
        return this.vidCrtvId;
    }

    public int getVideoCheckType() {
        return this.videoCheckType;
    }

    public int getVideoCompleteTime() {
        return this.videoCompleteTime;
    }

    public int getVideoCtnType() {
        return this.videoCtnType;
    }

    public String getVideoMD5Value() {
        return this.videoMD5Value;
    }

    public int getVideoPlayProgress() {
        return this.videoPlayProgress;
    }

    public String getVideoResolution() {
        return this.videoResolution;
    }

    public int getVideoSize() {
        return this.videoSize;
    }

    public String getVideoUrlEncode() {
        return this.videoUrlEncode;
    }

    public int getVideo_end_type() {
        return this.video_end_type;
    }

    public int getVst() {
        return this.vst;
    }

    public int getWatchMile() {
        return this.watchMile;
    }

    public int getWtick() {
        return this.wtick;
    }

    public int getcUA() {
        return this.cUA;
    }

    public long getcVersionCode() {
        return this.cVersionCode;
    }

    public String getendcard_url() {
        return this.endcard_url;
    }

    public boolean isActiveOm() {
        return (TextUtils.isEmpty(this.omid) || TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL)) ? false : true;
    }

    public boolean isBidCampaign() {
        return this.isBidCampaign;
    }

    public boolean isCallBackImpression() {
        return this.isCallBackImpression;
    }

    public boolean isCallbacked() {
        return this.isCallbacked;
    }

    public boolean isCampaignIsFiltered() {
        return this.campaignIsFiltered;
    }

    public boolean isDynamicView() {
        return this.isDynamicView;
    }

    public boolean isECTemplateRenderSucc() {
        return this.isECTemplateRenderSucc;
    }

    public boolean isEffectiveOffer(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (getPlct() > 0) {
            return (getPlct() * 1000) + getTimestamp() >= jCurrentTimeMillis;
        }
        return getTimestamp() + j10 >= jCurrentTimeMillis;
    }

    public boolean isHasMBTplMark() {
        return this.hasMBTplMark;
    }

    public boolean isHasReportAdTrackPause() {
        return this.hasReportAdTrackPause;
    }

    public boolean isMraid() {
        return this.isMraid;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public boolean isReport() {
        return this.isReport;
    }

    public boolean isReportClick() {
        return this.isReportClick;
    }

    public boolean isSpareOffer(long j10, long j11) {
        if (isEffectiveOffer(j10)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (getPlctb() > 0) {
            return (getPlctb() * 1000) + getTimestamp() >= jCurrentTimeMillis;
        }
        return getTimestamp() + j11 >= jCurrentTimeMillis;
    }

    public boolean isTemplateRenderSucc() {
        return this.isTemplateRenderSucc;
    }

    public boolean needShowIDialog() {
        return super.needShowIDialog(this);
    }

    public void setAabEntity(AabEntity aabEntity) {
        this.aabEntity = aabEntity;
    }

    public void setAc(String str) {
        this.ac = str;
    }

    public void setAc_s(int i10) {
        this.ac_s = i10;
    }

    @Override // com.mbridge.msdk.out.Campaign, com.mbridge.msdk.out.BaseCampaign
    public void setAdCall(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.linkType != 2 ? "Learn more" : "Install";
        }
        super.setAdCall(str);
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setAdSpaceT(int i10) {
        this.adSpaceT = i10;
    }

    public void setAdType(int i10) {
        this.adType = i10;
    }

    public void setAdZip(String str) {
        this.adZip = str;
        boolean zI = ak.i(str);
        int iB = ak.b(str);
        if (zI) {
            setDynamicView(true);
            setDynamicTempCode(iB);
        }
    }

    public void setAd_url_list(String str) {
        this.ad_url_list = str;
    }

    public void setAdchoice(a aVar) {
        this.adchoice = aVar;
    }

    public void setAdvImp(String str) {
        this.advImp = str;
    }

    public void setAks(HashMap<String, String> map) {
        this.aks = map;
    }

    public void setAl(String str) {
        this.al = str;
    }

    public void setAutoShowStoreMiniCard(int i10) {
        this.autoShowStoreMiniCard = i10;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setBty(int i10) {
        this.bty = i10;
    }

    public void setCMPTEntryUrl(String str) {
        this.CMPTEntryUrl = str;
    }

    public void setCacheLevel(int i10) {
        this.cacheLevel = i10;
    }

    public void setCallBackImpression(boolean z9) {
        this.isCallBackImpression = z9;
    }

    public void setCallbacked(boolean z9) {
        this.isCallbacked = z9;
    }

    public void setCampaignIsFiltered(boolean z9) {
        this.campaignIsFiltered = z9;
    }

    public void setCampaignUnitId(String str) {
        this.campaignUnitId = str;
    }

    public void setCanStart2C1Anim(boolean z9) {
        this.canStart2C1Anim = z9;
    }

    public void setCanStartMoreOfferAnim(boolean z9) {
        this.canStartMoreOfferAnim = z9;
    }

    public void setCandidateCacheTime(long j10) {
        this.candidateCacheTime = j10;
    }

    public void setCbd(int i10) {
        this.cbd = i10;
    }

    public void setCbt(int i10) {
        this.cbt = i10;
    }

    public void setClickInterval(int i10) {
        this.clickInterval = i10;
    }

    public void setClickTempSource(int i10) {
        this.clickTempSource = i10;
    }

    public void setClickTimeOutInterval(int i10) {
        this.clickTimeOutInterval = i10;
    }

    public void setClickType(int i10) {
        this.clickType = i10;
    }

    public void setClickURL(String str) {
        this.clickURL = str;
    }

    public void setClick_mode(String str) {
        this.click_mode = str;
    }

    @Override // com.mbridge.msdk.out.Campaign, com.mbridge.msdk.out.BaseCampaign
    public void setCreativeId(long j10) {
        this.creativeId = j10;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public void setDynamicTempCode(int i10) {
        this.dynamicTempCode = ak.a(i10);
    }

    public void setDynamicView(boolean z9) {
        this.isDynamicView = z9;
    }

    public void setECTemplateRenderSucc(boolean z9) {
        this.isECTemplateRenderSucc = z9;
    }

    public void setEcCrtvId(long j10) {
        this.ecCrtvId = j10;
    }

    public void setEcTemplateId(long j10) {
        this.ecTemplateId = j10;
    }

    public void setEcppv(String str) {
        this.ecppv = str;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public void setEndScreenUrl(String str) {
        this.endScreenUrl = str;
    }

    public void setEndcard_click_result(int i10) {
        this.endcard_click_result = i10;
    }

    public void setExpIds(String str) {
        this.expIds = str;
    }

    public void setExt_data(String str) {
        this.ext_data = str;
    }

    public void setFac(int i10) {
        this.fac = i10;
    }

    public void setFca(int i10) {
        this.fca = i10;
    }

    public void setFcb(int i10) {
        this.fcb = i10;
    }

    public void setFilterCallBackState(int i10) {
        if (i10 == 2) {
            i10 = this.retarget_offer == 1 ? 1 : 0;
        }
        this.filterCallBackState = i10;
    }

    public void setFlb(int i10) {
        this.flb = i10;
    }

    public void setFlbSkipTime(int i10) {
        this.flbSkipTime = i10;
    }

    public void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public void setGuidelines(String str) {
        this.guidelines = str;
    }

    public void setHasMBTplMark(boolean z9) {
        this.hasMBTplMark = z9;
    }

    public void setHasReportAdTrackPause(boolean z9) {
        this.hasReportAdTrackPause = z9;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIa_ext1(String str) {
        this.ia_ext1 = str;
    }

    public void setIa_ext2(String str) {
        this.ia_ext2 = str;
    }

    public void setIex(int i10) {
        this.iex = i10;
    }

    public void setImageSize(String str) {
        this.imageSize = str;
    }

    public void setImpReportType(int i10) {
        this.impReportType = i10;
        if (i10 == 1) {
            int i11 = this.adType;
            if (i11 == 296 || i11 == 42) {
                String impressionURL = getImpressionURL();
                String onlyImpressionURL = getOnlyImpressionURL();
                if (!TextUtils.isEmpty(impressionURL) && !impressionURL.contains(JSON_KEY_IMP_REPORT_TYPE)) {
                    setImpressionURL(impressionURL + "&imp_report_type=" + i10);
                }
                if (TextUtils.isEmpty(onlyImpressionURL) || onlyImpressionURL.contains(JSON_KEY_IMP_REPORT_TYPE)) {
                    return;
                }
                setOnlyImpressionURL(onlyImpressionURL + "&imp_report_type=" + i10);
            }
        }
    }

    public void setImpUA(int i10) {
        this.impUA = i10;
    }

    public void setImpressionURL(String str) {
        this.impressionURL = str;
    }

    public void setInteractiveCache(String str) {
        this.interactiveCache = str;
    }

    public void setIsAddSuccesful(int i10) {
        this.isAddSuccesful = i10;
    }

    public void setIsBidCampaign(boolean z9) {
        this.isBidCampaign = z9;
    }

    public void setIsClick(int i10) {
        this.isClick = i10;
    }

    public void setIsDeleted(int i10) {
        this.isDeleted = i10;
    }

    public void setIsDownLoadZip(int i10) {
        this.isDownLoadZip = i10;
    }

    public void setIsMraid(boolean z9) {
        this.isMraid = z9;
    }

    public void setIsTimeoutCheckVideoStatus(int i10) {
        this.isTimeoutCheckVideoStatus = i10;
    }

    public void setJmPd(int i10) {
        this.jmPd = i10;
    }

    public void setJumpResult(JumpLoaderResult jumpLoaderResult) {
        this.jumpResult = jumpLoaderResult;
    }

    public void setK(String str) {
        this.f3487k = str;
    }

    public void setKeyIaIcon(String str) {
        this.keyIaIcon = str;
    }

    public void setKeyIaOri(int i10) {
        this.keyIaOri = i10;
    }

    public void setKeyIaRst(int i10) {
        this.keyIaRst = i10;
    }

    public void setKeyIaUrl(String str) {
        this.keyIaUrl = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLandingType(String str) {
        this.landingType = str;
    }

    public void setLinkType(int i10) {
        this.linkType = i10;
    }

    public void setLoadTimeoutState(int i10) {
        this.loadTimeoutState = i10;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
    }

    public void setMaitve(int i10) {
        this.maitve = i10;
    }

    public void setMaitve_src(String str) {
        this.maitve_src = str;
    }

    public void setMediaViewHolder(b bVar) {
        this.mediaViewHolder = bVar;
    }

    public void setMof_template_url(String str) {
        this.mof_template_url = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCMPTEntryUrl(str);
        boolean zI = ak.i(str);
        int iB = ak.b(str);
        if (zI) {
            setDynamicView(true);
            setDynamicTempCode(iB);
        }
        setCanStart2C1Anim(ak.h(str));
    }

    public void setMof_tplid(int i10) {
        this.mof_tplid = i10;
    }

    public void setMp(String str) {
        this.mp = str;
    }

    public void setMraid(String str) {
        this.mraid = str;
    }

    public void setNLRid(String str) {
        this.n_lrid = str;
    }

    public void setNRid(String str) {
        this.n_rid = str;
    }

    public void setNativeVideoTracking(j jVar) {
        this.nativeVideoTracking = jVar;
    }

    public void setNativeVideoTrackingString(String str) {
        this.nativeVideoTrackingString = str;
    }

    public void setNetAddress(String str) {
        this.netAddress = str;
    }

    public void setNoticeUrl(String str) {
        this.noticeUrl = str;
    }

    public void setNscpt(int i10) {
        this.nscpt = i10;
    }

    public void setNvT2(int i10) {
        this.nvT2 = i10;
    }

    public void setOc_time(int i10) {
        this.oc_time = i10;
    }

    public void setOc_type(int i10) {
        this.oc_type = i10;
    }

    public void setOfferType(int i10) {
        this.offerType = i10;
    }

    public void setOmid(String str) {
        this.omid = str;
    }

    public void setOnlyImpressionURL(String str) {
        Uri uri;
        this.onlyImpressionURL = str;
        try {
            if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
                return;
            }
            String queryParameter = uri.getQueryParameter(URL_KEY_EXP_IDS);
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            setExpIds(queryParameter);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void setPkgSource(String str) {
        this.pkgSource = str;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setPlayable_ads_without_video(int i10) {
        this.playable_ads_without_video = i10;
    }

    public void setPlct(long j10) {
        this.plct = j10;
    }

    public void setPlctb(long j10) {
        this.plctb = j10;
    }

    public void setPrivacyButtonTemplateVisibility(int i10) {
        this.privacyButtonTemplateVisibility = i10;
    }

    public void setPrivacyUrl(String str) {
        this.privacyUrl = str;
    }

    public void setProgressBarShow(int i10) {
        this.progressBarShow = i10;
    }

    public void setPv_urls(List<String> list) {
        this.pv_urls = list;
    }

    public void setQ(String str) {
        this.f3488q = str;
    }

    public void setR(String str) {
        this.f3489r = str;
    }

    public void setReady(boolean z9) {
        this.isReady = z9;
    }

    public void setReadyState(int i10) {
        this.readyState = i10;
    }

    public void setReady_rate(int i10) {
        this.ready_rate = i10;
    }

    public void setReasond(String str) {
        this.reasond = str;
    }

    public void setReport(boolean z9) {
        this.isReport = z9;
    }

    public void setReportClick(boolean z9) {
        this.isReportClick = z9;
    }

    public void setReq_ext_data(String str) {
        this.req_ext_data = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setRequestIdNotice(String str) {
        this.requestIdNotice = str;
    }

    public void setRetarget_offer(int i10) {
        this.retarget_offer = i10;
    }

    public void setRewardAmount(int i10) {
        this.rewardAmount = i10;
    }

    public void setRewardName(String str) {
        this.reward_name = str;
    }

    public void setRewardPlayStatus(int i10) {
        this.rewardPlayStatus = i10;
    }

    public void setRewardPlus(RewardPlus rewardPlus) {
        this.rewardPlus = rewardPlus;
    }

    public void setRewardTemplateMode(c cVar) throws JSONException {
        this.rewardTemplateMode = cVar;
        if (cVar == null || TextUtils.isEmpty(cVar.e())) {
            return;
        }
        if (TextUtils.isEmpty(this.mof_template_url) && cVar.e().contains(KEY_IS_CMPT_ENTRY)) {
            setCMPTEntryUrl(cVar.e());
        }
        boolean zI = ak.i(cVar.e());
        int iB = ak.b(cVar.e());
        if (zI) {
            setDynamicView(true);
            setDynamicTempCode(iB);
        }
        setMoreOfferAdControl(cVar.e(), "template_url");
    }

    public void setRsIgnoreCheckRule(ArrayList<Integer> arrayList) {
        this.rsIgnoreCheckRule = arrayList;
    }

    public void setRsIgnoreCheckRuleByString(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length > 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (String str2 : strArrSplit) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            }
            setRsIgnoreCheckRule(arrayList);
        }
    }

    public void setRtinsType(int i10) {
        this.rtinsType = i10;
    }

    public void setShowCount(int i10) {
        this.showCount = i10;
    }

    public void setShowIndex(int i10) {
        this.showIndex = i10;
    }

    public void setShowStoreMiniCardDelayTime(int i10) {
        this.showStoreMiniCardDelayTime = i10;
    }

    public void setShowType(int i10) {
        this.showType = i10;
    }

    public void setSpareOfferFlag(int i10) {
        this.spareOfferFlag = i10;
    }

    public void setTImp(int i10) {
        this.t_imp = i10;
    }

    public void setT_list(String str) {
        this.t_list = str;
    }

    public void setTab(int i10) {
        this.tab = i10;
    }

    public void setTemplate(int i10) {
        this.template = i10;
    }

    public void setTemplateRenderSucc(boolean z9) {
        this.isTemplateRenderSucc = z9;
    }

    public void setTokenRule(int i10) {
        this.tokenRule = i10;
    }

    public void setTpOffer(int i10) {
        this.tpOffer = i10;
    }

    public void setTrackingTcpPort(int i10) {
        this.trackingTcpPort = i10;
    }

    public void setTriggerClickSource(int i10) {
        this.triggerClickSource = i10;
    }

    public void setTs(long j10) {
        this.ts = j10;
    }

    public void setTyped(int i10) {
        this.typed = i10;
    }

    public void setUseSkipTime(int i10) {
        this.useSkipTime = i10;
    }

    public void setUserActivation(boolean z9) {
        this.userActivation = z9;
    }

    public void setVcn(int i10) {
        this.vcn = i10;
    }

    public void setVidCrtvId(long j10) {
        this.vidCrtvId = j10;
    }

    public void setVideoCheckType(int i10) {
        if (i10 > 2 || i10 < 1) {
            this.videoCheckType = 2;
        } else {
            this.videoCheckType = i10;
        }
    }

    public void setVideoCompleteTime(int i10) {
        this.videoCompleteTime = i10;
    }

    public void setVideoCtnType(int i10) {
        if (i10 > 2 || i10 < 1) {
            this.videoCtnType = 1;
        } else {
            this.videoCtnType = i10;
        }
    }

    public void setVideoMD5Value(String str) {
        this.videoMD5Value = str;
    }

    public void setVideoPlayProgress(int i10) {
        this.videoPlayProgress = i10;
    }

    public void setVideoResolution(String str) {
        this.videoResolution = str;
    }

    public void setVideoSize(int i10) {
        this.videoSize = i10;
    }

    public void setVideoUrlEncode(String str) {
        this.videoUrlEncode = str;
    }

    public void setVideo_end_type(int i10) {
        this.video_end_type = i10;
    }

    public void setVst(int i10) {
        this.vst = i10;
    }

    public void setWatchMile(int i10) {
        this.watchMile = i10;
    }

    public void setWtick(int i10) {
        this.wtick = i10;
    }

    public void setcUA(int i10) {
        this.cUA = i10;
    }

    public void setcVersionCode(long j10) {
        this.cVersionCode = j10;
    }

    public void setendcard_url(String str) throws JSONException {
        c cVar;
        this.endcard_url = str;
        if (TextUtils.isEmpty(this.mof_template_url) && (((cVar = this.rewardTemplateMode) == null || TextUtils.isEmpty(cVar.e)) && !TextUtils.isEmpty(str) && str.contains(KEY_IS_CMPT_ENTRY))) {
            setCMPTEntryUrl(str);
        }
        setCanStartMoreOfferAnim(ak.h(str));
        setMoreOfferAdControl(str, ENDCARD_URL);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private String f3490a = "";

        /* renamed from: b, reason: collision with root package name */
        private String f3491b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f3492c = "";

        /* renamed from: d, reason: collision with root package name */
        private String f3493d = "";
        private String e = "";
        private int f = 0;
        private int g = 0;
        private String h = "";

        /* renamed from: i, reason: collision with root package name */
        private String f3494i = "";

        /* renamed from: j, reason: collision with root package name */
        private String f3495j = "";

        /* renamed from: k, reason: collision with root package name */
        private String f3496k = "";

        private static a a(JSONObject jSONObject) {
            a aVar;
            a aVar2 = null;
            if (jSONObject != null) {
                try {
                    aVar = new a();
                } catch (Exception e) {
                    e = e;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    aVar.f3492c = jSONObject.optString("adchoice_icon");
                    aVar.f3493d = jSONObject.optString("adchoice_link");
                    String strOptString = jSONObject.optString("adchoice_size");
                    aVar.e = strOptString;
                    aVar.f3490a = jSONObject.optString("ad_logo_link");
                    aVar.h = jSONObject.optString("adv_logo");
                    aVar.f3494i = jSONObject.optString("adv_name");
                    aVar.f3495j = jSONObject.optString("platform_logo");
                    aVar.f3496k = jSONObject.optString("platform_name");
                    aVar.f = c(strOptString);
                    aVar.g = d(strOptString);
                    aVar.f3491b = jSONObject.toString();
                    return aVar;
                } catch (Exception e3) {
                    e = e3;
                    aVar2 = aVar;
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                    return aVar2;
                } catch (Throwable th2) {
                    th = th2;
                    aVar2 = aVar;
                    if (MBridgeConstans.DEBUG) {
                        th.printStackTrace();
                    }
                    return aVar2;
                }
            }
            return aVar2;
        }

        private static int c(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (strArrSplit = str.split("x")) != null && strArrSplit.length > 1) {
                    return Integer.parseInt(strArrSplit[1]);
                }
            } catch (NumberFormatException | Exception unused) {
            }
            return 0;
        }

        private static int d(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (strArrSplit = str.split("x")) != null && strArrSplit.length > 0) {
                    return Integer.parseInt(strArrSplit[0]);
                }
            } catch (NumberFormatException | Exception unused) {
            }
            return 0;
        }

        public final String b() {
            return this.f3492c;
        }

        public final int e() {
            return this.f;
        }

        public final int f() {
            return this.g;
        }

        public final void b(String str) {
            this.f3493d = str;
        }

        public final String d() {
            return this.e;
        }

        public final String c() {
            return this.f3493d;
        }

        public static a a(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return a(new JSONObject(str));
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
                return null;
            }
        }

        public final String a() {
            return this.f3491b;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class c implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private List<a> f3505a;

        /* renamed from: b, reason: collision with root package name */
        private int f3506b;

        /* renamed from: c, reason: collision with root package name */
        private String f3507c;

        /* renamed from: d, reason: collision with root package name */
        private String f3508d;
        private String e;
        private int f;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class a implements Serializable {

            /* renamed from: a, reason: collision with root package name */
            public List<String> f3509a = new ArrayList();

            /* renamed from: b, reason: collision with root package name */
            public String f3510b;
        }

        private c(String str) {
            this.f3508d = str;
        }

        public static c a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                if (!ap.b(jSONObject.toString())) {
                    return null;
                }
                c cVar = new c(jSONObject.toString());
                cVar.f = jSONObject.optInt("video_template", 1);
                cVar.e = jSONObject.optString("template_url");
                cVar.f3506b = jSONObject.optInt("orientation");
                cVar.f3507c = jSONObject.optString("paused_url");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("image");
                if (jSONObjectOptJSONObject != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys != null && itKeys.hasNext()) {
                        String next = itKeys.next();
                        List<String> listB = ak.b(jSONObjectOptJSONObject.optJSONArray(next));
                        if (listB != null && listB.size() > 0) {
                            a aVar = new a();
                            aVar.f3510b = next;
                            aVar.f3509a.addAll(listB);
                            arrayList.add(aVar);
                        }
                    }
                    cVar.f3505a = arrayList;
                }
                return cVar;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final int b() {
            return this.f3506b;
        }

        public final String c() {
            return this.f3507c;
        }

        public final String d() {
            return this.f3508d;
        }

        public final String e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }

        public final void b(String str) {
            this.e = str;
        }

        public static c a(String str) {
            try {
                if (ap.b(str)) {
                    return a(new JSONObject(str));
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final List<a> a() {
            return this.f3505a;
        }
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx, boolean z9, boolean z10) throws JSONException {
        JSONObject jSONObjectCampaignToJsonObject = campaignToJsonObject(campaignEx);
        jSONObjectCampaignToJsonObject.put("isReady", z9);
        jSONObjectCampaignToJsonObject.put("expired", z10);
        return jSONObjectCampaignToJsonObject;
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, String str, String str2, String str3, boolean z9, CampaignUnit campaignUnit) {
        return parseCampaign(jSONObject, str, str2, str3, z9, campaignUnit, "", "");
    }
}
