package t6;

import java.util.ListIterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends kotlin.jvm.internal.b implements ListIterator {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f12797d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, int i10) {
        super(eVar, 5);
        this.f12797d = eVar;
        b bVar = e.Companion;
        int size = eVar.size();
        bVar.getClass();
        b.c(i10, size);
        this.f10128b = i10;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f10128b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f10128b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            com.google.gson.internal.a.b();
            return null;
        }
        int i10 = this.f10128b - 1;
        this.f10128b = i10;
        return this.f12797d.get(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f10128b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
