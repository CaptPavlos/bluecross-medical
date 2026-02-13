package c1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c1 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final v4 f1069a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1070b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1071c;

    public c1(v4 v4Var) {
        i0.y.g(v4Var);
        this.f1069a = v4Var;
    }

    public final void a() {
        v4 v4Var = this.f1069a;
        v4Var.l0();
        v4Var.b().g();
        v4Var.b().g();
        if (this.f1070b) {
            v4Var.a().f1545n.b("Unregistering connectivity change receiver");
            this.f1070b = false;
            this.f1071c = false;
            try {
                v4Var.f1525l.f1475a.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                v4Var.a().f.c(e, "Failed to unregister the network broadcast receiver");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        v4 v4Var = this.f1069a;
        v4Var.l0();
        String action = intent.getAction();
        v4Var.a().f1545n.c(action, "NetworkBroadcastReceiver received action");
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            v4Var.a().f1540i.c(action, "NetworkBroadcastReceiver received unknown action");
            return;
        }
        a1 a1Var = v4Var.f1519b;
        v4.U(a1Var);
        boolean zA = a1Var.A();
        if (this.f1071c != zA) {
            this.f1071c = zA;
            v4Var.b().p(new a4.a(this, zA));
        }
    }
}
