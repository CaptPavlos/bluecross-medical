package f1;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import com.google.android.gms.internal.measurement.a4;
import i0.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends j0.a {
    public static final Parcelable.Creator<e> CREATOR = new f(28);

    /* renamed from: a, reason: collision with root package name */
    public final int f8043a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.b f8044b;

    /* renamed from: c, reason: collision with root package name */
    public final s f8045c;

    public e(int i10, f0.b bVar, s sVar) {
        this.f8043a = i10;
        this.f8044b = bVar;
        this.f8045c = sVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f8043a);
        a4.E(parcel, 2, this.f8044b, i10);
        a4.E(parcel, 3, this.f8045c, i10);
        a4.M(parcel, I);
    }
}
