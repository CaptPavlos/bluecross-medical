package p;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class i extends n {

    /* renamed from: a, reason: collision with root package name */
    public final String f11855a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f11856b;

    /* renamed from: c, reason: collision with root package name */
    public final m.d f11857c;

    public i(String str, byte[] bArr, m.d dVar) {
        this.f11855a = str;
        this.f11856b = bArr;
        this.f11857c = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            i iVar = (i) nVar;
            if (this.f11855a.equals(iVar.f11855a)) {
                if (Arrays.equals(this.f11856b, nVar instanceof i ? ((i) nVar).f11856b : iVar.f11856b) && this.f11857c.equals(iVar.f11857c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f11855a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f11856b)) * 1000003) ^ this.f11857c.hashCode();
    }
}
