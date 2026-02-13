package androidx.constraintlayout.core.motion;

import a3.a;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class CustomAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.mMethod = false;
        this.mName = customAttribute.mName;
        this.mType = customAttribute.mType;
        setValue(obj);
    }

    private static int clamp(int i10) {
        int i11 = (i10 & (~(i10 >> 31))) - 255;
        return (i11 & (i11 >> 31)) + 255;
    }

    public static int hsvToRgb(float f, float f10, float f11) {
        float f12 = f * 6.0f;
        int i10 = (int) f12;
        float f13 = f12 - i10;
        float f14 = f11 * 255.0f;
        int iD = (int) a.d(1.0f, f10, f14, 0.5f);
        int i11 = (int) (((1.0f - (f13 * f10)) * f14) + 0.5f);
        int i12 = (int) (((1.0f - ((1.0f - f13) * f10)) * f14) + 0.5f);
        int i13 = (int) (f14 + 0.5f);
        if (i10 == 0) {
            return ((i13 << 16) + (i12 << 8) + iD) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i10 == 1) {
            return ((i11 << 16) + (i13 << 8) + iD) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i10 == 2) {
            return ((iD << 16) + (i13 << 8) + i12) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i10 == 3) {
            return ((iD << 16) + (i11 << 8) + i13) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i10 == 4) {
            return ((i12 << 16) + (iD << 8) + i13) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i10 != 5) {
            return 0;
        }
        return ((i13 << 16) + (iD << 8) + i11) | ViewCompat.MEASURED_STATE_MASK;
    }

    public boolean diff(CustomAttribute customAttribute) {
        AttributeType attributeType;
        if (customAttribute != null && (attributeType = this.mType) == customAttribute.mType) {
            switch (attributeType) {
                case INT_TYPE:
                case REFERENCE_TYPE:
                    if (this.mIntegerValue == customAttribute.mIntegerValue) {
                        return true;
                    }
                    break;
                case FLOAT_TYPE:
                    return this.mFloatValue == customAttribute.mFloatValue;
                case COLOR_TYPE:
                case COLOR_DRAWABLE_TYPE:
                    return this.mColorValue == customAttribute.mColorValue;
                case STRING_TYPE:
                    return this.mIntegerValue == customAttribute.mIntegerValue;
                case BOOLEAN_TYPE:
                    return this.mBooleanValue == customAttribute.mBooleanValue;
                case DIMENSION_TYPE:
                    return this.mFloatValue == customAttribute.mFloatValue;
                default:
                    return false;
            }
        }
        return false;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType) {
            case INT_TYPE:
                return this.mIntegerValue;
            case FLOAT_TYPE:
                return this.mFloatValue;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                a2.a.j("Color does not have a single color to interpolate");
                return 0.0f;
            case STRING_TYPE:
                a2.a.j("Cannot interpolate String");
                return 0.0f;
            case BOOLEAN_TYPE:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case DIMENSION_TYPE:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (this.mType) {
            case INT_TYPE:
                fArr[0] = this.mIntegerValue;
                break;
            case FLOAT_TYPE:
                fArr[0] = this.mFloatValue;
                break;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int i10 = (this.mColorValue >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i10 / 255.0f;
                break;
            case STRING_TYPE:
                a2.a.j("Color does not have a single color to interpolate");
                break;
            case BOOLEAN_TYPE:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                break;
            case DIMENSION_TYPE:
                fArr[0] = this.mFloatValue;
                break;
        }
    }

    public boolean isContinuous() {
        int iOrdinal = this.mType.ordinal();
        return (iOrdinal == 4 || iOrdinal == 5 || iOrdinal == 7) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        int iOrdinal = this.mType.ordinal();
        return (iOrdinal == 2 || iOrdinal == 3) ? 4 : 1;
    }

    public void setColorValue(int i10) {
        this.mColorValue = i10;
    }

    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    public void setIntValue(int i10) {
        this.mIntegerValue = i10;
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        switch (this.mType) {
            case INT_TYPE:
            case REFERENCE_TYPE:
                this.mIntegerValue = (int) fArr[0];
                break;
            case FLOAT_TYPE:
                this.mFloatValue = fArr[0];
                break;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int iHsvToRgb = hsvToRgb(fArr[0], fArr[1], fArr[2]);
                this.mColorValue = iHsvToRgb;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (iHsvToRgb & ViewCompat.MEASURED_SIZE_MASK);
                break;
            case STRING_TYPE:
                a2.a.j("Color does not have a single color to interpolate");
                break;
            case BOOLEAN_TYPE:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                break;
            case DIMENSION_TYPE:
                this.mFloatValue = fArr[0];
                break;
        }
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z9) {
        this.mName = str;
        this.mType = attributeType;
        this.mMethod = z9;
        setValue(obj);
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.mMethod = false;
        this.mName = str;
        this.mType = attributeType;
    }

    public void setValue(Object obj) {
        switch (this.mType) {
            case INT_TYPE:
            case REFERENCE_TYPE:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case FLOAT_TYPE:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                this.mColorValue = ((Integer) obj).intValue();
                break;
            case STRING_TYPE:
                this.mStringValue = (String) obj;
                break;
            case BOOLEAN_TYPE:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case DIMENSION_TYPE:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
        }
    }
}
