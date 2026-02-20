package c1;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p3 extends com.google.android.gms.internal.measurement.y implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1403a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p3(x3 x3Var, AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
        this.f1403a = atomicReference;
    }

    @Override // c1.k0
    public final void B(List list) {
        AtomicReference atomicReference = this.f1403a;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i10, Parcel parcel, Parcel parcel2) {
        if (i10 != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(k4.CREATOR);
        com.google.android.gms.internal.measurement.z.d(parcel);
        B(arrayListCreateTypedArrayList);
        return true;
    }
}
