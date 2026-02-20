package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 implements h {

    /* renamed from: a, reason: collision with root package name */
    public final y6.i f12990a;

    /* JADX WARN: Multi-variable type inference failed */
    public e0(g7.p pVar) {
        this.f12990a = (y6.i) pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v3, types: [g7.p, y6.i] */
    @Override // u7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(u7.i r6, w6.c r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof u7.a
            if (r0 == 0) goto L13
            r0 = r7
            u7.a r0 = (u7.a) r0
            int r1 = r0.f12973d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12973d = r1
            goto L18
        L13:
            u7.a r0 = new u7.a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f12971b
            int r1 = r0.f12973d
            s6.w r2 = s6.w.f12711a
            r3 = 1
            if (r1 == 0) goto L32
            if (r1 != r3) goto L2b
            v7.l r6 = r0.f12970a
            s6.a.e(r7)     // Catch: java.lang.Throwable -> L29
            goto L52
        L29:
            r7 = move-exception
            goto L5c
        L2b:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            r6 = 0
            return r6
        L32:
            s6.a.e(r7)
            v7.l r7 = new v7.l
            w6.h r1 = r0.getContext()
            r7.<init>(r6, r1)
            r0.f12970a = r7     // Catch: java.lang.Throwable -> L5a
            r0.f12973d = r3     // Catch: java.lang.Throwable -> L5a
            y6.i r6 = r5.f12990a     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r6 = r6.invoke(r7, r0)     // Catch: java.lang.Throwable -> L5a
            x6.a r0 = x6.a.f13718a
            if (r6 != r0) goto L4d
            goto L4e
        L4d:
            r6 = r2
        L4e:
            if (r6 != r0) goto L51
            return r0
        L51:
            r6 = r7
        L52:
            r6.releaseIntercepted()
            return r2
        L56:
            r4 = r7
            r7 = r6
            r6 = r4
            goto L5c
        L5a:
            r6 = move-exception
            goto L56
        L5c:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.e0.collect(u7.i, w6.c):java.lang.Object");
    }
}
