package i0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends j0.a {

    @NonNull
    public static final Parcelable.Creator<f> CREATOR = new g0.l(25);

    /* renamed from: a, reason: collision with root package name */
    public final m f8883a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8884b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8885c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f8886d;
    public final int e;
    public final int[] f;

    public f(m mVar, boolean z9, boolean z10, int[] iArr, int i10, int[] iArr2) {
        this.f8883a = mVar;
        this.f8884b = z9;
        this.f8885c = z10;
        this.f8886d = iArr;
        this.e = i10;
        this.f = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.E(parcel, 1, this.f8883a, i10);
        a4.O(parcel, 2, 4);
        parcel.writeInt(this.f8884b ? 1 : 0);
        a4.O(parcel, 3, 4);
        parcel.writeInt(this.f8885c ? 1 : 0);
        int[] iArr = this.f8886d;
        if (iArr != null) {
            int I2 = a4.I(parcel, 4);
            parcel.writeIntArray(iArr);
            a4.M(parcel, I2);
        }
        a4.O(parcel, 5, 4);
        parcel.writeInt(this.e);
        int[] iArr2 = this.f;
        if (iArr2 != null) {
            int I3 = a4.I(parcel, 6);
            parcel.writeIntArray(iArr2);
            a4.M(parcel, I3);
        }
        a4.M(parcel, I);
    }
}
