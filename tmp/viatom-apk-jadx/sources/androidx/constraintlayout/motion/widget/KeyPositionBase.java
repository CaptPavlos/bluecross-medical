package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    public abstract void calcPosition(int i10, int i11, float f, float f10, float f11, float f12);

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int i10, int i11, RectF rectF, RectF rectF2, float f, float f10);

    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f10, String[] strArr, float[] fArr);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }
}
