package androidx.work.impl;

import android.database.SQLException;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class AutoMigration_19_20 implements AutoMigrationSpec {
    @Override // androidx.room.migration.AutoMigrationSpec
    public final void onPostMigrate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        if (sQLiteConnection instanceof SupportSQLiteConnection) {
            onPostMigrate(((SupportSQLiteConnection) sQLiteConnection).getDb());
        }
    }

    @Override // androidx.room.migration.AutoMigrationSpec
    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
        supportSQLiteDatabase.getClass();
        supportSQLiteDatabase.execSQL("UPDATE WorkSpec SET `last_enqueue_time` = -1 WHERE `last_enqueue_time` = 0");
    }
}
