package androidx.transition;

import androidx.annotation.NonNull;
import androidx.transition.Transition;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class TransitionListenerAdapter implements Transition.TransitionListener {
    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition, boolean z9) {
        onTransitionEnd(transition);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition, boolean z9) {
        onTransitionStart(transition);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionStart(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionCancel(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionPause(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionResume(@NonNull Transition transition) {
    }
}
