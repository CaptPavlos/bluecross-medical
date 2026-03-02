package androidx.room;

import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import com.google.android.gms.internal.measurement.a4;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.g;
import o7.m;
import t6.l;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class EntityUpsertAdapter<T> {
    public static final Companion Companion = new Companion(null);
    private static final String ErrorMsg = "unique";
    private static final String SQLITE_CONSTRAINT_PRIMARYKEY = "1555";
    private static final String SQLITE_CONSTRAINT_UNIQUE = "2067";
    private final EntityInsertAdapter<T> entityInsertAdapter;
    private final EntityDeleteOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertAdapter(EntityInsertAdapter<T> entityInsertAdapter, EntityDeleteOrUpdateAdapter<T> entityDeleteOrUpdateAdapter) {
        entityInsertAdapter.getClass();
        entityDeleteOrUpdateAdapter.getClass();
        this.entityInsertAdapter = entityInsertAdapter;
        this.updateAdapter = entityDeleteOrUpdateAdapter;
    }

    private final void checkUniquenessException(SQLException sQLException) {
        String message = sQLException.getMessage();
        if (message == null) {
            throw sQLException;
        }
        if (!m.d0(message, ErrorMsg, true) && !m.d0(message, SQLITE_CONSTRAINT_UNIQUE, false) && !m.d0(message, SQLITE_CONSTRAINT_PRIMARYKEY, false)) {
            throw sQLException;
        }
    }

    public final void upsert(SQLiteConnection sQLiteConnection, Iterable<? extends T> iterable) {
        sQLiteConnection.getClass();
        if (iterable == null) {
            return;
        }
        for (T t : iterable) {
            try {
                this.entityInsertAdapter.insert(sQLiteConnection, (SQLiteConnection) t);
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(sQLiteConnection, t);
            }
        }
    }

    public final long upsertAndReturnId(SQLiteConnection sQLiteConnection, T t) {
        sQLiteConnection.getClass();
        try {
            return this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, t);
        } catch (SQLException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(sQLiteConnection, t);
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long[] upsertAndReturnIdsArray(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long jInsertAndReturnId;
        sQLiteConnection.getClass();
        if (collection == null) {
            return new long[0];
        }
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            try {
                jInsertAndReturnId = this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, l.b0(collection, i10));
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(sQLiteConnection, l.b0(collection, i10));
                jInsertAndReturnId = -1;
            }
            jArr[i10] = jInsertAndReturnId;
        }
        return jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] upsertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long jInsertAndReturnId;
        sQLiteConnection.getClass();
        if (collection == null) {
            return new Long[0];
        }
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i10 = 0; i10 < size; i10++) {
            try {
                jInsertAndReturnId = this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, l.b0(collection, i10));
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(sQLiteConnection, l.b0(collection, i10));
                jInsertAndReturnId = -1;
            }
            lArr[i10] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        sQLiteConnection.getClass();
        if (collection == null) {
            return t.f12808a;
        }
        u6.c cVarL = a4.l();
        for (T t : collection) {
            try {
                cVarL.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, t)));
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(sQLiteConnection, t);
                cVarL.add(-1L);
            }
        }
        return a4.h(cVarL);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public final void upsert(SQLiteConnection sQLiteConnection, T[] tArr) {
        sQLiteConnection.getClass();
        if (tArr == null) {
            return;
        }
        for (T t : tArr) {
            try {
                this.entityInsertAdapter.insert(sQLiteConnection, (SQLiteConnection) t);
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(sQLiteConnection, t);
            }
        }
    }

    public final void upsert(SQLiteConnection sQLiteConnection, T t) {
        sQLiteConnection.getClass();
        try {
            this.entityInsertAdapter.insert(sQLiteConnection, (SQLiteConnection) t);
        } catch (SQLException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(sQLiteConnection, t);
        }
    }

    public final long[] upsertAndReturnIdsArray(SQLiteConnection sQLiteConnection, T[] tArr) {
        long jInsertAndReturnId;
        sQLiteConnection.getClass();
        if (tArr == null) {
            return new long[0];
        }
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            try {
                jInsertAndReturnId = this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, tArr[i10]);
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(sQLiteConnection, tArr[i10]);
                jInsertAndReturnId = -1;
            }
            jArr[i10] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, T[] tArr) {
        long jInsertAndReturnId;
        sQLiteConnection.getClass();
        if (tArr == null) {
            return new Long[0];
        }
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i10 = 0; i10 < length; i10++) {
            try {
                jInsertAndReturnId = this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, tArr[i10]);
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(sQLiteConnection, tArr[i10]);
                jInsertAndReturnId = -1;
            }
            lArr[i10] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(SQLiteConnection sQLiteConnection, T[] tArr) {
        sQLiteConnection.getClass();
        if (tArr == null) {
            return t.f12808a;
        }
        u6.c cVarL = a4.l();
        for (T t : tArr) {
            try {
                cVarL.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, t)));
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(sQLiteConnection, t);
                cVarL.add(-1L);
            }
        }
        return a4.h(cVarL);
    }
}
