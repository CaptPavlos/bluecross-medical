package t7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import r7.x1;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements x1 {

    /* renamed from: a, reason: collision with root package name */
    public Object f12817a = g.f12844p;

    /* renamed from: b, reason: collision with root package name */
    public r7.g f12818b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f12819c;

    public b(e eVar) {
        this.f12819c = eVar;
    }

    @Override // r7.x1
    public final void a(w7.s sVar, int i10) {
        r7.g gVar = this.f12818b;
        if (gVar != null) {
            gVar.a(sVar, i10);
        }
    }

    public final Object b(y6.c cVar) throws Throwable {
        m mVar;
        m mVar2;
        Object obj = this.f12817a;
        boolean z9 = true;
        if (obj == g.f12844p || obj == g.f12840l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e.g;
            e eVar = this.f12819c;
            m mVar3 = (m) atomicReferenceFieldUpdater.get(eVar);
            while (!eVar.w()) {
                long andIncrement = e.f12827c.getAndIncrement(eVar);
                long j10 = g.f12834b;
                long j11 = andIncrement / j10;
                int i10 = (int) (andIncrement % j10);
                if (mVar3.f13555c != j11) {
                    m mVarM = eVar.m(j11, mVar3);
                    if (mVarM == null) {
                        continue;
                    } else {
                        mVar = mVarM;
                    }
                } else {
                    mVar = mVar3;
                }
                Object objH = eVar.H(mVar, i10, andIncrement, null);
                e2.a aVar = g.f12841m;
                if (objH == aVar) {
                    androidx.window.layout.c.g("unreachable");
                    return null;
                }
                e2.a aVar2 = g.f12843o;
                if (objH == aVar2) {
                    if (andIncrement < eVar.t()) {
                        mVar.a();
                    }
                    mVar3 = mVar;
                } else if (objH == g.f12842n) {
                    r7.g gVarN = y.n(r0.f.F(cVar));
                    try {
                        this.f12818b = gVarN;
                        try {
                            Object objH2 = eVar.H(mVar, i10, andIncrement, this);
                            if (objH2 == aVar) {
                                a(mVar, i10);
                            } else {
                                if (objH2 == aVar2) {
                                    if (andIncrement < eVar.t()) {
                                        mVar.a();
                                    }
                                    m mVar4 = (m) e.g.get(eVar);
                                    while (true) {
                                        if (eVar.w()) {
                                            r7.g gVar = this.f12818b;
                                            gVar.getClass();
                                            this.f12818b = null;
                                            this.f12817a = g.f12840l;
                                            Throwable thN = eVar.n();
                                            if (thN == null) {
                                                gVar.resumeWith(Boolean.FALSE);
                                            } else {
                                                gVar.resumeWith(new s6.j(thN));
                                            }
                                        } else {
                                            long andIncrement2 = e.f12827c.getAndIncrement(eVar);
                                            long j12 = g.f12834b;
                                            long j13 = andIncrement2 / j12;
                                            int i11 = (int) (andIncrement2 % j12);
                                            if (mVar4.f13555c != j13) {
                                                m mVarM2 = eVar.m(j13, mVar4);
                                                if (mVarM2 != null) {
                                                    mVar2 = mVarM2;
                                                }
                                            } else {
                                                mVar2 = mVar4;
                                            }
                                            Object objH3 = eVar.H(mVar2, i11, andIncrement2, this);
                                            m mVar5 = mVar2;
                                            if (objH3 == g.f12841m) {
                                                a(mVar5, i11);
                                                break;
                                            }
                                            if (objH3 == g.f12843o) {
                                                if (andIncrement2 < eVar.t()) {
                                                    mVar5.a();
                                                }
                                                mVar4 = mVar5;
                                            } else {
                                                if (objH3 == g.f12842n) {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                                mVar5.a();
                                                this.f12817a = objH3;
                                                this.f12818b = null;
                                            }
                                        }
                                    }
                                } else {
                                    mVar.a();
                                    this.f12817a = objH2;
                                    this.f12818b = null;
                                }
                                gVarN.c(Boolean.TRUE, null);
                            }
                            return gVarN.q();
                        } catch (Throwable th) {
                            th = th;
                            gVarN.z();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    mVar.a();
                    this.f12817a = objH;
                }
            }
            this.f12817a = g.f12840l;
            Throwable thN2 = eVar.n();
            if (thN2 != null) {
                int i12 = w7.t.f13556a;
                throw thN2;
            }
            z9 = false;
        }
        return Boolean.valueOf(z9);
    }

    public final Object c() throws Throwable {
        Object obj = this.f12817a;
        e2.a aVar = g.f12844p;
        if (obj == aVar) {
            androidx.window.layout.c.g("`hasNext()` has not been invoked");
            return null;
        }
        this.f12817a = aVar;
        if (obj != g.f12840l) {
            return obj;
        }
        Throwable thR = this.f12819c.r();
        int i10 = w7.t.f13556a;
        throw thR;
    }
}
