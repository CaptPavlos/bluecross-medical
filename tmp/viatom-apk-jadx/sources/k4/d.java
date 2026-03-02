package k4;

import a6.n;
import c5.g;
import com.uptodown.UptodownApp;
import g7.p;
import java.util.ArrayList;
import r7.i0;
import r7.w;
import r7.y;
import y6.i;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10053a;

    /* renamed from: b, reason: collision with root package name */
    public int f10054b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UptodownApp f10055c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(UptodownApp uptodownApp, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10053a = i10;
        this.f10055c = uptodownApp;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10053a) {
            case 0:
                return new d(this.f10055c, cVar, 0);
            default:
                return new d(this.f10055c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10053a) {
        }
        return ((d) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f10053a;
        x6.a aVar = x6.a.f13718a;
        UptodownApp uptodownApp = this.f10055c;
        s6.w wVar = s6.w.f12711a;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i11 = this.f10054b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    this.f10054b = 1;
                    float f = UptodownApp.E;
                    e eVar = i0.f12407a;
                    Object objZ = y.z(new n(uptodownApp, cVar, 16), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            default:
                int i12 = this.f10054b;
                try {
                    if (i12 == 0) {
                        s6.a.e(obj);
                        ArrayList arrayListI = v5.a.i(uptodownApp);
                        v5.a aVar2 = new v5.a();
                        this.f10054b = 1;
                        e eVar2 = i0.f12407a;
                        Object objZ2 = y.z(new g(uptodownApp, arrayListI, aVar2, (w6.c) null), y7.d.f14116a, this);
                        if (objZ2 != aVar) {
                            objZ2 = wVar;
                        }
                        if (objZ2 == aVar) {
                        }
                    } else if (i12 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        break;
                    } else {
                        s6.a.e(obj);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    new t1.c(uptodownApp, 4).f("preloadAppsInstalled", e);
                }
                break;
        }
        return wVar;
    }
}
