package c6;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import b9.s;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import r7.i0;
import r7.w;
import r7.y;
import t6.j;
import t6.n;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends l9.a implements c.b {

    /* renamed from: m, reason: collision with root package name */
    public TextView f1795m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f1796n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f1797o;

    /* renamed from: p, reason: collision with root package name */
    public Button f1798p;

    /* renamed from: q, reason: collision with root package name */
    public Button f1799q;

    /* renamed from: r, reason: collision with root package name */
    public RecyclerView f1800r;

    /* renamed from: s, reason: collision with root package name */
    public RecyclerView f1801s;
    public RecyclerView t;

    /* renamed from: u, reason: collision with root package name */
    public FrameLayout f1802u;

    /* renamed from: v, reason: collision with root package name */
    public ConstraintLayout f1803v;

    /* renamed from: w, reason: collision with root package name */
    public View f1804w;

    /* renamed from: x, reason: collision with root package name */
    public View f1805x;
    public View y;

    /* renamed from: z, reason: collision with root package name */
    public h f1806z;

    public final c.g a(ArrayList arrayList) {
        d9.d dVar = this.f11100j;
        return new c.g(arrayList, this, (String) null, dVar == null ? null : dVar.f7475i, dVar == null ? null : dVar.e, dVar == null ? null : dVar.f, dVar != null ? dVar.f7471a : null, (Typeface) null, this.f11102l, 268);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Iterable, java.lang.Object] */
    @Override // c.b
    public final void h(c.h hVar) {
        Object next;
        ?? r12;
        k8.d dVar = hVar.f964a;
        h hVar2 = this.f1806z;
        m8.b bVar = null;
        Object obj = null;
        cVar = null;
        cVar = null;
        m8.c cVar = null;
        Object obj2 = null;
        if (hVar2 == null) {
            l.i("viewModel");
            throw null;
        }
        m8.a aVar = hVar2.f1809a;
        int iC = c.i.c(hVar.f967d);
        if (iC == 10) {
            ?? r13 = aVar.f11239d;
            if (r13 != 0) {
                Iterator it = r13.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next2 = it.next();
                    if (((m8.b) next2).f11240a.intValue() == dVar.f10088a) {
                        obj2 = next2;
                        break;
                    }
                }
                bVar = (m8.b) obj2;
            }
            if (bVar == null) {
                return;
            }
            bVar.f11242c = hVar.f965b;
            return;
        }
        if (iC != 11) {
            return;
        }
        ?? r14 = aVar.f11239d;
        if (r14 != 0) {
            Iterator it2 = r14.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (((m8.b) next).f11240a.intValue() == j.u0(m8.e.f11250b)) {
                    break;
                }
            }
            m8.b bVar2 = (m8.b) next;
            if (bVar2 != null && (r12 = bVar2.f) != 0) {
                Iterator it3 = r12.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next3 = it3.next();
                    if (((m8.c) next3).f11245b.intValue() == dVar.f10088a) {
                        obj = next3;
                        break;
                    }
                }
                cVar = (m8.c) obj;
            }
        }
        if (cVar == null) {
            return;
        }
        cVar.f11247d = hVar.f965b;
    }

    @Override // l9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        h hVar = (h) new ViewModelProvider(viewModelStore, new i(0)).get(h.class);
        this.f1806z = hVar;
        if (hVar != null) {
            hVar.b(m8.e.f11249a);
        } else {
            l.i("viewModel");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_mspa_options, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Iterable, java.lang.Object] */
    @Override // l9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        ArrayList arrayList;
        view.getClass();
        super.onViewCreated(view, bundle);
        TextView textView = this.f11096b;
        if (textView != null) {
            textView.setText(getString(R.string.ccpa_privacy_title));
        }
        this.f1795m = (TextView) view.findViewById(R.id.tv_purposes_label1);
        this.f1800r = (RecyclerView) view.findViewById(R.id.rv_purposes_list);
        this.f1796n = (TextView) view.findViewById(R.id.tv_sensitive_purposes);
        this.f1797o = (TextView) view.findViewById(R.id.tv_child_sensitive_purposes);
        this.f1798p = (Button) view.findViewById(R.id.btn_save_and_exit);
        this.f1799q = (Button) view.findViewById(R.id.btn_agree_to_all);
        this.f1801s = (RecyclerView) view.findViewById(R.id.rv_sensitive_purposes_list);
        this.t = (RecyclerView) view.findViewById(R.id.rv_child_sensitive_purposes_list);
        this.f1802u = (FrameLayout) view.findViewById(R.id.gbc_fragment_container);
        this.f1803v = (ConstraintLayout) view.findViewById(R.id.mspa_options_container);
        this.f1804w = view.findViewById(R.id.purposes_divider);
        this.f1805x = view.findViewById(R.id.sensitive_purposes_divider);
        this.y = view.findViewById(R.id.child_sensitive_purposes_divider);
        ImageView imageView = this.f11097c;
        final int i10 = 0;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: c6.d

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f f1792b;

                {
                    this.f1792b = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v16, types: [t6.t] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ArrayList arrayList2;
                    ArrayList arrayList3;
                    int i11;
                    ArrayList arrayList4;
                    ArrayList arrayList5;
                    ArrayList arrayList6;
                    int i12 = i10;
                    ArrayList arrayList7 = null;
                    final int i13 = 0;
                    final f fVar = this.f1792b;
                    switch (i12) {
                        case 0:
                            fVar.dismiss();
                            return;
                        case 1:
                            if (j.g.f9878a) {
                                Fragment fragmentFindFragmentByTag = fVar.getChildFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
                                j.d dVar = fragmentFindFragmentByTag instanceof j.d ? (j.d) fragmentFindFragmentByTag : null;
                                if (dVar != null) {
                                    dVar.a();
                                }
                            }
                            h hVar = fVar.f1806z;
                            if (hVar == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            RecyclerView recyclerView = fVar.f1800r;
                            RecyclerView.Adapter adapter = recyclerView == null ? null : recyclerView.getAdapter();
                            c.g gVar = adapter instanceof c.g ? (c.g) adapter : null;
                            if (gVar == null || (arrayList6 = gVar.f958a) == null) {
                                arrayList2 = null;
                            } else {
                                arrayList2 = new ArrayList(n.V(arrayList6, 10));
                                int size = arrayList6.size();
                                int i14 = 0;
                                while (i14 < size) {
                                    Object obj = arrayList6.get(i14);
                                    i14++;
                                    arrayList2.add(((c.h) obj).f965b);
                                }
                            }
                            RecyclerView recyclerView2 = fVar.f1801s;
                            RecyclerView.Adapter adapter2 = recyclerView2 == null ? null : recyclerView2.getAdapter();
                            c.g gVar2 = adapter2 instanceof c.g ? (c.g) adapter2 : null;
                            if (gVar2 == null || (arrayList5 = gVar2.f958a) == null) {
                                arrayList3 = null;
                            } else {
                                arrayList3 = new ArrayList(n.V(arrayList5, 10));
                                int size2 = arrayList5.size();
                                int i15 = 0;
                                while (i15 < size2) {
                                    Object obj2 = arrayList5.get(i15);
                                    i15++;
                                    arrayList3.add(((c.h) obj2).f965b);
                                }
                            }
                            RecyclerView recyclerView3 = fVar.t;
                            RecyclerView.Adapter adapter3 = recyclerView3 == null ? null : recyclerView3.getAdapter();
                            c.g gVar3 = adapter3 instanceof c.g ? (c.g) adapter3 : null;
                            if (gVar3 != null && (arrayList4 = gVar3.f958a) != null) {
                                arrayList7 = new ArrayList(n.V(arrayList4, 10));
                                int size3 = arrayList4.size();
                                int i16 = 0;
                                while (i16 < size3) {
                                    Object obj3 = arrayList4.get(i16);
                                    i16++;
                                    arrayList7.add(((c.h) obj3).f965b);
                                }
                            }
                            ?? r12 = t.f12808a;
                            if (arrayList2 == null) {
                                arrayList2 = r12;
                            }
                            if (arrayList3 == null) {
                                arrayList3 = r12;
                            }
                            ArrayList arrayListL0 = t6.l.l0(arrayList3, arrayList2);
                            if (arrayList7 == null) {
                                arrayList7 = r12;
                            }
                            ArrayList arrayListL02 = t6.l.l0(arrayList7, arrayListL0);
                            hVar.c();
                            o8.c cVar = i9.a.h().f11814b;
                            String str = cVar.U;
                            if (str != null) {
                                i9.a.j().p(86, str);
                            }
                            i9.a.j().p(87, cVar.f11788o);
                            i9.a.j().q(88, j.g.f9878a);
                            final int i17 = 1;
                            if (arrayListL02.isEmpty()) {
                                i11 = 1;
                            } else {
                                int size4 = arrayListL02.size();
                                int i18 = 0;
                                while (i18 < size4) {
                                    Object obj4 = arrayListL02.get(i18);
                                    i18++;
                                    if (!l.a((Boolean) obj4, Boolean.FALSE)) {
                                        if (arrayListL02.isEmpty()) {
                                            i11 = 3;
                                        } else {
                                            int size5 = arrayListL02.size();
                                            while (i13 < size5) {
                                                Object obj5 = arrayListL02.get(i13);
                                                i13++;
                                                if (!l.a((Boolean) obj5, Boolean.TRUE)) {
                                                    i11 = 2;
                                                }
                                            }
                                            i11 = 3;
                                        }
                                    }
                                }
                                i11 = 1;
                            }
                            s.b(5, i11).observe(fVar, new Observer() { // from class: c6.e
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj6) {
                                    switch (i17) {
                                        case 0:
                                            f fVar2 = fVar;
                                            fVar2.dismiss();
                                            FragmentActivity activity = fVar2.getActivity();
                                            if (activity != null) {
                                                activity.finish();
                                                break;
                                            }
                                            break;
                                        default:
                                            f fVar3 = fVar;
                                            fVar3.dismiss();
                                            FragmentActivity activity2 = fVar3.getActivity();
                                            if (activity2 != null) {
                                                activity2.finish();
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        default:
                            h hVar2 = fVar.f1806z;
                            if (hVar2 != null) {
                                hVar2.a().observe(fVar, new Observer() { // from class: c6.e
                                    @Override // androidx.lifecycle.Observer
                                    public final void onChanged(Object obj6) {
                                        switch (i13) {
                                            case 0:
                                                f fVar2 = fVar;
                                                fVar2.dismiss();
                                                FragmentActivity activity = fVar2.getActivity();
                                                if (activity != null) {
                                                    activity.finish();
                                                    break;
                                                }
                                                break;
                                            default:
                                                f fVar3 = fVar;
                                                fVar3.dismiss();
                                                FragmentActivity activity2 = fVar3.getActivity();
                                                if (activity2 != null) {
                                                    activity2.finish();
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                });
                                return;
                            } else {
                                l.i("viewModel");
                                throw null;
                            }
                    }
                }
            });
        }
        h hVar = this.f1806z;
        if (hVar == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList arrayListB = hVar.b(m8.e.f11249a);
        if (arrayListB.isEmpty()) {
            TextView textView2 = this.f1795m;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            RecyclerView recyclerView = this.f1800r;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            View view2 = this.f1804w;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            RecyclerView recyclerView2 = this.f1800r;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(a(arrayListB));
            }
            TextView textView3 = this.f1795m;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            RecyclerView recyclerView3 = this.f1800r;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(0);
            }
            View view3 = this.f1804w;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
        h hVar2 = this.f1806z;
        if (hVar2 == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList arrayList2 = new ArrayList();
        ?? r12 = hVar2.f1809a.f11239d;
        if (r12 == 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : r12) {
                if (j.f0(m8.e.f11250b, ((m8.b) obj).f11240a.intValue())) {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj2 = arrayList.get(i11);
                i11++;
                ?? r10 = ((m8.b) obj2).f;
                if (r10 != 0) {
                    for (m8.c cVar : r10) {
                        int iIntValue = cVar.f11245b.intValue();
                        String str = cVar.e;
                        if (str == null) {
                            str = "";
                        }
                        arrayList2.add(new c.h(new k8.d(iIntValue, str), cVar.f11247d, 0, 12, null, null, androidx.constraintlayout.widget.R.styleable.ConstraintSet_pathMotionArc));
                    }
                }
            }
        }
        if (arrayList2.isEmpty()) {
            TextView textView4 = this.f1796n;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            RecyclerView recyclerView4 = this.f1801s;
            if (recyclerView4 != null) {
                recyclerView4.setVisibility(8);
            }
            View view4 = this.f1805x;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        } else {
            RecyclerView recyclerView5 = this.f1801s;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(a(arrayList2));
            }
            TextView textView5 = this.f1796n;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            RecyclerView recyclerView6 = this.f1801s;
            if (recyclerView6 != null) {
                recyclerView6.setVisibility(0);
            }
            View view5 = this.f1805x;
            if (view5 != null) {
                view5.setVisibility(0);
            }
        }
        h hVar3 = this.f1806z;
        if (hVar3 == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList arrayListB2 = hVar3.b(m8.e.f11251c);
        if (arrayListB2.isEmpty()) {
            TextView textView6 = this.f1797o;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            RecyclerView recyclerView7 = this.t;
            if (recyclerView7 != null) {
                recyclerView7.setVisibility(8);
            }
            View view6 = this.y;
            if (view6 != null) {
                view6.setVisibility(8);
            }
        } else {
            RecyclerView recyclerView8 = this.t;
            if (recyclerView8 != null) {
                recyclerView8.setAdapter(a(arrayListB2));
            }
            TextView textView7 = this.f1797o;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            RecyclerView recyclerView9 = this.t;
            if (recyclerView9 != null) {
                recyclerView9.setVisibility(0);
            }
            View view7 = this.y;
            if (view7 != null) {
                view7.setVisibility(0);
            }
        }
        final int i12 = 1;
        if (j.g.f9878a) {
            getChildFragmentManager().beginTransaction().add(R.id.gbc_fragment_container, new j.d(), DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D).addToBackStack(null).commit();
            FrameLayout frameLayout = this.f1802u;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            if (this.f1806z == null) {
                l.i("viewModel");
                throw null;
            }
            if (j.g.f9878a) {
                i9.a.j().q(92, true);
            }
        } else {
            FrameLayout frameLayout2 = this.f1802u;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        Button button = this.f1798p;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener(this) { // from class: c6.d

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f f1792b;

                {
                    this.f1792b = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v16, types: [t6.t] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view22) {
                    ArrayList arrayList22;
                    ArrayList arrayList3;
                    int i112;
                    ArrayList arrayList4;
                    ArrayList arrayList5;
                    ArrayList arrayList6;
                    int i122 = i12;
                    ArrayList arrayList7 = null;
                    final int i13 = 0;
                    final f fVar = this.f1792b;
                    switch (i122) {
                        case 0:
                            fVar.dismiss();
                            return;
                        case 1:
                            if (j.g.f9878a) {
                                Fragment fragmentFindFragmentByTag = fVar.getChildFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
                                j.d dVar = fragmentFindFragmentByTag instanceof j.d ? (j.d) fragmentFindFragmentByTag : null;
                                if (dVar != null) {
                                    dVar.a();
                                }
                            }
                            h hVar4 = fVar.f1806z;
                            if (hVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            RecyclerView recyclerView10 = fVar.f1800r;
                            RecyclerView.Adapter adapter = recyclerView10 == null ? null : recyclerView10.getAdapter();
                            c.g gVar = adapter instanceof c.g ? (c.g) adapter : null;
                            if (gVar == null || (arrayList6 = gVar.f958a) == null) {
                                arrayList22 = null;
                            } else {
                                arrayList22 = new ArrayList(n.V(arrayList6, 10));
                                int size2 = arrayList6.size();
                                int i14 = 0;
                                while (i14 < size2) {
                                    Object obj3 = arrayList6.get(i14);
                                    i14++;
                                    arrayList22.add(((c.h) obj3).f965b);
                                }
                            }
                            RecyclerView recyclerView22 = fVar.f1801s;
                            RecyclerView.Adapter adapter2 = recyclerView22 == null ? null : recyclerView22.getAdapter();
                            c.g gVar2 = adapter2 instanceof c.g ? (c.g) adapter2 : null;
                            if (gVar2 == null || (arrayList5 = gVar2.f958a) == null) {
                                arrayList3 = null;
                            } else {
                                arrayList3 = new ArrayList(n.V(arrayList5, 10));
                                int size22 = arrayList5.size();
                                int i15 = 0;
                                while (i15 < size22) {
                                    Object obj22 = arrayList5.get(i15);
                                    i15++;
                                    arrayList3.add(((c.h) obj22).f965b);
                                }
                            }
                            RecyclerView recyclerView32 = fVar.t;
                            RecyclerView.Adapter adapter3 = recyclerView32 == null ? null : recyclerView32.getAdapter();
                            c.g gVar3 = adapter3 instanceof c.g ? (c.g) adapter3 : null;
                            if (gVar3 != null && (arrayList4 = gVar3.f958a) != null) {
                                arrayList7 = new ArrayList(n.V(arrayList4, 10));
                                int size3 = arrayList4.size();
                                int i16 = 0;
                                while (i16 < size3) {
                                    Object obj32 = arrayList4.get(i16);
                                    i16++;
                                    arrayList7.add(((c.h) obj32).f965b);
                                }
                            }
                            ?? r122 = t.f12808a;
                            if (arrayList22 == null) {
                                arrayList22 = r122;
                            }
                            if (arrayList3 == null) {
                                arrayList3 = r122;
                            }
                            ArrayList arrayListL0 = t6.l.l0(arrayList3, arrayList22);
                            if (arrayList7 == null) {
                                arrayList7 = r122;
                            }
                            ArrayList arrayListL02 = t6.l.l0(arrayList7, arrayListL0);
                            hVar4.c();
                            o8.c cVar2 = i9.a.h().f11814b;
                            String str2 = cVar2.U;
                            if (str2 != null) {
                                i9.a.j().p(86, str2);
                            }
                            i9.a.j().p(87, cVar2.f11788o);
                            i9.a.j().q(88, j.g.f9878a);
                            final int i17 = 1;
                            if (arrayListL02.isEmpty()) {
                                i112 = 1;
                            } else {
                                int size4 = arrayListL02.size();
                                int i18 = 0;
                                while (i18 < size4) {
                                    Object obj4 = arrayListL02.get(i18);
                                    i18++;
                                    if (!l.a((Boolean) obj4, Boolean.FALSE)) {
                                        if (arrayListL02.isEmpty()) {
                                            i112 = 3;
                                        } else {
                                            int size5 = arrayListL02.size();
                                            while (i13 < size5) {
                                                Object obj5 = arrayListL02.get(i13);
                                                i13++;
                                                if (!l.a((Boolean) obj5, Boolean.TRUE)) {
                                                    i112 = 2;
                                                }
                                            }
                                            i112 = 3;
                                        }
                                    }
                                }
                                i112 = 1;
                            }
                            s.b(5, i112).observe(fVar, new Observer() { // from class: c6.e
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj6) {
                                    switch (i17) {
                                        case 0:
                                            f fVar2 = fVar;
                                            fVar2.dismiss();
                                            FragmentActivity activity = fVar2.getActivity();
                                            if (activity != null) {
                                                activity.finish();
                                                break;
                                            }
                                            break;
                                        default:
                                            f fVar3 = fVar;
                                            fVar3.dismiss();
                                            FragmentActivity activity2 = fVar3.getActivity();
                                            if (activity2 != null) {
                                                activity2.finish();
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        default:
                            h hVar22 = fVar.f1806z;
                            if (hVar22 != null) {
                                hVar22.a().observe(fVar, new Observer() { // from class: c6.e
                                    @Override // androidx.lifecycle.Observer
                                    public final void onChanged(Object obj6) {
                                        switch (i13) {
                                            case 0:
                                                f fVar2 = fVar;
                                                fVar2.dismiss();
                                                FragmentActivity activity = fVar2.getActivity();
                                                if (activity != null) {
                                                    activity.finish();
                                                    break;
                                                }
                                                break;
                                            default:
                                                f fVar3 = fVar;
                                                fVar3.dismiss();
                                                FragmentActivity activity2 = fVar3.getActivity();
                                                if (activity2 != null) {
                                                    activity2.finish();
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                });
                                return;
                            } else {
                                l.i("viewModel");
                                throw null;
                            }
                    }
                }
            });
        }
        Button button2 = this.f1799q;
        final int i13 = 2;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: c6.d

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ f f1792b;

                {
                    this.f1792b = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v16, types: [t6.t] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view22) {
                    ArrayList arrayList22;
                    ArrayList arrayList3;
                    int i112;
                    ArrayList arrayList4;
                    ArrayList arrayList5;
                    ArrayList arrayList6;
                    int i122 = i13;
                    ArrayList arrayList7 = null;
                    final int i132 = 0;
                    final f fVar = this.f1792b;
                    switch (i122) {
                        case 0:
                            fVar.dismiss();
                            return;
                        case 1:
                            if (j.g.f9878a) {
                                Fragment fragmentFindFragmentByTag = fVar.getChildFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D);
                                j.d dVar = fragmentFindFragmentByTag instanceof j.d ? (j.d) fragmentFindFragmentByTag : null;
                                if (dVar != null) {
                                    dVar.a();
                                }
                            }
                            h hVar4 = fVar.f1806z;
                            if (hVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            RecyclerView recyclerView10 = fVar.f1800r;
                            RecyclerView.Adapter adapter = recyclerView10 == null ? null : recyclerView10.getAdapter();
                            c.g gVar = adapter instanceof c.g ? (c.g) adapter : null;
                            if (gVar == null || (arrayList6 = gVar.f958a) == null) {
                                arrayList22 = null;
                            } else {
                                arrayList22 = new ArrayList(n.V(arrayList6, 10));
                                int size2 = arrayList6.size();
                                int i14 = 0;
                                while (i14 < size2) {
                                    Object obj3 = arrayList6.get(i14);
                                    i14++;
                                    arrayList22.add(((c.h) obj3).f965b);
                                }
                            }
                            RecyclerView recyclerView22 = fVar.f1801s;
                            RecyclerView.Adapter adapter2 = recyclerView22 == null ? null : recyclerView22.getAdapter();
                            c.g gVar2 = adapter2 instanceof c.g ? (c.g) adapter2 : null;
                            if (gVar2 == null || (arrayList5 = gVar2.f958a) == null) {
                                arrayList3 = null;
                            } else {
                                arrayList3 = new ArrayList(n.V(arrayList5, 10));
                                int size22 = arrayList5.size();
                                int i15 = 0;
                                while (i15 < size22) {
                                    Object obj22 = arrayList5.get(i15);
                                    i15++;
                                    arrayList3.add(((c.h) obj22).f965b);
                                }
                            }
                            RecyclerView recyclerView32 = fVar.t;
                            RecyclerView.Adapter adapter3 = recyclerView32 == null ? null : recyclerView32.getAdapter();
                            c.g gVar3 = adapter3 instanceof c.g ? (c.g) adapter3 : null;
                            if (gVar3 != null && (arrayList4 = gVar3.f958a) != null) {
                                arrayList7 = new ArrayList(n.V(arrayList4, 10));
                                int size3 = arrayList4.size();
                                int i16 = 0;
                                while (i16 < size3) {
                                    Object obj32 = arrayList4.get(i16);
                                    i16++;
                                    arrayList7.add(((c.h) obj32).f965b);
                                }
                            }
                            ?? r122 = t.f12808a;
                            if (arrayList22 == null) {
                                arrayList22 = r122;
                            }
                            if (arrayList3 == null) {
                                arrayList3 = r122;
                            }
                            ArrayList arrayListL0 = t6.l.l0(arrayList3, arrayList22);
                            if (arrayList7 == null) {
                                arrayList7 = r122;
                            }
                            ArrayList arrayListL02 = t6.l.l0(arrayList7, arrayListL0);
                            hVar4.c();
                            o8.c cVar2 = i9.a.h().f11814b;
                            String str2 = cVar2.U;
                            if (str2 != null) {
                                i9.a.j().p(86, str2);
                            }
                            i9.a.j().p(87, cVar2.f11788o);
                            i9.a.j().q(88, j.g.f9878a);
                            final int i17 = 1;
                            if (arrayListL02.isEmpty()) {
                                i112 = 1;
                            } else {
                                int size4 = arrayListL02.size();
                                int i18 = 0;
                                while (i18 < size4) {
                                    Object obj4 = arrayListL02.get(i18);
                                    i18++;
                                    if (!l.a((Boolean) obj4, Boolean.FALSE)) {
                                        if (arrayListL02.isEmpty()) {
                                            i112 = 3;
                                        } else {
                                            int size5 = arrayListL02.size();
                                            while (i132 < size5) {
                                                Object obj5 = arrayListL02.get(i132);
                                                i132++;
                                                if (!l.a((Boolean) obj5, Boolean.TRUE)) {
                                                    i112 = 2;
                                                }
                                            }
                                            i112 = 3;
                                        }
                                    }
                                }
                                i112 = 1;
                            }
                            s.b(5, i112).observe(fVar, new Observer() { // from class: c6.e
                                @Override // androidx.lifecycle.Observer
                                public final void onChanged(Object obj6) {
                                    switch (i17) {
                                        case 0:
                                            f fVar2 = fVar;
                                            fVar2.dismiss();
                                            FragmentActivity activity = fVar2.getActivity();
                                            if (activity != null) {
                                                activity.finish();
                                                break;
                                            }
                                            break;
                                        default:
                                            f fVar3 = fVar;
                                            fVar3.dismiss();
                                            FragmentActivity activity2 = fVar3.getActivity();
                                            if (activity2 != null) {
                                                activity2.finish();
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            return;
                        default:
                            h hVar22 = fVar.f1806z;
                            if (hVar22 != null) {
                                hVar22.a().observe(fVar, new Observer() { // from class: c6.e
                                    @Override // androidx.lifecycle.Observer
                                    public final void onChanged(Object obj6) {
                                        switch (i132) {
                                            case 0:
                                                f fVar2 = fVar;
                                                fVar2.dismiss();
                                                FragmentActivity activity = fVar2.getActivity();
                                                if (activity != null) {
                                                    activity.finish();
                                                    break;
                                                }
                                                break;
                                            default:
                                                f fVar3 = fVar;
                                                fVar3.dismiss();
                                                FragmentActivity activity2 = fVar3.getActivity();
                                                if (activity2 != null) {
                                                    activity2.finish();
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                });
                                return;
                            } else {
                                l.i("viewModel");
                                throw null;
                            }
                    }
                }
            });
        }
        d9.d dVar = this.f11100j;
        if (dVar != null) {
            Integer num = dVar.g;
            if (num != null) {
                int iIntValue2 = num.intValue();
                ConstraintLayout constraintLayout = this.f1803v;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(iIntValue2);
                }
            }
            Integer num2 = dVar.f7475i;
            if (num2 != null) {
                int iIntValue3 = num2.intValue();
                TextView textView8 = this.f1795m;
                if (textView8 != null) {
                    textView8.setTextColor(iIntValue3);
                }
                TextView textView9 = this.f1796n;
                if (textView9 != null) {
                    textView9.setTextColor(iIntValue3);
                }
                TextView textView10 = this.f1797o;
                if (textView10 != null) {
                    textView10.setTextColor(iIntValue3);
                }
            }
            Integer num3 = dVar.f7479m;
            if (num3 != null) {
                int iIntValue4 = num3.intValue();
                Button button3 = this.f1798p;
                if (button3 != null) {
                    button3.setTextColor(iIntValue4);
                }
                Button button4 = this.f1799q;
                if (button4 != null) {
                    button4.setTextColor(iIntValue4);
                }
            }
            Integer num4 = dVar.f7481o;
            if (num4 != null) {
                int iIntValue5 = num4.intValue();
                Button button5 = this.f1798p;
                if (button5 != null) {
                    button5.setBackgroundTintList(ColorStateList.valueOf(iIntValue5));
                }
                Button button6 = this.f1799q;
                if (button6 != null) {
                    button6.setBackgroundTintList(ColorStateList.valueOf(iIntValue5));
                }
            }
        }
        Typeface typeface = this.f11101k;
        if (typeface != null) {
            TextView textView11 = this.f1795m;
            if (textView11 != null) {
                textView11.setTypeface(typeface);
            }
            TextView textView12 = this.f1796n;
            if (textView12 != null) {
                textView12.setTypeface(typeface);
            }
            TextView textView13 = this.f1797o;
            if (textView13 != null) {
                textView13.setTypeface(typeface);
            }
        }
        Typeface typeface2 = this.f11102l;
        if (typeface2 != null) {
            Button button7 = this.f1798p;
            if (button7 != null) {
                button7.setTypeface(typeface2);
            }
            Button button8 = this.f1799q;
            if (button8 != null) {
                button8.setTypeface(typeface2);
            }
        }
        h hVar4 = this.f1806z;
        if (hVar4 == null) {
            l.i("viewModel");
            throw null;
        }
        w viewModelScope = ViewModelKt.getViewModelScope(hVar4);
        y7.e eVar = i0.f12407a;
        y.q(viewModelScope, y7.d.f14116a, null, new a6.c(hVar4, null, 7), 2);
    }

    @Override // c.b
    public final void g(c.h hVar) {
    }
}
