package c1;

import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q2 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1415a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1416b;

    public q2() {
        this.f1415a = 1;
        com.google.android.gms.internal.measurement.h0 h0Var = new com.google.android.gms.internal.measurement.h0(Looper.getMainLooper(), 6, false);
        Looper.getMainLooper();
        this.f1416b = h0Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f1415a) {
            case 0:
                r1 r1Var = ((c3) this.f1416b).f1149a.g;
                u1.m(r1Var);
                r1Var.p(runnable);
                break;
            case 1:
                ((com.google.android.gms.internal.measurement.h0) this.f1416b).post(runnable);
                break;
            default:
                ((Executor) this.f1416b).execute(new o0.b(1, runnable));
                break;
        }
    }

    public /* synthetic */ q2(Object obj, int i10) {
        this.f1415a = i10;
        this.f1416b = obj;
    }
}
