package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class MigrationImpl extends Migration {
    private final l migrateCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationImpl(int i10, int i11, l lVar) {
        super(i10, i11);
        lVar.getClass();
        this.migrateCallback = lVar;
    }

    public final l getMigrateCallback() {
        return this.migrateCallback;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        this.migrateCallback.invoke(supportSQLiteDatabase);
    }
}
