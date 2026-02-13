package androidx.transition;

import androidx.transition.Transition;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Transition.TransitionNotification {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f651a;

    public static /* synthetic */ void a(Object obj, String str) {
        throw new RuntimeException(str + obj);
    }

    @Override // androidx.transition.Transition.TransitionNotification
    public void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z9) {
        switch (this.f651a) {
            case 0:
                transitionListener.onTransitionStart(transition, z9);
                break;
            case 1:
                transitionListener.onTransitionEnd(transition, z9);
                break;
            case 2:
                transitionListener.onTransitionCancel(transition);
                break;
            case 3:
                transitionListener.onTransitionPause(transition);
                break;
            default:
                transitionListener.onTransitionResume(transition);
                break;
        }
    }
}
