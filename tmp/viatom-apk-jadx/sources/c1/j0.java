package c1;

import android.os.Parcel;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 extends com.google.android.gms.internal.measurement.x implements k0 {
    @Override // c1.k0
    public final void B(List list) {
        Parcel parcelG = G();
        parcelG.writeTypedList(list);
        I(parcelG);
    }
}
