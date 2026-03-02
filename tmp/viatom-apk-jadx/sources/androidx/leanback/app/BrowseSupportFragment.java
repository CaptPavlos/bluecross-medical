package androidx.leanback.app;

import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.R;
import androidx.leanback.app.HeadersSupportFragment;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.util.StateMachine;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.InvisibleRowPresenter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.ScaleFrameLayout;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.layout.c;
import com.google.gson.internal.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class BrowseSupportFragment extends BaseSupportFragment {
    private static final String CURRENT_SELECTED_POSITION = "currentSelectedPosition";
    static final boolean DEBUG = false;
    public static final int HEADERS_DISABLED = 3;
    public static final int HEADERS_ENABLED = 1;
    public static final int HEADERS_HIDDEN = 2;
    static final String HEADER_SHOW = "headerShow";
    static final String HEADER_STACK_INDEX = "headerStackIndex";
    private static final String IS_PAGE_ROW = "isPageRow";
    private static final String LB_HEADERS_BACKSTACK = "lbHeadersBackStack_";
    static final String TAG = "BrowseSupportFragment";
    private ObjectAdapter mAdapter;
    private PresenterSelector mAdapterPresenter;
    BackStackListener mBackStackChangedListener;
    private boolean mBrandColorSet;
    BrowseFrameLayout mBrowseFrame;
    BrowseTransitionListener mBrowseTransitionListener;
    private int mContainerListAlignTop;
    private int mContainerListMarginStart;
    OnItemViewSelectedListener mExternalOnItemViewSelectedListener;
    private PresenterSelector mHeaderPresenterSelector;
    HeadersSupportFragment mHeadersSupportFragment;
    Object mHeadersTransition;
    boolean mIsPageRow;
    Fragment mMainFragment;
    MainFragmentAdapter mMainFragmentAdapter;
    ListRowDataAdapter mMainFragmentListRowDataAdapter;
    MainFragmentRowsAdapter mMainFragmentRowsAdapter;
    private OnItemViewClickedListener mOnItemViewClickedListener;
    Object mPageRow;
    private float mScaleFactor;
    private ScaleFrameLayout mScaleFrameLayout;
    private Object mSceneAfterEntranceTransition;
    Object mSceneWithHeaders;
    Object mSceneWithoutHeaders;
    String mWithHeadersBackStackName;
    private static final String ARG_TITLE = BrowseSupportFragment.class.getCanonicalName() + ".title";
    private static final String ARG_HEADERS_STATE = BrowseSupportFragment.class.getCanonicalName() + ".headersState";
    final StateMachine.State STATE_SET_ENTRANCE_START_STATE = new StateMachine.State("SET_ENTRANCE_START_STATE") { // from class: androidx.leanback.app.BrowseSupportFragment.1
        @Override // androidx.leanback.util.StateMachine.State
        public void run() {
            BrowseSupportFragment.this.setEntranceTransitionStartState();
        }
    };
    final StateMachine.Event EVT_HEADER_VIEW_CREATED = new StateMachine.Event("headerFragmentViewCreated");
    final StateMachine.Event EVT_MAIN_FRAGMENT_VIEW_CREATED = new StateMachine.Event("mainFragmentViewCreated");
    final StateMachine.Event EVT_SCREEN_DATA_READY = new StateMachine.Event("screenDataReady");
    private MainFragmentAdapterRegistry mMainFragmentAdapterRegistry = new MainFragmentAdapterRegistry();
    private int mHeadersState = 1;
    private int mBrandColor = 0;
    boolean mHeadersBackStackEnabled = true;
    boolean mShowingHeaders = true;
    boolean mCanShowHeaders = true;
    private boolean mMainFragmentScaleEnabled = true;
    private int mSelectedPosition = -1;
    boolean mStopped = true;
    private final SetSelectionRunnable mSetSelectionRunnable = new SetSelectionRunnable();
    private final BrowseFrameLayout.OnFocusSearchListener mOnFocusSearchListener = new BrowseFrameLayout.OnFocusSearchListener() { // from class: androidx.leanback.app.BrowseSupportFragment.4
        @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
        public View onFocusSearch(View view, int i10) {
            Fragment fragment;
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mCanShowHeaders && browseSupportFragment.isInHeadersTransition()) {
                return view;
            }
            if (BrowseSupportFragment.this.getTitleView() != null && view != BrowseSupportFragment.this.getTitleView() && i10 == 33) {
                return BrowseSupportFragment.this.getTitleView();
            }
            if (BrowseSupportFragment.this.getTitleView() != null && BrowseSupportFragment.this.getTitleView().hasFocus() && i10 == 130) {
                BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
                return (browseSupportFragment2.mCanShowHeaders && browseSupportFragment2.mShowingHeaders) ? browseSupportFragment2.mHeadersSupportFragment.getVerticalGridView() : browseSupportFragment2.mMainFragment.getView();
            }
            boolean z9 = view.getLayoutDirection() == 1;
            int i11 = z9 ? 66 : 17;
            int i12 = z9 ? 17 : 66;
            BrowseSupportFragment browseSupportFragment3 = BrowseSupportFragment.this;
            if (browseSupportFragment3.mCanShowHeaders && i10 == i11) {
                if (!browseSupportFragment3.isVerticalScrolling()) {
                    BrowseSupportFragment browseSupportFragment4 = BrowseSupportFragment.this;
                    if (!browseSupportFragment4.mShowingHeaders && browseSupportFragment4.isHeadersDataReady()) {
                        return BrowseSupportFragment.this.mHeadersSupportFragment.getVerticalGridView();
                    }
                }
            } else if (i10 == i12) {
                if (!browseSupportFragment3.isVerticalScrolling() && (fragment = BrowseSupportFragment.this.mMainFragment) != null && fragment.getView() != null) {
                    return BrowseSupportFragment.this.mMainFragment.getView();
                }
            } else if (i10 != 130 || !browseSupportFragment3.mShowingHeaders) {
                return null;
            }
            return view;
        }
    };
    private final BrowseFrameLayout.OnChildFocusListener mOnChildFocusListener = new BrowseFrameLayout.OnChildFocusListener() { // from class: androidx.leanback.app.BrowseSupportFragment.5
        @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
        public void onRequestChildFocus(View view, View view2) {
            if (BrowseSupportFragment.this.getChildFragmentManager().isDestroyed()) {
                return;
            }
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (!browseSupportFragment.mCanShowHeaders || browseSupportFragment.isInHeadersTransition()) {
                return;
            }
            int id = view.getId();
            if (id == R.id.browse_container_dock) {
                BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
                if (browseSupportFragment2.mShowingHeaders) {
                    browseSupportFragment2.startHeadersTransitionInternal(false);
                    return;
                }
            }
            if (id == R.id.browse_headers_dock) {
                BrowseSupportFragment browseSupportFragment3 = BrowseSupportFragment.this;
                if (browseSupportFragment3.mShowingHeaders) {
                    return;
                }
                browseSupportFragment3.startHeadersTransitionInternal(true);
            }
        }

        @Override // androidx.leanback.widget.BrowseFrameLayout.OnChildFocusListener
        public boolean onRequestFocusInDescendants(int i10, Rect rect) {
            HeadersSupportFragment headersSupportFragment;
            if (BrowseSupportFragment.this.getChildFragmentManager().isDestroyed()) {
                return true;
            }
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mCanShowHeaders && browseSupportFragment.mShowingHeaders && (headersSupportFragment = browseSupportFragment.mHeadersSupportFragment) != null && headersSupportFragment.getView() != null && BrowseSupportFragment.this.mHeadersSupportFragment.getView().requestFocus(i10, rect)) {
                return true;
            }
            Fragment fragment = BrowseSupportFragment.this.mMainFragment;
            if (fragment == null || fragment.getView() == null || !BrowseSupportFragment.this.mMainFragment.getView().requestFocus(i10, rect)) {
                return BrowseSupportFragment.this.getTitleView() != null && BrowseSupportFragment.this.getTitleView().requestFocus(i10, rect);
            }
            return true;
        }
    };
    private HeadersSupportFragment.OnHeaderClickedListener mHeaderClickedListener = new HeadersSupportFragment.OnHeaderClickedListener() { // from class: androidx.leanback.app.BrowseSupportFragment.10
        @Override // androidx.leanback.app.HeadersSupportFragment.OnHeaderClickedListener
        public void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
            Fragment fragment;
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (!browseSupportFragment.mCanShowHeaders || !browseSupportFragment.mShowingHeaders || browseSupportFragment.isInHeadersTransition() || (fragment = BrowseSupportFragment.this.mMainFragment) == null || fragment.getView() == null) {
                return;
            }
            BrowseSupportFragment.this.startHeadersTransitionInternal(false);
            BrowseSupportFragment.this.mMainFragment.getView().requestFocus();
        }
    };
    private HeadersSupportFragment.OnHeaderViewSelectedListener mHeaderViewSelectedListener = new HeadersSupportFragment.OnHeaderViewSelectedListener() { // from class: androidx.leanback.app.BrowseSupportFragment.11
        @Override // androidx.leanback.app.HeadersSupportFragment.OnHeaderViewSelectedListener
        public void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row) {
            int selectedPosition = BrowseSupportFragment.this.mHeadersSupportFragment.getSelectedPosition();
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mShowingHeaders) {
                browseSupportFragment.onRowSelected(selectedPosition);
            }
        }
    };
    private final RecyclerView.OnScrollListener mWaitScrollFinishAndCommitMainFragment = new RecyclerView.OnScrollListener() { // from class: androidx.leanback.app.BrowseSupportFragment.12
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            if (i10 == 0) {
                recyclerView.removeOnScrollListener(this);
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (browseSupportFragment.mStopped) {
                    return;
                }
                browseSupportFragment.commitMainFragment();
            }
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class BackStackListener implements FragmentManager.OnBackStackChangedListener {
        int mIndexOfHeadersBackStack = -1;
        int mLastEntryCount;

        public BackStackListener() {
            this.mLastEntryCount = BrowseSupportFragment.this.getFragmentManager().getBackStackEntryCount();
        }

        public void load(Bundle bundle) {
            if (bundle != null) {
                int i10 = bundle.getInt(BrowseSupportFragment.HEADER_STACK_INDEX, -1);
                this.mIndexOfHeadersBackStack = i10;
                BrowseSupportFragment.this.mShowingHeaders = i10 == -1;
                return;
            }
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mShowingHeaders) {
                return;
            }
            browseSupportFragment.getFragmentManager().beginTransaction().addToBackStack(BrowseSupportFragment.this.mWithHeadersBackStackName).commit();
        }

        @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
        public void onBackStackChanged() {
            if (BrowseSupportFragment.this.getFragmentManager() == null) {
                Log.w(BrowseSupportFragment.TAG, "getFragmentManager() is null, stack:", new Exception());
                return;
            }
            int backStackEntryCount = BrowseSupportFragment.this.getFragmentManager().getBackStackEntryCount();
            int i10 = this.mLastEntryCount;
            if (backStackEntryCount > i10) {
                int i11 = backStackEntryCount - 1;
                if (BrowseSupportFragment.this.mWithHeadersBackStackName.equals(BrowseSupportFragment.this.getFragmentManager().getBackStackEntryAt(i11).getName())) {
                    this.mIndexOfHeadersBackStack = i11;
                }
            } else if (backStackEntryCount < i10 && this.mIndexOfHeadersBackStack >= backStackEntryCount) {
                if (!BrowseSupportFragment.this.isHeadersDataReady()) {
                    BrowseSupportFragment.this.getFragmentManager().beginTransaction().addToBackStack(BrowseSupportFragment.this.mWithHeadersBackStackName).commit();
                    return;
                }
                this.mIndexOfHeadersBackStack = -1;
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (!browseSupportFragment.mShowingHeaders) {
                    browseSupportFragment.startHeadersTransitionInternal(true);
                }
            }
            this.mLastEntryCount = backStackEntryCount;
        }

        public void save(Bundle bundle) {
            bundle.putInt(BrowseSupportFragment.HEADER_STACK_INDEX, this.mIndexOfHeadersBackStack);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class ExpandPreLayout implements ViewTreeObserver.OnPreDrawListener {
        static final int STATE_FIRST_DRAW = 1;
        static final int STATE_INIT = 0;
        static final int STATE_SECOND_DRAW = 2;
        private final Runnable mCallback;
        private int mState;
        private final View mView;
        private MainFragmentAdapter mainFragmentAdapter;

        public ExpandPreLayout(Runnable runnable, MainFragmentAdapter mainFragmentAdapter, View view) {
            this.mView = view;
            this.mCallback = runnable;
            this.mainFragmentAdapter = mainFragmentAdapter;
        }

        public void execute() {
            this.mView.getViewTreeObserver().addOnPreDrawListener(this);
            this.mainFragmentAdapter.setExpand(false);
            this.mView.invalidate();
            this.mState = 0;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (BrowseSupportFragment.this.getView() == null || BrowseSupportFragment.this.getContext() == null) {
                this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
            int i10 = this.mState;
            if (i10 == 0) {
                this.mainFragmentAdapter.setExpand(true);
                this.mView.invalidate();
                this.mState = 1;
                return false;
            }
            if (i10 != 1) {
                return false;
            }
            this.mCallback.run();
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mState = 2;
            return false;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class FragmentFactory<T extends Fragment> {
        public abstract T createFragment(Object obj);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface FragmentHost {
        void notifyDataReady(MainFragmentAdapter mainFragmentAdapter);

        void notifyViewCreated(MainFragmentAdapter mainFragmentAdapter);

        void showTitleView(boolean z9);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class FragmentHostImpl implements FragmentHost {
        boolean mShowTitleView = true;

        public FragmentHostImpl() {
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentHost
        public void notifyDataReady(MainFragmentAdapter mainFragmentAdapter) {
            MainFragmentAdapter mainFragmentAdapter2 = BrowseSupportFragment.this.mMainFragmentAdapter;
            if (mainFragmentAdapter2 == null || mainFragmentAdapter2.getFragmentHost() != this) {
                return;
            }
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mIsPageRow) {
                browseSupportFragment.mStateMachine.fireEvent(browseSupportFragment.EVT_SCREEN_DATA_READY);
            }
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentHost
        public void notifyViewCreated(MainFragmentAdapter mainFragmentAdapter) {
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            browseSupportFragment.mStateMachine.fireEvent(browseSupportFragment.EVT_MAIN_FRAGMENT_VIEW_CREATED);
            BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
            if (browseSupportFragment2.mIsPageRow) {
                return;
            }
            browseSupportFragment2.mStateMachine.fireEvent(browseSupportFragment2.EVT_SCREEN_DATA_READY);
        }

        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentHost
        public void showTitleView(boolean z9) {
            this.mShowTitleView = z9;
            MainFragmentAdapter mainFragmentAdapter = BrowseSupportFragment.this.mMainFragmentAdapter;
            if (mainFragmentAdapter == null || mainFragmentAdapter.getFragmentHost() != this) {
                return;
            }
            BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
            if (browseSupportFragment.mIsPageRow) {
                browseSupportFragment.updateTitleViewVisibility();
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ListRowFragmentFactory extends FragmentFactory<RowsSupportFragment> {
        @Override // androidx.leanback.app.BrowseSupportFragment.FragmentFactory
        public RowsSupportFragment createFragment(Object obj) {
            return new RowsSupportFragment();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface MainFragmentAdapterProvider {
        MainFragmentAdapter getMainFragmentAdapter();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class MainFragmentAdapterRegistry {
        private static final FragmentFactory sDefaultFragmentFactory = new ListRowFragmentFactory();
        private final Map<Class<?>, FragmentFactory> mItemToFragmentFactoryMapping = new HashMap();

        public MainFragmentAdapterRegistry() {
            registerFragment(ListRow.class, sDefaultFragmentFactory);
        }

        public Fragment createFragment(Object obj) {
            FragmentFactory fragmentFactory = obj == null ? sDefaultFragmentFactory : this.mItemToFragmentFactoryMapping.get(obj.getClass());
            if (fragmentFactory == null && !(obj instanceof PageRow)) {
                fragmentFactory = sDefaultFragmentFactory;
            }
            return fragmentFactory.createFragment(obj);
        }

        public void registerFragment(Class<?> cls, FragmentFactory fragmentFactory) {
            this.mItemToFragmentFactoryMapping.put(cls, fragmentFactory);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class MainFragmentItemViewSelectedListener implements OnItemViewSelectedListener {
        MainFragmentRowsAdapter mMainFragmentRowsAdapter;

        public MainFragmentItemViewSelectedListener(MainFragmentRowsAdapter mainFragmentRowsAdapter) {
            this.mMainFragmentRowsAdapter = mainFragmentRowsAdapter;
        }

        @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
        public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            BrowseSupportFragment.this.onRowSelected(this.mMainFragmentRowsAdapter.getSelectedPosition());
            OnItemViewSelectedListener onItemViewSelectedListener = BrowseSupportFragment.this.mExternalOnItemViewSelectedListener;
            if (onItemViewSelectedListener != null) {
                onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class MainFragmentRowsAdapter<T extends Fragment> {
        private final T mFragment;

        public MainFragmentRowsAdapter(T t) {
            if (t != null) {
                this.mFragment = t;
            } else {
                a.n("Fragment can't be null");
                throw null;
            }
        }

        public RowPresenter.ViewHolder findRowViewHolderByPosition(int i10) {
            return null;
        }

        public final T getFragment() {
            return this.mFragment;
        }

        public int getSelectedPosition() {
            return 0;
        }

        public void setSelectedPosition(int i10, boolean z9, Presenter.ViewHolderTask viewHolderTask) {
        }

        public void setAdapter(ObjectAdapter objectAdapter) {
        }

        public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        }

        public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        }

        public void setSelectedPosition(int i10, boolean z9) {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface MainFragmentRowsAdapterProvider {
        MainFragmentRowsAdapter getMainFragmentRowsAdapter();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class SetSelectionRunnable implements Runnable {
        static final int TYPE_INTERNAL_SYNC = 0;
        static final int TYPE_INVALID = -1;
        static final int TYPE_USER_REQUEST = 1;
        private int mPosition;
        private boolean mSmooth;
        private int mType;

        public SetSelectionRunnable() {
            reset();
        }

        private void reset() {
            this.mPosition = -1;
            this.mType = -1;
            this.mSmooth = false;
        }

        public void post(int i10, int i11, boolean z9) {
            if (i11 >= this.mType) {
                this.mPosition = i10;
                this.mType = i11;
                this.mSmooth = z9;
                BrowseSupportFragment.this.mBrowseFrame.removeCallbacks(this);
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                if (browseSupportFragment.mStopped) {
                    return;
                }
                browseSupportFragment.mBrowseFrame.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            BrowseSupportFragment.this.setSelection(this.mPosition, this.mSmooth);
            reset();
        }

        public void start() {
            if (this.mType != -1) {
                BrowseSupportFragment.this.mBrowseFrame.post(this);
            }
        }

        public void stop() {
            BrowseSupportFragment.this.mBrowseFrame.removeCallbacks(this);
        }
    }

    public static Bundle createArgs(Bundle bundle, String str, int i10) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(ARG_TITLE, str);
        bundle.putInt(ARG_HEADERS_STATE, i10);
        return bundle;
    }

    private boolean createMainFragment(ObjectAdapter objectAdapter, int i10) {
        Object obj;
        boolean z9 = true;
        if (this.mCanShowHeaders) {
            if (objectAdapter != null && objectAdapter.size() != 0) {
                if (i10 < 0) {
                    i10 = 0;
                } else if (i10 >= objectAdapter.size()) {
                    androidx.core.view.accessibility.a.r("Invalid position %d requested", new Object[]{Integer.valueOf(i10)});
                }
                obj = objectAdapter.get(i10);
            }
            return false;
        }
        obj = null;
        boolean z10 = this.mIsPageRow;
        Object obj2 = this.mPageRow;
        boolean z11 = this.mCanShowHeaders && (obj instanceof PageRow);
        this.mIsPageRow = z11;
        Object obj3 = z11 ? obj : null;
        this.mPageRow = obj3;
        if (this.mMainFragment != null) {
            if (!z10) {
                z9 = z11;
            } else if (z11 && (obj2 == null || obj2 == obj3)) {
                z9 = false;
            }
        }
        if (!z9) {
            return z9;
        }
        Fragment fragmentCreateFragment = this.mMainFragmentAdapterRegistry.createFragment(obj);
        this.mMainFragment = fragmentCreateFragment;
        if (fragmentCreateFragment instanceof MainFragmentAdapterProvider) {
            setMainFragmentAdapter();
            return z9;
        }
        a.n("Fragment must implement MainFragmentAdapterProvider");
        return false;
    }

    private void expandMainFragment(boolean z9) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mScaleFrameLayout.getLayoutParams();
        marginLayoutParams.setMarginStart(!z9 ? this.mContainerListMarginStart : 0);
        this.mScaleFrameLayout.setLayoutParams(marginLayoutParams);
        this.mMainFragmentAdapter.setExpand(z9);
        setMainFragmentAlignment();
        float f = (!z9 && this.mMainFragmentScaleEnabled && this.mMainFragmentAdapter.isScalingEnabled()) ? this.mScaleFactor : 1.0f;
        this.mScaleFrameLayout.setLayoutScaleY(f);
        this.mScaleFrameLayout.setChildScale(f);
    }

    private void onExpandTransitionStart(boolean z9, Runnable runnable) {
        if (z9) {
            runnable.run();
        } else {
            new ExpandPreLayout(runnable, this.mMainFragmentAdapter, getView()).execute();
        }
    }

    private void readArguments(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String str = ARG_TITLE;
        if (bundle.containsKey(str)) {
            setTitle(bundle.getString(str));
        }
        String str2 = ARG_HEADERS_STATE;
        if (bundle.containsKey(str2)) {
            setHeadersState(bundle.getInt(str2));
        }
    }

    private void replaceMainFragment(int i10) {
        if (createMainFragment(this.mAdapter, i10)) {
            swapToMainFragment();
            expandMainFragment((this.mCanShowHeaders && this.mShowingHeaders) ? false : true);
        }
    }

    private void setHeadersOnScreen(boolean z9) {
        View view = this.mHeadersSupportFragment.getView();
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMarginStart(z9 ? 0 : -this.mContainerListMarginStart);
        view.setLayoutParams(marginLayoutParams);
    }

    private void setMainFragmentAlignment() {
        int i10 = this.mContainerListAlignTop;
        if (this.mMainFragmentScaleEnabled && this.mMainFragmentAdapter.isScalingEnabled() && this.mShowingHeaders) {
            i10 = (int) ((i10 / this.mScaleFactor) + 0.5f);
        }
        this.mMainFragmentAdapter.setAlignment(i10);
    }

    private void swapToMainFragment() {
        if (this.mStopped) {
            return;
        }
        VerticalGridView verticalGridView = this.mHeadersSupportFragment.getVerticalGridView();
        if (!isShowingHeaders() || verticalGridView == null || verticalGridView.getScrollState() == 0) {
            commitMainFragment();
            return;
        }
        getChildFragmentManager().beginTransaction().replace(R.id.scale_frame, new Fragment()).commit();
        verticalGridView.removeOnScrollListener(this.mWaitScrollFinishAndCommitMainFragment);
        verticalGridView.addOnScrollListener(this.mWaitScrollFinishAndCommitMainFragment);
    }

    private void updateWrapperPresenter() {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter == null) {
            this.mAdapterPresenter = null;
            return;
        }
        final PresenterSelector presenterSelector = objectAdapter.getPresenterSelector();
        if (presenterSelector == null) {
            a.n("Adapter.getPresenterSelector() is null");
            return;
        }
        if (presenterSelector == this.mAdapterPresenter) {
            return;
        }
        this.mAdapterPresenter = presenterSelector;
        Presenter[] presenters = presenterSelector.getPresenters();
        final InvisibleRowPresenter invisibleRowPresenter = new InvisibleRowPresenter();
        int length = presenters.length;
        final Presenter[] presenterArr = new Presenter[length + 1];
        System.arraycopy(presenterArr, 0, presenters, 0, presenters.length);
        presenterArr[length] = invisibleRowPresenter;
        this.mAdapter.setPresenterSelector(new PresenterSelector() { // from class: androidx.leanback.app.BrowseSupportFragment.2
            @Override // androidx.leanback.widget.PresenterSelector
            public Presenter getPresenter(Object obj) {
                return ((Row) obj).isRenderedAsRowView() ? presenterSelector.getPresenter(obj) : invisibleRowPresenter;
            }

            @Override // androidx.leanback.widget.PresenterSelector
            public Presenter[] getPresenters() {
                return presenterArr;
            }
        });
    }

    public final void commitMainFragment() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i10 = R.id.scale_frame;
        if (childFragmentManager.findFragmentById(i10) != this.mMainFragment) {
            childFragmentManager.beginTransaction().replace(i10, this.mMainFragment).commit();
        }
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public Object createEntranceTransition() {
        return TransitionHelper.loadTransition(getContext(), R.transition.lb_browse_entrance_transition);
    }

    public void createHeadersTransition() {
        Object objLoadTransition = TransitionHelper.loadTransition(getContext(), this.mShowingHeaders ? R.transition.lb_browse_headers_in : R.transition.lb_browse_headers_out);
        this.mHeadersTransition = objLoadTransition;
        TransitionHelper.addTransitionListener(objLoadTransition, new TransitionListener() { // from class: androidx.leanback.app.BrowseSupportFragment.9
            @Override // androidx.leanback.transition.TransitionListener
            public void onTransitionEnd(Object obj) {
                VerticalGridView verticalGridView;
                Fragment fragment;
                View view;
                BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                browseSupportFragment.mHeadersTransition = null;
                MainFragmentAdapter mainFragmentAdapter = browseSupportFragment.mMainFragmentAdapter;
                if (mainFragmentAdapter != null) {
                    mainFragmentAdapter.onTransitionEnd();
                    BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
                    if (!browseSupportFragment2.mShowingHeaders && (fragment = browseSupportFragment2.mMainFragment) != null && (view = fragment.getView()) != null && !view.hasFocus()) {
                        view.requestFocus();
                    }
                }
                HeadersSupportFragment headersSupportFragment = BrowseSupportFragment.this.mHeadersSupportFragment;
                if (headersSupportFragment != null) {
                    headersSupportFragment.onTransitionEnd();
                    BrowseSupportFragment browseSupportFragment3 = BrowseSupportFragment.this;
                    if (browseSupportFragment3.mShowingHeaders && (verticalGridView = browseSupportFragment3.mHeadersSupportFragment.getVerticalGridView()) != null && !verticalGridView.hasFocus()) {
                        verticalGridView.requestFocus();
                    }
                }
                BrowseSupportFragment.this.updateTitleViewVisibility();
                BrowseSupportFragment browseSupportFragment4 = BrowseSupportFragment.this;
                BrowseTransitionListener browseTransitionListener = browseSupportFragment4.mBrowseTransitionListener;
                if (browseTransitionListener != null) {
                    browseTransitionListener.onHeadersTransitionStop(browseSupportFragment4.mShowingHeaders);
                }
            }

            @Override // androidx.leanback.transition.TransitionListener
            public void onTransitionStart(Object obj) {
            }
        });
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void createStateMachineStates() {
        super.createStateMachineStates();
        this.mStateMachine.addState(this.STATE_SET_ENTRANCE_START_STATE);
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void createStateMachineTransitions() {
        super.createStateMachineTransitions();
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_SET_ENTRANCE_START_STATE, this.EVT_HEADER_VIEW_CREATED);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_ENTRANCE_ON_PREPARED_ON_CREATEVIEW, this.EVT_MAIN_FRAGMENT_VIEW_CREATED);
        this.mStateMachine.addTransition(this.STATE_ENTRANCE_ON_PREPARED, this.STATE_ENTRANCE_PERFORM, this.EVT_SCREEN_DATA_READY);
    }

    public void enableMainFragmentScaling(boolean z9) {
        this.mMainFragmentScaleEnabled = z9;
    }

    @Deprecated
    public void enableRowScaling(boolean z9) {
        enableMainFragmentScaling(z9);
    }

    public ObjectAdapter getAdapter() {
        return this.mAdapter;
    }

    @ColorInt
    public int getBrandColor() {
        return this.mBrandColor;
    }

    public int getHeadersState() {
        return this.mHeadersState;
    }

    public HeadersSupportFragment getHeadersSupportFragment() {
        return this.mHeadersSupportFragment;
    }

    public Fragment getMainFragment() {
        return this.mMainFragment;
    }

    public final MainFragmentAdapterRegistry getMainFragmentRegistry() {
        return this.mMainFragmentAdapterRegistry;
    }

    public OnItemViewClickedListener getOnItemViewClickedListener() {
        return this.mOnItemViewClickedListener;
    }

    public OnItemViewSelectedListener getOnItemViewSelectedListener() {
        return this.mExternalOnItemViewSelectedListener;
    }

    public RowsSupportFragment getRowsSupportFragment() {
        Fragment fragment = this.mMainFragment;
        if (fragment instanceof RowsSupportFragment) {
            return (RowsSupportFragment) fragment;
        }
        return null;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public RowPresenter.ViewHolder getSelectedRowViewHolder() {
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter == null) {
            return null;
        }
        return this.mMainFragmentRowsAdapter.findRowViewHolderByPosition(mainFragmentRowsAdapter.getSelectedPosition());
    }

    public boolean isFirstRowWithContent(int i10) {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter != null && objectAdapter.size() != 0) {
            int i11 = 0;
            while (i11 < this.mAdapter.size()) {
                if (((Row) this.mAdapter.get(i11)).isRenderedAsRowView()) {
                    return i10 == i11;
                }
                i11++;
            }
        }
        return true;
    }

    public boolean isFirstRowWithContentOrPageRow(int i10) {
        ObjectAdapter objectAdapter = this.mAdapter;
        if (objectAdapter != null && objectAdapter.size() != 0) {
            int i11 = 0;
            while (i11 < this.mAdapter.size()) {
                Row row = (Row) this.mAdapter.get(i11);
                if (row.isRenderedAsRowView() || (row instanceof PageRow)) {
                    return i10 == i11;
                }
                i11++;
            }
        }
        return true;
    }

    public final boolean isHeadersDataReady() {
        ObjectAdapter objectAdapter = this.mAdapter;
        return (objectAdapter == null || objectAdapter.size() == 0) ? false : true;
    }

    public final boolean isHeadersTransitionOnBackEnabled() {
        return this.mHeadersBackStackEnabled;
    }

    public boolean isInHeadersTransition() {
        return this.mHeadersTransition != null;
    }

    public boolean isShowingHeaders() {
        return this.mShowingHeaders;
    }

    public boolean isVerticalScrolling() {
        return this.mHeadersSupportFragment.isScrolling() || this.mMainFragmentAdapter.isScrolling();
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.LeanbackTheme);
        this.mContainerListMarginStart = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginStart, r0.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_start));
        this.mContainerListAlignTop = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsMarginTop, r0.getResources().getDimensionPixelSize(R.dimen.lb_browse_rows_margin_top));
        typedArrayObtainStyledAttributes.recycle();
        readArguments(getArguments());
        if (this.mCanShowHeaders) {
            if (this.mHeadersBackStackEnabled) {
                this.mWithHeadersBackStackName = LB_HEADERS_BACKSTACK + this;
                this.mBackStackChangedListener = new BackStackListener();
                getFragmentManager().addOnBackStackChangedListener(this.mBackStackChangedListener);
                this.mBackStackChangedListener.load(bundle);
            } else if (bundle != null) {
                this.mShowingHeaders = bundle.getBoolean(HEADER_SHOW);
            }
        }
        this.mScaleFactor = getResources().getFraction(R.fraction.lb_browse_rows_scale, 1, 1);
    }

    public HeadersSupportFragment onCreateHeadersSupportFragment() {
        return new HeadersSupportFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i10 = R.id.scale_frame;
        if (childFragmentManager.findFragmentById(i10) == null) {
            this.mHeadersSupportFragment = onCreateHeadersSupportFragment();
            createMainFragment(this.mAdapter, this.mSelectedPosition);
            FragmentTransaction fragmentTransactionReplace = getChildFragmentManager().beginTransaction().replace(R.id.browse_headers_dock, this.mHeadersSupportFragment);
            Fragment fragment = this.mMainFragment;
            if (fragment != null) {
                fragmentTransactionReplace.replace(i10, fragment);
            } else {
                MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(null);
                this.mMainFragmentAdapter = mainFragmentAdapter;
                mainFragmentAdapter.setFragmentHost(new FragmentHostImpl());
            }
            fragmentTransactionReplace.commit();
        } else {
            this.mHeadersSupportFragment = (HeadersSupportFragment) getChildFragmentManager().findFragmentById(R.id.browse_headers_dock);
            this.mMainFragment = getChildFragmentManager().findFragmentById(i10);
            this.mIsPageRow = bundle != null && bundle.getBoolean(IS_PAGE_ROW, false);
            this.mSelectedPosition = bundle != null ? bundle.getInt(CURRENT_SELECTED_POSITION, 0) : 0;
            setMainFragmentAdapter();
        }
        this.mHeadersSupportFragment.setHeadersGone(true ^ this.mCanShowHeaders);
        PresenterSelector presenterSelector = this.mHeaderPresenterSelector;
        if (presenterSelector != null) {
            this.mHeadersSupportFragment.setPresenterSelector(presenterSelector);
        }
        this.mHeadersSupportFragment.setAdapter(this.mAdapter);
        this.mHeadersSupportFragment.setOnHeaderViewSelectedListener(this.mHeaderViewSelectedListener);
        this.mHeadersSupportFragment.setOnHeaderClickedListener(this.mHeaderClickedListener);
        View viewInflate = layoutInflater.inflate(R.layout.lb_browse_fragment, viewGroup, false);
        getProgressBarManager().setRootView((ViewGroup) viewInflate);
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) viewInflate.findViewById(R.id.browse_frame);
        this.mBrowseFrame = browseFrameLayout;
        browseFrameLayout.setOnChildFocusListener(this.mOnChildFocusListener);
        this.mBrowseFrame.setOnFocusSearchListener(this.mOnFocusSearchListener);
        installTitleView(layoutInflater, this.mBrowseFrame, bundle);
        ScaleFrameLayout scaleFrameLayout = (ScaleFrameLayout) viewInflate.findViewById(i10);
        this.mScaleFrameLayout = scaleFrameLayout;
        scaleFrameLayout.setPivotX(0.0f);
        this.mScaleFrameLayout.setPivotY(this.mContainerListAlignTop);
        if (this.mBrandColorSet) {
            this.mHeadersSupportFragment.setBackgroundColor(this.mBrandColor);
        }
        this.mSceneWithHeaders = TransitionHelper.createScene(this.mBrowseFrame, new Runnable() { // from class: androidx.leanback.app.BrowseSupportFragment.6
            @Override // java.lang.Runnable
            public void run() {
                BrowseSupportFragment.this.showHeaders(true);
            }
        });
        this.mSceneWithoutHeaders = TransitionHelper.createScene(this.mBrowseFrame, new Runnable() { // from class: androidx.leanback.app.BrowseSupportFragment.7
            @Override // java.lang.Runnable
            public void run() {
                BrowseSupportFragment.this.showHeaders(false);
            }
        });
        this.mSceneAfterEntranceTransition = TransitionHelper.createScene(this.mBrowseFrame, new Runnable() { // from class: androidx.leanback.app.BrowseSupportFragment.8
            @Override // java.lang.Runnable
            public void run() {
                BrowseSupportFragment.this.setEntranceTransitionEndState();
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mBackStackChangedListener != null) {
            getFragmentManager().removeOnBackStackChangedListener(this.mBackStackChangedListener);
        }
        super.onDestroy();
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        setMainFragmentRowsAdapter(null);
        this.mPageRow = null;
        this.mMainFragmentAdapter = null;
        this.mMainFragment = null;
        this.mHeadersSupportFragment = null;
        this.mBrowseFrame = null;
        this.mScaleFrameLayout = null;
        this.mSceneAfterEntranceTransition = null;
        this.mSceneWithHeaders = null;
        this.mSceneWithoutHeaders = null;
        super.onDestroyView();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void onEntranceTransitionEnd() {
        MainFragmentAdapter mainFragmentAdapter = this.mMainFragmentAdapter;
        if (mainFragmentAdapter != null) {
            mainFragmentAdapter.onTransitionEnd();
        }
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment != null) {
            headersSupportFragment.onTransitionEnd();
        }
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void onEntranceTransitionPrepare() {
        this.mHeadersSupportFragment.onTransitionPrepare();
        this.mMainFragmentAdapter.setEntranceTransitionState(false);
        this.mMainFragmentAdapter.onTransitionPrepare();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void onEntranceTransitionStart() {
        this.mHeadersSupportFragment.onTransitionStart();
        this.mMainFragmentAdapter.onTransitionStart();
    }

    public void onRowSelected(int i10) {
        this.mSetSelectionRunnable.post(i10, 0, true);
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(CURRENT_SELECTED_POSITION, this.mSelectedPosition);
        bundle.putBoolean(IS_PAGE_ROW, this.mIsPageRow);
        BackStackListener backStackListener = this.mBackStackChangedListener;
        if (backStackListener != null) {
            backStackListener.save(bundle);
        } else {
            bundle.putBoolean(HEADER_SHOW, this.mShowingHeaders);
        }
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Fragment fragment;
        HeadersSupportFragment headersSupportFragment;
        super.onStart();
        this.mHeadersSupportFragment.setAlignment(this.mContainerListAlignTop);
        setMainFragmentAlignment();
        if (this.mCanShowHeaders && this.mShowingHeaders && (headersSupportFragment = this.mHeadersSupportFragment) != null && headersSupportFragment.getView() != null) {
            this.mHeadersSupportFragment.getView().requestFocus();
        } else if ((!this.mCanShowHeaders || !this.mShowingHeaders) && (fragment = this.mMainFragment) != null && fragment.getView() != null) {
            this.mMainFragment.getView().requestFocus();
        }
        if (this.mCanShowHeaders) {
            showHeaders(this.mShowingHeaders);
        }
        this.mStateMachine.fireEvent(this.EVT_HEADER_VIEW_CREATED);
        this.mStopped = false;
        commitMainFragment();
        this.mSetSelectionRunnable.start();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.mStopped = true;
        this.mSetSelectionRunnable.stop();
        super.onStop();
    }

    @Override // androidx.leanback.app.BaseSupportFragment
    public void runEntranceTransition(Object obj) {
        TransitionHelper.runTransition(this.mSceneAfterEntranceTransition, obj);
    }

    public void setAdapter(ObjectAdapter objectAdapter) {
        this.mAdapter = objectAdapter;
        updateWrapperPresenter();
        if (getView() == null) {
            return;
        }
        updateMainFragmentRowsAdapter();
        this.mHeadersSupportFragment.setAdapter(this.mAdapter);
    }

    public void setBrandColor(@ColorInt int i10) {
        this.mBrandColor = i10;
        this.mBrandColorSet = true;
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment != null) {
            headersSupportFragment.setBackgroundColor(i10);
        }
    }

    public void setBrowseTransitionListener(BrowseTransitionListener browseTransitionListener) {
        this.mBrowseTransitionListener = browseTransitionListener;
    }

    public void setEntranceTransitionEndState() {
        setHeadersOnScreen(this.mShowingHeaders);
        setSearchOrbViewOnScreen(true);
        this.mMainFragmentAdapter.setEntranceTransitionState(true);
    }

    public void setEntranceTransitionStartState() {
        setHeadersOnScreen(false);
        setSearchOrbViewOnScreen(false);
    }

    public void setHeaderPresenterSelector(PresenterSelector presenterSelector) {
        this.mHeaderPresenterSelector = presenterSelector;
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment != null) {
            headersSupportFragment.setPresenterSelector(presenterSelector);
        }
    }

    public void setHeadersState(int i10) {
        if (i10 < 1 || i10 > 3) {
            a.n(a3.a.f(i10, "Invalid headers state: "));
            return;
        }
        if (i10 != this.mHeadersState) {
            this.mHeadersState = i10;
            if (i10 == 1) {
                this.mCanShowHeaders = true;
                this.mShowingHeaders = true;
            } else if (i10 == 2) {
                this.mCanShowHeaders = true;
                this.mShowingHeaders = false;
            } else if (i10 != 3) {
                androidx.constraintlayout.core.widgets.analyzer.a.B(i10, "Unknown headers state: ", TAG);
            } else {
                this.mCanShowHeaders = false;
                this.mShowingHeaders = false;
            }
            HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
            if (headersSupportFragment != null) {
                headersSupportFragment.setHeadersGone(true ^ this.mCanShowHeaders);
            }
        }
    }

    public final void setHeadersTransitionOnBackEnabled(boolean z9) {
        this.mHeadersBackStackEnabled = z9;
    }

    public void setMainFragmentAdapter() {
        MainFragmentAdapter mainFragmentAdapter = ((MainFragmentAdapterProvider) this.mMainFragment).getMainFragmentAdapter();
        this.mMainFragmentAdapter = mainFragmentAdapter;
        mainFragmentAdapter.setFragmentHost(new FragmentHostImpl());
        if (this.mIsPageRow) {
            setMainFragmentRowsAdapter(null);
            return;
        }
        ActivityResultCaller activityResultCaller = this.mMainFragment;
        if (activityResultCaller instanceof MainFragmentRowsAdapterProvider) {
            setMainFragmentRowsAdapter(((MainFragmentRowsAdapterProvider) activityResultCaller).getMainFragmentRowsAdapter());
        } else {
            setMainFragmentRowsAdapter(null);
        }
        this.mIsPageRow = this.mMainFragmentRowsAdapter == null;
    }

    public void setMainFragmentRowsAdapter(MainFragmentRowsAdapter mainFragmentRowsAdapter) {
        MainFragmentRowsAdapter mainFragmentRowsAdapter2 = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter == mainFragmentRowsAdapter2) {
            return;
        }
        if (mainFragmentRowsAdapter2 != null) {
            mainFragmentRowsAdapter2.setAdapter(null);
        }
        this.mMainFragmentRowsAdapter = mainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setOnItemViewSelectedListener(new MainFragmentItemViewSelectedListener(mainFragmentRowsAdapter));
            this.mMainFragmentRowsAdapter.setOnItemViewClickedListener(this.mOnItemViewClickedListener);
        }
        updateMainFragmentRowsAdapter();
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.mOnItemViewClickedListener = onItemViewClickedListener;
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setOnItemViewClickedListener(onItemViewClickedListener);
        }
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.mExternalOnItemViewSelectedListener = onItemViewSelectedListener;
    }

    public void setSearchOrbViewOnScreen(boolean z9) {
        View searchAffordanceView = getTitleViewAdapter().getSearchAffordanceView();
        if (searchAffordanceView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) searchAffordanceView.getLayoutParams();
            marginLayoutParams.setMarginStart(z9 ? 0 : -this.mContainerListMarginStart);
            searchAffordanceView.setLayoutParams(marginLayoutParams);
        }
    }

    public void setSelectedPosition(int i10, boolean z9, Presenter.ViewHolderTask viewHolderTask) {
        if (this.mMainFragmentAdapterRegistry == null) {
            return;
        }
        if (viewHolderTask != null) {
            startHeadersTransition(false);
        }
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setSelectedPosition(i10, z9, viewHolderTask);
        }
    }

    public void setSelection(int i10, boolean z9) {
        if (i10 == -1) {
            return;
        }
        this.mSelectedPosition = i10;
        HeadersSupportFragment headersSupportFragment = this.mHeadersSupportFragment;
        if (headersSupportFragment == null || this.mMainFragmentAdapter == null) {
            return;
        }
        headersSupportFragment.setSelectedPosition(i10, z9);
        replaceMainFragment(i10);
        MainFragmentRowsAdapter mainFragmentRowsAdapter = this.mMainFragmentRowsAdapter;
        if (mainFragmentRowsAdapter != null) {
            mainFragmentRowsAdapter.setSelectedPosition(i10, z9);
        }
        updateTitleViewVisibility();
    }

    public void showHeaders(boolean z9) {
        this.mHeadersSupportFragment.setHeadersEnabled(z9);
        setHeadersOnScreen(z9);
        expandMainFragment(!z9);
    }

    public void startHeadersTransition(boolean z9) {
        if (!this.mCanShowHeaders) {
            c.g("Cannot start headers transition");
        } else {
            if (isInHeadersTransition() || this.mShowingHeaders == z9) {
                return;
            }
            startHeadersTransitionInternal(z9);
        }
    }

    public void startHeadersTransitionInternal(final boolean z9) {
        if (!getFragmentManager().isDestroyed() && isHeadersDataReady()) {
            this.mShowingHeaders = z9;
            this.mMainFragmentAdapter.onTransitionPrepare();
            this.mMainFragmentAdapter.onTransitionStart();
            onExpandTransitionStart(!z9, new Runnable() { // from class: androidx.leanback.app.BrowseSupportFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    BrowseSupportFragment.this.mHeadersSupportFragment.onTransitionPrepare();
                    BrowseSupportFragment.this.mHeadersSupportFragment.onTransitionStart();
                    BrowseSupportFragment.this.createHeadersTransition();
                    BrowseTransitionListener browseTransitionListener = BrowseSupportFragment.this.mBrowseTransitionListener;
                    if (browseTransitionListener != null) {
                        browseTransitionListener.onHeadersTransitionStart(z9);
                    }
                    boolean z10 = z9;
                    BrowseSupportFragment browseSupportFragment = BrowseSupportFragment.this;
                    TransitionHelper.runTransition(z10 ? browseSupportFragment.mSceneWithHeaders : browseSupportFragment.mSceneWithoutHeaders, BrowseSupportFragment.this.mHeadersTransition);
                    BrowseSupportFragment browseSupportFragment2 = BrowseSupportFragment.this;
                    if (browseSupportFragment2.mHeadersBackStackEnabled) {
                        if (!z9) {
                            browseSupportFragment2.getFragmentManager().beginTransaction().addToBackStack(BrowseSupportFragment.this.mWithHeadersBackStackName).commit();
                            return;
                        }
                        int i10 = browseSupportFragment2.mBackStackChangedListener.mIndexOfHeadersBackStack;
                        if (i10 >= 0) {
                            BrowseSupportFragment.this.getFragmentManager().popBackStackImmediate(browseSupportFragment2.getFragmentManager().getBackStackEntryAt(i10).getId(), 1);
                        }
                    }
                }
            });
        }
    }

    public void updateMainFragmentRowsAdapter() {
        ListRowDataAdapter listRowDataAdapter = this.mMainFragmentListRowDataAdapter;
        if (listRowDataAdapter != null) {
            listRowDataAdapter.detach();
            this.mMainFragmentListRowDataAdapter = null;
        }
        if (this.mMainFragmentRowsAdapter != null) {
            ObjectAdapter objectAdapter = this.mAdapter;
            ListRowDataAdapter listRowDataAdapter2 = objectAdapter != null ? new ListRowDataAdapter(objectAdapter) : null;
            this.mMainFragmentListRowDataAdapter = listRowDataAdapter2;
            this.mMainFragmentRowsAdapter.setAdapter(listRowDataAdapter2);
        }
    }

    public void updateTitleViewVisibility() {
        MainFragmentAdapter mainFragmentAdapter;
        MainFragmentAdapter mainFragmentAdapter2;
        boolean z9 = this.mShowingHeaders;
        boolean z10 = this.mIsPageRow;
        if (!z9) {
            if ((!z10 || (mainFragmentAdapter2 = this.mMainFragmentAdapter) == null) ? isFirstRowWithContent(this.mSelectedPosition) : mainFragmentAdapter2.mFragmentHost.mShowTitleView) {
                showTitle(6);
                return;
            } else {
                showTitle(false);
                return;
            }
        }
        boolean zIsFirstRowWithContent = (!z10 || (mainFragmentAdapter = this.mMainFragmentAdapter) == null) ? isFirstRowWithContent(this.mSelectedPosition) : mainFragmentAdapter.mFragmentHost.mShowTitleView;
        boolean zIsFirstRowWithContentOrPageRow = isFirstRowWithContentOrPageRow(this.mSelectedPosition);
        int i10 = zIsFirstRowWithContent ? 2 : 0;
        if (zIsFirstRowWithContentOrPageRow) {
            i10 |= 4;
        }
        if (i10 != 0) {
            showTitle(i10);
        } else {
            showTitle(false);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class MainFragmentAdapter<T extends Fragment> {
        private final T mFragment;
        FragmentHostImpl mFragmentHost;
        private boolean mScalingEnabled;

        public MainFragmentAdapter(T t) {
            this.mFragment = t;
        }

        public final T getFragment() {
            return this.mFragment;
        }

        public final FragmentHost getFragmentHost() {
            return this.mFragmentHost;
        }

        public boolean isScalingEnabled() {
            return this.mScalingEnabled;
        }

        public boolean isScrolling() {
            return false;
        }

        public boolean onTransitionPrepare() {
            return false;
        }

        public void setFragmentHost(FragmentHostImpl fragmentHostImpl) {
            this.mFragmentHost = fragmentHostImpl;
        }

        public void setScalingEnabled(boolean z9) {
            this.mScalingEnabled = z9;
        }

        public void onTransitionEnd() {
        }

        public void onTransitionStart() {
        }

        public void setAlignment(int i10) {
        }

        public void setEntranceTransitionState(boolean z9) {
        }

        public void setExpand(boolean z9) {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class BrowseTransitionListener {
        public void onHeadersTransitionStart(boolean z9) {
        }

        public void onHeadersTransitionStop(boolean z9) {
        }
    }

    public void setSelectedPosition(int i10, boolean z9) {
        this.mSetSelectionRunnable.post(i10, 1, z9);
    }

    public void setSelectedPosition(int i10) {
        setSelectedPosition(i10, true);
    }
}
