package l4;

import androidx.lifecycle.ViewModelKt;
import com.uptodown.activities.SearchActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x8 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10997a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f10998b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10999c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x8(int i10, SearchActivity searchActivity, String str, w6.c cVar) {
        super(2, cVar);
        this.f10997a = i10;
        this.f10998b = searchActivity;
        this.f10999c = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10997a) {
            case 0:
                return new x8(0, this.f10998b, this.f10999c, cVar);
            default:
                return new x8(1, this.f10998b, this.f10999c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10997a) {
            case 0:
                x8 x8Var = (x8) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                x8Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                x8 x8Var2 = (x8) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                x8Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10997a;
        s6.w wVar = s6.w.f12711a;
        Object obj2 = null;
        int i11 = 0;
        String str = this.f10999c;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                int i12 = SearchActivity.Q;
                SearchActivity searchActivity = this.f10998b;
                b9 b9VarP0 = searchActivity.p0();
                String strB0 = o7.u.b0(str, "/", "", false);
                n4.l0 l0Var = searchActivity.K;
                l0Var.getClass();
                int itemCount = l0Var.getItemCount();
                b9VarP0.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(b9VarP0);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(b9VarP0, searchActivity, strB0, itemCount, (w6.c) null), 2);
                break;
            default:
                s6.a.e(obj);
                SearchActivity searchActivity2 = this.f10998b;
                n4.l0 l0Var2 = searchActivity2.K;
                if (l0Var2 != null && !l0Var2.f11426a.isEmpty() && str != null && str.length() != 0) {
                    n4.l0 l0Var3 = searchActivity2.K;
                    l0Var3.getClass();
                    ArrayList arrayList = l0Var3.f11426a;
                    int size = arrayList.size();
                    while (true) {
                        if (i11 < size) {
                            Object obj3 = arrayList.get(i11);
                            i11++;
                            if (kotlin.jvm.internal.l.a(((h5.h) obj3).f8595w, str)) {
                                obj2 = obj3;
                            }
                        }
                    }
                    n4.l0 l0Var4 = searchActivity2.K;
                    l0Var4.getClass();
                    int iE0 = t6.l.e0(l0Var4.f11426a, (h5.h) obj2);
                    n4.l0 l0Var5 = searchActivity2.K;
                    if (iE0 <= -1) {
                        if (l0Var5 != null) {
                            l0Var5.notifyDataSetChanged();
                            break;
                        }
                    } else {
                        l0Var5.getClass();
                        l0Var5.notifyItemChanged(iE0);
                        break;
                    }
                } else {
                    n4.l0 l0Var6 = searchActivity2.K;
                    if (l0Var6 != null) {
                        l0Var6.notifyDataSetChanged();
                        break;
                    }
                }
                break;
        }
        return wVar;
    }
}
