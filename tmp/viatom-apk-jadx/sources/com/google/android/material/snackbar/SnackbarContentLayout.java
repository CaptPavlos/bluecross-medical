package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private final TimeInterpolator contentInterpolator;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.contentInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    private static void updateTopBottomPadding(@NonNull View view, int i10, int i11) {
        if (view.isPaddingRelative()) {
            view.setPaddingRelative(view.getPaddingStart(), i10, view.getPaddingEnd(), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    private boolean updateViewsWithinLayout(int i10, int i11, int i12) {
        boolean z9;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z9 = true;
        } else {
            z9 = false;
        }
        if (this.messageView.getPaddingTop() == i11 && this.messageView.getPaddingBottom() == i12) {
            return z9;
        }
        updateTopBottomPadding(this.messageView, i11, i12);
        return true;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i10, int i11) {
        this.messageView.setAlpha(0.0f);
        long j10 = i11;
        long j11 = i10;
        this.messageView.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.contentInterpolator).setStartDelay(j11).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.contentInterpolator).setStartDelay(j11).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i10, int i11) {
        this.messageView.setAlpha(1.0f);
        long j10 = i11;
        long j11 = i10;
        this.messageView.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.contentInterpolator).setStartDelay(j11).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.contentInterpolator).setStartDelay(j11).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        super.onMeasure(i10, i11);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.messageView.getLayout();
        boolean z9 = layout != null && layout.getLineCount() > 1;
        if (!z9 || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
            if (!z9) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!updateViewsWithinLayout(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxInlineActionWidth(int i10) {
        this.maxInlineActionWidth = i10;
    }

    public void updateActionTextColorAlphaIfNeeded(float f) {
        if (f != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), this.actionView.getCurrentTextColor(), f));
        }
    }

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }
}
