package androidx.leanback.widget;

import android.graphics.Outline;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(21)
/* loaded from: classes.dex */
class RoundedRectHelperApi21 {
    private static final int MAX_CACHED_PROVIDER = 32;
    private static SparseArray<ViewOutlineProvider> sRoundedRectProvider;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class RoundedRectOutlineProvider extends ViewOutlineProvider {
        private int mRadius;

        public RoundedRectOutlineProvider(int i10) {
            this.mRadius = i10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.mRadius);
            outline.setAlpha(1.0f);
        }
    }

    private RoundedRectHelperApi21() {
    }

    public static void setClipToRoundedOutline(View view, boolean z9, int i10) {
        if (z9) {
            if (sRoundedRectProvider == null) {
                sRoundedRectProvider = new SparseArray<>();
            }
            ViewOutlineProvider roundedRectOutlineProvider = sRoundedRectProvider.get(i10);
            if (roundedRectOutlineProvider == null) {
                roundedRectOutlineProvider = new RoundedRectOutlineProvider(i10);
                if (sRoundedRectProvider.size() < 32) {
                    sRoundedRectProvider.put(i10, roundedRectOutlineProvider);
                }
            }
            view.setOutlineProvider(roundedRectOutlineProvider);
        } else {
            view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        view.setClipToOutline(z9);
    }
}
