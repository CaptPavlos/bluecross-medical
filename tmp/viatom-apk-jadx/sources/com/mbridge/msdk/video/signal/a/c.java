package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c implements com.mbridge.msdk.video.signal.c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6147a = "c";

    @Override // com.mbridge.msdk.video.signal.e
    public void click(int i10, String str) {
        af.a(f6147a, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i10, String str) {
        af.a(f6147a, "handlerH5Exception");
    }

    @Override // com.mbridge.msdk.video.signal.c
    public void reactDeveloper(Object obj, String str) {
        af.a(f6147a, "reactDeveloper");
    }

    @Override // com.mbridge.msdk.video.signal.c
    public void reportUrls(Object obj, String str) {
        af.a(f6147a, "reportUrls");
    }
}
