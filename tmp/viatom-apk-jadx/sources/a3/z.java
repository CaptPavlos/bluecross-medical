package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z implements c3.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f194a;

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        if (r10 == r6) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(r2.d r9, y6.c r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof a3.b0
            if (r0 == 0) goto L13
            r0 = r10
            a3.b0 r0 = (a3.b0) r0
            int r1 = r0.f31d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f31d = r1
            goto L18
        L13:
            a3.b0 r0 = new a3.b0
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f29b
            int r1 = r0.f31d
            java.lang.String r2 = "FirebaseSessions"
            r3 = 2
            r4 = 1
            java.lang.String r5 = ""
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L46
            if (r1 == r4) goto L3c
            if (r1 != r3) goto L35
            java.lang.Object r9 = r0.f28a
            java.lang.String r9 = (java.lang.String) r9
            s6.a.e(r10)     // Catch: java.lang.Exception -> L32
            goto L88
        L32:
            r10 = move-exception
            goto L8f
        L35:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r9)
            r9 = 0
            return r9
        L3c:
            java.lang.Object r9 = r0.f28a
            r2.d r9 = (r2.d) r9
            s6.a.e(r10)     // Catch: java.lang.Exception -> L44
            goto L61
        L44:
            r10 = move-exception
            goto L6d
        L46:
            s6.a.e(r10)
            r10 = r9
            r2.c r10 = (r2.c) r10     // Catch: java.lang.Exception -> L44
            h1.p r9 = r10.e()     // Catch: java.lang.Exception -> L44
            r9.getClass()     // Catch: java.lang.Exception -> L69
            r0.f28a = r10     // Catch: java.lang.Exception -> L69
            r0.f31d = r4     // Catch: java.lang.Exception -> L69
            java.lang.Object r9 = z1.t1.g(r9, r0)     // Catch: java.lang.Exception -> L69
            if (r9 != r6) goto L5e
            goto L87
        L5e:
            r7 = r10
            r10 = r9
            r9 = r7
        L61:
            r2.a r10 = (r2.a) r10     // Catch: java.lang.Exception -> L44
            java.lang.String r10 = r10.f12343a     // Catch: java.lang.Exception -> L44
            r7 = r10
            r10 = r9
            r9 = r7
            goto L74
        L69:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L6d:
            java.lang.String r1 = "Error getting authentication token."
            android.util.Log.w(r2, r1, r10)
            r10 = r9
            r9 = r5
        L74:
            r2.c r10 = (r2.c) r10     // Catch: java.lang.Exception -> L32
            h1.p r10 = r10.d()     // Catch: java.lang.Exception -> L32
            r10.getClass()     // Catch: java.lang.Exception -> L32
            r0.f28a = r9     // Catch: java.lang.Exception -> L32
            r0.f31d = r3     // Catch: java.lang.Exception -> L32
            java.lang.Object r10 = z1.t1.g(r10, r0)     // Catch: java.lang.Exception -> L32
            if (r10 != r6) goto L88
        L87:
            return r6
        L88:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L32
            if (r10 != 0) goto L8d
            goto L94
        L8d:
            r5 = r10
            goto L94
        L8f:
            java.lang.String r0 = "Error getting Firebase installation id ."
            android.util.Log.w(r2, r0, r10)
        L94:
            a3.c0 r10 = new a3.c0
            r10.<init>(r5, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.z.a(r2.d, y6.c):java.lang.Object");
    }

    @Override // p6.a
    public Object get() {
        switch (this.f194a) {
            case 0:
                return o1.f148a;
            default:
                return p1.f152a;
        }
    }
}
