package androidx.leanback.widget;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.DetailsOverviewLogoPresenter;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class FullWidthDetailsOverviewRowPresenter extends RowPresenter {
    public static final int ALIGN_MODE_MIDDLE = 1;
    public static final int ALIGN_MODE_START = 0;
    static final boolean DEBUG = false;
    public static final int STATE_FULL = 1;
    public static final int STATE_HALF = 0;
    public static final int STATE_SMALL = 2;
    static final String TAG = "FullWidthDetailsRP";
    static final Handler sHandler = new Handler();
    OnActionClickedListener mActionClickedListener;
    private int mActionsBackgroundColor;
    private boolean mActionsBackgroundColorSet;
    private int mAlignmentMode;
    private int mBackgroundColor;
    private boolean mBackgroundColorSet;
    final DetailsOverviewLogoPresenter mDetailsOverviewLogoPresenter;
    final Presenter mDetailsPresenter;
    protected int mInitialState;
    private Listener mListener;
    private boolean mParticipatingEntranceTransition;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class ActionsItemBridgeAdapter extends ItemBridgeAdapter {
        ViewHolder mViewHolder;

        public ActionsItemBridgeAdapter(ViewHolder viewHolder) {
            this.mViewHolder = viewHolder;
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.itemView.removeOnLayoutChangeListener(this.mViewHolder.mLayoutChangeListener);
            viewHolder.itemView.addOnLayoutChangeListener(this.mViewHolder.mLayoutChangeListener);
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onBind(final ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mViewHolder.getOnItemViewClickedListener() == null && FullWidthDetailsOverviewRowPresenter.this.mActionClickedListener == null) {
                return;
            }
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), new View.OnClickListener() { // from class: androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter.ActionsItemBridgeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ActionsItemBridgeAdapter.this.mViewHolder.getOnItemViewClickedListener() != null) {
                        BaseOnItemViewClickedListener onItemViewClickedListener = ActionsItemBridgeAdapter.this.mViewHolder.getOnItemViewClickedListener();
                        Presenter.ViewHolder viewHolder2 = viewHolder.getViewHolder();
                        Object item = viewHolder.getItem();
                        ViewHolder viewHolder3 = ActionsItemBridgeAdapter.this.mViewHolder;
                        onItemViewClickedListener.onItemClicked(viewHolder2, item, viewHolder3, viewHolder3.getRow());
                    }
                    OnActionClickedListener onActionClickedListener = FullWidthDetailsOverviewRowPresenter.this.mActionClickedListener;
                    if (onActionClickedListener != null) {
                        onActionClickedListener.onActionClicked((Action) viewHolder.getItem());
                    }
                }
            });
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.itemView.removeOnLayoutChangeListener(this.mViewHolder.mLayoutChangeListener);
            this.mViewHolder.checkFirstAndLastPosition(false);
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mViewHolder.getOnItemViewClickedListener() == null && FullWidthDetailsOverviewRowPresenter.this.mActionClickedListener == null) {
                return;
            }
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), null);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class ViewHolder extends RowPresenter.ViewHolder {
        ItemBridgeAdapter mActionBridgeAdapter;
        final HorizontalGridView mActionsRow;
        final OnChildSelectedListener mChildSelectedListener;
        final ViewGroup mDetailsDescriptionFrame;
        final Presenter.ViewHolder mDetailsDescriptionViewHolder;
        final DetailsOverviewLogoPresenter.ViewHolder mDetailsLogoViewHolder;
        final View.OnLayoutChangeListener mLayoutChangeListener;
        int mNumItems;
        final FrameLayout mOverviewFrame;
        final ViewGroup mOverviewRoot;
        protected final DetailsOverviewRow.Listener mRowListener;
        final RecyclerView.OnScrollListener mScrollListener;
        int mState;
        final Runnable mUpdateDrawableCallback;

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        public class DetailsOverviewRowListener extends DetailsOverviewRow.Listener {
            public DetailsOverviewRowListener() {
            }

            @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
            public void onActionsAdapterChanged(DetailsOverviewRow detailsOverviewRow) {
                ViewHolder.this.bindActions(detailsOverviewRow.getActionsAdapter());
            }

            @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
            public void onImageDrawableChanged(DetailsOverviewRow detailsOverviewRow) {
                Handler handler = FullWidthDetailsOverviewRowPresenter.sHandler;
                handler.removeCallbacks(ViewHolder.this.mUpdateDrawableCallback);
                handler.post(ViewHolder.this.mUpdateDrawableCallback);
            }

            @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
            public void onItemChanged(DetailsOverviewRow detailsOverviewRow) {
                ViewHolder viewHolder = ViewHolder.this;
                Presenter.ViewHolder viewHolder2 = viewHolder.mDetailsDescriptionViewHolder;
                if (viewHolder2 != null) {
                    FullWidthDetailsOverviewRowPresenter.this.mDetailsPresenter.onUnbindViewHolder(viewHolder2);
                }
                ViewHolder viewHolder3 = ViewHolder.this;
                FullWidthDetailsOverviewRowPresenter.this.mDetailsPresenter.onBindViewHolder(viewHolder3.mDetailsDescriptionViewHolder, detailsOverviewRow.getItem());
            }
        }

        public ViewHolder(View view, Presenter presenter, DetailsOverviewLogoPresenter detailsOverviewLogoPresenter) throws Resources.NotFoundException {
            super(view);
            this.mRowListener = createRowListener();
            this.mState = 0;
            this.mUpdateDrawableCallback = new Runnable() { // from class: androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter.ViewHolder.1
                @Override // java.lang.Runnable
                public void run() {
                    Row row = ViewHolder.this.getRow();
                    if (row == null) {
                        return;
                    }
                    ViewHolder viewHolder = ViewHolder.this;
                    FullWidthDetailsOverviewRowPresenter.this.mDetailsOverviewLogoPresenter.onBindViewHolder(viewHolder.mDetailsLogoViewHolder, row);
                }
            };
            this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter.ViewHolder.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    ViewHolder.this.checkFirstAndLastPosition(false);
                }
            };
            OnChildSelectedListener onChildSelectedListener = new OnChildSelectedListener() { // from class: androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter.ViewHolder.3
                @Override // androidx.leanback.widget.OnChildSelectedListener
                public void onChildSelected(ViewGroup viewGroup, View view2, int i10, long j10) {
                    ViewHolder.this.dispatchItemSelection(view2);
                }
            };
            this.mChildSelectedListener = onChildSelectedListener;
            RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter.ViewHolder.4
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
                    ViewHolder.this.checkFirstAndLastPosition(true);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
                }
            };
            this.mScrollListener = onScrollListener;
            ViewGroup viewGroup = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_root);
            this.mOverviewRoot = viewGroup;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(androidx.leanback.R.id.details_frame);
            this.mOverviewFrame = frameLayout;
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_overview_description);
            this.mDetailsDescriptionFrame = viewGroup2;
            HorizontalGridView horizontalGridView = (HorizontalGridView) frameLayout.findViewById(androidx.leanback.R.id.details_overview_actions);
            this.mActionsRow = horizontalGridView;
            horizontalGridView.setHasOverlappingRendering(false);
            horizontalGridView.setOnScrollListener(onScrollListener);
            horizontalGridView.setAdapter(this.mActionBridgeAdapter);
            horizontalGridView.setOnChildSelectedListener(onChildSelectedListener);
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_actions_fade_size);
            horizontalGridView.setFadingRightEdgeLength(dimensionPixelSize);
            horizontalGridView.setFadingLeftEdgeLength(dimensionPixelSize);
            Presenter.ViewHolder viewHolderOnCreateViewHolder = presenter.onCreateViewHolder(viewGroup2);
            this.mDetailsDescriptionViewHolder = viewHolderOnCreateViewHolder;
            viewGroup2.addView(viewHolderOnCreateViewHolder.view);
            DetailsOverviewLogoPresenter.ViewHolder viewHolder = (DetailsOverviewLogoPresenter.ViewHolder) detailsOverviewLogoPresenter.onCreateViewHolder(viewGroup);
            this.mDetailsLogoViewHolder = viewHolder;
            viewGroup.addView(viewHolder.view);
        }

        public void bindActions(ObjectAdapter objectAdapter) {
            this.mActionBridgeAdapter.setAdapter(objectAdapter);
            this.mActionsRow.setAdapter(this.mActionBridgeAdapter);
            this.mNumItems = this.mActionBridgeAdapter.getItemCount();
        }

        public void checkFirstAndLastPosition(boolean z9) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition = this.mActionsRow.findViewHolderForPosition(this.mNumItems - 1);
            if (viewHolderFindViewHolderForPosition != null) {
                viewHolderFindViewHolderForPosition.itemView.getRight();
                this.mActionsRow.getWidth();
            }
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition2 = this.mActionsRow.findViewHolderForPosition(0);
            if (viewHolderFindViewHolderForPosition2 != null) {
                viewHolderFindViewHolderForPosition2.itemView.getLeft();
            }
        }

        public DetailsOverviewRow.Listener createRowListener() {
            return new DetailsOverviewRowListener();
        }

        public void dispatchItemSelection(View view) {
            if (isSelected()) {
                HorizontalGridView horizontalGridView = this.mActionsRow;
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) (view != null ? horizontalGridView.getChildViewHolder(view) : horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition()));
                if (viewHolder == null) {
                    if (getOnItemViewSelectedListener() != null) {
                        getOnItemViewSelectedListener().onItemSelected(null, null, this, getRow());
                    }
                } else if (getOnItemViewSelectedListener() != null) {
                    getOnItemViewSelectedListener().onItemSelected(viewHolder.getViewHolder(), viewHolder.getItem(), this, getRow());
                }
            }
        }

        public final ViewGroup getActionsRow() {
            return this.mActionsRow;
        }

        public final ViewGroup getDetailsDescriptionFrame() {
            return this.mDetailsDescriptionFrame;
        }

        public final Presenter.ViewHolder getDetailsDescriptionViewHolder() {
            return this.mDetailsDescriptionViewHolder;
        }

        public final DetailsOverviewLogoPresenter.ViewHolder getLogoViewHolder() {
            return this.mDetailsLogoViewHolder;
        }

        public final ViewGroup getOverviewView() {
            return this.mOverviewFrame;
        }

        public final int getState() {
            return this.mState;
        }

        public void onBind() {
            DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) getRow();
            bindActions(detailsOverviewRow.getActionsAdapter());
            detailsOverviewRow.addListener(this.mRowListener);
        }

        public void onUnbind() {
            unbindActions();
            ((DetailsOverviewRow) getRow()).removeListener(this.mRowListener);
            FullWidthDetailsOverviewRowPresenter.sHandler.removeCallbacks(this.mUpdateDrawableCallback);
        }

        public void unbindActions() {
            this.mActionBridgeAdapter.setAdapter(null);
            this.mActionsRow.setAdapter(null);
            this.mNumItems = 0;
        }
    }

    public FullWidthDetailsOverviewRowPresenter(Presenter presenter, DetailsOverviewLogoPresenter detailsOverviewLogoPresenter) {
        this.mInitialState = 0;
        this.mBackgroundColor = 0;
        this.mActionsBackgroundColor = 0;
        setHeaderPresenter(null);
        setSelectEffectEnabled(false);
        this.mDetailsPresenter = presenter;
        this.mDetailsOverviewLogoPresenter = detailsOverviewLogoPresenter;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) throws Resources.NotFoundException {
        final ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutResourceId(), viewGroup, false), this.mDetailsPresenter, this.mDetailsOverviewLogoPresenter);
        this.mDetailsOverviewLogoPresenter.setContext(viewHolder.mDetailsLogoViewHolder, viewHolder, this);
        setState(viewHolder, this.mInitialState);
        viewHolder.mActionBridgeAdapter = new ActionsItemBridgeAdapter(viewHolder);
        FrameLayout frameLayout = viewHolder.mOverviewFrame;
        if (this.mBackgroundColorSet) {
            frameLayout.setBackgroundColor(this.mBackgroundColor);
        }
        if (this.mActionsBackgroundColorSet) {
            frameLayout.findViewById(androidx.leanback.R.id.details_overview_actions_background).setBackgroundColor(this.mActionsBackgroundColor);
        }
        RoundedRectHelper.setClipToRoundedOutline(frameLayout, true);
        if (!getSelectEffectEnabled()) {
            viewHolder.mOverviewFrame.setForeground(null);
        }
        viewHolder.mActionsRow.setOnUnhandledKeyListener(new BaseGridView.OnUnhandledKeyListener() { // from class: androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter.1
            @Override // androidx.leanback.widget.BaseGridView.OnUnhandledKeyListener
            public boolean onUnhandledKey(KeyEvent keyEvent) {
                if (viewHolder.getOnKeyListener() != null) {
                    return viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent);
                }
                return false;
            }
        });
        return viewHolder;
    }

    public final int getActionsBackgroundColor() {
        return this.mActionsBackgroundColor;
    }

    public final int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public final int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public final int getInitialState() {
        return this.mInitialState;
    }

    public int getLayoutResourceId() {
        return androidx.leanback.R.layout.lb_fullwidth_details_overview;
    }

    public OnActionClickedListener getOnActionClickedListener() {
        return this.mActionClickedListener;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isClippingChildren() {
        return true;
    }

    public final boolean isParticipatingEntranceTransition() {
        return this.mParticipatingEntranceTransition;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public final boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public final void notifyOnBindLogo(ViewHolder viewHolder) throws Resources.NotFoundException {
        onLayoutOverviewFrame(viewHolder, viewHolder.getState(), true);
        onLayoutLogo(viewHolder, viewHolder.getState(), true);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onBindLogo(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        this.mDetailsOverviewLogoPresenter.onBindViewHolder(viewHolder2.mDetailsLogoViewHolder, detailsOverviewRow);
        this.mDetailsPresenter.onBindViewHolder(viewHolder2.mDetailsDescriptionViewHolder, detailsOverviewRow.getItem());
        viewHolder2.onBind();
    }

    public void onLayoutLogo(ViewHolder viewHolder, int i10, boolean z9) throws Resources.NotFoundException {
        View view = viewHolder.getLogoViewHolder().view;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (this.mAlignmentMode != 1) {
            marginLayoutParams.setMarginStart(view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_logo_margin_start));
        } else {
            marginLayoutParams.setMarginStart(view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_left) - marginLayoutParams.width);
        }
        int state = viewHolder.getState();
        if (state == 0) {
            marginLayoutParams.topMargin = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_description_margin_top) + view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_actions_height) + view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_blank_height);
        } else if (state != 2) {
            marginLayoutParams.topMargin = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_blank_height) - (marginLayoutParams.height / 2);
        } else {
            marginLayoutParams.topMargin = 0;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public void onLayoutOverviewFrame(ViewHolder viewHolder, int i10, boolean z9) throws Resources.NotFoundException {
        int dimensionPixelSize;
        boolean z10 = i10 == 2;
        boolean z11 = viewHolder.getState() == 2;
        if (z10 != z11 || z9) {
            Resources resources = viewHolder.view.getResources();
            int dimensionPixelSize2 = this.mDetailsOverviewLogoPresenter.isBoundToImage(viewHolder.getLogoViewHolder(), (DetailsOverviewRow) viewHolder.getRow()) ? viewHolder.getLogoViewHolder().view.getLayoutParams().width : 0;
            if (this.mAlignmentMode != 1) {
                if (z11) {
                    dimensionPixelSize = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_logo_margin_start);
                } else {
                    dimensionPixelSize2 += resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_logo_margin_start);
                    dimensionPixelSize = 0;
                }
            } else if (z11) {
                dimensionPixelSize = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_left) - dimensionPixelSize2;
            } else {
                dimensionPixelSize2 = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_left);
                dimensionPixelSize = 0;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.getOverviewView().getLayoutParams();
            marginLayoutParams.topMargin = z11 ? 0 : resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_blank_height);
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.leftMargin = dimensionPixelSize;
            viewHolder.getOverviewView().setLayoutParams(marginLayoutParams);
            ViewGroup detailsDescriptionFrame = viewHolder.getDetailsDescriptionFrame();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) detailsDescriptionFrame.getLayoutParams();
            marginLayoutParams2.setMarginStart(dimensionPixelSize2);
            detailsDescriptionFrame.setLayoutParams(marginLayoutParams2);
            ViewGroup actionsRow = viewHolder.getActionsRow();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) actionsRow.getLayoutParams();
            marginLayoutParams3.setMarginStart(dimensionPixelSize2);
            marginLayoutParams3.height = z11 ? 0 : resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_v2_actions_height);
            actionsRow.setLayoutParams(marginLayoutParams3);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewAttachedToWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        this.mDetailsPresenter.onViewAttachedToWindow(viewHolder2.mDetailsDescriptionViewHolder);
        this.mDetailsOverviewLogoPresenter.onViewAttachedToWindow(viewHolder2.mDetailsLogoViewHolder);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onRowViewDetachedFromWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        this.mDetailsPresenter.onViewDetachedFromWindow(viewHolder2.mDetailsDescriptionViewHolder);
        this.mDetailsOverviewLogoPresenter.onViewDetachedFromWindow(viewHolder2.mDetailsLogoViewHolder);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onSelectLevelChanged(RowPresenter.ViewHolder viewHolder) {
        super.onSelectLevelChanged(viewHolder);
        if (getSelectEffectEnabled()) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            ((ColorDrawable) viewHolder2.mOverviewFrame.getForeground().mutate()).setColor(viewHolder2.mColorDimmer.getPaint().getColor());
        }
    }

    public void onStateChanged(ViewHolder viewHolder, int i10) throws Resources.NotFoundException {
        onLayoutOverviewFrame(viewHolder, i10, false);
        onLayoutLogo(viewHolder, i10, false);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.onUnbind();
        this.mDetailsPresenter.onUnbindViewHolder(viewHolder2.mDetailsDescriptionViewHolder);
        this.mDetailsOverviewLogoPresenter.onUnbindViewHolder(viewHolder2.mDetailsLogoViewHolder);
        super.onUnbindRowViewHolder(viewHolder);
    }

    public final void setActionsBackgroundColor(int i10) {
        this.mActionsBackgroundColor = i10;
        this.mActionsBackgroundColorSet = true;
    }

    public final void setAlignmentMode(int i10) {
        this.mAlignmentMode = i10;
    }

    public final void setBackgroundColor(int i10) {
        this.mBackgroundColor = i10;
        this.mBackgroundColorSet = true;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void setEntranceTransitionState(RowPresenter.ViewHolder viewHolder, boolean z9) {
        super.setEntranceTransitionState(viewHolder, z9);
        if (this.mParticipatingEntranceTransition) {
            viewHolder.view.setVisibility(z9 ? 0 : 4);
        }
    }

    public final void setInitialState(int i10) {
        this.mInitialState = i10;
    }

    public final void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.mActionClickedListener = onActionClickedListener;
    }

    public final void setParticipatingEntranceTransition(boolean z9) {
        this.mParticipatingEntranceTransition = z9;
    }

    public final void setState(ViewHolder viewHolder, int i10) throws Resources.NotFoundException {
        if (viewHolder.getState() != i10) {
            int state = viewHolder.getState();
            viewHolder.mState = i10;
            onStateChanged(viewHolder, state);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class Listener {
        public void onBindLogo(ViewHolder viewHolder) {
        }
    }

    public FullWidthDetailsOverviewRowPresenter(Presenter presenter) {
        this(presenter, new DetailsOverviewLogoPresenter());
    }
}
