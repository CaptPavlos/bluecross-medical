package b9;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends i {
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f890i;

    /* renamed from: j, reason: collision with root package name */
    public final int f891j;

    /* renamed from: k, reason: collision with root package name */
    public final String f892k;

    /* renamed from: l, reason: collision with root package name */
    public final String f893l;

    /* renamed from: m, reason: collision with root package name */
    public final b f894m;

    /* renamed from: n, reason: collision with root package name */
    public final b f895n;

    /* renamed from: o, reason: collision with root package name */
    public final String f896o;

    /* renamed from: p, reason: collision with root package name */
    public final String f897p;

    /* renamed from: q, reason: collision with root package name */
    public final Boolean f898q;

    public j(String str, String str2, int i10, String str3, String str4, b bVar, b bVar2, String str5, String str6, Boolean bool) {
        this.h = str;
        this.f890i = str2;
        this.f891j = i10;
        this.f892k = str3;
        this.f893l = str4;
        this.f894m = bVar;
        this.f895n = bVar2;
        this.f896o = str5;
        this.f897p = str6;
        this.f898q = bool;
    }

    @Override // b9.i
    public final String d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("displayType", this.f892k);
        jSONObject.put("configurationHashCode", this.f893l);
        jSONObject.put("cmpId", this.f891j);
        jSONObject.put("accountId", this.h);
        jSONObject.put("publisher", this.f890i);
        jSONObject.putOpt("configs", this.f894m.a());
        b bVar = this.f895n;
        jSONObject.putOpt("existingConfigs", bVar == null ? null : bVar.a());
        jSONObject.putOpt("existingCMPStatus", this.f896o);
        jSONObject.put("manualTrigger", this.f898q);
        jSONObject.put("existingGBCStatus", this.f897p);
        c(jSONObject);
        String string = jSONObject.toString();
        string.getClass();
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.h.equals(jVar.h) && this.f890i.equals(jVar.f890i) && this.f891j == jVar.f891j && this.f892k.equals(jVar.f892k) && this.f893l.equals(jVar.f893l) && this.f894m.equals(jVar.f894m) && kotlin.jvm.internal.l.a(this.f895n, jVar.f895n) && kotlin.jvm.internal.l.a(this.f896o, jVar.f896o) && kotlin.jvm.internal.l.a(this.f897p, jVar.f897p) && kotlin.jvm.internal.l.a(this.f898q, jVar.f898q);
    }

    public final int hashCode() {
        int iHashCode = (this.f894m.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(androidx.constraintlayout.core.widgets.analyzer.a.o((this.f891j + androidx.constraintlayout.core.widgets.analyzer.a.o(this.h.hashCode() * 31, 31, this.f890i)) * 31, 31, this.f892k), 31, this.f893l)) * 31;
        b bVar = this.f895n;
        int iHashCode2 = (iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
        String str = this.f896o;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f897p;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.f898q;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "TrackingInitLog(accountId=" + this.h + ", publisher=" + this.f890i + ", cmpId=" + this.f891j + ", displayType=" + this.f892k + ", configurationHashCode=" + this.f893l + ", configs=" + this.f894m + ", existingConfigs=" + this.f895n + ", existingCMPStatus=" + ((Object) this.f896o) + ", existingGBCStatus=" + ((Object) this.f897p) + ", manualTrigger=" + this.f898q + ')';
    }
}
