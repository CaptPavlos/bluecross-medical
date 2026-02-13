package i5;

import a3.o;
import a6.j;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import e5.v;
import h0.m;
import h5.q;
import java.io.File;
import l4.o3;
import l4.u4;
import l4.w;
import r7.i0;
import r7.y;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends ResultReceiver {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Bundle, java.lang.Object, w6.c] */
    /* JADX WARN: Type inference failed for: r2v21 */
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i10, Bundle bundle) {
        q qVar;
        File fileG;
        if (bundle != null) {
            qVar = (q) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) bundle.getParcelable("download", q.class) : bundle.getParcelable("download"));
        } else {
            qVar = null;
        }
        Activity activity = o4.b.g;
        if (activity != null) {
            if (i10 != 202) {
                if (i10 == 209 && (activity instanceof w)) {
                    w wVar = (w) activity;
                    wVar.runOnUiThread(new a4.a(wVar, 18));
                }
            } else if (qVar != null && (activity instanceof r5.b) && !(activity instanceof TvAppDetailActivity)) {
                r5.b bVar = (r5.b) activity;
                bVar.runOnUiThread(new r5.a(0, bVar, qVar));
            }
            if (activity instanceof OldVersionsActivity) {
                int i11 = 5;
                if ((qVar != null ? Long.valueOf(qVar.e) : null) != null) {
                    OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) activity;
                    oldVersionsActivity.runOnUiThread(new v(i10, oldVersionsActivity, i11, qVar));
                }
                if (i10 == 202 && qVar != null && qVar.g() != null) {
                    OldVersionsActivity oldVersionsActivity2 = (OldVersionsActivity) activity;
                    oldVersionsActivity2.runOnUiThread(new k1.a(oldVersionsActivity2, qVar, 28, false));
                }
                if (i10 == 208) {
                    OldVersionsActivity oldVersionsActivity3 = (OldVersionsActivity) activity;
                    oldVersionsActivity3.runOnUiThread(new v(i10, oldVersionsActivity3, i11, (Object) obj));
                    return;
                }
                return;
            }
            w6.c cVar = null;
            if ((activity instanceof w) && r0.f.A() == null && i10 == 202 && qVar != null && qVar.c() && (fileG = qVar.g()) != null) {
                int i12 = w.G;
                ((w) activity).U(fileG, null);
            }
            int i13 = 2;
            if (activity instanceof MainActivity) {
                if (qVar != null) {
                    MainActivity mainActivity = (MainActivity) activity;
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(mainActivity);
                    y7.e eVar = i0.f12407a;
                    y.q(lifecycleScope, n.f13548a, null, new o(i10, mainActivity, qVar, (w6.c) null), 2);
                    return;
                }
                return;
            }
            if (activity instanceof MyDownloads) {
                MyDownloads myDownloads = (MyDownloads) activity;
                LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(myDownloads);
                y7.e eVar2 = i0.f12407a;
                y.q(lifecycleScope2, n.f13548a, null, new o(myDownloads, i10, qVar, (w6.c) null), 2);
                return;
            }
            if (activity instanceof Updates) {
                Updates updates = (Updates) activity;
                String str = qVar != null ? qVar.f8701b : null;
                LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(updates);
                y7.e eVar3 = i0.f12407a;
                y.q(lifecycleScope3, n.f13548a, null, new o3(i10, obj, updates, str, null, 1), 2);
                return;
            }
            if (activity instanceof MyApps) {
                MyApps myApps = (MyApps) activity;
                String str2 = qVar != null ? qVar.f8701b : null;
                LifecycleCoroutineScope lifecycleScope4 = LifecycleOwnerKt.getLifecycleScope(myApps);
                y7.e eVar4 = i0.f12407a;
                y.q(lifecycleScope4, n.f13548a, null, new o3(i10, obj, myApps, str2, null, 0), 2);
                return;
            }
            int i14 = 3;
            if (activity instanceof AppDetailActivity) {
                String string = bundle != null ? bundle.getString("packagename") : null;
                if (string != null && string.length() != 0) {
                    AppDetailActivity appDetailActivity = (AppDetailActivity) activity;
                    appDetailActivity.runOnUiThread(new v(i10, appDetailActivity, i14, string));
                }
                AppDetailActivity appDetailActivity2 = (AppDetailActivity) activity;
                appDetailActivity2.runOnUiThread(new v(i10, appDetailActivity2, 4, qVar));
                return;
            }
            if (activity instanceof TvAppDetailActivity) {
                TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) activity;
                tvAppDetailActivity.runOnUiThread(new v(i10, tvAppDetailActivity, 8, qVar));
                return;
            }
            if (activity instanceof TvOldVersionsActivity) {
                TvOldVersionsActivity tvOldVersionsActivity = (TvOldVersionsActivity) activity;
                tvOldVersionsActivity.runOnUiThread(new m(tvOldVersionsActivity, i10, i14));
                return;
            }
            if (activity instanceof TvMyDownloadsActivity) {
                TvMyDownloadsActivity tvMyDownloadsActivity = (TvMyDownloadsActivity) activity;
                tvMyDownloadsActivity.runOnUiThread(new m(tvMyDownloadsActivity, i10, i13));
                return;
            }
            if (activity instanceof WishlistActivity) {
                ((WishlistActivity) activity).D0(qVar != null ? qVar.f8701b : null);
                return;
            }
            if (activity instanceof RecommendedActivity) {
                ((RecommendedActivity) activity).D0(qVar != null ? qVar.f8701b : null);
                return;
            }
            if (activity instanceof PublicListActivity) {
                ((PublicListActivity) activity).D0(qVar != null ? qVar.f8701b : null);
                return;
            }
            if (activity instanceof MoreInfo) {
                MoreInfo moreInfo = (MoreInfo) activity;
                moreInfo.runOnUiThread(new k1.a(moreInfo, qVar, 27, false));
                return;
            }
            if (activity instanceof OrganizationActivity) {
                OrganizationActivity organizationActivity = (OrganizationActivity) activity;
                LifecycleCoroutineScope lifecycleScope5 = LifecycleOwnerKt.getLifecycleScope(organizationActivity);
                y7.e eVar5 = i0.f12407a;
                y.q(lifecycleScope5, n.f13548a, null, new u4(qVar, organizationActivity, obj, i14), 2);
                return;
            }
            if (activity instanceof SearchActivity) {
                ((SearchActivity) activity).r0(qVar != null ? qVar.f8701b : null);
                return;
            }
            if (activity instanceof ListsActivity) {
                ListsActivity listsActivity = (ListsActivity) activity;
                obj = qVar != null ? qVar.f8701b : 0;
                LifecycleCoroutineScope lifecycleScope6 = LifecycleOwnerKt.getLifecycleScope(listsActivity);
                y7.e eVar6 = i0.f12407a;
                y.q(lifecycleScope6, n.f13548a, null, new j(listsActivity, obj, cVar, 24), 2);
            }
        }
    }
}
