package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class ControlBar extends LinearLayout {
    private int mChildMarginFromCenter;
    boolean mDefaultFocusToMiddle;
    int mLastFocusIndex;
    private OnChildFocusedListener mOnChildFocusedListener;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnChildFocusedListener {
        void onChildFocusedListener(View view, View view2);
    }

    public ControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastFocusIndex = -1;
        this.mDefaultFocusToMiddle = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        if (i10 != 33 && i10 != 130) {
            super.addFocusables(arrayList, i10, i11);
            return;
        }
        int i12 = this.mLastFocusIndex;
        if (i12 >= 0 && i12 < getChildCount()) {
            arrayList.add(getChildAt(this.mLastFocusIndex));
        } else if (getChildCount() > 0) {
            arrayList.add(getChildAt(getDefaultFocusIndex()));
        }
    }

    public int getDefaultFocusIndex() {
        if (this.mDefaultFocusToMiddle) {
            return getChildCount() / 2;
        }
        return 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.mChildMarginFromCenter <= 0) {
            return;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < getChildCount() - 1) {
            View childAt = getChildAt(i12);
            i12++;
            View childAt2 = getChildAt(i12);
            int measuredWidth = this.mChildMarginFromCenter - ((childAt2.getMeasuredWidth() + childAt.getMeasuredWidth()) / 2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
            int marginStart = measuredWidth - layoutParams.getMarginStart();
            layoutParams.setMarginStart(measuredWidth);
            childAt2.setLayoutParams(layoutParams);
            i13 += marginStart;
        }
        setMeasuredDimension(getMeasuredWidth() + i13, getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (getChildCount() > 0) {
            int i11 = this.mLastFocusIndex;
            if (getChildAt((i11 < 0 || i11 >= getChildCount()) ? getDefaultFocusIndex() : this.mLastFocusIndex).requestFocus(i10, rect)) {
                return true;
            }
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        this.mLastFocusIndex = indexOfChild(view);
        OnChildFocusedListener onChildFocusedListener = this.mOnChildFocusedListener;
        if (onChildFocusedListener != null) {
            onChildFocusedListener.onChildFocusedListener(view, view2);
        }
    }

    public void setChildMarginFromCenter(int i10) {
        this.mChildMarginFromCenter = i10;
    }

    public void setDefaultFocusToMiddle(boolean z9) {
        this.mDefaultFocusToMiddle = z9;
    }

    public void setOnChildFocusedListener(OnChildFocusedListener onChildFocusedListener) {
        this.mOnChildFocusedListener = onChildFocusedListener;
    }

    public ControlBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mLastFocusIndex = -1;
        this.mDefaultFocusToMiddle = true;
    }
}
