package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final j1 f8283c = new j1(k1.f8285a);

    @Override // g8.a
    public final int e(Object obj) {
        return ((s6.s) obj).f12707a.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        i1 i1Var = (i1) obj;
        i1Var.getClass();
        long jDecodeLong = cVar.decodeInlineElement(this.f8330b, i10).decodeLong();
        i1Var.b(i1Var.d() + 1);
        long[] jArr = i1Var.f8277a;
        int i11 = i1Var.f8278b;
        i1Var.f8278b = i11 + 1;
        jArr[i11] = jDecodeLong;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        long[] jArr = ((s6.s) obj).f12707a;
        i1 i1Var = new i1();
        i1Var.f8277a = jArr;
        i1Var.f8278b = jArr.length;
        i1Var.b(10);
        return i1Var;
    }

    @Override // g8.t0
    public final Object l() {
        return new s6.s(new long[0]);
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        long[] jArr = ((s6.s) obj).f12707a;
        dVar.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeInlineElement(this.f8330b, i11).encodeLong(jArr[i11]);
        }
    }
}
