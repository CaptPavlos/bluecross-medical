package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {
    private Path mOriginalPatternPath;

    @NonNull
    private final Path mPatternPath;
    private final Matrix mTempMatrix;

    public PatternPathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.PATTERN_PATH_MOTION);
        try {
            String namedString = TypedArrayUtils.getNamedString(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (namedString == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            setPatternPath(PathParser.createPathFromPathData(namedString));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private static float distance(float f, float f10) {
        return (float) Math.sqrt((f10 * f10) + (f * f));
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f, float f10, float f11, float f12) {
        float f13 = f11 - f;
        float f14 = f12 - f10;
        float fDistance = distance(f13, f14);
        double dAtan2 = Math.atan2(f14, f13);
        this.mTempMatrix.setScale(fDistance, fDistance);
        this.mTempMatrix.postRotate((float) Math.toDegrees(dAtan2));
        this.mTempMatrix.postTranslate(f, f10);
        Path path = new Path();
        this.mPatternPath.transform(this.mTempMatrix, path);
        return path;
    }

    @NonNull
    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(@NonNull Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f10 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f11 = fArr[0];
        float f12 = fArr[1];
        if (f11 == f && f12 == f10) {
            com.google.gson.internal.a.n("pattern must not end at the starting point");
            return;
        }
        this.mTempMatrix.setTranslate(-f11, -f12);
        float f13 = f - f11;
        float f14 = f10 - f12;
        float fDistance = 1.0f / distance(f13, f14);
        this.mTempMatrix.postScale(fDistance, fDistance);
        this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2(f14, f13)));
        path.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = path;
    }

    public PatternPathMotion() {
        Path path = new Path();
        this.mPatternPath = path;
        this.mTempMatrix = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = path;
    }

    public PatternPathMotion(@NonNull Path path) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        setPatternPath(path);
    }
}
