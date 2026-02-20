package p;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final m.c f11862a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f11863b;

    public k(m.c cVar, byte[] bArr) {
        if (cVar == null) {
            androidx.window.layout.c.k("encoding is null");
            throw null;
        }
        if (bArr == null) {
            androidx.window.layout.c.k("bytes is null");
            throw null;
        }
        this.f11862a = cVar;
        this.f11863b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f11862a.equals(kVar.f11862a)) {
            return Arrays.equals(this.f11863b, kVar.f11863b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f11862a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f11863b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f11862a + ", bytes=[...]}";
    }
}
