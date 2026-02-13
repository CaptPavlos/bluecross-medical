package r0;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends x {
    public final q0.a J(q0.b bVar, String str, int i10) {
        Parcel parcelG = G();
        x0.a.c(parcelG, bVar);
        parcelG.writeString(str);
        parcelG.writeInt(i10);
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
        Parcel parcelC = c(parcelG, 8);
        q0.a aVarI = q0.b.I(parcelC.readStrongBinder());
        parcelC.recycle();
        return aVarI;
    }

    public final q0.a L(q0.b bVar, String str, int i10) {
        Parcel parcelG = G();
        x0.a.c(parcelG, bVar);
        parcelG.writeString(str);
        parcelG.writeInt(i10);
        Parcel parcelC = c(parcelG, 4);
        q0.a aVarI = q0.b.I(parcelC.readStrongBinder());
        parcelC.recycle();
        return aVarI;
    }

    public final q0.a M(q0.b bVar, String str, boolean z9, long j10) {
        Parcel parcelG = G();
        x0.a.c(parcelG, bVar);
        parcelG.writeString(str);
        parcelG.writeInt(z9 ? 1 : 0);
        parcelG.writeLong(j10);
        Parcel parcelC = c(parcelG, 7);
        q0.a aVarI = q0.b.I(parcelC.readStrongBinder());
        parcelC.recycle();
        return aVarI;
    }
}
