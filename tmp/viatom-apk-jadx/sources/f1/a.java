package f1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import d5.j;
import g0.f;
import i0.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends h {
    public final j A;
    public final Bundle B;
    public final Integer C;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f8037z;

    public a(Context context, Looper looper, j jVar, Bundle bundle, g0.e eVar, f fVar) {
        super(context, looper, 44, jVar, eVar, fVar, 0);
        this.f8037z = true;
        this.A = jVar;
        this.B = bundle;
        this.C = (Integer) jVar.g;
    }

    @Override // i0.e
    public final int i() {
        return 12451000;
    }

    @Override // i0.e, g0.b
    public final boolean l() {
        return this.f8037z;
    }

    @Override // i0.e
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new c(iBinder, "com.google.android.gms.signin.internal.ISignInService", 2);
    }

    @Override // i0.e
    public final Bundle r() {
        j jVar = this.A;
        boolean zEquals = this.f8867c.getPackageName().equals((String) jVar.f7136d);
        Bundle bundle = this.B;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) jVar.f7136d);
        }
        return bundle;
    }

    @Override // i0.e
    public final String u() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // i0.e
    public final String v() {
        return "com.google.android.gms.signin.service.START";
    }
}
