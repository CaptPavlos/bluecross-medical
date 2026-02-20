package androidx.room;

import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.google.android.gms.internal.measurement.a4;
import com.mbridge.msdk.MBridgeConstans;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import o7.u;
import s6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public static final Companion Companion = new Companion(null);
    private final List<RoomDatabase.Callback> callbacks;
    private DatabaseConfiguration configuration;
    private final Delegate delegate;
    private final String identityHash;
    private final String legacyHash;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {
        public final int version;

        public Delegate(int i10) {
            this.version = i10;
        }

        public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
            validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, null);
        }

        public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z9, String str) {
            this.isValid = z9;
            this.expectedFoundMsg = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String str, String str2) {
        super(delegate.version);
        databaseConfiguration.getClass();
        delegate.getClass();
        str.getClass();
        str2.getClass();
        this.callbacks = databaseConfiguration.callbacks;
        this.configuration = databaseConfiguration;
        this.delegate = delegate;
        this.identityHash = str;
        this.legacyHash = str2;
    }

    private final void checkIdentity(SupportSQLiteDatabase supportSQLiteDatabase) throws IOException, SQLException {
        if (!Companion.hasRoomMasterTable$room_runtime_release(supportSQLiteDatabase)) {
            ValidationResult validationResultOnValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (!validationResultOnValidateSchema.isValid) {
                com.google.gson.internal.a.l(validationResultOnValidateSchema.expectedFoundMsg, "Pre-packaged database has an invalid schema: ");
                return;
            } else {
                this.delegate.onPostMigrate(supportSQLiteDatabase);
                updateIdentity(supportSQLiteDatabase);
                return;
            }
        }
        Cursor cursorQuery = supportSQLiteDatabase.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
        try {
            String string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
            a4.j(cursorQuery, null);
            if (l.a(this.identityHash, string) || l.a(this.legacyHash, string)) {
                return;
            }
            androidx.window.layout.c.g(androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "), this.identityHash, ", found: ", string));
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a4.j(cursorQuery, th);
                throw th2;
            }
        }
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        super.onConfigure(supportSQLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) throws IOException, SQLException {
        supportSQLiteDatabase.getClass();
        boolean zHasEmptySchema$room_runtime_release = Companion.hasEmptySchema$room_runtime_release(supportSQLiteDatabase);
        this.delegate.createAllTables(supportSQLiteDatabase);
        if (!zHasEmptySchema$room_runtime_release) {
            ValidationResult validationResultOnValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (!validationResultOnValidateSchema.isValid) {
                com.google.gson.internal.a.l(validationResultOnValidateSchema.expectedFoundMsg, "Pre-packaged database has an invalid schema: ");
                return;
            }
        }
        updateIdentity(supportSQLiteDatabase);
        this.delegate.onCreate(supportSQLiteDatabase);
        List<RoomDatabase.Callback> list = this.callbacks;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onCreate(supportSQLiteDatabase);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i10, int i11) throws IOException, SQLException {
        supportSQLiteDatabase.getClass();
        onUpgrade(supportSQLiteDatabase, i10, i11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) throws IOException, SQLException {
        supportSQLiteDatabase.getClass();
        super.onOpen(supportSQLiteDatabase);
        checkIdentity(supportSQLiteDatabase);
        this.delegate.onOpen(supportSQLiteDatabase);
        List<RoomDatabase.Callback> list = this.callbacks;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onOpen(supportSQLiteDatabase);
            }
        }
        this.configuration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i10, int i11) throws IOException, SQLException {
        List<Migration> listFindMigrationPath;
        supportSQLiteDatabase.getClass();
        DatabaseConfiguration databaseConfiguration = this.configuration;
        if (databaseConfiguration != null && (listFindMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i10, i11)) != null) {
            this.delegate.onPreMigrate(supportSQLiteDatabase);
            Iterator<T> it = listFindMigrationPath.iterator();
            while (it.hasNext()) {
                ((Migration) it.next()).migrate(new SupportSQLiteConnection(supportSQLiteDatabase));
            }
            ValidationResult validationResultOnValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (!validationResultOnValidateSchema.isValid) {
                com.google.gson.internal.a.l(validationResultOnValidateSchema.expectedFoundMsg, "Migration didn't properly handle: ");
                return;
            } else {
                this.delegate.onPostMigrate(supportSQLiteDatabase);
                updateIdentity(supportSQLiteDatabase);
                return;
            }
        }
        DatabaseConfiguration databaseConfiguration2 = this.configuration;
        if (databaseConfiguration2 == null || databaseConfiguration2.isMigrationRequired(i10, i11)) {
            throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        if (databaseConfiguration2.allowDestructiveMigrationForAllTables) {
            Companion.dropAllTables$room_runtime_release(supportSQLiteDatabase);
        } else {
            this.delegate.dropAllTables(supportSQLiteDatabase);
        }
        List<RoomDatabase.Callback> list = this.callbacks;
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                ((RoomDatabase.Callback) it2.next()).onDestructiveMigration(supportSQLiteDatabase);
            }
        }
        this.delegate.createAllTables(supportSQLiteDatabase);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final void dropAllTables$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) throws IOException, SQLException {
            supportSQLiteDatabase.getClass();
            Cursor cursorQuery = supportSQLiteDatabase.query("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                u6.c cVarL = a4.l();
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    string.getClass();
                    if (!u.c0(string, "sqlite_", false) && !string.equals("android_metadata")) {
                        cVarL.add(new i(string, Boolean.valueOf(l.a(cursorQuery.getString(1), MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW))));
                    }
                }
                u6.c cVarH = a4.h(cVarL);
                cursorQuery.close();
                ListIterator listIterator = cVarH.listIterator(0);
                while (true) {
                    u6.a aVar = (u6.a) listIterator;
                    if (!aVar.hasNext()) {
                        return;
                    }
                    i iVar = (i) aVar.next();
                    String str = (String) iVar.f12693a;
                    if (((Boolean) iVar.f12694b).booleanValue()) {
                        supportSQLiteDatabase.execSQL("DROP VIEW IF EXISTS " + str);
                    } else {
                        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        }

        public final boolean hasEmptySchema$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) throws IOException {
            supportSQLiteDatabase.getClass();
            Cursor cursorQuery = supportSQLiteDatabase.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z9 = false;
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getInt(0) == 0) {
                        z9 = true;
                    }
                }
                a4.j(cursorQuery, null);
                return z9;
            } finally {
            }
        }

        public final boolean hasRoomMasterTable$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) throws IOException {
            supportSQLiteDatabase.getClass();
            Cursor cursorQuery = supportSQLiteDatabase.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z9 = false;
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getInt(0) != 0) {
                        z9 = true;
                    }
                }
                a4.j(cursorQuery, null);
                return z9;
            } finally {
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String str) {
        this(databaseConfiguration, delegate, "", str);
        databaseConfiguration.getClass();
        delegate.getClass();
        str.getClass();
    }
}
