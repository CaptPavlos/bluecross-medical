package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f10, float f11) {
        float f12 = f11 * f10;
        shapePath.reset(0.0f, f12, 180.0f, 180.0f - f);
        double d8 = f12;
        shapePath.lineTo((float) (Math.sin(Math.toRadians(f)) * d8), (float) (Math.sin(Math.toRadians(90.0f - f)) * d8));
    }

    @Deprecated
    public CutCornerTreatment(float f) {
        this.size = f;
    }
}
