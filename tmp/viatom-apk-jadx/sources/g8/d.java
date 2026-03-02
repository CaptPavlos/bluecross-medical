package g8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends o {

    /* renamed from: b, reason: collision with root package name */
    public final c f8248b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c8.b bVar) {
        super(bVar);
        bVar.getClass();
        e8.e descriptor = bVar.getDescriptor();
        descriptor.getClass();
        this.f8248b = new c(descriptor, 1);
    }

    @Override // g8.a
    public final Object a() {
        return new ArrayList();
    }

    @Override // g8.a
    public final int b(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // g8.a
    public final void c(int i10, Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        arrayList.ensureCapacity(i10);
    }

    @Override // g8.a
    public final Iterator d(Object obj) {
        Collection collection = (Collection) obj;
        collection.getClass();
        return collection.iterator();
    }

    @Override // g8.a
    public final int e(Object obj) {
        Collection collection = (Collection) obj;
        collection.getClass();
        return collection.size();
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return this.f8248b;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        throw null;
    }

    @Override // g8.a
    public final Object j(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        return arrayList;
    }

    @Override // g8.o
    public final void k(int i10, Object obj, Object obj2) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        arrayList.add(i10, obj2);
    }
}
