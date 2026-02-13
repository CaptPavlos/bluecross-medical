package c1;

import android.os.Parcel;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q3 extends com.google.android.gms.internal.measurement.y implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1417a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x3 f1418b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q3(x3 x3Var, AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
        this.f1417a = atomicReference;
        this.f1418b = x3Var;
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i10, Parcel parcel, Parcel parcel2) {
        if (i10 != 2) {
            return false;
        }
        p4 p4Var = (p4) com.google.android.gms.internal.measurement.z.a(parcel, p4.CREATOR);
        com.google.android.gms.internal.measurement.z.d(parcel);
        n(p4Var);
        return true;
    }

    @Override // c1.m0
    public final void n(p4 p4Var) {
        AtomicReference atomicReference = this.f1417a;
        synchronized (atomicReference) {
            w0 w0Var = this.f1418b.f1149a.f;
            u1.m(w0Var);
            w0Var.f1545n.c(Integer.valueOf(p4Var.f1404a.size()), "[sgtm] Got upload batches from service. count");
            atomicReference.set(p4Var);
            atomicReference.notifyAll();
        }
    }
}
