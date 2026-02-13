package y5;

import android.animation.ValueAnimator;
import android.widget.TextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class p0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13963a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f13964b;

    public /* synthetic */ p0(q0 q0Var, int i10) {
        this.f13963a = i10;
        this.f13964b = q0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f13963a) {
            case 0:
                valueAnimator.getClass();
                Object animatedValue = valueAnimator.getAnimatedValue();
                animatedValue.getClass();
                float fFloatValue = ((Float) animatedValue).floatValue();
                TextView textView = this.f13964b.f13975d;
                textView.setScaleX(fFloatValue);
                textView.setScaleY(fFloatValue);
                int i10 = (int) ((1 - fFloatValue) * 10);
                textView.setPadding(i10, i10, i10, i10);
                break;
            default:
                valueAnimator.getClass();
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                animatedValue2.getClass();
                float fFloatValue2 = ((Float) animatedValue2).floatValue();
                TextView textView2 = this.f13964b.f13975d;
                textView2.setScaleX(fFloatValue2);
                textView2.setScaleY(fFloatValue2);
                int i11 = (int) ((1 - fFloatValue2) * 10);
                textView2.setPadding(i11, i11, i11, i11);
                break;
        }
    }
}
