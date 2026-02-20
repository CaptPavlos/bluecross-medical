package r7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends e1 {
    public final /* synthetic */ int e;
    public final g f;

    public /* synthetic */ i(g gVar, int i10) {
        this.e = i10;
        this.f = gVar;
    }

    @Override // r7.e1
    public final boolean i() {
        switch (this.e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // r7.e1
    public final void j(Throwable th) {
        switch (this.e) {
            case 0:
                i1 i1VarH = h();
                g gVar = this.f;
                Throwable thP = gVar.p(i1VarH);
                if (gVar.w()) {
                    w7.f fVar = (w7.f) gVar.f12399d;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = w7.f.h;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(fVar);
                        e2.a aVar = w7.a.f13526c;
                        if (kotlin.jvm.internal.l.a(obj, aVar)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, aVar, thP)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != aVar) {
                                    break;
                                }
                            }
                            break;
                        } else if (obj instanceof Throwable) {
                            break;
                        } else {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                                    break;
                                }
                            }
                        }
                    }
                }
                gVar.n(thP);
                if (!gVar.w()) {
                    gVar.m();
                    break;
                }
                break;
            default:
                this.f.resumeWith(s6.w.f12711a);
                break;
        }
    }
}
