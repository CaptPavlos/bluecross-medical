package p4;

import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11986a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f11987b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(FileExplorerActivity fileExplorerActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f11986a = i10;
        this.f11987b = fileExplorerActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11986a) {
            case 0:
                return new l(this.f11987b, cVar, 0);
            case 1:
                return new l(this.f11987b, cVar, 1);
            case 2:
                return new l(this.f11987b, cVar, 2);
            case 3:
                return new l(this.f11987b, cVar, 3);
            case 4:
                return new l(this.f11987b, cVar, 4);
            case 5:
                return new l(this.f11987b, cVar, 5);
            case 6:
                return new l(this.f11987b, cVar, 6);
            case 7:
                return new l(this.f11987b, cVar, 7);
            case 8:
                return new l(this.f11987b, cVar, 8);
            case 9:
                return new l(this.f11987b, cVar, 9);
            case 10:
                return new l(this.f11987b, cVar, 10);
            case 11:
                return new l(this.f11987b, cVar, 11);
            case 12:
                return new l(this.f11987b, cVar, 12);
            case 13:
                return new l(this.f11987b, cVar, 13);
            case 14:
                return new l(this.f11987b, cVar, 14);
            default:
                return new l(this.f11987b, cVar, 15);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11986a) {
            case 0:
                l lVar = (l) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                lVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                l lVar2 = (l) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                lVar2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                l lVar3 = (l) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                lVar3.invokeSuspend(wVar4);
                return wVar4;
            case 3:
                l lVar4 = (l) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                lVar4.invokeSuspend(wVar5);
                return wVar5;
            case 4:
                l lVar5 = (l) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                lVar5.invokeSuspend(wVar6);
                return wVar6;
            case 5:
                l lVar6 = (l) create(wVar, cVar);
                s6.w wVar7 = s6.w.f12711a;
                lVar6.invokeSuspend(wVar7);
                return wVar7;
            case 6:
                l lVar7 = (l) create(wVar, cVar);
                s6.w wVar8 = s6.w.f12711a;
                lVar7.invokeSuspend(wVar8);
                return wVar8;
            case 7:
                l lVar8 = (l) create(wVar, cVar);
                s6.w wVar9 = s6.w.f12711a;
                lVar8.invokeSuspend(wVar9);
                return wVar9;
            case 8:
                l lVar9 = (l) create(wVar, cVar);
                s6.w wVar10 = s6.w.f12711a;
                lVar9.invokeSuspend(wVar10);
                return wVar10;
            case 9:
                l lVar10 = (l) create(wVar, cVar);
                s6.w wVar11 = s6.w.f12711a;
                lVar10.invokeSuspend(wVar11);
                return wVar11;
            case 10:
                l lVar11 = (l) create(wVar, cVar);
                s6.w wVar12 = s6.w.f12711a;
                lVar11.invokeSuspend(wVar12);
                return wVar12;
            case 11:
                l lVar12 = (l) create(wVar, cVar);
                s6.w wVar13 = s6.w.f12711a;
                lVar12.invokeSuspend(wVar13);
                return wVar13;
            case 12:
                l lVar13 = (l) create(wVar, cVar);
                s6.w wVar14 = s6.w.f12711a;
                lVar13.invokeSuspend(wVar14);
                return wVar14;
            case 13:
                l lVar14 = (l) create(wVar, cVar);
                s6.w wVar15 = s6.w.f12711a;
                lVar14.invokeSuspend(wVar15);
                return wVar15;
            case 14:
                l lVar15 = (l) create(wVar, cVar);
                s6.w wVar16 = s6.w.f12711a;
                lVar15.invokeSuspend(wVar16);
                return wVar16;
            default:
                l lVar16 = (l) create(wVar, cVar);
                s6.w wVar17 = s6.w.f12711a;
                lVar16.invokeSuspend(wVar17);
                return wVar17;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Menu menu;
        MenuItem menuItemFindItem;
        Menu menu2;
        MenuItem menuItemFindItem2;
        Menu menu3;
        MenuItem menuItemFindItem3;
        Menu menu4;
        MenuItem menuItemFindItem4;
        Menu menu5;
        MenuItem menuItemFindItem5;
        Menu menu6;
        MenuItem menuItemFindItem6;
        Menu menu7;
        MenuItem menuItemFindItem7;
        Menu menu8;
        MenuItem menuItemFindItem8;
        Menu menu9;
        MenuItem menuItemFindItem9;
        Menu menu10;
        MenuItem menuItemFindItem10;
        Menu menu11;
        MenuItem menuItemFindItem11;
        Menu menu12;
        MenuItem menuItemFindItem12;
        int i10 = this.f11986a;
        s6.w wVar = s6.w.f12711a;
        FileExplorerActivity fileExplorerActivity = this.f11987b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                FileExplorerActivity.T(fileExplorerActivity);
                return wVar;
            case 1:
                s6.a.e(obj);
                FileExplorerActivity.T(fileExplorerActivity);
                return wVar;
            case 2:
                s6.a.e(obj);
                r4.b bVar = fileExplorerActivity.M;
                if (bVar != null) {
                    fileExplorerActivity.W = bVar.a();
                }
                return wVar;
            case 3:
                s6.a.e(obj);
                r4.b bVar2 = fileExplorerActivity.M;
                bVar2.getClass();
                bVar2.c(false);
                ArrayList arrayList = fileExplorerActivity.W;
                if (arrayList != null) {
                    arrayList.getClass();
                    if (!arrayList.isEmpty()) {
                        Toolbar toolbar = fileExplorerActivity.K;
                        if (toolbar != null && (menu6 = toolbar.getMenu()) != null && (menuItemFindItem6 = menu6.findItem(R.id.action_paste)) != null) {
                            menuItemFindItem6.setVisible(true);
                        }
                        Toolbar toolbar2 = fileExplorerActivity.K;
                        if (toolbar2 != null && (menu5 = toolbar2.getMenu()) != null && (menuItemFindItem5 = menu5.findItem(R.id.action_create)) != null) {
                            menuItemFindItem5.setVisible(true);
                        }
                        Toolbar toolbar3 = fileExplorerActivity.K;
                        if (toolbar3 != null && (menu4 = toolbar3.getMenu()) != null && (menuItemFindItem4 = menu4.findItem(R.id.action_copy)) != null) {
                            menuItemFindItem4.setVisible(false);
                        }
                        Toolbar toolbar4 = fileExplorerActivity.K;
                        if (toolbar4 != null && (menu3 = toolbar4.getMenu()) != null && (menuItemFindItem3 = menu3.findItem(R.id.action_compress)) != null) {
                            menuItemFindItem3.setVisible(false);
                        }
                        Toolbar toolbar5 = fileExplorerActivity.K;
                        if (toolbar5 != null && (menu2 = toolbar5.getMenu()) != null && (menuItemFindItem2 = menu2.findItem(R.id.action_cut)) != null) {
                            menuItemFindItem2.setVisible(false);
                        }
                        Toolbar toolbar6 = fileExplorerActivity.K;
                        if (toolbar6 != null && (menu = toolbar6.getMenu()) != null && (menuItemFindItem = menu.findItem(R.id.action_delete)) != null) {
                            menuItemFindItem.setVisible(false);
                        }
                    }
                }
                return wVar;
            case 4:
                s6.a.e(obj);
                int i11 = FileExplorerActivity.f6665q0;
                fileExplorerActivity.X(null);
                return wVar;
            case 5:
                s6.a.e(obj);
                r4.b bVar3 = fileExplorerActivity.M;
                if (bVar3 != null) {
                    fileExplorerActivity.W = bVar3.a();
                }
                return wVar;
            case 6:
                s6.a.e(obj);
                r4.b bVar4 = fileExplorerActivity.M;
                bVar4.getClass();
                bVar4.c(false);
                ArrayList arrayList2 = fileExplorerActivity.W;
                if (arrayList2 != null) {
                    arrayList2.getClass();
                    if (!arrayList2.isEmpty()) {
                        Toolbar toolbar7 = fileExplorerActivity.K;
                        if (toolbar7 != null && (menu12 = toolbar7.getMenu()) != null && (menuItemFindItem12 = menu12.findItem(R.id.action_paste)) != null) {
                            menuItemFindItem12.setVisible(true);
                        }
                        Toolbar toolbar8 = fileExplorerActivity.K;
                        if (toolbar8 != null && (menu11 = toolbar8.getMenu()) != null && (menuItemFindItem11 = menu11.findItem(R.id.action_create)) != null) {
                            menuItemFindItem11.setVisible(true);
                        }
                        Toolbar toolbar9 = fileExplorerActivity.K;
                        if (toolbar9 != null && (menu10 = toolbar9.getMenu()) != null && (menuItemFindItem10 = menu10.findItem(R.id.action_copy)) != null) {
                            menuItemFindItem10.setVisible(false);
                        }
                        Toolbar toolbar10 = fileExplorerActivity.K;
                        if (toolbar10 != null && (menu9 = toolbar10.getMenu()) != null && (menuItemFindItem9 = menu9.findItem(R.id.action_compress)) != null) {
                            menuItemFindItem9.setVisible(false);
                        }
                        Toolbar toolbar11 = fileExplorerActivity.K;
                        if (toolbar11 != null && (menu8 = toolbar11.getMenu()) != null && (menuItemFindItem8 = menu8.findItem(R.id.action_cut)) != null) {
                            menuItemFindItem8.setVisible(false);
                        }
                        Toolbar toolbar12 = fileExplorerActivity.K;
                        if (toolbar12 != null && (menu7 = toolbar12.getMenu()) != null && (menuItemFindItem7 = menu7.findItem(R.id.action_delete)) != null) {
                            menuItemFindItem7.setVisible(false);
                        }
                    }
                }
                return wVar;
            case 7:
                s6.a.e(obj);
                FileExplorerActivity.T(fileExplorerActivity);
                return wVar;
            case 8:
                s6.a.e(obj);
                FileExplorerActivity.T(fileExplorerActivity);
                return wVar;
            case 9:
                s6.a.e(obj);
                FileExplorerActivity.T(fileExplorerActivity);
                return wVar;
            case 10:
                s6.a.e(obj);
                FileExplorerActivity.T(fileExplorerActivity);
                return wVar;
            case 11:
                s6.a.e(obj);
                RelativeLayout relativeLayout = fileExplorerActivity.f6674x;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                    return wVar;
                }
                kotlin.jvm.internal.l.i("rlLoading");
                throw null;
            case 12:
                s6.a.e(obj);
                boolean z9 = fileExplorerActivity.U;
                ArrayList arrayList3 = fileExplorerActivity.O;
                if (z9) {
                    if (arrayList3 != null) {
                        if (arrayList3.size() > 1) {
                            t6.q.W(arrayList3, new u(9));
                        }
                        ArrayList arrayList4 = fileExplorerActivity.O;
                        arrayList4.getClass();
                        if (arrayList4.size() > 1) {
                            t6.q.W(arrayList4, new u(10));
                        }
                    }
                    ArrayList arrayList5 = fileExplorerActivity.S;
                    if (arrayList5 != null) {
                        if (arrayList5.size() > 1) {
                            t6.q.W(arrayList5, new u(11));
                        }
                        ArrayList arrayList6 = fileExplorerActivity.S;
                        arrayList6.getClass();
                        if (arrayList6.size() > 1) {
                            t6.q.W(arrayList6, new u(12));
                        }
                    }
                } else {
                    if (arrayList3 != null) {
                        if (arrayList3.size() > 1) {
                            t6.q.W(arrayList3, new u(5));
                        }
                        ArrayList arrayList7 = fileExplorerActivity.O;
                        arrayList7.getClass();
                        if (arrayList7.size() > 1) {
                            t6.q.W(arrayList7, new u(6));
                        }
                    }
                    ArrayList arrayList8 = fileExplorerActivity.S;
                    if (arrayList8 != null) {
                        if (arrayList8.size() > 1) {
                            t6.q.W(arrayList8, new u(7));
                        }
                        ArrayList arrayList9 = fileExplorerActivity.S;
                        arrayList9.getClass();
                        if (arrayList9.size() > 1) {
                            t6.q.W(arrayList9, new u(8));
                        }
                    }
                }
                return wVar;
            case 13:
                s6.a.e(obj);
                boolean z10 = fileExplorerActivity.U;
                ArrayList arrayList10 = fileExplorerActivity.O;
                if (z10) {
                    if (arrayList10 != null) {
                        if (arrayList10.size() > 1) {
                            t6.q.W(arrayList10, new a9.i(23));
                        }
                        ArrayList arrayList11 = fileExplorerActivity.O;
                        arrayList11.getClass();
                        if (arrayList11.size() > 1) {
                            t6.q.W(arrayList11, new a9.i(24));
                        }
                    }
                    ArrayList arrayList12 = fileExplorerActivity.S;
                    if (arrayList12 != null) {
                        if (arrayList12.size() > 1) {
                            t6.q.W(arrayList12, new a9.i(25));
                        }
                        ArrayList arrayList13 = fileExplorerActivity.S;
                        arrayList13.getClass();
                        if (arrayList13.size() > 1) {
                            t6.q.W(arrayList13, new a9.i(26));
                        }
                    }
                } else {
                    if (arrayList10 != null) {
                        if (arrayList10.size() > 1) {
                            t6.q.W(arrayList10, new a9.i(19));
                        }
                        ArrayList arrayList14 = fileExplorerActivity.O;
                        arrayList14.getClass();
                        if (arrayList14.size() > 1) {
                            t6.q.W(arrayList14, new a9.i(20));
                        }
                    }
                    ArrayList arrayList15 = fileExplorerActivity.S;
                    if (arrayList15 != null) {
                        if (arrayList15.size() > 1) {
                            t6.q.W(arrayList15, new a9.i(21));
                        }
                        ArrayList arrayList16 = fileExplorerActivity.S;
                        arrayList16.getClass();
                        if (arrayList16.size() > 1) {
                            t6.q.W(arrayList16, new a9.i(22));
                        }
                    }
                }
                return wVar;
            case 14:
                s6.a.e(obj);
                boolean z11 = fileExplorerActivity.U;
                ArrayList arrayList17 = fileExplorerActivity.O;
                if (z11) {
                    if (arrayList17 != null) {
                        if (arrayList17.size() > 1) {
                            t6.q.W(arrayList17, new u(1));
                        }
                        ArrayList arrayList18 = fileExplorerActivity.O;
                        arrayList18.getClass();
                        if (arrayList18.size() > 1) {
                            t6.q.W(arrayList18, new u(2));
                        }
                    }
                    ArrayList arrayList19 = fileExplorerActivity.S;
                    if (arrayList19 != null) {
                        if (arrayList19.size() > 1) {
                            t6.q.W(arrayList19, new u(3));
                        }
                        ArrayList arrayList20 = fileExplorerActivity.S;
                        arrayList20.getClass();
                        if (arrayList20.size() > 1) {
                            t6.q.W(arrayList20, new u(4));
                        }
                    }
                } else {
                    if (arrayList17 != null) {
                        if (arrayList17.size() > 1) {
                            t6.q.W(arrayList17, new a9.i(27));
                        }
                        ArrayList arrayList21 = fileExplorerActivity.O;
                        arrayList21.getClass();
                        if (arrayList21.size() > 1) {
                            t6.q.W(arrayList21, new a9.i(28));
                        }
                    }
                    ArrayList arrayList22 = fileExplorerActivity.S;
                    if (arrayList22 != null) {
                        if (arrayList22.size() > 1) {
                            t6.q.W(arrayList22, new a9.i(29));
                        }
                        ArrayList arrayList23 = fileExplorerActivity.S;
                        arrayList23.getClass();
                        if (arrayList23.size() > 1) {
                            t6.q.W(arrayList23, new u(0));
                        }
                    }
                }
                return wVar;
            default:
                s6.a.e(obj);
                DocumentFile documentFile = fileExplorerActivity.P;
                if (documentFile != null) {
                    String lastPathSegment = documentFile.getUri().getLastPathSegment();
                    String strSubstring = lastPathSegment != null ? lastPathSegment.substring(o7.m.m0(":", lastPathSegment, 6) + 1) : "";
                    if (!fileExplorerActivity.V) {
                        TextView textView = fileExplorerActivity.f6672v;
                        if (textView == null) {
                            kotlin.jvm.internal.l.i("tvBreadCrumb");
                            throw null;
                        }
                        textView.setText(fileExplorerActivity.getString(R.string.internal_storage) + '/' + strSubstring);
                    } else if (strSubstring.length() == 0) {
                        TextView textView2 = fileExplorerActivity.f6672v;
                        if (textView2 == null) {
                            kotlin.jvm.internal.l.i("tvBreadCrumb");
                            throw null;
                        }
                        textView2.setText(fileExplorerActivity.getString(R.string.sd_card));
                    } else {
                        DocumentFile documentFile2 = fileExplorerActivity.P;
                        documentFile2.getClass();
                        String lastPathSegment2 = documentFile2.getUri().getLastPathSegment();
                        LinearLayout linearLayout = fileExplorerActivity.f6675z;
                        if (linearLayout == null) {
                            kotlin.jvm.internal.l.i("llBreadcrumb");
                            throw null;
                        }
                        if (linearLayout.findViewWithTag(lastPathSegment2) == null) {
                            LayoutInflater layoutInflater = fileExplorerActivity.getLayoutInflater();
                            LinearLayout linearLayout2 = fileExplorerActivity.f6675z;
                            if (linearLayout2 == null) {
                                kotlin.jvm.internal.l.i("llBreadcrumb");
                                throw null;
                            }
                            View viewInflate = layoutInflater.inflate(R.layout.breadcrumb, (ViewGroup) linearLayout2, false);
                            viewInflate.getClass();
                            LinearLayout linearLayout3 = (LinearLayout) viewInflate;
                            linearLayout3.setTag(lastPathSegment2);
                            TextView textView3 = (TextView) linearLayout3.findViewById(R.id.tv_breadcrumb_path);
                            lastPathSegment2.getClass();
                            if (lastPathSegment2.substring(o7.m.m0(":", lastPathSegment2, 6) + 1).length() > 0) {
                                String strSubstring2 = lastPathSegment2.substring(o7.m.m0(":", lastPathSegment2, 6) + 1);
                                if (strSubstring2.substring(o7.m.m0("/", strSubstring2, 6) + 1).length() > 0) {
                                    textView3.setText(strSubstring2.substring(o7.m.m0("/", strSubstring2, 6) + 1));
                                } else {
                                    textView3.setText(strSubstring2.substring(o7.m.m0(":", strSubstring2, 6) + 1));
                                }
                            }
                            textView3.setTypeface(o4.b.f11720s);
                            LinearLayout linearLayout4 = fileExplorerActivity.f6675z;
                            if (linearLayout4 == null) {
                                kotlin.jvm.internal.l.i("llBreadcrumb");
                                throw null;
                            }
                            linearLayout4.addView(linearLayout3);
                            new Handler(Looper.getMainLooper()).post(new androidx.constraintlayout.helper.widget.a(fileExplorerActivity, 9));
                        }
                    }
                } else {
                    File file = fileExplorerActivity.T;
                    if (file != null) {
                        if (file.equals(Environment.getExternalStorageDirectory())) {
                            TextView textView4 = fileExplorerActivity.f6672v;
                            if (textView4 == null) {
                                kotlin.jvm.internal.l.i("tvBreadCrumb");
                                throw null;
                            }
                            textView4.setText(fileExplorerActivity.getString(R.string.internal_storage));
                        } else {
                            File file2 = fileExplorerActivity.T;
                            file2.getClass();
                            String absolutePath = file2.getAbsolutePath();
                            LinearLayout linearLayout5 = fileExplorerActivity.f6675z;
                            if (linearLayout5 == null) {
                                kotlin.jvm.internal.l.i("llBreadcrumb");
                                throw null;
                            }
                            if (linearLayout5.findViewWithTag(absolutePath) == null) {
                                LayoutInflater layoutInflater2 = fileExplorerActivity.getLayoutInflater();
                                LinearLayout linearLayout6 = fileExplorerActivity.f6675z;
                                if (linearLayout6 == null) {
                                    kotlin.jvm.internal.l.i("llBreadcrumb");
                                    throw null;
                                }
                                View viewInflate2 = layoutInflater2.inflate(R.layout.breadcrumb, (ViewGroup) linearLayout6, false);
                                viewInflate2.getClass();
                                LinearLayout linearLayout7 = (LinearLayout) viewInflate2;
                                linearLayout7.setTag(absolutePath);
                                TextView textView5 = (TextView) linearLayout7.findViewById(R.id.tv_breadcrumb_path);
                                File file3 = fileExplorerActivity.T;
                                file3.getClass();
                                String path = file3.getPath();
                                path.getClass();
                                textView5.setText(Uri.parse(path).getLastPathSegment());
                                textView5.setTypeface(o4.b.f11720s);
                                LinearLayout linearLayout8 = fileExplorerActivity.f6675z;
                                if (linearLayout8 == null) {
                                    kotlin.jvm.internal.l.i("llBreadcrumb");
                                    throw null;
                                }
                                linearLayout8.addView(linearLayout7);
                                new Handler(Looper.getMainLooper()).post(new androidx.constraintlayout.helper.widget.a(fileExplorerActivity, 9));
                            }
                        }
                    }
                }
                if (fileExplorerActivity.M == null) {
                    r4.b bVar5 = new r4.b(fileExplorerActivity.l0);
                    fileExplorerActivity.M = bVar5;
                    RecyclerView recyclerView = fileExplorerActivity.f6673w;
                    if (recyclerView == null) {
                        kotlin.jvm.internal.l.i("rvFiles");
                        throw null;
                    }
                    recyclerView.setAdapter(bVar5);
                }
                ArrayList arrayList24 = new ArrayList();
                ArrayList arrayList25 = fileExplorerActivity.O;
                if (arrayList25 != null) {
                    arrayList24.addAll(arrayList25);
                } else {
                    ArrayList arrayList26 = fileExplorerActivity.S;
                    if (arrayList26 != null) {
                        arrayList24.addAll(arrayList26);
                    }
                }
                r4.b bVar6 = fileExplorerActivity.M;
                bVar6.getClass();
                bVar6.f12375b = arrayList24;
                bVar6.f12377d = new boolean[arrayList24.size()];
                bVar6.notifyDataSetChanged();
                RelativeLayout relativeLayout2 = fileExplorerActivity.f6674x;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                    return wVar;
                }
                kotlin.jvm.internal.l.i("rlLoading");
                throw null;
        }
    }
}
