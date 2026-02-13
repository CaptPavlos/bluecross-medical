package a6;

import com.uptodown.workers.PreRegisterWorker;
import r7.i0;
import r7.w;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f280a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PreRegisterWorker f281b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PreRegisterWorker preRegisterWorker, w6.c cVar) {
        super(2, cVar);
        this.f281b = preRegisterWorker;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new p(this.f281b, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((p) create((w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f280a;
        w6.c cVar = null;
        s6.w wVar = s6.w.f12711a;
        int i11 = 1;
        if (i10 != 0) {
            if (i10 == 1) {
                s6.a.e(obj);
                return wVar;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        s6.a.e(obj);
        this.f280a = 1;
        y7.e eVar = i0.f12407a;
        Object objZ = y.z(new n(this.f281b, cVar, i11), y7.d.f14116a, this);
        x6.a aVar = x6.a.f13718a;
        if (objZ != aVar) {
            objZ = wVar;
        }
        return objZ == aVar ? aVar : wVar;
    }
}
