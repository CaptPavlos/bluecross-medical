package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g1 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final g1 f8268c = new g1(h1.f8272a);

    @Override // g8.a
    public final int e(Object obj) {
        return ((s6.q) obj).f12705a.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        f1 f1Var = (f1) obj;
        f1Var.getClass();
        int iDecodeInt = cVar.decodeInlineElement(this.f8330b, i10).decodeInt();
        f1Var.b(f1Var.d() + 1);
        int[] iArr = f1Var.f8262a;
        int i11 = f1Var.f8263b;
        f1Var.f8263b = i11 + 1;
        iArr[i11] = iDecodeInt;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        int[] iArr = ((s6.q) obj).f12705a;
        f1 f1Var = new f1();
        f1Var.f8262a = iArr;
        f1Var.f8263b = iArr.length;
        f1Var.b(10);
        return f1Var;
    }

    @Override // g8.t0
    public final Object l() {
        return new s6.q(new int[0]);
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        int[] iArr = ((s6.q) obj).f12705a;
        dVar.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeInlineElement(this.f8330b, i11).encodeInt(iArr[i11]);
        }
    }
}
