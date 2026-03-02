package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import c0.e;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.measurement.a4;
import i0.y;
import j0.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class SignInAccount extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<SignInAccount> CREATOR = new e(2);

    /* renamed from: a, reason: collision with root package name */
    public final String f1844a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f1845b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1846c;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f1845b = googleSignInAccount;
        y.e(str, "8.3 and 8.4 SDKs require non-null email");
        this.f1844a = str;
        y.e(str2, "8.3 and 8.4 SDKs require non-null userId");
        this.f1846c = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.F(parcel, 4, this.f1844a);
        a4.E(parcel, 7, this.f1845b, i10);
        a4.F(parcel, 8, this.f1846c);
        a4.M(parcel, I);
    }
}
