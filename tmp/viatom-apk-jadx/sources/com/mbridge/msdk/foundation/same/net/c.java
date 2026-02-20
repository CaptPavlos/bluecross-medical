package com.mbridge.msdk.foundation.same.net;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c<T> implements b<T> {
    private long startTime;
    public int adType = 0;
    public String placementId = "";
    public String unitId = "";
    private com.mbridge.msdk.foundation.same.report.a.b mRequestTime = null;

    public void calcRequestTime(long j10) {
        com.mbridge.msdk.foundation.same.report.a.b bVar = new com.mbridge.msdk.foundation.same.report.a.b(new h());
        this.mRequestTime = bVar;
        bVar.b(this.unitId);
        this.mRequestTime.b(1);
        this.mRequestTime.a((j10 - this.startTime) + "");
    }

    public void onPreExecute() {
        this.startTime = System.currentTimeMillis();
    }

    @Override // com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(d<T> dVar) {
        try {
            String str = com.mbridge.msdk.foundation.controller.c.m().k() + "_" + this.placementId + "_" + this.unitId + "_" + this.adType;
            com.mbridge.msdk.c.h.a();
            af.b("Listener", dVar.f3709c + " " + str);
            T t = dVar.f3709c;
            if (t instanceof JSONObject) {
                com.mbridge.msdk.foundation.same.net.e.c.a().a(str, ((JSONObject) t).optInt(NotificationCompat.CATEGORY_STATUS), ((JSONObject) dVar.f3709c).toString(), System.currentTimeMillis());
            }
            if (dVar.f3709c instanceof String) {
                com.mbridge.msdk.foundation.same.net.e.c.a().a(str, new JSONObject((String) dVar.f3709c).optInt(NotificationCompat.CATEGORY_STATUS), (String) dVar.f3709c, System.currentTimeMillis());
            }
        } catch (Exception e) {
            af.b("Listener", e.getMessage());
        }
    }

    public void saveHbState(int i10) {
        com.mbridge.msdk.foundation.same.report.a.b bVar = this.mRequestTime;
        if (bVar != null) {
            bVar.c(i10);
        }
    }

    public void saveRequestTime(int i10) {
        com.mbridge.msdk.foundation.same.report.a.b bVar = this.mRequestTime;
        if (bVar != null) {
            bVar.a(i10);
            this.mRequestTime.a();
        }
    }

    public void setAdType(int i10) {
        this.adType = i10;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void onCancel() {
    }

    public void onFinish() {
    }

    public void onNetworking() {
    }

    public void onRetry() {
    }

    @Override // com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
    }

    public void onProgressChange(long j10, long j11) {
    }
}
