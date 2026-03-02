package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.internal.measurement.a4;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import t6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        roomDatabase.getClass();
    }

    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t);

    public final void insert(Iterable<? extends T> iterable) {
        iterable.getClass();
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                supportSQLiteStatementAcquire.executeInsert();
            }
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long insertAndReturnId(T t) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, t);
            return supportSQLiteStatementAcquire.executeInsert();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        collection.getClass();
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i10 = 0;
            for (T t : collection) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    m.U();
                    throw null;
                }
                bind(supportSQLiteStatementAcquire, t);
                jArr[i10] = supportSQLiteStatementAcquire.executeInsert();
                i10 = i11;
            }
            release(supportSQLiteStatementAcquire);
            return jArr;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        tArr.getClass();
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = i11 + 1;
                try {
                    bind(supportSQLiteStatementAcquire, tArr[i11]);
                    lArr[i10] = Long.valueOf(supportSQLiteStatementAcquire.executeInsert());
                    i10++;
                    i11 = i12;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoSuchElementException(e.getMessage());
                }
            }
            release(supportSQLiteStatementAcquire);
            return lArr;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        collection.getClass();
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            u6.c cVarL = a4.l();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                cVarL.add(Long.valueOf(supportSQLiteStatementAcquire.executeInsert()));
            }
            u6.c cVarH = a4.h(cVarL);
            release(supportSQLiteStatementAcquire);
            return cVarH;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final void insert(T[] tArr) {
        tArr.getClass();
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            for (T t : tArr) {
                bind(supportSQLiteStatementAcquire, t);
                supportSQLiteStatementAcquire.executeInsert();
            }
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final void insert(T t) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, t);
            supportSQLiteStatementAcquire.executeInsert();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        collection.getClass();
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        Iterator<? extends T> it = collection.iterator();
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i10 = 0; i10 < size; i10++) {
                bind(supportSQLiteStatementAcquire, it.next());
                lArr[i10] = Long.valueOf(supportSQLiteStatementAcquire.executeInsert());
            }
            return lArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        tArr.getClass();
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            u6.c cVarL = a4.l();
            for (T t : tArr) {
                bind(supportSQLiteStatementAcquire, t);
                cVarL.add(Long.valueOf(supportSQLiteStatementAcquire.executeInsert()));
            }
            u6.c cVarH = a4.h(cVarL);
            release(supportSQLiteStatementAcquire);
            return cVarH;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        tArr.getClass();
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int length = tArr.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = i11 + 1;
                bind(supportSQLiteStatementAcquire, tArr[i10]);
                jArr[i11] = supportSQLiteStatementAcquire.executeInsert();
                i10++;
                i11 = i12;
            }
            return jArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }
}
