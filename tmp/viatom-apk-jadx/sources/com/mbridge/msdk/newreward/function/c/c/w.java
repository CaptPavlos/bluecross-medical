package com.mbridge.msdk.newreward.function.c.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w extends q {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.b f4743a;

    /* renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.c.a.a f4744b;

    /* renamed from: c, reason: collision with root package name */
    private final l f4745c;

    public w(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.a.a aVar, l lVar) {
        this.f4743a = bVar;
        this.f4744b = aVar;
        this.f4745c = lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // com.mbridge.msdk.newreward.function.c.c.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r6, com.mbridge.msdk.newreward.function.c.c.x r7) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r6 = "<script>"
            com.mbridge.msdk.newreward.function.c.a.a r0 = r5.f4744b
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.h()
            java.lang.String r1 = r0.getMraid()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L23
            if (r7 == 0) goto La4
            com.mbridge.msdk.newreward.function.c.a.b r6 = r5.f4743a
            com.mbridge.msdk.newreward.function.c.a.a r0 = r5.f4744b
            r7.a(r6, r0, r5)
            com.mbridge.msdk.newreward.function.c.a.b r6 = r5.f4743a
            com.mbridge.msdk.newreward.function.c.a.a r0 = r5.f4744b
            r7.b(r6, r0, r5)
            return
        L23:
            com.mbridge.msdk.foundation.same.b.c r1 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML
            java.lang.String r1 = com.mbridge.msdk.foundation.same.b.e.a(r1)
            java.lang.String r2 = r0.getMraid()
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L3f
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = java.lang.String.valueOf(r2)
        L3f:
            java.lang.String r3 = ".html"
            java.lang.String r2 = r2.concat(r3)
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            r4.<init>(r1, r2)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            com.mbridge.msdk.c.b.a r6 = com.mbridge.msdk.c.b.a.a()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            java.lang.String r6 = r6.b()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r2.append(r6)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            java.lang.String r6 = "</script>"
            r2.append(r6)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            java.lang.String r6 = r0.getMraid()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r2.append(r6)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r1.write(r6)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r1.flush()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            java.lang.String r6 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r0.setMraid(r6)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            r1.close()     // Catch: java.lang.Exception -> L9b
            goto L9b
        L85:
            r6 = move-exception
            r3 = r1
            goto La5
        L88:
            r3 = r1
            goto L8c
        L8a:
            r6 = move-exception
            goto La5
        L8c:
            if (r3 == 0) goto L91
            r3.close()     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L91
        L91:
            java.lang.String r6 = ""
            r0.setMraid(r6)     // Catch: java.lang.Throwable -> L8a
            if (r3 == 0) goto L9b
            r3.close()     // Catch: java.lang.Exception -> L9b
        L9b:
            if (r7 == 0) goto La4
            com.mbridge.msdk.newreward.function.c.a.b r6 = r5.f4743a
            com.mbridge.msdk.newreward.function.c.a.a r0 = r5.f4744b
            r7.b(r6, r0, r5)
        La4:
            return
        La5:
            if (r3 == 0) goto Laa
            r3.close()     // Catch: java.lang.Exception -> Laa
        Laa:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.c.c.w.a(int, com.mbridge.msdk.newreward.function.c.c.x):void");
    }
}
