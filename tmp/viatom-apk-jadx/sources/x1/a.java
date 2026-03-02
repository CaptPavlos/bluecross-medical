package x1;

import h1.i;
import h1.p;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.arch.core.executor.a f13570a = new androidx.arch.core.executor.a(2);

    public static p a(p pVar, p pVar2) {
        y2.c cVar = new y2.c(14);
        i iVar = new i((d0.i) cVar.f13781b);
        androidx.transition.a aVar = new androidx.transition.a(iVar, new AtomicBoolean(false), cVar, 8);
        androidx.arch.core.executor.a aVar2 = f13570a;
        pVar.e(aVar2, aVar);
        pVar2.e(aVar2, aVar);
        return iVar.f8418a;
    }
}
