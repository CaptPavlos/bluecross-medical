package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f6573a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f6574b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h f6575a = new h();
    }

    public final boolean a(int i10) {
        if (MBridgeConstans.DEBUG) {
            af.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i10 + ", key: REWARD_VIDEO_REFACTOR_FOR_LOAD");
        }
        if (i10 != 94 && i10 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f6573a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f6573a = new AtomicBoolean(ah.a().a("r_v_r_f_l", false));
        } catch (Exception e) {
            this.f6573a = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("isRewardVideoRefactor error: "), "RewardVideoRefactorManager");
            }
        }
        return this.f6573a.get();
    }

    public final boolean b(int i10) {
        if (MBridgeConstans.DEBUG) {
            af.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i10 + ", key: REWARD_VIDEO_REFACTOR_FOR_CAMPAIGN_REQUEST");
        }
        if (i10 != 94 && i10 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f6574b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f6574b = new AtomicBoolean(ah.a().a("r_v_r_f_c_r", false));
        } catch (Exception e) {
            this.f6574b = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("isRewardVideoRefactor error: "), "RewardVideoRefactorManager");
            }
        }
        return this.f6574b.get();
    }

    private h() {
    }

    public static h a() {
        return a.f6575a;
    }

    public final int a(String str, int i10) {
        try {
            return ah.a().a(str, i10);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("getRewardVideoCampaignRequestTimeout error: "), "RewardVideoRefactorManager");
            }
            return i10;
        }
    }
}
