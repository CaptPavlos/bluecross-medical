package c1;

import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d4 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f1111a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1112b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a4.f f1113c;

    public d4(a4.f fVar, long j10, long j11) {
        Objects.requireNonNull(fVar);
        this.f1113c = fVar;
        this.f1111a = j10;
        this.f1112b = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r1 r1Var = ((g4) this.f1113c.f219c).f1149a.g;
        u1.m(r1Var);
        r1Var.p(new a4.a(this, 4));
    }
}
