package c5;

import com.uptodown.R;
import e5.f1;
import e5.h1;
import h5.x0;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1689a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w2.r f1690b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(w2.r rVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1689a = i10;
        this.f1690b = rVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1689a) {
            case 0:
                return new h(this.f1690b, cVar, 0);
            default:
                return new h(this.f1690b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1689a) {
            case 0:
                h hVar = (h) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                hVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                h hVar2 = (h) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                hVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        switch (this.f1689a) {
            case 0:
                s6.a.e(obj);
                h1 h1Var = ((f1) this.f1690b.f13463c).f7746a;
                n4.h hVar = h1Var.f7766b;
                if (hVar == null || (arrayList4 = hVar.e) == null || arrayList4.isEmpty()) {
                    h1Var.f7766b = new n4.h(h1Var.h, h1Var.f7769i, h1Var.f7770j, h1Var.getClass().getSimpleName());
                }
                if (h1Var.f7768d.isEmpty() || h1Var.f7767c.isEmpty()) {
                    h1Var.f().setVisibility(8);
                    h1Var.i().setVisibility(0);
                    h1Var.e().setVisibility(0);
                } else {
                    String strB = h1Var.b();
                    if (strB == null || strB.length() == 0) {
                        h1Var.l(h1Var.getString(R.string.apps));
                    }
                    n4.h hVar2 = h1Var.f7766b;
                    if (hVar2 != null) {
                        ArrayList arrayList5 = h1Var.f7768d;
                        ArrayList arrayList6 = h1Var.f7767c;
                        x0 x0Var = h1Var.e;
                        x0 x0Var2 = h1Var.f;
                        String strB2 = h1Var.b();
                        strB2.getClass();
                        arrayList5.getClass();
                        arrayList6.getClass();
                        hVar2.e = new ArrayList();
                        if (!arrayList5.isEmpty()) {
                            n4.f fVar = new n4.f();
                            fVar.f11338c = strB2;
                            fVar.f11336a = arrayList5;
                            fVar.f11337b = arrayList6;
                            n4.g gVar = new n4.g();
                            gVar.f11345a = fVar;
                            gVar.f11346b = 0;
                            hVar2.e.add(gVar);
                        }
                        if (x0Var != null && (arrayList3 = x0Var.f8789b) != null && (!arrayList3.isEmpty())) {
                            hVar2.b(x0Var);
                        }
                        if (arrayList6.isEmpty() || ((h5.k) arrayList6.get(0)).f != 523) {
                            if (x0Var2 != null && (arrayList = x0Var2.f8789b) != null && (!arrayList.isEmpty())) {
                                hVar2.b(x0Var2);
                            }
                        } else if (x0Var2 != null && (arrayList2 = x0Var2.f8789b) != null && (!arrayList2.isEmpty())) {
                            hVar2.b(x0Var2);
                        }
                    }
                    h1Var.f().setAdapter(h1Var.f7766b);
                    h1Var.f().setVisibility(0);
                    h1Var.i().setVisibility(8);
                }
                h1Var.d().setVisibility(8);
                break;
            default:
                s6.a.e(obj);
                w2.r rVar = this.f1690b;
                f1 f1Var = (f1) rVar.f13463c;
                ArrayList arrayList7 = (ArrayList) rVar.e;
                f1Var.getClass();
                arrayList7.getClass();
                f1Var.f7746a.f7767c = arrayList7;
                break;
        }
        return s6.w.f12711a;
    }
}
