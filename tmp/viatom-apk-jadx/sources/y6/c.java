package y6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c extends a {
    private final w6.h _context;
    private transient w6.c intercepted;

    public c(w6.c cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }

    @Override // w6.c
    public w6.h getContext() {
        w6.h hVar = this._context;
        hVar.getClass();
        return hVar;
    }

    public final w6.c intercepted() {
        w6.c cVarInterceptContinuation = this.intercepted;
        if (cVarInterceptContinuation == null) {
            w6.e eVar = (w6.e) getContext().get(w6.d.f13522a);
            if (eVar == null || (cVarInterceptContinuation = eVar.interceptContinuation(this)) == null) {
                cVarInterceptContinuation = this;
            }
            this.intercepted = cVarInterceptContinuation;
        }
        return cVarInterceptContinuation;
    }

    @Override // y6.a
    public void releaseIntercepted() {
        w6.c cVar = this.intercepted;
        if (cVar != null && cVar != this) {
            w6.f fVar = getContext().get(w6.d.f13522a);
            fVar.getClass();
            ((w6.e) fVar).releaseInterceptedContinuation(cVar);
        }
        this.intercepted = b.f14097a;
    }

    public c(w6.c cVar, w6.h hVar) {
        super(cVar);
        this._context = hVar;
    }
}
