package androidx.leanback.app;

import a3.a;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import androidx.leanback.R;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.SearchBar;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.SpeechRecognitionCallback;
import androidx.leanback.widget.VerticalGridView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes.dex */
public class SearchFragment extends Fragment {
    private static final String ARG_PREFIX = "androidx.leanback.app.SearchFragment";
    private static final String ARG_QUERY;
    private static final String ARG_TITLE;
    static final int AUDIO_PERMISSION_REQUEST_CODE = 0;
    static final boolean DEBUG = false;
    private static final String EXTRA_LEANBACK_BADGE_PRESENT = "LEANBACK_BADGE_PRESENT";
    static final int QUERY_COMPLETE = 2;
    static final int RESULTS_CHANGED = 1;
    static final long SPEECH_RECOGNITION_DELAY_MS = 300;
    static final String TAG = "SearchFragment";
    private Drawable mBadgeDrawable;
    private ExternalQuery mExternalQuery;
    private boolean mIsPaused;
    private OnItemViewClickedListener mOnItemViewClickedListener;
    OnItemViewSelectedListener mOnItemViewSelectedListener;
    private boolean mPendingStartRecognitionWhenPaused;
    SearchResultProvider mProvider;
    ObjectAdapter mResultAdapter;
    RowsFragment mRowsFragment;
    SearchBar mSearchBar;
    private SpeechRecognitionCallback mSpeechRecognitionCallback;
    private SpeechRecognizer mSpeechRecognizer;
    boolean mSpeechRecognizerEnabled;
    int mStatus;
    private String mTitle;
    final ObjectAdapter.DataObserver mAdapterObserver = new ObjectAdapter.DataObserver() { // from class: androidx.leanback.app.SearchFragment.1
        @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
        public void onChanged() {
            SearchFragment searchFragment = SearchFragment.this;
            searchFragment.mHandler.removeCallbacks(searchFragment.mResultsChangedCallback);
            SearchFragment searchFragment2 = SearchFragment.this;
            searchFragment2.mHandler.post(searchFragment2.mResultsChangedCallback);
        }
    };
    final Handler mHandler = new Handler();
    final Runnable mResultsChangedCallback = new Runnable() { // from class: androidx.leanback.app.SearchFragment.2
        @Override // java.lang.Runnable
        public void run() {
            RowsFragment rowsFragment = SearchFragment.this.mRowsFragment;
            if (rowsFragment != null) {
                ObjectAdapter adapter = rowsFragment.getAdapter();
                SearchFragment searchFragment = SearchFragment.this;
                if (adapter != searchFragment.mResultAdapter && (searchFragment.mRowsFragment.getAdapter() != null || SearchFragment.this.mResultAdapter.size() != 0)) {
                    SearchFragment searchFragment2 = SearchFragment.this;
                    searchFragment2.mRowsFragment.setAdapter(searchFragment2.mResultAdapter);
                    SearchFragment.this.mRowsFragment.setSelectedPosition(0);
                }
            }
            SearchFragment.this.updateSearchBarVisibility();
            SearchFragment searchFragment3 = SearchFragment.this;
            int i10 = searchFragment3.mStatus | 1;
            searchFragment3.mStatus = i10;
            if ((i10 & 2) != 0) {
                searchFragment3.updateFocus();
            }
        }
    };
    private final Runnable mSetSearchResultProvider = new Runnable() { // from class: androidx.leanback.app.SearchFragment.3
        @Override // java.lang.Runnable
        public void run() {
            ObjectAdapter objectAdapter;
            SearchFragment searchFragment = SearchFragment.this;
            if (searchFragment.mRowsFragment == null) {
                return;
            }
            ObjectAdapter resultsAdapter = searchFragment.mProvider.getResultsAdapter();
            SearchFragment searchFragment2 = SearchFragment.this;
            ObjectAdapter objectAdapter2 = searchFragment2.mResultAdapter;
            if (resultsAdapter != objectAdapter2) {
                boolean z9 = objectAdapter2 == null;
                searchFragment2.releaseAdapter();
                SearchFragment searchFragment3 = SearchFragment.this;
                searchFragment3.mResultAdapter = resultsAdapter;
                if (resultsAdapter != null) {
                    resultsAdapter.registerObserver(searchFragment3.mAdapterObserver);
                }
                if (!z9 || ((objectAdapter = SearchFragment.this.mResultAdapter) != null && objectAdapter.size() != 0)) {
                    SearchFragment searchFragment4 = SearchFragment.this;
                    searchFragment4.mRowsFragment.setAdapter(searchFragment4.mResultAdapter);
                }
                SearchFragment.this.executePendingQuery();
            }
            SearchFragment searchFragment5 = SearchFragment.this;
            if (!searchFragment5.mAutoStartRecognition) {
                searchFragment5.updateFocus();
                return;
            }
            searchFragment5.mHandler.removeCallbacks(searchFragment5.mStartRecognitionRunnable);
            SearchFragment searchFragment6 = SearchFragment.this;
            searchFragment6.mHandler.postDelayed(searchFragment6.mStartRecognitionRunnable, SearchFragment.SPEECH_RECOGNITION_DELAY_MS);
        }
    };
    final Runnable mStartRecognitionRunnable = new Runnable() { // from class: androidx.leanback.app.SearchFragment.4
        @Override // java.lang.Runnable
        public void run() {
            SearchFragment searchFragment = SearchFragment.this;
            searchFragment.mAutoStartRecognition = false;
            searchFragment.mSearchBar.startRecognition();
        }
    };
    String mPendingQuery = null;
    boolean mAutoStartRecognition = true;
    private SearchBar.SearchBarPermissionListener mPermissionListener = new SearchBar.SearchBarPermissionListener() { // from class: androidx.leanback.app.SearchFragment.5
        @Override // androidx.leanback.widget.SearchBar.SearchBarPermissionListener
        public void requestAudioPermission() {
            PermissionHelper.requestPermissions(SearchFragment.this, new String[]{"android.permission.RECORD_AUDIO"}, 0);
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ExternalQuery {
        String mQuery;
        boolean mSubmit;

        public ExternalQuery(String str, boolean z9) {
            this.mQuery = str;
            this.mSubmit = z9;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface SearchResultProvider {
        ObjectAdapter getResultsAdapter();

        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    static {
        String canonicalName = SearchFragment.class.getCanonicalName();
        ARG_QUERY = a.C(canonicalName, ".query");
        ARG_TITLE = a.C(canonicalName, ".title");
    }

    private void applyExternalQuery() {
        SearchBar searchBar;
        ExternalQuery externalQuery = this.mExternalQuery;
        if (externalQuery == null || (searchBar = this.mSearchBar) == null) {
            return;
        }
        searchBar.setSearchQuery(externalQuery.mQuery);
        ExternalQuery externalQuery2 = this.mExternalQuery;
        if (externalQuery2.mSubmit) {
            submitQuery(externalQuery2.mQuery);
        }
        this.mExternalQuery = null;
    }

    public static Bundle createArgs(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(ARG_QUERY, str);
        bundle.putString(ARG_TITLE, str2);
        return bundle;
    }

    private void focusOnResults() {
        RowsFragment rowsFragment = this.mRowsFragment;
        if (rowsFragment == null || rowsFragment.getVerticalGridView() == null || this.mResultAdapter.size() == 0 || !this.mRowsFragment.getVerticalGridView().requestFocus()) {
            return;
        }
        this.mStatus &= -2;
    }

    public static SearchFragment newInstance(String str) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.setArguments(createArgs(null, str));
        return searchFragment;
    }

    private void onSetSearchResultProvider() {
        this.mHandler.removeCallbacks(this.mSetSearchResultProvider);
        this.mHandler.post(this.mSetSearchResultProvider);
    }

    private void readArguments(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String str = ARG_QUERY;
        if (bundle.containsKey(str)) {
            setSearchQuery(bundle.getString(str));
        }
        String str2 = ARG_TITLE;
        if (bundle.containsKey(str2)) {
            setTitle(bundle.getString(str2));
        }
    }

    private void releaseRecognizer() {
        if (this.mSpeechRecognizer != null) {
            this.mSearchBar.setSpeechRecognizer(null);
            this.mSpeechRecognizer.destroy();
            this.mSpeechRecognizer = null;
        }
    }

    public void displayCompletions(List<String> list) {
        this.mSearchBar.displayCompletions(list);
    }

    public void executePendingQuery() {
        String str = this.mPendingQuery;
        if (str == null || this.mResultAdapter == null) {
            return;
        }
        this.mPendingQuery = null;
        retrieveResults(str);
    }

    public Drawable getBadgeDrawable() {
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            return searchBar.getBadgeDrawable();
        }
        return null;
    }

    public Intent getRecognizerIntent() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null && searchBar.getHint() != null) {
            intent.putExtra("android.speech.extra.PROMPT", this.mSearchBar.getHint());
        }
        intent.putExtra(EXTRA_LEANBACK_BADGE_PRESENT, this.mBadgeDrawable != null);
        return intent;
    }

    public RowsFragment getRowsFragment() {
        return this.mRowsFragment;
    }

    public String getTitle() {
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            return searchBar.getTitle();
        }
        return null;
    }

