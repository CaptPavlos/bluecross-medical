package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final q f8313c = new q(r.f8321a);

    @Override // g8.a
    public final int e(Object obj) {
        double[] dArr = (double[]) obj;
        dArr.getClass();
        return dArr.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        p pVar = (p) obj;
        pVar.getClass();
        double dDecodeDoubleElement = cVar.decodeDoubleElement(this.f8330b, i10);
        pVar.b(pVar.d() + 1);
        double[] dArr = pVar.f8307a;
        int i11 = pVar.f8308b;
        pVar.f8308b = i11 + 1;
        dArr[i11] = dDecodeDoubleElement;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        double[] dArr = (double[]) obj;
        dArr.getClass();
        p pVar = new p();
        pVar.f8307a = dArr;
        pVar.f8308b = dArr.length;
        pVar.b(10);
        return pVar;
    }

    @Override // g8.t0
    public final Object l() {
        return new double[0];
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        double[] dArr = (double[]) obj;
        dVar.getClass();
        dArr.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeDoubleElement(this.f8330b, i11, dArr[i11]);
        }
    }
}
