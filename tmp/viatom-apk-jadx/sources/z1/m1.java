package z1;

import android.os.Build;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f14298a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14299b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14300c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14301d;
    public final boolean e;
    public final int f;

    public m1(int i10, int i11, long j10, long j11, boolean z9, int i12) {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        this.f14298a = i10;
        if (str == null) {
            androidx.window.layout.c.k("Null model");
            throw null;
        }
        this.f14299b = i11;
        this.f14300c = j10;
        this.f14301d = j11;
        this.e = z9;
        this.f = i12;
        if (str2 == null) {
            androidx.window.layout.c.k("Null manufacturer");
            throw null;
        }
        if (str3 != null) {
            return;
        }
        androidx.window.layout.c.k("Null modelClass");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        if (this.f14298a != m1Var.f14298a) {
            return false;
        }
        String str = Build.MODEL;
        if (!str.equals(str) || this.f14299b != m1Var.f14299b || this.f14300c != m1Var.f14300c || this.f14301d != m1Var.f14301d || this.e != m1Var.e || this.f != m1Var.f) {
            return false;
        }
        String str2 = Build.MANUFACTURER;
        if (!str2.equals(str2)) {
            return false;
        }
        String str3 = Build.PRODUCT;
        return str3.equals(str3);
    }

    public final int hashCode() {
        int iHashCode = (((((this.f14298a ^ 1000003) * 1000003) ^ Build.MODEL.hashCode()) * 1000003) ^ this.f14299b) * 1000003;
        long j10 = this.f14300c;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f14301d;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.e ? 1231 : 1237)) * 1000003) ^ this.f) * 1000003) ^ Build.MANUFACTURER.hashCode()) * 1000003) ^ Build.PRODUCT.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceData{arch=");
        sb.append(this.f14298a);
        sb.append(", model=");
        sb.append(Build.MODEL);
        sb.append(", availableProcessors=");
        sb.append(this.f14299b);
        sb.append(", totalRam=");
        sb.append(this.f14300c);
        sb.append(", diskSpace=");
        sb.append(this.f14301d);
        sb.append(", isEmulator=");
        sb.append(this.e);
        sb.append(", state=");
        sb.append(this.f);
        sb.append(", manufacturer=");
        sb.append(Build.MANUFACTURER);
        sb.append(", modelClass=");
        return a3.a.o(sb, Build.PRODUCT, "}");
    }
}
