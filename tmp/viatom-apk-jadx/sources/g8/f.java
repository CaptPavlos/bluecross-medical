package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final f f8260c = new f(g.f8264a);

    @Override // g8.a
    public final int e(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        zArr.getClass();
        return zArr.length;
    }

    @Override // g8.o, g8.a
    public final void h(f8.c cVar, int i10, Object obj) {
        e eVar = (e) obj;
        eVar.getClass();
        boolean zDecodeBooleanElement = cVar.decodeBooleanElement(this.f8330b, i10);
        eVar.b(eVar.d() + 1);
        boolean[] zArr = eVar.f8253a;
        int i11 = eVar.f8254b;
        eVar.f8254b = i11 + 1;
        zArr[i11] = zDecodeBooleanElement;
    }

    @Override // g8.a
    public final Object i(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        zArr.getClass();
        e eVar = new e();
        eVar.f8253a = zArr;
        eVar.f8254b = zArr.length;
        eVar.b(10);
        return eVar;
    }

    @Override // g8.t0
    public final Object l() {
        return new boolean[0];
    }

    @Override // g8.t0
    public final void m(f8.d dVar, Object obj, int i10) {
        boolean[] zArr = (boolean[]) obj;
        dVar.getClass();
        zArr.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            dVar.encodeBooleanElement(this.f8330b, i11, zArr[i11]);
        }
    }
}
