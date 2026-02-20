package c5;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1712a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f1713b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1714c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k0(Context context, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1712a = i10;
        this.f1713b = context;
        this.f1714c = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1712a) {
            case 0:
                return new k0(this.f1713b, this.f1714c, cVar, 0);
            default:
                return new k0(this.f1713b, this.f1714c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1712a) {
            case 0:
                k0 k0Var = (k0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                k0Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                k0 k0Var2 = (k0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                k0Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = r6.f1712a
            switch(r0) {
                case 0: goto L18;
                default: goto L5;
            }
        L5:
            s6.a.e(r7)
            android.content.Context r7 = r6.f1713b
            boolean r0 = r7 instanceof p4.f
            if (r0 == 0) goto L15
            p4.f r7 = (p4.f) r7
            java.lang.String r0 = r6.f1714c
            r7.C(r0)
        L15:
            s6.w r7 = s6.w.f12711a
            return r7
        L18:
            java.lang.String r0 = "SettingsPreferences"
            java.lang.String r1 = "fcmTokenSent"
            android.content.Context r2 = r6.f1713b
            s6.a.e(r7)
            r7 = 0
            c1.w4 r3 = new c1.w4     // Catch: java.lang.Exception -> L3f
            r4 = 4
            r5 = 0
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Exception -> L3f
            java.lang.String r4 = r6.f1714c     // Catch: java.lang.Exception -> L3f
            h5.p0 r3 = r3.M(r4)     // Catch: java.lang.Exception -> L3f
            org.json.JSONObject r3 = r3.f8699d     // Catch: java.lang.Exception -> L3f
            if (r3 == 0) goto L3d
            java.lang.String r4 = "success"
            int r3 = r3.optInt(r4)     // Catch: java.lang.Exception -> L3f
            r4 = 1
            if (r3 != r4) goto L3d
            goto L41
        L3d:
            r4 = r7
            goto L41
        L3f:
            r3 = move-exception
            goto L55
        L41:
            android.content.SharedPreferences r3 = r2.getSharedPreferences(r0, r7)     // Catch: java.lang.Exception -> L50
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch: java.lang.Exception -> L50
            r3.putBoolean(r1, r4)     // Catch: java.lang.Exception -> L50
            r3.apply()     // Catch: java.lang.Exception -> L50
            goto L76
        L50:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Exception -> L3f
            goto L76
        L55:
            t1.c r4 = new t1.c
            r5 = 4
            r4.<init>(r2, r5)
            java.lang.String r5 = "sendFcmToken"
            r4.f(r5, r3)
            r3.printStackTrace()
            android.content.SharedPreferences r0 = r2.getSharedPreferences(r0, r7)     // Catch: java.lang.Exception -> L72
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch: java.lang.Exception -> L72
            r0.putBoolean(r1, r7)     // Catch: java.lang.Exception -> L72
            r0.apply()     // Catch: java.lang.Exception -> L72
            goto L76
        L72:
            r7 = move-exception
            r7.printStackTrace()
        L76:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.k0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
