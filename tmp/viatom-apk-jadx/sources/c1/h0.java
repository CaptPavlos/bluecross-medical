package c1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h0 extends c0 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1242b;

    public h0(u1 u1Var) {
        super(u1Var);
        this.f1149a.A++;
    }

    public final void h() {
        if (this.f1242b) {
            return;
        }
        androidx.window.layout.c.g("Not initialized");
    }

    public final void i() {
        if (this.f1242b) {
            androidx.window.layout.c.g("Can't initialize twice");
        } else {
            if (j()) {
                return;
            }
            this.f1149a.C.incrementAndGet();
            this.f1242b = true;
        }
    }

    public abstract boolean j();
}
