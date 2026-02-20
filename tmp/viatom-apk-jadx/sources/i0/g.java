package i0;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Scope;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends j0.a {

    @NonNull
    public static final Parcelable.Creator<g> CREATOR = new g0.l(26);

    /* renamed from: o, reason: collision with root package name */
    public static final Scope[] f8891o = new Scope[0];

    /* renamed from: p, reason: collision with root package name */
    public static final f0.d[] f8892p = new f0.d[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f8893a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8894b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8895c;

    /* renamed from: d, reason: collision with root package name */
    public String f8896d;
    public IBinder e;
    public Scope[] f;
    public Bundle g;
    public Account h;

    /* renamed from: i, reason: collision with root package name */
    public f0.d[] f8897i;

    /* renamed from: j, reason: collision with root package name */
    public f0.d[] f8898j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f8899k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8900l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8901m;

    /* renamed from: n, reason: collision with root package name */
    public final String f8902n;

    public g(int i10, int i11, int i12, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, f0.d[] dVarArr, f0.d[] dVarArr2, boolean z9, int i13, boolean z10, String str2) {
        Scope[] scopeArr2 = scopeArr == null ? f8891o : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        f0.d[] dVarArr3 = f8892p;
        f0.d[] dVarArr4 = dVarArr == null ? dVarArr3 : dVarArr;
        dVarArr3 = dVarArr2 != null ? dVarArr2 : dVarArr3;
        this.f8893a = i10;
        this.f8894b = i11;
        this.f8895c = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f8896d = "com.google.android.gms";
        } else {
            this.f8896d = str;
        }
        if (i10 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i14 = a.f8858b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                i l0Var = iInterfaceQueryLocalInterface instanceof i ? (i) iInterfaceQueryLocalInterface : new l0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 3);
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        l0 l0Var2 = (l0) l0Var;
                        Parcel parcelC = l0Var2.c(l0Var2.G(), 2);
                        Account account3 = (Account) x0.a.a(parcelC, Account.CREATOR);
                        parcelC.recycle();
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        account2 = account3;
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                    throw th;
                }
            }
            this.h = account2;
        } else {
            this.e = iBinder;
            this.h = account;
        }
        this.f = scopeArr2;
        this.g = bundle2;
        this.f8897i = dVarArr4;
        this.f8898j = dVarArr3;
        this.f8899k = z9;
        this.f8900l = i13;
        this.f8901m = z10;
        this.f8902n = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        g0.l.a(this, parcel, i10);
    }
}
