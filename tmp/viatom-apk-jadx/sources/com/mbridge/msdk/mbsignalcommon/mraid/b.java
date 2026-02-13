package com.mbridge.msdk.mbsignalcommon.mraid;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface b {
    void close();

    void expand(String str, boolean z9);

    CampaignEx getMraidCampaign();

    void open(String str);

    void unload();

    void useCustomClose(boolean z9);
}
