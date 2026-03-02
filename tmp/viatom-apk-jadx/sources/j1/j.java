package j1;

import j$.util.Objects;
import java.util.AbstractMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f9899c;

    public j(k kVar) {
        this.f9899c = kVar;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        k kVar = this.f9899c;
        l1.b.q(i10, kVar.f);
        Object[] objArr = kVar.e;
        int i11 = i10 * 2;
        Object obj = objArr[i11];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i11 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9899c.f;
    }
}
