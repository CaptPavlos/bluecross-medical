package e5;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import c1.w4;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.Updates;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7757a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f7758b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7759c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7760d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(String str, String str2, long j10, w6.c cVar) {
        super(2, cVar);
        this.f7757a = 2;
        this.f7759c = str;
        this.f7760d = str2;
        this.f7758b = j10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7757a) {
            case 0:
                return new g1((h1) this.f7760d, this.f7758b, this.f7759c, cVar, 0);
            case 1:
                return new g1((t1) this.f7760d, this.f7758b, this.f7759c, cVar, 1);
            case 2:
                return new g1(this.f7759c, (String) this.f7760d, this.f7758b, cVar);
            case 3:
                return new g1((FreeUpSpaceActivity) this.f7760d, this.f7759c, this.f7758b, cVar, 3);
            case 4:
                return new g1((MyApps) this.f7760d, this.f7759c, this.f7758b, cVar, 4);
            default:
                return new g1((Updates) this.f7760d, this.f7759c, this.f7758b, cVar, 5);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7757a) {
            case 0:
                g1 g1Var = (g1) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                g1Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                g1 g1Var2 = (g1) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                g1Var2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                g1 g1Var3 = (g1) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                g1Var3.invokeSuspend(wVar4);
                return wVar4;
            case 3:
                g1 g1Var4 = (g1) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                g1Var4.invokeSuspend(wVar5);
                return wVar5;
            case 4:
                g1 g1Var5 = (g1) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                g1Var5.invokeSuspend(wVar6);
                return wVar6;
            default:
                g1 g1Var6 = (g1) create(wVar, cVar);
                s6.w wVar7 = s6.w.f12711a;
                g1Var6.invokeSuspend(wVar7);
                return wVar7;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        n4.p pVar;
        int i10;
        n4.w0 w0Var;
        switch (this.f7757a) {
            case 0:
                s6.a.e(obj);
                Context contextRequireContext = ((h1) this.f7760d).requireContext();
                contextRequireContext.getClass();
                new w4(contextRequireContext, 4, false).G(this.f7759c, "parentCategoryFeature", this.f7758b);
                break;
            case 1:
                s6.a.e(obj);
                Context contextRequireContext2 = ((t1) this.f7760d).requireContext();
                contextRequireContext2.getClass();
                new w4(contextRequireContext2, 4, false).G(this.f7759c, "homeFeature", this.f7758b);
                break;
            case 2:
                s6.a.e(obj);
                Activity activity = o4.b.g;
                if (activity != null && (activity instanceof l4.w)) {
                    final l4.w wVar = (l4.w) activity;
                    String str = this.f7759c + '\n' + ((String) this.f7760d);
                    final long j10 = this.f7758b;
                    wVar.K(str, new g7.a() { // from class: l4.l
                        @Override // g7.a
                        public final Object invoke() {
                            w wVar2 = wVar;
                            Context applicationContext = wVar2.getApplicationContext();
                            applicationContext.getClass();
                            new c1.l(applicationContext, j10, new q(wVar2), LifecycleOwnerKt.getLifecycleScope(wVar2));
                            return s6.w.f12711a;
                        }
                    });
                }
                break;
            case 3:
                s6.a.e(obj);
                FreeUpSpaceActivity freeUpSpaceActivity = (FreeUpSpaceActivity) this.f7760d;
                String str2 = this.f7759c;
                int iN0 = FreeUpSpaceActivity.n0(freeUpSpaceActivity, str2);
                if (iN0 >= 0) {
                    n4.e eVar = freeUpSpaceActivity.J;
                    ArrayList arrayListA = eVar != null ? eVar.a() : null;
                    arrayListA.getClass();
                    ((h5.f) arrayListA.get(iN0)).f8533n = this.f7758b;
                    n4.e eVar2 = freeUpSpaceActivity.J;
                    if (eVar2 != null) {
                        eVar2.notifyItemChanged(FreeUpSpaceActivity.n0(freeUpSpaceActivity, str2));
                    }
                }
                break;
            case 4:
                s6.a.e(obj);
                MyApps myApps = (MyApps) this.f7760d;
                String str3 = this.f7759c;
                int iB0 = MyApps.B0(myApps, str3);
                if (iB0 >= 0 && (pVar = myApps.W) != null && (pVar.f11451d.get(iB0) instanceof h5.f)) {
                    n4.p pVar2 = myApps.W;
                    ArrayList arrayList = pVar2 != null ? pVar2.f11451d : null;
                    arrayList.getClass();
                    Object obj2 = arrayList.get(iB0);
                    obj2.getClass();
                    ((h5.f) obj2).f8533n = this.f7758b;
                    n4.p pVar3 = myApps.W;
                    if (pVar3 != null) {
                        pVar3.notifyItemChanged(MyApps.B0(myApps, str3));
                    }
                }
                break;
            default:
                s6.a.e(obj);
                Updates updates = (Updates) this.f7760d;
                n4.w0 w0Var2 = updates.X;
                ArrayList arrayListA2 = w0Var2 != null ? w0Var2.a() : null;
                if (arrayListA2 == null || arrayListA2.isEmpty()) {
                    i10 = -1;
                } else {
                    n4.w0 w0Var3 = updates.X;
                    ArrayList arrayListA3 = w0Var3 != null ? w0Var3.a() : null;
                    arrayListA3.getClass();
                    i10 = 0;
                    for (Object obj3 : arrayListA3) {
                        int i11 = i10 + 1;
                        if (!(obj3 instanceof n4.u0) || !o7.u.Z(((n4.u0) obj3).f11493a.f8526c, this.f7759c, true)) {
                            i10 = i11;
                        }
                    }
                    i10 = -1;
                }
                if (i10 >= 0 && (w0Var = updates.X) != null && (w0Var.a().get(i10) instanceof n4.u0)) {
                    n4.w0 w0Var4 = updates.X;
                    ArrayList arrayListA4 = w0Var4 != null ? w0Var4.a() : null;
                    arrayListA4.getClass();
                    Object obj4 = arrayListA4.get(i10);
                    obj4.getClass();
                    ((n4.u0) obj4).f11493a.f8533n = this.f7758b;
                    n4.w0 w0Var5 = updates.X;
                    if (w0Var5 != null) {
                        w0Var5.notifyItemChanged(i10);
                    }
                }
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(Fragment fragment, long j10, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7757a = i10;
        this.f7760d = fragment;
        this.f7758b = j10;
        this.f7759c = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(l4.w wVar, String str, long j10, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7757a = i10;
        this.f7760d = wVar;
        this.f7759c = str;
        this.f7758b = j10;
    }
}
