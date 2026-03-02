package androidx.leanback.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.ControlBar;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Presenter;
import androidx.window.layout.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class ControlBarPresenter extends Presenter {
    static final int MAX_CONTROLS = 7;
    private static int sChildMarginDefault;
    private static int sControlIconWidth;
    boolean mDefaultFocusToMiddle = true;
    private int mLayoutResourceId;
    OnControlClickedListener mOnControlClickedListener;
    OnControlSelectedListener mOnControlSelectedListener;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class BoundData {
        ObjectAdapter adapter;
        Presenter presenter;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnControlClickedListener {
        void onControlClicked(Presenter.ViewHolder viewHolder, Object obj, BoundData boundData);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnControlSelectedListener {
        void onControlSelected(Presenter.ViewHolder viewHolder, Object obj, BoundData boundData);
    }

    public ControlBarPresenter(int i10) {
        this.mLayoutResourceId = i10;
    }

    public int getChildMarginDefault(Context context) {
        if (sChildMarginDefault == 0) {
            sChildMarginDefault = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_child_margin_default);
        }
        return sChildMarginDefault;
    }

    public int getControlIconWidth(Context context) {
        if (sControlIconWidth == 0) {
            sControlIconWidth = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_control_icon_width);
        }
        return sControlIconWidth;
    }

    public int getLayoutResourceId() {
        return this.mLayoutResourceId;
    }

    public OnControlSelectedListener getOnItemControlListener() {
        return this.mOnControlSelectedListener;
    }

    public OnControlClickedListener getOnItemViewClickedListener() {
        return this.mOnControlClickedListener;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        BoundData boundData = (BoundData) obj;
        ObjectAdapter objectAdapter = viewHolder2.mAdapter;
        ObjectAdapter objectAdapter2 = boundData.adapter;
        if (objectAdapter != objectAdapter2) {
            viewHolder2.mAdapter = objectAdapter2;
            if (objectAdapter2 != null) {
                objectAdapter2.registerObserver(viewHolder2.mDataObserver);
            }
        }
        Presenter presenter = boundData.presenter;
        viewHolder2.mPresenter = presenter;
        viewHolder2.mData = boundData;
        viewHolder2.showControls(presenter);
    }

    @Override // androidx.leanback.widget.Presenter
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutResourceId(), viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ObjectAdapter objectAdapter = viewHolder2.mAdapter;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(viewHolder2.mDataObserver);
            viewHolder2.mAdapter = null;
        }
        viewHolder2.mData = null;
    }

    public void setBackgroundColor(ViewHolder viewHolder, int i10) {
        viewHolder.mControlsContainer.setBackgroundColor(i10);
    }

    public void setDefaultFocusToMiddle(boolean z9) {
        this.mDefaultFocusToMiddle = z9;
    }

    public void setOnControlClickedListener(OnControlClickedListener onControlClickedListener) {
        this.mOnControlClickedListener = onControlClickedListener;
    }

    public void setOnControlSelectedListener(OnControlSelectedListener onControlSelectedListener) {
        this.mOnControlSelectedListener = onControlSelectedListener;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class ViewHolder extends Presenter.ViewHolder {
        ObjectAdapter mAdapter;
        ControlBar mControlBar;
        View mControlsContainer;
        BoundData mData;
        ObjectAdapter.DataObserver mDataObserver;
        Presenter mPresenter;
        SparseArray<Presenter.ViewHolder> mViewHolders;

        public ViewHolder(View view) {
            super(view);
            this.mViewHolders = new SparseArray<>();
            this.mControlsContainer = view.findViewById(androidx.leanback.R.id.controls_container);
            ControlBar controlBar = (ControlBar) view.findViewById(androidx.leanback.R.id.control_bar);
            this.mControlBar = controlBar;
            if (controlBar == null) {
                c.g("Couldn't find control_bar");
                throw null;
            }
            controlBar.setDefaultFocusToMiddle(ControlBarPresenter.this.mDefaultFocusToMiddle);
            this.mControlBar.setOnChildFocusedListener(new ControlBar.OnChildFocusedListener() { // from class: androidx.leanback.widget.ControlBarPresenter.ViewHolder.1
                @Override // androidx.leanback.widget.ControlBar.OnChildFocusedListener
                public void onChildFocusedListener(View view2, View view3) {
                    if (ControlBarPresenter.this.mOnControlSelectedListener == null) {
                        return;
                    }
                    for (int i10 = 0; i10 < ViewHolder.this.mViewHolders.size(); i10++) {
                        if (ViewHolder.this.mViewHolders.get(i10).view == view2) {
                            ViewHolder viewHolder = ViewHolder.this;
                            ControlBarPresenter.this.mOnControlSelectedListener.onControlSelected(viewHolder.mViewHolders.get(i10), ViewHolder.this.getDisplayedAdapter().get(i10), ViewHolder.this.mData);
                            return;
                        }
                    }
                }
            });
            this.mDataObserver = new ObjectAdapter.DataObserver() { // from class: androidx.leanback.widget.ControlBarPresenter.ViewHolder.2
                @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
                public void onChanged() {
                    ViewHolder viewHolder = ViewHolder.this;
                    if (viewHolder.mAdapter == viewHolder.getDisplayedAdapter()) {
                        ViewHolder viewHolder2 = ViewHolder.this;
                        viewHolder2.showControls(viewHolder2.mPresenter);
                    }
                }

                @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
                public void onItemRangeChanged(int i10, int i11) {
                    ViewHolder viewHolder = ViewHolder.this;
                    if (viewHolder.mAdapter == viewHolder.getDisplayedAdapter()) {
                        for (int i12 = 0; i12 < i11; i12++) {
                            ViewHolder viewHolder2 = ViewHolder.this;
                            viewHolder2.bindControlToAction(i10 + i12, viewHolder2.mPresenter);
                        }
                    }
                }
            };
        }

        private void bindControlToAction(final int i10, ObjectAdapter objectAdapter, Presenter presenter) {
            final Presenter.ViewHolder viewHolderOnCreateViewHolder = this.mViewHolders.get(i10);
            Object obj = objectAdapter.get(i10);
            if (viewHolderOnCreateViewHolder == null) {
                viewHolderOnCreateViewHolder = presenter.onCreateViewHolder(this.mControlBar);
                this.mViewHolders.put(i10, viewHolderOnCreateViewHolder);
                presenter.setOnClickListener(viewHolderOnCreateViewHolder, new View.OnClickListener() { // from class: androidx.leanback.widget.ControlBarPresenter.ViewHolder.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Object obj2 = ViewHolder.this.getDisplayedAdapter().get(i10);
                        ViewHolder viewHolder = ViewHolder.this;
                        OnControlClickedListener onControlClickedListener = ControlBarPresenter.this.mOnControlClickedListener;
                        if (onControlClickedListener != null) {
                            onControlClickedListener.onControlClicked(viewHolderOnCreateViewHolder, obj2, viewHolder.mData);
                        }
                    }
                });
            }
            if (viewHolderOnCreateViewHolder.view.getParent() == null) {
                this.mControlBar.addView(viewHolderOnCreateViewHolder.view);
            }
            presenter.onBindViewHolder(viewHolderOnCreateViewHolder, obj);
        }

        public int getChildMarginFromCenter(Context context, int i10) {
            return ControlBarPresenter.this.getChildMarginDefault(context) + ControlBarPresenter.this.getControlIconWidth(context);
        }

        public ObjectAdapter getDisplayedAdapter() {
            return this.mAdapter;
        }

        public void showControls(Presenter presenter) {
            ObjectAdapter displayedAdapter = getDisplayedAdapter();
            int size = displayedAdapter == null ? 0 : displayedAdapter.size();
            View focusedChild = this.mControlBar.getFocusedChild();
            if (focusedChild != null && size > 0 && this.mControlBar.indexOfChild(focusedChild) >= size) {
                this.mControlBar.getChildAt(displayedAdapter.size() - 1).requestFocus();
            }
            for (int childCount = this.mControlBar.getChildCount() - 1; childCount >= size; childCount--) {
                this.mControlBar.removeViewAt(childCount);
            }
            for (int i10 = 0; i10 < size && i10 < 7; i10++) {
                bindControlToAction(i10, displayedAdapter, presenter);
            }
            ControlBar controlBar = this.mControlBar;
            controlBar.setChildMarginFromCenter(getChildMarginFromCenter(controlBar.getContext(), size));
        }

        public void bindControlToAction(int i10, Presenter presenter) {
            bindControlToAction(i10, getDisplayedAdapter(), presenter);
        }
    }
}
