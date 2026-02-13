package androidx.constraintlayout.core;

import com.google.gson.internal.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);

        void releaseAll(T[] tArr, int i10);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i10) {
            if (i10 > 0) {
                this.mPool = new Object[i10];
            } else {
                a.n("The max pool size must be > 0");
                throw null;
            }
        }

        private boolean isInPool(T t) {
            for (int i10 = 0; i10 < this.mPoolSize; i10++) {
                if (this.mPool[i10] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public T acquire() {
            int i10 = this.mPoolSize;
            if (i10 <= 0) {
                return null;
            }
            int i11 = i10 - 1;
            Object[] objArr = this.mPool;
            T t = (T) objArr[i11];
            objArr[i11] = null;
            this.mPoolSize = i10 - 1;
            return t;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean release(T t) {
            int i10 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = t;
            this.mPoolSize = i10 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void releaseAll(T[] tArr, int i10) {
            if (i10 > tArr.length) {
                i10 = tArr.length;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                T t = tArr[i11];
                int i12 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i12 < objArr.length) {
                    objArr[i12] = t;
                    this.mPoolSize = i12 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
