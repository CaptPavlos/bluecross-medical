package r0;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends x {
    public final q0.a J(q0.b bVar, String str, int i10, q0.b bVar2) {
        Parcel parcelG = G();
        x0.a.c(parcelG, bVar);
        parcelG.writeString(str);
        parcelG.writeInt(i10);
        x0.a.c(parcelG, bVar2);
        Parcel parcelC = c(parcelG, 2);
        q0.a aVarI = q0.b.I(parcelC.readStrongBinder());
        parcelC.recycle();
        return aVarI;
    }

    public final q0.a K(q0.b bVar, String str, int i10, q0.b bVar2) {
        Parcel parcelG = G();
        x0.a.c(parcelG, bVar);
        parcelG.writeString(str);
        parcelG.writeInt(i10);
        x0.a.c(parcelG, bVar2);
        Parcel parcelC = c(parcelG, 3);
        q0.a aVarI = q0.b.I(parcelC.readStrongBinder());
        parcelC.recycle();
        return aVarI;
    }
}
