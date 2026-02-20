package androidx.work.impl.model;

import a3.q;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import s6.w;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<SystemIdInfo> __insertAdapterOfSystemIdInfo;

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
        this.__insertAdapterOfSystemIdInfo = new EntityInsertAdapter<SystemIdInfo>() { // from class: androidx.work.impl.model.SystemIdInfoDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement sQLiteStatement, SystemIdInfo systemIdInfo) {
                sQLiteStatement.getClass();
                systemIdInfo.getClass();
                sQLiteStatement.mo92bindText(1, systemIdInfo.workSpecId);
                sQLiteStatement.mo90bindLong(2, systemIdInfo.getGeneration());
                sQLiteStatement.mo90bindLong(3, systemIdInfo.systemId);
            }

            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SystemIdInfo getSystemIdInfo$lambda$1(String str, String str2, int i10, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.mo90bindLong(2, i10);
            return sQLiteStatementPrepare.step() ? new SystemIdInfo(sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "work_spec_id")), (int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "generation")), (int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "system_id"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getWorkSpecIds$lambda$2(String str, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(sQLiteStatementPrepare.getText(0));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w insertSystemIdInfo$lambda$0(SystemIdInfoDao_Impl systemIdInfoDao_Impl, SystemIdInfo systemIdInfo, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        systemIdInfoDao_Impl.__insertAdapterOfSystemIdInfo.insert(sQLiteConnection, (SQLiteConnection) systemIdInfo);
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w removeSystemIdInfo$lambda$3(String str, String str2, int i10, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            sQLiteStatementPrepare.mo90bindLong(2, i10);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return w.f12711a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w removeSystemIdInfo$lambda$4(String str, String str2, SQLiteConnection sQLiteConnection) {
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

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo getSystemIdInfo(String str, int i10) {
        str.getClass();
        return (SystemIdInfo) DBUtil.performBlocking(this.__db, true, false, new c(str, i10, 1));
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public List<String> getWorkSpecIds() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new q(7));
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void insertSystemIdInfo(SystemIdInfo systemIdInfo) {
        systemIdInfo.getClass();
        DBUtil.performBlocking(this.__db, false, true, new a8.d(3, this, systemIdInfo));
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String str, int i10) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new c(str, i10, 0));
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

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final void removeSystemIdInfo(WorkGenerationalId workGenerationalId) {
        workGenerationalId.getClass();
        removeSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String str) {
        str.getClass();
        DBUtil.performBlocking(this.__db, false, true, new androidx.room.support.e(str, 7));
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public final SystemIdInfo getSystemIdInfo(WorkGenerationalId workGenerationalId) {
        workGenerationalId.getClass();
        return getSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }
}
