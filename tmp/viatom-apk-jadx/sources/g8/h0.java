package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final h0 f8271c = new h0(i0.f8275a);

    @Override // g8.a
    public final int e(Object obj) {
        long[] jArr = (long[]) obj;
        jArr.getClass();
        return jArr.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        g0 g0Var = (g0) obj;
        g0Var.getClass();
        long jDecodeLongElement = cVar.decodeLongElement(this.f8330b, i10);
        g0Var.b(g0Var.d() + 1);
        long[] jArr = g0Var.f8266a;
        int i11 = g0Var.f8267b;
        g0Var.f8267b = i11 + 1;
        jArr[i11] = jDecodeLongElement;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        long[] jArr = (long[]) obj;
        jArr.getClass();
        g0 g0Var = new g0();
        g0Var.f8266a = jArr;
        g0Var.f8267b = jArr.length;
        g0Var.b(10);
        return g0Var;
    }

    @Override // g8.t0
    public final Object l() {
        return new long[0];
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        long[] jArr = (long[]) obj;
        dVar.getClass();
        jArr.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeLongElement(this.f8330b, i11, jArr[i11]);
        }
    }
}
