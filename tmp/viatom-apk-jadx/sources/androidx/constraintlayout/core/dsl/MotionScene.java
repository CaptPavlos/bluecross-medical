package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class MotionScene {
    ArrayList<Transition> mTransitions = new ArrayList<>();
    ArrayList<ConstraintSet> mConstraintSets = new ArrayList<>();

    public void addConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSets.add(constraintSet);
    }

    public void addTransition(Transition transition) {
        this.mTransitions.add(transition);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        int i10 = 0;
        if (!this.mTransitions.isEmpty()) {
            sb.append("Transitions:{\n");
            ArrayList<Transition> arrayList = this.mTransitions;
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Transition transition = arrayList.get(i11);
                i11++;
                sb.append(transition.toString());
            }
            sb.append("},\n");
        }
        if (!this.mConstraintSets.isEmpty()) {
            sb.append("ConstraintSets:{\n");
            ArrayList<ConstraintSet> arrayList2 = this.mConstraintSets;
            int size2 = arrayList2.size();
            while (i10 < size2) {
                ConstraintSet constraintSet = arrayList2.get(i10);
                i10++;
                sb.append(constraintSet.toString());
            }
            sb.append("},\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
