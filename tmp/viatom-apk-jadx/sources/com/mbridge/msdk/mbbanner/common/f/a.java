package com.mbridge.msdk.mbbanner.common.f;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.h;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a extends c<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4278a = "a";

    /* renamed from: b, reason: collision with root package name */
    private String f4279b = "";

    public abstract void a(int i10, String str);

    public abstract void a(CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        af.c(f4278a, "onFailed errorCode = " + aVar.f3702a);
        a(aVar.f3702a, com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(d<JSONObject> dVar) {
        super.onSuccess(dVar);
        List<h> list = dVar.f3708b.f3711b;
        final JSONObject jSONObject = dVar.f3709c;
        af.c(f4278a, "parseLoad content = " + jSONObject);
        final int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        if (1 != iOptInt) {
            a(iOptInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        final String strOptString = jSONObject.optString("version");
        com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.f.a.1
            @Override // java.lang.Runnable
            public final void run() {
                boolean zEquals = "v5".equals(strOptString);
                JSONObject jSONObject2 = jSONObject;
                final CampaignUnit v5CampaignUnit = zEquals ? b.parseV5CampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), a.this.f4279b) : b.parseCampaignUnit(jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA), a.this.f4279b);
                com.mbridge.msdk.foundation.same.f.a.c().post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.f.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CampaignUnit campaignUnit = v5CampaignUnit;
                        if (campaignUnit != null && campaignUnit.getAds() != null && v5CampaignUnit.getAds().size() > 0) {
                            a.this.a(v5CampaignUnit);
                            if (!TextUtils.isEmpty(a.this.f4279b)) {
                                a.this.saveHbState(1);
                            }
                            a.this.saveRequestTime(v5CampaignUnit.getAds().size());
                            return;
                        }
                        CampaignUnit campaignUnit2 = v5CampaignUnit;
                        String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                        if (TextUtils.isEmpty(msg)) {
                            msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        a.this.a(iOptInt, msg);
                    }
                });
            }
        });
    }

    public final void a(String str) {
        this.f4279b = str;
    }
}
