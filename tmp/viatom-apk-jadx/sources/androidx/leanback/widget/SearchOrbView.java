package androidx.leanback.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class SearchOrbView extends FrameLayout implements View.OnClickListener {
    private boolean mAttachedToWindow;
    private boolean mColorAnimationEnabled;
    private ValueAnimator mColorAnimator;
    private final ArgbEvaluator mColorEvaluator;
    private Colors mColors;
    private final ValueAnimator.AnimatorUpdateListener mFocusUpdateListener;
    private final float mFocusedZ;
    private final float mFocusedZoom;
    private final ImageView mIcon;
    private Drawable mIconDrawable;
    private View.OnClickListener mListener;
    private final int mPulseDurationMs;
    private final View mRootView;
    private final int mScaleDurationMs;
    private final View mSearchOrbView;
    private ValueAnimator mShadowFocusAnimator;
    private final float mUnfocusedZ;
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener;

    @SuppressLint({"CustomViewStyleable"})
    public SearchOrbView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mColorEvaluator = new ArgbEvaluator();
        final int i11 = 0;
        this.mUpdateListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: androidx.leanback.widget.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SearchOrbView f568b;

            {
                this.f568b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case 0:
                        this.f568b.lambda$new$0(valueAnimator);
                        break;
                    default:
                        this.f568b.lambda$new$1(valueAnimator);
                        break;
                }
            }
        };
        final int i12 = 1;
        this.mFocusUpdateListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: androidx.leanback.widget.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SearchOrbView f568b;

            {
                this.f568b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i12) {
                    case 0:
                        this.f568b.lambda$new$0(valueAnimator);
                        break;
                    default:
                        this.f568b.lambda$new$1(valueAnimator);
                        break;
                }
            }
        };
        Resources resources = context.getResources();
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResourceId(), (ViewGroup) this, true);
        this.mRootView = viewInflate;
        this.mSearchOrbView = viewInflate.findViewById(androidx.leanback.R.id.search_orb);
        ImageView imageView = (ImageView) viewInflate.findViewById(androidx.leanback.R.id.icon);
        this.mIcon = imageView;
        this.mFocusedZoom = context.getResources().getFraction(androidx.leanback.R.fraction.lb_search_orb_focused_zoom, 1, 1);
        this.mPulseDurationMs = context.getResources().getInteger(androidx.leanback.R.integer.lb_search_orb_pulse_duration_ms);
        this.mScaleDurationMs = context.getResources().getInteger(androidx.leanback.R.integer.lb_search_orb_scale_duration_ms);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_orb_focused_z);
        this.mFocusedZ = dimensionPixelSize;
        this.mUnfocusedZ = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_orb_unfocused_z);
        int[] iArr = androidx.leanback.R.styleable.lbSearchOrbView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbIcon);
        setOrbIcon(drawable == null ? resources.getDrawable(androidx.leanback.R.drawable.lb_ic_in_app_search) : drawable);
        int color = typedArrayObtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbColor, resources.getColor(androidx.leanback.R.color.lb_default_search_color));
        setOrbColors(new Colors(color, typedArrayObtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbBrightColor, color), typedArrayObtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbIconColor, 0)));
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClipChildren(false);
        setOnClickListener(this);
        setSoundEffectsEnabled(false);
        setSearchOrbZ(0.0f);
        ViewCompat.setZ(imageView, dimensionPixelSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ValueAnimator valueAnimator) {
        setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(ValueAnimator valueAnimator) {
        setSearchOrbZ(valueAnimator.getAnimatedFraction());
    }

    private void startShadowFocusAnimation(boolean z9, int i10) {
        if (this.mShadowFocusAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mShadowFocusAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(this.mFocusUpdateListener);
        }
        ValueAnimator valueAnimator = this.mShadowFocusAnimator;
        if (z9) {
            valueAnimator.start();
        } else {
            valueAnimator.reverse();
        }
        this.mShadowFocusAnimator.setDuration(i10);
    }

    private void updateColorAnimator() {
        ValueAnimator valueAnimator = this.mColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mColorAnimator = null;
        }
        if (this.mColorAnimationEnabled && this.mAttachedToWindow) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.mColorEvaluator, Integer.valueOf(this.mColors.color), Integer.valueOf(this.mColors.brightColor), Integer.valueOf(this.mColors.color));
            this.mColorAnimator = valueAnimatorOfObject;
            valueAnimatorOfObject.setRepeatCount(-1);
            this.mColorAnimator.setDuration(this.mPulseDurationMs * 2);
            this.mColorAnimator.addUpdateListener(this.mUpdateListener);
            this.mColorAnimator.start();
        }
    }

    public void animateOnFocus(boolean z9) {
        float f = z9 ? this.mFocusedZoom : 1.0f;
        this.mRootView.animate().scaleX(f).scaleY(f).setDuration(this.mScaleDurationMs).start();
        startShadowFocusAnimation(z9, this.mScaleDurationMs);
        enableOrbColorAnimation(z9);
    }

    public void enableOrbColorAnimation(boolean z9) {
        this.mColorAnimationEnabled = z9;
        updateColorAnimator();
    }

    public float getFocusedZoom() {
        return this.mFocusedZoom;
    }

    public int getLayoutResourceId() {
        return androidx.leanback.R.layout.lb_search_orb;
    }

    @ColorInt
    public int getOrbColor() {
        return this.mColors.color;
    }

    public Colors getOrbColors() {
        return this.mColors;
    }

    public Drawable getOrbIcon() {
        return this.mIconDrawable;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        updateColorAnimator();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        updateColorAnimator();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z9, int i10, Rect rect) {
        super.onFocusChanged(z9, i10, rect);
        animateOnFocus(z9);
    }

    public void scaleOrbViewOnly(float f) {
        this.mSearchOrbView.setScaleX(f);
        this.mSearchOrbView.setScaleY(f);
    }

    public void setOnOrbClickedListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void setOrbColor(int i10) {
        setOrbColors(new Colors(i10, i10, 0));
    }

    public void setOrbColors(Colors colors) {
        this.mColors = colors;
        this.mIcon.setColorFilter(colors.iconColor);
        if (this.mColorAnimator == null) {
            setOrbViewColor(this.mColors.color);
        } else {
            enableOrbColorAnimation(true);
        }
    }

    public void setOrbIcon(Drawable drawable) {
        this.mIconDrawable = drawable;
        this.mIcon.setImageDrawable(drawable);
    }

    public void setOrbViewColor(int i10) {
        if (this.mSearchOrbView.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.mSearchOrbView.getBackground()).setColor(i10);
        }
    }

    public void setSearchOrbZ(float f) {
        View view = this.mSearchOrbView;
        float f10 = this.mUnfocusedZ;
        ViewCompat.setZ(view, ((this.mFocusedZ - f10) * f) + f10);
    }

    @Deprecated
    public void setOrbColor(@ColorInt int i10, @ColorInt int i11) {
        setOrbColors(new Colors(i10, i11, 0));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Colors {
        private static final float BRIGHTNESS_ALPHA = 0.15f;

        @ColorInt
        public int brightColor;

        @ColorInt
        public int color;

        @ColorInt
        public int iconColor;

        public Colors(@ColorInt int i10, @ColorInt int i11, @ColorInt int i12) {
            this.color = i10;
            this.brightColor = i11 == i10 ? getBrightColor(i10) : i11;
            this.iconColor = i12;
        }

        public static int getBrightColor(int i10) {
            return Color.argb((int) ((Color.alpha(i10) * 0.85f) + 38.25f), (int) ((Color.red(i10) * 0.85f) + 38.25f), (int) ((Color.green(i10) * 0.85f) + 38.25f), (int) ((Color.blue(i10) * 0.85f) + 38.25f));
        }

        public Colors(@ColorInt int i10, @ColorInt int i11) {
            this(i10, i11, 0);
        }

        public Colors(@ColorInt int i10) {
            this(i10, i10);
        }
    }

    public SearchOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.searchOrbViewStyle);
    }

    public SearchOrbView(Context context) {
        this(context, null);
    }
}
