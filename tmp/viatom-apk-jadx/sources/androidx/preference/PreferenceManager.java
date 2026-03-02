package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class PreferenceManager {
    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
    private static final int STORAGE_DEFAULT = 0;
    private static final int STORAGE_DEVICE_PROTECTED = 1;
    private final Context mContext;

    @Nullable
    private SharedPreferences.Editor mEditor;
    private boolean mNoCommit;
    private OnDisplayPreferenceDialogListener mOnDisplayPreferenceDialogListener;
    private OnNavigateToScreenListener mOnNavigateToScreenListener;
    private OnPreferenceTreeClickListener mOnPreferenceTreeClickListener;
    private PreferenceComparisonCallback mPreferenceComparisonCallback;

    @Nullable
    private PreferenceDataStore mPreferenceDataStore;
    private PreferenceScreen mPreferenceScreen;

    @Nullable
    private SharedPreferences mSharedPreferences;
    private int mSharedPreferencesMode;
    private String mSharedPreferencesName;
    private long mNextId = 0;
    private int mStorage = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnDisplayPreferenceDialogListener {
        void onDisplayPreferenceDialog(@NonNull Preference preference);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnNavigateToScreenListener {
        void onNavigateToScreen(@NonNull PreferenceScreen preferenceScreen);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnPreferenceTreeClickListener {
        boolean onPreferenceTreeClick(@NonNull Preference preference);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class PreferenceComparisonCallback {
        public abstract boolean arePreferenceContentsTheSame(@NonNull Preference preference, @NonNull Preference preference2);

        public abstract boolean arePreferenceItemsTheSame(@NonNull Preference preference, @NonNull Preference preference2);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class SimplePreferenceComparisonCallback extends PreferenceComparisonCallback {
        @Override // androidx.preference.PreferenceManager.PreferenceComparisonCallback
        public boolean arePreferenceContentsTheSame(@NonNull Preference preference, @NonNull Preference preference2) {
            if (preference.getClass() != preference2.getClass()) {
                return false;
            }
            if ((preference == preference2 && preference.wasDetached()) || !TextUtils.equals(preference.getTitle(), preference2.getTitle()) || !TextUtils.equals(preference.getSummary(), preference2.getSummary())) {
                return false;
            }
            Drawable icon = preference.getIcon();
            Drawable icon2 = preference2.getIcon();
            if ((icon != icon2 && (icon == null || !icon.equals(icon2))) || preference.isEnabled() != preference2.isEnabled() || preference.isSelectable() != preference2.isSelectable()) {
                return false;
            }
            if (!(preference instanceof TwoStatePreference) || ((TwoStatePreference) preference).isChecked() == ((TwoStatePreference) preference2).isChecked()) {
                return !(preference instanceof DropDownPreference) || preference == preference2;
            }
            return false;
        }

        @Override // androidx.preference.PreferenceManager.PreferenceComparisonCallback
        public boolean arePreferenceItemsTheSame(@NonNull Preference preference, @NonNull Preference preference2) {
            return preference.getId() == preference2.getId();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PreferenceManager(@NonNull Context context) {
        this.mContext = context;
        setSharedPreferencesName(getDefaultSharedPreferencesName(context));
    }

    public static SharedPreferences getDefaultSharedPreferences(@NonNull Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode());
    }

    private static int getDefaultSharedPreferencesMode() {
        return 0;
    }

    private static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public static void setDefaultValues(@NonNull Context context, String str, int i10, int i11, boolean z9) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_HAS_SET_DEFAULT_VALUES, 0);
        if (z9 || !sharedPreferences.getBoolean(KEY_HAS_SET_DEFAULT_VALUES, false)) {
            PreferenceManager preferenceManager = new PreferenceManager(context);
            preferenceManager.setSharedPreferencesName(str);
            preferenceManager.setSharedPreferencesMode(i10);
            preferenceManager.inflateFromResource(context, i11, null);
            sharedPreferences.edit().putBoolean(KEY_HAS_SET_DEFAULT_VALUES, true).apply();
        }
    }

    private void setNoCommit(boolean z9) {
        SharedPreferences.Editor editor;
        if (!z9 && (editor = this.mEditor) != null) {
            editor.apply();
        }
        this.mNoCommit = z9;
    }

    @NonNull
    public PreferenceScreen createPreferenceScreen(@NonNull Context context) {
        PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        preferenceScreen.onAttachedToHierarchy(this);
        return preferenceScreen;
    }

    @Nullable
    public <T extends Preference> T findPreference(@NonNull CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.mPreferenceScreen;
        if (preferenceScreen == null) {
            return null;
        }
        return (T) preferenceScreen.findPreference(charSequence);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public SharedPreferences.Editor getEditor() {
        if (this.mPreferenceDataStore != null) {
            return null;
        }
        if (!this.mNoCommit) {
            return getSharedPreferences().edit();
        }
        if (this.mEditor == null) {
            this.mEditor = getSharedPreferences().edit();
        }
        return this.mEditor;
    }

    public long getNextId() {
        long j10;
        synchronized (this) {
            j10 = this.mNextId;
            this.mNextId = 1 + j10;
        }
        return j10;
    }

    @Nullable
    public OnDisplayPreferenceDialogListener getOnDisplayPreferenceDialogListener() {
        return this.mOnDisplayPreferenceDialogListener;
    }

    @Nullable
    public OnNavigateToScreenListener getOnNavigateToScreenListener() {
        return this.mOnNavigateToScreenListener;
    }

    @Nullable
    public OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        return this.mOnPreferenceTreeClickListener;
    }

    @Nullable
    public PreferenceComparisonCallback getPreferenceComparisonCallback() {
        return this.mPreferenceComparisonCallback;
    }

    @Nullable
    public PreferenceDataStore getPreferenceDataStore() {
        return this.mPreferenceDataStore;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceScreen;
    }

    @Nullable
    public SharedPreferences getSharedPreferences() {
        if (getPreferenceDataStore() != null) {
            return null;
        }
        if (this.mSharedPreferences == null) {
            int i10 = this.mStorage;
            Context contextCreateDeviceProtectedStorageContext = this.mContext;
            if (i10 == 1) {
                contextCreateDeviceProtectedStorageContext = ContextCompat.createDeviceProtectedStorageContext(contextCreateDeviceProtectedStorageContext);
            }
            this.mSharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences(this.mSharedPreferencesName, this.mSharedPreferencesMode);
        }
        return this.mSharedPreferences;
    }

    public int getSharedPreferencesMode() {
        return this.mSharedPreferencesMode;
    }

    public String getSharedPreferencesName() {
        return this.mSharedPreferencesName;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PreferenceScreen inflateFromResource(@NonNull Context context, int i10, @Nullable PreferenceScreen preferenceScreen) {
        setNoCommit(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new PreferenceInflater(context, this).inflate(i10, preferenceScreen);
        preferenceScreen2.onAttachedToHierarchy(this);
        setNoCommit(false);
        return preferenceScreen2;
    }

    public boolean isStorageDefault() {
        return Build.VERSION.SDK_INT < 24 || this.mStorage == 0;
    }

    public boolean isStorageDeviceProtected() {
        return Build.VERSION.SDK_INT >= 24 && this.mStorage == 1;
    }

    public void setOnDisplayPreferenceDialogListener(@Nullable OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener) {
        this.mOnDisplayPreferenceDialogListener = onDisplayPreferenceDialogListener;
    }

    public void setOnNavigateToScreenListener(@Nullable OnNavigateToScreenListener onNavigateToScreenListener) {
        this.mOnNavigateToScreenListener = onNavigateToScreenListener;
    }

    public void setOnPreferenceTreeClickListener(@Nullable OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        this.mOnPreferenceTreeClickListener = onPreferenceTreeClickListener;
    }

    public void setPreferenceComparisonCallback(@Nullable PreferenceComparisonCallback preferenceComparisonCallback) {
        this.mPreferenceComparisonCallback = preferenceComparisonCallback;
    }

    public void setPreferenceDataStore(@Nullable PreferenceDataStore preferenceDataStore) {
        this.mPreferenceDataStore = preferenceDataStore;
    }

    public boolean setPreferences(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.mPreferenceScreen;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.onDetached();
        }
        this.mPreferenceScreen = preferenceScreen;
        return true;
    }

    public void setSharedPreferencesMode(int i10) {
        this.mSharedPreferencesMode = i10;
        this.mSharedPreferences = null;
    }

    public void setSharedPreferencesName(String str) {
        this.mSharedPreferencesName = str;
        this.mSharedPreferences = null;
    }

    public void setStorageDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mStorage = 0;
            this.mSharedPreferences = null;
        }
    }

    public void setStorageDeviceProtected() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mStorage = 1;
            this.mSharedPreferences = null;
        }
    }

    public boolean shouldCommit() {
        return !this.mNoCommit;
    }

    public void showDialog(@NonNull Preference preference) {
        OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener = this.mOnDisplayPreferenceDialogListener;
        if (onDisplayPreferenceDialogListener != null) {
            onDisplayPreferenceDialogListener.onDisplayPreferenceDialog(preference);
        }
    }

    public static void setDefaultValues(@NonNull Context context, int i10, boolean z9) {
        setDefaultValues(context, getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode(), i10, z9);
    }
}
