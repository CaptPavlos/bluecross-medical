package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CornerRounding {
    public static final Companion Companion;
    public static final CornerRounding Unrounded;
    private final float radius;
    private final float smoothing;

    static {
        g gVar = null;
        Companion = new Companion(gVar);
        float f = 0.0f;
        Unrounded = new CornerRounding(f, f, 3, gVar);
    }

    public /* synthetic */ CornerRounding(float f, float f10, int i10, g gVar) {
        this((i10 & 1) != 0 ? 0.0f : f, (i10 & 2) != 0 ? 0.0f : f10);
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public CornerRounding(@FloatRange(from = 0.0d) float f, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        this.radius = f;
        this.smoothing = f10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CornerRounding() {
        float f = 0.0f;
        this(f, f, 3, null);
    }
}
