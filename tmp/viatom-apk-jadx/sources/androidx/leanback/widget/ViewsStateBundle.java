package androidx.leanback.widget;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.collection.LruCache;
import java.util.Map;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ViewsStateBundle {
    private static final int LIMIT_DEFAULT = 100;
    private static final int UNLIMITED = Integer.MAX_VALUE;
    private LruCache<String, SparseArray<Parcelable>> mChildStates;
    private int mSavePolicy = 0;
    private int mLimitNumber = 100;

    private void applyPolicyChanges() {
        int i10 = this.mSavePolicy;
        if (i10 == 2) {
            if (this.mLimitNumber <= 0) {
                f.a();
                return;
            }
            LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
            if (lruCache == null || lruCache.maxSize() != this.mLimitNumber) {
                this.mChildStates = new LruCache<>(this.mLimitNumber);
                return;
            }
            return;
        }
        if (i10 != 3 && i10 != 1) {
            this.mChildStates = null;
            return;
        }
        LruCache<String, SparseArray<Parcelable>> lruCache2 = this.mChildStates;
        if (lruCache2 == null || lruCache2.maxSize() != Integer.MAX_VALUE) {
            this.mChildStates = new LruCache<>(Integer.MAX_VALUE);
        }
    }

    public static String getSaveStatesKey(int i10) {
        return Integer.toString(i10);
    }

    private void saveViewUnchecked(View view, int i10) {
        if (this.mChildStates != null) {
            String saveStatesKey = getSaveStatesKey(i10);
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            view.saveHierarchyState(sparseArray);
            this.mChildStates.put(saveStatesKey, sparseArray);
        }
    }

    public void clear() {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    public int getLimitNumber() {
        return this.mLimitNumber;
    }

    public int getSavePolicy() {
        return this.mSavePolicy;
    }

    public void loadFromBundle(Bundle bundle) {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || bundle == null) {
            return;
        }
        lruCache.evictAll();
        for (String str : bundle.keySet()) {
            this.mChildStates.put(str, bundle.getSparseParcelableArray(str));
        }
    }

    public void loadView(View view, int i10) {
        if (this.mChildStates != null) {
            SparseArray<Parcelable> sparseArrayRemove = this.mChildStates.remove(getSaveStatesKey(i10));
            if (sparseArrayRemove != null) {
                view.restoreHierarchyState(sparseArrayRemove);
            }
        }
    }

    public void remove(int i10) {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || lruCache.size() == 0) {
            return;
        }
        this.mChildStates.remove(getSaveStatesKey(i10));
    }

    public Bundle saveAsBundle() {
        LruCache<String, SparseArray<Parcelable>> lruCache = this.mChildStates;
        if (lruCache == null || lruCache.size() == 0) {
            return null;
        }
        Map<String, SparseArray<Parcelable>> mapSnapshot = this.mChildStates.snapshot();
        Bundle bundle = new Bundle();
        for (Map.Entry<String, SparseArray<Parcelable>> entry : mapSnapshot.entrySet()) {
            bundle.putSparseParcelableArray(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    public void saveOffscreenView(View view, int i10) {
        int i11 = this.mSavePolicy;
        if (i11 == 1) {
            remove(i10);
        } else if (i11 == 2 || i11 == 3) {
            saveViewUnchecked(view, i10);
        }
    }

    public Bundle saveOnScreenView(Bundle bundle, View view, int i10) {
        if (this.mSavePolicy != 0) {
            String saveStatesKey = getSaveStatesKey(i10);
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            view.saveHierarchyState(sparseArray);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(saveStatesKey, sparseArray);
        }
        return bundle;
    }

    public void setLimitNumber(int i10) {
        this.mLimitNumber = i10;
        applyPolicyChanges();
    }

    public void setSavePolicy(int i10) {
        this.mSavePolicy = i10;
        applyPolicyChanges();
    }
}
