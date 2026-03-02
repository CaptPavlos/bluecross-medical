package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 extends e1 {
    public final /* synthetic */ int e;
    public final Object f;

    public /* synthetic */ l0(Object obj, int i10) {
        this.e = i10;
        this.f = obj;
    }

    @Override // r7.e1
    public final boolean i() {
        switch (this.e) {
        }
        return false;
    }

    @Override // r7.e1
    public final void j(Throwable th) {
        switch (this.e) {
            case 0:
                ((k0) this.f).dispose();
                break;
            case 1:
                ((g7.l) this.f).invoke(th);
                break;
            default:
                Object obj = i1.f12408a.get(h());
                boolean z9 = obj instanceof p;
                f1 f1Var = (f1) this.f;
                if (!z9) {
                    f1Var.resumeWith(y.x(obj));
                    break;
                } else {
                    f1Var.resumeWith(s6.a.b(((p) obj).f12426a));
                    break;
                }
        }
    }
}
