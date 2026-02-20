package androidx.leanback.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes.dex */
abstract class BaseRowFragment extends Fragment {
    private static final String CURRENT_SELECTED_POSITION = "currentSelectedPosition";
    private ObjectAdapter mAdapter;
    private boolean mPendingTransitionPrepare;
    private PresenterSelector mPresenterSelector;
    VerticalGridView mVerticalGridView;
    final ItemBridgeAdapter mBridgeAdapter = new ItemBridgeAdapter();
    int mSelectedPosition = -1;
    LateSelectionObserver mLateSelectionObserver = new LateSelectionObserver();
    private final OnChildViewHolderSelectedListener mRowSelectedListener = new OnChildViewHolderSelectedListener() { // from class: androidx.leanback.app.BaseRowFragment.1
        @Override // androidx.leanback.widget.OnChildViewHolderSelectedListener
        public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i10, int i11) {
            BaseRowFragment baseRowFragment = BaseRowFragment.this;
            if (baseRowFragment.mLateSelectionObserver.mIsLateSelection) {
                return;
            }
            baseRowFragment.mSelectedPosition = i10;
            baseRowFragment.onRowSelected(recyclerView, viewHolder, i10, i11);
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class LateSelectionObserver extends RecyclerView.AdapterDataObserver {
        boolean mIsLateSelection = false;

        public LateSelectionObserver() {
        }

        public void clear() {
            if (this.mIsLateSelection) {
                this.mIsLateSelection = false;
                BaseRowFragment.this.mBridgeAdapter.unregisterAdapterDataObserver(this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            performLateSelection();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i10, int i11) {
            performLateSelection();
        }

        public void performLateSelection() {
            clear();
            BaseRowFragment baseRowFragment = BaseRowFragment.this;
            VerticalGridView verticalGridView = baseRowFragment.mVerticalGridView;
            if (verticalGridView != null) {
                verticalGridView.setSelectedPosition(baseRowFragment.mSelectedPosition);
            }
        }

        public void startLateSelection() {
            this.mIsLateSelection = true;
            BaseRowFragment.this.mBridgeAdapter.registerAdapterDataObserver(this);
        }
    }

    public VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view;
    }

    public final ObjectAdapter getAdapter() {
        return this.mAdapter;
    }

    public final ItemBridgeAdapter getBridgeAdapter() {
        return this.mBridgeAdapter;
    }

    public Object getItem(Row row, int i10) {
        if (row instanceof ListRow) {
            return ((ListRow) row).getAdapter().get(i10);
        }
        return null;
    }

    public abstract int getLayoutResourceId();

    public final PresenterSelector getPresenterSelector() {
        return this.mPresenterSelector;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public final VerticalGridView getVerticalGridView() {
        return this.mVerticalGridView;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(getLayoutResourceId(), viewGroup, false);
        this.mVerticalGridView = findGridViewFromRoot(viewInflate);
        if (this.mPendingTransitionPrepare) {
            this.mPendingTransitionPrepare = false;
            onTransitionPrepare();
        }
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mLateSelectionObserver.clear();
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView != null) {
            verticalGridView.swapAdapter(null, true);
            this.mVerticalGridView = null;
        }
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(CURRENT_SELECTED_POSITION, this.mSelectedPosition);
    }

    public void onTransitionEnd() {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView != null) {
            verticalGridView.setLayoutFrozen(false);
            this.mVerticalGridView.setAnimateChildLayout(true);
            this.mVerticalGridView.setPruneChild(true);
            this.mVerticalGridView.setFocusSearchDisabled(false);
            this.mVerticalGridView.setScrollEnabled(true);
        }
    }

    public boolean onTransitionPrepare() {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView == null) {
            this.mPendingTransitionPrepare = true;
            return false;
        }
        verticalGridView.setAnimateChildLayout(false);
        this.mVerticalGridView.setScrollEnabled(false);
        return true;
    }

    public void onTransitionStart() {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView != null) {
            verticalGridView.setPruneChild(false);
            this.mVerticalGridView.setLayoutFrozen(true);
            this.mVerticalGridView.setFocusSearchDisabled(true);
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (bundle != null) {
            this.mSelectedPosition = bundle.getInt(CURRENT_SELECTED_POSITION, -1);
        }
        setAdapterAndSelection();
        this.mVerticalGridView.setOnChildViewHolderSelectedListener(this.mRowSelectedListener);
    }

    public final void setAdapter(ObjectAdapter objectAdapter) {
        if (this.mAdapter != objectAdapter) {
            this.mAdapter = objectAdapter;
            updateAdapter();
        }
    }

    public void setAdapterAndSelection() {
        if (this.mAdapter == null) {
            return;
        }
        RecyclerView.Adapter adapter = this.mVerticalGridView.getAdapter();
        ItemBridgeAdapter itemBridgeAdapter = this.mBridgeAdapter;
        if (adapter != itemBridgeAdapter) {
            this.mVerticalGridView.setAdapter(itemBridgeAdapter);
        }
        if (this.mBridgeAdapter.getItemCount() == 0 && this.mSelectedPosition >= 0) {
            this.mLateSelectionObserver.startLateSelection();
            return;
        }
        int i10 = this.mSelectedPosition;
        if (i10 >= 0) {
            this.mVerticalGridView.setSelectedPosition(i10);
        }
    }

    public void setAlignment(int i10) {
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView != null) {
            verticalGridView.setItemAlignmentOffset(0);
            this.mVerticalGridView.setItemAlignmentOffsetPercent(-1.0f);
            this.mVerticalGridView.setWindowAlignmentOffset(i10);
            this.mVerticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
            this.mVerticalGridView.setWindowAlignment(0);
        }
    }

    public final void setPresenterSelector(PresenterSelector presenterSelector) {
        if (this.mPresenterSelector != presenterSelector) {
            this.mPresenterSelector = presenterSelector;
            updateAdapter();
        }
    }

    public void setSelectedPosition(int i10, boolean z9) {
        if (this.mSelectedPosition == i10) {
            return;
        }
        this.mSelectedPosition = i10;
        VerticalGridView verticalGridView = this.mVerticalGridView;
        if (verticalGridView == null || this.mLateSelectionObserver.mIsLateSelection) {
            return;
        }
        if (z9) {
            verticalGridView.setSelectedPositionSmooth(i10);
        } else {
            verticalGridView.setSelectedPosition(i10);
        }
    }

    public void updateAdapter() {
        this.mBridgeAdapter.setAdapter(this.mAdapter);
        this.mBridgeAdapter.setPresenter(this.mPresenterSelector);
        if (this.mVerticalGridView != null) {
            setAdapterAndSelection();
        }
    }

    public void setSelectedPosition(int i10) {
        setSelectedPosition(i10, true);
    }

    public void onRowSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i10, int i11) {
    }
}
