package androidx.room.support;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import g7.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import r7.w;
import r7.y;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> bindArgsCache;
    private final SupportSQLiteStatement delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final w queryCallbackScope;
    private final String sqlStatement;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorStatement$execute$1", f = "QueryInterceptorStatement.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorStatement$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements p {
        final /* synthetic */ List<Object> $argsCopy;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<? extends Object> list, w6.c cVar) {
            super(2, cVar);
            this.$argsCopy = list;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorStatement.this.new AnonymousClass1(this.$argsCopy, cVar);
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
            QueryInterceptorStatement.this.queryCallback.onQuery(QueryInterceptorStatement.this.sqlStatement, this.$argsCopy);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorStatement$executeInsert$1", f = "QueryInterceptorStatement.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorStatement$executeInsert$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01301 extends y6.i implements p {
        final /* synthetic */ List<Object> $argsCopy;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01301(List<? extends Object> list, w6.c cVar) {
            super(2, cVar);
            this.$argsCopy = list;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorStatement.this.new C01301(this.$argsCopy, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01301) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorStatement.this.queryCallback.onQuery(QueryInterceptorStatement.this.sqlStatement, this.$argsCopy);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorStatement$executeUpdateDelete$1", f = "QueryInterceptorStatement.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorStatement$executeUpdateDelete$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01311 extends y6.i implements p {
        final /* synthetic */ List<Object> $argsCopy;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01311(List<? extends Object> list, w6.c cVar) {
            super(2, cVar);
            this.$argsCopy = list;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorStatement.this.new C01311(this.$argsCopy, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01311) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorStatement.this.queryCallback.onQuery(QueryInterceptorStatement.this.sqlStatement, this.$argsCopy);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorStatement$simpleQueryForLong$1", f = "QueryInterceptorStatement.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorStatement$simpleQueryForLong$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01321 extends y6.i implements p {
        final /* synthetic */ List<Object> $argsCopy;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01321(List<? extends Object> list, w6.c cVar) {
            super(2, cVar);
            this.$argsCopy = list;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorStatement.this.new C01321(this.$argsCopy, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01321) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorStatement.this.queryCallback.onQuery(QueryInterceptorStatement.this.sqlStatement, this.$argsCopy);
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.QueryInterceptorStatement$simpleQueryForString$1", f = "QueryInterceptorStatement.android.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.QueryInterceptorStatement$simpleQueryForString$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01331 extends y6.i implements p {
        final /* synthetic */ List<Object> $argsCopy;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01331(List<? extends Object> list, w6.c cVar) {
            super(2, cVar);
            this.$argsCopy = list;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return QueryInterceptorStatement.this.new C01331(this.$argsCopy, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01331) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            QueryInterceptorStatement.this.queryCallback.onQuery(QueryInterceptorStatement.this.sqlStatement, this.$argsCopy);
            return s6.w.f12711a;
        }
    }

    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, String str, w wVar, RoomDatabase.QueryCallback queryCallback) {
        supportSQLiteStatement.getClass();
        str.getClass();
        wVar.getClass();
        queryCallback.getClass();
        this.delegate = supportSQLiteStatement;
        this.sqlStatement = str;
        this.queryCallbackScope = wVar;
        this.queryCallback = queryCallback;
        this.bindArgsCache = new ArrayList();
    }

    private final void saveArgsToCache(int i10, Object obj) {
        int i11 = i10 - 1;
        if (i11 >= this.bindArgsCache.size()) {
            int size = (i11 - this.bindArgsCache.size()) + 1;
            for (int i12 = 0; i12 < size; i12++) {
                this.bindArgsCache.add(null);
            }
        }
        this.bindArgsCache.set(i11, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i10, byte[] bArr) {
        bArr.getClass();
        saveArgsToCache(i10, bArr);
        this.delegate.bindBlob(i10, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i10, double d8) {
        saveArgsToCache(i10, Double.valueOf(d8));
        this.delegate.bindDouble(i10, d8);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i10, long j10) {
        saveArgsToCache(i10, Long.valueOf(j10));
        this.delegate.bindLong(i10, j10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i10) {
        saveArgsToCache(i10, null);
        this.delegate.bindNull(i10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i10, String str) {
        str.getClass();
        saveArgsToCache(i10, str);
        this.delegate.bindString(i10, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        y.q(this.queryCallbackScope, null, null, new AnonymousClass1(l.r0(this.bindArgsCache), null), 3);
        this.delegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        y.q(this.queryCallbackScope, null, null, new C01301(l.r0(this.bindArgsCache), null), 3);
        return this.delegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        y.q(this.queryCallbackScope, null, null, new C01311(l.r0(this.bindArgsCache), null), 3);
        return this.delegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        y.q(this.queryCallbackScope, null, null, new C01321(l.r0(this.bindArgsCache), null), 3);
        return this.delegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        y.q(this.queryCallbackScope, null, null, new C01331(l.r0(this.bindArgsCache), null), 3);
        return this.delegate.simpleQueryForString();
    }
}
