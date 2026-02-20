package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b implements h {

    /* renamed from: b, reason: collision with root package name */
    public boolean f5667b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5668c = false;

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z9, com.mbridge.msdk.videocommon.b.c cVar2) {
        af.a("ShowRewardListener", "onAdClose:isCompleteView:" + z9 + ",reward:" + cVar2);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void b(String str, String str2) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("onEndcardShow: ", str2, "ShowRewardListener");
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        af.a("ShowRewardListener", "onAdShow");
        this.f5667b = true;
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("onShowFail:", str, "ShowRewardListener");
        this.f5668c = true;
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(boolean z9, String str, String str2) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("onVideoAdClicked:", str2, "ShowRewardListener");
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(String str, String str2) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("onVideoComplete: ", str2, "ShowRewardListener");
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(boolean z9, int i10) {
        af.a("ShowRewardListener", "onAdCloseWithIVReward: " + z9 + "  " + i10);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.h
    public void a(int i10, String str, String str2) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("onAutoLoad: ", str2, "ShowRewardListener");
    }
}
