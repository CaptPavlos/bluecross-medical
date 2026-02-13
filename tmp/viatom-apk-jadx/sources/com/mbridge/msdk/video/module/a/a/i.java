package com.mbridge.msdk.video.module.a.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class i extends f {

    /* renamed from: b, reason: collision with root package name */
    protected com.mbridge.msdk.video.module.a.a f6086b;

    public i(com.mbridge.msdk.video.module.a.a aVar) {
        this.f6086b = aVar;
    }

    @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i10, Object obj) {
        super.a(i10, obj);
        com.mbridge.msdk.video.module.a.a aVar = this.f6086b;
        if (aVar != null) {
            aVar.a(i10, obj);
        }
    }
}
