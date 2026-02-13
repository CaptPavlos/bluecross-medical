package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import androidx.constraintlayout.core.widgets.analyzer.a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z9);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class Callback {
        public static final Companion Companion = new Companion(null);
        private static final String TAG = "SupportSQLite";
        public final int version;

        public Callback(int i10) {
            this.version = i10;
        }

        private final void deleteDatabaseFile(String str) {
            if (u.Z(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i10 = 0;
            boolean z9 = false;
            while (i10 <= length) {
                boolean z10 = l.c(str.charAt(!z9 ? i10 : length), 32) <= 0;
                if (z9) {
                    if (!z10) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z10) {
                    i10++;
                } else {
                    z9 = true;
                }
            }
            if (str.subSequence(i10, length + 1).toString().length() == 0) {
                return;
            }
            Log.w(TAG, "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e) {
                Log.w(TAG, "delete failed: ", e);
            }
        }

        public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
        }

        public void onCorruption(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
            Log.e(TAG, "Corruption reported by sqlite on database: " + supportSQLiteDatabase + ".path");
            if (!supportSQLiteDatabase.isOpen()) {
                String path = supportSQLiteDatabase.getPath();
                if (path != null) {
                    deleteDatabaseFile(path);
                    return;
                }
                return;
            }
            List<Pair<String, String>> attachedDbs = null;
            try {
                try {
                    attachedDbs = supportSQLiteDatabase.getAttachedDbs();
                } finally {
                    if (attachedDbs != null) {
                        Iterator<T> it = attachedDbs.iterator();
                        while (it.hasNext()) {
                            Object obj = ((Pair) it.next()).second;
                            obj.getClass();
                            deleteDatabaseFile((String) obj);
                        }
                    } else {
                        String path2 = supportSQLiteDatabase.getPath();
                        if (path2 != null) {
                            deleteDatabaseFile(path2);
                        }
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                supportSQLiteDatabase.close();
            } catch (IOException unused2) {
            }
            if (attachedDbs != null) {
                return;
            }
        }

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i10, int i11) {
            supportSQLiteDatabase.getClass();
            throw new SQLiteException(a.u(i10, i11, "Can't downgrade database from version ", " to "));
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.getClass();
        }

        public abstract void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i10, int i11);

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Configuration {
        public static final Companion Companion = new Companion(null);
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(Context context) {
                context.getClass();
                this.context = context;
            }

            public Builder allowDataLossOnRecovery(boolean z9) {
                this.allowDataLossOnRecovery = z9;
                return this;
            }

            public Configuration build() {
                String str;
                Callback callback = this.callback;
                if (callback == null) {
                    com.google.gson.internal.a.n("Must set a callback to create the configuration.");
                    return null;
                }
                if (!this.useNoBackupDirectory || ((str = this.name) != null && str.length() != 0)) {
                    return new Configuration(this.context, this.name, callback, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
                }
                com.google.gson.internal.a.n("Must set a non-null database name to a configuration that uses the no backup directory.");
                return null;
            }

            public Builder callback(Callback callback) {
                callback.getClass();
                this.callback = callback;
                return this;
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder noBackupDirectory(boolean z9) {
                this.useNoBackupDirectory = z9;
                return this;
            }
        }

        public /* synthetic */ Configuration(Context context, String str, Callback callback, boolean z9, boolean z10, int i10, g gVar) {
            this(context, str, callback, (i10 & 8) != 0 ? false : z9, (i10 & 16) != 0 ? false : z10);
        }

        public static final Builder builder(Context context) {
            return Companion.builder(context);
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final Builder builder(Context context) {
                context.getClass();
                return new Builder(context);
            }

            private Companion() {
            }
        }

        public Configuration(Context context, String str, Callback callback, boolean z9, boolean z10) {
            context.getClass();
            callback.getClass();
            this.context = context;
            this.name = str;
            this.callback = callback;
            this.useNoBackupDirectory = z9;
            this.allowDataLossOnRecovery = z10;
        }
    }
}
