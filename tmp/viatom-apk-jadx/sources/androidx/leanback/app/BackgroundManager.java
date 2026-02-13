package androidx.leanback.app;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.leanback.R;
import androidx.window.layout.c;
import com.google.gson.internal.a;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.OggPageHeader;
import java.lang.ref.WeakReference;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class BackgroundManager {
    private static final int CHANGE_BG_DELAY_MS = 500;
    static final boolean DEBUG = false;
    private static final int FADE_DURATION = 500;
    private static final String FRAGMENT_TAG = "androidx.leanback.app.BackgroundManager";
    static final int FULL_ALPHA = 255;
    static final String TAG = "BackgroundManager";
    private final Animator.AnimatorListener mAnimationListener;
    private final ValueAnimator.AnimatorUpdateListener mAnimationUpdateListener;
    final ValueAnimator mAnimator;
    boolean mAttached;
    private boolean mAutoReleaseOnStop = true;
    int mBackgroundColor;
    Drawable mBackgroundDrawable;
    private View mBgView;
    ChangeBackgroundRunnable mChangeRunnable;
    private boolean mChangeRunnablePending;
    Activity mContext;
    private BackgroundFragment mFragmentState;
    Handler mHandler;
    private int mHeightPx;
    int mImageInWrapperIndex;
    int mImageOutWrapperIndex;
    private long mLastSetTime;
    TranslucentLayerDrawable mLayerDrawable;
    private BackgroundContinuityService mService;
    private int mThemeDrawableResourceId;
    private int mWidthPx;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class BackgroundContinuityService {
        private static final boolean DEBUG = false;
        private static final String TAG = "BackgroundContinuity";
        private static BackgroundContinuityService sService = new BackgroundContinuityService();
        private int mColor;
        private int mCount;
        private Drawable mDrawable;
        private int mLastThemeDrawableId;
        private WeakReference<Drawable.ConstantState> mLastThemeDrawableState;

        private BackgroundContinuityService() {
            reset();
        }

        public static BackgroundContinuityService getInstance() {
            BackgroundContinuityService backgroundContinuityService = sService;
            backgroundContinuityService.mCount++;
            return backgroundContinuityService;
        }

        private void reset() {
            this.mColor = 0;
            this.mDrawable = null;
        }

        public int getColor() {
            return this.mColor;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public Drawable getThemeDrawable(Context context, int i10) {
            Drawable.ConstantState constantState;
            WeakReference<Drawable.ConstantState> weakReference = this.mLastThemeDrawableState;
            Drawable drawableNewDrawable = (weakReference == null || this.mLastThemeDrawableId != i10 || (constantState = weakReference.get()) == null) ? null : constantState.newDrawable();
            if (drawableNewDrawable != null) {
                return drawableNewDrawable;
            }
            Drawable drawable = ContextCompat.getDrawable(context, i10);
            this.mLastThemeDrawableState = new WeakReference<>(drawable.getConstantState());
            this.mLastThemeDrawableId = i10;
            return drawable;
        }

        public void setColor(int i10) {
            this.mColor = i10;
            this.mDrawable = null;
        }

        public void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public void unref() {
            int i10 = this.mCount;
            if (i10 <= 0) {
                u.f(this.mCount, "Can't unref, count ");
                return;
            }
            int i11 = i10 - 1;
            this.mCount = i11;
            if (i11 == 0) {
                reset();
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class ChangeBackgroundRunnable implements Runnable {
        final Drawable mDrawable;

        public ChangeBackgroundRunnable(Drawable drawable) {
            this.mDrawable = drawable;
        }

        private void runTask() {
            BackgroundManager backgroundManager = BackgroundManager.this;
            if (backgroundManager.mLayerDrawable == null) {
                return;
            }
            DrawableWrapper imageInWrapper = backgroundManager.getImageInWrapper();
            if (imageInWrapper != null) {
                if (BackgroundManager.this.sameDrawable(this.mDrawable, imageInWrapper.getDrawable())) {
                    return;
                }
                BackgroundManager backgroundManager2 = BackgroundManager.this;
                backgroundManager2.mLayerDrawable.clearDrawable(R.id.background_imagein, backgroundManager2.mContext);
                BackgroundManager.this.mLayerDrawable.updateDrawable(R.id.background_imageout, imageInWrapper.getDrawable());
            }
            applyBackgroundChanges();
        }

        public void applyBackgroundChanges() {
            Drawable drawable;
            BackgroundManager backgroundManager = BackgroundManager.this;
            if (backgroundManager.mAttached) {
                if (backgroundManager.getImageInWrapper() == null && (drawable = this.mDrawable) != null) {
                    BackgroundManager.this.mLayerDrawable.updateDrawable(R.id.background_imagein, drawable);
                    BackgroundManager backgroundManager2 = BackgroundManager.this;
                    backgroundManager2.mLayerDrawable.setWrapperAlpha(backgroundManager2.mImageInWrapperIndex, 0);
                }
                BackgroundManager.this.mAnimator.setDuration(500L);
                BackgroundManager.this.mAnimator.start();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            runTask();
            BackgroundManager.this.mChangeRunnable = null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class EmptyDrawable extends BitmapDrawable {
        public EmptyDrawable(Resources resources) {
            super(resources, null);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class TranslucentLayerDrawable extends LayerDrawable {
        int mAlpha;
        WeakReference<BackgroundManager> mManagerWeakReference;
        boolean mSuspendInvalidation;
        DrawableWrapper[] mWrapper;

        public TranslucentLayerDrawable(BackgroundManager backgroundManager, Drawable[] drawableArr) {
            super(drawableArr);
            this.mAlpha = 255;
            this.mManagerWeakReference = new WeakReference<>(backgroundManager);
            int length = drawableArr.length;
            this.mWrapper = new DrawableWrapper[length];
            for (int i10 = 0; i10 < length; i10++) {
                this.mWrapper[i10] = new DrawableWrapper(drawableArr[i10]);
            }
        }

        public void clearDrawable(int i10, Context context) {
            for (int i11 = 0; i11 < getNumberOfLayers(); i11++) {
                if (getId(i11) == i10) {
                    this.mWrapper[i11] = null;
                    if (getDrawable(i11) instanceof EmptyDrawable) {
                        return;
                    }
                    super.setDrawableByLayerId(i10, BackgroundManager.createEmptyDrawable(context));
                    return;
                }
            }
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Drawable drawable;
            int i10;
            int i11;
            int i12 = 0;
            while (true) {
                DrawableWrapper[] drawableWrapperArr = this.mWrapper;
                if (i12 >= drawableWrapperArr.length) {
                    return;
                }
                DrawableWrapper drawableWrapper = drawableWrapperArr[i12];
                if (drawableWrapper != null && (drawable = drawableWrapper.getDrawable()) != null) {
                    int alpha = DrawableCompat.getAlpha(drawable);
                    int i13 = this.mAlpha;
                    if (i13 < 255) {
                        i11 = i13 * alpha;
                        i10 = 1;
                    } else {
                        i10 = 0;
                        i11 = alpha;
                    }
                    int i14 = this.mWrapper[i12].mAlpha;
                    if (i14 < 255) {
                        i11 *= i14;
                        i10++;
                    }
                    if (i10 == 0) {
                        drawable.draw(canvas);
                    } else {
                        if (i10 == 1) {
                            i11 /= 255;
                        } else if (i10 == 2) {
                            i11 /= OggPageHeader.MAX_PAGE_PAYLOAD;
                        }
                        try {
                            this.mSuspendInvalidation = true;
                            drawable.setAlpha(i11);
                            drawable.draw(canvas);
                            drawable.setAlpha(alpha);
                        } finally {
                            this.mSuspendInvalidation = false;
                        }
                    }
                }
                i12++;
            }
        }

        public int findWrapperIndexById(int i10) {
            for (int i11 = 0; i11 < getNumberOfLayers(); i11++) {
                if (getId(i11) == i10) {
                    return i11;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public int getAlpha() {
            return this.mAlpha;
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (this.mSuspendInvalidation) {
                return;
            }
            super.invalidateDrawable(drawable);
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public Drawable mutate() {
            Drawable drawableMutate = super.mutate();
            int numberOfLayers = getNumberOfLayers();
            for (int i10 = 0; i10 < numberOfLayers; i10++) {
                DrawableWrapper[] drawableWrapperArr = this.mWrapper;
                DrawableWrapper drawableWrapper = drawableWrapperArr[i10];
                if (drawableWrapper != null) {
                    drawableWrapperArr[i10] = new DrawableWrapper(drawableWrapper, getDrawable(i10));
                }
            }
            return drawableMutate;
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
            if (this.mAlpha != i10) {
                this.mAlpha = i10;
                invalidateSelf();
                BackgroundManager backgroundManager = this.mManagerWeakReference.get();
                if (backgroundManager != null) {
                    backgroundManager.postChangeRunnable();
                }
            }
        }

        @Override // android.graphics.drawable.LayerDrawable
        public boolean setDrawableByLayerId(int i10, Drawable drawable) {
            return updateDrawable(i10, drawable) != null;
        }

        public void setWrapperAlpha(int i10, int i11) {
            DrawableWrapper drawableWrapper = this.mWrapper[i10];
            if (drawableWrapper != null) {
                drawableWrapper.mAlpha = i11;
                invalidateSelf();
            }
        }

        public DrawableWrapper updateDrawable(int i10, Drawable drawable) {
            super.setDrawableByLayerId(i10, drawable);
            for (int i11 = 0; i11 < getNumberOfLayers(); i11++) {
                if (getId(i11) == i10) {
                    this.mWrapper[i11] = new DrawableWrapper(drawable);
                    invalidateSelf();
                    return this.mWrapper[i11];
                }
            }
            return null;
        }
    }

    private BackgroundManager(Activity activity) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.leanback.app.BackgroundManager.1
            final Runnable mRunnable = new Runnable() { // from class: androidx.leanback.app.BackgroundManager.1.1
                @Override // java.lang.Runnable
                public void run() {
                    BackgroundManager.this.postChangeRunnable();
                }
            };

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BackgroundManager backgroundManager = BackgroundManager.this;
                TranslucentLayerDrawable translucentLayerDrawable = backgroundManager.mLayerDrawable;
                if (translucentLayerDrawable != null) {
                    translucentLayerDrawable.clearDrawable(R.id.background_imageout, backgroundManager.mContext);
                }
                BackgroundManager.this.mHandler.post(this.mRunnable);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        };
        this.mAnimationListener = animatorListener;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.leanback.app.BackgroundManager.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BackgroundManager backgroundManager = BackgroundManager.this;
                int i10 = backgroundManager.mImageInWrapperIndex;
                if (i10 != -1) {
                    backgroundManager.mLayerDrawable.setWrapperAlpha(i10, iIntValue);
                }
            }
        };
        this.mAnimationUpdateListener = animatorUpdateListener;
        this.mContext = activity;
        this.mService = BackgroundContinuityService.getInstance();
        this.mHeightPx = this.mContext.getResources().getDisplayMetrics().heightPixels;
        this.mWidthPx = this.mContext.getResources().getDisplayMetrics().widthPixels;
        this.mHandler = new Handler();
        FastOutLinearInInterpolator fastOutLinearInInterpolator = new FastOutLinearInInterpolator();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 255);
        this.mAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.addListener(animatorListener);
        valueAnimatorOfInt.addUpdateListener(animatorUpdateListener);
        valueAnimatorOfInt.setInterpolator(fastOutLinearInInterpolator);
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowBackground});
        this.mThemeDrawableResourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        createFragment(activity);
    }

    public static Drawable createEmptyDrawable(Context context) {
        return new EmptyDrawable(context.getResources());
    }

    private void createFragment(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        String str = FRAGMENT_TAG;
        BackgroundFragment backgroundFragment = (BackgroundFragment) fragmentManager.findFragmentByTag(str);
        if (backgroundFragment == null) {
            backgroundFragment = new BackgroundFragment();
            activity.getFragmentManager().beginTransaction().add(backgroundFragment, str).commit();
        } else if (backgroundFragment.getBackgroundManager() != null) {
            c.g("Created duplicated BackgroundManager for same activity, please use getInstance() instead");
            return;
        }
        backgroundFragment.setBackgroundManager(this);
        this.mFragmentState = backgroundFragment;
    }

    public static BackgroundManager getInstance(Activity activity) {
        BackgroundManager backgroundManager;
        BackgroundFragment backgroundFragment = (BackgroundFragment) activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        return (backgroundFragment == null || (backgroundManager = backgroundFragment.getBackgroundManager()) == null) ? new BackgroundManager(activity) : backgroundManager;
    }

    private long getRunnableDelay() {
        return Math.max(0L, (this.mLastSetTime + 500) - System.currentTimeMillis());
    }

    private Drawable getThemeDrawable() {
        int i10 = this.mThemeDrawableResourceId;
        Drawable themeDrawable = i10 != -1 ? this.mService.getThemeDrawable(this.mContext, i10) : null;
        return themeDrawable == null ? createEmptyDrawable(this.mContext) : themeDrawable;
    }

    private void lazyInit() {
        if (this.mLayerDrawable != null) {
            return;
        }
        TranslucentLayerDrawable translucentLayerDrawableCreateTranslucentLayerDrawable = createTranslucentLayerDrawable((LayerDrawable) ContextCompat.getDrawable(this.mContext, R.drawable.lb_background).mutate());
        this.mLayerDrawable = translucentLayerDrawableCreateTranslucentLayerDrawable;
        this.mImageInWrapperIndex = translucentLayerDrawableCreateTranslucentLayerDrawable.findWrapperIndexById(R.id.background_imagein);
        this.mImageOutWrapperIndex = this.mLayerDrawable.findWrapperIndexById(R.id.background_imageout);
        if (this.mBgView.getBackground() != null) {
            this.mLayerDrawable.setAlpha(this.mBgView.getBackground().getAlpha());
        }
        this.mBgView.setBackground(this.mLayerDrawable);
    }

    private void setDrawableInternal(Drawable drawable) {
        if (!this.mAttached) {
            c.g("Must attach before setting background drawable");
            return;
        }
        ChangeBackgroundRunnable changeBackgroundRunnable = this.mChangeRunnable;
        if (changeBackgroundRunnable != null) {
            if (sameDrawable(drawable, changeBackgroundRunnable.mDrawable)) {
                return;
            }
            this.mHandler.removeCallbacks(this.mChangeRunnable);
            this.mChangeRunnable = null;
        }
        this.mChangeRunnable = new ChangeBackgroundRunnable(drawable);
        this.mChangeRunnablePending = true;
        postChangeRunnable();
    }

    private void syncWithService() {
        int color = this.mService.getColor();
        Drawable drawable = this.mService.getDrawable();
        this.mBackgroundColor = color;
        this.mBackgroundDrawable = drawable == null ? null : drawable.getConstantState().newDrawable().mutate();
        updateImmediate();
    }

    private void updateImmediate() {
        if (this.mAttached) {
            lazyInit();
            Drawable drawable = this.mBackgroundDrawable;
            TranslucentLayerDrawable translucentLayerDrawable = this.mLayerDrawable;
            if (drawable == null) {
                translucentLayerDrawable.updateDrawable(R.id.background_imagein, getDefaultDrawable());
            } else {
                translucentLayerDrawable.updateDrawable(R.id.background_imagein, drawable);
            }
            this.mLayerDrawable.clearDrawable(R.id.background_imageout, this.mContext);
        }
    }

    public void attach(Window window) {
        attachToViewInternal(window.getDecorView());
    }

    public void attachToView(View view) {
        attachToViewInternal(view);
        this.mContext.getWindow().getDecorView().setBackground(Build.VERSION.SDK_INT >= 26 ? null : new ColorDrawable(0));
    }

    public void attachToViewInternal(View view) {
        if (this.mAttached) {
            a.l(this.mBgView, "Already attached to ");
            return;
        }
        this.mBgView = view;
        this.mAttached = true;
        syncWithService();
    }

    public void clearDrawable() {
        setDrawable(null);
    }

    public TranslucentLayerDrawable createTranslucentLayerDrawable(LayerDrawable layerDrawable) {
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i10 = 0; i10 < numberOfLayers; i10++) {
            drawableArr[i10] = layerDrawable.getDrawable(i10);
        }
        TranslucentLayerDrawable translucentLayerDrawable = new TranslucentLayerDrawable(this, drawableArr);
        for (int i11 = 0; i11 < numberOfLayers; i11++) {
            translucentLayerDrawable.setId(i11, layerDrawable.getId(i11));
        }
        return translucentLayerDrawable;
    }

    public void detach() {
        release();
        this.mBgView = null;
        this.mAttached = false;
        BackgroundContinuityService backgroundContinuityService = this.mService;
        if (backgroundContinuityService != null) {
            backgroundContinuityService.unref();
            this.mService = null;
        }
    }

    @ColorInt
    public final int getColor() {
        return this.mBackgroundColor;
    }

    @Deprecated
    public Drawable getDefaultDimLayer() {
        return ContextCompat.getDrawable(this.mContext, R.color.lb_background_protection);
    }

    public Drawable getDefaultDrawable() {
        return this.mBackgroundColor != 0 ? new ColorDrawable(this.mBackgroundColor) : getThemeDrawable();
    }

    @Deprecated
    public Drawable getDimLayer() {
        return null;
    }

    public Drawable getDrawable() {
        return this.mBackgroundDrawable;
    }

    public DrawableWrapper getImageInWrapper() {
        TranslucentLayerDrawable translucentLayerDrawable = this.mLayerDrawable;
        if (translucentLayerDrawable == null) {
            return null;
        }
        return translucentLayerDrawable.mWrapper[this.mImageInWrapperIndex];
    }

    public DrawableWrapper getImageOutWrapper() {
        TranslucentLayerDrawable translucentLayerDrawable = this.mLayerDrawable;
        if (translucentLayerDrawable == null) {
            return null;
        }
        return translucentLayerDrawable.mWrapper[this.mImageOutWrapperIndex];
    }

    public boolean isAttached() {
        return this.mAttached;
    }

    public boolean isAutoReleaseOnStop() {
        return this.mAutoReleaseOnStop;
    }

    public void onActivityStart() {
        updateImmediate();
    }

    public void onResume() {
        postChangeRunnable();
    }

    public void onStop() {
        if (isAutoReleaseOnStop()) {
            release();
        }
    }

    public void postChangeRunnable() {
        if (this.mChangeRunnable == null || !this.mChangeRunnablePending || this.mAnimator.isStarted() || !this.mFragmentState.isResumed() || this.mLayerDrawable.getAlpha() < 255) {
            return;
        }
        long runnableDelay = getRunnableDelay();
        this.mLastSetTime = System.currentTimeMillis();
        this.mHandler.postDelayed(this.mChangeRunnable, runnableDelay);
        this.mChangeRunnablePending = false;
    }

    public void release() {
        ChangeBackgroundRunnable changeBackgroundRunnable = this.mChangeRunnable;
        if (changeBackgroundRunnable != null) {
            this.mHandler.removeCallbacks(changeBackgroundRunnable);
            this.mChangeRunnable = null;
        }
        if (this.mAnimator.isStarted()) {
            this.mAnimator.cancel();
        }
        TranslucentLayerDrawable translucentLayerDrawable = this.mLayerDrawable;
        if (translucentLayerDrawable != null) {
            translucentLayerDrawable.clearDrawable(R.id.background_imagein, this.mContext);
            this.mLayerDrawable.clearDrawable(R.id.background_imageout, this.mContext);
            this.mLayerDrawable = null;
        }
        this.mBackgroundDrawable = null;
    }

    public boolean sameDrawable(Drawable drawable, Drawable drawable2) {
        if (drawable != null && drawable2 != null) {
            if (drawable == drawable2) {
                return true;
            }
            if ((drawable instanceof BitmapDrawable) && (drawable2 instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap().sameAs(((BitmapDrawable) drawable2).getBitmap())) {
                return true;
            }
            if ((drawable instanceof ColorDrawable) && (drawable2 instanceof ColorDrawable) && ((ColorDrawable) drawable).getColor() == ((ColorDrawable) drawable2).getColor()) {
                return true;
            }
        }
        return false;
    }

    public void setAutoReleaseOnStop(boolean z9) {
        this.mAutoReleaseOnStop = z9;
    }

    public void setBitmap(Bitmap bitmap) {
        Matrix matrix = null;
        if (bitmap == null) {
            setDrawable(null);
            return;
        }
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return;
        }
        if (bitmap.getWidth() != this.mWidthPx || bitmap.getHeight() != this.mHeightPx) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i10 = this.mHeightPx;
            int i11 = width * i10;
            int i12 = this.mWidthPx;
            float f = i11 > i12 * height ? i10 / height : i12 / width;
            int iMax = Math.max(0, (width - Math.min((int) (i12 / f), width)) / 2);
            Matrix matrix2 = new Matrix();
            matrix2.setScale(f, f);
            matrix2.preTranslate(-iMax, 0.0f);
            matrix = matrix2;
        }
        setDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap, matrix));
    }

    public void setColor(@ColorInt int i10) {
        this.mService.setColor(i10);
        this.mBackgroundColor = i10;
        this.mBackgroundDrawable = null;
        if (this.mLayerDrawable == null) {
            return;
        }
        setDrawableInternal(getDefaultDrawable());
    }

    public void setDrawable(Drawable drawable) {
        this.mService.setDrawable(drawable);
        this.mBackgroundDrawable = drawable;
        if (this.mLayerDrawable == null) {
            return;
        }
        if (drawable == null) {
            setDrawableInternal(getDefaultDrawable());
        } else {
            setDrawableInternal(drawable);
        }
    }

    public void setThemeDrawableResourceId(int i10) {
        this.mThemeDrawableResourceId = i10;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class BitmapDrawable extends Drawable {
        boolean mMutated;
        ConstantState mState;

        public BitmapDrawable(Resources resources, Bitmap bitmap, Matrix matrix) {
            this.mState = new ConstantState(bitmap, matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            ConstantState constantState = this.mState;
            if (constantState.mBitmap == null) {
                return;
            }
            if (constantState.mPaint.getAlpha() < 255 && this.mState.mPaint.getColorFilter() != null) {
                c.g("Can't draw with translucent alpha and color filter");
            } else {
                ConstantState constantState2 = this.mState;
                canvas.drawBitmap(constantState2.mBitmap, constantState2.mMatrix, constantState2.mPaint);
            }
        }

        public Bitmap getBitmap() {
            return this.mState.mBitmap;
        }

        @Override // android.graphics.drawable.Drawable
        public ColorFilter getColorFilter() {
            return this.mState.mPaint.getColorFilter();
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable mutate() {
            if (!this.mMutated) {
                this.mMutated = true;
                this.mState = new ConstantState(this.mState);
            }
            return this;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
            mutate();
            if (this.mState.mPaint.getAlpha() != i10) {
                this.mState.mPaint.setAlpha(i10);
                invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            mutate();
            this.mState.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public ConstantState getConstantState() {
            return this.mState;
        }

        public BitmapDrawable(Resources resources, Bitmap bitmap) {
            this(resources, bitmap, null);
        }

        public BitmapDrawable(ConstantState constantState) {
            this.mState = constantState;
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class ConstantState extends Drawable.ConstantState {
            final Bitmap mBitmap;
            final Matrix mMatrix;
            final Paint mPaint;

            public ConstantState(ConstantState constantState) {
                Paint paint = new Paint();
                this.mPaint = paint;
                this.mBitmap = constantState.mBitmap;
                this.mMatrix = constantState.mMatrix != null ? new Matrix(constantState.mMatrix) : new Matrix();
                if (constantState.mPaint.getAlpha() != 255) {
                    paint.setAlpha(constantState.mPaint.getAlpha());
                }
                if (constantState.mPaint.getColorFilter() != null) {
                    paint.setColorFilter(constantState.mPaint.getColorFilter());
                }
                paint.setFilterBitmap(true);
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public Drawable newDrawable() {
                return new BitmapDrawable(this);
            }

            public ConstantState(Bitmap bitmap, Matrix matrix) {
                Paint paint = new Paint();
                this.mPaint = paint;
                this.mBitmap = bitmap;
                this.mMatrix = matrix == null ? new Matrix() : matrix;
                paint.setFilterBitmap(true);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class DrawableWrapper {
        int mAlpha;
        final Drawable mDrawable;

        public DrawableWrapper(DrawableWrapper drawableWrapper, Drawable drawable) {
            this.mAlpha = 255;
            this.mDrawable = drawable;
            this.mAlpha = drawableWrapper.mAlpha;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public void setColor(int i10) {
            ((ColorDrawable) this.mDrawable).setColor(i10);
        }

        public DrawableWrapper(Drawable drawable) {
            this.mAlpha = 255;
            this.mDrawable = drawable;
        }
    }

    @Deprecated
    public void setDimLayer(Drawable drawable) {
    }
}
