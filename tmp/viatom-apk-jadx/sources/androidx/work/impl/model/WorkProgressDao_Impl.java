package androidx.work.impl.model;

import a3.q;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.work.Data;
import java.util.List;
import s6.w;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkProgressDao_Impl implements WorkProgressDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<WorkProgress> __insertAdapterOfWorkProgress;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
        this.__insertAdapterOfWorkProgress = new EntityInsertAdapter<WorkProgress>() { // from class: androidx.work.impl.model.WorkProgressDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement sQLiteStatement, WorkProgress workProgress) {
                sQLiteStatement.getClass();
                workProgress.getClass();
                sQLiteStatement.mo92bindText(1, workProgress.getWorkSpecId());
                sQLiteStatement.mo88bindBlob(2, Data.Companion.toByteArrayInternalV1(workProgress.getProgress()));
            }

            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w delete$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w deleteAll$lambda$3(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Data getProgressForWorkSpecId$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            Data dataFromByteArray = null;
            if (sQLiteStatementPrepare.step()) {
                byte[] blob = sQLiteStatementPrepare.isNull(0) ? null : sQLiteStatementPrepare.getBlob(0);
                if (blob != null) {
                    dataFromByteArray = Data.Companion.fromByteArray(blob);
                }
            }
            return dataFromByteArray;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w insert$lambda$0(WorkProgressDao_Impl workProgressDao_Impl, WorkProgress workProgress, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        workProgressDao_Impl.__insertAdapterOfWorkProgress.insert(sQLiteConnection, (SQLiteConnection) workProgress);
        return w.f12711a;
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void delete(String str) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 11));
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void deleteAll() {
        DBUtil.performBlocking(this.__db, false, true, new q(8));
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public Data getProgressForWorkSpecId(String str) {
        str.getClass();
        return (Data) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 10));
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void insert(WorkProgress workProgress) {
        workProgress.getClass();
        DBUtil.performBlocking(this.__db, false, true, new a8.d(5, this, workProgress));
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final List<m7.c> getRequiredConverters() {
            return t.f12808a;
        }

        private Companion() {
        }
    }
}
