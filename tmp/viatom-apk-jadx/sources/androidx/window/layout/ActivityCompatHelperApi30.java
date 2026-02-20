package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(30)
/* loaded from: classes.dex */
public final class ActivityCompatHelperApi30 {
    public static final ActivityCompatHelperApi30 INSTANCE = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    public final Rect currentWindowBounds(Activity activity) {
        activity.getClass();
        Rect bounds = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        bounds.getClass();
        return bounds;
    }

    public final Rect maximumWindowBounds(Activity activity) {
        activity.getClass();
        Rect bounds = activity.getWindowManager().getMaximumWindowMetrics().getBounds();
        bounds.getClass();
        return bounds;
    }
}
