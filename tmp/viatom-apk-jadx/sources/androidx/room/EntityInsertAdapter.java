package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.google.android.gms.internal.measurement.a4;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import r0.f;
import t6.l;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class EntityInsertAdapter<T> {
    public abstract void bind(SQLiteStatement sQLiteStatement, T t);

    public abstract String createQuery();

    public final void insert(SQLiteConnection sQLiteConnection, T[] tArr) {
        sQLiteConnection.getClass();
        if (tArr == null) {
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        int i10 = 0;
        while (i10 < tArr.length) {
            try {
                int i11 = i10 + 1;
                try {
                    T t = tArr[i10];
                    if (t != null) {
                        bind(sQLiteStatementPrepare, t);
                        sQLiteStatementPrepare.step();
                        sQLiteStatementPrepare.reset();
                    }
                    i10 = i11;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoSuchElementException(e.getMessage());
                }
            } finally {
            }
        }
        f.p(sQLiteStatementPrepare, null);
    }

    public final long insertAndReturnId(SQLiteConnection sQLiteConnection, T t) {
        sQLiteConnection.getClass();
        if (t == null) {
            return -1L;
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            bind(sQLiteStatementPrepare, t);
            sQLiteStatementPrepare.step();
            f.p(sQLiteStatementPrepare, null);
            return SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long[] insertAndReturnIdsArray(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long lastInsertedRowId;
        sQLiteConnection.getClass();
        if (collection == null) {
            return new long[0];
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            int size = collection.size();
            long[] jArr = new long[size];
            for (int i10 = 0; i10 < size; i10++) {
                Object objB0 = l.b0(collection, i10);
                if (objB0 != null) {
                    bind(sQLiteStatementPrepare, objB0);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    lastInsertedRowId = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    lastInsertedRowId = -1;
                }
                jArr[i10] = lastInsertedRowId;
            }
            f.p(sQLiteStatementPrepare, null);
            return jArr;
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long lastInsertedRowId;
        sQLiteConnection.getClass();
        if (collection == null) {
            return new Long[0];
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i10 = 0; i10 < size; i10++) {
                Object objB0 = l.b0(collection, i10);
                if (objB0 != null) {
                    bind(sQLiteStatementPrepare, objB0);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    lastInsertedRowId = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    lastInsertedRowId = -1;
                }
                lArr[i10] = Long.valueOf(lastInsertedRowId);
            }
            f.p(sQLiteStatementPrepare, null);
            return lArr;
        } finally {
        }
    }

    public final List<Long> insertAndReturnIdsList(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        sQLiteConnection.getClass();
        if (collection == null) {
            return t.f12808a;
        }
        u6.c cVarL = a4.l();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            for (T t : collection) {
                if (t != null) {
                    bind(sQLiteStatementPrepare, t);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    cVarL.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection)));
                } else {
                    cVarL.add(-1L);
                }
            }
            f.p(sQLiteStatementPrepare, null);
            return a4.h(cVarL);
        } finally {
        }
    }

    public final void insert(SQLiteConnection sQLiteConnection, T t) {
        sQLiteConnection.getClass();
        if (t == null) {
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            bind(sQLiteStatementPrepare, t);
            sQLiteStatementPrepare.step();
            f.p(sQLiteStatementPrepare, null);
        } finally {
        }
    }

    public final void insert(SQLiteConnection sQLiteConnection, Iterable<? extends T> iterable) {
        sQLiteConnection.getClass();
        if (iterable == null) {
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            for (T t : iterable) {
                if (t != null) {
                    bind(sQLiteStatementPrepare, t);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                }
            }
            f.p(sQLiteStatementPrepare, null);
        } finally {
        }
    }

    public final long[] insertAndReturnIdsArray(SQLiteConnection sQLiteConnection, T[] tArr) {
        long lastInsertedRowId;
        sQLiteConnection.getClass();
        if (tArr == null) {
            return new long[0];
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            int length = tArr.length;
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                T t = tArr[i10];
                if (t != null) {
                    bind(sQLiteStatementPrepare, t);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    lastInsertedRowId = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    lastInsertedRowId = -1;
                }
                jArr[i10] = lastInsertedRowId;
            }
            f.p(sQLiteStatementPrepare, null);
            return jArr;
        } finally {
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, T[] tArr) {
        long lastInsertedRowId;
        sQLiteConnection.getClass();
        if (tArr == null) {
            return new Long[0];
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            for (int i10 = 0; i10 < length; i10++) {
                T t = tArr[i10];
                if (t != null) {
                    bind(sQLiteStatementPrepare, t);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    lastInsertedRowId = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    lastInsertedRowId = -1;
                }
                lArr[i10] = Long.valueOf(lastInsertedRowId);
            }
            f.p(sQLiteStatementPrepare, null);
            return lArr;
        } finally {
        }
    }

    public final List<Long> insertAndReturnIdsList(SQLiteConnection sQLiteConnection, T[] tArr) {
        sQLiteConnection.getClass();
        if (tArr == null) {
            return t.f12808a;
        }
        u6.c cVarL = a4.l();
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            for (T t : tArr) {
                if (t != null) {
                    bind(sQLiteStatementPrepare, t);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    cVarL.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection)));
                } else {
                    cVarL.add(-1L);
                }
            }
            f.p(sQLiteStatementPrepare, null);
            return a4.h(cVarL);
        } finally {
        }
    }
}
