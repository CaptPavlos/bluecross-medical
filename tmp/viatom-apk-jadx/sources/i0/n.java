package i0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.a4;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends j0.a {

    @NonNull
    public static final Parcelable.Creator<n> CREATOR = new g0.l(19);

    /* renamed from: a, reason: collision with root package name */
    public final int f8933a;

    /* renamed from: b, reason: collision with root package name */
    public List f8934b;

    public n(int i10, List list) {
        this.f8933a = i10;
        this.f8934b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f8933a);
        a4.H(parcel, 2, this.f8934b);
        a4.M(parcel, I);
    }
}
