package com.mbridge.msdk.newreward.function.e;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private String f4983a = com.mbridge.msdk.foundation.controller.c.m().k();

    /* renamed from: b, reason: collision with root package name */
    private String f4984b;

    /* renamed from: c, reason: collision with root package name */
    private int f4985c;

    /* renamed from: d, reason: collision with root package name */
    private g f4986d;
    private com.mbridge.msdk.videocommon.d.a e;
    private com.mbridge.msdk.videocommon.d.c f;

    /* JADX WARN: Removed duplicated region for block: B:55:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r9, com.mbridge.msdk.newreward.a.b.b r10) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.e.f.a(java.lang.Object, com.mbridge.msdk.newreward.a.b.b):void");
    }

    public final com.mbridge.msdk.videocommon.d.c b() {
        return this.f;
    }

    public final com.mbridge.msdk.videocommon.d.a a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.command.f fVar, int i10, String str) {
        int i11;
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("key", "2000112");
            eVar.a("st_net", Integer.valueOf(com.mbridge.msdk.foundation.same.net.e.d.f().f3748s));
            if (fVar == com.mbridge.msdk.newreward.function.command.f.REPORT_SETTING_REQUEST_START) {
                i11 = 3;
            } else if (fVar == com.mbridge.msdk.newreward.function.command.f.REPORT_SETTING_REQUEST_SUCCESS) {
                i11 = 1;
            } else {
                i11 = fVar == com.mbridge.msdk.newreward.function.command.f.REPORT_SETTING_REQUEST_FAIL ? 2 : 0;
            }
            eVar.a("result", Integer.valueOf(i11));
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i10));
            eVar.a("url", com.mbridge.msdk.foundation.same.net.e.d.f().f3747r ? com.mbridge.msdk.foundation.same.net.e.d.f().J : com.mbridge.msdk.foundation.same.net.e.d.f().I);
            eVar.a("reason", str);
            cVar.a("2000112", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000112", cVar);
        } catch (Throwable th) {
            af.b("SettingModel", th.getMessage());
        }
    }
}
