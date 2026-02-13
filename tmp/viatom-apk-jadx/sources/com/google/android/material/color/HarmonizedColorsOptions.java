package com.google.android.material.color;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class HarmonizedColorsOptions {

    @AttrRes
    private final int colorAttributeToHarmonizeWith;

    @Nullable
    private final HarmonizedColorAttributes colorAttributes;

    @NonNull
    @ColorRes
    private final int[] colorResourceIds;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Builder {

        @Nullable
        private HarmonizedColorAttributes colorAttributes;

        @NonNull
        @ColorRes
        private int[] colorResourceIds = new int[0];

        @AttrRes
        private int colorAttributeToHarmonizeWith = R.attr.colorPrimary;

        @NonNull
        public HarmonizedColorsOptions build() {
            return new HarmonizedColorsOptions(this);
        }

        @NonNull
        public Builder setColorAttributeToHarmonizeWith(@AttrRes int i10) {
            this.colorAttributeToHarmonizeWith = i10;
            return this;
        }

        @NonNull
        public Builder setColorAttributes(@Nullable HarmonizedColorAttributes harmonizedColorAttributes) {
            this.colorAttributes = harmonizedColorAttributes;
            return this;
        }

        @NonNull
        public Builder setColorResourceIds(@NonNull @ColorRes int[] iArr) {
            this.colorResourceIds = iArr;
            return this;
        }
    }

    private HarmonizedColorsOptions(Builder builder) {
        this.colorResourceIds = builder.colorResourceIds;
        this.colorAttributes = builder.colorAttributes;
        this.colorAttributeToHarmonizeWith = builder.colorAttributeToHarmonizeWith;
    }

    @NonNull
    public static HarmonizedColorsOptions createMaterialDefaults() {
        return new Builder().setColorAttributes(HarmonizedColorAttributes.createMaterialDefaults()).build();
    }

    @AttrRes
    public int getColorAttributeToHarmonizeWith() {
        return this.colorAttributeToHarmonizeWith;
    }

    @Nullable
    public HarmonizedColorAttributes getColorAttributes() {
        return this.colorAttributes;
    }

    @NonNull
    @ColorRes
    public int[] getColorResourceIds() {
        return this.colorResourceIds;
    }

    @StyleRes
    public int getThemeOverlayResourceId(@StyleRes int i10) {
        HarmonizedColorAttributes harmonizedColorAttributes = this.colorAttributes;
        return (harmonizedColorAttributes == null || harmonizedColorAttributes.getThemeOverlay() == 0) ? i10 : this.colorAttributes.getThemeOverlay();
    }
}
