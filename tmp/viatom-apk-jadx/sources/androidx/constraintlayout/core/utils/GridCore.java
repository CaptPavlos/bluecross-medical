package androidx.constraintlayout.core.utils;

import a6.h;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class GridCore extends VirtualLayout {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int SPANS_RESPECT_WIDGET_ORDER = 2;
    public static final int SUB_GRID_BY_COL_ROW = 1;
    public static final int VERTICAL = 1;
    private ConstraintWidget[] mBoxWidgets;
    private String mColumnWeights;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    ConstraintWidgetContainer mContainer;
    private int mFlags;
    private float mHorizontalGaps;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private String mRowWeights;
    private int mRows;
    private int mRowsSet;
    private String mSkips;
    private int[][] mSpanMatrix;
    private String mSpans;
    private float mVerticalGaps;
    private boolean mExtraSpaceHandled = false;
    private int mNextAvailableIndex = 0;
    Set<String> mSpanIds = new HashSet();
    private int mSpanIndex = 0;

    public GridCore(int i10, int i11) {
        this.mRowsSet = i10;
        this.mColumnsSet = i11;
        if (i10 > 50) {
            this.mRowsSet = 3;
        }
        if (i11 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initMatrices();
    }

    private void addConstraints() {
        setBoxWidgetVerticalChains();
        setBoxWidgetHorizontalChains();
        arrangeWidgets();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void arrangeWidgets() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.mWidgetsCount
            if (r1 >= r2) goto L73
            java.util.Set<java.lang.String> r2 = r10.mSpanIds
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r10.mWidgets
            r3 = r3[r1]
            java.lang.String r3 = r3.stringId
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L15
            goto L70
        L15:
            int r2 = r10.getNextPosition()
            int r5 = r10.getRowByIndex(r2)
            int r6 = r10.getColByIndex(r2)
            r3 = -1
            if (r2 != r3) goto L25
            goto L73
        L25:
            boolean r3 = r10.isSpansRespectWidgetOrder()
            if (r3 == 0) goto L66
            int[][] r3 = r10.mSpanMatrix
            if (r3 == 0) goto L66
            int r4 = r10.mSpanIndex
            int r7 = r3.length
            if (r4 >= r7) goto L66
            r3 = r3[r4]
            r4 = r3[r0]
            if (r4 != r2) goto L66
            boolean[][] r2 = r10.mPositionMatrix
            r2 = r2[r5]
            r9 = 1
            r2[r6] = r9
            r2 = r3[r9]
            r4 = 2
            r3 = r3[r4]
            boolean r2 = r10.invalidatePositions(r5, r6, r2, r3)
            if (r2 != 0) goto L4d
            goto L70
        L4d:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r2 = r10.mWidgets
            r2 = r2[r1]
            int[][] r3 = r10.mSpanMatrix
            int r7 = r10.mSpanIndex
            r3 = r3[r7]
            r7 = r3[r9]
            r8 = r3[r4]
            r3 = r10
            r4 = r2
            r3.connectWidget(r4, r5, r6, r7, r8)
            int r2 = r3.mSpanIndex
            int r2 = r2 + r9
            r3.mSpanIndex = r2
            goto L70
        L66:
            r3 = r10
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r2 = r3.mWidgets
            r4 = r2[r1]
            r7 = 1
            r8 = 1
            r3.connectWidget(r4, r5, r6, r7, r8)
        L70:
            int r1 = r1 + 1
            goto L2
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.utils.GridCore.arrangeWidgets():void");
    }

    private void clearHorizontalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setHorizontalWeight(-1.0f);
        constraintWidget.mLeft.reset();
        constraintWidget.mRight.reset();
    }

    private void clearVerticalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setVerticalWeight(-1.0f);
        constraintWidget.mTop.reset();
        constraintWidget.mBottom.reset();
        constraintWidget.mBaseline.reset();
    }

    private void connectWidget(ConstraintWidget constraintWidget, int i10, int i11, int i12, int i13) {
        constraintWidget.mLeft.connect(this.mBoxWidgets[i11].mLeft, 0);
        constraintWidget.mTop.connect(this.mBoxWidgets[i10].mTop, 0);
        constraintWidget.mRight.connect(this.mBoxWidgets[(i11 + i13) - 1].mRight, 0);
        constraintWidget.mBottom.connect(this.mBoxWidgets[(i10 + i12) - 1].mBottom, 0);
    }

    private void createBoxes() {
        int iMax = Math.max(this.mRows, this.mColumns);
        ConstraintWidget[] constraintWidgetArr = this.mBoxWidgets;
        int i10 = 0;
        if (constraintWidgetArr == null) {
            this.mBoxWidgets = new ConstraintWidget[iMax];
            while (true) {
                ConstraintWidget[] constraintWidgetArr2 = this.mBoxWidgets;
                if (i10 >= constraintWidgetArr2.length) {
                    return;
                }
                constraintWidgetArr2[i10] = makeNewWidget();
                i10++;
            }
        } else {
            if (iMax == constraintWidgetArr.length) {
                return;
            }
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[iMax];
            while (i10 < iMax) {
                ConstraintWidget[] constraintWidgetArr4 = this.mBoxWidgets;
                if (i10 < constraintWidgetArr4.length) {
                    constraintWidgetArr3[i10] = constraintWidgetArr4[i10];
                } else {
                    constraintWidgetArr3[i10] = makeNewWidget();
                }
                i10++;
            }
            while (true) {
                ConstraintWidget[] constraintWidgetArr5 = this.mBoxWidgets;
                if (iMax >= constraintWidgetArr5.length) {
                    this.mBoxWidgets = constraintWidgetArr3;
                    return;
                } else {
                    this.mContainer.remove(constraintWidgetArr5[iMax]);
                    iMax++;
                }
            }
        }
    }

    private void fillConstraintMatrix(boolean z9) {
        int[][] spans;
        int[][] spans2;
        if (z9) {
            for (int i10 = 0; i10 < this.mPositionMatrix.length; i10++) {
                int i11 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i11 < zArr[0].length) {
                        zArr[i10][i11] = true;
                        i11++;
                    }
                }
            }
            for (int i12 = 0; i12 < this.mConstraintMatrix.length; i12++) {
                int i13 = 0;
                while (true) {
                    int[][] iArr = this.mConstraintMatrix;
                    if (i13 < iArr[0].length) {
                        iArr[i12][i13] = -1;
                        i13++;
                    }
                }
            }
        }
        this.mNextAvailableIndex = 0;
        String str = this.mSkips;
        if (str != null && !str.trim().isEmpty() && (spans2 = parseSpans(this.mSkips, false)) != null) {
            handleSkips(spans2);
        }
        String str2 = this.mSpans;
        if (str2 == null || str2.trim().isEmpty() || (spans = parseSpans(this.mSpans, true)) == null) {
            return;
        }
        handleSpans(spans);
    }

    private int getColByIndex(int i10) {
        return this.mOrientation == 1 ? i10 / this.mRows : i10 % this.mColumns;
    }

    private int getNextPosition() {
        boolean z9 = false;
        int i10 = 0;
        while (!z9) {
            i10 = this.mNextAvailableIndex;
            if (i10 >= this.mRows * this.mColumns) {
                return -1;
            }
            int rowByIndex = getRowByIndex(i10);
            int colByIndex = getColByIndex(this.mNextAvailableIndex);
            boolean[] zArr = this.mPositionMatrix[rowByIndex];
            if (zArr[colByIndex]) {
                zArr[colByIndex] = false;
                z9 = true;
            }
            this.mNextAvailableIndex++;
        }
        return i10;
    }

    private int getRowByIndex(int i10) {
        return this.mOrientation == 1 ? i10 % this.mRows : i10 / this.mColumns;
    }

    private void handleSkips(int[][] iArr) {
        for (int[] iArr2 : iArr) {
            if (!invalidatePositions(getRowByIndex(iArr2[0]), getColByIndex(iArr2[0]), iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        if (!isSpansRespectWidgetOrder()) {
            for (int i10 = 0; i10 < iArr.length; i10++) {
                int rowByIndex = getRowByIndex(iArr[i10][0]);
                int colByIndex = getColByIndex(iArr[i10][0]);
                int[] iArr2 = iArr[i10];
                if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i10];
                int[] iArr3 = iArr[i10];
                connectWidget(constraintWidget, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
                this.mSpanIds.add(this.mWidgets[i10].stringId);
            }
        }
    }

    private void initMatrices() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z9 = false;
        if (iArr != null && iArr.length == this.mWidgetsCount && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z9 = true;
        }
        if (!z9) {
            initVariables();
        }
        fillConstraintMatrix(z9);
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i10 = this.mWidgetsCount;
        if (i10 > 0) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i10, 4);
            this.mConstraintMatrix = iArr;
            for (int[] iArr2 : iArr) {
                Arrays.fill(iArr2, -1);
            }
        }
    }

    private boolean invalidatePositions(int i10, int i11, int i12, int i13) {
        for (int i14 = i10; i14 < i10 + i12; i14++) {
            for (int i15 = i11; i15 < i11 + i13; i15++) {
                boolean[][] zArr = this.mPositionMatrix;
                if (i14 < zArr.length && i15 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i14];
                    if (zArr2[i15]) {
                        zArr2[i15] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isSpansRespectWidgetOrder() {
        return (this.mFlags & 2) > 0;
    }

    private boolean isSubGridByColRow() {
        return (this.mFlags & 1) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$parseSpans$0(String str, String str2) {
        return Integer.parseInt(str.split(":")[0]) - Integer.parseInt(str2.split(":")[0]);
    }

    private ConstraintWidget makeNewWidget() {
        ConstraintWidget constraintWidget = new ConstraintWidget();
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        constraintWidget.stringId = String.valueOf(constraintWidget.hashCode());
        return constraintWidget;
    }

    private int[][] parseSpans(String str, boolean z9) {
        try {
            String[] strArrSplit = str.split(",");
            Arrays.sort(strArrSplit, new h(1));
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 3);
            if (this.mRows != 1 && this.mColumns != 1) {
                for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                    String[] strArrSplit2 = strArrSplit[i10].trim().split(":");
                    String[] strArrSplit3 = strArrSplit2[1].split("x");
                    iArr[i10][0] = Integer.parseInt(strArrSplit2[0]);
                    if (isSubGridByColRow()) {
                        iArr[i10][1] = Integer.parseInt(strArrSplit3[1]);
                        iArr[i10][2] = Integer.parseInt(strArrSplit3[0]);
                    } else {
                        iArr[i10][1] = Integer.parseInt(strArrSplit3[0]);
                        iArr[i10][2] = Integer.parseInt(strArrSplit3[1]);
                    }
                }
                return iArr;
            }
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < strArrSplit.length; i13++) {
                String[] strArrSplit4 = strArrSplit[i13].trim().split(":");
                iArr[i13][0] = Integer.parseInt(strArrSplit4[0]);
                int[] iArr2 = iArr[i13];
                iArr2[1] = 1;
                iArr2[2] = 1;
                if (this.mColumns == 1) {
                    iArr2[1] = Integer.parseInt(strArrSplit4[1]);
                    i11 += iArr[i13][1];
                    if (z9) {
                        i11--;
                    }
                }
                if (this.mRows == 1) {
                    iArr[i13][2] = Integer.parseInt(strArrSplit4[1]);
                    i12 += iArr[i13][2];
                    if (z9) {
                        i12--;
                    }
                }
            }
            if (i11 != 0 && !this.mExtraSpaceHandled) {
                setRows(this.mRows + i11);
            }
            if (i12 != 0 && !this.mExtraSpaceHandled) {
                setColumns(this.mColumns + i12);
            }
            this.mExtraSpaceHandled = true;
            return iArr;
        } catch (Exception unused) {
            return null;
        }
    }

    private float[] parseWeights(int i10, String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        float[] fArr = new float[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 < strArrSplit.length) {
                try {
                    fArr[i11] = Float.parseFloat(strArrSplit[i11]);
                } catch (Exception e) {
                    System.err.println("Error parsing `" + strArrSplit[i11] + "`: " + e.getMessage());
                    fArr[i11] = 1.0f;
                }
            } else {
                fArr[i11] = 1.0f;
            }
        }
        return fArr;
    }

    private void setBoxWidgetHorizontalChains() {
        int i10;
        int iMax = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] weights = parseWeights(this.mColumns, this.mColumnWeights);
        if (this.mColumns == 1) {
            clearHorizontalAttributes(constraintWidget);
            constraintWidget.mLeft.connect(this.mLeft, 0);
            constraintWidget.mRight.connect(this.mRight, 0);
            return;
        }
        int i11 = 0;
        while (true) {
            i10 = this.mColumns;
            if (i11 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i11];
            clearHorizontalAttributes(constraintWidget2);
            if (weights != null) {
                constraintWidget2.setHorizontalWeight(weights[i11]);
            }
            if (i11 > 0) {
                constraintWidget2.mLeft.connect(this.mBoxWidgets[i11 - 1].mRight, 0);
            } else {
                constraintWidget2.mLeft.connect(this.mLeft, 0);
            }
            if (i11 < this.mColumns - 1) {
                constraintWidget2.mRight.connect(this.mBoxWidgets[i11 + 1].mLeft, 0);
            } else {
                constraintWidget2.mRight.connect(this.mRight, 0);
            }
            if (i11 > 0) {
                constraintWidget2.mLeft.mMargin = (int) this.mHorizontalGaps;
            }
            i11++;
        }
        while (i10 < iMax) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i10];
            clearHorizontalAttributes(constraintWidget3);
            constraintWidget3.mLeft.connect(this.mLeft, 0);
            constraintWidget3.mRight.connect(this.mRight, 0);
            i10++;
        }
    }

    private void setBoxWidgetVerticalChains() {
        int i10;
        int iMax = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] weights = parseWeights(this.mRows, this.mRowWeights);
        if (this.mRows == 1) {
            clearVerticalAttributes(constraintWidget);
            constraintWidget.mTop.connect(this.mTop, 0);
            constraintWidget.mBottom.connect(this.mBottom, 0);
            return;
        }
        int i11 = 0;
        while (true) {
            i10 = this.mRows;
            if (i11 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i11];
            clearVerticalAttributes(constraintWidget2);
            if (weights != null) {
                constraintWidget2.setVerticalWeight(weights[i11]);
            }
            if (i11 > 0) {
                constraintWidget2.mTop.connect(this.mBoxWidgets[i11 - 1].mBottom, 0);
            } else {
                constraintWidget2.mTop.connect(this.mTop, 0);
            }
            if (i11 < this.mRows - 1) {
                constraintWidget2.mBottom.connect(this.mBoxWidgets[i11 + 1].mTop, 0);
            } else {
                constraintWidget2.mBottom.connect(this.mBottom, 0);
            }
            if (i11 > 0) {
                constraintWidget2.mTop.mMargin = (int) this.mVerticalGaps;
            }
            i11++;
        }
        while (i10 < iMax) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i10];
            clearVerticalAttributes(constraintWidget3);
            constraintWidget3.mTop.connect(this.mTop, 0);
            constraintWidget3.mBottom.connect(this.mBottom, 0);
            i10++;
        }
    }

    private void setupGrid(boolean z9) {
        int[][] spans;
        if (this.mRows < 1 || this.mColumns < 1) {
            return;
        }
        if (z9) {
            for (int i10 = 0; i10 < this.mPositionMatrix.length; i10++) {
                int i11 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i11 < zArr[0].length) {
                        zArr[i10][i11] = true;
                        i11++;
                    }
                }
            }
            this.mSpanIds.clear();
        }
        this.mNextAvailableIndex = 0;
        String str = this.mSkips;
        if (str != null && !str.trim().isEmpty() && (spans = parseSpans(this.mSkips, false)) != null) {
            handleSkips(spans);
        }
        String str2 = this.mSpans;
        if (str2 != null && !str2.trim().isEmpty()) {
            this.mSpanMatrix = parseSpans(this.mSpans, true);
        }
        createBoxes();
        int[][] iArr = this.mSpanMatrix;
        if (iArr != null) {
            handleSpans(iArr);
        }
    }

    private void updateActualRowsAndColumns() {
        int i10;
        int i11 = this.mRowsSet;
        if (i11 != 0 && (i10 = this.mColumnsSet) != 0) {
            this.mRows = i11;
            this.mColumns = i10;
            return;
        }
        int i12 = this.mColumnsSet;
        if (i12 > 0) {
            this.mColumns = i12;
            this.mRows = ((this.mWidgetsCount + i12) - 1) / i12;
        } else if (i11 > 0) {
            this.mRows = i11;
            this.mColumns = ((this.mWidgetsCount + i11) - 1) / i11;
        } else {
            int iSqrt = (int) (Math.sqrt(this.mWidgetsCount) + 1.5d);
            this.mRows = iSqrt;
            this.mColumns = ((this.mWidgetsCount + iSqrt) - 1) / iSqrt;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(@Nullable LinearSystem linearSystem, boolean z9) {
        super.addToSolver(linearSystem, z9);
        addConstraints();
    }

    @Nullable
    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    @Nullable
    public ConstraintWidgetContainer getContainer() {
        return this.mContainer;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Nullable
    public String getRowWeights() {
        return this.mRowWeights;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i10, int i11, int i12, int i13) {
        super.measure(i10, i11, i12, i13);
        this.mContainer = (ConstraintWidgetContainer) getParent();
        setupGrid(false);
        this.mContainer.add(this.mBoxWidgets);
    }

    public void setColumnWeights(@NonNull String str) {
        String str2 = this.mColumnWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mColumnWeights = str;
        }
    }

    public void setColumns(int i10) {
        if (i10 <= 50 && this.mColumnsSet != i10) {
            this.mColumnsSet = i10;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setContainer(@NonNull ConstraintWidgetContainer constraintWidgetContainer) {
        this.mContainer = constraintWidgetContainer;
    }

    public void setFlags(int i10) {
        this.mFlags = i10;
    }

    public void setHorizontalGaps(float f) {
        if (f >= 0.0f && this.mHorizontalGaps != f) {
            this.mHorizontalGaps = f;
        }
    }

    public void setOrientation(int i10) {
        if ((i10 == 0 || i10 == 1) && this.mOrientation != i10) {
            this.mOrientation = i10;
        }
    }

    public void setRowWeights(@NonNull String str) {
        String str2 = this.mRowWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mRowWeights = str;
        }
    }

    public void setRows(int i10) {
        if (i10 <= 50 && this.mRowsSet != i10) {
            this.mRowsSet = i10;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setSkips(@NonNull String str) {
        String str2 = this.mSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mExtraSpaceHandled = false;
            this.mSkips = str;
        }
    }

    public void setSpans(@NonNull CharSequence charSequence) {
        String str = this.mSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mExtraSpaceHandled = false;
            this.mSpans = charSequence.toString();
        }
    }

    public void setVerticalGaps(float f) {
        if (f >= 0.0f && this.mVerticalGaps != f) {
            this.mVerticalGaps = f;
        }
    }

    public GridCore() {
        updateActualRowsAndColumns();
        initMatrices();
    }
}
