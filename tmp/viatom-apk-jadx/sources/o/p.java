package o;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class p extends b0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f11642a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f11643b;

    public p(byte[] bArr, byte[] bArr2) {
        this.f11642a = bArr;
        this.f11643b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            boolean z9 = b0Var instanceof p;
            p pVar = (p) b0Var;
            if (Arrays.equals(this.f11642a, z9 ? pVar.f11642a : pVar.f11642a)) {
                p pVar2 = (p) b0Var;
                if (Arrays.equals(this.f11643b, z9 ? pVar2.f11643b : pVar2.f11643b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.f11642a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f11643b);
    }

    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f11642a) + ", encryptedBlob=" + Arrays.toString(this.f11643b) + "}";
    }
}
