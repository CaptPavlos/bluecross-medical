package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f10, float f11) {
        float f12 = f11 * f10;
        shapePath.reset(0.0f, f12, 180.0f, 180.0f - f);
        float f13 = f12 * 2.0f;
        shapePath.addArc(0.0f, 0.0f, f13, f13, 180.0f, f);
    }

    @Deprecated
    public RoundedCornerTreatment(float f) {
        this.radius = f;
    }
}
