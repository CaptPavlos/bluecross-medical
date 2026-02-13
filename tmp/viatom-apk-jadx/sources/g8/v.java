package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final v f8335c = new v(w.f8337a);

    @Override // g8.a
    public final int e(Object obj) {
        float[] fArr = (float[]) obj;
        fArr.getClass();
        return fArr.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        u uVar = (u) obj;
        uVar.getClass();
        float fDecodeFloatElement = cVar.decodeFloatElement(this.f8330b, i10);
        uVar.b(uVar.d() + 1);
        float[] fArr = uVar.f8331a;
        int i11 = uVar.f8332b;
        uVar.f8332b = i11 + 1;
        fArr[i11] = fDecodeFloatElement;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        float[] fArr = (float[]) obj;
        fArr.getClass();
        u uVar = new u();
        uVar.f8331a = fArr;
        uVar.f8332b = fArr.length;
        uVar.b(10);
        return uVar;
    }

    @Override // g8.t0
    public final Object l() {
        return new float[0];
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        float[] fArr = (float[]) obj;
        dVar.getClass();
        fArr.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeFloatElement(this.f8330b, i11, fArr[i11]);
        }
    }
}
