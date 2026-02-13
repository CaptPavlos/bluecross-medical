package androidx.sqlite.db.framework;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.k;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import g7.r;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.l;
import s6.f;
import s6.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private static final f beginTransactionMethod$delegate;
    private static final f getThreadSessionMethod$delegate;
    private final SQLiteDatabase delegate;
    public static final Companion Companion = new Companion(null);
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(30)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        public final void execPerConnectionSQL(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) throws SQLException {
            sQLiteDatabase.getClass();
            str.getClass();
            sQLiteDatabase.execPerConnectionSQL(str, objArr);
        }
    }

    static {
        k kVar = new k(7);
        g gVar = g.f12691b;
        getThreadSessionMethod$delegate = s6.a.c(gVar, kVar);
        beginTransactionMethod$delegate = s6.a.c(gVar, new k(8));
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        this.delegate = sQLiteDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method beginTransactionMethod_delegate$lambda$8() {
        Class<?> returnType;
        try {
            Method getThreadSessionMethod = Companion.getGetThreadSessionMethod();
            if (getThreadSessionMethod == null || (returnType = getThreadSessionMethod.getReturnType()) == null) {
                return null;
            }
            Class<?> cls = Integer.TYPE;
            return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method getThreadSessionMethod_delegate$lambda$7() {
        try {
            Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private final void internalBeginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Companion companion = Companion;
        if (companion.getBeginTransactionMethod() == null || companion.getGetThreadSessionMethod() == null) {
            if (sQLiteTransactionListener != null) {
                beginTransactionWithListener(sQLiteTransactionListener);
                return;
            } else {
                beginTransaction();
                return;
            }
        }
        Method beginTransactionMethod = companion.getBeginTransactionMethod();
        beginTransactionMethod.getClass();
        Method getThreadSessionMethod = companion.getGetThreadSessionMethod();
        getThreadSessionMethod.getClass();
        Object objInvoke = getThreadSessionMethod.invoke(this.delegate, null);
        if (objInvoke != null) {
            beginTransactionMethod.invoke(objInvoke, 0, sQLiteTransactionListener, 0, null);
        } else {
            androidx.window.layout.c.g("Required value was null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteCursor query$lambda$0(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        sQLiteQuery.getClass();
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor query$lambda$1(r rVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return (Cursor) rVar.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor query$lambda$2(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        sQLiteQuery.getClass();
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionReadOnly() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        internalBeginTransactionWithListenerReadOnly(null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        sQLiteTransactionListener.getClass();
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        sQLiteTransactionListener.getClass();
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        sQLiteTransactionListener.getClass();
        internalBeginTransactionWithListenerReadOnly(sQLiteTransactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String str) throws SQLException {
        str.getClass();
        SQLiteStatement sQLiteStatementCompileStatement = this.delegate.compileStatement(str);
        sQLiteStatementCompileStatement.getClass();
        return new FrameworkSQLiteStatement(sQLiteStatementCompileStatement);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String str, String str2, Object[] objArr) throws SQLException {
        str.getClass();
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str);
        if (str2 != null && str2.length() != 0) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = compileStatement(sb.toString());
        SimpleSQLiteQuery.Companion.bind(supportSQLiteStatementCompileStatement, objArr);
        return supportSQLiteStatementCompileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String str, Object[] objArr) throws SQLException {
        str.getClass();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, str, objArr);
        } else {
            a2.a.m(a3.a.f(i10, "execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: "));
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str, Object[] objArr) throws SQLException {
        str.getClass();
        objArr.getClass();
        this.delegate.execSQL(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String str, int i10, ContentValues contentValues) throws SQLException {
        str.getClass();
        contentValues.getClass();
        return this.delegate.insertWithOnConflict(str, null, contentValues, i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public final boolean isDelegate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        return l.a(this.delegate, sQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i10) {
        return this.delegate.needUpgrade(i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        Cursor cursorRawQueryWithFactory = this.delegate.rawQueryWithFactory(new a(new r() { // from class: androidx.sqlite.db.framework.b
            @Override // g7.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return FrameworkSQLiteDatabase.query$lambda$0(supportSQLiteQuery, (SQLiteDatabase) obj, (SQLiteCursorDriver) obj2, (String) obj3, (SQLiteQuery) obj4);
            }
        }, 1), supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null);
        cursorRawQueryWithFactory.getClass();
        return cursorRawQueryWithFactory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z9) {
        this.delegate.setForeignKeyConstraintsEnabled(z9);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        locale.getClass();
        this.delegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i10) {
        this.delegate.setMaxSqlCacheSize(i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j10) {
        this.delegate.setMaximumSize(j10);
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j10) {
        this.delegate.setPageSize(j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i10) {
        this.delegate.setVersion(i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) throws SQLException {
        str.getClass();
        contentValues.getClass();
        if (contentValues.size() == 0) {
            com.google.gson.internal.a.n("Empty values");
            return 0;
        }
        int size = contentValues.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(CONFLICT_VALUES[i10]);
        sb.append(str);
        sb.append(" SET ");
        int i11 = 0;
        for (String str3 : contentValues.keySet()) {
            sb.append(i11 > 0 ? "," : "");
            sb.append(str3);
            objArr2[i11] = contentValues.get(str3);
            sb.append("=?");
            i11++;
        }
        if (objArr != null) {
            for (int i12 = size; i12 < length; i12++) {
                objArr2[i12] = objArr[i12 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = compileStatement(sb.toString());
        SimpleSQLiteQuery.Companion.bind(supportSQLiteStatementCompileStatement, objArr2);
        return supportSQLiteStatementCompileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getBeginTransactionMethod() {
            return (Method) FrameworkSQLiteDatabase.beginTransactionMethod$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getGetThreadSessionMethod() {
            return (Method) FrameworkSQLiteDatabase.getThreadSessionMethod$delegate.getValue();
        }

        private Companion() {
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j10) {
        return this.delegate.yieldIfContendedSafely(j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str) throws SQLException {
        str.getClass();
        this.delegate.execSQL(str);
    }

    /* renamed from: setMaximumSize, reason: collision with other method in class */
    public void m223setMaximumSize(long j10) {
        this.delegate.setMaximumSize(j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str, Object[] objArr) {
        str.getClass();
        objArr.getClass();
        return query(new SimpleSQLiteQuery(str, objArr));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str) {
        str.getClass();
        return query(new SimpleSQLiteQuery(str));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        supportSQLiteQuery.getClass();
        SQLiteDatabase sQLiteDatabase = this.delegate;
        a aVar = new a(supportSQLiteQuery, 0);
        String sql = supportSQLiteQuery.getSql();
        String[] strArr = EMPTY_STRING_ARRAY;
        cancellationSignal.getClass();
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(aVar, sql, strArr, null, cancellationSignal);
        cursorRawQueryWithFactory.getClass();
        return cursorRawQueryWithFactory;
    }
}
