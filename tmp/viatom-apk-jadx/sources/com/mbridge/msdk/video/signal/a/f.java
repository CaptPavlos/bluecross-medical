package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.module.MBridgeVideoView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class f implements com.mbridge.msdk.video.signal.g {
    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i10, String str) {
        af.a("DefaultJSNotifyProxy", "onClick:" + i10 + ",pt:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "onVideoStatusNotify:", "DefaultJSNotifyProxy");
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(MBridgeVideoView.b bVar) {
        af.a("DefaultJSNotifyProxy", "onProgressNotify:" + bVar.toString());
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(Object obj) {
        af.a("DefaultJSNotifyProxy", "onWebviewShow:" + obj);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i10, int i11, int i12, int i13) {
        af.a("DefaultJSNotifyProxy", "showDataInfo");
    }
}
