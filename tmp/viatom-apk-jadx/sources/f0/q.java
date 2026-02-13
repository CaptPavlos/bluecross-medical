package f0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.l5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends j0.a {
    public static final Parcelable.Creator<q> CREATOR = new android.support.v4.media.f(25);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8029a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8030b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8031c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8032d;

    public q(String str, int i10, int i11, boolean z9) {
        this.f8029a = z9;
        this.f8030b = str;
        this.f8031c = l1.b.Q(i10) - 1;
        this.f8032d = l5.P(i11) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f8029a ? 1 : 0);
        a4.F(parcel, 2, this.f8030b);
        a4.O(parcel, 3, 4);
        parcel.writeInt(this.f8031c);
        a4.O(parcel, 4, 4);
        parcel.writeInt(this.f8032d);
        a4.M(parcel, I);
    }
}
