package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

import android.text.Layout;
import androidx.window.layout.c;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class TtmlStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    private static final int OFF = 0;
    private static final int ON = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;
    private int backgroundColor;
    private int fontColor;
    private String fontFamily;
    private float fontSize;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    private String id;
    private TtmlStyle inheritableStyle;
    private Layout.Alignment textAlign;
    private int linethrough = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int fontSizeUnit = -1;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OptionalBoolean {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    private TtmlStyle inherit(TtmlStyle ttmlStyle, boolean z9) {
        if (ttmlStyle != null) {
            if (!this.hasFontColor && ttmlStyle.hasFontColor) {
                setFontColor(ttmlStyle.fontColor);
            }
            if (this.bold == -1) {
                this.bold = ttmlStyle.bold;
            }
            if (this.italic == -1) {
                this.italic = ttmlStyle.italic;
            }
            if (this.fontFamily == null) {
                this.fontFamily = ttmlStyle.fontFamily;
            }
            if (this.linethrough == -1) {
                this.linethrough = ttmlStyle.linethrough;
            }
            if (this.underline == -1) {
                this.underline = ttmlStyle.underline;
            }
            if (this.textAlign == null) {
                this.textAlign = ttmlStyle.textAlign;
            }
            if (this.fontSizeUnit == -1) {
                this.fontSizeUnit = ttmlStyle.fontSizeUnit;
                this.fontSize = ttmlStyle.fontSize;
            }
            if (z9 && !this.hasBackgroundColor && ttmlStyle.hasBackgroundColor) {
                setBackgroundColor(ttmlStyle.backgroundColor);
            }
        }
        return this;
    }

    public final TtmlStyle chain(TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, true);
    }

    public final int getBackgroundColor() {
        if (this.hasBackgroundColor) {
            return this.backgroundColor;
        }
        c.g("Background color has not been defined.");
        return 0;
    }

    public final int getFontColor() {
        if (this.hasFontColor) {
            return this.fontColor;
        }
        c.g("Font color has not been defined.");
        return 0;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    public final String getId() {
        return this.id;
    }

    public final int getStyle() {
        int i10 = this.bold;
        if (i10 == -1 && this.italic == -1) {
            return -1;
        }
        return (i10 == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public final Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public final boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public final boolean hasFontColor() {
        return this.hasFontColor;
    }

    public final boolean isLinethrough() {
        return this.linethrough == 1;
    }

    public final boolean isUnderline() {
        return this.underline == 1;
    }

    public final TtmlStyle setBackgroundColor(int i10) {
        this.backgroundColor = i10;
        this.hasBackgroundColor = true;
        return this;
    }

    public final TtmlStyle setBold(boolean z9) {
        Assertions.checkState(this.inheritableStyle == null);
        this.bold = z9 ? 1 : 0;
        return this;
    }

    public final TtmlStyle setFontColor(int i10) {
        Assertions.checkState(this.inheritableStyle == null);
        this.fontColor = i10;
        this.hasFontColor = true;
        return this;
    }

    public final TtmlStyle setFontFamily(String str) {
        Assertions.checkState(this.inheritableStyle == null);
        this.fontFamily = str;
        return this;
    }

    public final TtmlStyle setFontSize(float f) {
        this.fontSize = f;
        return this;
    }

    public final TtmlStyle setFontSizeUnit(int i10) {
        this.fontSizeUnit = i10;
        return this;
    }

    public final TtmlStyle setId(String str) {
        this.id = str;
        return this;
    }

    public final TtmlStyle setItalic(boolean z9) {
        Assertions.checkState(this.inheritableStyle == null);
        this.italic = z9 ? 1 : 0;
        return this;
    }

    public final TtmlStyle setLinethrough(boolean z9) {
        Assertions.checkState(this.inheritableStyle == null);
        this.linethrough = z9 ? 1 : 0;
        return this;
    }

    public final TtmlStyle setTextAlign(Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    public final TtmlStyle setUnderline(boolean z9) {
        Assertions.checkState(this.inheritableStyle == null);
        this.underline = z9 ? 1 : 0;
        return this;
    }

    public final TtmlStyle inherit(TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, false);
    }
}
