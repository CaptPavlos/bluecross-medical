package a3;

import android.util.Log;
import androidx.datastore.core.DataStore;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f73a;

    /* renamed from: b, reason: collision with root package name */
    public int f74b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k1 f75c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(k1 k1Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f73a = i10;
        this.f75c = k1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f73a) {
            case 0:
                return new g1(this.f75c, cVar, 0);
            default:
                return new g1(this.f75c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f73a) {
        }
        return ((g1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f73a) {
            case 0:
                int i10 = this.f74b;
                if (i10 == 0) {
                    s6.a.e(obj);
                    k1 k1Var = this.f75c;
                    u7.o oVar = new u7.o(k1Var.e.getData(), new e1(k1Var, null), 1);
                    f1 f1Var = new f1(k1Var, 0);
                    this.f74b = 1;
                    Object objCollect = oVar.collect(f1Var, this);
                    x6.a aVar = x6.a.f13718a;
                    if (objCollect == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return s6.w.f12711a;
            default:
                int i11 = this.f74b;
                w6.c cVar = null;
                k1 k1Var2 = this.f75c;
                try {
                    if (i11 == 0) {
                        s6.a.e(obj);
                        DataStore dataStore = k1Var2.e;
                        i1 i1Var = new i1(k1Var2, cVar, 0);
                        this.f74b = 1;
                        Object objUpdateData = dataStore.updateData(i1Var, this);
                        x6.a aVar2 = x6.a.f13718a;
                        if (objUpdateData == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i11 != 1) {
                            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        s6.a.e(obj);
                    }
                } catch (Exception e) {
                    Log.d("FirebaseSessions", "App backgrounded, failed to update data. Message: " + e.getMessage());
                    o0 o0Var = k1Var2.h;
                    if (o0Var == null) {
                        kotlin.jvm.internal.l.i("localSessionData");
                        throw null;
                    }
                    k1Var2.f125d.getClass();
                    k1Var2.h = o0.a(o0Var, null, o1.a(), null, 5);
                }
                return s6.w.f12711a;
        }
    }
}
