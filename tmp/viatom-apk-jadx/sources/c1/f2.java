package c1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class f2 extends e2 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1213b;

    public f2(u1 u1Var) {
        super(u1Var);
        this.f1149a.A++;
    }

    public abstract boolean h();

    public final void i() {
        if (this.f1213b) {
            return;
        }
        androidx.window.layout.c.g("Not initialized");
    }

    public final void j() {
        if (this.f1213b) {
            androidx.window.layout.c.g("Can't initialize twice");
        } else {
            if (h()) {
                return;
            }
            this.f1149a.C.incrementAndGet();
            this.f1213b = true;
        }
    }
}
