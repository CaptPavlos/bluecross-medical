package androidx.room.driver;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.window.layout.c;
import com.google.android.gms.internal.measurement.u6;
import com.mbridge.msdk.dycreator.baseview.a;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.g;
import o7.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class SupportSQLiteStatement implements SQLiteStatement {
    public static final Companion Companion = new Companion(null);
    private final SupportSQLiteDatabase db;
    private boolean isClosed;
    private final String sql;

    private SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        this.db = supportSQLiteDatabase;
        this.sql = str;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindBoolean(int i10, boolean z9) {
        mo90bindLong(i10, z9 ? 1L : 0L);
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
    public final /* synthetic */ boolean getBoolean(int i10) {
        return a.a(this, i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final /* synthetic */ List getColumnNames() {
        return a.b(this);
    }

    public final SupportSQLiteDatabase getDb() {
        return this.db;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final float getFloat(int i10) {
        return (float) getDouble(i10);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final int getInt(int i10) {
        return (int) getLong(i10);
    }

    public final String getSql() {
        return this.sql;
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final void setClosed(boolean z9) {
        this.isClosed = z9;
    }

    public final void throwIfClosed() {
        if (this.isClosed) {
            throw androidx.constraintlayout.core.widgets.analyzer.a.p(21, "statement is closed");
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class SupportAndroidSQLiteStatement extends SupportSQLiteStatement {
        public static final Companion Companion = new Companion(null);
        private int[] bindingTypes;
        private byte[][] blobBindings;
        private Cursor cursor;
        private double[] doubleBindings;
        private long[] longBindings;
        private String[] stringBindings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportAndroidSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            super(supportSQLiteDatabase, str, null);
            supportSQLiteDatabase.getClass();
            str.getClass();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        private final void ensureCapacity(int i10, int i11) {
            int i12 = i11 + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i12) {
                this.bindingTypes = Arrays.copyOf(iArr, i12);
            }
            if (i10 == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i12) {
                    this.longBindings = Arrays.copyOf(jArr, i12);
                    return;
                }
                return;
            }
            if (i10 == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i12) {
                    this.doubleBindings = Arrays.copyOf(dArr, i12);
                    return;
                }
                return;
            }
            if (i10 == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i12) {
                    this.stringBindings = (String[]) Arrays.copyOf(strArr, i12);
                    return;
                }
                return;
            }
            if (i10 != 4) {
                return;
            }
            byte[][] bArr = this.blobBindings;
            if (bArr.length < i12) {
                this.blobBindings = (byte[][]) Arrays.copyOf(bArr, i12);
            }
        }

        private final void ensureCursor() {
            if (this.cursor == null) {
                this.cursor = getDb().query(new SupportSQLiteQuery() { // from class: androidx.room.driver.SupportSQLiteStatement$SupportAndroidSQLiteStatement$ensureCursor$1
                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
                        supportSQLiteProgram.getClass();
                        int length = this.this$0.bindingTypes.length;
                        for (int i10 = 1; i10 < length; i10++) {
                            int i11 = this.this$0.bindingTypes[i10];
                            if (i11 == 1) {
                                supportSQLiteProgram.bindLong(i10, this.this$0.longBindings[i10]);
                            } else if (i11 == 2) {
                                supportSQLiteProgram.bindDouble(i10, this.this$0.doubleBindings[i10]);
                            } else if (i11 == 3) {
                                String str = this.this$0.stringBindings[i10];
                                str.getClass();
                                supportSQLiteProgram.bindString(i10, str);
                            } else if (i11 == 4) {
                                byte[] bArr = this.this$0.blobBindings[i10];
                                bArr.getClass();
                                supportSQLiteProgram.bindBlob(i10, bArr);
                            } else if (i11 == 5) {
                                supportSQLiteProgram.bindNull(i10);
                            }
                        }
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public int getArgCount() {
                        return this.this$0.bindingTypes.length;
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public String getSql() {
                        return this.this$0.getSql();
                    }
                });
            }
        }

        private final void throwIfInvalidColumn(Cursor cursor, int i10) {
            if (i10 < 0 || i10 >= cursor.getColumnCount()) {
                throw androidx.constraintlayout.core.widgets.analyzer.a.p(25, "column index out of range");
            }
        }

        private final Cursor throwIfNoRow() {
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor;
            }
            throw androidx.constraintlayout.core.widgets.analyzer.a.p(21, "no row");
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo88bindBlob(int i10, byte[] bArr) {
            bArr.getClass();
            throwIfClosed();
            ensureCapacity(4, i10);
            this.bindingTypes[i10] = 4;
            this.blobBindings[i10] = bArr;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo89bindDouble(int i10, double d8) {
            throwIfClosed();
            ensureCapacity(2, i10);
            this.bindingTypes[i10] = 2;
            this.doubleBindings[i10] = d8;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo90bindLong(int i10, long j10) {
            throwIfClosed();
            ensureCapacity(1, i10);
            this.bindingTypes[i10] = 1;
            this.longBindings[i10] = j10;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo91bindNull(int i10) {
            throwIfClosed();
            ensureCapacity(5, i10);
            this.bindingTypes[i10] = 5;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo92bindText(int i10, String str) {
            str.getClass();
            throwIfClosed();
            ensureCapacity(3, i10);
            this.bindingTypes[i10] = 3;
            this.stringBindings[i10] = str;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo93clearBindings() {
            throwIfClosed();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (!isClosed()) {
                mo93clearBindings();
                reset();
            }
            setClosed(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int i10) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, i10);
            byte[] blob = cursorThrowIfNoRow.getBlob(i10);
            blob.getClass();
            return blob;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i10) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                c.g("Required value was null.");
                return null;
            }
            throwIfInvalidColumn(cursor, i10);
            String columnName = cursor.getColumnName(i10);
            columnName.getClass();
            return columnName;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i10) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                throwIfInvalidColumn(cursor, i10);
                return Companion.getDataType(cursor, i10);
            }
            c.g("Required value was null.");
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i10) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, i10);
            return cursorThrowIfNoRow.getDouble(i10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i10) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, i10);
            return cursorThrowIfNoRow.getLong(i10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int i10) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, i10);
            String string = cursorThrowIfNoRow.getString(i10);
            string.getClass();
            return string;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i10) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, i10);
            return cursorThrowIfNoRow.isNull(i10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                cursor.close();
            }
            this.cursor = null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            c.g("Required value was null.");
            return false;
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

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private final boolean isRowStatement(String str) {
            String string = m.v0(str).toString();
            if (string.length() < 3) {
                return false;
            }
            String upperCase = string.substring(0, 3).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            int iHashCode = upperCase.hashCode();
            if (iHashCode != 79487) {
                if (iHashCode != 81978) {
                    if (iHashCode == 85954 && upperCase.equals("WIT")) {
                        return true;
                    }
                } else if (upperCase.equals("SEL")) {
                    return true;
                }
            } else if (upperCase.equals("PRA")) {
                return true;
            }
            return false;
        }

        public final SupportSQLiteStatement create(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            supportSQLiteDatabase.getClass();
            str.getClass();
            return isRowStatement(str) ? new SupportAndroidSQLiteStatement(supportSQLiteDatabase, str) : new SupportOtherAndroidSQLiteStatement(supportSQLiteDatabase, str);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str, g gVar) {
        this(supportSQLiteDatabase, str);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class SupportOtherAndroidSQLiteStatement extends SupportSQLiteStatement {
        private final androidx.sqlite.db.SupportSQLiteStatement delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportOtherAndroidSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            super(supportSQLiteDatabase, str, null);
            supportSQLiteDatabase.getClass();
            str.getClass();
            this.delegate = supportSQLiteDatabase.compileStatement(str);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo88bindBlob(int i10, byte[] bArr) {
            bArr.getClass();
            throwIfClosed();
            this.delegate.bindBlob(i10, bArr);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo89bindDouble(int i10, double d8) {
            throwIfClosed();
            this.delegate.bindDouble(i10, d8);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo90bindLong(int i10, long j10) {
            throwIfClosed();
            this.delegate.bindLong(i10, j10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo91bindNull(int i10) {
            throwIfClosed();
            this.delegate.bindNull(i10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo92bindText(int i10, String str) {
            str.getClass();
            throwIfClosed();
            this.delegate.bindString(i10, str);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo93clearBindings() {
            throwIfClosed();
            this.delegate.clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() throws IOException {
            this.delegate.close();
            setClosed(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int i10) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new u6();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i10) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new u6();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i10) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new u6();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i10) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new u6();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i10) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new u6();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int i10) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new u6();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i10) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new u6();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            this.delegate.execute();
            return false;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
        }
    }
}
