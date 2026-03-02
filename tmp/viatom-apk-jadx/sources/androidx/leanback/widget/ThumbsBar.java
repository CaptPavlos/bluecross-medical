package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ThumbsBar extends LinearLayout {
    final SparseArray<Bitmap> mBitmaps;
    int mHeroThumbHeightInPixel;
    int mHeroThumbWidthInPixel;
    private boolean mIsUserSets;
    int mMeasuredMarginInPixel;
    int mNumOfThumbs;
    int mThumbHeightInPixel;
    int mThumbWidthInPixel;

    public ThumbsBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mNumOfThumbs = -1;
        this.mBitmaps = new SparseArray<>();
        this.mIsUserSets = false;
        this.mThumbWidthInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_thumbs_width);
        this.mThumbHeightInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_thumbs_height);
        this.mHeroThumbHeightInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_hero_thumbs_width);
        this.mHeroThumbWidthInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_hero_thumbs_height);
        this.mMeasuredMarginInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_thumbs_margin);
    }

    private int calculateNumOfThumbs(int i10) {
        int iRoundUp = roundUp(i10 - this.mHeroThumbWidthInPixel, this.mThumbWidthInPixel + this.mMeasuredMarginInPixel);
        if (iRoundUp < 2) {
            iRoundUp = 2;
        } else if ((iRoundUp & 1) != 0) {
            iRoundUp++;
        }
        return iRoundUp + 1;
    }

    private static int roundUp(int i10, int i11) {
        return ((i10 + i11) - 1) / i11;
    }

    private void setNumberOfThumbsInternal() {
        while (getChildCount() > this.mNumOfThumbs) {
            removeView(getChildAt(getChildCount() - 1));
        }
        while (getChildCount() < this.mNumOfThumbs) {
            addView(createThumbView(this), new LinearLayout.LayoutParams(this.mThumbWidthInPixel, this.mThumbHeightInPixel));
        }
        int heroIndex = getHeroIndex();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (heroIndex == i10) {
                layoutParams.width = this.mHeroThumbWidthInPixel;
                layoutParams.height = this.mHeroThumbHeightInPixel;
            } else {
                layoutParams.width = this.mThumbWidthInPixel;
                layoutParams.height = this.mThumbHeightInPixel;
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void clearThumbBitmaps() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            setThumbBitmap(i10, null);
        }
        this.mBitmaps.clear();
    }

    public View createThumbView(ViewGroup viewGroup) {
        return new ImageView(viewGroup.getContext());
    }

    public int getHeroIndex() {
        return getChildCount() / 2;
    }

    public Bitmap getThumbBitmap(int i10) {
        return this.mBitmaps.get(i10);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i10, int i11, int i12, int i13) {
        super.onLayout(z9, i10, i11, i12, i13);
        int heroIndex = getHeroIndex();
        View childAt = getChildAt(heroIndex);
        int width = (getWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int measuredWidth = (childAt.getMeasuredWidth() / 2) + (getWidth() / 2);
        childAt.layout(width, getPaddingTop(), measuredWidth, childAt.getMeasuredHeight() + getPaddingTop());
        int measuredHeight = (childAt.getMeasuredHeight() / 2) + getPaddingTop();
        for (int i14 = heroIndex - 1; i14 >= 0; i14--) {
            int i15 = width - this.mMeasuredMarginInPixel;
            View childAt2 = getChildAt(i14);
            childAt2.layout(i15 - childAt2.getMeasuredWidth(), measuredHeight - (childAt2.getMeasuredHeight() / 2), i15, (childAt2.getMeasuredHeight() / 2) + measuredHeight);
            width = i15 - childAt2.getMeasuredWidth();
        }
        while (true) {
            heroIndex++;
            if (heroIndex >= this.mNumOfThumbs) {
                return;
            }
            int i16 = measuredWidth + this.mMeasuredMarginInPixel;
            View childAt3 = getChildAt(heroIndex);
            childAt3.layout(i16, measuredHeight - (childAt3.getMeasuredHeight() / 2), childAt3.getMeasuredWidth() + i16, (childAt3.getMeasuredHeight() / 2) + measuredHeight);
            measuredWidth = i16 + childAt3.getMeasuredWidth();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iCalculateNumOfThumbs;
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        if (this.mIsUserSets || this.mNumOfThumbs == (iCalculateNumOfThumbs = calculateNumOfThumbs(measuredWidth))) {
            return;
        }
        this.mNumOfThumbs = iCalculateNumOfThumbs;
        setNumberOfThumbsInternal();
    }

    public void setHeroThumbSize(int i10, int i11) {
        boolean z9;
        this.mHeroThumbHeightInPixel = i11;
        this.mHeroThumbWidthInPixel = i10;
        int heroIndex = getHeroIndex();
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (heroIndex == i12) {
                View childAt = getChildAt(i12);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z10 = true;
                if (layoutParams.height != i11) {
                    layoutParams.height = i11;
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (layoutParams.width != i10) {
                    layoutParams.width = i10;
                } else {
                    z10 = z9;
                }
                if (z10) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setNumberOfThumbs(int i10) {
        this.mIsUserSets = true;
        this.mNumOfThumbs = i10;
        setNumberOfThumbsInternal();
    }

    public void setThumbBitmap(int i10, Bitmap bitmap) {
        this.mBitmaps.put(i10, bitmap);
        ((ImageView) getChildAt(i10)).setImageBitmap(bitmap);
    }

    public void setThumbSize(int i10, int i11) {
        boolean z9;
        this.mThumbHeightInPixel = i11;
        this.mThumbWidthInPixel = i10;
        int heroIndex = getHeroIndex();
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (heroIndex != i12) {
                View childAt = getChildAt(i12);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z10 = true;
                if (layoutParams.height != i11) {
                    layoutParams.height = i11;
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (layoutParams.width != i10) {
                    layoutParams.width = i10;
                } else {
                    z10 = z9;
                }
                if (z10) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setThumbSpace(int i10) {
        this.mMeasuredMarginInPixel = i10;
        requestLayout();
    }

    public ThumbsBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
