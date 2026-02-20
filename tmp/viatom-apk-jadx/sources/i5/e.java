package i5;

import com.uptodown.activities.AppInstalledDetailsActivity;
import g7.p;
import r7.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9021a;

    /* renamed from: b, reason: collision with root package name */
    public int f9022b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppInstalledDetailsActivity f9023c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9024d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(AppInstalledDetailsActivity appInstalledDetailsActivity, int i10, String str, w6.c cVar, int i11) {
        super(2, cVar);
        this.f9021a = i11;
        this.f9023c = appInstalledDetailsActivity;
        this.f9024d = i10;
        this.e = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f9021a) {
            case 0:
                return new e(this.f9023c, this.f9024d, this.e, cVar, 0);
            default:
                return new e(this.f9023c, this.f9024d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f9021a) {
        }
        return ((e) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            int r0 = r13.f9021a
            s6.w r1 = s6.w.f12711a
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            x6.a r3 = x6.a.f13718a
            r4 = 1
            r5 = 0
            switch(r0) {
                case 0: goto L68;
                default: goto Ld;
            }
        Ld:
            int r0 = r13.f9022b
            if (r0 == 0) goto L1c
            if (r0 != r4) goto L17
            s6.a.e(r14)
            goto L67
        L17:
            androidx.window.layout.c.g(r2)
            r1 = r5
            goto L67
        L1c:
            s6.a.e(r14)
            t3.h r14 = v5.g.f13148u
            com.uptodown.activities.AppInstalledDetailsActivity r8 = r13.f9023c
            android.content.Context r0 = r8.getApplicationContext()
            r0.getClass()
            v5.g r14 = r14.l(r0)
            r14.a()
            h5.f r0 = r8.V
            r0.getClass()
            java.lang.String r0 = r0.f8526c
            r0.getClass()
            h5.y0 r11 = r14.M(r0)
            if (r11 == 0) goto L4c
            android.content.Context r0 = r8.getApplicationContext()
            r0.getClass()
            h5.q r5 = r11.a(r0)
        L4c:
            r10 = r5
            r14.b()
            y7.e r14 = r7.i0.f12407a
            s7.c r14 = w7.n.f13548a
            a6.q r6 = new a6.q
            java.lang.String r9 = r13.e
            r12 = 0
            int r7 = r13.f9024d
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r13.f9022b = r4
            java.lang.Object r14 = r7.y.z(r6, r14, r13)
            if (r14 != r3) goto L67
            r1 = r3
        L67:
            return r1
        L68:
            int r0 = r13.f9022b
            if (r0 == 0) goto L77
            if (r0 != r4) goto L72
            s6.a.e(r14)
            goto La5
        L72:
            androidx.window.layout.c.g(r2)
            r1 = r5
            goto La5
        L77:
            s6.a.e(r14)
            r13.f9022b = r4
            com.uptodown.activities.AppInstalledDetailsActivity r7 = r13.f9023c
            h5.f r14 = r7.V
            r14.getClass()
            java.lang.String r14 = r14.f8526c
            java.lang.String r9 = r13.e
            boolean r14 = kotlin.jvm.internal.l.a(r9, r14)
            if (r14 == 0) goto La1
            y7.e r14 = r7.i0.f12407a
            y7.d r14 = y7.d.f14116a
            i5.e r6 = new i5.e
            r10 = 0
            r11 = 1
            int r8 = r13.f9024d
            r6.<init>(r7, r8, r9, r10, r11)
            java.lang.Object r14 = r7.y.z(r6, r14, r13)
            if (r14 != r3) goto La1
            goto La2
        La1:
            r14 = r1
        La2:
            if (r14 != r3) goto La5
            r1 = r3
        La5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
