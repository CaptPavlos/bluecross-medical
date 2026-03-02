package androidx.core.util;

import androidx.annotation.IntRange;
import androidx.window.layout.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Pools {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i10) {
            if (i10 > 0) {
                this.pool = new Object[i10];
            } else {
                com.google.gson.internal.a.n("The max pool size must be > 0");
                throw null;
            }
        }

        private final boolean isInPool(T t) {
            int i10 = this.poolSize;
            for (int i11 = 0; i11 < i10; i11++) {
                if (this.pool[i11] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i10 = this.poolSize;
            if (i10 <= 0) {
                return null;
            }
            int i11 = i10 - 1;
            T t = (T) this.pool[i11];
            t.getClass();
            this.pool[i11] = null;
            this.poolSize--;
            return t;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T t) {
            t.getClass();
            if (isInPool(t)) {
                c.g("Already in the pool!");
                return false;
            }
            int i10 = this.poolSize;
            Object[] objArr = this.pool;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = t;
            this.poolSize = i10 + 1;
            return true;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object lock;

        public SynchronizedPool(int i10) {
            super(i10);
            this.lock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.lock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(T t) {
            boolean zRelease;
            t.getClass();
            synchronized (this.lock) {
                zRelease = super.release(t);
            }
            return zRelease;
        }
    }

    private Pools() {
    }
}
