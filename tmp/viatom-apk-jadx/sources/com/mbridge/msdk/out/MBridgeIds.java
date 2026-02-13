package com.mbridge.msdk.out;

import a3.a;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeIds implements NoProGuard, Serializable {
    private String bidToken = "";
    private boolean isCache = false;
    private String placementId;
    private String requestId;
    private String unitId;

    public MBridgeIds(String str, String str2, String str3) {
        this.placementId = str;
        this.unitId = str2;
        this.requestId = str3;
    }

    public String getBidToken() {
        if (TextUtils.isEmpty(this.bidToken)) {
            this.bidToken = "";
        }
        return this.bidToken;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getRequestId() {
        return TextUtils.isEmpty(this.requestId) ? "" : this.requestId;
    }

    public String getUnitId() {
        return this.unitId;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setCache(boolean z9) {
        this.isCache = z9;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("MBridgeIds{placementId='");
        sb.append(this.placementId);
        sb.append("', unitId='");
        sb.append(this.unitId);
        sb.append("', bidToken='");
        return a.o(sb, this.bidToken, "'}");
    }

    public MBridgeIds(String str, String str2) {
        this.placementId = str;
        this.unitId = str2;
    }

    public MBridgeIds() {
    }
}
