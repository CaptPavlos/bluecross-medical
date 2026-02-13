package z1;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 extends r1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14226a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f14227b;

    public h0(String str, byte[] bArr) {
        this.f14226a = str;
        this.f14227b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r1)) {
            return false;
        }
        r1 r1Var = (r1) obj;
        h0 h0Var = (h0) r1Var;
        if (this.f14226a.equals(h0Var.f14226a)) {
            return Arrays.equals(this.f14227b, r1Var instanceof h0 ? ((h0) r1Var).f14227b : h0Var.f14227b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f14226a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f14227b);
    }

    public final String toString() {
        return "File{filename=" + this.f14226a + ", contents=" + Arrays.toString(this.f14227b) + "}";
    }
}
