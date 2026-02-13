package androidx.constraintlayout.core.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class GridEngine {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int VERTICAL = 1;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    private int mNextAvailableIndex = 0;
    private int mNumWidgets;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    private String mStrSkips;
    private String mStrSpans;

    public GridEngine(int i10, int i11, int i12) {
        this.mRowsSet = i10;
        this.mColumnsSet = i11;
        this.mNumWidgets = i12;
        if (i10 > 50) {
            this.mRowsSet = 3;
        }
        if (i11 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        int i13 = this.mRows;
        int i14 = this.mColumns;
        if (i12 > i13 * i14 || i12 < 1) {
            this.mNumWidgets = i13 * i14;
        }
        initVariables();
        fillConstraintMatrix(false);
    }

    private void addAllConstraintPositions() {
        for (int i10 = 0; i10 < this.mNumWidgets; i10++) {
            if (leftOfWidget(i10) == -1) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return;
                } else {
                    addConstraintPosition(i10, rowByIndex, colByIndex, 1, 1);
                }
            }
        }
    }

    private void addConstraintPosition(int i10, int i11, int i12, int i13, int i14) {
        int[] iArr = this.mConstraintMatrix[i10];
        iArr[0] = i12;
        iArr[1] = i11;
        iArr[2] = (i12 + i14) - 1;
        iArr[3] = (i11 + i13) - 1;
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
        String str = this.mStrSkips;
        if (str != null && !str.trim().isEmpty() && (spans2 = parseSpans(this.mStrSkips)) != null) {
            handleSkips(spans2);
        }
        String str2 = this.mStrSpans;
        if (str2 != null && !str2.trim().isEmpty() && (spans = parseSpans(this.mStrSpans)) != null) {
            handleSpans(spans);
        }
        addAllConstraintPositions();
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
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int rowByIndex = getRowByIndex(iArr[i10][0]);
            int colByIndex = getColByIndex(iArr[i10][0]);
            int[] iArr2 = iArr[i10];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int rowByIndex = getRowByIndex(iArr[i10][0]);
            int colByIndex = getColByIndex(iArr[i10][0]);
            int[] iArr2 = iArr[i10];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return;
            }
            int[] iArr3 = iArr[i10];
            addConstraintPosition(i10, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
        }
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i10 = this.mNumWidgets;
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

    private boolean isSpansValid(CharSequence charSequence) {
        return charSequence != null;
    }

    private int[][] parseSpans(String str) {
        if (!isSpansValid(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 3);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String[] strArrSplit2 = strArrSplit[i10].trim().split(":");
            String[] strArrSplit3 = strArrSplit2[1].split("x");
            iArr[i10][0] = Integer.parseInt(strArrSplit2[0]);
            iArr[i10][1] = Integer.parseInt(strArrSplit3[0]);
            iArr[i10][2] = Integer.parseInt(strArrSplit3[1]);
        }
        return iArr;
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
            this.mRows = ((this.mNumWidgets + i12) - 1) / i12;
        } else if (i11 > 0) {
            this.mRows = i11;
            this.mColumns = ((this.mNumWidgets + i11) - 1) / i11;
        } else {
            int iSqrt = (int) (Math.sqrt(this.mNumWidgets) + 1.5d);
            this.mRows = iSqrt;
            this.mColumns = ((this.mNumWidgets + iSqrt) - 1) / iSqrt;
        }
    }

    public int bottomOfWidget(int i10) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i10 >= iArr.length) {
            return 0;
        }
        return iArr[i10][3];
    }

    public int leftOfWidget(int i10) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i10 >= iArr.length) {
            return 0;
        }
        return iArr[i10][0];
    }

    public int rightOfWidget(int i10) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i10 >= iArr.length) {
            return 0;
        }
        return iArr[i10][2];
    }

    public void setColumns(int i10) {
        if (i10 <= 50 && this.mColumnsSet != i10) {
            this.mColumnsSet = i10;
            updateActualRowsAndColumns();
        }
    }

    public void setNumWidgets(int i10) {
        if (i10 > this.mRows * this.mColumns) {
            return;
        }
        this.mNumWidgets = i10;
    }

    public void setOrientation(int i10) {
        if ((i10 == 0 || i10 == 1) && this.mOrientation != i10) {
            this.mOrientation = i10;
        }
    }

    public void setRows(int i10) {
        if (i10 <= 50 && this.mRowsSet != i10) {
            this.mRowsSet = i10;
            updateActualRowsAndColumns();
        }
    }

    public void setSkips(String str) {
        String str2 = this.mStrSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mStrSkips = str;
        }
    }

    public void setSpans(CharSequence charSequence) {
        String str = this.mStrSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mStrSpans = charSequence.toString();
        }
    }

    public void setup() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z9 = false;
        if (iArr != null && iArr.length == this.mNumWidgets && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z9 = true;
        }
        if (!z9) {
            initVariables();
        }
        fillConstraintMatrix(z9);
    }

    public int topOfWidget(int i10) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i10 >= iArr.length) {
            return 0;
        }
        return iArr[i10][1];
    }

    public GridEngine(int i10, int i11) {
        this.mRowsSet = i10;
        this.mColumnsSet = i11;
        if (i10 > 50) {
            this.mRowsSet = 3;
        }
        if (i11 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initVariables();
    }

    public GridEngine() {
    }
}
