package w2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.internal.measurement.a4;
import java.util.Map;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends j0.a {
    public static final Parcelable.Creator<q> CREATOR = new g0.l(27);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f13458a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayMap f13459b;

    /* renamed from: c, reason: collision with root package name */
    public j f13460c;

    public q(Bundle bundle) {
        this.f13458a = bundle;
    }

    public final Map b() {
        if (this.f13459b == null) {
            ArrayMap arrayMap = new ArrayMap();
            Bundle bundle = this.f13458a;
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals(TypedValues.TransitionType.S_FROM) && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.f13459b = arrayMap;
        }
        return this.f13459b;
    }

    public final j c() {
        if (this.f13460c == null) {
            Bundle bundle = this.f13458a;
            if (n5.e0(bundle)) {
                this.f13460c = new j(new n5(bundle));
            }
        }
        return this.f13460c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.C(2, this.f13458a, parcel);
        a4.M(parcel, I);
    }
}
