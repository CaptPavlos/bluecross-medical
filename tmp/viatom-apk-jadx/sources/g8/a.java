package g8;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements c8.b {
    public abstract Object a();

    public abstract int b(Object obj);

    public abstract void c(int i10, Object obj);

    public abstract Iterator d(Object obj);

    @Override // c8.a
    public Object deserialize(f8.e eVar) {
        eVar.getClass();
        return f(eVar);
    }

    public abstract int e(Object obj);

    public final Object f(f8.e eVar) {
        eVar.getClass();
        Object objA = a();
        int iB = b(objA);
        f8.c cVarBeginStructure = eVar.beginStructure(getDescriptor());
        if (!cVarBeginStructure.decodeSequentially()) {
            while (true) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    break;
                }
                h(cVarBeginStructure, iDecodeElementIndex + iB, objA);
            }
        } else {
            int iDecodeCollectionSize = cVarBeginStructure.decodeCollectionSize(getDescriptor());
            c(iDecodeCollectionSize, objA);
            g(cVarBeginStructure, objA, iB, iDecodeCollectionSize);
        }
        cVarBeginStructure.endStructure(getDescriptor());
        return j(objA);
    }

    public abstract void g(f8.c cVar, Object obj, int i10, int i11);

    public abstract void h(f8.c cVar, int i10, Object obj);

    public abstract Object i(Object obj);

    public abstract Object j(Object obj);
}
