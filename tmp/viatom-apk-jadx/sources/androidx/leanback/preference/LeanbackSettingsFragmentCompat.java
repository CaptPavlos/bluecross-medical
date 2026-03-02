package androidx.leanback.preference;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class LeanbackSettingsFragmentCompat extends Fragment implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback, PreferenceFragmentCompat.OnPreferenceStartScreenCallback, PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback {
    private static final String PREFERENCE_FRAGMENT_TAG = "androidx.leanback.preference.LeanbackSettingsFragment.PREFERENCE_FRAGMENT";
    private final RootViewOnKeyListener mRootViewOnKeyListener = new RootViewOnKeyListener();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class RootViewOnKeyListener implements View.OnKeyListener {
        public RootViewOnKeyListener() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                return LeanbackSettingsFragmentCompat.this.getChildFragmentManager().popBackStackImmediate();
            }
            return false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.leanback_settings_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LeanbackSettingsRootView leanbackSettingsRootView = (LeanbackSettingsRootView) getView();
        if (leanbackSettingsRootView != null) {
            leanbackSettingsRootView.setOnBackKeyListener(null);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceDisplayDialogCallback
    public boolean onPreferenceDisplayDialog(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference) {
        if (preferenceFragmentCompat == null) {
            a.j(preference, "Cannot display dialog for preference ", ", Caller must not be null!");
            return false;
        }
        if (preference instanceof ListPreference) {
            LeanbackListPreferenceDialogFragmentCompat leanbackListPreferenceDialogFragmentCompatNewInstanceSingle = LeanbackListPreferenceDialogFragmentCompat.newInstanceSingle(((ListPreference) preference).getKey());
            leanbackListPreferenceDialogFragmentCompatNewInstanceSingle.setTargetFragment(preferenceFragmentCompat, 0);
            startPreferenceFragment(leanbackListPreferenceDialogFragmentCompatNewInstanceSingle);
            return true;
        }
        if (preference instanceof MultiSelectListPreference) {
            LeanbackListPreferenceDialogFragmentCompat leanbackListPreferenceDialogFragmentCompatNewInstanceMulti = LeanbackListPreferenceDialogFragmentCompat.newInstanceMulti(((MultiSelectListPreference) preference).getKey());
            leanbackListPreferenceDialogFragmentCompatNewInstanceMulti.setTargetFragment(preferenceFragmentCompat, 0);
            startPreferenceFragment(leanbackListPreferenceDialogFragmentCompatNewInstanceMulti);
            return true;
        }
        if (!(preference instanceof EditTextPreference)) {
            return false;
        }
        LeanbackEditTextPreferenceDialogFragmentCompat leanbackEditTextPreferenceDialogFragmentCompatNewInstance = LeanbackEditTextPreferenceDialogFragmentCompat.newInstance(preference.getKey());
        leanbackEditTextPreferenceDialogFragmentCompatNewInstance.setTargetFragment(preferenceFragmentCompat, 0);
        startPreferenceFragment(leanbackEditTextPreferenceDialogFragmentCompatNewInstance);
        return true;
    }

    public abstract void onPreferenceStartInitialScreen();

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LeanbackSettingsRootView leanbackSettingsRootView = (LeanbackSettingsRootView) getView();
        if (leanbackSettingsRootView != null) {
            leanbackSettingsRootView.setOnBackKeyListener(this.mRootViewOnKeyListener);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            onPreferenceStartInitialScreen();
        }
    }

    public void startImmersiveFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(PREFERENCE_FRAGMENT_TAG);
        if (fragmentFindFragmentByTag != null && !fragmentFindFragmentByTag.isHidden()) {
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
        }
        fragmentTransactionBeginTransaction.add(R.id.settings_dialog_container, fragment).addToBackStack(null).commit();
    }

    public void startPreferenceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        if (getChildFragmentManager().findFragmentByTag(PREFERENCE_FRAGMENT_TAG) != null) {
            fragmentTransactionBeginTransaction.addToBackStack(null).replace(R.id.settings_preference_fragment_container, fragment, PREFERENCE_FRAGMENT_TAG);
        } else {
            fragmentTransactionBeginTransaction.add(R.id.settings_preference_fragment_container, fragment, PREFERENCE_FRAGMENT_TAG);
        }
        fragmentTransactionBeginTransaction.commit();
    }
}
