package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.ExclusiveLock;
import androidx.room.migration.Migration;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import com.google.android.gms.internal.measurement.a4;
import com.mbridge.msdk.MBridgeConstans;
import g7.p;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import o7.u;
import r0.f;
import s6.i;
import s6.j;
import s6.k;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class BaseRoomConnectionManager {
    public static final int BUSY_TIMEOUT_MS = 3000;
    public static final Companion Companion = new Companion(null);
    private boolean isConfigured;
    private boolean isInitializing;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class DriverWrapper implements SQLiteDriver {
        private final SQLiteDriver actual;
        final /* synthetic */ BaseRoomConnectionManager this$0;

        public DriverWrapper(BaseRoomConnectionManager baseRoomConnectionManager, SQLiteDriver sQLiteDriver) {
            sQLiteDriver.getClass();
            this.this$0 = baseRoomConnectionManager;
            this.actual = sQLiteDriver;
        }

        private final SQLiteConnection openLocked(final String str) {
            return (SQLiteConnection) new ExclusiveLock(str, (this.this$0.isConfigured || this.this$0.isInitializing || l.a(str, ":memory:")) ? false : true).withLock(new b(this.this$0, this, str, 0), new g7.l() { // from class: androidx.room.BaseRoomConnectionManager$DriverWrapper$openLocked$2
                @Override // g7.l
                public final Void invoke(Throwable th) {
                    th.getClass();
                    throw new IllegalStateException(a3.a.o(new StringBuilder("Unable to open database '"), str, "'. Was a proper path / name used in Room's database builder?"), th);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SQLiteConnection openLocked$lambda$1(BaseRoomConnectionManager baseRoomConnectionManager, DriverWrapper driverWrapper, String str) {
            if (baseRoomConnectionManager.isInitializing) {
                androidx.window.layout.c.g("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
                return null;
            }
            SQLiteConnection sQLiteConnectionOpen = driverWrapper.actual.open(str);
            if (baseRoomConnectionManager.isConfigured) {
                baseRoomConnectionManager.configurationConnection(sQLiteConnectionOpen);
                return sQLiteConnectionOpen;
            }
            try {
                baseRoomConnectionManager.isInitializing = true;
                baseRoomConnectionManager.configureDatabase(sQLiteConnectionOpen);
                return sQLiteConnectionOpen;
            } finally {
                baseRoomConnectionManager.isInitializing = false;
            }
        }

        @Override // androidx.sqlite.SQLiteDriver
        public SQLiteConnection open(String str) {
            str.getClass();
            return openLocked(this.this$0.resolveFileName$room_runtime_release(str));
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.TRUNCATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void checkIdentity(SQLiteConnection sQLiteConnection) throws Throwable {
        Object jVar;
        RoomOpenDelegate.ValidationResult validationResultOnValidateSchema;
        if (hasRoomMasterTable(sQLiteConnection)) {
            SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(RoomMasterTable.READ_QUERY);
            try {
                String text = sQLiteStatementPrepare.step() ? sQLiteStatementPrepare.getText(0) : null;
                f.p(sQLiteStatementPrepare, null);
                if (l.a(getOpenDelegate().getIdentityHash(), text) || l.a(getOpenDelegate().getLegacyIdentityHash(), text)) {
                    return;
                }
                throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + getOpenDelegate().getIdentityHash() + ", found: " + text).toString());
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    f.p(sQLiteStatementPrepare, th);
                    throw th2;
                }
            }
        }
        SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            validationResultOnValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
        } catch (Throwable th3) {
            jVar = new j(th3);
        }
        if (!validationResultOnValidateSchema.isValid) {
            throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg).toString());
        }
        getOpenDelegate().onPostMigrate(sQLiteConnection);
        updateIdentity(sQLiteConnection);
        jVar = w.f12711a;
        if (!(jVar instanceof j)) {
            SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
        }
        Throwable thA = k.a(jVar);
        if (thA == null) {
            return;
        }
        SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
        throw thA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configurationConnection(SQLiteConnection sQLiteConnection) {
        configureSynchronousFlag(sQLiteConnection);
        configureBusyTimeout(sQLiteConnection);
        getOpenDelegate().onOpen(sQLiteConnection);
    }

    private final void configureBusyTimeout(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA busy_timeout");
        try {
            sQLiteStatementPrepare.step();
            long j10 = sQLiteStatementPrepare.getLong(0);
            f.p(sQLiteStatementPrepare, null);
            if (j10 < 3000) {
                SQLite.execSQL(sQLiteConnection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.p(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureDatabase(SQLiteConnection sQLiteConnection) throws Throwable {
        Object jVar;
        configureJournalMode(sQLiteConnection);
        configureSynchronousFlag(sQLiteConnection);
        configureBusyTimeout(sQLiteConnection);
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("PRAGMA user_version");
        try {
            sQLiteStatementPrepare.step();
            int i10 = (int) sQLiteStatementPrepare.getLong(0);
            f.p(sQLiteStatementPrepare, null);
            if (i10 != getOpenDelegate().getVersion()) {
                SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    if (i10 == 0) {
                        onCreate(sQLiteConnection);
                    } else {
                        onMigrate(sQLiteConnection, i10, getOpenDelegate().getVersion());
                    }
                    SQLite.execSQL(sQLiteConnection, "PRAGMA user_version = " + getOpenDelegate().getVersion());
                    jVar = w.f12711a;
                } catch (Throwable th) {
                    jVar = new j(th);
                }
                if (!(jVar instanceof j)) {
                    SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
                }
                Throwable thA = k.a(jVar);
                if (thA != null) {
                    SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
                    throw thA;
                }
            }
            onOpen(sQLiteConnection);
        } finally {
        }
    }

    private final void configureJournalMode(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void configureSynchronousFlag(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = FULL");
        }
    }

    private final void createMasterTableIfNotExists(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
    }

    private final void dropAllTables(SQLiteConnection sQLiteConnection) {
        if (!getConfiguration().allowDestructiveMigrationForAllTables) {
            getOpenDelegate().dropAllTables(sQLiteConnection);
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
        try {
            u6.c cVarL = a4.l();
            while (sQLiteStatementPrepare.step()) {
                String text = sQLiteStatementPrepare.getText(0);
                if (!u.c0(text, "sqlite_", false) && !text.equals("android_metadata")) {
                    cVarL.add(new i(text, Boolean.valueOf(l.a(sQLiteStatementPrepare.getText(1), MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW))));
                }
            }
            u6.c cVarH = a4.h(cVarL);
            f.p(sQLiteStatementPrepare, null);
            ListIterator listIterator = cVarH.listIterator(0);
            while (true) {
                u6.a aVar = (u6.a) listIterator;
                if (!aVar.hasNext()) {
                    return;
                }
                i iVar = (i) aVar.next();
                String str = (String) iVar.f12693a;
                if (((Boolean) iVar.f12694b).booleanValue()) {
                    SQLite.execSQL(sQLiteConnection, "DROP VIEW IF EXISTS " + str);
                } else {
                    SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS " + str);
                }
            }
        } finally {
        }
    }

    private final boolean hasEmptySchema(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z9 = false;
            if (sQLiteStatementPrepare.step()) {
                if (sQLiteStatementPrepare.getLong(0) == 0) {
                    z9 = true;
                }
            }
            f.p(sQLiteStatementPrepare, null);
            return z9;
        } finally {
        }
    }

    private final boolean hasRoomMasterTable(SQLiteConnection sQLiteConnection) {
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z9 = false;
            if (sQLiteStatementPrepare.step()) {
                if (sQLiteStatementPrepare.getLong(0) != 0) {
                    z9 = true;
                }
            }
            f.p(sQLiteStatementPrepare, null);
            return z9;
        } finally {
        }
    }

    private final void invokeCreateCallback(SQLiteConnection sQLiteConnection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onCreate(sQLiteConnection);
        }
    }

    private final void invokeDestructiveMigrationCallback(SQLiteConnection sQLiteConnection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onDestructiveMigration(sQLiteConnection);
        }
    }

    private final void invokeOpenCallback(SQLiteConnection sQLiteConnection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onOpen(sQLiteConnection);
        }
    }

    private final void updateIdentity(SQLiteConnection sQLiteConnection) {
        createMasterTableIfNotExists(sQLiteConnection);
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.createInsertQuery(getOpenDelegate().getIdentityHash()));
    }

    public abstract List<RoomDatabase.Callback> getCallbacks();

    public abstract DatabaseConfiguration getConfiguration();

    public final int getMaxNumberOfReaders(RoomDatabase.JournalMode journalMode) {
        journalMode.getClass();
        int i10 = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
    }

    public final int getMaxNumberOfWriters(RoomDatabase.JournalMode journalMode) {
        journalMode.getClass();
        int i10 = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    public abstract RoomOpenDelegate getOpenDelegate();

    public final void onCreate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        boolean zHasEmptySchema = hasEmptySchema(sQLiteConnection);
        getOpenDelegate().createAllTables(sQLiteConnection);
        if (!zHasEmptySchema) {
            RoomOpenDelegate.ValidationResult validationResultOnValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
            if (!validationResultOnValidateSchema.isValid) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg).toString());
            }
        }
        updateIdentity(sQLiteConnection);
        getOpenDelegate().onCreate(sQLiteConnection);
        invokeCreateCallback(sQLiteConnection);
    }

    public final void onMigrate(SQLiteConnection sQLiteConnection, int i10, int i11) {
        sQLiteConnection.getClass();
        List<Migration> listFindMigrationPath = MigrationUtil.findMigrationPath(getConfiguration().migrationContainer, i10, i11);
        if (listFindMigrationPath == null) {
            if (!MigrationUtil.isMigrationRequired(getConfiguration(), i10, i11)) {
                dropAllTables(sQLiteConnection);
                invokeDestructiveMigrationCallback(sQLiteConnection);
                getOpenDelegate().createAllTables(sQLiteConnection);
                return;
            } else {
                throw new IllegalStateException(("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
            }
        }
        getOpenDelegate().onPreMigrate(sQLiteConnection);
        Iterator<T> it = listFindMigrationPath.iterator();
        while (it.hasNext()) {
            ((Migration) it.next()).migrate(sQLiteConnection);
        }
        RoomOpenDelegate.ValidationResult validationResultOnValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
        if (validationResultOnValidateSchema.isValid) {
            getOpenDelegate().onPostMigrate(sQLiteConnection);
            updateIdentity(sQLiteConnection);
        } else {
            throw new IllegalStateException(("Migration didn't properly handle: " + validationResultOnValidateSchema.expectedFoundMsg).toString());
        }
    }

    public final void onOpen(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        checkIdentity(sQLiteConnection);
        getOpenDelegate().onOpen(sQLiteConnection);
        invokeOpenCallback(sQLiteConnection);
        this.isConfigured = true;
    }

    public String resolveFileName$room_runtime_release(String str) {
        str.getClass();
        return str;
    }

    public abstract <R> Object useConnection(boolean z9, p pVar, w6.c cVar);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }
}
