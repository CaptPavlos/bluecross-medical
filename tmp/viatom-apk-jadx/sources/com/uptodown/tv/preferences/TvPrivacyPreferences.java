package com.uptodown.tv.preferences;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.uptodown.R;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import m4.d;
import v5.c;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TvPrivacyPreferences extends d {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a extends PreferenceFragmentCompat {
        @Override // androidx.preference.PreferenceFragmentCompat
        public final void onCreatePreferences(Bundle bundle, String str) {
            getPreferenceManager().setSharedPreferencesName("SettingsPreferences");
            addPreferencesFromResource(R.xml.tv_privacy_preferences);
            Preference preferenceFindPreference = findPreference("right_to_be_forgotten");
            preferenceFindPreference.getClass();
            final int i10 = 0;
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: p5.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TvPrivacyPreferences.a f12035b;

                {
                    this.f12035b = this;
                }

                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    switch (i10) {
                        case 0:
                            preference.getClass();
                            TvPrivacyPreferences.a aVar = this.f12035b;
                            FragmentActivity fragmentActivityRequireActivity = aVar.requireActivity();
                            fragmentActivityRequireActivity.getClass();
                            String string = aVar.getString(R.string.url_contact);
                            string.getClass();
                            c.e(fragmentActivityRequireActivity, string, null);
                            break;
                        case 1:
                            preference.getClass();
                            TvPrivacyPreferences.a aVar2 = this.f12035b;
                            Context contextRequireContext = aVar2.requireContext();
                            contextRequireContext.getClass();
                            t1.N(contextRequireContext, "gdpr_requested", true);
                            Context contextRequireContext2 = aVar2.requireContext();
                            contextRequireContext2.getClass();
                            t1.N(contextRequireContext2, "gdpr_analytics_allowed", true);
                            Context contextRequireContext3 = aVar2.requireContext();
                            contextRequireContext3.getClass();
                            t1.N(contextRequireContext3, "gdpr_crashlytics_allowed", true);
                            Context contextRequireContext4 = aVar2.requireContext();
                            contextRequireContext4.getClass();
                            t1.N(contextRequireContext4, "gdpr_tracking_allowed", true);
                            aVar2.requireActivity().finish();
                            break;
                        default:
                            preference.getClass();
                            TvPrivacyPreferences.a aVar3 = this.f12035b;
                            Context contextRequireContext5 = aVar3.requireContext();
                            contextRequireContext5.getClass();
                            t1.N(contextRequireContext5, "gdpr_requested", false);
                            Context contextRequireContext6 = aVar3.requireContext();
                            contextRequireContext6.getClass();
                            t1.N(contextRequireContext6, "gdpr_analytics_allowed", false);
                            Context contextRequireContext7 = aVar3.requireContext();
                            contextRequireContext7.getClass();
                            t1.N(contextRequireContext7, "gdpr_crashlytics_allowed", false);
                            Context contextRequireContext8 = aVar3.requireContext();
                            contextRequireContext8.getClass();
                            t1.N(contextRequireContext8, "gdpr_tracking_allowed", false);
                            aVar3.requireActivity().finish();
                            break;
                    }
                    return true;
                }
            });
            Preference preferenceFindPreference2 = findPreference("privacy_accept_all");
            preferenceFindPreference2.getClass();
            final int i11 = 1;
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: p5.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TvPrivacyPreferences.a f12035b;

                {
                    this.f12035b = this;
                }

                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    switch (i11) {
                        case 0:
                            preference.getClass();
                            TvPrivacyPreferences.a aVar = this.f12035b;
                            FragmentActivity fragmentActivityRequireActivity = aVar.requireActivity();
                            fragmentActivityRequireActivity.getClass();
                            String string = aVar.getString(R.string.url_contact);
                            string.getClass();
                            c.e(fragmentActivityRequireActivity, string, null);
                            break;
                        case 1:
                            preference.getClass();
                            TvPrivacyPreferences.a aVar2 = this.f12035b;
                            Context contextRequireContext = aVar2.requireContext();
                            contextRequireContext.getClass();
                            t1.N(contextRequireContext, "gdpr_requested", true);
                            Context contextRequireContext2 = aVar2.requireContext();
                            contextRequireContext2.getClass();
                            t1.N(contextRequireContext2, "gdpr_analytics_allowed", true);
                            Context contextRequireContext3 = aVar2.requireContext();
                            contextRequireContext3.getClass();
                            t1.N(contextRequireContext3, "gdpr_crashlytics_allowed", true);
                            Context contextRequireContext4 = aVar2.requireContext();
                            contextRequireContext4.getClass();
                            t1.N(contextRequireContext4, "gdpr_tracking_allowed", true);
                            aVar2.requireActivity().finish();
                            break;
                        default:
                            preference.getClass();
                            TvPrivacyPreferences.a aVar3 = this.f12035b;
                            Context contextRequireContext5 = aVar3.requireContext();
                            contextRequireContext5.getClass();
                            t1.N(contextRequireContext5, "gdpr_requested", false);
                            Context contextRequireContext6 = aVar3.requireContext();
                            contextRequireContext6.getClass();
                            t1.N(contextRequireContext6, "gdpr_analytics_allowed", false);
                            Context contextRequireContext7 = aVar3.requireContext();
                            contextRequireContext7.getClass();
                            t1.N(contextRequireContext7, "gdpr_crashlytics_allowed", false);
                            Context contextRequireContext8 = aVar3.requireContext();
                            contextRequireContext8.getClass();
                            t1.N(contextRequireContext8, "gdpr_tracking_allowed", false);
                            aVar3.requireActivity().finish();
                            break;
                    }
                    return true;
                }
            });
            Preference preferenceFindPreference3 = findPreference("privacy_decline_all");
            preferenceFindPreference3.getClass();
            final int i12 = 2;
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: p5.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TvPrivacyPreferences.a f12035b;

                {
                    this.f12035b = this;
                }

                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    switch (i12) {
                        case 0:
                            preference.getClass();
                            TvPrivacyPreferences.a aVar = this.f12035b;
                            FragmentActivity fragmentActivityRequireActivity = aVar.requireActivity();
                            fragmentActivityRequireActivity.getClass();
                            String string = aVar.getString(R.string.url_contact);
                            string.getClass();
                            c.e(fragmentActivityRequireActivity, string, null);
                            break;
                        case 1:
                            preference.getClass();
                            TvPrivacyPreferences.a aVar2 = this.f12035b;
                            Context contextRequireContext = aVar2.requireContext();
                            contextRequireContext.getClass();
                            t1.N(contextRequireContext, "gdpr_requested", true);
                            Context contextRequireContext2 = aVar2.requireContext();
                            contextRequireContext2.getClass();
                            t1.N(contextRequireContext2, "gdpr_analytics_allowed", true);
                            Context contextRequireContext3 = aVar2.requireContext();
                            contextRequireContext3.getClass();
                            t1.N(contextRequireContext3, "gdpr_crashlytics_allowed", true);
                            Context contextRequireContext4 = aVar2.requireContext();
                            contextRequireContext4.getClass();
                            t1.N(contextRequireContext4, "gdpr_tracking_allowed", true);
                            aVar2.requireActivity().finish();
                            break;
                        default:
                            preference.getClass();
                            TvPrivacyPreferences.a aVar3 = this.f12035b;
                            Context contextRequireContext5 = aVar3.requireContext();
                            contextRequireContext5.getClass();
                            t1.N(contextRequireContext5, "gdpr_requested", false);
                            Context contextRequireContext6 = aVar3.requireContext();
                            contextRequireContext6.getClass();
                            t1.N(contextRequireContext6, "gdpr_analytics_allowed", false);
                            Context contextRequireContext7 = aVar3.requireContext();
                            contextRequireContext7.getClass();
                            t1.N(contextRequireContext7, "gdpr_crashlytics_allowed", false);
                            Context contextRequireContext8 = aVar3.requireContext();
                            contextRequireContext8.getClass();
                            t1.N(contextRequireContext8, "gdpr_tracking_allowed", false);
                            aVar3.requireActivity().finish();
                            break;
                    }
                    return true;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new a()).commit();
    }
}
