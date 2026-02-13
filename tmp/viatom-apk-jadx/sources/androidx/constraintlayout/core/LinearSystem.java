package androidx.constraintlayout.core;

import a3.a;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    private static final boolean DO_NOT_USE = false;
    public static final boolean FULL_DEBUG = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    private Row mTempGoal;
    private int mPoolSize = 1000;
    public boolean hasSimpleDefinition = false;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int mTableSize = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[1000];
    private int mPoolVariablesCount = 0;
    ArrayRow[] mRows = new ArrayRow[32];

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z9);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z9);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable solverVariableAcquire = this.mCache.mSolverVariablePool.acquire();
        if (solverVariableAcquire == null) {
            solverVariableAcquire = new SolverVariable(type, str);
            solverVariableAcquire.setType(type, str);
        } else {
            solverVariableAcquire.reset();
            solverVariableAcquire.setType(type, str);
        }
        int i10 = this.mPoolVariablesCount;
        int i11 = this.mPoolSize;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            this.mPoolSize = i12;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i12);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i13 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i13 + 1;
        solverVariableArr[i13] = solverVariableAcquire;
        return solverVariableAcquire;
    }

    private void addRow(ArrayRow arrayRow) {
        int i10;
        if (SIMPLIFY_SYNONYMS && arrayRow.mIsSimpleDefinition) {
            arrayRow.mVariable.setFinalValue(this, arrayRow.mConstantValue);
        } else {
            ArrayRow[] arrayRowArr = this.mRows;
            int i11 = this.mNumRows;
            arrayRowArr[i11] = arrayRow;
            SolverVariable solverVariable = arrayRow.mVariable;
            solverVariable.mDefinitionId = i11;
            this.mNumRows = i11 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i12 = 0;
            while (i12 < this.mNumRows) {
                if (this.mRows[i12] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.mRows[i12];
                if (arrayRow2 != null && arrayRow2.mIsSimpleDefinition) {
                    arrayRow2.mVariable.setFinalValue(this, arrayRow2.mConstantValue);
                    boolean z9 = OPTIMIZED_ENGINE;
                    Cache cache = this.mCache;
                    if (z9) {
                        cache.mOptimizedArrayRowPool.release(arrayRow2);
                    } else {
                        cache.mArrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.mNumRows;
                        if (i13 >= i10) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.mRows;
                        int i15 = i13 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i13];
                        arrayRowArr2[i15] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.mVariable;
                        if (solverVariable2.mDefinitionId == i13) {
                            solverVariable2.mDefinitionId = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.mRows[i14] = null;
                    }
                    this.mNumRows = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void computeValues() {
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            ArrayRow arrayRow = this.mRows[i10];
            arrayRow.mVariable.computedValue = arrayRow.mConstantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(type, null);
        solverVariableAcquireSolverVariable.setName(str);
        int i10 = this.mVariablesID + 1;
        this.mVariablesID = i10;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i10;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, solverVariableAcquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String strConcat = "";
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            StringBuilder sbV = a.v(strConcat);
            sbV.append(this.mRows[i10]);
            strConcat = sbV.toString().concat("\n");
        }
        StringBuilder sbV2 = a.v(strConcat);
        sbV2.append(this.mGoal);
        sbV2.append("\n");
        System.out.println(sbV2.toString());
    }

    private void displaySolverVariables() {
        StringBuilder sb = new StringBuilder("Display Rows (");
        sb.append(this.mNumRows);
        sb.append("x");
        System.out.println(a.n(sb, ")\n", this.mNumColumns));
    }

    private int enforceBFS(Row row) throws Exception {
        float f;
        long j10;
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            ArrayRow arrayRow = this.mRows[i10];
            if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED) {
                float f10 = 0.0f;
                if (arrayRow.mConstantValue < 0.0f) {
                    boolean z9 = false;
                    int i11 = 0;
                    while (!z9) {
                        Metrics metrics = sMetrics;
                        long j11 = 1;
                        if (metrics != null) {
                            metrics.bfs++;
                        }
                        i11++;
                        float f11 = Float.MAX_VALUE;
                        int i12 = 0;
                        int i13 = -1;
                        int i14 = -1;
                        int i15 = 0;
                        while (true) {
                            if (i12 >= this.mNumRows) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.mRows[i12];
                            if (arrayRow2.mVariable.mType == SolverVariable.Type.UNRESTRICTED || arrayRow2.mIsSimpleDefinition || arrayRow2.mConstantValue >= f10) {
                                f = f10;
                                j10 = j11;
                            } else if (SKIP_COLUMNS) {
                                int currentSize = arrayRow2.variables.getCurrentSize();
                                int i16 = 0;
                                while (i16 < currentSize) {
                                    float f12 = f10;
                                    SolverVariable variable = arrayRow2.variables.getVariable(i16);
                                    long j12 = j11;
                                    float f13 = arrayRow2.variables.get(variable);
                                    if (f13 > f12) {
                                        for (int i17 = 0; i17 < 9; i17++) {
                                            float f14 = variable.mStrengthVector[i17] / f13;
                                            if ((f14 < f11 && i17 == i15) || i17 > i15) {
                                                i15 = i17;
                                                i14 = variable.id;
                                                i13 = i12;
                                                f11 = f14;
                                            }
                                        }
                                    }
                                    i16++;
                                    f10 = f12;
                                    j11 = j12;
                                }
                                f = f10;
                                j10 = j11;
                            } else {
                                f = f10;
                                j10 = j11;
                                for (int i18 = 1; i18 < this.mNumColumns; i18++) {
                                    SolverVariable solverVariable = this.mCache.mIndexedVariables[i18];
                                    float f15 = arrayRow2.variables.get(solverVariable);
                                    if (f15 > f) {
                                        for (int i19 = 0; i19 < 9; i19++) {
                                            float f16 = solverVariable.mStrengthVector[i19] / f15;
                                            if ((f16 < f11 && i19 == i15) || i19 > i15) {
                                                i15 = i19;
                                                f11 = f16;
                                                i13 = i12;
                                                i14 = i18;
                                            }
                                        }
                                    }
                                }
                            }
                            i12++;
                            f10 = f;
                            j11 = j10;
                        }
                        float f17 = f10;
                        long j13 = j11;
                        if (i13 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i13];
                            arrayRow3.mVariable.mDefinitionId = -1;
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots += j13;
                            }
                            arrayRow3.pivot(this.mCache.mIndexedVariables[i14]);
                            SolverVariable solverVariable2 = arrayRow3.mVariable;
                            solverVariable2.mDefinitionId = i13;
                            solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
                        } else {
                            z9 = true;
                        }
                        if (i11 > this.mNumColumns / 2) {
                            z9 = true;
                        }
                        f10 = f17;
                    }
                    return i11;
                }
            }
        }
        return 0;
    }

    private String getDisplaySize(int i10) {
        int i11 = i10 * 4;
        int i12 = i11 / 1024;
        int i13 = i12 / 1024;
        return i13 > 0 ? a.g(i13, "", " Mb") : i12 > 0 ? a.g(i12, "", " Kb") : a.g(i11, "", " bytes");
    }

    private String getDisplayStrength(int i10) {
        return i10 == 1 ? "LOW" : i10 == 2 ? "MEDIUM" : i10 == 3 ? "HIGH" : i10 == 4 ? "HIGHEST" : i10 == 5 ? "EQUALITY" : i10 == 8 ? "FIXED" : i10 == 6 ? "BARRIER" : "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i10 = this.mTableSize * 2;
        this.mTableSize = i10;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i10);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.mTableSize);
        int i11 = this.mTableSize;
        this.mAlreadyTestedCandidates = new boolean[i11];
        this.mMaxColumns = i11;
        this.mMaxRows = i11;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i11);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private int optimize(Row row, boolean z9) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i10 = 0; i10 < this.mNumColumns; i10++) {
            this.mAlreadyTestedCandidates[i10] = false;
        }
        boolean z10 = false;
        int i11 = 0;
        while (!z10) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i11++;
            if (i11 < this.mNumColumns * 2) {
                if (row.getKey() != null) {
                    this.mAlreadyTestedCandidates[row.getKey().id] = true;
                }
                SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
                if (pivotCandidate != null) {
                    boolean[] zArr = this.mAlreadyTestedCandidates;
                    int i12 = pivotCandidate.id;
                    if (!zArr[i12]) {
                        zArr[i12] = true;
                    }
                }
                if (pivotCandidate != null) {
                    float f = Float.MAX_VALUE;
                    int i13 = -1;
                    for (int i14 = 0; i14 < this.mNumRows; i14++) {
                        ArrayRow arrayRow = this.mRows[i14];
                        if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.mIsSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                            float f10 = arrayRow.variables.get(pivotCandidate);
                            if (f10 < 0.0f) {
                                float f11 = (-arrayRow.mConstantValue) / f10;
                                if (f11 < f) {
                                    i13 = i14;
                                    f = f11;
                                }
                            }
                        }
                    }
                    if (i13 > -1) {
                        ArrayRow arrayRow2 = this.mRows[i13];
                        arrayRow2.mVariable.mDefinitionId = -1;
                        Metrics metrics3 = sMetrics;
                        if (metrics3 != null) {
                            metrics3.pivots++;
                        }
                        arrayRow2.pivot(pivotCandidate);
                        SolverVariable solverVariable = arrayRow2.mVariable;
                        solverVariable.mDefinitionId = i13;
                        solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                    }
                } else {
                    z10 = true;
                }
            }
            return i11;
        }
        return i11;
    }

    private void releaseRows() {
        int i10 = 0;
        if (OPTIMIZED_ENGINE) {
            while (i10 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i10];
                if (arrayRow != null) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.mNumRows) {
            ArrayRow arrayRow2 = this.mRows[i10];
            if (arrayRow2 != null) {
                this.mCache.mArrayRowPool.release(arrayRow2);
            }
            this.mRows[i10] = null;
            i10++;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableCreateObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableCreateObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableCreateObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableCreateObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable solverVariableCreateObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable solverVariableCreateObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable solverVariableCreateObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable solverVariableCreateObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow arrayRowCreateRow = createRow();
        double d8 = f;
        double d10 = i10;
        arrayRowCreateRow.createRowWithAngle(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable8, (float) (Math.sin(d8) * d10));
        addConstraint(arrayRowCreateRow);
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowWithAngle(solverVariableCreateObjectVariable, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable7, (float) (Math.cos(d8) * d10));
        addConstraint(arrayRowCreateRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11, int i12) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowCentering(solverVariable, solverVariable2, i10, f, solverVariable3, solverVariable4, i11);
        if (i12 != 8) {
            arrayRowCreateRow.addError(this, i12);
        }
        addConstraint(arrayRowCreateRow);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addConstraint(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L4
            goto La6
        L4:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.sMetrics
            r1 = 1
            if (r0 == 0) goto L18
            long r3 = r0.constraints
            long r3 = r3 + r1
            r0.constraints = r3
            boolean r3 = r8.mIsSimpleDefinition
            if (r3 == 0) goto L18
            long r3 = r0.simpleconstraints
            long r3 = r3 + r1
            r0.simpleconstraints = r3
        L18:
            int r0 = r7.mNumRows
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.mMaxRows
            if (r0 >= r4) goto L27
            int r0 = r7.mNumColumns
            int r0 = r0 + r3
            int r4 = r7.mMaxColumns
            if (r0 < r4) goto L2a
        L27:
            r7.increaseTableSize()
        L2a:
            boolean r0 = r8.mIsSimpleDefinition
            r4 = 0
            if (r0 != 0) goto La1
            r8.updateFromSystem(r7)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L3a
            goto La6
        L3a:
            r8.ensurePositiveConstant()
            boolean r0 = r8.chooseSubject(r7)
            if (r0 == 0) goto L98
            androidx.constraintlayout.core.SolverVariable r0 = r7.createExtraVariable()
            r8.mVariable = r0
            int r5 = r7.mNumRows
            r7.addRow(r8)
            int r6 = r7.mNumRows
            int r5 = r5 + r3
            if (r6 != r5) goto L98
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r4.initFromRow(r8)
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r7.optimize(r4, r3)
            int r4 = r0.mDefinitionId
            r5 = -1
            if (r4 != r5) goto L99
            androidx.constraintlayout.core.SolverVariable r4 = r8.mVariable
            if (r4 != r0) goto L78
            androidx.constraintlayout.core.SolverVariable r0 = r8.pickPivot(r0)
            if (r0 == 0) goto L78
            androidx.constraintlayout.core.Metrics r4 = androidx.constraintlayout.core.LinearSystem.sMetrics
            if (r4 == 0) goto L75
            long r5 = r4.pivots
            long r5 = r5 + r1
            r4.pivots = r5
        L75:
            r8.pivot(r0)
        L78:
            boolean r0 = r8.mIsSimpleDefinition
            if (r0 != 0) goto L81
            androidx.constraintlayout.core.SolverVariable r0 = r8.mVariable
            r0.updateReferencesWithNewDefinition(r7, r8)
        L81:
            boolean r0 = androidx.constraintlayout.core.LinearSystem.OPTIMIZED_ENGINE
            androidx.constraintlayout.core.Cache r1 = r7.mCache
            if (r0 == 0) goto L8d
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r1.mOptimizedArrayRowPool
            r0.release(r8)
            goto L92
        L8d:
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r1.mArrayRowPool
            r0.release(r8)
        L92:
            int r0 = r7.mNumRows
            int r0 = r0 - r3
            r7.mNumRows = r0
            goto L99
        L98:
            r3 = r4
        L99:
            boolean r0 = r8.hasKeyVariable()
            if (r0 != 0) goto La0
            goto La6
        La0:
            r4 = r3
        La1:
            if (r4 != 0) goto La6
            r7.addRow(r8)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.addConstraint(androidx.constraintlayout.core.ArrayRow):void");
    }

    public void addEquality(SolverVariable solverVariable, int i10) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && solverVariable.mDefinitionId == -1) {
            float f = i10;
            solverVariable.setFinalValue(this, f);
            for (int i11 = 0; i11 < this.mVariablesID + 1; i11++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i11];
                if (solverVariable2 != null && solverVariable2.mIsSynonym && solverVariable2.mSynonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.mSynonymDelta + f);
                }
            }
            return;
        }
        int i12 = solverVariable.mDefinitionId;
        if (i12 == -1) {
            ArrayRow arrayRowCreateRow = createRow();
            arrayRowCreateRow.createRowDefinition(solverVariable, i10);
            addConstraint(arrayRowCreateRow);
            return;
        }
        ArrayRow arrayRow = this.mRows[i12];
        if (arrayRow.mIsSimpleDefinition) {
            arrayRow.mConstantValue = i10;
            return;
        }
        if (arrayRow.variables.getCurrentSize() == 0) {
            arrayRow.mIsSimpleDefinition = true;
            arrayRow.mConstantValue = i10;
        } else {
            ArrayRow arrayRowCreateRow2 = createRow();
            arrayRowCreateRow2.createRowEquals(solverVariable, i10);
            addConstraint(arrayRowCreateRow2);
        }
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z9) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i10);
        addConstraint(arrayRowCreateRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i10);
        if (i11 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i11);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z9) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i10);
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i10);
        if (i11 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i11);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i10) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i10 != 8) {
            arrayRowCreateRow.addError(this, i10);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addSingleError(ArrayRow arrayRow, int i10, int i11) {
        arrayRow.addSingleError(createErrorVariable(i11, null), i10);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i10) {
        if (solverVariable.mDefinitionId != -1 || i10 != 0) {
            addEquality(solverVariable, solverVariable2, i10, 8);
            return;
        }
        if (solverVariable2.mIsSynonym) {
            solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.mSynonym];
        }
        if (solverVariable.mIsSynonym) {
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.mSynonym];
        } else {
            solverVariable.setSynonym(this, solverVariable2, 0.0f);
        }
    }

    public final void cleanupRows() {
        int i10;
        ArrayRow[] arrayRowArr;
        int i11 = 0;
        while (i11 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i11];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.mIsSimpleDefinition = true;
            }
            if (arrayRow.mIsSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.mVariable;
                solverVariable.computedValue = arrayRow.mConstantValue;
                solverVariable.removeFromRow(arrayRow);
                int i12 = i11;
                while (true) {
                    i10 = this.mNumRows;
                    int i13 = i10 - 1;
                    arrayRowArr = this.mRows;
                    if (i12 >= i13) {
                        break;
                    }
                    int i14 = i12 + 1;
                    arrayRowArr[i12] = arrayRowArr[i14];
                    i12 = i14;
                }
                arrayRowArr[i10 - 1] = null;
                this.mNumRows = i10 - 1;
                i11--;
                boolean z9 = OPTIMIZED_ENGINE;
                Cache cache = this.mCache;
                if (z9) {
                    cache.mOptimizedArrayRowPool.release(arrayRow);
                } else {
                    cache.mArrayRowPool.release(arrayRow);
                }
            }
            i11++;
        }
    }

    public SolverVariable createErrorVariable(int i10, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i11 = this.mVariablesID + 1;
        this.mVariablesID = i11;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i11;
        solverVariableAcquireSolverVariable.strength = i10;
        this.mCache.mIndexedVariables[i11] = solverVariableAcquireSolverVariable;
        this.mGoal.addError(solverVariableAcquireSolverVariable);
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i10 = this.mVariablesID + 1;
        this.mVariablesID = i10;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i10;
        this.mCache.mIndexedVariables[i10] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i10 = solverVariable.id;
            if (i10 != -1 && i10 <= this.mVariablesID && this.mCache.mIndexedVariables[i10] != null) {
                return solverVariable;
            }
            if (i10 != -1) {
                solverVariable.reset();
            }
            int i11 = this.mVariablesID + 1;
            this.mVariablesID = i11;
            this.mNumColumns++;
            solverVariable.id = i11;
            solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
            this.mCache.mIndexedVariables[i11] = solverVariable;
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRowAcquire;
        boolean z9 = OPTIMIZED_ENGINE;
        Cache cache = this.mCache;
        if (z9) {
            arrayRowAcquire = cache.mOptimizedArrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        } else {
            arrayRowAcquire = cache.mArrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRowAcquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i10 = this.mVariablesID + 1;
        this.mVariablesID = i10;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i10;
        this.mCache.mIndexedVariables[i10] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String strN = a.n(new StringBuilder(" num vars "), "\n", this.mVariablesID);
        for (int i10 = 0; i10 < this.mVariablesID + 1; i10++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i10];
            if (solverVariable != null && solverVariable.isFinalValue) {
                strN = strN + " $[" + i10 + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String strC = a.C(strN, "\n");
        for (int i11 = 0; i11 < this.mVariablesID + 1; i11++) {
            SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
            SolverVariable solverVariable2 = solverVariableArr[i11];
            if (solverVariable2 != null && solverVariable2.mIsSynonym) {
                strC = strC + " ~[" + i11 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.mSynonym] + " + " + solverVariable2.mSynonymDelta + "\n";
            }
        }
        String strC2 = a.C(strC, "\n\n #  ");
        for (int i12 = 0; i12 < this.mNumRows; i12++) {
            StringBuilder sbV = a.v(strC2);
            sbV.append(this.mRows[i12].toReadableString());
            strC2 = sbV.toString().concat("\n #  ");
        }
        if (this.mGoal != null) {
            StringBuilder sbW = a.w(strC2, "Goal: ");
            sbW.append(this.mGoal);
            sbW.append("\n");
            strC2 = sbW.toString();
        }
        System.out.println(strC2);
    }

    public void displaySystemInformation() {
        int iSizeInBytes = 0;
        for (int i10 = 0; i10 < this.mTableSize; i10++) {
            ArrayRow arrayRow = this.mRows[i10];
            if (arrayRow != null) {
                iSizeInBytes += arrayRow.sizeInBytes();
            }
        }
        int iSizeInBytes2 = 0;
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            ArrayRow arrayRow2 = this.mRows[i11];
            if (arrayRow2 != null) {
                iSizeInBytes2 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder("Linear System -> Table size: ");
        sb.append(this.mTableSize);
        sb.append(" (");
        int i12 = this.mTableSize;
        sb.append(getDisplaySize(i12 * i12));
        sb.append(") -- row sizes: ");
        sb.append(getDisplaySize(iSizeInBytes));
        sb.append(", actual size: ");
        sb.append(getDisplaySize(iSizeInBytes2));
        sb.append(" rows: ");
        sb.append(this.mNumRows);
        sb.append("/");
        sb.append(this.mMaxRows);
        sb.append(" cols: ");
        sb.append(this.mNumColumns);
        sb.append("/");
        sb.append(this.mMaxColumns);
        sb.append(" 0 occupied cells, ");
        sb.append(getDisplaySize(0));
        printStream.println(sb.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String strConcat = "";
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            if (this.mRows[i10].mVariable.mType == SolverVariable.Type.UNRESTRICTED) {
                StringBuilder sbV = a.v(strConcat);
                sbV.append(this.mRows[i10].toReadableString());
                strConcat = sbV.toString().concat("\n");
            }
        }
        StringBuilder sbV2 = a.v(strConcat);
        sbV2.append(this.mGoal);
        sbV2.append("\n");
        System.out.println(sbV2.toString());
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int iSizeInBytes = 0;
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            ArrayRow arrayRow = this.mRows[i10];
            if (arrayRow != null) {
                iSizeInBytes = arrayRow.sizeInBytes() + iSizeInBytes;
            }
        }
        return iSizeInBytes;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public ArrayRow getRow(int i10) {
        return this.mRows[i10];
    }

    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            if (!this.mRows[i10].mIsSimpleDefinition) {
                minimizeGoal(this.mGoal);
                return;
            }
        }
        Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        computeValues();
    }

    public void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i10;
        if (!arrayRow.mIsSimpleDefinition || (solverVariable = arrayRow.mVariable) == null) {
            return;
        }
        int i11 = solverVariable.mDefinitionId;
        if (i11 != -1) {
            while (true) {
                i10 = this.mNumRows;
                if (i11 >= i10 - 1) {
                    break;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                int i12 = i11 + 1;
                ArrayRow arrayRow2 = arrayRowArr[i12];
                SolverVariable solverVariable2 = arrayRow2.mVariable;
                if (solverVariable2.mDefinitionId == i12) {
                    solverVariable2.mDefinitionId = i11;
                }
                arrayRowArr[i11] = arrayRow2;
                i11 = i12;
            }
            this.mNumRows = i10 - 1;
        }
        SolverVariable solverVariable3 = arrayRow.mVariable;
        if (!solverVariable3.isFinalValue) {
            solverVariable3.setFinalValue(this, arrayRow.mConstantValue);
        }
        boolean z9 = OPTIMIZED_ENGINE;
        Cache cache = this.mCache;
        if (z9) {
            cache.mOptimizedArrayRowPool.release(arrayRow);
        } else {
            cache.mArrayRowPool.release(arrayRow);
        }
    }

    public void reset() {
        Cache cache;
        int i10 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i10 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i10];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i10++;
        }
        cache.mSolverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> map = this.mVariables;
        if (map != null) {
            map.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            ArrayRow arrayRow = this.mRows[i11];
            if (arrayRow != null) {
                arrayRow.mUsed = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        boolean z9 = OPTIMIZED_ENGINE;
        Cache cache2 = this.mCache;
        if (z9) {
            this.mTempGoal = new ValuesRow(cache2);
        } else {
            this.mTempGoal = new ArrayRow(cache2);
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && i11 == 8 && solverVariable2.isFinalValue && solverVariable.mDefinitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i10);
            return null;
        }
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowEquals(solverVariable, solverVariable2, i10);
        if (i11 != 8) {
            arrayRowCreateRow.addError(this, i11);
        }
        addConstraint(arrayRowCreateRow);
        return arrayRowCreateRow;
    }
}
