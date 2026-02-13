package i8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends a {
    public final h8.k f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(h8.b bVar, h8.k kVar, String str) {
        super(bVar, str);
        bVar.getClass();
        kVar.getClass();
        this.f = kVar;
        this.f9059a.add("primitive");
    }

    @Override // i8.a
    public final h8.k b(String str) {
        str.getClass();
        if (str == "primitive") {
            return this.f;
        }
        com.google.gson.internal.a.n("This input can only handle primitives with 'primitive' tag");
        return null;
    }

    @Override // f8.c
    public final int decodeElementIndex(e8.e eVar) {
        eVar.getClass();
        return 0;
    }

    @Override // i8.a
    public final h8.k p() {
        return this.f;
    }
}
