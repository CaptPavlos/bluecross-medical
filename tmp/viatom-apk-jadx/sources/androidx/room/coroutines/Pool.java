package androidx.room.coroutines;

import a8.k;
import a8.n;
import a8.o;
import a8.p;
import androidx.collection.CircularArray;
import androidx.sqlite.SQLiteConnection;
import com.google.android.gms.internal.measurement.a4;
import java.util.concurrent.locks.ReentrantLock;
import t6.l;
import y6.c;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class Pool {
    private final CircularArray<ConnectionWithLock> availableConnections;
    private final int capacity;
    private final g7.a connectionFactory;
    private final k connectionPermits;
    private final ConnectionWithLock[] connections;
    private boolean isClosed;
    private final ReentrantLock lock;
    private int size;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.coroutines.Pool", f = "ConnectionPoolImpl.kt", l = {212}, m = "acquire")
    /* renamed from: androidx.room.coroutines.Pool$acquire$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pool.this.acquire(this);
        }
    }

    public Pool(int i10, g7.a aVar) {
        aVar.getClass();
        this.capacity = i10;
        this.connectionFactory = aVar;
        this.lock = new ReentrantLock();
        this.connections = new ConnectionWithLock[i10];
        int i11 = p.f325a;
        this.connectionPermits = new o(i10, 0);
        this.availableConnections = new CircularArray<>(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void tryOpenNewConnectionLocked() {
        if (this.size >= this.capacity) {
            return;
        }
        ConnectionWithLock connectionWithLock = new ConnectionWithLock((SQLiteConnection) this.connectionFactory.invoke(), null, 2, 0 == true ? 1 : 0);
        ConnectionWithLock[] connectionWithLockArr = this.connections;
        int i10 = this.size;
        this.size = i10 + 1;
        connectionWithLockArr[i10] = connectionWithLock;
        this.availableConnections.addLast(connectionWithLock);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        r0.c(r3, r6.f324b);
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object acquire(w6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.room.coroutines.Pool.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.coroutines.Pool$acquire$1 r0 = (androidx.room.coroutines.Pool.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquire$1 r0 = new androidx.room.coroutines.Pool$acquire$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.Pool r0 = (androidx.room.coroutines.Pool) r0
            s6.a.e(r6)
            goto L82
        L29:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            r6 = 0
            return r6
        L30:
            s6.a.e(r6)
            a8.k r6 = r5.connectionPermits
            r0.L$0 = r5
            r0.label = r2
            a8.n r6 = (a8.n) r6
            r6.getClass()
            int r1 = r6.f323a
        L40:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = a8.n.g
            int r2 = r2.getAndDecrement(r6)
            if (r2 > r1) goto L40
            s6.w r3 = s6.w.f12711a
            x6.a r4 = x6.a.f13718a
            if (r2 <= 0) goto L4f
            goto L7e
        L4f:
            w6.c r0 = r0.f.F(r0)
            r7.g r0 = r7.y.n(r0)
            boolean r2 = r6.a(r0)     // Catch: java.lang.Throwable -> Lc0
            if (r2 != 0) goto L73
        L5d:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = a8.n.g     // Catch: java.lang.Throwable -> Lc0
            int r2 = r2.getAndDecrement(r6)     // Catch: java.lang.Throwable -> Lc0
            if (r2 > r1) goto L5d
            if (r2 <= 0) goto L6d
            a8.b r6 = r6.f324b     // Catch: java.lang.Throwable -> Lc0
            r0.c(r3, r6)     // Catch: java.lang.Throwable -> Lc0
            goto L73
        L6d:
            boolean r2 = r6.a(r0)     // Catch: java.lang.Throwable -> Lc0
            if (r2 == 0) goto L5d
        L73:
            java.lang.Object r6 = r0.q()
            if (r6 != r4) goto L7a
            goto L7b
        L7a:
            r6 = r3
        L7b:
            if (r6 != r4) goto L7e
            r3 = r6
        L7e:
            if (r3 != r4) goto L81
            return r4
        L81:
            r0 = r5
        L82:
            java.util.concurrent.locks.ReentrantLock r6 = r0.lock     // Catch: java.lang.Throwable -> La5
            r6.lock()     // Catch: java.lang.Throwable -> La5
            boolean r1 = r0.isClosed     // Catch: java.lang.Throwable -> L97
            if (r1 != 0) goto La7
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r1 = r0.availableConnections     // Catch: java.lang.Throwable -> L97
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L97
            if (r1 == 0) goto L99
            r0.tryOpenNewConnectionLocked()     // Catch: java.lang.Throwable -> L97
            goto L99
        L97:
            r1 = move-exception
            goto Lb4
        L99:
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r1 = r0.availableConnections     // Catch: java.lang.Throwable -> L97
            java.lang.Object r1 = r1.popFirst()     // Catch: java.lang.Throwable -> L97
            androidx.room.coroutines.ConnectionWithLock r1 = (androidx.room.coroutines.ConnectionWithLock) r1     // Catch: java.lang.Throwable -> L97
            r6.unlock()     // Catch: java.lang.Throwable -> La5
            return r1
        La5:
            r6 = move-exception
            goto Lb8
        La7:
            java.lang.String r1 = "Connection pool is closed"
            r2 = 21
            androidx.sqlite.SQLite.throwSQLiteException(r2, r1)     // Catch: java.lang.Throwable -> L97
            com.google.android.gms.internal.measurement.u6 r1 = new com.google.android.gms.internal.measurement.u6     // Catch: java.lang.Throwable -> L97
            r1.<init>()     // Catch: java.lang.Throwable -> L97
            throw r1     // Catch: java.lang.Throwable -> L97
        Lb4:
            r6.unlock()     // Catch: java.lang.Throwable -> La5
            throw r1     // Catch: java.lang.Throwable -> La5
        Lb8:
            a8.k r0 = r0.connectionPermits
            a8.n r0 = (a8.n) r0
            r0.b()
            throw r6
        Lc0:
            r6 = move-exception
            r0.z()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.acquire(w6.c):java.lang.Object");
    }

    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void dump(StringBuilder sb) {
        sb.getClass();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            u6.c cVarL = a4.l();
            int size = this.availableConnections.size();
            for (int i10 = 0; i10 < size; i10++) {
                cVarL.add(this.availableConnections.get(i10));
            }
            u6.c cVarH = a4.h(cVarL);
            sb.append('\t' + toString() + " (");
            sb.append("capacity=" + this.capacity + ", ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("permits=");
            n nVar = (n) this.connectionPermits;
            nVar.getClass();
            sb2.append(Math.max(n.g.get(nVar), 0));
            sb2.append(", ");
            sb.append(sb2.toString());
            sb.append("queue=(size=" + cVarH.c() + ")[" + l.h0(cVarH, null, null, null, null, 63) + "], ");
            sb.append(")");
            sb.append('\n');
            ConnectionWithLock[] connectionWithLockArr = this.connections;
            int length = connectionWithLockArr.length;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                ConnectionWithLock connectionWithLock = connectionWithLockArr[i12];
                i11++;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\t\t[");
                sb3.append(i11);
                sb3.append("] - ");
                sb3.append(connectionWithLock != null ? connectionWithLock.toString() : null);
                sb.append(sb3.toString());
                sb.append('\n');
                if (connectionWithLock != null) {
                    connectionWithLock.dump(sb);
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final g7.a getConnectionFactory() {
        return this.connectionFactory;
    }

    public final void recycle(ConnectionWithLock connectionWithLock) {
        connectionWithLock.getClass();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connectionWithLock);
            reentrantLock.unlock();
            ((n) this.connectionPermits).b();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
