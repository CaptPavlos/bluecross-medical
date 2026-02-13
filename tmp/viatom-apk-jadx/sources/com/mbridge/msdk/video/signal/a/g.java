package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class g implements com.mbridge.msdk.video.signal.i {
    @Override // com.mbridge.msdk.video.signal.i
    public String a() {
        af.a("js", "getEndScreenInfo");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void b(String str) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("setOrientation,landscape=", str, "js");
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void c(String str) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("handlerPlayableException，msg=", str, "js");
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "notifyCloseBtn,state=", "js");
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "toggleCloseBtn,state=", "js");
    }

    @Override // com.mbridge.msdk.video.signal.i
    public void a(String str) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("triggerCloseBtn,state=", str, "js");
    }
}
