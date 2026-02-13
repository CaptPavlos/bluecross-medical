package androidx.leanback.widget;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class RoundedRectHelper {
    private RoundedRectHelper() {
    }

    public static void setClipToRoundedOutline(View view, boolean z9) {
        RoundedRectHelperApi21.setClipToRoundedOutline(view, z9, view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_rounded_rect_corner_radius));
    }

    public static boolean supportsRoundedCorner() {
        return true;
    }

    public static void setClipToRoundedOutline(View view, boolean z9, int i10) {
        RoundedRectHelperApi21.setClipToRoundedOutline(view, z9, i10);
    }
}
