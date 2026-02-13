package j4;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f9979a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f9980b;

    /* renamed from: c, reason: collision with root package name */
    public g f9981c;

    public j(d0 d0Var, ImageView imageView, g gVar) {
        this.f9979a = d0Var;
        this.f9980b = new WeakReference(imageView);
        this.f9981c = gVar;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            imageView.getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        WeakReference weakReference = this.f9980b;
        ImageView imageView = (ImageView) weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    imageView.removeOnAttachStateChangeListener(this);
                    viewTreeObserver.removeOnPreDrawListener(this);
                    weakReference.clear();
                    d0 d0Var = this.f9979a;
                    d0Var.f9931c = false;
                    d0Var.f9930b.e(width, height);
                    d0Var.e(imageView, this.f9981c);
                }
            }
        }
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
