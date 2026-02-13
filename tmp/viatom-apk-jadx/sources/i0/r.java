package i0;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends j0.a {
    public static final Parcelable.Creator<r> CREATOR = new g0.l(21);

    /* renamed from: a, reason: collision with root package name */
    public final int f8942a;

    /* renamed from: b, reason: collision with root package name */
    public final Account f8943b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8944c;

    /* renamed from: d, reason: collision with root package name */
    public final GoogleSignInAccount f8945d;

    public r(int i10, Account account, int i11, GoogleSignInAccount googleSignInAccount) {
        this.f8942a = i10;
        this.f8943b = account;
        this.f8944c = i11;
        this.f8945d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f8942a);
        a4.E(parcel, 2, this.f8943b, i10);
        a4.O(parcel, 3, 4);
        parcel.writeInt(this.f8944c);
        a4.E(parcel, 4, this.f8945d, i10);
        a4.M(parcel, I);
    }
}
