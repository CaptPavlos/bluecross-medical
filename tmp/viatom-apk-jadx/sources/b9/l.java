package b9;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends i {
    public final ArrayList h;

    public l(ArrayList arrayList) {
        this.h = arrayList;
    }

    @Override // b9.i
    public final String d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            arrayList.add(new JSONObject(((a) obj).d()));
        }
        jSONObject.put("userEvents", new JSONArray((Collection) arrayList));
        c(jSONObject);
        String string = jSONObject.toString();
        string.getClass();
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.h.equals(((l) obj).h);
    }

    public final int hashCode() {
        return this.h.hashCode();
    }

    public final String toString() {
        return a3.a.p(new StringBuilder("TrackingUserEventsLog(userEvents="), this.h, ')');
    }
}
