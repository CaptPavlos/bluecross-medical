package l4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyDownloads;
import com.uptodown.workers.DownloadWorker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d4 implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10323a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f10324b;

    public /* synthetic */ d4(MyDownloads myDownloads, int i10) {
        this.f10323a = i10;
        this.f10324b = myDownloads;
    }

    @Override // g7.a
    public final Object invoke() {
        String str;
        int i10 = this.f10323a;
        int i11 = 3;
        w6.c cVar = null;
        s6.w wVar = s6.w.f12711a;
        MyDownloads myDownloads = this.f10324b;
        switch (i10) {
            case 0:
                int i12 = MyDownloads.O;
                View viewInflate = myDownloads.getLayoutInflater().inflate(R.layout.my_downloads, (ViewGroup) null, false);
                int i13 = R.id.loading_view_my_downloads;
                View viewFindChildViewById = ViewBindings.findChildViewById(viewInflate, R.id.loading_view_my_downloads);
                if (viewFindChildViewById != null) {
                    i13 = R.id.my_downloads_filters;
                    View viewFindChildViewById2 = ViewBindings.findChildViewById(viewInflate, R.id.my_downloads_filters);
                    if (viewFindChildViewById2 != null) {
                        int i14 = R.id.ll_order_my_downloads;
                        View viewFindChildViewById3 = ViewBindings.findChildViewById(viewFindChildViewById2, R.id.ll_order_my_downloads);
                        if (viewFindChildViewById3 != null) {
                            a3.x xVarP = a3.x.p(viewFindChildViewById3);
                            i14 = R.id.rl_my_downloads_selector;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.rl_my_downloads_selector);
                            if (relativeLayout != null) {
                                i14 = R.id.tv_delete_all_downloads;
                                TextView textView = (TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_delete_all_downloads);
                                if (textView != null) {
                                    i14 = R.id.tv_delete_selected_downloads;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_delete_selected_downloads);
                                    if (textView2 != null) {
                                        i14 = R.id.tv_label_selected_items;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(viewFindChildViewById2, R.id.tv_label_selected_items);
                                        if (textView3 != null) {
                                            d5.j jVar = new d5.j((RelativeLayout) viewFindChildViewById2, xVarP, relativeLayout, textView, textView2, textView3, 4);
                                            i13 = R.id.nsv_my_downloads;
                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(viewInflate, R.id.nsv_my_downloads);
                                            if (nestedScrollView != null) {
                                                i13 = R.id.recyclerview;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, R.id.recyclerview);
                                                if (recyclerView != null) {
                                                    i13 = R.id.search_view_my_downloads;
                                                    SearchView searchView = (SearchView) ViewBindings.findChildViewById(viewInflate, R.id.search_view_my_downloads);
                                                    if (searchView != null) {
                                                        i13 = R.id.toolbar_downloads;
                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(viewInflate, R.id.toolbar_downloads);
                                                        if (toolbar != null) {
                                                            i13 = R.id.tv_no_items;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_no_items);
                                                            if (textView4 != null) {
                                                                i13 = R.id.tv_toolbar_title_downloads;
                                                                if (((TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_toolbar_title_downloads)) != null) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewFindChildViewById2.getResources().getResourceName(i14)));
                        break;
                    }
                }
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i13)));
                break;
            case 1:
                int i15 = MyDownloads.O;
                r7.y.q(LifecycleOwnerKt.getLifecycleScope(myDownloads), null, null, new a3.o(myDownloads, cVar, 20), 3);
                break;
            case 2:
                int i16 = MyDownloads.O;
                myDownloads.n0(true);
                break;
            case 3:
                int i17 = MyDownloads.O;
                myDownloads.n0(false);
                DownloadWorker.f = false;
                DownloadWorker.e = false;
                break;
            default:
                int i18 = MyDownloads.O;
                float f = UptodownApp.E;
                if (!k4.c.o(myDownloads, "downloadApkWorker")) {
                    myDownloads.n0(false);
                    break;
                } else {
                    DownloadWorker.f = true;
                    ArrayList arrayList = new ArrayList();
                    v5.g gVarL = v5.g.f13148u.l(myDownloads);
                    gVarL.a();
                    Iterator it = gVarL.F().iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        h5.q qVar = (h5.q) next;
                        if (qVar.m()) {
                            arrayList.add(qVar);
                        }
                    }
                    gVarL.b();
                    if (arrayList.size() > 1) {
                        String string = myDownloads.getString(R.string.dialog_cancel_downloads_msg);
                        string.getClass();
                        str = String.format(string, Arrays.copyOf(new Object[0], 0));
                    } else {
                        String string2 = myDownloads.getString(R.string.dialog_cancel_download_msg);
                        string2.getClass();
                        str = String.format(string2, Arrays.copyOf(new Object[0], 0));
                    }
                    myDownloads.L(str, new d4(myDownloads, 2), new d4(myDownloads, i11));
                    break;
                }
        }
        return wVar;
    }
}
