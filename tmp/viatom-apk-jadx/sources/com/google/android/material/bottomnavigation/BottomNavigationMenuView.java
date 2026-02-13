package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private final List<Integer> tempChildWidths;

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        this.tempChildWidths = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int measuredWidth = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                if (getLayoutDirection() == 1) {
                    int i17 = i14 - measuredWidth;
                    childAt.layout(i17 - childAt.getMeasuredWidth(), 0, i17, i15);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i15);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int iMax;
        int i13;
        int i14;
        int size = View.MeasureSpec.getSize(i10);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        int childCount = getChildCount();
        this.tempChildWidths.clear();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), Integer.MIN_VALUE);
        int i15 = 0;
        if (getItemIconGravity() == 0) {
            if (isShifting(getLabelVisibilityMode(), currentVisibleContentItemCount) && isItemHorizontalTranslationEnabled()) {
                View childAt = getChildAt(getSelectedItemPosition());
                int iMax2 = this.activeItemMinWidth;
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), iMakeMeasureSpec);
                    iMax2 = Math.max(iMax2, childAt.getMeasuredWidth());
                }
                int i16 = currentVisibleContentItemCount - (childAt.getVisibility() != 8 ? 1 : 0);
                int iMin = Math.min(size - (this.inactiveItemMinWidth * i16), Math.min(iMax2, this.activeItemMaxWidth));
                int i17 = size - iMin;
                int iMin2 = Math.min(i17 / (i16 != 0 ? i16 : 1), this.inactiveItemMaxWidth);
                int i18 = i17 - (i16 * iMin2);
                int i19 = 0;
                while (i19 < childCount) {
                    if (getChildAt(i19).getVisibility() != 8) {
                        i14 = i19 == getSelectedItemPosition() ? iMin : iMin2;
                        if (i18 > 0) {
                            i14++;
                            i18--;
                        }
                    } else {
                        i14 = 0;
                    }
                    this.tempChildWidths.add(Integer.valueOf(i14));
                    i19++;
                }
            } else {
                int iMin3 = Math.min(size / (currentVisibleContentItemCount != 0 ? currentVisibleContentItemCount : 1), this.activeItemMaxWidth);
                int i20 = size - (currentVisibleContentItemCount * iMin3);
                for (int i21 = 0; i21 < childCount; i21++) {
                    if (getChildAt(i21).getVisibility() == 8) {
                        i13 = 0;
                    } else if (i20 > 0) {
                        i13 = iMin3 + 1;
                        i20--;
                    } else {
                        i13 = iMin3;
                    }
                    this.tempChildWidths.add(Integer.valueOf(i13));
                }
            }
            i12 = 0;
            iMax = 0;
            while (i15 < childCount) {
                View childAt2 = getChildAt(i15);
                if (childAt2.getVisibility() != 8) {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(i15).intValue(), 1073741824), iMakeMeasureSpec);
                    childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                    int measuredWidth = childAt2.getMeasuredWidth() + i12;
                    iMax = Math.max(iMax, childAt2.getMeasuredHeight());
                    i12 = measuredWidth;
                }
                i15++;
            }
        } else {
            if (currentVisibleContentItemCount == 0) {
                currentVisibleContentItemCount = 1;
            }
            float f = size;
            float fMin = Math.min((currentVisibleContentItemCount + 3) / 10.0f, 0.9f) * f;
            float f10 = currentVisibleContentItemCount;
            int iRound = Math.round(fMin / f10);
            int iRound2 = Math.round(f / f10);
            int i22 = 0;
            int iMax3 = 0;
            while (i15 < childCount) {
                View childAt3 = getChildAt(i15);
                if (childAt3.getVisibility() != 8) {
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(iRound2, Integer.MIN_VALUE), iMakeMeasureSpec);
                    if (childAt3.getMeasuredWidth() < iRound) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(iRound, 1073741824), iMakeMeasureSpec);
                    }
                    int measuredWidth2 = childAt3.getMeasuredWidth() + i22;
                    iMax3 = Math.max(iMax3, childAt3.getMeasuredHeight());
                    i22 = measuredWidth2;
                }
                i15++;
            }
            i12 = i22;
            iMax = iMax3;
        }
        setMeasuredDimension(i12, Math.max(iMax, getSuggestedMinimumHeight()));
    }

    public void setItemHorizontalTranslationEnabled(boolean z9) {
        this.itemHorizontalTranslationEnabled = z9;
    }
}
