package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class CornerTreatment {
    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f10, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f, f10, cornerSize.getCornerSize(rectF));
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f10, float f11) {
        getCornerPath(f, f10, shapePath);
    }

    @Deprecated
    public void getCornerPath(float f, float f10, @NonNull ShapePath shapePath) {
    }
}
