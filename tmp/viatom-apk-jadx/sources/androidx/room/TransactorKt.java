package androidx.room;

import a3.q;
import androidx.room.Transactor;
import androidx.sqlite.SQLiteStatement;
import g7.p;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TransactorKt {
    public static final <R> Object deferredTransaction(Transactor transactor, p pVar, w6.c cVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.DEFERRED, pVar, cVar);
    }

    public static final <R> Object exclusiveTransaction(Transactor transactor, p pVar, w6.c cVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.EXCLUSIVE, pVar, cVar);
    }

    public static final Object execSQL(PooledConnection pooledConnection, String str, w6.c cVar) {
        Object objUsePrepared = pooledConnection.usePrepared(str, new q(2), cVar);
        return objUsePrepared == x6.a.f13718a ? objUsePrepared : w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean execSQL$lambda$0(SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        return sQLiteStatement.step();
    }

    public static final <R> Object immediateTransaction(Transactor transactor, p pVar, w6.c cVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.IMMEDIATE, pVar, cVar);
    }
}
