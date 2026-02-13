package com.mbridge.msdk.newreward.function.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f4636a = 4;

    /* renamed from: b, reason: collision with root package name */
    public static int f4637b = 5;

    /* renamed from: c, reason: collision with root package name */
    private static String f4638c = "BaseCandidateCache";

    /* renamed from: d, reason: collision with root package name */
    private JSONArray f4639d;
    private JSONObject e;
    private String f;
    private int g;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private e f4640i;

    /* renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.c f4641j;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.a.a$a, reason: collision with other inner class name */
    public static class C0042a {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.newreward.function.c.a.b f4643a;

        /* renamed from: b, reason: collision with root package name */
        private double f4644b;

        public C0042a(double d8, com.mbridge.msdk.newreward.function.c.a.b bVar) {
            this.f4644b = d8;
            this.f4643a = bVar;
        }

        public final com.mbridge.msdk.newreward.function.c.a.b a() {
            return this.f4643a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0197 A[Catch: Exception -> 0x0028, TryCatch #3 {Exception -> 0x0028, blocks: (B:3:0x000d, B:9:0x002d, B:11:0x0067, B:14:0x0077, B:16:0x007d, B:18:0x0098, B:21:0x009f, B:23:0x00a5, B:25:0x00ad, B:27:0x00d2, B:33:0x010e, B:36:0x011f, B:40:0x0128, B:42:0x012e, B:44:0x013c, B:45:0x0140, B:52:0x0152, B:54:0x0158, B:56:0x0160, B:57:0x0178, B:58:0x017b, B:62:0x018f, B:64:0x0197, B:65:0x019c, B:60:0x0187, B:34:0x0113), top: B:75:0x000d }] */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v12 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(int r17, int r18, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.a.a.a(int, int, java.util.List, boolean, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    public final String b(String str) throws NumberFormatException {
        b bVarC = c(str);
        if (bVarC != null && bVarC.h() != com.mbridge.msdk.foundation.b.c.f3330c && bVarC.h() != com.mbridge.msdk.foundation.b.c.f3328a) {
            String[] strArrSplit = z.a(str.split("_")[3]).split("\\|");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    public final b c(String str) throws NumberFormatException {
        b bVar = new b();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            bVar.d("bid token exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f3328a);
            return bVar;
        }
        JSONArray jSONArray = this.f4639d;
        if (jSONArray == null || jSONArray.length() == 0) {
            bVar.d("config is empty");
            bVar.a(com.mbridge.msdk.foundation.b.c.f3328a);
            return bVar;
        }
        String strA = z.a(str.split("_")[3]);
        if (TextUtils.isEmpty(strA)) {
            bVar.d("bid token exception:decode error");
            bVar.a(com.mbridge.msdk.foundation.b.c.f3328a);
            return bVar;
        }
        String[] strArrSplit = strA.split("\\|");
        if (strArrSplit.length == 0) {
            bVar.d("bid token can not get bid price");
            bVar.a(com.mbridge.msdk.foundation.b.c.f3328a);
            return bVar;
        }
        if (strArrSplit.length > 0) {
            try {
                Double.parseDouble(strArrSplit[0]);
            } catch (Exception unused) {
                bVar.d("bid token can not cast bid price");
                bVar.a(com.mbridge.msdk.foundation.b.c.f3328a);
                return bVar;
            }
        }
        if (TextUtils.isEmpty(this.f)) {
            bVar.d("unitId is empty");
            bVar.a(com.mbridge.msdk.foundation.b.c.f3330c);
        }
        return bVar;
    }

    public final double d(String str) throws NumberFormatException {
        b bVarC = c(str);
        if (bVarC != null && bVarC.h() != com.mbridge.msdk.foundation.b.c.f3330c && bVarC.h() != com.mbridge.msdk.foundation.b.c.f3328a) {
            try {
                String[] strArrSplit = z.a(str.split("_")[3]).split("\\|");
                if (strArrSplit.length > 0) {
                    return Double.parseDouble(strArrSplit[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1.0d;
    }

    public final void e(String str) {
        this.f = str;
    }

    public final void f(String str) {
        this.h = str;
    }

    private List<String> b(List<String> list, int i10, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(a(list.get(i11), i10, str, str2));
        }
        return arrayList;
    }

    public final void a(JSONArray jSONArray) {
        this.f4639d = jSONArray;
    }

    public final void a(List<com.mbridge.msdk.newreward.function.c.a.a> list, com.mbridge.msdk.foundation.same.report.d.c cVar, String str, int i10, String str2, int i11, double d8) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        CampaignEx campaignExH = list.get(i12).h();
                        campaignExH.setReadyState(0);
                        if (cVar != null) {
                            campaignExH.setNLRid(cVar.f());
                        }
                        campaignExH.setNRid(str);
                        campaignExH.setReasond(str2);
                        campaignExH.setTyped(i10);
                        String strB = z.b(d8 + "");
                        campaignExH.setNoticeUrl(a(campaignExH.getNoticeUrl(), i11, str, strB));
                        campaignExH.setClickURL(a(campaignExH.getClickURL(), i11, str, strB));
                        campaignExH.setImpressionURL(a(campaignExH.getImpressionURL(), i11, str, strB));
                        campaignExH.setOnlyImpressionURL(a(campaignExH.getOnlyImpressionURL(), i11, str, strB));
                        campaignExH.setAdvImp(a(campaignExH.getAdvImpList(), i11, str, strB));
                        j nativeVideoTracking = campaignExH.getNativeVideoTracking();
                        if (nativeVideoTracking != null) {
                            nativeVideoTracking.k(a(nativeVideoTracking.l(), i11, str, strB));
                            nativeVideoTracking.c(a(nativeVideoTracking.c(), i11, str, strB));
                            nativeVideoTracking.o(a(nativeVideoTracking.p(), i11, str, strB));
                            nativeVideoTracking.s(a(nativeVideoTracking.t(), i11, str, strB));
                            nativeVideoTracking.a(a(nativeVideoTracking.a(), i11, str, strB));
                            nativeVideoTracking.b(a(nativeVideoTracking.b(), i11, str, strB));
                            nativeVideoTracking.r(a(nativeVideoTracking.s(), i11, str, strB));
                            nativeVideoTracking.u(a(nativeVideoTracking.v(), i11, str, strB));
                            nativeVideoTracking.t(a(nativeVideoTracking.v(), i11, str, strB));
                            nativeVideoTracking.v(a(nativeVideoTracking.w(), i11, str, strB));
                            nativeVideoTracking.h(a(nativeVideoTracking.h(), i11, str, strB));
                            nativeVideoTracking.p(a(nativeVideoTracking.q(), i11, str, strB));
                            nativeVideoTracking.q(a(nativeVideoTracking.r(), i11, str, strB));
                            nativeVideoTracking.n(a(nativeVideoTracking.o(), i11, str, strB));
                            nativeVideoTracking.e(a(nativeVideoTracking.e(), i11, str, strB));
                            nativeVideoTracking.f(a(nativeVideoTracking.f(), i11, str, strB));
                            nativeVideoTracking.g(a(nativeVideoTracking.g(), i11, str, strB));
                            nativeVideoTracking.i(a(nativeVideoTracking.j(), i11, str, strB));
                            nativeVideoTracking.j(a(nativeVideoTracking.k(), i11, str, strB));
                            nativeVideoTracking.l(a(nativeVideoTracking.m(), i11, str, strB));
                            nativeVideoTracking.a(a(nativeVideoTracking.i(), i11, str, strB));
                            nativeVideoTracking.d(a(nativeVideoTracking.d(), i11, str, strB));
                            nativeVideoTracking.m(a(nativeVideoTracking.n(), i11, str, strB));
                            campaignExH.setNativeVideoTracking(nativeVideoTracking);
                            campaignExH.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignExH.setPv_urls(b(campaignExH.getPv_urls(), i11, str, strB));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final b a() {
        b bVar = new b();
        try {
            JSONArray jSONArray = this.f4639d;
            if (jSONArray != null && jSONArray.length() != 0) {
                return bVar;
            }
            bVar.d("setting config is null");
            bVar.a(com.mbridge.msdk.foundation.b.c.f3328a);
            return bVar;
        } catch (Exception unused) {
            bVar.d("checkConfigAndDB exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f3330c);
            return bVar;
        }
    }

    public final List<com.mbridge.msdk.newreward.function.c.a.b> a(int i10, int i11, String str) {
        return com.mbridge.msdk.newreward.function.d.c.a().b().a(i11, str, this.f, true, 0, "");
    }

    private String a(String str, int i10, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.contains("ca_sce") || str.contains("real_rid") || str.contains("real_bp")) {
            return str;
        }
        if (aq.c(str) > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("&ca_sce=");
            sb.append(i10);
            sb.append("&real_rid=");
            sb.append(str2);
            return a3.a.o(sb, "&real_bp=", str3);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("?ca_sce=");
        sb2.append(i10);
        sb2.append("&real_rid=");
        sb2.append(str2);
        return a3.a.o(sb2, "&real_bp=", str3);
    }

    private String a(Map<Integer, String> map, int i10, String str, String str2) throws JSONException {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                String value = entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_AD_IMP_KEY, entry.getKey());
                jSONObject.put("url", a(value, i10, str, str2));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private String[] a(String[] strArr, int i10, String str, String str2) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            strArr2[i11] = a(strArr[i11], i10, str, str2);
        }
        return strArr2;
    }

    private List<Map<Integer, String>> a(List<Map<Integer, String>> list, int i10, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            Map<Integer, String> map = list.get(i11);
            if (map != null && map.size() > 0) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    map.put(entry.getKey(), a(entry.getValue(), i10, str, str2));
                }
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    public final void a(int i10) {
        this.g = i10;
    }

    public final void a(e eVar) {
        this.f4640i = eVar;
    }

    public final void a(com.mbridge.msdk.newreward.function.command.c cVar) {
        this.f4641j = cVar;
    }

    public final void a(String str, String str2, int i10, double d8) {
        if (d8 == 0.0d) {
            return;
        }
        try {
            if (i10 == 1) {
                a(f4636a, 3, null, true, str2, str, -1, this.f);
            } else if (i10 == 2) {
                a(f4636a, 1, null, true, str2, str, -1, this.f);
            } else {
                if (i10 != 3) {
                    return;
                }
                a(f4636a, 4, null, true, str2, str, -1, this.f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final JSONObject a(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArray = this.f4639d;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() > 1) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (int i10 = 0; i10 < this.f4639d.length(); i10++) {
                try {
                    jSONObjectOptJSONObject = this.f4639d.optJSONObject(i10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.getString("g"))) {
                    this.e = jSONObjectOptJSONObject;
                    return jSONObjectOptJSONObject;
                }
            }
            return null;
        }
        return this.f4639d.optJSONObject(0);
    }
}
