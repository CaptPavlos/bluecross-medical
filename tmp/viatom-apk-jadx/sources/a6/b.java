package a6;

import androidx.work.ListenableWorker;
import com.uptodown.workers.AppInstalledWorker;
import r7.i0;
import r7.w;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f245a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppInstalledWorker f246b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AppInstalledWorker appInstalledWorker, w6.c cVar) {
        super(2, cVar);
        this.f246b = appInstalledWorker;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new b(this.f246b, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f245a;
        w6.c cVar = null;
        if (i10 == 0) {
            s6.a.e(obj);
            this.f245a = 1;
            y7.e eVar = i0.f12407a;
            Object objZ = y.z(new c(this.f246b, cVar, 0), y7.d.f14116a, this);
            Object obj2 = x6.a.f13718a;
            if (objZ != obj2) {
                objZ = s6.w.f12711a;
            }
            if (objZ == obj2) {
                return obj2;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return ListenableWorker.Result.success();
    }
}
