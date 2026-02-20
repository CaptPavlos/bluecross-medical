package d5;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f7291a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f7292b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f7293c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f7294d;
    public final ViewPager2 e;

    public q(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, ViewPager2 viewPager2) {
        this.f7291a = relativeLayout;
        this.f7292b = imageView;
        this.f7293c = relativeLayout2;
        this.f7294d = textView;
        this.e = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f7291a;
    }
}
