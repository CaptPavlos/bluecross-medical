package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f, float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f10, float f11, float f12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f10, float f11, float f12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f, float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f, float f10, float f11) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f10, float f11, float f12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f10, float f11, float f12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f, float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i10, float[] fArr2, int i11, int i12) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f, float f10, float f11) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f10, float f11, float f12) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f10, float f11, float f12) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f10, float f11, float f12) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f, float f10) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f10) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f10) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f10) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f10) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f10) {
            oops();
            return false;
        }
    };

    private MatrixUtils() {
    }
}
