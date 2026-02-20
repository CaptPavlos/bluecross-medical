package n4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Iterator;
import l4.f5;
import y5.d2;
import y5.n1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.j f11353a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.a f11354b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.m f11355c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11356d;
    public ArrayList e;
    public int f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f11357i;

    /* renamed from: j, reason: collision with root package name */
    public int f11358j;

    /* renamed from: k, reason: collision with root package name */
    public int f11359k;

    /* renamed from: l, reason: collision with root package name */
    public final int f11360l;

    /* renamed from: m, reason: collision with root package name */
    public int f11361m;

    /* renamed from: n, reason: collision with root package name */
    public int f11362n;

    public h(g5.j jVar, g5.a aVar, g5.m mVar, String str) {
        jVar.getClass();
        aVar.getClass();
        mVar.getClass();
        this.f11353a = jVar;
        this.f11354b = aVar;
        this.f11355c = mVar;
        this.f11356d = str;
        this.e = new ArrayList();
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.f11357i = -1;
        this.f11358j = -1;
        this.f11359k = -1;
        this.f11360l = -1;
        this.f11361m = -1;
        this.f11362n = -1;
    }

    public final void a(ArrayList arrayList, int i10) {
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            h5.x0 x0Var = (h5.x0) next;
            if (x0Var.f8788a.f8632a == i10) {
                b(x0Var);
                arrayList.remove(x0Var);
                return;
            }
        }
    }

    public final void b(h5.x0 x0Var) {
        if (x0Var != null) {
            g gVar = new g();
            gVar.f11345a = x0Var;
            gVar.f11346b = x0Var.f8790c;
            this.e.add(gVar);
            notifyItemInserted(this.e.size() - 1);
        }
    }

    public final void c(h5.x0 x0Var, int i10) {
        if (i10 < 0 || i10 >= this.e.size()) {
            return;
        }
        g gVar = new g();
        gVar.f11345a = x0Var;
        gVar.f11346b = x0Var.f8790c;
        this.e.set(i10, gVar);
        notifyItemChanged(i10);
    }

    public final void d(String str, RecyclerView recyclerView) {
        str.getClass();
        recyclerView.getClass();
        int size = this.e.size();
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i10);
            Object obj = null;
            if (viewHolderFindViewHolderForAdapterPosition instanceof y5.c0) {
                t0 t0Var = ((y5.c0) viewHolderFindViewHolderForAdapterPosition).f13830d;
                ArrayList arrayList = t0Var.f11489d;
                int size2 = arrayList.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size2) {
                        break;
                    }
                    Object obj2 = arrayList.get(i11);
                    i11++;
                    if (kotlin.jvm.internal.l.a(((h5.h) obj2).f8595w, str)) {
                        obj = obj2;
                        break;
                    }
                }
                t0Var.notifyItemChanged(t6.l.e0(t0Var.f11489d, (h5.h) obj));
            } else if (viewHolderFindViewHolderForAdapterPosition instanceof y5.b0) {
                r0 r0Var = ((y5.b0) viewHolderFindViewHolderForAdapterPosition).f13814d;
                ArrayList arrayList2 = r0Var.f11474c;
                int size3 = arrayList2.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size3) {
                        break;
                    }
                    Object obj3 = arrayList2.get(i12);
                    i12++;
                    if (kotlin.jvm.internal.l.a(((h5.h) obj3).f8595w, str)) {
                        obj = obj3;
                        break;
                    }
                }
                r0Var.notifyItemChanged(t6.l.e0(r0Var.f11474c, (h5.h) obj));
            } else if (viewHolderFindViewHolderForAdapterPosition instanceof y5.j0) {
                if (kotlin.jvm.internal.l.a(((y5.j0) viewHolderFindViewHolderForAdapterPosition).f13901l, str)) {
                    notifyItemChanged(this.h);
                }
            } else if (viewHolderFindViewHolderForAdapterPosition instanceof d2) {
                k1 k1Var = ((d2) viewHolderFindViewHolderForAdapterPosition).e;
                ArrayList arrayList3 = k1Var.e;
                int size4 = arrayList3.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size4) {
                        break;
                    }
                    Object obj4 = arrayList3.get(i13);
                    i13++;
                    if (kotlin.jvm.internal.l.a(((h5.h) obj4).f8595w, str)) {
                        obj = obj4;
                        break;
                    }
                }
                k1Var.notifyItemChanged(t6.l.e0(k1Var.e, (h5.h) obj));
            } else if (viewHolderFindViewHolderForAdapterPosition instanceof n1) {
                m mVar = ((n1) viewHolderFindViewHolderForAdapterPosition).f13951d;
                ArrayList arrayList4 = mVar.f11432c;
                int size5 = arrayList4.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size5) {
                        break;
                    }
                    Object obj5 = arrayList4.get(i14);
                    i14++;
                    if (kotlin.jvm.internal.l.a(((h5.h) obj5).f8595w, str)) {
                        obj = obj5;
                        break;
                    }
                }
                mVar.notifyItemChanged(t6.l.e0(mVar.f11432c, (h5.h) obj));
            } else if (viewHolderFindViewHolderForAdapterPosition instanceof y5.e0) {
                n nVar = ((y5.e0) viewHolderFindViewHolderForAdapterPosition).e;
                ArrayList arrayList5 = nVar.f11440c;
                int size6 = arrayList5.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size6) {
                        break;
                    }
                    Object obj6 = arrayList5.get(i15);
                    i15++;
                    if (kotlin.jvm.internal.l.a(((h5.h) obj6).f8595w, str)) {
                        obj = obj6;
                        break;
                    }
                }
                nVar.notifyItemChanged(t6.l.e0(nVar.f11440c, (h5.h) obj));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        g gVar = (g) this.e.get(i10);
        if (gVar != null) {
            return gVar.f11346b;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        Object objA;
        viewHolder.getClass();
        if (viewHolder instanceof y5.l) {
            return;
        }
        int i11 = 0;
        if (viewHolder instanceof y5.a0) {
            y5.a0 a0Var = (y5.a0) viewHolder;
            g gVar = (g) this.e.get(i10);
            Object objA2 = gVar != null ? gVar.a() : null;
            objA2.getClass();
            f fVar = (f) objA2;
            ViewGroup viewGroup = a0Var.e;
            RecyclerView recyclerView = a0Var.f13800c;
            TextView textView = a0Var.f13799b;
            String str = fVar.f11338c;
            if (str == null) {
                kotlin.jvm.internal.l.i(CampaignEx.JSON_KEY_TITLE);
                throw null;
            }
            textView.setText(str);
            ArrayList arrayList = fVar.f11336a;
            if (arrayList == null) {
                kotlin.jvm.internal.l.i("homeFeatures");
                throw null;
            }
            if (!arrayList.isEmpty()) {
                recyclerView.scrollToPosition(a0Var.h);
                recyclerView.smoothScrollBy(1, 0);
                j jVar = a0Var.f13801d;
                ArrayList arrayList2 = fVar.f11336a;
                if (arrayList2 == null) {
                    kotlin.jvm.internal.l.i("homeFeatures");
                    throw null;
                }
                jVar.getClass();
                ArrayList arrayList3 = jVar.f11383c;
                arrayList3.clear();
                arrayList3.addAll(arrayList2);
                jVar.notifyDataSetChanged();
            }
            if (viewGroup.getChildCount() == 0) {
                ArrayList arrayList4 = fVar.f11337b;
                if (arrayList4 == null) {
                    kotlin.jvm.internal.l.i("categories");
                    throw null;
                }
                Iterator it = arrayList4.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    h5.k kVar = (h5.k) next;
                    View viewInflate = LayoutInflater.from(a0Var.itemView.getContext()).inflate(R.layout.chip_category, viewGroup, false);
                    viewInflate.getClass();
                    TextView textView2 = (TextView) viewInflate;
                    textView2.setTypeface(o4.b.f11719r);
                    textView2.setText(kVar.f8633b);
                    if (kVar.equals(t6.l.i0(arrayList4))) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins((int) a0Var.itemView.getContext().getResources().getDimension(R.dimen.margin_m), 0, (int) a0Var.itemView.getContext().getResources().getDimension(R.dimen.margin_m), 0);
                        textView2.setLayoutParams(layoutParams);
                    }
                    textView2.setOnClickListener(new f5(25, a0Var, kVar));
                    viewGroup.addView(textView2);
                }
                return;
            }
            return;
        }
        int i12 = 8;
        if (viewHolder instanceof y5.c0) {
            g gVar2 = (g) this.e.get(i10);
            if ((gVar2 != null ? gVar2.a() : null) instanceof h5.x0) {
                y5.c0 c0Var = (y5.c0) viewHolder;
                g gVar3 = (g) this.e.get(i10);
                objA = gVar3 != null ? gVar3.a() : null;
                objA.getClass();
                h5.x0 x0Var = (h5.x0) objA;
                if (x0Var.f8789b.isEmpty()) {
                    c0Var.itemView.setVisibility(8);
                    return;
                }
                c0Var.f13828b.setOnClickListener(new f5(27, c0Var, x0Var));
                c0Var.f13829c.setText(x0Var.f8788a.f8633b);
                c0Var.f13830d.a(x0Var.f8789b);
                return;
            }
            return;
        }
        if (viewHolder instanceof y5.b0) {
            g gVar4 = (g) this.e.get(i10);
            if ((gVar4 != null ? gVar4.a() : null) instanceof h5.x0) {
                y5.b0 b0Var = (y5.b0) viewHolder;
                g gVar5 = (g) this.e.get(i10);
                objA = gVar5 != null ? gVar5.a() : null;
                objA.getClass();
                h5.x0 x0Var2 = (h5.x0) objA;
                b0Var.f13812b.setOnClickListener(new f5(26, b0Var, x0Var2));
                b0Var.f13813c.setText(x0Var2.f8788a.f8633b);
                r0 r0Var = b0Var.f13814d;
                ArrayList arrayList5 = x0Var2.f8789b;
                r0Var.getClass();
                arrayList5.getClass();
                ArrayList arrayList6 = r0Var.f11474c;
                arrayList6.clear();
                arrayList6.addAll(arrayList5);
                r0Var.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (viewHolder instanceof y5.j0) {
            y5.j0 j0Var = (y5.j0) viewHolder;
            g gVar6 = (g) this.e.get(i10);
            Object objA3 = gVar6 != null ? gVar6.a() : null;
            objA3.getClass();
            h5.h hVar = (h5.h) objA3;
            j0Var.f13901l = hVar.f8595w;
            View view = j0Var.itemView;
            view.getClass();
            view.setOnClickListener(new y5.i0(i11, j0Var, hVar));
            j0Var.itemView.setOnLongClickListener(new b5.c(i12, j0Var, hVar));
            j4.d0 d0VarE = j4.y.d().e(hVar.e());
            d0VarE.f(R.color.main_blue);
            float f = UptodownApp.E;
            Context context = j0Var.itemView.getContext();
            context.getClass();
            d0VarE.g(k4.c.x(context));
            d0VarE.e(j0Var.f, null);
            y5.f.f(hVar, j0Var.g, j0Var.h);
            j0Var.e(j0Var.e, hVar.i());
            j0Var.c(hVar, j0Var.f13897d, j0Var.e, j0Var.h, j0Var.f13899j, j0Var.f13898i, j0Var.f13900k);
            return;
        }
        if (viewHolder instanceof d2) {
            d2 d2Var = (d2) viewHolder;
            g gVar7 = (g) this.e.get(i10);
            objA = gVar7 != null ? gVar7.a() : null;
            objA.getClass();
            h5.x0 x0Var3 = (h5.x0) objA;
            d2Var.f13842b.setOnClickListener(new y5.i0(9, d2Var, x0Var3));
            d2Var.f13843c.setText(x0Var3.f8788a.f8633b);
            k1 k1Var = d2Var.e;
            ArrayList arrayList7 = x0Var3.f8789b;
            k1Var.getClass();
            arrayList7.getClass();
            ArrayList arrayList8 = k1Var.e;
            arrayList8.clear();
            arrayList8.addAll(arrayList7);
            return;
        }
        if (viewHolder instanceof n1) {
            n1 n1Var = (n1) viewHolder;
            g gVar8 = (g) this.e.get(i10);
            objA = gVar8 != null ? gVar8.a() : null;
            objA.getClass();
            h5.x0 x0Var4 = (h5.x0) objA;
            n1Var.f13949b.setOnClickListener(new y5.i0(6, n1Var, x0Var4));
            n1Var.f13950c.setText(x0Var4.f8788a.f8633b);
            boolean zA = kotlin.jvm.internal.l.a(x0Var4.f8788a.f8633b, n1Var.itemView.getContext().getResources().getString(R.string.top_downloads_title));
            m mVar = n1Var.f13951d;
            ArrayList arrayList9 = x0Var4.f8789b;
            if (zA) {
                mVar.getClass();
                arrayList9.getClass();
                mVar.f11433d = true;
                mVar.f11432c = arrayList9;
                mVar.notifyDataSetChanged();
                return;
            }
            mVar.getClass();
            arrayList9.getClass();
            mVar.f11433d = false;
            mVar.f11432c = arrayList9;
            mVar.notifyDataSetChanged();
            return;
        }
        if (!(viewHolder instanceof y5.e0)) {
            if (!(viewHolder instanceof y5.r)) {
                com.google.gson.internal.a.n("ViewHolder unknown!!");
                return;
            }
            y5.r rVar = (y5.r) viewHolder;
            g gVar9 = (g) this.e.get(i10);
            objA = gVar9 != null ? gVar9.a() : null;
            objA.getClass();
            rVar.a((ArrayList) objA);
            return;
        }
        y5.e0 e0Var = (y5.e0) viewHolder;
        g gVar10 = (g) this.e.get(i10);
        objA = gVar10 != null ? gVar10.a() : null;
        objA.getClass();
        h5.x0 x0Var5 = (h5.x0) objA;
        e0Var.f13850b.setOnClickListener(new f5(28, e0Var, x0Var5));
        e0Var.f13851c.setText(x0Var5.f8788a.f8633b);
        n nVar = e0Var.e;
        ArrayList arrayList10 = x0Var5.f8789b;
        nVar.getClass();
        arrayList10.getClass();
        ArrayList arrayList11 = nVar.f11440c;
        arrayList11.clear();
        arrayList11.addAll(arrayList10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        g5.a aVar = this.f11354b;
        g5.j jVar = this.f11353a;
        switch (i10) {
            case -1:
                return new y5.l(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.empty_view, viewGroup, false));
            case 0:
                return new y5.a0(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.home_fragment_header, viewGroup, false), jVar, aVar, this.f11355c);
            case 1:
                return new y5.c0(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.home_recycler_view_top, viewGroup, false), jVar, aVar);
            case 2:
            default:
                com.google.gson.internal.a.n("viewType unknown");
                return null;
            case 3:
                return new y5.j0(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.home_gallery_featured, viewGroup, false), jVar, aVar);
            case 4:
                return new d2(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.home_recycler_view_top, viewGroup, false), jVar, aVar, this.f11356d);
            case 5:
                return new n1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.home_recycler_view_top, viewGroup, false), jVar, aVar);
            case 6:
                View viewX = com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.home_recycler_view_top, viewGroup, false);
                jVar.getClass();
                aVar.getClass();
                y5.e0 e0Var = new y5.e0(viewX);
                e0Var.f13849a = jVar;
                View viewFindViewById = viewX.findViewById(R.id.rl_title_home_recycler_view_top);
                viewFindViewById.getClass();
                e0Var.f13850b = (RelativeLayout) viewFindViewById;
                View viewFindViewById2 = viewX.findViewById(R.id.tv_title_home_recycler_view_top);
                viewFindViewById2.getClass();
                TextView textView = (TextView) viewFindViewById2;
                e0Var.f13851c = textView;
                View viewFindViewById3 = viewX.findViewById(R.id.rv_home_recycler_view_top);
                viewFindViewById3.getClass();
                RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
                GridLayoutManager gridLayoutManager = new GridLayoutManager(viewX.getContext(), 3, 0, false);
                e0Var.f13852d = gridLayoutManager;
                n nVar = new n();
                nVar.f11438a = jVar;
                nVar.f11439b = aVar;
                nVar.f11440c = new ArrayList();
                e0Var.e = nVar;
                textView.setTypeface(o4.b.f11719r);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(nVar);
                recyclerView.setItemAnimator(null);
                recyclerView.addItemDecoration(new y5.d0(e0Var));
                return e0Var;
            case 7:
                return new y5.r(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.floating_categories, viewGroup, false), jVar);
            case 8:
                return new y5.b0(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.home_recycler_view_top, viewGroup, false), jVar, aVar);
        }
    }
}
