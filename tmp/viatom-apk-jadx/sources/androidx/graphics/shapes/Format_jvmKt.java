package androidx.graphics.shapes;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Format_jvmKt {
    public static final String toStringWithLessPrecision(float f) {
        return String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
    }
}
