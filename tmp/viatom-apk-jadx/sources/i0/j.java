package i0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends j0.a {

    @NonNull
    public static final Parcelable.Creator<j> CREATOR = new g0.l(20);

    /* renamed from: a, reason: collision with root package name */
    public final int f8912a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8913b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8914c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8915d;
    public final long e;
    public final String f;
    public final String g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8916i;

    public j(int i10, int i11, int i12, long j10, long j11, String str, String str2, int i13, int i14) {
        this.f8912a = i10;
        this.f8913b = i11;
        this.f8914c = i12;
        this.f8915d = j10;
        this.e = j11;
        this.f = str;
        this.g = str2;
        this.h = i13;
        this.f8916i = i14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f8912a);
        a4.O(parcel, 2, 4);
        parcel.writeInt(this.f8913b);
        a4.O(parcel, 3, 4);
        parcel.writeInt(this.f8914c);
        a4.O(parcel, 4, 8);
        parcel.writeLong(this.f8915d);
        a4.O(parcel, 5, 8);
        parcel.writeLong(this.e);
        a4.F(parcel, 6, this.f);
        a4.F(parcel, 7, this.g);
        a4.O(parcel, 8, 4);
        parcel.writeInt(this.h);
        a4.O(parcel, 9, 4);
        parcel.writeInt(this.f8916i);
        a4.M(parcel, I);
    }
}
