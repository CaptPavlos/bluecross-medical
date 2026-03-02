package r7;

import com.google.android.gms.internal.measurement.u6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a extends i1 implements w6.c, w {

    /* renamed from: c, reason: collision with root package name */
    public final w6.h f12387c;

    public a(w6.h hVar, boolean z9) {
        super(z9);
        L((a1) hVar.get(t.f12437b));
        this.f12387c = hVar.plus(this);
    }

    @Override // r7.i1
    public final void K(u6 u6Var) {
        y.o(u6Var, this.f12387c);
    }

    @Override // r7.i1
    public final void U(Object obj) {
        if (!(obj instanceof p)) {
            d0(obj);
            return;
        }
        p pVar = (p) obj;
        c0(p.f12425b.get(pVar) != 0, pVar.f12426a);
    }

    public final void e0(x xVar, a aVar, g7.p pVar) {
        int iOrdinal = xVar.ordinal();
        s6.w wVar = s6.w.f12711a;
        if (iOrdinal == 0) {
            try {
                w7.a.h(wVar, r0.f.F(r0.f.s(pVar, aVar, this)));
                return;
            } finally {
                resumeWith(new s6.j(th));
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                r0.f.F(r0.f.s(pVar, aVar, this)).resumeWith(wVar);
                return;
            }
            if (iOrdinal != 3) {
                androidx.window.layout.c.b();
                return;
            }
            try {
                w6.h hVar = this.f12387c;
                Object objL = w7.a.l(hVar, null);
                try {
                    kotlin.jvm.internal.a0.b(2, pVar);
                    Object objInvoke = pVar.invoke(aVar, this);
                    if (objInvoke != x6.a.f13718a) {
                        resumeWith(objInvoke);
                    }
                } finally {
                    w7.a.g(hVar, objL);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // w6.c
    public final w6.h getContext() {
        return this.f12387c;
    }

    @Override // r7.w
    public final w6.h getCoroutineContext() {
        return this.f12387c;
    }

    @Override // w6.c
    public final void resumeWith(Object obj) {
        Throwable thA = s6.k.a(obj);
        if (thA != null) {
            obj = new p(false, thA);
        }
        Object objQ = Q(obj);
        if (objQ == y.e) {
            return;
        }
        u(objQ);
    }

    @Override // r7.i1
    public final String z() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public void d0(Object obj) {
    }

    public void c0(boolean z9, Throwable th) {
    }
}
