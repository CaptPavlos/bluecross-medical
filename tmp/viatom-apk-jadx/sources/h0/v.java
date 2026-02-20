package h0;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.h0;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends u0.b implements g0.e, g0.f {

    /* renamed from: q, reason: collision with root package name */
    public static final b0.b f8404q = e1.b.f7624a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8405b;

    /* renamed from: k, reason: collision with root package name */
    public final Handler f8406k;

    /* renamed from: l, reason: collision with root package name */
    public final b0.b f8407l;

    /* renamed from: m, reason: collision with root package name */
    public final Set f8408m;

    /* renamed from: n, reason: collision with root package name */
    public final d5.j f8409n;

    /* renamed from: o, reason: collision with root package name */
    public f1.a f8410o;

    /* renamed from: p, reason: collision with root package name */
    public p f8411p;

    public v(Context context, h0 h0Var, d5.j jVar) {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        this.f8405b = context;
        this.f8406k = h0Var;
        this.f8409n = jVar;
        this.f8408m = (Set) jVar.f7134b;
        this.f8407l = f8404q;
    }

    @Override // g0.f
    public final void a(f0.b bVar) {
        this.f8411p.h(bVar);
    }

    @Override // g0.e
    public final void c(int i10) {
        p pVar = this.f8411p;
        n nVar = (n) ((e) pVar.f).f8368j.get((a) pVar.f8395c);
        if (nVar != null) {
            if (nVar.f8388q) {
                nVar.p(new f0.b(17));
            } else {
                nVar.c(i10);
            }
        }
    }

    @Override // g0.e
    public final void d() {
        f1.a aVar = this.f8410o;
        aVar.getClass();
        boolean z9 = false;
        try {
            aVar.A.getClass();
            Account account = new Account("<<default account>>", "com.google");
            GoogleSignInAccount googleSignInAccountB = "<<default account>>".equals(account.name) ? d0.b.a(aVar.f8867c).b() : null;
            Integer num = aVar.C;
            i0.y.g(num);
            i0.r rVar = new i0.r(2, account, num.intValue(), googleSignInAccountB);
            f1.c cVar = (f1.c) aVar.t();
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(cVar.f2253k);
            int i10 = v0.a.f13116a;
            parcelObtain.writeInt(1);
            int I = a4.I(parcelObtain, 20293);
            a4.O(parcelObtain, 1, 4);
            parcelObtain.writeInt(1);
            a4.E(parcelObtain, 2, rVar, 0);
            a4.M(parcelObtain, I);
            parcelObtain.writeStrongBinder(this);
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                cVar.f2252b.transact(12, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.f8406k.post(new k1.a(this, new f1.e(1, new f0.b(8, null), null), 18, z9));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }
}
