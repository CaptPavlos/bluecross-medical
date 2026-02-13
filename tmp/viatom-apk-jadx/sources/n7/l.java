package n7;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements Iterator, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f11586a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f11587b;

    public l(d dVar) {
        this.f11587b = dVar;
        this.f11586a = ((f) dVar.f11575b).iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11586a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((g7.l) this.f11587b.f11576c).invoke(this.f11586a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
