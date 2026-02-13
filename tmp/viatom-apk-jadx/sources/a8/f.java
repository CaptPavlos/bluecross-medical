package a8;

import r7.x1;
import w7.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements x1 {

    /* renamed from: a, reason: collision with root package name */
    public final f f312a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f313b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f314c;

    public f(i iVar, f fVar, Object obj) {
        this.f314c = iVar;
        this.f312a = fVar;
        this.f313b = obj;
    }

    @Override // r7.x1
    public final void a(s sVar, int i10) {
        this.f312a.a(sVar, i10);
    }

    public final void b(Object obj) {
        i.h.set(this.f314c, this.f313b);
        this.f312a.b(obj);
    }

    public final boolean c(Object obj, Object obj2) {
        boolean zC = this.f312a.c(obj, obj2);
        if (zC) {
            i.h.set(this.f314c, this.f313b);
        }
        return zC;
    }
}
