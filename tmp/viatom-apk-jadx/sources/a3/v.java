package a3;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v implements c3.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f167a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f168b;

    public /* synthetic */ v(d0.i iVar, int i10) {
        this.f167a = i10;
        this.f168b = iVar;
    }

    @Override // p6.a
    public final Object get() {
        int i10 = this.f167a;
        d0.i iVar = this.f168b;
        switch (i10) {
            case 0:
                l1.g gVar = (l1.g) iVar.f6781b;
                gVar.getClass();
                v0 v0Var = v0.f169a;
                return v0.a(gVar);
            default:
                return new d3.a((Context) iVar.f6781b);
        }
    }
}
