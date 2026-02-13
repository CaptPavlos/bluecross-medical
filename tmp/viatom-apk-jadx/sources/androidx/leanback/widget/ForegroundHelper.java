package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ForegroundHelper {
    private ForegroundHelper() {
    }

    public static Drawable getForeground(View view) {
        return view.getForeground();
    }

    public static void setForeground(View view, Drawable drawable) {
        view.setForeground(drawable);
    }

    public static boolean supportsForeground() {
        return true;
    }
}
