package androidx.room.util;

import android.os.Build;
import androidx.sqlite.SQLiteStatement;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class SQLiteStatementUtil__StatementUtil_androidKt {
    public static final int columnIndexOf(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        str.getClass();
        int iColumnIndexOfCommon = SQLiteStatementUtil.columnIndexOfCommon(sQLiteStatement, str);
        if (iColumnIndexOfCommon >= 0) {
            return iColumnIndexOfCommon;
        }
        int iColumnIndexOfCommon2 = SQLiteStatementUtil.columnIndexOfCommon(sQLiteStatement, "`" + str + '`');
        return iColumnIndexOfCommon2 >= 0 ? iColumnIndexOfCommon2 : findColumnIndexBySuffix$SQLiteStatementUtil__StatementUtil_androidKt(sQLiteStatement, str);
    }

    private static final int findColumnIndexBySuffix$SQLiteStatementUtil__StatementUtil_androidKt(SQLiteStatement sQLiteStatement, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        int columnCount = sQLiteStatement.getColumnCount();
        String strConcat = ".".concat(str);
        String str2 = "." + str + '`';
        for (int i10 = 0; i10 < columnCount; i10++) {
            String columnName = sQLiteStatement.getColumnName(i10);
            if (columnName.length() >= str.length() + 2 && (u.X(columnName, strConcat, false) || (columnName.charAt(0) == '`' && u.X(columnName, str2, false)))) {
                return i10;
            }
        }
        return -1;
    }
}
