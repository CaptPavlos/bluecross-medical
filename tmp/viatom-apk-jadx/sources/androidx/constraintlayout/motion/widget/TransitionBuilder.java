package androidx.constraintlayout.motion.widget;

import a2.a;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class TransitionBuilder {
    private static final String TAG = "TransitionBuilder";

    public static MotionScene.Transition buildTransition(MotionScene motionScene, int i10, int i11, ConstraintSet constraintSet, int i12, ConstraintSet constraintSet2) {
        MotionScene.Transition transition = new MotionScene.Transition(i10, motionScene, i11, i12);
        updateConstraintSetInMotionScene(motionScene, transition, constraintSet, constraintSet2);
        return transition;
    }

    private static void updateConstraintSetInMotionScene(MotionScene motionScene, MotionScene.Transition transition, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
        int startConstraintSetId = transition.getStartConstraintSetId();
        int endConstraintSetId = transition.getEndConstraintSetId();
        motionScene.setConstraintSet(startConstraintSetId, constraintSet);
        motionScene.setConstraintSet(endConstraintSetId, constraintSet2);
    }

    public static void validate(MotionLayout motionLayout) {
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            a.j("Invalid motion layout. Layout missing Motion Scene.");
            return;
        }
        if (!motionScene.validateLayout(motionLayout)) {
            a.j("MotionLayout doesn't have the right motion scene.");
        } else if (motionScene.mCurrentTransition == null || motionScene.getDefinedTransitions().isEmpty()) {
            a.j("Invalid motion layout. Motion Scene doesn't have any transition.");
        }
    }
}
