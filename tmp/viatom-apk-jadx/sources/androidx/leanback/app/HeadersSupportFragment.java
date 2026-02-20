package androidx.leanback.app;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.leanback.R;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DividerPresenter;
import androidx.leanback.widget.DividerRow;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.SectionRow;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class HeadersSupportFragment extends BaseRowSupportFragment {
    private static final PresenterSelector sHeaderPresenter = new ClassPresenterSelector().addClassPresenter(DividerRow.class, new DividerPresenter()).addClassPresenter(SectionRow.class, new RowHeaderPresenter(R.layout.lb_section_header, false)).addClassPresenter(Row.class, new RowHeaderPresenter(R.layout.lb_header));
    static View.OnLayoutChangeListener sLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.leanback.app.HeadersSupportFragment.2
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            view.setPivotX(view.getLayoutDirection() == 1 ? view.getWidth() : 0.0f);
            view.setPivotY(view.getMeasuredHeight() / 2);
        }
    };
    private int mBackgroundColor;
    private boolean mBackgroundColorSet;
    OnHeaderClickedListener mOnHeaderClickedListener;
    private OnHeaderViewSelectedListener mOnHeaderViewSelectedListener;
    private boolean mHeadersEnabled = true;
    private boolean mHeadersGone = false;
    private final ItemBridgeAdapter.AdapterListener mAdapterListener = new ItemBridgeAdapter.AdapterListener() { // from class: androidx.leanback.app.HeadersSupportFragment.1
        @Override // androidx.leanback.widget.ItemBridgeAdapter.AdapterListener
        public void onCreate(final ItemBridgeAdapter.ViewHolder viewHolder) {
            View view = viewHolder.getViewHolder().view;
            view.setOnClickListener(new View.OnClickListener() { // from class: androidx.leanback.app.HeadersSupportFragment.1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    OnHeaderClickedListener onHeaderClickedListener = HeadersSupportFragment.this.mOnHeaderClickedListener;
                    if (onHeaderClickedListener != null) {
                        onHeaderClickedListener.onHeaderClicked((RowHeaderPresenter.ViewHolder) viewHolder.getViewHolder(), (Row) viewHolder.getItem());
                    }
                }
            });
            if (HeadersSupportFragment.this.mWrapper != null) {
                viewHolder.itemView.addOnLayoutChangeListener(HeadersSupportFragment.sLayoutChangeListener);
            } else {
                view.addOnLayoutChangeListener(HeadersSupportFragment.sLayoutChangeListener);
            }
        }
    };
    final ItemBridgeAdapter.Wrapper mWrapper = new ItemBridgeAdapter.Wrapper() { // from class: androidx.leanback.app.HeadersSupportFragment.3
        @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
        public View createWrapper(View view) {
            return new NoOverlappingFrameLayout(view.getContext());
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter.Wrapper
        public void wrap(View view, View view2) {
            ((FrameLayout) view).addView(view2);
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class NoOverlappingFrameLayout extends FrameLayout {
        public NoOverlappingFrameLayout(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnHeaderClickedListener {
        void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnHeaderViewSelectedListener {
        void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row);
    }

    public HeadersSupportFragment() {
        setPresenterSelector(sHeaderPresenter);
        FocusHighlightHelper.setupHeaderItemFocusHighlight(getBridgeAdapter());
    }

    private void updateFadingEdgeToBrandColor(int i10) {
        Drawable background = getView().findViewById(R.id.fade_out_edge).getBackground();
        if (background instanceof GradientDrawable) {
            background.mutate();
            ((GradientDrawable) background).setColors(new int[]{0, i10});
        }
    }

    private void updateListViewVisibility() {
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            getView().setVisibility(this.mHeadersGone ? 8 : 0);
            if (this.mHeadersGone) {
                return;
            }
            if (this.mHeadersEnabled) {
                verticalGridView.setChildrenVisibility(0);
            } else {
                verticalGridView.setChildrenVisibility(4);
            }
        }
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view.findViewById(R.id.browse_headers);
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public int getLayoutResourceId() {
        return R.layout.lb_headers_fragment;
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public /* bridge */ /* synthetic */ int getSelectedPosition() {
        return super.getSelectedPosition();
    }

    public boolean isScrolling() {
        return getVerticalGridView().getScrollState() != 0;
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public void onRowSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i10, int i11) {
        OnHeaderViewSelectedListener onHeaderViewSelectedListener = this.mOnHeaderViewSelectedListener;
        if (onHeaderViewSelectedListener != null) {
            if (viewHolder == null || i10 < 0) {
                onHeaderViewSelectedListener.onHeaderSelected(null, null);
            } else {
                ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) viewHolder;
                onHeaderViewSelectedListener.onHeaderSelected((RowHeaderPresenter.ViewHolder) viewHolder2.getViewHolder(), (Row) viewHolder2.getItem());
            }
        }
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public void onTransitionEnd() {
        VerticalGridView verticalGridView;
        if (this.mHeadersEnabled && (verticalGridView = getVerticalGridView()) != null) {
            verticalGridView.setDescendantFocusability(262144);
            if (verticalGridView.hasFocus()) {
                verticalGridView.requestFocus();
            }
        }
        super.onTransitionEnd();
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public /* bridge */ /* synthetic */ boolean onTransitionPrepare() {
        return super.onTransitionPrepare();
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public void onTransitionStart() {
        VerticalGridView verticalGridView;
        super.onTransitionStart();
        if (this.mHeadersEnabled || (verticalGridView = getVerticalGridView()) == null) {
            return;
        }
        verticalGridView.setDescendantFocusability(131072);
        if (verticalGridView.hasFocus()) {
            verticalGridView.requestFocus();
        }
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView == null) {
            return;
        }
        if (this.mBackgroundColorSet) {
            verticalGridView.setBackgroundColor(this.mBackgroundColor);
            updateFadingEdgeToBrandColor(this.mBackgroundColor);
        } else {
            Drawable background = verticalGridView.getBackground();
            if (background instanceof ColorDrawable) {
                updateFadingEdgeToBrandColor(((ColorDrawable) background).getColor());
            }
        }
        updateListViewVisibility();
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public /* bridge */ /* synthetic */ void setAlignment(int i10) {
        super.setAlignment(i10);
    }

    public void setBackgroundColor(int i10) {
        this.mBackgroundColor = i10;
        this.mBackgroundColorSet = true;
        if (getVerticalGridView() != null) {
            getVerticalGridView().setBackgroundColor(this.mBackgroundColor);
            updateFadingEdgeToBrandColor(this.mBackgroundColor);
        }
    }

    public void setHeadersEnabled(boolean z9) {
        this.mHeadersEnabled = z9;
        updateListViewVisibility();
    }

    public void setHeadersGone(boolean z9) {
        this.mHeadersGone = z9;
        updateListViewVisibility();
    }

    public void setOnHeaderClickedListener(OnHeaderClickedListener onHeaderClickedListener) {
        this.mOnHeaderClickedListener = onHeaderClickedListener;
    }

    public void setOnHeaderViewSelectedListener(OnHeaderViewSelectedListener onHeaderViewSelectedListener) {
        this.mOnHeaderViewSelectedListener = onHeaderViewSelectedListener;
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public /* bridge */ /* synthetic */ void setSelectedPosition(int i10) {
        super.setSelectedPosition(i10);
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public void updateAdapter() {
        super.updateAdapter();
        ItemBridgeAdapter bridgeAdapter = getBridgeAdapter();
        bridgeAdapter.setAdapterListener(this.mAdapterListener);
        bridgeAdapter.setWrapper(this.mWrapper);
    }

    @Override // androidx.leanback.app.BaseRowSupportFragment
    public /* bridge */ /* synthetic */ void setSelectedPosition(int i10, boolean z9) {
        super.setSelectedPosition(i10, z9);
    }
}
