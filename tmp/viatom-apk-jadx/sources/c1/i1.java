package c1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i1 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final String f1268a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j1 f1269b;

    public i1(j1 j1Var, String str) {
        Objects.requireNonNull(j1Var);
        this.f1269b = j1Var;
        this.f1268a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        j1 j1Var = this.f1269b;
        if (iBinder == null) {
            w0 w0Var = j1Var.f1286b.f;
            u1.m(w0Var);
            w0Var.f1540i.b("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i10 = com.google.android.gms.internal.measurement.b0.f1886a;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            com.google.android.gms.internal.measurement.c0 a0Var = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.measurement.c0 ? (com.google.android.gms.internal.measurement.c0) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.measurement.a0(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService", 0);
            u1 u1Var = j1Var.f1286b;
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f1545n.b("Install Referrer Service connected");
            r1 r1Var = u1Var.g;
            u1.m(r1Var);
            r1Var.p(new k1.a(this, a0Var, this));
        } catch (RuntimeException e) {
            w0 w0Var3 = j1Var.f1286b.f;
            u1.m(w0Var3);
            w0Var3.f1540i.c(e, "Exception occurred while calling Install Referrer API");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        w0 w0Var = this.f1269b.f1286b.f;
        u1.m(w0Var);
        w0Var.f1545n.b("Install Referrer Service disconnected");
    }
}
