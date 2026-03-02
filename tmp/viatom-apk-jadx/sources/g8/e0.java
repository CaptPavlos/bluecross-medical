package g8;

import com.google.android.gms.internal.measurement.l5;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 extends a {

    /* renamed from: a, reason: collision with root package name */
    public final c8.b f8255a;

    /* renamed from: b, reason: collision with root package name */
    public final c8.b f8256b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f8257c;

    public e0(c8.b bVar, c8.b bVar2) {
        bVar.getClass();
        bVar2.getClass();
        this.f8255a = bVar;
        this.f8256b = bVar2;
        e8.e descriptor = bVar.getDescriptor();
        e8.e descriptor2 = bVar2.getDescriptor();
        descriptor.getClass();
        descriptor2.getClass();
        this.f8257c = new d0("kotlin.collections.LinkedHashMap", descriptor, descriptor2);
    }

    @Override // g8.a
    public final Object a() {
        return new LinkedHashMap();
    }

    @Override // g8.a
    public final int b(Object obj) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        linkedHashMap.getClass();
        return linkedHashMap.size() * 2;
    }

    @Override // g8.a
    public final void c(int i10, Object obj) {
        ((LinkedHashMap) obj).getClass();
    }

    @Override // g8.a
    public final Iterator d(Object obj) {
        Map map = (Map) obj;
        map.getClass();
        return map.entrySet().iterator();
    }

    @Override // g8.a
    public final int e(Object obj) {
        Map map = (Map) obj;
        map.getClass();
        return map.size();
    }

    @Override // g8.a
    public final void g(f8.c cVar, Object obj, int i10, int i11) {
        Map map = (Map) obj;
        map.getClass();
        if (i11 < 0) {
            com.google.gson.internal.a.n("Size must be known in advance when using READ_ALL");
            return;
        }
        l7.d dVarN = l5.N(0, i11 * 2);
        dVarN.getClass();
        int i12 = dVarN.f11084a;
        int i13 = dVarN.f11085b;
        int i14 = dVarN.f11086c <= 0 ? -2 : 2;
        int i15 = new l7.b(i12, i13, i14).f11085b;
        if ((i14 <= 0 || i12 > i15) && (i14 >= 0 || i15 > i12)) {
            return;
        }
        while (true) {
            k(cVar, i10 + i12, map, false);
            if (i12 == i15) {
                return;
            } else {
                i12 += i14;
            }
        }
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return this.f8257c;
    }

    @Override // g8.a
    public final /* bridge */ /* synthetic */ void h(f8.c cVar, int i10, Object obj) {
        k(cVar, i10, (Map) obj, true);
    }

    @Override // g8.a
    public final Object i(Object obj) {
        throw null;
    }

    @Override // g8.a
    public final Object j(Object obj) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        linkedHashMap.getClass();
        return linkedHashMap;
    }

    public final void k(f8.c cVar, int i10, Map map, boolean z9) {
        int iDecodeElementIndex;
        map.getClass();
        Object objDecodeSerializableElement = cVar.decodeSerializableElement(getDescriptor(), i10, this.f8255a, null);
        if (z9) {
            iDecodeElementIndex = cVar.decodeElementIndex(getDescriptor());
            if (iDecodeElementIndex != i10 + 1) {
                z8.f.b(androidx.constraintlayout.core.widgets.analyzer.a.u(i10, iDecodeElementIndex, "Value must follow key in a map, index for key: ", ", returned index for value: "));
                return;
            }
        } else {
            iDecodeElementIndex = i10 + 1;
        }
        boolean zContainsKey = map.containsKey(objDecodeSerializableElement);
        c8.b bVar = this.f8256b;
        map.put(objDecodeSerializableElement, (!zContainsKey || (bVar.getDescriptor().getKind() instanceof e8.d)) ? cVar.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, bVar, null) : cVar.decodeSerializableElement(getDescriptor(), iDecodeElementIndex, bVar, t6.a0.f0(map, objDecodeSerializableElement)));
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        int iE = e(obj);
        e8.e descriptor = getDescriptor();
        f8.d dVarBeginCollection = fVar.beginCollection(descriptor, iE);
        Iterator itD = d(obj);
        int i10 = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i11 = i10 + 1;
            dVarBeginCollection.encodeSerializableElement(getDescriptor(), i10, this.f8255a, key);
            i10 += 2;
            dVarBeginCollection.encodeSerializableElement(getDescriptor(), i11, this.f8256b, value);
        }
        dVarBeginCollection.endStructure(descriptor);
    }
}
