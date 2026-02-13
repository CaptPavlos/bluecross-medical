package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f10, float f11) {
        this.fabMargin = f;
        this.roundedCornerRadius = f10;
        setCradleVerticalOffset(f11);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f10, float f11, @NonNull ShapePath shapePath) {
        float f12;
        float f13;
        float f14 = this.fabDiameter;
        if (f14 == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f15 = ((this.fabMargin * 2.0f) + f14) / 2.0f;
        float f16 = f11 * this.roundedCornerRadius;
        float f17 = f10 + this.horizontalOffset;
        float fD = a3.a.d(1.0f, f11, f15, this.cradleVerticalOffset * f11);
        if (fD / f15 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f18 = this.fabCornerSize;
        float f19 = f18 * f11;
        boolean z9 = f18 == -1.0f || Math.abs((f18 * 2.0f) - f14) < 0.1f;
        if (z9) {
            f12 = fD;
            f13 = 0.0f;
        } else {
            f13 = ROUNDED_CORNER_FAB_OFFSET;
            f12 = 0.0f;
        }
        float f20 = f15 + f16;
        float f21 = f12 + f16;
        float fSqrt = (float) Math.sqrt((f20 * f20) - (f21 * f21));
        float f22 = f17 - fSqrt;
        float f23 = f17 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f21));
        float f24 = (90.0f - degrees) + f13;
        shapePath.lineTo(f22, 0.0f);
        float f25 = f22 - f16;
        float f26 = f22 + f16;
        float f27 = f16 * 2.0f;
        shapePath.addArc(f25, 0.0f, f26, f27, 270.0f, degrees);
        if (z9) {
            shapePath.addArc(f17 - f15, (-f15) - f12, f17 + f15, f15 - f12, 180.0f - f24, (f24 * 2.0f) - 180.0f);
        } else {
            float f28 = this.fabMargin;
            float f29 = f19 * 2.0f;
            float f30 = f28 + f29;
            float f31 = f17 - f15;
            shapePath.addArc(f31, -(f19 + f28), f30 + f31, f28 + f19, 180.0f - f24, ((f24 * 2.0f) - 180.0f) / 2.0f);
            float f32 = f17 + f15;
            float f33 = this.fabMargin;
            shapePath.lineTo(f32 - ((f33 / 2.0f) + f19), f33 + f19);
            float f34 = this.fabMargin;
            shapePath.addArc(f32 - (f29 + f34), -(f19 + f34), f32, f34 + f19, 90.0f, f24 - 90.0f);
        }
        shapePath.addArc(f23 - f16, 0.0f, f23 + f16, f27, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f) {
        if (f >= 0.0f) {
            this.cradleVerticalOffset = f;
        } else {
            com.google.gson.internal.a.n("cradleVerticalOffset must be positive.");
        }
    }

    public void setFabCornerSize(float f) {
        this.fabCornerSize = f;
    }

    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }
}
