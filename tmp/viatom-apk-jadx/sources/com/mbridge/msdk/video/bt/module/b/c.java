package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends b {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.a.b f5669a;

    /* renamed from: d, reason: collision with root package name */
    private String f5670d;

    public c(com.mbridge.msdk.video.bt.module.a.b bVar, String str) {
        this.f5669a = bVar;
        this.f5670d = str;
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f5669a != null) {
            af.a("H5ShowRewardListener", "onAdShow");
            this.f5669a.a(this.f5670d);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void b(String str, String str2) {
        if (this.f5669a != null) {
            af.a("H5ShowRewardListener", "onEndcardShow");
            this.f5669a.c(this.f5670d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z9, com.mbridge.msdk.videocommon.b.c cVar2) {
        if (this.f5669a != null) {
            af.a("H5ShowRewardListener", "onAdClose");
            this.f5669a.a(this.f5670d, z9, cVar2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
        if (this.f5669a != null) {
            af.a("H5ShowRewardListener", "onShowFail");
            this.f5669a.a(this.f5670d, str);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(boolean z9, String str, String str2) {
        if (this.f5669a != null) {
            af.a("H5ShowRewardListener", "onVideoAdClicked");
            this.f5669a.a(this.f5670d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(String str, String str2) {
        if (this.f5669a != null) {
            af.a("H5ShowRewardListener", "onVideoComplete");
            this.f5669a.b(this.f5670d, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(int i10, String str, String str2) {
        if (this.f5669a != null) {
            af.a("H5ShowRewardListener", "onAutoLoad");
            this.f5669a.a(this.f5670d, i10, str, str2);
        }
    }
}
