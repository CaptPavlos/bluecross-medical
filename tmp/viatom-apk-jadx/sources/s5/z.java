package s5;

import android.content.Context;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import e5.u0;
import h5.y0;
import java.util.ArrayList;
import java.util.Iterator;
import l4.u4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12681a;

    /* renamed from: b, reason: collision with root package name */
    public int f12682b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f12683c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(TvMyAppsFragment tvMyAppsFragment, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12681a = i10;
        this.f12683c = tvMyAppsFragment;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12681a) {
            case 0:
                return new z(this.f12683c, cVar, 0);
            default:
                return new z(this.f12683c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12681a) {
        }
        return ((z) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int applicationEnabledSetting;
        Iterator it;
        int applicationEnabledSetting2;
        int i10 = this.f12681a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        TvMyAppsFragment tvMyAppsFragment = this.f12683c;
        boolean z9 = true;
        char c10 = 1;
        switch (i10) {
            case 0:
                int i11 = this.f12682b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    this.f12682b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    Object objZ = r7.y.z(new z(tvMyAppsFragment, null, c10 == true ? 1 : 0), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            default:
                int i12 = this.f12682b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    if (tvMyAppsFragment.getContext() != null) {
                        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                        boolean z10 = tvMyAppsFragment.f6711d;
                        h5.e eVar2 = h5.e.f8506a;
                        if (z10) {
                            Context contextRequireContext = tvMyAppsFragment.requireContext();
                            contextRequireContext.getClass();
                            ArrayList arrayListI = v5.a.i(contextRequireContext);
                            v5.g gVarL = v5.g.f13148u.l(contextRequireContext);
                            gVarL.a();
                            ArrayList arrayList = new ArrayList();
                            Iterator it2 = arrayListI.iterator();
                            it2.getClass();
                            while (it2.hasNext()) {
                                Object next = it2.next();
                                next.getClass();
                                h5.f fVar = (h5.f) next;
                                if (fVar.b(contextRequireContext)) {
                                    if (fVar.f8532m == 1) {
                                        fVar.g = eVar2;
                                    } else {
                                        String str = fVar.f8526c;
                                        str.getClass();
                                        y0 y0VarM = gVarL.M(str);
                                        if (y0VarM == null) {
                                            long j10 = fVar.f8534o;
                                            long j11 = fVar.f8537r;
                                            long jCurrentTimeMillis = System.currentTimeMillis();
                                            if (j11 != j10 && jCurrentTimeMillis - j10 < 604800000) {
                                                fVar.g = h5.e.f8507b;
                                            }
                                        } else if (y0VarM.f != 1) {
                                            fVar.g = eVar2;
                                            String str2 = fVar.f8526c;
                                            str2.getClass();
                                            try {
                                                applicationEnabledSetting2 = contextRequireContext.getPackageManager().getApplicationEnabledSetting(str2);
                                            } catch (Error e) {
                                                e.printStackTrace();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                            if (applicationEnabledSetting2 != 2 && applicationEnabledSetting2 != 3 && applicationEnabledSetting2 != 4) {
                                                if (y0VarM.f == 0) {
                                                    arrayList.add(fVar);
                                                }
                                            }
                                        }
                                        if (y0VarM != null && y0VarM.e == 0) {
                                            y0VarM.e = 1;
                                            gVarL.c0(y0VarM);
                                        }
                                    }
                                }
                                ArrayList arrayList2 = UptodownApp.f6636n0;
                                if (arrayList2 != null) {
                                    Iterator it3 = arrayList2.iterator();
                                    it3.getClass();
                                    while (it3.hasNext()) {
                                        Object next2 = it3.next();
                                        next2.getClass();
                                        h5.f0 f0Var = (h5.f0) next2;
                                        if (kotlin.jvm.internal.l.a(f0Var.f8545b, fVar.f8538s)) {
                                            fVar.f8539u = f0Var;
                                        }
                                    }
                                }
                            }
                            xVar.f10138a = arrayList;
                        } else {
                            Context contextRequireContext2 = tvMyAppsFragment.requireContext();
                            contextRequireContext2.getClass();
                            xVar.f10138a = v5.a.i(contextRequireContext2);
                            ArrayList arrayList3 = new ArrayList();
                            Iterator it4 = ((ArrayList) xVar.f10138a).iterator();
                            it4.getClass();
                            while (it4.hasNext()) {
                                Object next3 = it4.next();
                                next3.getClass();
                                h5.f fVar2 = (h5.f) next3;
                                if (tvMyAppsFragment.getContext() != null) {
                                    if (o7.u.Z(tvMyAppsFragment.requireContext().getPackageName(), fVar2.f8526c, true)) {
                                        arrayList3.add(fVar2);
                                    } else {
                                        Context contextRequireContext3 = tvMyAppsFragment.requireContext();
                                        contextRequireContext3.getClass();
                                        if (fVar2.b(contextRequireContext3)) {
                                            Context contextRequireContext4 = tvMyAppsFragment.requireContext();
                                            contextRequireContext4.getClass();
                                            String str3 = fVar2.f8526c;
                                            str3.getClass();
                                            try {
                                                applicationEnabledSetting = contextRequireContext4.getPackageManager().getApplicationEnabledSetting(str3);
                                            } catch (Error e7) {
                                                e7.printStackTrace();
                                            } catch (Exception e10) {
                                                e10.printStackTrace();
                                            }
                                            if (applicationEnabledSetting != 2 && applicationEnabledSetting != 3 && applicationEnabledSetting != 4) {
                                                arrayList3.add(fVar2);
                                            }
                                        }
                                    }
                                }
                            }
                            xVar.f10138a = arrayList3;
                        }
                        ArrayList arrayList4 = (ArrayList) xVar.f10138a;
                        t6.q.W(arrayList4, new a6.h(5));
                        if (tvMyAppsFragment.getContext() != null) {
                            t3.h hVar = v5.g.f13148u;
                            Context contextRequireContext5 = tvMyAppsFragment.requireContext();
                            contextRequireContext5.getClass();
                            v5.g gVarL2 = hVar.l(contextRequireContext5);
                            gVarL2.a();
                            ArrayList arrayListO = gVarL2.O();
                            gVarL2.b();
                            Iterator it5 = arrayListO.iterator();
                            it5.getClass();
                            while (it5.hasNext()) {
                                Object next4 = it5.next();
                                next4.getClass();
                                y0 y0Var = (y0) next4;
                                int size = arrayList4.size();
                                int i13 = 0;
                                while (i13 < size) {
                                    if (o7.u.Z(y0Var.f8795b, ((h5.f) arrayList4.get(i13)).f8526c, z9)) {
                                        it = it5;
                                        if (y0Var.f8796c > ((h5.f) arrayList4.get(i13)).f8527d) {
                                            h5.f fVar3 = (h5.f) arrayList4.get(i13);
                                            fVar3.getClass();
                                            fVar3.g = eVar2;
                                        }
                                    } else {
                                        it = it5;
                                    }
                                    i13++;
                                    it5 = it;
                                    z9 = true;
                                }
                            }
                        }
                        t6.q.W(arrayList4, new com.google.android.material.button.a(new u0(6), 4));
                        if (tvMyAppsFragment.getContext() != null) {
                            String packageName = tvMyAppsFragment.requireContext().getPackageName();
                            int i14 = 0;
                            while (i14 < arrayList4.size() && (!o7.u.Z(packageName, ((h5.f) arrayList4.get(i14)).f8526c, true) || ((h5.f) arrayList4.get(i14)).g != eVar2)) {
                                i14++;
                            }
                            if (i14 < arrayList4.size()) {
                                Object objRemove = arrayList4.remove(i14);
                                objRemove.getClass();
                                arrayList4.add(0, (h5.f) objRemove);
                            }
                        }
                        y7.e eVar3 = r7.i0.f12407a;
                        s7.c cVar = w7.n.f13548a;
                        u4 u4Var = new u4(tvMyAppsFragment, xVar, null, 27);
                        this.f12682b = 1;
                        if (r7.y.z(u4Var, cVar, this) == aVar) {
                            break;
                        }
                    }
                } else if (i12 != 1) {
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
