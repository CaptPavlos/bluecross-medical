package b0;

import a4.f;
import i0.y;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements g0.a {

    /* renamed from: c, reason: collision with root package name */
    public static final c f820c;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f821a;

    /* renamed from: b, reason: collision with root package name */
    public final String f822b;

    static {
        f fVar = new f(2);
        fVar.f218b = Boolean.FALSE;
        f820c = new c(fVar);
    }

    public c(f fVar) {
        this.f821a = ((Boolean) fVar.f218b).booleanValue();
        this.f822b = (String) fVar.f219c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return y.j(null, null) && this.f821a == cVar.f821a && y.j(this.f822b, cVar.f822b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{null, Boolean.valueOf(this.f821a), this.f822b});
    }
}
