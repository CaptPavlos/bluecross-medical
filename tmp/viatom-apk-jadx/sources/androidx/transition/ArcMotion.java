package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        typedArrayObtainStyledAttributes.recycle();
    }

    private static float toTangent(float f) {
        if (f >= 0.0f && f <= 90.0f) {
            return (float) Math.tan(Math.toRadians(f / 2.0f));
        }
        com.google.gson.internal.a.n("Arc must be between 0 and 90 degrees");
        return 0.0f;
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f, float f10, float f11, float f12) {
        float fD;
        float fD2;
        float f13;
        Path path = new Path();
        path.moveTo(f, f10);
        float f14 = f11 - f;
        float f15 = f12 - f10;
        float f16 = (f15 * f15) + (f14 * f14);
        float f17 = (f + f11) / 2.0f;
        float f18 = (f10 + f12) / 2.0f;
        float f19 = 0.25f * f16;
        boolean z9 = f10 > f12;
        if (Math.abs(f14) < Math.abs(f15)) {
            float fAbs = Math.abs(f16 / (f15 * 2.0f));
            if (z9) {
                fD2 = fAbs + f12;
                fD = f11;
            } else {
                fD2 = fAbs + f10;
                fD = f;
            }
            f13 = this.mMinimumVerticalTangent;
        } else {
            float f20 = f16 / (f14 * 2.0f);
            if (z9) {
                fD2 = f10;
                fD = f20 + f;
            } else {
                fD = f11 - f20;
                fD2 = f12;
            }
            f13 = this.mMinimumHorizontalTangent;
        }
        float f21 = f19 * f13 * f13;
        float f22 = f17 - fD;
        float f23 = f18 - fD2;
        float f24 = (f23 * f23) + (f22 * f22);
        float f25 = this.mMaximumTangent;
        float f26 = f19 * f25 * f25;
        if (f24 >= f21) {
            f21 = f24 > f26 ? f26 : 0.0f;
        }
        if (f21 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f21 / f24);
            fD = a3.a.d(fD, f17, fSqrt, f17);
            fD2 = a3.a.d(fD2, f18, fSqrt, f18);
        }
        path.cubicTo((f + fD) / 2.0f, (f10 + fD2) / 2.0f, (fD + f11) / 2.0f, (fD2 + f12) / 2.0f, f11, f12);
        return path;
    }

    public void setMaximumAngle(float f) {
        this.mMaximumAngle = f;
        this.mMaximumTangent = toTangent(f);
    }

    public void setMinimumHorizontalAngle(float f) {
        this.mMinimumHorizontalAngle = f;
        this.mMinimumHorizontalTangent = toTangent(f);
    }

    public void setMinimumVerticalAngle(float f) {
        this.mMinimumVerticalAngle = f;
        this.mMinimumVerticalTangent = toTangent(f);
    }

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }
}
