package c1;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a2 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1005a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d5 f1006b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f1007c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d2 f1008d;

    public /* synthetic */ a2(d2 d2Var, d5 d5Var, Bundle bundle, int i10) {
        this.f1005a = i10;
        this.f1006b = d5Var;
        this.f1007c = bundle;
        this.f1008d = d2Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        switch (this.f1005a) {
            case 0:
                d2 d2Var = this.f1008d;
                d2Var.f1108a.B();
                return d2Var.f1108a.d0(this.f1007c, this.f1006b);
            default:
                d2 d2Var2 = this.f1008d;
                d2Var2.f1108a.B();
                return d2Var2.f1108a.d0(this.f1007c, this.f1006b);
        }
    }
}
