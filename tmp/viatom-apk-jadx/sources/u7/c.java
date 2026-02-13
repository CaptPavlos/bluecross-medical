package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends d {
    public final y6.i f;

    /* JADX WARN: Multi-variable type inference failed */
    public c(g7.p pVar, w6.h hVar, int i10, t7.a aVar) {
        super(pVar, hVar, i10, aVar);
        this.f = (y6.i) pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // u7.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(t7.s r5, w6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof u7.b
            if (r0 == 0) goto L13
            r0 = r6
            u7.b r0 = (u7.b) r0
            int r1 = r0.f12981d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12981d = r1
            goto L1a
        L13:
            u7.b r0 = new u7.b
            y6.c r6 = (y6.c) r6
            r0.<init>(r4, r6)
        L1a:
            java.lang.Object r6 = r0.f12979b
            int r1 = r0.f12981d
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            t7.s r5 = r0.f12978a
            s6.a.e(r6)
            goto L40
        L29:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
        L2e:
            r5 = 0
            return r5
        L30:
            s6.a.e(r6)
            r0.f12978a = r5
            r0.f12981d = r2
            java.lang.Object r6 = super.c(r5, r0)
            x6.a r0 = x6.a.f13718a
            if (r6 != r0) goto L40
            return r0
        L40:
            t7.r r5 = (t7.r) r5
            t7.e r5 = r5.f12859d
            boolean r5 = r5.x()
            if (r5 == 0) goto L4d
            s6.w r5 = s6.w.f12711a
            return r5
        L4d:
            java.lang.String r5 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            androidx.window.layout.c.g(r5)
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.c.c(t7.s, w6.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [g7.p, y6.i] */
    @Override // u7.d
    public final d d(w6.h hVar, int i10, t7.a aVar) {
        return new c(this.f, hVar, i10, aVar);
    }
}
