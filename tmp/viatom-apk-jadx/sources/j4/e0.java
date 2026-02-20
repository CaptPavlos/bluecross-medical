package j4;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f9935a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap f9936b;

    /* renamed from: c, reason: collision with root package name */
    public final z8.h0 f9937c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9938d;

    public e0(Bitmap bitmap, z8.h0 h0Var, int i10, int i11) {
        if ((bitmap != null) == (h0Var != null)) {
            p8.u.m();
            throw null;
        }
        this.f9936b = bitmap;
        this.f9937c = h0Var;
        if (i10 == 0) {
            androidx.window.layout.c.k("loadedFrom == null");
        }
        this.f9935a = i10;
        this.f9938d = i11;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e0(z8.h0 h0Var, int i10) {
        this(null, h0Var, i10, 0);
        StringBuilder sb = l0.f9987a;
        if (h0Var != null) {
        } else {
            androidx.window.layout.c.k("source == null");
            throw null;
        }
    }
}
