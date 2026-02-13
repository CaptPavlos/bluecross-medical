package androidx.sqlite.db.framework;

import a3.i0;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import com.google.android.gms.internal.measurement.a4;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import kotlin.jvm.internal.g;
import s6.f;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;
    private final SupportSQLiteOpenHelper.Callback callback;
    private final Context context;
    private final f lazyDelegate;
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class DBRefHolder {
        private FrameworkSQLiteDatabase db;

        public DBRefHolder(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }

        public final FrameworkSQLiteDatabase getDb() {
            return this.db;
        }

        public final void setDb(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z9, boolean z10) {
        context.getClass();
        callback.getClass();
        this.context = context;
        this.name = str;
        this.callback = callback;
        this.useNoBackupDirectory = z9;
        this.allowDataLossOnRecovery = z10;
        this.lazyDelegate = new m(new i0(this, 4));
    }

    private final OpenHelper getDelegate() {
        return (OpenHelper) this.lazyDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OpenHelper lazyDelegate$lambda$0(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        OpenHelper openHelper;
        if (frameworkSQLiteOpenHelper.name == null || !frameworkSQLiteOpenHelper.useNoBackupDirectory) {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.context, frameworkSQLiteOpenHelper.name, new DBRefHolder(null), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
        } else {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.context, new File(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(frameworkSQLiteOpenHelper.context), frameworkSQLiteOpenHelper.name).getAbsolutePath(), new DBRefHolder(null), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
        }
        openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.writeAheadLoggingEnabled);
        return openHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.name;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z9) {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().setWriteAheadLoggingEnabled(z9);
        }
        this.writeAheadLoggingEnabled = z9;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class OpenHelper extends SQLiteOpenHelper {
        public static final Companion Companion = new Companion(null);
        private final boolean allowDataLossOnRecovery;
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Context context;
        private final DBRefHolder dbRef;
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName, Throwable th) {
                super(th);
                callbackName.getClass();
                th.getClass();
                this.callbackName = callbackName;
                this.cause = th;
            }

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class CallbackName {
            private static final /* synthetic */ z6.a $ENTRIES;
            private static final /* synthetic */ CallbackName[] $VALUES;
            public static final CallbackName ON_CONFIGURE = new CallbackName("ON_CONFIGURE", 0);
            public static final CallbackName ON_CREATE = new CallbackName("ON_CREATE", 1);
            public static final CallbackName ON_UPGRADE = new CallbackName("ON_UPGRADE", 2);
            public static final CallbackName ON_DOWNGRADE = new CallbackName("ON_DOWNGRADE", 3);
            public static final CallbackName ON_OPEN = new CallbackName("ON_OPEN", 4);

            private static final /* synthetic */ CallbackName[] $values() {
                return new CallbackName[]{ON_CONFIGURE, ON_CREATE, ON_UPGRADE, ON_DOWNGRADE, ON_OPEN};
            }

            static {
                CallbackName[] callbackNameArr$values = $values();
                $VALUES = callbackNameArr$values;
                $ENTRIES = a4.m(callbackNameArr$values);
            }

            private CallbackName(String str, int i10) {
            }

            public static z6.a getEntries() {
                return $ENTRIES;
            }

            public static CallbackName valueOf(String str) {
                return (CallbackName) Enum.valueOf(CallbackName.class, str);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) $VALUES.clone();
            }
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CallbackName.values().length];
                try {
                    iArr[CallbackName.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallbackName.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CallbackName.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CallbackName.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CallbackName.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final DBRefHolder dBRefHolder, final SupportSQLiteOpenHelper.Callback callback, boolean z9) {
            String string;
            super(context, str, null, callback.version, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.c
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteOpenHelper.OpenHelper._init_$lambda$0(callback, dBRefHolder, sQLiteDatabase);
                }
            });
            context.getClass();
            dBRefHolder.getClass();
            callback.getClass();
            this.context = context;
            this.dbRef = dBRefHolder;
            this.callback = callback;
            this.allowDataLossOnRecovery = z9;
            if (str == null) {
                string = UUID.randomUUID().toString();
                string.getClass();
            } else {
                string = str;
            }
            this.lock = new ProcessLock(string, context.getCacheDir(), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback callback, DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
            Companion companion = Companion;
            sQLiteDatabase.getClass();
            callback.onCorruption(companion.getWrappedDb(dBRefHolder, sQLiteDatabase));
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean z9) {
            if (z9) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.getClass();
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = getReadableDatabase();
            readableDatabase.getClass();
            return readableDatabase;
        }

        private final SQLiteDatabase innerGetDatabase(boolean z9) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z10 = this.opened;
            if (databaseName != null && !z10 && (parentFile = this.context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w(FrameworkSQLiteOpenHelper.TAG, "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return getWritableOrReadableDatabase(z9);
            } catch (Throwable unused) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return getWritableOrReadableDatabase(z9);
                } catch (Throwable th) {
                    th = th;
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = (CallbackException) th;
                        Throwable cause = callbackException.getCause();
                        int i10 = WhenMappings.$EnumSwitchMapping$0[callbackException.getCallbackName().ordinal()];
                        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
                            throw cause;
                        }
                        if (i10 != 5) {
                            androidx.window.layout.c.b();
                            return null;
                        }
                        if (!(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                        th = cause;
                    }
                    if (!(th instanceof SQLiteException) || databaseName == null || !this.allowDataLossOnRecovery) {
                        throw th;
                    }
                    this.context.deleteDatabase(databaseName);
                    try {
                        return getWritableOrReadableDatabase(z9);
                    } catch (CallbackException e) {
                        throw e.getCause();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                ProcessLock.lock$default(this.lock, false, 1, null);
                super.close();
                this.dbRef.setDb(null);
                this.opened = false;
            } finally {
                this.lock.unlock();
            }
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        public final Context getContext() {
            return this.context;
        }

        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        public final SupportSQLiteDatabase getSupportDatabase(boolean z9) throws IOException {
            SupportSQLiteDatabase wrappedDb;
            try {
                this.lock.lock((this.opened || getDatabaseName() == null) ? false : true);
                this.migrated = false;
                SQLiteDatabase sQLiteDatabaseInnerGetDatabase = innerGetDatabase(z9);
                if (this.migrated) {
                    close();
                    wrappedDb = getSupportDatabase(z9);
                } else {
                    wrappedDb = getWrappedDb(sQLiteDatabaseInnerGetDatabase);
                }
                this.lock.unlock();
                return wrappedDb;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            return Companion.getWrappedDb(this.dbRef, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            if (!this.migrated && this.callback.version != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                this.callback.onConfigure(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            try {
                this.callback.onCreate(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            sQLiteDatabase.getClass();
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(sQLiteDatabase), i10, i11);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.getClass();
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            sQLiteDatabase.getClass();
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i10, i11);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final FrameworkSQLiteDatabase getWrappedDb(DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
                dBRefHolder.getClass();
                sQLiteDatabase.getClass();
                FrameworkSQLiteDatabase db = dBRefHolder.getDb();
                if (db != null && db.isDelegate(sQLiteDatabase)) {
                    return db;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
                dBRefHolder.setDb(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z9) {
        this(context, str, callback, z9, false, 16, null);
        context.getClass();
        callback.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        this(context, str, callback, false, false, 24, null);
        context.getClass();
        callback.getClass();
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z9, boolean z10, int i10, g gVar) {
        this(context, str, callback, (i10 & 8) != 0 ? false : z9, (i10 & 16) != 0 ? false : z10);
    }
}
