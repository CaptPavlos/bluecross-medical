package androidx.room;

import com.google.android.gms.internal.measurement.a4;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ObservedTableStates {
    private final ReentrantLock lock = new ReentrantLock();
    private boolean needsSync;
    private final boolean[] tableObservedState;
    private final long[] tableObserversCount;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ObserveOp {
        private static final /* synthetic */ z6.a $ENTRIES;
        private static final /* synthetic */ ObserveOp[] $VALUES;
        public static final ObserveOp NO_OP = new ObserveOp("NO_OP", 0);
        public static final ObserveOp ADD = new ObserveOp("ADD", 1);
        public static final ObserveOp REMOVE = new ObserveOp("REMOVE", 2);

        private static final /* synthetic */ ObserveOp[] $values() {
            return new ObserveOp[]{NO_OP, ADD, REMOVE};
        }

        static {
            ObserveOp[] observeOpArr$values = $values();
            $VALUES = observeOpArr$values;
            $ENTRIES = a4.m(observeOpArr$values);
        }

        private ObserveOp(String str, int i10) {
        }

        public static z6.a getEntries() {
            return $ENTRIES;
        }

        public static ObserveOp valueOf(String str) {
            return (ObserveOp) Enum.valueOf(ObserveOp.class, str);
        }

        public static ObserveOp[] values() {
            return (ObserveOp[]) $VALUES.clone();
        }
    }

    public ObservedTableStates(int i10) {
        this.tableObserversCount = new long[i10];
        this.tableObservedState = new boolean[i10];
    }

    public final void forceNeedSync$room_runtime_release() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.needsSync = true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final ObserveOp[] getTablesToSync$room_runtime_release() {
        ObserveOp observeOp;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.needsSync) {
                reentrantLock.unlock();
                return null;
            }
            this.needsSync = false;
            int length = this.tableObserversCount.length;
            ObserveOp[] observeOpArr = new ObserveOp[length];
            int i10 = 0;
            boolean z9 = false;
            while (i10 < length) {
                boolean z10 = true;
                boolean z11 = this.tableObserversCount[i10] > 0;
                boolean[] zArr = this.tableObservedState;
                if (z11 != zArr[i10]) {
                    zArr[i10] = z11;
                    observeOp = z11 ? ObserveOp.ADD : ObserveOp.REMOVE;
                } else {
                    z10 = z9;
                    observeOp = ObserveOp.NO_OP;
                }
                observeOpArr[i10] = observeOp;
                i10++;
                z9 = z10;
            }
            ObserveOp[] observeOpArr2 = z9 ? observeOpArr : null;
            reentrantLock.unlock();
            return observeOpArr2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean onObserverAdded$room_runtime_release(int[] iArr) {
        iArr.getClass();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z9 = false;
            for (int i10 : iArr) {
                long[] jArr = this.tableObserversCount;
                long j10 = jArr[i10];
                jArr[i10] = 1 + j10;
                if (j10 == 0) {
                    z9 = true;
                    this.needsSync = true;
                }
            }
            return z9;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean onObserverRemoved$room_runtime_release(int[] iArr) {
        iArr.getClass();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z9 = false;
            for (int i10 : iArr) {
                long[] jArr = this.tableObserversCount;
                long j10 = jArr[i10];
                jArr[i10] = j10 - 1;
                if (j10 == 1) {
                    z9 = true;
                    this.needsSync = true;
                }
            }
            return z9;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void resetTriggerState$room_runtime_release() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean[] zArr = this.tableObservedState;
            int length = zArr.length;
            zArr.getClass();
            Arrays.fill(zArr, 0, length, false);
            this.needsSync = true;
        } finally {
            reentrantLock.unlock();
        }
    }
}