    public boolean isSpeechRecognizerAvailable() {
        return SpeechRecognizer.isRecognitionAvailable(FragmentUtil.getContext(this));
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        if (this.mAutoStartRecognition) {
            this.mAutoStartRecognition = bundle == null;
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.lb_search_fragment, viewGroup, false);
        BrowseFrameLayout browseFrameLayout = (BrowseFrameLayout) viewInflate.findViewById(R.id.lb_search_frame);
        SearchBar searchBar = (SearchBar) browseFrameLayout.findViewById(R.id.lb_search_bar);
        this.mSearchBar = searchBar;
        searchBar.setSearchBarListener(new SearchBar.SearchBarListener() { // from class: androidx.leanback.app.SearchFragment.6
            @Override // androidx.leanback.widget.SearchBar.SearchBarListener
            public void onKeyboardDismiss(String str) {
                SearchFragment.this.queryComplete();
            }

            @Override // androidx.leanback.widget.SearchBar.SearchBarListener
            public void onSearchQueryChange(String str) {
                SearchFragment searchFragment = SearchFragment.this;
                if (searchFragment.mProvider != null) {
                    searchFragment.retrieveResults(str);
                } else {
                    searchFragment.mPendingQuery = str;
                }
            }

            @Override // androidx.leanback.widget.SearchBar.SearchBarListener
            public void onSearchQuerySubmit(String str) {
                SearchFragment.this.submitQuery(str);
            }
        });
        this.mSearchBar.setSpeechRecognitionCallback(this.mSpeechRecognitionCallback);
        this.mSearchBar.setPermissionListener(this.mPermissionListener);
        applyExternalQuery();
        readArguments(getArguments());
        Drawable drawable = this.mBadgeDrawable;
        if (drawable != null) {
            setBadgeDrawable(drawable);
        }
        String str = this.mTitle;
        if (str != null) {
            setTitle(str);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i10 = R.id.lb_results_frame;
        if (childFragmentManager.findFragmentById(i10) == null) {
            this.mRowsFragment = new RowsFragment();
            getChildFragmentManager().beginTransaction().replace(i10, this.mRowsFragment).commit();
        } else {
            this.mRowsFragment = (RowsFragment) getChildFragmentManager().findFragmentById(i10);
        }
        this.mRowsFragment.setOnItemViewSelectedListener(new OnItemViewSelectedListener() { // from class: androidx.leanback.app.SearchFragment.7
            @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
            public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
                SearchFragment.this.updateSearchBarVisibility();
                OnItemViewSelectedListener onItemViewSelectedListener = SearchFragment.this.mOnItemViewSelectedListener;
                if (onItemViewSelectedListener != null) {
                    onItemViewSelectedListener.onItemSelected(viewHolder, obj, viewHolder2, row);
                }
            }
        });
        this.mRowsFragment.setOnItemViewClickedListener(this.mOnItemViewClickedListener);
        this.mRowsFragment.setExpand(true);
        if (this.mProvider != null) {
            onSetSearchResultProvider();
        }
        browseFrameLayout.setOnFocusSearchListener(new BrowseFrameLayout.OnFocusSearchListener() { // from class: androidx.leanback.app.SearchFragment.8
            @Override // androidx.leanback.widget.BrowseFrameLayout.OnFocusSearchListener
            public View onFocusSearch(View view, int i11) {
                ObjectAdapter objectAdapter;
                RowsFragment rowsFragment = SearchFragment.this.mRowsFragment;
                if (rowsFragment != null && rowsFragment.getView() != null && SearchFragment.this.mRowsFragment.getView().hasFocus()) {
                    if (i11 != 33) {
                        return null;
                    }
                    SearchFragment searchFragment = SearchFragment.this;
                    return searchFragment.mSpeechRecognizerEnabled ? searchFragment.mSearchBar.findViewById(R.id.lb_search_bar_speech_orb) : searchFragment.mSearchBar;
                }
                if (!SearchFragment.this.mSearchBar.hasFocus() || i11 != 130 || SearchFragment.this.mRowsFragment.getView() == null || (objectAdapter = SearchFragment.this.mResultAdapter) == null || objectAdapter.size() <= 0) {
                    return null;
                }
                return SearchFragment.this.mRowsFragment.getView();
            }
        });
        if (isSpeechRecognizerAvailable()) {
            this.mSpeechRecognizerEnabled = true;
            return viewInflate;
        }
        if (this.mSearchBar.hasFocus()) {
            this.mSearchBar.findViewById(R.id.lb_search_text_editor).requestFocus();
        }
        this.mSearchBar.findViewById(R.id.lb_search_bar_speech_orb).setFocusable(false);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        releaseAdapter();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.mSearchBar = null;
        this.mRowsFragment = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        releaseRecognizer();
        this.mIsPaused = true;
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (i10 == 0 && strArr.length > 0 && strArr[0].equals("android.permission.RECORD_AUDIO") && iArr[0] == 0) {
            startRecognition();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsPaused = false;
        if (this.mSpeechRecognitionCallback == null && this.mSpeechRecognizer == null && this.mSpeechRecognizerEnabled) {
            SpeechRecognizer speechRecognizerCreateSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(FragmentUtil.getContext(this));
            this.mSpeechRecognizer = speechRecognizerCreateSpeechRecognizer;
            this.mSearchBar.setSpeechRecognizer(speechRecognizerCreateSpeechRecognizer);
        }
        if (!this.mPendingStartRecognitionWhenPaused) {
            this.mSearchBar.stopRecognition();
        } else {
            this.mPendingStartRecognitionWhenPaused = false;
            this.mSearchBar.startRecognition();
        }
    }

    @Override // android.app.Fragment
    public void onStart() throws Resources.NotFoundException {
        super.onStart();
        VerticalGridView verticalGridView = this.mRowsFragment.getVerticalGridView();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.lb_search_browse_rows_align_top);
        verticalGridView.setItemAlignmentOffset(0);
        verticalGridView.setItemAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignmentOffset(dimensionPixelSize);
        verticalGridView.setWindowAlignmentOffsetPercent(-1.0f);
        verticalGridView.setWindowAlignment(0);
    }

