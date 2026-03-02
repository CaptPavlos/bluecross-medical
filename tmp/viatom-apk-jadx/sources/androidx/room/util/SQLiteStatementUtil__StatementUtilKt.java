package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.state.b;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class SQLiteStatementUtil__StatementUtilKt {
    public static final int columnIndexOfCommon(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        str.getClass();
        if (sQLiteStatement instanceof MappedColumnsSQLiteStatementWrapper) {
            return ((MappedColumnsSQLiteStatementWrapper) sQLiteStatement).getColumnIndex(str);
        }
        int columnCount = sQLiteStatement.getColumnCount();
        for (int i10 = 0; i10 < columnCount; i10++) {
            if (str.equals(sQLiteStatement.getColumnName(i10))) {
                return i10;
            }
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndex(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        str.getClass();
        return SQLiteStatementUtil.columnIndexOf(sQLiteStatement, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndexOrThrow(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        str.getClass();
        int iColumnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, str);
        if (iColumnIndexOf >= 0) {
            return iColumnIndexOf;
        }
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i10 = 0; i10 < columnCount; i10++) {
            arrayList.add(sQLiteStatement.getColumnName(i10));
        }
        b.h(93, str, "' does not exist. Available columns: [", l.h0(arrayList, null, null, null, null, 63), "Column '");
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final SQLiteStatement wrapMappedColumns(SQLiteStatement sQLiteStatement, String[] strArr, int[] iArr) {
        sQLiteStatement.getClass();
        strArr.getClass();
        iArr.getClass();
        return new MappedColumnsSQLiteStatementWrapper(sQLiteStatement, strArr, iArr);
    }
}
