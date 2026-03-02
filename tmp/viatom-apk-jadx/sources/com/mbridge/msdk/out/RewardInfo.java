package com.mbridge.msdk.out;

import a3.a;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class RewardInfo implements NoProGuard, Serializable {
    private boolean isCompleteView;
    private int rewardAlertStatus;
    private String rewardAmount;
    private String rewardName;

    public RewardInfo(boolean z9, String str, String str2, int i10) {
        this.isCompleteView = z9;
        this.rewardName = str;
        this.rewardAmount = str2;
        this.rewardAlertStatus = i10;
    }

    public int getRewardAlertStatus() {
        return this.rewardAlertStatus;
    }

    public String getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public boolean isCompleteView() {
        return this.isCompleteView;
    }

    public void setCompleteView(boolean z9) {
        this.isCompleteView = z9;
    }

    public void setRewardAlertStatus(int i10) {
        this.rewardAlertStatus = i10;
    }

    public void setRewardAmount(String str) {
        this.rewardAmount = str;
    }

    public void setRewardName(String str) {
        this.rewardName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RewardInfo{isCompleteView=");
        sb.append(this.isCompleteView);
        sb.append(", rewardName='");
        sb.append(this.rewardName);
        sb.append("', rewardAmount='");
        sb.append(this.rewardAmount);
        sb.append("', rewardAlertStatus=");
        return a.k(sb, this.rewardAlertStatus, '}');
    }

    public RewardInfo(boolean z9, String str, String str2) {
        this.isCompleteView = z9;
        this.rewardName = str;
        this.rewardAmount = str2;
    }

    public RewardInfo(boolean z9, int i10) {
        this.isCompleteView = z9;
        this.rewardAlertStatus = i10;
    }
}
