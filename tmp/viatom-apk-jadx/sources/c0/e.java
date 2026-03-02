package c0;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f979a;

    public /* synthetic */ e(int i10) {
        this.f979a = i10;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f979a) {
            case 0:
                int iQ = a.a.Q(parcel);
                String strT = null;
                String strT2 = null;
                String strT3 = null;
                String strT4 = null;
                Uri uri = null;
                String strT5 = null;
                String strT6 = null;
                ArrayList arrayListV = null;
                String strT7 = null;
                String strT8 = null;
                long jM = 0;
                int iL = 0;
                while (parcel.dataPosition() < iQ) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 1:
                            iL = a.a.L(parcel, i10);
                            break;
                        case 2:
                            strT = a.a.t(parcel, i10);
                            break;
                        case 3:
                            strT2 = a.a.t(parcel, i10);
                            break;
                        case 4:
                            strT3 = a.a.t(parcel, i10);
                            break;
                        case 5:
                            strT4 = a.a.t(parcel, i10);
                            break;
                        case 6:
                            uri = (Uri) a.a.s(parcel, i10, Uri.CREATOR);
                            break;
                        case 7:
                            strT5 = a.a.t(parcel, i10);
                            break;
                        case '\b':
                            jM = a.a.M(parcel, i10);
                            break;
                        case '\t':
                            strT6 = a.a.t(parcel, i10);
                            break;
                        case '\n':
                            arrayListV = a.a.v(parcel, i10, Scope.CREATOR);
                            break;
                        case 11:
                            strT7 = a.a.t(parcel, i10);
                            break;
                        case '\f':
                            strT8 = a.a.t(parcel, i10);
                            break;
                        default:
                            a.a.O(parcel, i10);
                            break;
                    }
                }
                a.a.y(parcel, iQ);
                return new GoogleSignInAccount(iL, strT, strT2, strT3, strT4, uri, strT5, jM, strT6, arrayListV, strT7, strT8);
            case 1:
                int iQ2 = a.a.Q(parcel);
                ArrayList arrayListV2 = null;
                ArrayList arrayListV3 = null;
                Account account = null;
                String strT9 = null;
                String strT10 = null;
                String strT11 = null;
                int iL2 = 0;
                boolean zI = false;
                boolean zI2 = false;
                boolean zI3 = false;
                while (parcel.dataPosition() < iQ2) {
                    int i11 = parcel.readInt();
                    switch ((char) i11) {
                        case 1:
                            iL2 = a.a.L(parcel, i11);
                            break;
                        case 2:
                            arrayListV3 = a.a.v(parcel, i11, Scope.CREATOR);
                            break;
                        case 3:
                            account = (Account) a.a.s(parcel, i11, Account.CREATOR);
                            break;
                        case 4:
                            zI = a.a.I(parcel, i11);
                            break;
                        case 5:
                            zI2 = a.a.I(parcel, i11);
                            break;
                        case 6:
                            zI3 = a.a.I(parcel, i11);
                            break;
                        case 7:
                            strT9 = a.a.t(parcel, i11);
                            break;
                        case '\b':
                            strT10 = a.a.t(parcel, i11);
                            break;
                        case '\t':
                            arrayListV2 = a.a.v(parcel, i11, d0.a.CREATOR);
                            break;
                        case '\n':
                            strT11 = a.a.t(parcel, i11);
                            break;
                        default:
                            a.a.O(parcel, i11);
                            break;
                    }
                }
                a.a.y(parcel, iQ2);
                return new GoogleSignInOptions(iL2, arrayListV3, account, zI, zI2, zI3, strT9, strT10, GoogleSignInOptions.c(arrayListV2), strT11);
            default:
                int iQ3 = a.a.Q(parcel);
                String strT12 = "";
                GoogleSignInAccount googleSignInAccount = null;
                String strT13 = "";
                while (parcel.dataPosition() < iQ3) {
                    int i12 = parcel.readInt();
                    char c10 = (char) i12;
                    if (c10 == 4) {
                        strT12 = a.a.t(parcel, i12);
                    } else if (c10 == 7) {
                        googleSignInAccount = (GoogleSignInAccount) a.a.s(parcel, i12, GoogleSignInAccount.CREATOR);
                    } else if (c10 != '\b') {
                        a.a.O(parcel, i12);
                    } else {
                        strT13 = a.a.t(parcel, i12);
                    }
                }
                a.a.y(parcel, iQ3);
                return new SignInAccount(strT12, googleSignInAccount, strT13);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        switch (this.f979a) {
            case 0:
                return new GoogleSignInAccount[i10];
            case 1:
                return new GoogleSignInOptions[i10];
            default:
                return new SignInAccount[i10];
        }
    }
}
