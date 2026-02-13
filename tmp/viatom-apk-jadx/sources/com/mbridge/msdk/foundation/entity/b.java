package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.out.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {
    public static final String JSON_KEY_ADS = "ads";
    public static final String JSON_KEY_AD_HTML = "cam_html";
    public static final String JSON_KEY_AD_TYPE = "ad_type";
    public static final String JSON_KEY_AD_ZIP = "cam_tpl_url";
    public static final String JSON_KEY_BANNER_HTML = "cam_html";
    public static final String JSON_KEY_BANNER_URL = "cam_tpl_url";
    public static final String JSON_KEY_CSP = "csp";
    public static final String JSON_KEY_C_I = "c_i";
    public static final String JSON_KEY_DO = "do";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_END_SCREEN_URL = "end_screen_url";
    public static final String JSON_KEY_FRAME_ADS = "frames";
    public static final String JSON_KEY_HTML_URL = "html_url";
    public static final String JSON_KEY_IA_EXT1 = "ia_all_ext1";
    public static final String JSON_KEY_IA_EXT2 = "ia_all_ext2";
    public static final String JSON_KEY_IA_ICON = "ia_icon";
    public static final String JSON_KEY_IA_ORI = "ia_ori";
    public static final String JSON_KEY_IA_RST = "ia_rst";
    public static final String JSON_KEY_IA_URL = "ia_url";
    public static final String JSON_KEY_JM_DO = "jm_do";
    public static final String JSON_KEY_MOF_TEMPLATE_URL = "mof_template_url";
    public static final String JSON_KEY_MOF_TPLID = "mof_tplid";
    public static final String JSON_KEY_NSCPT = "nscpt";
    public static final String JSON_KEY_ONLY_IMPRESSION_URL = "only_impression_url";
    public static final String JSON_KEY_PARENT_SESSION_ID = "parent_session_id";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_REPLACE_TMP = "replace_tmp";
    public static final String JSON_KEY_REQ_EXT_DATA = "req_ext_data";
    public static final String JSON_KEY_RKS = "rks";
    public static final String JSON_KEY_SECOND_REQUEST_INDEX = "r_index";
    public static final String JSON_KEY_SECOND_SHOW_INDEX = "s_show_index";
    public static final String JSON_KEY_SESSION_ID = "a";
    public static final String JSON_KEY_SH = "sh";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TK_TCP_PORT = "tk_tcp_port";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_UNIT_SIZE = "unit_size";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String KEY_IRLFA = "irlfa";
    private static final String TAG = "b";
    private String adHtml;
    private int adType;
    private String adZip;
    public ArrayList<CampaignEx> ads;
    private String bannerHtml;
    private String bannerUrl;
    private String csp;
    private String domain;
    private double ecppv;
    private HashMap<String, String> epMap;
    private String htmlUrl;
    private String ia_all_ext1;
    private String ia_all_ext2;
    private String ia_icon;
    private int ia_ori;
    private int ia_rst;
    private String ia_url;
    private int jmDo;
    private List<Frame> listFrames;
    private String localRequestId;
    private com.mbridge.msdk.foundation.same.report.d.c metricsData;
    private String onlyImpressionUrl;
    private String parentSessionId;
    private String requestId;
    private HashMap<String, String> rks;
    private String sessionId;
    private String sh;
    private int template;
    private int tokenRule;
    private String unitSize;
    private int vcn;
    protected StringBuffer cParams = new StringBuffer();
    private String encryptPrice = "";
    private String msg = "";
    private int activitySwitch = 1;
    private int secondRequestIndex = 0;
    private int secondShowIndex = 0;

    private static void getSysIDAndBKUPID(JSONObject jSONObject) {
        FastKV fastKVBuild;
        com.mbridge.msdk.foundation.controller.d.a();
        try {
            fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), z.a("H+tU+FeXHM==")).build();
        } catch (Exception unused) {
            fastKVBuild = null;
        }
        if (fastKVBuild != null) {
            try {
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                if (jSONObject == null || contextC == null) {
                    return;
                }
                String strOptString = jSONObject.optString("b");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, strOptString)) {
                    com.mbridge.msdk.foundation.same.a.V = strOptString;
                    com.mbridge.msdk.foundation.a.a.a.a().a("b", com.mbridge.msdk.foundation.same.a.V);
                    try {
                        fastKVBuild.putString(z.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    } catch (Exception unused2) {
                    }
                }
                String strOptString2 = jSONObject.optString("c");
                if (TextUtils.isEmpty(strOptString2) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, strOptString2)) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.g = strOptString2;
                com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.g);
                try {
                    fastKVBuild.putString(z.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
            if (jSONObject == null || contextC2 == null) {
                return;
            }
            String strOptString3 = jSONObject.optString("b");
            if (!TextUtils.isEmpty(strOptString3) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, strOptString3)) {
                com.mbridge.msdk.foundation.same.a.V = strOptString3;
                com.mbridge.msdk.foundation.a.a.a.a().a("b", com.mbridge.msdk.foundation.same.a.V);
                SharedPreferences sharedPreferences = contextC2.getSharedPreferences(z.a("H+tU+FeXHM=="), 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString(z.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    editorEdit.apply();
                }
            }
            String strOptString4 = jSONObject.optString("c");
            if (TextUtils.isEmpty(strOptString4) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, strOptString4)) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.g = strOptString4;
            com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.g);
            SharedPreferences sharedPreferences2 = contextC2.getSharedPreferences(z.a("H+tU+FeXHM=="), 0);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                editorEdit2.putString(z.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                editorEdit2.apply();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject, String str) throws JSONException {
        String strOptString;
        ArrayList arrayList;
        int i10;
        String str2;
        int i11;
        ArrayList arrayList2;
        String str3;
        int i12;
        String str4 = JSON_KEY_ADS;
        String str5 = "a";
        String str6 = CampaignEx.JSON_KEY_ECPPV;
        String str7 = JSON_KEY_ONLY_IMPRESSION_URL;
        String str8 = JSON_KEY_HTML_URL;
        if (jSONObject == null) {
            return null;
        }
        try {
            CampaignUnit campaignUnit = new CampaignUnit();
            try {
                String strOptString2 = jSONObject.optString(JSON_KEY_RKS);
                if (TextUtils.isEmpty(strOptString2)) {
                    arrayList = null;
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(strOptString2);
                        Iterator<String> itKeys = jSONObject2.keys();
                        HashMap map = new HashMap();
                        while (itKeys != null && itKeys.hasNext()) {
                            String next = itKeys.next();
                            map.put(next, jSONObject2.optString(next));
                        }
                        arrayList = null;
                        campaignUnit.setRks(map);
                    } catch (Exception unused) {
                        return campaignUnit;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    HashMap map2 = new HashMap();
                    map2.put("encrypt_p", "");
                    map2.put(KEY_IRLFA, "");
                    campaignUnit.setEpMap(map2);
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(JSON_KEY_REQ_EXT_DATA);
                int iOptInt = jSONObject.optInt(JSON_KEY_NSCPT, 1);
                String strOptString3 = jSONObject.optString(JSON_KEY_MOF_TEMPLATE_URL, "");
                int iOptInt2 = jSONObject.optInt(JSON_KEY_MOF_TPLID, 0);
                String string = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : "";
                new JSONArray();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pv_urls");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    i10 = iOptInt2;
                    str2 = "";
                    i11 = iOptInt;
                    arrayList2 = arrayList;
                } else {
                    i11 = iOptInt;
                    i10 = iOptInt2;
                    ArrayList arrayList3 = new ArrayList(jSONArrayOptJSONArray.length());
                    str2 = "";
                    for (int i13 = 0; i13 < jSONArrayOptJSONArray.length(); i13++) {
                        arrayList3.add(jSONArrayOptJSONArray.getString(i13));
                    }
                    arrayList2 = arrayList3;
                }
                com.mbridge.msdk.foundation.db.a.b.a().a(jSONObject.optJSONObject(JSON_KEY_REPLACE_TMP), true);
                getSysIDAndBKUPID(jSONObject);
                campaignUnit.setSessionId(jSONObject.optString("a"));
                campaignUnit.setParentSessionId(jSONObject.optString(JSON_KEY_PARENT_SESSION_ID));
                campaignUnit.setAdType(jSONObject.optInt("ad_type"));
                campaignUnit.setUnitSize(jSONObject.optString(JSON_KEY_UNIT_SIZE));
                campaignUnit.setHtmlUrl(jSONObject.optString(JSON_KEY_HTML_URL));
                campaignUnit.setOnlyImpressionUrl(jSONObject.optString(JSON_KEY_ONLY_IMPRESSION_URL));
                campaignUnit.setActivitySwitch(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH));
                campaignUnit.setEcppv(jSONObject.optDouble(CampaignEx.JSON_KEY_ECPPV));
                campaignUnit.setTemplate(jSONObject.optInt("template"));
                campaignUnit.setJmDo(jSONObject.optInt(JSON_KEY_JM_DO));
                campaignUnit.setIa_icon(jSONObject.optString("ia_icon"));
                campaignUnit.setIa_rst(jSONObject.optInt("ia_rst"));
                campaignUnit.setIa_url(jSONObject.optString("ia_url"));
                campaignUnit.setIa_ori(jSONObject.optInt("ia_ori"));
                campaignUnit.setIa_all_ext1(jSONObject.optString(JSON_KEY_IA_EXT1));
                campaignUnit.setIa_all_ext2(jSONObject.optString(JSON_KEY_IA_EXT2));
                campaignUnit.setVcn(jSONObject.optInt("vcn"));
                campaignUnit.setTokenRule(jSONObject.optInt("token_r"));
                campaignUnit.setEncryptPrice(jSONObject.optString("encrypt_p"));
                campaignUnit.setSecondRequestIndex(jSONObject.optInt(JSON_KEY_SECOND_REQUEST_INDEX, 0));
                campaignUnit.setSecondShowIndex(jSONObject.optInt(JSON_KEY_SECOND_SHOW_INDEX, 0));
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(JSON_KEY_ADS);
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(JSON_KEY_FRAME_ADS);
                strOptString = jSONObject.optString(JSON_KEY_C_I, str2);
                v.a().a(strOptString);
                String str9 = "web env is not support";
                String str10 = JSON_KEY_END_SCREEN_URL;
                try {
                    try {
                        if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) {
                            String str11 = CampaignEx.JSON_KEY_ECPPV;
                            String str12 = JSON_KEY_ONLY_IMPRESSION_URL;
                            String str13 = JSON_KEY_HTML_URL;
                            String str14 = JSON_KEY_END_SCREEN_URL;
                            String str15 = string;
                            int i14 = i11;
                            int i15 = i10;
                            CampaignUnit campaignUnit2 = campaignUnit;
                            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                                ArrayList<CampaignEx> arrayList4 = new ArrayList<>();
                                int i16 = 0;
                                while (i16 < jSONArrayOptJSONArray2.length()) {
                                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i16);
                                    JSONArray jSONArray = jSONArrayOptJSONArray2;
                                    String str16 = str12;
                                    String strOptString4 = jSONObject.optString(str16);
                                    CampaignUnit campaignUnit3 = campaignUnit2;
                                    String str17 = str15;
                                    String str18 = str13;
                                    try {
                                        String strOptString5 = jSONObject.optString(str18);
                                        int i17 = i15;
                                        str13 = str18;
                                        String str19 = str14;
                                        String strOptString6 = jSONObject.optString(str19);
                                        String str20 = str11;
                                        str11 = str20;
                                        int i18 = i16;
                                        CampaignEx campaign = CampaignEx.parseCampaign(jSONObjectOptJSONObject2, strOptString4, strOptString5, strOptString6, false, campaignUnit3, str, jSONObject.optString(str20));
                                        campaignUnit2 = campaignUnit3;
                                        if (campaign != null) {
                                            campaign.setNetAddress(strOptString);
                                            campaign.setMof_tplid(i17);
                                            campaign.setMof_template_url(strOptString3);
                                            campaign.setNscpt(i14);
                                            campaign.setPv_urls(arrayList2);
                                            campaign.setReq_ext_data(str17);
                                            campaign.setVcn(campaignUnit2.getVcn());
                                            campaign.setTokenRule(campaignUnit2.getTokenRule());
                                            campaign.setEncryptPrice(campaignUnit2.getEncryptPrice());
                                            campaign.setAc_s(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, 1));
                                            arrayList4.add(campaign);
                                        } else {
                                            campaignUnit2.setMsg(str9);
                                        }
                                        str15 = str17;
                                        str12 = str16;
                                        i15 = i17;
                                        i16 = i18 + 1;
                                        jSONArrayOptJSONArray2 = jSONArray;
                                        str14 = str19;
                                    } catch (Exception unused2) {
                                        strOptString = campaignUnit3;
                                    }
                                }
                                campaignUnit2.setAds(arrayList4);
                            }
                            return campaignUnit2;
                        }
                        ArrayList arrayList5 = new ArrayList();
                        String str21 = "template";
                        String str22 = campaignUnit;
                        int i19 = 0;
                        while (i19 < jSONArrayOptJSONArray3.length()) {
                            try {
                                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i19);
                                int i20 = i19;
                                JSONArray jSONArray2 = jSONObjectOptJSONObject3.getJSONArray(str4);
                                String str23 = str4;
                                ArrayList arrayList6 = new ArrayList();
                                String str24 = str5;
                                JSONObject jSONObject3 = jSONObjectOptJSONObject3;
                                int i21 = 0;
                                while (i21 < jSONArray2.length()) {
                                    JSONObject jSONObjectOptJSONObject4 = jSONArray2.optJSONObject(i21);
                                    ArrayList arrayList7 = arrayList5;
                                    String strOptString7 = jSONObject.optString(str7);
                                    String str25 = strOptString;
                                    String strOptString8 = jSONObject.optString(str8);
                                    JSONArray jSONArray3 = jSONArrayOptJSONArray3;
                                    String str26 = str10;
                                    String str27 = strOptString3;
                                    JSONArray jSONArray4 = jSONArray2;
                                    int i22 = i11;
                                    int i23 = i21;
                                    JSONObject jSONObject4 = jSONObject3;
                                    String str28 = str8;
                                    String str29 = str9;
                                    CampaignUnit campaignUnit4 = str22;
                                    String str30 = str6;
                                    String str31 = str7;
                                    CampaignEx campaign2 = CampaignEx.parseCampaign(jSONObjectOptJSONObject4, strOptString7, strOptString8, jSONObject.optString(str10), false, campaignUnit4, str, jSONObject.optString(str6));
                                    if (campaign2 != null) {
                                        campaign2.setNetAddress(str25);
                                        campaign2.setKeyIaUrl(campaignUnit4.getIa_url());
                                        campaign2.setKeyIaOri(campaignUnit4.getIa_ori());
                                        campaign2.setKeyIaRst(campaignUnit4.getIa_rst());
                                        campaign2.setKeyIaIcon(campaignUnit4.getIa_icon());
                                        campaign2.setAdType(jSONObject.optInt("ad_type"));
                                        campaign2.setIa_ext1(jSONObject.optString(CampaignEx.KEY_IA_EXT1));
                                        campaign2.setIa_ext2(jSONObject.optString(CampaignEx.KEY_IA_EXT2));
                                        campaign2.setAc_s(jSONObject.optInt(CampaignEx.KEY_ACTIVITY_CHECK_SWITCH, 1));
                                        campaign2.setVcn(campaignUnit4.getVcn());
                                        campaign2.setTokenRule(campaignUnit4.getTokenRule());
                                        campaign2.setEncryptPrice(campaignUnit4.getEncryptPrice());
                                        i12 = i10;
                                        campaign2.setMof_tplid(i12);
                                        campaign2.setMof_template_url(str27);
                                        campaign2.setNscpt(i22);
                                        campaign2.setPv_urls(arrayList2);
                                        str3 = string;
                                        campaign2.setReq_ext_data(str3);
                                        arrayList6.add(campaign2);
                                    } else {
                                        str3 = string;
                                        i12 = i10;
                                        campaignUnit4.setMsg(str29);
                                    }
                                    int i24 = i23 + 1;
                                    strOptString = str25;
                                    str6 = str30;
                                    str22 = campaignUnit4;
                                    i11 = i22;
                                    str9 = str29;
                                    i10 = i12;
                                    string = str3;
                                    jSONArray2 = jSONArray4;
                                    str8 = str28;
                                    str7 = str31;
                                    arrayList5 = arrayList7;
                                    jSONArrayOptJSONArray3 = jSONArray3;
                                    jSONObject3 = jSONObject4;
                                    str10 = str26;
                                    strOptString3 = str27;
                                    i21 = i24;
                                }
                                ArrayList arrayList8 = arrayList5;
                                Frame frame = new Frame();
                                frame.setParentSessionId(jSONObject.optString(JSON_KEY_PARENT_SESSION_ID));
                                frame.setSessionId(jSONObject.optString(str24));
                                frame.setCampaigns(arrayList6);
                                String str32 = str21;
                                frame.setTemplate(jSONObject3.optInt(str32));
                                arrayList8.add(frame);
                                strOptString = strOptString;
                                str6 = str6;
                                str22 = str22;
                                str21 = str32;
                                i11 = i11;
                                strOptString3 = strOptString3;
                                str9 = str9;
                                i19 = i20 + 1;
                                str5 = str24;
                                i10 = i10;
                                string = string;
                                str4 = str23;
                                str8 = str8;
                                jSONArrayOptJSONArray3 = jSONArrayOptJSONArray3;
                                str10 = str10;
                                arrayList5 = arrayList8;
                                str7 = str7;
                            } catch (Exception unused3) {
                                strOptString = str22;
                            }
                        }
                        CampaignUnit campaignUnit5 = str22;
                        campaignUnit5.setListFrames(arrayList5);
                        return campaignUnit5;
                    } catch (Exception unused4) {
                    }
                } catch (Exception unused5) {
                    strOptString = str9;
                }
            } catch (Exception unused6) {
                strOptString = campaignUnit;
            }
            return strOptString;
        } catch (Exception unused7) {
            return null;
        }
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject) {
        return parseV5CampaignUnit(jSONObject, "");
    }

    public abstract String assembCParams();

    public int getActivitySwitch() {
        return this.activitySwitch;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public ArrayList<CampaignEx> getAds() {
        return this.ads;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getCsp() {
        return this.csp;
    }

    public String getDomain() {
        return this.domain;
    }

    public double getEcppv() {
        return this.ecppv;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public HashMap<String, String> getEpMap() {
        return this.epMap;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getIa_all_ext1() {
        return this.ia_all_ext1;
    }

    public String getIa_all_ext2() {
        return this.ia_all_ext2;
    }

    public String getIa_icon() {
        return this.ia_icon;
    }

    public int getIa_ori() {
        return this.ia_ori;
    }

    public int getIa_rst() {
        return this.ia_rst;
    }

    public String getIa_url() {
        return this.ia_url;
    }

    public int getJmDo() {
        return this.jmDo;
    }

    public List<Frame> getListFrames() {
        return this.listFrames;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public com.mbridge.msdk.foundation.same.report.d.c getMetricsData() {
        return this.metricsData;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getOnlyImpressionUrl() {
        return this.onlyImpressionUrl;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionUrl)) {
                return "";
            }
            Uri uri = Uri.parse(this.onlyImpressionUrl);
            if (uri != null) {
                this.requestId = uri.getQueryParameter(CampaignEx.JSON_KEY_AD_K);
            }
            return this.requestId;
        } catch (Exception unused) {
            return "";
        }
    }

    public HashMap<String, String> getRks() {
        return this.rks;
    }

    public int getSecondRequestIndex() {
        return this.secondRequestIndex;
    }

    public int getSecondShowIndex() {
        return this.secondShowIndex;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSh() {
        return this.sh;
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

    public String getUnitSize() {
        return this.unitSize;
    }

    public int getVcn() {
        int i10 = this.vcn;
        if (i10 > 1) {
            return i10;
        }
        return 1;
    }

    public Object nullToEmpty(Object obj) {
        return obj == null ? "" : obj;
    }

    public void setActivitySwitch(int i10) {
        this.activitySwitch = i10;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setAdType(int i10) {
        this.adType = i10;
    }

    public void setAdZip(String str) {
        this.adZip = str;
    }

    public void setAds(ArrayList<CampaignEx> arrayList) {
        this.ads = arrayList;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setCsp(String str) {
        this.csp = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setEcppv(double d8) {
        this.ecppv = d8;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public void setEpMap(HashMap<String, String> map) {
        this.epMap = map;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIa_all_ext1(String str) {
        this.ia_all_ext1 = str;
    }

    public void setIa_all_ext2(String str) {
        this.ia_all_ext2 = str;
    }

    public void setIa_icon(String str) {
        this.ia_icon = str;
    }

    public void setIa_ori(int i10) {
        this.ia_ori = i10;
    }

    public void setIa_rst(int i10) {
        this.ia_rst = i10;
    }

    public void setIa_url(String str) {
        this.ia_url = str;
    }

    public void setJmDo(int i10) {
        this.jmDo = i10;
    }

    public void setListFrames(List<Frame> list) {
        this.listFrames = list;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
        ArrayList<CampaignEx> ads = getAds();
        int size = ads.size();
        int i10 = 0;
        while (i10 < size) {
            CampaignEx campaignEx = ads.get(i10);
            i10++;
            campaignEx.setLocalRequestId(str);
        }
    }

    public void setMetricsData(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        this.metricsData = cVar;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setOnlyImpressionUrl(String str) {
        this.onlyImpressionUrl = str;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public void setRks(HashMap<String, String> map) {
        this.rks = map;
    }

    public void setSecondRequestIndex(int i10) {
        this.secondRequestIndex = i10;
    }

    public void setSecondShowIndex(int i10) {
        this.secondShowIndex = i10;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSh(String str) {
        this.sh = str;
    }

    public void setTemplate(int i10) {
        this.template = i10;
    }

    public void setTokenRule(int i10) {
        this.tokenRule = i10;
    }

    public void setUnitSize(String str) {
        this.unitSize = str;
    }

    public void setVcn(int i10) {
        this.vcn = i10;
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject, String str) {
        return parseCampaignUnit(jSONObject, str);
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject) {
        return parseCampaignUnit(jSONObject, "");
    }
}
