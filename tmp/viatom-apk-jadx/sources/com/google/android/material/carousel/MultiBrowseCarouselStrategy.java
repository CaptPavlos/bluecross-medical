package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {1, 0};

    public boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i10) {
        int itemCount = arrangement.getItemCount() - i10;
        boolean z9 = itemCount > 0 && (arrangement.smallCount > 0 || arrangement.mediumCount > 1);
        while (itemCount > 0) {
            int i11 = arrangement.smallCount;
            if (i11 > 0) {
                arrangement.smallCount = i11 - 1;
            } else {
                int i12 = arrangement.mediumCount;
                if (i12 > 1) {
                    arrangement.mediumCount = i12 - 1;
                }
            }
            itemCount--;
        }
        return z9;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        boolean z9;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f;
        float fMax = Math.max(getSmallItemSizeMax() + f, smallItemSizeMin);
        float f10 = containerHeight;
        float fMin = Math.min(measuredHeight + f, f10);
        float fClamp = MathUtils.clamp((measuredHeight / 3.0f) + f, smallItemSizeMin + f, fMax + f);
        float f11 = (fMin + fClamp) / 2.0f;
        int[] iArrDoubleCounts = SMALL_COUNTS;
        float f12 = 2.0f * smallItemSizeMin;
        if (f10 <= f12) {
            iArrDoubleCounts = new int[]{0};
        }
        int[] iArrDoubleCounts2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            iArrDoubleCounts = CarouselStrategy.doubleCounts(iArrDoubleCounts);
            iArrDoubleCounts2 = CarouselStrategy.doubleCounts(iArrDoubleCounts2);
        }
        int[] iArr = iArrDoubleCounts2;
        int[] iArr2 = iArrDoubleCounts;
        float f13 = f;
        int iMax = (int) Math.max(1.0d, Math.floor(((f10 - (CarouselStrategyHelper.maxValue(iArr) * f11)) - (CarouselStrategyHelper.maxValue(iArr2) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(f10 / fMin);
        int i10 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr3[i11] = iCeil - i11;
        }
        Arrangement arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f10, fClamp, smallItemSizeMin, fMax, iArr2, f11, iArr, fMin, iArr3);
        this.keylineCount = arrangementFindLowestCostArrangement.getItemCount();
        boolean zEnsureArrangementFitsItemCount = ensureArrangementFitsItemCount(arrangementFindLowestCostArrangement, carousel.getItemCount());
        int i12 = arrangementFindLowestCostArrangement.mediumCount;
        if (i12 == 0 && arrangementFindLowestCostArrangement.smallCount == 0 && f10 > f12) {
            arrangementFindLowestCostArrangement.smallCount = 1;
            z9 = true;
        } else {
            z9 = zEnsureArrangementFitsItemCount;
        }
        if (z9) {
            arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f10, fClamp, smallItemSizeMin, fMax, new int[]{arrangementFindLowestCostArrangement.smallCount}, f11, new int[]{i12}, fMin, new int[]{arrangementFindLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f13, containerHeight, arrangementFindLowestCostArrangement, carousel.getCarouselAlignment());
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i10) {
        if (i10 >= this.keylineCount || carousel.getItemCount() < this.keylineCount) {
            return i10 >= this.keylineCount && carousel.getItemCount() < this.keylineCount;
        }
        return true;
    }
}
