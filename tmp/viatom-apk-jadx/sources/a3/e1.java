package a3;

import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e1 extends y6.i implements g7.q {

    /* renamed from: a, reason: collision with root package name */
    public int f57a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ u7.i f58b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Throwable f59c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k1 f60d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(k1 k1Var, w6.c cVar) {
        super(3, cVar);
        this.f60d = k1Var;
    }

    @Override // g7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        e1 e1Var = new e1(this.f60d, (w6.c) obj3);
        e1Var.f58b = (u7.i) obj;
        e1Var.f59c = (Throwable) obj2;
        return e1Var.invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f57a;
        if (i10 == 0) {
            s6.a.e(obj);
            u7.i iVar = this.f58b;
            Throwable th = this.f59c;
            t0 t0VarA = this.f60d.f123b.a(null);
            o0 o0Var = new o0(t0VarA, null, null);
            Log.d("FirebaseSessions", "Init session datastore failed with exception message: " + th.getMessage() + ". Emit fallback session " + t0VarA.f161a);
            this.f58b = null;
            this.f57a = 1;
            Object objEmit = iVar.emit(o0Var, this);
            x6.a aVar = x6.a.f13718a;
            if (objEmit == aVar) {
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
    }
}
