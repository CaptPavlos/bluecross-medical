package c1;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c5 implements m2 {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.s0 f1095a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f1096b;

    public c5(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.s0 s0Var) {
        this.f1096b = appMeasurementDynamiteService;
        this.f1095a = s0Var;
    }

    @Override // c1.m2
    public final void a(long j10, Bundle bundle, String str, String str2) {
        try {
            this.f1095a.l(j10, bundle, str, str2);
        } catch (RemoteException e) {
            u1 u1Var = this.f1096b.f2292a;
            if (u1Var != null) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f1540i.c(e, "Event listener threw exception");
            }
        }
    }
}
