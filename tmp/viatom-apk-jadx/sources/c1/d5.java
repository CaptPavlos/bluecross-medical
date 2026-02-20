package c1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d5 extends j0.a {
    public static final Parcelable.Creator<d5> CREATOR = new android.support.v4.media.f(19);
    public final long A;
    public final String B;
    public final String C;
    public final long D;
    public final int E;

    /* renamed from: a, reason: collision with root package name */
    public final String f1114a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1115b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1116c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1117d;
    public final long e;
    public final long f;
    public final String g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f1118i;

    /* renamed from: j, reason: collision with root package name */
    public final long f1119j;

    /* renamed from: k, reason: collision with root package name */
    public final String f1120k;

    /* renamed from: l, reason: collision with root package name */
    public final long f1121l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1122m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f1123n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f1124o;

    /* renamed from: p, reason: collision with root package name */
    public final Boolean f1125p;

    /* renamed from: q, reason: collision with root package name */
    public final long f1126q;

    /* renamed from: r, reason: collision with root package name */
    public final List f1127r;

    /* renamed from: s, reason: collision with root package name */
    public final String f1128s;
    public final String t;

    /* renamed from: u, reason: collision with root package name */
    public final String f1129u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f1130v;

    /* renamed from: w, reason: collision with root package name */
    public final long f1131w;

    /* renamed from: x, reason: collision with root package name */
    public final int f1132x;
    public final String y;

    /* renamed from: z, reason: collision with root package name */
    public final int f1133z;

    public d5(String str, String str2, String str3, long j10, String str4, long j11, long j12, String str5, boolean z9, boolean z10, String str6, long j13, int i10, boolean z11, boolean z12, Boolean bool, long j14, List list, String str7, String str8, String str9, boolean z13, long j15, int i11, String str10, int i12, long j16, String str11, String str12, long j17, int i13) {
        i0.y.d(str);
        this.f1114a = str;
        this.f1115b = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f1116c = str3;
        this.f1119j = j10;
        this.f1117d = str4;
        this.e = j11;
        this.f = j12;
        this.g = str5;
        this.h = z9;
        this.f1118i = z10;
        this.f1120k = str6;
        this.f1121l = j13;
        this.f1122m = i10;
        this.f1123n = z11;
        this.f1124o = z12;
        this.f1125p = bool;
        this.f1126q = j14;
        this.f1127r = list;
        this.f1128s = str7;
        this.t = str8;
        this.f1129u = str9;
        this.f1130v = z13;
        this.f1131w = j15;
        this.f1132x = i11;
        this.y = str10;
        this.f1133z = i12;
        this.A = j16;
        this.B = str11;
        this.C = str12;
        this.D = j17;
        this.E = i13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = com.google.android.gms.internal.measurement.a4.I(parcel, 20293);
        com.google.android.gms.internal.measurement.a4.F(parcel, 2, this.f1114a);
        com.google.android.gms.internal.measurement.a4.F(parcel, 3, this.f1115b);
        com.google.android.gms.internal.measurement.a4.F(parcel, 4, this.f1116c);
        com.google.android.gms.internal.measurement.a4.F(parcel, 5, this.f1117d);
        com.google.android.gms.internal.measurement.a4.O(parcel, 6, 8);
        parcel.writeLong(this.e);
        com.google.android.gms.internal.measurement.a4.O(parcel, 7, 8);
        parcel.writeLong(this.f);
        com.google.android.gms.internal.measurement.a4.F(parcel, 8, this.g);
        com.google.android.gms.internal.measurement.a4.O(parcel, 9, 4);
        parcel.writeInt(this.h ? 1 : 0);
        com.google.android.gms.internal.measurement.a4.O(parcel, 10, 4);
        parcel.writeInt(this.f1118i ? 1 : 0);
        com.google.android.gms.internal.measurement.a4.O(parcel, 11, 8);
        parcel.writeLong(this.f1119j);
        com.google.android.gms.internal.measurement.a4.F(parcel, 12, this.f1120k);
        com.google.android.gms.internal.measurement.a4.O(parcel, 14, 8);
        parcel.writeLong(this.f1121l);
        com.google.android.gms.internal.measurement.a4.O(parcel, 15, 4);
        parcel.writeInt(this.f1122m);
        com.google.android.gms.internal.measurement.a4.O(parcel, 16, 4);
        parcel.writeInt(this.f1123n ? 1 : 0);
        com.google.android.gms.internal.measurement.a4.O(parcel, 18, 4);
        parcel.writeInt(this.f1124o ? 1 : 0);
        Boolean bool = this.f1125p;
        if (bool != null) {
            com.google.android.gms.internal.measurement.a4.O(parcel, 21, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        com.google.android.gms.internal.measurement.a4.O(parcel, 22, 8);
        parcel.writeLong(this.f1126q);
        List<String> list = this.f1127r;
        if (list != null) {
            int I2 = com.google.android.gms.internal.measurement.a4.I(parcel, 23);
            parcel.writeStringList(list);
            com.google.android.gms.internal.measurement.a4.M(parcel, I2);
        }
        com.google.android.gms.internal.measurement.a4.F(parcel, 25, this.f1128s);
        com.google.android.gms.internal.measurement.a4.F(parcel, 26, this.t);
        com.google.android.gms.internal.measurement.a4.F(parcel, 27, this.f1129u);
        com.google.android.gms.internal.measurement.a4.O(parcel, 28, 4);
        parcel.writeInt(this.f1130v ? 1 : 0);
        com.google.android.gms.internal.measurement.a4.O(parcel, 29, 8);
        parcel.writeLong(this.f1131w);
        com.google.android.gms.internal.measurement.a4.O(parcel, 30, 4);
        parcel.writeInt(this.f1132x);
        com.google.android.gms.internal.measurement.a4.F(parcel, 31, this.y);
        com.google.android.gms.internal.measurement.a4.O(parcel, 32, 4);
        parcel.writeInt(this.f1133z);
        com.google.android.gms.internal.measurement.a4.O(parcel, 34, 8);
        parcel.writeLong(this.A);
        com.google.android.gms.internal.measurement.a4.F(parcel, 35, this.B);
        com.google.android.gms.internal.measurement.a4.F(parcel, 36, this.C);
        com.google.android.gms.internal.measurement.a4.O(parcel, 37, 8);
        parcel.writeLong(this.D);
        com.google.android.gms.internal.measurement.a4.O(parcel, 38, 4);
        parcel.writeInt(this.E);
        com.google.android.gms.internal.measurement.a4.M(parcel, I);
    }

    public d5(String str, String str2, String str3, String str4, long j10, long j11, String str5, boolean z9, boolean z10, long j12, String str6, long j13, int i10, boolean z11, boolean z12, Boolean bool, long j14, ArrayList arrayList, String str7, String str8, String str9, boolean z13, long j15, int i11, String str10, int i12, long j16, String str11, String str12, long j17, int i13) {
        this.f1114a = str;
        this.f1115b = str2;
        this.f1116c = str3;
        this.f1119j = j12;
        this.f1117d = str4;
        this.e = j10;
        this.f = j11;
        this.g = str5;
        this.h = z9;
        this.f1118i = z10;
        this.f1120k = str6;
        this.f1121l = j13;
        this.f1122m = i10;
        this.f1123n = z11;
        this.f1124o = z12;
        this.f1125p = bool;
        this.f1126q = j14;
        this.f1127r = arrayList;
        this.f1128s = str7;
        this.t = str8;
        this.f1129u = str9;
        this.f1130v = z13;
        this.f1131w = j15;
        this.f1132x = i11;
        this.y = str10;
        this.f1133z = i12;
        this.A = j16;
        this.B = str11;
        this.C = str12;
        this.D = j17;
        this.E = i13;
    }
}
