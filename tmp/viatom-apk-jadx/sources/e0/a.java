package e0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends j0.a {

    @NonNull
    public static final Parcelable.Creator<a> CREATOR = new c(0);

    /* renamed from: a, reason: collision with root package name */
    public final Intent f7588a;

    public a(Intent intent) {
        this.f7588a = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.E(parcel, 1, this.f7588a, i10);
        a4.M(parcel, I);
    }
}
