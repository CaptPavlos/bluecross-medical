package c5;

import android.content.Context;
import c1.w4;
import h5.p0;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1765a;

    /* renamed from: b, reason: collision with root package name */
    public int f1766b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w2.r f1767c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(w2.r rVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1765a = i10;
        this.f1767c = rVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1765a) {
            case 0:
                return new w(this.f1767c, cVar, 0);
            default:
                return new w(this.f1767c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1765a) {
        }
        return ((w) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f1765a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        w2.r rVar = this.f1767c;
        int i11 = 1;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i12 = this.f1766b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    this.f1766b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    Object objZ = r7.y.z(new w(rVar, cVar, i11), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                        break;
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            default:
                Context context = (Context) rVar.f13463c;
                int i13 = this.f1766b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    p0 p0VarD = new w4(context, 4, false).d((String) rVar.f13462b);
                    new HashMap();
                    new ArrayList();
                    long jC = h5.h.c(p0VarD);
                    if (jC <= 0) {
                        y7.e eVar2 = r7.i0.f12407a;
                        s7.c cVar2 = w7.n.f13548a;
                        a6.n nVar = new a6.n(rVar, cVar, 5);
                        this.f1766b = 1;
                        if (r7.y.z(nVar, cVar2, this) == aVar) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else if (i13 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
        }
        return aVar;
    }
}
