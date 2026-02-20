package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class SeekBar extends View {
    private AccessibilitySeekListener mAccessibilitySeekListener;
    private int mActiveBarHeight;
    private int mActiveRadius;
    private final Paint mBackgroundPaint;
    private final RectF mBackgroundRect;
    private int mBarHeight;
    private final Paint mKnobPaint;
    private int mKnobx;
    private int mMax;
    private int mProgress;
    private final Paint mProgressPaint;
    private final RectF mProgressRect;
    private int mSecondProgress;
    private final Paint mSecondProgressPaint;
    private final RectF mSecondProgressRect;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class AccessibilitySeekListener {
        public abstract boolean onAccessibilitySeekBackward();

        public abstract boolean onAccessibilitySeekForward();
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressRect = new RectF();
        this.mSecondProgressRect = new RectF();
        this.mBackgroundRect = new RectF();
        Paint paint = new Paint(1);
        this.mSecondProgressPaint = paint;
        Paint paint2 = new Paint(1);
        this.mProgressPaint = paint2;
        Paint paint3 = new Paint(1);
        this.mBackgroundPaint = paint3;
        Paint paint4 = new Paint(1);
        this.mKnobPaint = paint4;
        setWillNotDraw(false);
        paint3.setColor(-7829368);
        paint.setColor(-3355444);
        paint2.setColor(SupportMenu.CATEGORY_MASK);
        paint4.setColor(-1);
        this.mBarHeight = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_progressbar_bar_height);
        this.mActiveBarHeight = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_progressbar_active_bar_height);
        this.mActiveRadius = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_progressbar_active_radius);
    }

    private void calculate() {
        int i10 = isFocused() ? this.mActiveBarHeight : this.mBarHeight;
        int width = getWidth();
        int height = getHeight();
        int i11 = (height - i10) / 2;
        RectF rectF = this.mBackgroundRect;
        int i12 = this.mBarHeight;
        float f = i11;
        float f10 = height - i11;
        rectF.set(i12 / 2, f, width - (i12 / 2), f10);
        int i13 = isFocused() ? this.mActiveRadius : this.mBarHeight / 2;
        float f11 = width - (i13 * 2);
        float f12 = (this.mProgress / this.mMax) * f11;
        RectF rectF2 = this.mProgressRect;
        int i14 = this.mBarHeight;
        rectF2.set(i14 / 2, f, (i14 / 2) + f12, f10);
        this.mSecondProgressRect.set(this.mProgressRect.right, f, (this.mBarHeight / 2) + ((this.mSecondProgress / this.mMax) * f11), f10);
        this.mKnobx = i13 + ((int) f12);
        invalidate();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    public int getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getSecondProgress() {
        return this.mSecondProgress;
    }

    public int getSecondaryProgressColor() {
        return this.mSecondProgressPaint.getColor();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = isFocused() ? this.mActiveRadius : this.mBarHeight / 2;
        canvas.drawRoundRect(this.mBackgroundRect, f, f, this.mBackgroundPaint);
        RectF rectF = this.mSecondProgressRect;
        if (rectF.right > rectF.left) {
            canvas.drawRoundRect(rectF, f, f, this.mSecondProgressPaint);
        }
        canvas.drawRoundRect(this.mProgressRect, f, f, this.mProgressPaint);
        canvas.drawCircle(this.mKnobx, getHeight() / 2, f, this.mKnobPaint);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z9, int i10, Rect rect) {
        super.onFocusChanged(z9, i10, rect);
        calculate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        calculate();
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        AccessibilitySeekListener accessibilitySeekListener = this.mAccessibilitySeekListener;
        if (accessibilitySeekListener != null) {
            if (i10 == 4096) {
                return accessibilitySeekListener.onAccessibilitySeekForward();
            }
            if (i10 == 8192) {
                return accessibilitySeekListener.onAccessibilitySeekBackward();
            }
        }
        return super.performAccessibilityAction(i10, bundle);
    }

    public void setAccessibilitySeekListener(AccessibilitySeekListener accessibilitySeekListener) {
        this.mAccessibilitySeekListener = accessibilitySeekListener;
    }

    public void setActiveBarHeight(int i10) {
        this.mActiveBarHeight = i10;
        calculate();
    }

    public void setActiveRadius(int i10) {
        this.mActiveRadius = i10;
        calculate();
    }

    public void setBarHeight(int i10) {
        this.mBarHeight = i10;
        calculate();
    }

    public void setMax(int i10) {
        this.mMax = i10;
        calculate();
    }

    public void setProgress(int i10) {
        int i11 = this.mMax;
        if (i10 > i11) {
            i10 = i11;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.mProgress = i10;
        calculate();
    }

    public void setProgressColor(int i10) {
        this.mProgressPaint.setColor(i10);
    }

    public void setSecondaryProgress(int i10) {
        int i11 = this.mMax;
        if (i10 > i11) {
            i10 = i11;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.mSecondProgress = i10;
        calculate();
    }

    public void setSecondaryProgressColor(int i10) {
        this.mSecondProgressPaint.setColor(i10);
    }
}
