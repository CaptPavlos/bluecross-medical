package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet, i10, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i10, int i11) {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i10, i11);
        int i12 = R.styleable.PopupWindow_overlapAnchor;
        if (tintTypedArrayObtainStyledAttributes.hasValue(i12)) {
            setSupportOverlapAnchor(tintTypedArrayObtainStyledAttributes.getBoolean(i12, false));
        }
        setBackgroundDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    private void setSupportOverlapAnchor(boolean z9) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z9;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z9);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i10, int i11, int i12, int i13) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        super(context, attributeSet, i10, i11);
        init(context, attributeSet, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
