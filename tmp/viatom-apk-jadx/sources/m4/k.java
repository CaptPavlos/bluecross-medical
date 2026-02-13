package m4;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import com.uptodown.tv.ui.activity.TvMainActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11210a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11211b;

    public /* synthetic */ k(Object obj, int i10) {
        this.f11210a = i10;
        this.f11211b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        int i11 = this.f11210a;
        Object obj = this.f11211b;
        switch (i11) {
            case 0:
                PreferencesActivity preferencesActivity = (PreferencesActivity) obj;
                int i12 = PreferencesActivity.M;
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", preferencesActivity.getPackageName());
                if (intent.resolveActivity(preferencesActivity.getPackageManager()) != null) {
                    preferencesActivity.startActivityForResult(intent, 646);
                }
                dialogInterface.dismiss();
                break;
            case 1:
                TvMainActivity tvMainActivity = (TvMainActivity) obj;
                int i13 = TvMainActivity.f;
                dialogInterface.dismiss();
                tvMainActivity.e.launch(new Intent(tvMainActivity, (Class<?>) TvPrivacyPreferences.class));
                break;
            case 2:
                TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) obj;
                dialogInterface.dismiss();
                tvAppDetailFragment.startActivity(new Intent(tvAppDetailFragment.requireActivity(), (Class<?>) TvPrivacyPreferences.class));
                break;
            default:
                Activity activity = (Activity) obj;
                dialogInterface.dismiss();
                if (!(activity instanceof AppDetailActivity)) {
                    if (!(activity instanceof MainActivity)) {
                        activity.startActivity(new Intent(activity, (Class<?>) GdprPrivacySettings.class));
                        break;
                    } else {
                        ((MainActivity) activity).f6651v0.launch(new Intent(activity, (Class<?>) GdprPrivacySettings.class));
                        break;
                    }
                } else {
                    ((AppDetailActivity) activity).L.launch(new Intent(activity, (Class<?>) GdprPrivacySettings.class));
                    break;
                }
        }
    }
}
