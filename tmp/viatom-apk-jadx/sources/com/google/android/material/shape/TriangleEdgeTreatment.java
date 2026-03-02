package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z9) {
        this.size = f;
        this.inside = z9;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f10, float f11, @NonNull ShapePath shapePath) {
        boolean z9 = this.inside;
        float f12 = this.size;
        if (!z9) {
            shapePath.lineTo(f10 - (f12 * f11), 0.0f, f10, (-f12) * f11);
            shapePath.lineTo((this.size * f11) + f10, 0.0f, f, 0.0f);
        } else {
            shapePath.lineTo(f10 - (f12 * f11), 0.0f);
            float f13 = this.size;
            shapePath.lineTo(f10, f13 * f11, (f13 * f11) + f10, 0.0f);
            shapePath.lineTo(f, 0.0f);
        }
    }
}
