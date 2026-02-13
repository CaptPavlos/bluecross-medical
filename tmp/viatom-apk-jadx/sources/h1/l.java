package h1;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements n, f, e, c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8425a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f8426b;

    /* renamed from: c, reason: collision with root package name */
    public final a f8427c;

    /* renamed from: d, reason: collision with root package name */
    public final p f8428d;

    public /* synthetic */ l(Executor executor, a aVar, p pVar, int i10) {
        this.f8425a = i10;
        this.f8426b = executor;
        this.f8427c = aVar;
        this.f8428d = pVar;
    }

    @Override // h1.n
    public final void a(p pVar) {
        switch (this.f8425a) {
            case 0:
                this.f8426b.execute(new k1.a(this, pVar, 19, false));
                break;
            default:
                this.f8426b.execute(new k1.a(this, pVar, 20, false));
                break;
        }
    }

    @Override // h1.f
    public void h(Object obj) {
        this.f8428d.l(obj);
    }

    @Override // h1.c
    public void n() {
        this.f8428d.m();
    }

    @Override // h1.e
    public void u(Exception exc) {
        this.f8428d.k(exc);
    }
}
