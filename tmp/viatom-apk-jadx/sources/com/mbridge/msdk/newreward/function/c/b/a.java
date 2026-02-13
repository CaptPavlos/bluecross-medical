package com.mbridge.msdk.newreward.function.c.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.c.a;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.VolleyErrorUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.ac;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.t;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.network.y;
import com.mbridge.msdk.tracker.network.z;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a extends u<JSONObject> implements w.a {

    /* renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.newreward.function.c.a.b f4687a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f4688b;

    /* renamed from: c, reason: collision with root package name */
    protected int f4689c;

    /* renamed from: d, reason: collision with root package name */
    protected String f4690d;
    protected String e;
    protected String f;
    private Map<String, String> g;
    private c h;

    /* renamed from: i, reason: collision with root package name */
    private z f4691i;

    /* renamed from: j, reason: collision with root package name */
    private long f4692j;

    /* renamed from: k, reason: collision with root package name */
    private long f4693k;

    /* renamed from: l, reason: collision with root package name */
    private String f4694l;

    /* renamed from: m, reason: collision with root package name */
    private String f4695m;

    /* renamed from: n, reason: collision with root package name */
    private String f4696n;

    /* renamed from: o, reason: collision with root package name */
    private String f4697o;

    /* renamed from: p, reason: collision with root package name */
    private Map<String, String> f4698p;

    /* renamed from: q, reason: collision with root package name */
    private long f4699q;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.c.b.a$a, reason: collision with other inner class name */
    public static final class C0044a implements a.InterfaceC0041a {

        /* renamed from: a, reason: collision with root package name */
        private final a f4700a;

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f4701b;

        public C0044a(a aVar, com.mbridge.msdk.newreward.function.c.a.b bVar) {
            this.f4700a = aVar;
            this.f4701b = bVar;
        }

        @Override // com.mbridge.msdk.newreward.a.c.a.InterfaceC0041a
        public final void a(String str, long j10) {
            af.a("BaseCampaignRequest", "onTimeout taskID = " + str + ", timeout = " + j10);
            a.a(this.f4700a, this.f4701b, j10);
        }
    }

    public a(int i10, String str, String str2, String str3, long j10, String str4, String str5) {
        super(0, str4, 0, str5);
        this.f4688b = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f4689c = i10;
        this.f4690d = str;
        this.e = str2;
        this.f = str3;
        this.f4694l = UUID.randomUUID().toString();
        this.f4692j = SystemClock.elapsedRealtime();
        this.f4697o = str4;
        this.f4687a = new com.mbridge.msdk.newreward.function.c.a.b(this.f4689c, this.f4690d, this.e, this.f);
        a((w.a) this);
        d(true);
        c(true);
        this.f4699q = j10 <= 0 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : j10;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f4694l, this.f4699q, new C0044a(this, this.f4687a));
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final /* synthetic */ void a(JSONObject jSONObject) throws JSONException {
        c cVar;
        JSONObject jSONObject2 = jSONObject;
        if (MBridgeConstans.DEBUG) {
            af.a("BaseCampaignRequest", "deliverResponse: " + jSONObject2);
        }
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f4694l);
        int iOptInt = jSONObject2.optInt(NotificationCompat.CATEGORY_STATUS);
        if (iOptInt == 1) {
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            if (jSONObjectOptJSONObject != null) {
                CampaignUnit campaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObjectOptJSONObject, this.f4695m);
                this.f4687a.a(jSONObjectOptJSONObject);
                this.f4687a.f(jSONObjectOptJSONObject.optString("c"));
                this.f4687a.e(jSONObjectOptJSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
                this.f4687a.d(jSONObjectOptJSONObject.optString("a"));
                this.f4687a.d(jSONObjectOptJSONObject.optInt("template"));
                this.f4687a.a(System.currentTimeMillis());
                this.f4687a.c(this.f4695m);
                this.f4687a.g(jSONObjectOptJSONObject.optString(com.mbridge.msdk.foundation.same.a.T));
                this.f4687a.c(1);
                this.f4687a.e(0);
                this.f4687a.a(campaignUnit.getRequestId());
                this.f4687a.a(campaignUnit.getEcppv());
                this.f4687a.i(this.f4697o);
                this.f4687a.a(campaignUnit.getSecondRequestIndex());
                this.f4687a.b(campaignUnit.getSecondShowIndex());
                MBridgeGlobalCommon.handlerCampaigns(this.f4696n, this.f4687a, campaignUnit.getAds(), new ArrayList());
                com.mbridge.msdk.newreward.function.c.a.b bVar = this.f4687a;
                if (bVar != null && (cVar = this.h) != null) {
                    try {
                        cVar.a(bVar, this);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("BaseCampaignRequest", "handlerOnSuccessEvent Exception: ", e);
                        }
                    }
                }
            } else {
                a(this, this.f4687a, new b(7, "data is null"));
            }
        } else {
            b bVar2 = new b(9);
            bVar2.a(jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
            bVar2.a(iOptInt);
            bVar2.c(jSONObject2.toString());
            a(this, this.f4687a, bVar2);
        }
        this.f4693k = SystemClock.elapsedRealtime();
    }

    public final void b(String str) {
        c("local_id", str);
        c("ad_type", String.valueOf(this.f4689c));
        this.f4696n = str;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final Map<String, String> c() {
        if (this.f4698p == null) {
            this.f4698p = new HashMap();
        }
        this.f4698p.put("Charset", C.UTF8_NAME);
        return this.f4698p;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final boolean d() {
        return true;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final z b() {
        if (this.f4691i == null) {
            this.f4691i = new com.mbridge.msdk.tracker.network.e(10000, this.f4699q, 5);
        }
        return this.f4691i;
    }

    public final void b(String str, String str2) {
        if (this.f4698p == null) {
            this.f4698p = new HashMap();
        }
        this.f4698p.put(str, str2);
    }

    public final void a(c cVar) {
        this.h = cVar;
    }

    public final void a(String str, String str2) {
        if (this.g == null) {
            this.g = new HashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, String> map = this.g;
        if (str2 == null) {
            str2 = "";
        }
        map.put(str, str2);
    }

    public final void a(String str) {
        this.f4695m = str;
    }

    public final void a(Map<String, String> map) {
        if (this.g == null) {
            this.g = new HashMap();
        }
        if (map == null || map.size() == 0) {
            return;
        }
        this.g.putAll(map);
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final Map<String, String> a() {
        if (this.g == null) {
            this.g = new HashMap();
        }
        return this.g;
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final w<JSONObject> a(r rVar) {
        if (rVar != null) {
            try {
                byte[] bArr = rVar.f5444b;
                if (bArr != null && bArr.length != 0) {
                    return w.a(new JSONObject(new String(bArr, StandardCharsets.UTF_8)), com.mbridge.msdk.tracker.network.toolbox.f.a(rVar));
                }
            } catch (JSONException e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "parseNetworkResponse JSONException: ", e);
                }
                return w.a(new t(e));
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    af.b("BaseCampaignRequest", "parseNetworkResponse Exception: ", e3);
                }
                return w.a(new ac(e3));
            }
        }
        return w.a(new y());
    }

    @Override // com.mbridge.msdk.tracker.network.w.a
    public final void a(ad adVar) {
        c cVar;
        com.mbridge.msdk.newreward.a.c.a.a().a(this.f4694l);
        if (MBridgeConstans.DEBUG) {
            af.b("BaseCampaignRequest", "onErrorResponse: " + adVar.getMessage());
        }
        com.mbridge.msdk.newreward.function.c.a.b bVar = this.f4687a;
        if (bVar == null || (cVar = this.h) == null) {
            return;
        }
        try {
            cVar.b(bVar, this, VolleyErrorUtils.parseVolleyError(adVar));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("BaseCampaignRequest", "onError Exception: ", e);
            }
        }
    }

    private static void a(a aVar, com.mbridge.msdk.newreward.function.c.a.b bVar, b bVar2) {
        c cVar;
        if (aVar == null || bVar == null || (cVar = aVar.h) == null) {
            return;
        }
        try {
            cVar.a(bVar, aVar, bVar2);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("BaseCampaignRequest", "handlerOnFailedEvent Exception: ", e);
            }
        }
    }

    public static /* synthetic */ void a(a aVar, com.mbridge.msdk.newreward.function.c.a.b bVar, long j10) {
        c cVar;
        if (aVar == null || bVar == null || (cVar = aVar.h) == null) {
            return;
        }
        try {
            cVar.a(bVar, aVar, j10, new b(10, "v3 is timeout"));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("BaseCampaignRequest", "onTimeout Exception: ", e);
            }
        }
    }
}
