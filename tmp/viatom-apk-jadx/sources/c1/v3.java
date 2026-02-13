package c1;

import android.os.RemoteException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class v3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x3 f1517b;

    public /* synthetic */ v3(x3 x3Var, int i10) {
        this.f1516a = i10;
        this.f1517b = x3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1516a) {
            case 0:
                this.f1517b.m();
                break;
            case 1:
                x3 x3Var = this.f1517b;
                u1 u1Var = x3Var.f1149a;
                i0 i0Var = x3Var.f1572d;
                if (i0Var == null) {
                    w0 w0Var = u1Var.f;
                    u1.m(w0Var);
                    w0Var.f.b("Failed to send Dma consent settings to service");
                    break;
                } else {
                    try {
                        i0Var.h(x3Var.w(false));
                        x3Var.t();
                        break;
                    } catch (RemoteException e) {
                        w0 w0Var2 = u1Var.f;
                        u1.m(w0Var2);
                        w0Var2.f.c(e, "Failed to send Dma consent settings to the service");
                        return;
                    }
                }
            default:
                x3 x3Var2 = this.f1517b;
                u1 u1Var2 = x3Var2.f1149a;
                i0 i0Var2 = x3Var2.f1572d;
                if (i0Var2 == null) {
                    w0 w0Var3 = u1Var2.f;
                    u1.m(w0Var3);
                    w0Var3.f.b("Failed to send storage consent settings to service");
                    break;
                } else {
                    try {
                        i0Var2.j(x3Var2.w(false));
                        x3Var2.t();
                        break;
                    } catch (RemoteException e3) {
                        w0 w0Var4 = u1Var2.f;
                        u1.m(w0Var4);
                        w0Var4.f.c(e3, "Failed to send storage consent settings to the service");
                    }
                }
        }
    }
}
