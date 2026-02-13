package c1;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class s0 implements h1.e {

    /* renamed from: a, reason: collision with root package name */
    public long f1447a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1448b;

    public s0(n0.a aVar) {
        i0.y.g(aVar);
        this.f1448b = aVar;
    }

    @Override // h1.e
    public /* synthetic */ void u(Exception exc) {
        a3.x xVar = (a3.x) this.f1448b;
        ((AtomicLong) xVar.f183d).set(this.f1447a);
    }
}
