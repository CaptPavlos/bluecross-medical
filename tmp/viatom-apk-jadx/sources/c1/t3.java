package c1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t3 extends o {
    public final /* synthetic */ int e;
    public final /* synthetic */ x3 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t3(x3 x3Var, u1 u1Var, int i10) {
        super(u1Var);
        this.e = i10;
        this.f = x3Var;
    }

    @Override // c1.o
    public final void a() {
        switch (this.e) {
            case 0:
                x3 x3Var = this.f;
                x3Var.g();
                if (x3Var.x()) {
                    w0 w0Var = x3Var.f1149a.f;
                    u1.m(w0Var);
                    w0Var.f1545n.b("Inactivity, disconnecting from the service");
                    x3Var.o();
                    break;
                }
                break;
            default:
                w0 w0Var2 = this.f.f1149a.f;
                u1.m(w0Var2);
                w0Var2.f1540i.b("Tasks have been queued for a long time");
                break;
        }
    }
}
