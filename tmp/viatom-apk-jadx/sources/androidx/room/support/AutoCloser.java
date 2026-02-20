package androidx.room.support;

import androidx.annotation.GuardedBy;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import g7.p;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.l;
import r7.a1;
import r7.w;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class AutoCloser {
    public static final String BUG_LINK = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    public static final Companion Companion = new Companion(null);
    private a1 autoCloseJob;
    private final long autoCloseTimeoutInMs;
    private w coroutineScope;

    @GuardedBy("lock")
    private SupportSQLiteDatabase delegateDatabase;
    private SupportSQLiteOpenHelper delegateOpenHelper;
    private AtomicLong lastDecrementRefCountTimeStamp;
    private final Object lock;
    private boolean manuallyClosed;
    private g7.a onAutoCloseCallback;
    private final AtomicInteger referenceCount;
    private final Watch watch;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Watch {
        long getMillis();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.room.support.AutoCloser$decrementCountAndScheduleClose$2", f = "AutoCloser.android.kt", l = {167}, m = "invokeSuspend")
    /* renamed from: androidx.room.support.AutoCloser$decrementCountAndScheduleClose$2, reason: invalid class name */
    public static final class AnonymousClass2 extends y6.i implements p {
        int label;

        public AnonymousClass2(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return AutoCloser.this.new AnonymousClass2(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                long j10 = AutoCloser.this.autoCloseTimeoutInMs;
                this.label = 1;
                Object objH = y.h(j10, this);
                x6.a aVar = x6.a.f13718a;
                if (objH == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
            }
            AutoCloser.this.autoCloseDatabase();
            return s6.w.f12711a;
        }
    }

    public AutoCloser(long j10, TimeUnit timeUnit, Watch watch) {
        timeUnit.getClass();
        watch.getClass();
        this.watch = watch;
        this.lock = new Object();
        this.autoCloseTimeoutInMs = timeUnit.toMillis(j10);
        this.referenceCount = new AtomicInteger(0);
        this.lastDecrementRefCountTimeStamp = new AtomicLong(watch.getMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoCloseDatabase() {
        synchronized (this.lock) {
            try {
                if (this.watch.getMillis() - this.lastDecrementRefCountTimeStamp.get() < this.autoCloseTimeoutInMs) {
                    return;
                }
                if (this.referenceCount.get() != 0) {
                    return;
                }
                g7.a aVar = this.onAutoCloseCallback;
                if (aVar == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should  have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                aVar.invoke();
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void closeDatabaseIfOpen() {
        synchronized (this.lock) {
            try {
                this.manuallyClosed = true;
                a1 a1Var = this.autoCloseJob;
                if (a1Var != null) {
                    a1Var.a(null);
                }
                this.autoCloseJob = null;
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void decrementCountAndScheduleClose() {
        int iDecrementAndGet = this.referenceCount.decrementAndGet();
        if (iDecrementAndGet < 0) {
            androidx.window.layout.c.g("Unbalanced reference count.");
            return;
        }
        this.lastDecrementRefCountTimeStamp.set(this.watch.getMillis());
        if (iDecrementAndGet == 0) {
            w wVar = this.coroutineScope;
            if (wVar != null) {
                this.autoCloseJob = y.q(wVar, null, null, new AnonymousClass2(null), 3);
            } else {
                l.i("coroutineScope");
                throw null;
            }
        }
    }

    public final <V> V executeRefCountingFunction(g7.l lVar) {
        lVar.getClass();
        try {
            return (V) lVar.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    public final g7.a getAutoCloseCallbackForTest$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final int getRefCountForTest$room_runtime_release() {
        return this.referenceCount.get();
    }

    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        a1 a1Var = this.autoCloseJob;
        if (a1Var != null) {
            a1Var.a(null);
        }
        this.autoCloseJob = null;
        this.referenceCount.incrementAndGet();
        if (this.manuallyClosed) {
            androidx.window.layout.c.g("Attempting to open already closed database.");
            return null;
        }
        synchronized (this.lock) {
            SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                return supportSQLiteDatabase;
            }
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.delegateOpenHelper;
            if (supportSQLiteOpenHelper == null) {
                l.i("delegateOpenHelper");
                throw null;
            }
            SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
            this.delegateDatabase = writableDatabase;
            return writableDatabase;
        }
    }

    public final void initCoroutineScope(w wVar) {
        wVar.getClass();
        this.coroutineScope = wVar;
    }

    public final void initOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        supportSQLiteOpenHelper.getClass();
        if (supportSQLiteOpenHelper instanceof AutoClosingRoomOpenHelper) {
            com.google.gson.internal.a.n("Failed requirement.");
        } else {
            this.delegateOpenHelper = supportSQLiteOpenHelper;
        }
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(g7.a aVar) {
        aVar.getClass();
        this.onAutoCloseCallback = aVar;
    }

    public final void setDelegateDatabase$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.delegateDatabase = supportSQLiteDatabase;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ AutoCloser(long j10, TimeUnit timeUnit, Watch watch, int i10, kotlin.jvm.internal.g gVar) {
        this(j10, timeUnit, (i10 & 4) != 0 ? new a() : watch);
    }
}
