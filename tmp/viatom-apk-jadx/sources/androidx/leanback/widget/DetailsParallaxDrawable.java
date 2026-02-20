package androidx.leanback.widget;

import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import androidx.leanback.graphics.CompositeDrawable;
import androidx.leanback.graphics.FitWidthBitmapDrawable;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxTarget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class DetailsParallaxDrawable extends CompositeDrawable {
    private Drawable mBottomDrawable;

    public DetailsParallaxDrawable(Context context, DetailsParallax detailsParallax) throws Resources.NotFoundException {
        int i10 = -context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_cover_drawable_parallax_movement);
        FitWidthBitmapDrawable fitWidthBitmapDrawable = new FitWidthBitmapDrawable();
        init(context, detailsParallax, fitWidthBitmapDrawable, new ColorDrawable(), new ParallaxTarget.PropertyValuesHolderTarget(fitWidthBitmapDrawable, PropertyValuesHolder.ofInt("verticalOffset", 0, i10)));
    }

    private static int getDefaultBackgroundColor(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(androidx.leanback.R.attr.defaultBrandColorDark, typedValue, true) ? context.getResources().getColor(typedValue.resourceId) : context.getResources().getColor(androidx.leanback.R.color.lb_default_brand_color_dark);
    }

    public void connect(Context context, DetailsParallax detailsParallax, ParallaxTarget parallaxTarget) throws Resources.NotFoundException {
        Parallax.IntProperty overviewRowTop = detailsParallax.getOverviewRowTop();
        Parallax.IntProperty overviewRowBottom = detailsParallax.getOverviewRowBottom();
        detailsParallax.addEffect(overviewRowTop.atAbsolute(context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_align_pos_for_actions)), overviewRowTop.atAbsolute(context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_align_pos_for_description))).target(parallaxTarget);
        detailsParallax.addEffect(overviewRowBottom.atMax(), overviewRowBottom.atMin()).target((ParallaxEffect) getChildAt(1), (Property<ParallaxEffect, V>) CompositeDrawable.ChildDrawable.TOP_ABSOLUTE);
        detailsParallax.addEffect(overviewRowTop.atMax(), overviewRowTop.atMin()).target((ParallaxEffect) getChildAt(0), (Property<ParallaxEffect, V>) CompositeDrawable.ChildDrawable.BOTTOM_ABSOLUTE);
    }

    public Drawable getBottomDrawable() {
        return this.mBottomDrawable;
    }

    public Drawable getCoverDrawable() {
        return getChildAt(0).getDrawable();
    }

    @ColorInt
    public int getSolidColor() {
        return ((ColorDrawable) this.mBottomDrawable).getColor();
    }

    public void init(Context context, DetailsParallax detailsParallax, Drawable drawable, Drawable drawable2, ParallaxTarget parallaxTarget) throws Resources.NotFoundException {
        if (drawable2 instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) drawable2;
            if (colorDrawable.getColor() == 0) {
                colorDrawable.setColor(getDefaultBackgroundColor(context));
            }
        }
        addChildDrawable(drawable);
        this.mBottomDrawable = drawable2;
        addChildDrawable(drawable2);
        connect(context, detailsParallax, parallaxTarget);
    }

    public void setSolidColor(@ColorInt int i10) {
        ((ColorDrawable) this.mBottomDrawable).setColor(i10);
    }

    public DetailsParallaxDrawable(Context context, DetailsParallax detailsParallax, Drawable drawable, Drawable drawable2, ParallaxTarget parallaxTarget) throws Resources.NotFoundException {
        init(context, detailsParallax, drawable, drawable2, parallaxTarget);
    }

    public DetailsParallaxDrawable(Context context, DetailsParallax detailsParallax, Drawable drawable, ParallaxTarget parallaxTarget) throws Resources.NotFoundException {
        init(context, detailsParallax, drawable, new ColorDrawable(), parallaxTarget);
    }
}
