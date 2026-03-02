package androidx.leanback.graphics;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.SparseArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ColorFilterCache {
    private static final SparseArray<ColorFilterCache> sColorToFiltersMap = new SparseArray<>();
    private final PorterDuffColorFilter[] mFilters = new PorterDuffColorFilter[256];

    private ColorFilterCache(int i10, int i11, int i12) {
        for (int i13 = 0; i13 <= 255; i13++) {
            this.mFilters[i13] = new PorterDuffColorFilter(Color.argb(i13, i10, i11, i12), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static ColorFilterCache getColorFilterCache(int i10) {
        int iRed = Color.red(i10);
        int iGreen = Color.green(i10);
        int iBlue = Color.blue(i10);
        int iRgb = Color.rgb(iRed, iGreen, iBlue);
        SparseArray<ColorFilterCache> sparseArray = sColorToFiltersMap;
        ColorFilterCache colorFilterCache = sparseArray.get(iRgb);
        if (colorFilterCache != null) {
            return colorFilterCache;
        }
        ColorFilterCache colorFilterCache2 = new ColorFilterCache(iRed, iGreen, iBlue);
        sparseArray.put(iRgb, colorFilterCache2);
        return colorFilterCache2;
    }

    public ColorFilter getFilterForLevel(float f) {
        if (f < 0.0f || f > 1.0d) {
            return null;
        }
        return this.mFilters[(int) (f * 255.0f)];
    }
}
