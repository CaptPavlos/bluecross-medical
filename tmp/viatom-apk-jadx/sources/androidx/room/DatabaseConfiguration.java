package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import t6.t;
import w6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationForAllTables;
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;
    public final boolean multiInstanceInvalidation;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final h queryCoroutineContext;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SQLiteDriver sqliteDriver;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;
    private boolean useTempTrackingTable;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3, boolean z12, SQLiteDriver sQLiteDriver, h hVar) {
        context.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z9;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.requireMigration = z10;
        this.allowDestructiveMigrationOnDowngrade = z11;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = list2;
        this.autoMigrationSpecs = list3;
        this.allowDestructiveMigrationForAllTables = z12;
        this.sqliteDriver = sQLiteDriver;
        this.queryCoroutineContext = hVar;
        this.multiInstanceInvalidation = intent != null;
        this.useTempTrackingTable = true;
    }

    public static /* synthetic */ DatabaseConfiguration copy$default(DatabaseConfiguration databaseConfiguration, Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set set, String str2, File file, Callable callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List list2, List list3, boolean z12, SQLiteDriver sQLiteDriver, h hVar, int i10, Object obj) {
        h hVar2;
        SQLiteDriver sQLiteDriver2;
        if (obj != null) {
            a2.a.m("Super calls with default arguments not supported in this target, function: copy");
            return null;
        }
        Context context2 = (i10 & 1) != 0 ? databaseConfiguration.context : context;
        String str3 = (i10 & 2) != 0 ? databaseConfiguration.name : str;
        SupportSQLiteOpenHelper.Factory factory2 = (i10 & 4) != 0 ? databaseConfiguration.sqliteOpenHelperFactory : factory;
        RoomDatabase.MigrationContainer migrationContainer2 = (i10 & 8) != 0 ? databaseConfiguration.migrationContainer : migrationContainer;
        List list4 = (i10 & 16) != 0 ? databaseConfiguration.callbacks : list;
        boolean z13 = (i10 & 32) != 0 ? databaseConfiguration.allowMainThreadQueries : z9;
        RoomDatabase.JournalMode journalMode2 = (i10 & 64) != 0 ? databaseConfiguration.journalMode : journalMode;
        Executor executor3 = (i10 & 128) != 0 ? databaseConfiguration.queryExecutor : executor;
        Executor executor4 = (i10 & 256) != 0 ? databaseConfiguration.transactionExecutor : executor2;
        Intent intent2 = (i10 & 512) != 0 ? databaseConfiguration.multiInstanceInvalidationServiceIntent : intent;
        boolean z14 = (i10 & 1024) != 0 ? databaseConfiguration.requireMigration : z10;
        boolean z15 = (i10 & 2048) != 0 ? databaseConfiguration.allowDestructiveMigrationOnDowngrade : z11;
        Set set2 = (i10 & 4096) != 0 ? databaseConfiguration.migrationNotRequiredFrom : set;
        String str4 = (i10 & 8192) != 0 ? databaseConfiguration.copyFromAssetPath : str2;
        Context context3 = context2;
        File file2 = (i10 & 16384) != 0 ? databaseConfiguration.copyFromFile : file;
        Callable callable2 = (i10 & 32768) != 0 ? databaseConfiguration.copyFromInputStream : callable;
        RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2 = (i10 & 65536) != 0 ? databaseConfiguration.prepackagedDatabaseCallback : prepackagedDatabaseCallback;
        List list5 = (i10 & 131072) != 0 ? databaseConfiguration.typeConverters : list2;
        List list6 = (i10 & 262144) != 0 ? databaseConfiguration.autoMigrationSpecs : list3;
        boolean z16 = (i10 & 524288) != 0 ? databaseConfiguration.allowDestructiveMigrationForAllTables : z12;
        SQLiteDriver sQLiteDriver3 = (i10 & 1048576) != 0 ? databaseConfiguration.sqliteDriver : sQLiteDriver;
        if ((i10 & 2097152) != 0) {
            sQLiteDriver2 = sQLiteDriver3;
            hVar2 = databaseConfiguration.queryCoroutineContext;
        } else {
            hVar2 = hVar;
            sQLiteDriver2 = sQLiteDriver3;
        }
        return databaseConfiguration.copy(context3, str3, factory2, migrationContainer2, list4, z13, journalMode2, executor3, executor4, intent2, z14, z15, set2, str4, file2, callable2, prepackagedDatabaseCallback2, list5, list6, z16, sQLiteDriver2, hVar2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final DatabaseConfiguration copy(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3, boolean z12, SQLiteDriver sQLiteDriver, h hVar) {
        context.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
        return new DatabaseConfiguration(context, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent, z10, z11, set, str2, file, callable, prepackagedDatabaseCallback, list2, list3, z12, sQLiteDriver, hVar);
    }

    public final Set<Integer> getMigrationNotRequiredFrom$room_runtime_release() {
        return this.migrationNotRequiredFrom;
    }

    public final boolean getUseTempTrackingTable$room_runtime_release() {
        return this.useTempTrackingTable;
    }

    public boolean isMigrationRequired(int i10, int i11) {
        return MigrationUtil.isMigrationRequired(this, i10, i11);
    }

    public boolean isMigrationRequiredFrom(int i10) {
        return isMigrationRequired(i10, i10 + 1);
    }

    public final void setUseTempTrackingTable$room_runtime_release(boolean z9) {
        this.useTempTrackingTable = z9;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, boolean z10, Set<Integer> set) {
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        t tVar = t.f12808a;
        this(context, str, factory, migrationContainer, list, z9, journalMode, executor, executor, null, z10, false, set, null, null, null, null, tVar, tVar, false, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z10, boolean z11, boolean z12, Set<Integer> set) {
        Context context2;
        Intent intent;
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        if (z10) {
            context2 = context;
            intent = new Intent(context2, (Class<?>) MultiInstanceInvalidationService.class);
        } else {
            context2 = context;
            intent = null;
        }
        Intent intent2 = intent;
        t tVar = t.f12808a;
        this(context2, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent2, z11, z12, set, null, null, null, null, tVar, tVar, false, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z10, boolean z11, boolean z12, Set<Integer> set, String str2, File file) {
        Context context2;
        Intent intent;
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        if (z10) {
            context2 = context;
            intent = new Intent(context2, (Class<?>) MultiInstanceInvalidationService.class);
        } else {
            context2 = context;
            intent = null;
        }
        Intent intent2 = intent;
        t tVar = t.f12808a;
        this(context2, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent2, z11, z12, set, str2, file, null, null, tVar, tVar, false, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z10, boolean z11, boolean z12, Set<Integer> set, String str2, File file, Callable<InputStream> callable) {
        Context context2;
        Intent intent;
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        if (z10) {
            context2 = context;
            intent = new Intent(context2, (Class<?>) MultiInstanceInvalidationService.class);
        } else {
            context2 = context;
            intent = null;
        }
        Intent intent2 = intent;
        t tVar = t.f12808a;
        this(context2, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent2, z11, z12, set, str2, file, callable, null, tVar, tVar, false, null, null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z10, boolean z11, boolean z12, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        Context context2;
        Intent intent;
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        if (z10) {
            context2 = context;
            intent = new Intent(context2, (Class<?>) MultiInstanceInvalidationService.class);
        } else {
            context2 = context;
            intent = null;
        }
        Intent intent2 = intent;
        t tVar = t.f12808a;
        this(context2, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent2, z11, z12, set, str2, file, callable, prepackagedDatabaseCallback, tVar, tVar, false, null, null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z10, boolean z11, boolean z12, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2) {
        Context context2;
        Intent intent;
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        if (z10) {
            context2 = context;
            intent = new Intent(context2, (Class<?>) MultiInstanceInvalidationService.class);
        } else {
            context2 = context;
            intent = null;
        }
        this(context2, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent, z11, z12, set, str2, file, callable, prepackagedDatabaseCallback, list2, t.f12808a, false, null, null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z10, boolean z11, boolean z12, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3) {
        Context context2;
        Intent intent;
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
        if (z10) {
            context2 = context;
            intent = new Intent(context2, (Class<?>) MultiInstanceInvalidationService.class);
        } else {
            context2 = context;
            intent = null;
        }
        this(context2, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent, z11, z12, set, str2, file, callable, null, list2, list3, false, null, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3) {
        this(context, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent, z10, z11, set, str2, file, callable, null, list2, list3, false, null, null);
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z9, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3, boolean z12) {
        this(context, str, factory, migrationContainer, list, z9, journalMode, executor, executor2, intent, z10, z11, set, str2, file, callable, null, list2, list3, z12, null, null);
        context.getClass();
        factory.getClass();
        migrationContainer.getClass();
        journalMode.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
    }
}
