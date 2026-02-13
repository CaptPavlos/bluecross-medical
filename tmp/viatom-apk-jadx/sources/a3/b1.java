package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b1 implements c3.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f32a;

    /* renamed from: b, reason: collision with root package name */
    public final p6.a f33b;

    /* renamed from: c, reason: collision with root package name */
    public final c3.c f34c;

    public /* synthetic */ b1(c3.c cVar, c3.c cVar2, int i10) {
        this.f32a = i10;
        this.f33b = cVar;
        this.f34c = cVar2;
    }

    @Override // p6.a
    public final Object get() {
        switch (this.f32a) {
            case 0:
                return new a1((o1) this.f33b.get(), (p1) this.f34c.get());
            default:
                return new d3.j((d3.o) this.f33b.get(), (d3.o) this.f34c.get());
        }
    }
}
