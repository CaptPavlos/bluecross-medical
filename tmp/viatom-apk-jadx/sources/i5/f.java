package i5;

import a3.o;
import a6.j;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import e5.j0;
import e5.v;
import h0.m;
import l4.d9;
import l4.j2;
import l4.k2;
import l4.m9;
import l4.n2;
import l4.o3;
import l4.w;
import r7.i0;
import r7.y;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9025a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i10, Handler handler) {
        super(handler);
        this.f9025a = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [w6.c] */
    /* JADX WARN: Type inference failed for: r10v16 */
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i10, Bundle bundle) {
        j0 j0VarN0;
        int i11 = 3;
        int i12 = 0;
        int i13 = 2;
        int i14 = 1;
        switch (this.f9025a) {
            case 0:
                Activity activity = o4.b.g;
                if (activity != null) {
                    String string = bundle != null ? bundle.getString("packagename") : null;
                    if (!(activity instanceof Updates)) {
                        if (!(activity instanceof MyApps)) {
                            if (!(activity instanceof AppInstalledDetailsActivity)) {
                                if (!(activity instanceof MainActivity)) {
                                    if (!(activity instanceof AppDetailActivity)) {
                                        if (!(activity instanceof WishlistActivity)) {
                                            if (!(activity instanceof RecommendedActivity)) {
                                                if (!(activity instanceof PublicListActivity)) {
                                                    if (!(activity instanceof SearchActivity)) {
                                                        if (activity instanceof ListsActivity) {
                                                            ListsActivity listsActivity = (ListsActivity) activity;
                                                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(listsActivity);
                                                            y7.e eVar = i0.f12407a;
                                                            y.q(lifecycleScope, n.f13548a, null, new j(listsActivity, string, (w6.c) str, 24), 2);
                                                            break;
                                                        }
                                                    } else {
                                                        ((SearchActivity) activity).r0(string);
                                                        break;
                                                    }
                                                } else {
                                                    ((PublicListActivity) activity).D0(bundle != null ? bundle.getString("packagename") : 0);
                                                    break;
                                                }
                                            } else {
                                                ((RecommendedActivity) activity).D0(bundle != null ? bundle.getString("packagename") : null);
                                                break;
                                            }
                                        } else {
                                            ((WishlistActivity) activity).D0(bundle != null ? bundle.getString("packagename") : null);
                                            break;
                                        }
                                    } else {
                                        AppDetailActivity appDetailActivity = (AppDetailActivity) activity;
                                        appDetailActivity.runOnUiThread(new v(i10, appDetailActivity, i11, bundle != null ? bundle.getString("packagename") : null));
                                        break;
                                    }
                                } else {
                                    if (i10 == 103) {
                                        ((MainActivity) activity).c1();
                                    }
                                    String string2 = bundle != null ? bundle.getString("packagename") : null;
                                    MainActivity mainActivity = (MainActivity) activity;
                                    mainActivity.runOnUiThread(new k2(mainActivity, i10, string2, i14));
                                    mainActivity.e1(string2);
                                    break;
                                }
                            } else if (i10 != 105 && i10 != 110) {
                                String string3 = bundle != null ? bundle.getString("packagename") : null;
                                y7.e eVar2 = i0.f12407a;
                                y.q(y.a(n.f13548a), null, null, new e((AppInstalledDetailsActivity) activity, i10, string3, str, 0), 3);
                                break;
                            } else {
                                ((AppInstalledDetailsActivity) activity).runOnUiThread(new a4.a((w) activity, 18));
                                break;
                            }
                        } else {
                            MyApps myApps = (MyApps) activity;
                            LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(myApps);
                            y7.e eVar3 = i0.f12407a;
                            y.q(lifecycleScope2, n.f13548a, null, new o3(i10, bundle, myApps, string, null, 0), 2);
                            break;
                        }
                    } else {
                        Updates updates = (Updates) activity;
                        LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(updates);
                        y7.e eVar4 = i0.f12407a;
                        y.q(lifecycleScope3, n.f13548a, null, new o3(i10, bundle, updates, string, null, 1), 2);
                        break;
                    }
                }
                break;
            case 1:
                bundle.getClass();
                String string4 = bundle.getString("packageName");
                Activity activity2 = o4.b.g;
                if (activity2 != null) {
                    w6.c cVar = null;
                    if (!(activity2 instanceof Updates)) {
                        if (!(activity2 instanceof MyApps)) {
                            if (!(activity2 instanceof AppDetailActivity)) {
                                if (!(activity2 instanceof MyDownloads)) {
                                    if (!(activity2 instanceof OldVersionsActivity)) {
                                        if (!(activity2 instanceof InstallerActivity)) {
                                            if (!(activity2 instanceof TvAppDetailActivity)) {
                                                if ((activity2 instanceof MainActivity) && string4 != null) {
                                                    MainActivity mainActivity2 = (MainActivity) activity2;
                                                    mainActivity2.runOnUiThread(new k2(mainActivity2, i10, string4, i12));
                                                    break;
                                                }
                                            } else if (string4 != null) {
                                                TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) activity2;
                                                tvAppDetailActivity.runOnUiThread(new v(i10, 7, tvAppDetailActivity, string4));
                                                break;
                                            }
                                        } else if (i10 != 351) {
                                            ((InstallerActivity) activity2).finish();
                                            break;
                                        } else {
                                            InstallerActivity installerActivity = (InstallerActivity) activity2;
                                            installerActivity.runOnUiThread(new p4.y(installerActivity, i12));
                                            break;
                                        }
                                    } else {
                                        OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) activity2;
                                        oldVersionsActivity.runOnUiThread(new v(i10, 6, oldVersionsActivity, string4));
                                        break;
                                    }
                                } else {
                                    MyDownloads myDownloads = (MyDownloads) activity2;
                                    myDownloads.runOnUiThread(new m(myDownloads, i10, i14));
                                    break;
                                }
                            } else if (string4 != null) {
                                AppDetailActivity appDetailActivity2 = (AppDetailActivity) activity2;
                                appDetailActivity2.runOnUiThread(new a4.a(appDetailActivity2, string4, i10));
                                break;
                            }
                        } else if (string4 != null) {
                            MyApps myApps2 = (MyApps) activity2;
                            LifecycleCoroutineScope lifecycleScope4 = LifecycleOwnerKt.getLifecycleScope(myApps2);
                            y7.e eVar5 = i0.f12407a;
                            y.q(lifecycleScope4, n.f13548a, null, new o(myApps2, string4, i10, cVar, 19), 2);
                            break;
                        }
                    } else if (string4 != null) {
                        Updates updates2 = (Updates) activity2;
                        LifecycleCoroutineScope lifecycleScope5 = LifecycleOwnerKt.getLifecycleScope(updates2);
                        y7.e eVar6 = i0.f12407a;
                        y.q(lifecycleScope5, n.f13548a, null, new o(updates2, string4, i10, cVar, 26), 2);
                        break;
                    }
                }
                break;
            case 2:
                if (i10 != 602) {
                    Activity activity3 = o4.b.g;
                    if (activity3 != null) {
                        w6.c cVar2 = null;
                        if (!(activity3 instanceof Updates)) {
                            if (!(activity3 instanceof MyApps)) {
                                if (!(activity3 instanceof SecurityActivity)) {
                                    if (!(activity3 instanceof TvMyAppsActivity)) {
                                        if (!(activity3 instanceof MainActivity)) {
                                            if (!(activity3 instanceof AppDetailActivity)) {
                                                if (!(activity3 instanceof WishlistActivity)) {
                                                    if (!(activity3 instanceof RecommendedActivity)) {
                                                        if (!(activity3 instanceof PublicListActivity)) {
                                                            if (!(activity3 instanceof RollbackActivity)) {
                                                                if ((activity3 instanceof TvAppDetailActivity) && i10 == 603) {
                                                                    TvAppDetailActivity tvAppDetailActivity2 = (TvAppDetailActivity) activity3;
                                                                    tvAppDetailActivity2.runOnUiThread(new a4.a(tvAppDetailActivity2, 21));
                                                                    break;
                                                                }
                                                            } else if (i10 == 601) {
                                                                RollbackActivity rollbackActivity = (RollbackActivity) activity3;
                                                                rollbackActivity.runOnUiThread(new a4.a(rollbackActivity, 19));
                                                                break;
                                                            }
                                                        } else if (i10 == 601) {
                                                            ((PublicListActivity) activity3).D0(null);
                                                            break;
                                                        }
                                                    } else if (i10 == 601) {
                                                        ((RecommendedActivity) activity3).D0(null);
                                                        break;
                                                    }
                                                } else if (i10 == 601) {
                                                    ((WishlistActivity) activity3).D0(null);
                                                    break;
                                                }
                                            } else if (i10 == 603 && (j0VarN0 = ((AppDetailActivity) activity3).n0()) != null) {
                                                j0VarN0.E();
                                                break;
                                            }
                                        } else if (i10 == 603) {
                                            MainActivity mainActivity3 = (MainActivity) activity3;
                                            LifecycleCoroutineScope lifecycleScope6 = LifecycleOwnerKt.getLifecycleScope(mainActivity3);
                                            y7.e eVar7 = i0.f12407a;
                                            y.q(lifecycleScope6, n.f13548a, null, new n2(mainActivity3, cVar2, i14), 2);
                                            break;
                                        } else if (i10 == 604) {
                                            MainActivity mainActivity4 = (MainActivity) activity3;
                                            mainActivity4.runOnUiThread(new j2(i12, mainActivity4));
                                            break;
                                        }
                                    } else if (i10 == 601) {
                                        TvMyAppsActivity tvMyAppsActivity = (TvMyAppsActivity) activity3;
                                        tvMyAppsActivity.runOnUiThread(new a4.a(tvMyAppsActivity, 22));
                                        break;
                                    }
                                } else if (i10 == 601) {
                                    SecurityActivity securityActivity = (SecurityActivity) activity3;
                                    LifecycleCoroutineScope lifecycleScope7 = LifecycleOwnerKt.getLifecycleScope(securityActivity);
                                    y7.e eVar8 = i0.f12407a;
                                    y.q(lifecycleScope7, n.f13548a, null, new d9(securityActivity, cVar2, i14), 2);
                                    break;
                                }
                            } else if (i10 == 601) {
                                y7.e eVar9 = i0.f12407a;
                                y.q(y.a(n.f13548a), null, null, new h((MyApps) activity3, cVar2, i12), 3);
                                break;
                            }
                        } else if (i10 == 600) {
                            Updates updates3 = (Updates) activity3;
                            LifecycleCoroutineScope lifecycleScope8 = LifecycleOwnerKt.getLifecycleScope(updates3);
                            y7.e eVar10 = i0.f12407a;
                            y.q(lifecycleScope8, n.f13548a, null, new m9(updates3, cVar2, i14), 2);
                            break;
                        } else if (i10 == 601) {
                            Boolean boolValueOf = bundle != null ? Boolean.valueOf(bundle.getBoolean("newUpdatesAvailable")) : null;
                            Integer numValueOf = bundle != null ? Integer.valueOf(bundle.getInt("newUpdatesAvailableCount")) : null;
                            Updates updates4 = (Updates) activity3;
                            LifecycleCoroutineScope lifecycleScope9 = LifecycleOwnerKt.getLifecycleScope(updates4);
                            y7.e eVar11 = i0.f12407a;
                            y.q(lifecycleScope9, n.f13548a, null, new c5.m(updates4, boolValueOf, numValueOf, cVar2, 15), 2);
                            break;
                        }
                    }
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new s5.i0(i13), 1000L);
                    break;
                }
                break;
        }
    }

    private final void a(int i10, Bundle bundle) {
    }
}
