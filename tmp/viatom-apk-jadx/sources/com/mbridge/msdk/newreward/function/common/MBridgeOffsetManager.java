package com.mbridge.msdk.newreward.function.common;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeOffsetManager {
    private int offset = 0;

    public int getOffset() {
        return Math.max(this.offset, 0);
    }

    public void increaseOffset(int i10) {
        this.offset += i10;
    }

    public void resetOffset() {
        this.offset = 0;
    }
}
