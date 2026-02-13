package androidx.cardview.widget;

import a2.a;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;
    private boolean mDirty = true;
    private boolean mAddPaddingForCorners = true;
    private boolean mPrintedShadowClipWarning = false;
    private Paint mPaint = new Paint(5);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f10, float f11) {
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        setBackground(colorStateList);
        Paint paint = new Paint(5);
        this.mCornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int) (f + 0.5f);
        this.mCardBounds = new RectF();
        Paint paint2 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f10, f11);
    }

    private void buildComponents(Rect rect) {
        float f = this.mRawMaxShadowSize;
        float f10 = SHADOW_MULTIPLIER * f;
        this.mCardBounds.set(rect.left + f, rect.top + f10, rect.right - f, rect.bottom - f10);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f = this.mCornerRadius;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f10 = this.mShadowSize;
        rectF2.inset(-f10, -f10);
        Path path = this.mCornerShadowPath;
        if (path == null) {
            this.mCornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float f11 = this.mCornerRadius;
        float f12 = f11 / (this.mShadowSize + f11);
        Paint paint = this.mCornerShadowPaint;
        float f13 = this.mCornerRadius + this.mShadowSize;
        int i10 = this.mShadowStartColor;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f13, new int[]{i10, i10, this.mShadowEndColor}, new float[]{0.0f, f12, 1.0f}, tileMode));
        Paint paint2 = this.mEdgeShadowPaint;
        float f14 = this.mCornerRadius;
        float f15 = this.mShadowSize;
        float f16 = (-f14) + f15;
        float f17 = (-f14) - f15;
        int i11 = this.mShadowStartColor;
        paint2.setShader(new LinearGradient(0.0f, f16, 0.0f, f17, new int[]{i11, i11, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, tileMode));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f, float f10, boolean z9) {
        if (!z9) {
            return f;
        }
        return (float) (((1.0d - COS_45) * f10) + f);
    }

    public static float calculateVerticalPadding(float f, float f10, boolean z9) {
        if (!z9) {
            return f * SHADOW_MULTIPLIER;
        }
        return (float) (((1.0d - COS_45) * f10) + (f * SHADOW_MULTIPLIER));
    }

    private void drawShadow(Canvas canvas) {
        Canvas canvas2;
        float f = this.mCornerRadius;
        float f10 = (-f) - this.mShadowSize;
        float f11 = (this.mRawShadowSize / 2.0f) + f + this.mInsetShadow;
        float f12 = 2.0f * f11;
        boolean z9 = this.mCardBounds.width() - f12 > 0.0f;
        boolean z10 = this.mCardBounds.height() - f12 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.mCardBounds;
        canvas.translate(rectF.left + f11, rectF.top + f11);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z9) {
            canvas2 = canvas;
            canvas2.drawRect(0.0f, f10, this.mCardBounds.width() - f12, -this.mCornerRadius, this.mEdgeShadowPaint);
        } else {
            canvas2 = canvas;
        }
        canvas2.restoreToCount(iSave);
        int iSave2 = canvas2.save();
        RectF rectF2 = this.mCardBounds;
        canvas2.translate(rectF2.right - f11, rectF2.bottom - f11);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z9) {
            canvas2.drawRect(0.0f, f10, this.mCardBounds.width() - f12, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(iSave2);
        int iSave3 = canvas2.save();
        RectF rectF3 = this.mCardBounds;
        canvas2.translate(rectF3.left + f11, rectF3.bottom - f11);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z10) {
            canvas2.drawRect(0.0f, f10, this.mCardBounds.height() - f12, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(iSave3);
        int iSave4 = canvas2.save();
        RectF rectF4 = this.mCardBounds;
        canvas2.translate(rectF4.right - f11, rectF4.top + f11);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z10) {
            canvas2.drawRect(0.0f, f10, this.mCardBounds.height() - f12, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(iSave4);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float f, float f10) {
        if (f < 0.0f) {
            a.k("Invalid shadow size ", f, ". Must be >= 0");
            return;
        }
        if (f10 < 0.0f) {
            a.k("Invalid max shadow size ", f10, ". Must be >= 0");
            return;
        }
        float even = toEven(f);
        float even2 = toEven(f10);
        if (even > even2) {
            if (!this.mPrintedShadowClipWarning) {
                this.mPrintedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.mRawShadowSize == even && this.mRawMaxShadowSize == even2) {
            return;
        }
        this.mRawShadowSize = even;
        this.mRawMaxShadowSize = even2;
        this.mShadowSize = (int) ((even * SHADOW_MULTIPLIER) + this.mInsetShadow + 0.5f);
        this.mDirty = true;
        invalidateSelf();
    }

    private int toEven(float f) {
        int i10 = (int) (f + 0.5f);
        return i10 % 2 == 1 ? i10 - 1 : i10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public void getMaxShadowAndCornerPadding(Rect rect) {
        getPadding(rect);
    }

    public float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    public float getMinHeight() {
        float f = this.mRawMaxShadowSize;
        return (((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) + this.mInsetShadow) * 2.0f) + (Math.max(f, ((f * SHADOW_MULTIPLIER) / 2.0f) + this.mCornerRadius + this.mInsetShadow) * 2.0f);
    }

    public float getMinWidth() {
        float f = this.mRawMaxShadowSize;
        return ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f) + (Math.max(f, (f / 2.0f) + this.mCornerRadius + this.mInsetShadow) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int iCeil2 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public float getShadowSize() {
        return this.mRawShadowSize;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.mBackground;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.mBackground;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    public void setAddPaddingForCorners(boolean z9) {
        this.mAddPaddingForCorners = z9;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.mPaint.setAlpha(i10);
        this.mCornerShadowPaint.setAlpha(i10);
        this.mEdgeShadowPaint.setAlpha(i10);
    }

    public void setColor(@Nullable ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setCornerRadius(float f) {
        if (f < 0.0f) {
            a.k("Invalid radius ", f, ". Must be >= 0");
            return;
        }
        float f10 = (int) (f + 0.5f);
        if (this.mCornerRadius == f10) {
            return;
        }
        this.mCornerRadius = f10;
        this.mDirty = true;
        invalidateSelf();
    }

    public void setMaxShadowSize(float f) {
        setShadowSize(this.mRawShadowSize, f);
    }

    public void setShadowSize(float f) {
        setShadowSize(f, this.mRawMaxShadowSize);
    }
}
