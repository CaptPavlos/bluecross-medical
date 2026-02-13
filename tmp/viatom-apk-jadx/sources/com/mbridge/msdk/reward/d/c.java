package com.mbridge.msdk.reward.d;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.h;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c extends com.mbridge.msdk.foundation.same.net.c<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5281a = "c";

    /* renamed from: b, reason: collision with root package name */
    private int f5282b;

    /* renamed from: c, reason: collision with root package name */
    private String f5283c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.d.c f5284d;

    private void a(List<h> list, JSONObject jSONObject, int i10, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        String strB = "";
        if (list != null && list.size() > 0) {
            for (h hVar : list) {
                if (hVar != null) {
                    String strA = hVar.a();
                    if (!TextUtils.isEmpty(strA) && strA.equals("data_res_type")) {
                        strB = hVar.b();
                    }
                }
            }
        }
        String strB2 = "errorCode: 3507 errorMessage: data load failed, errorMsg is " + jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
        if (TextUtils.isEmpty(strB) || !strB.equals("1")) {
            com.mbridge.msdk.foundation.c.b bVarB = i10 == -1 ? com.mbridge.msdk.foundation.c.a.b(880017, strB2) : com.mbridge.msdk.foundation.c.a.b(880003, strB2);
            if (cVar != null) {
                cVar.a(bVarB);
                cVar.b(false);
                if (TextUtils.isEmpty(strB2)) {
                    strB2 = bVarB.b();
                }
            }
            b(i10, strB2, cVar);
            return;
        }
        com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880018, strB2);
        if (cVar != null) {
            cVar.a(bVarB2);
            cVar.b(true);
            if (TextUtils.isEmpty(strB2)) {
                strB2 = bVarB2.b();
            }
        }
        b(i10, strB2, cVar);
    }

    public abstract void a(List<Frame> list);

    public abstract void a(List<h> list, CampaignUnit campaignUnit);

    public abstract void b(int i10, String str, com.mbridge.msdk.foundation.same.report.d.c cVar);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        af.b(f5281a, "errorCode = " + aVar.f3702a);
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(aVar.f3702a, com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
        bVar.a("campaign_request_error", aVar);
        bVar.f(aVar.f3703b);
        this.f5284d.a(bVar);
        b(aVar.f3702a, com.mbridge.msdk.foundation.same.net.e.a.a(aVar), this.f5284d);
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(d<JSONObject> dVar) {
        com.mbridge.msdk.foundation.same.net.d.a aVar;
        super.onSuccess(dVar);
        if (dVar == null || (aVar = dVar.f3708b) == null) {
            return;
        }
        int i10 = this.f5282b;
        if (i10 == 0) {
            final List<h> list = aVar.f3711b;
            final JSONObject jSONObject = dVar.f3709c;
            final int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            if (1 != iOptInt) {
                a(list, jSONObject, iOptInt, this.f5284d);
                return;
            }
            calcRequestTime(System.currentTimeMillis());
            final String strOptString = jSONObject.optString("version");
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.d.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean zEquals = "v5".equals(strOptString);
                    JSONObject jSONObject2 = jSONObject;
                    final CampaignUnit v5CampaignUnit = zEquals ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), c.this.f5283c) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), c.this.f5283c);
                    com.mbridge.msdk.foundation.same.f.a.c().post(new Runnable() { // from class: com.mbridge.msdk.reward.d.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CampaignUnit campaignUnit = v5CampaignUnit;
                            if (campaignUnit != null && campaignUnit.getAds() != null && v5CampaignUnit.getAds().size() > 0) {
                                v5CampaignUnit.setMetricsData(c.this.f5284d);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                c.this.a(list, v5CampaignUnit);
                                c.this.saveRequestTime(v5CampaignUnit.getAds().size());
                                return;
                            }
                            CampaignUnit campaignUnit2 = v5CampaignUnit;
                            String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                            if (TextUtils.isEmpty(msg)) {
                                msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                            }
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            c cVar = c.this;
                            cVar.b(iOptInt, msg, cVar.f5284d);
                        }
                    });
                }
            });
            return;
        }
        if (i10 == 1) {
            List<h> list2 = aVar.f3711b;
            JSONObject jSONObject2 = dVar.f3709c;
            int iOptInt2 = jSONObject2.optInt(NotificationCompat.CATEGORY_STATUS);
            if (1 != iOptInt2) {
                a(list2, jSONObject2, iOptInt2, this.f5284d);
                return;
            }
            calcRequestTime(System.currentTimeMillis());
            CampaignUnit v5CampaignUnit = "v5".equals(jSONObject2.optString("version")) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.f5283c) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), this.f5283c);
            if (v5CampaignUnit != null && v5CampaignUnit.getListFrames() != null && v5CampaignUnit.getListFrames().size() > 0) {
                List<Frame> listFrames = v5CampaignUnit.getListFrames();
                a(listFrames);
                saveRequestTime(listFrames.size());
            } else {
                String msg = v5CampaignUnit != null ? v5CampaignUnit.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                }
                b(iOptInt2, msg, this.f5284d);
            }
        }
    }

    public final void a(String str) {
        this.f5283c = str;
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        this.f5284d = cVar;
    }
}
