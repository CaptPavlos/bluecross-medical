package h5;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements Parcelable {
    public static Parcelable.Creator<k> CREATOR = new g0.l(3);

    /* renamed from: a, reason: collision with root package name */
    public int f8632a;

    /* renamed from: b, reason: collision with root package name */
    public String f8633b;

    /* renamed from: c, reason: collision with root package name */
    public String f8634c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8635d;
    public boolean e;
    public int f;
    public int g;
    public ArrayList h;

    public /* synthetic */ k(int i10, String str, int i11) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str, (String) null);
    }

    public final void a(JSONObject jSONObject, int i10) {
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f8633b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("id")) {
            this.f8632a = jSONObject.optInt("id");
        }
        this.f = i10;
    }

    public final void b(JSONObject jSONObject) {
        if (!jSONObject.isNull("id")) {
            this.f8632a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f8633b = jSONObject.optString(RewardPlus.NAME);
        } else if (!jSONObject.isNull("value")) {
            this.f8633b = jSONObject.optString("value");
        }
        if (!jSONObject.isNull("description")) {
            this.f8634c = jSONObject.optString("description");
        }
        this.f8635d = true;
    }

    public final void c(Bundle bundle) {
        this.f8632a = bundle.getInt("id");
        this.f8633b = bundle.getString(RewardPlus.NAME);
        this.f8634c = bundle.getString("description");
        this.f8635d = bundle.getBoolean("isFloating");
        this.f = bundle.getInt("parentCategoryId");
        this.g = bundle.getInt("isGame");
        this.e = bundle.getBoolean("isLeaf");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeInt(this.f8632a);
        parcel.writeString(this.f8633b);
        parcel.writeString(this.f8634c);
        parcel.writeInt(this.f8635d ? 1 : 0);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeTypedList(this.h);
    }

    public k(int i10, String str, String str2) {
        this.f8632a = i10;
        this.f8633b = str;
        this.f8634c = str2;
    }
}
