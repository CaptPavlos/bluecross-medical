package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i10, float f, int i11) {
        if (this.mPageTransformer == null) {
            return;
        }
        float f10 = -f;
        for (int i12 = 0; i12 < this.mLayoutManager.getChildCount(); i12++) {
            View childAt = this.mLayoutManager.getChildAt(i12);
            if (childAt == null) {
                Locale locale = Locale.US;
                a.k("LayoutManager returned a null child at pos ", i12, "/", this.mLayoutManager.getChildCount(), " while transforming pages");
                return;
            }
            this.mPageTransformer.transformPage(childAt, (this.mLayoutManager.getPosition(childAt) - i10) + f10);
        }
    }

    public void setPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i10) {
    }
}
