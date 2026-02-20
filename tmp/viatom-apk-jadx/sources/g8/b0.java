package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final b0 f8240c = new b0(c0.f8244a);

    @Override // g8.a
    public final int e(Object obj) {
        int[] iArr = (int[]) obj;
        iArr.getClass();
        return iArr.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        a0 a0Var = (a0) obj;
        a0Var.getClass();
        int iDecodeIntElement = cVar.decodeIntElement(this.f8330b, i10);
        a0Var.b(a0Var.d() + 1);
        int[] iArr = a0Var.f8236a;
        int i11 = a0Var.f8237b;
        a0Var.f8237b = i11 + 1;
        iArr[i11] = iDecodeIntElement;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        int[] iArr = (int[]) obj;
        iArr.getClass();
        a0 a0Var = new a0();
        a0Var.f8236a = iArr;
        a0Var.f8237b = iArr.length;
        a0Var.b(10);
        return a0Var;
    }

    @Override // g8.t0
    public final Object l() {
        return new int[0];
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        int[] iArr = (int[]) obj;
        dVar.getClass();
        iArr.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeIntElement(this.f8330b, i11, iArr[i11]);
        }
    }
}
