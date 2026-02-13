package r2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements i {

    /* renamed from: a, reason: collision with root package name */
    public final j f12357a;

    /* renamed from: b, reason: collision with root package name */
    public final h1.i f12358b;

    public f(j jVar, h1.i iVar) {
        this.f12357a = jVar;
        this.f12358b = iVar;
    }

    @Override // r2.i
    public final boolean a(Exception exc) {
        this.f12358b.b(exc);
        return true;
    }

    @Override // r2.i
    public final boolean b(s2.b bVar) {
        if (bVar.f12523b != 4 || this.f12357a.a(bVar)) {
            return false;
        }
        String str = bVar.f12524c;
        if (str == null) {
            androidx.window.layout.c.k("Null token");
            return false;
        }
        this.f12358b.a(new a(str, bVar.e, bVar.f));
        return true;
    }
}
