package c1;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1449a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.n0 f1450b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f1451c;

    public /* synthetic */ s1(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.n0 n0Var, int i10) {
        this.f1449a = i10;
        this.f1450b = n0Var;
        this.f1451c = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1449a) {
            case 0:
                x3 x3VarP = this.f1451c.f2292a.p();
                com.google.android.gms.internal.measurement.n0 n0Var = this.f1450b;
                x3VarP.g();
                x3VarP.h();
                x3VarP.u(new y1((Object) x3VarP, x3VarP.w(false), (Object) n0Var, 6));
                break;
            default:
                AppMeasurementDynamiteService appMeasurementDynamiteService = this.f1451c;
                b5 b5Var = appMeasurementDynamiteService.f2292a.f1479i;
                u1.k(b5Var);
                u1 u1Var = appMeasurementDynamiteService.f2292a;
                b5Var.T(this.f1450b, u1Var.y != null && u1Var.y.booleanValue());
                break;
        }
    }
}
