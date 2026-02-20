package c5;

import c1.w4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1730a;

    /* renamed from: b, reason: collision with root package name */
    public int f1731b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f1732c;

    /* renamed from: d, reason: collision with root package name */
    public w4 f1733d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(t tVar, w4 w4Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1730a = i10;
        this.f1732c = tVar;
        this.f1733d = w4Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1730a) {
            case 0:
                return new n(this.f1732c, this.f1733d, cVar, 0);
            case 1:
                return new n(this.f1732c, this.f1733d, cVar, 1);
            case 2:
                return new n(this.f1732c, this.f1733d, cVar, 2);
            case 3:
                return new n(this.f1732c, this.f1733d, cVar, 3);
            case 4:
                return new n(this.f1732c, this.f1733d, cVar, 4);
            case 5:
                return new n(this.f1732c, cVar);
            case 6:
                return new n(this.f1732c, this.f1733d, cVar, 6);
            case 7:
                return new n(this.f1732c, this.f1733d, cVar, 7);
            case 8:
                return new n(this.f1732c, this.f1733d, cVar, 8);
            default:
                return new n(this.f1732c, this.f1733d, cVar, 9);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1730a) {
        }
        return ((n) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x046f, code lost:
    
        if (r1 != r5) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0457 A[PHI: r1 r13
      0x0457: PHI (r1v40 c1.w4) = (r1v39 c1.w4), (r1v49 c1.w4) binds: [B:145:0x0454, B:122:0x03c0] A[DONT_GENERATE, DONT_INLINE]
      0x0457: PHI (r13v11 ??) = (r13v10 ??), (r13v12 ??) binds: [B:145:0x0454, B:122:0x03c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01be  */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11, types: [c1.w4, w6.c] */
    /* JADX WARN: Type inference failed for: r13v12 */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.n.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(t tVar, w6.c cVar) {
        super(2, cVar);
        this.f1730a = 5;
        this.f1732c = tVar;
    }
}
