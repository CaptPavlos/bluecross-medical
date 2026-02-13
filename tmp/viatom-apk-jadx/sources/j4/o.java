package j4;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends b {
    public final Object h;

    /* renamed from: i, reason: collision with root package name */
    public g f9999i;

    public o(y yVar, c0 c0Var, String str, g gVar) {
        super(yVar, null, c0Var, str);
        this.h = new Object();
        this.f9999i = gVar;
    }

    @Override // j4.b
    public final void a() {
        this.g = true;
        this.f9999i = null;
    }

    @Override // j4.b
    public final void b(Bitmap bitmap, int i10) {
        g gVar = this.f9999i;
        if (gVar != null) {
            gVar.onSuccess();
        }
    }

    @Override // j4.b
    public final void c(Exception exc) {
        g gVar = this.f9999i;
        if (gVar != null) {
            gVar.p(exc);
        }
    }

    @Override // j4.b
    public final Object d() {
        return this.h;
    }
}
