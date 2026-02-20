package androidx.leanback.preference;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.collection.ArraySet;
import androidx.leanback.widget.VerticalGridView;
import androidx.preference.DialogPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.internal.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class LeanbackListPreferenceDialogFragmentCompat extends LeanbackPreferenceDialogFragmentCompat {
    private static final String SAVE_STATE_ENTRIES = "LeanbackListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "LeanbackListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_INITIAL_SELECTION = "LeanbackListPreferenceDialogFragment.initialSelection";
    private static final String SAVE_STATE_INITIAL_SELECTIONS = "LeanbackListPreferenceDialogFragment.initialSelections";
    private static final String SAVE_STATE_IS_MULTI = "LeanbackListPreferenceDialogFragment.isMulti";
    private static final String SAVE_STATE_MESSAGE = "LeanbackListPreferenceDialogFragment.message";
    private static final String SAVE_STATE_TITLE = "LeanbackListPreferenceDialogFragment.title";
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private String mInitialSelection;
    Set<String> mInitialSelections;
    private boolean mMulti;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class AdapterMulti extends RecyclerView.Adapter<ViewHolder> implements OnItemClickListener {
        private final CharSequence[] mEntries;
        private final CharSequence[] mEntryValues;
        private final Set<String> mSelections;

        public AdapterMulti(CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, Set<String> set) {
            this.mEntries = charSequenceArr;
            this.mEntryValues = charSequenceArr2;
            this.mSelections = new HashSet(set);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mEntries.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i10) {
            viewHolder.getWidgetView().setChecked(this.mSelections.contains(this.mEntryValues[i10].toString()));
            viewHolder.getTitleView().setText(this.mEntries[i10]);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.leanback_list_preference_item_multi, viewGroup, false), this);
        }

        @Override // androidx.leanback.preference.LeanbackListPreferenceDialogFragmentCompat.OnItemClickListener
        public void onItemClick(ViewHolder viewHolder) {
            int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition == -1) {
                return;
            }
            String string = this.mEntryValues[absoluteAdapterPosition].toString();
            boolean zContains = this.mSelections.contains(string);
            Set<String> set = this.mSelections;
            if (zContains) {
                set.remove(string);
            } else {
                set.add(string);
            }
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) LeanbackListPreferenceDialogFragmentCompat.this.getPreference();
            if (multiSelectListPreference.callChangeListener(new HashSet(this.mSelections))) {
                multiSelectListPreference.setValues(new HashSet(this.mSelections));
                LeanbackListPreferenceDialogFragmentCompat.this.mInitialSelections = this.mSelections;
            } else {
                boolean zContains2 = this.mSelections.contains(string);
                Set<String> set2 = this.mSelections;
                if (zContains2) {
                    set2.remove(string);
                } else {
                    set2.add(string);
                }
            }
            notifyDataSetChanged();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class AdapterSingle extends RecyclerView.Adapter<ViewHolder> implements OnItemClickListener {
        private final CharSequence[] mEntries;
        private final CharSequence[] mEntryValues;
        private CharSequence mSelectedValue;

        public AdapterSingle(CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, CharSequence charSequence) {
            this.mEntries = charSequenceArr;
            this.mEntryValues = charSequenceArr2;
            this.mSelectedValue = charSequence;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mEntries.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i10) {
            viewHolder.getWidgetView().setChecked(TextUtils.equals(this.mEntryValues[i10].toString(), this.mSelectedValue));
            viewHolder.getTitleView().setText(this.mEntries[i10]);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.leanback_list_preference_item_single, viewGroup, false), this);
        }

        @Override // androidx.leanback.preference.LeanbackListPreferenceDialogFragmentCompat.OnItemClickListener
        public void onItemClick(ViewHolder viewHolder) {
            int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition == -1) {
                return;
            }
            CharSequence charSequence = this.mEntryValues[absoluteAdapterPosition];
            ListPreference listPreference = (ListPreference) LeanbackListPreferenceDialogFragmentCompat.this.getPreference();
            if (absoluteAdapterPosition >= 0) {
                String string = this.mEntryValues[absoluteAdapterPosition].toString();
                if (listPreference.callChangeListener(string)) {
                    listPreference.setValue(string);
                    this.mSelectedValue = charSequence;
                }
            }
            LeanbackListPreferenceDialogFragmentCompat.this.getFragmentManager().popBackStack();
            notifyDataSetChanged();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnItemClickListener {
        void onItemClick(ViewHolder viewHolder);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ViewGroup mContainer;
        private final OnItemClickListener mListener;
        private final TextView mTitleView;
        private final Checkable mWidgetView;

        public ViewHolder(View view, OnItemClickListener onItemClickListener) {
            super(view);
            this.mWidgetView = (Checkable) view.findViewById(R.id.button);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.container);
            this.mContainer = viewGroup;
            this.mTitleView = (TextView) view.findViewById(android.R.id.title);
            viewGroup.setOnClickListener(this);
            this.mListener = onItemClickListener;
        }

        public ViewGroup getContainer() {
            return this.mContainer;
        }

        public TextView getTitleView() {
            return this.mTitleView;
        }

        public Checkable getWidgetView() {
            return this.mWidgetView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mListener.onItemClick(this);
        }
    }

    public static LeanbackListPreferenceDialogFragmentCompat newInstanceMulti(String str) {
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        LeanbackListPreferenceDialogFragmentCompat leanbackListPreferenceDialogFragmentCompat = new LeanbackListPreferenceDialogFragmentCompat();
        leanbackListPreferenceDialogFragmentCompat.setArguments(bundle);
        return leanbackListPreferenceDialogFragmentCompat;
    }

    public static LeanbackListPreferenceDialogFragmentCompat newInstanceSingle(String str) {
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        LeanbackListPreferenceDialogFragmentCompat leanbackListPreferenceDialogFragmentCompat = new LeanbackListPreferenceDialogFragmentCompat();
        leanbackListPreferenceDialogFragmentCompat.setArguments(bundle);
        return leanbackListPreferenceDialogFragmentCompat;
    }

    @Override // androidx.leanback.preference.LeanbackPreferenceDialogFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.mDialogTitle = bundle.getCharSequence(SAVE_STATE_TITLE);
            this.mDialogMessage = bundle.getCharSequence(SAVE_STATE_MESSAGE);
            this.mMulti = bundle.getBoolean(SAVE_STATE_IS_MULTI);
            this.mEntries = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
            this.mEntryValues = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
            if (!this.mMulti) {
                this.mInitialSelection = bundle.getString(SAVE_STATE_INITIAL_SELECTION);
                return;
            }
            String[] stringArray = bundle.getStringArray(SAVE_STATE_INITIAL_SELECTIONS);
            ArraySet arraySet = new ArraySet(stringArray != null ? stringArray.length : 0);
            this.mInitialSelections = arraySet;
            if (stringArray != null) {
                Collections.addAll(arraySet, stringArray);
                return;
            }
            return;
        }
        DialogPreference preference = getPreference();
        this.mDialogTitle = preference.getDialogTitle();
        this.mDialogMessage = preference.getDialogMessage();
        if (preference instanceof ListPreference) {
            this.mMulti = false;
            ListPreference listPreference = (ListPreference) preference;
            this.mEntries = listPreference.getEntries();
            this.mEntryValues = listPreference.getEntryValues();
            this.mInitialSelection = listPreference.getValue();
            return;
        }
        if (!(preference instanceof MultiSelectListPreference)) {
            a.n("Preference must be a ListPreference or MultiSelectListPreference");
            return;
        }
        this.mMulti = true;
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) preference;
        this.mEntries = multiSelectListPreference.getEntries();
        this.mEntryValues = multiSelectListPreference.getEntryValues();
        this.mInitialSelections = multiSelectListPreference.getValues();
    }

    public RecyclerView.Adapter onCreateAdapter() {
        boolean z9 = this.mMulti;
        CharSequence[] charSequenceArr = this.mEntries;
        return z9 ? new AdapterMulti(charSequenceArr, this.mEntryValues, this.mInitialSelections) : new AdapterSingle(charSequenceArr, this.mEntryValues, this.mInitialSelection);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(androidx.preference.R.attr.preferenceTheme, typedValue, true);
        int i10 = typedValue.resourceId;
        if (i10 == 0) {
            i10 = R.style.PreferenceThemeOverlayLeanback;
        }
        View viewInflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), i10)).inflate(R.layout.leanback_list_preference_fragment, viewGroup, false);
        VerticalGridView verticalGridView = (VerticalGridView) viewInflate.findViewById(android.R.id.list);
        verticalGridView.setWindowAlignment(3);
        verticalGridView.setFocusScrollStrategy(0);
        verticalGridView.setAdapter(onCreateAdapter());
        verticalGridView.requestFocus();
        CharSequence charSequence = this.mDialogTitle;
        if (!TextUtils.isEmpty(charSequence)) {
            ((TextView) viewInflate.findViewById(R.id.decor_title)).setText(charSequence);
        }
        CharSequence charSequence2 = this.mDialogMessage;
        if (!TextUtils.isEmpty(charSequence2)) {
            TextView textView = (TextView) viewInflate.findViewById(android.R.id.message);
            textView.setVisibility(0);
            textView.setText(charSequence2);
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence(SAVE_STATE_TITLE, this.mDialogTitle);
        bundle.putCharSequence(SAVE_STATE_MESSAGE, this.mDialogMessage);
        bundle.putBoolean(SAVE_STATE_IS_MULTI, this.mMulti);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.mEntries);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.mEntryValues);
        if (!this.mMulti) {
            bundle.putString(SAVE_STATE_INITIAL_SELECTION, this.mInitialSelection);
        } else {
            Set<String> set = this.mInitialSelections;
            bundle.putStringArray(SAVE_STATE_INITIAL_SELECTIONS, (String[]) set.toArray(new String[set.size()]));
        }
    }
}
