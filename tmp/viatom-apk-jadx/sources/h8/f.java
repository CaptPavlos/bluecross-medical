package h8;

import com.google.android.gms.internal.measurement.l5;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final f f8833a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final e f8834b = e.f8830b;

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        l5.g(eVar);
        return new d((List) new g8.d(m.f8840a).f(eVar));
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8834b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        d dVar = (d) obj;
        dVar.getClass();
        l5.e(fVar);
        m mVar = m.f8840a;
        e8.f fVar2 = m.f8841b;
        fVar2.getClass();
        g8.c cVar = new g8.c(fVar2, 1);
        List list = dVar.f8829a;
        int size = list.size();
        f8.d dVarBeginCollection = fVar.beginCollection(cVar, size);
        Iterator it = list.iterator();
        for (int i10 = 0; i10 < size; i10++) {
            dVarBeginCollection.encodeSerializableElement(cVar, i10, mVar, it.next());
        }
        dVarBeginCollection.endStructure(cVar);
    }
}
