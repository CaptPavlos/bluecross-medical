package androidx.leanback.widget;

import android.util.SparseArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class SparseArrayObjectAdapter extends ObjectAdapter {
    private SparseArray<Object> mItems;

    public SparseArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.mItems = new SparseArray<>();
    }

    public void clear() {
        int size = this.mItems.size();
        if (size == 0) {
            return;
        }
        this.mItems.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public Object get(int i10) {
        return this.mItems.valueAt(i10);
    }

    public int indexOf(Object obj) {
        return this.mItems.indexOfValue(obj);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    public Object lookup(int i10) {
        return this.mItems.get(i10);
    }

    public void notifyArrayItemRangeChanged(int i10, int i11) {
        notifyItemRangeChanged(i10, i11);
    }

    public void set(int i10, Object obj) {
        int iIndexOfKey = this.mItems.indexOfKey(i10);
        SparseArray<Object> sparseArray = this.mItems;
        if (iIndexOfKey < 0) {
            sparseArray.append(i10, obj);
            notifyItemRangeInserted(this.mItems.indexOfKey(i10), 1);
        } else if (sparseArray.valueAt(iIndexOfKey) != obj) {
            this.mItems.setValueAt(iIndexOfKey, obj);
            notifyItemRangeChanged(iIndexOfKey, 1);
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.mItems.size();
    }

    public int indexOf(int i10) {
        return this.mItems.indexOfKey(i10);
    }

    public SparseArrayObjectAdapter(Presenter presenter) {
        super(presenter);
        this.mItems = new SparseArray<>();
    }

    public SparseArrayObjectAdapter() {
        this.mItems = new SparseArray<>();
    }

    public void clear(int i10) {
        int iIndexOfKey = this.mItems.indexOfKey(i10);
        if (iIndexOfKey >= 0) {
            this.mItems.removeAt(iIndexOfKey);
            notifyItemRangeRemoved(iIndexOfKey, 1);
        }
    }
}
