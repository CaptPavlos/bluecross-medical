package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z0 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final z0 f8346c = new z0(a1.f8238a);

    @Override // g8.a
    public final int e(Object obj) {
        short[] sArr = (short[]) obj;
        sArr.getClass();
        return sArr.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        y0 y0Var = (y0) obj;
        y0Var.getClass();
        short sDecodeShortElement = cVar.decodeShortElement(this.f8330b, i10);
        y0Var.b(y0Var.d() + 1);
        short[] sArr = y0Var.f8343a;
        int i11 = y0Var.f8344b;
        y0Var.f8344b = i11 + 1;
        sArr[i11] = sDecodeShortElement;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        short[] sArr = (short[]) obj;
        sArr.getClass();
        y0 y0Var = new y0();
        y0Var.f8343a = sArr;
        y0Var.f8344b = sArr.length;
        y0Var.b(10);
        return y0Var;
    }

    @Override // g8.t0
    public final Object l() {
        return new short[0];
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        short[] sArr = (short[]) obj;
        dVar.getClass();
        sArr.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeShortElement(this.f8330b, i11, sArr[i11]);
        }
    }
}
