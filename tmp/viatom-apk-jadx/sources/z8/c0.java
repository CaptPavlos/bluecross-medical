package z8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f14462a;

    /* renamed from: b, reason: collision with root package name */
    public int f14463b;

    /* renamed from: c, reason: collision with root package name */
    public int f14464c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14465d;
    public final boolean e;
    public c0 f;
    public c0 g;

    public c0(byte[] bArr, int i10, int i11, boolean z9) {
        bArr.getClass();
        this.f14462a = bArr;
        this.f14463b = i10;
        this.f14464c = i11;
        this.f14465d = z9;
        this.e = false;
    }

    public final c0 a() {
        c0 c0Var = this.f;
        if (c0Var == this) {
            c0Var = null;
        }
        c0 c0Var2 = this.g;
        c0Var2.getClass();
        c0Var2.f = this.f;
        c0 c0Var3 = this.f;
        c0Var3.getClass();
        c0Var3.g = this.g;
        this.f = null;
        this.g = null;
        return c0Var;
    }

    public final void b(c0 c0Var) {
        c0Var.getClass();
        c0Var.g = this;
        c0Var.f = this.f;
        c0 c0Var2 = this.f;
        c0Var2.getClass();
        c0Var2.g = c0Var;
        this.f = c0Var;
    }

    public final c0 c() {
        this.f14465d = true;
        return new c0(this.f14462a, this.f14463b, this.f14464c, true);
    }

    public final void d(c0 c0Var, int i10) {
        c0Var.getClass();
        byte[] bArr = c0Var.f14462a;
        if (!c0Var.e) {
            androidx.window.layout.c.g("only owner can write");
            return;
        }
        int i11 = c0Var.f14464c;
        int i12 = i11 + i10;
        if (i12 > 8192) {
            if (c0Var.f14465d) {
                f.a();
                return;
            }
            int i13 = c0Var.f14463b;
            if (i12 - i13 > 8192) {
                f.a();
                return;
            } else {
                t6.j.k0(bArr, 0, i13, bArr, i11);
                c0Var.f14464c -= c0Var.f14463b;
                c0Var.f14463b = 0;
            }
        }
        int i14 = c0Var.f14464c;
        int i15 = this.f14463b;
        t6.j.k0(this.f14462a, i14, i15, bArr, i15 + i10);
        c0Var.f14464c += i10;
        this.f14463b += i10;
    }

    public c0() {
        this.f14462a = new byte[8192];
        this.e = true;
        this.f14465d = false;
    }
}
