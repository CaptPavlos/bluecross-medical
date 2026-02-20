package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final m f8293c = new m(n.f8297a);

    @Override // g8.a
    public final int e(Object obj) {
        char[] cArr = (char[]) obj;
        cArr.getClass();
        return cArr.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        l lVar = (l) obj;
        lVar.getClass();
        char cDecodeCharElement = cVar.decodeCharElement(this.f8330b, i10);
        lVar.b(lVar.d() + 1);
        char[] cArr = lVar.f8287a;
        int i11 = lVar.f8288b;
        lVar.f8288b = i11 + 1;
        cArr[i11] = cDecodeCharElement;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        char[] cArr = (char[]) obj;
        cArr.getClass();
        l lVar = new l();
        lVar.f8287a = cArr;
        lVar.f8288b = cArr.length;
        lVar.b(10);
        return lVar;
    }

    @Override // g8.t0
    public final Object l() {
        return new char[0];
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        char[] cArr = (char[]) obj;
        dVar.getClass();
        cArr.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeCharElement(this.f8330b, i11, cArr[i11]);
        }
    }
}
