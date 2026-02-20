package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Carousel extends MotionHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "Carousel";
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private Adapter mAdapter;
    private int mAnimateTargetDelay;
    private int mBackwardTransition;
    private float mDampening;
    private int mEmptyViewBehavior;
    private int mFirstViewReference;
    private int mForwardTransition;
    private int mIndex;
    private boolean mInfiniteCarousel;
    int mLastStartId;
    private final ArrayList<View> mList;
    private MotionLayout mMotionLayout;
    private int mNextState;
    private int mPreviousIndex;
    private int mPreviousState;
    private int mStartIndex;
    private int mTargetIndex;
    private int mTouchUpMode;
    Runnable mUpdateRunnable;
    private float mVelocityThreshold;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Adapter {
        int count();

        void onNewItem(int i10);

        void populate(View view, int i10);
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdapter = null;
        this.mList = new ArrayList<>();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.mMotionLayout.setProgress(0.0f);
                Carousel.this.updateItems();
                Carousel.this.mAdapter.onNewItem(Carousel.this.mIndex);
                float velocity = Carousel.this.mMotionLayout.getVelocity();
                if (Carousel.this.mTouchUpMode != 2 || velocity <= Carousel.this.mVelocityThreshold || Carousel.this.mIndex >= Carousel.this.mAdapter.count() - 1) {
                    return;
                }
                final float f = Carousel.this.mDampening * velocity;
                if (Carousel.this.mIndex != 0 || Carousel.this.mPreviousIndex <= Carousel.this.mIndex) {
                    if (Carousel.this.mIndex != Carousel.this.mAdapter.count() - 1 || Carousel.this.mPreviousIndex >= Carousel.this.mIndex) {
                        Carousel.this.mMotionLayout.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Carousel.this.mMotionLayout.touchAnimateTo(5, 1.0f, f);
                            }
                        });
                    }
                }
            }
        };
        init(context, attributeSet);
    }

    private void enableAllTransitions(boolean z9) {
        ArrayList<MotionScene.Transition> definedTransitions = this.mMotionLayout.getDefinedTransitions();
        int size = definedTransitions.size();
        int i10 = 0;
        while (i10 < size) {
            MotionScene.Transition transition = definedTransitions.get(i10);
            i10++;
            transition.setEnabled(z9);
        }
    }

    private boolean enableTransition(int i10, boolean z9) {
        MotionLayout motionLayout;
        MotionScene.Transition transition;
        if (i10 == -1 || (motionLayout = this.mMotionLayout) == null || (transition = motionLayout.getTransition(i10)) == null || z9 == transition.isEnabled()) {
            return false;
        }
        transition.setEnabled(z9);
        return true;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.mFirstViewReference = typedArrayObtainStyledAttributes.getResourceId(index, this.mFirstViewReference);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.mBackwardTransition = typedArrayObtainStyledAttributes.getResourceId(index, this.mBackwardTransition);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.mForwardTransition = typedArrayObtainStyledAttributes.getResourceId(index, this.mForwardTransition);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.mEmptyViewBehavior = typedArrayObtainStyledAttributes.getInt(index, this.mEmptyViewBehavior);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.mPreviousState = typedArrayObtainStyledAttributes.getResourceId(index, this.mPreviousState);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.mNextState = typedArrayObtainStyledAttributes.getResourceId(index, this.mNextState);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.mDampening = typedArrayObtainStyledAttributes.getFloat(index, this.mDampening);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.mTouchUpMode = typedArrayObtainStyledAttributes.getInt(index, this.mTouchUpMode);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.mVelocityThreshold = typedArrayObtainStyledAttributes.getFloat(index, this.mVelocityThreshold);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.mInfiniteCarousel = typedArrayObtainStyledAttributes.getBoolean(index, this.mInfiniteCarousel);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateItems$0() {
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        int i10 = this.mTargetIndex;
        int i11 = this.mIndex;
        MotionLayout motionLayout = this.mMotionLayout;
        if (i10 < i11) {
            motionLayout.transitionToState(this.mPreviousState, this.mAnimateTargetDelay);
        } else {
            motionLayout.transitionToState(this.mNextState, this.mAnimateTargetDelay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateItems() {
        Adapter adapter = this.mAdapter;
        if (adapter == null || this.mMotionLayout == null || adapter.count() == 0) {
            return;
        }
        int size = this.mList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = this.mList.get(i10);
            int iCount = (this.mIndex + i10) - this.mStartIndex;
            if (this.mInfiniteCarousel) {
                if (iCount < 0) {
                    int i11 = this.mEmptyViewBehavior;
                    if (i11 != 4) {
                        updateViewVisibility(view, i11);
                    } else {
                        updateViewVisibility(view, 0);
                    }
                    int iCount2 = iCount % this.mAdapter.count();
                    Adapter adapter2 = this.mAdapter;
                    if (iCount2 == 0) {
                        adapter2.populate(view, 0);
                    } else {
                        adapter2.populate(view, (iCount % this.mAdapter.count()) + adapter2.count());
                    }
                } else if (iCount >= this.mAdapter.count()) {
                    if (iCount == this.mAdapter.count()) {
                        iCount = 0;
                    } else if (iCount > this.mAdapter.count()) {
                        iCount %= this.mAdapter.count();
                    }
                    int i12 = this.mEmptyViewBehavior;
                    if (i12 != 4) {
                        updateViewVisibility(view, i12);
                    } else {
                        updateViewVisibility(view, 0);
                    }
                    this.mAdapter.populate(view, iCount);
                } else {
                    updateViewVisibility(view, 0);
                    this.mAdapter.populate(view, iCount);
                }
            } else if (iCount < 0) {
                updateViewVisibility(view, this.mEmptyViewBehavior);
            } else if (iCount >= this.mAdapter.count()) {
                updateViewVisibility(view, this.mEmptyViewBehavior);
            } else {
                updateViewVisibility(view, 0);
                this.mAdapter.populate(view, iCount);
            }
        }
        int i13 = this.mTargetIndex;
        if (i13 != -1 && i13 != this.mIndex) {
            this.mMotionLayout.post(new a(this, 0));
        } else if (i13 == this.mIndex) {
            this.mTargetIndex = -1;
        }
        if (this.mBackwardTransition == -1 || this.mForwardTransition == -1) {
            Log.w(TAG, "No backward or forward transitions defined for Carousel!");
            return;
        }
        if (this.mInfiniteCarousel) {
            return;
        }
        int iCount3 = this.mAdapter.count();
        int i14 = this.mIndex;
        int i15 = this.mBackwardTransition;
        if (i14 == 0) {
            enableTransition(i15, false);
        } else {
            enableTransition(i15, true);
            this.mMotionLayout.setTransition(this.mBackwardTransition);
        }
        int i16 = this.mIndex;
        int i17 = iCount3 - 1;
        int i18 = this.mForwardTransition;
        if (i16 == i17) {
            enableTransition(i18, false);
        } else {
            enableTransition(i18, true);
            this.mMotionLayout.setTransition(this.mForwardTransition);
        }
    }

    private boolean updateViewVisibility(int i10, View view, int i11) {
        ConstraintSet.Constraint constraint;
        ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(i10);
        if (constraintSet == null || (constraint = constraintSet.getConstraint(view.getId())) == null) {
            return false;
        }
        constraint.propertySet.mVisibilityMode = 1;
        view.setVisibility(i11);
        return true;
    }

    public int getCount() {
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            return adapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.mIndex;
    }

    public boolean isInfinite() {
        return this.mInfiniteCarousel;
    }

    public void jumpToIndex(int i10) {
        this.mIndex = Math.max(0, Math.min(getCount() - 1, i10));
        refresh();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            this.mList.clear();
            for (int i10 = 0; i10 < this.mCount; i10++) {
                int i11 = this.mIds[i10];
                View viewById = motionLayout.getViewById(i11);
                if (this.mFirstViewReference == i11) {
                    this.mStartIndex = i10;
                }
                this.mList.add(viewById);
            }
            this.mMotionLayout = motionLayout;
            if (this.mTouchUpMode == 2) {
                MotionScene.Transition transition = motionLayout.getTransition(this.mForwardTransition);
                if (transition != null) {
                    transition.setOnTouchUp(5);
                }
                MotionScene.Transition transition2 = this.mMotionLayout.getTransition(this.mBackwardTransition);
                if (transition2 != null) {
                    transition2.setOnTouchUp(5);
                }
            }
            updateItems();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mList.clear();
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout motionLayout, int i10, int i11, float f) {
        this.mLastStartId = i10;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout motionLayout, int i10) {
        int i11 = this.mIndex;
        this.mPreviousIndex = i11;
        if (i10 == this.mNextState) {
            this.mIndex = i11 + 1;
        } else if (i10 == this.mPreviousState) {
            this.mIndex = i11 - 1;
        }
        boolean z9 = this.mInfiniteCarousel;
        int i12 = this.mIndex;
        if (z9) {
            if (i12 >= this.mAdapter.count()) {
                this.mIndex = 0;
            }
            if (this.mIndex < 0) {
                this.mIndex = this.mAdapter.count() - 1;
            }
        } else {
            if (i12 >= this.mAdapter.count()) {
                this.mIndex = this.mAdapter.count() - 1;
            }
            if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        }
        if (this.mPreviousIndex != this.mIndex) {
            this.mMotionLayout.post(this.mUpdateRunnable);
        }
    }

    public void refresh() {
        int size = this.mList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = this.mList.get(i10);
            if (this.mAdapter.count() == 0) {
                updateViewVisibility(view, this.mEmptyViewBehavior);
            } else {
                updateViewVisibility(view, 0);
            }
        }
        this.mMotionLayout.rebuildScene();
        updateItems();
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void setInfinite(boolean z9) {
        this.mInfiniteCarousel = z9;
    }

    public void transitionToIndex(int i10, int i11) {
        this.mTargetIndex = Math.max(0, Math.min(getCount() - 1, i10));
        int iMax = Math.max(0, i11);
        this.mAnimateTargetDelay = iMax;
        this.mMotionLayout.setTransitionDuration(iMax);
        int i12 = this.mIndex;
        MotionLayout motionLayout = this.mMotionLayout;
        if (i10 < i12) {
            motionLayout.transitionToState(this.mPreviousState, this.mAnimateTargetDelay);
        } else {
            motionLayout.transitionToState(this.mNextState, this.mAnimateTargetDelay);
        }
    }

    private boolean updateViewVisibility(View view, int i10) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout == null) {
            return false;
        }
        boolean zUpdateViewVisibility = false;
        for (int i11 : motionLayout.getConstraintSetIds()) {
            zUpdateViewVisibility |= updateViewVisibility(i11, view, i10);
        }
        return zUpdateViewVisibility;
    }

    public Carousel(Context context) {
        super(context);
        this.mAdapter = null;
        this.mList = new ArrayList<>();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.mMotionLayout.setProgress(0.0f);
                Carousel.this.updateItems();
                Carousel.this.mAdapter.onNewItem(Carousel.this.mIndex);
                float velocity = Carousel.this.mMotionLayout.getVelocity();
                if (Carousel.this.mTouchUpMode != 2 || velocity <= Carousel.this.mVelocityThreshold || Carousel.this.mIndex >= Carousel.this.mAdapter.count() - 1) {
                    return;
                }
                final float f = Carousel.this.mDampening * velocity;
                if (Carousel.this.mIndex != 0 || Carousel.this.mPreviousIndex <= Carousel.this.mIndex) {
                    if (Carousel.this.mIndex != Carousel.this.mAdapter.count() - 1 || Carousel.this.mPreviousIndex >= Carousel.this.mIndex) {
                        Carousel.this.mMotionLayout.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Carousel.this.mMotionLayout.touchAnimateTo(5, 1.0f, f);
                            }
                        });
                    }
                }
            }
        };
    }

    public Carousel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAdapter = null;
        this.mList = new ArrayList<>();
        this.mPreviousIndex = 0;
        this.mIndex = 0;
        this.mFirstViewReference = -1;
        this.mInfiniteCarousel = false;
        this.mBackwardTransition = -1;
        this.mForwardTransition = -1;
        this.mPreviousState = -1;
        this.mNextState = -1;
        this.mDampening = 0.9f;
        this.mStartIndex = 0;
        this.mEmptyViewBehavior = 4;
        this.mTouchUpMode = 1;
        this.mVelocityThreshold = 2.0f;
        this.mTargetIndex = -1;
        this.mAnimateTargetDelay = 200;
        this.mLastStartId = -1;
        this.mUpdateRunnable = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.mMotionLayout.setProgress(0.0f);
                Carousel.this.updateItems();
                Carousel.this.mAdapter.onNewItem(Carousel.this.mIndex);
                float velocity = Carousel.this.mMotionLayout.getVelocity();
                if (Carousel.this.mTouchUpMode != 2 || velocity <= Carousel.this.mVelocityThreshold || Carousel.this.mIndex >= Carousel.this.mAdapter.count() - 1) {
                    return;
                }
                final float f = Carousel.this.mDampening * velocity;
                if (Carousel.this.mIndex != 0 || Carousel.this.mPreviousIndex <= Carousel.this.mIndex) {
                    if (Carousel.this.mIndex != Carousel.this.mAdapter.count() - 1 || Carousel.this.mPreviousIndex >= Carousel.this.mIndex) {
                        Carousel.this.mMotionLayout.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Carousel.this.mMotionLayout.touchAnimateTo(5, 1.0f, f);
                            }
                        });
                    }
                }
            }
        };
        init(context, attributeSet);
    }
}
