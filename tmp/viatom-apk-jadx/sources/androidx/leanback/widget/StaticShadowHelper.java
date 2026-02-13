package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class StaticShadowHelper {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ShadowImpl {
        View mFocusShadow;
        View mNormalShadow;
    }

    private StaticShadowHelper() {
    }

    public static Object addStaticShadow(ViewGroup viewGroup) {
        viewGroup.setLayoutMode(1);
        LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_shadow, viewGroup, true);
        ShadowImpl shadowImpl = new ShadowImpl();
        shadowImpl.mNormalShadow = viewGroup.findViewById(androidx.leanback.R.id.lb_shadow_normal);
        shadowImpl.mFocusShadow = viewGroup.findViewById(androidx.leanback.R.id.lb_shadow_focused);
        return shadowImpl;
    }

    public static void prepareParent(ViewGroup viewGroup) {
        viewGroup.setLayoutMode(1);
    }

    public static void setShadowFocusLevel(Object obj, float f) {
        ShadowImpl shadowImpl = (ShadowImpl) obj;
        shadowImpl.mNormalShadow.setAlpha(1.0f - f);
        shadowImpl.mFocusShadow.setAlpha(f);
    }

    public static boolean supportsShadow() {
        return true;
    }
}
