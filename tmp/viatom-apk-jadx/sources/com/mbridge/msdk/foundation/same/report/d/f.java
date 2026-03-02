package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.tracker.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {
    private Map<String, String> a(String str, String str2, m mVar) throws JSONException {
        e eVar = new e();
        try {
            g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                h.a();
                gVarB = i.a();
            }
            if (!TextUtils.isEmpty(gVarB.an())) {
                eVar.a("as_rid", gVarB.an());
            }
            String strP = gVarB.P();
            JSONArray jSONArrayO = gVarB.O();
            if (jSONArrayO != null) {
                int i10 = 0;
                while (true) {
                    if (i10 >= jSONArrayO.length()) {
                        break;
                    }
                    if (str.equals(jSONArrayO.getString(i10))) {
                        strP = BuildConfig.VERSION_NAME;
                        break;
                    }
                    i10++;
                }
            }
            if (TextUtils.isEmpty(strP)) {
                eVar.a("log_rate", -1);
            } else {
                eVar.a("log_rate", strP);
            }
            if (!TextUtils.isEmpty(str2)) {
                k kVarC = h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), str2);
                if (kVarC != null && !TextUtils.isEmpty(kVarC.s())) {
                    eVar.a("us_rid", kVarC.s());
                }
                if (kVarC != null && !TextUtils.isEmpty(kVarC.a())) {
                    eVar.a("u_stid", kVarC.a());
                }
                e eVarA = d.a().a(str2);
                if (eVarA != null) {
                    if (mVar != null && mVar.g() != null) {
                        try {
                            mVar.g().put("r_stid", eVarA.b("r_stid"));
                            eVarA.c("r_stid");
                        } catch (JSONException unused) {
                        }
                    }
                    eVar.a(eVarA);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f A[Catch: Exception -> 0x002a, TRY_LEAVE, TryCatch #2 {Exception -> 0x002a, blocks: (B:3:0x0019, B:5:0x0025, B:10:0x002f, B:12:0x003b, B:40:0x00a5, B:42:0x00ab, B:49:0x00c7, B:51:0x00cd, B:53:0x00d2, B:54:0x00d6, B:56:0x00dc, B:59:0x00e5, B:62:0x00f1, B:64:0x0104, B:65:0x010d, B:67:0x011c, B:69:0x012b, B:70:0x0138, B:73:0x0140, B:75:0x0146, B:77:0x014c, B:80:0x017c, B:82:0x0186, B:84:0x018c, B:85:0x01aa, B:86:0x01b5, B:88:0x01bd, B:90:0x01c3, B:91:0x01e1, B:92:0x01ec, B:94:0x01f4, B:96:0x01fa, B:97:0x0218, B:98:0x0223, B:100:0x022b, B:102:0x0231, B:103:0x024f, B:104:0x025a, B:107:0x0271, B:110:0x027d, B:111:0x0281, B:112:0x0284, B:115:0x0290, B:117:0x029e, B:120:0x02b0, B:122:0x02b6, B:129:0x0304, B:131:0x030e, B:134:0x031a, B:136:0x0320, B:137:0x0337, B:138:0x033b, B:140:0x0341, B:141:0x0358, B:142:0x035b, B:144:0x0365, B:146:0x0374, B:147:0x0394, B:148:0x039d, B:151:0x03a6, B:153:0x03ac, B:159:0x03e7, B:163:0x03f2, B:165:0x0408, B:167:0x042d, B:169:0x0433, B:171:0x0458, B:173:0x045c, B:175:0x046c, B:176:0x0471, B:178:0x047b, B:179:0x0484, B:181:0x048a, B:182:0x0497, B:184:0x04b5, B:186:0x04bc, B:187:0x04c9, B:189:0x04d3, B:190:0x04dc, B:192:0x04e4, B:194:0x04eb, B:195:0x04f8, B:197:0x0502, B:198:0x050b, B:199:0x0518, B:201:0x0520, B:203:0x0528, B:206:0x0536, B:208:0x055c, B:210:0x0562, B:212:0x0567, B:211:0x0565, B:213:0x056e, B:215:0x0576, B:217:0x057c, B:219:0x0581, B:218:0x057f, B:220:0x0588, B:222:0x0594, B:228:0x05a4, B:230:0x05b0, B:232:0x05ba, B:238:0x05d1, B:240:0x05e4, B:242:0x05ea, B:244:0x05ef, B:243:0x05ed, B:239:0x05db, B:233:0x05c3, B:235:0x05c9, B:254:0x062a, B:245:0x05f7, B:247:0x0605, B:249:0x0618, B:251:0x061e, B:253:0x0623, B:252:0x0621, B:248:0x060f, B:170:0x0451, B:166:0x0426, B:154:0x03c3, B:155:0x03c7, B:157:0x03cd, B:158:0x03e4, B:123:0x02d1, B:124:0x02d9, B:126:0x02e3, B:127:0x02fa, B:78:0x016c, B:66:0x0115, B:43:0x00b3, B:45:0x00b9, B:48:0x00c4, B:46:0x00be, B:21:0x005f, B:25:0x0073, B:28:0x007e, B:30:0x0084, B:33:0x008f, B:35:0x0095, B:31:0x0089, B:37:0x009b, B:20:0x0056, B:13:0x0040, B:15:0x0046), top: B:265:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cd A[Catch: Exception -> 0x002a, TryCatch #2 {Exception -> 0x002a, blocks: (B:3:0x0019, B:5:0x0025, B:10:0x002f, B:12:0x003b, B:40:0x00a5, B:42:0x00ab, B:49:0x00c7, B:51:0x00cd, B:53:0x00d2, B:54:0x00d6, B:56:0x00dc, B:59:0x00e5, B:62:0x00f1, B:64:0x0104, B:65:0x010d, B:67:0x011c, B:69:0x012b, B:70:0x0138, B:73:0x0140, B:75:0x0146, B:77:0x014c, B:80:0x017c, B:82:0x0186, B:84:0x018c, B:85:0x01aa, B:86:0x01b5, B:88:0x01bd, B:90:0x01c3, B:91:0x01e1, B:92:0x01ec, B:94:0x01f4, B:96:0x01fa, B:97:0x0218, B:98:0x0223, B:100:0x022b, B:102:0x0231, B:103:0x024f, B:104:0x025a, B:107:0x0271, B:110:0x027d, B:111:0x0281, B:112:0x0284, B:115:0x0290, B:117:0x029e, B:120:0x02b0, B:122:0x02b6, B:129:0x0304, B:131:0x030e, B:134:0x031a, B:136:0x0320, B:137:0x0337, B:138:0x033b, B:140:0x0341, B:141:0x0358, B:142:0x035b, B:144:0x0365, B:146:0x0374, B:147:0x0394, B:148:0x039d, B:151:0x03a6, B:153:0x03ac, B:159:0x03e7, B:163:0x03f2, B:165:0x0408, B:167:0x042d, B:169:0x0433, B:171:0x0458, B:173:0x045c, B:175:0x046c, B:176:0x0471, B:178:0x047b, B:179:0x0484, B:181:0x048a, B:182:0x0497, B:184:0x04b5, B:186:0x04bc, B:187:0x04c9, B:189:0x04d3, B:190:0x04dc, B:192:0x04e4, B:194:0x04eb, B:195:0x04f8, B:197:0x0502, B:198:0x050b, B:199:0x0518, B:201:0x0520, B:203:0x0528, B:206:0x0536, B:208:0x055c, B:210:0x0562, B:212:0x0567, B:211:0x0565, B:213:0x056e, B:215:0x0576, B:217:0x057c, B:219:0x0581, B:218:0x057f, B:220:0x0588, B:222:0x0594, B:228:0x05a4, B:230:0x05b0, B:232:0x05ba, B:238:0x05d1, B:240:0x05e4, B:242:0x05ea, B:244:0x05ef, B:243:0x05ed, B:239:0x05db, B:233:0x05c3, B:235:0x05c9, B:254:0x062a, B:245:0x05f7, B:247:0x0605, B:249:0x0618, B:251:0x061e, B:253:0x0623, B:252:0x0621, B:248:0x060f, B:170:0x0451, B:166:0x0426, B:154:0x03c3, B:155:0x03c7, B:157:0x03cd, B:158:0x03e4, B:123:0x02d1, B:124:0x02d9, B:126:0x02e3, B:127:0x02fa, B:78:0x016c, B:66:0x0115, B:43:0x00b3, B:45:0x00b9, B:48:0x00c4, B:46:0x00be, B:21:0x005f, B:25:0x0073, B:28:0x007e, B:30:0x0084, B:33:0x008f, B:35:0x0095, B:31:0x0089, B:37:0x009b, B:20:0x0056, B:13:0x0040, B:15:0x0046), top: B:265:0x0019, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d2 A[Catch: Exception -> 0x002a, TryCatch #2 {Exception -> 0x002a, blocks: (B:3:0x0019, B:5:0x0025, B:10:0x002f, B:12:0x003b, B:40:0x00a5, B:42:0x00ab, B:49:0x00c7, B:51:0x00cd, B:53:0x00d2, B:54:0x00d6, B:56:0x00dc, B:59:0x00e5, B:62:0x00f1, B:64:0x0104, B:65:0x010d, B:67:0x011c, B:69:0x012b, B:70:0x0138, B:73:0x0140, B:75:0x0146, B:77:0x014c, B:80:0x017c, B:82:0x0186, B:84:0x018c, B:85:0x01aa, B:86:0x01b5, B:88:0x01bd, B:90:0x01c3, B:91:0x01e1, B:92:0x01ec, B:94:0x01f4, B:96:0x01fa, B:97:0x0218, B:98:0x0223, B:100:0x022b, B:102:0x0231, B:103:0x024f, B:104:0x025a, B:107:0x0271, B:110:0x027d, B:111:0x0281, B:112:0x0284, B:115:0x0290, B:117:0x029e, B:120:0x02b0, B:122:0x02b6, B:129:0x0304, B:131:0x030e, B:134:0x031a, B:136:0x0320, B:137:0x0337, B:138:0x033b, B:140:0x0341, B:141:0x0358, B:142:0x035b, B:144:0x0365, B:146:0x0374, B:147:0x0394, B:148:0x039d, B:151:0x03a6, B:153:0x03ac, B:159:0x03e7, B:163:0x03f2, B:165:0x0408, B:167:0x042d, B:169:0x0433, B:171:0x0458, B:173:0x045c, B:175:0x046c, B:176:0x0471, B:178:0x047b, B:179:0x0484, B:181:0x048a, B:182:0x0497, B:184:0x04b5, B:186:0x04bc, B:187:0x04c9, B:189:0x04d3, B:190:0x04dc, B:192:0x04e4, B:194:0x04eb, B:195:0x04f8, B:197:0x0502, B:198:0x050b, B:199:0x0518, B:201:0x0520, B:203:0x0528, B:206:0x0536, B:208:0x055c, B:210:0x0562, B:212:0x0567, B:211:0x0565, B:213:0x056e, B:215:0x0576, B:217:0x057c, B:219:0x0581, B:218:0x057f, B:220:0x0588, B:222:0x0594, B:228:0x05a4, B:230:0x05b0, B:232:0x05ba, B:238:0x05d1, B:240:0x05e4, B:242:0x05ea, B:244:0x05ef, B:243:0x05ed, B:239:0x05db, B:233:0x05c3, B:235:0x05c9, B:254:0x062a, B:245:0x05f7, B:247:0x0605, B:249:0x0618, B:251:0x061e, B:253:0x0623, B:252:0x0621, B:248:0x060f, B:170:0x0451, B:166:0x0426, B:154:0x03c3, B:155:0x03c7, B:157:0x03cd, B:158:0x03e4, B:123:0x02d1, B:124:0x02d9, B:126:0x02e3, B:127:0x02fa, B:78:0x016c, B:66:0x0115, B:43:0x00b3, B:45:0x00b9, B:48:0x00c4, B:46:0x00be, B:21:0x005f, B:25:0x0073, B:28:0x007e, B:30:0x0084, B:33:0x008f, B:35:0x0095, B:31:0x0089, B:37:0x009b, B:20:0x0056, B:13:0x0040, B:15:0x0046), top: B:265:0x0019, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.mbridge.msdk.foundation.same.report.d.e] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, java.lang.String> b(java.lang.String r20, com.mbridge.msdk.foundation.same.report.d.c r21) {
        /*
            Method dump skipped, instructions count: 1639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.d.f.b(java.lang.String, com.mbridge.msdk.foundation.same.report.d.c):java.util.Map");
    }

    private Map<String, String> c(String str, c cVar) {
        e eVar = new e();
        try {
            if (str.equals("2000125")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000123")));
            } else if (str.equals("2000126")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000125")));
            } else if (str.equals("2000127")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000123")));
            } else if (str.equals("2000154")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000126")));
            } else if (str.equals("2000047") || str.equals("2000048")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000123")));
            } else if (str.equals("2000155")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000154")));
            } else if (str.equals("2000146")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000130")));
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar.a();
    }

    private Map<String, String> d(String str, c cVar) {
        HashMap map = new HashMap();
        try {
            if (Arrays.asList(b.e).contains(str)) {
                map.put("auto_load", cVar != null ? cVar.d() : "");
            }
            if (cVar != null) {
                Map<String, Map<String, String>> mapP = cVar.p();
                String str2 = cVar.f() + str;
                if (mapP.containsKey(str2) && mapP.get(str2) != null) {
                    map.putAll(mapP.get(str2));
                }
                try {
                    Map<String, Map<String, String>> mapQ = cVar.q();
                    String str3 = cVar.f() + "_" + cVar.b() + "_" + str;
                    if (mapQ.containsKey(str3) && mapQ.get(str3) != null) {
                        map.putAll(mapQ.get(str3));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
        return map;
    }

    private Map<String, String> a(String str, c cVar) {
        return (cVar == null || TextUtils.isEmpty(str)) ? new HashMap() : cVar.j(str);
    }

    private com.mbridge.msdk.tracker.e a(String str, Map<String, String> map) throws JSONException {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e(str);
        try {
            JSONObject jSONObject = new JSONObject(map);
            Boolean boolB = com.mbridge.msdk.foundation.same.b.a().b();
            if (boolB != null) {
                jSONObject.put("r_v_r", boolB.booleanValue() ? 1 : 0);
            }
            eVar.a(jSONObject);
            eVar.a(0);
            eVar.b(0);
            return eVar;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return eVar;
        }
    }

    public final void a(String str, m mVar, c cVar, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        Map<String, String> mapC;
        HashMap map = new HashMap();
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            cVar.a(str);
            Map<String, String> mapB = b(str, cVar);
            if (mapB != null) {
                map.putAll(mapB);
            }
            Map<String, String> mapA = a(str, cVar.i(), mVar);
            if (mapA != null) {
                map.putAll(mapA);
            }
            if (Arrays.asList(b.f3814d).contains(str) && (mapC = c(str, cVar)) != null) {
                map.putAll(mapC);
            }
            Map<String, String> mapD = d(str, cVar);
            if (mapD != null) {
                map.putAll(mapD);
            }
            if (!map.containsKey("lrid") || TextUtils.isEmpty((CharSequence) map.get("lrid"))) {
                map.put("lrid", cVar.f());
            }
            Map<String, String> mapA2 = a(str, cVar);
            if (mapA2 != null) {
                map.putAll(mapA2);
            }
            if (cVar.d() == null || !cVar.d().equals("1") || !Arrays.asList(b.f3812b).contains(str) || cVar.j() == 296) {
                com.mbridge.msdk.tracker.e eVarA = a(str, map);
                if (mVar != null && eVarA != null) {
                    mVar.a(eVarA);
                }
                if (aVar != null) {
                    aVar.a();
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private List<CampaignEx> a(c cVar, String str) throws NumberFormatException {
        ArrayList arrayList = new ArrayList();
        if (cVar != null) {
            try {
                String str2 = cVar.f() + str;
                Map<String, Map<String, String>> mapP = cVar.p();
                int iIntValue = -1;
                if (mapP != null && mapP.containsKey(str2)) {
                    try {
                        Object obj = mapP.get(str2).get("resource_type");
                        if (obj instanceof String) {
                            iIntValue = Integer.parseInt((String) obj);
                        } else if (obj instanceof Integer) {
                            iIntValue = ((Integer) obj).intValue();
                        }
                    } catch (NumberFormatException e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
                if (iIntValue == 1) {
                    List<CampaignEx> listH = cVar.h() != null ? cVar.h() : cVar.e();
                    if (listH != null && listH.size() > 0) {
                        arrayList.addAll(listH);
                    }
                } else if (cVar.g() != null) {
                    arrayList.add(cVar.g());
                } else {
                    List<CampaignEx> listH2 = cVar.h() != null ? cVar.h() : cVar.e();
                    if (listH2 != null && listH2.size() > 0) {
                        arrayList.addAll(listH2);
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public final void b(String str, m mVar, c cVar, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap map = new HashMap();
            cVar.a(str);
            Map<String, String> mapA = a(str, cVar.i(), mVar);
            if (mapA != null) {
                map.putAll(mapA);
            }
            Map<String, String> mapD = d(str, cVar);
            if (mapD != null) {
                map.putAll(mapD);
            }
            Map<String, String> mapA2 = a(str, cVar);
            if (mapA2 != null) {
                map.putAll(mapA2);
            }
            com.mbridge.msdk.tracker.e eVarA = a(str, map);
            if (mVar != null && eVarA != null) {
                mVar.a(eVarA);
            }
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
