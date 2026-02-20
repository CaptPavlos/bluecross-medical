package f1;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.a4;
import g0.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends j0.a implements i {
    public static final Parcelable.Creator<d> CREATOR = new f(27);

    /* renamed from: a, reason: collision with root package name */
    public final List f8041a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8042b;

    public d(String str, ArrayList arrayList) {
        this.f8041a = arrayList;
        this.f8042b = str;
    }

    @Override // g0.i
    public final Status getStatus() {
        return this.f8042b != null ? Status.e : Status.f1857i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        List<String> list = this.f8041a;
        if (list != null) {
            int I2 = a4.I(parcel, 1);
            parcel.writeStringList(list);
            a4.M(parcel, I2);
        }
        a4.F(parcel, 2, this.f8042b);
        a4.M(parcel, I);
    }
}
