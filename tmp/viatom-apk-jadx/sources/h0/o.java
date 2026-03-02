package h0;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final a f8391a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.d f8392b;

    public /* synthetic */ o(a aVar, f0.d dVar) {
        this.f8391a = aVar;
        this.f8392b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return i0.y.j(this.f8391a, oVar.f8391a) && i0.y.j(this.f8392b, oVar.f8392b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8391a, this.f8392b});
    }

    public final String toString() {
        i0.k kVar = new i0.k(this);
        kVar.d(this.f8391a, "key");
        kVar.d(this.f8392b, "feature");
        return kVar.toString();
    }
}
