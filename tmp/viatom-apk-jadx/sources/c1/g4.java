package c1;

import android.os.Looper;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g4 extends h0 {

    /* renamed from: c, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.h0 f1233c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1234d;
    public final y2.c e;
    public final f4 f;
    public final a4.f g;

    public g4(u1 u1Var) {
        super(u1Var);
        this.f1234d = true;
        this.e = new y2.c(this, 7);
        this.f = new f4(this);
        this.g = new a4.f(this, 5);
    }

    @Override // c1.h0
    public final boolean j() {
        return false;
    }

    public final void k() {
        g();
        if (this.f1233c == null) {
            this.f1233c = new com.google.android.gms.internal.measurement.h0(Looper.getMainLooper(), 0);
        }
    }
}
