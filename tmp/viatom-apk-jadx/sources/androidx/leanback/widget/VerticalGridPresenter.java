package androidx.leanback.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.system.Settings;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.ShadowOverlayHelper;
import androidx.window.layout.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class VerticalGridPresenter extends Presenter {
    private static final boolean DEBUG = false;
    private static final String TAG = "GridPresenter";
    private int mFocusZoomFactor;
    private boolean mKeepChildForeground;
    private int mNumColumns;
    private OnItemViewClickedListener mOnItemViewClickedListener;
    private OnItemViewSelectedListener mOnItemViewSelectedListener;
    private boolean mRoundedCornersEnabled;
    private boolean mShadowEnabled;
    ShadowOverlayHelper mShadowOverlayHelper;
    private ItemBridgeAdapter.Wrapper mShadowOverlayWrapper;
    private boolean mUseFocusDimmer;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class VerticalGridItemBridgeAdapter extends ItemBridgeAdapter {
        public VerticalGridItemBridgeAdapter() {
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.itemView.setActivated(true);
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onBind(final ItemBridgeAdapter.ViewHolder viewHolder) {
            if (VerticalGridPresenter.this.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener(new View.OnClickListener() { // from class: androidx.leanback.widget.VerticalGridPresenter.VerticalGridItemBridgeAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (VerticalGridPresenter.this.getOnItemViewClickedListener() != null) {
                            OnItemViewClickedListener onItemViewClickedListener = VerticalGridPresenter.this.getOnItemViewClickedListener();
                            ItemBridgeAdapter.ViewHolder viewHolder2 = viewHolder;
                            onItemViewClickedListener.onItemClicked(viewHolder2.mHolder, viewHolder2.mItem, null, null);
                        }
                    }
                });
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                TransitionHelper.setTransitionGroup((ViewGroup) view, true);
            }
            ShadowOverlayHelper shadowOverlayHelper = VerticalGridPresenter.this.mShadowOverlayHelper;
            if (shadowOverlayHelper != null) {
                shadowOverlayHelper.onViewCreated(viewHolder.itemView);
            }
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (VerticalGridPresenter.this.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener(null);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ViewHolder extends Presenter.ViewHolder {
        final VerticalGridView mGridView;
        boolean mInitialized;
        ItemBridgeAdapter mItemBridgeAdapter;

        public ViewHolder(VerticalGridView verticalGridView) {
            super(verticalGridView);
            this.mGridView = verticalGridView;
        }

        public VerticalGridView getGridView() {
            return this.mGridView;
        }
    }

    public VerticalGridPresenter(int i10, boolean z9) {
        this.mNumColumns = -1;
        this.mShadowEnabled = true;
        this.mKeepChildForeground = true;
        this.mRoundedCornersEnabled = true;
        this.mFocusZoomFactor = i10;
        this.mUseFocusDimmer = z9;
    }

    public final boolean areChildRoundedCornersEnabled() {
        return this.mRoundedCornersEnabled;
    }

    public ViewHolder createGridViewHolder(ViewGroup viewGroup) {
        return new ViewHolder((VerticalGridView) LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_vertical_grid, viewGroup, false).findViewById(androidx.leanback.R.id.browse_grid));
    }

    public ShadowOverlayHelper.Options createShadowOverlayOptions() {
        return ShadowOverlayHelper.Options.DEFAULT;
    }

    public final void enableChildRoundedCorners(boolean z9) {
        this.mRoundedCornersEnabled = z9;
    }

    public final int getFocusZoomFactor() {
        return this.mFocusZoomFactor;
    }

    public final boolean getKeepChildForeground() {
        return this.mKeepChildForeground;
    }

    public int getNumberOfColumns() {
        return this.mNumColumns;
    }

    public final OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.mOnItemViewClickedListener;
    }

    public final OnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.mOnItemViewSelectedListener;
    }

    public final boolean getShadowEnabled() {
        return this.mShadowEnabled;
    }

    public void initializeGridViewHolder(final ViewHolder viewHolder) {
        if (this.mNumColumns == -1) {
            c.g("Number of columns must be set");
            return;
        }
        viewHolder.getGridView().setNumColumns(this.mNumColumns);
        viewHolder.mInitialized = true;
        Context context = viewHolder.mGridView.getContext();
        if (this.mShadowOverlayHelper == null) {
            ShadowOverlayHelper shadowOverlayHelperBuild = new ShadowOverlayHelper.Builder().needsOverlay(this.mUseFocusDimmer).needsShadow(needsDefaultShadow()).needsRoundedCorner(areChildRoundedCornersEnabled()).preferZOrder(isUsingZOrder(context)).keepForegroundDrawable(this.mKeepChildForeground).options(createShadowOverlayOptions()).build(context);
            this.mShadowOverlayHelper = shadowOverlayHelperBuild;
            if (shadowOverlayHelperBuild.needsWrapper()) {
                this.mShadowOverlayWrapper = new ItemBridgeAdapterShadowOverlayWrapper(this.mShadowOverlayHelper);
            }
        }
        viewHolder.mItemBridgeAdapter.setWrapper(this.mShadowOverlayWrapper);
        this.mShadowOverlayHelper.prepareParentForShadow(viewHolder.mGridView);
        viewHolder.getGridView().setFocusDrawingOrderEnabled(this.mShadowOverlayHelper.getShadowType() != 3);
        FocusHighlightHelper.setupBrowseItemFocusHighlight(viewHolder.mItemBridgeAdapter, this.mFocusZoomFactor, this.mUseFocusDimmer);
        viewHolder.getGridView().setOnChildSelectedListener(new OnChildSelectedListener() { // from class: androidx.leanback.widget.VerticalGridPresenter.1
            @Override // androidx.leanback.widget.OnChildSelectedListener
            public void onChildSelected(ViewGroup viewGroup, View view, int i10, long j10) {
                VerticalGridPresenter.this.selectChildView(viewHolder, view);
            }
        });
    }

    public final boolean isFocusDimmerUsed() {
        return this.mUseFocusDimmer;
    }

    public boolean isUsingDefaultShadow() {
        return ShadowOverlayHelper.supportsShadow();
    }

    public boolean isUsingZOrder(Context context) {
        return !Settings.getInstance(context).preferStaticShadows();
    }

    public final boolean needsDefaultShadow() {
        return isUsingDefaultShadow() && getShadowEnabled();
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mItemBridgeAdapter.setAdapter((ObjectAdapter) obj);
        viewHolder2.getGridView().setAdapter(viewHolder2.mItemBridgeAdapter);
    }

    @Override // androidx.leanback.widget.Presenter
    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolderCreateGridViewHolder = createGridViewHolder(viewGroup);
        viewHolderCreateGridViewHolder.mInitialized = false;
        viewHolderCreateGridViewHolder.mItemBridgeAdapter = new VerticalGridItemBridgeAdapter();
        initializeGridViewHolder(viewHolderCreateGridViewHolder);
        if (viewHolderCreateGridViewHolder.mInitialized) {
            return viewHolderCreateGridViewHolder;
        }
        a2.a.j("super.initializeGridViewHolder() must be called");
        return null;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mItemBridgeAdapter.setAdapter(null);
        viewHolder2.getGridView().setAdapter(null);
    }

    public void selectChildView(ViewHolder viewHolder, View view) {
        if (getOnItemViewSelectedListener() != null) {
            ItemBridgeAdapter.ViewHolder viewHolder2 = view == null ? null : (ItemBridgeAdapter.ViewHolder) viewHolder.getGridView().getChildViewHolder(view);
            if (viewHolder2 == null) {
                getOnItemViewSelectedListener().onItemSelected(null, null, null, null);
            } else {
                getOnItemViewSelectedListener().onItemSelected(viewHolder2.mHolder, viewHolder2.mItem, null, null);
            }
        }
    }

    public void setEntranceTransitionState(ViewHolder viewHolder, boolean z9) {
        viewHolder.mGridView.setChildrenVisibility(z9 ? 0 : 4);
    }

    public final void setKeepChildForeground(boolean z9) {
        this.mKeepChildForeground = z9;
    }

    public void setNumberOfColumns(int i10) {
        if (i10 < 0) {
            com.google.gson.internal.a.n("Invalid number of columns");
        } else if (this.mNumColumns != i10) {
            this.mNumColumns = i10;
        }
    }

    public final void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.mOnItemViewClickedListener = onItemViewClickedListener;
    }

    public final void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.mOnItemViewSelectedListener = onItemViewSelectedListener;
    }

    public final void setShadowEnabled(boolean z9) {
        this.mShadowEnabled = z9;
    }

    public VerticalGridPresenter(int i10) {
        this(i10, true);
    }

    public VerticalGridPresenter() {
        this(3);
    }
}
