package j8;

import g7.l;
import java.util.Map;
import kotlin.jvm.internal.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Map f10032a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f10033b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f10034c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f10035d;
    public final Map e;

    public d(Map map, Map map2, Map map3, Map map4, Map map5, boolean z9) {
        map.getClass();
        map2.getClass();
        map3.getClass();
        map4.getClass();
        map5.getClass();
        this.f10032a = map;
        this.f10033b = map2;
        this.f10034c = map3;
        this.f10035d = map4;
        this.e = map5;
    }

    @Override // j8.f
    public final void a(g gVar) {
        for (Map.Entry entry : this.f10032a.entrySet()) {
            m7.c cVar = (m7.c) entry.getKey();
            c cVar2 = (c) entry.getValue();
            if (cVar2 instanceof a) {
                cVar.getClass();
                c8.b bVar = ((a) cVar2).f10030a;
                bVar.getClass();
                gVar.p(cVar, bVar);
            } else {
                if (!(cVar2 instanceof b)) {
                    androidx.window.layout.c.b();
                    return;
                }
                gVar.e(cVar, ((b) cVar2).f10031a);
            }
        }
        for (Map.Entry entry2 : this.f10033b.entrySet()) {
            m7.c cVar3 = (m7.c) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                m7.c cVar4 = (m7.c) entry3.getKey();
                c8.b bVar2 = (c8.b) entry3.getValue();
                cVar3.getClass();
                cVar4.getClass();
                bVar2.getClass();
                gVar.t(cVar3, cVar4, bVar2);
            }
        }
        for (Map.Entry entry4 : this.f10034c.entrySet()) {
            m7.c cVar5 = (m7.c) entry4.getKey();
            l lVar = (l) entry4.getValue();
            cVar5.getClass();
            lVar.getClass();
            a0.b(1, lVar);
            gVar.s(cVar5, lVar);
        }
        for (Map.Entry entry5 : this.e.entrySet()) {
            m7.c cVar6 = (m7.c) entry5.getKey();
            l lVar2 = (l) entry5.getValue();
            cVar6.getClass();
            lVar2.getClass();
            a0.b(1, lVar2);
            gVar.j(cVar6, lVar2);
        }
    }
}
