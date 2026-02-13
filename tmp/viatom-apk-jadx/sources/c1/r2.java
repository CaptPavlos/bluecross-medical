package c1;

import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1429a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1430b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1431c;

    public r2(c3 c3Var, boolean z9) {
        this.f1430b = z9;
        Objects.requireNonNull(c3Var);
        this.f1431c = c3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r9 = this;
            int r0 = r9.f1429a
            switch(r0) {
                case 0: goto L38;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r9.f1431c
            t1.c r0 = (t1.c) r0
            boolean r1 = r9.f1430b
            if (r1 == 0) goto L10
            java.lang.String r2 = "OK"
            goto L12
        L10:
            java.lang.String r2 = "KO"
        L12:
            boolean r2 = t1.c.b(r0, r2)
            if (r2 == 0) goto L37
            java.lang.Object r0 = r0.f12752c
            v4.a r0 = (v4.a) r0
            if (r1 == 0) goto L32
            c2.d r0 = r0.f13126b
            r0.getClass()
            java.lang.Thread r1 = new java.lang.Thread
            v4.b r2 = new v4.b
            r3 = 1
            r2.<init>(r0, r3)
            r1.<init>(r2)
            r1.start()
            goto L37
        L32:
            c2.d r0 = r0.f13126b
            r0.o()
        L37:
            return
        L38:
            java.lang.Object r0 = r9.f1431c
            c1.c3 r0 = (c1.c3) r0
            c1.u1 r1 = r0.f1149a
            boolean r2 = r1.d()
            java.lang.Boolean r3 = r1.y
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L52
            java.lang.Boolean r3 = r1.y
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L52
            r3 = r5
            goto L53
        L52:
            r3 = r4
        L53:
            boolean r6 = r9.f1430b
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            r1.y = r7
            if (r3 != r6) goto L6d
            c1.w0 r3 = r1.f
            c1.u1.m(r3)
            c1.u0 r3 = r3.f1545n
            java.lang.String r7 = "Default data collection state already set to"
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r6)
            r3.c(r8, r7)
        L6d:
            boolean r3 = r1.d()
            if (r3 == r2) goto L86
            boolean r3 = r1.d()
            java.lang.Boolean r7 = r1.y
            if (r7 == 0) goto L84
            java.lang.Boolean r7 = r1.y
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L84
            r4 = r5
        L84:
            if (r3 == r4) goto L9a
        L86:
            c1.w0 r1 = r1.f
            c1.u1.m(r1)
            c1.u0 r1 = r1.f1542k
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "Default data collection is different than actual status"
            r1.d(r3, r4, r2)
        L9a:
            r0.y()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.r2.run():void");
    }

    public r2(t1.c cVar, boolean z9) {
        this.f1431c = cVar;
        this.f1430b = z9;
    }
}
