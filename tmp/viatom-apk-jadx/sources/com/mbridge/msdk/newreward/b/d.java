package com.mbridge.msdk.newreward.b;

import android.text.TextUtils;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.a.g;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends a implements RewardVideoListener, c {

    /* renamed from: d, reason: collision with root package name */
    RewardVideoListener f4634d;
    private int e;
    private boolean f;
    private int g;
    private int h;

    /* renamed from: i, reason: collision with root package name */
    private int f4635i;

    public d(int i10, String str, String str2, boolean z9) {
        super(i10, str, str2, z9);
        this.e = 2;
        this.f = false;
        if (i10 == 287) {
            this.e = com.mbridge.msdk.foundation.same.a.X;
        } else {
            this.e = com.mbridge.msdk.foundation.same.a.W;
        }
    }

    @Override // com.mbridge.msdk.newreward.b.c
    public final void a(boolean z9, String str) {
        g gVar = new g(this.f4627a);
        e eVar = new e(z9, this.f4629c.e(), str, this.f4629c.c(), this.f4629c.f());
        eVar.e(this.f4629c.d());
        eVar.e(this.e);
        eVar.d(com.mbridge.msdk.foundation.controller.c.m().k());
        eVar.d(this.f4629c.f() ? 2 : 1);
        eVar.f(com.mbridge.msdk.newreward.function.h.d.a(str));
        eVar.e(this.f);
        eVar.a(this.g, this.h, this.f4635i);
        this.f4628b.a(eVar, gVar);
    }

    public final String b() {
        e eVarB;
        com.mbridge.msdk.newreward.function.e.a aVarD;
        com.mbridge.msdk.newreward.function.c.a.b bVarB;
        com.mbridge.msdk.newreward.a.c cVar = this.f4628b;
        if (cVar == null || (eVarB = cVar.b()) == null || (aVarD = eVarB.D()) == null || (bVarB = aVarD.b()) == null) {
            return "";
        }
        String strF = bVarB.f();
        return TextUtils.isEmpty(strF) ? "" : strF;
    }

    public final String c() {
        e eVarB;
        com.mbridge.msdk.newreward.function.e.a aVarD;
        com.mbridge.msdk.newreward.function.c.a.b bVarB;
        com.mbridge.msdk.newreward.a.c cVar = this.f4628b;
        return (cVar == null || (eVarB = cVar.b()) == null || (aVarD = eVarB.D()) == null || (bVarB = aVarD.b()) == null) ? "" : com.mbridge.msdk.foundation.same.c.a(bVarB.E());
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdClose(mBridgeIds, rewardInfo);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z9, int i10) {
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdCloseWithIVReward(mBridgeIds, z9, i10);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onAdShow(MBridgeIds mBridgeIds) {
        try {
            ((MBridgeDailyPlayModel) this.f4627a.a((Object) null, f.CREATE_DAILY)).insertDailyCap();
        } catch (Exception e) {
            androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("updateDailyShowCap error:"), "RewardVideoController");
        }
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdShow(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onEndcardShow(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onLoadSuccess(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onLoadSuccess(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onShowFail(MBridgeIds mBridgeIds, String str) {
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onShowFail(mBridgeIds, str);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onVideoAdClicked(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoAdClicked(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoComplete(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoLoadFail(mBridgeIds, str);
        }
    }

    @Override // com.mbridge.msdk.newout.RewardVideoListener
    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f4634d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoLoadSuccess(mBridgeIds);
        }
    }

    public final void b(boolean z9) {
        this.f = z9;
    }

    @Override // com.mbridge.msdk.newreward.b.a
    public final void a() {
        this.f4628b.a(this.f4627a, this.f4629c);
    }

    @Override // com.mbridge.msdk.newreward.b.c
    public final void a(String str, String str2, String str3) {
        com.mbridge.msdk.newreward.a.f fVar = new com.mbridge.msdk.newreward.a.f();
        fVar.a(str2);
        fVar.b(str3);
        this.f4628b.a(fVar);
    }

    @Override // com.mbridge.msdk.newreward.b.c
    public final boolean a(boolean z9) {
        return this.f4628b.a(z9);
    }

    public final void a(int i10) {
        this.e = i10;
        com.mbridge.msdk.newreward.a.c cVar = this.f4628b;
        if (cVar != null) {
            Iterator<e> it = cVar.a().iterator();
            while (it.hasNext()) {
                it.next().e(i10);
            }
        }
    }

    public final void a(int i10, int i11, int i12) {
        this.g = i10;
        this.h = i11;
        if (i11 == com.mbridge.msdk.foundation.same.a.K) {
            this.f4635i = i12 < 0 ? 5 : i12;
        }
        if (i11 == com.mbridge.msdk.foundation.same.a.J) {
            this.f4635i = i12 < 0 ? 80 : i12;
        }
        com.mbridge.msdk.newreward.function.h.c.a(this.f4629c.c(), i10, i11, i12);
    }

    @Override // com.mbridge.msdk.newreward.b.c
    public final void a(RewardVideoListener rewardVideoListener) {
        this.f4634d = rewardVideoListener;
        this.f4628b.a(this);
    }
}
