package androidx.leanback.preference;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.preference.DialogPreference;
import androidx.preference.EditTextPreference;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class LeanbackEditTextPreferenceDialogFragmentCompat extends LeanbackPreferenceDialogFragmentCompat {
    private static final int DEFAULT_IME_OPTIONS = 2;
    private static final int DEFAULT_INPUT_TYPE = 1;
    public static final String EXTRA_IME_OPTIONS = "ime_option";
    public static final String EXTRA_INPUT_TYPE = "input_type";
    private static final String SAVE_STATE_IME_OPTIONS = "LeanbackEditPreferenceDialog.imeOptions";
    private static final String SAVE_STATE_INPUT_TYPE = "LeanbackEditPreferenceDialog.inputType";
    private static final String SAVE_STATE_MESSAGE = "LeanbackEditPreferenceDialog.message";
    private static final String SAVE_STATE_TEXT = "LeanbackEditPreferenceDialog.text";
    private static final String SAVE_STATE_TITLE = "LeanbackEditPreferenceDialog.title";
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private int mImeOptions;
    private int mInputType;
    private CharSequence mText;

    public static LeanbackEditTextPreferenceDialogFragmentCompat newInstance(String str) {
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        LeanbackEditTextPreferenceDialogFragmentCompat leanbackEditTextPreferenceDialogFragmentCompat = new LeanbackEditTextPreferenceDialogFragmentCompat();
        leanbackEditTextPreferenceDialogFragmentCompat.setArguments(bundle);
        return leanbackEditTextPreferenceDialogFragmentCompat;
    }

    @Override // androidx.leanback.preference.LeanbackPreferenceDialogFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.mDialogTitle = bundle.getCharSequence(SAVE_STATE_TITLE);
            this.mDialogMessage = bundle.getCharSequence(SAVE_STATE_MESSAGE);
            this.mText = bundle.getCharSequence(SAVE_STATE_TEXT);
            this.mInputType = bundle.getInt(SAVE_STATE_INPUT_TYPE, 1);
            this.mImeOptions = bundle.getInt(SAVE_STATE_IME_OPTIONS, 2);
            return;
        }
        DialogPreference preference = getPreference();
        this.mDialogTitle = preference.getDialogTitle();
        this.mDialogMessage = preference.getDialogMessage();
        if (!(preference instanceof EditTextPreference)) {
            a.n("Preference must be a EditTextPreference");
            return;
        }
        this.mDialogTitle = preference.getDialogTitle();
        this.mDialogMessage = preference.getDialogMessage();
        this.mText = ((EditTextPreference) preference).getText();
        this.mInputType = preference.getExtras().getInt(EXTRA_INPUT_TYPE, 1);
        this.mImeOptions = preference.getExtras().getInt(EXTRA_IME_OPTIONS, 2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(androidx.preference.R.attr.preferenceTheme, typedValue, true);
        int i10 = typedValue.resourceId;
        if (i10 == 0) {
            i10 = R.style.PreferenceThemeOverlayLeanback;
        }
        View viewInflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), i10)).inflate(R.layout.leanback_edit_preference_fragment, viewGroup, false);
        if (!TextUtils.isEmpty(this.mDialogTitle)) {
            ((TextView) viewInflate.findViewById(R.id.decor_title)).setText(this.mDialogTitle);
        }
        if (!TextUtils.isEmpty(this.mDialogMessage)) {
            TextView textView = (TextView) viewInflate.findViewById(android.R.id.message);
            textView.setVisibility(0);
            textView.setText(this.mDialogMessage);
        }
        EditText editText = (EditText) viewInflate.findViewById(android.R.id.edit);
        editText.setInputType(this.mInputType);
        editText.setImeOptions(this.mImeOptions);
        if (!TextUtils.isEmpty(this.mText)) {
            editText.setText(this.mText);
        }
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: androidx.leanback.preference.LeanbackEditTextPreferenceDialogFragmentCompat.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i11, KeyEvent keyEvent) {
                if (i11 != 6 && i11 != 2 && i11 != 3 && i11 != 5 && i11 != 4) {
                    return false;
                }
                ((InputMethodManager) LeanbackEditTextPreferenceDialogFragmentCompat.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(textView2.getWindowToken(), 0);
                ((EditTextPreference) LeanbackEditTextPreferenceDialogFragmentCompat.this.getPreference()).setText(textView2.getText().toString());
                LeanbackEditTextPreferenceDialogFragmentCompat.this.getFragmentManager().popBackStack();
                return true;
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence(SAVE_STATE_TITLE, this.mDialogTitle);
        bundle.putCharSequence(SAVE_STATE_MESSAGE, this.mDialogMessage);
        bundle.putCharSequence(SAVE_STATE_TEXT, this.mText);
        bundle.putInt(SAVE_STATE_INPUT_TYPE, this.mInputType);
        bundle.putInt(SAVE_STATE_IME_OPTIONS, this.mImeOptions);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        EditText editText = (EditText) getView().findViewById(android.R.id.edit);
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        editText.requestFocus();
        inputMethodManager.showSoftInput(editText, 0);
    }
}
