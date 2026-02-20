package com.mbridge.msdk.newreward.function.common;

import android.text.TextUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeDailyPlayModel {
    private final int mAdType;
    private final String mCountKey;
    private int mMaxDailyCap = 0;
    private final String mPlacementID;
    private final String mTimeKey;
    private final String mUnitID;

    public MBridgeDailyPlayModel(int i10, String str, String str2) {
        this.mAdType = i10;
        str = TextUtils.isEmpty(str) ? "null" : str;
        this.mPlacementID = str;
        str2 = TextUtils.isEmpty(str2) ? "null" : str2;
        this.mUnitID = str2;
        String str3 = i10 + "_" + str + "_" + str2;
        this.mCountKey = str3.concat("_count");
        this.mTimeKey = str3.concat("_time");
    }

    public void insertDailyCap() {
        long j10 = MBridgeSharedPreferenceModel.getInstance().getLong(this.mTimeKey, 0L);
        int integer = MBridgeSharedPreferenceModel.getInstance().getInteger(this.mCountKey, 0) + 1;
        if (j10 != 0 && System.currentTimeMillis() - j10 <= 86400000) {
            MBridgeSharedPreferenceModel.getInstance().putInteger(this.mCountKey, integer);
        } else {
            MBridgeSharedPreferenceModel.getInstance().putLong(this.mTimeKey, System.currentTimeMillis());
            MBridgeSharedPreferenceModel.getInstance().putInteger(this.mCountKey, integer);
        }
    }

    public boolean isOverDailyCap() {
        if (this.mMaxDailyCap <= 0) {
            return false;
        }
        long j10 = MBridgeSharedPreferenceModel.getInstance().getLong(this.mTimeKey, 0L);
        if (j10 == 0) {
            return false;
        }
        if (System.currentTimeMillis() - j10 <= 86400000) {
            return MBridgeSharedPreferenceModel.getInstance().getInteger(this.mCountKey, 0) >= this.mMaxDailyCap;
        }
        MBridgeSharedPreferenceModel.getInstance().putLong(this.mTimeKey, 0L);
        MBridgeSharedPreferenceModel.getInstance().putInteger(this.mCountKey, 0);
        return false;
    }

    public void setMaxPlayCount(int i10) {
        this.mMaxDailyCap = i10;
    }
}
