package c1;

import androidx.collection.LruCache;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k1 extends LruCache {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n1 f1300a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(n1 n1Var) {
        super(20);
        this.f1300a = n1Var;
    }

    @Override // androidx.collection.LruCache
    public final Object create(Object obj) throws Throwable {
        String str = (String) obj;
        i0.y.d(str);
        n1 n1Var = this.f1300a;
        n1Var.h();
        i0.y.d(str);
        n nVar = n1Var.f1335b.f1520c;
        v4.U(nVar);
        a3.x xVarM0 = nVar.m0(str);
        if (xVarM0 == null) {
            return null;
        }
        w0 w0Var = n1Var.f1149a.f;
        u1.m(w0Var);
        w0Var.f1545n.c(str, "Populate EES config from database on cache miss. appId");
        n1Var.o(str, n1Var.p(str, (byte[]) xVarM0.f181b));
        return (com.google.android.gms.internal.measurement.e0) n1Var.f1358j.snapshot().get(str);
    }
}
