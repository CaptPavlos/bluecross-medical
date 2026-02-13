package s5;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import com.google.android.gms.internal.measurement.l5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u extends RowsSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayObjectAdapter f12673a;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityResultLauncher f12674b;

    public u() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(4);
        listRowPresenter.setShadowEnabled(false);
        this.f12673a = new ArrayObjectAdapter(listRowPresenter);
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new t(this));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f12674b = activityResultLauncherRegisterForActivityResult;
    }

    public final void a(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(R.string.ok, new r5.c(7));
        builder.setCancelable(true);
        AlertDialog alertDialogCreate = builder.create();
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        String str;
        BrowseSupportFragment.FragmentHost fragmentHost;
        super.onCreate(bundle);
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(getString(com.uptodown.R.string.manage_apps));
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            int size = l5.z(contextRequireContext).size();
            if (size > 0) {
                str = " (" + size + ')';
            } else {
                str = "";
            }
            q5.l lVar = new q5.l();
            lVar.f12268a = -1;
            lVar.f12269b = -1;
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(lVar);
            o5.b bVar = new o5.b();
            bVar.f11731a = 0;
            bVar.f11732b = getString(com.uptodown.R.string.updates) + str;
            bVar.f11733c = com.uptodown.R.drawable.vector_tv_updates;
            arrayObjectAdapter.add(bVar);
            o5.b bVar2 = new o5.b();
            bVar2.f11731a = 1;
            bVar2.f11732b = getString(com.uptodown.R.string.installed);
            bVar2.f11733c = com.uptodown.R.drawable.vector_tv_installed;
            arrayObjectAdapter.add(bVar2);
            o5.b bVar3 = new o5.b();
            bVar3.f11731a = 2;
            bVar3.f11732b = getString(com.uptodown.R.string.rollback_title);
            bVar3.f11733c = com.uptodown.R.drawable.vector_tv_rollback;
            arrayObjectAdapter.add(bVar3);
            o5.b bVar4 = new o5.b();
            bVar4.f11731a = 3;
            bVar4.f11732b = getString(com.uptodown.R.string.downloads_title);
            bVar4.f11733c = com.uptodown.R.drawable.vector_tv_downloads;
            arrayObjectAdapter.add(bVar4);
            o5.b bVar5 = new o5.b();
            bVar5.f11731a = 4;
            bVar5.f11732b = getString(com.uptodown.R.string.settings);
            bVar5.f11733c = com.uptodown.R.drawable.vector_tv_settings;
            arrayObjectAdapter.add(bVar5);
            ListRow listRow = new ListRow(headerItem, arrayObjectAdapter);
            ArrayObjectAdapter arrayObjectAdapter2 = this.f12673a;
            arrayObjectAdapter2.add(listRow);
            setAdapter(arrayObjectAdapter2);
            BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter = getMainFragmentAdapter();
            if (mainFragmentAdapter == null || (fragmentHost = mainFragmentAdapter.getFragmentHost()) == null) {
                return;
            }
            fragmentHost.notifyDataReady(getMainFragmentAdapter());
        }
    }

    @Override // androidx.leanback.app.RowsSupportFragment, androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new t(this));
    }
}
