package androidx.leanback.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.view.View;
import androidx.leanback.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ColorFilterDimmer {
    private final float mActiveLevel;
    private final ColorFilterCache mColorDimmer;
    private final float mDimmedLevel;
    private ColorFilter mFilter;
    private final Paint mPaint;

    private ColorFilterDimmer(ColorFilterCache colorFilterCache, float f, float f10) {
        this.mColorDimmer = colorFilterCache;
        f = f > 1.0f ? 1.0f : f;
        f = f < 0.0f ? 0.0f : f;
        f10 = f10 > 1.0f ? 1.0f : f10;
        float f11 = f10 >= 0.0f ? f10 : 0.0f;
        this.mActiveLevel = f;
        this.mDimmedLevel = f11;
        this.mPaint = new Paint();
    }

    public static ColorFilterDimmer create(ColorFilterCache colorFilterCache, float f, float f10) {
        return new ColorFilterDimmer(colorFilterCache, f, f10);
    }

    public static ColorFilterDimmer createDefault(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = typedArrayObtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = typedArrayObtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        typedArrayObtainStyledAttributes.recycle();
        return new ColorFilterDimmer(ColorFilterCache.getColorFilterCache(color), fraction, fraction2);
    }

    public void applyFilterToView(View view) {
        if (this.mFilter != null) {
            view.setLayerType(2, this.mPaint);
        } else {
            view.setLayerType(0, null);
        }
        view.invalidate();
    }

    public ColorFilter getColorFilter() {
        return this.mFilter;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public void setActiveLevel(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        ColorFilterCache colorFilterCache = this.mColorDimmer;
        float f10 = this.mDimmedLevel;
        ColorFilter filterForLevel = colorFilterCache.getFilterForLevel(((this.mActiveLevel - f10) * f) + f10);
        this.mFilter = filterForLevel;
        this.mPaint.setColorFilter(filterForLevel);
    }
}
