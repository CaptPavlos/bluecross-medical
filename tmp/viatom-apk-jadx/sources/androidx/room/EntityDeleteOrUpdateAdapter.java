package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.NoSuchElementException;
import r0.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class EntityDeleteOrUpdateAdapter<T> {
    public abstract void bind(SQLiteStatement sQLiteStatement, T t);

    public abstract String createQuery();

    public final int handle(SQLiteConnection sQLiteConnection, T t) {
        sQLiteConnection.getClass();
        if (t == null) {
            return 0;
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            bind(sQLiteStatementPrepare, t);
            sQLiteStatementPrepare.step();
            f.p(sQLiteStatementPrepare, null);
            return SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
        } finally {
        }
    }

    public final int handleMultiple(SQLiteConnection sQLiteConnection, T[] tArr) {
        sQLiteConnection.getClass();
        int totalChangedRows = 0;
        if (tArr == null) {
            return 0;
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
                        totalChangedRows += SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
                    }
                    i10 = i11;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoSuchElementException(e.getMessage());
                }
            } finally {
            }
        }
        f.p(sQLiteStatementPrepare, null);
        return totalChangedRows;
    }

    public final int handleMultiple(SQLiteConnection sQLiteConnection, Iterable<? extends T> iterable) {
        sQLiteConnection.getClass();
        int totalChangedRows = 0;
        if (iterable == null) {
            return 0;
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            for (T t : iterable) {
                if (t != null) {
                    bind(sQLiteStatementPrepare, t);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    totalChangedRows += SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
                }
            }
            f.p(sQLiteStatementPrepare, null);
            return totalChangedRows;
        } finally {
        }
    }
}
