package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends b {

    /* renamed from: a, reason: collision with root package name */
    private h f5671a;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f5672d;
    private String e;
    private String f;
    private boolean g;
    private Context h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5673i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5674j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5675k = false;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(android.content.Context r4, boolean r5, com.mbridge.msdk.videocommon.d.c r6, com.mbridge.msdk.foundation.entity.CampaignEx r7, com.mbridge.msdk.video.bt.module.b.h r8, java.lang.String r9, java.lang.String r10) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.f5673i = r0
            r3.f5674j = r0
            r3.f5675k = r0
            r3.f5671a = r8
            r3.f5672d = r6
            r3.e = r10
            r3.f = r9
            r3.g = r5
            r3.h = r4
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L70
            java.lang.String r4 = r4.k()     // Catch: java.lang.Exception -> L70
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L70
            r8 = 0
            if (r5 != 0) goto L41
            com.mbridge.msdk.c.h r5 = com.mbridge.msdk.c.h.a()     // Catch: java.lang.Exception -> L70
            com.mbridge.msdk.c.g r4 = r5.b(r4)     // Catch: java.lang.Exception -> L70
            if (r4 != 0) goto L37
            com.mbridge.msdk.c.h.a()     // Catch: java.lang.Exception -> L70
            com.mbridge.msdk.c.g r4 = com.mbridge.msdk.c.i.a()     // Catch: java.lang.Exception -> L70
        L37:
            if (r4 == 0) goto L41
            long r4 = r4.ad()     // Catch: java.lang.Exception -> L70
            r1 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r1
            goto L42
        L41:
            r4 = r8
        L42:
            com.mbridge.msdk.videocommon.d.b r10 = com.mbridge.msdk.videocommon.d.b.a()     // Catch: java.lang.Exception -> L70
            com.mbridge.msdk.videocommon.d.a r10 = r10.b()     // Catch: java.lang.Exception -> L70
            if (r10 == 0) goto L50
            long r8 = r10.f()     // Catch: java.lang.Exception -> L70
        L50:
            if (r7 == 0) goto L70
            boolean r4 = r7.isSpareOffer(r8, r4)     // Catch: java.lang.Exception -> L70
            if (r4 == 0) goto L6a
            r4 = 1
            r7.setSpareOfferFlag(r4)     // Catch: java.lang.Exception -> L70
            int r5 = r6.y()     // Catch: java.lang.Exception -> L70
            if (r5 != r4) goto L66
            r7.setCbt(r4)     // Catch: java.lang.Exception -> L70
            return
        L66:
            r7.setCbt(r0)     // Catch: java.lang.Exception -> L70
            return
        L6a:
            r7.setSpareOfferFlag(r0)     // Catch: java.lang.Exception -> L70
            r7.setCbt(r0)     // Catch: java.lang.Exception -> L70
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.b.d.<init>(android.content.Context, boolean, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.video.bt.module.b.h, java.lang.String, java.lang.String):void");
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        super.a(cVar);
        h hVar = this.f5671a;
        if (hVar == null || this.f5673i) {
            return;
        }
        this.f5673i = true;
        this.f5667b = true;
        hVar.a(cVar);
        this.f5671a.a(2, this.f, this.e);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void b(String str, String str2) {
        super.b(str, str2);
        h hVar = this.f5671a;
        if (hVar != null) {
            hVar.b(str, str2);
            this.f5671a.a(6, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z9, com.mbridge.msdk.videocommon.b.c cVar2) {
        super.a(cVar, z9, cVar2);
        h hVar = this.f5671a;
        if (hVar == null || this.f5675k) {
            return;
        }
        this.f5675k = true;
        hVar.a(7, this.f, this.e);
        this.f5671a.a(cVar, z9, cVar2);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(boolean z9, int i10) {
        super.a(z9, i10);
        h hVar = this.f5671a;
        if (hVar == null || this.f5675k) {
            return;
        }
        hVar.a(z9, i10);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
        super.a(cVar, str);
        h hVar = this.f5671a;
        if (hVar == null || this.f5674j) {
            return;
        }
        this.f5674j = true;
        this.f5668c = true;
        hVar.a(cVar, str);
        this.f5671a.a(4, this.f, this.e);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(boolean z9, String str, String str2) {
        super.a(z9, str, str2);
        h hVar = this.f5671a;
        if (hVar != null) {
            hVar.a(z9, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(String str, String str2) {
        super.a(str, str2);
        h hVar = this.f5671a;
        if (hVar != null) {
            hVar.a(str, str2);
            this.f5671a.a(5, str, str2);
        }
    }
}
