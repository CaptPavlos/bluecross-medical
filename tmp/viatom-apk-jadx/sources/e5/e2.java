package e5;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e2 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7735a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f2 f7736b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f7737c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h5.k f7738d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e2(f2 f2Var, Context context, h5.k kVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7735a = i10;
        this.f7736b = f2Var;
        this.f7737c = context;
        this.f7738d = kVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7735a) {
            case 0:
                return new e2(this.f7736b, this.f7737c, this.f7738d, cVar, 0);
            default:
                return new e2(this.f7736b, this.f7737c, this.f7738d, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7735a) {
            case 0:
                e2 e2Var = (e2) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                e2Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                e2 e2Var2 = (e2) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                e2Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        switch (this.f7735a) {
            case 0:
                s6.a.e(obj);
                f2 f2Var = this.f7736b;
                f2Var.e = true;
                int i10 = 0;
                f2Var.f7751i = 0;
                h5.k kVar = this.f7738d;
                Context context = this.f7737c;
                h5.x0 x0VarA = f2.a(f2Var, context, kVar);
                ArrayList arrayList = x0VarA.f8789b;
                int size = arrayList.size();
                while (true) {
                    if (i10 < size) {
                        obj2 = arrayList.get(i10);
                        i10++;
                        if (((h5.h) obj2).m()) {
                        }
                    } else {
                        obj2 = null;
                    }
                }
                h5.h hVar = (h5.h) obj2;
                if (hVar != null) {
                    f2Var.g = true;
                    f2Var.d(context, hVar, "impress");
                }
                u7.m0 m0Var = f2Var.f7747a;
                v5.l lVar = new v5.l(new c2(x0VarA, true));
                m0Var.getClass();
                m0Var.g(null, lVar);
                h5.k kVar2 = x0VarA.f8788a;
                if (kVar2.f8635d) {
                    f2Var.c(context, kVar2.f8632a);
                }
                break;
            default:
                s6.a.e(obj);
                f2 f2Var2 = this.f7736b;
                f2Var2.e = true;
                h5.x0 x0VarA2 = f2.a(f2Var2, this.f7737c, this.f7738d);
                if (x0VarA2.f8789b.isEmpty()) {
                    f2Var2.f = true;
                }
                u7.m0 m0Var2 = f2Var2.f7747a;
                v5.l lVar2 = new v5.l(new c2(x0VarA2, false));
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return s6.w.f12711a;
    }
}
