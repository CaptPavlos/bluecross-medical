package e5;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7683a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f7684b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f7685c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(Context context, long j10, boolean z9, w6.c cVar) {
        super(2, cVar);
        this.f7683a = context;
        this.f7684b = j10;
        this.f7685c = z9;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new b1(this.f7683a, this.f7684b, this.f7685c, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        b1 b1Var = (b1) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        b1Var.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        s6.a.e(obj);
        v5.g gVarL = v5.g.f13148u.l(this.f7683a);
        gVarL.a();
        long j10 = this.f7684b;
        if (gVarL.I(j10) != null) {
            if (this.f7685c) {
                gVarL.f0(1, j10);
            } else {
                gVarL.f0(0, j10);
            }
        }
        gVarL.b();
        return s6.w.f12711a;
    }
}
