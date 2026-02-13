package androidx.leanback.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(21)
/* loaded from: classes.dex */
class ShadowHelperApi21 {
    static final ViewOutlineProvider sOutlineProvider = new ViewOutlineProvider() { // from class: androidx.leanback.widget.ShadowHelperApi21.1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
            outline.setAlpha(1.0f);
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ShadowImpl {
        float mFocusedZ;
        float mNormalZ;
        View mShadowContainer;
    }

    private ShadowHelperApi21() {
    }

    public static Object addDynamicShadow(View view, float f, float f10, int i10) {
        if (i10 > 0) {
            RoundedRectHelperApi21.setClipToRoundedOutline(view, true, i10);
        } else {
            view.setOutlineProvider(sOutlineProvider);
        }
        ShadowImpl shadowImpl = new ShadowImpl();
        shadowImpl.mShadowContainer = view;
        shadowImpl.mNormalZ = f;
        shadowImpl.mFocusedZ = f10;
        view.setZ(f);
        return shadowImpl;
    }

    public static void setShadowFocusLevel(Object obj, float f) {
        ShadowImpl shadowImpl = (ShadowImpl) obj;
        View view = shadowImpl.mShadowContainer;
        float f10 = shadowImpl.mNormalZ;
        view.setZ(((shadowImpl.mFocusedZ - f10) * f) + f10);
    }
}
