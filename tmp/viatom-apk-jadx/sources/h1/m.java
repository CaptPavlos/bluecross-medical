package h1;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements n, f, e, c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8429a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f8430b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f8431c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f8432d;

    public m(Executor executor, c cVar) {
        this.f8429a = 0;
        this.f8431c = new Object();
        this.f8430b = executor;
        this.f8432d = cVar;
    }

    private final void b(p pVar) {
        synchronized (this.f8431c) {
        }
        this.f8430b.execute(new k1.a(this, pVar, 21, false));
    }

    private final void c(p pVar) {
        if (pVar.i() || pVar.f8438d) {
            return;
        }
        synchronized (this.f8431c) {
        }
        this.f8430b.execute(new k1.a(this, pVar, 22, false));
    }

    private final void d(p pVar) {
        if (pVar.i()) {
            synchronized (this.f8431c) {
            }
            this.f8430b.execute(new k1.a(this, pVar, 23, false));
        }
    }

    @Override // h1.n
    public final void a(p pVar) {
        switch (this.f8429a) {
            case 0:
                if (pVar.f8438d) {
                    synchronized (this.f8431c) {
                    }
                    this.f8430b.execute(new a4.a(this, 14));
                    return;
                }
                return;
            case 1:
                b(pVar);
                return;
            case 2:
                c(pVar);
                return;
            case 3:
                d(pVar);
                return;
            default:
                this.f8430b.execute(new k1.a(this, pVar, 24, false));
                return;
        }
    }

    @Override // h1.f
    public void h(Object obj) {
        ((p) this.f8432d).l(obj);
    }

    @Override // h1.c
    public void n() {
        ((p) this.f8432d).m();
    }

    @Override // h1.e
    public void u(Exception exc) {
        ((p) this.f8432d).k(exc);
    }

    public m(Executor executor, d dVar) {
        this.f8429a = 1;
        this.f8431c = new Object();
        this.f8430b = executor;
        this.f8432d = dVar;
    }

    public m(Executor executor, e eVar) {
        this.f8429a = 2;
        this.f8431c = new Object();
        this.f8430b = executor;
        this.f8432d = eVar;
    }

    public m(Executor executor, f fVar) {
        this.f8429a = 3;
        this.f8431c = new Object();
        this.f8430b = executor;
        this.f8432d = fVar;
    }

    public m(Executor executor, h hVar, p pVar) {
        this.f8429a = 4;
        this.f8430b = executor;
        this.f8431c = hVar;
        this.f8432d = pVar;
    }
}
