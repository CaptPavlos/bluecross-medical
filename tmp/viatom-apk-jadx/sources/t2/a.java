package t2;

import c.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12755a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12756b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12757c;

    /* renamed from: d, reason: collision with root package name */
    public final b f12758d;
    public final int e;

    public a(String str, String str2, String str3, b bVar, int i10) {
        this.f12755a = str;
        this.f12756b = str2;
        this.f12757c = str3;
        this.f12758d = bVar;
        this.e = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String str = aVar.f12755a;
        String str2 = this.f12755a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        String str3 = aVar.f12756b;
        String str4 = this.f12756b;
        if (str4 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str4.equals(str3)) {
            return false;
        }
        String str5 = aVar.f12757c;
        String str6 = this.f12757c;
        if (str6 == null) {
            if (str5 != null) {
                return false;
            }
        } else if (!str6.equals(str5)) {
            return false;
        }
        b bVar = aVar.f12758d;
        b bVar2 = this.f12758d;
        if (bVar2 == null) {
            if (bVar != null) {
                return false;
            }
        } else if (!bVar2.equals(bVar)) {
            return false;
        }
        int i10 = aVar.e;
        int i11 = this.e;
        return i11 == 0 ? i10 == 0 : i.a(i11, i10);
    }

    public final int hashCode() {
        String str = this.f12755a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f12756b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f12757c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        b bVar = this.f12758d;
        int iHashCode4 = (iHashCode3 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        int i10 = this.e;
        return (i10 != 0 ? i.c(i10) : 0) ^ iHashCode4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationResponse{uri=");
        sb.append(this.f12755a);
        sb.append(", fid=");
        sb.append(this.f12756b);
        sb.append(", refreshToken=");
        sb.append(this.f12757c);
        sb.append(", authToken=");
        sb.append(this.f12758d);
        sb.append(", responseCode=");
        int i10 = this.e;
        sb.append(i10 != 1 ? i10 != 2 ? "null" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
