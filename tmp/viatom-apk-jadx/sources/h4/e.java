package h4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends f4.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8453a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8454b;

    /* renamed from: c, reason: collision with root package name */
    public e4.c f8455c;

    /* renamed from: d, reason: collision with root package name */
    public String f8456d;
    public float e;

    @Override // f4.a
    public final void a(e4.e eVar, float f) {
        eVar.getClass();
        this.e = f;
    }

    @Override // f4.a
    public final void b(e4.e eVar, e4.c cVar) {
        eVar.getClass();
        if (cVar == e4.c.f7653c) {
            this.f8455c = cVar;
        }
    }

    @Override // f4.a
    public final void d(e4.e eVar, e4.d dVar) {
        eVar.getClass();
        int iOrdinal = dVar.ordinal();
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                this.f8454b = true;
                return;
            } else if (iOrdinal != 4) {
                return;
            }
        }
        this.f8454b = false;
    }

    @Override // f4.a
    public final void f(e4.e eVar, String str) {
        eVar.getClass();
        this.f8456d = str;
    }
}
