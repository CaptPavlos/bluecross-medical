package c5;

import androidx.browser.trusted.sharing.ShareTarget;
import c1.w4;
import h5.p0;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1703a;

    /* renamed from: b, reason: collision with root package name */
    public int f1704b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w4 f1705c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x4 f1706d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(w4 w4Var, x4 x4Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1703a = i10;
        this.f1705c = w4Var;
        this.f1706d = x4Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1703a) {
            case 0:
                return new j0(this.f1705c, this.f1706d, cVar, 0);
            default:
                return new j0(this.f1705c, this.f1706d, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1703a) {
        }
        return ((j0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        int i10 = this.f1703a;
        s6.w wVar = s6.w.f12711a;
        w4 w4Var = this.f1705c;
        x6.a aVar = x6.a.f13718a;
        x4 x4Var = this.f1706d;
        switch (i10) {
            case 0:
                int i11 = this.f1704b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    w4 w4Var2 = new w4(w4Var.f1555a, 4, false);
                    p0 p0VarM = w4Var2.m("https://www.uptodown.app:443".concat("/eapi/my-recommended-list/private"), ShareTarget.METHOD_POST, null);
                    p0VarM.f8699d = w4Var2.k(p0VarM, "/eapi/my-recommended-list/private");
                    if (p0VarM.b() || (str = p0VarM.f8696a) == null || str.length() == 0) {
                        y7.e eVar = r7.i0.f12407a;
                        s7.c cVar = w7.n.f13548a;
                        i0 i0Var = new i0(x4Var, null, 1);
                        this.f1704b = 2;
                        if (r7.y.z(i0Var, cVar, this) != aVar) {
                        }
                    } else {
                        y7.e eVar2 = r7.i0.f12407a;
                        s7.c cVar2 = w7.n.f13548a;
                        i0 i0Var2 = new i0(x4Var, null, 0);
                        this.f1704b = 1;
                        if (r7.y.z(i0Var2, cVar2, this) != aVar) {
                        }
                    }
                    break;
                } else if (i11 != 1 && i11 != 2) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            default:
                int i12 = this.f1704b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    w4 w4Var3 = new w4(w4Var.f1555a, 4, false);
                    p0 p0VarM2 = w4Var3.m("https://www.uptodown.app:443".concat("/eapi/my-recommended-list/public"), ShareTarget.METHOD_POST, null);
                    p0VarM2.f8699d = w4Var3.k(p0VarM2, "/eapi/my-recommended-list/public");
                    if (p0VarM2.b() || (str2 = p0VarM2.f8696a) == null || str2.length() == 0) {
                        y7.e eVar3 = r7.i0.f12407a;
                        s7.c cVar3 = w7.n.f13548a;
                        i0 i0Var3 = new i0(x4Var, null, 3);
                        this.f1704b = 2;
                        if (r7.y.z(i0Var3, cVar3, this) != aVar) {
                        }
                    } else {
                        y7.e eVar4 = r7.i0.f12407a;
                        s7.c cVar4 = w7.n.f13548a;
                        i0 i0Var4 = new i0(x4Var, null, 2);
                        this.f1704b = 1;
                        if (r7.y.z(i0Var4, cVar4, this) != aVar) {
                        }
                    }
                    break;
                } else if (i12 != 1 && i12 != 2) {
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
