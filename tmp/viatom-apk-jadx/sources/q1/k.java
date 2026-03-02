package q1;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements n2.c, n2.b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f12238a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f12239b;

    /* renamed from: c, reason: collision with root package name */
    public final r1.k f12240c;

    public k() {
        r1.k kVar = r1.k.f12340a;
        this.f12238a = new HashMap();
        this.f12239b = new ArrayDeque();
        this.f12240c = kVar;
    }

    public final synchronized void a(Executor executor, n2.a aVar) {
        try {
            executor.getClass();
            if (!this.f12238a.containsKey(l1.b.class)) {
                this.f12238a.put(l1.b.class, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f12238a.get(l1.b.class)).put(aVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }
}
