package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import c0.e;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.measurement.a4;
import i0.y;
import j0.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes3.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new e(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f1823a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1824b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1825c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1826d;
    public final String e;
    public final Uri f;
    public String g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final String f1827i;

    /* renamed from: j, reason: collision with root package name */
    public final List f1828j;

    /* renamed from: k, reason: collision with root package name */
    public final String f1829k;

    /* renamed from: l, reason: collision with root package name */
    public final String f1830l;

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f1831m = new HashSet();

    public GoogleSignInAccount(int i10, String str, String str2, String str3, String str4, Uri uri, String str5, long j10, String str6, ArrayList arrayList, String str7, String str8) {
        this.f1823a = i10;
        this.f1824b = str;
        this.f1825c = str2;
        this.f1826d = str3;
        this.e = str4;
        this.f = uri;
        this.g = str5;
        this.h = j10;
        this.f1827i = str6;
        this.f1828j = arrayList;
        this.f1829k = str7;
        this.f1830l = str8;
    }

    public static GoogleSignInAccount b(String str) throws JSONException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j10 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(1, jSONArray.getString(i10)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has(NotificationCompat.CATEGORY_EMAIL) ? jSONObject.optString(NotificationCompat.CATEGORY_EMAIL) : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        y.d(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j10, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f1827i.equals(this.f1827i)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.f1828j);
        hashSet.addAll(googleSignInAccount.f1831m);
        HashSet hashSet2 = new HashSet(this.f1828j);
        hashSet2.addAll(this.f1831m);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int iHashCode = this.f1827i.hashCode() + 527;
        HashSet hashSet = new HashSet(this.f1828j);
        hashSet.addAll(this.f1831m);
        return (iHashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f1823a);
        a4.F(parcel, 2, this.f1824b);
        a4.F(parcel, 3, this.f1825c);
        a4.F(parcel, 4, this.f1826d);
        a4.F(parcel, 5, this.e);
        a4.E(parcel, 6, this.f, i10);
        a4.F(parcel, 7, this.g);
        a4.O(parcel, 8, 8);
        parcel.writeLong(this.h);
        a4.F(parcel, 9, this.f1827i);
        a4.H(parcel, 10, this.f1828j);
        a4.F(parcel, 11, this.f1829k);
        a4.F(parcel, 12, this.f1830l);
        a4.M(parcel, I);
    }
}
