package androidx.room.coroutines;

import androidx.sqlite.SQLiteDriver;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ConnectionPoolKt {
    public static final ConnectionPool newConnectionPool(SQLiteDriver sQLiteDriver, String str, int i10, int i11) {
        sQLiteDriver.getClass();
        str.getClass();
        return new ConnectionPoolImpl(sQLiteDriver, str, i10, i11);
    }

    public static final ConnectionPool newSingleConnectionPool(SQLiteDriver sQLiteDriver, String str) {
        sQLiteDriver.getClass();
        str.getClass();
        return new ConnectionPoolImpl(sQLiteDriver, str);
    }
}
