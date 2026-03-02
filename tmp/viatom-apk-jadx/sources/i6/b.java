package i6;

import android.os.Parcel;
import android.os.Parcelable;
import c.i;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements Parcelable {
    public static final a CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f9029a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9030b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9031c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9032d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f9033i;

    /* renamed from: j, reason: collision with root package name */
    public final String f9034j;

    /* renamed from: k, reason: collision with root package name */
    public final String f9035k;

    /* renamed from: l, reason: collision with root package name */
    public final String f9036l;

    /* renamed from: m, reason: collision with root package name */
    public final int f9037m;

    /* renamed from: n, reason: collision with root package name */
    public final int f9038n;

    /* renamed from: o, reason: collision with root package name */
    public final String f9039o;

    /* renamed from: p, reason: collision with root package name */
    public final String f9040p;

    public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i10, int i11, String str13, int i12) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? "" : str2, (i12 & 4) != 0 ? "" : str3, (i12 & 8) != 0 ? "" : str4, (i12 & 16) != 0 ? "" : str5, (i12 & 32) != 0 ? "" : str6, (i12 & 64) != 0 ? "" : str7, (i12 & 128) != 0 ? "" : str8, (i12 & 256) != 0 ? "" : str9, (i12 & 512) != 0 ? "" : str10, (i12 & 1024) != 0 ? "" : str11, (i12 & 2048) != 0 ? "" : str12, (i12 & 4096) != 0 ? 0 : i10, (i12 & 8192) != 0 ? 1 : i11, (i12 & 16384) != 0 ? "" : str13, (i12 & 32768) == 0 ? "Error: cannot load vendor file" : "");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return l.a(this.f9029a, bVar.f9029a) && l.a(this.f9030b, bVar.f9030b) && l.a(this.f9031c, bVar.f9031c) && l.a(this.f9032d, bVar.f9032d) && l.a(this.e, bVar.e) && l.a(this.f, bVar.f) && l.a(this.g, bVar.g) && l.a(this.h, bVar.h) && l.a(this.f9033i, bVar.f9033i) && l.a(this.f9034j, bVar.f9034j) && l.a(this.f9035k, bVar.f9035k) && l.a(this.f9036l, bVar.f9036l) && this.f9037m == bVar.f9037m && this.f9038n == bVar.f9038n && l.a(this.f9039o, bVar.f9039o) && l.a(this.f9040p, bVar.f9040p);
    }

    public final int hashCode() {
        int iHashCode = this.f9029a.hashCode() * 31;
        String str = this.f9030b;
        return this.f9040p.hashCode() + a.a.b(this.f9039o, (i.c(this.f9038n) + ((this.f9037m + a.a.b(this.f9036l, a.a.b(this.f9035k, a.a.b(this.f9034j, a.a.b(this.f9033i, a.a.b(this.h, a.a.b(this.g, a.a.b(this.f, a.a.b(this.e, a.a.b(this.f9032d, a.a.b(this.f9031c, (iHashCode + (str == null ? 0 : str.hashCode())) * 31))))))))))) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PartnersDetailDialogArgs(name=");
        sb.append(this.f9029a);
        sb.append(", description=");
        sb.append((Object) this.f9030b);
        sb.append(", purposes=");
        sb.append(this.f9031c);
        sb.append(", legitimateInterests=");
        sb.append(this.f9032d);
        sb.append(", specialPurposes=");
        sb.append(this.e);
        sb.append(", features=");
        sb.append(this.f);
        sb.append(", specialFeatures=");
        sb.append(this.g);
        sb.append(", dataDeclarations=");
        sb.append(this.h);
        sb.append(", privacyPolicy=");
        sb.append(this.f9033i);
        sb.append(", cookieMaxAge=");
        sb.append(this.f9034j);
        sb.append(", usesNonCookieAccess=");
        sb.append(this.f9035k);
        sb.append(", dataRetention=");
        sb.append(this.f9036l);
        sb.append(", vendorId=");
        sb.append(this.f9037m);
        sb.append(", switchItemType=");
        sb.append(i.d(this.f9038n));
        sb.append(", disclosuresUrl=");
        sb.append(this.f9039o);
        sb.append(", disclosuresErrorLabel=");
        return a3.a.m(sb, this.f9040p, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11;
        parcel.getClass();
        parcel.writeString(this.f9029a);
        parcel.writeString(this.f9030b);
        parcel.writeString(this.f9031c);
        parcel.writeString(this.f9032d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.f9033i);
        parcel.writeString(this.f9034j);
        parcel.writeString(this.f9035k);
        parcel.writeString(this.f9036l);
        parcel.writeInt(this.f9037m);
        switch (this.f9038n) {
            case 1:
                i11 = 1;
                break;
            case 2:
                i11 = 2;
                break;
            case 3:
                i11 = 3;
                break;
            case 4:
                i11 = 4;
                break;
            case 5:
                i11 = 5;
                break;
            case 6:
                i11 = 6;
                break;
            case 7:
                i11 = 7;
                break;
            case 8:
                i11 = 8;
                break;
            case 9:
                i11 = 9;
                break;
            case 10:
                i11 = 10;
                break;
            case 11:
                i11 = 11;
                break;
            case 12:
                i11 = 12;
                break;
            default:
                throw null;
        }
        parcel.writeInt(i11);
        parcel.writeString(this.f9039o);
        parcel.writeString(this.f9040p);
    }

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i10, int i11, String str13, String str14) {
        str.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        str9.getClass();
        str10.getClass();
        str11.getClass();
        str12.getClass();
        if (i11 != 0) {
            str13.getClass();
            str14.getClass();
            this.f9029a = str;
            this.f9030b = str2;
            this.f9031c = str3;
            this.f9032d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
            this.h = str8;
            this.f9033i = str9;
            this.f9034j = str10;
            this.f9035k = str11;
            this.f9036l = str12;
            this.f9037m = i10;
            this.f9038n = i11;
            this.f9039o = str13;
            this.f9040p = str14;
            return;
        }
        throw null;
    }
}
