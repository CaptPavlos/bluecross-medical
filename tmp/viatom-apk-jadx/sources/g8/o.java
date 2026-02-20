package g8;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class o extends a {

    /* renamed from: a, reason: collision with root package name */
    public final c8.b f8302a;

    public o(c8.b bVar) {
        this.f8302a = bVar;
    }

    @Override // g8.a
    public final void g(f8.c cVar, Object obj, int i10, int i11) {
        if (i11 < 0) {
            com.google.gson.internal.a.n("Size must be known in advance when using READ_ALL");
            return;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            h(cVar, i10 + i12, obj);
        }
    }

    @Override // g8.a
    public void h(f8.c cVar, int i10, Object obj) {
        k(i10, obj, cVar.decodeSerializableElement(getDescriptor(), i10, this.f8302a, null));
    }

    public abstract void k(int i10, Object obj, Object obj2);

    @Override // c8.g
    public void serialize(f8.f fVar, Object obj) {
        int iE = e(obj);
        e8.e descriptor = getDescriptor();
        f8.d dVarBeginCollection = fVar.beginCollection(descriptor, iE);
        Iterator itD = d(obj);
        for (int i10 = 0; i10 < iE; i10++) {
            dVarBeginCollection.encodeSerializableElement(getDescriptor(), i10, this.f8302a, itD.next());
        }
        dVarBeginCollection.endStructure(descriptor);
    }
}
