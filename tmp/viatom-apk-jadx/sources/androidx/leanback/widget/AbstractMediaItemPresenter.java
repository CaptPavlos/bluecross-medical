package androidx.leanback.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.leanback.widget.MultiActionsProvider;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class AbstractMediaItemPresenter extends RowPresenter {
    public static final int PLAY_STATE_INITIAL = 0;
    public static final int PLAY_STATE_PAUSED = 1;
    public static final int PLAY_STATE_PLAYING = 2;
    static final Rect sTempRect = new Rect();
    private int mBackgroundColor;
    private boolean mBackgroundColorSet;
    private Presenter mMediaItemActionPresenter;
    private boolean mMediaRowSeparator;
    private int mThemeId;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ViewHolder extends RowPresenter.ViewHolder {
        private final List<Presenter.ViewHolder> mActionViewHolders;
        ValueAnimator mFocusViewAnimator;
        private final ViewGroup mMediaItemActionsContainer;
        private final View mMediaItemDetailsView;
        private final TextView mMediaItemDurationView;
        private final TextView mMediaItemNameView;
        final TextView mMediaItemNumberView;
        final ViewFlipper mMediaItemNumberViewFlipper;
        final View mMediaItemPausedView;
        final View mMediaItemPlayingView;
        MultiActionsProvider.MultiAction[] mMediaItemRowActions;
        private final View mMediaItemRowSeparator;
        final View mMediaRowView;
        AbstractMediaItemPresenter mRowPresenter;
        final View mSelectorView;

        public ViewHolder(View view) {
            super(view);
            this.mSelectorView = view.findViewById(androidx.leanback.R.id.mediaRowSelector);
            this.mMediaRowView = view.findViewById(androidx.leanback.R.id.mediaItemRow);
            this.mMediaItemDetailsView = view.findViewById(androidx.leanback.R.id.mediaItemDetails);
            this.mMediaItemNameView = (TextView) view.findViewById(androidx.leanback.R.id.mediaItemName);
            this.mMediaItemDurationView = (TextView) view.findViewById(androidx.leanback.R.id.mediaItemDuration);
            this.mMediaItemRowSeparator = view.findViewById(androidx.leanback.R.id.mediaRowSeparator);
            this.mMediaItemActionsContainer = (ViewGroup) view.findViewById(androidx.leanback.R.id.mediaItemActionsContainer);
            this.mActionViewHolders = new ArrayList();
            getMediaItemDetailsView().setOnClickListener(new View.OnClickListener() { // from class: androidx.leanback.widget.AbstractMediaItemPresenter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ViewHolder.this.getOnItemViewClickedListener() != null) {
                        BaseOnItemViewClickedListener onItemViewClickedListener = ViewHolder.this.getOnItemViewClickedListener();
                        ViewHolder viewHolder = ViewHolder.this;
                        onItemViewClickedListener.onItemClicked(null, null, viewHolder, viewHolder.getRowObject());
                    }
                }
            });
            getMediaItemDetailsView().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.leanback.widget.AbstractMediaItemPresenter.ViewHolder.2
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view2, boolean z9) {
                    ViewHolder viewHolder = ViewHolder.this;
                    viewHolder.mFocusViewAnimator = AbstractMediaItemPresenter.updateSelector(viewHolder.mSelectorView, view2, viewHolder.mFocusViewAnimator, true);
                }
            });
            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(androidx.leanback.R.id.mediaItemNumberViewFlipper);
            this.mMediaItemNumberViewFlipper = viewFlipper;
            TypedValue typedValue = new TypedValue();
            View viewInflate = LayoutInflater.from(view.getContext()).inflate(view.getContext().getTheme().resolveAttribute(androidx.leanback.R.attr.playbackMediaItemNumberViewFlipperLayout, typedValue, true) ? typedValue.resourceId : androidx.leanback.R.layout.lb_media_item_number_view_flipper, (ViewGroup) viewFlipper, true);
            this.mMediaItemNumberView = (TextView) viewInflate.findViewById(androidx.leanback.R.id.initial);
            this.mMediaItemPausedView = viewInflate.findViewById(androidx.leanback.R.id.paused);
            this.mMediaItemPlayingView = viewInflate.findViewById(androidx.leanback.R.id.playing);
        }

        public int findActionIndex(MultiActionsProvider.MultiAction multiAction) {
            if (this.mMediaItemRowActions == null) {
                return -1;
            }
            int i10 = 0;
            while (true) {
                MultiActionsProvider.MultiAction[] multiActionArr = this.mMediaItemRowActions;
                if (i10 >= multiActionArr.length) {
                    return -1;
                }
                if (multiActionArr[i10] == multiAction) {
                    return i10;
                }
                i10++;
            }
        }

        public ViewGroup getMediaItemActionsContainer() {
            return this.mMediaItemActionsContainer;
        }

        public View getMediaItemDetailsView() {
            return this.mMediaItemDetailsView;
        }

        public TextView getMediaItemDurationView() {
            return this.mMediaItemDurationView;
        }

        public TextView getMediaItemNameView() {
            return this.mMediaItemNameView;
        }

        public TextView getMediaItemNumberView() {
            return this.mMediaItemNumberView;
        }

        public ViewFlipper getMediaItemNumberViewFlipper() {
            return this.mMediaItemNumberViewFlipper;
        }

        public View getMediaItemPausedView() {
            return this.mMediaItemPausedView;
        }

        public View getMediaItemPlayingView() {
            return this.mMediaItemPlayingView;
        }

        public MultiActionsProvider.MultiAction[] getMediaItemRowActions() {
            return this.mMediaItemRowActions;
        }

        public View getMediaItemRowSeparator() {
            return this.mMediaItemRowSeparator;
        }

        public View getSelectorView() {
            return this.mSelectorView;
        }

        public void notifyActionChanged(MultiActionsProvider.MultiAction multiAction) {
            int iFindActionIndex;
            Presenter actionPresenter = this.mRowPresenter.getActionPresenter();
            if (actionPresenter != null && (iFindActionIndex = findActionIndex(multiAction)) >= 0) {
                Presenter.ViewHolder viewHolder = this.mActionViewHolders.get(iFindActionIndex);
                actionPresenter.onUnbindViewHolder(viewHolder);
                actionPresenter.onBindViewHolder(viewHolder, multiAction);
            }
        }

        public void notifyDetailsChanged() {
            this.mRowPresenter.onUnbindMediaDetails(this);
            this.mRowPresenter.onBindMediaDetails(this, getRowObject());
        }

        public void notifyPlayStateChanged() {
            this.mRowPresenter.onBindMediaPlayState(this);
        }

        public void onBindRowActions() {
            int childCount = getMediaItemActionsContainer().getChildCount();
            while (true) {
                childCount--;
                if (childCount < this.mActionViewHolders.size()) {
                    break;
                }
                getMediaItemActionsContainer().removeViewAt(childCount);
                this.mActionViewHolders.remove(childCount);
            }
            this.mMediaItemRowActions = null;
            Object rowObject = getRowObject();
            if (rowObject instanceof MultiActionsProvider) {
                MultiActionsProvider.MultiAction[] actions = ((MultiActionsProvider) rowObject).getActions();
                Presenter actionPresenter = this.mRowPresenter.getActionPresenter();
                if (actionPresenter == null) {
                    return;
                }
                this.mMediaItemRowActions = actions;
                for (final int size = this.mActionViewHolders.size(); size < actions.length; size++) {
                    final Presenter.ViewHolder viewHolderOnCreateViewHolder = actionPresenter.onCreateViewHolder(getMediaItemActionsContainer());
                    getMediaItemActionsContainer().addView(viewHolderOnCreateViewHolder.view);
                    this.mActionViewHolders.add(viewHolderOnCreateViewHolder);
                    viewHolderOnCreateViewHolder.view.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.leanback.widget.AbstractMediaItemPresenter.ViewHolder.3
                        @Override // android.view.View.OnFocusChangeListener
                        public void onFocusChange(View view, boolean z9) {
                            ViewHolder viewHolder = ViewHolder.this;
                            viewHolder.mFocusViewAnimator = AbstractMediaItemPresenter.updateSelector(viewHolder.mSelectorView, view, viewHolder.mFocusViewAnimator, false);
                        }
                    });
                    viewHolderOnCreateViewHolder.view.setOnClickListener(new View.OnClickListener() { // from class: androidx.leanback.widget.AbstractMediaItemPresenter.ViewHolder.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (ViewHolder.this.getOnItemViewClickedListener() != null) {
                                BaseOnItemViewClickedListener onItemViewClickedListener = ViewHolder.this.getOnItemViewClickedListener();
                                Presenter.ViewHolder viewHolder = viewHolderOnCreateViewHolder;
                                ViewHolder viewHolder2 = ViewHolder.this;
                                onItemViewClickedListener.onItemClicked(viewHolder, viewHolder2.mMediaItemRowActions[size], viewHolder2, viewHolder2.getRowObject());
                            }
                        }
                    });
                }
                if (this.mMediaItemActionsContainer != null) {
                    for (int i10 = 0; i10 < actions.length; i10++) {
                        Presenter.ViewHolder viewHolder = this.mActionViewHolders.get(i10);
                        actionPresenter.onUnbindViewHolder(viewHolder);
                        actionPresenter.onBindViewHolder(viewHolder, this.mMediaItemRowActions[i10]);
                    }
                }
            }
        }

        public void setSelectedMediaItemNumberView(int i10) {
            if (i10 < 0 || i10 >= this.mMediaItemNumberViewFlipper.getChildCount()) {
                return;
            }
            this.mMediaItemNumberViewFlipper.setDisplayedChild(i10);
        }
    }

    public AbstractMediaItemPresenter(int i10) {
        this.mBackgroundColor = 0;
        this.mMediaItemActionPresenter = new MediaItemActionPresenter();
        this.mThemeId = i10;
        setHeaderPresenter(null);
    }

    public static int calculateMediaItemNumberFlipperIndex(ViewHolder viewHolder) {
        View view;
        int mediaPlayState = viewHolder.mRowPresenter.getMediaPlayState(viewHolder.getRowObject());
        if (mediaPlayState == 0) {
            TextView textView = viewHolder.mMediaItemNumberView;
            if (textView == null) {
                return -1;
            }
            return viewHolder.mMediaItemNumberViewFlipper.indexOfChild(textView);
        }
        if (mediaPlayState != 1) {
            if (mediaPlayState == 2 && (view = viewHolder.mMediaItemPlayingView) != null) {
                return viewHolder.mMediaItemNumberViewFlipper.indexOfChild(view);
            }
            return -1;
        }
        View view2 = viewHolder.mMediaItemPausedView;
        if (view2 == null) {
            return -1;
        }
        return viewHolder.mMediaItemNumberViewFlipper.indexOfChild(view2);
    }

    public static ValueAnimator updateSelector(final View view, View view2, ValueAnimator valueAnimator, boolean z9) throws Resources.NotFoundException {
        ValueAnimator valueAnimator2;
        int integer = view2.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        int layoutDirection = view.getLayoutDirection();
        if (!view2.hasFocus()) {
            view.animate().cancel();
            view.animate().alpha(0.0f).setDuration(integer).setInterpolator(decelerateInterpolator).start();
            return valueAnimator;
        }
        if (valueAnimator != null) {
            valueAnimator.cancel();
            valueAnimator2 = null;
        } else {
            valueAnimator2 = valueAnimator;
        }
        float alpha = view.getAlpha();
        long j10 = integer;
        view.animate().alpha(1.0f).setDuration(j10).setInterpolator(decelerateInterpolator).start();
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        Rect rect = sTempRect;
        rect.set(0, 0, view2.getWidth(), view2.getHeight());
        viewGroup.offsetDescendantRectToMyCoords(view2, rect);
        if (z9) {
            if (layoutDirection == 1) {
                rect.right = viewGroup.getHeight() + rect.right;
                rect.left -= viewGroup.getHeight() / 2;
            } else {
                rect.left -= viewGroup.getHeight();
                rect.right = (viewGroup.getHeight() / 2) + rect.right;
            }
        }
        final int i10 = rect.left;
        final int iWidth = rect.width();
        final float f = marginLayoutParams.width - iWidth;
        final float f10 = marginLayoutParams.leftMargin - i10;
        if (f10 == 0.0f && f == 0.0f) {
            return valueAnimator2;
        }
        if (alpha == 0.0f) {
            marginLayoutParams.width = iWidth;
            marginLayoutParams.leftMargin = i10;
            view.requestLayout();
            return valueAnimator2;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(j10);
        valueAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.leanback.widget.AbstractMediaItemPresenter.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                float animatedFraction = 1.0f - valueAnimator3.getAnimatedFraction();
                marginLayoutParams.leftMargin = Math.round((f10 * animatedFraction) + i10);
                marginLayoutParams.width = Math.round((f * animatedFraction) + iWidth);
                view.requestLayout();
            }
        });
        valueAnimatorOfFloat.start();
        return valueAnimatorOfFloat;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.mThemeId != 0) {
            context = new ContextThemeWrapper(context, this.mThemeId);
        }
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_row_media_item, viewGroup, false));
        viewHolder.mRowPresenter = this;
        if (this.mBackgroundColorSet) {
            viewHolder.mMediaRowView.setBackgroundColor(this.mBackgroundColor);
        }
        return viewHolder;
    }

    public Presenter getActionPresenter() {
        return this.mMediaItemActionPresenter;
    }

    public int getMediaPlayState(Object obj) {
        return 0;
    }

    public int getThemeId() {
        return this.mThemeId;
    }

    public boolean hasMediaRowSeparator() {
        return this.mMediaRowSeparator;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isClippingChildren() {
        return true;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public abstract void onBindMediaDetails(ViewHolder viewHolder, Object obj);

    public void onBindMediaPlayState(ViewHolder viewHolder) {
        int iCalculateMediaItemNumberFlipperIndex = calculateMediaItemNumberFlipperIndex(viewHolder);
        if (iCalculateMediaItemNumberFlipperIndex == -1 || viewHolder.mMediaItemNumberViewFlipper.getDisplayedChild() == iCalculateMediaItemNumberFlipperIndex) {
            return;
        }
        viewHolder.mMediaItemNumberViewFlipper.setDisplayedChild(iCalculateMediaItemNumberFlipperIndex);
    }

    public void onBindRowActions(ViewHolder viewHolder) {
        viewHolder.onBindRowActions();
    }

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        onBindRowActions(viewHolder2);
        viewHolder2.getMediaItemRowSeparator().setVisibility(hasMediaRowSeparator() ? 0 : 8);
        onBindMediaPlayState(viewHolder2);
        onBindMediaDetails(viewHolder2, obj);
    }

    public void setActionPresenter(Presenter presenter) {
        this.mMediaItemActionPresenter = presenter;
    }

    public void setBackgroundColor(int i10) {
        this.mBackgroundColorSet = true;
        this.mBackgroundColor = i10;
    }

    public void setHasMediaRowSeparator(boolean z9) {
        this.mMediaRowSeparator = z9;
    }

    public void setThemeId(int i10) {
        this.mThemeId = i10;
    }

    public AbstractMediaItemPresenter() {
        this(0);
    }

    public void onUnbindMediaDetails(ViewHolder viewHolder) {
    }

    public void onUnbindMediaPlayState(ViewHolder viewHolder) {
    }
}
