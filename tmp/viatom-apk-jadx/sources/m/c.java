package m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f11153a;

    public c(String str) {
        if (str != null) {
            this.f11153a = str;
        } else {
            androidx.window.layout.c.k("name is null");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f11153a.equals(((c) obj).f11153a);
    }

    public final int hashCode() {
        return this.f11153a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return a3.a.o(new StringBuilder("Encoding{name=\""), this.f11153a, "\"}");
    }
}
