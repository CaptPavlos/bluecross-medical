package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    public ArrayRowVariables variables;
    SolverVariable mVariable = null;
    float mConstantValue = 0.0f;
    boolean mUsed = false;
    ArrayList<SolverVariable> mVariablesToUpdate = new ArrayList<>();
    boolean mIsSimpleDefinition = false;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f, boolean z9);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i10);

        float getVariableValue(int i10);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f);

        float remove(SolverVariable solverVariable, boolean z9);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z9);
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i10 = 0; i10 < currentSize; i10++) {
            float variableValue = this.variables.getVariableValue(i10);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i10);
                if ((zArr == null || !zArr[variable.id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f)) {
                    f = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        int i10 = solverVariable.strength;
        float f = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f = 1000.0f;
            } else if (i10 == 3) {
                f = 1000000.0f;
            } else if (i10 == 4) {
                f = 1.0E9f;
            } else if (i10 == 5) {
                f = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f);
    }

    public ArrayRow addSingleError(SolverVariable solverVariable, int i10) {
        this.variables.put(solverVariable, i10);
        return this;
    }

    public boolean chooseSubject(LinearSystem linearSystem) {
        boolean z9;
        SolverVariable solverVariableChooseSubjectInVariables = chooseSubjectInVariables(linearSystem);
        if (solverVariableChooseSubjectInVariables == null) {
            z9 = true;
        } else {
            pivot(solverVariableChooseSubjectInVariables);
            z9 = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
        }
        return z9;
    }

    public SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable = null;
        float f = 0.0f;
        float f10 = 0.0f;
        boolean z9 = false;
        boolean z10 = false;
        SolverVariable solverVariable2 = null;
        for (int i10 = 0; i10 < currentSize; i10++) {
            float variableValue = this.variables.getVariableValue(i10);
            SolverVariable variable = this.variables.getVariable(i10);
            if (variable.mType == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f > variableValue) {
                    boolean zIsNew = isNew(variable, linearSystem);
                    z9 = zIsNew;
                    f = variableValue;
                    solverVariable = variable;
                } else if (!z9 && isNew(variable, linearSystem)) {
                    f = variableValue;
                    solverVariable = variable;
                    z9 = true;
                }
            } else if (solverVariable == null && variableValue < 0.0f) {
                if (solverVariable2 == null || f10 > variableValue) {
                    boolean zIsNew2 = isNew(variable, linearSystem);
                    z10 = zIsNew2;
                    f10 = variableValue;
                    solverVariable2 = variable;
                } else if (!z10 && isNew(variable, linearSystem)) {
                    f10 = variableValue;
                    solverVariable2 = variable;
                    z10 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.mVariable = null;
        this.mConstantValue = 0.0f;
    }

    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.mConstantValue = (-i10) + i11;
                return this;
            }
        } else {
            if (f <= 0.0f) {
                this.variables.put(solverVariable, -1.0f);
                this.variables.put(solverVariable2, 1.0f);
                this.mConstantValue = i10;
                return this;
            }
            ArrayRowVariables arrayRowVariables = this.variables;
            if (f >= 1.0f) {
                arrayRowVariables.put(solverVariable4, -1.0f);
                this.variables.put(solverVariable3, 1.0f);
                this.mConstantValue = -i11;
                return this;
            }
            float f10 = 1.0f - f;
            arrayRowVariables.put(solverVariable, f10 * 1.0f);
            this.variables.put(solverVariable2, f10 * (-1.0f));
            this.variables.put(solverVariable3, (-1.0f) * f);
            this.variables.put(solverVariable4, 1.0f * f);
            if (i10 > 0 || i11 > 0) {
                this.mConstantValue = (i11 * f) + ((-i10) * f10);
                return this;
            }
        }
        return this;
    }

    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i10) {
        this.mVariable = solverVariable;
        float f = i10;
        solverVariable.computedValue = f;
        this.mConstantValue = f;
        this.mIsSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f, float f10, float f11, SolverVariable solverVariable, int i10, SolverVariable solverVariable2, int i11, SolverVariable solverVariable3, int i12, SolverVariable solverVariable4, int i13) {
        if (f10 == 0.0f || f == f11) {
            this.mConstantValue = ((-i10) - i11) + i12 + i13;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        float f12 = (f / f10) / (f11 / f10);
        this.mConstantValue = (i13 * f12) + (i12 * f12) + ((-i10) - i11);
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable4, f12);
        this.variables.put(solverVariable3, -f12);
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f, float f10, float f11, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.mConstantValue = 0.0f;
        if (f10 == 0.0f || f == f11) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        if (f == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            return this;
        }
        ArrayRowVariables arrayRowVariables = this.variables;
        if (f11 == 0.0f) {
            arrayRowVariables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
            return this;
        }
        float f12 = (f / f10) / (f11 / f10);
        arrayRowVariables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable4, f12);
        this.variables.put(solverVariable3, -f12);
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i10) {
        boolean z9 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z9 = true;
            }
            this.mConstantValue = i10;
        }
        ArrayRowVariables arrayRowVariables = this.variables;
        if (z9) {
            arrayRowVariables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            return this;
        }
        arrayRowVariables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z9 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z9 = true;
            }
            this.mConstantValue = i10;
        }
        ArrayRowVariables arrayRowVariables = this.variables;
        if (z9) {
            arrayRowVariables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        arrayRowVariables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, 1.0f);
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z9 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z9 = true;
            }
            this.mConstantValue = i10;
        }
        ArrayRowVariables arrayRowVariables = this.variables;
        if (z9) {
            arrayRowVariables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            return this;
        }
        arrayRowVariables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, -1.0f);
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.mConstantValue = -f;
        return this;
    }

    public void ensurePositiveConstant() {
        float f = this.mConstantValue;
        if (f < 0.0f) {
            this.mConstantValue = f * (-1.0f);
            this.variables.invert();
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getKey() {
        return this.mVariable;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    public boolean hasKeyVariable() {
        SolverVariable solverVariable = this.mVariable;
        if (solverVariable != null) {
            return solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.mConstantValue >= 0.0f;
        }
        return false;
    }

    public boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.mVariable = null;
            this.variables.clear();
            for (int i10 = 0; i10 < arrayRow.variables.getCurrentSize(); i10++) {
                this.variables.add(arrayRow.variables.getVariable(i10), arrayRow.variables.getVariableValue(i10), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.mVariable == null && this.mConstantValue == 0.0f && this.variables.getCurrentSize() == 0;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return pickPivotInVariables(null, solverVariable);
    }

    public void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.mVariable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.mVariable.mDefinitionId = -1;
            this.mVariable = null;
        }
        float fRemove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.mVariable = solverVariable;
        if (fRemove == 1.0f) {
            return;
        }
        this.mConstantValue /= fRemove;
        this.variables.divideByAmount(fRemove);
    }

    public void reset() {
        this.mVariable = null;
        this.variables.clear();
        this.mConstantValue = 0.0f;
        this.mIsSimpleDefinition = false;
    }

    public int sizeInBytes() {
        return this.variables.sizeInBytes() + (this.mVariable != null ? 4 : 0) + 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toReadableString() {
        /*
            r10 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r10.mVariable
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r10.mVariable
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = r0.concat(r1)
            float r1 = r10.mConstantValue
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = a3.a.v(r0)
            float r1 = r10.mConstantValue
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r4
            goto L36
        L35:
            r1 = r3
        L36:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r5 = r10.variables
            int r5 = r5.getCurrentSize()
        L3c:
            if (r3 >= r5) goto L9c
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r6 = r10.variables
            androidx.constraintlayout.core.SolverVariable r6 = r6.getVariable(r3)
            if (r6 != 0) goto L47
            goto L99
        L47:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r7 = r10.variables
            float r7 = r7.getVariableValue(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L99
        L52:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L66
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L76
            java.lang.String r1 = "- "
            java.lang.String r0 = a3.a.C(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L76
        L66:
            if (r8 <= 0) goto L6f
            java.lang.String r1 = " + "
            java.lang.String r0 = a3.a.C(r0, r1)
            goto L76
        L6f:
            java.lang.String r1 = " - "
            java.lang.String r0 = a3.a.C(r0, r1)
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = a3.a.C(r0, r6)
            goto L98
        L81:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L98:
            r1 = r4
        L99:
            int r3 = r3 + 1
            goto L3c
        L9c:
            if (r1 != 0) goto La4
            java.lang.String r1 = "0.0"
            java.lang.String r0 = a3.a.C(r0, r1)
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.toReadableString():java.lang.String");
    }

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z9) {
        if (solverVariable == null || !solverVariable.isFinalValue) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.mConstantValue = (solverVariable.computedValue * f) + this.mConstantValue;
        this.variables.remove(solverVariable, z9);
        if (z9) {
            solverVariable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z9) {
        float fUse = this.variables.use(arrayRow, z9);
        this.mConstantValue = (arrayRow.mConstantValue * fUse) + this.mConstantValue;
        if (z9) {
            arrayRow.mVariable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.mVariable != null && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z9) {
        if (solverVariable == null || !solverVariable.mIsSynonym) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.mConstantValue = (solverVariable.mSynonymDelta * f) + this.mConstantValue;
        this.variables.remove(solverVariable, z9);
        if (z9) {
            solverVariable.removeFromRow(this);
        }
        this.variables.add(linearSystem.mCache.mIndexedVariables[solverVariable.mSynonym], f, z9);
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromSystem(LinearSystem linearSystem) {
        ArrayList<SolverVariable> arrayList;
        if (linearSystem.mRows.length == 0) {
            return;
        }
        boolean z9 = false;
        while (!z9) {
            int currentSize = this.variables.getCurrentSize();
            for (int i10 = 0; i10 < currentSize; i10++) {
                SolverVariable variable = this.variables.getVariable(i10);
                if (variable.mDefinitionId != -1 || variable.isFinalValue || variable.mIsSynonym) {
                    this.mVariablesToUpdate.add(variable);
                }
            }
            int size = this.mVariablesToUpdate.size();
            if (size > 0) {
                int i11 = 0;
                while (true) {
                    arrayList = this.mVariablesToUpdate;
                    if (i11 >= size) {
                        break;
                    }
                    SolverVariable solverVariable = arrayList.get(i11);
                    if (solverVariable.isFinalValue) {
                        updateFromFinalVariable(linearSystem, solverVariable, true);
                    } else if (solverVariable.mIsSynonym) {
                        updateFromSynonymVariable(linearSystem, solverVariable, true);
                    } else {
                        updateFromRow(linearSystem, linearSystem.mRows[solverVariable.mDefinitionId], true);
                    }
                    i11++;
                }
                arrayList.clear();
            } else {
                z9 = true;
            }
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.mVariable != null && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public ArrayRow() {
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i10) {
        if (i10 < 0) {
            this.mConstantValue = i10 * (-1);
            this.variables.put(solverVariable, 1.0f);
            return this;
        }
        this.mConstantValue = i10;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i10) {
        this.variables.put(linearSystem.createErrorVariable(i10, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i10, "em"), -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i10, SolverVariable solverVariable2) {
        this.mConstantValue = i10;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
