package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class MotionKeyPosition extends MotionKey {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    protected static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing;

    public MotionKeyPosition() {
        int i10 = MotionKey.UNSET;
        this.mCurveFit = i10;
        this.mTransitionEasing = null;
        this.mPathMotionArc = i10;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f, float f10, float f11, float f12) {
        float f13 = f11 - f;
        float f14 = f12 - f10;
        float f15 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f16 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f17 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f14) + (f15 * f13) + f);
        this.mCalculatedPositionY = (int) ((f14 * f17) + (f13 * f16) + f10);
    }

    private void calcPathPosition(float f, float f10, float f11, float f12) {
        float f13 = f11 - f;
        float f14 = f12 - f10;
        float f15 = this.mPercentX;
        float f16 = (f13 * f15) + f;
        float f17 = this.mPercentY;
        this.mCalculatedPositionX = ((-f14) * f17) + f16;
        this.mCalculatedPositionY = (f13 * f17) + (f14 * f15) + f10;
    }

    private void calcScreenPosition(int i10, int i11) {
        float f = this.mPercentX;
        float f10 = 0;
        this.mCalculatedPositionX = (i10 * f) + f10;
        this.mCalculatedPositionY = (i11 * f) + f10;
    }

    public void calcPosition(int i10, int i11, float f, float f10, float f11, float f12) {
        int i12 = this.mPositionType;
        if (i12 == 1) {
            calcPathPosition(f, f10, f11, f12);
        } else if (i12 != 2) {
            calcCartesianPosition(f, f10, f11, f12);
        } else {
            calcScreenPosition(i10, i11);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo33clone() {
        return new MotionKeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.mTransitionEasing = motionKeyPosition.mTransitionEasing;
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mPercentWidth = motionKeyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = motionKeyPosition.mPercentX;
        this.mPercentY = motionKeyPosition.mPercentY;
        this.mAltPercentX = motionKeyPosition.mAltPercentX;
        this.mAltPercentY = motionKeyPosition.mAltPercentY;
        this.mCalculatedPositionX = motionKeyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = motionKeyPosition.mCalculatedPositionY;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getId(java.lang.String r3) {
        /*
            r2 = this;
            r3.getClass()
            int r0 = r3.hashCode()
            r1 = -1
            switch(r0) {
                case -1812823328: goto L4f;
                case -1127236479: goto L44;
                case -1017587252: goto L39;
                case -827014263: goto L2e;
                case -200259324: goto L23;
                case 428090547: goto L18;
                case 428090548: goto Ld;
                default: goto Lb;
            }
        Lb:
            r3 = r1
            goto L59
        Ld:
            java.lang.String r0 = "percentY"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L16
            goto Lb
        L16:
            r3 = 6
            goto L59
        L18:
            java.lang.String r0 = "percentX"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L21
            goto Lb
        L21:
            r3 = 5
            goto L59
        L23:
            java.lang.String r0 = "sizePercent"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L2c
            goto Lb
        L2c:
            r3 = 4
            goto L59
        L2e:
            java.lang.String r0 = "drawPath"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L37
            goto Lb
        L37:
            r3 = 3
            goto L59
        L39:
            java.lang.String r0 = "percentHeight"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L42
            goto Lb
        L42:
            r3 = 2
            goto L59
        L44:
            java.lang.String r0 = "percentWidth"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L4d
            goto Lb
        L4d:
            r3 = 1
            goto L59
        L4f:
            java.lang.String r0 = "transitionEasing"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L58
            goto Lb
        L58:
            r3 = 0
        L59:
            switch(r3) {
                case 0: goto L6f;
                case 1: goto L6c;
                case 2: goto L69;
                case 3: goto L66;
                case 4: goto L63;
                case 5: goto L60;
                case 6: goto L5d;
                default: goto L5c;
            }
        L5c:
            return r1
        L5d:
            r3 = 507(0x1fb, float:7.1E-43)
            return r3
        L60:
            r3 = 506(0x1fa, float:7.09E-43)
            return r3
        L63:
            r3 = 505(0x1f9, float:7.08E-43)
            return r3
        L66:
            r3 = 502(0x1f6, float:7.03E-43)
            return r3
        L69:
            r3 = 504(0x1f8, float:7.06E-43)
            return r3
        L6c:
            r3 = 503(0x1f7, float:7.05E-43)
            return r3
        L6f:
            r3 = 501(0x1f5, float:7.02E-43)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyPosition.getId(java.lang.String):int");
    }

    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i10, int i11, FloatRect floatRect, FloatRect floatRect2, float f, float f10) {
        calcPosition(i10, i11, floatRect.centerX(), floatRect.centerY(), floatRect2.centerX(), floatRect2.centerY());
        return Math.abs(f - this.mCalculatedPositionX) < SELECTION_SLOPE && Math.abs(f10 - this.mCalculatedPositionY) < SELECTION_SLOPE;
    }

    public void positionAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f, float f10, String[] strArr, float[] fArr) {
        int i10 = this.mPositionType;
        if (i10 == 1) {
            positionPathAttributes(floatRect, floatRect2, f, f10, strArr, fArr);
        } else if (i10 != 2) {
            positionCartAttributes(floatRect, floatRect2, f, f10, strArr, fArr);
        } else {
            positionScreenAttributes(motionWidget, floatRect, floatRect2, f, f10, strArr, fArr);
        }
    }

    public void positionCartAttributes(FloatRect floatRect, FloatRect floatRect2, float f, float f10, String[] strArr, float[] fArr) {
        float fCenterX = floatRect.centerX();
        float fCenterY = floatRect.centerY();
        float fCenterX2 = floatRect2.centerX() - fCenterX;
        float fCenterY2 = floatRect2.centerY() - fCenterY;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f - fCenterX) / fCenterX2;
            strArr[1] = "percentY";
            fArr[1] = (f10 - fCenterY) / fCenterY2;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = (f - fCenterX) / fCenterX2;
            fArr[1] = (f10 - fCenterY) / fCenterY2;
        } else {
            fArr[1] = (f - fCenterX) / fCenterX2;
            fArr[0] = (f10 - fCenterY) / fCenterY2;
        }
    }

    public void positionPathAttributes(FloatRect floatRect, FloatRect floatRect2, float f, float f10, String[] strArr, float[] fArr) {
        float fCenterX = floatRect.centerX();
        float fCenterY = floatRect.centerY();
        float fCenterX2 = floatRect2.centerX() - fCenterX;
        float fCenterY2 = floatRect2.centerY() - fCenterY;
        float fHypot = (float) Math.hypot(fCenterX2, fCenterY2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f11 = fCenterX2 / fHypot;
        float f12 = fCenterY2 / fHypot;
        float f13 = f10 - fCenterY;
        float f14 = f - fCenterX;
        float f15 = ((f11 * f13) - (f14 * f12)) / fHypot;
        float f16 = ((f12 * f13) + (f11 * f14)) / fHypot;
        String str = strArr[0];
        if (str != null) {
            if ("percentX".equals(str)) {
                fArr[0] = f16;
                fArr[1] = f15;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f16;
        fArr[1] = f15;
    }

    public void positionScreenAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f, float f10, String[] strArr, float[] fArr) {
        floatRect.centerX();
        floatRect.centerY();
        floatRect2.centerX();
        floatRect2.centerY();
        MotionWidget parent = motionWidget.getParent();
        int width = parent.getWidth();
        int height = parent.getHeight();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = f / width;
            strArr[1] = "percentY";
            fArr[1] = f10 / height;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = f / width;
            fArr[1] = f10 / height;
        } else {
            fArr[1] = f / width;
            fArr[0] = f10 / height;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i10, float f) {
        switch (i10) {
            case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                this.mPercentWidth = f;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                this.mPercentHeight = f;
                return true;
            case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
                this.mPercentWidth = f;
                this.mPercentHeight = f;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_X /* 506 */:
                this.mPercentX = f;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_Y /* 507 */:
                this.mPercentY = f;
                return true;
            default:
                return super.setValue(i10, f);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> map) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i10, int i11) {
        if (i10 == 100) {
            this.mFramePosition = i11;
            return true;
        }
        if (i10 == 508) {
            this.mCurveFit = i11;
            return true;
        }
        if (i10 != 510) {
            return super.setValue(i10, i11);
        }
        this.mPositionType = i11;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i10, String str) {
        if (i10 != 501) {
            return super.setValue(i10, str);
        }
        this.mTransitionEasing = str.toString();
        return true;
    }
}
