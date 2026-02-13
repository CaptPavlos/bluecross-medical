package c1;

import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1285a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final u1 f1286b;

    public j1(v4 v4Var) {
        this.f1286b = v4Var.f1525l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a() {
        switch (this.f1285a) {
            case 0:
                u1 u1Var = this.f1286b;
                boolean z9 = false;
                try {
                    p0.b bVarA = p0.c.a(u1Var.f1475a);
                    if (bVarA == null) {
                        w0 w0Var = u1Var.f;
                        u1.m(w0Var);
                        w0Var.f1545n.b("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                        u1Var = u1Var;
                    } else {
                        int i10 = bVarA.b(128, "com.android.vending").versionCode;
                        u1Var = i10;
                        if (i10 >= 80837300) {
                            z9 = true;
                            u1Var = i10;
                        }
                    }
                } catch (Exception e) {
                    w0 w0Var2 = u1Var.f;
                    u1.m(w0Var2);
                    w0Var2.f1545n.c(e, "Failed to retrieve Play Store version for Install Referrer");
                }
                return z9;
            default:
                w0 w0Var3 = this.f1286b.f;
                u1.m(w0Var3);
                return Log.isLoggable(w0Var3.q(), 3);
        }
    }

    public j1(n2 n2Var, u1 u1Var) {
        this.f1286b = u1Var;
    }
}
