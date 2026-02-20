package androidx.constraintlayout.core.motion.utils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    public static CurveFit get(int i10, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i10 = 2;
        }
        return i10 != 0 ? i10 != 2 ? new LinearCurveFit(dArr, dArr2) : new Constant(dArr[0], dArr2[0]) : new MonotonicCurveFit(dArr, dArr2);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double getPos(double d8, int i10);

    public abstract void getPos(double d8, double[] dArr);

    public abstract void getPos(double d8, float[] fArr);

    public abstract double getSlope(double d8, int i10);

    public abstract void getSlope(double d8, double[] dArr);

    public abstract double[] getTimePoints();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        public Constant(double d8, double[] dArr) {
            this.mTime = d8;
            this.mValue = dArr;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void getPos(double d8, float[] fArr) {
            int i10 = 0;
            while (true) {
                double[] dArr = this.mValue;
                if (i10 >= dArr.length) {
                    return;
                }
                fArr[i10] = (float) dArr[i10];
                i10++;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void getSlope(double d8, double[] dArr) {
            for (int i10 = 0; i10 < this.mValue.length; i10++) {
                dArr[i10] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double getSlope(double d8, int i10) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void getPos(double d8, double[] dArr) {
            double[] dArr2 = this.mValue;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double getPos(double d8, int i10) {
            return this.mValue[i10];
        }
    }
}
