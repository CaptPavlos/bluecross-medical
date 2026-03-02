package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ViewTransitionController {
    ArrayList<ViewTransition.Animate> mAnimations;
    private final MotionLayout mMotionLayout;
    private HashSet<View> mRelatedViews;
    private ArrayList<ViewTransition> mViewTransitions = new ArrayList<>();
    private String mTAG = "ViewTransitionController";
    ArrayList<ViewTransition.Animate> mRemoveList = new ArrayList<>();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private void listenForSharedVariable(final ViewTransition viewTransition, final boolean z9) {
        final int sharedValueID = viewTransition.getSharedValueID();
        final int sharedValue = viewTransition.getSharedValue();
        ConstraintLayout.getSharedValues().addListener(viewTransition.getSharedValueID(), new SharedValues.SharedValuesListener() { // from class: androidx.constraintlayout.motion.widget.ViewTransitionController.1
            @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
            public void onNewValue(int i10, int i11, int i12) {
                int sharedValueCurrent = viewTransition.getSharedValueCurrent();
                viewTransition.setSharedValueCurrent(i11);
                if (sharedValueID != i10 || sharedValueCurrent == i11) {
                    return;
                }
                boolean z10 = z9;
                int i13 = sharedValue;
                if (z10) {
                    if (i13 == i11) {
                        int childCount = ViewTransitionController.this.mMotionLayout.getChildCount();
                        for (int i14 = 0; i14 < childCount; i14++) {
                            View childAt = ViewTransitionController.this.mMotionLayout.getChildAt(i14);
                            if (viewTransition.matchesView(childAt)) {
                                int currentState = ViewTransitionController.this.mMotionLayout.getCurrentState();
                                ConstraintSet constraintSet = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState);
                                ViewTransition viewTransition2 = viewTransition;
                                ViewTransitionController viewTransitionController = ViewTransitionController.this;
                                viewTransition2.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, childAt);
                            }
                        }
                        return;
                    }
                    return;
                }
                if (i13 != i11) {
                    int childCount2 = ViewTransitionController.this.mMotionLayout.getChildCount();
                    for (int i15 = 0; i15 < childCount2; i15++) {
                        View childAt2 = ViewTransitionController.this.mMotionLayout.getChildAt(i15);
                        if (viewTransition.matchesView(childAt2)) {
                            int currentState2 = ViewTransitionController.this.mMotionLayout.getCurrentState();
                            ConstraintSet constraintSet2 = ViewTransitionController.this.mMotionLayout.getConstraintSet(currentState2);
                            ViewTransition viewTransition3 = viewTransition;
                            ViewTransitionController viewTransitionController2 = ViewTransitionController.this;
                            viewTransition3.applyTransition(viewTransitionController2, viewTransitionController2.mMotionLayout, currentState2, constraintSet2, childAt2);
                        }
                    }
                }
            }
        });
    }

    public void add(ViewTransition viewTransition) {
        this.mViewTransitions.add(viewTransition);
        this.mRelatedViews = null;
        if (viewTransition.getStateTransition() == 4) {
            listenForSharedVariable(viewTransition, true);
        } else if (viewTransition.getStateTransition() == 5) {
            listenForSharedVariable(viewTransition, false);
        }
    }

    public void addAnimation(ViewTransition.Animate animate) {
        if (this.mAnimations == null) {
            this.mAnimations = new ArrayList<>();
        }
        this.mAnimations.add(animate);
    }

    public void animate() {
        ArrayList<ViewTransition.Animate> arrayList = this.mAnimations;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            ViewTransition.Animate animate = arrayList.get(i10);
            i10++;
            animate.mutate();
        }
        this.mAnimations.removeAll(this.mRemoveList);
        this.mRemoveList.clear();
        if (this.mAnimations.isEmpty()) {
            this.mAnimations = null;
        }
    }

    public boolean applyViewTransition(int i10, MotionController motionController) {
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            ViewTransition viewTransition = arrayList.get(i11);
            i11++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i10) {
                viewTransition2.mKeyFrames.addAllFrames(motionController);
                return true;
            }
        }
        return false;
    }

    public void enableViewTransition(int i10, boolean z9) {
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            ViewTransition viewTransition = arrayList.get(i11);
            i11++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i10) {
                viewTransition2.setEnabled(z9);
                return;
            }
        }
    }

    public void invalidate() {
        this.mMotionLayout.invalidate();
    }

    public boolean isViewTransitionEnabled(int i10) {
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            ViewTransition viewTransition = arrayList.get(i11);
            i11++;
            ViewTransition viewTransition2 = viewTransition;
            if (viewTransition2.getId() == i10) {
                return viewTransition2.isEnabled();
            }
        }
        return false;
    }

    public void remove(int i10) {
        ViewTransition viewTransition;
        ArrayList<ViewTransition> arrayList = this.mViewTransitions;
        int size = arrayList.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                viewTransition = null;
                break;
            }
            ViewTransition viewTransition2 = arrayList.get(i11);
            i11++;
            viewTransition = viewTransition2;
            if (viewTransition.getId() == i10) {
                break;
            }
        }
        if (viewTransition != null) {
            this.mRelatedViews = null;
            this.mViewTransitions.remove(viewTransition);
        }
    }

    public void removeAnimation(ViewTransition.Animate animate) {
        this.mRemoveList.add(animate);
    }

    public void touchEvent(MotionEvent motionEvent) {
        ViewTransitionController viewTransitionController = this;
        int currentState = viewTransitionController.mMotionLayout.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (viewTransitionController.mRelatedViews == null) {
            viewTransitionController.mRelatedViews = new HashSet<>();
            ArrayList<ViewTransition> arrayList = viewTransitionController.mViewTransitions;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                ViewTransition viewTransition = arrayList.get(i10);
                i10++;
                ViewTransition viewTransition2 = viewTransition;
                int childCount = viewTransitionController.mMotionLayout.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewTransitionController.mMotionLayout.getChildAt(i11);
                    if (viewTransition2.matchesView(childAt)) {
                        childAt.getId();
                        viewTransitionController.mRelatedViews.add(childAt);
                    }
                }
            }
        }
        float x3 = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList<ViewTransition.Animate> arrayList2 = viewTransitionController.mAnimations;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            ArrayList<ViewTransition.Animate> arrayList3 = viewTransitionController.mAnimations;
            int size2 = arrayList3.size();
            int i12 = 0;
            while (i12 < size2) {
                ViewTransition.Animate animate = arrayList3.get(i12);
                i12++;
                animate.reactTo(action, x3, y);
            }
        }
        if (action == 0 || action == 1) {
            ConstraintSet constraintSet = viewTransitionController.mMotionLayout.getConstraintSet(currentState);
            ArrayList<ViewTransition> arrayList4 = viewTransitionController.mViewTransitions;
            int size3 = arrayList4.size();
            int i13 = 0;
            while (i13 < size3) {
                int i14 = i13 + 1;
                ViewTransition viewTransition3 = arrayList4.get(i13);
                if (viewTransition3.supports(action)) {
                    Iterator<View> it = viewTransitionController.mRelatedViews.iterator();
                    while (it.hasNext()) {
                        View next = it.next();
                        if (viewTransition3.matchesView(next)) {
                            next.getHitRect(rect);
                            if (rect.contains((int) x3, (int) y)) {
                                viewTransition3.applyTransition(viewTransitionController, viewTransitionController.mMotionLayout, currentState, constraintSet, next);
                            }
                            viewTransitionController = this;
                        }
                    }
                }
                viewTransitionController = this;
                i13 = i14;
            }
        }
    }

    public void viewTransition(int i10, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList<ViewTransition> arrayList2 = this.mViewTransitions;
        int size = arrayList2.size();
        ViewTransition viewTransition = null;
        int i11 = 0;
        while (i11 < size) {
            ViewTransition viewTransition2 = arrayList2.get(i11);
            i11++;
            ViewTransition viewTransition3 = viewTransition2;
            if (viewTransition3.getId() == i10) {
                for (View view : viewArr) {
                    if (viewTransition3.checkTags(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    viewTransition(viewTransition3, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                viewTransition = viewTransition3;
            }
        }
        if (viewTransition == null) {
            Log.e(this.mTAG, " Could not find ViewTransition");
        }
    }

    private void viewTransition(ViewTransition viewTransition, View... viewArr) {
        int currentState = this.mMotionLayout.getCurrentState();
        if (viewTransition.mViewTransitionMode == 2) {
            viewTransition.applyTransition(this, this.mMotionLayout, currentState, null, viewArr);
            return;
        }
        if (currentState == -1) {
            Log.w(this.mTAG, "No support for ViewTransition within transition yet. Currently: " + this.mMotionLayout.toString());
            return;
        }
        ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(currentState);
        if (constraintSet == null) {
            return;
        }
        viewTransition.applyTransition(this, this.mMotionLayout, currentState, constraintSet, viewArr);
    }
}
