package l4;

import com.uptodown.activities.MoreInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b3 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10240a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f10241b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b3(MoreInfo moreInfo, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10240a = i10;
        this.f10241b = moreInfo;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10240a) {
            case 0:
                return new b3(this.f10241b, cVar, 0);
            default:
                return new b3(this.f10241b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10240a) {
            case 0:
                b3 b3Var = (b3) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                b3Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                b3 b3Var2 = (b3) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                b3Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10240a;
        s6.w wVar = s6.w.f12711a;
        MoreInfo moreInfo = this.f10241b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                ArrayList arrayList = moreInfo.L;
                if (arrayList != null && !arrayList.isEmpty()) {
                    moreInfo.q0().f7416k.setVisibility(0);
                    moreInfo.q0().E.setTypeface(o4.b.f11719r);
                    moreInfo.q0().F.setTypeface(o4.b.f11720s);
                    ArrayList arrayList2 = moreInfo.L;
                    arrayList2.getClass();
                    Iterator it = arrayList2.iterator();
                    it.getClass();
                    String strJ = null;
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        String str = (String) next;
                        strJ = strJ == null ? str : a3.a.j(strJ, ", ", str);
                    }
                    moreInfo.q0().F.setText(strJ);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                int i11 = MoreInfo.P;
                moreInfo.q0().f7414j.setVisibility(0);
                break;
        }
        return wVar;
    }
}
