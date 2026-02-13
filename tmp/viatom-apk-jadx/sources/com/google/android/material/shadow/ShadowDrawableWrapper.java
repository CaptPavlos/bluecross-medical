package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes3.dex */
public class ShadowDrawableWrapper extends DrawableWrapperCompat {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;

    @NonNull
    final RectF contentBounds;
    float cornerRadius;

    @NonNull
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty;

    @NonNull
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f10, float f11) {
        super(drawable);
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = Math.round(f);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(paint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f10, f11);
    }

    private void buildComponents(@NonNull Rect rect) {
        float f = this.rawMaxShadowSize;
        float f10 = SHADOW_MULTIPLIER * f;
        this.contentBounds.set(rect.left + f, rect.top + f10, rect.right - f, rect.bottom - f10);
        Drawable drawable = getDrawable();
        RectF rectF = this.contentBounds;
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f = this.cornerRadius;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f10 = this.shadowSize;
        rectF2.inset(-f10, -f10);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f11 = -rectF2.top;
        if (f11 > 0.0f) {
            float f12 = this.cornerRadius / f11;
            this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f11, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f12, ((1.0f - f12) / 2.0f) + f12, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
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

    private void drawShadow(@NonNull Canvas canvas) {
        float f;
        int i10;
        int iSave = canvas.save();
        canvas.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f10 = this.cornerRadius;
        float f11 = (-f10) - this.shadowSize;
        float f12 = f10 * 2.0f;
        boolean z9 = this.contentBounds.width() - f12 > 0.0f;
        boolean z10 = this.contentBounds.height() - f12 > 0.0f;
        float f13 = this.rawShadowSize;
        float f14 = f10 / ((f13 - (0.5f * f13)) + f10);
        float f15 = f10 / ((f13 - (SHADOW_TOP_SCALE * f13)) + f10);
        float f16 = f10 / ((f13 - (f13 * 1.0f)) + f10);
        int iSave2 = canvas.save();
        RectF rectF = this.contentBounds;
        canvas.translate(rectF.left + f10, rectF.top + f10);
        canvas.scale(f14, f15);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z9) {
            canvas.scale(1.0f / f14, 1.0f);
            f = 1.0f;
            i10 = iSave2;
            canvas.drawRect(0.0f, f11, this.contentBounds.width() - f12, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            f = 1.0f;
            i10 = iSave2;
        }
        canvas.restoreToCount(i10);
        int iSave3 = canvas.save();
        RectF rectF2 = this.contentBounds;
        canvas.translate(rectF2.right - f10, rectF2.bottom - f10);
        canvas.scale(f14, f16);
        canvas.rotate(180.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z9) {
            canvas.scale(f / f14, f);
            canvas.drawRect(0.0f, f11, this.contentBounds.width() - f12, this.shadowSize + (-this.cornerRadius), this.edgeShadowPaint);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF3 = this.contentBounds;
        canvas.translate(rectF3.left + f10, rectF3.bottom - f10);
        canvas.scale(f14, f16);
        canvas.rotate(270.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z10) {
            canvas.scale(1.0f / f16, 1.0f);
            canvas.drawRect(0.0f, f11, this.contentBounds.height() - f12, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        RectF rectF4 = this.contentBounds;
        canvas.translate(rectF4.right - f10, rectF4.top + f10);
        canvas.scale(f14, f15);
        canvas.rotate(90.0f);
        canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z10) {
            canvas.scale(1.0f / f15, 1.0f);
            canvas.drawRect(0.0f, f11, this.contentBounds.height() - f12, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(iSave);
    }

    private static int toEven(float f) {
        int iRound = Math.round(f);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float f = this.rawMaxShadowSize;
        return (this.rawMaxShadowSize * SHADOW_MULTIPLIER * 2.0f) + (Math.max(f, ((f * SHADOW_MULTIPLIER) / 2.0f) + this.cornerRadius) * 2.0f);
    }

    public float getMinWidth() {
        float f = this.rawMaxShadowSize;
        return (this.rawMaxShadowSize * 2.0f) + (Math.max(f, (f / 2.0f) + this.cornerRadius) * 2.0f);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        int iCeil = (int) Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int iCeil2 = (int) Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean z9) {
        this.addPaddingForCorners = z9;
        invalidateSelf();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        super.setAlpha(i10);
        this.cornerShadowPaint.setAlpha(i10);
        this.edgeShadowPaint.setAlpha(i10);
    }

    public void setCornerRadius(float f) {
        float fRound = Math.round(f);
        if (this.cornerRadius == fRound) {
            return;
        }
        this.cornerRadius = fRound;
        this.dirty = true;
        invalidateSelf();
    }

    public void setMaxShadowSize(float f) {
        setShadowSize(this.rawShadowSize, f);
    }

    public final void setRotation(float f) {
        if (this.rotation != f) {
            this.rotation = f;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f, float f10) {
        if (f < 0.0f || f10 < 0.0f) {
            a.n("invalid shadow size");
            return;
        }
        float even = toEven(f);
        float even2 = toEven(f10);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.rawShadowSize == even && this.rawMaxShadowSize == even2) {
            return;
        }
        this.rawShadowSize = even;
        this.rawMaxShadowSize = even2;
        this.shadowSize = Math.round(even * SHADOW_MULTIPLIER);
        this.maxShadowSize = even2;
        this.dirty = true;
        invalidateSelf();
    }

    public void setShadowSize(float f) {
        setShadowSize(f, this.rawMaxShadowSize);
    }
}
