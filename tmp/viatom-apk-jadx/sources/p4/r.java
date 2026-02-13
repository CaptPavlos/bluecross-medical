package p4;

import android.content.UriPermission;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.uptodown.R;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r implements TabLayout.OnTabSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f12013a;

    public r(FileExplorerActivity fileExplorerActivity) {
        this.f12013a = fileExplorerActivity;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab tab) {
        Uri uri;
        boolean zMatches;
        FileExplorerActivity fileExplorerActivity = this.f12013a;
        if (tab != null && tab.getId() == 0) {
            fileExplorerActivity.V = false;
            RecyclerView recyclerView = fileExplorerActivity.f6673w;
            if (recyclerView == null) {
                kotlin.jvm.internal.l.i("rvFiles");
                throw null;
            }
            recyclerView.setVisibility(0);
            LinearLayout linearLayout = fileExplorerActivity.y;
            if (linearLayout == null) {
                kotlin.jvm.internal.l.i("llPermissionExplanation");
                throw null;
            }
            linearLayout.setVisibility(8);
            RecyclerView recyclerView2 = fileExplorerActivity.f6673w;
            if (recyclerView2 == null) {
                kotlin.jvm.internal.l.i("rvFiles");
                throw null;
            }
            recyclerView2.setVisibility(0);
            fileExplorerActivity.a0();
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                fileExplorerActivity.T = externalStorageDirectory;
                fileExplorerActivity.P = null;
            }
            fileExplorerActivity.Y(true);
            return;
        }
        fileExplorerActivity.V = true;
        ArrayList arrayList = fileExplorerActivity.Q;
        arrayList.getClass();
        if (arrayList.size() > 0) {
            fileExplorerActivity.a0();
            List<UriPermission> persistedUriPermissions = fileExplorerActivity.getContentResolver().getPersistedUriPermissions();
            persistedUriPermissions.getClass();
            Iterator<UriPermission> it = persistedUriPermissions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    uri = null;
                    break;
                }
                UriPermission next = it.next();
                Uri uri2 = next.getUri();
                uri2.getClass();
                String path = uri2.getPath();
                if (path != null) {
                    Pattern patternCompile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                    patternCompile.getClass();
                    zMatches = patternCompile.matcher(path).matches();
                } else {
                    zMatches = false;
                }
                if (zMatches) {
                    uri = next.getUri();
                    break;
                }
            }
            if (uri != null) {
                fileExplorerActivity.P = DocumentFile.fromTreeUri(fileExplorerActivity, uri);
                fileExplorerActivity.T = null;
                fileExplorerActivity.Y(true);
                return;
            }
            LinearLayout linearLayout2 = fileExplorerActivity.y;
            if (linearLayout2 == null) {
                kotlin.jvm.internal.l.i("llPermissionExplanation");
                throw null;
            }
            linearLayout2.setVisibility(0);
            RecyclerView recyclerView3 = fileExplorerActivity.f6673w;
            if (recyclerView3 == null) {
                kotlin.jvm.internal.l.i("rvFiles");
                throw null;
            }
            recyclerView3.setVisibility(8);
            LinearLayout linearLayout3 = fileExplorerActivity.y;
            if (linearLayout3 == null) {
                kotlin.jvm.internal.l.i("llPermissionExplanation");
                throw null;
            }
            View viewFindViewById = linearLayout3.findViewById(R.id.tv_grant_access_sd);
            viewFindViewById.getClass();
            TextView textView = (TextView) viewFindViewById;
            textView.setTypeface(o4.b.f11720s);
            textView.setOnClickListener(new e(fileExplorerActivity, 10));
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab tab) {
    }
}
