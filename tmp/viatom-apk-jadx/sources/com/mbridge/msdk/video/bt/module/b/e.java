package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.video.bt.module.MBTempContainer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends MBTempContainer.a.C0062a {

    /* renamed from: a, reason: collision with root package name */
    private h f5676a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.d.c f5677b;

    public e(com.mbridge.msdk.foundation.same.report.d.c cVar, h hVar) {
        this.f5676a = hVar;
        this.f5677b = cVar;
    }

    @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.a.C0062a, com.mbridge.msdk.video.bt.module.MBTempContainer.a
    public final void a(String str) {
        super.a(str);
        h hVar = this.f5676a;
        if (hVar != null) {
            hVar.a(this.f5677b, str);
        }
    }
}
