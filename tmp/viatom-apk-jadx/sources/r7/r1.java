package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class r1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f12434a = new ThreadLocal();

    public static n0 a() {
        ThreadLocal threadLocal = f12434a;
        n0 n0Var = (n0) threadLocal.get();
        if (n0Var != null) {
            return n0Var;
        }
        d dVar = new d(Thread.currentThread());
        threadLocal.set(dVar);
        return dVar;
    }
}
