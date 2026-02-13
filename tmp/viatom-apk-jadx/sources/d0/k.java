package d0;

import a6.o;
import android.content.Context;
import android.os.Binder;
import android.os.Parcel;
import android.text.TextUtils;
import c1.d0;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.measurement.a4;
import h0.q;
import i0.y;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends u0.b {

    /* renamed from: b, reason: collision with root package name */
    public final RevocationBoundService f6782b;

    public k(RevocationBoundService revocationBoundService) {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService", 0);
        this.f6782b = revocationBoundService;
    }

    @Override // u0.b
    public final boolean G(int i10, Parcel parcel, Parcel parcel2) {
        BasePendingResult kVar;
        String strD;
        RevocationBoundService revocationBoundService = this.f6782b;
        if (i10 != 1) {
            if (i10 != 2) {
                return false;
            }
            I();
            i.E(revocationBoundService).F();
            return true;
        }
        I();
        b bVarA = b.a(revocationBoundService);
        GoogleSignInAccount googleSignInAccountB = bVarA.b();
        GoogleSignInOptions googleSignInOptionsB = GoogleSignInOptions.f1832k;
        if (googleSignInAccountB != null) {
            String strD2 = bVarA.d("defaultGoogleSignInAccount");
            if (TextUtils.isEmpty(strD2) || (strD = bVarA.d(b.f("googleSignInOptions", strD2))) == null) {
                googleSignInOptionsB = null;
            } else {
                try {
                    googleSignInOptionsB = GoogleSignInOptions.b(strD);
                } catch (JSONException unused) {
                }
            }
        }
        c0.a aVarO = a4.o(revocationBoundService, googleSignInOptionsB);
        if (googleSignInAccountB != null) {
            q qVar = aVarO.h;
            Context context = aVarO.f8187a;
            boolean z9 = aVarO.d() == 3;
            h.f6778a.b("Revoking access", new Object[0]);
            String strD3 = b.a(context).d("refreshToken");
            h.b(context);
            if (!z9) {
                g gVar = new g(qVar, 1);
                qVar.b(gVar);
                kVar = gVar;
            } else if (strD3 == null) {
                o oVar = c.f6769c;
                Status status = new Status(4, null, null, null);
                y.a("Status code must not be SUCCESS", !false);
                kVar = new g0.k(status);
                kVar.e(status);
            } else {
                c cVar = new c(strD3);
                new Thread(cVar).start();
                kVar = cVar.f6771b;
            }
            kVar.a(new h0.j(kVar, new h1.i(), new d0(17)));
        } else {
            aVarO.c();
        }
        return true;
    }

    public final void I() {
        if (n0.b.b(this.f6782b, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(String.valueOf(callingUid).length() + 41);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }
}
