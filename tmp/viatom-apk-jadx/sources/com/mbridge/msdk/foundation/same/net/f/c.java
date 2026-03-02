package com.mbridge.msdk.foundation.same.net.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.CustomInfoManager;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.j;
import com.mbridge.msdk.tracker.network.l;
import com.mbridge.msdk.tracker.network.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c {
    private static final String TAG = "c";
    protected Context mContext;

    public c(Context context) {
        if (context == null) {
            this.mContext = com.mbridge.msdk.foundation.controller.c.m().c();
        } else {
            this.mContext = context.getApplicationContext();
        }
    }

    private String asUrlParams(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        sb.append("&");
                        sb.append(str);
                        sb.append("=");
                        sb.append(str2);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, e.getMessage());
                }
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    private static com.mbridge.msdk.tracker.network.i<?> createRequest(int i10, int i11, String str, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j10) {
        if (i10 == 0) {
            return new l(i11, str, str2, j10, new i(bVar));
        }
        if (i10 != 1) {
            return null;
        }
        return new j(i11, str, str2, j10, new i(bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[Catch: Exception -> 0x00c3, TRY_ENTER, TryCatch #1 {Exception -> 0x00c3, blocks: (B:31:0x0097, B:33:0x009d, B:37:0x00a8, B:43:0x00cb, B:45:0x00e8), top: B:84:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018c  */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.mbridge.msdk.tracker.network.i, com.mbridge.msdk.tracker.network.u] */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.mbridge.msdk.tracker.network.v] */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x018a -> B:83:0x01e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x01ca -> B:83:0x01e3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void post(int r11, java.lang.String r12, com.mbridge.msdk.foundation.same.net.f.e r13, com.mbridge.msdk.foundation.same.net.b r14, boolean r15, boolean r16, java.lang.String r17, long r18) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.f.c.post(int, java.lang.String, com.mbridge.msdk.foundation.same.net.f.e, com.mbridge.msdk.foundation.same.net.b, boolean, boolean, java.lang.String, long):void");
    }

    public void addExtraParams(String str, e eVar) {
        if (eVar == null) {
            af.b(TAG, "addExtraParams error, params is null,frame work error");
            return;
        }
        String strA = Aa.a();
        if (strA == null) {
            strA = "";
        }
        eVar.a("channel", strA);
        eVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.a().b() + "");
        eVar.a("open", com.mbridge.msdk.foundation.same.a.S);
        if (com.mbridge.msdk.e.b.a() && !TextUtils.isEmpty(str) && str.contains("setting")) {
            String strB = Aa.b();
            if (!TextUtils.isEmpty(strB)) {
                eVar.a("keyword", strB);
            }
        }
        String str2 = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (str2 != null) {
            String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str2, str);
            if (!TextUtils.isEmpty(customInfoByUnitId)) {
                eVar.a("ch_info", customInfoByUnitId);
            }
            k kVarD = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), str2);
            if (kVarD != null && !TextUtils.isEmpty(kVarD.a())) {
                eVar.a("u_stid", kVarD.a());
            }
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
            eVar.a("dev_source", "2");
        }
        if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
            eVar.a("re_domain", "1");
        }
    }

    public boolean canTrack() {
        return true;
    }

    public void choiceV3OrV5BySetting(int i10, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str, long j10) {
        e eVar2;
        com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        int iAs = TextUtils.isEmpty(str) ? gVarA.as() : gVarA.I();
        String strA = com.mbridge.msdk.foundation.same.net.e.d.f().a(str, iAs);
        if (iAs < 2) {
            postV5(i10, strA, eVar, bVar, "campaign", j10);
            return;
        }
        if (iAs % 2 == 0) {
            if (eVar == null) {
                eVar = new e();
            }
            eVar2 = eVar;
            JSONArray jSONArrayB = com.mbridge.msdk.foundation.db.a.b.a().b();
            if (jSONArrayB != null) {
                String string = jSONArrayB.toString();
                int iD = com.mbridge.msdk.foundation.same.net.e.d.f().d();
                if (iD > 0 && string.length() > iD) {
                    post(i10, strA, eVar2, bVar, "campaign", j10);
                    return;
                }
                eVar2.a(e.h, string);
            }
        } else {
            eVar2 = eVar;
        }
        getLoadOrSetting(i10, strA, eVar2, bVar, "campaign", j10);
    }

    public void get(int i10, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z9, boolean z10, String str2, long j10) {
        if (eVar == null) {
            try {
                eVar = new e();
            } catch (Exception e) {
                af.a(TAG, e.getMessage());
            }
        }
        addExtraParams(str, eVar);
        f.f(eVar);
        String str3 = eVar.a().get("sign");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.a(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis + "");
        if (com.mbridge.msdk.e.b.a()) {
            eVar.a("st", SameMD5.getMD5(str3 + jCurrentTimeMillis));
        } else {
            eVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + str3));
        }
        com.mbridge.msdk.foundation.same.net.d dVarA = com.mbridge.msdk.foundation.same.net.e.c.a().a(eVar);
        if (dVarA != null && bVar != null) {
            bVar.onSuccess(dVarA);
            return;
        }
        if (str.contains(com.mbridge.msdk.foundation.same.net.e.d.f().h) && com.mbridge.msdk.foundation.same.net.e.d.f().f3747r) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("uri", com.mbridge.msdk.foundation.same.net.e.d.f().f3741l + Uri.parse(str).getPath());
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, eVar.b());
                } catch (Throwable th) {
                    af.b(TAG, th.getMessage());
                }
                com.mbridge.msdk.foundation.same.net.e.a().a(com.mbridge.msdk.foundation.same.net.e.d.f().f3741l, com.mbridge.msdk.foundation.same.net.e.d.f().f3745p, jSONObject.toString(), true, bVar);
                return;
            } catch (Throwable th2) {
                af.b(TAG, th2.getMessage());
            }
        }
        StringBuilder sbW = a3.a.w(str, "?");
        sbW.append(eVar.toString());
        String string = sbW.toString();
        com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        if (string.length() >= gVarA.ap() && string.contains(com.mbridge.msdk.foundation.same.net.e.d.f().h)) {
            post(i10, str, eVar, bVar, z10, false, str2, j10);
            return;
        }
        e eVar2 = eVar;
        if (string.length() >= gVarA.R() && z9) {
            post(i10, str, eVar2, bVar, z10, false, str2, j10);
            return;
        }
        com.mbridge.msdk.tracker.network.i<?> iVarCreateRequest = createRequest(i10, 0, str, bVar, str2, j10);
        if (iVarCreateRequest != null) {
            if (eVar2.a() != null) {
                String str4 = eVar2.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                if (TextUtils.isEmpty(str4)) {
                    str4 = "";
                }
                iVarCreateRequest.c("local_id", str4);
                String str5 = eVar2.a().get("ad_type");
                iVarCreateRequest.c("ad_type", TextUtils.isEmpty(str5) ? "" : str5);
                iVarCreateRequest.a(eVar2.a());
            }
            iVarCreateRequest.a(canTrack());
            m.a().b().a(iVarCreateRequest);
        }
    }

    public void getCampaign(int i10, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, long j10) {
        e eVar2;
        try {
            com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
            int iAs = TextUtils.isEmpty(str) ? gVarA.as() : gVarA.I();
            String strA = com.mbridge.msdk.foundation.same.net.e.d.f().a(str, iAs);
            if (iAs < 2) {
                postV5(i10, strA, eVar, bVar, true, "campaign", j10);
                return;
            }
            if (iAs % 2 == 0) {
                if (eVar == null) {
                    eVar = new e();
                }
                eVar2 = eVar;
                JSONArray jSONArrayB = com.mbridge.msdk.foundation.db.a.b.a().b();
                if (jSONArrayB != null) {
                    String string = jSONArrayB.toString();
                    int iD = com.mbridge.msdk.foundation.same.net.e.d.f().d();
                    if (iD > 0 && string.length() > iD) {
                        post(i10, strA, eVar2, bVar, true, false, "campaign", j10);
                        return;
                    }
                    eVar2.a(e.h, string);
                }
            } else {
                eVar2 = eVar;
            }
            get(i10, strA, eVar2, bVar, true, true, "campaign", j10);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e.getMessage());
            }
        }
    }

    public void getLoadOrSetting(int i10, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z9, String str2, long j10) {
        get(i10, str, eVar, bVar, z9, false, str2, j10);
    }

    public void postFocusReport(int i10, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j10) {
        post(i10, str, eVar, bVar, false, true, str2, j10);
    }

    public void postV5(int i10, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j10) {
        String str3 = eVar.a().get("sign");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.a(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + str3));
        post(i10, str, eVar, bVar, false, false, str2, j10);
    }

    public void getLoadOrSetting(int i10, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j10) {
        getLoadOrSetting(i10, str, eVar, bVar, true, str2, j10);
    }

    public void postV5(int i10, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z9, String str2, long j10) {
        String str3 = eVar.a().get("sign");
        if (str3 == null) {
            str3 = "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        eVar.a(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(jCurrentTimeMillis + str3));
        post(i10, str, eVar, bVar, z9, false, str2, j10);
    }

    public void get(int i10, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j10) {
        get(i10, str, eVar, bVar, false, false, str2, j10);
    }

    public void get(int i10, String str, Map<String, String> map, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j10) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().k());
        map.put("sdk_version", MBConfiguration.SDK_VERSION);
        map.put("platform", "1");
        String strAsUrlParams = asUrlParams(map);
        if (!TextUtils.isEmpty(strAsUrlParams)) {
            str = a3.a.j(str, "?", strAsUrlParams);
        }
        String str3 = str;
        if (MBridgeConstans.DEBUG) {
            androidx.constraintlayout.core.widgets.analyzer.a.E("get wx scheme url = ", str3, "AppletsModel");
        }
        com.mbridge.msdk.tracker.network.i<?> iVarCreateRequest = createRequest(i10, 0, str3, bVar, str2, j10);
        if (iVarCreateRequest != null) {
            String str4 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            iVarCreateRequest.c("local_id", str4);
            String str5 = map.get("ad_type");
            iVarCreateRequest.c("ad_type", TextUtils.isEmpty(str5) ? "" : str5);
            iVarCreateRequest.a(map);
            iVarCreateRequest.a(canTrack());
            m.a().b().a(iVarCreateRequest);
        }
    }

    public void post(int i10, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j10) {
        post(i10, str, eVar, bVar, false, false, str2, j10);
    }
}
