package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.google.gson.internal.a;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(typedArrayObtainAttributes, xmlPullParser);
        typedArrayObtainAttributes.recycle();
    }

    private void initCubic(float f, float f10, float f11, float f12) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f10, f11, f12, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i10 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.mX = new float[iMin];
        this.mY = new float[iMin];
        float[] fArr = new float[2];
        for (int i11 = 0; i11 < iMin; i11++) {
            pathMeasure.getPosTan((i11 * length) / (iMin - 1), fArr, null);
            this.mX[i11] = fArr[0];
            this.mY[i11] = fArr[1];
        }
        if (Math.abs(this.mX[0]) <= 1.0E-5d && Math.abs(this.mY[0]) <= 1.0E-5d) {
            int i12 = iMin - 1;
            if (Math.abs(this.mX[i12] - 1.0f) <= 1.0E-5d && Math.abs(this.mY[i12] - 1.0f) <= 1.0E-5d) {
                float f = 0.0f;
                int i13 = 0;
                while (i10 < iMin) {
                    float[] fArr2 = this.mX;
                    int i14 = i13 + 1;
                    float f10 = fArr2[i13];
                    if (f10 < f) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f10);
                    }
                    fArr2[i10] = f10;
                    i10++;
                    f = f10;
                    i13 = i14;
                }
                if (pathMeasure.nextContour()) {
                    a.n("The Path should be continuous, can't have 2+ contours");
                    return;
                }
                return;
            }
        }
        int i15 = iMin - 1;
        throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.mX[0] + "," + this.mY[0] + " end:" + this.mX[i15] + "," + this.mY[i15]);
    }

    private void initQuad(float f, float f10) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f10, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            Path pathCreatePathFromPathData = PathParser.createPathFromPathData(namedString);
            if (pathCreatePathFromPathData == null) {
                throw new InflateException(a3.a.i("The path is null, which is created from ", namedString));
            }
            initPath(pathCreatePathFromPathData);
            return;
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zHasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
        if (zHasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (zHasAttribute) {
            initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            initQuad(namedFloat, namedFloat2);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float[] fArr;
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i10 = 0;
        while (true) {
            int i11 = length - i10;
            fArr = this.mX;
            if (i11 <= 1) {
                break;
            }
            int i12 = (i10 + length) / 2;
            if (f < fArr[i12]) {
                length = i12;
            } else {
                i10 = i12;
            }
        }
        float f10 = fArr[length];
        float f11 = fArr[i10];
        float f12 = f10 - f11;
        float[] fArr2 = this.mY;
        if (f12 == 0.0f) {
            return fArr2[i10];
        }
        float f13 = fArr2[i10];
        return a3.a.d(fArr2[length], f13, (f - f11) / f12, f13);
    }

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }
}
