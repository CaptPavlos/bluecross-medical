package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class RowContainerView extends LinearLayout {
    private Drawable mForeground;
    private boolean mForegroundBoundsChanged;
    private ViewGroup mHeaderDock;

    public RowContainerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mForegroundBoundsChanged = true;
        setOrientation(1);
        LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_row_container, this);
        this.mHeaderDock = (ViewGroup) findViewById(androidx.leanback.R.id.lb_row_container_header_dock);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    public void addHeaderView(View view) {
        if (this.mHeaderDock.indexOfChild(view) < 0) {
            this.mHeaderDock.addView(view, 0);
        }
    }

    public void addRowView(View view) {
        addView(view);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.mForeground;
        if (drawable != null) {
            if (this.mForegroundBoundsChanged) {
                this.mForegroundBoundsChanged = false;
                drawable.setBounds(0, 0, getWidth(), getHeight());
            }
            this.mForeground.draw(canvas);
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.mForeground;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mForegroundBoundsChanged = true;
    }

    public void removeHeaderView(View view) {
        if (this.mHeaderDock.indexOfChild(view) >= 0) {
            this.mHeaderDock.removeView(view);
        }
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        this.mForeground = drawable;
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setForegroundColor(@ColorInt int i10) {
        Drawable drawable = this.mForeground;
        if (!(drawable instanceof ColorDrawable)) {
            setForeground(new ColorDrawable(i10));
        } else {
            ((ColorDrawable) drawable.mutate()).setColor(i10);
            invalidate();
        }
    }

    public void showHeader(boolean z9) {
        this.mHeaderDock.setVisibility(z9 ? 0 : 8);
    }

    public RowContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RowContainerView(Context context) {
        this(context, null, 0);
    }
}
