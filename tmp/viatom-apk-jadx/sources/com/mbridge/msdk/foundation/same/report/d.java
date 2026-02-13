package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements com.mbridge.msdk.tracker.d {
    private static StringBuilder a(List<com.mbridge.msdk.tracker.i> list) {
        com.mbridge.msdk.tracker.e eVarC;
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            com.mbridge.msdk.tracker.i iVar = list.get(i10);
            if (iVar != null && (eVarC = iVar.c()) != null) {
                JSONObject jSONObjectD = eVarC.d();
                c.a(jSONObjectD);
                if (jSONObjectD == null) {
                    jSONObjectD = new JSONObject();
                }
                try {
                    try {
                        jSONObjectD.put(CampaignEx.JSON_KEY_ST_TS, eVarC.f());
                        jSONObjectD.put("rts", System.currentTimeMillis());
                        int iD = iVar.d() - 1;
                        if (iD >= 1) {
                            jSONObjectD.put("retryed", iD);
                        }
                        long jG = eVarC.g();
                        if (jG > 0) {
                            jSONObjectD.put(TypedValues.TransitionType.S_DURATION, jG);
                        }
                    } catch (Exception e) {
                        if (com.mbridge.msdk.tracker.a.f5328a) {
                            Log.e("TrackManager", "decorateRequestParams: ", e);
                        }
                    }
                    sb.append(a(jSONObjectD));
                    if (i10 < list.size() - 1) {
                        sb.append("\n");
                    }
                } catch (Throwable th) {
                    sb.append(a(jSONObjectD));
                    throw th;
                }
            }
        }
        return sb;
    }

    @Override // com.mbridge.msdk.tracker.d
    public final Map<String, String> a(com.mbridge.msdk.tracker.m mVar, List<com.mbridge.msdk.tracker.i> list, JSONObject jSONObject) {
        HashMap map;
        if (list != null && list.size() != 0) {
            try {
                c.a(jSONObject);
                if (jSONObject == null) {
                    map = null;
                } else {
                    map = new HashMap();
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, String.valueOf(jSONObject.opt(next)));
                    }
                }
                if (map == null) {
                    map = new HashMap();
                }
                StringBuilder sbA = a(list);
                map.put("tun", String.valueOf(ab.r()));
                map.put(DataSchemeDataSource.SCHEME_DATA, sbA.toString());
                return map;
            } catch (Exception unused) {
            } catch (OutOfMemoryError unused2) {
                if (mVar != null) {
                    mVar.i();
                }
            } catch (Throwable unused3) {
                return null;
            }
        }
        return null;
    }

    private static String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        int i10 = 0;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            i10++;
            if (i10 <= jSONObject.length() - 1) {
                sb.append(next);
                sb.append("=");
                sb.append(a(String.valueOf(jSONObject.opt(next))));
                sb.append("&");
            } else {
                sb.append(next);
                sb.append("=");
                sb.append(a(String.valueOf(jSONObject.opt(next))));
            }
        }
        return sb.toString();
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
