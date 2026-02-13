package androidx.room.coroutines;

import androidx.constraintlayout.widget.R;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.google.android.gms.internal.measurement.u6;
import g7.p;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.x;
import l1.b;
import r7.w;
import r7.y;
import w6.c;
import w6.h;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed;
    private final SQLiteDriver driver;
    private final Pool readers;
    private final ThreadLocal<PooledConnectionImpl> threadLocal;
    private long timeout;
    private final Pool writers;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.coroutines.ConnectionPoolImpl$acquireWithTimeout$2", f = "ConnectionPoolImpl.kt", l = {171}, m = "invokeSuspend")
    /* renamed from: androidx.room.coroutines.ConnectionPoolImpl$acquireWithTimeout$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ x $connection;
        final /* synthetic */ Pool $this_acquireWithTimeout;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(x xVar, Pool pool, c cVar) {
            super(2, cVar);
            this.$connection = xVar;
            this.$this_acquireWithTimeout = pool;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass2(this.$connection, this.$this_acquireWithTimeout, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            x xVar;
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                xVar = this.$connection;
                Pool pool = this.$this_acquireWithTimeout;
                this.L$0 = xVar;
                this.label = 1;
                obj = pool.acquire(this);
                x6.a aVar = x6.a.f13718a;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                xVar = (x) this.L$0;
                s6.a.e(obj);
            }
            xVar.f10138a = obj;
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", l = {114, R.styleable.ConstraintSet_polarRelativeTo, 541, 147}, m = "useConnection")
    /* renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$1, reason: invalid class name */
    public static final class AnonymousClass1<R> extends y6.c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectionPoolImpl.this.useConnection(false, null, this);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$2", f = "ConnectionPoolImpl.kt", l = {115}, m = "invokeSuspend")
    /* renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C01182 extends i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ PooledConnectionImpl $confinedConnection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01182(p pVar, PooledConnectionImpl pooledConnectionImpl, c cVar) {
            super(2, cVar);
            this.$block = pVar;
            this.$confinedConnection = pooledConnectionImpl;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            return new C01182(this.$block, this.$confinedConnection, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, c cVar) {
            return ((C01182) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    s6.a.e(obj);
                    return obj;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            p pVar = this.$block;
            PooledConnectionImpl pooledConnectionImpl = this.$confinedConnection;
            this.label = 1;
            Object objInvoke = pVar.invoke(pooledConnectionImpl, this);
            x6.a aVar = x6.a.f13718a;
            return objInvoke == aVar ? aVar : objInvoke;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$4", f = "ConnectionPoolImpl.kt", l = {147}, m = "invokeSuspend")
    /* renamed from: androidx.room.coroutines.ConnectionPoolImpl$useConnection$4, reason: invalid class name */
    public static final class AnonymousClass4 extends i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ x $connection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(p pVar, x xVar, c cVar) {
            super(2, cVar);
            this.$block = pVar;
            this.$connection = xVar;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass4(this.$block, this.$connection, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, c cVar) {
            return ((AnonymousClass4) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    s6.a.e(obj);
                    return obj;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            p pVar = this.$block;
            Object obj2 = this.$connection.f10138a;
            this.label = 1;
            Object objInvoke = pVar.invoke(obj2, this);
            x6.a aVar = x6.a.f13718a;
            return objInvoke == aVar ? aVar : objInvoke;
        }
    }

    public ConnectionPoolImpl(final SQLiteDriver sQLiteDriver, final String str, int i10, int i11) {
        sQLiteDriver.getClass();
        str.getClass();
        this.threadLocal = new ThreadLocal<>();
        final int i12 = 0;
        this._isClosed = new AtomicBoolean(false);
        int i13 = p7.a.f12038d;
        this.timeout = b.O(30, p7.c.SECONDS);
        if (i10 <= 0) {
            com.google.gson.internal.a.n("Maximum number of readers must be greater than 0");
            throw null;
        }
        if (i11 <= 0) {
            com.google.gson.internal.a.n("Maximum number of writers must be greater than 0");
            throw null;
        }
        this.driver = sQLiteDriver;
        this.readers = new Pool(i10, new g7.a() { // from class: androidx.room.coroutines.a
            @Override // g7.a
            public final Object invoke() {
                switch (i12) {
                }
                return sQLiteDriver.open(str);
            }
        });
        final int i14 = 1;
        this.writers = new Pool(i11, new g7.a() { // from class: androidx.room.coroutines.a
            @Override // g7.a
            public final Object invoke() {
                switch (i14) {
                }
                return sQLiteDriver.open(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection sQLiteConnectionOpen = sQLiteDriver.open(str);
        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA query_only = 1");
        return sQLiteConnectionOpen;
    }

    private final Object acquireWithTimeout(Pool pool, c cVar) {
        Object obj;
        x xVar = new x();
        try {
            obj = null;
            y.A(this.timeout, new AnonymousClass2(xVar, pool, null), cVar);
        } catch (Throwable th) {
            obj = th;
        }
        return new s6.i(xVar.f10138a, obj);
    }

    private final h createConnectionContext(PooledConnectionImpl pooledConnectionImpl) {
        return new ConnectionElement(pooledConnectionImpl).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, pooledConnectionImpl));
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    private final Void throwTimeoutException(boolean z9) {
        String str = z9 ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.");
        sb.append("\n\nWriter pool:\n");
        this.writers.dump(sb);
        sb.append("Reader pool:");
        sb.append('\n');
        this.readers.dump(sb);
        SQLite.throwSQLiteException(5, sb.toString());
        throw new u6();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }

    /* renamed from: getTimeout-UwyO8pc$room_runtime_release, reason: not valid java name */
    public final long m86getTimeoutUwyO8pc$room_runtime_release() {
        return this.timeout;
    }

    /* renamed from: setTimeout-LRDsOJo$room_runtime_release, reason: not valid java name */
    public final void m87setTimeoutLRDsOJo$room_runtime_release(long j10) {
        this.timeout = j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0137 A[Catch: all -> 0x014b, TryCatch #6 {all -> 0x014b, blocks: (B:69:0x0131, B:71:0x0137, B:76:0x0147, B:80:0x0150, B:84:0x015a, B:92:0x0191, B:93:0x0198, B:94:0x0199, B:95:0x019a, B:96:0x01a2), top: B:124:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017f A[Catch: all -> 0x0190, TRY_LEAVE, TryCatch #0 {all -> 0x0190, blocks: (B:88:0x0179, B:90:0x017f), top: B:112:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019a A[Catch: all -> 0x014b, TryCatch #6 {all -> 0x014b, blocks: (B:69:0x0131, B:71:0x0137, B:76:0x0147, B:80:0x0150, B:84:0x015a, B:92:0x0191, B:93:0x0198, B:94:0x0199, B:95:0x019a, B:96:0x01a2), top: B:124:0x0131 }] */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object useConnection(boolean r18, g7.p r19, w6.c r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.useConnection(boolean, g7.p, w6.c):java.lang.Object");
    }

    public ConnectionPoolImpl(final SQLiteDriver sQLiteDriver, final String str) {
        sQLiteDriver.getClass();
        str.getClass();
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        int i10 = p7.a.f12038d;
        this.timeout = b.O(30, p7.c.SECONDS);
        this.driver = sQLiteDriver;
        final int i11 = 2;
        Pool pool = new Pool(1, new g7.a() { // from class: androidx.room.coroutines.a
            @Override // g7.a
            public final Object invoke() {
                switch (i11) {
                }
                return sQLiteDriver.open(str);
            }
        });
        this.readers = pool;
        this.writers = pool;
    }
}
