package androidx.leanback.transition;

import android.animation.Animator;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class CustomChangeBounds extends ChangeBounds {
    int mDefaultStartDelay;
    final HashMap<View, Integer> mViewStartDelays = new HashMap<>();
    final SparseIntArray mIdStartDelays = new SparseIntArray();
    final HashMap<String, Integer> mClassStartDelays = new HashMap<>();

    private int getDelay(View view) {
        Integer num = this.mViewStartDelays.get(view);
        if (num != null) {
            return num.intValue();
        }
        int i10 = this.mIdStartDelays.get(view.getId(), -1);
        if (i10 != -1) {
            return i10;
        }
        Integer num2 = this.mClassStartDelays.get(view.getClass().getName());
        return num2 != null ? num2.intValue() : this.mDefaultStartDelay;
    }

    @Override // android.transition.ChangeBounds, android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view;
        Animator animatorCreateAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
        if (animatorCreateAnimator != null && transitionValues2 != null && (view = transitionValues2.view) != null) {
            animatorCreateAnimator.setStartDelay(getDelay(view));
        }
        return animatorCreateAnimator;
    }

    public void setDefaultStartDelay(int i10) {
        this.mDefaultStartDelay = i10;
    }

    public void setStartDelay(View view, int i10) {
        this.mViewStartDelays.put(view, Integer.valueOf(i10));
    }

    public void setStartDelay(int i10, int i11) {
        this.mIdStartDelays.put(i10, i11);
    }

    public void setStartDelay(String str, int i10) {
        this.mClassStartDelays.put(str, Integer.valueOf(i10));
    }
}
