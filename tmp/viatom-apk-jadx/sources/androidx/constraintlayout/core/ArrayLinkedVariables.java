package androidx.constraintlayout.core;

import a3.a;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    static final int NONE = -1;
    private static float sEpsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    int mCurrentSize = 0;
    private int mRowSize = 8;
    private SolverVariable mCandidate = null;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private int mHead = -1;
    private int mLast = -1;
    private boolean mDidFillOnce = false;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f, boolean z9) {
        float f10 = sEpsilon;
        if (f <= (-f10) || f >= f10) {
            int i10 = this.mHead;
            if (i10 == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.mCurrentSize++;
                if (this.mDidFillOnce) {
                    return;
                }
                int i11 = this.mLast + 1;
                this.mLast = i11;
                int[] iArr = this.mArrayIndices;
                if (i11 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.mCurrentSize; i13++) {
                int i14 = this.mArrayIndices[i10];
                int i15 = solverVariable.id;
                if (i14 == i15) {
                    float[] fArr = this.mArrayValues;
                    float f11 = fArr[i10] + f;
                    float f12 = sEpsilon;
                    if (f11 > (-f12) && f11 < f12) {
                        f11 = 0.0f;
                    }
                    fArr[i10] = f11;
                    if (f11 == 0.0f) {
                        int i16 = this.mHead;
                        int[] iArr2 = this.mArrayNextIndices;
                        if (i10 == i16) {
                            this.mHead = iArr2[i10];
                        } else {
                            iArr2[i12] = iArr2[i10];
                        }
                        if (z9) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i10;
                        }
                        solverVariable.usageInRowCount--;
                        this.mCurrentSize--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i12 = i10;
                }
                i10 = this.mArrayNextIndices[i10];
            }
            int length = this.mLast;
            int i17 = length + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i17;
            }
            int[] iArr4 = this.mArrayIndices;
            if (length >= iArr4.length && this.mCurrentSize < iArr4.length) {
                int i18 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i18 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i18] == -1) {
                        length = i18;
                        break;
                    }
                    i18++;
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i19 = this.mRowSize * 2;
                this.mRowSize = i19;
                this.mDidFillOnce = false;
                this.mLast = length - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i19);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
            }
            this.mArrayIndices[length] = solverVariable.id;
            this.mArrayValues[length] = f;
            int[] iArr7 = this.mArrayNextIndices;
            if (i12 != -1) {
                iArr7[length] = iArr7[i12];
                iArr7[i12] = length;
            } else {
                iArr7[length] = this.mHead;
                this.mHead = length;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i20 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i20 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i10 = this.mHead;
        for (int i11 = 0; i10 != -1 && i11 < this.mCurrentSize; i11++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i10]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i10 = this.mArrayNextIndices[i10];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mCurrentSize = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i10 = this.mHead;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.mCurrentSize; i11++) {
            if (this.mArrayIndices[i10] == solverVariable.id) {
                return true;
            }
            i10 = this.mArrayNextIndices[i10];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i10 = this.mCurrentSize;
        System.out.print("{ ");
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i11) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f) {
        int i10 = this.mHead;
        for (int i11 = 0; i10 != -1 && i11 < this.mCurrentSize; i11++) {
            float[] fArr = this.mArrayValues;
            fArr[i10] = fArr[i10] / f;
            i10 = this.mArrayNextIndices[i10];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i10 = this.mHead;
        for (int i11 = 0; i10 != -1 && i11 < this.mCurrentSize; i11++) {
            if (this.mArrayIndices[i10] == solverVariable.id) {
                return this.mArrayValues[i10];
            }
            i10 = this.mArrayNextIndices[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCurrentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i10) {
        return this.mArrayIndices[i10];
    }

    public final int getNextIndice(int i10) {
        return this.mArrayNextIndices[i10];
    }

    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.mCandidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i10 = this.mHead;
        SolverVariable solverVariable2 = null;
        for (int i11 = 0; i10 != -1 && i11 < this.mCurrentSize; i11++) {
            if (this.mArrayValues[i10] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i10]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i10 = this.mArrayNextIndices[i10];
        }
        return solverVariable2;
    }

    public final float getValue(int i10) {
        return this.mArrayValues[i10];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i10) {
        int i11 = this.mHead;
        for (int i12 = 0; i11 != -1 && i12 < this.mCurrentSize; i12++) {
            if (i12 == i10) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i11]];
            }
            i11 = this.mArrayNextIndices[i11];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i10) {
        int i11 = this.mHead;
        for (int i12 = 0; i11 != -1 && i12 < this.mCurrentSize; i12++) {
            if (i12 == i10) {
                return this.mArrayValues[i11];
            }
            i11 = this.mArrayNextIndices[i11];
        }
        return 0.0f;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        int i10 = this.mHead;
        for (int i11 = 0; i10 != -1 && i11 < this.mCurrentSize; i11++) {
            if (this.mArrayValues[i10] > 0.0f) {
                return true;
            }
            i10 = this.mArrayNextIndices[i10];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i10 = this.mHead;
        if (i10 == -1) {
            return -1;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.mCurrentSize; i11++) {
            if (this.mArrayIndices[i10] == solverVariable.id) {
                return i10;
            }
            i10 = this.mArrayNextIndices[i10];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i10 = this.mHead;
        for (int i11 = 0; i10 != -1 && i11 < this.mCurrentSize; i11++) {
            float[] fArr = this.mArrayValues;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.mArrayNextIndices[i10];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i10 = this.mHead;
        if (i10 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (this.mDidFillOnce) {
                return;
            }
            int i11 = this.mLast + 1;
            this.mLast = i11;
            int[] iArr = this.mArrayIndices;
            if (i11 >= iArr.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.mCurrentSize; i13++) {
            int i14 = this.mArrayIndices[i10];
            int i15 = solverVariable.id;
            if (i14 == i15) {
                this.mArrayValues[i10] = f;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.mArrayNextIndices[i10];
        }
        int length = this.mLast;
        int i16 = length + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i16;
        }
        int[] iArr3 = this.mArrayIndices;
        if (length >= iArr3.length && this.mCurrentSize < iArr3.length) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i17 >= iArr4.length) {
                    break;
                }
                if (iArr4[i17] == -1) {
                    length = i17;
                    break;
                }
                i17++;
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i18 = this.mRowSize * 2;
            this.mRowSize = i18;
            this.mDidFillOnce = false;
            this.mLast = length - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i18);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
        }
        this.mArrayIndices[length] = solverVariable.id;
        this.mArrayValues[length] = f;
        int[] iArr6 = this.mArrayNextIndices;
        if (i12 != -1) {
            iArr6[length] = iArr6[i12];
            iArr6[i12] = length;
        } else {
            iArr6[length] = this.mHead;
            this.mHead = length;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i19 = this.mCurrentSize + 1;
        this.mCurrentSize = i19;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i19 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z9) {
        if (this.mCandidate == solverVariable) {
            this.mCandidate = null;
        }
        int i10 = this.mHead;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.mCurrentSize) {
            if (this.mArrayIndices[i10] == solverVariable.id) {
                int i13 = this.mHead;
                int[] iArr = this.mArrayNextIndices;
                if (i10 == i13) {
                    this.mHead = iArr[i10];
                } else {
                    iArr[i12] = iArr[i10];
                }
                if (z9) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.mCurrentSize--;
                this.mArrayIndices[i10] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i10;
                }
                return this.mArrayValues[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.mArrayNextIndices[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int i10 = this.mHead;
        String string = "";
        for (int i11 = 0; i10 != -1 && i11 < this.mCurrentSize; i11++) {
            StringBuilder sbV = a.v(string.concat(" -> "));
            sbV.append(this.mArrayValues[i10]);
            sbV.append(" : ");
            StringBuilder sbV2 = a.v(sbV.toString());
            sbV2.append(this.mCache.mIndexedVariables[this.mArrayIndices[i10]]);
            string = sbV2.toString();
            i10 = this.mArrayNextIndices[i10];
        }
        return string;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z9) {
        float f = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z9);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i10 = 0; i10 < currentSize; i10++) {
            SolverVariable variable = arrayRowVariables.getVariable(i10);
            add(variable, arrayRowVariables.get(variable) * f, z9);
        }
        return f;
    }
}
