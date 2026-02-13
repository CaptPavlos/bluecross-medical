package u0;

import a4.f;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;
import d5.j;
import h0.n;
import i0.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends h {

    /* renamed from: z, reason: collision with root package name */
    public final b0.c f12883z;

    public d(Context context, Looper looper, j jVar, b0.c cVar, n nVar, n nVar2) {
        super(context, looper, 68, jVar, nVar, nVar2, 0);
        cVar = cVar == null ? b0.c.f820c : cVar;
        f fVar = new f(2);
        fVar.f218b = Boolean.FALSE;
        fVar.f218b = Boolean.valueOf(cVar.f821a);
        fVar.f219c = cVar.f822b;
        byte[] bArr = new byte[16];
        a.f12880a.nextBytes(bArr);
        fVar.f219c = Base64.encodeToString(bArr, 11);
        this.f12883z = new b0.c(fVar);
    }

    @Override // i0.e
    public final int i() {
        return 12800000;
    }

    @Override // i0.e
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterfaceQueryLocalInterface instanceof e ? (e) iInterfaceQueryLocalInterface : new e(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService", 1);
    }

    @Override // i0.e
    public final Bundle r() {
        b0.c cVar = this.f12883z;
        cVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", null);
        bundle.putBoolean("force_save_dialog", cVar.f821a);
        bundle.putString("log_session_id", cVar.f822b);
        return bundle;
    }

    @Override // i0.e
    public final String u() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // i0.e
    public final String v() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}
