package i0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends j0.a {

    @NonNull
    public static final Parcelable.Creator<m> CREATOR = new g0.l(23);

    /* renamed from: a, reason: collision with root package name */
    public final int f8929a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8930b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8931c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8932d;
    public final int e;

    public m(int i10, int i11, int i12, boolean z9, boolean z10) {
        this.f8929a = i10;
        this.f8930b = z9;
        this.f8931c = z10;
        this.f8932d = i11;
        this.e = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f8929a);
        a4.O(parcel, 2, 4);
        parcel.writeInt(this.f8930b ? 1 : 0);
        a4.O(parcel, 3, 4);
        parcel.writeInt(this.f8931c ? 1 : 0);
        a4.O(parcel, 4, 4);
        parcel.writeInt(this.f8932d);
        a4.O(parcel, 5, 4);
        parcel.writeInt(this.e);
        a4.M(parcel, I);
    }
}
