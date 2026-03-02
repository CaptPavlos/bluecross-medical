package h0;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y extends s {

    /* renamed from: b, reason: collision with root package name */
    public final h1.i f8416b;

    public y(h1.i iVar) {
        super(4);
        this.f8416b = iVar;
    }

    @Override // h0.z
    public final void a(Status status) {
        this.f8416b.b(new e0.m(status));
    }

    @Override // h0.z
    public final void b(Exception exc) {
        this.f8416b.b(exc);
    }

    @Override // h0.z
    public final void c(n nVar) throws DeadObjectException {
        try {
            h(nVar);
        } catch (DeadObjectException e) {
            a(z.e(e));
            throw e;
        } catch (RemoteException e3) {
            a(z.e(e3));
        } catch (RuntimeException e7) {
            this.f8416b.b(e7);
        }
    }

    @Override // h0.s
    public final boolean f(n nVar) {
        if (nVar.f8385n.get(null) == null) {
            return false;
        }
        com.google.gson.internal.a.k();
        return false;
    }

    @Override // h0.s
    public final f0.d[] g(n nVar) {
        if (nVar.f8385n.get(null) == null) {
            return null;
        }
        com.google.gson.internal.a.k();
        return null;
    }

    public final void h(n nVar) {
        if (nVar.f8385n.remove(null) == null) {
            this.f8416b.c(Boolean.FALSE);
        } else {
            com.google.gson.internal.a.k();
        }
    }

    @Override // h0.z
    public final /* bridge */ /* synthetic */ void d(a4.f fVar, boolean z9) {
    }
}
