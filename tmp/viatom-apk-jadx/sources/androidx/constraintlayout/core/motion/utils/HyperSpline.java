package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Cubic {
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d8, double d10, double d11, double d12) {
            this.mA = d8;
            this.mB = d10;
            this.mC = d11;
            this.mD = d12;
        }

        public double eval(double d8) {
            return (((((this.mD * d8) + this.mC) * d8) + this.mB) * d8) + this.mA;
        }

        public double vel(double d8) {
            return (((this.mC * 2.0d) + (this.mD * 3.0d * d8)) * d8) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i10, double[] dArr) {
        double[] dArr2 = new double[i10];
        double[] dArr3 = new double[i10];
        double[] dArr4 = new double[i10];
        int i11 = i10 - 1;
        int i12 = 0;
        dArr2[0] = 0.5d;
        int i13 = 1;
        for (int i14 = 1; i14 < i11; i14++) {
            dArr2[i14] = 1.0d / (4.0d - dArr2[i14 - 1]);
        }
        int i15 = i10 - 2;
        dArr2[i11] = 1.0d / (2.0d - dArr2[i15]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i13 < i11) {
            int i16 = i13 + 1;
            int i17 = i13 - 1;
            dArr3[i13] = (((dArr[i16] - dArr[i17]) * 3.0d) - dArr3[i17]) * dArr2[i13];
            i13 = i16;
        }
        double d8 = (((dArr[i11] - dArr[i15]) * 3.0d) - dArr3[i15]) * dArr2[i11];
        dArr3[i11] = d8;
        dArr4[i11] = d8;
        while (i15 >= 0) {
            dArr4[i15] = dArr3[i15] - (dArr2[i15] * dArr4[i15 + 1]);
            i15--;
        }
        Cubic[] cubicArr = new Cubic[i11];
        while (i12 < i11) {
            double d10 = dArr[i12];
            double d11 = dArr4[i12];
            int i18 = i12 + 1;
            double d12 = dArr[i18];
            double d13 = dArr4[i18];
            cubicArr[i12] = new Cubic((float) d10, d11, (((d12 - d10) * 3.0d) - (d11 * 2.0d)) - d13, ((d10 - d12) * 2.0d) + d11 + d13);
            i12 = i18;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i10;
        int length = cubicArr.length;
        double[] dArr = new double[length];
        double d8 = 0.0d;
        double d10 = 0.0d;
        double dSqrt = 0.0d;
        while (true) {
            i10 = 0;
            if (d10 >= 1.0d) {
                break;
            }
            double d11 = 0.0d;
            while (i10 < length) {
                double d12 = dArr[i10];
                double dEval = cubicArr[i10].eval(d10);
                dArr[i10] = dEval;
                double d13 = d12 - dEval;
                d11 += d13 * d13;
                i10++;
            }
            if (d10 > 0.0d) {
                dSqrt += Math.sqrt(d11);
            }
            d10 += 0.1d;
        }
        while (i10 < length) {
            double d14 = dArr[i10];
            double dEval2 = cubicArr[i10].eval(1.0d);
            dArr[i10] = dEval2;
            double d15 = d14 - dEval2;
            d8 += d15 * d15;
            i10++;
        }
        return Math.sqrt(d8) + dSqrt;
    }

    public void getPos(double d8, float[] fArr) {
        double d10 = d8 * this.mTotalLength;
        int i10 = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i10 >= dArr.length - 1) {
                break;
            }
            double d11 = dArr[i10];
            if (d11 >= d10) {
                break;
            }
            d10 -= d11;
            i10++;
        }
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr[i11] = (float) this.mCurve[i11][i10].eval(d10 / this.mCurveLength[i10]);
        }
    }

    public void getVelocity(double d8, double[] dArr) {
        double d10 = d8 * this.mTotalLength;
        int i10 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i10 >= dArr2.length - 1) {
                break;
            }
            double d11 = dArr2[i10];
            if (d11 >= d10) {
                break;
            }
            d10 -= d11;
            i10++;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr[i11] = this.mCurve[i11][i10].vel(d10 / this.mCurveLength[i10]);
        }
    }

    public void setup(double[][] dArr) {
        int i10;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i11 = 0; i11 < this.mDimensionality; i11++) {
            for (int i12 = 0; i12 < this.mPoints; i12++) {
                this.mCtl[i11][i12] = dArr[i12][i11];
            }
        }
        int i13 = 0;
        while (true) {
            i10 = this.mDimensionality;
            if (i13 >= i10) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i13];
            cubicArr[i13] = calcNaturalCubic(dArr2.length, dArr2);
            i13++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i10];
        for (int i14 = 0; i14 < this.mCurveLength.length; i14++) {
            for (int i15 = 0; i15 < this.mDimensionality; i15++) {
                cubicArr2[i15] = this.mCurve[i15][i14];
            }
            double d8 = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double dApproxLength = approxLength(cubicArr2);
            dArr3[i14] = dApproxLength;
            this.mTotalLength = d8 + dApproxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d8, double[] dArr) {
        double d10 = d8 * this.mTotalLength;
        int i10 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i10 >= dArr2.length - 1) {
                break;
            }
            double d11 = dArr2[i10];
            if (d11 >= d10) {
                break;
            }
            d10 -= d11;
            i10++;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr[i11] = this.mCurve[i11][i10].eval(d10 / this.mCurveLength[i10]);
        }
    }

    public double getPos(double d8, int i10) {
        double[] dArr;
        double d10 = d8 * this.mTotalLength;
        int i11 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i11 >= dArr.length - 1) {
                break;
            }
            double d11 = dArr[i11];
            if (d11 >= d10) {
                break;
            }
            d10 -= d11;
            i11++;
        }
        return this.mCurve[i10][i11].eval(d10 / dArr[i11]);
    }
}
