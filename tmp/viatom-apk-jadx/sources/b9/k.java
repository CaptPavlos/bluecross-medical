package b9;

import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends i {
    public final ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public final String f899i;

    /* renamed from: j, reason: collision with root package name */
    public final String f900j;

    /* renamed from: k, reason: collision with root package name */
    public final String f901k;

    /* renamed from: l, reason: collision with root package name */
    public final String f902l;

    /* renamed from: m, reason: collision with root package name */
    public final String f903m;

    /* renamed from: n, reason: collision with root package name */
    public final String f904n;

    /* renamed from: o, reason: collision with root package name */
    public final String f905o;

    /* renamed from: p, reason: collision with root package name */
    public final String f906p;

    /* renamed from: q, reason: collision with root package name */
    public final String f907q;

    /* renamed from: r, reason: collision with root package name */
    public final List f908r;

    /* renamed from: s, reason: collision with root package name */
    public final Boolean f909s;

    public k(ArrayList arrayList, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList arrayList2, Boolean bool, int i10) {
        str3 = (i10 & 8) != 0 ? null : str3;
        str4 = (i10 & 16) != 0 ? null : str4;
        str5 = (i10 & 32) != 0 ? null : str5;
        str6 = (i10 & 64) != 0 ? null : str6;
        str7 = (i10 & 128) != 0 ? null : str7;
        str8 = (i10 & 256) != 0 ? null : str8;
        bool = (i10 & 2048) != 0 ? null : bool;
        this.h = arrayList;
        this.f899i = str;
        this.f900j = str2;
        this.f901k = str3;
        this.f902l = str4;
        this.f903m = str5;
        this.f904n = str6;
        this.f905o = str7;
        this.f906p = str8;
        this.f907q = str9;
        this.f908r = arrayList2;
        this.f909s = bool;
    }

    @Override // b9.i
    public final String d() throws JSONException {
        ArrayList arrayList;
        List<s6.i> list = this.f908r;
        if (list == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (s6.i iVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(String.valueOf(((Number) iVar.f12693a).intValue()), iVar.f12694b);
                arrayList.add(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = this.h;
        int size = arrayList3.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList3.get(i10);
            i10++;
            arrayList2.add(new JSONObject(((a) obj).d()));
        }
        jSONObject2.put("userEvents", new JSONArray((Collection) arrayList2));
        jSONObject2.putOpt("acceptanceState", this.f899i);
        jSONObject2.putOpt("objectionState", this.f900j);
        jSONObject2.putOpt("tcData", this.f901k);
        jSONObject2.putOpt("gppData", this.f902l);
        jSONObject2.putOpt(MRAIDCommunicatorUtil.KEY_STATE, this.f903m);
        jSONObject2.putOpt("jurisdiction", this.f904n);
        jSONObject2.putOpt("nonIabConsentData", this.f905o);
        jSONObject2.putOpt("uspData", this.f906p);
        jSONObject2.putOpt("gbcAcceptanceState", this.f907q);
        jSONObject2.putOpt("gbcData", arrayList != null ? new JSONArray((Collection) arrayList) : null);
        jSONObject2.putOpt("paidUserIndicated", this.f909s);
        c(jSONObject2);
        String string = jSONObject2.toString();
        string.getClass();
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.l.a(this.h, kVar.h) && kotlin.jvm.internal.l.a(this.f899i, kVar.f899i) && kotlin.jvm.internal.l.a(this.f900j, kVar.f900j) && kotlin.jvm.internal.l.a(this.f901k, kVar.f901k) && kotlin.jvm.internal.l.a(this.f902l, kVar.f902l) && kotlin.jvm.internal.l.a(this.f903m, kVar.f903m) && kotlin.jvm.internal.l.a(this.f904n, kVar.f904n) && kotlin.jvm.internal.l.a(this.f905o, kVar.f905o) && kotlin.jvm.internal.l.a(this.f906p, kVar.f906p) && kotlin.jvm.internal.l.a(this.f907q, kVar.f907q) && kotlin.jvm.internal.l.a(this.f908r, kVar.f908r) && kotlin.jvm.internal.l.a(this.f909s, kVar.f909s);
    }

    public final int hashCode() {
        int iHashCode = this.h.hashCode() * 31;
        String str = this.f899i;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f900j;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f901k;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f902l;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f903m;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f904n;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f905o;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f906p;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f907q;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        List list = this.f908r;
        int iHashCode11 = (iHashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.f909s;
        return iHashCode11 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "TrackingUserDoneLog(userEvents=" + this.h + ", acceptanceState=" + ((Object) this.f899i) + ", objectionState=" + ((Object) this.f900j) + ", tcData=" + ((Object) this.f901k) + ", gppData=" + ((Object) this.f902l) + ", state=" + ((Object) this.f903m) + ", jurisdiction=" + ((Object) this.f904n) + ", nonIabConsentData=" + ((Object) this.f905o) + ", uspData=" + ((Object) this.f906p) + ", gbcAcceptanceState=" + ((Object) this.f907q) + ", gbcData=" + this.f908r + ", paidUserIndicated=" + this.f909s + ')';
    }
}
