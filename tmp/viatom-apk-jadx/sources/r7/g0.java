package r7;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class g0 extends y7.h {

    /* renamed from: c, reason: collision with root package name */
    public int f12400c;

    public g0(int i10) {
        super(0L, false);
        this.f12400c = i10;
    }

    public abstract w6.c d();

    public Throwable e(Object obj) {
        p pVar = obj instanceof p ? (p) obj : null;
        if (pVar != null) {
            return pVar.f12426a;
        }
        return null;
    }

    public final void h(Throwable th) {
        y.o(new f7.a("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th), d().getContext());
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            w6.c cVarD = d();
            cVarD.getClass();
            w7.f fVar = (w7.f) cVarD;
            w6.c cVar = fVar.e;
            Object obj = fVar.g;
            w6.h context = cVar.getContext();
            Object objL = w7.a.l(context, obj);
            a1 a1Var = null;
            v1 v1VarY = objL != w7.a.f13527d ? y.y(cVar, context, objL) : null;
            try {
                w6.h context2 = cVar.getContext();
                Object objI = i();
                Throwable thE = e(objI);
                if (thE == null) {
                    int i10 = this.f12400c;
                    boolean z9 = true;
                    if (i10 != 1 && i10 != 2) {
                        z9 = false;
                    }
                    if (z9) {
                        a1Var = (a1) context2.get(t.f12437b);
                    }
                }
                if (a1Var != null && !a1Var.isActive()) {
                    CancellationException cancellationExceptionE = a1Var.e();
                    b(cancellationExceptionE);
                    cVar.resumeWith(s6.a.b(cancellationExceptionE));
                } else if (thE != null) {
                    cVar.resumeWith(new s6.j(thE));
                } else {
                    cVar.resumeWith(g(objI));
                }
                if (v1VarY != null && !v1VarY.f0()) {
                    return;
                }
                w7.a.g(context, objL);
            } catch (Throwable th) {
                if (v1VarY == null || v1VarY.f0()) {
                    w7.a.g(context, objL);
                }
                throw th;
            }
        } catch (Throwable th2) {
            h(th2);
        }
    }

    public void b(CancellationException cancellationException) {
    }

    public Object g(Object obj) {
        return obj;
    }
}
