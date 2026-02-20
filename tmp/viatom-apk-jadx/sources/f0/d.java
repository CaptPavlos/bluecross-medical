package f0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.a4;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends j0.a {

    @NonNull
    public static final Parcelable.Creator<d> CREATOR = new android.support.v4.media.f(24);

    /* renamed from: a, reason: collision with root package name */
    public final String f7997a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7998b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7999c;

    public d() {
        this.f7997a = "CLIENT_TELEMETRY";
        this.f7999c = 1L;
        this.f7998b = -1;
    }

    public final long b() {
        long j10 = this.f7999c;
        return j10 == -1 ? this.f7998b : j10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = dVar.f7997a;
            String str2 = this.f7997a;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && b() == dVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7997a, Long.valueOf(b())});
    }

    public final String toString() {
        i0.k kVar = new i0.k(this);
        kVar.d(this.f7997a, RewardPlus.NAME);
        kVar.d(Long.valueOf(b()), "version");
        return kVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.F(parcel, 1, this.f7997a);
        a4.O(parcel, 2, 4);
        parcel.writeInt(this.f7998b);
        long jB = b();
        a4.O(parcel, 3, 8);
        parcel.writeLong(jB);
        a4.M(parcel, I);
    }

    public d(String str, int i10, long j10) {
        this.f7997a = str;
        this.f7998b = i10;
        this.f7999c = j10;
    }
}
