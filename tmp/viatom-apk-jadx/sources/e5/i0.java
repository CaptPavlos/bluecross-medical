package e5;

import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7775a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7776b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j0 f7777c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(String str, j0 j0Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7775a = i10;
        this.f7776b = str;
        this.f7777c = j0Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7775a) {
            case 0:
                return new i0(this.f7776b, this.f7777c, cVar, 0);
            default:
                return new i0(this.f7776b, this.f7777c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7775a) {
            case 0:
                i0 i0Var = (i0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                i0Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                i0 i0Var2 = (i0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                i0Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        FragmentActivity activity;
        switch (this.f7775a) {
            case 0:
                j0 j0Var = this.f7777c;
                ArrayList arrayList = j0Var.f7789j;
                s6.a.e(obj);
                String str = this.f7776b;
                if (str != null && str.length() != 0) {
                    n4.t0 t0Var = j0Var.h;
                    if (t0Var != null) {
                        ArrayList arrayList2 = t0Var.f11489d;
                        int size = arrayList2.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 < size) {
                                obj4 = arrayList2.get(i10);
                                i10++;
                                if (kotlin.jvm.internal.l.a(((h5.h) obj4).f8595w, str)) {
                                }
                            } else {
                                obj4 = null;
                            }
                        }
                        n4.t0 t0Var2 = j0Var.h;
                        t0Var2.getClass();
                        int iE0 = t6.l.e0(t0Var2.f11489d, (h5.h) obj4);
                        n4.t0 t0Var3 = j0Var.h;
                        t0Var3.getClass();
                        t0Var3.notifyItemChanged(iE0);
                    }
                    n4.t0 t0Var4 = j0Var.f7788i;
                    if (t0Var4 != null) {
                        ArrayList arrayList3 = t0Var4.f11489d;
                        int size2 = arrayList3.size();
                        int i11 = 0;
                        while (true) {
                            if (i11 < size2) {
                                obj3 = arrayList3.get(i11);
                                i11++;
                                if (kotlin.jvm.internal.l.a(((h5.h) obj3).f8595w, str)) {
                                }
                            } else {
                                obj3 = null;
                            }
                        }
                        n4.t0 t0Var5 = j0Var.f7788i;
                        t0Var5.getClass();
                        int iE02 = t6.l.e0(t0Var5.f11489d, (h5.h) obj3);
                        n4.t0 t0Var6 = j0Var.f7788i;
                        t0Var6.getClass();
                        t0Var6.notifyItemChanged(iE02);
                    }
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        it.getClass();
                        while (it.hasNext()) {
                            Object next = it.next();
                            next.getClass();
                            n4.t0 t0Var7 = (n4.t0) next;
                            ArrayList arrayList4 = t0Var7.f11489d;
                            int size3 = arrayList4.size();
                            int i12 = 0;
                            while (true) {
                                if (i12 < size3) {
                                    obj2 = arrayList4.get(i12);
                                    i12++;
                                    if (kotlin.jvm.internal.l.a(((h5.h) obj2).f8595w, str)) {
                                        break;
                                    }
                                } else {
                                    obj2 = null;
                                }
                            }
                            t0Var7.notifyItemChanged(arrayList4.indexOf((h5.h) obj2));
                        }
                    }
                }
                break;
            default:
                s6.a.e(obj);
                j0 j0Var2 = this.f7777c;
                if (o7.u.Z(this.f7776b, j0Var2.D().f8595w, true) && (activity = j0Var2.getActivity()) != null) {
                    j0Var2.p0(activity);
                }
                break;
        }
        return s6.w.f12711a;
    }
}
