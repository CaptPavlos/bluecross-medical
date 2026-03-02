package w7;

import r7.a0;
import r7.d0;
import r7.k0;
import r7.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends r7.s implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f13549a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.s f13550b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13551c;

    /* JADX WARN: Multi-variable type inference failed */
    public o(r7.s sVar, String str) {
        d0 d0Var = sVar instanceof d0 ? (d0) sVar : null;
        this.f13549a = d0Var == null ? a0.f12388a : d0Var;
        this.f13550b = sVar;
        this.f13551c = str;
    }

    @Override // r7.s
    public final void dispatch(w6.h hVar, Runnable runnable) {
        this.f13550b.dispatch(hVar, runnable);
    }

    @Override // r7.s
    public final void dispatchYield(w6.h hVar, Runnable runnable) {
        this.f13550b.dispatchYield(hVar, runnable);
    }

    @Override // r7.d0
    public final void f(long j10, r7.g gVar) {
        this.f13549a.f(j10, gVar);
    }

    @Override // r7.s
    public final boolean isDispatchNeeded(w6.h hVar) {
        return this.f13550b.isDispatchNeeded(hVar);
    }

    @Override // r7.d0
    public final k0 k(long j10, t1 t1Var, w6.h hVar) {
        return this.f13549a.k(j10, t1Var, hVar);
    }

    @Override // r7.s
    public final String toString() {
        return this.f13551c;
    }
}
