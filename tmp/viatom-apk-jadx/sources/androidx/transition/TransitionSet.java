package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mChangeFlags;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    ArrayList<Transition> mTransitions;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        public TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            int i10 = transitionSet.mCurrentListeners - 1;
            transitionSet.mCurrentListeners = i10;
            if (i10 == 0) {
                transitionSet.mStarted = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            if (transitionSet.mStarted) {
                return;
            }
            transitionSet.start();
            this.mTransitionSet.mStarted = true;
        }
    }

    public TransitionSet(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void addTransitionInternal(@NonNull Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
    }

    private int indexOfTransition(long j10) {
        int i10 = 1;
        while (true) {
            int size = this.mTransitions.size();
            ArrayList<Transition> arrayList = this.mTransitions;
            if (i10 >= size) {
                return arrayList.size() - 1;
            }
            if (arrayList.get(i10).mSeekOffsetInParent > j10) {
                return i10 - 1;
            }
            i10++;
        }
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        ArrayList<Transition> arrayList = this.mTransitions;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Transition transition = arrayList.get(i10);
            i10++;
            transition.addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            this.mTransitions.get(i10).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        addTransitionInternal(transition);
        long j10 = this.mDuration;
        if (j10 >= 0) {
            transition.setDuration(j10);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTransitions.get(i10).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            ArrayList<Transition> arrayList = this.mTransitions;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Transition transition = arrayList.get(i10);
                i10++;
                Transition transition2 = transition;
                if (transition2.isValidTarget(transitionValues.view)) {
                    transition2.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition2);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTransitions.get(i10).capturePropagationValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            ArrayList<Transition> arrayList = this.mTransitions;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Transition transition = arrayList.get(i10);
                i10++;
                Transition transition2 = transition;
                if (transition2.isValidTarget(transitionValues.view)) {
                    transition2.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition2);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    /* renamed from: clone */
    public Transition mo224clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo224clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            transitionSet.addTransitionInternal(this.mTransitions.get(i10).mo224clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    public void createAnimators(@NonNull ViewGroup viewGroup, @NonNull TransitionValuesMaps transitionValuesMaps, @NonNull TransitionValuesMaps transitionValuesMaps2, @NonNull ArrayList<TransitionValues> arrayList, @NonNull ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            Transition transition = this.mTransitions.get(i10);
            if (startDelay > 0 && (this.mPlayTogether || i10 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z9) {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            this.mTransitions.get(i10).excludeTarget(view, z9);
        }
        return super.excludeTarget(view, z9);
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTransitions.get(i10).forceToEnd(viewGroup);
        }
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int i10) {
        if (i10 < 0 || i10 >= this.mTransitions.size()) {
            return null;
        }
        return this.mTransitions.get(i10);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    public boolean hasAnimators() {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            if (this.mTransitions.get(i10).hasAnimators()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.mTransitions.get(i10).isSeekingSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(@Nullable View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTransitions.get(i10).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    @RequiresApi(34)
    public void prepareAnimatorsForSeeking() {
        this.mTotalDuration = 0L;
        TransitionListenerAdapter transitionListenerAdapter = new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.2
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionCancel(@NonNull Transition transition) {
                TransitionSet.this.mTransitions.remove(transition);
                if (TransitionSet.this.hasAnimators()) {
                    return;
                }
                TransitionSet.this.notifyListeners(Transition.TransitionNotification.ON_CANCEL, false);
                TransitionSet transitionSet = TransitionSet.this;
                transitionSet.mEnded = true;
                transitionSet.notifyListeners(Transition.TransitionNotification.ON_END, false);
            }
        };
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            Transition transition = this.mTransitions.get(i10);
            transition.addListener(transitionListenerAdapter);
            transition.prepareAnimatorsForSeeking();
            long totalDurationMillis = transition.getTotalDurationMillis();
            boolean z9 = this.mPlayTogether;
            long j10 = this.mTotalDuration;
            if (z9) {
                this.mTotalDuration = Math.max(j10, totalDurationMillis);
            } else {
                transition.mSeekOffsetInParent = j10;
                this.mTotalDuration = j10 + totalDurationMillis;
            }
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int i10) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).removeTarget(i10);
        }
        return (TransitionSet) super.removeTarget(i10);
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(@Nullable View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTransitions.get(i10).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        ArrayList<Transition> arrayList;
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        int i10 = 0;
        if (this.mPlayTogether) {
            ArrayList<Transition> arrayList2 = this.mTransitions;
            int size = arrayList2.size();
            while (i10 < size) {
                Transition transition = arrayList2.get(i10);
                i10++;
                transition.runAnimators();
            }
            return;
        }
        int i11 = 1;
        while (true) {
            int size2 = this.mTransitions.size();
            arrayList = this.mTransitions;
            if (i11 >= size2) {
                break;
            }
            Transition transition2 = arrayList.get(i11 - 1);
            final Transition transition3 = this.mTransitions.get(i11);
            transition2.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition4) {
                    transition3.runAnimators();
                    transition4.removeListener(this);
                }
            });
            i11++;
        }
        Transition transition4 = arrayList.get(0);
        if (transition4 != null) {
            transition4.runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean z9) {
        super.setCanRemoveViews(z9);
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTransitions.get(i10).setCanRemoveViews(z9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // androidx.transition.Transition
    @androidx.annotation.RequiresApi(34)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurrentPlayTimeMillis(long r20, long r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = r22
            long r5 = r0.getTotalDurationMillis()
            androidx.transition.TransitionSet r7 = r0.mParent
            r8 = 0
            if (r7 == 0) goto L22
            int r7 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r7 >= 0) goto L18
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 < 0) goto Lc2
        L18:
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L22
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L22
            goto Lc2
        L22:
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r10 = 0
            r11 = 1
            if (r7 >= 0) goto L2a
            r12 = r11
            goto L2b
        L2a:
            r12 = r10
        L2b:
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 < 0) goto L33
            int r14 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r14 < 0) goto L3b
        L33:
            int r14 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r14 > 0) goto L42
            int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r14 <= 0) goto L42
        L3b:
            r0.mEnded = r10
            androidx.transition.Transition$TransitionNotification r14 = androidx.transition.Transition.TransitionNotification.ON_START
            r0.notifyListeners(r14, r12)
        L42:
            boolean r14 = r0.mPlayTogether
            if (r14 == 0) goto L5f
        L46:
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.mTransitions
            int r7 = r7.size()
            if (r10 >= r7) goto L5c
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.mTransitions
            java.lang.Object r7 = r7.get(r10)
            androidx.transition.Transition r7 = (androidx.transition.Transition) r7
            r7.setCurrentPlayTimeMillis(r1, r3)
            int r10 = r10 + 1
            goto L46
        L5c:
            r16 = r8
            goto La7
        L5f:
            int r10 = r0.indexOfTransition(r3)
            if (r7 < 0) goto L8a
        L65:
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.mTransitions
            int r7 = r7.size()
            if (r10 >= r7) goto L5c
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.mTransitions
            java.lang.Object r7 = r7.get(r10)
            androidx.transition.Transition r7 = (androidx.transition.Transition) r7
            long r14 = r7.mSeekOffsetInParent
            r16 = r8
            long r8 = r1 - r14
            int r18 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r18 >= 0) goto L80
            goto La7
        L80:
            long r14 = r3 - r14
            r7.setCurrentPlayTimeMillis(r8, r14)
            int r10 = r10 + 1
            r8 = r16
            goto L65
        L8a:
            r16 = r8
        L8c:
            if (r10 < 0) goto La7
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.mTransitions
            java.lang.Object r7 = r7.get(r10)
            androidx.transition.Transition r7 = (androidx.transition.Transition) r7
            long r8 = r7.mSeekOffsetInParent
            long r14 = r1 - r8
            long r8 = r3 - r8
            r7.setCurrentPlayTimeMillis(r14, r8)
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 < 0) goto La4
            goto La7
        La4:
            int r10 = r10 + (-1)
            goto L8c
        La7:
            androidx.transition.TransitionSet r7 = r0.mParent
            if (r7 == 0) goto Lc2
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto Lb3
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 <= 0) goto Lb9
        Lb3:
            if (r13 >= 0) goto Lc2
            int r2 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r2 < 0) goto Lc2
        Lb9:
            if (r1 <= 0) goto Lbd
            r0.mEnded = r11
        Lbd:
            androidx.transition.Transition$TransitionNotification r1 = androidx.transition.Transition.TransitionNotification.ON_END
            r0.notifyListeners(r1, r12)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionSet.setCurrentPlayTimeMillis(long, long):void");
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setDuration(long j10) {
        ArrayList<Transition> arrayList;
        super.setDuration(j10);
        if (this.mDuration >= 0 && (arrayList = this.mTransitions) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mTransitions.get(i10).setDuration(j10);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(@Nullable Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTransitions.get(i10).setEpicenterCallback(epicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mTransitions.get(i10).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @NonNull
    public TransitionSet setOrdering(int i10) {
        if (i10 == 0) {
            this.mPlayTogether = true;
            return this;
        }
        if (i10 != 1) {
            throw new AndroidRuntimeException(a3.a.f(i10, "Invalid parameter for TransitionSet ordering: "));
        }
        this.mPlayTogether = false;
        return this;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(@Nullable PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
                this.mTransitions.get(i10).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTransitions.get(i10).setPropagation(transitionPropagation);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long j10) {
        return (TransitionSet) super.setStartDelay(j10);
    }

    @Override // androidx.transition.Transition
    public String toString(String str) {
        String string = super.toString(str);
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            StringBuilder sbW = a3.a.w(string, "\n");
            sbW.append(this.mTransitions.get(i10).toString(str + "  "));
            string = sbW.toString();
        }
        return string;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z9) {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            this.mTransitions.get(i10).excludeTarget(str, z9);
        }
        return super.excludeTarget(str, z9);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull Class cls) {
        return addTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(int i10, boolean z9) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).excludeTarget(i10, z9);
        }
        return super.excludeTarget(i10, z9);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull Class cls) {
        return removeTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int i10) {
        for (int i11 = 0; i11 < this.mTransitions.size(); i11++) {
            this.mTransitions.get(i11).addTarget(i10);
        }
        return (TransitionSet) super.addTarget(i10);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z9) {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            this.mTransitions.get(i10).excludeTarget(cls, z9);
        }
        return super.excludeTarget(cls, z9);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            this.mTransitions.get(i10).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            this.mTransitions.get(i10).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> cls) {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            this.mTransitions.get(i10).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    public TransitionSet() {
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> cls) {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            this.mTransitions.get(i10).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        for (int i10 = 0; i10 < this.mTransitions.size(); i10++) {
            this.mTransitions.get(i10).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }
}
