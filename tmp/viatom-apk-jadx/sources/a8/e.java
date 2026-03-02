package a8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import r7.x1;
import s6.w;
import w7.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements r7.f, x1 {

    /* renamed from: a, reason: collision with root package name */
    public final r7.g f309a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f310b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f311c;

    public e(i iVar, r7.g gVar, Object obj) {
        this.f311c = iVar;
        this.f309a = gVar;
        this.f310b = obj;
    }

    @Override // r7.x1
    public final void a(s sVar, int i10) {
        this.f309a.a(sVar, i10);
    }

    @Override // r7.f
    public final void c(Object obj, g7.q qVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i.h;
        Object obj2 = this.f310b;
        i iVar = this.f311c;
        atomicReferenceFieldUpdater.set(iVar, obj2);
        d dVar = new d(0, iVar, this);
        r7.g gVar = this.f309a;
        gVar.A(w.f12711a, gVar.f12400c, new b(dVar, 2));
    }

    @Override // r7.f
    public final e2.a f(Object obj, g7.q qVar) {
        i iVar = this.f311c;
        c cVar = new c(iVar, this, 1);
        e2.a aVarF = this.f309a.f((w) obj, cVar);
        if (aVarF != null) {
            i.h.set(iVar, this.f310b);
        }
        return aVarF;
    }

    @Override // w6.c
    public final w6.h getContext() {
        return this.f309a.e;
    }

    @Override // r7.f
    public final boolean n(Throwable th) {
        return this.f309a.n(th);
    }

    @Override // r7.f
    public final void r(Object obj) {
        this.f309a.r(obj);
    }

    @Override // w6.c
    public final void resumeWith(Object obj) {
        this.f309a.resumeWith(obj);
    }
}
