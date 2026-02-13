package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.Clock;
import androidx.work.Data;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@TypeConverters({Data.class, WorkTypeConverters.class})
@Database(autoMigrations = {@AutoMigration(from = 13, to = 14), @AutoMigration(from = 14, spec = AutoMigration_14_15.class, to = 15), @AutoMigration(from = 16, to = 17), @AutoMigration(from = 17, to = 18), @AutoMigration(from = 18, to = 19), @AutoMigration(from = 19, spec = AutoMigration_19_20.class, to = 20), @AutoMigration(from = 20, to = 21), @AutoMigration(from = 22, to = 23), @AutoMigration(from = 23, to = 24)}, entities = {Dependency.class, WorkSpec.class, WorkTag.class, SystemIdInfo.class, WorkName.class, WorkProgress.class, Preference.class}, version = 24)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion(null);

    public static final WorkDatabase create(Context context, Executor executor, Clock clock, boolean z9) {
        return Companion.create(context, executor, clock, z9);
    }

    public abstract DependencyDao dependencyDao();

    public abstract PreferenceDao preferenceDao();

    public abstract RawWorkInfoDao rawWorkInfoDao();

    public abstract SystemIdInfoDao systemIdInfoDao();

    public abstract WorkNameDao workNameDao();

    public abstract WorkProgressDao workProgressDao();

    public abstract WorkSpecDao workSpecDao();

    public abstract WorkTagDao workTagDao();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SupportSQLiteOpenHelper create$lambda$0(Context context, SupportSQLiteOpenHelper.Configuration configuration) {
            configuration.getClass();
            SupportSQLiteOpenHelper.Configuration.Builder builder = SupportSQLiteOpenHelper.Configuration.Companion.builder(context);
            builder.name(configuration.name).callback(configuration.callback).noBackupDirectory(true).allowDataLossOnRecovery(true);
            return new FrameworkSQLiteOpenHelperFactory().create(builder.build());
        }

        public final WorkDatabase create(Context context, Executor executor, Clock clock, boolean z9) {
            context.getClass();
            executor.getClass();
            clock.getClass();
            return (WorkDatabase) (z9 ? Room.inMemoryDatabaseBuilder(context, WorkDatabase.class).allowMainThreadQueries() : Room.databaseBuilder(context, WorkDatabase.class, WorkDatabasePathHelperKt.WORK_DATABASE_NAME).openHelperFactory(new androidx.core.view.inputmethod.a(context, 1))).setQueryExecutor(executor).addCallback(new CleanupCallback(clock)).addMigrations(Migration_1_2.INSTANCE).addMigrations(new RescheduleMigration(context, 2, 3)).addMigrations(Migration_3_4.INSTANCE).addMigrations(Migration_4_5.INSTANCE).addMigrations(new RescheduleMigration(context, 5, 6)).addMigrations(Migration_6_7.INSTANCE).addMigrations(Migration_7_8.INSTANCE).addMigrations(Migration_8_9.INSTANCE).addMigrations(new WorkMigration9To10(context)).addMigrations(new RescheduleMigration(context, 10, 11)).addMigrations(Migration_11_12.INSTANCE).addMigrations(Migration_12_13.INSTANCE).addMigrations(Migration_15_16.INSTANCE).addMigrations(Migration_16_17.INSTANCE).addMigrations(new RescheduleMigration(context, 21, 22)).fallbackToDestructiveMigration(true).build();
        }

        private Companion() {
        }
    }
}
