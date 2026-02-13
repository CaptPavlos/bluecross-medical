package z5;

import android.animation.ValueAnimator;
import android.widget.ImageView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14431a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f14432b;

    public /* synthetic */ g(ImageView imageView, int i10) {
        this.f14431a = i10;
        this.f14432b = imageView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f14431a) {
            case 0:
                valueAnimator.getClass();
                Object animatedValue = valueAnimator.getAnimatedValue();
                animatedValue.getClass();
                float fFloatValue = ((Float) animatedValue).floatValue();
                ImageView imageView = this.f14432b;
                imageView.setScaleX(fFloatValue);
                imageView.setScaleY(fFloatValue);
                int i10 = (int) ((1 - fFloatValue) * 10);
                imageView.setPadding(i10, i10, i10, i10);
                break;
            default:
                valueAnimator.getClass();
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                animatedValue2.getClass();
                float fFloatValue2 = ((Float) animatedValue2).floatValue();
                ImageView imageView2 = this.f14432b;
                imageView2.setScaleX(fFloatValue2);
                imageView2.setScaleY(fFloatValue2);
                int i11 = (int) ((1 - fFloatValue2) * 10);
                imageView2.setPadding(i11, i11, i11, i11);
                break;
        }
    }
}