    public void queryComplete() {
        this.mStatus |= 2;
        focusOnResults();
    }

    public void releaseAdapter() {
        ObjectAdapter objectAdapter = this.mResultAdapter;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(this.mAdapterObserver);
            this.mResultAdapter = null;
        }
    }

    public void retrieveResults(String str) {
        if (this.mProvider.onQueryTextChange(str)) {
            this.mStatus &= -3;
        }
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.mBadgeDrawable = drawable;
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setBadgeDrawable(drawable);
        }
    }

    public void setOnItemViewClickedListener(OnItemViewClickedListener onItemViewClickedListener) {
        if (onItemViewClickedListener != this.mOnItemViewClickedListener) {
            this.mOnItemViewClickedListener = onItemViewClickedListener;
            RowsFragment rowsFragment = this.mRowsFragment;
            if (rowsFragment != null) {
                rowsFragment.setOnItemViewClickedListener(onItemViewClickedListener);
            }
        }
    }

    public void setOnItemViewSelectedListener(OnItemViewSelectedListener onItemViewSelectedListener) {
        this.mOnItemViewSelectedListener = onItemViewSelectedListener;
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setSearchAffordanceColors(colors);
        }
    }

    public void setSearchAffordanceColorsInListening(SearchOrbView.Colors colors) {
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setSearchAffordanceColorsInListening(colors);
        }
    }

    public void setSearchQuery(String str, boolean z9) {
        if (str == null) {
            return;
        }
        this.mExternalQuery = new ExternalQuery(str, z9);
        applyExternalQuery();
        if (this.mAutoStartRecognition) {
            this.mAutoStartRecognition = false;
            this.mHandler.removeCallbacks(this.mStartRecognitionRunnable);
        }
    }

    public void setSearchResultProvider(SearchResultProvider searchResultProvider) {
        if (this.mProvider != searchResultProvider) {
            this.mProvider = searchResultProvider;
            onSetSearchResultProvider();
        }
    }

    @Deprecated
    public void setSpeechRecognitionCallback(SpeechRecognitionCallback speechRecognitionCallback) {
        this.mSpeechRecognitionCallback = speechRecognitionCallback;
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setSpeechRecognitionCallback(speechRecognitionCallback);
        }
        if (speechRecognitionCallback != null) {
            releaseRecognizer();
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        SearchBar searchBar = this.mSearchBar;
        if (searchBar != null) {
            searchBar.setTitle(str);
        }
    }

    public void startRecognition() {
        if (this.mIsPaused) {
            this.mPendingStartRecognitionWhenPaused = true;
        } else {
            this.mSearchBar.startRecognition();
        }
    }

    public void submitQuery(String str) {
        queryComplete();
        SearchResultProvider searchResultProvider = this.mProvider;
        if (searchResultProvider != null) {
            searchResultProvider.onQueryTextSubmit(str);
        }
    }

    public void updateFocus() {
        RowsFragment rowsFragment;
        ObjectAdapter objectAdapter = this.mResultAdapter;
        if (objectAdapter == null || objectAdapter.size() <= 0 || (rowsFragment = this.mRowsFragment) == null || rowsFragment.getAdapter() != this.mResultAdapter) {
            this.mSearchBar.requestFocus();
        } else {
            focusOnResults();
        }
    }

    public void updateSearchBarVisibility() {
        ObjectAdapter objectAdapter;
        RowsFragment rowsFragment = this.mRowsFragment;
        this.mSearchBar.setVisibility(((rowsFragment != null ? rowsFragment.getSelectedPosition() : -1) <= 0 || (objectAdapter = this.mResultAdapter) == null || objectAdapter.size() == 0) ? 0 : 8);
    }

    public void displayCompletions(CompletionInfo[] completionInfoArr) {
        this.mSearchBar.displayCompletions(completionInfoArr);
    }

    public static Bundle createArgs(Bundle bundle, String str) {
        return createArgs(bundle, str, null);
    }

    public void setSearchQuery(Intent intent, boolean z9) {
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            return;
        }
        setSearchQuery(stringArrayListExtra.get(0), z9);
    }

    private void setSearchQuery(String str) {
        this.mSearchBar.setSearchQuery(str);
    }
}
