package l4;

import androidx.viewpager2.widget.ViewPager2;
import com.uptodown.activities.Gallery;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a1 extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Gallery f10207a;

    public a1(Gallery gallery) {
        this.f10207a = gallery;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageSelected(int i10) {
        super.onPageSelected(i10);
        int i11 = Gallery.K;
        this.f10207a.o0(i10);
    }
}
