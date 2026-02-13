package androidx.constraintlayout.core.motion.utils;

import a3.a;
import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class CoreSpline extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public CoreSpline(String str) {
            this.mType = str;
            this.mTypeId = a.b(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.mTypeId, get(f));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffsetArr;
        private final int mOffst;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        private final int mPhase;
        float[] mPhaseArr;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        private final int mValue;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public CycleOscillator(int i10, String str, int i11, int i12) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.mOffst = 0;
            this.mPhase = 1;
            this.mValue = 2;
            this.mWaveShape = i10;
            this.mVariesBy = i11;
            oscillator.setType(i10, str);
            this.mValues = new float[i12];
            this.mPosition = new double[i12];
            this.mPeriod = new float[i12];
            this.mOffsetArr = new float[i12];
            this.mPhaseArr = new float[i12];
            this.mScale = new float[i12];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f) {
            CurveFit curveFit = this.mCurveFit;
            double[] dArr = this.mSplineSlopeCache;
            if (curveFit != null) {
                double d8 = f;
                curveFit.getSlope(d8, dArr);
                this.mCurveFit.getPos(d8, this.mSplineValueCache);
            } else {
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d10 = f;
            double value = this.mOscillator.getValue(d10, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d10, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return (slope * this.mSplineValueCache[2]) + (value * dArr2[2]) + dArr2[0];
        }

        public double getValues(float f) {
            CurveFit curveFit = this.mCurveFit;
            double[] dArr = this.mSplineValueCache;
            if (curveFit != null) {
                curveFit.getPos(f, dArr);
            } else {
                dArr[0] = this.mOffsetArr[0];
                dArr[1] = this.mPhaseArr[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return (this.mOscillator.getValue(f, dArr2[1]) * this.mSplineValueCache[2]) + dArr2[0];
        }

        public void setPoint(int i10, int i11, float f, float f10, float f11, float f12) {
            this.mPosition[i10] = i11 / 100.0d;
            this.mPeriod[i10] = f;
            this.mOffsetArr[i10] = f10;
            this.mPhaseArr[i10] = f11;
            this.mValues[i10] = f12;
        }

        public void setup(float f) {
            this.mPathLength = f;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i10 = 0; i10 < dArr.length; i10++) {
                double[] dArr3 = dArr[i10];
                dArr3[0] = this.mOffsetArr[i10];
                dArr3[1] = this.mPhaseArr[i10];
                dArr3[2] = this.mValues[i10];
                this.mOscillator.addPoint(this.mPosition[i10], this.mPeriod[i10]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PathRotateSet extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public PathRotateSet(String str) {
            this.mType = str;
            this.mTypeId = a.b(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f, double d8, double d10) {
            motionWidget.setRotationZ(get(f) + ((float) Math.toDegrees(Math.atan2(d10, d8))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.mTypeId, get(f));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        public WavePoint(int i10, float f, float f10, float f11, float f12) {
            this.mPosition = i10;
            this.mValue = f12;
            this.mOffset = f10;
            this.mPeriod = f;
            this.mPhase = f11;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float get(float f) {
        return (float) this.mCycleOscillator.getValues(f);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCycleOscillator.getSlope(f);
    }

    public void setPoint(int i10, int i11, String str, int i12, float f, float f10, float f11, float f12, Object obj) {
        this.mWavePoints.add(new WavePoint(i10, f, f10, f11, f12));
        if (i12 != -1) {
            this.mVariesBy = i12;
        }
        this.mWaveShape = i11;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        char c10 = 2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size2 = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size2) {
            int i12 = i10 + 1;
            WavePoint wavePoint = arrayList.get(i10);
            float f10 = wavePoint.mPeriod;
            dArr[i11] = f10 * 0.01d;
            double[] dArr3 = dArr2[i11];
            float f11 = wavePoint.mValue;
            dArr3[0] = f11;
            float f12 = wavePoint.mOffset;
            char c11 = c10;
            dArr3[1] = f12;
            float f13 = wavePoint.mPhase;
            dArr3[c11] = f13;
            this.mCycleOscillator.setPoint(i11, wavePoint.mPosition, f10, f12, f13, f11);
            i11++;
            i10 = i12;
            c10 = c11;
            dArr2 = dArr2;
        }
        this.mCycleOscillator.setup(f);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            WavePoint wavePoint = arrayList.get(i10);
            i10++;
            StringBuilder sbW = a.w(string, "[");
            sbW.append(wavePoint.mPosition);
            sbW.append(" , ");
            sbW.append(decimalFormat.format(r5.mValue));
            sbW.append("] ");
            string = sbW.toString();
        }
        return string;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setCustom(Object obj) {
    }

    public void setPoint(int i10, int i11, String str, int i12, float f, float f10, float f11, float f12) {
        this.mWavePoints.add(new WavePoint(i10, f, f10, f11, f12));
        if (i12 != -1) {
            this.mVariesBy = i12;
        }
        this.mWaveShape = i11;
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f) {
    }
}
