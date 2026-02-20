package b9;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends i {
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final Boolean f912i;

    /* renamed from: j, reason: collision with root package name */
    public final String f913j;

    /* renamed from: k, reason: collision with root package name */
    public final String f914k;

    /* renamed from: l, reason: collision with root package name */
    public final b f915l;

    /* renamed from: m, reason: collision with root package name */
    public final Boolean f916m;

    /* renamed from: n, reason: collision with root package name */
    public final String f917n;

    /* renamed from: o, reason: collision with root package name */
    public final Boolean f918o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f919p;

    public n(String str, Boolean bool, String str2, String str3, b bVar, Boolean bool2, String str4, Boolean bool3, boolean z9) {
        this.h = str;
        this.f912i = bool;
        this.f913j = str2;
        this.f914k = str3;
        this.f915l = bVar;
        this.f916m = bool2;
        this.f917n = str4;
        this.f918o = bool3;
        this.f919p = z9;
    }

    @Override // b9.i
    public final String d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("existingCMPStatus", this.h);
        jSONObject.putOpt("regulation", this.f913j);
        jSONObject.putOpt("cmpTriggered", this.f912i);
        jSONObject.putOpt("accountId", this.f914k);
        b bVar = this.f915l;
        jSONObject.putOpt("existingConfigs", bVar == null ? null : bVar.a());
        jSONObject.putOpt("paidUser", this.f916m);
        jSONObject.putOpt("existingGBCStatus", this.f917n);
        jSONObject.putOpt("consentOrPayApplicable", this.f918o);
        jSONObject.putOpt("gbcApplicable", Boolean.valueOf(this.f919p));
        c(jSONObject);
        String string = jSONObject.toString();
        string.getClass();
        return string;
    }
}
