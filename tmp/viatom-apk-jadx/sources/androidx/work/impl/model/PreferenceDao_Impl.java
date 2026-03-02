package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import g7.l;
import java.util.List;
import s6.w;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PreferenceDao_Impl implements PreferenceDao {
    public static final Companion Companion = new Companion(null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Preference> __insertAdapterOfPreference;

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.__db = roomDatabase;
        this.__insertAdapterOfPreference = new EntityInsertAdapter<Preference>() { // from class: androidx.work.impl.model.PreferenceDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement sQLiteStatement, Preference preference) {
                sQLiteStatement.getClass();
                preference.getClass();
                sQLiteStatement.mo92bindText(1, preference.getKey());
                Long value = preference.getValue();
                if (value == null) {
                    sQLiteStatement.mo91bindNull(2);
                } else {
                    sQLiteStatement.mo90bindLong(2, value.longValue());
                }
            }

            @Override // androidx.room.EntityInsertAdapter
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long getLongValue$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            Long lValueOf = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(0));
            }
            return lValueOf;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long getObservableLongValue$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(str);
        try {
            sQLiteStatementPrepare.mo92bindText(1, str2);
            Long lValueOf = null;
            if (sQLiteStatementPrepare.step() && !sQLiteStatementPrepare.isNull(0)) {
                lValueOf = Long.valueOf(sQLiteStatementPrepare.getLong(0));
            }
            return lValueOf;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w insertPreference$lambda$0(PreferenceDao_Impl preferenceDao_Impl, Preference preference, SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        preferenceDao_Impl.__insertAdapterOfPreference.insert(sQLiteConnection, (SQLiteConnection) preference);
        return w.f12711a;
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public Long getLongValue(String str) {
        str.getClass();
        return (Long) DBUtil.performBlocking(this.__db, true, false, new androidx.room.support.e(str, 6));
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public LiveData<Long> getObservableLongValue(String str) {
        str.getClass();
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"Preference"}, false, (l) new androidx.room.support.e(str, 5));
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public void insertPreference(Preference preference) {
        preference.getClass();
        DBUtil.performBlocking(this.__db, false, true, new a8.d(2, this, preference));
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
