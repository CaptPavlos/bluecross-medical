package androidx.leanback.preference.internal;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class OutlineOnlyWithChildrenFrameLayout extends FrameLayout {
    ViewOutlineProvider mInnerOutlineProvider;
    private ViewOutlineProvider mMagicalOutlineProvider;

    public OutlineOnlyWithChildrenFrameLayout(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i10, int i11, int i12, int i13) {
        super.onLayout(z9, i10, i11, i12, i13);
        invalidateOutline();
    }

    @Override // android.view.View
    public void setOutlineProvider(ViewOutlineProvider viewOutlineProvider) {
        this.mInnerOutlineProvider = viewOutlineProvider;
        if (this.mMagicalOutlineProvider == null) {
            this.mMagicalOutlineProvider = new ViewOutlineProvider() { // from class: androidx.leanback.preference.internal.OutlineOnlyWithChildrenFrameLayout.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (OutlineOnlyWithChildrenFrameLayout.this.getChildCount() > 0) {
                        OutlineOnlyWithChildrenFrameLayout.this.mInnerOutlineProvider.getOutline(view, outline);
                    } else {
                        ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                    }
                }
            };
        }
        super.setOutlineProvider(this.mMagicalOutlineProvider);
    }

    public OutlineOnlyWithChildrenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OutlineOnlyWithChildrenFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public OutlineOnlyWithChildrenFrameLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
