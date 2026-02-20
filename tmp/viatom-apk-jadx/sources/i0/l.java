package i0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements d, b, c {

    /* renamed from: b, reason: collision with root package name */
    public static l f8926b;

    /* renamed from: c, reason: collision with root package name */
    public static final m f8927c = new m(0, 0, 0, false, false);

    /* renamed from: a, reason: collision with root package name */
    public Object f8928a;

    public /* synthetic */ l(Object obj) {
        this.f8928a = obj;
    }

    public static synchronized l e() {
        try {
            if (f8926b == null) {
                f8926b = new l();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8926b;
    }

    @Override // i0.c
    public void a(f0.b bVar) {
        ((g0.f) this.f8928a).a(bVar);
    }

    @Override // i0.d
    public void b(f0.b bVar) {
        boolean z9 = bVar.f7991b == 0;
        e eVar = (e) this.f8928a;
        if (z9) {
            eVar.d(null, eVar.s());
            return;
        }
        c cVar = eVar.f8876p;
        if (cVar != null) {
            cVar.a(bVar);
        }
    }

    @Override // i0.b
    public void c(int i10) {
        ((g0.e) this.f8928a).c(i10);
    }

    @Override // i0.b
    public void d() {
        ((g0.e) this.f8928a).d();
    }
}
