package androidx.constraintlayout.core.widgets;

import a3.a;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private int mBarrierType = 0;
    private boolean mAllowsGoneWidget = true;
    private int mMargin = 0;
    boolean mResolved = false;

    public Barrier(String str) {
        setDebugName(str);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z9) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z10;
        int i10;
        int i11;
        int i12;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i13 = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i13 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i13];
            constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
            i13++;
        }
        int i14 = this.mBarrierType;
        if (i14 < 0 || i14 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i14];
        if (!this.mResolved) {
            allSolved();
        }
        if (this.mResolved) {
            this.mResolved = false;
            int i15 = this.mBarrierType;
            if (i15 == 0 || i15 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                return;
            } else {
                if (i15 == 2 || i15 == 3) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                    return;
                }
                return;
            }
        }
        for (int i16 = 0; i16 < this.mWidgetsCount; i16++) {
            ConstraintWidget constraintWidget = this.mWidgets[i16];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i11 = this.mBarrierType) == 0 || i11 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i12 = this.mBarrierType) == 2 || i12 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z10 = true;
                break;
            }
        }
        z10 = false;
        boolean z11 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
        boolean z12 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
        int i17 = !(!z10 && (((i10 = this.mBarrierType) == 0 && z11) || ((i10 == 2 && z12) || ((i10 == 1 && z11) || (i10 == 3 && z12))))) ? 4 : 5;
        for (int i18 = 0; i18 < this.mWidgetsCount; i18++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i18];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                int i19 = this.mBarrierType;
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i19];
                constraintAnchor3.mSolverVariable = solverVariableCreateObjectVariable;
                ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                int i20 = (constraintAnchor4 == null || constraintAnchor4.mOwner != this) ? 0 : constraintAnchor3.mMargin;
                if (i19 == 0 || i19 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin - i20, z10);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin + i20, z10);
                }
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, solverVariableCreateObjectVariable, this.mMargin + i20, i17);
            }
        }
        int i21 = this.mBarrierType;
        if (i21 == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            return;
        }
        if (i21 == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        } else if (i21 == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        } else if (i21 == 3) {
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    public boolean allSolved() {
        int i10;
        int i11;
        int i12;
        boolean z9 = true;
        int i13 = 0;
        while (true) {
            i10 = this.mWidgetsCount;
            if (i13 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i13];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i11 = this.mBarrierType) == 0 || i11 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i12 = this.mBarrierType) == 2 || i12 == 3) && !constraintWidget.isResolvedVertically()))) {
                z9 = false;
            }
            i13++;
        }
        if (!z9 || i10 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z10 = false;
        for (int i14 = 0; i14 < this.mWidgetsCount; i14++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i14];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z10) {
                    int i15 = this.mBarrierType;
                    if (i15 == 0) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i15 == 1) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i15 == 2) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i15 == 3) {
                        iMax = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z10 = true;
                }
                int i16 = this.mBarrierType;
                if (i16 == 0) {
                    iMax = Math.min(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i16 == 1) {
                    iMax = Math.max(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i16 == 2) {
                    iMax = Math.min(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i16 == 3) {
                    iMax = Math.max(iMax, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i17 = iMax + this.mMargin;
        int i18 = this.mBarrierType;
        if (i18 == 0 || i18 == 1) {
            setFinalHorizontal(i17, i17);
        } else {
            setFinalVertical(i17, i17);
        }
        this.mResolved = true;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(constraintWidget, map);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i10 = this.mBarrierType;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.mResolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.mResolved;
    }

    public void markWidgets() {
        for (int i10 = 0; i10 < this.mWidgetsCount; i10++) {
            ConstraintWidget constraintWidget = this.mWidgets[i10];
            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                int i11 = this.mBarrierType;
                if (i11 == 0 || i11 == 1) {
                    constraintWidget.setInBarrier(0, true);
                } else if (i11 == 2 || i11 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            }
        }
    }

    public void setAllowsGoneWidget(boolean z9) {
        this.mAllowsGoneWidget = z9;
    }

    public void setBarrierType(int i10) {
        this.mBarrierType = i10;
    }

    public void setMargin(int i10) {
        this.mMargin = i10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String string = "[Barrier] " + getDebugName() + " {";
        for (int i10 = 0; i10 < this.mWidgetsCount; i10++) {
            ConstraintWidget constraintWidget = this.mWidgets[i10];
            if (i10 > 0) {
                string = string.concat(", ");
            }
            StringBuilder sbV = a.v(string);
            sbV.append(constraintWidget.getDebugName());
            string = sbV.toString();
        }
        return string.concat("}");
    }

    public Barrier() {
    }
}
