package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(34)
/* loaded from: classes.dex */
public final class Api34Impl {
    public static final Api34Impl INSTANCE = new Api34Impl();

    private Api34Impl() {
    }

    @DoNotInline
    public final BackEvent createOnBackEvent(float f, float f10, float f11, int i10) {
        return new BackEvent(f, f10, f11, i10);
    }

    @DoNotInline
    public final float progress(BackEvent backEvent) {
        backEvent.getClass();
        return backEvent.getProgress();
    }

    @DoNotInline
    public final int swipeEdge(BackEvent backEvent) {
        backEvent.getClass();
        return backEvent.getSwipeEdge();
    }

    @DoNotInline
    public final float touchX(BackEvent backEvent) {
        backEvent.getClass();
        return backEvent.getTouchX();
    }

    @DoNotInline
    public final float touchY(BackEvent backEvent) {
        backEvent.getClass();
        return backEvent.getTouchY();
    }
}
