package c1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y4 extends j0.a {
    public static final Parcelable.Creator<y4> CREATOR = new android.support.v4.media.f(18);

    /* renamed from: a, reason: collision with root package name */
    public final int f1609a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1610b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1611c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f1612d;
    public final String e;
    public final String f;
    public final Double g;

    public y4(long j10, Object obj, String str, String str2) {
        i0.y.d(str);
        this.f1609a = 2;
        this.f1610b = str;
        this.f1611c = j10;
        this.f = str2;
        if (obj == null) {
            this.f1612d = null;
            this.g = null;
            this.e = null;
            return;
        }
        if (obj instanceof Long) {
            this.f1612d = (Long) obj;
            this.g = null;
            this.e = null;
        } else if (obj instanceof String) {
            this.f1612d = null;
            this.g = null;
            this.e = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                com.google.gson.internal.a.n("User attribute given of un-supported type");
                throw null;
            }
            this.f1612d = null;
            this.g = (Double) obj;
            this.e = null;
        }
    }

    public final Object b() {
        Long l10 = this.f1612d;
        if (l10 != null) {
            return l10;
        }
        Double d8 = this.g;
        if (d8 != null) {
            return d8;
        }
        String str = this.e;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        android.support.v4.media.f.b(this, parcel);
    }

    public y4(int i10, String str, long j10, Long l10, Float f, String str2, String str3, Double d8) {
        this.f1609a = i10;
        this.f1610b = str;
        this.f1611c = j10;
        this.f1612d = l10;
        this.g = i10 == 1 ? f != null ? Double.valueOf(f.doubleValue()) : null : d8;
        this.e = str2;
        this.f = str3;
    }

    public y4(z4 z4Var) {
        this(z4Var.f1632d, z4Var.e, z4Var.f1631c, z4Var.f1630b);
    }
}
