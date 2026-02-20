package j1;

import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends d {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f9884c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f9885d;
    public final /* synthetic */ d e;

    public c(d dVar, int i10, int i11) {
        this.e = dVar;
        this.f9884c = i10;
        this.f9885d = i11;
    }

    @Override // j1.a
    public final Object[] c() {
        return this.e.c();
    }

    @Override // j1.a
    public final int d() {
        return this.e.e() + this.f9884c + this.f9885d;
    }

    @Override // j1.a
    public final int e() {
        return this.e.e() + this.f9884c;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        l1.b.q(i10, this.f9885d);
        return this.e.get(i10 + this.f9884c);
    }

    @Override // j1.d, java.util.List
    /* renamed from: i */
    public final d subList(int i10, int i11) {
        l1.b.t(i10, i11, this.f9885d);
        int i12 = this.f9884c;
        return this.e.subList(i10 + i12, i11 + i12);
    }

    @Override // j1.d, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // j1.d, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9885d;
    }

    @Override // j1.d, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
        return listIterator(i10);
    }
}
