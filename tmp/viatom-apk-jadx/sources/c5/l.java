package c5;

import c1.w4;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1715a;

    /* renamed from: b, reason: collision with root package name */
    public int f1716b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f1717c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w4 f1718d;
    public final /* synthetic */ kotlin.jvm.internal.x e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(t tVar, w4 w4Var, kotlin.jvm.internal.x xVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1715a = i10;
        this.f1717c = tVar;
        this.f1718d = w4Var;
        this.e = xVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1715a) {
            case 0:
                return new l(this.f1717c, this.f1718d, this.e, cVar, 0);
            default:
                return new l(this.f1717c, this.f1718d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1715a) {
        }
        return ((l) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f1715a;
        kotlin.jvm.internal.x xVar = this.e;
        w4 w4Var = this.f1718d;
        t tVar = this.f1717c;
        x6.a aVar = x6.a.f13718a;
        s6.w wVar = s6.w.f12711a;
        switch (i10) {
            case 0:
                int i11 = this.f1716b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    ArrayList arrayList = (ArrayList) xVar.f10138a;
                    this.f1716b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    Object objZ = r7.y.z(new s(tVar, arrayList, w4Var, (w6.c) null), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            default:
                int i12 = this.f1716b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    ArrayList arrayList2 = (ArrayList) xVar.f10138a;
                    this.f1716b = 1;
                    y7.e eVar2 = r7.i0.f12407a;
                    Object objZ2 = r7.y.z(new s(arrayList2, tVar, w4Var, (w6.c) null), y7.d.f14116a, this);
                    if (objZ2 != aVar) {
                        objZ2 = wVar;
                    }
                    if (objZ2 == aVar) {
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
        }
        return wVar;
    }
}
