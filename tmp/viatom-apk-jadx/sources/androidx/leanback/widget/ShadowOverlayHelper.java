package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ShadowOverlayHelper {
    public static final int SHADOW_DYNAMIC = 3;
    public static final int SHADOW_NONE = 1;
    public static final int SHADOW_STATIC = 2;
    float mFocusedZ;
    boolean mNeedsOverlay;
    boolean mNeedsRoundedCorner;
    boolean mNeedsShadow;
    boolean mNeedsWrapper;
    int mRoundedCornerRadius;
    int mShadowType = 1;
    float mUnfocusedZ;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        private boolean keepForegroundDrawable;
        private boolean needsOverlay;
        private boolean needsRoundedCorner;
        private boolean needsShadow;
        private boolean preferZOrder = true;
        private Options options = Options.DEFAULT;

        public ShadowOverlayHelper build(Context context) {
            ShadowOverlayHelper shadowOverlayHelper = new ShadowOverlayHelper();
            shadowOverlayHelper.mNeedsOverlay = this.needsOverlay;
            boolean z9 = false;
            shadowOverlayHelper.mNeedsRoundedCorner = this.needsRoundedCorner && ShadowOverlayHelper.supportsRoundedCorner();
            shadowOverlayHelper.mNeedsShadow = this.needsShadow && ShadowOverlayHelper.supportsShadow();
            if (shadowOverlayHelper.mNeedsRoundedCorner) {
                shadowOverlayHelper.setupRoundedCornerRadius(this.options, context);
            }
            if (!shadowOverlayHelper.mNeedsShadow) {
                shadowOverlayHelper.mShadowType = 1;
                if ((!ShadowOverlayHelper.supportsForeground() || this.keepForegroundDrawable) && shadowOverlayHelper.mNeedsOverlay) {
                    z9 = true;
                }
                shadowOverlayHelper.mNeedsWrapper = z9;
                return shadowOverlayHelper;
            }
            if (!this.preferZOrder || !ShadowOverlayHelper.supportsDynamicShadow()) {
                shadowOverlayHelper.mShadowType = 2;
                shadowOverlayHelper.mNeedsWrapper = true;
                return shadowOverlayHelper;
            }
            shadowOverlayHelper.mShadowType = 3;
            shadowOverlayHelper.setupDynamicShadowZ(this.options, context);
            if ((!ShadowOverlayHelper.supportsForeground() || this.keepForegroundDrawable) && shadowOverlayHelper.mNeedsOverlay) {
                z9 = true;
            }
            shadowOverlayHelper.mNeedsWrapper = z9;
            return shadowOverlayHelper;
        }

        public Builder keepForegroundDrawable(boolean z9) {
            this.keepForegroundDrawable = z9;
            return this;
        }

        public Builder needsOverlay(boolean z9) {
            this.needsOverlay = z9;
            return this;
        }

        public Builder needsRoundedCorner(boolean z9) {
            this.needsRoundedCorner = z9;
            return this;
        }

        public Builder needsShadow(boolean z9) {
            this.needsShadow = z9;
            return this;
        }

        public Builder options(Options options) {
            this.options = options;
            return this;
        }

        public Builder preferZOrder(boolean z9) {
            this.preferZOrder = z9;
            return this;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Options {
        public static final Options DEFAULT = new Options();
        private int roundedCornerRadius = 0;
        private float dynamicShadowUnfocusedZ = -1.0f;
        private float dynamicShadowFocusedZ = -1.0f;

        public Options dynamicShadowZ(float f, float f10) {
            this.dynamicShadowUnfocusedZ = f;
            this.dynamicShadowFocusedZ = f10;
            return this;
        }

        public final float getDynamicShadowFocusedZ() {
            return this.dynamicShadowFocusedZ;
        }

        public final float getDynamicShadowUnfocusedZ() {
            return this.dynamicShadowUnfocusedZ;
        }

        public final int getRoundedCornerRadius() {
            return this.roundedCornerRadius;
        }

        public Options roundedCornerRadius(int i10) {
            this.roundedCornerRadius = i10;
            return this;
        }
    }

    public static Object getNoneWrapperDynamicShadowImpl(View view) {
        return view.getTag(androidx.leanback.R.id.lb_shadow_impl);
    }

    public static void setNoneWrapperOverlayColor(View view, int i10) {
        Drawable foreground = ForegroundHelper.getForeground(view);
        if (foreground instanceof ColorDrawable) {
            ((ColorDrawable) foreground).setColor(i10);
        } else {
            ForegroundHelper.setForeground(view, new ColorDrawable(i10));
        }
    }

    public static void setNoneWrapperShadowFocusLevel(View view, float f) {
        setShadowFocusLevel(getNoneWrapperDynamicShadowImpl(view), 3, f);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0007 A[PHI: r0
      0x0007: PHI (r0v4 float) = (r0v0 float), (r0v1 float) binds: [B:4:0x0005, B:7:0x000d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void setShadowFocusLevel(java.lang.Object r2, int r3, float r4) {
        /*
            if (r2 == 0) goto L1e
            r0 = 0
            int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r1 >= 0) goto L9
        L7:
            r4 = r0
            goto L10
        L9:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r1 <= 0) goto L10
            goto L7
        L10:
            r0 = 2
            if (r3 == r0) goto L1b
            r0 = 3
            if (r3 == r0) goto L17
            goto L1e
        L17:
            androidx.leanback.widget.ShadowHelper.setShadowFocusLevel(r2, r4)
            return
        L1b:
            androidx.leanback.widget.StaticShadowHelper.setShadowFocusLevel(r2, r4)
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ShadowOverlayHelper.setShadowFocusLevel(java.lang.Object, int, float):void");
    }

    public static boolean supportsDynamicShadow() {
        return ShadowHelper.supportsDynamicShadow();
    }

    public static boolean supportsForeground() {
        return ForegroundHelper.supportsForeground();
    }

    public static boolean supportsRoundedCorner() {
        return RoundedRectHelper.supportsRoundedCorner();
    }

    public static boolean supportsShadow() {
        return StaticShadowHelper.supportsShadow();
    }

    public ShadowOverlayContainer createShadowOverlayContainer(Context context) {
        if (needsWrapper()) {
            return new ShadowOverlayContainer(context, this.mShadowType, this.mNeedsOverlay, this.mUnfocusedZ, this.mFocusedZ, this.mRoundedCornerRadius);
        }
        f.a();
        return null;
    }

    public int getShadowType() {
        return this.mShadowType;
    }

    public boolean needsOverlay() {
        return this.mNeedsOverlay;
    }

    public boolean needsRoundedCorner() {
        return this.mNeedsRoundedCorner;
    }

    public boolean needsWrapper() {
        return this.mNeedsWrapper;
    }

    public void onViewCreated(View view) {
        if (needsWrapper()) {
            return;
        }
        if (!this.mNeedsShadow) {
            if (this.mNeedsRoundedCorner) {
                RoundedRectHelper.setClipToRoundedOutline(view, true, this.mRoundedCornerRadius);
            }
        } else if (this.mShadowType == 3) {
            view.setTag(androidx.leanback.R.id.lb_shadow_impl, ShadowHelper.addDynamicShadow(view, this.mUnfocusedZ, this.mFocusedZ, this.mRoundedCornerRadius));
        } else if (this.mNeedsRoundedCorner) {
            RoundedRectHelper.setClipToRoundedOutline(view, true, this.mRoundedCornerRadius);
        }
    }

    public void prepareParentForShadow(ViewGroup viewGroup) {
        if (this.mShadowType == 2) {
            StaticShadowHelper.prepareParent(viewGroup);
        }
    }

    public void setOverlayColor(View view, int i10) {
        if (needsWrapper()) {
            ((ShadowOverlayContainer) view).setOverlayColor(i10);
        } else {
            setNoneWrapperOverlayColor(view, i10);
        }
    }

    public void setupDynamicShadowZ(Options options, Context context) {
        if (options.getDynamicShadowUnfocusedZ() >= 0.0f) {
            this.mFocusedZ = options.getDynamicShadowFocusedZ();
            this.mUnfocusedZ = options.getDynamicShadowUnfocusedZ();
        } else {
            Resources resources = context.getResources();
            this.mFocusedZ = resources.getDimension(androidx.leanback.R.dimen.lb_material_shadow_focused_z);
            this.mUnfocusedZ = resources.getDimension(androidx.leanback.R.dimen.lb_material_shadow_normal_z);
        }
    }

    public void setupRoundedCornerRadius(Options options, Context context) {
        if (options.getRoundedCornerRadius() == 0) {
            this.mRoundedCornerRadius = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_rounded_rect_corner_radius);
        } else {
            this.mRoundedCornerRadius = options.getRoundedCornerRadius();
        }
    }

    public void setShadowFocusLevel(View view, float f) {
        if (needsWrapper()) {
            ((ShadowOverlayContainer) view).setShadowFocusLevel(f);
        } else {
            setShadowFocusLevel(getNoneWrapperDynamicShadowImpl(view), 3, f);
        }
    }
}
