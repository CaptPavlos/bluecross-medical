package androidx.leanback.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Property;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.R;
import androidx.leanback.widget.PagingIndicator;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class OnboardingSupportFragment extends Fragment {
    private static final boolean DEBUG = false;
    private static final long DESCRIPTION_START_DELAY_MS = 33;
    private static final long HEADER_ANIMATION_DURATION_MS = 417;
    private static final long HEADER_APPEAR_DELAY_MS = 500;
    private static final TimeInterpolator HEADER_APPEAR_INTERPOLATOR = new DecelerateInterpolator();
    private static final TimeInterpolator HEADER_DISAPPEAR_INTERPOLATOR = new AccelerateInterpolator();
    private static final String KEY_CURRENT_PAGE_INDEX = "leanback.onboarding.current_page_index";
    private static final String KEY_ENTER_ANIMATION_FINISHED = "leanback.onboarding.enter_animation_finished";
    private static final String KEY_LOGO_ANIMATION_FINISHED = "leanback.onboarding.logo_animation_finished";
    private static final long LOGO_SPLASH_PAUSE_DURATION_MS = 1333;
    private static final int SLIDE_DISTANCE = 60;
    private static final String TAG = "OnboardingF";
    private static int sSlideDistance;
    private AnimatorSet mAnimator;
    private boolean mArrowBackgroundColorSet;
    private boolean mArrowColorSet;
    int mCurrentPageIndex;
    TextView mDescriptionView;
    private boolean mDescriptionViewTextColorSet;
    private boolean mDotBackgroundColorSet;
    boolean mEnterAnimationFinished;
    private int mIconResourceId;
    boolean mIsLtr;
    boolean mLogoAnimationFinished;
    private int mLogoResourceId;
    private ImageView mLogoView;
    private ImageView mMainIconView;
    PagingIndicator mPageIndicator;
    View mStartButton;
    private CharSequence mStartButtonText;
    private boolean mStartButtonTextSet;
    private ContextThemeWrapper mThemeWrapper;
    TextView mTitleView;
    private boolean mTitleViewTextColorSet;

    @ColorInt
    private int mTitleViewTextColor = 0;

    @ColorInt
    private int mDescriptionViewTextColor = 0;

    @ColorInt
    private int mDotBackgroundColor = 0;

    @ColorInt
    private int mArrowColor = 0;

    @ColorInt
    private int mArrowBackgroundColor = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: androidx.leanback.app.OnboardingSupportFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            OnboardingSupportFragment onboardingSupportFragment = OnboardingSupportFragment.this;
            if (onboardingSupportFragment.mLogoAnimationFinished) {
                int i10 = onboardingSupportFragment.mCurrentPageIndex;
                int pageCount = onboardingSupportFragment.getPageCount() - 1;
                OnboardingSupportFragment onboardingSupportFragment2 = OnboardingSupportFragment.this;
                if (i10 == pageCount) {
                    onboardingSupportFragment2.onFinishFragment();
                } else {
                    onboardingSupportFragment2.moveToNextPage();
                }
            }
        }
    };
    private final View.OnKeyListener mOnKeyListener = new View.OnKeyListener() { // from class: androidx.leanback.app.OnboardingSupportFragment.2
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) throws Resources.NotFoundException {
            if (!OnboardingSupportFragment.this.mLogoAnimationFinished) {
                return i10 != 4;
            }
            if (keyEvent.getAction() == 0) {
                return false;
            }
            if (i10 == 4) {
                OnboardingSupportFragment onboardingSupportFragment = OnboardingSupportFragment.this;
                if (onboardingSupportFragment.mCurrentPageIndex == 0) {
                    return false;
                }
                onboardingSupportFragment.moveToPreviousPage();
                return true;
            }
            if (i10 == 21) {
                OnboardingSupportFragment onboardingSupportFragment2 = OnboardingSupportFragment.this;
                if (onboardingSupportFragment2.mIsLtr) {
                    onboardingSupportFragment2.moveToPreviousPage();
                } else {
                    onboardingSupportFragment2.moveToNextPage();
                }
                return true;
            }
            if (i10 != 22) {
                return false;
            }
            OnboardingSupportFragment onboardingSupportFragment3 = OnboardingSupportFragment.this;
            if (onboardingSupportFragment3.mIsLtr) {
                onboardingSupportFragment3.moveToNextPage();
            } else {
                onboardingSupportFragment3.moveToPreviousPage();
            }
            return true;
        }
    };

    private Animator createAnimator(View view, boolean z9, int i10, long j10) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        boolean z10 = getView().getLayoutDirection() == 0;
        boolean z11 = (z10 && i10 == 8388613) || (!z10 && i10 == 8388611) || i10 == 5;
        if (z9) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, z11 ? sSlideDistance : -sSlideDistance, 0.0f);
            TimeInterpolator timeInterpolator = HEADER_APPEAR_INTERPOLATOR;
            objectAnimatorOfFloat.setInterpolator(timeInterpolator);
            objectAnimatorOfFloat2.setInterpolator(timeInterpolator);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, z11 ? sSlideDistance : -sSlideDistance);
            TimeInterpolator timeInterpolator2 = HEADER_DISAPPEAR_INTERPOLATOR;
            objectAnimatorOfFloat.setInterpolator(timeInterpolator2);
            objectAnimatorOfFloat2.setInterpolator(timeInterpolator2);
        }
        objectAnimatorOfFloat.setDuration(HEADER_ANIMATION_DURATION_MS);
        objectAnimatorOfFloat.setTarget(view);
        objectAnimatorOfFloat2.setDuration(HEADER_ANIMATION_DURATION_MS);
        objectAnimatorOfFloat2.setTarget(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        if (j10 > 0) {
            animatorSet.setStartDelay(j10);
        }
        return animatorSet;
    }

    private LayoutInflater getThemeInflater(LayoutInflater layoutInflater) {
        ContextThemeWrapper contextThemeWrapper = this.mThemeWrapper;
        return contextThemeWrapper == null ? layoutInflater : layoutInflater.cloneInContext(contextThemeWrapper);
    }

    private void onPageChangedInternal(int i10) throws Resources.NotFoundException {
        OnboardingSupportFragment onboardingSupportFragment;
        Animator animatorCreateAnimator;
        AnimatorSet animatorSet = this.mAnimator;
        if (animatorSet != null) {
            animatorSet.end();
        }
        this.mPageIndicator.onPageSelected(this.mCurrentPageIndex, true);
        ArrayList arrayList = new ArrayList();
        int currentPageIndex = getCurrentPageIndex();
        TextView textView = this.mTitleView;
        if (i10 < currentPageIndex) {
            onboardingSupportFragment = this;
            arrayList.add(onboardingSupportFragment.createAnimator(textView, false, GravityCompat.START, 0L));
            animatorCreateAnimator = onboardingSupportFragment.createAnimator(onboardingSupportFragment.mDescriptionView, false, GravityCompat.START, DESCRIPTION_START_DELAY_MS);
            arrayList.add(animatorCreateAnimator);
            arrayList.add(onboardingSupportFragment.createAnimator(onboardingSupportFragment.mTitleView, true, GravityCompat.END, HEADER_APPEAR_DELAY_MS));
            arrayList.add(onboardingSupportFragment.createAnimator(onboardingSupportFragment.mDescriptionView, true, GravityCompat.END, 533L));
        } else {
            onboardingSupportFragment = this;
            arrayList.add(onboardingSupportFragment.createAnimator(textView, false, GravityCompat.END, 0L));
            animatorCreateAnimator = onboardingSupportFragment.createAnimator(onboardingSupportFragment.mDescriptionView, false, GravityCompat.END, DESCRIPTION_START_DELAY_MS);
            arrayList.add(animatorCreateAnimator);
            arrayList.add(onboardingSupportFragment.createAnimator(onboardingSupportFragment.mTitleView, true, GravityCompat.START, HEADER_APPEAR_DELAY_MS));
            arrayList.add(onboardingSupportFragment.createAnimator(onboardingSupportFragment.mDescriptionView, true, GravityCompat.START, 533L));
        }
        final int currentPageIndex2 = getCurrentPageIndex();
        animatorCreateAnimator.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingSupportFragment.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                OnboardingSupportFragment onboardingSupportFragment2 = OnboardingSupportFragment.this;
                onboardingSupportFragment2.mTitleView.setText(onboardingSupportFragment2.getPageTitle(currentPageIndex2));
                OnboardingSupportFragment onboardingSupportFragment3 = OnboardingSupportFragment.this;
                onboardingSupportFragment3.mDescriptionView.setText(onboardingSupportFragment3.getPageDescription(currentPageIndex2));
            }
        });
        Context context = getContext();
        if (getCurrentPageIndex() == getPageCount() - 1) {
            onboardingSupportFragment.mStartButton.setVisibility(0);
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_fade_out);
            animatorLoadAnimator.setTarget(onboardingSupportFragment.mPageIndicator);
            animatorLoadAnimator.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingSupportFragment.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    OnboardingSupportFragment.this.mPageIndicator.setVisibility(8);
                }
            });
            arrayList.add(animatorLoadAnimator);
            Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_start_button_fade_in);
            animatorLoadAnimator2.setTarget(onboardingSupportFragment.mStartButton);
            arrayList.add(animatorLoadAnimator2);
        } else if (i10 == getPageCount() - 1) {
            onboardingSupportFragment.mPageIndicator.setVisibility(0);
            Animator animatorLoadAnimator3 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_fade_in);
            animatorLoadAnimator3.setTarget(onboardingSupportFragment.mPageIndicator);
            arrayList.add(animatorLoadAnimator3);
            Animator animatorLoadAnimator4 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_start_button_fade_out);
            animatorLoadAnimator4.setTarget(onboardingSupportFragment.mStartButton);
            animatorLoadAnimator4.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingSupportFragment.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    OnboardingSupportFragment.this.mStartButton.setVisibility(8);
                }
            });
            arrayList.add(animatorLoadAnimator4);
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        onboardingSupportFragment.mAnimator = animatorSet2;
        animatorSet2.playTogether(arrayList);
        onboardingSupportFragment.mAnimator.start();
        onPageChanged(onboardingSupportFragment.mCurrentPageIndex, i10);
    }

    private void resolveTheme() {
        Context context = getContext();
        int iOnProvideTheme = onProvideTheme();
        if (iOnProvideTheme != -1) {
            this.mThemeWrapper = new ContextThemeWrapper(context, iOnProvideTheme);
            return;
        }
        int i10 = R.attr.onboardingTheme;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            this.mThemeWrapper = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    @ColorInt
    public final int getArrowBackgroundColor() {
        return this.mArrowBackgroundColor;
    }

    @ColorInt
    public final int getArrowColor() {
        return this.mArrowColor;
    }

    public final int getCurrentPageIndex() {
        return this.mCurrentPageIndex;
    }

    @ColorInt
    public final int getDescriptionViewTextColor() {
        return this.mDescriptionViewTextColor;
    }

    @ColorInt
    public final int getDotBackgroundColor() {
        return this.mDotBackgroundColor;
    }

    public final int getIconResourceId() {
        return this.mIconResourceId;
    }

    public final int getLogoResourceId() {
        return this.mLogoResourceId;
    }

    public abstract int getPageCount();

    public abstract CharSequence getPageDescription(int i10);

    public abstract CharSequence getPageTitle(int i10);

    public final CharSequence getStartButtonText() {
        return this.mStartButtonText;
    }

    @ColorInt
    public final int getTitleViewTextColor() {
        return this.mTitleViewTextColor;
    }

    public void hideLogoView() {
        this.mLogoView.setVisibility(8);
        int i10 = this.mIconResourceId;
        if (i10 != 0) {
            this.mMainIconView.setImageResource(i10);
            this.mMainIconView.setVisibility(0);
        }
        View view = getView();
        LayoutInflater themeInflater = getThemeInflater(LayoutInflater.from(getContext()));
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.background_container);
        View viewOnCreateBackgroundView = onCreateBackgroundView(themeInflater, viewGroup);
        if (viewOnCreateBackgroundView != null) {
            viewGroup.setVisibility(0);
            viewGroup.addView(viewOnCreateBackgroundView);
        }
        int i11 = R.id.content_container;
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(i11);
        View viewOnCreateContentView = onCreateContentView(themeInflater, viewGroup2);
        if (viewOnCreateContentView != null) {
            viewGroup2.setVisibility(0);
            viewGroup2.addView(viewOnCreateContentView);
        }
        ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.foreground_container);
        View viewOnCreateForegroundView = onCreateForegroundView(themeInflater, viewGroup3);
        if (viewOnCreateForegroundView != null) {
            viewGroup3.setVisibility(0);
            viewGroup3.addView(viewOnCreateForegroundView);
        }
        view.findViewById(R.id.page_container).setVisibility(0);
        view.findViewById(i11).setVisibility(0);
        if (getPageCount() > 1) {
            this.mPageIndicator.setPageCount(getPageCount());
            this.mPageIndicator.onPageSelected(this.mCurrentPageIndex, false);
        }
        if (this.mCurrentPageIndex == getPageCount() - 1) {
            this.mStartButton.setVisibility(0);
        } else {
            this.mPageIndicator.setVisibility(0);
        }
        this.mTitleView.setText(getPageTitle(this.mCurrentPageIndex));
        this.mDescriptionView.setText(getPageDescription(this.mCurrentPageIndex));
    }

    public final boolean isLogoAnimationFinished() {
        return this.mLogoAnimationFinished;
    }

    public void moveToNextPage() throws Resources.NotFoundException {
        if (this.mLogoAnimationFinished && this.mCurrentPageIndex < getPageCount() - 1) {
            int i10 = this.mCurrentPageIndex;
            this.mCurrentPageIndex = i10 + 1;
            onPageChangedInternal(i10);
        }
    }

    public void moveToPreviousPage() throws Resources.NotFoundException {
        int i10;
        if (this.mLogoAnimationFinished && (i10 = this.mCurrentPageIndex) > 0) {
            this.mCurrentPageIndex = i10 - 1;
            onPageChangedInternal(i10);
        }
    }

    public abstract View onCreateBackgroundView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public abstract View onCreateContentView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public Animator onCreateDescriptionAnimator() {
        return AnimatorInflater.loadAnimator(getContext(), R.animator.lb_onboarding_description_enter);
    }

    public Animator onCreateEnterAnimation() {
        return null;
    }

    public abstract View onCreateForegroundView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public Animator onCreateLogoAnimation() {
        return null;
    }

    public Animator onCreateTitleAnimator() {
        return AnimatorInflater.loadAnimator(getContext(), R.animator.lb_onboarding_title_enter);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        resolveTheme();
        ViewGroup viewGroup2 = (ViewGroup) getThemeInflater(layoutInflater).inflate(R.layout.lb_onboarding_fragment, viewGroup, false);
        this.mIsLtr = getResources().getConfiguration().getLayoutDirection() == 0;
        PagingIndicator pagingIndicator = (PagingIndicator) viewGroup2.findViewById(R.id.page_indicator);
        this.mPageIndicator = pagingIndicator;
        pagingIndicator.setOnClickListener(this.mOnClickListener);
        this.mPageIndicator.setOnKeyListener(this.mOnKeyListener);
        View viewFindViewById = viewGroup2.findViewById(R.id.button_start);
        this.mStartButton = viewFindViewById;
        viewFindViewById.setOnClickListener(this.mOnClickListener);
        this.mStartButton.setOnKeyListener(this.mOnKeyListener);
        this.mMainIconView = (ImageView) viewGroup2.findViewById(R.id.main_icon);
        this.mLogoView = (ImageView) viewGroup2.findViewById(R.id.logo);
        this.mTitleView = (TextView) viewGroup2.findViewById(R.id.title);
        this.mDescriptionView = (TextView) viewGroup2.findViewById(R.id.description);
        if (this.mTitleViewTextColorSet) {
            this.mTitleView.setTextColor(this.mTitleViewTextColor);
        }
        if (this.mDescriptionViewTextColorSet) {
            this.mDescriptionView.setTextColor(this.mDescriptionViewTextColor);
        }
        if (this.mDotBackgroundColorSet) {
            this.mPageIndicator.setDotBackgroundColor(this.mDotBackgroundColor);
        }
        if (this.mArrowColorSet) {
            this.mPageIndicator.setArrowColor(this.mArrowColor);
        }
        if (this.mArrowBackgroundColorSet) {
            this.mPageIndicator.setDotBackgroundColor(this.mArrowBackgroundColor);
        }
        if (this.mStartButtonTextSet) {
            ((Button) this.mStartButton).setText(this.mStartButtonText);
        }
        Context context = getContext();
        if (sSlideDistance == 0) {
            sSlideDistance = (int) (context.getResources().getDisplayMetrics().scaledDensity * 60.0f);
        }
        viewGroup2.requestFocus();
        return viewGroup2;
    }

    public void onLogoAnimationFinished() throws Resources.NotFoundException {
        startEnterAnimation(false);
    }

    public int onProvideTheme() {
        return -1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(KEY_CURRENT_PAGE_INDEX, this.mCurrentPageIndex);
        bundle.putBoolean(KEY_LOGO_ANIMATION_FINISHED, this.mLogoAnimationFinished);
        bundle.putBoolean(KEY_ENTER_ANIMATION_FINISHED, this.mEnterAnimationFinished);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws Resources.NotFoundException {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            this.mCurrentPageIndex = 0;
            this.mLogoAnimationFinished = false;
            this.mEnterAnimationFinished = false;
            this.mPageIndicator.onPageSelected(0, false);
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.leanback.app.OnboardingSupportFragment.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() throws Resources.NotFoundException {
                    OnboardingSupportFragment.this.getView().getViewTreeObserver().removeOnPreDrawListener(this);
                    if (!OnboardingSupportFragment.this.startLogoAnimation()) {
                        OnboardingSupportFragment onboardingSupportFragment = OnboardingSupportFragment.this;
                        onboardingSupportFragment.mLogoAnimationFinished = true;
                        onboardingSupportFragment.onLogoAnimationFinished();
                    }
                    return true;
                }
            });
            return;
        }
        this.mCurrentPageIndex = bundle.getInt(KEY_CURRENT_PAGE_INDEX);
        this.mLogoAnimationFinished = bundle.getBoolean(KEY_LOGO_ANIMATION_FINISHED);
        this.mEnterAnimationFinished = bundle.getBoolean(KEY_ENTER_ANIMATION_FINISHED);
        if (this.mLogoAnimationFinished) {
            onLogoAnimationFinished();
        } else {
            if (startLogoAnimation()) {
                return;
            }
            this.mLogoAnimationFinished = true;
            onLogoAnimationFinished();
        }
    }

    public void setArrowBackgroundColor(@ColorInt int i10) {
        this.mArrowBackgroundColor = i10;
        this.mArrowBackgroundColorSet = true;
        PagingIndicator pagingIndicator = this.mPageIndicator;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowBackgroundColor(i10);
        }
    }

    public void setArrowColor(@ColorInt int i10) {
        this.mArrowColor = i10;
        this.mArrowColorSet = true;
        PagingIndicator pagingIndicator = this.mPageIndicator;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowColor(i10);
        }
    }

    public void setDescriptionViewTextColor(@ColorInt int i10) {
        this.mDescriptionViewTextColor = i10;
        this.mDescriptionViewTextColorSet = true;
        TextView textView = this.mDescriptionView;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public void setDotBackgroundColor(@ColorInt int i10) {
        this.mDotBackgroundColor = i10;
        this.mDotBackgroundColorSet = true;
        PagingIndicator pagingIndicator = this.mPageIndicator;
        if (pagingIndicator != null) {
            pagingIndicator.setDotBackgroundColor(i10);
        }
    }

    public final void setIconResouceId(int i10) {
        this.mIconResourceId = i10;
        ImageView imageView = this.mMainIconView;
        if (imageView != null) {
            imageView.setImageResource(i10);
            this.mMainIconView.setVisibility(0);
        }
    }

    public final void setLogoResourceId(int i10) {
        this.mLogoResourceId = i10;
    }

    public void setStartButtonText(CharSequence charSequence) {
        this.mStartButtonText = charSequence;
        this.mStartButtonTextSet = true;
        View view = this.mStartButton;
        if (view != null) {
            ((Button) view).setText(charSequence);
        }
    }

    public void setTitleViewTextColor(@ColorInt int i10) {
        this.mTitleViewTextColor = i10;
        this.mTitleViewTextColorSet = true;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public final void startEnterAnimation(boolean z9) throws Resources.NotFoundException {
        Context context = getContext();
        if (context == null) {
            return;
        }
        hideLogoView();
        if (!this.mEnterAnimationFinished || z9) {
            ArrayList arrayList = new ArrayList();
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_enter);
            animatorLoadAnimator.setTarget(getPageCount() <= 1 ? this.mStartButton : this.mPageIndicator);
            arrayList.add(animatorLoadAnimator);
            Animator animatorOnCreateTitleAnimator = onCreateTitleAnimator();
            if (animatorOnCreateTitleAnimator != null) {
                animatorOnCreateTitleAnimator.setTarget(this.mTitleView);
                arrayList.add(animatorOnCreateTitleAnimator);
            }
            Animator animatorOnCreateDescriptionAnimator = onCreateDescriptionAnimator();
            if (animatorOnCreateDescriptionAnimator != null) {
                animatorOnCreateDescriptionAnimator.setTarget(this.mDescriptionView);
                arrayList.add(animatorOnCreateDescriptionAnimator);
            }
            Animator animatorOnCreateEnterAnimation = onCreateEnterAnimation();
            if (animatorOnCreateEnterAnimation != null) {
                arrayList.add(animatorOnCreateEnterAnimation);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimator = animatorSet;
            animatorSet.playTogether(arrayList);
            this.mAnimator.start();
            this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingSupportFragment.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    OnboardingSupportFragment.this.mEnterAnimationFinished = true;
                }
            });
            getView().requestFocus();
        }
    }

    public boolean startLogoAnimation() throws Resources.NotFoundException {
        Animator animatorOnCreateLogoAnimation;
        final Context context = getContext();
        if (context == null) {
            return false;
        }
        if (this.mLogoResourceId != 0) {
            this.mLogoView.setVisibility(0);
            this.mLogoView.setImageResource(this.mLogoResourceId);
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_logo_enter);
            Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_logo_exit);
            animatorLoadAnimator2.setStartDelay(LOGO_SPLASH_PAUSE_DURATION_MS);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(animatorLoadAnimator, animatorLoadAnimator2);
            animatorSet.setTarget(this.mLogoView);
            animatorOnCreateLogoAnimation = animatorSet;
        } else {
            animatorOnCreateLogoAnimation = onCreateLogoAnimation();
        }
        if (animatorOnCreateLogoAnimation == null) {
            return false;
        }
        animatorOnCreateLogoAnimation.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingSupportFragment.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
                if (context != null) {
                    OnboardingSupportFragment onboardingSupportFragment = OnboardingSupportFragment.this;
                    onboardingSupportFragment.mLogoAnimationFinished = true;
                    onboardingSupportFragment.onLogoAnimationFinished();
                }
            }
        });
        animatorOnCreateLogoAnimation.start();
        return true;
    }

    public void onFinishFragment() {
    }

    public void onPageChanged(int i10, int i11) {
    }
}
