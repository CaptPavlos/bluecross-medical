package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.view.ViewGroup;
import com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements com.mbridge.msdk.newreward.function.command.receiver.b {

    /* renamed from: a, reason: collision with root package name */
    WebViewEC f4892a = null;

    /* JADX WARN: Removed duplicated region for block: B:55:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0121 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:7:0x000e, B:9:0x0019, B:13:0x0024, B:17:0x004a, B:18:0x005c, B:21:0x0065, B:23:0x0075, B:25:0x007b, B:26:0x0087, B:28:0x008d, B:30:0x0097, B:32:0x00a5, B:34:0x00ab, B:36:0x00b9, B:38:0x00c1, B:57:0x0121, B:60:0x0131, B:62:0x0137, B:64:0x0148, B:65:0x0158, B:67:0x0175, B:70:0x017d, B:77:0x0190, B:79:0x0196, B:81:0x019b, B:83:0x01a1, B:84:0x01ac, B:86:0x01b1, B:39:0x00d3, B:41:0x00d9, B:43:0x00e5, B:45:0x00f1, B:47:0x00f5, B:48:0x00fb, B:50:0x0101, B:54:0x0109), top: B:90:0x000e }] */
    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.h.a(java.lang.Object):void");
    }

    private void a(com.mbridge.msdk.newreward.function.command.c cVar, String str, com.mbridge.msdk.newreward.a.e eVar, ViewGroup viewGroup) {
        if (cVar != null) {
            cVar.g(cVar.a("add_temple", str, "template_type", 18, "adapter_model", eVar, "parent_temple", viewGroup), com.mbridge.msdk.newreward.function.command.f.SHOW_ADD_TEMPLE);
            this.f4892a.removeTempleFromSuperView(viewGroup);
            com.mbridge.msdk.newreward.function.command.receiver.d.a().d(com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_EC);
        }
    }
}
