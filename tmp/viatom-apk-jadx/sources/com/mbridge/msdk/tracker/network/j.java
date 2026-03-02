package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.tracker.network.w;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends i<JSONObject> implements w.a {

    /* renamed from: b, reason: collision with root package name */
    private final k<JSONObject> f5414b;

    public j(int i10, String str, String str2, long j10, k<JSONObject> kVar) {
        super(i10, str, 0, str2, j10);
        this.f5414b = kVar;
        a((w.a) this);
    }

    private void b(w<JSONObject> wVar) {
        k<JSONObject> kVar = this.f5414b;
        if (kVar != null) {
            try {
                kVar.b(this, wVar, wVar.f5496c.f5383a);
            } catch (Exception e) {
                af.b(i.f5410a, e.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final w<JSONObject> a(r rVar) {
        try {
            String str = new String(rVar.f5444b, StandardCharsets.UTF_8);
            if (rVar.f5443a == 204) {
                w<JSONObject> wVarA = w.a(new JSONObject(), com.mbridge.msdk.tracker.network.toolbox.f.a(rVar));
                a(wVarA, rVar);
                return wVarA;
            }
            w<JSONObject> wVarA2 = w.a(new JSONObject(str), com.mbridge.msdk.tracker.network.toolbox.f.a(rVar));
            a(wVarA2, rVar);
            return wVarA2;
        } catch (JSONException e) {
            af.b(i.f5410a, e.getMessage());
            w<JSONObject> wVarA3 = w.a(new t(e));
            b(wVarA3);
            return wVarA3;
        } catch (Throwable th) {
            w<JSONObject> wVarA4 = w.a(new ac(th));
            b(wVarA4);
            return wVarA4;
        }
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    private void a(w<JSONObject> wVar, r rVar) {
        k<JSONObject> kVar = this.f5414b;
        if (kVar != null) {
            try {
                kVar.a(this, wVar, rVar);
            } catch (Exception e) {
                af.b(i.f5410a, e.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.network.w.a
    public final void a(ad adVar) {
        b(w.a(adVar));
    }
}
