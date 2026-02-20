package com.mbridge.msdk.playercommon.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class Cue {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = Float.MIN_VALUE;
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int windowColor;
    public final boolean windowColorSet;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    private Cue(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f, int i10, int i11, float f10, int i12, int i13, float f11, float f12, float f13, boolean z9, int i14) {
        this.text = charSequence;
        this.textAlignment = alignment;
        this.bitmap = bitmap;
        this.line = f;
        this.lineType = i10;
        this.lineAnchor = i11;
        this.position = f10;
        this.positionAnchor = i12;
        this.size = f12;
        this.bitmapHeight = f13;
        this.windowColorSet = z9;
        this.windowColor = i14;
        this.textSizeType = i13;
        this.textSize = f11;
    }

    public Cue(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f, int i10, int i11, float f10, int i12, float f11) {
        this(charSequence, alignment, f, i10, i11, f10, i12, f11, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f, int i10, int i11, float f10, int i12, float f11, int i13, float f12) {
        this(charSequence, alignment, null, f, i10, i11, f10, i12, i13, f12, f11, Float.MIN_VALUE, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f, int i10, int i11, float f10, int i12, float f11, boolean z9, int i13) {
        this(charSequence, alignment, null, f, i10, i11, f10, i12, Integer.MIN_VALUE, Float.MIN_VALUE, f11, Float.MIN_VALUE, z9, i13);
    }

    public Cue(Bitmap bitmap, float f, int i10, float f10, int i11, float f11, float f12) {
        this(null, null, bitmap, f10, 0, i11, f, i10, Integer.MIN_VALUE, Float.MIN_VALUE, f11, f12, false, ViewCompat.MEASURED_STATE_MASK);
    }
}
