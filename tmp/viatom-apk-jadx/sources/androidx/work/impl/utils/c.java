package androidx.work.impl.utils;

import a6.j;
import android.widget.ProgressBar;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import com.uptodown.activities.UserDeviceDetailsActivity;
import e5.b2;
import e5.h1;
import e5.j0;
import e5.t1;
import g5.g;
import g7.l;
import h5.h;
import h8.p;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import l4.hb;
import l4.ib;
import n4.n0;
import n4.p0;
import n4.u0;
import o7.i;
import o7.k;
import r7.i0;
import r7.y;
import s6.w;
import t6.a0;
import t6.u;
import w7.n;
import y5.r1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f758a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f759b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f760c;

    public /* synthetic */ c(int i10, Object obj, Object obj2) {
        this.f758a = i10;
        this.f759b = obj;
        this.f760c = obj2;
    }

    @Override // g7.a
    public final Object invoke() {
        String[] strArrNames;
        int i10 = this.f758a;
        w6.c cVar = null;
        w wVar = w.f12711a;
        Object obj = this.f760c;
        Object obj2 = this.f759b;
        switch (i10) {
            case 0:
                return CancelWorkRunnable.forId$lambda$1((WorkManagerImpl) obj2, (UUID) obj);
            case 1:
                return ((l) obj2).invoke((WorkDatabase) obj);
            case 2:
                e5.d dVar = (e5.d) obj;
                String str = ((h) obj2).f8595w;
                if (str != null) {
                    dVar.b(str);
                }
                return wVar;
            case 3:
                j0 j0Var = (j0) obj;
                String str2 = ((h) obj2).f8595w;
                if (str2 != null) {
                    j0Var.u0(str2);
                }
                return wVar;
            case 4:
                ((h1) obj2).m(((h) obj).f8595w);
                return wVar;
            case 5:
                ((t1) obj2).d(((h) obj).f8595w);
                return wVar;
            case 6:
                b2 b2Var = (b2) obj2;
                h hVar = (h) obj;
                hVar.getClass();
                p0 p0Var = b2Var.e;
                p0Var.getClass();
                ((n0) p0Var.f11458k.get(b2Var.c(hVar.f8595w))).f11441a = hVar;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(b2Var);
                y7.e eVar = i0.f12407a;
                y.q(lifecycleScope, n.f13548a, null, new j(b2Var, hVar, cVar, 14), 2);
                return wVar;
            case 7:
                e8.e eVar2 = (e8.e) obj2;
                h8.b bVar = (h8.b) obj;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                bVar.f8826a.getClass();
                i8.l.l(eVar2, bVar);
                int iE = eVar2.e();
                for (int i11 = 0; i11 < iE; i11++) {
                    List listG = eVar2.g(i11);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : listG) {
                        if (obj3 instanceof p) {
                            arrayList.add(obj3);
                        }
                    }
                    p pVar = (p) (arrayList.size() == 1 ? arrayList.get(0) : null);
                    if (pVar != null && (strArrNames = pVar.names()) != null) {
                        for (String str3 : strArrNames) {
                            String str4 = kotlin.jvm.internal.l.a(eVar2.getKind(), e8.h.f7972c) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str3)) {
                                throw new c8.h("The suggested name '" + str3 + "' for " + str4 + ' ' + eVar2.f(i11) + " is already one of the names for " + str4 + ' ' + eVar2.f(((Number) a0.f0(linkedHashMap, str3)).intValue()) + " in " + eVar2);
                            }
                            linkedHashMap.put(str3, Integer.valueOf(i11));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? u.f12809a : linkedHashMap;
            case 8:
                ((l4.w) obj2).U((File) obj, null);
                return wVar;
            case 9:
                UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) obj2;
                h5.h1 h1Var = (h5.h1) obj;
                int i12 = UserDeviceDetailsActivity.N;
                ib ibVarO0 = userDeviceDetailsActivity.o0();
                long j10 = h1Var.f8605a;
                String str5 = h1Var.f8606b;
                ibVarO0.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(ibVarO0);
                y7.e eVar3 = i0.f12407a;
                y.q(viewModelScope, y7.d.f14116a, null, new hb(userDeviceDetailsActivity, j10, ibVarO0, str5, (w6.c) null), 2);
                return wVar;
            case 10:
                String str6 = (String) obj;
                Matcher matcher = ((k) obj2).f11772a.matcher(str6);
                matcher.getClass();
                if (matcher.find(0)) {
                    return new i(matcher, str6);
                }
                return null;
            case 11:
                String str7 = ((h) obj).Z;
                str7.getClass();
                ((g) obj2).x(str7);
                return wVar;
            case 12:
                ((ProgressBar) obj2).setVisibility(8);
                ((y5.h) obj).f13873a = false;
                return wVar;
            default:
                u0 u0Var = (u0) obj;
                if (kotlin.jvm.internal.l.a(((r1) obj2).f13998r, u0Var.f11493a.f8526c)) {
                    u0Var.f11495c = false;
                    u0Var.f11496d = true;
                }
                return wVar;
        }
    }
}
