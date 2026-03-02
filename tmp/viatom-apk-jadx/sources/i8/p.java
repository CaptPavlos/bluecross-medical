package i8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends a {
    public final h8.d f;
    public final int g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(h8.b bVar, h8.d dVar) {
        super(bVar, null);
        bVar.getClass();
        this.f = dVar;
        this.g = dVar.f8829a.size();
        this.h = -1;
    }

    @Override // i8.a
    public final h8.k b(String str) throws NumberFormatException {
        str.getClass();
        return (h8.k) this.f.f8829a.get(Integer.parseInt(str));
    }

    @Override // f8.c
    public final int decodeElementIndex(e8.e eVar) {
        eVar.getClass();
        int i10 = this.h;
        if (i10 >= this.g - 1) {
            return -1;
        }
        int i11 = i10 + 1;
        this.h = i11;
        return i11;
    }

    @Override // i8.a
    public final String n(e8.e eVar, int i10) {
        eVar.getClass();
        return String.valueOf(i10);
    }

    @Override // i8.a
    public final h8.k p() {
        return this.f;
    }
}
