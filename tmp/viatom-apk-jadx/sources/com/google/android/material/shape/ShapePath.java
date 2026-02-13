package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i10, @NonNull Canvas canvas) {
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i10, this.operation.getStartAngle(), this.operation.getSweepAngle());
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class InnerCornerShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation1;
        private final PathLineOperation operation2;
        private final float startX;
        private final float startY;

        public InnerCornerShadowOperation(PathLineOperation pathLineOperation, PathLineOperation pathLineOperation2, float f, float f10) {
            this.operation1 = pathLineOperation;
            this.operation2 = pathLineOperation2;
            this.startX = f;
            this.startY = f10;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            int i11;
            float sweepAngle = getSweepAngle();
            if (sweepAngle > 0.0f) {
                return;
            }
            double dHypot = Math.hypot(this.operation1.f2386x - this.startX, this.operation1.y - this.startY);
            double dHypot2 = Math.hypot(this.operation2.f2386x - this.operation1.f2386x, this.operation2.y - this.operation1.y);
            float fMin = (float) Math.min(i10, Math.min(dHypot, dHypot2));
            double d8 = fMin;
            double dTan = Math.tan(Math.toRadians((-sweepAngle) / 2.0f)) * d8;
            if (dHypot > dTan) {
                RectF rectF = new RectF(0.0f, 0.0f, (float) (dHypot - dTan), 0.0f);
                this.renderMatrix.set(matrix);
                this.renderMatrix.preTranslate(this.startX, this.startY);
                this.renderMatrix.preRotate(getStartAngle());
                i11 = i10;
                shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF, i11);
            } else {
                i11 = i10;
            }
            float f = fMin * 2.0f;
            RectF rectF2 = new RectF(0.0f, 0.0f, f, f);
            this.renderMatrix.set(matrix);
            this.renderMatrix.preTranslate(this.operation1.f2386x, this.operation1.y);
            this.renderMatrix.preRotate(getStartAngle());
            this.renderMatrix.preTranslate((float) ((-dTan) - d8), (-2.0f) * fMin);
            shadowRenderer.drawInnerCornerShadow(canvas, this.renderMatrix, rectF2, (int) fMin, 450.0f, sweepAngle, new float[]{(float) (d8 + dTan), f});
            if (dHypot2 > dTan) {
                RectF rectF3 = new RectF(0.0f, 0.0f, (float) (dHypot2 - dTan), 0.0f);
                this.renderMatrix.set(matrix);
                this.renderMatrix.preTranslate(this.operation1.f2386x, this.operation1.y);
                this.renderMatrix.preRotate(getEndAngle());
                this.renderMatrix.preTranslate((float) dTan, 0.0f);
                shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF3, i11);
            }
        }

        public float getEndAngle() {
            return (float) Math.toDegrees(Math.atan((this.operation2.y - this.operation1.y) / (this.operation2.f2386x - this.operation1.f2386x)));
        }

        public float getStartAngle() {
            return (float) Math.toDegrees(Math.atan((this.operation1.y - this.startY) / (this.operation1.f2386x - this.startX)));
        }

        public float getSweepAngle() {
            float endAngle = ((getEndAngle() - getStartAngle()) + 360.0f) % 360.0f;
            return endAngle <= ShapePath.ANGLE_LEFT ? endAngle : endAngle - 360.0f;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f, float f10) {
            this.operation = pathLineOperation;
            this.startX = f;
            this.startY = f10;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i10, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.operation.y - this.startY, this.operation.f2386x - this.startX), 0.0f);
            this.renderMatrix.set(matrix);
            this.renderMatrix.preTranslate(this.startX, this.startY);
            this.renderMatrix.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF, i10);
        }

        public float getAngle() {
            return (float) Math.toDegrees(Math.atan((this.operation.y - this.startY) / (this.operation.f2386x - this.startX)));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();

        @Deprecated
        public float bottom;

        @Deprecated
        public float left;

        @Deprecated
        public float right;

        @Deprecated
        public float startAngle;

        @Deprecated
        public float sweepAngle;

        @Deprecated
        public float top;

        public PathArcOperation(float f, float f10, float f11, float f12) {
            setLeft(f);
            setTop(f10);
            setRight(f11);
            setBottom(f12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getBottom() {
            return this.bottom;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getLeft() {
            return this.left;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getRight() {
            return this.right;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getTop() {
            return this.top;
        }

        private void setBottom(float f) {
            this.bottom = f;
        }

        private void setLeft(float f) {
            this.left = f;
        }

        private void setRight(float f) {
            this.right = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartAngle(float f) {
            this.startAngle = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSweepAngle(float f) {
            this.sweepAngle = f;
        }

        private void setTop(float f) {
            this.top = f;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float f, float f10, float f11, float f12, float f13, float f14) {
            setControlX1(f);
            setControlY1(f10);
            setControlX2(f11);
            setControlY2(f12);
            setEndX(f13);
            setEndY(f14);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float f) {
            this.controlX1 = f;
        }

        private void setControlX2(float f) {
            this.controlX2 = f;
        }

        private void setControlY1(float f) {
            this.controlY1 = f;
        }

        private void setControlY2(float f) {
            this.controlY2 = f;
        }

        private void setEndX(float f) {
            this.endX = f;
        }

        private void setEndY(float f) {
            this.endY = f;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path.transform(matrix);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PathLineOperation extends PathOperation {

        /* renamed from: x, reason: collision with root package name */
        private float f2386x;
        private float y;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f2386x, this.y);
            path.transform(matrix);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PathQuadOperation extends PathOperation {

        @Deprecated
        public float controlX;

        @Deprecated
        public float controlY;

        @Deprecated
        public float endX;

        @Deprecated
        public float endY;

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlX(float f) {
            this.controlX = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlY(float f) {
            this.controlY = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndX(float f) {
            this.endX = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndY(float f) {
            this.endY = f;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = new Matrix();
        final Matrix renderMatrix = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas);

        public final void draw(ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i10, canvas);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float f) {
        if (getCurrentShadowAngle() == f) {
            return;
        }
        float currentShadowAngle = ((f - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (currentShadowAngle > ANGLE_LEFT) {
            return;
        }
        PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        pathArcOperation.setStartAngle(getCurrentShadowAngle());
        pathArcOperation.setSweepAngle(currentShadowAngle);
        this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
        setCurrentShadowAngle(f);
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f, float f10) {
        addConnectingShadowIfNecessary(f);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f10);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float f) {
        this.currentShadowAngle = f;
    }

    private void setEndShadowAngle(float f) {
        this.endShadowAngle = f;
    }

    private void setEndX(float f) {
        this.endX = f;
    }

    private void setEndY(float f) {
        this.endY = f;
    }

    private void setStartX(float f) {
        this.startX = f;
    }

    private void setStartY(float f) {
        this.startY = f;
    }

    public void addArc(float f, float f10, float f11, float f12, float f13, float f14) {
        PathArcOperation pathArcOperation = new PathArcOperation(f, f10, f11, f12);
        pathArcOperation.setStartAngle(f13);
        pathArcOperation.setSweepAngle(f14);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f15 = f13 + f14;
        boolean z9 = f14 < 0.0f;
        if (z9) {
            f13 = (f13 + ANGLE_LEFT) % 360.0f;
        }
        addShadowCompatOperation(arcShadowOperation, f13, z9 ? (ANGLE_LEFT + f15) % 360.0f : f15);
        double d8 = f15;
        setEndX((((f11 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d8)))) + ((f + f11) * 0.5f));
        setEndY((((f12 - f10) / 2.0f) * ((float) Math.sin(Math.toRadians(d8)))) + ((f10 + f12) * 0.5f));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.operations.get(i10).applyToPath(matrix, path);
        }
    }

    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    @NonNull
    public ShadowCompatOperation createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.shadowCompatOperations);
        return new ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
            @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
            public void draw(Matrix matrix3, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ShadowCompatOperation) it.next()).draw(matrix2, shadowRenderer, i10, canvas);
                }
            }
        };
    }

    public void cubicToPoint(float f, float f10, float f11, float f12, float f13, float f14) {
        this.operations.add(new PathCubicOperation(f, f10, f11, f12, f13, f14));
        this.containsIncompatibleShadowOp = true;
        setEndX(f13);
        setEndY(f14);
    }

    public float getEndX() {
        return this.endX;
    }

    public float getEndY() {
        return this.endY;
    }

    public float getStartX() {
        return this.startX;
    }

    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float f, float f10, float f11, float f12) {
        if ((Math.abs(f - getEndX()) < 0.001f && Math.abs(f10 - getEndY()) < 0.001f) || (Math.abs(f - f11) < 0.001f && Math.abs(f10 - f12) < 0.001f)) {
            lineTo(f11, f12);
            return;
        }
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f2386x = f;
        pathLineOperation.y = f10;
        this.operations.add(pathLineOperation);
        PathLineOperation pathLineOperation2 = new PathLineOperation();
        pathLineOperation2.f2386x = f11;
        pathLineOperation2.y = f12;
        this.operations.add(pathLineOperation2);
        InnerCornerShadowOperation innerCornerShadowOperation = new InnerCornerShadowOperation(pathLineOperation, pathLineOperation2, getEndX(), getEndY());
        if (innerCornerShadowOperation.getSweepAngle() > 0.0f) {
            lineTo(f, f10);
            lineTo(f11, f12);
        } else {
            addShadowCompatOperation(innerCornerShadowOperation, innerCornerShadowOperation.getStartAngle() + ANGLE_UP, innerCornerShadowOperation.getEndAngle() + ANGLE_UP);
            setEndX(f11);
            setEndY(f12);
        }
    }

    public void quadToPoint(float f, float f10, float f11, float f12) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f);
        pathQuadOperation.setControlY(f10);
        pathQuadOperation.setEndX(f11);
        pathQuadOperation.setEndY(f12);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f11);
        setEndY(f12);
    }

    public void reset(float f, float f10, float f11, float f12) {
        setStartX(f);
        setStartY(f10);
        setEndX(f);
        setEndY(f10);
        setCurrentShadowAngle(f11);
        setEndShadowAngle((f11 + f12) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public ShapePath(float f, float f10) {
        reset(f, f10);
    }

    public void reset(float f, float f10) {
        reset(f, f10, ANGLE_UP, 0.0f);
    }

    public void lineTo(float f, float f10) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f2386x = f;
        pathLineOperation.y = f10;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f);
        setEndY(f10);
    }
}
