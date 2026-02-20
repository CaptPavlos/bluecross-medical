package s7;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.l;
import r7.a1;
import r7.d0;
import r7.g;
import r7.i0;
import r7.k0;
import r7.m1;
import r7.s;
import r7.t;
import r7.t1;
import w6.h;
import w7.n;
import w7.o;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends s implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f12714a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12715b;

    /* renamed from: c, reason: collision with root package name */
    public final c f12716c;

    public c(Handler handler, boolean z9) {
        this.f12714a = handler;
        this.f12715b = z9;
        this.f12716c = z9 ? this : new c(handler, true);
    }

    @Override // r7.s
    public final void dispatch(h hVar, Runnable runnable) {
        if (this.f12714a.post(runnable)) {
            return;
        }
        l(hVar, runnable);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f12714a == this.f12714a && cVar.f12715b == this.f12715b;
    }

    @Override // r7.d0
    public final void f(long j10, g gVar) {
        r5.a aVar = new r5.a(gVar, this, 2, false);
        if (j10 > 4611686018427387903L) {
            j10 = 4611686018427387903L;
        }
        if (this.f12714a.postDelayed(aVar, j10)) {
            gVar.u(new a8.d(11, this, aVar));
        } else {
            l(gVar.e, aVar);
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.f12714a) ^ (this.f12715b ? 1231 : 1237);
    }

    @Override // r7.s
    public final boolean isDispatchNeeded(h hVar) {
        return (this.f12715b && l.a(Looper.myLooper(), this.f12714a.getLooper())) ? false : true;
    }

    @Override // r7.d0
    public final k0 k(long j10, t1 t1Var, h hVar) {
        if (j10 > 4611686018427387903L) {
            j10 = 4611686018427387903L;
        }
        if (this.f12714a.postDelayed(t1Var, j10)) {
            return new androidx.datastore.core.a(1, this, t1Var);
        }
        l(hVar, t1Var);
        return m1.f12414a;
    }

    public final void l(h hVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        a1 a1Var = (a1) hVar.get(t.f12437b);
        if (a1Var != null) {
            a1Var.a(cancellationException);
        }
        e eVar = i0.f12407a;
        y7.d.f14116a.dispatch(hVar, runnable);
    }

    @Override // r7.s
    public final s limitedParallelism(int i10, String str) {
        w7.a.a(i10);
        return str != null ? new o(this, str) : this;
    }

    @Override // r7.s
    public final String toString() {
        c cVar;
        String str;
        e eVar = i0.f12407a;
        c cVar2 = n.f13548a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f12716c;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f12714a.toString();
        return this.f12715b ? a3.a.C(string, ".immediate") : string;
    }
}
