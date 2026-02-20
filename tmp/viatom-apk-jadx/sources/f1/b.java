package f1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.a4;
import g0.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends j0.a implements i {
    public static final Parcelable.Creator<b> CREATOR = new f(26);

    /* renamed from: a, reason: collision with root package name */
    public final int f8038a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8039b;

    /* renamed from: c, reason: collision with root package name */
    public final Intent f8040c;

    public b(int i10, int i11, Intent intent) {
        this.f8038a = i10;
        this.f8039b = i11;
        this.f8040c = intent;
    }

    @Override // g0.i
    public final Status getStatus() {
        return this.f8039b == 0 ? Status.e : Status.f1857i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f8038a);
        a4.O(parcel, 2, 4);
        parcel.writeInt(this.f8039b);
        a4.E(parcel, 3, this.f8040c, i10);
        a4.M(parcel, I);
    }
}
