package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.canvas.CanvasCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class ShapeableDelegate {

    @Nullable
    ShapeAppearanceModel shapeAppearanceModel;
    boolean forceCompatClippingEnabled = false;
    boolean offsetZeroCornerEdgeBoundsEnabled = false;
    RectF maskBounds = new RectF();
    final Path shapePath = new Path();

    @NonNull
    public static ShapeableDelegate create(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 33 ? new ShapeableDelegateV33(view) : new ShapeableDelegateV22(view);
    }

    private boolean isMaskBoundsValid() {
        RectF rectF = this.maskBounds;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    private void updateShapePath() {
        if (!isMaskBoundsValid() || this.shapeAppearanceModel == null) {
            return;
        }
        ShapeAppearancePathProvider.getInstance().calculatePath(this.shapeAppearanceModel, 1.0f, this.maskBounds, this.shapePath);
    }

    public abstract void invalidateClippingMethod(@NonNull View view);

    public boolean isForceCompatClippingEnabled() {
        return this.forceCompatClippingEnabled;
    }

    public void maybeClip(@NonNull Canvas canvas, @NonNull CanvasCompat.CanvasOperation canvasOperation) {
        if (!shouldUseCompatClipping() || this.shapePath.isEmpty()) {
            canvasOperation.run(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.shapePath);
        canvasOperation.run(canvas);
        canvas.restore();
    }

    public void onMaskChanged(@NonNull View view, @NonNull RectF rectF) {
        this.maskBounds = rectF;
        updateShapePath();
        invalidateClippingMethod(view);
    }

    public void onShapeAppearanceChanged(@NonNull View view, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        updateShapePath();
        invalidateClippingMethod(view);
    }

    public void setForceCompatClippingEnabled(@NonNull View view, boolean z9) {
        if (z9 != this.forceCompatClippingEnabled) {
            this.forceCompatClippingEnabled = z9;
            invalidateClippingMethod(view);
        }
    }

    public void setOffsetZeroCornerEdgeBoundsEnabled(@NonNull View view, boolean z9) {
        this.offsetZeroCornerEdgeBoundsEnabled = z9;
        invalidateClippingMethod(view);
    }

    public abstract boolean shouldUseCompatClipping();
}
