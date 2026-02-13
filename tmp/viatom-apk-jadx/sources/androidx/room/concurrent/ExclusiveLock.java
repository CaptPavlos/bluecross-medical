package androidx.room.concurrent;

import com.google.android.gms.internal.measurement.u6;
import g7.a;
import g7.l;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ExclusiveLock {
    public static final Companion Companion = new Companion(null);
    private static final Map<String, ReentrantLock> threadLocksMap = new LinkedHashMap();
    private final FileLock fileLock;
    private final ReentrantLock threadLock;

    public ExclusiveLock(String str, boolean z9) {
        str.getClass();
        Companion companion = Companion;
        this.threadLock = companion.getThreadLock(str);
        this.fileLock = z9 ? companion.getFileLock(str) : null;
    }

    public final <T> T withLock(a aVar, l lVar) {
        aVar.getClass();
        lVar.getClass();
        this.threadLock.lock();
        boolean z9 = false;
        try {
            FileLock fileLock = this.fileLock;
            if (fileLock != null) {
                fileLock.lock();
            }
            z9 = true;
            try {
                T t = (T) aVar.invoke();
                this.threadLock.unlock();
                return t;
            } finally {
                FileLock fileLock2 = this.fileLock;
                if (fileLock2 != null) {
                    fileLock2.unlock();
                }
            }
        } catch (Throwable th) {
            try {
                if (z9) {
                    throw th;
                }
                lVar.invoke(th);
                throw new u6();
            } catch (Throwable th2) {
                this.threadLock.unlock();
                throw th2;
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FileLock getFileLock(String str) {
            return new FileLock(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReentrantLock getThreadLock(String str) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                try {
                    Map map = ExclusiveLock.threadLocksMap;
                    Object reentrantLock2 = map.get(str);
                    if (reentrantLock2 == null) {
                        reentrantLock2 = new ReentrantLock();
                        map.put(str, reentrantLock2);
                    }
                    reentrantLock = (ReentrantLock) reentrantLock2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return reentrantLock;
        }

        private Companion() {
        }
    }
}
