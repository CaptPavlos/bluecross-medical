package h5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.UptodownApp;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e1 implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public String f8512a;

    /* renamed from: b, reason: collision with root package name */
    public String f8513b;

    /* renamed from: c, reason: collision with root package name */
    public String f8514c;

    /* renamed from: d, reason: collision with root package name */
    public String f8515d;
    public String g;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f8517j;

    /* renamed from: k, reason: collision with root package name */
    public int f8518k;

    /* renamed from: l, reason: collision with root package name */
    public String f8519l;

    /* renamed from: m, reason: collision with root package name */
    public String f8520m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8521n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8522o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8523p;

    /* renamed from: q, reason: collision with root package name */
    public static final c1 f8511q = new c1();
    public static Parcelable.Creator<e1> CREATOR = new g0.l(14);
    public long e = -1;
    public String f = "type0";

    /* renamed from: i, reason: collision with root package name */
    public int f8516i = -1;

    public final String a() {
        if (this.f8514c == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = this.f8514c;
        str.getClass();
        sb.append(str);
        float f = UptodownApp.E;
        return a3.a.o(sb, UptodownApp.M, ":webp");
    }

    public final void b(Context context, JSONObject jSONObject) {
        context.getClass();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("udata");
        if (jSONObjectOptJSONObject != null) {
            if (!jSONObjectOptJSONObject.isNull("id")) {
                this.f8512a = jSONObjectOptJSONObject.optString("id");
            }
            if (!jSONObjectOptJSONObject.isNull("username")) {
                this.f8515d = jSONObjectOptJSONObject.optString("username");
            }
            if (!jSONObjectOptJSONObject.isNull("avatar")) {
                this.f8514c = jSONObjectOptJSONObject.optString("avatar");
            }
            if (!jSONObjectOptJSONObject.isNull("registeredTimestamp")) {
                this.e = jSONObjectOptJSONObject.optLong("registeredTimestamp");
            }
            if (!jSONObjectOptJSONObject.isNull("usernameFormat")) {
                this.f = jSONObjectOptJSONObject.optString("usernameFormat");
            }
            if (!jSONObjectOptJSONObject.isNull("backgroundImage")) {
                this.g = jSONObjectOptJSONObject.optString("backgroundImage");
            }
            if (!jSONObjectOptJSONObject.isNull("hasNotifications")) {
                this.f8523p = jSONObjectOptJSONObject.optInt("hasNotifications") == 1;
            }
        }
        if (jSONObject.isNull("utoken")) {
            c1.c(context);
        } else {
            String strOptString = jSONObject.optString("utoken");
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                editorEdit.putString("UTOKEN", strOptString);
                editorEdit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (jSONObject.isNull("turboToken")) {
            return;
        }
        this.f8520m = jSONObject.optString("turboToken");
    }

    public final void c(JSONObject jSONObject) {
        if (!jSONObject.isNull("userID")) {
            this.f8512a = jSONObject.optString("userID");
        }
        if (!jSONObject.isNull("username")) {
            this.f8515d = jSONObject.optString("username");
        }
        if (!jSONObject.isNull("registeredTimeAgo")) {
            this.f8519l = jSONObject.optString("registeredTimeAgo");
        }
        if (!jSONObject.isNull("avatar")) {
            this.f8514c = jSONObject.optString("avatar");
        }
        if (!jSONObject.isNull("isTurbo")) {
            this.f8521n = jSONObject.optInt("isTurbo") == 1;
        }
        if (!jSONObject.isNull("usernameFormat")) {
            this.f = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("reviewsCount")) {
            this.h = jSONObject.optInt("reviewsCount");
        }
        if (!jSONObject.isNull("backgroundImage")) {
            this.g = jSONObject.optString("backgroundImage");
        }
        if (!jSONObject.isNull("following")) {
            this.f8516i = jSONObject.optInt("following");
        }
        if (!jSONObject.isNull("countFollowers")) {
            this.f8517j = jSONObject.optInt("countFollowers");
        }
        if (jSONObject.isNull("countFollowings")) {
            return;
        }
        this.f8518k = jSONObject.optInt("countFollowings");
    }

    public final boolean d() {
        String str = this.f8520m;
        return !(str == null || str.length() == 0) || this.f8521n;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final void e(Context context) {
        context.getClass();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("SharedPreferencesUser", 0).edit();
        editorEdit.putString("user_id", this.f8512a);
        editorEdit.putString("user_email", this.f8513b);
        editorEdit.putString("user_picture", this.f8514c);
        editorEdit.putString("user_name", this.f8515d);
        editorEdit.putLong("registered_timestamp", this.e);
        editorEdit.putString("is_turbo", this.f8520m);
        editorEdit.putString("username_format", this.f);
        editorEdit.putString("background_image", this.g);
        editorEdit.putBoolean("has_news_on_feed", this.f8523p);
        editorEdit.apply();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeString(this.f8512a);
        parcel.writeString(this.f8513b);
        parcel.writeString(this.f8514c);
        parcel.writeString(this.f8515d);
        parcel.writeString(this.f8520m);
        parcel.writeString(this.f);
        parcel.writeLong(this.e);
        parcel.writeString(this.g);
        if (this.f8521n) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.h);
        parcel.writeString(this.f8519l);
        parcel.writeInt(this.f8516i);
        parcel.writeInt(this.f8517j);
        parcel.writeInt(this.f8518k);
        if (this.f8522o) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
        if (this.f8523p) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }
}
