package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.Contrast;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class CarouselStrategy {
    private float smallSizeMax;
    private float smallSizeMin;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum StrategyType {
        CONTAINED,
        UNCONTAINED
    }

    public static int[] doubleCounts(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr2[i10] = iArr[i10] * 2;
        }
        return iArr2;
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public static float getChildMaskPercentage(float f, float f10, float f11) {
        return 1.0f - ((f - f11) / (f10 - f11));
    }

    public float getSmallItemSizeMax() {
        return this.smallSizeMax;
    }

    public float getSmallItemSizeMin() {
        return this.smallSizeMin;
    }

    public StrategyType getStrategyType() {
        return StrategyType.CONTAINED;
    }

    public void initialize(Context context) {
        float smallSizeMin = this.smallSizeMin;
        if (smallSizeMin <= 0.0f) {
            smallSizeMin = CarouselStrategyHelper.getSmallSizeMin(context);
        }
        this.smallSizeMin = smallSizeMin;
        float smallSizeMax = this.smallSizeMax;
        if (smallSizeMax <= 0.0f) {
            smallSizeMax = CarouselStrategyHelper.getSmallSizeMax(context);
        }
        this.smallSizeMax = smallSizeMax;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view);

    public void setSmallItemSizeMax(float f) {
        this.smallSizeMax = f;
    }

    public void setSmallItemSizeMin(float f) {
        this.smallSizeMin = f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i10) {
        return false;
    }
}
