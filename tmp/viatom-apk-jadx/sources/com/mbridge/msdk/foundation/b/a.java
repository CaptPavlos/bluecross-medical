package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static int f3315b = 4;

    /* renamed from: c, reason: collision with root package name */
    private static String f3316c = "BaseCandidateCache";

    /* renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.foundation.db.c f3317a;

    /* renamed from: d, reason: collision with root package name */
    private JSONArray f3318d;
    private JSONObject e;
    private String f;

    /* JADX WARN: Removed duplicated region for block: B:61:0x0187 A[Catch: Exception -> 0x002c, TryCatch #1 {Exception -> 0x002c, blocks: (B:3:0x0011, B:9:0x0031, B:11:0x0069, B:14:0x0079, B:16:0x007f, B:19:0x0086, B:21:0x0091, B:24:0x0098, B:26:0x009e, B:28:0x00a6, B:32:0x0104, B:33:0x0108, B:35:0x0113, B:38:0x0119, B:40:0x011f, B:42:0x012d, B:43:0x0131, B:49:0x0142, B:51:0x0148, B:53:0x0150, B:54:0x0168, B:55:0x016b, B:59:0x017f, B:61:0x0187, B:62:0x018c, B:57:0x0177), top: B:68:0x0011, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r17, int r18, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.b.a.a(int, int, java.util.List, boolean, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    public final String b(String str) throws NumberFormatException {
        c cVarC = c(str);
        if (cVarC != null && cVarC.g() != c.f3330c && cVarC.g() != c.f3328a) {
            String[] strArrSplit = z.a(str.split("_")[3]).split("\\|");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    public final c c(String str) throws NumberFormatException {
        c cVar = new c();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            cVar.d("bid token exception");
            cVar.a(c.f3328a);
            return cVar;
        }
        JSONArray jSONArray = this.f3318d;
        if (jSONArray == null || jSONArray.length() == 0) {
            cVar.d("config is empty");
            cVar.a(c.f3328a);
            return cVar;
        }
        String strA = z.a(str.split("_")[3]);
        if (TextUtils.isEmpty(strA)) {
            cVar.d("bid token exception:decode error");
            cVar.a(c.f3328a);
            return cVar;
        }
        String[] strArrSplit = strA.split("\\|");
        if (strArrSplit.length == 0) {
            cVar.d("bid token can not get bid price");
            cVar.a(c.f3328a);
            return cVar;
        }
        if (strArrSplit.length > 0) {
            try {
                Double.parseDouble(strArrSplit[0]);
            } catch (Exception unused) {
                cVar.d("bid token can not cast bid price");
                cVar.a(c.f3328a);
                return cVar;
            }
        }
        if (TextUtils.isEmpty(this.f)) {
            cVar.d("unitId is empty");
            cVar.a(c.f3330c);
        }
        return cVar;
    }

    public final double d(String str) throws NumberFormatException {
        c cVarC = c(str);
        if (cVarC != null && cVarC.g() != c.f3330c && cVarC.g() != c.f3328a) {
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

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.foundation.b.a$a, reason: collision with other inner class name */
    public static class C0025a {

        /* renamed from: a, reason: collision with root package name */
        private b f3320a;

        /* renamed from: b, reason: collision with root package name */
        private double f3321b;

        public C0025a(double d8, b bVar) {
            this.f3321b = d8;
            this.f3320a = bVar;
        }

        public final b a() {
            return this.f3320a;
        }
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
        this.f3318d = jSONArray;
    }

    public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.c cVar, String str, int i10, String str2, int i11, double d8) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        CampaignEx campaignEx = list.get(i12);
                        campaignEx.setReadyState(0);
                        if (cVar != null) {
                            campaignEx.setNLRid(cVar.f());
                        }
                        campaignEx.setNRid(str);
                        campaignEx.setReasond(str2);
                        campaignEx.setTyped(i10);
                        String strB = z.b(d8 + "");
                        campaignEx.setNoticeUrl(a(campaignEx.getNoticeUrl(), i11, str, strB));
                        campaignEx.setClickURL(a(campaignEx.getClickURL(), i11, str, strB));
                        campaignEx.setImpressionURL(a(campaignEx.getImpressionURL(), i11, str, strB));
                        campaignEx.setOnlyImpressionURL(a(campaignEx.getOnlyImpressionURL(), i11, str, strB));
                        campaignEx.setAdvImp(a(campaignEx.getAdvImpList(), i11, str, strB));
                        j nativeVideoTracking = campaignEx.getNativeVideoTracking();
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
                            campaignEx.setNativeVideoTracking(nativeVideoTracking);
                            campaignEx.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignEx.setPv_urls(b(campaignEx.getPv_urls(), i11, str, strB));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final c a() {
        c cVar = new c();
        try {
            JSONArray jSONArray = this.f3318d;
            if (jSONArray != null && jSONArray.length() != 0) {
                if (this.f3317a == null) {
                    cVar.d("db error");
                    cVar.a(c.f3330c);
                }
                return cVar;
            }
            cVar.d("setting config is null");
            cVar.a(c.f3328a);
            return cVar;
        } catch (Exception unused) {
            cVar.d("checkConfigAndDB exception");
            cVar.a(c.f3330c);
            return cVar;
        }
    }

    public final void a(List<C0025a> list, int i10) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list, new Comparator<C0025a>() { // from class: com.mbridge.msdk.foundation.b.a.1
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(C0025a c0025a, C0025a c0025a2) {
                            return Double.compare(c0025a.f3321b, c0025a2.f3321b);
                        }
                    });
                    int size = list.size() - i10;
                    if (size > 0) {
                        List<C0025a> listSubList = list.subList(0, size);
                        if (this.f3317a == null || listSubList.size() <= 0) {
                            return;
                        }
                        for (int i11 = 0; i11 < listSubList.size(); i11++) {
                            b bVar = listSubList.get(i11).f3320a;
                            this.f3317a.a(this.f, bVar.e(), bVar.d());
                            a(f3315b, 1, null, true, bVar.e(), bVar.d(), -1, this.f);
                        }
                    }
                }
            } catch (Exception e) {
                af.a(f3316c, e);
            }
        }
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

    public final long a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return 0L;
        }
        String ecppv = list.get(0).getEcppv();
        if (TextUtils.isEmpty(ecppv)) {
            return 0L;
        }
        String strA = z.a(ecppv);
        if (TextUtils.isEmpty(strA)) {
            return 0L;
        }
        try {
            if (Double.parseDouble(strA) <= 0.0d) {
                return 0L;
            }
            JSONObject jSONObjectA = a(b(str));
            int iOptInt = jSONObjectA != null ? jSONObjectA.optInt("max_cache_num", 20) : 20;
            com.mbridge.msdk.foundation.db.c cVar = this.f3317a;
            if (cVar == null || iOptInt <= 0) {
                return -1L;
            }
            return cVar.a(list, this.f);
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public final void a(String str, String str2, int i10, String str3) {
        try {
            if (this.f3317a != null && !TextUtils.isEmpty(str3)) {
                if (i10 == 1) {
                    this.f3317a.a(str2, str, this.f, i10);
                    a(f3315b, 3, null, true, str2, str, -1, this.f);
                } else if (i10 == 2) {
                    this.f3317a.a(this.f, str2, str);
                    a(f3315b, 1, null, true, str2, str, -1, this.f);
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    this.f3317a.b(str2, str, this.f);
                    a(f3315b, 4, null, true, str2, str, -1, this.f);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final JSONObject a(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArray = this.f3318d;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() > 1) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (int i10 = 0; i10 < this.f3318d.length(); i10++) {
                try {
                    jSONObjectOptJSONObject = this.f3318d.optJSONObject(i10);
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
        return this.f3318d.optJSONObject(0);
    }

    public final List<b> a(int i10, long j10) throws JSONException {
        a aVar;
        com.mbridge.msdk.foundation.db.c cVar;
        if (i10 < 0 || (cVar = this.f3317a) == null) {
            aVar = this;
        } else {
            cVar.a(this.f, i10);
            aVar = this;
            aVar.a(f3315b, 1, null, true, "", "", i10, this.f);
        }
        com.mbridge.msdk.foundation.db.c cVar2 = aVar.f3317a;
        if (cVar2 != null) {
            return cVar2.a(aVar.f, 0, j10);
        }
        return null;
    }
}
