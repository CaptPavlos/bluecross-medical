package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final i f8274c = new i(j.f8279a);

    @Override // g8.a
    public final int e(Object obj) {
        byte[] bArr = (byte[]) obj;
        bArr.getClass();
        return bArr.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        h hVar = (h) obj;
        hVar.getClass();
        byte bDecodeByteElement = cVar.decodeByteElement(this.f8330b, i10);
        hVar.b(hVar.d() + 1);
        byte[] bArr = hVar.f8269a;
        int i11 = hVar.f8270b;
        hVar.f8270b = i11 + 1;
        bArr[i11] = bDecodeByteElement;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        byte[] bArr = (byte[]) obj;
        bArr.getClass();
        h hVar = new h();
        hVar.f8269a = bArr;
        hVar.f8270b = bArr.length;
        hVar.b(10);
        return hVar;
    }

    @Override // g8.t0
    public final Object l() {
        return new byte[0];
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        byte[] bArr = (byte[]) obj;
        dVar.getClass();
        bArr.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeByteElement(this.f8330b, i11, bArr[i11]);
        }
    }
}
