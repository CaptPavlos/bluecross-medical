package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.EnvironmentCompat;
import androidx.window.layout.c;
import com.google.android.gms.internal.measurement.a4;
import g7.l;
import java.io.IOException;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class CursorUtil {
    public static final Cursor copyAndClose(Cursor cursor) throws IOException {
        cursor.getClass();
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i10 = 0; i10 < columnCount; i10++) {
                    int type = cursor.getType(i10);
                    if (type == 0) {
                        objArr[i10] = null;
                    } else if (type == 1) {
                        objArr[i10] = Long.valueOf(cursor.getLong(i10));
                    } else if (type == 2) {
                        objArr[i10] = Double.valueOf(cursor.getDouble(i10));
                    } else if (type == 3) {
                        objArr[i10] = cursor.getString(i10);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i10] = cursor.getBlob(i10);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            cursor.close();
            return matrixCursor;
        } finally {
        }
    }

    @VisibleForTesting
    public static final int findColumnIndexBySuffix(String[] strArr, String str) {
        strArr.getClass();
        str.getClass();
        String strConcat = ".".concat(str);
        String str2 = "." + str + '`';
        int length = strArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            String str3 = strArr[i10];
            int i12 = i11 + 1;
            if (str3.length() >= str.length() + 2 && (u.X(str3, strConcat, false) || (str3.charAt(0) == '`' && u.X(str3, str2, false)))) {
                return i11;
            }
            i10++;
            i11 = i12;
        }
        return -1;
    }

    public static final int getColumnIndex(Cursor cursor, String str) {
        cursor.getClass();
        str.getClass();
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(cursor, str);
    }

    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String string;
        cursor.getClass();
        str.getClass();
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            columnNames.getClass();
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "");
            int i10 = 0;
            for (String str2 : columnNames) {
                i10++;
                if (i10 > 1) {
                    sb.append((CharSequence) ", ");
                }
                a4.g(sb, str2, null);
            }
            sb.append((CharSequence) "");
            string = sb.toString();
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            string = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        c.h("column '", str, "' does not exist. Available columns: ", string);
        return 0;
    }

    public static final <R> R useCursor(Cursor cursor, l lVar) throws IOException {
        cursor.getClass();
        lVar.getClass();
        try {
            R r6 = (R) lVar.invoke(cursor);
            cursor.close();
            return r6;
        } finally {
        }
    }

    public static final Cursor wrapMappedColumns(Cursor cursor, final String[] strArr, final int[] iArr) {
        cursor.getClass();
        strArr.getClass();
        iArr.getClass();
        if (strArr.length == iArr.length) {
            return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil.wrapMappedColumns.2
                @Override // android.database.CursorWrapper, android.database.Cursor
                public int getColumnIndex(String str) {
                    str.getClass();
                    String[] strArr2 = strArr;
                    int[] iArr2 = iArr;
                    int length = strArr2.length;
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < length) {
                        int i12 = i11 + 1;
                        if (u.Z(strArr2[i10], str, true)) {
                            return iArr2[i11];
                        }
                        i10++;
                        i11 = i12;
                    }
                    return super.getColumnIndex(str);
                }
            };
        }
        c.g("Expected columnNames.length == mapping.length");
        return null;
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        columnNames.getClass();
        return findColumnIndexBySuffix(columnNames, str);
    }
}
