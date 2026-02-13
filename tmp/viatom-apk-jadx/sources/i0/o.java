package i0;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o implements g0.a {

    /* renamed from: b, reason: collision with root package name */
    public static final o f8935b = new o(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f8936a;

    public /* synthetic */ o(String str) {
        this.f8936a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return y.j(this.f8936a, ((o) obj).f8936a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8936a});
    }
}
