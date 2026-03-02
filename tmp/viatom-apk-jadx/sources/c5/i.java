package c5;

import e5.f1;
import e5.h1;
import h5.x0;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1695a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w2.r f1696b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1697c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ArrayList arrayList, w2.r rVar, w6.c cVar) {
        super(2, cVar);
        this.f1697c = arrayList;
        this.f1696b = rVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1695a) {
            case 0:
                return new i(this.f1697c, this.f1696b, cVar);
            default:
                return new i(this.f1696b, this.f1697c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1695a) {
            case 0:
                i iVar = (i) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                iVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                i iVar2 = (i) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                iVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        h1 h1Var;
        h5.k kVar;
        n4.h hVar;
        switch (this.f1695a) {
            case 0:
                s6.a.e(obj);
                ArrayList arrayList = this.f1697c;
                if (!arrayList.isEmpty()) {
                    f1 f1Var = (f1) this.f1696b.f13463c;
                    f1Var.getClass();
                    n4.h hVar2 = f1Var.f7746a.f7766b;
                    if (hVar2 != null && !arrayList.isEmpty()) {
                        n4.g gVar = new n4.g();
                        gVar.f11345a = arrayList;
                        gVar.f11346b = 7;
                        hVar2.e.add(gVar);
                        hVar2.notifyItemInserted(hVar2.e.size() - 1);
                    }
                }
                break;
            default:
                s6.a.e(obj);
                w2.r rVar = this.f1696b;
                if (((h5.k) rVar.f13464d).f8632a == 523) {
                    f1 f1Var2 = (f1) rVar.f13463c;
                    f1Var2.getClass();
                    ArrayList arrayList2 = this.f1697c;
                    arrayList2.getClass();
                    if (!arrayList2.isEmpty() && (kVar = (h1Var = f1Var2.f7746a).f7765a) != null && (hVar = h1Var.f7766b) != null) {
                        if (kVar.f8632a == 523) {
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 558);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 566);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 562);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 564);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 559);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 645);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 560);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 561);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 565);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 593);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 568);
                            }
                            if (!arrayList2.isEmpty()) {
                                Iterator it = arrayList2.iterator();
                                it.getClass();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    next.getClass();
                                    hVar.b((x0) next);
                                }
                            }
                        } else {
                            Iterator it2 = arrayList2.iterator();
                            it2.getClass();
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                next2.getClass();
                                hVar.b((x0) next2);
                            }
                        }
                    }
                }
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(w2.r rVar, ArrayList arrayList, w6.c cVar) {
        super(2, cVar);
        this.f1696b = rVar;
        this.f1697c = arrayList;
    }
}
