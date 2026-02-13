package androidx.leanback.preference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes.dex */
public abstract class LeanbackPreferenceFragment extends BaseLeanbackPreferenceFragment {
    public LeanbackPreferenceFragment() {
        LeanbackPreferenceFragmentTransitionHelperApi21.addTransitions(this);
    }

    @Override // androidx.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = LayoutInflater.from(viewOnCreateView.getContext()).inflate(R.layout.leanback_preference_fragment, viewGroup, false);
        ((ViewGroup) viewInflate.findViewById(R.id.main_frame)).addView(viewOnCreateView);
        return viewInflate;
    }

    @Override // androidx.preference.PreferenceFragment, android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setTitle(getPreferenceScreen().getTitle());
    }

    public void setTitle(CharSequence charSequence) {
        View view = getView();
        TextView textView = view == null ? null : (TextView) view.findViewById(R.id.decor_title);
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
