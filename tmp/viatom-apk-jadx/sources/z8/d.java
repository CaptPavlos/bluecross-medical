package z8;

import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d extends j0 {
    public static final ReentrantLock h;

    /* renamed from: i, reason: collision with root package name */
    public static final Condition f14466i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f14467j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f14468k;

    /* renamed from: l, reason: collision with root package name */
    public static d f14469l;
    public boolean e;
    public d f;
    public long g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        conditionNewCondition.getClass();
        f14466i = conditionNewCondition;
        f14467j = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        f14468k = 60000000000L;
    }

    public final void h() {
        d dVar;
        long j10 = this.f14483c;
        boolean z9 = this.f14481a;
        if (j10 != 0 || z9) {
            ReentrantLock reentrantLock = h;
            reentrantLock.lock();
            try {
                if (this.e) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.e = true;
                if (f14469l == null) {
                    f14469l = new d();
                    j4.j0 j0Var = new j4.j0("Okio Watchdog");
                    j0Var.setDaemon(true);
                    j0Var.start();
                }
                long jNanoTime = System.nanoTime();
                if (j10 != 0 && z9) {
                    this.g = Math.min(j10, c() - jNanoTime) + jNanoTime;
                } else if (j10 != 0) {
                    this.g = j10 + jNanoTime;
                } else {
                    if (!z9) {
                        throw new AssertionError();
                    }
                    this.g = c();
                }
                long j11 = this.g - jNanoTime;
                d dVar2 = f14469l;
                dVar2.getClass();
                while (true) {
                    dVar = dVar2.f;
                    if (dVar == null || j11 < dVar.g - jNanoTime) {
                        break;
                    } else {
                        dVar2 = dVar;
                    }
                }
                this.f = dVar;
                dVar2.f = this;
                if (dVar2 == f14469l) {
                    f14466i.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = h;
        reentrantLock.lock();
        try {
            if (!this.e) {
                return false;
            }
            this.e = false;
            d dVar = f14469l;
            while (dVar != null) {
                d dVar2 = dVar.f;
                if (dVar2 == this) {
                    dVar.f = this.f;
                    this.f = null;
                    return false;
                }
                dVar = dVar2;
            }
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void j() {
    }
}
