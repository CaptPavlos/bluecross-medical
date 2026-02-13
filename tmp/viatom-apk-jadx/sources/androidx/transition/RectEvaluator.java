package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i10 = rect.left + ((int) ((rect2.left - r0) * f));
        int i11 = rect.top + ((int) ((rect2.top - r1) * f));
        int i12 = rect.right + ((int) ((rect2.right - r2) * f));
        int i13 = rect.bottom + ((int) ((rect2.bottom - r6) * f));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i10, i11, i12, i13);
        }
        rect3.set(i10, i11, i12, i13);
        return this.mRect;
    }

    public RectEvaluator() {
    }
}
