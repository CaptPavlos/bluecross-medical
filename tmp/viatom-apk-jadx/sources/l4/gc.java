package l4;

import com.uptodown.activities.VirusTotalReport;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class gc extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hc f10442a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VirusTotalReport f10443b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10444c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f10445d;
    public final /* synthetic */ long e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc(hc hcVar, VirusTotalReport virusTotalReport, boolean z9, long j10, long j11, w6.c cVar) {
        super(2, cVar);
        this.f10442a = hcVar;
        this.f10443b = virusTotalReport;
        this.f10444c = z9;
        this.f10445d = j10;
        this.e = j11;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new gc(this.f10442a, this.f10443b, this.f10444c, this.f10445d, this.e, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        gc gcVar = (gc) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        gcVar.invokeSuspend(wVar);
        return wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            s6.a.e(r6)
            l4.hc r6 = r5.f10442a
            u7.m0 r6 = r6.f10472a
            r6.getClass()
            r0 = 0
            v5.j r1 = v5.j.f13166a
            r6.g(r0, r1)
            c1.w4 r1 = new c1.w4
            r2 = 4
            r3 = 0
            com.uptodown.activities.VirusTotalReport r4 = r5.f10443b
            r1.<init>(r4, r2, r3)
            boolean r2 = r5.f10444c
            if (r2 != 0) goto L20
            long r2 = r5.f10445d
            goto L22
        L20:
            long r2 = r5.e
        L22:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            h5.p0 r1 = r1.C(r2)
            boolean r2 = r1.b()
            if (r2 != 0) goto L4e
            org.json.JSONObject r1 = r1.f8699d
            if (r1 == 0) goto L4e
            java.lang.String r2 = "data"
            org.json.JSONObject r2 = r1.optJSONObject(r2)
            java.lang.String r3 = "success"
            int r1 = r1.optInt(r3)
            r3 = 1
            if (r1 != r3) goto L4e
            if (r2 == 0) goto L4e
            h5.o0 r1 = new h5.o0
            r1.<init>()
            r1.a(r2)
            goto L4f
        L4e:
            r1 = r0
        L4f:
            v5.l r2 = new v5.l
            l4.fc r3 = new l4.fc
            r3.<init>(r1)
            r2.<init>(r3)
            r6.getClass()
            r6.g(r0, r2)
            s6.w r6 = s6.w.f12711a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.gc.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
