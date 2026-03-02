package j2;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f9909a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f9910b;

    public c(String str, Map map) {
        this.f9909a = str;
        this.f9910b = map;
    }

    public static c a(String str) {
        return new c(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f9909a.equals(cVar.f9909a) && this.f9910b.equals(cVar.f9910b);
    }

    public final int hashCode() {
        return this.f9910b.hashCode() + (this.f9909a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f9909a + ", properties=" + this.f9910b.values() + "}";
    }
}
