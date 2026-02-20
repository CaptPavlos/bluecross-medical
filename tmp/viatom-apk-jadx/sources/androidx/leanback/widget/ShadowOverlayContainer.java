package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.window.layout.c;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ShadowOverlayContainer extends FrameLayout {
    public static final int SHADOW_DYNAMIC = 3;
    public static final int SHADOW_NONE = 1;
    public static final int SHADOW_STATIC = 2;
    private static final Rect sTempRect = new Rect();
    private float mFocusedZ;
    private boolean mInitialized;
    int mOverlayColor;
    private Paint mOverlayPaint;
    private int mRoundedCornerRadius;
    private boolean mRoundedCorners;
    private Object mShadowImpl;
    private int mShadowType;
    private float mUnfocusedZ;
    private View mWrappedView;

    public ShadowOverlayContainer(Context context, int i10, boolean z9, float f, float f10, int i11) {
        super(context);
        this.mShadowType = 1;
        this.mUnfocusedZ = f;
        this.mFocusedZ = f10;
        initialize(i10, z9, i11);
    }

    public static void prepareParentForShadow(ViewGroup viewGroup) {
        StaticShadowHelper.prepareParent(viewGroup);
    }

    public static boolean supportsDynamicShadow() {
        return ShadowHelper.supportsDynamicShadow();
    }

    public static boolean supportsShadow() {
        return StaticShadowHelper.supportsShadow();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mOverlayPaint == null || this.mOverlayColor == 0) {
            return;
        }
        canvas.drawRect(this.mWrappedView.getLeft(), this.mWrappedView.getTop(), this.mWrappedView.getRight(), this.mWrappedView.getBottom(), this.mOverlayPaint);
    }

    public int getShadowType() {
        return this.mShadowType;
    }

    public View getWrappedView() {
        return this.mWrappedView;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void initialize(int i10, boolean z9, int i11) {
        if (this.mInitialized) {
            u.e();
            return;
        }
        this.mInitialized = true;
        this.mRoundedCornerRadius = i11;
        this.mRoundedCorners = i11 > 0;
        this.mShadowType = i10;
        if (i10 == 2) {
            this.mShadowImpl = StaticShadowHelper.addStaticShadow(this);
        } else if (i10 == 3) {
            this.mShadowImpl = ShadowHelper.addDynamicShadow(this, this.mUnfocusedZ, this.mFocusedZ, i11);
        }
        if (!z9) {
            setWillNotDraw(true);
            this.mOverlayPaint = null;
            return;
        }
        setWillNotDraw(false);
        this.mOverlayColor = 0;
        Paint paint = new Paint();
        this.mOverlayPaint = paint;
        paint.setColor(this.mOverlayColor);
        this.mOverlayPaint.setStyle(Paint.Style.FILL);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i10, int i11, int i12, int i13) {
        View view;
        super.onLayout(z9, i10, i11, i12, i13);
        if (!z9 || (view = this.mWrappedView) == null) {
            return;
        }
        Rect rect = sTempRect;
        rect.left = (int) view.getPivotX();
        rect.top = (int) this.mWrappedView.getPivotY();
        offsetDescendantRectToMyCoords(this.mWrappedView, rect);
        setPivotX(rect.left);
        setPivotY(rect.top);
    }

    public void setOverlayColor(@ColorInt int i10) {
        Paint paint = this.mOverlayPaint;
        if (paint == null || i10 == this.mOverlayColor) {
            return;
        }
        this.mOverlayColor = i10;
        paint.setColor(i10);
        invalidate();
    }

    public void setShadowFocusLevel(float f) {
        Object obj = this.mShadowImpl;
        if (obj != null) {
            ShadowOverlayHelper.setShadowFocusLevel(obj, this.mShadowType, f);
        }
    }

    public void useDynamicShadow() {
        useDynamicShadow(getResources().getDimension(androidx.leanback.R.dimen.lb_material_shadow_normal_z), getResources().getDimension(androidx.leanback.R.dimen.lb_material_shadow_focused_z));
    }

    public void useStaticShadow() {
        if (this.mInitialized) {
            c.g("Already initialized");
        } else if (supportsShadow()) {
            this.mShadowType = 2;
        }
    }

    public void wrap(View view) {
        if (!this.mInitialized || this.mWrappedView != null) {
            u.e();
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams.width = layoutParams.width == -1 ? -1 : -2;
            layoutParams.height = layoutParams.height == -1 ? -1 : -2;
            setLayoutParams(layoutParams);
            addView(view, layoutParams2);
        } else {
            addView(view);
        }
        if (this.mRoundedCorners && this.mShadowType != 3) {
            RoundedRectHelper.setClipToRoundedOutline(this, true);
        }
        this.mWrappedView = view;
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mShadowType = 1;
        useStaticShadow();
        useDynamicShadow();
    }

    public ShadowOverlayContainer(Context context) {
        this(context, null, 0);
    }

    public void useDynamicShadow(float f, float f10) {
        if (!this.mInitialized) {
            if (supportsDynamicShadow()) {
                this.mShadowType = 3;
                this.mUnfocusedZ = f;
                this.mFocusedZ = f10;
                return;
            }
            return;
        }
        c.g("Already initialized");
    }

    @Deprecated
    public void initialize(boolean z9, boolean z10, boolean z11) {
        initialize(!z9 ? 1 : this.mShadowType, z10, z11 ? getContext().getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_rounded_rect_corner_radius) : 0);
    }

    @Deprecated
    public void initialize(boolean z9, boolean z10) {
        initialize(z9, z10, true);
    }
}
