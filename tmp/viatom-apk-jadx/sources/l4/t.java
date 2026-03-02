package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f10832a;

    /* renamed from: b, reason: collision with root package name */
    public int f10833b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f10834c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(w wVar, w6.c cVar) {
        super(2, cVar);
        this.f10834c = wVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new t(this.f10834c, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((t) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
    
        if (r7.y.h(5000, r7) == r6) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        if (r7.y.h(5000, r7) == r6) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        return r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0045 -> B:21:0x0048). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.f10833b
            r1 = 5000(0x1388, double:2.4703E-320)
            r3 = 2
            r4 = 1
            l4.w r5 = r7.f10834c
            x6.a r6 = x6.a.f13718a
            if (r0 == 0) goto L21
            if (r0 == r4) goto L1d
            if (r0 != r3) goto L16
            int r0 = r7.f10832a
            s6.a.e(r8)
            goto L48
        L16:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            r8 = 0
            return r8
        L1d:
            s6.a.e(r8)
            goto L2d
        L21:
            s6.a.e(r8)
            r7.f10833b = r4
            java.lang.Object r8 = r7.y.h(r1, r7)
            if (r8 != r6) goto L2d
            goto L47
        L2d:
            float r8 = com.uptodown.UptodownApp.E
            androidx.work.WorkInfo$State r8 = k4.c.i(r5)
            r0 = 0
        L34:
            r4 = 5
            if (r0 >= r4) goto L4f
            androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.ENQUEUED
            if (r8 != r4) goto L4f
            int r0 = r0 + 1
            r7.f10832a = r0
            r7.f10833b = r3
            java.lang.Object r8 = r7.y.h(r1, r7)
            if (r8 != r6) goto L48
        L47:
            return r6
        L48:
            float r8 = com.uptodown.UptodownApp.E
            androidx.work.WorkInfo$State r8 = k4.c.i(r5)
            goto L34
        L4f:
            float r8 = com.uptodown.UptodownApp.E
            java.lang.String r8 = "downloadApkWorker"
            boolean r8 = k4.c.o(r5, r8)
            if (r8 != 0) goto La7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            t3.h r0 = v5.g.f13148u
            v5.g r0 = r0.l(r5)
            r0.a()
            java.util.ArrayList r1 = r0.F()
            java.util.Iterator r1 = r1.iterator()
            r1.getClass()
        L72:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L8b
            java.lang.Object r2 = r1.next()
            r2.getClass()
            h5.q r2 = (h5.q) r2
            boolean r3 = r2.m()
            if (r3 == 0) goto L72
            r8.add(r2)
            goto L72
        L8b:
            r0.b()
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto La7
            java.lang.Object r0 = t6.l.c0(r8)
            h5.q r0 = (h5.q) r0
            int r0 = r0.f8700a
            java.lang.Object r8 = t6.l.c0(r8)
            h5.q r8 = (h5.q) r8
            java.lang.String r8 = r8.f8709n
            r5.e0(r0, r8)
        La7:
            s6.w r8 = s6.w.f12711a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.t.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
