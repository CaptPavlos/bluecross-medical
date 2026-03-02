package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.window.layout.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(@Px int i10) {
        Preconditions.checkArgumentNonnegative(i10, "Margin must be non-negative");
        this.mMarginPx = i10;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        c.g("Expected the page view to be managed by a ViewPager2 instance.");
        return null;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        ViewPager2 viewPager2RequireViewPager = requireViewPager(view);
        float f10 = this.mMarginPx * f;
        if (viewPager2RequireViewPager.getOrientation() != 0) {
            view.setTranslationY(f10);
            return;
        }
        if (viewPager2RequireViewPager.isRtl()) {
            f10 = -f10;
        }
        view.setTranslationX(f10);
    }
}
