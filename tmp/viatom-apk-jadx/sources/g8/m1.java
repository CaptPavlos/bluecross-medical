package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m1 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final m1 f8296c = new m1(n1.f8300a);

    @Override // g8.a
    public final int e(Object obj) {
        return ((s6.v) obj).f12710a.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        l1 l1Var = (l1) obj;
        l1Var.getClass();
        short sDecodeShort = cVar.decodeInlineElement(this.f8330b, i10).decodeShort();
        l1Var.b(l1Var.d() + 1);
        short[] sArr = l1Var.f8291a;
        int i11 = l1Var.f8292b;
        l1Var.f8292b = i11 + 1;
        sArr[i11] = sDecodeShort;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        short[] sArr = ((s6.v) obj).f12710a;
        l1 l1Var = new l1();
        l1Var.f8291a = sArr;
        l1Var.f8292b = sArr.length;
        l1Var.b(10);
        return l1Var;
    }

    @Override // g8.t0
    public final Object l() {
        return new s6.v(new short[0]);
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        short[] sArr = ((s6.v) obj).f12710a;
        dVar.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeInlineElement(this.f8330b, i11).encodeShort(sArr[i11]);
        }
    }
}
