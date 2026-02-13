package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class GuidedActionItemContainer extends NonOverlappingLinearLayoutWithForeground {
    private boolean mFocusOutAllowed;

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mFocusOutAllowed = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        if (this.mFocusOutAllowed || !Util.isDescendant(this, view)) {
            return super.focusSearch(view, i10);
        }
        View viewFocusSearch = super.focusSearch(view, i10);
        if (Util.isDescendant(this, viewFocusSearch)) {
            return viewFocusSearch;
        }
        return null;
    }

    public void setFocusOutAllowed(boolean z9) {
        this.mFocusOutAllowed = z9;
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuidedActionItemContainer(Context context) {
        this(context, null);
    }
}
