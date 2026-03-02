package l4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import com.uptodown.tv.ui.fragment.TvAppsListFragment;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import com.uptodown.tv.ui.fragment.TvSearchFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u4 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10875a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10876b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10877c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u4(Object obj, Object obj2, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10875a = i10;
        this.f10876b = obj;
        this.f10877c = obj2;
    }

    private final Object a(Object obj) {
        s6.a.e(obj);
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f10876b;
        RelativeLayout relativeLayout = fileExplorerActivity.f6674x;
        if (relativeLayout == null) {
            kotlin.jvm.internal.l.i("rlLoading");
            throw null;
        }
        relativeLayout.setVisibility(8);
        String str = (String) this.f10877c;
        int i10 = 0;
        if (str != null) {
            ArrayList arrayList = fileExplorerActivity.O;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    DocumentFile documentFile = (DocumentFile) next;
                    if (documentFile.getName() != null && o7.u.Z(documentFile.getName(), str, true)) {
                        break;
                    }
                    i10++;
                }
            } else {
                ArrayList arrayList2 = fileExplorerActivity.S;
                if (arrayList2 != null) {
                    Iterator it2 = arrayList2.iterator();
                    it2.getClass();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        if (o7.u.Z(((File) next2).getName(), str, true)) {
                            break;
                        }
                        i10++;
                    }
                }
            }
        }
        RecyclerView recyclerView = fileExplorerActivity.f6673w;
        if (recyclerView == null) {
            kotlin.jvm.internal.l.i("rvFiles");
            throw null;
        }
        recyclerView.scrollToPosition(i10);
        r4.b bVar = fileExplorerActivity.M;
        bVar.getClass();
        if (bVar.getItemCount() == 0) {
            DocumentFile documentFile2 = fileExplorerActivity.P;
            if (documentFile2 != null) {
                fileExplorerActivity.c0(documentFile2.canRead());
            } else {
                File file = fileExplorerActivity.T;
                if (file != null) {
                    fileExplorerActivity.c0(file.canRead());
                }
            }
        } else {
            TextView textView = fileExplorerActivity.B;
            if (textView == null) {
                kotlin.jvm.internal.l.i("tvEmptyDirectory");
                throw null;
            }
            textView.setVisibility(8);
        }
        return s6.w.f12711a;
    }

    private final Object b(Object obj) {
        s6.a.e(obj);
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f10876b;
        r4.b bVar = fileExplorerActivity.M;
        bVar.getClass();
        bVar.c(false);
        RelativeLayout relativeLayout = fileExplorerActivity.f6674x;
        if (relativeLayout == null) {
            kotlin.jvm.internal.l.i("rlLoading");
            throw null;
        }
        relativeLayout.setVisibility(8);
        String string = fileExplorerActivity.getString(R.string.core_files_deleted, String.valueOf(((kotlin.jvm.internal.v) this.f10877c).f10136a));
        string.getClass();
        fileExplorerActivity.C(string);
        fileExplorerActivity.W();
        fileExplorerActivity.Y(false);
        return s6.w.f12711a;
    }

    private final Object d(Object obj) {
        s6.a.e(obj);
        FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f10876b;
        String string = ((EditText) this.f10877c).getText().toString();
        int i10 = FileExplorerActivity.f6665q0;
        kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(r7.y.a(y7.d.f14116a), null, null, new a6.q(fileExplorerActivity, uVar, string, (w6.c) null), 3);
        return s6.w.f12711a;
    }

    private final Object e(Object obj) {
        s6.a.e(obj);
        InstallerActivity installerActivity = (InstallerActivity) this.f10876b;
        TextView textView = installerActivity.f6680q;
        if (textView != null) {
            ArrayList arrayList = installerActivity.P;
            arrayList.getClass();
            textView.setText((CharSequence) arrayList.get(((kotlin.jvm.internal.v) this.f10877c).f10136a));
        }
        TextView textView2 = installerActivity.f6680q;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        return s6.w.f12711a;
    }

    private final Object g(Object obj) {
        s6.a.e(obj);
        List<Fragment> fragments = ((TvAppDetailActivity) this.f10876b).getSupportFragmentManager().getFragments();
        fragments.getClass();
        if (fragments.size() > 0) {
            Fragment fragment = fragments.get(0);
            if (fragment instanceof TvAppDetailFragment) {
                TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) fragment;
                String str = (String) this.f10877c;
                h5.h hVar = tvAppDetailFragment.f6693a;
                if (hVar != null && str != null && str.equalsIgnoreCase(hVar.f8595w)) {
                    tvAppDetailFragment.u();
                }
            }
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object h(java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.u4.h(java.lang.Object):java.lang.Object");
    }

    private final Object i(Object obj) {
        s6.a.e(obj);
        d0.i iVar = (d0.i) ((c1.g1) this.f10876b).f1232d;
        String str = (String) this.f10877c;
        str.getClass();
        a4 a4Var = (a4) iVar.f6781b;
        TextView textView = a4Var.I;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = a4Var.J;
        if (textView2 != null) {
            textView2.setText(String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{0}, 1)));
        }
        ProgressBar progressBar = a4Var.H;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        return s6.w.f12711a;
    }

    private final Object j(Object obj) {
        String str;
        s6.a.e(obj);
        TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) this.f10876b;
        h5.q qVar = (h5.q) ((kotlin.jvm.internal.x) this.f10877c).f10138a;
        if (tvAppDetailFragment.getContext() != null && tvAppDetailFragment.f6693a != null) {
            if (!tvAppDetailFragment.f6697i) {
                Context contextRequireContext = tvAppDetailFragment.requireContext();
                contextRequireContext.getClass();
                boolean z9 = false;
                try {
                    SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences.contains("is_device_tracking_registered")) {
                        z9 = sharedPreferences.getBoolean("is_device_tracking_registered", false);
                    }
                } catch (Exception unused) {
                }
                if (z9) {
                    h5.h hVar = tvAppDetailFragment.f6693a;
                    hVar.getClass();
                    if (!hVar.l()) {
                        h5.h hVar2 = tvAppDetailFragment.f6693a;
                        hVar2.getClass();
                        if (hVar2.j()) {
                            h5.h hVar3 = tvAppDetailFragment.f6693a;
                            hVar3.getClass();
                            if (!kotlin.jvm.internal.l.a(hVar3.N, "Discontinued")) {
                                h5.h hVar4 = tvAppDetailFragment.f6693a;
                                hVar4.getClass();
                                if (hVar4.f8595w != null) {
                                    Activity activity = o4.b.g;
                                    u4.a aVarA = r0.f.A();
                                    str = aVarA != null ? aVarA.f12891a : null;
                                    h5.h hVar5 = tvAppDetailFragment.f6693a;
                                    hVar5.getClass();
                                    if (o7.u.Z(str, hVar5.f8595w, true)) {
                                        tvAppDetailFragment.r();
                                    } else if (qVar == null) {
                                        tvAppDetailFragment.o();
                                    } else if (qVar.c()) {
                                        tvAppDetailFragment.q();
                                    } else if (tvAppDetailFragment.k()) {
                                        tvAppDetailFragment.p(qVar);
                                    } else {
                                        tvAppDetailFragment.o();
                                    }
                                }
                            } else if (tvAppDetailFragment.getActivity() != null && tvAppDetailFragment.f6695c != 13) {
                                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new q5.a());
                                sparseArrayObjectAdapter.set(1, new Action(1L, tvAppDetailFragment.getString(R.string.status_discontinued)));
                                DetailsOverviewRow detailsOverviewRow = tvAppDetailFragment.h;
                                detailsOverviewRow.getClass();
                                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                                tvAppDetailFragment.f6695c = 13;
                            }
                        } else if (tvAppDetailFragment.getActivity() != null && tvAppDetailFragment.f6695c != 11) {
                            SparseArrayObjectAdapter sparseArrayObjectAdapter2 = new SparseArrayObjectAdapter(new q5.a());
                            sparseArrayObjectAdapter2.set(1, new Action(1L, tvAppDetailFragment.getString(R.string.app_detail_not_compatible)));
                            DetailsOverviewRow detailsOverviewRow2 = tvAppDetailFragment.h;
                            detailsOverviewRow2.getClass();
                            detailsOverviewRow2.setActionsAdapter(sparseArrayObjectAdapter2);
                            tvAppDetailFragment.f6695c = 11;
                        }
                    } else if (tvAppDetailFragment.getActivity() != null && tvAppDetailFragment.f6695c != 8) {
                        SparseArrayObjectAdapter sparseArrayObjectAdapter3 = new SparseArrayObjectAdapter(new q5.a());
                        sparseArrayObjectAdapter3.set(1, new Action(1L, tvAppDetailFragment.getString(R.string.coming_soon_button)));
                        DetailsOverviewRow detailsOverviewRow3 = tvAppDetailFragment.h;
                        detailsOverviewRow3.getClass();
                        detailsOverviewRow3.setActionsAdapter(sparseArrayObjectAdapter3);
                        tvAppDetailFragment.f6695c = 8;
                    }
                } else if (tvAppDetailFragment.getActivity() != null && tvAppDetailFragment.f6695c != 9) {
                    SparseArrayObjectAdapter sparseArrayObjectAdapter4 = new SparseArrayObjectAdapter(new q5.a());
                    sparseArrayObjectAdapter4.set(1, new Action(1L, tvAppDetailFragment.getString(R.string.status_checking_device_compatibility)));
                    DetailsOverviewRow detailsOverviewRow4 = tvAppDetailFragment.h;
                    detailsOverviewRow4.getClass();
                    detailsOverviewRow4.setActionsAdapter(sparseArrayObjectAdapter4);
                    tvAppDetailFragment.f6695c = 9;
                }
            } else if (tvAppDetailFragment.f6698j == null) {
                tvAppDetailFragment.s();
            } else {
                Activity activity2 = o4.b.g;
                u4.a aVarA2 = r0.f.A();
                str = aVarA2 != null ? aVarA2.f12891a : null;
                h5.h hVar6 = tvAppDetailFragment.f6693a;
                hVar6.getClass();
                if (o7.u.Z(str, hVar6.f8595w, true)) {
                    tvAppDetailFragment.r();
                } else if (qVar == null) {
                    tvAppDetailFragment.t();
                } else if (qVar.c()) {
                    tvAppDetailFragment.q();
                    tvAppDetailFragment.f6695c = 6;
                } else if (tvAppDetailFragment.k()) {
                    tvAppDetailFragment.p(qVar);
                } else {
                    tvAppDetailFragment.t();
                }
            }
        }
        return s6.w.f12711a;
    }

    private final Object k(Object obj) {
        TvAppsListFragment tvAppsListFragment = (TvAppsListFragment) this.f10876b;
        s6.a.e(obj);
        try {
            TvAppsListFragment.a(tvAppsListFragment, (ArrayList) ((kotlin.jvm.internal.x) this.f10877c).f10138a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvAppsListFragment.f6707d = false;
        return s6.w.f12711a;
    }

    private final Object l(Object obj) {
        s6.a.e(obj);
        TvMyAppsFragment tvMyAppsFragment = (TvMyAppsFragment) this.f10876b;
        ArrayList arrayList = (ArrayList) ((kotlin.jvm.internal.x) this.f10877c).f10138a;
        s5.w wVar = tvMyAppsFragment.f6709b;
        wVar.getClass();
        wVar.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                s5.w wVar2 = tvMyAppsFragment.f6709b;
                wVar2.getClass();
                wVar2.add(arrayList.get(i10));
            }
        }
        s5.w wVar3 = tvMyAppsFragment.f6709b;
        wVar3.getClass();
        if (wVar3.size() == 0 && tvMyAppsFragment.getContext() != null) {
            String string = tvMyAppsFragment.getString(R.string.no_data_available);
            FragmentActivity activity = tvMyAppsFragment.getActivity();
            if (activity != null && !activity.isFinishing()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(string);
                builder.setPositiveButton(android.R.string.ok, new r5.c(8));
                builder.setCancelable(true);
                builder.create().show();
            }
        }
        return s6.w.f12711a;
    }

    private final Object m(Object obj) {
        s6.a.e(obj);
        TvMyDownloadsFragment tvMyDownloadsFragment = (TvMyDownloadsFragment) this.f10876b;
        ArrayList arrayList = (ArrayList) this.f10877c;
        ArrayObjectAdapter arrayObjectAdapter = tvMyDownloadsFragment.f6712a;
        arrayObjectAdapter.getClass();
        arrayObjectAdapter.clear();
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            ArrayObjectAdapter arrayObjectAdapter2 = tvMyDownloadsFragment.f6712a;
            arrayObjectAdapter2.getClass();
            arrayObjectAdapter2.add((h5.q) next);
        }
        ArrayObjectAdapter arrayObjectAdapter3 = tvMyDownloadsFragment.f6712a;
        arrayObjectAdapter3.getClass();
        if (arrayObjectAdapter3.size() == 0 && tvMyDownloadsFragment.getContext() != null) {
            String string = tvMyDownloadsFragment.getString(R.string.no_data_available);
            FragmentActivity activity = tvMyDownloadsFragment.getActivity();
            if (activity != null && !activity.isFinishing()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(string);
                builder.setPositiveButton(android.R.string.ok, new r5.c(9));
                builder.setCancelable(true);
                builder.create().show();
            }
        }
        return s6.w.f12711a;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10875a) {
            case 0:
                return new u4((v4) this.f10876b, (MyStatsActivity) this.f10877c, cVar, 0);
            case 1:
                return new u4((OldVersionsActivity) this.f10876b, (String) this.f10877c, cVar, 1);
            case 2:
                return new u4((k5) this.f10876b, (OldVersionsActivity) this.f10877c, cVar, 2);
            case 3:
                return new u4((h5.q) this.f10876b, (OrganizationActivity) this.f10877c, cVar, 3);
            case 4:
                return new u4((r5) this.f10876b, (OrganizationActivity) this.f10877c, cVar, 4);
            case 5:
                return new u4((r5) this.f10876b, (Context) this.f10877c, cVar, 5);
            case 6:
                return new u4((PreregistrationActivity) this.f10876b, (h5.g0) this.f10877c, cVar, 6);
            case 7:
                return new u4((Context) this.f10876b, (ArrayList) this.f10877c, cVar, 7);
            case 8:
                return new u4((PublicListActivity) this.f10876b, (String) this.f10877c, cVar, 8);
            case 9:
                return new u4((RecommendedActivity) this.f10876b, (String) this.f10877c, cVar, 9);
            case 10:
                return new u4((k8) this.f10876b, (ReviewsActivity) this.f10877c, cVar, 10);
            case 11:
                return new u4((Updates) this.f10876b, (ArrayList) this.f10877c, cVar, 11);
            case 12:
                return new u4((wa) this.f10876b, (Context) this.f10877c, cVar, 12);
            case 13:
                return new u4((Context) this.f10876b, (ob) this.f10877c, cVar, 13);
            case 14:
                return new u4((Context) this.f10876b, (tb) this.f10877c, cVar, 14);
            case 15:
                return new u4((WishlistActivity) this.f10876b, (String) this.f10877c, cVar, 15);
            case 16:
                return new u4((Bitmap) this.f10876b, (m6.e) this.f10877c, cVar, 16);
            case 17:
                return new u4((p4.f) this.f10876b, (String) this.f10877c, cVar, 17);
            case 18:
                return new u4((FileExplorerActivity) this.f10876b, (String) this.f10877c, cVar, 18);
            case 19:
                return new u4((FileExplorerActivity) this.f10876b, (kotlin.jvm.internal.v) this.f10877c, cVar, 19);
            case 20:
                return new u4((FileExplorerActivity) this.f10876b, (EditText) this.f10877c, cVar, 20);
            case 21:
                return new u4((InstallerActivity) this.f10876b, (kotlin.jvm.internal.v) this.f10877c, cVar, 21);
            case 22:
                return new u4((TvAppDetailActivity) this.f10876b, (String) this.f10877c, cVar, 22);
            case 23:
                return new u4((c1.g1) this.f10876b, (ArrayList) this.f10877c, cVar, 23);
            case 24:
                return new u4((c1.g1) this.f10876b, (String) this.f10877c, cVar, 24);
            case 25:
                return new u4((TvAppDetailFragment) this.f10876b, (kotlin.jvm.internal.x) this.f10877c, cVar, 25);
            case 26:
                return new u4((TvAppsListFragment) this.f10876b, (kotlin.jvm.internal.x) this.f10877c, cVar, 26);
            case 27:
                return new u4((TvMyAppsFragment) this.f10876b, (kotlin.jvm.internal.x) this.f10877c, cVar, 27);
            case 28:
                return new u4((TvMyDownloadsFragment) this.f10876b, (ArrayList) this.f10877c, cVar, 28);
            default:
                return new u4((TvSearchFragment) this.f10876b, (h5.h) this.f10877c, cVar, 29);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws JSONException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10875a) {
            case 0:
                u4 u4Var = (u4) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                u4Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                u4 u4Var2 = (u4) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                u4Var2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                u4 u4Var3 = (u4) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                u4Var3.invokeSuspend(wVar4);
                return wVar4;
            case 3:
                u4 u4Var4 = (u4) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                u4Var4.invokeSuspend(wVar5);
                return wVar5;
            case 4:
                u4 u4Var5 = (u4) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                u4Var5.invokeSuspend(wVar6);
                return wVar6;
            case 5:
                u4 u4Var6 = (u4) create(wVar, cVar);
                s6.w wVar7 = s6.w.f12711a;
                u4Var6.invokeSuspend(wVar7);
                return wVar7;
            case 6:
                u4 u4Var7 = (u4) create(wVar, cVar);
                s6.w wVar8 = s6.w.f12711a;
                u4Var7.invokeSuspend(wVar8);
                return wVar8;
            case 7:
                u4 u4Var8 = (u4) create(wVar, cVar);
                s6.w wVar9 = s6.w.f12711a;
                u4Var8.invokeSuspend(wVar9);
                return wVar9;
            case 8:
                u4 u4Var9 = (u4) create(wVar, cVar);
                s6.w wVar10 = s6.w.f12711a;
                u4Var9.invokeSuspend(wVar10);
                return wVar10;
            case 9:
                u4 u4Var10 = (u4) create(wVar, cVar);
                s6.w wVar11 = s6.w.f12711a;
                u4Var10.invokeSuspend(wVar11);
                return wVar11;
            case 10:
                u4 u4Var11 = (u4) create(wVar, cVar);
                s6.w wVar12 = s6.w.f12711a;
                u4Var11.invokeSuspend(wVar12);
                return wVar12;
            case 11:
                u4 u4Var12 = (u4) create(wVar, cVar);
                s6.w wVar13 = s6.w.f12711a;
                u4Var12.invokeSuspend(wVar13);
                return wVar13;
            case 12:
                u4 u4Var13 = (u4) create(wVar, cVar);
                s6.w wVar14 = s6.w.f12711a;
                u4Var13.invokeSuspend(wVar14);
                return wVar14;
            case 13:
                u4 u4Var14 = (u4) create(wVar, cVar);
                s6.w wVar15 = s6.w.f12711a;
                u4Var14.invokeSuspend(wVar15);
                return wVar15;
            case 14:
                u4 u4Var15 = (u4) create(wVar, cVar);
                s6.w wVar16 = s6.w.f12711a;
                u4Var15.invokeSuspend(wVar16);
                return wVar16;
            case 15:
                u4 u4Var16 = (u4) create(wVar, cVar);
                s6.w wVar17 = s6.w.f12711a;
                u4Var16.invokeSuspend(wVar17);
                return wVar17;
            case 16:
                u4 u4Var17 = new u4((Bitmap) this.f10876b, (m6.e) this.f10877c, cVar, 16);
                s6.w wVar18 = s6.w.f12711a;
                u4Var17.invokeSuspend(wVar18);
                return wVar18;
            case 17:
                u4 u4Var18 = (u4) create(wVar, cVar);
                s6.w wVar19 = s6.w.f12711a;
                u4Var18.invokeSuspend(wVar19);
                return wVar19;
            case 18:
                u4 u4Var19 = (u4) create(wVar, cVar);
                s6.w wVar20 = s6.w.f12711a;
                u4Var19.invokeSuspend(wVar20);
                return wVar20;
            case 19:
                u4 u4Var20 = (u4) create(wVar, cVar);
                s6.w wVar21 = s6.w.f12711a;
                u4Var20.invokeSuspend(wVar21);
                return wVar21;
            case 20:
                u4 u4Var21 = (u4) create(wVar, cVar);
                s6.w wVar22 = s6.w.f12711a;
                u4Var21.invokeSuspend(wVar22);
                return wVar22;
            case 21:
                u4 u4Var22 = (u4) create(wVar, cVar);
                s6.w wVar23 = s6.w.f12711a;
                u4Var22.invokeSuspend(wVar23);
                return wVar23;
            case 22:
                u4 u4Var23 = (u4) create(wVar, cVar);
                s6.w wVar24 = s6.w.f12711a;
                u4Var23.invokeSuspend(wVar24);
                return wVar24;
            case 23:
                u4 u4Var24 = (u4) create(wVar, cVar);
                s6.w wVar25 = s6.w.f12711a;
                u4Var24.invokeSuspend(wVar25);
                return wVar25;
            case 24:
                u4 u4Var25 = (u4) create(wVar, cVar);
                s6.w wVar26 = s6.w.f12711a;
                u4Var25.invokeSuspend(wVar26);
                return wVar26;
            case 25:
                u4 u4Var26 = (u4) create(wVar, cVar);
                s6.w wVar27 = s6.w.f12711a;
                u4Var26.invokeSuspend(wVar27);
                return wVar27;
            case 26:
                u4 u4Var27 = (u4) create(wVar, cVar);
                s6.w wVar28 = s6.w.f12711a;
                u4Var27.invokeSuspend(wVar28);
                return wVar28;
            case 27:
                u4 u4Var28 = (u4) create(wVar, cVar);
                s6.w wVar29 = s6.w.f12711a;
                u4Var28.invokeSuspend(wVar29);
                return wVar29;
            case 28:
                u4 u4Var29 = (u4) create(wVar, cVar);
                s6.w wVar30 = s6.w.f12711a;
                u4Var29.invokeSuspend(wVar30);
                return wVar30;
            default:
                u4 u4Var30 = (u4) create(wVar, cVar);
                s6.w wVar31 = s6.w.f12711a;
                u4Var30.invokeSuspend(wVar31);
                return wVar31;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:427:0x0a42  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0a78  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 2998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.u4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
