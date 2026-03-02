package c5;

import android.content.Context;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public v5.g f1647a;

    /* renamed from: b, reason: collision with root package name */
    public Context f1648b;

    /* renamed from: c, reason: collision with root package name */
    public g7.q f1649c;

    /* renamed from: d, reason: collision with root package name */
    public Iterator f1650d;
    public int e;
    public int f;
    public final /* synthetic */ Context g;
    public final /* synthetic */ y6.i h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(Context context, g7.q qVar, w6.c cVar) {
        super(2, cVar);
        this.g = context;
        this.h = (y6.i) qVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [g7.q, y6.i] */
    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new a(this.g, this.h, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((a) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:36:0x003f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // y6.a
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            int r0 = r11.f
            r1 = 1
            android.content.Context r2 = r11.g
            if (r0 == 0) goto L24
            if (r0 != r1) goto L1d
            int r0 = r11.e
            java.util.Iterator r3 = r11.f1650d
            g7.q r4 = r11.f1649c
            android.content.Context r5 = r11.f1648b
            v5.g r6 = r11.f1647a
            s6.a.e(r12)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            goto L3f
        L17:
            r12 = move-exception
            goto Laf
        L1a:
            r12 = move-exception
            goto L9d
        L1d:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r12)
            r12 = 0
            return r12
        L24:
            s6.a.e(r12)
            t3.h r12 = v5.g.f13148u
            v5.g r6 = r12.l(r2)
            java.util.ArrayList r12 = v5.a.i(r2)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            r6.a()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            y6.i r0 = r11.h     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            r3 = 0
            r4 = r0
            r5 = r2
            r0 = r3
            r3 = r12
        L3f:
            boolean r12 = r3.hasNext()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            if (r12 == 0) goto L99
            java.lang.Object r12 = r3.next()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            h5.f r12 = (h5.f) r12     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            java.lang.String r7 = r12.f8526c     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            if (r7 == 0) goto L3f
            int r7 = r7.length()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            if (r7 != 0) goto L56
            goto L3f
        L56:
            android.content.pm.PackageManager r7 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r7.getClass()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            java.lang.String r8 = r12.f8526c     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r8.getClass()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r9 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r7 = l5.a.b(r7, r8, r9)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            long r7 = v5.a.a(r7)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            long r9 = r12.f8533n     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 == 0) goto L3f
            r12.f8533n = r7     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r6.a0(r12)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            java.lang.String r12 = r12.f8526c     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r12.getClass()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            java.lang.Long r9 = new java.lang.Long     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f1647a = r6     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f1648b = r5     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r7 = r4
            g7.q r7 = (g7.q) r7     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f1649c = r7     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f1650d = r3     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.e = r0     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f = r1     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            java.lang.Object r12 = r4.invoke(r12, r9, r11)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            x6.a r7 = x6.a.f13718a
            if (r12 != r7) goto L3f
            return r7
        L99:
            r6.b()
            goto Lac
        L9d:
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L17
            t1.c r0 = new t1.c     // Catch: java.lang.Throwable -> L17
            r1 = 4
            r0.<init>(r2, r1)     // Catch: java.lang.Throwable -> L17
            java.lang.String r1 = "CoroutineCalculateAppSize"
            r0.f(r1, r12)     // Catch: java.lang.Throwable -> L17
            goto L99
        Lac:
            s6.w r12 = s6.w.f12711a
            return r12
        Laf:
            r6.b()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
