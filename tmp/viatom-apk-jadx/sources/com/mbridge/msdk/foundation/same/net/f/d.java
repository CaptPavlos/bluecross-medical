package com.mbridge.msdk.foundation.same.net.f;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d extends com.mbridge.msdk.foundation.same.net.c<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3755a = "d";

    private void a(com.mbridge.msdk.foundation.same.net.d<JSONObject> dVar) {
        JSONObject jSONObject = dVar.f3709c;
        if (jSONObject == null) {
            a("response result is null");
            return;
        }
        int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -9999);
        if (iOptInt == -9999) {
            a(dVar.f3709c);
            return;
        }
        if (iOptInt == 1 || iOptInt == 200) {
            a(dVar.f3709c.optJSONObject(DataSchemeDataSource.SCHEME_DATA));
            return;
        }
        String strOptString = dVar.f3709c.optString(NotificationCompat.CATEGORY_MESSAGE);
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = "error message is null";
        }
        a(strOptString);
    }

    public abstract void a(String str);

    public abstract void a(JSONObject jSONObject);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        af.b(f3755a, "errorCode = " + aVar.f3702a);
        a(com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(com.mbridge.msdk.foundation.same.net.d<JSONObject> dVar) {
        if (dVar == null) {
            a("response is null");
            return;
        }
        super.onSuccess(dVar);
        com.mbridge.msdk.foundation.same.net.d.a aVar = dVar.f3708b;
        if (aVar == null) {
            a(dVar);
        } else if (aVar.f3713d == 204) {
            a(new JSONObject());
        } else {
            a(dVar);
        }
    }
}
