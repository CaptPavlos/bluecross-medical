package androidx.constraintlayout.core.motion.utils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr2[0].length;
        this.mSlopeTemp = new double[length];
        this.mT = dArr;
        this.mY = dArr2;
        if (length <= 2) {
            return;
        }
        int i10 = 0;
        double d8 = 0.0d;
        while (true) {
            double d10 = d8;
            if (i10 >= dArr.length) {
                this.mTotalLength = 0.0d;
                return;
            }
            double d11 = dArr2[i10][0];
            if (i10 > 0) {
                Math.hypot(d11 - d8, d11 - d10);
            }
            i10++;
            d8 = d11;
        }
    }

    private double getLength2D(double d8) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d8 <= dArr[0]) {
            return 0.0d;
        }
        int i10 = length - 1;
        if (d8 >= dArr[i10]) {
            return this.mTotalLength;
        }
        double dHypot = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i11 = 0;
        while (i11 < i10) {
            double[] dArr2 = this.mY[i11];
            double d12 = dArr2[0];
            double d13 = dArr2[1];
            if (i11 > 0) {
                dHypot += Math.hypot(d12 - d10, d13 - d11);
            }
            double[] dArr3 = this.mT;
            double d14 = dArr3[i11];
            if (d8 == d14) {
                return dHypot;
            }
            int i12 = i11 + 1;
            double d15 = dArr3[i12];
            if (d8 < d15) {
                double d16 = (d8 - d14) / (d15 - d14);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i11];
                double d17 = dArr5[0];
                double[] dArr6 = dArr4[i12];
                double d18 = dArr6[0];
                double d19 = 1.0d - d16;
                return Math.hypot(d13 - ((dArr6[1] * d16) + (dArr5[1] * d19)), d12 - ((d18 * d16) + (d17 * d19))) + dHypot;
            }
            i11 = i12;
            d10 = d12;
            d11 = d13;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d8, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i10 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d10 = dArr[0];
            if (d8 <= d10) {
                getSlope(d10, this.mSlopeTemp);
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) (((d8 - this.mT[0]) * this.mSlopeTemp[i11]) + this.mY[0][i11]);
                }
                return;
            }
            int i12 = length - 1;
            double d11 = dArr[i12];
            if (d8 >= d11) {
                getSlope(d11, this.mSlopeTemp);
                while (i10 < length2) {
                    fArr[i10] = (float) (((d8 - this.mT[i12]) * this.mSlopeTemp[i10]) + this.mY[i12][i10]);
                    i10++;
                }
                return;
            }
        } else {
            if (d8 <= dArr[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    fArr[i13] = (float) this.mY[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d8 >= dArr[i14]) {
                while (i10 < length2) {
                    fArr[i10] = (float) this.mY[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d8 == this.mT[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    fArr[i16] = (float) this.mY[i15][i16];
                }
            }
            double[] dArr2 = this.mT;
            int i17 = i15 + 1;
            double d12 = dArr2[i17];
            if (d8 < d12) {
                double d13 = dArr2[i15];
                double d14 = (d8 - d13) / (d12 - d13);
                while (i10 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i10] = (float) ((dArr3[i17][i10] * d14) + ((1.0d - d14) * dArr3[i15][i10]));
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[PHI: r4
      0x000f: PHI (r4v5 double) = (r4v0 double), (r4v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getSlope(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.mT
            int r1 = r0.length
            double[][] r2 = r12.mY
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r13 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = r3
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L41
            double[] r4 = r12.mT
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L3f
            r13 = r4[r0]
            double r6 = r6 - r13
        L2c:
            if (r3 >= r2) goto L41
            double[][] r13 = r12.mY
            r14 = r13[r0]
            r8 = r14[r3]
            r13 = r13[r5]
            r10 = r13[r3]
            double r10 = r10 - r8
            double r10 = r10 / r6
            r15[r3] = r10
            int r3 = r3 + 1
            goto L2c
        L3f:
            r0 = r5
            goto L1b
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, double[]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a A[PHI: r3
      0x000a: PHI (r3v4 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double getSlope(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.mT
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r8 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            int r0 = r1 + (-1)
            if (r2 >= r0) goto L35
            double[] r0 = r7.mT
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L33
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.mY
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r9 = r8[r10]
            double r9 = r9 - r0
            double r9 = r9 / r4
            return r9
        L33:
            r2 = r3
            goto L15
        L35:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, int):double");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d8, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i10 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d10 = dArr2[0];
            if (d8 <= d10) {
                getSlope(d10, this.mSlopeTemp);
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = ((d8 - this.mT[0]) * this.mSlopeTemp[i11]) + this.mY[0][i11];
                }
                return;
            }
            int i12 = length - 1;
            double d11 = dArr2[i12];
            if (d8 >= d11) {
                getSlope(d11, this.mSlopeTemp);
                while (i10 < length2) {
                    dArr[i10] = ((d8 - this.mT[i12]) * this.mSlopeTemp[i10]) + this.mY[i12][i10];
                    i10++;
                }
                return;
            }
        } else {
            if (d8 <= dArr2[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    dArr[i13] = this.mY[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d8 >= dArr2[i14]) {
                while (i10 < length2) {
                    dArr[i10] = this.mY[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d8 == this.mT[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    dArr[i16] = this.mY[i15][i16];
                }
            }
            double[] dArr3 = this.mT;
            int i17 = i15 + 1;
            double d12 = dArr3[i17];
            if (d8 < d12) {
                double d13 = dArr3[i15];
                double d14 = (d8 - d13) / (d12 - d13);
                while (i10 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i10] = (dArr4[i17][i10] * d14) + ((1.0d - d14) * dArr4[i15][i10]);
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d8, int i10) {
        double d10;
        double d11;
        double slope;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i11 = 0;
        if (this.mExtrapolate) {
            double d12 = dArr[0];
            if (d8 <= d12) {
                d10 = this.mY[0][i10];
                d11 = d8 - d12;
                slope = getSlope(d12, i10);
            } else {
                int i12 = length - 1;
                double d13 = dArr[i12];
                if (d8 >= d13) {
                    d10 = this.mY[i12][i10];
                    d11 = d8 - d13;
                    slope = getSlope(d13, i10);
                }
            }
            return (slope * d11) + d10;
        }
        if (d8 <= dArr[0]) {
            return this.mY[0][i10];
        }
        int i13 = length - 1;
        if (d8 >= dArr[i13]) {
            return this.mY[i13][i10];
        }
        while (i11 < length - 1) {
            double[] dArr2 = this.mT;
            double d14 = dArr2[i11];
            if (d8 == d14) {
                return this.mY[i11][i10];
            }
            int i14 = i11 + 1;
            double d15 = dArr2[i14];
            if (d8 < d15) {
                double d16 = (d8 - d14) / (d15 - d14);
                double[][] dArr3 = this.mY;
                return (dArr3[i14][i10] * d16) + ((1.0d - d16) * dArr3[i11][i10]);
            }
            i11 = i14;
        }
        return 0.0d;
    }
}
