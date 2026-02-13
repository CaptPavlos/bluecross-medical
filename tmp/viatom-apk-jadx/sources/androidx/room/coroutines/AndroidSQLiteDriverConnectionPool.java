package androidx.room.coroutines;

import a3.i0;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.driver.AndroidSQLiteConnection;
import g7.p;
import s6.f;
import s6.m;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class AndroidSQLiteDriverConnectionPool implements ConnectionPool {
    private final f androidConnection$delegate;
    private final SQLiteDriver driver;
    private final String fileName;

    public AndroidSQLiteDriverConnectionPool(SQLiteDriver sQLiteDriver, String str) {
        sQLiteDriver.getClass();
        str.getClass();
        this.driver = sQLiteDriver;
        this.fileName = str;
        this.androidConnection$delegate = new m(new i0(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AndroidSQLiteDriverPooledConnection androidConnection_delegate$lambda$0(AndroidSQLiteDriverConnectionPool androidSQLiteDriverConnectionPool) {
        SQLiteConnection sQLiteConnectionOpen = androidSQLiteDriverConnectionPool.driver.open(androidSQLiteDriverConnectionPool.fileName);
        sQLiteConnectionOpen.getClass();
        return new AndroidSQLiteDriverPooledConnection((AndroidSQLiteConnection) sQLiteConnectionOpen);
    }

    private final AndroidSQLiteDriverPooledConnection getAndroidConnection() {
        return (AndroidSQLiteDriverPooledConnection) this.androidConnection$delegate.getValue();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        getAndroidConnection().getDelegate().close();
    }

    @Override // androidx.room.coroutines.ConnectionPool
    public <R> Object useConnection(boolean z9, p pVar, c cVar) {
        return pVar.invoke(getAndroidConnection(), cVar);
    }
}
