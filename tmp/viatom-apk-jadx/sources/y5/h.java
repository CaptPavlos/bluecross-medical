package y5;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13873a;

    public final void a(ProgressBar progressBar, ImageView imageView) {
        progressBar.getClass();
        imageView.getClass();
        if (progressBar.getVisibility() != 0 || this.f13873a) {
            return;
        }
        this.f13873a = true;
        this.itemView.getContext().getClass();
        androidx.work.impl.utils.c cVar = new androidx.work.impl.utils.c(12, progressBar, this);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.6f, 1.0f);
        valueAnimatorOfFloat.setStartDelay(200L);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new z5.g(imageView, 1));
        valueAnimatorOfFloat.addListener(new z5.h(cVar, 0));
        valueAnimatorOfFloat.start();
    }

    public final void b(ProgressBar progressBar, ImageView imageView) {
        progressBar.getClass();
        imageView.getClass();
        if (progressBar.getVisibility() != 8 || this.f13873a) {
            return;
        }
        int i10 = 0;
        progressBar.setVisibility(0);
        this.f13873a = true;
        this.itemView.getContext().getClass();
        g gVar = new g(this, i10);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.6f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new z5.g(imageView, i10));
        valueAnimatorOfFloat.addListener(new z5.h(gVar, 1));
        valueAnimatorOfFloat.start();
    }
}
