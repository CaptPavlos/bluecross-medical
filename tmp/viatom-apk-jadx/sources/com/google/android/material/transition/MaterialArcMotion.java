package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.transition.PathMotion;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MaterialArcMotion extends PathMotion {
    private static PointF getControlPoint(float f, float f10, float f11, float f12) {
        return f10 > f12 ? new PointF(f11, f10) : new PointF(f, f12);
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f, float f10, float f11, float f12) {
        Path path = new Path();
        path.moveTo(f, f10);
        PointF controlPoint = getControlPoint(f, f10, f11, f12);
        path.quadTo(controlPoint.x, controlPoint.y, f11, f12);
        return path;
    }
}
