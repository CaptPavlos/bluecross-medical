package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f, float f10, @NonNull ShapePath shapePath) {
        getEdgePath(f, f / 2.0f, f10, shapePath);
    }

    public void getEdgePath(float f, float f10, float f11, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f, 0.0f);
    }
}
