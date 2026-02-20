package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.google.android.material.color.MaterialColors;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    private EdgeToEdgeUtils() {
    }

    public static void applyEdgeToEdge(@NonNull Window window, boolean z9, @Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2) {
        boolean z10 = num == null || num.intValue() == 0;
        boolean z11 = num2 == null || num2.intValue() == 0;
        if (z10 || z11) {
            int color = MaterialColors.getColor(window.getContext(), R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
            if (z10) {
                num = Integer.valueOf(color);
            }
            if (z11) {
                num2 = Integer.valueOf(color);
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, !z9);
        int statusBarColor = getStatusBarColor(window.getContext(), z9);
        int navigationBarColor = getNavigationBarColor(window.getContext(), z9);
        window.setStatusBarColor(statusBarColor);
        window.setNavigationBarColor(navigationBarColor);
        setLightStatusBar(window, isUsingLightSystemBar(statusBarColor, MaterialColors.isColorLight(num.intValue())));
        setLightNavigationBar(window, isUsingLightSystemBar(navigationBarColor, MaterialColors.isColorLight(num2.intValue())));
    }

    private static int getNavigationBarColor(Context context, boolean z9) {
        if (z9 && Build.VERSION.SDK_INT < 27) {
            return ColorUtils.setAlphaComponent(MaterialColors.getColor(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
        }
        if (z9) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    private static int getStatusBarColor(Context context, boolean z9) {
        if (z9) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    private static boolean isUsingLightSystemBar(int i10, boolean z9) {
        if (MaterialColors.isColorLight(i10)) {
            return true;
        }
        return i10 == 0 && z9;
    }

    public static void setLightNavigationBar(@NonNull Window window, boolean z9) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z9);
    }

    public static void setLightStatusBar(@NonNull Window window, boolean z9) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(z9);
    }

    public static void applyEdgeToEdge(@NonNull Window window, boolean z9) {
        applyEdgeToEdge(window, z9, null, null);
    }
}
