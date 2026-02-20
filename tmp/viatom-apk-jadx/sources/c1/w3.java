package c1;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w3 implements ServiceConnection, i0.b, i0.c {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f1552a;

    /* renamed from: b, reason: collision with root package name */
    public volatile r0 f1553b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x3 f1554c;

    public w3(x3 x3Var) {
        this.f1554c = x3Var;
    }

    @Override // i0.c
    public final void a(f0.b bVar) {
        x3 x3Var = this.f1554c;
        r1 r1Var = x3Var.f1149a.g;
        u1.m(r1Var);
        r1Var.l();
        w0 w0Var = x3Var.f1149a.f;
        if (w0Var == null || !w0Var.f1213b) {
            w0Var = null;
        }
        if (w0Var != null) {
            w0Var.f1545n.c(bVar, "Service connection failed");
        }
        synchronized (this) {
            this.f1552a = false;
            this.f1553b = null;
        }
        r1 r1Var2 = this.f1554c.f1149a.g;
        u1.m(r1Var2);
        r1Var2.p(new k1.a(this, bVar, 12, false));
    }

    public final void b() throws Throwable {
        x3 x3Var = this.f1554c;
        x3Var.g();
        Context context = x3Var.f1149a.f1475a;
        synchronized (this) {
            try {
                try {
                    if (this.f1552a) {
                        w0 w0Var = this.f1554c.f1149a.f;
                        u1.m(w0Var);
                        w0Var.f1545n.b("Connection attempt already in progress");
                    } else {
                        if (this.f1553b != null && (this.f1553b.e() || this.f1553b.h())) {
                            w0 w0Var2 = this.f1554c.f1149a.f;
                            u1.m(w0Var2);
                            w0Var2.f1545n.b("Already awaiting connection attempt");
                            return;
                        }
                        this.f1553b = new r0(context, Looper.getMainLooper(), i0.j0.a(context), f0.f.f8003b, 93, this, this, null);
                        w0 w0Var3 = this.f1554c.f1149a.f;
                        u1.m(w0Var3);
                        w0Var3.f1545n.b("Connecting to remote service");
                        this.f1552a = true;
                        i0.y.g(this.f1553b);
                        this.f1553b.m();
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // i0.b
    public final void c(int i10) {
        u1 u1Var = this.f1554c.f1149a;
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        r1Var.l();
        w0 w0Var = u1Var.f;
        u1.m(w0Var);
        w0Var.f1544m.b("Service connection suspended");
        r1 r1Var2 = u1Var.g;
        u1.m(r1Var2);
        r1Var2.p(new a4.a(this, 2));
    }

    @Override // i0.b
    public final void d() {
        r1 r1Var = this.f1554c.f1149a.g;
        u1.m(r1Var);
        r1Var.l();
        synchronized (this) {
            try {
                i0.y.g(this.f1553b);
                i0 i0Var = (i0) this.f1553b.t();
                r1 r1Var2 = this.f1554c.f1149a.g;
                u1.m(r1Var2);
                r1Var2.p(new u3(this, i0Var, 1));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f1553b = null;
                this.f1552a = false;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        r1 r1Var = this.f1554c.f1149a.g;
        u1.m(r1Var);
        r1Var.l();
        synchronized (this) {
            if (iBinder == null) {
                this.f1552a = false;
                w0 w0Var = this.f1554c.f1149a.f;
                u1.m(w0Var);
                w0Var.f.b("Service connected with null binder");
                return;
            }
            i0 g0Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    g0Var = iInterfaceQueryLocalInterface instanceof i0 ? (i0) iInterfaceQueryLocalInterface : new g0(iBinder);
                    w0 w0Var2 = this.f1554c.f1149a.f;
                    u1.m(w0Var2);
                    w0Var2.f1545n.b("Bound to IMeasurementService interface");
                } else {
                    w0 w0Var3 = this.f1554c.f1149a.f;
                    u1.m(w0Var3);
                    w0Var3.f.c(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                w0 w0Var4 = this.f1554c.f1149a.f;
                u1.m(w0Var4);
                w0Var4.f.b("Service connect failed to get IMeasurementService");
            }
            if (g0Var == null) {
                this.f1552a = false;
                try {
                    m0.a aVarB = m0.a.b();
                    x3 x3Var = this.f1554c;
                    aVarB.c(x3Var.f1149a.f1475a, x3Var.f1571c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                r1 r1Var2 = this.f1554c.f1149a.g;
                u1.m(r1Var2);
                r1Var2.p(new u3(this, g0Var, 0));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        u1 u1Var = this.f1554c.f1149a;
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        r1Var.l();
        w0 w0Var = u1Var.f;
        u1.m(w0Var);
        w0Var.f1544m.b("Service disconnected");
        r1 r1Var2 = u1Var.g;
        u1.m(r1Var2);
        r1Var2.p(new k1.a(this, componentName, 11, false));
    }
}
