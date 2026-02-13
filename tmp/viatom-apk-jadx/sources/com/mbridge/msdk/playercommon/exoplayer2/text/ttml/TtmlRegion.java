package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class TtmlRegion {
    public final String id;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final float textSize;
    public final int textSizeType;
    public final float width;

    public TtmlRegion(String str, float f, float f10, int i10, int i11, float f11, int i12, float f12) {
        this.id = str;
        this.position = f;
        this.line = f10;
        this.lineType = i10;
        this.lineAnchor = i11;
        this.width = f11;
        this.textSizeType = i12;
        this.textSize = f12;
    }

    public TtmlRegion(String str) {
        this(str, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }
}
