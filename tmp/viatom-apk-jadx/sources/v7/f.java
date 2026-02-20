package v7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t7.e f13183a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13184b;

    public f(t7.e eVar, int i10) {
        this.f13183a = eVar;
        this.f13184b = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // u7.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r7, w6.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof v7.e
            if (r0 == 0) goto L13
            r0 = r8
            v7.e r0 = (v7.e) r0
            int r1 = r0.f13182c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13182c = r1
            goto L18
        L13:
            v7.e r0 = new v7.e
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f13180a
            int r1 = r0.f13182c
            x6.a r2 = x6.a.f13718a
            s6.w r3 = s6.w.f12711a
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L37
            if (r1 == r5) goto L33
            if (r1 != r4) goto L2c
            s6.a.e(r8)
            return r3
        L2c:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            r7 = 0
            return r7
        L33:
            s6.a.e(r8)
            goto L4c
        L37:
            s6.a.e(r8)
            t6.w r8 = new t6.w
            int r1 = r6.f13184b
            r8.<init>(r1, r7)
            r0.f13182c = r5
            t7.e r7 = r6.f13183a
            java.lang.Object r7 = r7.l(r8, r0)
            if (r7 != r2) goto L4c
            goto L8e
        L4c:
            r0.f13182c = r4
            w6.h r7 = r0.getContext()
            r7.y.i(r7)
            w6.c r8 = r0.f.F(r0)
            boolean r0 = r8 instanceof w7.f
            if (r0 == 0) goto L60
            w7.f r8 = (w7.f) r8
            goto L61
        L60:
            r8 = 0
        L61:
            if (r8 != 0) goto L65
            r7 = r3
            goto L88
        L65:
            r7.s r0 = r8.f13533d
            boolean r1 = r0.isDispatchNeeded(r7)
            if (r1 == 0) goto L75
            r8.f = r3
            r8.f12400c = r5
            r0.dispatchYield(r7, r8)
            goto L87
        L75:
            r7.y1 r1 = new r7.y1
            r7.t r4 = r7.y1.f12456a
            r1.<init>(r4)
            w6.h r7 = r7.plus(r1)
            r8.f = r3
            r8.f12400c = r5
            r0.dispatchYield(r7, r8)
        L87:
            r7 = r2
        L88:
            if (r7 != r2) goto L8b
            goto L8c
        L8b:
            r7 = r3
        L8c:
            if (r7 != r2) goto L8f
        L8e:
            return r2
        L8f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: v7.f.emit(java.lang.Object, w6.c):java.lang.Object");
    }
}
