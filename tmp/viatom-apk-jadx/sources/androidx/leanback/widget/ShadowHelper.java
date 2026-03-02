package androidx.leanback.widget;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ShadowHelper {
    private ShadowHelper() {
    }

    public static Object addDynamicShadow(View view, float f, float f10, int i10) {
        return ShadowHelperApi21.addDynamicShadow(view, f, f10, i10);
    }

    public static void setShadowFocusLevel(Object obj, float f) {
        ShadowHelperApi21.setShadowFocusLevel(obj, f);
    }

    public static boolean supportsDynamicShadow() {
        return true;
    }
}
