package androidx.room.coroutines;

import a8.j;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import kotlin.jvm.internal.g;
import w6.c;
import w6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ConnectionWithLock implements SQLiteConnection, a8.a {
    private h acquireCoroutineContext;
    private Throwable acquireThrowable;
    private final SQLiteConnection delegate;
    private final a8.a lock;

    public ConnectionWithLock(SQLiteConnection sQLiteConnection, a8.a aVar) {
        sQLiteConnection.getClass();
        aVar.getClass();
        this.delegate = sQLiteConnection;
        this.lock = aVar;
    }

    @Override // androidx.sqlite.SQLiteConnection, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0107 A[LOOP:0: B:55:0x0101->B:57:0x0107, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dump(java.lang.StringBuilder r7) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionWithLock.dump(java.lang.StringBuilder):void");
    }

    @Override // a8.a
    public z7.a getOnLock() {
        return this.lock.getOnLock();
    }

    @Override // a8.a
    public boolean holdsLock(Object obj) {
        obj.getClass();
        return this.lock.holdsLock(obj);
    }

    @Override // a8.a
    public boolean isLocked() {
        return this.lock.isLocked();
    }

    @Override // a8.a
    public Object lock(Object obj, c cVar) {
        return this.lock.lock(obj, cVar);
    }

    public final ConnectionWithLock markAcquired(h hVar) {
        hVar.getClass();
        this.acquireCoroutineContext = hVar;
        this.acquireThrowable = new Throwable();
        return this;
    }

    public final ConnectionWithLock markReleased() {
        this.acquireCoroutineContext = null;
        this.acquireThrowable = null;
        return this;
    }

    @Override // androidx.sqlite.SQLiteConnection
    public SQLiteStatement prepare(String str) {
        str.getClass();
        return this.delegate.prepare(str);
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Override // a8.a
    public boolean tryLock(Object obj) {
        return this.lock.tryLock(obj);
    }

    @Override // a8.a
    public void unlock(Object obj) {
        this.lock.unlock(obj);
    }

    public /* synthetic */ ConnectionWithLock(SQLiteConnection sQLiteConnection, a8.a aVar, int i10, g gVar) {
        this(sQLiteConnection, (i10 & 2) != 0 ? j.a() : aVar);
    }
}
