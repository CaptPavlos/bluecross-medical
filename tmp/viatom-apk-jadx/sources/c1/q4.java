package c1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class q4 extends m4 {

    /* renamed from: c, reason: collision with root package name */
    public boolean f1419c;

    public q4(v4 v4Var) {
        super(v4Var);
        this.f1335b.f1531r++;
    }

    public final void h() {
        if (this.f1419c) {
            return;
        }
        androidx.window.layout.c.g("Not initialized");
    }

    public final void i() {
        if (this.f1419c) {
            androidx.window.layout.c.g("Can't initialize twice");
            return;
        }
        j();
        this.f1335b.f1532s++;
        this.f1419c = true;
    }

    public abstract void j();
}
