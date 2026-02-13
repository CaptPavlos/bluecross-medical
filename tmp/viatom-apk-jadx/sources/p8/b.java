package p8;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f12059a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final b f12060b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final b f12061c = new b();

    /* renamed from: d, reason: collision with root package name */
    public static final b f12062d = new b();
    public static b e;

    public static Socket a(m mVar, a aVar, s8.f fVar) {
        Iterator it = mVar.f12130d.iterator();
        while (it.hasNext()) {
            s8.a aVar2 = (s8.a) it.next();
            if (aVar2.g(aVar, null) && aVar2.h != null && aVar2 != fVar.a()) {
                if (fVar.f12743l != null || fVar.f12740i.f12725n.size() != 1) {
                    u.e();
                    return null;
                }
                Reference reference = (Reference) fVar.f12740i.f12725n.get(0);
                Socket socketB = fVar.b(true, false, false);
                fVar.f12740i = aVar2;
                aVar2.f12725n.add(reference);
                return socketB;
            }
        }
        return null;
    }

    public static void b(m mVar, a aVar, s8.f fVar, e0 e0Var) {
        Iterator it = mVar.f12130d.iterator();
        while (it.hasNext()) {
            s8.a aVar2 = (s8.a) it.next();
            if (aVar2.g(aVar, e0Var)) {
                if (fVar.f12740i != null) {
                    u.e();
                    return;
                }
                fVar.f12740i = aVar2;
                fVar.f12741j = true;
                aVar2.f12725n.add(new s8.e(fVar, fVar.f));
                return;
            }
        }
    }
}
