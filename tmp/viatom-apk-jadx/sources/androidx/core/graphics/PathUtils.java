package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PathUtils {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float[] approximate(Path path, float f) {
            return path.approximate(f);
        }
    }

    private PathUtils() {
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f) {
        float[] fArrApproximate = Api26Impl.approximate(path, f);
        int length = fArrApproximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 1; i10 < length; i10++) {
            int i11 = i10 * 3;
            int i12 = (i10 - 1) * 3;
            float f10 = fArrApproximate[i11];
            float f11 = fArrApproximate[i11 + 1];
            float f12 = fArrApproximate[i11 + 2];
            float f13 = fArrApproximate[i12];
            float f14 = fArrApproximate[i12 + 1];
            float f15 = fArrApproximate[i12 + 2];
            if (f10 != f13 && (f11 != f14 || f12 != f15)) {
                arrayList.add(new PathSegment(new PointF(f14, f15), f13, new PointF(f11, f12), f10));
            }
        }
        return arrayList;
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }
}
