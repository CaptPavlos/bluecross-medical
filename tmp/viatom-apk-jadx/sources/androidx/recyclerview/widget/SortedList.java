package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.window.layout.c;
import com.google.gson.internal.a;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t22, T2 t23);

        public abstract boolean areItemsTheSame(T2 t22, T2 t23);

        @Override // java.util.Comparator
        public abstract int compare(T2 t22, T2 t23);

        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return null;
        }

        public abstract void onChanged(int i10, int i11);

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i10, int i11, Object obj) {
            onChanged(i10, i11);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i10) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i10));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t, boolean z9) {
        int iFindIndexOf = findIndexOf(t, this.mData, 0, this.mSize, 1);
        if (iFindIndexOf == -1) {
            iFindIndexOf = 0;
        } else if (iFindIndexOf < this.mSize) {
            T t9 = this.mData[iFindIndexOf];
            if (this.mCallback.areItemsTheSame(t9, t)) {
                boolean zAreContentsTheSame = this.mCallback.areContentsTheSame(t9, t);
                T[] tArr = this.mData;
                if (zAreContentsTheSame) {
                    tArr[iFindIndexOf] = t;
                    return iFindIndexOf;
                }
                tArr[iFindIndexOf] = t;
                Callback callback = this.mCallback;
                callback.onChanged(iFindIndexOf, 1, callback.getChangePayload(t9, t));
                return iFindIndexOf;
            }
        }
        addToData(iFindIndexOf, t);
        if (z9) {
            this.mCallback.onInserted(iFindIndexOf, 1);
        }
        return iFindIndexOf;
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int iSortAndDedup = sortAndDedup(tArr);
        if (this.mSize != 0) {
            merge(tArr, iSortAndDedup);
            return;
        }
        this.mData = tArr;
        this.mSize = iSortAndDedup;
        this.mCallback.onInserted(0, iSortAndDedup);
    }

    private void addToData(int i10, T t) {
        int i11 = this.mSize;
        if (i10 > i11) {
            a.f(this.mSize, a3.a.r(i10, "cannot add item to ", " because size is "));
            return;
        }
        T[] tArr = this.mData;
        if (i11 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
            System.arraycopy(this.mData, 0, tArr2, 0, i10);
            tArr2[i10] = t;
            System.arraycopy(this.mData, i10, tArr2, i10 + 1, this.mSize - i10);
            this.mData = tArr2;
        } else {
            System.arraycopy(tArr, i10, tArr, i10 + 1, i11 - i10);
            this.mData[i10] = t;
        }
        this.mSize++;
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t, T[] tArr, int i10, int i11, int i12) {
        while (i10 < i11) {
            int i13 = (i10 + i11) / 2;
            T t9 = tArr[i13];
            int iCompare = this.mCallback.compare(t9, t);
            if (iCompare < 0) {
                i10 = i13 + 1;
            } else {
                if (iCompare == 0) {
                    if (!this.mCallback.areItemsTheSame(t9, t)) {
                        int iLinearEqualitySearch = linearEqualitySearch(t, i13, i10, i11);
                        if (i12 != 1 || iLinearEqualitySearch != -1) {
                            return iLinearEqualitySearch;
                        }
                    }
                    return i13;
                }
                i11 = i13;
            }
        }
        if (i12 == 1) {
            return i10;
        }
        return -1;
    }

    private int findSameItem(T t, T[] tArr, int i10, int i11) {
        while (i10 < i11) {
            if (this.mCallback.areItemsTheSame(tArr[i10], t)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t, int i10, int i11, int i12) {
        T t9;
        for (int i13 = i10 - 1; i13 >= i11; i13--) {
            T t10 = this.mData[i13];
            if (this.mCallback.compare(t10, t) != 0) {
                break;
            }
            if (this.mCallback.areItemsTheSame(t10, t)) {
                return i13;
            }
        }
        do {
            i10++;
            if (i10 >= i12) {
                return -1;
            }
            t9 = this.mData[i10];
            if (this.mCallback.compare(t9, t) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t9, t));
        return i10;
    }

    private void merge(T[] tArr, int i10) {
        boolean z9 = this.mCallback instanceof BatchedCallback;
        if (!z9) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i11 = 0;
        this.mOldDataStart = 0;
        int i12 = this.mSize;
        this.mOldDataSize = i12;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i12 + i10 + 10));
        this.mNewDataStart = 0;
        while (true) {
            int i13 = this.mOldDataStart;
            int i14 = this.mOldDataSize;
            if (i13 >= i14 && i11 >= i10) {
                break;
            }
            if (i13 == i14) {
                int i15 = i10 - i11;
                System.arraycopy(tArr, i11, this.mData, this.mNewDataStart, i15);
                int i16 = this.mNewDataStart + i15;
                this.mNewDataStart = i16;
                this.mSize += i15;
                this.mCallback.onInserted(i16 - i15, i15);
                break;
            }
            T[] tArr2 = this.mOldData;
            if (i11 == i10) {
                int i17 = i14 - i13;
                System.arraycopy(tArr2, i13, this.mData, this.mNewDataStart, i17);
                this.mNewDataStart += i17;
                break;
            }
            T t = tArr2[i13];
            T t9 = tArr[i11];
            int iCompare = this.mCallback.compare(t, t9);
            if (iCompare > 0) {
                T[] tArr3 = this.mData;
                int i18 = this.mNewDataStart;
                this.mNewDataStart = i18 + 1;
                tArr3[i18] = t9;
                this.mSize++;
                i11++;
                this.mCallback.onInserted(i18, 1);
            } else if (iCompare == 0 && this.mCallback.areItemsTheSame(t, t9)) {
                T[] tArr4 = this.mData;
                int i19 = this.mNewDataStart;
                this.mNewDataStart = i19 + 1;
                tArr4[i19] = t9;
                i11++;
                this.mOldDataStart++;
                if (!this.mCallback.areContentsTheSame(t, t9)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t, t9));
                }
            } else {
                T[] tArr5 = this.mData;
                int i20 = this.mNewDataStart;
                this.mNewDataStart = i20 + 1;
                tArr5[i20] = t;
                this.mOldDataStart++;
            }
        }
        this.mOldData = null;
        if (z9) {
            return;
        }
        endBatchedUpdates();
    }

    private boolean remove(T t, boolean z9) {
        int iFindIndexOf = findIndexOf(t, this.mData, 0, this.mSize, 2);
        if (iFindIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(iFindIndexOf, z9);
        return true;
    }

    private void removeItemAtIndex(int i10, boolean z9) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i10 + 1, tArr, i10, (this.mSize - i10) - 1);
        int i11 = this.mSize - 1;
        this.mSize = i11;
        this.mData[i11] = null;
        if (z9) {
            this.mCallback.onRemoved(i10, 1);
        }
    }

    private void replaceAllInsert(T t) {
        T[] tArr = this.mData;
        int i10 = this.mNewDataStart;
        tArr[i10] = t;
        this.mNewDataStart = i10 + 1;
        this.mSize++;
        this.mCallback.onInserted(i10, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z9 = this.mCallback instanceof BatchedCallback;
        if (!z9) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int iSortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, iSortAndDedup));
        while (true) {
            int i10 = this.mNewDataStart;
            if (i10 >= iSortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i11 = this.mOldDataStart;
            int i12 = this.mOldDataSize;
            if (i11 >= i12) {
                int i13 = iSortAndDedup - i10;
                System.arraycopy(tArr, i10, this.mData, i10, i13);
                this.mNewDataStart += i13;
                this.mSize += i13;
                this.mCallback.onInserted(i10, i13);
                break;
            }
            if (i10 >= iSortAndDedup) {
                int i14 = i12 - i11;
                this.mSize -= i14;
                this.mCallback.onRemoved(i10, i14);
                break;
            }
            T t = this.mOldData[i11];
            T t9 = tArr[i10];
            int iCompare = this.mCallback.compare(t, t9);
            if (iCompare < 0) {
                replaceAllRemove();
            } else if (iCompare > 0) {
                replaceAllInsert(t9);
            } else if (this.mCallback.areItemsTheSame(t, t9)) {
                T[] tArr2 = this.mData;
                int i15 = this.mNewDataStart;
                tArr2[i15] = t9;
                this.mOldDataStart++;
                this.mNewDataStart = i15 + 1;
                if (!this.mCallback.areContentsTheSame(t, t9)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t, t9));
                }
            } else {
                replaceAllRemove();
                replaceAllInsert(t9);
            }
        }
        this.mOldData = null;
        if (z9) {
            return;
        }
        endBatchedUpdates();
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i10 = 0;
        int i11 = 1;
        for (int i12 = 1; i12 < tArr.length; i12++) {
            T t = tArr[i12];
            if (this.mCallback.compare(tArr[i10], t) == 0) {
                int iFindSameItem = findSameItem(t, tArr, i10, i11);
                if (iFindSameItem != -1) {
                    tArr[iFindSameItem] = t;
                } else {
                    if (i11 != i12) {
                        tArr[i11] = t;
                    }
                    i11++;
                }
            } else {
                if (i11 != i12) {
                    tArr[i11] = t;
                }
                i10 = i11;
                i11++;
            }
        }
        return i11;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData == null) {
            return;
        }
        c.g("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public void addAll(@NonNull T[] tArr, boolean z9) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z9) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i10 = this.mSize;
        if (i10 == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i10, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i10);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i10) throws IndexOutOfBoundsException {
        int i11;
        if (i10 >= this.mSize || i10 < 0) {
            a.f(this.mSize, a3.a.r(i10, "Asked to get item at ", " but size is "));
            return null;
        }
        T[] tArr = this.mOldData;
        return (tArr == null || i10 < (i11 = this.mNewDataStart)) ? this.mData[i10] : tArr[(i10 - i11) + this.mOldDataStart];
    }

    public int indexOf(T t) {
        T[] tArr = this.mOldData;
        T[] tArr2 = this.mData;
        if (tArr == null) {
            return findIndexOf(t, tArr2, 0, this.mSize, 4);
        }
        int iFindIndexOf = findIndexOf(t, tArr2, 0, this.mNewDataStart, 4);
        if (iFindIndexOf != -1) {
            return iFindIndexOf;
        }
        int iFindIndexOf2 = findIndexOf(t, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (iFindIndexOf2 != -1) {
            return (iFindIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
        }
        return -1;
    }

    public void recalculatePositionOfItemAt(int i10) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t = get(i10);
        removeItemAtIndex(i10, false);
        int iAdd = add(t, false);
        if (i10 != iAdd) {
            this.mCallback.onMoved(i10, iAdd);
        }
    }

    public T removeItemAt(int i10) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t = get(i10);
        removeItemAtIndex(i10, true);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i10, T t) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t9 = get(i10);
        boolean z9 = t9 == t || !this.mCallback.areContentsTheSame(t9, t);
        if (t9 != t && this.mCallback.compare(t9, t) == 0) {
            this.mData[i10] = t;
            if (z9) {
                Callback callback = this.mCallback;
                callback.onChanged(i10, 1, callback.getChangePayload(t9, t));
                return;
            }
            return;
        }
        if (z9) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i10, 1, callback2.getChangePayload(t9, t));
        }
        removeItemAtIndex(i10, false);
        int iAdd = add(t, false);
        if (i10 != iAdd) {
            this.mCallback.onMoved(i10, iAdd);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areContentsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t22, T2 t23) {
            return this.mWrappedCallback.areItemsTheSame(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t22, T2 t23) {
            return this.mWrappedCallback.compare(t22, t23);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t22, T2 t23) {
            return this.mWrappedCallback.getChangePayload(t22, t23);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i10, int i11) {
            this.mBatchingListUpdateCallback.onChanged(i10, i11, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i10, int i11) {
            this.mBatchingListUpdateCallback.onInserted(i10, i11);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i10, int i11) {
            this.mBatchingListUpdateCallback.onMoved(i10, i11);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i10, int i11) {
            this.mBatchingListUpdateCallback.onRemoved(i10, i11);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i10, int i11, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i10, i11, obj);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    public boolean remove(T t) {
        throwIfInMutationOperation();
        return remove(t, true);
    }

    public void replaceAll(@NonNull T[] tArr, boolean z9) {
        throwIfInMutationOperation();
        if (z9) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int add(T t) {
        throwIfInMutationOperation();
        return add(t, true);
    }
}
