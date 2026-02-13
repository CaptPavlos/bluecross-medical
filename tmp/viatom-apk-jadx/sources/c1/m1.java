package c1;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class m1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1331a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1332b;

    public /* synthetic */ m1(n1 n1Var) {
        this.f1332b = n1Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1331a) {
            case 0:
                return new com.google.android.gms.internal.measurement.l4(((n1) this.f1332b).f1359k);
            default:
                d2 d2Var = (d2) this.f1332b;
                d2Var.f1108a.B();
                a1 a1Var = d2Var.f1108a.h;
                v4.U(a1Var);
                a1Var.g();
                throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public m1(d2 d2Var, v vVar, String str) {
        this.f1332b = d2Var;
    }
}
