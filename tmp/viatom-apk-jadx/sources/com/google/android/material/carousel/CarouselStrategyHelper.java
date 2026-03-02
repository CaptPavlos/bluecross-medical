package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.carousel.KeylineState;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class CarouselStrategyHelper {
    private CarouselStrategyHelper() {
    }

    public static float addEnd(float f, float f10, int i10) {
        return (Math.max(0, i10 - 1) * f10) + f;
    }

    public static float addStart(float f, float f10, int i10) {
        return i10 > 0 ? (f10 / 2.0f) + f : f;
    }

    public static KeylineState createCenterAlignedKeylineState(@NonNull Context context, float f, int i10, @NonNull Arrangement arrangement) {
        float f10;
        float f11;
        float fMin = Math.min(getExtraSmallSize(context) + f, arrangement.largeSize);
        float f12 = fMin / 2.0f;
        float f13 = 0.0f - f12;
        float fAddStart = addStart(0.0f, arrangement.smallSize, arrangement.smallCount);
        float fUpdateCurPosition = updateCurPosition(0.0f, addEnd(fAddStart, arrangement.smallSize, (int) Math.floor(arrangement.smallCount / 2.0f)), arrangement.smallSize, arrangement.smallCount);
        float fAddStart2 = addStart(fUpdateCurPosition, arrangement.mediumSize, arrangement.mediumCount);
        float fUpdateCurPosition2 = updateCurPosition(fUpdateCurPosition, addEnd(fAddStart2, arrangement.mediumSize, (int) Math.floor(arrangement.mediumCount / 2.0f)), arrangement.mediumSize, arrangement.mediumCount);
        float fAddStart3 = addStart(fUpdateCurPosition2, arrangement.largeSize, arrangement.largeCount);
        float fUpdateCurPosition3 = updateCurPosition(fUpdateCurPosition2, addEnd(fAddStart3, arrangement.largeSize, arrangement.largeCount), arrangement.largeSize, arrangement.largeCount);
        float fAddStart4 = addStart(fUpdateCurPosition3, arrangement.mediumSize, arrangement.mediumCount);
        float fAddStart5 = addStart(updateCurPosition(fUpdateCurPosition3, addEnd(fAddStart4, arrangement.mediumSize, (int) Math.ceil(arrangement.mediumCount / 2.0f)), arrangement.mediumSize, arrangement.mediumCount), arrangement.smallSize, arrangement.smallCount);
        float f14 = i10 + f12;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, arrangement.largeSize, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f);
        KeylineState.Builder builderAddAnchorKeyline = new KeylineState.Builder(arrangement.largeSize, i10).addAnchorKeyline(f13, childMaskPercentage, fMin);
        if (arrangement.smallCount > 0) {
            f10 = 2.0f;
            f11 = childMaskPercentage;
            builderAddAnchorKeyline.addKeylineRange(fAddStart, childMaskPercentage2, arrangement.smallSize, (int) Math.floor(r7 / 2.0f));
        } else {
            f10 = 2.0f;
            f11 = childMaskPercentage;
        }
        if (arrangement.mediumCount > 0) {
            builderAddAnchorKeyline.addKeylineRange(fAddStart2, childMaskPercentage3, arrangement.mediumSize, (int) Math.floor(r4 / f10));
        }
        builderAddAnchorKeyline.addKeylineRange(fAddStart3, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            builderAddAnchorKeyline.addKeylineRange(fAddStart4, childMaskPercentage3, arrangement.mediumSize, (int) Math.ceil(r4 / f10));
        }
        if (arrangement.smallCount > 0) {
            builderAddAnchorKeyline.addKeylineRange(fAddStart5, childMaskPercentage2, arrangement.smallSize, (int) Math.ceil(r0 / f10));
        }
        builderAddAnchorKeyline.addAnchorKeyline(f14, f11, fMin);
        return builderAddAnchorKeyline.build();
    }

    public static KeylineState createKeylineState(@NonNull Context context, float f, int i10, @NonNull Arrangement arrangement, int i11) {
        return i11 == 1 ? createCenterAlignedKeylineState(context, f, i10, arrangement) : createLeftAlignedKeylineState(context, f, i10, arrangement);
    }

    public static KeylineState createLeftAlignedKeylineState(@NonNull Context context, float f, int i10, @NonNull Arrangement arrangement) {
        float fMin = Math.min(getExtraSmallSize(context) + f, arrangement.largeSize);
        float f10 = fMin / 2.0f;
        float f11 = 0.0f - f10;
        float fAddStart = addStart(0.0f, arrangement.largeSize, arrangement.largeCount);
        float fUpdateCurPosition = updateCurPosition(0.0f, addEnd(fAddStart, arrangement.largeSize, arrangement.largeCount), arrangement.largeSize, arrangement.largeCount);
        float fAddStart2 = addStart(fUpdateCurPosition, arrangement.mediumSize, arrangement.mediumCount);
        float fAddStart3 = addStart(updateCurPosition(fUpdateCurPosition, fAddStart2, arrangement.mediumSize, arrangement.mediumCount), arrangement.smallSize, arrangement.smallCount);
        float f12 = i10 + f10;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, arrangement.largeSize, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f);
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(arrangement.largeSize, i10).addAnchorKeyline(f11, childMaskPercentage, fMin).addKeylineRange(fAddStart, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            builderAddKeylineRange.addKeyline(fAddStart2, childMaskPercentage3, arrangement.mediumSize);
        }
        int i11 = arrangement.smallCount;
        if (i11 > 0) {
            builderAddKeylineRange.addKeylineRange(fAddStart3, childMaskPercentage2, arrangement.smallSize, i11);
        }
        builderAddKeylineRange.addAnchorKeyline(f12, childMaskPercentage, fMin);
        return builderAddKeylineRange.build();
    }

    public static float getExtraSmallSize(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    public static float getSmallSizeMax(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    public static float getSmallSizeMin(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    public static int maxValue(int[] iArr) {
        int i10 = Integer.MIN_VALUE;
        for (int i11 : iArr) {
            if (i11 > i10) {
                i10 = i11;
            }
        }
        return i10;
    }

    public static float updateCurPosition(float f, float f10, float f11, int i10) {
        return i10 > 0 ? (f11 / 2.0f) + f10 : f;
    }
}
