package c1;

import android.content.Intent;
import android.os.SystemClock;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e4 extends o {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e4(Object obj, g2 g2Var, int i10) {
        super(g2Var);
        this.e = i10;
        this.f = obj;
    }

    @Override // c1.o
    public final void a() {
        switch (this.e) {
            case 0:
                f4 f4Var = (f4) this.f;
                g4 g4Var = (g4) f4Var.f1221d;
                g4Var.g();
                u1 u1Var = g4Var.f1149a;
                u1Var.f1481k.getClass();
                f4Var.a(SystemClock.elapsedRealtime(), false, false);
                z zVar = u1Var.f1484n;
                u1.j(zVar);
                u1Var.f1481k.getClass();
                zVar.j(SystemClock.elapsedRealtime());
                break;
            case 1:
                l4 l4Var = (l4) this.f;
                l4Var.k();
                w0 w0Var = l4Var.f1149a.f;
                u1.m(w0Var);
                w0Var.f1545n.b("Starting upload from DelayedRunnable");
                l4Var.f1335b.q();
                break;
            default:
                v4 v4Var = (v4) this.f;
                v4Var.b().g();
                String str = (String) v4Var.f1530q.pollFirst();
                if (str != null) {
                    v4Var.f().getClass();
                    v4Var.I = SystemClock.elapsedRealtime();
                    v4Var.a().f1545n.c(str, "Sending trigger URI notification to app");
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                    intent.setPackage(str);
                    v4.S(v4Var.f1525l.f1475a, intent);
                }
                v4Var.H();
                break;
        }
    }
}
