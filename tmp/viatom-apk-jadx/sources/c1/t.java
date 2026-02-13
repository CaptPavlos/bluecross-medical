package c1;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f1459a;

    public t(u uVar) {
        this.f1459a = uVar.f1470a.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1459a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f1459a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
