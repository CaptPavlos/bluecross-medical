package androidx.constraintlayout.core;

import a3.a;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-4f;
    static final int NOT_FOUND = -1;
    GoalVariableAccessor mAccessor;
    private SolverVariable[] mArrayGoals;
    Cache mCache;
    private int mNumGoals;
    private SolverVariable[] mSortArray;
    private int mTableSize;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class GoalVariableAccessor {
        PriorityGoalRow mRow;
        SolverVariable mVariable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.mRow = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i10 = 0; i10 < 9; i10++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f = fArr[i10] + solverVariable.mGoalStrengthVector[i10];
                fArr[i10] = f;
                if (Math.abs(f) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i10] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f) {
            boolean z9 = true;
            if (!this.mVariable.inGoal) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f10 = solverVariable.mGoalStrengthVector[i10];
                    if (f10 != 0.0f) {
                        float f11 = f10 * f;
                        if (Math.abs(f11) < 1.0E-4f) {
                            f11 = 0.0f;
                        }
                        this.mVariable.mGoalStrengthVector[i10] = f11;
                    } else {
                        this.mVariable.mGoalStrengthVector[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f12 = (solverVariable.mGoalStrengthVector[i11] * f) + fArr[i11];
                fArr[i11] = f12;
                if (Math.abs(f12) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i11] = 0.0f;
                } else {
                    z9 = false;
                }
            }
            if (z9) {
                PriorityGoalRow.this.removeGoal(this.mVariable);
            }
            return false;
        }

        public void init(SolverVariable solverVariable) {
            this.mVariable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f = this.mVariable.mGoalStrengthVector[i10];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i10 = 0; i10 < 9; i10++) {
                if (this.mVariable.mGoalStrengthVector[i10] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f = solverVariable.mGoalStrengthVector[i10];
                float f10 = this.mVariable.mGoalStrengthVector[i10];
                if (f10 == f) {
                    i10--;
                } else if (f10 < f) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.mVariable.mGoalStrengthVector, 0.0f);
        }

        public String toString() {
            String string = "[ ";
            if (this.mVariable != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    StringBuilder sbV = a.v(string);
                    sbV.append(this.mVariable.mGoalStrengthVector[i10]);
                    sbV.append(" ");
                    string = sbV.toString();
                }
            }
            StringBuilder sbW = a.w(string, "] ");
            sbW.append(this.mVariable);
            return sbW.toString();
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mTableSize = 128;
        this.mArrayGoals = new SolverVariable[128];
        this.mSortArray = new SolverVariable[128];
        this.mNumGoals = 0;
        this.mAccessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }

    private void addToGoal(SolverVariable solverVariable) {
        int i10;
        SolverVariable[] solverVariableArr;
        int i11 = this.mNumGoals + 1;
        SolverVariable[] solverVariableArr2 = this.mArrayGoals;
        if (i11 > solverVariableArr2.length) {
            SolverVariable[] solverVariableArr3 = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
            this.mArrayGoals = solverVariableArr3;
            this.mSortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr3, solverVariableArr3.length * 2);
        }
        SolverVariable[] solverVariableArr4 = this.mArrayGoals;
        int i12 = this.mNumGoals;
        solverVariableArr4[i12] = solverVariable;
        int i13 = i12 + 1;
        this.mNumGoals = i13;
        if (i13 > 1 && solverVariableArr4[i12].id > solverVariable.id) {
            int i14 = 0;
            while (true) {
                i10 = this.mNumGoals;
                solverVariableArr = this.mSortArray;
                if (i14 >= i10) {
                    break;
                }
                solverVariableArr[i14] = this.mArrayGoals[i14];
                i14++;
            }
            Arrays.sort(solverVariableArr, 0, i10, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.id - solverVariable3.id;
                }
            });
            for (int i15 = 0; i15 < this.mNumGoals; i15++) {
                this.mArrayGoals[i15] = this.mSortArray[i15];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGoal(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.mNumGoals) {
            if (this.mArrayGoals[i10] == solverVariable) {
                while (true) {
                    int i11 = this.mNumGoals;
                    if (i10 >= i11 - 1) {
                        this.mNumGoals = i11 - 1;
                        solverVariable.inGoal = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.mArrayGoals;
                        int i12 = i10 + 1;
                        solverVariableArr[i10] = solverVariableArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.mAccessor.init(solverVariable);
        this.mAccessor.reset();
        solverVariable.mGoalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.mNumGoals = 0;
        this.mConstantValue = 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.constraintlayout.core.SolverVariable getPivotCandidate(androidx.constraintlayout.core.LinearSystem r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.mNumGoals
            if (r0 >= r2) goto L30
            androidx.constraintlayout.core.SolverVariable[] r2 = r4.mArrayGoals
            r2 = r2[r0]
            int r3 = r2.id
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2d
        L12:
            androidx.constraintlayout.core.PriorityGoalRow$GoalVariableAccessor r3 = r4.mAccessor
            r3.init(r2)
            androidx.constraintlayout.core.PriorityGoalRow$GoalVariableAccessor r2 = r4.mAccessor
            if (r1 != r5) goto L22
            boolean r2 = r2.isNegative()
            if (r2 == 0) goto L2d
            goto L2c
        L22:
            androidx.constraintlayout.core.SolverVariable[] r3 = r4.mArrayGoals
            r3 = r3[r1]
            boolean r2 = r2.isSmallerThan(r3)
            if (r2 == 0) goto L2d
        L2c:
            r1 = r0
        L2d:
            int r0 = r0 + 1
            goto L3
        L30:
            if (r1 != r5) goto L34
            r5 = 0
            return r5
        L34:
            androidx.constraintlayout.core.SolverVariable[] r5 = r4.mArrayGoals
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.PriorityGoalRow.getPivotCandidate(androidx.constraintlayout.core.LinearSystem, boolean[]):androidx.constraintlayout.core.SolverVariable");
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.mNumGoals == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String string = " goal -> (" + this.mConstantValue + ") : ";
        for (int i10 = 0; i10 < this.mNumGoals; i10++) {
            this.mAccessor.init(this.mArrayGoals[i10]);
            StringBuilder sbV = a.v(string);
            sbV.append(this.mAccessor);
            sbV.append(" ");
            string = sbV.toString();
        }
        return string;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z9) {
        SolverVariable solverVariable = arrayRow.mVariable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i10 = 0; i10 < currentSize; i10++) {
            SolverVariable variable = arrayRowVariables.getVariable(i10);
            float variableValue = arrayRowVariables.getVariableValue(i10);
            this.mAccessor.init(variable);
            if (this.mAccessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.mConstantValue = (arrayRow.mConstantValue * variableValue) + this.mConstantValue;
        }
        removeGoal(solverVariable);
    }
}
