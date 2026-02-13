package androidx.viewpager2.widget;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WindowInsetsApplier implements OnApplyWindowInsetsListener {
    private WindowInsetsApplier() {
    }

    private WindowInsetsCompat consumeAllInsets(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.CONSUMED;
        return windowInsetsCompat2.toWindowInsets() != null ? windowInsetsCompat2 : windowInsetsCompat.consumeSystemWindowInsets().consumeStableInsets();
    }

    public static boolean install(@NonNull ViewPager2 viewPager2) {
        ApplicationInfo applicationInfo = viewPager2.getContext().getApplicationInfo();
        if (Build.VERSION.SDK_INT >= 30 && applicationInfo.targetSdkVersion >= 30) {
            return false;
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewPager2, new WindowInsetsApplier());
        return true;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    @NonNull
    public WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        ViewPager2 viewPager2 = (ViewPager2) view;
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(viewPager2, windowInsetsCompat);
        if (windowInsetsCompatOnApplyWindowInsets.isConsumed()) {
            return windowInsetsCompatOnApplyWindowInsets;
        }
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ViewCompat.dispatchApplyWindowInsets(recyclerView.getChildAt(i10), new WindowInsetsCompat(windowInsetsCompatOnApplyWindowInsets));
        }
        return consumeAllInsets(windowInsetsCompatOnApplyWindowInsets);
    }
}
