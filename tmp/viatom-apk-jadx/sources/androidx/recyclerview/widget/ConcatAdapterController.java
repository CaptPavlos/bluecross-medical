package androidx.recyclerview.widget;

import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;
import com.google.gson.internal.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class ConcatAdapterController implements NestedAdapterWrapper.Callback {
    private final ConcatAdapter mConcatAdapter;

    @NonNull
    private final ConcatAdapter.Config.StableIdMode mStableIdMode;
    private final StableIdStorage mStableIdStorage;
    private final ViewTypeStorage mViewTypeStorage;
    private List<WeakReference<RecyclerView>> mAttachedRecyclerViews = new ArrayList();
    private final IdentityHashMap<RecyclerView.ViewHolder, NestedAdapterWrapper> mBinderLookup = new IdentityHashMap<>();
    private List<NestedAdapterWrapper> mWrappers = new ArrayList();
    private WrapperAndLocalPosition mReusableHolder = new WrapperAndLocalPosition();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class WrapperAndLocalPosition {
        boolean mInUse;
        int mLocalPosition;
        NestedAdapterWrapper mWrapper;
    }

    public ConcatAdapterController(ConcatAdapter concatAdapter, ConcatAdapter.Config config) {
        this.mConcatAdapter = concatAdapter;
        if (config.isolateViewTypes) {
            this.mViewTypeStorage = new ViewTypeStorage.IsolatedViewTypeStorage();
        } else {
            this.mViewTypeStorage = new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        }
        ConcatAdapter.Config.StableIdMode stableIdMode = config.stableIdMode;
        this.mStableIdMode = stableIdMode;
        if (stableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.mStableIdStorage = new StableIdStorage.NoStableIdStorage();
            return;
        }
        if (stableIdMode == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.mStableIdStorage = new StableIdStorage.IsolatedStableIdStorage();
        } else if (stableIdMode == ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
            this.mStableIdStorage = new StableIdStorage.SharedPoolStableIdStorage();
        } else {
            a.n("unknown stable id mode");
            throw null;
        }
    }

    private void calculateAndUpdateStateRestorationPolicy() {
        RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicyComputeStateRestorationPolicy = computeStateRestorationPolicy();
        if (stateRestorationPolicyComputeStateRestorationPolicy != this.mConcatAdapter.getStateRestorationPolicy()) {
            this.mConcatAdapter.internalSetStateRestorationPolicy(stateRestorationPolicyComputeStateRestorationPolicy);
        }
    }

    private RecyclerView.Adapter.StateRestorationPolicy computeStateRestorationPolicy() {
        for (NestedAdapterWrapper nestedAdapterWrapper : this.mWrappers) {
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy = nestedAdapterWrapper.adapter.getStateRestorationPolicy();
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy2 = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
            if (stateRestorationPolicy == stateRestorationPolicy2 || (stateRestorationPolicy == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && nestedAdapterWrapper.getCachedItemCount() == 0)) {
                return stateRestorationPolicy2;
            }
        }
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    private int countItemsBefore(NestedAdapterWrapper nestedAdapterWrapper) {
        NestedAdapterWrapper next;
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        int cachedItemCount = 0;
        while (it.hasNext() && (next = it.next()) != nestedAdapterWrapper) {
            cachedItemCount += next.getCachedItemCount();
        }
        return cachedItemCount;
    }

    @NonNull
    private WrapperAndLocalPosition findWrapperAndLocalPosition(int i10) {
        WrapperAndLocalPosition wrapperAndLocalPosition = this.mReusableHolder;
        if (wrapperAndLocalPosition.mInUse) {
            wrapperAndLocalPosition = new WrapperAndLocalPosition();
        } else {
            wrapperAndLocalPosition.mInUse = true;
        }
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        int cachedItemCount = i10;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NestedAdapterWrapper next = it.next();
            if (next.getCachedItemCount() > cachedItemCount) {
                wrapperAndLocalPosition.mWrapper = next;
                wrapperAndLocalPosition.mLocalPosition = cachedItemCount;
                break;
            }
            cachedItemCount -= next.getCachedItemCount();
        }
        if (wrapperAndLocalPosition.mWrapper != null) {
            return wrapperAndLocalPosition;
        }
        a.n(a3.a.f(i10, "Cannot find wrapper for "));
        return null;
    }

    @Nullable
    private NestedAdapterWrapper findWrapperFor(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int iIndexOfWrapper = indexOfWrapper(adapter);
        if (iIndexOfWrapper == -1) {
            return null;
        }
        return this.mWrappers.get(iIndexOfWrapper);
    }

    @NonNull
    private NestedAdapterWrapper getWrapper(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            return nestedAdapterWrapper;
        }
        androidx.core.view.accessibility.a.l("Cannot find wrapper for ", viewHolder, ", seems like it is not bound by this adapter: ", this);
        return null;
    }

    private int indexOfWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int size = this.mWrappers.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.mWrappers.get(i10).adapter == adapter) {
                return i10;
            }
        }
        return -1;
    }

    private boolean isAttachedTo(RecyclerView recyclerView) {
        Iterator<WeakReference<RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            if (it.next().get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    private void releaseWrapperAndLocalPosition(WrapperAndLocalPosition wrapperAndLocalPosition) {
        wrapperAndLocalPosition.mInUse = false;
        wrapperAndLocalPosition.mWrapper = null;
        wrapperAndLocalPosition.mLocalPosition = -1;
        this.mReusableHolder = wrapperAndLocalPosition;
    }

    public boolean addAdapter(int i10, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        if (i10 < 0 || i10 > this.mWrappers.size()) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + this.mWrappers.size() + ". Given:" + i10);
        }
        if (hasStableIds()) {
            Preconditions.checkArgument(adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else if (adapter.hasStableIds()) {
            Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        if (findWrapperFor(adapter) != null) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = new NestedAdapterWrapper(adapter, this, this.mViewTypeStorage, this.mStableIdStorage.createStableIdLookup());
        this.mWrappers.add(i10, nestedAdapterWrapper);
        Iterator<WeakReference<RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (nestedAdapterWrapper.getCachedItemCount() > 0) {
            this.mConcatAdapter.notifyItemRangeInserted(countItemsBefore(nestedAdapterWrapper), nestedAdapterWrapper.getCachedItemCount());
        }
        calculateAndUpdateStateRestorationPolicy();
        return true;
    }

    public boolean canRestoreState() {
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            if (!it.next().adapter.canRestoreState()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getBoundAdapter(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            return null;
        }
        return nestedAdapterWrapper.adapter;
    }

    public List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getCopyOfAdapters() {
        if (this.mWrappers.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(this.mWrappers.size());
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().adapter);
        }
        return arrayList;
    }

    public long getItemId(int i10) {
        WrapperAndLocalPosition wrapperAndLocalPositionFindWrapperAndLocalPosition = findWrapperAndLocalPosition(i10);
        long itemId = wrapperAndLocalPositionFindWrapperAndLocalPosition.mWrapper.getItemId(wrapperAndLocalPositionFindWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(wrapperAndLocalPositionFindWrapperAndLocalPosition);
        return itemId;
    }

    public int getItemViewType(int i10) {
        WrapperAndLocalPosition wrapperAndLocalPositionFindWrapperAndLocalPosition = findWrapperAndLocalPosition(i10);
        int itemViewType = wrapperAndLocalPositionFindWrapperAndLocalPosition.mWrapper.getItemViewType(wrapperAndLocalPositionFindWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(wrapperAndLocalPositionFindWrapperAndLocalPosition);
        return itemViewType;
    }

    public int getLocalAdapterPosition(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, RecyclerView.ViewHolder viewHolder, int i10) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            return -1;
        }
        int iCountItemsBefore = i10 - countItemsBefore(nestedAdapterWrapper);
        int itemCount = nestedAdapterWrapper.adapter.getItemCount();
        if (iCountItemsBefore >= 0 && iCountItemsBefore < itemCount) {
            return nestedAdapterWrapper.adapter.findRelativeAdapterPositionIn(adapter, viewHolder, iCountItemsBefore);
        }
        StringBuilder sbQ = a3.a.q(iCountItemsBefore, itemCount, "Detected inconsistent adapter updates. The local position of the view holder maps to ", " which is out of bounds for the adapter with size ", ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
        sbQ.append(viewHolder);
        sbQ.append("adapter:");
        sbQ.append(adapter);
        throw new IllegalStateException(sbQ.toString());
    }

    public int getTotalCount() {
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        int cachedItemCount = 0;
        while (it.hasNext()) {
            cachedItemCount += it.next().getCachedItemCount();
        }
        return cachedItemCount;
    }

    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> getWrappedAdapterAndPosition(int i10) {
        WrapperAndLocalPosition wrapperAndLocalPositionFindWrapperAndLocalPosition = findWrapperAndLocalPosition(i10);
        Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> pair = new Pair<>(wrapperAndLocalPositionFindWrapperAndLocalPosition.mWrapper.adapter, Integer.valueOf(wrapperAndLocalPositionFindWrapperAndLocalPosition.mLocalPosition));
        releaseWrapperAndLocalPosition(wrapperAndLocalPositionFindWrapperAndLocalPosition);
        return pair;
    }

    public boolean hasStableIds() {
        return this.mStableIdMode != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (isAttachedTo(recyclerView)) {
            return;
        }
        this.mAttachedRecyclerViews.add(new WeakReference<>(recyclerView));
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            it.next().adapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        WrapperAndLocalPosition wrapperAndLocalPositionFindWrapperAndLocalPosition = findWrapperAndLocalPosition(i10);
        this.mBinderLookup.put(viewHolder, wrapperAndLocalPositionFindWrapperAndLocalPosition.mWrapper);
        wrapperAndLocalPositionFindWrapperAndLocalPosition.mWrapper.onBindViewHolder(viewHolder, wrapperAndLocalPositionFindWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(wrapperAndLocalPositionFindWrapperAndLocalPosition);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
        this.mConcatAdapter.notifyDataSetChanged();
        calculateAndUpdateStateRestorationPolicy();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return this.mViewTypeStorage.getWrapperForGlobalType(i10).onCreateViewHolder(viewGroup, i10);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        int size = this.mAttachedRecyclerViews.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference<RecyclerView> weakReference = this.mAttachedRecyclerViews.get(size);
            if (weakReference.get() == null) {
                this.mAttachedRecyclerViews.remove(size);
            } else if (weakReference.get() == recyclerView) {
                this.mAttachedRecyclerViews.remove(size);
                break;
            }
            size--;
        }
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            it.next().adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            androidx.core.view.accessibility.a.l("Cannot find wrapper for ", viewHolder, ", seems like it is not bound by this adapter: ", this);
            return false;
        }
        boolean zOnFailedToRecycleView = nestedAdapterWrapper.adapter.onFailedToRecycleView(viewHolder);
        this.mBinderLookup.remove(viewHolder);
        return zOnFailedToRecycleView;
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i10, int i11) {
        this.mConcatAdapter.notifyItemRangeChanged(i10 + countItemsBefore(nestedAdapterWrapper), i11);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeInserted(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i10, int i11) {
        this.mConcatAdapter.notifyItemRangeInserted(i10 + countItemsBefore(nestedAdapterWrapper), i11);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeMoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i10, int i11) {
        int iCountItemsBefore = countItemsBefore(nestedAdapterWrapper);
        this.mConcatAdapter.notifyItemMoved(i10 + iCountItemsBefore, i11 + iCountItemsBefore);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeRemoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i10, int i11) {
        this.mConcatAdapter.notifyItemRangeRemoved(i10 + countItemsBefore(nestedAdapterWrapper), i11);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onStateRestorationPolicyChanged(NestedAdapterWrapper nestedAdapterWrapper) {
        calculateAndUpdateStateRestorationPolicy();
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        getWrapper(viewHolder).adapter.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        getWrapper(viewHolder).adapter.onViewDetachedFromWindow(viewHolder);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            androidx.core.view.accessibility.a.l("Cannot find wrapper for ", viewHolder, ", seems like it is not bound by this adapter: ", this);
        } else {
            nestedAdapterWrapper.adapter.onViewRecycled(viewHolder);
            this.mBinderLookup.remove(viewHolder);
        }
    }

    public boolean removeAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int iIndexOfWrapper = indexOfWrapper(adapter);
        if (iIndexOfWrapper == -1) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = this.mWrappers.get(iIndexOfWrapper);
        int iCountItemsBefore = countItemsBefore(nestedAdapterWrapper);
        this.mWrappers.remove(iIndexOfWrapper);
        this.mConcatAdapter.notifyItemRangeRemoved(iCountItemsBefore, nestedAdapterWrapper.getCachedItemCount());
        Iterator<WeakReference<RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
        nestedAdapterWrapper.dispose();
        calculateAndUpdateStateRestorationPolicy();
        return true;
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i10, int i11, @Nullable Object obj) {
        this.mConcatAdapter.notifyItemRangeChanged(i10 + countItemsBefore(nestedAdapterWrapper), i11, obj);
    }

    public boolean addAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        return addAdapter(this.mWrappers.size(), adapter);
    }
}
