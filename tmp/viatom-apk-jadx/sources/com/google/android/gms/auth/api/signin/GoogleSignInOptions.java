package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import c0.d;
import c0.e;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.measurement.a4;
import j0.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes3.dex */
public class GoogleSignInOptions extends a implements g0.a, ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* renamed from: k, reason: collision with root package name */
    public static final GoogleSignInOptions f1832k;

    /* renamed from: l, reason: collision with root package name */
    public static final Scope f1833l;

    /* renamed from: m, reason: collision with root package name */
    public static final Scope f1834m;

    /* renamed from: n, reason: collision with root package name */
    public static final Scope f1835n;

    /* renamed from: o, reason: collision with root package name */
    public static final Scope f1836o;

    /* renamed from: p, reason: collision with root package name */
    public static final d f1837p;

    /* renamed from: a, reason: collision with root package name */
    public final int f1838a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1839b;

    /* renamed from: c, reason: collision with root package name */
    public final Account f1840c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1841d;
    public final boolean e;
    public final boolean f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f1842i;

    /* renamed from: j, reason: collision with root package name */
    public final String f1843j;

    static {
        Scope scope = new Scope(1, "profile");
        f1833l = new Scope(1, NotificationCompat.CATEGORY_EMAIL);
        Scope scope2 = new Scope(1, "openid");
        f1834m = scope2;
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        f1835n = scope3;
        f1836o = new Scope(1, "https://www.googleapis.com/auth/games");
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(f1836o)) {
            Scope scope4 = f1835n;
            if (hashSet.contains(scope4)) {
                hashSet.remove(scope4);
            }
        }
        f1832k = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, map, null);
        HashSet hashSet2 = new HashSet();
        HashMap map2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(f1836o)) {
            Scope scope5 = f1835n;
            if (hashSet2.contains(scope5)) {
                hashSet2.remove(scope5);
            }
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, map2, null);
        CREATOR = new e(1);
        f1837p = new d(1);
    }

    public GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z9, boolean z10, boolean z11, String str, String str2, HashMap map, String str3) {
        this.f1838a = i10;
        this.f1839b = arrayList;
        this.f1840c = account;
        this.f1841d = z9;
        this.e = z10;
        this.f = z11;
        this.g = str;
        this.h = str2;
        this.f1842i = new ArrayList(map.values());
        this.f1843j = str3;
    }

    public static GoogleSignInOptions b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(1, jSONArray.getString(i10)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), null);
    }

    public static HashMap c(ArrayList arrayList) {
        HashMap map = new HashMap();
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                d0.a aVar = (d0.a) obj;
                map.put(Integer.valueOf(aVar.f6763b), aVar);
            }
        }
        return map;
    }

    public final boolean equals(Object obj) {
        String str = this.g;
        ArrayList arrayList = this.f1839b;
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            ArrayList arrayList2 = googleSignInOptions.f1839b;
            String str2 = googleSignInOptions.g;
            if (this.f1842i.isEmpty() && googleSignInOptions.f1842i.isEmpty() && arrayList.size() == new ArrayList(arrayList2).size() && arrayList.containsAll(new ArrayList(arrayList2))) {
                Account account = this.f1840c;
                Account account2 = googleSignInOptions.f1840c;
                if (account == null) {
                    if (account2 != null) {
                        return false;
                    }
                } else if (!account.equals(account2)) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        return false;
                    }
                } else if (!str.equals(str2)) {
                    return false;
                }
                if (this.f == googleSignInOptions.f && this.f1841d == googleSignInOptions.f1841d && this.e == googleSignInOptions.e) {
                    return TextUtils.equals(this.f1843j, googleSignInOptions.f1843j);
                }
                return false;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f1839b;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(((Scope) arrayList2.get(i10)).f1856b);
        }
        Collections.sort(arrayList);
        int iHashCode = (arrayList.hashCode() + (1 * 31)) * 31;
        Account account = this.f1840c;
        int iHashCode2 = (iHashCode + (account == null ? 0 : account.hashCode())) * 31;
        String str = this.g;
        int iHashCode3 = (((((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + (this.f ? 1 : 0)) * 31) + (this.f1841d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        String str2 = this.f1843j;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f1838a);
        a4.H(parcel, 2, new ArrayList(this.f1839b));
        a4.E(parcel, 3, this.f1840c, i10);
        a4.O(parcel, 4, 4);
        parcel.writeInt(this.f1841d ? 1 : 0);
        a4.O(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        a4.O(parcel, 6, 4);
        parcel.writeInt(this.f ? 1 : 0);
        a4.F(parcel, 7, this.g);
        a4.F(parcel, 8, this.h);
        a4.H(parcel, 9, this.f1842i);
        a4.F(parcel, 10, this.f1843j);
        a4.M(parcel, I);
    }
}
