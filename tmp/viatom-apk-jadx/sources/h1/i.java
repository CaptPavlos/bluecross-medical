package h1;

import i0.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final p f8418a = new p();

    public i(d0.i iVar) {
        y2.c cVar = new y2.c(this, 16);
        iVar.getClass();
        ((p) iVar.f6781b).c(j.f8419a, new d0.i(cVar, 15));
    }

    public final void a(Object obj) {
        this.f8418a.l(obj);
    }

    public final boolean b(Exception exc) {
        p pVar = this.f8418a;
        pVar.getClass();
        y.h(exc, "Exception must not be null");
        synchronized (pVar.f8435a) {
            try {
                if (pVar.f8437c) {
                    return false;
                }
                pVar.f8437c = true;
                pVar.f = exc;
                pVar.f8436b.q(pVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Object obj) {
        this.f8418a.n(obj);
    }

    public i() {
    }
}
