package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteStatement;
import com.mbridge.msdk.dycreator.baseview.a;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class CursorSQLiteStatement implements SQLiteStatement {
    public static final Companion Companion = new Companion(null);
    private final Cursor cursor;

    public CursorSQLiteStatement(Cursor cursor) {
        cursor.getClass();
        this.cursor = cursor;
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindBlob, reason: merged with bridge method [inline-methods] */
    public Void mo88bindBlob(int i10, byte[] bArr) {
        bArr.getClass();
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindBoolean(int i10, boolean z9) {
        mo90bindLong(i10, z9 ? 1L : 0L);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindDouble, reason: merged with bridge method [inline-methods] */
    public Void mo89bindDouble(int i10, double d8) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindFloat(int i10, float f) {
        mo89bindDouble(i10, f);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindInt(int i10, int i11) {
        mo90bindLong(i10, i11);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindLong, reason: merged with bridge method [inline-methods] */
    public Void mo90bindLong(int i10, long j10) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindNull, reason: merged with bridge method [inline-methods] */
    public Void mo91bindNull(int i10) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindText, reason: merged with bridge method [inline-methods] */
    public Void mo92bindText(int i10, String str) {
        str.getClass();
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: clearBindings, reason: merged with bridge method [inline-methods] */
    public Void mo93clearBindings() {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public byte[] getBlob(int i10) {
        byte[] blob = this.cursor.getBlob(i10);
        blob.getClass();
        return blob;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final /* synthetic */ boolean getBoolean(int i10) {
        return a.a(this, i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getColumnName(int i10) {
        String columnName = this.cursor.getColumnName(i10);
        columnName.getClass();
        return columnName;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final /* synthetic */ List getColumnNames() {
        return a.b(this);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(int i10) {
        return Companion.getDataType(this.cursor, i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(int i10) {
        return this.cursor.getDouble(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final float getFloat(int i10) {
        return (float) getDouble(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final int getInt(int i10) {
        return (int) getLong(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(int i10) {
        return this.cursor.getLong(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getText(int i10) {
        String string = this.cursor.getString(i10);
        string.getClass();
        return string;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(int i10) {
        return this.cursor.isNull(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.cursor.moveToPosition(-1);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        return this.cursor.moveToNext();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getDataType(Cursor cursor, int i10) {
            int type = cursor.getType(i10);
            int type2 = cursor.getType(i10);
            if (type2 == 0) {
                return 5;
            }
            int i11 = 1;
            if (type2 != 1) {
                i11 = 2;
                if (type2 != 2) {
                    i11 = 3;
                    if (type2 != 3) {
                        if (type2 == 4) {
                            return 4;
                        }
                        a2.a.g(type, "Unknown field type: ");
                        return 0;
                    }
                }
            }
            return i11;
        }

        private Companion() {
        }
    }
}
