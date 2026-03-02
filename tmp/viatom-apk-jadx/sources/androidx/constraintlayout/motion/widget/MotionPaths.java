package androidx.constraintlayout.motion.widget;

import a3.a;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    LinkedHashMap<String, ConstraintAttribute> mAttributes;
    float mHeight;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPosition;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float mTime;
    float mWidth;
    float mX;
    float mY;
    int mDrawPath = 0;
    float mPathRotate = Float.NaN;
    float mProgress = Float.NaN;

    public MotionPaths(int i10, int i11, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i12 = Key.UNSET;
        this.mPathMotionArc = i12;
        this.mAnimateRelativeTo = i12;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != Key.UNSET) {
            initPolar(i10, i11, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i13 = keyPosition.mPositionType;
        if (i13 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
            return;
        }
        if (i13 == 2) {
            initScreen(i10, i11, keyPosition, motionPaths, motionPaths2);
        } else if (i13 != 3) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initAxis(keyPosition, motionPaths, motionPaths2);
        }
    }

    private boolean diff(float f, float f10) {
        return (Float.isNaN(f) || Float.isNaN(f10)) ? Float.isNaN(f) != Float.isNaN(f10) : Math.abs(f - f10) > 1.0E-6f;
    }

    private static float xRotate(float f, float f10, float f11, float f12, float f13, float f14) {
        return (((f13 - f11) * f10) - ((f14 - f12) * f)) + f11;
    }

    private static float yRotate(float f, float f10, float f11, float f12, float f13, float f14) {
        return ((f14 - f12) * f10) + ((f13 - f11) * f) + f12;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = constraint.propertySet.mProgress;
        this.mRelativeAngle = constraint.layout.circleAngle;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.mAttributes.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.mPosition, motionPaths.mPosition);
    }

    public void configureRelativeTo(MotionController motionController) {
        motionController.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z9) {
        boolean zDiff = diff(this.mX, motionPaths.mX);
        boolean zDiff2 = diff(this.mY, motionPaths.mY);
        zArr[0] = zArr[0] | diff(this.mPosition, motionPaths.mPosition);
        boolean z10 = zDiff | zDiff2 | z9;
        zArr[1] = zArr[1] | z10;
        zArr[2] = z10 | zArr[2];
        zArr[3] = zArr[3] | diff(this.mWidth, motionPaths.mWidth);
        zArr[4] = diff(this.mHeight, motionPaths.mHeight) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 < 6) {
                dArr[i10] = fArr[r1];
                i10++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f = this.mWidth;
        float f10 = this.mHeight;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f11 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 3) {
                f = f11;
            } else if (i12 == 4) {
                f10 = f11;
            }
        }
        fArr[i10] = f;
        fArr[i10 + 1] = f10;
    }

    public void getCenter(double d8, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f;
        float fC = this.mX;
        float fCos = this.mY;
        float f10 = this.mWidth;
        float f11 = this.mHeight;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f16 = (float) dArr[i10];
            float f17 = (float) dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                fC = f16;
                f12 = f17;
            } else if (i11 == 2) {
                fCos = f16;
                f14 = f17;
            } else if (i11 == 3) {
                f10 = f16;
                f13 = f17;
            } else if (i11 == 4) {
                f11 = f16;
                f15 = f17;
            }
        }
        float f18 = (f13 / 2.0f) + f12;
        float fC2 = (f15 / 2.0f) + f14;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.getCenter(d8, fArr3, fArr4);
            float f19 = fArr3[0];
            float f20 = fArr3[1];
            float f21 = fArr4[0];
            float f22 = fArr4[1];
            f = 2.0f;
            double d10 = fC;
            double d11 = fCos;
            fC = (float) (a.c(d11, d10, f19) - (f10 / 2.0f));
            fCos = (float) ((f20 - (Math.cos(d11) * d10)) - (f11 / 2.0f));
            double d12 = f12;
            double dC = a.c(d11, d12, f21);
            double d13 = f14;
            float fCos2 = (float) ((Math.cos(d11) * d13) + dC);
            fC2 = (float) a.c(d11, d13, f22 - (Math.cos(d11) * d12));
            f18 = fCos2;
        } else {
            f = 2.0f;
        }
        fArr[0] = (f10 / f) + fC + 0.0f;
        fArr[1] = (f11 / f) + fCos + 0.0f;
        fArr2[0] = f18;
        fArr2[1] = fC2;
    }

    public void getCenterVelocity(double d8, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float fC = this.mX;
        float fCos = this.mY;
        float f = this.mWidth;
        float f10 = this.mHeight;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f11 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                fC = f11;
            } else if (i12 == 2) {
                fCos = f11;
            } else if (i12 == 3) {
                f = f11;
            } else if (i12 == 4) {
                f10 = f11;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d8, fArr2, new float[2]);
            float f12 = fArr2[0];
            float f13 = fArr2[1];
            double d10 = fC;
            double d11 = fCos;
            fC = (float) (a.c(d11, d10, f12) - (f / 2.0f));
            fCos = (float) ((f13 - (Math.cos(d11) * d10)) - (f10 / 2.0f));
        }
        fArr[i10] = (f / 2.0f) + fC + 0.0f;
        fArr[i10 + 1] = (f10 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i10) {
        ConstraintAttribute constraintAttribute = this.mAttributes.get(str);
        int i11 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            dArr[i10] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        constraintAttribute.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        while (i11 < iNumberOfInterpolatedValues) {
            dArr[i10] = r2[i11];
            i11++;
            i10++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        ConstraintAttribute constraintAttribute = this.mAttributes.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float fC = this.mX;
        float fCos = this.mY;
        float f = this.mWidth;
        float f10 = this.mHeight;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f11 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                fC = f11;
            } else if (i12 == 2) {
                fCos = f11;
            } else if (i12 == 3) {
                f = f11;
            } else if (i12 == 4) {
                f10 = f11;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d8 = fC;
            double d10 = fCos;
            fC = (float) (a.c(d10, d8, centerX) - (f / 2.0f));
            fCos = (float) ((centerY - (Math.cos(d10) * d8)) - (f10 / 2.0f));
        }
        float f12 = f + fC;
        float f13 = f10 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i10] = fC + 0.0f;
        fArr[i10 + 1] = fCos + 0.0f;
        fArr[i10 + 2] = f12 + 0.0f;
        fArr[i10 + 3] = fCos + 0.0f;
        fArr[i10 + 4] = f12 + 0.0f;
        fArr[i10 + 5] = f13 + 0.0f;
        fArr[i10 + 6] = fC + 0.0f;
        fArr[i10 + 7] = f13 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.mAttributes.containsKey(str);
    }

    public void initAxis(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f10 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f11 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f12 = motionPaths2.mWidth;
        float f13 = motionPaths.mWidth;
        float f14 = f12 - f13;
        float f15 = motionPaths2.mHeight;
        float f16 = motionPaths.mHeight;
        float f17 = f15 - f16;
        this.mPosition = this.mTime;
        float f18 = (f13 / 2.0f) + motionPaths.mX;
        float f19 = (f16 / 2.0f) + motionPaths.mY;
        float f20 = f;
        float f21 = (f12 / 2.0f) + motionPaths2.mX;
        float f22 = (f15 / 2.0f) + motionPaths2.mY;
        if (f18 > f21) {
            f18 = f21;
            f21 = f18;
        }
        if (f19 <= f22) {
            f19 = f22;
            f22 = f19;
        }
        float f23 = f21 - f18;
        float f24 = f19 - f22;
        float f25 = (f14 * f10) / 2.0f;
        this.mX = (int) (((f23 * f20) + r13) - f25);
        float f26 = (f17 * f11) / 2.0f;
        this.mY = (int) (((f24 * f20) + r14) - f26);
        this.mWidth = (int) (f13 + r9);
        this.mHeight = (int) (f16 + r12);
        float f27 = Float.isNaN(keyPosition.mPercentX) ? f20 : keyPosition.mPercentX;
        float f28 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f20 = keyPosition.mPercentY;
        }
        float f29 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 0;
        this.mX = (int) (((f29 * f24) + ((f27 * f23) + motionPaths.mX)) - f25);
        this.mY = (int) (((f24 * f20) + ((f23 * f28) + motionPaths.mY)) - f26);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f10 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f11 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f12 = motionPaths2.mWidth;
        float f13 = motionPaths.mWidth;
        float f14 = f12 - f13;
        float f15 = motionPaths2.mHeight;
        float f16 = motionPaths.mHeight;
        float f17 = f15 - f16;
        this.mPosition = this.mTime;
        float f18 = motionPaths.mX;
        float f19 = motionPaths.mY;
        float f20 = f;
        float f21 = ((f12 / 2.0f) + motionPaths2.mX) - ((f13 / 2.0f) + f18);
        float f22 = ((f15 / 2.0f) + motionPaths2.mY) - ((f16 / 2.0f) + f19);
        float f23 = (f14 * f10) / 2.0f;
        this.mX = (int) (((f21 * f20) + f18) - f23);
        float f24 = (f17 * f11) / 2.0f;
        this.mY = (int) (((f22 * f20) + f19) - f24);
        this.mWidth = (int) (f13 + r9);
        this.mHeight = (int) (f16 + r12);
        float f25 = Float.isNaN(keyPosition.mPercentX) ? f20 : keyPosition.mPercentX;
        float f26 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f20 = keyPosition.mPercentY;
        }
        float f27 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 0;
        this.mX = (int) (((f27 * f22) + ((f25 * f21) + motionPaths.mX)) - f23);
        this.mY = (int) (((f22 * f20) + ((f21 * f26) + motionPaths.mY)) - f24);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f10 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f11 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f12 = motionPaths2.mWidth - motionPaths.mWidth;
        float f13 = motionPaths2.mHeight - motionPaths.mHeight;
        this.mPosition = this.mTime;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f = keyPosition.mPercentX;
        }
        float f14 = motionPaths.mX;
        float f15 = motionPaths.mWidth;
        float f16 = motionPaths.mY;
        float f17 = motionPaths.mHeight;
        float f18 = f;
        float f19 = ((motionPaths2.mWidth / 2.0f) + motionPaths2.mX) - ((f15 / 2.0f) + f14);
        float f20 = ((motionPaths2.mHeight / 2.0f) + motionPaths2.mY) - ((f17 / 2.0f) + f16);
        float f21 = f19 * f18;
        float f22 = (f12 * f10) / 2.0f;
        this.mX = (int) ((f14 + f21) - f22);
        float f23 = f20 * f18;
        float f24 = (f13 * f11) / 2.0f;
        this.mY = (int) ((f16 + f23) - f24);
        this.mWidth = (int) (f15 + r7);
        this.mHeight = (int) (f17 + r8);
        float f25 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f26 = (int) ((motionPaths.mX + f21) - f22);
        float f27 = (int) ((motionPaths.mY + f23) - f24);
        this.mX = f26 + ((-f20) * f25);
        this.mY = f27 + (f19 * f25);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPolar(int i10, int i11, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fD;
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mMode = keyPosition.mPositionType;
        float f10 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f11 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f12 = motionPaths2.mWidth;
        float f13 = motionPaths.mWidth;
        float f14 = motionPaths2.mHeight;
        float f15 = motionPaths.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (int) (((f12 - f13) * f10) + f13);
        this.mHeight = (int) (((f14 - f15) * f11) + f15);
        int i12 = keyPosition.mPositionType;
        float f16 = keyPosition.mPercentX;
        if (i12 != 2) {
            float f17 = Float.isNaN(f16) ? f : keyPosition.mPercentX;
            float f18 = motionPaths2.mX;
            float f19 = motionPaths.mX;
            this.mX = a.d(f18, f19, f17, f19);
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f = keyPosition.mPercentY;
            }
            float f20 = motionPaths2.mY;
            float f21 = motionPaths.mY;
            this.mY = a.d(f20, f21, f, f21);
        } else {
            if (Float.isNaN(f16)) {
                float f22 = motionPaths2.mX;
                float f23 = motionPaths.mX;
                fMin = a.d(f22, f23, f, f23);
            } else {
                fMin = Math.min(f11, f10) * keyPosition.mPercentX;
            }
            this.mX = fMin;
            if (Float.isNaN(keyPosition.mPercentY)) {
                float f24 = motionPaths2.mY;
                float f25 = motionPaths.mY;
                fD = a.d(f24, f25, f, f25);
            } else {
                fD = keyPosition.mPercentY;
            }
            this.mY = fD;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initScreen(int i10, int i11, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.mTime = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f10 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f11 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f12 = motionPaths2.mWidth;
        float f13 = f12 - motionPaths.mWidth;
        float f14 = motionPaths2.mHeight;
        float f15 = f14 - motionPaths.mHeight;
        this.mPosition = this.mTime;
        float f16 = motionPaths.mX;
        float f17 = motionPaths.mY;
        float f18 = (f12 / 2.0f) + motionPaths2.mX;
        float f19 = (f14 / 2.0f) + motionPaths2.mY;
        float f20 = f13 * f10;
        this.mX = (int) ((((f18 - ((r8 / 2.0f) + f16)) * f) + f16) - (f20 / 2.0f));
        float f21 = f15 * f11;
        this.mY = (int) ((((f19 - ((r11 / 2.0f) + f17)) * f) + f17) - (f21 / 2.0f));
        this.mWidth = (int) (r8 + f20);
        this.mHeight = (int) (r11 + f21);
        this.mMode = 2;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.mX = (int) (keyPosition.mPercentX * (i10 - ((int) this.mWidth)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.mY = (int) (keyPosition.mPercentY * (i11 - ((int) this.mHeight)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setBounds(float f, float f10, float f11, float f12) {
        this.mX = f;
        this.mY = f10;
        this.mWidth = f11;
        this.mHeight = f12;
    }

    public void setDpDt(float f, float f10, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f15 = (float) dArr[i10];
            double d8 = dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f11 = f15;
            } else if (i11 == 2) {
                f13 = f15;
            } else if (i11 == 3) {
                f12 = f15;
            } else if (i11 == 4) {
                f14 = f15;
            }
        }
        float f16 = f11 - ((0.0f * f12) / 2.0f);
        float f17 = f13 - ((0.0f * f14) / 2.0f);
        fArr[0] = (((f12 * 1.0f) + f16) * f) + ((1.0f - f) * f16) + 0.0f;
        fArr[1] = (((f14 * 1.0f) + f17) * f10) + ((1.0f - f10) * f17) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setView(float f, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z9) {
        float f10;
        float f11 = this.mX;
        float f12 = this.mY;
        float f13 = this.mWidth;
        float f14 = this.mHeight;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i10];
            this.mTempDelta = new double[i10];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            double[] dArr4 = this.mTempValue;
            int i12 = iArr[i11];
            dArr4[i12] = dArr[i11];
            this.mTempDelta[i12] = dArr2[i11];
        }
        float f15 = Float.NaN;
        int i13 = 0;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i13 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i13]) && (dArr3 == null || dArr3[i13] == 0.0d)) {
                f10 = f15;
            } else {
                double d8 = dArr3 != null ? dArr3[i13] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i13])) {
                    d8 = this.mTempValue[i13] + d8;
                }
                f10 = f15;
                float f20 = (float) d8;
                float f21 = (float) this.mTempDelta[i13];
                if (i13 == 1) {
                    f15 = f10;
                    f16 = f21;
                    f11 = f20;
                } else if (i13 == 2) {
                    f15 = f10;
                    f17 = f21;
                    f12 = f20;
                } else if (i13 == 3) {
                    f15 = f10;
                    f18 = f21;
                    f13 = f20;
                } else if (i13 == 4) {
                    f15 = f10;
                    f19 = f21;
                    f14 = f20;
                } else if (i13 == 5) {
                    f15 = f20;
                }
                i13++;
            }
            f15 = f10;
            i13++;
        }
        float f22 = f15;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(f, fArr, fArr2);
            float f23 = fArr[0];
            float f24 = fArr[1];
            float f25 = fArr2[0];
            float f26 = fArr2[1];
            double d10 = f23;
            double d11 = f11;
            double d12 = f12;
            float fC = (float) (a.c(d12, d11, d10) - (f13 / 2.0f));
            float fCos = (float) ((f24 - (Math.cos(d12) * d11)) - (f14 / 2.0f));
            double d13 = f25;
            double d14 = f16;
            double d15 = f17;
            float fCos2 = (float) ((Math.cos(d12) * d11 * d15) + a.c(d12, d14, d13));
            float fSin = (float) ((Math.sin(d12) * d11 * d15) + (f26 - (Math.cos(d12) * d14)));
            if (dArr2.length >= 2) {
                dArr2[0] = fCos2;
                dArr2[1] = fSin;
            }
            if (!Float.isNaN(f22)) {
                view.setRotation((float) (Math.toDegrees(Math.atan2(fSin, fCos2)) + f22));
            }
            f11 = fC;
            f12 = fCos;
        } else if (!Float.isNaN(f22)) {
            view.setRotation(f22 + ((float) Math.toDegrees(Math.atan2((f19 / 2.0f) + f17, (f18 / 2.0f) + f16))) + 0.0f);
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).layout(f11, f12, f13 + f11, f14 + f12);
            return;
        }
        float f27 = f11 + 0.5f;
        int i14 = (int) f27;
        float f28 = f12 + 0.5f;
        int i15 = (int) f28;
        int i16 = (int) (f27 + f13);
        int i17 = (int) (f28 + f14);
        int i18 = i16 - i14;
        int i19 = i17 - i15;
        if (i18 != view.getMeasuredWidth() || i19 != view.getMeasuredHeight() || z9) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
        }
        view.layout(i14, i15, i16, i17);
    }

    public void setupRelative(MotionController motionController, MotionPaths motionPaths) {
        double d8 = (((this.mWidth / 2.0f) + this.mX) - motionPaths.mX) - (motionPaths.mWidth / 2.0f);
        double d10 = (((this.mHeight / 2.0f) + this.mY) - motionPaths.mY) - (motionPaths.mHeight / 2.0f);
        this.mRelativeToController = motionController;
        this.mX = (float) Math.hypot(d10, d8);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.mY = (float) (Math.atan2(d10, d8) + 1.5707963267948966d);
        } else {
            this.mY = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    public MotionPaths() {
        int i10 = Key.UNSET;
        this.mPathMotionArc = i10;
        this.mAnimateRelativeTo = i10;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mAttributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public void getCenter(double d8, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float fC = this.mX;
        float fCos = this.mY;
        float f = this.mWidth;
        float f10 = this.mHeight;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f11 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                fC = f11;
            } else if (i12 == 2) {
                fCos = f11;
            } else if (i12 == 3) {
                f = f11;
            } else if (i12 == 4) {
                f10 = f11;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d8, fArr2, new float[2]);
            float f12 = fArr2[0];
            float f13 = fArr2[1];
            double d10 = fC;
            double d11 = fCos;
            fC = (float) (a.c(d11, d10, f12) - (f / 2.0f));
            fCos = (float) ((f13 - (Math.cos(d11) * d10)) - (f10 / 2.0f));
        }
        fArr[i10] = (f / 2.0f) + fC + 0.0f;
        fArr[i10 + 1] = (f10 / 2.0f) + fCos + 0.0f;
    }
}
