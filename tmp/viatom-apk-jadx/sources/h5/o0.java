package h5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o0 implements Parcelable {
    public static final n0 CREATOR = new n0();

    /* renamed from: a, reason: collision with root package name */
    public String f8675a;

    /* renamed from: b, reason: collision with root package name */
    public int f8676b;

    /* renamed from: c, reason: collision with root package name */
    public int f8677c;

    /* renamed from: d, reason: collision with root package name */
    public String f8678d;
    public ArrayList e;

    public final void a(JSONObject jSONObject) {
        if (!jSONObject.isNull("sha256")) {
            this.f8675a = jSONObject.optString("sha256");
        }
        if (!jSONObject.isNull("scans")) {
            this.f8676b = jSONObject.optInt("scans");
        }
        if (!jSONObject.isNull("positives")) {
            this.f8677c = jSONObject.optInt("positives");
        }
        if (!jSONObject.isNull("lastAnalysis")) {
            this.f8678d = jSONObject.optString("lastAnalysis");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("infections");
        if (jSONArrayOptJSONArray != null) {
            this.e = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                y yVar = new y();
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    if (!jSONObjectOptJSONObject.isNull("antivirusName")) {
                        yVar.f8792a = jSONObjectOptJSONObject.optString("antivirusName");
                    }
                    if (!jSONObjectOptJSONObject.isNull("virusName")) {
                        yVar.f8793b = jSONObjectOptJSONObject.optString("virusName");
                    }
                }
                ArrayList arrayList = this.e;
                arrayList.getClass();
                arrayList.add(yVar);
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeString(this.f8675a);
        parcel.writeInt(this.f8676b);
        parcel.writeInt(this.f8677c);
        parcel.writeString(this.f8678d);
        parcel.writeList(this.e);
    }
}
