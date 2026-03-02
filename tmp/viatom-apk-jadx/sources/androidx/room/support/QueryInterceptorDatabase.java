package androidx.room.support;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import g7.p;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import r7.w;
import r7.y;
import t6.j;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final w queryCallbackScope;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$beginTransaction$1", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$beginTransaction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements p {
        int label;

        public AnonymousClass1(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new AnonymousClass1(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", t.f12808a);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$beginTransactionNonExclusive$1", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$beginTransactionNonExclusive$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01221 extends y6.i implements p {
        int label;

        public C01221(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new C01221(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01221) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery("BEGIN IMMEDIATE TRANSACTION", t.f12808a);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$beginTransactionWithListener$1", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$beginTransactionWithListener$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01231 extends y6.i implements p {
        int label;

        public C01231(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new C01231(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01231) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", t.f12808a);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$beginTransactionWithListenerNonExclusive$1", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$beginTransactionWithListenerNonExclusive$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01241 extends y6.i implements p {
        int label;

        public C01241(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new C01241(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01241) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery("BEGIN IMMEDIATE TRANSACTION", t.f12808a);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$endTransaction$1", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$endTransaction$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01251 extends y6.i implements p {
        int label;

        public C01251(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new C01251(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01251) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery("END TRANSACTION", t.f12808a);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$execSQL$1", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$execSQL$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01261 extends y6.i implements p {
        final /* synthetic */ String $sql;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01261(String str, w6.c cVar) {
            super(2, cVar);
            this.$sql = str;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new C01261(this.$sql, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01261) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery(this.$sql, t.f12808a);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$execSQL$2", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$execSQL$2, reason: invalid class name */
    public static final class AnonymousClass2 extends y6.i implements p {
        final /* synthetic */ List<Object> $argsCopy;
        final /* synthetic */ String $sql;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, List<? extends Object> list, w6.c cVar) {
            super(2, cVar);
            this.$sql = str;
            this.$argsCopy = list;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new AnonymousClass2(this.$sql, this.$argsCopy, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery(this.$sql, this.$argsCopy);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$query$1", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$query$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01271 extends y6.i implements p {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01271(String str, w6.c cVar) {
            super(2, cVar);
            this.$query = str;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new C01271(this.$query, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01271) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery(this.$query, t.f12808a);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$query$2", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$query$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01282 extends y6.i implements p {
        final /* synthetic */ List<Object> $argsCopy;
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01282(String str, List<? extends Object> list, w6.c cVar) {
            super(2, cVar);
            this.$query = str;
            this.$argsCopy = list;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new C01282(this.$query, this.$argsCopy, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01282) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery(this.$query, this.$argsCopy);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$query$3", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$query$3, reason: invalid class name */
    public static final class AnonymousClass3 extends y6.i implements p {
        final /* synthetic */ SupportSQLiteQuery $query;
        final /* synthetic */ QueryInterceptorProgram $queryInterceptorProgram;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram, w6.c cVar) {
            super(2, cVar);
            this.$query = supportSQLiteQuery;
            this.$queryInterceptorProgram = queryInterceptorProgram;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new AnonymousClass3(this.$query, this.$queryInterceptorProgram, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass3) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery(this.$query.getSql(), this.$queryInterceptorProgram.getBindArgsCache$room_runtime_release());
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$query$4", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$query$4, reason: invalid class name */
    public static final class AnonymousClass4 extends y6.i implements p {
        final /* synthetic */ SupportSQLiteQuery $query;
        final /* synthetic */ QueryInterceptorProgram $queryInterceptorProgram;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram, w6.c cVar) {
            super(2, cVar);
            this.$query = supportSQLiteQuery;
            this.$queryInterceptorProgram = queryInterceptorProgram;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new AnonymousClass4(this.$query, this.$queryInterceptorProgram, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass4) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery(this.$query.getSql(), this.$queryInterceptorProgram.getBindArgsCache$room_runtime_release());
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorDatabase$setTransactionSuccessful$1", f = "QueryInterceptorDatabase.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorDatabase$setTransactionSuccessful$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01291 extends y6.i implements p {
        int label;

        public C01291(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorDatabase.this.new C01291(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01291) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorDatabase.this.queryCallback.onQuery("TRANSACTION SUCCESSFUL", t.f12808a);
            return s6.w.f12711a;
        }
    }

    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, w wVar, RoomDatabase.QueryCallback queryCallback) {
        supportSQLiteDatabase.getClass();
        wVar.getClass();
        queryCallback.getClass();
        this.delegate = supportSQLiteDatabase;
        this.queryCallbackScope = wVar;
        this.queryCallback = queryCallback;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        y.q(this.queryCallbackScope, null, null, new AnonymousClass1(null), 3);
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        y.q(this.queryCallbackScope, null, null, new C01221(null), 3);
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionReadOnly() {
        this.delegate.beginTransactionReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        sQLiteTransactionListener.getClass();
        y.q(this.queryCallbackScope, null, null, new C01231(null), 3);
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        sQLiteTransactionListener.getClass();
        y.q(this.queryCallbackScope, null, null, new C01241(null), 3);
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) {
        sQLiteTransactionListener.getClass();
        this.delegate.beginTransactionWithListenerReadOnly(sQLiteTransactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String str) {
        str.getClass();
        return new QueryInterceptorStatement(this.delegate.compileStatement(str), str, this.queryCallbackScope, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String str, String str2, Object[] objArr) {
        str.getClass();
        return this.delegate.delete(str, str2, objArr);
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
        y.q(this.queryCallbackScope, null, null, new C01251(null), 3);
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String str, @SuppressLint({"ArrayReturn"}) Object[] objArr) {
        str.getClass();
        this.delegate.execPerConnectionSQL(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str, Object[] objArr) throws SQLException {
        str.getClass();
        objArr.getClass();
        y.q(this.queryCallbackScope, null, null, new AnonymousClass2(str, j.y0(objArr), null), 3);
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
    public long insert(String str, int i10, ContentValues contentValues) {
        str.getClass();
        contentValues.getClass();
        return this.delegate.insert(str, i10, contentValues);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
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
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        y.q(this.queryCallbackScope, null, null, new AnonymousClass3(supportSQLiteQuery, queryInterceptorProgram, null), 3);
        return this.delegate.query(supportSQLiteQuery);
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
        return this.delegate.setMaximumSize(j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j10) {
        this.delegate.setPageSize(j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        y.q(this.queryCallbackScope, null, null, new C01291(null), 3);
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i10) {
        this.delegate.setVersion(i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) {
        str.getClass();
        contentValues.getClass();
        return this.delegate.update(str, i10, contentValues, str2, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j10) {
        return this.delegate.yieldIfContendedSafely(j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str) throws SQLException {
        str.getClass();
        y.q(this.queryCallbackScope, null, null, new C01261(str, null), 3);
        this.delegate.execSQL(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str, Object[] objArr) {
        str.getClass();
        objArr.getClass();
        y.q(this.queryCallbackScope, null, null, new C01282(str, j.y0(objArr), null), 3);
        return this.delegate.query(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str) {
        str.getClass();
        y.q(this.queryCallbackScope, null, null, new C01271(str, null), 3);
        return this.delegate.query(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        supportSQLiteQuery.getClass();
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        y.q(this.queryCallbackScope, null, null, new AnonymousClass4(supportSQLiteQuery, queryInterceptorProgram, null), 3);
        return this.delegate.query(supportSQLiteQuery);
    }
}
