package c6;

import a3.x;
import a3.z0;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import c1.d0;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import d5.n;
import d9.o;
import d9.p;
import d9.t;
import f6.m;
import java.util.ArrayList;
import kotlin.jvm.internal.l;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1813a;

    public /* synthetic */ i(int i10) {
        this.f1813a = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v27, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Object, java.util.List] */
    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls) {
        String str;
        String str2;
        Object obj;
        String str3;
        String str4;
        String str5;
        int i10 = this.f1813a;
        cls.getClass();
        switch (i10) {
            case 0:
                return new h(i9.a.f(), i9.a.d(), ChoiceCmp.INSTANCE.getCallback());
            case 1:
                m mVarK = i9.a.k();
                o8.i iVarH = i9.a.h();
                f6.d googleVendorList$app_release = ChoiceCmp.INSTANCE.getGoogleVendorList$app_release();
                k8.h hVarA = i9.a.h().f11814b.a();
                r rVarC = i9.a.c();
                n nVarM = i9.a.m();
                ArrayList arrayList = i9.a.h().f.f7574j;
                ?? r13 = i9.a.h().f11814b.f11785l;
                ?? r14 = i9.a.h().f11814b.f11782i;
                ?? r15 = i9.a.h().f11814b.f11797z;
                Integer num = i9.a.h().f11814b.H;
                n6.c cVar = i9.a.f9111k;
                if (cVar == null) {
                    cVar = new n6.c();
                }
                return new e6.d(mVarK, iVarH, googleVendorList$app_release, hVarA, rVarC, nVarM, arrayList, r13, r14, r15, cVar);
            case 2:
                n nVarM2 = i9.a.m();
                nVarM2.i();
                if (((d9.g) nVarM2.g).X.length() == 0) {
                    t tVar = (t) nVarM2.f;
                    if (tVar == null) {
                        l.i("translationsText");
                        throw null;
                    }
                    str = tVar.f7584a.X;
                } else {
                    str = ((d9.g) nVarM2.g).X;
                }
                return new g6.c(new o(str, nVarM2.b()));
            case 3:
                m mVarK2 = i9.a.k();
                if (i9.a.y == null) {
                    i9.a.y = new x(i9.a.g(), i9.a.i(), new g4.a(), 23);
                }
                x xVar = i9.a.y;
                if (xVar != null) {
                    return new i6.e(mVarK2, xVar, i9.a.m());
                }
                l.i("disclosureRepository_");
                throw null;
            case 4:
                d0.i iVarJ = i9.a.j();
                ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                n6.c cVar2 = i9.a.f9111k;
                if (cVar2 == null) {
                    cVar2 = new n6.c();
                }
                return new j.c(iVarJ, callback, cVar2, i9.a.h());
            case 5:
                return new k6.d(i9.a.m(), i9.a.k(), i9.a.h(), ChoiceCmp.INSTANCE.getGoogleVendorList$app_release(), i9.a.h().f11814b.a(), i9.a.h().f11814b.h, i9.a.h().f11814b.f11785l, i9.a.h().f11814b.f11782i, i9.a.h().f11814b.f11784k);
            case 6:
                d0.i iVarJ2 = i9.a.j();
                ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                ChoiceCmpCallback callback2 = choiceCmp.getCallback();
                n nVarM3 = i9.a.m();
                if (((p) nVarM3.f7244j).f7571c.length() == 0) {
                    t tVar2 = (t) nVarM3.f;
                    if (tVar2 == null) {
                        l.i("translationsText");
                        throw null;
                    }
                    str2 = tVar2.f7585b.f7571c;
                } else {
                    str2 = ((p) nVarM3.f7244j).f7571c;
                }
                if (((p) nVarM3.f7244j).f7572d.isEmpty()) {
                    t tVar3 = (t) nVarM3.f;
                    if (tVar3 == null) {
                        l.i("translationsText");
                        throw null;
                    }
                    obj = tVar3.f7585b.f7572d;
                } else {
                    obj = ((p) nVarM3.f7244j).f7572d;
                }
                ?? r142 = obj;
                if (((p) nVarM3.f7244j).g.length() == 0) {
                    t tVar4 = (t) nVarM3.f;
                    if (tVar4 == null) {
                        l.i("translationsText");
                        throw null;
                    }
                    str3 = tVar4.f7585b.g;
                } else {
                    str3 = ((p) nVarM3.f7244j).g;
                }
                if (((p) nVarM3.f7244j).h.length() == 0) {
                    t tVar5 = (t) nVarM3.f;
                    if (tVar5 == null) {
                        l.i("translationsText");
                        throw null;
                    }
                    str4 = tVar5.f7585b.h;
                } else {
                    str4 = ((p) nVarM3.f7244j).h;
                }
                if (((p) nVarM3.f7244j).f.length() == 0) {
                    t tVar6 = (t) nVarM3.f;
                    if (tVar6 == null) {
                        l.i("translationsText");
                        throw null;
                    }
                    str5 = tVar6.f7585b.f;
                } else {
                    str5 = ((p) nVarM3.f7244j).f;
                }
                d9.b bVar = new d9.b(str2, str3, str4, str5, nVarM3.b(), r142);
                o8.i portalConfig$app_release = choiceCmp.getPortalConfig$app_release();
                b9.h hVarL = i9.a.l();
                n6.c cVar3 = i9.a.f9111k;
                if (cVar3 == null) {
                    cVar3 = new n6.c();
                }
                return new k9.d(iVarJ2, callback2, bVar, portalConfig$app_release, hVarL, cVar3);
            case 7:
                return new l.e(i9.a.k(), i9.a.h(), i9.a.h().f11815c, i9.a.m(), i9.a.h().f11814b.a(), i9.a.h().f11814b.f11783j, i9.a.h().f11814b.f11785l, i9.a.h().f11814b.f11782i, i9.a.h().f11814b.f11784k);
            case 8:
                m mVarK3 = i9.a.k();
                o8.i iVarH2 = i9.a.h();
                ChoiceCmp choiceCmp2 = ChoiceCmp.INSTANCE;
                f6.d googleVendorList$app_release2 = choiceCmp2.getGoogleVendorList$app_release();
                k8.h hVarA2 = i9.a.h().f11814b.a();
                if (i9.a.f9120u == null) {
                    y2.c cVarG = i9.a.g();
                    d0.i iVarJ3 = i9.a.j();
                    d0 d0VarI = i9.a.i();
                    ChoiceCmpCallback callback3 = choiceCmp2.getCallback();
                    if (i9.a.f9116p == null) {
                        i9.a.f9116p = new d0(12);
                    }
                    d0 d0Var = i9.a.f9116p;
                    if (d0Var == null) {
                        l.i("coreUiLabelsResolver");
                        throw null;
                    }
                    i9.a.f9120u = new z0(cVarG, iVarJ3, d0VarI, new x(callback3, d0Var), choiceCmp2.getAppPackageId(), choiceCmp2.getPCode());
                }
                z0 z0Var = i9.a.f9120u;
                if (z0Var == null) {
                    l.i("portalConfigRepository_");
                    throw null;
                }
                r rVarC2 = i9.a.c();
                boolean z9 = i9.a.h().f11814b.f11790q;
                d9.i iVarC = i9.a.m().c();
                n6.c cVar4 = i9.a.f9111k;
                if (cVar4 == null) {
                    cVar4 = new n6.c();
                }
                return new m6.f(mVarK3, iVarH2, googleVendorList$app_release2, hVarA2, z0Var, rVarC2, z9, iVarC, cVar4, i9.a.d());
            default:
                return new o6.c(i9.a.k(), i9.a.h(), i9.a.m());
        }
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(m7.c cVar, CreationExtras creationExtras) {
        int i10 = this.f1813a;
        return androidx.constraintlayout.core.widgets.analyzer.a.c(this, cVar, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        int i10 = this.f1813a;
        return androidx.constraintlayout.core.widgets.analyzer.a.b(this, cls, creationExtras);
    }
}
