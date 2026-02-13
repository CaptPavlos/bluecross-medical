package com.inmobi.cmp.core.cmpapi.status;

import androidx.annotation.Keep;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public enum EventStatus {
    TC_LOADED("tcloaded"),
    CMP_UI_SHOWN("cmpuishown"),
    USER_ACTION_COMPLETE("useractioncomplete");

    private final String value;

    EventStatus(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
