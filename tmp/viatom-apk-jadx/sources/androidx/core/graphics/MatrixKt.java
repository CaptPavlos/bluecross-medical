package androidx.core.graphics;

import android.graphics.Matrix;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MatrixKt {
    public static final Matrix rotationMatrix(float f, float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f, f10, f11);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f11 = 0.0f;
        }
        return rotationMatrix(f, f10, f11);
    }

    public static final Matrix scaleMatrix(float f, float f10) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f10);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f10 = 1.0f;
        }
        return scaleMatrix(f, f10);
    }

    public static final Matrix times(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    public static final Matrix translationMatrix(float f, float f10) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f, f10);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        return translationMatrix(f, f10);
    }

    public static final float[] values(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
