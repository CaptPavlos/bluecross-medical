package androidx.leanback.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.leanback.widget.SearchEditText;
import androidx.leanback.widget.SearchOrbView;
import androidx.window.layout.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class SearchBar extends RelativeLayout {
    static final boolean DEBUG = false;
    static final int DEFAULT_PRIORITY = 1;
    static final float DEFAULT_RATE = 1.0f;
    static final int DO_NOT_LOOP = 0;
    static final float FULL_LEFT_VOLUME = 1.0f;
    static final float FULL_RIGHT_VOLUME = 1.0f;
    static final String TAG = "SearchBar";
    boolean mAutoStartRecognition;
    private int mBackgroundAlpha;
    private int mBackgroundSpeechAlpha;
    private Drawable mBadgeDrawable;
    private ImageView mBadgeView;
    private Drawable mBarBackground;
    private int mBarHeight;
    private final Context mContext;
    final Handler mHandler;
    private String mHint;
    private final InputMethodManager mInputMethodManager;
    private boolean mListening;
    private SearchBarPermissionListener mPermissionListener;
    boolean mRecognizing;
    SearchBarListener mSearchBarListener;
    String mSearchQuery;
    SearchEditText mSearchTextEditor;
    SparseIntArray mSoundMap;
    SoundPool mSoundPool;
    SpeechOrbView mSpeechOrbView;
    private SpeechRecognitionCallback mSpeechRecognitionCallback;
    private SpeechRecognizer mSpeechRecognizer;
    private final int mTextColor;
    private final int mTextColorSpeechMode;
    private final int mTextHintColor;
    private final int mTextHintColorSpeechMode;
    private String mTitle;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface SearchBarListener {
        void onKeyboardDismiss(String str);

        void onSearchQueryChange(String str);

        void onSearchQuerySubmit(String str);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface SearchBarPermissionListener {
        void requestAudioPermission();
    }

    public SearchBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mHandler = new Handler();
        this.mAutoStartRecognition = false;
        this.mSoundMap = new SparseIntArray();
        this.mRecognizing = false;
        this.mContext = context;
        Resources resources = getResources();
        LayoutInflater.from(getContext()).inflate(androidx.leanback.R.layout.lb_search_bar, (ViewGroup) this, true);
        this.mBarHeight = getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_bar_height);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBarHeight);
        layoutParams.addRule(10, -1);
        setLayoutParams(layoutParams);
        setBackgroundColor(0);
        setClipChildren(false);
        this.mSearchQuery = "";
        this.mInputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        this.mTextColorSpeechMode = resources.getColor(androidx.leanback.R.color.lb_search_bar_text_speech_mode);
        this.mTextColor = resources.getColor(androidx.leanback.R.color.lb_search_bar_text);
        this.mBackgroundSpeechAlpha = resources.getInteger(androidx.leanback.R.integer.lb_search_bar_speech_mode_background_alpha);
        this.mBackgroundAlpha = resources.getInteger(androidx.leanback.R.integer.lb_search_bar_text_mode_background_alpha);
        this.mTextHintColorSpeechMode = resources.getColor(androidx.leanback.R.color.lb_search_bar_hint_speech_mode);
        this.mTextHintColor = resources.getColor(androidx.leanback.R.color.lb_search_bar_hint);
    }

    private boolean isVoiceMode() {
        return this.mSpeechOrbView.isFocused();
    }

    private void loadSounds(Context context) {
        int[] iArr = {androidx.leanback.R.raw.lb_voice_failure, androidx.leanback.R.raw.lb_voice_open, androidx.leanback.R.raw.lb_voice_no_input, androidx.leanback.R.raw.lb_voice_success};
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            this.mSoundMap.put(i11, this.mSoundPool.load(context, i11, 1));
        }
    }

    private void play(final int i10) {
        this.mHandler.post(new Runnable() { // from class: androidx.leanback.widget.SearchBar.10
            @Override // java.lang.Runnable
            public void run() {
                SearchBar.this.mSoundPool.play(SearchBar.this.mSoundMap.get(i10), 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });
    }

    private void updateHint() throws Resources.NotFoundException {
        String string = getResources().getString(androidx.leanback.R.string.lb_search_bar_hint);
        if (!TextUtils.isEmpty(this.mTitle)) {
            string = isVoiceMode() ? getResources().getString(androidx.leanback.R.string.lb_search_bar_hint_with_title_speech, this.mTitle) : getResources().getString(androidx.leanback.R.string.lb_search_bar_hint_with_title, this.mTitle);
        } else if (isVoiceMode()) {
            string = getResources().getString(androidx.leanback.R.string.lb_search_bar_hint_speech);
        }
        this.mHint = string;
        SearchEditText searchEditText = this.mSearchTextEditor;
        if (searchEditText != null) {
            searchEditText.setHint(string);
        }
    }

    public void displayCompletions(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new CompletionInfo(arrayList.size(), arrayList.size(), it.next()));
            }
        }
        displayCompletions((CompletionInfo[]) arrayList.toArray(new CompletionInfo[arrayList.size()]));
    }

    public Drawable getBadgeDrawable() {
        return this.mBadgeDrawable;
    }

    public CharSequence getHint() {
        return this.mHint;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void hideNativeKeyboard() {
        this.mInputMethodManager.hideSoftInputFromWindow(this.mSearchTextEditor.getWindowToken(), 0);
    }

    public boolean isRecognizing() {
        return this.mRecognizing;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mSoundPool = new SoundPool(2, 1, 0);
        loadSounds(this.mContext);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        stopRecognition();
        this.mSoundPool.release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() throws Resources.NotFoundException {
        super.onFinishInflate();
        this.mBarBackground = ((RelativeLayout) findViewById(androidx.leanback.R.id.lb_search_bar_items)).getBackground();
        this.mSearchTextEditor = (SearchEditText) findViewById(androidx.leanback.R.id.lb_search_text_editor);
        ImageView imageView = (ImageView) findViewById(androidx.leanback.R.id.lb_search_bar_badge);
        this.mBadgeView = imageView;
        Drawable drawable = this.mBadgeDrawable;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        this.mSearchTextEditor.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.leanback.widget.SearchBar.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z9) throws Resources.NotFoundException {
                SearchBar searchBar = SearchBar.this;
                if (z9) {
                    searchBar.showNativeKeyboard();
                } else {
                    searchBar.hideNativeKeyboard();
                }
                SearchBar.this.updateUi(z9);
            }
        });
        final Runnable runnable = new Runnable() { // from class: androidx.leanback.widget.SearchBar.2
            @Override // java.lang.Runnable
            public void run() {
                SearchBar searchBar = SearchBar.this;
                searchBar.setSearchQueryInternal(searchBar.mSearchTextEditor.getText().toString());
            }
        };
        this.mSearchTextEditor.addTextChangedListener(new TextWatcher() { // from class: androidx.leanback.widget.SearchBar.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                SearchBar searchBar = SearchBar.this;
                if (searchBar.mRecognizing) {
                    return;
                }
                searchBar.mHandler.removeCallbacks(runnable);
                SearchBar.this.mHandler.post(runnable);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        this.mSearchTextEditor.setOnKeyboardDismissListener(new SearchEditText.OnKeyboardDismissListener() { // from class: androidx.leanback.widget.SearchBar.4
            @Override // androidx.leanback.widget.SearchEditText.OnKeyboardDismissListener
            public void onKeyboardDismiss() {
                SearchBar searchBar = SearchBar.this;
                SearchBarListener searchBarListener = searchBar.mSearchBarListener;
                if (searchBarListener != null) {
                    searchBarListener.onKeyboardDismiss(searchBar.mSearchQuery);
                }
            }
        });
        this.mSearchTextEditor.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: androidx.leanback.widget.SearchBar.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                if (3 == i10 || i10 == 0) {
                    SearchBar searchBar = SearchBar.this;
                    if (searchBar.mSearchBarListener != null) {
                        searchBar.hideNativeKeyboard();
                        SearchBar.this.mHandler.postDelayed(new Runnable() { // from class: androidx.leanback.widget.SearchBar.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SearchBar.this.submitQuery();
                            }
                        }, 500L);
                        return true;
                    }
                }
                if (1 == i10) {
                    SearchBar searchBar2 = SearchBar.this;
                    if (searchBar2.mSearchBarListener != null) {
                        searchBar2.hideNativeKeyboard();
                        SearchBar.this.mHandler.postDelayed(new Runnable() { // from class: androidx.leanback.widget.SearchBar.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SearchBar searchBar3 = SearchBar.this;
                                searchBar3.mSearchBarListener.onKeyboardDismiss(searchBar3.mSearchQuery);
                            }
                        }, 500L);
                        return true;
                    }
                }
                if (2 != i10) {
                    return false;
                }
                SearchBar.this.hideNativeKeyboard();
                SearchBar.this.mHandler.postDelayed(new Runnable() { // from class: androidx.leanback.widget.SearchBar.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SearchBar searchBar3 = SearchBar.this;
                        searchBar3.mAutoStartRecognition = true;
                        searchBar3.mSpeechOrbView.requestFocus();
                    }
                }, 500L);
                return true;
            }
        });
        this.mSearchTextEditor.setPrivateImeOptions("escapeNorth,voiceDismiss");
        SpeechOrbView speechOrbView = (SpeechOrbView) findViewById(androidx.leanback.R.id.lb_search_bar_speech_orb);
        this.mSpeechOrbView = speechOrbView;
        speechOrbView.setOnOrbClickedListener(new View.OnClickListener() { // from class: androidx.leanback.widget.SearchBar.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchBar.this.toggleRecognition();
            }
        });
        this.mSpeechOrbView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.leanback.widget.SearchBar.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z9) throws Resources.NotFoundException {
                SearchBar searchBar = SearchBar.this;
                if (z9) {
                    searchBar.hideNativeKeyboard();
                    SearchBar searchBar2 = SearchBar.this;
                    if (searchBar2.mAutoStartRecognition) {
                        searchBar2.startRecognition();
                        SearchBar.this.mAutoStartRecognition = false;
                    }
                } else {
                    searchBar.stopRecognition();
                }
                SearchBar.this.updateUi(z9);
            }
        });
        updateUi(hasFocus());
        updateHint();
    }

    public void playSearchFailure() {
        play(androidx.leanback.R.raw.lb_voice_failure);
    }

    public void playSearchOpen() {
        play(androidx.leanback.R.raw.lb_voice_open);
    }

    public void playSearchSuccess() {
        play(androidx.leanback.R.raw.lb_voice_success);
    }

    public void setBadgeDrawable(Drawable drawable) {
        this.mBadgeDrawable = drawable;
        ImageView imageView = this.mBadgeView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            ImageView imageView2 = this.mBadgeView;
            if (drawable != null) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setNextFocusDownId(int i10) {
        this.mSpeechOrbView.setNextFocusDownId(i10);
        this.mSearchTextEditor.setNextFocusDownId(i10);
    }

    public void setPermissionListener(SearchBarPermissionListener searchBarPermissionListener) {
        this.mPermissionListener = searchBarPermissionListener;
    }

    public void setSearchAffordanceColors(SearchOrbView.Colors colors) {
        SpeechOrbView speechOrbView = this.mSpeechOrbView;
        if (speechOrbView != null) {
            speechOrbView.setNotListeningOrbColors(colors);
        }
    }

    public void setSearchAffordanceColorsInListening(SearchOrbView.Colors colors) {
        SpeechOrbView speechOrbView = this.mSpeechOrbView;
        if (speechOrbView != null) {
            speechOrbView.setListeningOrbColors(colors);
        }
    }

    public void setSearchBarListener(SearchBarListener searchBarListener) {
        this.mSearchBarListener = searchBarListener;
    }

    public void setSearchQuery(String str) {
        stopRecognition();
        this.mSearchTextEditor.setText(str);
        setSearchQueryInternal(str);
    }

    public void setSearchQueryInternal(String str) {
        if (TextUtils.equals(this.mSearchQuery, str)) {
            return;
        }
        this.mSearchQuery = str;
        SearchBarListener searchBarListener = this.mSearchBarListener;
        if (searchBarListener != null) {
            searchBarListener.onSearchQueryChange(str);
        }
    }

    @Deprecated
    public void setSpeechRecognitionCallback(SpeechRecognitionCallback speechRecognitionCallback) {
        this.mSpeechRecognitionCallback = speechRecognitionCallback;
        if (speechRecognitionCallback == null || this.mSpeechRecognizer == null) {
            return;
        }
        c.g("Can't have speech recognizer and request");
    }

    public void setSpeechRecognizer(SpeechRecognizer speechRecognizer) {
        stopRecognition();
        SpeechRecognizer speechRecognizer2 = this.mSpeechRecognizer;
        if (speechRecognizer2 != null) {
            speechRecognizer2.setRecognitionListener(null);
            if (this.mListening) {
                this.mSpeechRecognizer.cancel();
                this.mListening = false;
            }
        }
        this.mSpeechRecognizer = speechRecognizer;
        if (this.mSpeechRecognitionCallback == null || speechRecognizer == null) {
            return;
        }
        c.g("Can't have speech recognizer and request");
    }

    public void setTitle(String str) {
        this.mTitle = str;
        updateHint();
    }

    public void showNativeKeyboard() {
        this.mHandler.post(new Runnable() { // from class: androidx.leanback.widget.SearchBar.8
            @Override // java.lang.Runnable
            public void run() {
                SearchBar.this.mSearchTextEditor.requestFocusFromTouch();
                SearchBar.this.mSearchTextEditor.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, SearchBar.this.mSearchTextEditor.getWidth(), SearchBar.this.mSearchTextEditor.getHeight(), 0));
                SearchBar.this.mSearchTextEditor.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, SearchBar.this.mSearchTextEditor.getWidth(), SearchBar.this.mSearchTextEditor.getHeight(), 0));
            }
        });
    }

    public void startRecognition() {
        if (this.mRecognizing) {
            return;
        }
        if (!hasFocus()) {
            requestFocus();
        }
        if (this.mSpeechRecognitionCallback != null) {
            this.mSearchTextEditor.setText("");
            this.mSearchTextEditor.setHint("");
            this.mSpeechRecognitionCallback.recognizeSpeech();
            this.mRecognizing = true;
            return;
        }
        if (this.mSpeechRecognizer == null) {
            return;
        }
        if (getContext().checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            SearchBarPermissionListener searchBarPermissionListener = this.mPermissionListener;
            if (searchBarPermissionListener != null) {
                searchBarPermissionListener.requestAudioPermission();
                return;
            } else {
                c.g("android.permission.RECORD_AUDIO required for search");
                return;
            }
        }
        this.mRecognizing = true;
        this.mSearchTextEditor.setText("");
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        this.mSpeechRecognizer.setRecognitionListener(new RecognitionListener() { // from class: androidx.leanback.widget.SearchBar.9
            @Override // android.speech.RecognitionListener
            public void onError(int i10) {
                switch (i10) {
                    case 1:
                        Log.w(SearchBar.TAG, "recognizer network timeout");
                        break;
                    case 2:
                        Log.w(SearchBar.TAG, "recognizer network error");
                        break;
                    case 3:
                        Log.w(SearchBar.TAG, "recognizer audio error");
                        break;
                    case 4:
                        Log.w(SearchBar.TAG, "recognizer server error");
                        break;
                    case 5:
                        Log.w(SearchBar.TAG, "recognizer client error");
                        break;
                    case 6:
                        Log.w(SearchBar.TAG, "recognizer speech timeout");
                        break;
                    case 7:
                        Log.w(SearchBar.TAG, "recognizer no match");
                        break;
                    case 8:
                        Log.w(SearchBar.TAG, "recognizer busy");
                        break;
                    case 9:
                        Log.w(SearchBar.TAG, "recognizer insufficient permissions");
                        break;
                    default:
                        Log.d(SearchBar.TAG, "recognizer other error");
                        break;
                }
                SearchBar.this.stopRecognition();
                SearchBar.this.playSearchFailure();
            }

            @Override // android.speech.RecognitionListener
            public void onPartialResults(Bundle bundle) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
                if (stringArrayList == null || stringArrayList.size() == 0) {
                    return;
                }
                SearchBar.this.mSearchTextEditor.updateRecognizedText(stringArrayList.get(0), stringArrayList.size() > 1 ? stringArrayList.get(1) : null);
            }

            @Override // android.speech.RecognitionListener
            public void onReadyForSpeech(Bundle bundle) {
                SearchBar.this.mSpeechOrbView.showListening();
                SearchBar.this.playSearchOpen();
            }

            @Override // android.speech.RecognitionListener
            public void onResults(Bundle bundle) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
                if (stringArrayList != null) {
                    SearchBar.this.mSearchQuery = stringArrayList.get(0);
                    SearchBar searchBar = SearchBar.this;
                    searchBar.mSearchTextEditor.setText(searchBar.mSearchQuery);
                    SearchBar.this.submitQuery();
                }
                SearchBar.this.stopRecognition();
                SearchBar.this.playSearchSuccess();
            }

            @Override // android.speech.RecognitionListener
            public void onRmsChanged(float f) {
                SearchBar.this.mSpeechOrbView.setSoundLevel(f < 0.0f ? 0 : (int) (f * 10.0f));
            }

            @Override // android.speech.RecognitionListener
            public void onBeginningOfSpeech() {
            }

            @Override // android.speech.RecognitionListener
            public void onEndOfSpeech() {
            }

            @Override // android.speech.RecognitionListener
            public void onBufferReceived(byte[] bArr) {
            }

            @Override // android.speech.RecognitionListener
            public void onEvent(int i10, Bundle bundle) {
            }
        });
        this.mListening = true;
        this.mSpeechRecognizer.startListening(intent);
    }

    public void stopRecognition() {
        if (this.mRecognizing) {
            this.mSearchTextEditor.setText(this.mSearchQuery);
            this.mSearchTextEditor.setHint(this.mHint);
            this.mRecognizing = false;
            if (this.mSpeechRecognitionCallback != null || this.mSpeechRecognizer == null) {
                return;
            }
            this.mSpeechOrbView.showNotListening();
            if (this.mListening) {
                this.mSpeechRecognizer.cancel();
                this.mListening = false;
            }
            this.mSpeechRecognizer.setRecognitionListener(null);
        }
    }

    public void submitQuery() {
        SearchBarListener searchBarListener;
        if (TextUtils.isEmpty(this.mSearchQuery) || (searchBarListener = this.mSearchBarListener) == null) {
            return;
        }
        searchBarListener.onSearchQuerySubmit(this.mSearchQuery);
    }

    public void toggleRecognition() {
        if (this.mRecognizing) {
            stopRecognition();
        } else {
            startRecognition();
        }
    }

    public void updateUi(boolean z9) throws Resources.NotFoundException {
        Drawable drawable = this.mBarBackground;
        if (z9) {
            drawable.setAlpha(this.mBackgroundSpeechAlpha);
            boolean zIsVoiceMode = isVoiceMode();
            SearchEditText searchEditText = this.mSearchTextEditor;
            if (zIsVoiceMode) {
                searchEditText.setTextColor(this.mTextHintColorSpeechMode);
                this.mSearchTextEditor.setHintTextColor(this.mTextHintColorSpeechMode);
            } else {
                searchEditText.setTextColor(this.mTextColorSpeechMode);
                this.mSearchTextEditor.setHintTextColor(this.mTextHintColorSpeechMode);
            }
        } else {
            drawable.setAlpha(this.mBackgroundAlpha);
            this.mSearchTextEditor.setTextColor(this.mTextColor);
            this.mSearchTextEditor.setHintTextColor(this.mTextHintColor);
        }
        updateHint();
    }

    public void displayCompletions(CompletionInfo[] completionInfoArr) {
        this.mInputMethodManager.displayCompletions(this.mSearchTextEditor, completionInfoArr);
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchBar(Context context) {
        this(context, null);
    }
}
