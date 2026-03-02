package com.mbridge.msdk.out;

import android.content.Context;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class MBBidCommonHandler {
    protected Context context;
    protected Map<String, Object> properties;

    public MBBidCommonHandler(Map<String, Object> map, Context context) {
        this.properties = map;
        this.context = context;
    }

    public abstract void bidLoad(String str);

    public abstract void bidRelease();

    public MBBidCommonHandler() {
    }
}
