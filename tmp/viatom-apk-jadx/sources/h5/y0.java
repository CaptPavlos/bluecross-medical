package h5;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y0 implements Parcelable {
    public static Parcelable.Creator<y0> CREATOR = new g0.l(13);

    /* renamed from: a, reason: collision with root package name */
    public long f8794a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8795b;

    /* renamed from: c, reason: collision with root package name */
    public long f8796c;

    /* renamed from: d, reason: collision with root package name */
    public String f8797d;
    public int e;
    public int f;
    public int g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public q f8798i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f8799j;

    public y0(Parcel parcel) {
        this.f8794a = -1L;
        this.f8796c = -1L;
        this.f8794a = parcel.readLong();
        String string = parcel.readString();
        string.getClass();
        this.f8795b = string;
        this.f8796c = parcel.readLong();
        this.f8797d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readString();
        if (Build.VERSION.SDK_INT >= 34) {
            this.f8798i = (q) parcel.readParcelable(q.class.getClassLoader(), q.class);
        } else {
            this.f8798i = (q) parcel.readParcelable(q.class.getClassLoader());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final h5.q a(android.content.Context r4) {
        /*
            r3 = this;
            r4.getClass()
            t3.h r0 = v5.g.f13148u
            v5.g r4 = r0.l(r4)
            r4.a()
            h5.q r0 = r3.f8798i
            if (r0 == 0) goto L25
            r0.getClass()
            int r0 = r0.f8700a
            if (r0 < 0) goto L25
            h5.q r0 = r3.f8798i
            r0.getClass()
            int r0 = r0.f8700a
            h5.q r0 = r4.z(r0)
            r3.f8798i = r0
            goto L2f
        L25:
            java.lang.String r0 = r3.f8795b
            long r1 = r3.f8796c
            h5.q r0 = r4.B(r1, r0)
            r3.f8798i = r0
        L2f:
            r4.b()
            h5.q r4 = r3.f8798i
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.y0.a(android.content.Context):h5.q");
    }

    public final boolean b() {
        int i10 = this.f;
        return i10 == 1 || i10 == 2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{id=");
        sb.append(this.f8794a);
        sb.append(", packagename='");
        sb.append(this.f8795b);
        sb.append("', versionCode=");
        sb.append(this.f8796c);
        sb.append(", versionName='");
        sb.append(this.f8797d);
        sb.append("', notified=");
        sb.append(this.e);
        sb.append(", ignoreVersion=");
        sb.append(this.f);
        sb.append(", isPartialUpdate=");
        sb.append(this.g);
        sb.append(", newFeatures='");
        sb.append(this.h);
        sb.append("', download=");
        q qVar = this.f8798i;
        return a3.a.m(sb, qVar != null ? qVar.toString() : null, '}');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeLong(this.f8794a);
        parcel.writeString(this.f8795b);
        parcel.writeLong(this.f8796c);
        parcel.writeString(this.f8797d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.h);
        parcel.writeParcelable(this.f8798i, i10);
    }

    public y0(String str) {
        this.f8794a = -1L;
        this.f8796c = -1L;
        this.f8795b = str;
    }
}
