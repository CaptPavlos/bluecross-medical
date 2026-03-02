package h0;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c1.d0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.j4;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x extends s {

    /* renamed from: b, reason: collision with root package name */
    public final j4 f8413b;

    /* renamed from: c, reason: collision with root package name */
    public final h1.i f8414c;

    /* renamed from: d, reason: collision with root package name */
    public final d0 f8415d;

    public x(j4 j4Var, h1.i iVar, d0 d0Var) {
        super(2);
        this.f8414c = iVar;
        this.f8413b = j4Var;
        this.f8415d = d0Var;
        if (j4Var.f2007a) {
            com.google.gson.internal.a.n("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
            throw null;
        }
    }

    @Override // h0.z
    public final void a(Status status) {
        this.f8415d.getClass();
        this.f8414c.b(status.f1860c != null ? new g0.h(status) : new e0.m(status));
    }

    @Override // h0.z
    public final void b(Exception exc) {
        this.f8414c.b(exc);
    }

    @Override // h0.z
    public final void c(n nVar) throws DeadObjectException {
        h1.i iVar = this.f8414c;
        try {
            this.f8413b.i(nVar.f8381b, iVar);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e3) {
            a(z.e(e3));
        } catch (RuntimeException e7) {
            iVar.b(e7);
        }
    }

    @Override // h0.z
    public final void d(a4.f fVar, boolean z9) {
        Boolean boolValueOf = Boolean.valueOf(z9);
        Map map = (Map) fVar.f219c;
        h1.i iVar = this.f8414c;
        map.put(iVar, boolValueOf);
        h1.p pVar = iVar.f8418a;
        a4.f fVar2 = new a4.f(27, fVar, iVar);
        pVar.getClass();
        pVar.f8436b.o(new h1.m(h1.j.f8419a, fVar2));
        pVar.p();
    }

    @Override // h0.s
    public final boolean f(n nVar) {
        return this.f8413b.f2007a;
    }

    @Override // h0.s
    public final f0.d[] g(n nVar) {
        return (f0.d[]) this.f8413b.f2008b;
    }
}
