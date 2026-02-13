package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.browser.trusted.c;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ViewTransition {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    public static final String CONSTRAINT_OVERRIDE = "ConstraintOverride";
    public static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    public static final String CUSTOM_METHOD = "CustomMethod";
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    public static final String KEY_FRAME_SET_TAG = "KeyFrameSet";
    static final int LINEAR = 3;
    public static final int ONSTATE_ACTION_DOWN = 1;
    public static final int ONSTATE_ACTION_DOWN_UP = 3;
    public static final int ONSTATE_ACTION_UP = 2;
    public static final int ONSTATE_SHARED_VALUE_SET = 4;
    public static final int ONSTATE_SHARED_VALUE_UNSET = 5;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "ViewTransition";
    private static final int UNSET = -1;
    static final int VIEWTRANSITIONMODE_ALLSTATES = 1;
    static final int VIEWTRANSITIONMODE_CURRENTSTATE = 0;
    static final int VIEWTRANSITIONMODE_NOSTATE = 2;
    public static final String VIEW_TRANSITION_TAG = "ViewTransition";
    ConstraintSet.Constraint mConstraintDelta;
    Context mContext;
    private int mId;
    KeyFrames mKeyFrames;
    ConstraintSet mSet;
    private int mTargetId;
    private String mTargetString;
    int mViewTransitionMode;
    private int mOnStateTransition = -1;
    private boolean mDisabled = false;
    private int mPathMotionArc = 0;
    private int mDuration = -1;
    private int mUpDuration = -1;
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private int mDefaultInterpolatorID = -1;
    private int mSetsTag = -1;
    private int mClearsTag = -1;
    private int mIfTagSet = -1;
    private int mIfTagNotSet = -1;
    private int mSharedValueTarget = -1;
    private int mSharedValueID = -1;
    private int mSharedValueCurrent = -1;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Animate {
        private final int mClearsTag;
        float mDpositionDt;
        int mDuration;
        boolean mHoldAt100;
        Interpolator mInterpolator;
        long mLastRender;
        MotionController mMC;
        float mPosition;
        private final int mSetsTag;
        long mStart;
        int mUpDuration;
        ViewTransitionController mVtController;
        KeyCache mCache = new KeyCache();
        boolean mReverse = false;
        Rect mTempRec = new Rect();

        public Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i10, int i11, int i12, Interpolator interpolator, int i13, int i14) {
            this.mHoldAt100 = false;
            this.mVtController = viewTransitionController;
            this.mMC = motionController;
            this.mDuration = i10;
            this.mUpDuration = i11;
            long jNanoTime = System.nanoTime();
            this.mStart = jNanoTime;
            this.mLastRender = jNanoTime;
            this.mVtController.addAnimation(this);
            this.mInterpolator = interpolator;
            this.mSetsTag = i13;
            this.mClearsTag = i14;
            if (i12 == 3) {
                this.mHoldAt100 = true;
            }
            this.mDpositionDt = i10 == 0 ? Float.MAX_VALUE : 1.0f / i10;
            mutate();
        }

        public void mutate() {
            if (this.mReverse) {
                mutateReverse();
            } else {
                mutateForward();
            }
        }

        public void mutateForward() {
            long jNanoTime = System.nanoTime();
            long j10 = jNanoTime - this.mLastRender;
            this.mLastRender = jNanoTime;
            float f = (((float) (j10 * 1.0E-6d)) * this.mDpositionDt) + this.mPosition;
            this.mPosition = f;
            if (f >= 1.0f) {
                this.mPosition = 1.0f;
            }
            Interpolator interpolator = this.mInterpolator;
            float interpolation = this.mPosition;
            if (interpolator != null) {
                interpolation = interpolator.getInterpolation(interpolation);
            }
            float f10 = interpolation;
            MotionController motionController = this.mMC;
            boolean zInterpolate = motionController.interpolate(motionController.mView, f10, jNanoTime, this.mCache);
            if (this.mPosition >= 1.0f) {
                if (this.mSetsTag != -1) {
                    this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.mMC.getView().setTag(this.mClearsTag, null);
                }
                if (!this.mHoldAt100) {
                    this.mVtController.removeAnimation(this);
                }
            }
            if (this.mPosition < 1.0f || zInterpolate) {
                this.mVtController.invalidate();
            }
        }

        public void mutateReverse() {
            long jNanoTime = System.nanoTime();
            long j10 = jNanoTime - this.mLastRender;
            this.mLastRender = jNanoTime;
            float f = this.mPosition - (((float) (j10 * 1.0E-6d)) * this.mDpositionDt);
            this.mPosition = f;
            if (f < 0.0f) {
                this.mPosition = 0.0f;
            }
            Interpolator interpolator = this.mInterpolator;
            float interpolation = this.mPosition;
            if (interpolator != null) {
                interpolation = interpolator.getInterpolation(interpolation);
            }
            float f10 = interpolation;
            MotionController motionController = this.mMC;
            boolean zInterpolate = motionController.interpolate(motionController.mView, f10, jNanoTime, this.mCache);
            if (this.mPosition <= 0.0f) {
                if (this.mSetsTag != -1) {
                    this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
                }
                if (this.mClearsTag != -1) {
                    this.mMC.getView().setTag(this.mClearsTag, null);
                }
                this.mVtController.removeAnimation(this);
            }
            if (this.mPosition > 0.0f || zInterpolate) {
                this.mVtController.invalidate();
            }
        }

        public void reactTo(int i10, float f, float f10) {
            if (i10 == 1) {
                if (this.mReverse) {
                    return;
                }
                reverse(true);
            } else {
                if (i10 != 2) {
                    return;
                }
                this.mMC.getView().getHitRect(this.mTempRec);
                if (this.mTempRec.contains((int) f, (int) f10) || this.mReverse) {
                    return;
                }
                reverse(true);
            }
        }

        public void reverse(boolean z9) {
            int i10;
            this.mReverse = z9;
            if (z9 && (i10 = this.mUpDuration) != -1) {
                this.mDpositionDt = i10 == 0 ? Float.MAX_VALUE : 1.0f / i10;
            }
            this.mVtController.invalidate();
            this.mLastRender = System.nanoTime();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[Catch: IOException -> 0x0045, XmlPullParserException -> 0x0048, TryCatch #2 {IOException -> 0x0045, XmlPullParserException -> 0x0048, blocks: (B:3:0x002a, B:37:0x00cc, B:11:0x0039, B:18:0x004b, B:19:0x0053, B:36:0x0099, B:21:0x0057, B:26:0x0068, B:24:0x0060, B:27:0x0070, B:29:0x0076, B:30:0x007a, B:32:0x0082, B:33:0x008a, B:35:0x0092), top: B:42:0x002a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ViewTransition(android.content.Context r6, org.xmlpull.v1.XmlPullParser r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "Error parsing XML resource"
            java.lang.String r1 = "ViewTransition"
            r5.<init>()
            r2 = -1
            r5.mOnStateTransition = r2
            r3 = 0
            r5.mDisabled = r3
            r5.mPathMotionArc = r3
            r5.mDuration = r2
            r5.mUpDuration = r2
            r5.mDefaultInterpolator = r3
            r3 = 0
            r5.mDefaultInterpolatorString = r3
            r5.mDefaultInterpolatorID = r2
            r5.mSetsTag = r2
            r5.mClearsTag = r2
            r5.mIfTagSet = r2
            r5.mIfTagNotSet = r2
            r5.mSharedValueTarget = r2
            r5.mSharedValueID = r2
            r5.mSharedValueCurrent = r2
            r5.mContext = r6
            int r2 = r7.getEventType()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
        L2e:
            r3 = 1
            if (r2 == r3) goto Ld9
            r3 = 2
            if (r2 == r3) goto L4b
            r3 = 3
            if (r2 == r3) goto L39
            goto Lcc
        L39:
            java.lang.String r2 = r7.getName()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            boolean r2 = r1.equals(r2)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            if (r2 == 0) goto Lcc
            goto Ld9
        L45:
            r6 = move-exception
            goto Ld2
        L48:
            r6 = move-exception
            goto Ld6
        L4b:
            java.lang.String r2 = r7.getName()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            int r3 = r2.hashCode()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            switch(r3) {
                case -1962203927: goto L8a;
                case -1239391468: goto L7a;
                case 61998586: goto L70;
                case 366511058: goto L60;
                case 1791837707: goto L57;
                default: goto L56;
            }     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
        L56:
            goto L99
        L57:
            java.lang.String r3 = "CustomAttribute"
            boolean r3 = r2.equals(r3)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            if (r3 == 0) goto L99
            goto L68
        L60:
            java.lang.String r3 = "CustomMethod"
            boolean r3 = r2.equals(r3)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            if (r3 == 0) goto L99
        L68:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r5.mConstraintDelta     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r2.mCustomConstraints     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r6, r7, r2)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            goto Lcc
        L70:
            boolean r3 = r2.equals(r1)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            if (r3 == 0) goto L99
            r5.parseViewTransitionTags(r6, r7)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            goto Lcc
        L7a:
            java.lang.String r3 = "KeyFrameSet"
            boolean r3 = r2.equals(r3)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            if (r3 == 0) goto L99
            androidx.constraintlayout.motion.widget.KeyFrames r2 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            r2.<init>(r6, r7)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            r5.mKeyFrames = r2     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            goto Lcc
        L8a:
            java.lang.String r3 = "ConstraintOverride"
            boolean r3 = r2.equals(r3)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            if (r3 == 0) goto L99
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = androidx.constraintlayout.widget.ConstraintSet.buildDelta(r6, r7)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            r5.mConstraintDelta = r2     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            goto Lcc
        L99:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            r3.<init>()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            java.lang.String r4 = androidx.constraintlayout.motion.widget.Debug.getLoc()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            r3.append(r4)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            java.lang.String r4 = " unknown tag "
            r3.append(r4)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            r3.append(r2)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            java.lang.String r2 = r3.toString()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            android.util.Log.e(r1, r2)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            r2.<init>()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            java.lang.String r3 = ".xml:"
            r2.append(r3)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            int r3 = r7.getLineNumber()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            r2.append(r3)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            java.lang.String r2 = r2.toString()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            android.util.Log.e(r1, r2)     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
        Lcc:
            int r2 = r7.next()     // Catch: java.io.IOException -> L45 org.xmlpull.v1.XmlPullParserException -> L48
            goto L2e
        Ld2:
            android.util.Log.e(r1, r0, r6)
            goto Ld9
        Ld6:
            android.util.Log.e(r1, r0, r6)
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyTransition$0(View[] viewArr) {
        if (this.mSetsTag != -1) {
            for (View view : viewArr) {
                view.setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.mClearsTag != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.mClearsTag, null);
            }
        }
    }

    private void parseViewTransitionTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ViewTransition);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.ViewTransition_android_id) {
                this.mId = typedArrayObtainStyledAttributes.getResourceId(index, this.mId);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.mTargetId);
                    this.mTargetId = resourceId;
                    if (resourceId == -1) {
                        this.mTargetString = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.mTargetString = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.mTargetId = typedArrayObtainStyledAttributes.getResourceId(index, this.mTargetId);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.mOnStateTransition = typedArrayObtainStyledAttributes.getInt(index, this.mOnStateTransition);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.mDisabled = typedArrayObtainStyledAttributes.getBoolean(index, this.mDisabled);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.mPathMotionArc = typedArrayObtainStyledAttributes.getInt(index, this.mPathMotionArc);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.mDuration = typedArrayObtainStyledAttributes.getInt(index, this.mDuration);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.mUpDuration = typedArrayObtainStyledAttributes.getInt(index, this.mUpDuration);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.mViewTransitionMode = typedArrayObtainStyledAttributes.getInt(index, this.mViewTransitionMode);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i11 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.mDefaultInterpolatorID = resourceId2;
                    if (resourceId2 != -1) {
                        this.mDefaultInterpolator = -2;
                    }
                } else if (i11 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.mDefaultInterpolatorString = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.mDefaultInterpolator = -1;
                    } else {
                        this.mDefaultInterpolatorID = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.mDefaultInterpolator = -2;
                    }
                } else {
                    this.mDefaultInterpolator = typedArrayObtainStyledAttributes.getInteger(index, this.mDefaultInterpolator);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.mSetsTag = typedArrayObtainStyledAttributes.getResourceId(index, this.mSetsTag);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.mClearsTag = typedArrayObtainStyledAttributes.getResourceId(index, this.mClearsTag);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.mIfTagSet = typedArrayObtainStyledAttributes.getResourceId(index, this.mIfTagSet);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.mIfTagNotSet = typedArrayObtainStyledAttributes.getResourceId(index, this.mIfTagNotSet);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.mSharedValueID = typedArrayObtainStyledAttributes.getResourceId(index, this.mSharedValueID);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.mSharedValueTarget = typedArrayObtainStyledAttributes.getInteger(index, this.mSharedValueTarget);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void updateTransition(MotionScene.Transition transition, View view) {
        int i10 = this.mDuration;
        if (i10 != -1) {
            transition.setDuration(i10);
        }
        transition.setPathMotionArc(this.mPathMotionArc);
        transition.setInterpolatorInfo(this.mDefaultInterpolator, this.mDefaultInterpolatorString, this.mDefaultInterpolatorID);
        int id = view.getId();
        KeyFrames keyFrames = this.mKeyFrames;
        if (keyFrames != null) {
            ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(-1);
            KeyFrames keyFrames2 = new KeyFrames();
            int size = keyFramesForView.size();
            int i11 = 0;
            while (i11 < size) {
                Key key = keyFramesForView.get(i11);
                i11++;
                keyFrames2.addKey(key.mo35clone().setViewId(id));
            }
            transition.addKeyFrame(keyFrames2);
        }
    }

    public void applyIndependentTransition(ViewTransitionController viewTransitionController, MotionLayout motionLayout, View view) {
        MotionController motionController = new MotionController(view);
        motionController.setBothStates(view);
        this.mKeyFrames.addAllFrames(motionController);
        motionController.setup(motionLayout.getWidth(), motionLayout.getHeight(), this.mDuration, System.nanoTime());
        new Animate(viewTransitionController, motionController, this.mDuration, this.mUpDuration, this.mOnStateTransition, getInterpolator(motionLayout.getContext()), this.mSetsTag, this.mClearsTag);
    }

    public void applyTransition(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i10, ConstraintSet constraintSet, View... viewArr) {
        if (this.mDisabled) {
            return;
        }
        int i11 = this.mViewTransitionMode;
        if (i11 == 2) {
            applyIndependentTransition(viewTransitionController, motionLayout, viewArr[0]);
            return;
        }
        if (i11 == 1) {
            for (int i12 : motionLayout.getConstraintSetIds()) {
                if (i12 != i10) {
                    ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i12);
                    for (View view : viewArr) {
                        ConstraintSet.Constraint constraint = constraintSet2.getConstraint(view.getId());
                        ConstraintSet.Constraint constraint2 = this.mConstraintDelta;
                        if (constraint2 != null) {
                            constraint2.applyDelta(constraint);
                            constraint.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
                        }
                    }
                }
            }
        }
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(constraintSet);
        for (View view2 : viewArr) {
            ConstraintSet.Constraint constraint3 = constraintSet3.getConstraint(view2.getId());
            ConstraintSet.Constraint constraint4 = this.mConstraintDelta;
            if (constraint4 != null) {
                constraint4.applyDelta(constraint3);
                constraint3.mCustomConstraints.putAll(this.mConstraintDelta.mCustomConstraints);
            }
        }
        motionLayout.updateState(i10, constraintSet3);
        int i13 = R.id.view_transition;
        motionLayout.updateState(i13, constraintSet);
        motionLayout.setState(i13, -1, -1);
        MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.mScene, i13, i10);
        for (View view3 : viewArr) {
            updateTransition(transition, view3);
        }
        motionLayout.setTransition(transition);
        motionLayout.transitionToEnd(new c(1, this, viewArr));
    }

    public boolean checkTags(View view) {
        int i10 = this.mIfTagSet;
        boolean z9 = i10 == -1 || view.getTag(i10) != null;
        int i11 = this.mIfTagNotSet;
        return z9 && (i11 == -1 || view.getTag(i11) == null);
    }

    public int getId() {
        return this.mId;
    }

    public Interpolator getInterpolator(Context context) {
        int i10 = this.mDefaultInterpolator;
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(context, this.mDefaultInterpolatorID);
        }
        if (i10 == -1) {
            final Easing interpolator = Easing.getInterpolator(this.mDefaultInterpolatorString);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.ViewTransition.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    return (float) interpolator.get(f);
                }
            };
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 == 5) {
            return new OvershootInterpolator();
        }
        if (i10 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int getSharedValue() {
        return this.mSharedValueTarget;
    }

    public int getSharedValueCurrent() {
        return this.mSharedValueCurrent;
    }

    public int getSharedValueID() {
        return this.mSharedValueID;
    }

    public int getStateTransition() {
        return this.mOnStateTransition;
    }

    public boolean isEnabled() {
        return !this.mDisabled;
    }

    public boolean matchesView(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.mTargetId == -1 && this.mTargetString == null) || !checkTags(view)) {
            return false;
        }
        if (view.getId() == this.mTargetId) {
            return true;
        }
        return this.mTargetString != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).constraintTag) != null && str.matches(this.mTargetString);
    }

    public void setEnabled(boolean z9) {
        this.mDisabled = !z9;
    }

    public void setId(int i10) {
        this.mId = i10;
    }

    public void setSharedValue(int i10) {
        this.mSharedValueTarget = i10;
    }

    public void setSharedValueCurrent(int i10) {
        this.mSharedValueCurrent = i10;
    }

    public void setSharedValueID(int i10) {
        this.mSharedValueID = i10;
    }

    public void setStateTransition(int i10) {
        this.mOnStateTransition = i10;
    }

    public boolean supports(int i10) {
        int i11 = this.mOnStateTransition;
        return i11 == 1 ? i10 == 0 : i11 == 2 ? i10 == 1 : i11 == 3 && i10 == 0;
    }

    public String toString() {
        return "ViewTransition(" + Debug.getName(this.mContext, this.mId) + ")";
    }
}
