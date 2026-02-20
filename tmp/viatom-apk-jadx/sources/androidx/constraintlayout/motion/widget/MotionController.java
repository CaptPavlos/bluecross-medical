package androidx.constraintlayout.motion.widget;

import a3.a;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class MotionController {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    String[] mAttributeTable;
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, ViewOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    View mView;
    Rect mTempRect = new Rect();
    boolean mForceMeasure = false;
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int mMaxDimension = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<Key> mKeyList = new ArrayList<>();

    public MotionController(View view) {
        int i10 = Key.UNSET;
        this.mPathMotionArc = i10;
        this.mTransformPivotTarget = i10;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i10;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        float f10 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f11 = this.mStaggerScale;
            if (f11 != 1.0d) {
                float f12 = this.mStaggerOffset;
                if (f < f12) {
                    f = 0.0f;
                }
                if (f > f12 && f < 1.0d) {
                    f = Math.min((f - f12) * f11, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        float f13 = Float.NaN;
        int i10 = 0;
        while (i10 < size) {
            MotionPaths motionPaths = arrayList.get(i10);
            i10++;
            MotionPaths motionPaths2 = motionPaths;
            Easing easing2 = motionPaths2.mKeyFrameEasing;
            if (easing2 != null) {
                float f14 = motionPaths2.mTime;
                if (f14 < f) {
                    easing = easing2;
                    f10 = f14;
                } else if (Float.isNaN(f13)) {
                    f13 = motionPaths2.mTime;
                }
            }
        }
        if (easing != null) {
            float f15 = (Float.isNaN(f13) ? 1.0f : f13) - f10;
            double d8 = (f - f10) / f15;
            f = (((float) easing.get(d8)) * f15) + f10;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d8);
            }
        }
        return f;
    }

    private static Interpolator getInterpolator(Context context, int i10, String str, int i11) {
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(context, i11);
        }
        if (i10 == -1) {
            final Easing interpolator = Easing.getInterpolator(str);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    return (float) interpolator.get(f);
                }
            };
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f = 1.0f / 99;
        double d8 = 0.0d;
        double d10 = 0.0d;
        int i10 = 0;
        float fHypot = 0.0f;
        while (i10 < 100) {
            float f10 = i10 * f;
            double d11 = f10;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f11 = Float.NaN;
            int i11 = 0;
            float f12 = 0.0f;
            while (i11 < size) {
                MotionPaths motionPaths = arrayList.get(i11);
                i11++;
                MotionPaths motionPaths2 = motionPaths;
                float f13 = f;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f14 = motionPaths2.mTime;
                    if (f14 < f10) {
                        f12 = f14;
                        easing = easing2;
                    } else if (Float.isNaN(f11)) {
                        f11 = motionPaths2.mTime;
                    }
                }
                f = f13;
            }
            float f15 = f;
            if (easing != null) {
                if (Float.isNaN(f11)) {
                    f11 = 1.0f;
                }
                d11 = (((float) easing.get((f10 - f12) / r17)) * (f11 - f12)) + f12;
            }
            double d12 = d11;
            this.mSpline[0].getPos(d12, this.mInterpolateData);
            int i12 = i10;
            this.mStartMotionPath.getCenter(d12, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i12 > 0) {
                fHypot += (float) Math.hypot(d10 - fArr[1], d8 - fArr[0]);
            }
            d8 = fArr[0];
            d10 = fArr[1];
            i10 = i12 + 1;
            f = f15;
        }
        return fHypot;
    }

    private void insertKey(MotionPaths motionPaths) {
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            Log.e(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i10) {
        float f = 1.0f;
        float f10 = 1.0f / (i10 - 1);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, ViewOscillator> map3 = this.mCycleMap;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            map4.get("translationY");
        }
        int i11 = 0;
        while (i11 < i10) {
            float fMin = i11 * f10;
            float f11 = this.mStaggerScale;
            float f12 = 0.0f;
            if (f11 != f) {
                float f13 = this.mStaggerOffset;
                if (fMin < f13) {
                    fMin = 0.0f;
                }
                if (fMin > f13 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f13) * f11, f);
                }
            }
            double d8 = fMin;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f14 = Float.NaN;
            int i12 = 0;
            while (i12 < size) {
                MotionPaths motionPaths = arrayList.get(i12);
                i12++;
                MotionPaths motionPaths2 = motionPaths;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f15 = motionPaths2.mTime;
                    if (f15 < fMin) {
                        easing = easing2;
                        f12 = f15;
                    } else if (Float.isNaN(f14)) {
                        f14 = motionPaths2.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                d8 = (((float) easing.get((fMin - f12) / r13)) * (f14 - f12)) + f12;
            }
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d8, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i11 * 2);
            i11++;
            f = 1.0f;
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                MotionPaths motionPaths = arrayList.get(i11);
                i11++;
                iArr[i10] = motionPaths.mMode;
                i10++;
            }
        }
        int i12 = 0;
        for (double d8 : timePoints) {
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i12);
            i12 += 2;
        }
        return i12 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                MotionPaths motionPaths = arrayList.get(i11);
                i11++;
                iArr[i10] = motionPaths.mMode;
                i10++;
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < timePoints.length; i13++) {
            this.mSpline[0].getPos(timePoints[i13], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i13], this.mInterpolateVariables, this.mInterpolateData, fArr, i12);
            i12 += 2;
        }
        return i12 / 2;
    }

    public void buildPath(float[] fArr, int i10) {
        int i11 = i10;
        float f = 1.0f;
        float f10 = 1.0f / (i11 - 1);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        ViewSpline viewSpline = map == null ? null : map.get("translationX");
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        ViewSpline viewSpline2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, ViewOscillator> map3 = this.mCycleMap;
        ViewOscillator viewOscillator = map3 == null ? null : map3.get("translationX");
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        ViewOscillator viewOscillator2 = map4 != null ? map4.get("translationY") : null;
        int i12 = 0;
        while (i12 < i11) {
            float fMin = i12 * f10;
            float f11 = this.mStaggerScale;
            float f12 = 0.0f;
            if (f11 != f) {
                float f13 = this.mStaggerOffset;
                if (fMin < f13) {
                    fMin = 0.0f;
                }
                if (fMin > f13 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f13) * f11, f);
                }
            }
            double d8 = fMin;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f14 = Float.NaN;
            int i13 = 0;
            while (i13 < size) {
                MotionPaths motionPaths = arrayList.get(i13);
                i13++;
                MotionPaths motionPaths2 = motionPaths;
                float f15 = f10;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f16 = motionPaths2.mTime;
                    if (f16 < fMin) {
                        f12 = f16;
                        easing = easing2;
                    } else if (Float.isNaN(f14)) {
                        f14 = motionPaths2.mTime;
                    }
                }
                f10 = f15;
            }
            float f17 = f10;
            if (easing != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                d8 = (((float) easing.get((fMin - f12) / r17)) * (f14 - f12)) + f12;
            }
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d8, dArr);
                }
            }
            int i14 = i12 * 2;
            this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, this.mInterpolateData, fArr, i14);
            if (viewOscillator != null) {
                fArr[i14] = viewOscillator.get(fMin) + fArr[i14];
            } else if (viewSpline != null) {
                fArr[i14] = viewSpline.get(fMin) + fArr[i14];
            }
            if (viewOscillator2 != null) {
                int i15 = i14 + 1;
                fArr[i15] = viewOscillator2.get(fMin) + fArr[i15];
            } else if (viewSpline2 != null) {
                int i16 = i14 + 1;
                fArr[i16] = viewSpline2.get(fMin) + fArr[i16];
            }
            i12++;
            i11 = i10;
            f10 = f17;
            f = 1.0f;
        }
    }

    public void buildRect(float f, float[] fArr, int i10) {
        this.mSpline[0].getPos(getAdjustedPosition(f, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i10);
    }

    public void buildRectangles(float[] fArr, int i10) {
        float f = 1.0f / (i10 - 1);
        for (int i11 = 0; i11 < i10; i11++) {
            this.mSpline[0].getPos(getAdjustedPosition(i11 * f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i11 * 8);
        }
    }

    public void endTrigger(boolean z9) {
        if (!"button".equals(Debug.getName(this.mView)) || this.mKeyTriggers == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
            if (i10 >= keyTriggerArr.length) {
                return;
            }
            keyTriggerArr[i10].conditionallyFire(z9 ? -100.0f : 100.0f, this.mView);
            i10++;
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i10) {
        ViewSpline viewSpline = this.mAttributesMap.get(str);
        if (viewSpline == null) {
            return -1;
        }
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr[i11] = viewSpline.get(i11 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d8, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d8, dArr);
        this.mSpline[0].getSlope(d8, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f, float f10, float f11, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i10 = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f12 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f13 = f12 - motionPaths2.mX;
            float f14 = motionPaths.mY - motionPaths2.mY;
            float f15 = motionPaths.mWidth - motionPaths2.mWidth;
            float f16 = (motionPaths.mHeight - motionPaths2.mHeight) + f14;
            fArr[0] = ((f15 + f13) * f10) + ((1.0f - f10) * f13);
            fArr[1] = (f16 * f11) + ((1.0f - f11) * f14);
            return;
        }
        double d8 = adjustedPosition;
        curveFitArr[0].getSlope(d8, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d8, this.mInterpolateData);
        float f17 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i10 >= dArr.length) {
                break;
            }
            dArr[i10] = dArr[i10] * f17;
            i10++;
        }
        CurveFit curveFit = this.mArcSpline;
        if (curveFit == null) {
            this.mStartMotionPath.setDpDt(f10, f11, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            curveFit.getPos(d8, dArr2);
            this.mArcSpline.getSlope(d8, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f10, f11, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int iMax = this.mStartMotionPath.mDrawPath;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            MotionPaths motionPaths = arrayList.get(i10);
            i10++;
            iMax = Math.max(iMax, motionPaths.mDrawPath);
        }
        return Math.max(iMax, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.mHeight;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.mWidth;
    }

    public float getFinalX() {
        return this.mEndMotionPath.mX;
    }

    public float getFinalY() {
        return this.mEndMotionPath.mY;
    }

    public MotionPaths getKeyFrame(int i10) {
        return this.mMotionPaths.get(i10);
    }

    public int getKeyFrameInfo(int i10, int[] iArr) {
        float[] fArr = new float[2];
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < size) {
            int i14 = i11 + 1;
            Key key = arrayList.get(i11);
            int i15 = key.mType;
            if (i15 == i10 || i10 != -1) {
                iArr[i13] = 0;
                iArr[i13 + 1] = i15;
                int i16 = key.mFramePosition;
                iArr[i13 + 2] = i16;
                double d8 = i16 / 100.0f;
                this.mSpline[0].getPos(d8, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i13 + 3] = Float.floatToIntBits(fArr[0]);
                int i17 = i13 + 4;
                iArr[i17] = Float.floatToIntBits(fArr[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    iArr[i13 + 5] = keyPosition.mPositionType;
                    iArr[i13 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i17 = i13 + 7;
                    iArr[i17] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i18 = i17 + 1;
                iArr[i13] = i18 - i13;
                i12++;
                i13 = i18;
            }
            i11 = i14;
        }
        return i12;
    }

    public float getKeyFrameParameter(int i10, float f, float f10) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f11 = motionPaths.mX;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f12 = motionPaths2.mX;
        float f13 = f11 - f12;
        float f14 = motionPaths.mY;
        float f15 = motionPaths2.mY;
        float f16 = f14 - f15;
        float f17 = (motionPaths2.mWidth / 2.0f) + f12;
        float f18 = (motionPaths2.mHeight / 2.0f) + f15;
        float fHypot = (float) Math.hypot(f13, f16);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f19 = f - f17;
        float f20 = f10 - f18;
        if (((float) Math.hypot(f19, f20)) == 0.0f) {
            return 0.0f;
        }
        float f21 = (f20 * f16) + (f19 * f13);
        if (i10 == 0) {
            return f21 / fHypot;
        }
        if (i10 == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f21 * f21));
        }
        if (i10 == 2) {
            return f19 / f13;
        }
        if (i10 == 3) {
            return f20 / f13;
        }
        if (i10 == 4) {
            return f19 / f16;
        }
        if (i10 != 5) {
            return 0.0f;
        }
        return f20 / f16;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            int i13 = i11 + 1;
            Key key = arrayList.get(i11);
            int i14 = key.mFramePosition;
            iArr[i10] = (key.mType * 1000) + i14;
            double d8 = i14 / 100.0f;
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, this.mInterpolateData, fArr, i12);
            i12 += 2;
            i11 = i13;
            i10++;
        }
        return i10;
    }

    public double[] getPos(double d8) {
        this.mSpline[0].getPos(d8, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d8, dArr);
            }
        }
        return this.mInterpolateData;
    }

    public KeyPositionBase getPositionKeyframe(int i10, int i11, float f, float f10) {
        int i12;
        int i13;
        float f11;
        float f12;
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f13 = motionPaths.mX;
        rectF.left = f13;
        float f14 = motionPaths.mY;
        rectF.top = f14;
        rectF.right = f13 + motionPaths.mWidth;
        rectF.bottom = f14 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f15 = motionPaths2.mX;
        rectF2.left = f15;
        float f16 = motionPaths2.mY;
        rectF2.top = f16;
        rectF2.right = f15 + motionPaths2.mWidth;
        rectF2.bottom = f16 + motionPaths2.mHeight;
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i14 = 0;
        while (i14 < size) {
            int i15 = i14 + 1;
            Key key = arrayList.get(i14);
            if (key instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) key;
                i12 = i10;
                i13 = i11;
                f11 = f;
                f12 = f10;
                if (keyPositionBase.intersects(i12, i13, rectF, rectF2, f11, f12)) {
                    return keyPositionBase;
                }
            } else {
                i12 = i10;
                i13 = i11;
                f11 = f;
                f12 = f10;
            }
            i10 = i12;
            i11 = i13;
            f = f11;
            f10 = f12;
            i14 = i15;
        }
        return null;
    }

    public void getPostLayoutDvDp(float f, int i10, int i11, float f10, float f11, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        ViewSpline viewSpline = map == null ? null : map.get("translationX");
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        ViewSpline viewSpline2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, ViewSpline> map3 = this.mAttributesMap;
        ViewSpline viewSpline3 = map3 == null ? null : map3.get(Key.ROTATION);
        HashMap<String, ViewSpline> map4 = this.mAttributesMap;
        ViewSpline viewSpline4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, ViewSpline> map5 = this.mAttributesMap;
        ViewSpline viewSpline5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, ViewOscillator> map6 = this.mCycleMap;
        ViewOscillator viewOscillator = map6 == null ? null : map6.get("translationX");
        HashMap<String, ViewOscillator> map7 = this.mCycleMap;
        ViewOscillator viewOscillator2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, ViewOscillator> map8 = this.mCycleMap;
        ViewOscillator viewOscillator3 = map8 == null ? null : map8.get(Key.ROTATION);
        HashMap<String, ViewOscillator> map9 = this.mCycleMap;
        ViewOscillator viewOscillator4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, ViewOscillator> map10 = this.mCycleMap;
        ViewOscillator viewOscillator5 = map10 != null ? map10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
        velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d8 = adjustedPosition;
                curveFit.getPos(d8, dArr);
                this.mArcSpline.getSlope(d8, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f10, f11, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f10, f11, i10, i11, fArr);
            return;
        }
        int i12 = 0;
        if (this.mSpline == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f12 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f13 = f12 - motionPaths2.mX;
            float f14 = motionPaths.mY - motionPaths2.mY;
            float f15 = motionPaths.mWidth - motionPaths2.mWidth;
            float f16 = f14 + (motionPaths.mHeight - motionPaths2.mHeight);
            fArr[0] = ((f15 + f13) * f10) + ((1.0f - f10) * f13);
            fArr[1] = (f16 * f11) + ((1.0f - f11) * f14);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
            velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f10, f11, i10, i11, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
        float f17 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i12 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f10, f11, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                velocityMatrix.applyTransform(f10, f11, i10, i11, fArr);
                return;
            } else {
                dArr2[i12] = dArr2[i12] * f17;
                i12++;
            }
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.mHeight;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.mWidth;
    }

    public float getStartX() {
        return this.mStartMotionPath.mX;
    }

    public float getStartY() {
        return this.mStartMotionPath.mY;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public View getView() {
        return this.mView;
    }

    public boolean interpolate(View view, float f, long j10, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean pathRotate2;
        View view2;
        View view3;
        float f10;
        float f11;
        double d8;
        View view4 = view;
        float adjustedPosition = getAdjustedPosition(f, null);
        int i10 = this.mQuantizeMotionSteps;
        if (i10 != Key.UNSET) {
            float f12 = 1.0f / i10;
            float fFloor = ((float) Math.floor(adjustedPosition / f12)) * f12;
            float f13 = (adjustedPosition % f12) / f12;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f13 = (f13 + this.mQuantizeMotionPhase) % 1.0f;
            }
            Interpolator interpolator = this.mQuantizeMotionInterpolator;
            adjustedPosition = ((interpolator != null ? interpolator.getInterpolation(f13) : ((double) f13) > 0.5d ? 1.0f : 0.0f) * f12) + fFloor;
        }
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        if (map != null) {
            Iterator<ViewSpline> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view4, adjustedPosition);
            }
        }
        HashMap<String, ViewTimeCycle> map2 = this.mTimeCycleAttributesMap;
        if (map2 != null) {
            ViewTimeCycle.PathRotate pathRotate3 = null;
            boolean property = false;
            for (ViewTimeCycle viewTimeCycle : map2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate3 = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    property |= viewTimeCycle.setProperty(view4, adjustedPosition, j10, keyCache);
                    view4 = view;
                }
            }
            pathRotate2 = property;
            pathRotate = pathRotate3;
        } else {
            pathRotate = null;
            pathRotate2 = false;
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d10 = adjustedPosition;
            curveFitArr[0].getPos(d10, this.mInterpolateData);
            this.mSpline[0].getSlope(d10, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d10, dArr);
                    this.mArcSpline.getSlope(d10, this.mInterpolateVelocity);
                }
            }
            if (this.mNoMovement) {
                view3 = view;
                f10 = 1.0f;
                f11 = 0.0f;
                d8 = d10;
            } else {
                float f14 = adjustedPosition;
                f10 = 1.0f;
                d8 = d10;
                f11 = 0.0f;
                this.mStartMotionPath.setView(f14, view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
                adjustedPosition = f14;
                view3 = view;
                this.mForceMeasure = false;
            }
            if (this.mTransformPivotTarget != Key.UNSET) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = ((View) view3.getParent()).findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float bottom = (this.mTransformPivotView.getBottom() + r1.getTop()) / 2.0f;
                    float right = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
                    if (view3.getRight() - view3.getLeft() > 0 && view3.getBottom() - view3.getTop() > 0) {
                        view3.setPivotX(right - view3.getLeft());
                        view3.setPivotY(bottom - view3.getTop());
                    }
                }
            }
            HashMap<String, ViewSpline> map3 = this.mAttributesMap;
            if (map3 != null) {
                for (ViewSpline viewSpline : map3.values()) {
                    if (viewSpline instanceof ViewSpline.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        if (dArr2.length > 1) {
                            ((ViewSpline.PathRotate) viewSpline).setPathRotate(view3, adjustedPosition, dArr2[0], dArr2[1]);
                        }
                    }
                    view3 = view;
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                view2 = view;
                float f15 = adjustedPosition;
                adjustedPosition = f15;
                pathRotate2 |= pathRotate.setPathRotate(view2, keyCache, f15, j10, dArr3[0], dArr3[1]);
            } else {
                view2 = view;
            }
            int i11 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i11 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i11].getPos(d8, this.mValuesBuff);
                CustomSupport.setInterpolatedValue(this.mStartMotionPath.mAttributes.get(this.mAttributeNames[i11 - 1]), view2, this.mValuesBuff);
                i11++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (adjustedPosition <= f11) {
                    view2.setVisibility(motionConstrainedPoint.mVisibility);
                } else {
                    MotionConstrainedPoint motionConstrainedPoint2 = this.mEndPoint;
                    if (adjustedPosition >= f10) {
                        view2.setVisibility(motionConstrainedPoint2.mVisibility);
                    } else if (motionConstrainedPoint2.mVisibility != motionConstrainedPoint.mVisibility) {
                        view2.setVisibility(0);
                    }
                }
            }
            if (this.mKeyTriggers != null) {
                int i12 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i12 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i12].conditionallyFire(adjustedPosition, view2);
                    i12++;
                }
            }
        } else {
            view2 = view;
            MotionPaths motionPaths = this.mStartMotionPath;
            float f16 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float fD = a.d(motionPaths2.mX, f16, adjustedPosition, f16);
            float f17 = motionPaths.mY;
            float fD2 = a.d(motionPaths2.mY, f17, adjustedPosition, f17);
            float f18 = motionPaths.mWidth;
            float f19 = motionPaths2.mWidth;
            float fD3 = a.d(f19, f18, adjustedPosition, f18);
            float f20 = motionPaths.mHeight;
            float f21 = motionPaths2.mHeight;
            float f22 = fD + 0.5f;
            int i13 = (int) f22;
            float f23 = fD2 + 0.5f;
            int i14 = (int) f23;
            int i15 = (int) (f22 + fD3);
            int iD = (int) (f23 + a.d(f21, f20, adjustedPosition, f20));
            int i16 = i15 - i13;
            int i17 = iD - i14;
            if (f19 != f18 || f21 != f20 || this.mForceMeasure) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i16, 1073741824), View.MeasureSpec.makeMeasureSpec(i17, 1073741824));
                this.mForceMeasure = false;
            }
            view2.layout(i13, i14, i15, iD);
        }
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            for (ViewOscillator viewOscillator : map4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((ViewOscillator.PathRotateSet) viewOscillator).setPathRotate(view2, adjustedPosition, dArr4[0], dArr4[1]);
                } else {
                    viewOscillator.setProperty(view2, adjustedPosition);
                }
            }
        }
        return pathRotate2;
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f, float f10, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f11 = motionPaths.mX;
        rectF.left = f11;
        float f12 = motionPaths.mY;
        rectF.top = f12;
        rectF.right = f11 + motionPaths.mWidth;
        rectF.bottom = f12 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f13 = motionPaths2.mX;
        rectF2.left = f13;
        float f14 = motionPaths2.mY;
        rectF2.top = f14;
        rectF2.right = f13 + motionPaths2.mWidth;
        rectF2.bottom = f14 + motionPaths2.mHeight;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f10, strArr, fArr);
    }

    public void remeasure() {
        this.mForceMeasure = true;
    }

    public void rotate(Rect rect, Rect rect2, int i10, int i11, int i12) {
        if (i10 == 1) {
            int i13 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i12 - ((rect.height() + i13) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i10 == 2) {
            int i14 = rect.left + rect.right;
            rect2.left = i11 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i14 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i10 == 3) {
            int i15 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i15 / 2);
            rect2.top = i12 - ((rect.height() + i15) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i10 != 4) {
            return;
        }
        int i16 = rect.left + rect.right;
        rect2.left = i11 - ((rect.width() + (rect.bottom + rect.top)) / 2);
        rect2.top = (i16 - rect.height()) / 2;
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    public void setBothStates(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i10) {
        this.mStartMotionPath.mDrawPath = i10;
    }

    public void setEndState(Rect rect, ConstraintSet constraintSet, int i10, int i11) {
        MotionController motionController;
        int i12 = constraintSet.mRotate;
        if (i12 != 0) {
            motionController = this;
            motionController.rotate(rect, this.mTempRect, i12, i10, i11);
            rect = motionController.mTempRect;
        } else {
            motionController = this;
        }
        MotionPaths motionPaths = motionController.mEndMotionPath;
        motionPaths.mTime = 1.0f;
        motionPaths.mPosition = 1.0f;
        readView(motionPaths);
        motionController.mEndMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        motionController.mEndMotionPath.applyParameters(constraintSet.getParameters(motionController.mId));
        motionController.mEndPoint.setState(rect, constraintSet, i12, motionController.mId);
    }

    public void setPathMotionArc(int i10) {
        this.mPathMotionArc = i10;
    }

    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ViewState viewState, View view, int i10, int i11, int i12) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        Rect rect = new Rect();
        if (i10 == 1) {
            int i13 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i11 - ((viewState.height() + i13) / 2);
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        } else if (i10 == 2) {
            int i14 = viewState.left + viewState.right;
            rect.left = i12 - ((viewState.width() + (viewState.top + viewState.bottom)) / 2);
            rect.top = (i14 - viewState.height()) / 2;
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, view, i10, viewState.rotation);
    }

    public void setTransformPivotTarget(int i10) {
        this.mTransformPivotTarget = i10;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setup(int i10, int i11, float f, long j10) {
        ArrayList arrayList;
        int i12;
        String[] strArr;
        int i13;
        int i14;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle viewTimeCycleMakeSpline;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        int i15;
        ViewSpline viewSplineMakeSpline;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i16 = this.mPathMotionArc;
        if (i16 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i16;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        int i17 = 0;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i18 = 0;
            arrayList = null;
            while (i18 < size) {
                Key key = arrayList2.get(i18);
                i18++;
                Key key2 = key;
                if (key2 instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key2;
                    insertKey(new MotionPaths(i10, i11, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i19 = keyPosition.mCurveFit;
                    if (i19 != Key.UNSET) {
                        this.mCurveFitType = i19;
                    }
                } else if (key2 instanceof KeyCycle) {
                    key2.getAttributeNames(hashSet3);
                } else if (key2 instanceof KeyTimeCycle) {
                    key2.getAttributeNames(hashSet);
                } else if (key2 instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) key2);
                } else {
                    key2.setInterpolation(map);
                    key2.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        int i20 = 1;
        if (hashSet2.isEmpty()) {
            i12 = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it = hashSet2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next.split(",")[i20];
                    ArrayList<Key> arrayList3 = this.mKeyList;
                    int size2 = arrayList3.size();
                    int i21 = i17;
                    while (i21 < size2) {
                        Key key3 = arrayList3.get(i21);
                        i21++;
                        int i22 = i20;
                        Key key4 = key3;
                        HashMap<String, ConstraintAttribute> map2 = key4.mCustomConstraints;
                        if (map2 != null && (constraintAttribute3 = map2.get(str)) != null) {
                            sparseArray.append(key4.mFramePosition, constraintAttribute3);
                        }
                        i20 = i22;
                    }
                    i15 = i20;
                    viewSplineMakeSpline = ViewSpline.makeCustomSpline(next, (SparseArray<ConstraintAttribute>) sparseArray);
                } else {
                    i15 = i20;
                    viewSplineMakeSpline = ViewSpline.makeSpline(next);
                }
                if (viewSplineMakeSpline != null) {
                    viewSplineMakeSpline.setType(next);
                    this.mAttributesMap.put(next, viewSplineMakeSpline);
                }
                i20 = i15;
                i17 = 0;
            }
            i12 = i20;
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i23 = 0;
                while (i23 < size3) {
                    Key key5 = arrayList4.get(i23);
                    i23++;
                    Key key6 = key5;
                    if (key6 instanceof KeyAttributes) {
                        key6.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int iIntValue = (!map.containsKey(str2) || (num = map.get(str2)) == null) ? 0 : num.intValue();
                ViewSpline viewSpline = this.mAttributesMap.get(str2);
                if (viewSpline != null) {
                    viewSpline.setup(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next2)) {
                    if (next2.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next2.split(",")[i12];
                        ArrayList<Key> arrayList5 = this.mKeyList;
                        int size4 = arrayList5.size();
                        int i24 = 0;
                        while (i24 < size4) {
                            Key key7 = arrayList5.get(i24);
                            i24++;
                            Key key8 = key7;
                            HashMap<String, ConstraintAttribute> map3 = key8.mCustomConstraints;
                            if (map3 != null && (constraintAttribute2 = map3.get(str3)) != null) {
                                sparseArray2.append(key8.mFramePosition, constraintAttribute2);
                            }
                        }
                        viewTimeCycleMakeSpline = ViewTimeCycle.makeCustomSpline(next2, sparseArray2);
                    } else {
                        viewTimeCycleMakeSpline = ViewTimeCycle.makeSpline(next2, j10);
                    }
                    if (viewTimeCycleMakeSpline != null) {
                        viewTimeCycleMakeSpline.setType(next2);
                        this.mTimeCycleAttributesMap.put(next2, viewTimeCycleMakeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList6 = this.mKeyList;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i25 = 0;
                while (i25 < size5) {
                    Key key9 = arrayList6.get(i25);
                    i25++;
                    Key key10 = key9;
                    if (key10 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key10).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(map.containsKey(str4) ? map.get(str4).intValue() : 0);
            }
        }
        int size6 = this.mMotionPaths.size();
        int i26 = size6 + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i26];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size6 + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        ArrayList<MotionPaths> arrayList7 = this.mMotionPaths;
        int size7 = arrayList7.size();
        int i27 = i12;
        int i28 = 0;
        while (i28 < size7) {
            MotionPaths motionPaths = arrayList7.get(i28);
            i28++;
            motionPathsArr[i27] = motionPaths;
            i27++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.mEndMotionPath.mAttributes.keySet()) {
            if (this.mStartMotionPath.mAttributes.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i29 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i29 >= strArr.length) {
                break;
            }
            String str6 = strArr[i29];
            this.mAttributeInterpolatorCount[i29] = 0;
            int i30 = 0;
            while (true) {
                if (i30 >= i26) {
                    break;
                }
                if (motionPathsArr[i30].mAttributes.containsKey(str6) && (constraintAttribute = motionPathsArr[i30].mAttributes.get(str6)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i29] = constraintAttribute.numberOfInterpolatedValues() + iArr[i29];
                    break;
                }
                i30++;
            }
            i29++;
        }
        boolean z9 = motionPathsArr[0].mPathMotionArc != Key.UNSET ? i12 : 0;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i31 = i12; i31 < i26; i31++) {
            motionPathsArr[i31].different(motionPathsArr[i31 - 1], zArr, this.mAttributeNames, z9);
        }
        int i32 = 0;
        for (int i33 = i12; i33 < length; i33++) {
            if (zArr[i33]) {
                i32++;
            }
        }
        this.mInterpolateVariables = new int[i32];
        int i34 = 2;
        int iMax = Math.max(2, i32);
        this.mInterpolateData = new double[iMax];
        this.mInterpolateVelocity = new double[iMax];
        int i35 = 0;
        for (int i36 = i12; i36 < length; i36++) {
            if (zArr[i36]) {
                this.mInterpolateVariables[i35] = i36;
                i35++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[i12] = this.mInterpolateVariables.length;
        iArr2[0] = i26;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr2 = new double[i26];
        for (int i37 = 0; i37 < i26; i37++) {
            motionPathsArr[i37].fillStandard(dArr[i37], this.mInterpolateVariables);
            dArr2[i37] = motionPathsArr[i37].mTime;
        }
        int i38 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i38 >= iArr3.length) {
                break;
            }
            if (iArr3[i38] < MotionPaths.sNames.length) {
                String strO = a.o(new StringBuilder(), MotionPaths.sNames[this.mInterpolateVariables[i38]], " [");
                for (int i39 = 0; i39 < i26; i39++) {
                    StringBuilder sbV = a.v(strO);
                    sbV.append(dArr[i39][i38]);
                    strO = sbV.toString();
                }
            }
            i38++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i40 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i40 >= strArr3.length) {
                break;
            }
            String str7 = strArr3[i40];
            int i41 = 0;
            int i42 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i41 < i26) {
                if (motionPathsArr[i41].hasCustomData(str7)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i26];
                        int[] iArr4 = new int[i34];
                        iArr4[i12] = motionPathsArr[i41].getCustomDataCount(str7);
                        i14 = 0;
                        iArr4[0] = i26;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr4);
                    } else {
                        i14 = 0;
                    }
                    MotionPaths motionPaths2 = motionPathsArr[i41];
                    i13 = i40;
                    dArr3[i42] = motionPaths2.mTime;
                    motionPaths2.getCustomData(str7, dArr4[i42], i14);
                    i42++;
                } else {
                    i13 = i40;
                }
                i41++;
                i40 = i13;
                i34 = 2;
            }
            int i43 = i40 + 1;
            this.mSpline[i43] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i42), (double[][]) Arrays.copyOf(dArr4, i42));
            i40 = i43;
            i34 = 2;
        }
        int i44 = 0;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr5 = new int[i26];
            double[] dArr5 = new double[i26];
            int[] iArr6 = new int[2];
            iArr6[i12] = 2;
            iArr6[0] = i26;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i45 = 0; i45 < i26; i45++) {
                iArr5[i45] = motionPathsArr[i45].mPathMotionArc;
                dArr5[i45] = r8.mTime;
                double[] dArr7 = dArr6[i45];
                dArr7[0] = r8.mX;
                dArr7[i12] = r8.mY;
            }
            i44 = 0;
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it3 = hashSet3.iterator();
            float preCycleDistance = Float.NaN;
            while (it3.hasNext()) {
                String next3 = it3.next();
                ViewOscillator viewOscillatorMakeSpline = ViewOscillator.makeSpline(next3);
                if (viewOscillatorMakeSpline != null) {
                    if (viewOscillatorMakeSpline.variesByPath() && Float.isNaN(preCycleDistance)) {
                        preCycleDistance = getPreCycleDistance();
                    }
                    viewOscillatorMakeSpline.setType(next3);
                    this.mCycleMap.put(next3, viewOscillatorMakeSpline);
                }
            }
            ArrayList<Key> arrayList8 = this.mKeyList;
            int size8 = arrayList8.size();
            int i46 = i44;
            while (i46 < size8) {
                Key key11 = arrayList8.get(i46);
                i46++;
                Key key12 = key11;
                if (key12 instanceof KeyCycle) {
                    ((KeyCycle) key12).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<ViewOscillator> it4 = this.mCycleMap.values().iterator();
            while (it4.hasNext()) {
                it4.next().setup(preCycleDistance);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    public void setStartState(Rect rect, ConstraintSet constraintSet, int i10, int i11) {
        MotionController motionController;
        Rect rect2;
        int i12 = constraintSet.mRotate;
        if (i12 != 0) {
            motionController = this;
            rect2 = rect;
            motionController.rotate(rect2, this.mTempRect, i12, i10, i11);
        } else {
            motionController = this;
            rect2 = rect;
        }
        MotionPaths motionPaths = motionController.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        readView(motionPaths);
        motionController.mStartMotionPath.setBounds(rect2.left, rect2.top, rect2.width(), rect2.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(motionController.mId);
        motionController.mStartMotionPath.applyParameters(parameters);
        motionController.mMotionStagger = parameters.motion.mMotionStagger;
        motionController.mStartPoint.setState(rect2, constraintSet, i12, motionController.mId);
        motionController.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        ConstraintSet.Motion motion = parameters.motion;
        motionController.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
        motionController.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
        Context context = motionController.mView.getContext();
        ConstraintSet.Motion motion2 = parameters.motion;
        motionController.mQuantizeMotionInterpolator = getInterpolator(context, motion2.mQuantizeInterpolatorType, motion2.mQuantizeInterpolatorString, motion2.mQuantizeInterpolatorID);
    }
}
