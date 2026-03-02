package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f;
        float fMax = Math.max(getSmallItemSizeMax() + f, smallItemSizeMin);
        float f10 = containerHeight;
        float fMin = Math.min(measuredWidth + f, f10);
        float fClamp = MathUtils.clamp((measuredWidth / 3.0f) + f, smallItemSizeMin + f, fMax + f);
        float f11 = (fMin + fClamp) / 2.0f;
        int i10 = 0;
        int[] iArr = f10 < 2.0f * smallItemSizeMin ? new int[]{0} : SMALL_COUNTS;
        int iMax = (int) Math.max(1.0d, Math.floor((f10 - (CarouselStrategyHelper.maxValue(r1) * fMax)) / fMin));
        int iCeil = (((int) Math.ceil(f10 / fMin)) - iMax) + 1;
        int[] iArr2 = new int[iCeil];
        for (int i11 = 0; i11 < iCeil; i11++) {
            iArr2[i11] = iMax + i11;
        }
        int i12 = carousel.getCarouselAlignment() == 1 ? 1 : 0;
        Arrangement arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f10, fClamp, smallItemSizeMin, fMax, i12 != 0 ? CarouselStrategy.doubleCounts(iArr) : iArr, f11, i12 != 0 ? CarouselStrategy.doubleCounts(MEDIUM_COUNTS) : MEDIUM_COUNTS, fMin, iArr2);
        this.keylineCount = arrangementFindLowestCostArrangement.getItemCount();
        if (arrangementFindLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f10, fClamp, smallItemSizeMin, fMax, iArr, f11, MEDIUM_COUNTS, fMin, iArr2);
        } else {
            i10 = i12;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f, containerHeight, arrangementFindLowestCostArrangement, i10);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i10) {
        if (carousel.getCarouselAlignment() == 1) {
            return (i10 < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (i10 >= this.keylineCount && carousel.getItemCount() < this.keylineCount);
        }
        return false;
    }
}
