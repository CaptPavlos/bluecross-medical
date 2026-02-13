package h0;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f8347a;

    /* renamed from: b, reason: collision with root package name */
    public final a4.f f8348b;

    /* renamed from: c, reason: collision with root package name */
    public final g0.a f8349c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8350d;

    public a(a4.f fVar, g0.a aVar, String str) {
        this.f8348b = fVar;
        this.f8349c = aVar;
        this.f8350d = str;
        this.f8347a = Arrays.hashCode(new Object[]{fVar, aVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return i0.y.j(this.f8348b, aVar.f8348b) && i0.y.j(this.f8349c, aVar.f8349c) && i0.y.j(this.f8350d, aVar.f8350d);
    }

    public final int hashCode() {
        return this.f8347a;
    }
}
