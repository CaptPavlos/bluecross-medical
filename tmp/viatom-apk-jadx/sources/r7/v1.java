package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v1 extends w7.r {
    public final ThreadLocal e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public v1(w6.c cVar, w6.h hVar) {
        w1 w1Var = w1.f12444a;
        super(cVar, hVar.get(w1Var) == null ? hVar.plus(w1Var) : hVar);
        this.e = new ThreadLocal();
        if (cVar.getContext().get(w6.d.f13522a) instanceof s) {
            return;
        }
        Object objL = w7.a.l(hVar, null);
        w7.a.g(hVar, objL);
        g0(hVar, objL);
    }

    public final boolean f0() {
        boolean z9 = this.threadLocalIsSet && this.e.get() == null;
        this.e.remove();
        return !z9;
    }

    public final void g0(w6.h hVar, Object obj) {
        this.threadLocalIsSet = true;
        this.e.set(new s6.i(hVar, obj));
    }

    @Override // w7.r, r7.i1
    public final void u(Object obj) {
        if (this.threadLocalIsSet) {
            s6.i iVar = (s6.i) this.e.get();
            if (iVar != null) {
                w7.a.g((w6.h) iVar.f12693a, iVar.f12694b);
            }
            this.e.remove();
        }
        Object objS = y.s(obj);
        w6.c cVar = this.f13553d;
        w6.h context = cVar.getContext();
        Object objL = w7.a.l(context, null);
        v1 v1VarY = objL != w7.a.f13527d ? y.y(cVar, context, objL) : null;
        try {
            this.f13553d.resumeWith(objS);
            if (v1VarY == null || v1VarY.f0()) {
                w7.a.g(context, objL);
            }
        } catch (Throwable th) {
            if (v1VarY == null || v1VarY.f0()) {
                w7.a.g(context, objL);
            }
            throw th;
        }
    }
}
