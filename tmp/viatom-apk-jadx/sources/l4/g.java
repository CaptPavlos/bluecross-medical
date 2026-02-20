package l4;

import android.content.Context;
import com.uptodown.activities.AppInstalledDetailsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10412a;

    /* renamed from: b, reason: collision with root package name */
    public int f10413b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppInstalledDetailsActivity f10414c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(AppInstalledDetailsActivity appInstalledDetailsActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10412a = i10;
        this.f10414c = appInstalledDetailsActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10412a) {
            case 0:
                return new g(this.f10414c, cVar, 0);
            case 1:
                return new g(this.f10414c, cVar, 1);
            case 2:
                return new g(this.f10414c, cVar, 2);
            default:
                return new g(this.f10414c, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10412a) {
        }
        return ((g) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        h5.q qVarA;
        int i10 = this.f10412a;
        int i11 = 0;
        AppInstalledDetailsActivity appInstalledDetailsActivity = this.f10414c;
        x6.a aVar = x6.a.f13718a;
        s6.w wVar = s6.w.f12711a;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i12 = this.f10413b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    t3.h hVar = v5.g.f13148u;
                    AppInstalledDetailsActivity appInstalledDetailsActivity2 = this.f10414c;
                    Context applicationContext = appInstalledDetailsActivity2.getApplicationContext();
                    applicationContext.getClass();
                    v5.g gVarL = hVar.l(applicationContext);
                    gVarL.a();
                    h5.f fVar = appInstalledDetailsActivity2.V;
                    fVar.getClass();
                    String str = fVar.f8526c;
                    str.getClass();
                    h5.y0 y0VarM = gVarL.M(str);
                    w6.c cVar2 = null;
                    if (y0VarM != null) {
                        Context applicationContext2 = appInstalledDetailsActivity2.getApplicationContext();
                        applicationContext2.getClass();
                        qVarA = y0VarM.a(applicationContext2);
                    } else {
                        qVarA = null;
                    }
                    gVarL.b();
                    if (y0VarM != null && !y0VarM.b()) {
                        y7.e eVar = r7.i0.f12407a;
                        s7.c cVar3 = w7.n.f13548a;
                        c5.m mVar = new c5.m(appInstalledDetailsActivity2, y0VarM, qVarA, cVar2, 4);
                        this.f10413b = 1;
                        if (r7.y.z(mVar, cVar3, this) == aVar) {
                        }
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 1:
                int i13 = this.f10413b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    this.f10413b = 1;
                    if (AppInstalledDetailsActivity.B0(appInstalledDetailsActivity, this) == aVar) {
                    }
                } else if (i13 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            case 2:
                int i14 = this.f10413b;
                if (i14 == 0) {
                    s6.a.e(obj);
                    this.f10413b = 1;
                    int i15 = AppInstalledDetailsActivity.Y;
                    y7.e eVar2 = r7.i0.f12407a;
                    Object objZ = r7.y.z(new g(appInstalledDetailsActivity, cVar, i11), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                    }
                } else if (i14 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            default:
                int i16 = this.f10413b;
                if (i16 == 0) {
                    s6.a.e(obj);
                    this.f10413b = 1;
                    int i17 = AppInstalledDetailsActivity.Y;
                    y7.e eVar3 = r7.i0.f12407a;
                    Object objZ2 = r7.y.z(new g(appInstalledDetailsActivity, cVar, i11), y7.d.f14116a, this);
                    if (objZ2 != aVar) {
                        objZ2 = wVar;
                    }
                    if (objZ2 == aVar) {
                    }
                } else if (i16 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
        }
        return wVar;
    }
}
