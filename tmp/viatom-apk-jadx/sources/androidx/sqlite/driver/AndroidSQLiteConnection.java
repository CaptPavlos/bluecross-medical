package androidx.sqlite.driver;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class AndroidSQLiteConnection implements SQLiteConnection {
    private final SQLiteDatabase db;

    public AndroidSQLiteConnection(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        this.db = sQLiteDatabase;
    }

    @Override // androidx.sqlite.SQLiteConnection, java.lang.AutoCloseable
    public void close() {
        this.db.close();
    }

    public final SQLiteDatabase getDb() {
        return this.db;
    }

    @Override // androidx.sqlite.SQLiteConnection
    public SQLiteStatement prepare(String str) {
        str.getClass();
        if (this.db.isOpen()) {
            return AndroidSQLiteStatement.Companion.create(this.db, str);
        }
        throw androidx.constraintlayout.core.widgets.analyzer.a.p(21, "connection is closed");
    }
}
