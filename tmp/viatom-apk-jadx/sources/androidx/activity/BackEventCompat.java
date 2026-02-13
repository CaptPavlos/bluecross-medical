package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.color.utilities.Contrast;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class BackEventCompat {
    public static final Companion Companion = new Companion(null);
    public static final int EDGE_LEFT = 0;
    public static final int EDGE_RIGHT = 1;
    private final float progress;
    private final int swipeEdge;
    private final float touchX;
    private final float touchY;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface SwipeEdge {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresApi(34)
    public BackEventCompat(BackEvent backEvent) {
        backEvent.getClass();
        Api34Impl api34Impl = Api34Impl.INSTANCE;
        this(api34Impl.touchX(backEvent), api34Impl.touchY(backEvent), api34Impl.progress(backEvent), api34Impl.swipeEdge(backEvent));
    }

    public final float getProgress() {
        return this.progress;
    }

    public final int getSwipeEdge() {
        return this.swipeEdge;
    }

    public final float getTouchX() {
        return this.touchX;
    }

    public final float getTouchY() {
        return this.touchY;
    }

    @RequiresApi(34)
    public final BackEvent toBackEvent() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.INSTANCE.createOnBackEvent(this.touchX, this.touchY, this.progress, this.swipeEdge);
        }
        a2.a.m("This method is only supported on API level 34+");
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BackEventCompat{touchX=");
        sb.append(this.touchX);
        sb.append(", touchY=");
        sb.append(this.touchY);
        sb.append(", progress=");
        sb.append(this.progress);
        sb.append(", swipeEdge=");
        return a3.a.k(sb, this.swipeEdge, '}');
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }
    }

    @VisibleForTesting
    public BackEventCompat(float f, float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11, int i10) {
        this.touchX = f;
        this.touchY = f10;
        this.progress = f11;
        this.swipeEdge = i10;
    }
}
