package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class HorizontalHoverCardSwitcher extends PresenterSwitcher {
    int mCardLeft;
    int mCardRight;
    private int[] mTmpOffsets = new int[2];
    private Rect mTmpRect = new Rect();

    @Override // androidx.leanback.widget.PresenterSwitcher
    public void insertView(View view) {
        getParentViewGroup().addView(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    @Override // androidx.leanback.widget.PresenterSwitcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewSelected(android.view.View r7) {
        /*
            r6 = this;
            android.view.ViewGroup r0 = r6.getParentViewGroup()
            int r0 = r0.getWidth()
            android.view.ViewGroup r1 = r6.getParentViewGroup()
            int r1 = r1.getPaddingRight()
            int r0 = r0 - r1
            android.view.ViewGroup r1 = r6.getParentViewGroup()
            int r1 = r1.getPaddingLeft()
            r2 = 0
            r7.measure(r2, r2)
            android.view.ViewGroup$LayoutParams r3 = r7.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
            int r4 = r7.getLayoutDirection()
            r5 = 1
            if (r4 != r5) goto L2b
            r2 = r5
        L2b:
            if (r2 != 0) goto L3e
            int r4 = r6.mCardLeft
            int r5 = r7.getMeasuredWidth()
            int r5 = r5 + r4
            if (r5 <= r0) goto L3e
            int r1 = r7.getMeasuredWidth()
            int r0 = r0 - r1
            r3.leftMargin = r0
            goto L57
        L3e:
            if (r2 == 0) goto L47
            int r0 = r6.mCardLeft
            if (r0 >= r1) goto L47
            r3.leftMargin = r1
            goto L57
        L47:
            if (r2 == 0) goto L53
            int r0 = r6.mCardRight
            int r1 = r7.getMeasuredWidth()
            int r0 = r0 - r1
            r3.leftMargin = r0
            goto L57
        L53:
            int r0 = r6.mCardLeft
            r3.leftMargin = r0
        L57:
            r7.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.HorizontalHoverCardSwitcher.onViewSelected(android.view.View):void");
    }

    public void select(HorizontalGridView horizontalGridView, View view, Object obj) {
        ViewGroup parentViewGroup = getParentViewGroup();
        horizontalGridView.getViewSelectedOffsets(view, this.mTmpOffsets);
        this.mTmpRect.set(0, 0, view.getWidth(), view.getHeight());
        parentViewGroup.offsetDescendantRectToMyCoords(view, this.mTmpRect);
        Rect rect = this.mTmpRect;
        int i10 = rect.left;
        int i11 = this.mTmpOffsets[0];
        this.mCardLeft = i10 - i11;
        this.mCardRight = rect.right - i11;
        select(obj);
    }
}
