package androidx.room.driver;

import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.coroutines.ConnectionPool;
import androidx.room.coroutines.RawConnectionAccessor;
import androidx.sqlite.SQLiteConnection;
import g7.l;
import g7.p;
import r0.f;
import w6.c;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class SupportSQLitePooledConnection implements Transactor, RawConnectionAccessor {
    private Transactor.SQLiteTransactionType currentTransactionType;
    private final SupportSQLiteConnection delegate;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class SupportSQLiteTransactor<T> implements TransactionScope<T>, RawConnectionAccessor {
        public SupportSQLiteTransactor() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection getRawConnection() {
            return SupportSQLitePooledConnection.this.getRawConnection();
        }

        @Override // androidx.room.TransactionScope
        public Object rollback(T t, c cVar) throws ConnectionPool.RollbackException {
            throw new ConnectionPool.RollbackException(t);
        }

        @Override // androidx.room.PooledConnection
        public <R> Object usePrepared(String str, l lVar, c cVar) {
            return SupportSQLitePooledConnection.this.usePrepared(str, lVar, cVar);
        }

        @Override // androidx.room.TransactionScope
        public <R> Object withNestedTransaction(p pVar, c cVar) {
            SupportSQLitePooledConnection supportSQLitePooledConnection = SupportSQLitePooledConnection.this;
            Transactor.SQLiteTransactionType sQLiteTransactionType = supportSQLitePooledConnection.currentTransactionType;
            if (sQLiteTransactionType != null) {
                return supportSQLitePooledConnection.transaction(sQLiteTransactionType, pVar, cVar);
            }
            androidx.window.layout.c.g("Required value was null.");
            return null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.driver.SupportSQLitePooledConnection", f = "SupportSQLiteConnectionPool.android.kt", l = {83}, m = "transaction")
    /* renamed from: androidx.room.driver.SupportSQLitePooledConnection$transaction$1, reason: invalid class name */
    public static final class AnonymousClass1<R> extends y6.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SupportSQLitePooledConnection.this.transaction(null, null, this);
        }
    }

    public SupportSQLitePooledConnection(SupportSQLiteConnection supportSQLiteConnection) {
        supportSQLiteConnection.getClass();
        this.delegate = supportSQLiteConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <R> java.lang.Object transaction(androidx.room.Transactor.SQLiteTransactionType r5, g7.p r6, w6.c r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.room.driver.SupportSQLitePooledConnection.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.driver.SupportSQLitePooledConnection$transaction$1 r0 = (androidx.room.driver.SupportSQLitePooledConnection.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.driver.SupportSQLitePooledConnection$transaction$1 r0 = new androidx.room.driver.SupportSQLitePooledConnection$transaction$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L3b
            if (r1 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            androidx.sqlite.db.SupportSQLiteDatabase r5 = (androidx.sqlite.db.SupportSQLiteDatabase) r5
            java.lang.Object r6 = r0.L$0
            androidx.room.driver.SupportSQLitePooledConnection r6 = (androidx.room.driver.SupportSQLitePooledConnection) r6
            s6.a.e(r7)     // Catch: java.lang.Throwable -> L2e androidx.room.coroutines.ConnectionPool.RollbackException -> L31
            goto L83
        L2e:
            r7 = move-exception
            goto Lad
        L31:
            r7 = move-exception
            goto L9d
        L34:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
        L39:
            r5 = 0
            return r5
        L3b:
            s6.a.e(r7)
            androidx.room.driver.SupportSQLiteConnection r7 = r4.delegate
            androidx.sqlite.db.SupportSQLiteDatabase r7 = r7.getDb()
            boolean r1 = r7.inTransaction()
            if (r1 != 0) goto L4c
            r4.currentTransactionType = r5
        L4c:
            int[] r1 = androidx.room.driver.SupportSQLitePooledConnection.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r1[r5]
            if (r5 == r3) goto L68
            r1 = 2
            if (r5 == r1) goto L64
            r1 = 3
            if (r5 != r1) goto L60
            r7.beginTransaction()
            goto L6b
        L60:
            androidx.window.layout.c.b()
            goto L39
        L64:
            r7.beginTransactionNonExclusive()
            goto L6b
        L68:
            r7.beginTransactionReadOnly()
        L6b:
            androidx.room.driver.SupportSQLitePooledConnection$SupportSQLiteTransactor r5 = new androidx.room.driver.SupportSQLitePooledConnection$SupportSQLiteTransactor     // Catch: java.lang.Throwable -> L92 androidx.room.coroutines.ConnectionPool.RollbackException -> L98
            r5.<init>()     // Catch: java.lang.Throwable -> L92 androidx.room.coroutines.ConnectionPool.RollbackException -> L98
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L92 androidx.room.coroutines.ConnectionPool.RollbackException -> L98
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L92 androidx.room.coroutines.ConnectionPool.RollbackException -> L98
            r0.label = r3     // Catch: java.lang.Throwable -> L92 androidx.room.coroutines.ConnectionPool.RollbackException -> L98
            java.lang.Object r5 = r6.invoke(r5, r0)     // Catch: java.lang.Throwable -> L92 androidx.room.coroutines.ConnectionPool.RollbackException -> L98
            x6.a r6 = x6.a.f13718a
            if (r5 != r6) goto L7f
            return r6
        L7f:
            r6 = r7
            r7 = r5
            r5 = r6
            r6 = r4
        L83:
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2e androidx.room.coroutines.ConnectionPool.RollbackException -> L31
            r5.endTransaction()
            boolean r5 = r5.inTransaction()
            if (r5 != 0) goto L91
            r6.currentTransactionType = r2
        L91:
            return r7
        L92:
            r5 = move-exception
            r6 = r7
            r7 = r5
            r5 = r6
            r6 = r4
            goto Lad
        L98:
            r5 = move-exception
            r6 = r7
            r7 = r5
            r5 = r6
            r6 = r4
        L9d:
            java.lang.Object r7 = r7.getResult()     // Catch: java.lang.Throwable -> L2e
            r5.endTransaction()
            boolean r5 = r5.inTransaction()
            if (r5 != 0) goto Lac
            r6.currentTransactionType = r2
        Lac:
            return r7
        Lad:
            r5.endTransaction()
            boolean r5 = r5.inTransaction()
            if (r5 != 0) goto Lb8
            r6.currentTransactionType = r2
        Lb8:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.driver.SupportSQLitePooledConnection.transaction(androidx.room.Transactor$SQLiteTransactionType, g7.p, w6.c):java.lang.Object");
    }

    public final SupportSQLiteConnection getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    @Override // androidx.room.Transactor
    public Object inTransaction(c cVar) {
        return Boolean.valueOf(this.delegate.getDb().inTransaction());
    }

    @Override // androidx.room.PooledConnection
    public <R> Object usePrepared(String str, l lVar, c cVar) {
        SupportSQLiteStatement supportSQLiteStatementPrepare = this.delegate.prepare(str);
        try {
            Object objInvoke = lVar.invoke(supportSQLiteStatementPrepare);
            f.p(supportSQLiteStatementPrepare, null);
            return objInvoke;
        } finally {
        }
    }

    @Override // androidx.room.Transactor
    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, p pVar, c cVar) {
        return transaction(sQLiteTransactionType, pVar, cVar);
    }
}
