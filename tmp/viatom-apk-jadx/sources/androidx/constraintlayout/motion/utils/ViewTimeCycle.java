package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class AlphaSet extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setAlpha(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ElevationSet extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setElevation(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class PathRotate extends ViewTimeCycle {
        public boolean setPathRotate(View view, KeyCache keyCache, float f, long j10, double d8, double d10) {
            view.setRotation(get(f, j10, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d10, d8))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ProgressSet extends ViewTimeCycle {
        boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            ProgressSet progressSet;
            Method method;
            if (view instanceof MotionLayout) {
                progressSet = this;
                ((MotionLayout) view).setProgress(get(f, j10, view, keyCache));
            } else {
                progressSet = this;
                if (progressSet.mNoMethod) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    progressSet.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(progressSet.get(f, j10, view, keyCache)));
                    } catch (IllegalAccessException e) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e);
                    } catch (InvocationTargetException e3) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e3);
                    }
                }
            }
            return progressSet.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class RotationSet extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setRotation(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class RotationXset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setRotationX(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class RotationYset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setRotationY(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ScaleXset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setScaleX(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ScaleYset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setScaleY(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class TranslationXset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setTranslationX(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class TranslationYset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setTranslationY(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class TranslationZset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            view.setTranslationZ(get(f, j10, view, keyCache));
            return this.mContinue;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle makeSpline(String str, long j10) {
        ViewTimeCycle rotationXset;
        str.getClass();
        switch (str) {
            case "rotationX":
                rotationXset = new RotationXset();
                break;
            case "rotationY":
                rotationXset = new RotationYset();
                break;
            case "translationX":
                rotationXset = new TranslationXset();
                break;
            case "translationY":
                rotationXset = new TranslationYset();
                break;
            case "translationZ":
                rotationXset = new TranslationZset();
                break;
            case "progress":
                rotationXset = new ProgressSet();
                break;
            case "scaleX":
                rotationXset = new ScaleXset();
                break;
            case "scaleY":
                rotationXset = new ScaleYset();
                break;
            case "rotation":
                rotationXset = new RotationSet();
                break;
            case "elevation":
                rotationXset = new ElevationSet();
                break;
            case "transitionPathRotate":
                rotationXset = new PathRotate();
                break;
            case "alpha":
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(j10);
        return rotationXset;
    }

    public float get(float f, long j10, View view, KeyCache keyCache) {
        this.mCurveFit.getPos(f, this.mCache);
        float[] fArr = this.mCache;
        float f10 = fArr[1];
        if (f10 == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.mLastCycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.mLastCycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.mLastCycle = 0.0f;
            }
        }
        float f11 = (float) (((((j10 - this.mLastTime) * 1.0E-9d) * f10) + this.mLastCycle) % 1.0d);
        this.mLastCycle = f11;
        keyCache.setFloatValue(view, this.mType, 0, f11);
        this.mLastTime = j10;
        float f12 = this.mCache[0];
        float fCalcWave = (calcWave(this.mLastCycle) * f12) + this.mCache[2];
        this.mContinue = (f12 == 0.0f && f10 == 0.0f) ? false : true;
        return fCalcWave;
    }

    public abstract boolean setProperty(View view, float f, long j10, KeyCache keyCache);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        public void setPoint(int i10, ConstraintAttribute constraintAttribute, float f, int i11, float f10) {
            this.mConstraintAttributeList.append(i10, constraintAttribute);
            this.mWaveProperties.append(i10, new float[]{f, f10});
            this.mWaveShape = Math.max(this.mWaveShape, i11);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j10, KeyCache keyCache) {
            this.mCurveFit.getPos(f, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f10 = fArr[fArr.length - 2];
            float f11 = fArr[fArr.length - 1];
            long j11 = j10 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(view, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f12 = (float) ((((j11 * 1.0E-9d) * f10) + this.mLastCycle) % 1.0d);
            this.mLastCycle = f12;
            this.mLastTime = j10;
            float fCalcWave = calcWave(f12);
            this.mContinue = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z9 = this.mContinue;
                float f13 = this.mTempValues[i10];
                this.mContinue = z9 | (((double) f13) != 0.0d);
                fArr2[i10] = (f13 * fCalcWave) + f11;
                i10++;
            }
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mCache);
            if (f10 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i10) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i11 = iNumberOfInterpolatedValues + 2;
            this.mTempValues = new float[i11];
            this.mCache = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i11);
            for (int i12 = 0; i12 < size; i12++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i12);
                ConstraintAttribute constraintAttributeValueAt = this.mConstraintAttributeList.valueAt(i12);
                float[] fArrValueAt = this.mWaveProperties.valueAt(i12);
                dArr[i12] = iKeyAt * 0.01d;
                constraintAttributeValueAt.getValuesToInterpolate(this.mTempValues);
                int i13 = 0;
                while (true) {
                    if (i13 < this.mTempValues.length) {
                        dArr2[i12][i13] = r8[i13];
                        i13++;
                    }
                }
                double[] dArr3 = dArr2[i12];
                dArr3[iNumberOfInterpolatedValues] = fArrValueAt[0];
                dArr3[iNumberOfInterpolatedValues + 1] = fArrValueAt[1];
            }
            this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i10, float f, float f10, int i11, float f11) {
            throw new RuntimeException("Wrong call for custom attribute");
        }
    }
}
