package androidx.constraintlayout.core.motion;

import a3.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.transition.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class CustomVariable {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private int mType;

    public CustomVariable(CustomVariable customVariable) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        this.mIntegerValue = customVariable.mIntegerValue;
        this.mFloatValue = customVariable.mFloatValue;
        this.mStringValue = customVariable.mStringValue;
        this.mBooleanValue = customVariable.mBooleanValue;
    }

    private static int clamp(int i10) {
        int i11 = (i10 & (~(i10 >> 31))) - 255;
        return (i11 & (i11 >> 31)) + 255;
    }

    public static String colorString(int i10) {
        return "#".concat(("00000000" + Integer.toHexString(i10)).substring(r2.length() - 8));
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

    public static int rgbaTocColor(float f, float f10, float f11, float f12) {
        int iClamp = clamp((int) (f * 255.0f));
        int iClamp2 = clamp((int) (f10 * 255.0f));
        return (iClamp << 16) | (clamp((int) (f12 * 255.0f)) << 24) | (iClamp2 << 8) | clamp((int) (f11 * 255.0f));
    }

    public void applyToWidget(MotionWidget motionWidget) {
        int i10 = this.mType;
        switch (i10) {
            case 900:
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                motionWidget.setCustomAttribute(this.mName, i10, this.mIntegerValue);
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                motionWidget.setCustomAttribute(this.mName, i10, this.mFloatValue);
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                motionWidget.setCustomAttribute(this.mName, i10, this.mStringValue);
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                motionWidget.setCustomAttribute(this.mName, i10, this.mBooleanValue);
                break;
        }
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public boolean diff(CustomVariable customVariable) {
        int i10;
        if (customVariable != null && (i10 = this.mType) == customVariable.mType) {
            switch (i10) {
                case 900:
                case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                    if (this.mIntegerValue == customVariable.mIntegerValue) {
                        return true;
                    }
                    break;
                case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    return this.mFloatValue == customVariable.mFloatValue;
                case TypedValues.Custom.TYPE_COLOR /* 902 */:
                    return this.mIntegerValue == customVariable.mIntegerValue;
                case TypedValues.Custom.TYPE_STRING /* 903 */:
                    return this.mIntegerValue == customVariable.mIntegerValue;
                case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                    return this.mBooleanValue == customVariable.mBooleanValue;
                case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                    return this.mFloatValue == customVariable.mFloatValue;
                default:
                    return false;
            }
        }
        return false;
    }

    public boolean getBooleanValue() {
        return this.mBooleanValue;
    }

    public int getColorValue() {
        return this.mIntegerValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public int getInterpolatedColor(float[] fArr) {
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String getName() {
        return this.mName;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public int getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType) {
            case 900:
                return this.mIntegerValue;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                return this.mFloatValue;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                a2.a.j("Color does not have a single color to interpolate");
                return 0.0f;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                a2.a.j("Cannot interpolate String");
                return 0.0f;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (this.mType) {
            case 900:
                fArr[0] = this.mIntegerValue;
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                fArr[0] = this.mFloatValue;
                break;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                int i10 = (this.mIntegerValue >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i10 / 255.0f;
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                a2.a.j("Cannot interpolate String");
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                break;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                fArr[0] = this.mFloatValue;
                break;
        }
    }

    public boolean isContinuous() {
        int i10 = this.mType;
        return (i10 == 903 || i10 == 904 || i10 == 906) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        return this.mType != 902 ? 1 : 4;
    }

    public void setBooleanValue(boolean z9) {
        this.mBooleanValue = z9;
    }

    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    public void setIntValue(int i10) {
        this.mIntegerValue = i10;
    }

    public void setInterpolatedValue(MotionWidget motionWidget, float[] fArr) {
        int i10 = this.mType;
        switch (i10) {
            case 900:
                motionWidget.setCustomAttribute(this.mName, i10, (int) fArr[0]);
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                motionWidget.setCustomAttribute(this.mName, i10, fArr[0]);
                break;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                motionWidget.setCustomAttribute(this.mName, this.mType, (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                c.a(this.mName, "unable to interpolate ");
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                motionWidget.setCustomAttribute(this.mName, i10, fArr[0] > 0.5f);
                break;
        }
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        switch (this.mType) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.mIntegerValue = (int) fArr[0];
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                this.mFloatValue = fArr[0];
                break;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                this.mIntegerValue = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow(fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow(fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow(fArr[2], 0.5d)) * 255.0f) & 255);
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                a2.a.j("Cannot interpolate String");
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                break;
        }
    }

    public String toString() {
        String strM = a.m(new StringBuilder(), this.mName, ':');
        switch (this.mType) {
            case 900:
                StringBuilder sbV = a.v(strM);
                sbV.append(this.mIntegerValue);
                return sbV.toString();
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                StringBuilder sbV2 = a.v(strM);
                sbV2.append(this.mFloatValue);
                return sbV2.toString();
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                StringBuilder sbV3 = a.v(strM);
                sbV3.append(colorString(this.mIntegerValue));
                return sbV3.toString();
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                StringBuilder sbV4 = a.v(strM);
                sbV4.append(this.mStringValue);
                return sbV4.toString();
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                StringBuilder sbV5 = a.v(strM);
                sbV5.append(Boolean.valueOf(this.mBooleanValue));
                return sbV5.toString();
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                StringBuilder sbV6 = a.v(strM);
                sbV6.append(this.mFloatValue);
                return sbV6.toString();
            default:
                return strM.concat("????");
        }
    }

    public CustomVariable(String str, int i10, String str2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mName = str;
        this.mType = i10;
        this.mStringValue = str2;
    }

    public CustomVariable(String str, int i10, int i11) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i10;
        if (i10 == 901) {
            this.mFloatValue = i11;
        } else {
            this.mIntegerValue = i11;
        }
    }

    public CustomVariable(String str, int i10, float f) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i10;
        this.mFloatValue = f;
    }

    public CustomVariable(String str, int i10, boolean z9) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i10;
        this.mBooleanValue = z9;
    }

    public CustomVariable(String str, int i10) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i10;
    }

    public CustomVariable(String str, int i10, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i10;
        setValue(obj);
    }

    public CustomVariable(CustomVariable customVariable, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (this.mType) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                this.mStringValue = (String) obj;
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
        }
    }
}
