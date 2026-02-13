package b9;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends i {
    public final ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public final String f910i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f911j;

    public m(ArrayList arrayList, ArrayList arrayList2, String str) {
        this.h = arrayList;
        this.f910i = str;
        this.f911j = arrayList2;
    }

    @Override // b9.i
    public final String d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            arrayList.add(new JSONObject(((a) obj).d()));
        }
        jSONObject.put("userEvents", new JSONArray((Collection) arrayList));
        jSONObject.putOpt("acceptanceState", this.f910i);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = this.f911j;
        int size2 = arrayList4.size();
        while (i10 < size2) {
            Object obj2 = arrayList4.get(i10);
            i10++;
            s6.i iVar = (s6.i) obj2;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(String.valueOf(((Number) iVar.f12693a).intValue()), iVar.f12694b);
            arrayList3.add(jSONObject2);
        }
        jSONObject.putOpt("gbcData", new JSONArray((Collection) arrayList3));
        c(jSONObject);
        String string = jSONObject.toString();
        string.getClass();
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.h.equals(mVar.h) && this.f910i.equals(mVar.f910i) && this.f911j.equals(mVar.f911j);
    }

    public final int hashCode() {
        return this.f911j.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(this.h.hashCode() * 31, 31, this.f910i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TrackingUserGBCDoneLog(userEvents=");
        sb.append(this.h);
        sb.append(", acceptanceState=");
        sb.append((Object) this.f910i);
        sb.append(", gbcData=");
        return a3.a.p(sb, this.f911j, ')');
    }
}
