package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.KeylineState;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD = 0.85f;

    private float calculateMediumChildSize(float f, float f10, float f11) {
        float fMax = Math.max(1.5f * f11, f);
        float f12 = MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD * f10;
        if (fMax > f12) {
            fMax = Math.max(f12, f11 * 1.2f);
        }
        return Math.min(f10, fMax);
    }

    private KeylineState createCenterAlignedKeylineState(int i10, float f, float f10, int i11, float f11, float f12, float f13) {
        float fMin = Math.min(f12, f10);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, f10, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(f11, f10, f);
        float f14 = f11 / 2.0f;
        float f15 = (f13 + 0.0f) - f14;
        float f16 = f15 + f14;
        float f17 = fMin / 2.0f;
        float f18 = (i11 * f10) + f16;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f10, i10).addAnchorKeyline((f15 - f14) - f17, childMaskPercentage, fMin).addKeyline(f15, childMaskPercentage2, f11, false).addKeylineRange((f10 / 2.0f) + f16, 0.0f, f10, i11, true);
        builderAddKeylineRange.addKeyline(f14 + f18, childMaskPercentage2, f11, false);
        builderAddKeylineRange.addAnchorKeyline(f18 + f11 + f17, childMaskPercentage, fMin);
        return builderAddKeylineRange.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context context, float f, int i10, float f10, int i11, float f11, int i12, float f12) {
        float fMin = Math.min(f12, f10);
        float fMax = Math.max(fMin, 0.5f * f11);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMax, f10, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(fMin, f10, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(f11, f10, f);
        float f13 = (i11 * f10) + 0.0f;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f10, i10).addAnchorKeyline(0.0f - (fMax / 2.0f), childMaskPercentage, fMax).addKeylineRange(f10 / 2.0f, 0.0f, f10, i11, true);
        if (i12 > 0) {
            float f14 = (f11 / 2.0f) + f13;
            f13 += f11;
            builderAddKeylineRange.addKeyline(f14, childMaskPercentage3, f11, false);
        }
        builderAddKeylineRange.addAnchorKeyline((CarouselStrategyHelper.getExtraSmallSize(context) / 2.0f) + f13, childMaskPercentage2, fMin);
        return builderAddKeylineRange.build();
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public CarouselStrategy.StrategyType getStrategyType() {
        return CarouselStrategy.StrategyType.UNCONTAINED;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f10 = measuredHeight;
        float f11 = f;
        float f12 = f10 + f11;
        float extraSmallSize = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f11;
        float extraSmallSize2 = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f11;
        int iMax = Math.max(1, (int) Math.floor(r1 / f12));
        float f13 = containerWidth - (iMax * f12);
        if (carousel.getCarouselAlignment() == 1) {
            float f14 = f13 / 2.0f;
            return createCenterAlignedKeylineState(containerWidth, f11, f12, iMax, Math.max(Math.min(3.0f * f14, f12), getSmallItemSizeMin() + f11), extraSmallSize2, f14);
        }
        int i10 = 1;
        if (f13 <= 0.0f) {
            i10 = 0;
        }
        return createLeftAlignedKeylineState(view.getContext(), f11, containerWidth, f12, iMax, calculateMediumChildSize(extraSmallSize, f12, f13), i10, extraSmallSize2);
    }
}
