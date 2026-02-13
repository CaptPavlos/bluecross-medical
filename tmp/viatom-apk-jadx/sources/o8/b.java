package o8;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11776a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11777b;

    public /* synthetic */ b() {
        this(new ArrayList(), new a(false, false));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.l.a(this.f11776a, bVar.f11776a) && kotlin.jvm.internal.l.a(this.f11777b, bVar.f11777b);
    }

    public final int hashCode() {
        return this.f11777b.hashCode() + (this.f11776a.hashCode() * 31);
    }

    public final String toString() {
        return "ConsentOrPayConfig(countries=" + this.f11776a + ", actionButtonSettings=" + this.f11777b + ')';
    }

    public b(ArrayList arrayList, a aVar) {
        this.f11776a = arrayList;
        this.f11777b = aVar;
    }
}
