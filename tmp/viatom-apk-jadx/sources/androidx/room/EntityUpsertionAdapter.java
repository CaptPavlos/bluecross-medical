package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import com.google.android.gms.internal.measurement.a4;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import o7.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> entityInsertionAdapter, EntityDeletionOrUpdateAdapter<T> entityDeletionOrUpdateAdapter) {
        entityInsertionAdapter.getClass();
        entityDeletionOrUpdateAdapter.getClass();
        this.insertionAdapter = entityInsertionAdapter;
        this.updateAdapter = entityDeletionOrUpdateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null) {
            throw sQLiteConstraintException;
        }
        if (!m.d0(message, "unique", true) && !m.d0(message, "2067", false) && !m.d0(message, "1555", false)) {
            throw sQLiteConstraintException;
        }
    }

    public final void upsert(Iterable<? extends T> iterable) {
        iterable.getClass();
        for (T t : iterable) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
            }
        }
    }

    public final long upsertAndReturnId(T t) {
        try {
            return this.insertionAdapter.insertAndReturnId(t);
        } catch (SQLiteConstraintException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(t);
            return -1L;
        }
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> collection) {
        long jInsertAndReturnId;
        collection.getClass();
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            jArr[i10] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        long jInsertAndReturnId;
        collection.getClass();
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i10 = 0; i10 < size; i10++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            lArr[i10] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> collection) {
        collection.getClass();
        u6.c cVarL = a4.l();
        for (T t : collection) {
            try {
                cVarL.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
                cVarL.add(-1L);
            }
        }
        return a4.h(cVarL);
    }

    public final void upsert(T[] tArr) {
        tArr.getClass();
        for (T t : tArr) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
            }
        }
    }

    public final void upsert(T t) {
        try {
            this.insertionAdapter.insert((EntityInsertionAdapter<T>) t);
        } catch (SQLiteConstraintException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(t);
        }
    }

    public final long[] upsertAndReturnIdsArray(T[] tArr) {
        long jInsertAndReturnId;
        tArr.getClass();
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(tArr[i10]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(tArr[i10]);
                jInsertAndReturnId = -1;
            }
            jArr[i10] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] tArr) {
        long jInsertAndReturnId;
        tArr.getClass();
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i10 = 0; i10 < length; i10++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(tArr[i10]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(tArr[i10]);
                jInsertAndReturnId = -1;
            }
            lArr[i10] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(T[] tArr) {
        tArr.getClass();
        u6.c cVarL = a4.l();
        for (T t : tArr) {
            try {
                cVarL.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
                cVarL.add(-1L);
            }
        }
        return a4.h(cVarL);
    }
}
