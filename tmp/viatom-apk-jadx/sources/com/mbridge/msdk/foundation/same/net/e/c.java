package com.mbridge.msdk.foundation.same.net.e;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.af;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f3726a;

    /* renamed from: b, reason: collision with root package name */
    private int f3727b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f3728c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Integer> f3729d;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f3730a;

        /* renamed from: b, reason: collision with root package name */
        public String f3731b;

        /* renamed from: c, reason: collision with root package name */
        public long f3732c;

        public a(long j10, int i10, String str) {
            this.f3732c = j10;
            this.f3730a = i10;
            this.f3731b = str;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f3733a = new c();
    }

    private c() {
        this.f3726a = "IDErrorUtil";
        this.f3728c = new ConcurrentHashMap<>();
        this.f3729d = new ArrayList<>();
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        if (gVarS == null) {
            h.a();
            gVarS = i.a();
        }
        this.f3727b = gVarS.A() * 1000;
        if (gVarS.E() == null || gVarS.E().size() <= 0) {
            af.b("IDErrorUtil", "Setting ercd is EMPTY and use default code list.");
            this.f3729d.addAll(Arrays.asList(-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616));
        } else {
            af.b("IDErrorUtil", "Setting ercd not EMPTY will use setting.");
            this.f3729d.addAll(gVarS.E());
        }
    }

    private synchronized a a(String str) {
        a aVar;
        af.b("IDErrorUtil", "getErrorInfo : " + str);
        if (!this.f3728c.containsKey(str) || (aVar = this.f3728c.get(str)) == null) {
            return null;
        }
        if (aVar.f3730a == -1) {
            return aVar;
        }
        if (System.currentTimeMillis() <= aVar.f3732c + this.f3727b) {
            af.b("IDErrorUtil", "getErrorInfo : " + aVar.f3731b);
            return aVar;
        }
        this.f3728c.remove(str);
        if (this.f3728c.size() > 0) {
            for (Map.Entry<String, a> entry : this.f3728c.entrySet()) {
                af.b("IDErrorUtil", "getErrorInfo : delete timeout entry");
                if (System.currentTimeMillis() - entry.getValue().f3732c > this.f3727b) {
                    this.f3728c.remove(entry.getKey());
                }
            }
        }
        return null;
    }

    private com.mbridge.msdk.foundation.same.net.d b(String str, String str2, String str3, String str4, String str5) {
        int i10;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(str3);
        sb.append("_");
        sb.append(str2);
        String strO = a3.a.o(sb, "_", str5);
        a aVarA = a(strO);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.mbridge.msdk.tracker.network.h("data_res_type", "1"));
        if (aVarA != null && !TextUtils.isEmpty(aVarA.f3731b)) {
            try {
                if (aVarA.f3730a != -1) {
                    return com.mbridge.msdk.foundation.same.net.d.a(new JSONObject(aVarA.f3731b), new com.mbridge.msdk.foundation.same.net.d.a(200, aVarA.f3731b.getBytes(), arrayList));
                }
                if (!TextUtils.isEmpty(str4)) {
                    return null;
                }
                if (str5 != null && !TextUtils.isEmpty(str5) && (i10 = Integer.parseInt(str5)) != 287 && i10 != 94) {
                    if (System.currentTimeMillis() < (h.a().a(str, str2).n() * 1000) + aVarA.f3732c) {
                        return com.mbridge.msdk.foundation.same.net.d.a(new JSONObject(aVarA.f3731b), new com.mbridge.msdk.foundation.same.net.d.a(200, aVarA.f3731b.getBytes(), arrayList));
                    }
                    this.f3728c.remove(strO);
                    return null;
                }
            } catch (Exception e) {
                af.b("IDErrorUtil", e.getMessage());
            }
        }
        af.b("IDErrorUtil", "getErrorInfo RETURN NULL");
        return null;
    }

    public final synchronized void a(String str, int i10, String str2, long j10) {
        if (this.f3728c.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f3729d.contains(Integer.valueOf(i10))) {
            af.b("IDErrorUtil", "addErrorInfo : " + str + " " + str2);
            this.f3728c.put(str, new a(j10, i10, str2));
        }
    }

    public final com.mbridge.msdk.foundation.same.net.d a(String str, String str2, String str3, String str4, String str5) {
        return b(str, str2, str3, str4, str5);
    }

    public final com.mbridge.msdk.foundation.same.net.d a(e eVar) {
        String str = eVar.a().get(MBridgeConstans.APP_ID);
        String str2 = eVar.a().get("placement_id");
        String str3 = TextUtils.isEmpty(str2) ? "" : str2;
        String strReplace = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (TextUtils.isEmpty(strReplace)) {
            strReplace = eVar.a().get("unit_ids");
            if (!TextUtils.isEmpty(strReplace)) {
                strReplace = strReplace.replace("[", "").replace("]", "");
            }
        }
        String str4 = strReplace;
        String str5 = eVar.a().get("ad_type");
        if (TextUtils.isEmpty(str5)) {
            str5 = "0";
        }
        return b(str, str4, str3, eVar.a().get("token"), str5);
    }

    public static c a() {
        return b.f3733a;
    }
}
