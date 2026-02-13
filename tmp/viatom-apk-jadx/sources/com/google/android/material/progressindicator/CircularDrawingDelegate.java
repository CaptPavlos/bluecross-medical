package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.collection.ScatterMapKt;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.progressindicator.DrawingDelegate;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH = 0.5522848f;
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float adjustedWavelength;
    private final RectF arcBounds;
    private float cachedAmplitude;
    private float cachedRadius;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    private final Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> endPoints;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.arcBounds = new RectF();
        this.endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    }

    private void appendCubicPerHalfCycle(@NonNull Path path, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint2) {
        float f = (this.adjustedWavelength / 2.0f) * 0.48f;
        DrawingDelegate.PathPoint pathPoint3 = new DrawingDelegate.PathPoint(this, pathPoint);
        DrawingDelegate.PathPoint pathPoint4 = new DrawingDelegate.PathPoint(this, pathPoint2);
        pathPoint3.moveAlong(f);
        pathPoint4.moveAlong(-f);
        float[] fArr = pathPoint3.posVec;
        float f10 = fArr[0];
        float f11 = fArr[1];
        float[] fArr2 = pathPoint4.posVec;
        float f12 = fArr2[0];
        float f13 = fArr2[1];
        float[] fArr3 = pathPoint2.posVec;
        path.cubicTo(f10, f11, f12, f13, fArr3[0], fArr3[1]);
    }

    private void calculateDisplayedPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, @NonNull Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> pair, float f, float f10, float f11, float f12) {
        float f13 = this.displayedAmplitude * f11;
        boolean z9 = this.drawingDeterminateIndicator;
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.spec;
        int i10 = z9 ? circularProgressIndicatorSpec.wavelengthDeterminate : circularProgressIndicatorSpec.wavelengthIndeterminate;
        float f14 = this.adjustedRadius;
        if (f14 != this.cachedRadius || (pathMeasure == this.activePathMeasure && (f13 != this.cachedAmplitude || i10 != this.cachedWavelength))) {
            this.cachedAmplitude = f13;
            this.cachedWavelength = i10;
            this.cachedRadius = f14;
            invalidateCachedPaths();
        }
        path.rewind();
        float f15 = 0.0f;
        float fClamp = MathUtils.clamp(f10, 0.0f, 1.0f);
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            float f16 = f12 / ((float) ((this.adjustedRadius * 6.283185307179586d) / this.adjustedWavelength));
            f += f16;
            f15 = 0.0f - (f16 * 360.0f);
        }
        float f17 = f % 1.0f;
        float length = (pathMeasure.getLength() * f17) / 2.0f;
        float length2 = (pathMeasure.getLength() * (f17 + fClamp)) / 2.0f;
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setRotate(f15);
        pathPoint.rotate(f15);
        pathPoint2.rotate(f15);
        path.transform(this.transform);
    }

    private void createWavyPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, float f) {
        path.rewind();
        float length = pathMeasure.getLength();
        boolean z9 = this.drawingDeterminateIndicator;
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.spec;
        int iMax = Math.max(3, (int) ((length / (z9 ? circularProgressIndicatorSpec.wavelengthDeterminate : circularProgressIndicatorSpec.wavelengthIndeterminate)) / 2.0f)) * 2;
        this.adjustedWavelength = length / iMax;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < iMax; i10++) {
            DrawingDelegate.PathPoint pathPoint = new DrawingDelegate.PathPoint();
            float f10 = i10;
            pathMeasure.getPosTan(this.adjustedWavelength * f10, pathPoint.posVec, pathPoint.tanVec);
            DrawingDelegate.PathPoint pathPoint2 = new DrawingDelegate.PathPoint();
            float f11 = this.adjustedWavelength;
            pathMeasure.getPosTan((f11 / 2.0f) + (f10 * f11), pathPoint2.posVec, pathPoint2.tanVec);
            arrayList.add(pathPoint);
            pathPoint2.moveAcross(f * 2.0f);
            arrayList.add(pathPoint2);
        }
        arrayList.add((DrawingDelegate.PathPoint) arrayList.get(0));
        DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint3 = (DrawingDelegate.PathPoint) arrayList.get(0);
        float[] fArr = pathPoint3.posVec;
        int i11 = 1;
        path.moveTo(fArr[0], fArr[1]);
        while (i11 < arrayList.size()) {
            DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint4 = (DrawingDelegate.PathPoint) arrayList.get(i11);
            appendCubicPerHalfCycle(path, pathPoint3, pathPoint4);
            i11++;
            pathPoint3 = pathPoint4;
        }
    }

    private void drawArc(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f10, @ColorInt int i10, @Px int i11, @Px int i12, float f11, float f12, boolean z9) {
        float f13 = f10 >= f ? f10 - f : (f10 + 1.0f) - f;
        float f14 = f % 1.0f;
        if (f14 < 0.0f) {
            f14 += 1.0f;
        }
        if (this.totalTrackLengthFraction < 1.0f) {
            float f15 = f14 + f13;
            if (f15 > 1.0f) {
                drawArc(canvas, paint, f14, 1.0f, i10, i11, 0, f11, f12, z9);
                drawArc(canvas, paint, 1.0f, f15, i10, 0, i12, f11, f12, z9);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.displayedCornerRadius / this.adjustedRadius);
        float f16 = f13 - 0.99f;
        if (f16 >= 0.0f) {
            float f17 = ((f16 * degrees) / 180.0f) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
            f13 += f17;
            if (!z9) {
                f14 -= f17 / 2.0f;
            }
        }
        float fLerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f14);
        float fLerp2 = com.google.android.material.math.MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f13);
        float degrees2 = (float) Math.toDegrees(i11 / this.adjustedRadius);
        float degrees3 = ((fLerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i12 / this.adjustedRadius));
        float f18 = (fLerp * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        boolean z10 = ((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) && z9 && f11 > 0.0f;
        paint.setAntiAlias(true);
        paint.setColor(i10);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f19 = this.displayedCornerRadius * 2.0f;
        float f20 = degrees * 2.0f;
        if (degrees3 < f20) {
            float f21 = degrees3 / f20;
            float f22 = (degrees * f21) + f18;
            DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint = new DrawingDelegate.PathPoint();
            if (z10) {
                float length = (this.activePathMeasure.getLength() * (f22 / 360.0f)) / 2.0f;
                float f23 = this.displayedAmplitude * f11;
                float f24 = this.adjustedRadius;
                if (f24 != this.cachedRadius || f23 != this.cachedAmplitude) {
                    this.cachedAmplitude = f23;
                    this.cachedRadius = f24;
                    invalidateCachedPaths();
                }
                this.activePathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
            } else {
                pathPoint.rotate(f22 + 90.0f);
                pathPoint.moveAcross(-this.adjustedRadius);
            }
            paint.setStyle(Paint.Style.FILL);
            drawRoundedBlock(canvas, paint, pathPoint, f19, this.displayedTrackThickness, f21);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(((CircularProgressIndicatorSpec) this.spec).useStrokeCap() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f25 = f18 + degrees;
        float f26 = degrees3 - f20;
        ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
        ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
        if (z10) {
            calculateDisplayedPath(this.activePathMeasure, this.displayedActivePath, this.endPoints, f25 / 360.0f, f26 / 360.0f, f11, f12);
            canvas.drawPath(this.displayedActivePath, paint);
        } else {
            ((DrawingDelegate.PathPoint) this.endPoints.first).rotate(f25 + 90.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.first).moveAcross(-this.adjustedRadius);
            ((DrawingDelegate.PathPoint) this.endPoints.second).rotate(f25 + f26 + 90.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.second).moveAcross(-this.adjustedRadius);
            RectF rectF = this.arcBounds;
            float f27 = this.adjustedRadius;
            rectF.set(-f27, -f27, f27, f27);
            canvas.drawArc(this.arcBounds, f25, f26, false, paint);
        }
        if (((CircularProgressIndicatorSpec) this.spec).useStrokeCap() || this.displayedCornerRadius <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.first, f19, this.displayedTrackThickness);
        drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.second, f19, this.displayedTrackThickness);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f, float f10, float f11) {
        float fMin = Math.min(f10, this.displayedTrackThickness);
        float f12 = f / 2.0f;
        float fMin2 = Math.min(f12, (this.displayedCornerRadius * fMin) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f) / 2.0f, (-fMin) / 2.0f, f12, fMin / 2.0f);
        canvas.save();
        float[] fArr = pathPoint.posVec;
        canvas.translate(fArr[0], fArr[1]);
        canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
        canvas.scale(f11, f11);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    private int getSize() {
        S s9 = this.spec;
        return (((CircularProgressIndicatorSpec) s9).indicatorInset * 2) + ((CircularProgressIndicatorSpec) s9).indicatorSize;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, boolean z9, boolean z10) {
        float fWidth = rect.width() / getPreferredWidth();
        float fHeight = rect.height() / getPreferredHeight();
        S s9 = this.spec;
        float f10 = (((CircularProgressIndicatorSpec) s9).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s9).indicatorInset;
        canvas.translate((f10 * fWidth) + rect.left, (f10 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
            if (Build.VERSION.SDK_INT == 29) {
                canvas.rotate(0.1f);
            }
        }
        float f11 = -f10;
        canvas.clipRect(f11, f11, f10, f10);
        S s10 = this.spec;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) s10).trackThickness * f;
        this.displayedCornerRadius = Math.min(((CircularProgressIndicatorSpec) s10).trackThickness / 2, ((CircularProgressIndicatorSpec) s10).getTrackCornerRadiusInPx()) * f;
        S s11 = this.spec;
        this.displayedAmplitude = ((CircularProgressIndicatorSpec) s11).waveAmplitude * f;
        float f12 = (((CircularProgressIndicatorSpec) s11).indicatorSize - ((CircularProgressIndicatorSpec) s11).trackThickness) / 2.0f;
        this.adjustedRadius = f12;
        if (z9 || z10) {
            float f13 = ((1.0f - f) * ((CircularProgressIndicatorSpec) s11).trackThickness) / 2.0f;
            if ((z9 && ((CircularProgressIndicatorSpec) s11).showAnimationBehavior == 2) || (z10 && ((CircularProgressIndicatorSpec) s11).hideAnimationBehavior == 1)) {
                this.adjustedRadius = f12 + f13;
            } else if ((z9 && ((CircularProgressIndicatorSpec) s11).showAnimationBehavior == 1) || (z10 && ((CircularProgressIndicatorSpec) s11).hideAnimationBehavior == 2)) {
                this.adjustedRadius = f12 - f13;
            }
        }
        if (z10 && ((CircularProgressIndicatorSpec) s11).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i10) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i10);
        canvas.save();
        canvas.rotate(activeIndicator.rotationDegree);
        this.drawingDeterminateIndicator = activeIndicator.isDeterminate;
        float f = activeIndicator.startFraction;
        float f10 = activeIndicator.endFraction;
        int i11 = activeIndicator.gapSize;
        drawArc(canvas, paint, f, f10, iCompositeARGBWithAlpha, i11, i11, activeIndicator.amplitudeFraction, activeIndicator.phaseFraction, true);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f10, @ColorInt int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i11, int i12) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i10, i11);
        this.drawingDeterminateIndicator = false;
        drawArc(canvas, paint, f, f10, iCompositeARGBWithAlpha, i12, i12, 0.0f, 0.0f, false);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void invalidateCachedPaths() {
        this.cachedActivePath.rewind();
        this.cachedActivePath.moveTo(1.0f, 0.0f);
        for (int i10 = 0; i10 < 2; i10++) {
            this.cachedActivePath.cubicTo(1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, 1.0f, 0.0f, 1.0f);
            this.cachedActivePath.cubicTo(-0.5522848f, 1.0f, -1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 0.0f);
            this.cachedActivePath.cubicTo(-1.0f, -0.5522848f, -0.5522848f, -1.0f, 0.0f, -1.0f);
            this.cachedActivePath.cubicTo(QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 1.0f, -0.5522848f, 1.0f, 0.0f);
        }
        this.transform.reset();
        Matrix matrix = this.transform;
        float f = this.adjustedRadius;
        matrix.setScale(f, f);
        this.cachedActivePath.transform(this.transform);
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            this.activePathMeasure.setPath(this.cachedActivePath, false);
            createWavyPath(this.activePathMeasure, this.cachedActivePath, this.cachedAmplitude);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f, float f10) {
        drawRoundedBlock(canvas, paint, pathPoint, f, f10, 1.0f);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i11) {
    }
}
