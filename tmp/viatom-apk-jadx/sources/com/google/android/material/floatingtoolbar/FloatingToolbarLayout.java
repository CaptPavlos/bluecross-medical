package com.google.android.material.floatingtoolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class FloatingToolbarLayout extends FrameLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_FloatingToolbar;
    private static final String TAG = "FloatingToolbarLayout";
    private int bottomMarginWindowInset;
    private int leftMarginWindowInset;
    private boolean marginBottomSystemWindowInsets;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private Rect originalMargins;
    private int rightMarginWindowInset;
    private int topMarginWindowInset;

    public FloatingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10, @StyleRes int i11) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        TintTypedArray tintTypedArrayObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.FloatingToolbar, i10, i11, new int[0]);
        int i12 = R.styleable.FloatingToolbar_backgroundTint;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i12)) {
            int color = tintTypedArrayObtainTintedStyledAttributes.getColor(i12, 0);
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context2, attributeSet, i10, i11).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
            setBackground(materialShapeDrawable);
        }
        this.marginLeftSystemWindowInsets = tintTypedArrayObtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginLeftSystemWindowInsets, true);
        this.marginTopSystemWindowInsets = tintTypedArrayObtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginTopSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = tintTypedArrayObtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginRightSystemWindowInsets, true);
        this.marginBottomSystemWindowInsets = tintTypedArrayObtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginBottomSystemWindowInsets, true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.floatingtoolbar.FloatingToolbarLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                if (!FloatingToolbarLayout.this.marginLeftSystemWindowInsets && !FloatingToolbarLayout.this.marginRightSystemWindowInsets && !FloatingToolbarLayout.this.marginTopSystemWindowInsets && !FloatingToolbarLayout.this.marginBottomSystemWindowInsets) {
                    return windowInsetsCompat;
                }
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
                FloatingToolbarLayout.this.bottomMarginWindowInset = insets.bottom;
                FloatingToolbarLayout.this.topMarginWindowInset = insets.top;
                FloatingToolbarLayout.this.rightMarginWindowInset = insets.right;
                FloatingToolbarLayout.this.leftMarginWindowInset = insets.left;
                FloatingToolbarLayout.this.updateMargins();
                return windowInsetsCompat;
            }
        });
        tintTypedArrayObtainTintedStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMargins() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Rect rect = this.originalMargins;
        if (rect == null) {
            Log.w(TAG, "Unable to update margins because original view margins are not set");
            return;
        }
        int i10 = rect.left + (this.marginLeftSystemWindowInsets ? this.leftMarginWindowInset : 0);
        int i11 = rect.right + (this.marginRightSystemWindowInsets ? this.rightMarginWindowInset : 0);
        int i12 = rect.top + (this.marginTopSystemWindowInsets ? this.topMarginWindowInset : 0);
        int i13 = rect.bottom + (this.marginBottomSystemWindowInsets ? this.bottomMarginWindowInset : 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.bottomMargin == i13 && marginLayoutParams.leftMargin == i10 && marginLayoutParams.rightMargin == i11 && marginLayoutParams.topMargin == i12) {
            return;
        }
        marginLayoutParams.bottomMargin = i13;
        marginLayoutParams.leftMargin = i10;
        marginLayoutParams.rightMargin = i11;
        marginLayoutParams.topMargin = i12;
        requestLayout();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            this.originalMargins = null;
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        this.originalMargins = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        updateMargins();
    }

    public FloatingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingToolbarStyle);
    }

    public FloatingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        this(context, attributeSet, i10, DEF_STYLE_RES);
    }

    public FloatingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }
}
