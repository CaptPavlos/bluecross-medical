package c5;

import c1.w4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1677a;

    /* renamed from: b, reason: collision with root package name */
    public int f1678b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w2.r f1679c;

    /* renamed from: d, reason: collision with root package name */
    public w4 f1680d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(w4 w4Var, w2.r rVar, w6.c cVar) {
        super(2, cVar);
        this.f1677a = 6;
        this.f1680d = w4Var;
        this.f1679c = rVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1677a) {
            case 0:
                return new f(this.f1679c, this.f1680d, cVar, 0);
            case 1:
                return new f(this.f1679c, this.f1680d, cVar, 1);
            case 2:
                return new f(this.f1679c, this.f1680d, cVar, 2);
            case 3:
                return new f(this.f1679c, this.f1680d, cVar, 3);
            case 4:
                return new f(this.f1679c, this.f1680d, cVar, 4);
            case 5:
                return new f(this.f1679c, cVar);
            case 6:
                return new f(this.f1680d, this.f1679c, cVar);
            case 7:
                return new f(this.f1679c, this.f1680d, cVar, 7);
            default:
                return new f(this.f1679c, this.f1680d, cVar, 8);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1677a) {
        }
        return ((f) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0332, code lost:
    
        if (r1 == r13) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f5  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.f.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(w2.r rVar, w4 w4Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1677a = i10;
        this.f1679c = rVar;
        this.f1680d = w4Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(w2.r rVar, w6.c cVar) {
        super(2, cVar);
        this.f1677a = 5;
        this.f1679c = rVar;
    }
}
