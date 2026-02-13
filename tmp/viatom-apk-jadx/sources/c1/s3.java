package c1;

import android.os.RemoteException;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1456a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d5 f1457b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x3 f1458c;

    public s3(x3 x3Var, d5 d5Var) {
        this.f1456a = 4;
        this.f1457b = d5Var;
        Objects.requireNonNull(x3Var);
        this.f1458c = x3Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f1456a) {
            case 0:
                x3 x3Var = this.f1458c;
                i0 i0Var = x3Var.f1572d;
                u1 u1Var = x3Var.f1149a;
                if (i0Var != null) {
                    try {
                        i0Var.p(this.f1457b);
                    } catch (RemoteException e) {
                        w0 w0Var = u1Var.f;
                        u1.m(w0Var);
                        w0Var.f.c(e, "Failed to reset data on the service: remote exception");
                    }
                    x3Var.t();
                    break;
                } else {
                    w0 w0Var2 = u1Var.f;
                    u1.m(w0Var2);
                    w0Var2.f.b("Failed to reset data on the service: not connected to service");
                    break;
                }
            case 1:
                x3 x3Var2 = this.f1458c;
                i0 i0Var2 = x3Var2.f1572d;
                u1 u1Var2 = x3Var2.f1149a;
                if (i0Var2 == null) {
                    w0 w0Var3 = u1Var2.f;
                    u1.m(w0Var3);
                    w0Var3.f.b("Discarding data. Failed to send app launch");
                    break;
                } else {
                    try {
                        d5 d5Var = this.f1457b;
                        g gVar = u1Var2.f1478d;
                        e0 e0Var = f0.f1161c1;
                        if (gVar.q(null, e0Var)) {
                            x3Var2.y(i0Var2, null, d5Var);
                        }
                        i0Var2.C(d5Var);
                        u1Var2.o().l();
                        u1Var2.f1478d.q(null, e0Var);
                        x3Var2.y(i0Var2, null, d5Var);
                        x3Var2.t();
                        break;
                    } catch (RemoteException e3) {
                        w0 w0Var4 = u1Var2.f;
                        u1.m(w0Var4);
                        w0Var4.f.c(e3, "Failed to send app launch to the service");
                        return;
                    }
                }
            case 2:
                x3 x3Var3 = this.f1458c;
                i0 i0Var3 = x3Var3.f1572d;
                u1 u1Var3 = x3Var3.f1149a;
                if (i0Var3 == null) {
                    w0 w0Var5 = u1Var3.f;
                    u1.m(w0Var5);
                    w0Var5.f1540i.b("Failed to send app backgrounded");
                    break;
                } else {
                    try {
                        i0Var3.v(this.f1457b);
                        x3Var3.t();
                        break;
                    } catch (RemoteException e7) {
                        w0 w0Var6 = u1Var3.f;
                        u1.m(w0Var6);
                        w0Var6.f.c(e7, "Failed to send app backgrounded to the service");
                        return;
                    }
                }
            case 3:
                x3 x3Var4 = this.f1458c;
                i0 i0Var4 = x3Var4.f1572d;
                u1 u1Var4 = x3Var4.f1149a;
                if (i0Var4 == null) {
                    w0 w0Var7 = u1Var4.f;
                    u1.m(w0Var7);
                    w0Var7.f.b("Failed to send measurementEnabled to service");
                    break;
                } else {
                    try {
                        i0Var4.g(this.f1457b);
                        x3Var4.t();
                        break;
                    } catch (RemoteException e10) {
                        w0 w0Var8 = u1Var4.f;
                        u1.m(w0Var8);
                        w0Var8.f.c(e10, "Failed to send measurementEnabled to the service");
                        return;
                    }
                }
            default:
                x3 x3Var5 = this.f1458c;
                i0 i0Var5 = x3Var5.f1572d;
                u1 u1Var5 = x3Var5.f1149a;
                if (i0Var5 == null) {
                    w0 w0Var9 = u1Var5.f;
                    u1.m(w0Var9);
                    w0Var9.f.b("Failed to send consent settings to service");
                    break;
                } else {
                    try {
                        i0Var5.t(this.f1457b);
                        x3Var5.t();
                        break;
                    } catch (RemoteException e11) {
                        w0 w0Var10 = u1Var5.f;
                        u1.m(w0Var10);
                        w0Var10.f.c(e11, "Failed to send consent settings to the service");
                    }
                }
        }
    }

    public /* synthetic */ s3(x3 x3Var, d5 d5Var, int i10) {
        this.f1456a = i10;
        this.f1457b = d5Var;
        this.f1458c = x3Var;
    }
}
