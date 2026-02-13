package n4;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import e5.v1;
import e5.w1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import y5.l1;
import y5.m1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.c f11452a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.d f11453b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.a f11454c;

    /* renamed from: d, reason: collision with root package name */
    public final w1 f11455d;
    public final String e;
    public final h5.w0 f;
    public final ArrayList g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f11456i;

    /* renamed from: j, reason: collision with root package name */
    public final g5.e f11457j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f11458k;

    /* renamed from: l, reason: collision with root package name */
    public int f11459l;

    public p0(g5.c cVar, g5.d dVar, g5.a aVar, w1 w1Var, String str, h5.w0 w0Var, ArrayList arrayList, String str2, boolean z9, v1 v1Var) {
        cVar.getClass();
        dVar.getClass();
        aVar.getClass();
        this.f11452a = cVar;
        this.f11453b = dVar;
        this.f11454c = aVar;
        this.f11455d = w1Var;
        this.e = str;
        this.f = w0Var;
        this.g = arrayList;
        this.h = str2;
        this.f11456i = z9;
        this.f11457j = v1Var;
        this.f11458k = new ArrayList();
    }

    public final void a(h5.x0 x0Var) {
        this.f11458k = new ArrayList();
        h5.k kVar = x0Var.f8788a;
        int i10 = kVar.f8632a;
        if (i10 == -3 || i10 == -2) {
            Iterator it = x0Var.f8789b.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                n0 n0Var = new n0();
                n0Var.f11441a = (h5.h) next;
                n0Var.f11442b = 0;
                n0Var.f11443c = 0;
                this.f11458k.add(n0Var);
            }
        } else {
            String str = kVar.f8634c;
            if (str != null && str.length() != 0) {
                n0 n0Var2 = new n0();
                n0Var2.f11442b = 5;
                this.f11458k.add(n0Var2);
                n0 n0Var3 = new n0();
                n0Var3.f11442b = 2;
                this.f11458k.add(n0Var3);
            }
            int i11 = 0;
            boolean z9 = false;
            for (h5.h hVar : x0Var.f8789b) {
                int i12 = i11 + 1;
                n0 n0Var4 = new n0();
                n0Var4.f11441a = hVar;
                if (i11 == 0 && hVar.m()) {
                    n0Var4.f11442b = 3;
                    z9 = true;
                } else if (i11 >= 10) {
                    n0Var4.f11442b = 0;
                } else if (x0Var.f8788a.f8632a == 1090) {
                    n0Var4.f11442b = 4;
                } else if (z9) {
                    if (i11 < 4) {
                        n0Var4.f11442b = 1;
                    }
                } else if (i11 < 3) {
                    n0Var4.f11442b = 1;
                }
                this.f11459l = i12;
                n0Var4.f11443c = i12;
                this.f11458k.add(n0Var4);
                i11 = i12;
            }
        }
        String str2 = x0Var.f8788a.f8634c;
        int i13 = (str2 == null || str2.length() == 0) ? 20 : 22;
        ArrayList arrayList = this.g;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        n0 n0Var5 = new n0();
        n0Var5.f11441a = arrayList;
        n0Var5.f11442b = 6;
        n0Var5.f11443c = 0;
        int size = this.f11458k.size();
        ArrayList arrayList2 = this.f11458k;
        if (size > i13) {
            arrayList2.add(i13, n0Var5);
        } else {
            arrayList2.add(n0Var5);
        }
    }

    public final void b(h5.h hVar) {
        hVar.getClass();
        Iterator it = this.f11458k.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int i11 = i10 + 1;
            Object obj = ((n0) it.next()).f11441a;
            if (obj instanceof h5.h) {
                obj.getClass();
                if (((h5.h) obj).f8566a == hVar.f8566a) {
                    notifyItemChanged(i10);
                    return;
                }
            }
            i10 = i11;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11458k.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        return ((n0) this.f11458k.get(i10)).f11442b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i10) {
        viewHolder.getClass();
        boolean z9 = viewHolder instanceof y5.j1;
        boolean z10 = this.f11456i;
        final int i11 = 1;
        if (z9) {
            Object obj = ((n0) this.f11458k.get(i10)).f11441a;
            obj.getClass();
            h5.h hVar = (h5.h) obj;
            if (z10) {
                ((y5.j1) viewHolder).g(hVar, ((n0) this.f11458k.get(i10)).f11443c - 1, i10);
                return;
            } else {
                ((y5.j1) viewHolder).g(hVar, ((n0) this.f11458k.get(i10)).f11443c, i10);
                return;
            }
        }
        if (!(viewHolder instanceof y5.h1)) {
            if (viewHolder instanceof y5.k1) {
                Object obj2 = ((n0) this.f11458k.get(i10)).f11441a;
                obj2.getClass();
                h5.h hVar2 = (h5.h) obj2;
                if (z10) {
                    ((y5.k1) viewHolder).g(hVar2, ((n0) this.f11458k.get(i10)).f11443c - 1);
                    return;
                } else {
                    ((y5.k1) viewHolder).g(hVar2, ((n0) this.f11458k.get(i10)).f11443c);
                    return;
                }
            }
            if ((viewHolder instanceof l1) || (viewHolder instanceof m1)) {
                return;
            }
            if (!(viewHolder instanceof y5.r)) {
                com.google.gson.internal.a.n("ViewHolder unknown!!");
                return;
            }
            Object obj3 = ((n0) this.f11458k.get(i10)).f11441a;
            obj3.getClass();
            ((y5.r) viewHolder).a((ArrayList) obj3);
            return;
        }
        final y5.h1 h1Var = (y5.h1) viewHolder;
        Object obj4 = ((n0) this.f11458k.get(i10)).f11441a;
        obj4.getClass();
        final h5.h hVar3 = (h5.h) obj4;
        int i12 = ((n0) this.f11458k.get(i10)).f11443c;
        ImageView imageView = h1Var.f;
        LinearLayout linearLayout = h1Var.f13881m;
        TextView textView = h1Var.f13877i;
        TextView textView2 = h1Var.f13878j;
        RelativeLayout relativeLayout = h1Var.e;
        relativeLayout.setOnLongClickListener(new b5.c(h1Var, hVar3, i10, 9));
        y5.f.b(relativeLayout, h1Var.f13874b, hVar3);
        TextView textView3 = h1Var.h;
        final int i13 = 0;
        if (textView3 != null) {
            textView3.setText(h1Var.itemView.getContext().getResources().getString(R.string.top_index_format, String.valueOf(i12)));
        }
        int i14 = hVar3.f8582p;
        if (i14 > 0 && hVar3.f8570i > 0) {
            TextView textView4 = h1Var.f13879k;
            if (textView4 != null) {
                textView4.setText(String.valueOf(i14 / 10.0d));
            }
            TextView textView5 = h1Var.f13880l;
            if (textView5 != null) {
                Context context = h1Var.itemView.getContext();
                long j10 = hVar3.f8570i;
                textView5.setText(context.getString(R.string.pre_registration_counter, j10 < 1000 ? String.valueOf(j10) : j10 < 1000000 ? String.format(Locale.getDefault(), "%dK", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j10) / 1000)}, 1)) : String.format(Locale.getDefault(), "%dM", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j10) / 1000000)}, 1))));
            }
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        h1Var.g.setText(hVar3.f8567b);
        String str = hVar3.f8580o;
        if (str == null || str.length() == 0) {
            textView.setText(hVar3.f8578n);
        } else {
            String str2 = hVar3.f8580o;
            str2.getClass();
            textView.setText(o7.u.b0(new o7.k("<(\\w+)>(.*?)</(\\w+)>").b(new o7.k("\\[(\\w+)=([\\w\\d]*)](.*?)\\[/(\\w+)]").b(new SpannableStringBuilder(str2), new a3.q(22)), new a3.q(23)), "<br />", "", false));
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: y5.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i13) {
                    case 0:
                        h1Var.f13875c.m(hVar3, i10);
                        break;
                    default:
                        h1Var.f13875c.m(hVar3, i10);
                        break;
                }
            }
        });
        h1Var.e(imageView, hVar3.h());
        a.a.x(h1Var.f13883o, imageView);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: y5.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i11) {
                    case 0:
                        h1Var.f13875c.m(hVar3, i10);
                        break;
                    default:
                        h1Var.f13875c.m(hVar3, i10);
                        break;
                }
            }
        });
        h1Var.f13882n.setVisibility(8);
        textView.setVisibility(0);
        textView2.setVisibility(0);
        if (h1Var.itemView.getContext() != null) {
            t3.h hVar4 = v5.g.f13148u;
            Context context2 = h1Var.itemView.getContext();
            context2.getClass();
            v5.g gVarL = hVar4.l(context2);
            gVarL.a();
            if (gVarL.I(hVar3.f8566a) == null) {
                textView2.setText(R.string.pre_registration_title);
                l5.E(textView2);
            } else {
                textView2.setText(R.string.cancel_registration);
                l5.H(textView2);
            }
            gVarL.b();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) throws NumberFormatException {
        boolean z9;
        h5.w0 w0Var;
        String str;
        viewGroup.getClass();
        g5.d dVar = this.f11453b;
        g5.a aVar = this.f11454c;
        g5.c cVar = this.f11452a;
        switch (i10) {
            case 0:
                return new y5.k1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.app_info_top_by_cat_item_small, viewGroup, false), cVar, aVar);
            case 1:
                return new y5.j1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.app_info_top_by_cat_item, viewGroup, false), cVar, dVar, aVar);
            case 2:
                View viewB = c.i.b(viewGroup, R.layout.top_by_category_description_view, null, false);
                int i11 = R.id.iv_top_by_category_linkedin;
                if (((ImageView) ViewBindings.findChildViewById(viewB, R.id.iv_top_by_category_linkedin)) != null) {
                    i11 = R.id.iv_top_by_category_twitter;
                    if (((ImageView) ViewBindings.findChildViewById(viewB, R.id.iv_top_by_category_twitter)) != null) {
                        i11 = R.id.iv_top_category_autor_avatar;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewB, R.id.iv_top_category_autor_avatar);
                        if (imageView != null) {
                            i11 = R.id.ll_top_by_category_autor_socials;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(viewB, R.id.ll_top_by_category_autor_socials);
                            if (linearLayout != null) {
                                i11 = R.id.rl_autor_top_by_cat;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewB, R.id.rl_autor_top_by_cat);
                                if (relativeLayout != null) {
                                    i11 = R.id.tv_top_by_category_apps_counter;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_by_category_apps_counter);
                                    if (textView != null) {
                                        i11 = R.id.tv_top_by_category_autor;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_by_category_autor);
                                        if (textView2 != null) {
                                            i11 = R.id.tv_top_by_category_created_by;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_by_category_created_by);
                                            if (textView3 != null) {
                                                i11 = R.id.tv_top_by_category_description;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_by_category_description);
                                                if (textView4 != null) {
                                                    i11 = R.id.tv_top_by_category_last_update;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(viewB, R.id.tv_top_by_category_last_update);
                                                    if (textView5 != null) {
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) viewB;
                                                        l1 l1Var = new l1(relativeLayout2);
                                                        h5.w0 w0Var2 = this.f;
                                                        if (w0Var2 != null) {
                                                            textView3.setTypeface(o4.b.f11720s);
                                                            textView2.setTypeface(o4.b.f11719r);
                                                            textView2.setText(w0Var2.f8787d);
                                                            textView5.setTypeface(o4.b.f11720s);
                                                            Context context = l1Var.itemView.getContext();
                                                            long j10 = w0Var2.f8784a;
                                                            if (j10 <= 0) {
                                                                str = null;
                                                                z9 = false;
                                                                w0Var = w0Var2;
                                                            } else {
                                                                z9 = false;
                                                                w0Var = w0Var2;
                                                                str = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(j10 * 1000));
                                                            }
                                                            Object[] objArr = new Object[1];
                                                            objArr[z9 ? 1 : 0] = str;
                                                            textView5.setText(context.getString(R.string.brakets_placeholder, objArr));
                                                            h5.w0 w0Var3 = w0Var;
                                                            j4.d0 d0VarE = j4.y.d().e(w0Var3.e);
                                                            float f = UptodownApp.E;
                                                            Context context2 = l1Var.itemView.getContext();
                                                            context2.getClass();
                                                            d0VarE.g(k4.c.y(context2));
                                                            d0VarE.e(imageView, null);
                                                            textView.setTypeface(o4.b.f11719r);
                                                            Context context3 = relativeLayout2.getContext();
                                                            Object[] objArr2 = new Object[1];
                                                            objArr2[z9 ? 1 : 0] = String.valueOf(w0Var3.f8785b);
                                                            textView.setText(context3.getString(R.string.apps_count, objArr2));
                                                        } else {
                                                            z9 = false;
                                                            relativeLayout.setVisibility(8);
                                                            linearLayout.setVisibility(8);
                                                            textView.setVisibility(8);
                                                        }
                                                        String str2 = this.e;
                                                        if (str2 == null || str2.length() == 0) {
                                                            l1Var.itemView.setVisibility(8);
                                                            return l1Var;
                                                        }
                                                        textView4.setTypeface(o4.b.f11720s);
                                                        w1 w1Var = this.f11455d;
                                                        if (w1Var == null) {
                                                            textView4.setText(str2);
                                                            return l1Var;
                                                        }
                                                        textView4.setOnTouchListener(new x5.e());
                                                        Context context4 = l1Var.itemView.getContext();
                                                        context4.getClass();
                                                        boolean z10 = z9;
                                                        String strB0 = o7.u.b0(o7.u.b0(str2, "<br />", "\n", z10), "<br/>", "\n", z10);
                                                        List<h5.o> listS = l5.s(strB0);
                                                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strB0);
                                                        int length = 0;
                                                        for (h5.o oVar : listS) {
                                                            int i12 = oVar.f8671a;
                                                            String str3 = oVar.e;
                                                            String str4 = oVar.f8674d;
                                                            int i13 = i12 - length;
                                                            int length2 = str4.length() + i13;
                                                            str3.getClass();
                                                            spannableStringBuilder = spannableStringBuilder.replace(i13, str3.length() + i13, (CharSequence) str4);
                                                            spannableStringBuilder.getClass();
                                                            String str5 = oVar.f8672b;
                                                            switch (str5.hashCode()) {
                                                                case 116079:
                                                                    if (str5.equals("url")) {
                                                                        spannableStringBuilder.setSpan(new h5.m(oVar, w1Var, context4, 3), i13, length2, 33);
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                    }
                                                                case 93028092:
                                                                    if (str5.equals("appID")) {
                                                                        spannableStringBuilder.setSpan(new h5.m(oVar, w1Var, context4, 0), i13, length2, 33);
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                    }
                                                                case 1296531097:
                                                                    if (str5.equals("categoryID")) {
                                                                        spannableStringBuilder.setSpan(new h5.m(oVar, w1Var, context4, 2), i13, length2, 33);
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                    }
                                                                case 1524339519:
                                                                    if (str5.equals("floatingCategoryID")) {
                                                                        spannableStringBuilder.setSpan(new h5.m(oVar, w1Var, context4, 1), i13, length2, 33);
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                    }
                                                            }
                                                            length = (str3.length() + length) - str4.length();
                                                        }
                                                        textView4.setText(spannableStringBuilder);
                                                        return l1Var;
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
                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewB.getResources().getResourceName(i11)));
                return null;
            case 3:
                return new y5.j1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.app_info_promoted_top_by_cat_item, viewGroup, false), cVar, dVar, aVar);
            case 4:
                return new y5.h1(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.app_info_top_by_cat_item, viewGroup, false), cVar, dVar, aVar);
            case 5:
                View viewB2 = c.i.b(viewGroup, R.layout.top_by_category_title_view, null, false);
                if (viewB2 == null) {
                    androidx.window.layout.c.k("rootView");
                    return null;
                }
                TextView textView6 = (TextView) viewB2;
                m1 m1Var = new m1(textView6);
                textView6.setTypeface(o4.b.f11719r);
                textView6.setText(this.h);
                return m1Var;
            case 6:
                return new y5.r(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.floating_categories, viewGroup, false), new o0(this));
            default:
                com.google.gson.internal.a.n("viewType unknown");
                return null;
        }
    }
}
