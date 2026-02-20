package d0;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import h0.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends i0.h {

    /* renamed from: z, reason: collision with root package name */
    public final GoogleSignInOptions f6774z;

    public e(Context context, Looper looper, d5.j jVar, GoogleSignInOptions googleSignInOptions, n nVar, n nVar2) {
        super(context, looper, 91, jVar, nVar, nVar2, 0);
        Set<Scope> set = (Set) jVar.f7135c;
        c0.b bVar = googleSignInOptions != null ? new c0.b(googleSignInOptions) : new c0.b();
        byte[] bArr = new byte[16];
        u0.a.f12880a.nextBytes(bArr);
        bVar.f974i = Base64.encodeToString(bArr, 11);
        if (!set.isEmpty()) {
            for (Scope scope : set) {
                HashSet hashSet = bVar.f970a;
                hashSet.add(scope);
                hashSet.addAll(Arrays.asList(new Scope[0]));
            }
        }
        Scope scope2 = GoogleSignInOptions.f1836o;
        HashSet hashSet2 = bVar.f970a;
        if (hashSet2.contains(scope2)) {
            Scope scope3 = GoogleSignInOptions.f1835n;
            if (hashSet2.contains(scope3)) {
                hashSet2.remove(scope3);
            }
        }
        if (bVar.f973d && (bVar.f == null || !hashSet2.isEmpty())) {
            hashSet2.add(GoogleSignInOptions.f1834m);
        }
        this.f6774z = new GoogleSignInOptions(3, new ArrayList(hashSet2), bVar.f, bVar.f973d, bVar.f971b, bVar.f972c, bVar.e, bVar.g, bVar.h, bVar.f974i);
    }

    @Override // i0.e
    public final int i() {
        return 12451000;
    }

    @Override // i0.e
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof j ? (j) iInterfaceQueryLocalInterface : new j(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService", 1);
    }

    @Override // i0.e
    public final String u() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // i0.e
    public final String v() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
}
