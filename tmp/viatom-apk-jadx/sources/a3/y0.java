package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y0 {
    public static final double f = Math.random();
    public static final /* synthetic */ int g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final l1.g f190a;

    /* renamed from: b, reason: collision with root package name */
    public final r2.d f191b;

    /* renamed from: c, reason: collision with root package name */
    public final d3.j f192c;

    /* renamed from: d, reason: collision with root package name */
    public final m f193d;
    public final w6.h e;

    public y0(l1.g gVar, r2.d dVar, d3.j jVar, m mVar, w6.h hVar) {
        gVar.getClass();
        dVar.getClass();
        jVar.getClass();
        mVar.getClass();
        hVar.getClass();
        this.f190a = gVar;
        this.f191b = dVar;
        this.f192c = jVar;
        this.f193d = mVar;
        this.e = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        if (r7.b(r0) == r5) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(a3.y0 r6, y6.c r7) {
        /*
            boolean r0 = r7 instanceof a3.x0
            if (r0 == 0) goto L13
            r0 = r7
            a3.x0 r0 = (a3.x0) r0
            int r1 = r0.f187d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f187d = r1
            goto L18
        L13:
            a3.x0 r0 = new a3.x0
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f185b
            int r1 = r0.f187d
            r2 = 2
            r3 = 1
            java.lang.String r4 = "FirebaseSessions"
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L3b
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2e
            a3.y0 r6 = r0.f184a
            s6.a.e(r7)
            goto L86
        L2e:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            r6 = 0
            return r6
        L35:
            a3.y0 r6 = r0.f184a
            s6.a.e(r7)
            goto L4b
        L3b:
            s6.a.e(r7)
            b3.c r7 = b3.c.f832a
            r0.f184a = r6
            r0.f187d = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r5) goto L4b
            goto L85
        L4b:
            java.util.Map r7 = (java.util.Map) r7
            java.util.Collection r7 = r7.values()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r1 = r7 instanceof java.util.Collection
            if (r1 == 0) goto L61
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L61
            goto Lc2
        L61:
            java.util.Iterator r7 = r7.iterator()
        L65:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Lc2
            java.lang.Object r1 = r7.next()
            w1.i r1 = (w1.i) r1
            w1.s r1 = r1.f13341a
            boolean r1 = r1.a()
            if (r1 == 0) goto L65
            d3.j r7 = r6.f192c
            r0.f184a = r6
            r0.f187d = r2
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r5) goto L86
        L85:
            return r5
        L86:
            d3.j r7 = r6.f192c
            d3.o r0 = r7.f6825a
            java.lang.Boolean r0 = r0.a()
            if (r0 == 0) goto L95
            boolean r3 = r0.booleanValue()
            goto La1
        L95:
            d3.o r7 = r7.f6826b
            java.lang.Boolean r7 = r7.a()
            if (r7 == 0) goto La1
            boolean r3 = r7.booleanValue()
        La1:
            if (r3 != 0) goto Lab
            java.lang.String r6 = "Sessions SDK disabled through settings API. Events will not be sent."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        Lab:
            d3.j r6 = r6.f192c
            double r6 = r6.a()
            double r0 = a3.y0.f
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto Lba
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            return r6
        Lba:
            java.lang.String r6 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        Lc2:
            java.lang.String r6 = "Sessions SDK disabled through data collection. Events will not be sent."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.y0.a(a3.y0, y6.c):java.lang.Object");
    }
}
