package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Presenter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ItemBridgeAdapter extends RecyclerView.Adapter implements FacetProviderAdapter {
    static final boolean DEBUG = false;
    static final String TAG = "ItemBridgeAdapter";
    private ObjectAdapter mAdapter;
    private AdapterListener mAdapterListener;
    private ObjectAdapter.DataObserver mDataObserver;
    FocusHighlightHandler mFocusHighlight;
    private PresenterSelector mPresenterSelector;
    private ArrayList<Presenter> mPresenters;
    Wrapper mWrapper;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ChainingFocusChangeListener implements View.OnFocusChangeListener {
        final View.OnFocusChangeListener mChainedListener;
        FocusHighlightHandler mFocusHighlight;
        boolean mHasWrapper;

        public ChainingFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener, boolean z9, FocusHighlightHandler focusHighlightHandler) {
            this.mChainedListener = onFocusChangeListener;
            this.mHasWrapper = z9;
            this.mFocusHighlight = focusHighlightHandler;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z9) {
            if (this.mHasWrapper) {
                view = (View) view.getParent();
            }
            this.mFocusHighlight.onItemFocused(view, z9);
            View.OnFocusChangeListener onFocusChangeListener = this.mChainedListener;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(view, z9);
            }
        }

        public void update(boolean z9, FocusHighlightHandler focusHighlightHandler) {
            this.mHasWrapper = z9;
            this.mFocusHighlight = focusHighlightHandler;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ViewHolder extends RecyclerView.ViewHolder implements FacetProvider {
        Object mExtraObject;
        final Presenter.ViewHolder mHolder;
        Object mItem;
        final Presenter mPresenter;

        public ViewHolder(Presenter presenter, View view, Presenter.ViewHolder viewHolder) {
            super(view);
            this.mPresenter = presenter;
            this.mHolder = viewHolder;
        }

        public final Object getExtraObject() {
            return this.mExtraObject;
        }

        @Override // androidx.leanback.widget.FacetProvider
        public Object getFacet(Class<?> cls) {
            return this.mHolder.getFacet(cls);
        }

        public final Object getItem() {
            return this.mItem;
        }

        public final Presenter getPresenter() {
            return this.mPresenter;
        }

        public final Presenter.ViewHolder getViewHolder() {
            return this.mHolder;
        }

        public void setExtraObject(Object obj) {
            this.mExtraObject = obj;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class Wrapper {
        public abstract View createWrapper(View view);

        public abstract void wrap(View view, View view2);
    }

    public ItemBridgeAdapter(ObjectAdapter objectAdapter, PresenterSelector presenterSelector) {
        this.mPresenters = new ArrayList<>();
        this.mDataObserver = new ObjectAdapter.DataObserver() { // from class: androidx.leanback.widget.ItemBridgeAdapter.1
            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onChanged() {
                ItemBridgeAdapter.this.notifyDataSetChanged();
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemMoved(int i10, int i11) {
                ItemBridgeAdapter.this.notifyItemMoved(i10, i11);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeChanged(int i10, int i11) {
                ItemBridgeAdapter.this.notifyItemRangeChanged(i10, i11);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeInserted(int i10, int i11) {
                ItemBridgeAdapter.this.notifyItemRangeInserted(i10, i11);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeRemoved(int i10, int i11) {
                ItemBridgeAdapter.this.notifyItemRangeRemoved(i10, i11);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeChanged(int i10, int i11, Object obj) {
                ItemBridgeAdapter.this.notifyItemRangeChanged(i10, i11, obj);
            }
        };
        setAdapter(objectAdapter);
        this.mPresenterSelector = presenterSelector;
    }

    public void clear() {
        setAdapter(null);
    }

    @Override // androidx.leanback.widget.FacetProviderAdapter
    public FacetProvider getFacetProvider(int i10) {
        return this.mPresenters.get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter != null) {
            return objectAdapter.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return this.mAdapter.getId(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        PresenterSelector presenterSelector = this.mPresenterSelector;
        if (presenterSelector == null) {
            presenterSelector = this.mAdapter.getPresenterSelector();
        }
        Presenter presenter = presenterSelector.getPresenter(this.mAdapter.get(i10));
        int iIndexOf = this.mPresenters.indexOf(presenter);
        if (iIndexOf < 0) {
            this.mPresenters.add(presenter);
            iIndexOf = this.mPresenters.indexOf(presenter);
            onAddPresenter(presenter, iIndexOf);
            AdapterListener adapterListener = this.mAdapterListener;
            if (adapterListener != null) {
                adapterListener.onAddPresenter(presenter, iIndexOf);
            }
        }
        return iIndexOf;
    }

    public ArrayList<Presenter> getPresenterMapper() {
        return this.mPresenters;
    }

    public Wrapper getWrapper() {
        return this.mWrapper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Object obj = this.mAdapter.get(i10);
        viewHolder2.mItem = obj;
        viewHolder2.mPresenter.onBindViewHolder(viewHolder2.mHolder, obj);
        onBind(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onBind(viewHolder2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        Presenter.ViewHolder viewHolderOnCreateViewHolder;
        View viewCreateWrapper;
        Presenter presenter = this.mPresenters.get(i10);
        Wrapper wrapper = this.mWrapper;
        if (wrapper != null) {
            viewCreateWrapper = wrapper.createWrapper(viewGroup);
            viewHolderOnCreateViewHolder = presenter.onCreateViewHolder(viewGroup);
            this.mWrapper.wrap(viewCreateWrapper, viewHolderOnCreateViewHolder.view);
        } else {
            viewHolderOnCreateViewHolder = presenter.onCreateViewHolder(viewGroup);
            viewCreateWrapper = viewHolderOnCreateViewHolder.view;
        }
        ViewHolder viewHolder = new ViewHolder(presenter, viewCreateWrapper, viewHolderOnCreateViewHolder);
        onCreate(viewHolder);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onCreate(viewHolder);
        }
        View view = viewHolder.mHolder.view;
        View.OnFocusChangeListener onFocusChangeListener = view.getOnFocusChangeListener();
        FocusHighlightHandler focusHighlightHandler = this.mFocusHighlight;
        if (focusHighlightHandler == null) {
            if (onFocusChangeListener instanceof ChainingFocusChangeListener) {
                view.setOnFocusChangeListener(((ChainingFocusChangeListener) onFocusChangeListener).mChainedListener);
            }
            return viewHolder;
        }
        boolean z9 = onFocusChangeListener instanceof ChainingFocusChangeListener;
        Wrapper wrapper2 = this.mWrapper;
        if (z9) {
            ((ChainingFocusChangeListener) onFocusChangeListener).update(wrapper2 != null, focusHighlightHandler);
        } else {
            view.setOnFocusChangeListener(new ChainingFocusChangeListener(onFocusChangeListener, wrapper2 != null, focusHighlightHandler));
        }
        this.mFocusHighlight.onInitializeView(viewCreateWrapper);
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        onViewRecycled(viewHolder);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        onAttachedToWindow(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onAttachedToWindow(viewHolder2);
        }
        viewHolder2.mPresenter.onViewAttachedToWindow(viewHolder2.mHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mPresenter.onViewDetachedFromWindow(viewHolder2.mHolder);
        onDetachedFromWindow(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onDetachedFromWindow(viewHolder2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mPresenter.onUnbindViewHolder(viewHolder2.mHolder);
        onUnbind(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onUnbind(viewHolder2);
        }
        viewHolder2.mItem = null;
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        ObjectAdapter objectAdapter2 = this.mAdapter;
        if (objectAdapter == objectAdapter2) {
            return;
        }
        if (objectAdapter2 != null) {
            objectAdapter2.unregisterObserver(this.mDataObserver);
        }
        this.mAdapter = objectAdapter;
        if (objectAdapter == null) {
            notifyDataSetChanged();
            return;
        }
        objectAdapter.registerObserver(this.mDataObserver);
        if (hasStableIds() != this.mAdapter.hasStableIds()) {
            setHasStableIds(this.mAdapter.hasStableIds());
        }
        notifyDataSetChanged();
    }

    public void setAdapterListener(AdapterListener adapterListener) {
        this.mAdapterListener = adapterListener;
    }

    public void setFocusHighlight(FocusHighlightHandler focusHighlightHandler) {
        this.mFocusHighlight = focusHighlightHandler;
    }

    public void setPresenter(PresenterSelector presenterSelector) {
        this.mPresenterSelector = presenterSelector;
        notifyDataSetChanged();
    }

    public void setPresenterMapper(ArrayList<Presenter> arrayList) {
        this.mPresenters = arrayList;
    }

    public void setWrapper(Wrapper wrapper) {
        this.mWrapper = wrapper;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class AdapterListener {
        public void onBind(ViewHolder viewHolder, List list) {
            onBind(viewHolder);
        }

        public void onBind(ViewHolder viewHolder) {
        }

        public void onAttachedToWindow(ViewHolder viewHolder) {
        }

        public void onCreate(ViewHolder viewHolder) {
        }

        public void onDetachedFromWindow(ViewHolder viewHolder) {
        }

        public void onUnbind(ViewHolder viewHolder) {
        }

        public void onAddPresenter(Presenter presenter, int i10) {
        }
    }

    public void onAttachedToWindow(ViewHolder viewHolder) {
    }

    public void onBind(ViewHolder viewHolder) {
    }

    public void onCreate(ViewHolder viewHolder) {
    }

    public void onDetachedFromWindow(ViewHolder viewHolder) {
    }

    public void onUnbind(ViewHolder viewHolder) {
    }

    public ItemBridgeAdapter(ObjectAdapter objectAdapter) {
        this(objectAdapter, null);
    }

    public ItemBridgeAdapter() {
        this.mPresenters = new ArrayList<>();
        this.mDataObserver = new ObjectAdapter.DataObserver() { // from class: androidx.leanback.widget.ItemBridgeAdapter.1
            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onChanged() {
                ItemBridgeAdapter.this.notifyDataSetChanged();
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemMoved(int i10, int i11) {
                ItemBridgeAdapter.this.notifyItemMoved(i10, i11);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeChanged(int i10, int i11) {
                ItemBridgeAdapter.this.notifyItemRangeChanged(i10, i11);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeInserted(int i10, int i11) {
                ItemBridgeAdapter.this.notifyItemRangeInserted(i10, i11);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeRemoved(int i10, int i11) {
                ItemBridgeAdapter.this.notifyItemRangeRemoved(i10, i11);
            }

            @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
            public void onItemRangeChanged(int i10, int i11, Object obj) {
                ItemBridgeAdapter.this.notifyItemRangeChanged(i10, i11, obj);
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10, List list) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Object obj = this.mAdapter.get(i10);
        viewHolder2.mItem = obj;
        viewHolder2.mPresenter.onBindViewHolder(viewHolder2.mHolder, obj, list);
        onBind(viewHolder2);
        AdapterListener adapterListener = this.mAdapterListener;
        if (adapterListener != null) {
            adapterListener.onBind(viewHolder2, list);
        }
    }

    public void onAddPresenter(Presenter presenter, int i10) {
    }
}
