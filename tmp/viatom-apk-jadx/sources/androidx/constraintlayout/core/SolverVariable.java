package androidx.constraintlayout.core;

import a3.a;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    private static final boolean DO_NOT_USE = false;
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int sUniqueConstantId = 1;
    private static int sUniqueErrorId = 1;
    private static int sUniqueId = 1;
    private static int sUniqueSlackId = 1;
    private static int sUniqueUnrestrictedId = 1;
    public float computedValue;
    public int id;
    public boolean inGoal;
    public boolean isFinalValue;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    int mDefinitionId;
    float[] mGoalStrengthVector;
    HashSet<ArrayRow> mInRows;
    boolean mIsSynonym;
    private String mName;
    float[] mStrengthVector;
    int mSynonym;
    float mSynonymDelta;
    Type mType;
    public int strength;
    public int usageInRowCount;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.mDefinitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.mStrengthVector = new float[9];
        this.mGoalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        this.mInRows = null;
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            StringBuilder sbV = a.v(str);
            sbV.append(sUniqueErrorId);
            return sbV.toString();
        }
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0) {
            StringBuilder sb = new StringBuilder("U");
            int i10 = sUniqueUnrestrictedId + 1;
            sUniqueUnrestrictedId = i10;
            sb.append(i10);
            return sb.toString();
        }
        if (iOrdinal == 1) {
            StringBuilder sb2 = new StringBuilder("C");
            int i11 = sUniqueConstantId + 1;
            sUniqueConstantId = i11;
            sb2.append(i11);
            return sb2.toString();
        }
        if (iOrdinal == 2) {
            StringBuilder sb3 = new StringBuilder(ExifInterface.LATITUDE_SOUTH);
            int i12 = sUniqueSlackId + 1;
            sUniqueSlackId = i12;
            sb3.append(i12);
            return sb3.toString();
        }
        if (iOrdinal == 3) {
            StringBuilder sb4 = new StringBuilder("e");
            int i13 = sUniqueErrorId + 1;
            sUniqueErrorId = i13;
            sb4.append(i13);
            return sb4.toString();
        }
        if (iOrdinal != 4) {
            u.h(type.name());
            return null;
        }
        StringBuilder sb5 = new StringBuilder(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i14 = sUniqueId + 1;
        sUniqueId = i14;
        sb5.append(i14);
        return sb5.toString();
    }

    public static void increaseErrorId() {
        sUniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i10 = 0;
        while (true) {
            int i11 = this.mClientEquationsCount;
            ArrayRow[] arrayRowArr = this.mClientEquations;
            if (i10 >= i11) {
                if (i11 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i12 = this.mClientEquationsCount;
                arrayRowArr2[i12] = arrayRow;
                this.mClientEquationsCount = i12 + 1;
                return;
            }
            if (arrayRowArr[i10] == arrayRow) {
                return;
            } else {
                i10++;
            }
        }
    }

    public void clearStrengths() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.mStrengthVector[i10] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i10 = this.mClientEquationsCount;
        int i11 = 0;
        while (i11 < i10) {
            if (this.mClientEquations[i11] == arrayRow) {
                while (i11 < i10 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i12 = i11 + 1;
                    arrayRowArr[i11] = arrayRowArr[i12];
                    i11 = i12;
                }
                this.mClientEquationsCount--;
                return;
            }
            i11++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.mDefinitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        int i10 = this.mClientEquationsCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.mGoalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        int i10 = this.mClientEquationsCount;
        this.mDefinitionId = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f) {
        this.mIsSynonym = true;
        this.mSynonym = solverVariable.id;
        this.mSynonymDelta = f;
        int i10 = this.mClientEquationsCount;
        this.mDefinitionId = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String strConcat = this + "[";
        int i10 = 0;
        boolean z9 = false;
        boolean z10 = true;
        while (i10 < this.mStrengthVector.length) {
            StringBuilder sbV = a.v(strConcat);
            sbV.append(this.mStrengthVector[i10]);
            String string = sbV.toString();
            float[] fArr = this.mStrengthVector;
            float f = fArr[i10];
            if (f > 0.0f) {
                z9 = false;
            } else if (f < 0.0f) {
                z9 = true;
            }
            if (f != 0.0f) {
                z10 = false;
            }
            strConcat = i10 < fArr.length - 1 ? string.concat(", ") : string.concat("] ");
            i10++;
        }
        if (z9) {
            strConcat = strConcat.concat(" (-)");
        }
        return z10 ? strConcat.concat(" (*)") : strConcat;
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i10 = this.mClientEquationsCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(SolverVariable solverVariable) {
        return this.id - solverVariable.id;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.mDefinitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.mStrengthVector = new float[9];
        this.mGoalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        this.mInRows = null;
        this.mType = type;
    }
}
