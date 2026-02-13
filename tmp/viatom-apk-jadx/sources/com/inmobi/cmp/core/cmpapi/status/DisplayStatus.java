package com.inmobi.cmp.core.cmpapi.status;

import androidx.annotation.Keep;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public enum DisplayStatus {
    VISIBLE("visible"),
    HIDDEN(MRAIDCommunicatorUtil.STATES_HIDDEN),
    DISABLED("disabled"),
    DISMISSED("dismissed");

    private final String value;

    DisplayStatus(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
