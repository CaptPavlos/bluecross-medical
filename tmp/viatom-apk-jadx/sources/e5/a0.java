package e5;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7671a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7672b;

    public /* synthetic */ a0(j0 j0Var, int i10) {
        this.f7671a = i10;
        this.f7672b = j0Var;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) throws Throwable {
        Object obj2;
        int i10 = this.f7671a;
        int i11 = -2;
        x6.a aVar = x6.a.f13718a;
        int i12 = -1;
        int i13 = 8;
        final int i14 = 1;
        final j0 j0Var = this.f7672b;
        s6.w wVar = s6.w.f12711a;
        final int i15 = 0;
        h5.t0 t0Var = null;
        switch (i10) {
            case 0:
                v5.m mVar = (v5.m) obj;
                if (mVar instanceof v5.j) {
                    return wVar;
                }
                if (!(mVar instanceof v5.l)) {
                    if (mVar instanceof v5.k) {
                        return wVar;
                    }
                    androidx.window.layout.c.b();
                    return null;
                }
                o0 o0Var = (o0) ((v5.l) mVar).f13168a;
                boolean z9 = o0Var.f7826b;
                String str = o0Var.f7825a;
                d5.b bVar = j0Var.f7785b;
                if (!z9) {
                    bVar.getClass();
                    int i16 = 3;
                    bVar.G.f.setOnClickListener(new e(j0Var, i16));
                    d5.b bVar2 = j0Var.f7785b;
                    bVar2.getClass();
                    bVar2.C.f7148i.setOnClickListener(new e(j0Var, i16));
                    d5.b bVar3 = j0Var.f7785b;
                    bVar3.getClass();
                    bVar3.C.f7147d.setVisibility(0);
                    if (j0Var.getContext() == null) {
                        return wVar;
                    }
                    d5.b bVar4 = j0Var.f7785b;
                    bVar4.getClass();
                    TextView textView = bVar4.G.f;
                    String string = j0Var.getString(R.string.pre_registration_title);
                    string.getClass();
                    textView.setText(string);
                    l5.E(textView);
                    d5.b bVar5 = j0Var.f7785b;
                    bVar5.getClass();
                    ((RelativeLayout) bVar5.G.f7054i).setBackground(ContextCompat.getDrawable(j0Var.requireContext(), R.drawable.ripple_blue_primary_button));
                    d5.b bVar6 = j0Var.f7785b;
                    bVar6.getClass();
                    bVar6.C.f7148i.setBackground(ContextCompat.getDrawable(j0Var.requireContext(), R.drawable.ripple_blue_primary_button));
                    d5.b bVar7 = j0Var.f7785b;
                    bVar7.getClass();
                    bVar7.C.f7156q.setText(j0Var.getString(R.string.pre_registration_title));
                    d5.b bVar8 = j0Var.f7785b;
                    bVar8.getClass();
                    bVar8.C.f7156q.setTextColor(ContextCompat.getColor(j0Var.requireContext(), R.color.white));
                    return wVar;
                }
                bVar.getClass();
                TextView textView2 = bVar.G.f;
                textView2.setOnClickListener(new k(j0Var, textView2, 0));
                d5.b bVar9 = j0Var.f7785b;
                bVar9.getClass();
                RelativeLayout relativeLayout = bVar9.C.f7148i;
                relativeLayout.setOnClickListener(new k(j0Var, relativeLayout, 0));
                d5.b bVar10 = j0Var.f7785b;
                bVar10.getClass();
                bVar10.C.f7147d.setVisibility(8);
                if (j0Var.getContext() != null && str != null && str.length() != 0) {
                    d5.b bVar11 = j0Var.f7785b;
                    bVar11.getClass();
                    TextView textView3 = bVar11.G.f;
                    textView3.setText(str);
                    l5.F(textView3);
                    d5.b bVar12 = j0Var.f7785b;
                    bVar12.getClass();
                    ((RelativeLayout) bVar12.G.f7054i).setBackground(ContextCompat.getDrawable(j0Var.requireContext(), R.drawable.ripple_open_button));
                    d5.b bVar13 = j0Var.f7785b;
                    bVar13.getClass();
                    bVar13.C.f7148i.setBackground(ContextCompat.getDrawable(j0Var.requireContext(), R.drawable.ripple_open_button));
                    d5.b bVar14 = j0Var.f7785b;
                    bVar14.getClass();
                    bVar14.C.f7156q.setTextColor(ContextCompat.getColorStateList(j0Var.requireContext(), R.color.selector_wizard_accept_button_text));
                    d5.b bVar15 = j0Var.f7785b;
                    bVar15.getClass();
                    bVar15.C.f7156q.setText(str);
                }
                t3.h hVar = v5.g.f13148u;
                Context contextRequireContext = j0Var.requireContext();
                contextRequireContext.getClass();
                v5.g gVarL = hVar.l(contextRequireContext);
                gVarL.a();
                h5.g0 g0VarI = gVarL.I(j0Var.D().f8566a);
                gVarL.b();
                d5.b bVar16 = j0Var.f7785b;
                if (g0VarI == null) {
                    bVar16.getClass();
                    bVar16.T.setChecked(true);
                    return wVar;
                }
                bVar16.getClass();
                bVar16.f6901z.setVisibility(0);
                d5.b bVar17 = j0Var.f7785b;
                bVar17.getClass();
                bVar17.T.setChecked(g0VarI.e == 1);
                return wVar;
            case 1:
                ArrayList arrayList = (ArrayList) obj;
                d5.b bVar18 = j0Var.f7785b;
                bVar18.getClass();
                if (bVar18.f6874k.getVisibility() == 8 && !arrayList.isEmpty()) {
                    n4.t0 t0Var2 = new n4.t0(new w(j0Var, 6), new c0(j0Var, 6), 8);
                    j0Var.f7788i = t0Var2;
                    t0Var2.a(arrayList);
                    d5.b bVar19 = j0Var.f7785b;
                    bVar19.getClass();
                    bVar19.Q.setAdapter(j0Var.f7788i);
                    d5.b bVar20 = j0Var.f7785b;
                    bVar20.getClass();
                    bVar20.Q.setNestedScrollingEnabled(false);
                    d5.b bVar21 = j0Var.f7785b;
                    bVar21.getClass();
                    bVar21.Q.setLayoutManager(new LinearLayoutManager(j0Var.getContext(), 0, false));
                    DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
                    defaultItemAnimator.setSupportsChangeAnimations(false);
                    d5.b bVar22 = j0Var.f7785b;
                    bVar22.getClass();
                    bVar22.Q.setItemAnimator(defaultItemAnimator);
                    d5.b bVar23 = j0Var.f7785b;
                    bVar23.getClass();
                    bVar23.f6874k.setVisibility(0);
                }
                return wVar;
            case 2:
                v5.m mVar2 = (v5.m) obj;
                if (mVar2 instanceof v5.j) {
                    return wVar;
                }
                if (mVar2 instanceof v5.l) {
                    n0 n0Var = (n0) ((v5.l) mVar2).f13168a;
                    n0Var.getClass();
                    if (n0Var.f7820a) {
                        FragmentActivity activity = j0Var.getActivity();
                        activity.getClass();
                        AlertDialog alertDialog = ((l4.w) activity).f10935w;
                        if (alertDialog != null) {
                            alertDialog.dismiss();
                        }
                        if (j0Var.getContext() != null) {
                            obj2 = null;
                            View viewInflate = j0Var.getLayoutInflater().inflate(R.layout.dialog_coming_soon, (ViewGroup) null, false);
                            int i17 = R.id.tv_close_dialog_pre_register;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_close_dialog_pre_register);
                            if (textView4 != null) {
                                i17 = R.id.tv_description_dialog_pre_register;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_description_dialog_pre_register);
                                if (textView5 != null) {
                                    i17 = R.id.tv_title_dialog_pre_register;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dialog_pre_register);
                                    if (textView6 != null) {
                                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                                        textView6.setTypeface(o4.b.f11719r);
                                        textView5.setTypeface(o4.b.f11720s);
                                        String string2 = j0Var.getString(R.string.pre_register_success, j0Var.D().f8567b);
                                        string2.getClass();
                                        String str2 = j0Var.D().f8567b;
                                        str2.getClass();
                                        Context contextRequireContext2 = j0Var.requireContext();
                                        contextRequireContext2.getClass();
                                        SpannableString spannableString = new SpannableString(string2);
                                        int iK0 = o7.m.k0(string2, str2, 0, false, 6);
                                        int length = str2.length() + iK0;
                                        if (iK0 != -1) {
                                            float dimension = contextRequireContext2.getResources().getDimension(R.dimen.text_size_m);
                                            Typeface typeface = o4.b.f11719r;
                                            typeface.getClass();
                                            spannableString.setSpan(new v5.e(dimension, typeface, ContextCompat.getColor(contextRequireContext2, R.color.text_primary)), iK0, length, 33);
                                        }
                                        textView5.setText(spannableString);
                                        textView4.setTypeface(o4.b.f11719r);
                                        textView4.setOnClickListener(new e(j0Var, 28));
                                        AlertDialog.Builder builder = new AlertDialog.Builder(j0Var.requireContext());
                                        builder.setView(linearLayout);
                                        builder.setCancelable(true);
                                        j0Var.l0(builder);
                                    }
                                }
                            }
                            androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i17)));
                        }
                    }
                    j0.k(j0Var);
                    return wVar;
                }
                obj2 = null;
                if (mVar2 instanceof v5.k) {
                    return wVar;
                }
                androidx.window.layout.c.b();
                return obj2;
            case 3:
                v5.m mVar3 = (v5.m) obj;
                if (mVar3 instanceof v5.j) {
                    return wVar;
                }
                if (!(mVar3 instanceof v5.l)) {
                    if (mVar3 instanceof v5.k) {
                        return wVar;
                    }
                    androidx.window.layout.c.b();
                    return null;
                }
                k0 k0Var = (k0) ((v5.l) mVar3).f13168a;
                ArrayList arrayList2 = k0Var.f7800a;
                ArrayList arrayList3 = k0Var.f7801b;
                boolean zIsEmpty = arrayList2.isEmpty();
                j0 j0Var2 = this.f7672b;
                if (zIsEmpty) {
                    d5.b bVar24 = j0Var2.f7785b;
                    bVar24.getClass();
                    bVar24.R.setVisibility(8);
                    return wVar;
                }
                ArrayList arrayList4 = new ArrayList();
                if (!arrayList3.isEmpty()) {
                    int size = arrayList3.size();
                    int i18 = 0;
                    while (i18 < size) {
                        Object obj3 = arrayList3.get(i18);
                        i18++;
                        h5.l1 l1Var = (h5.l1) obj3;
                        String strA = l1Var.a();
                        if (strA != null && strA.length() != 0) {
                            arrayList4.add(l1Var);
                        }
                    }
                }
                ArrayList arrayList5 = new ArrayList();
                int size2 = arrayList2.size();
                for (int i19 = 0; i19 < size2; i19++) {
                    Object obj4 = arrayList2.get(i19);
                    obj4.getClass();
                    h5.u0 u0Var = (h5.u0) obj4;
                    if (u0Var.f8756c == 0) {
                        arrayList5.add(u0Var);
                    }
                }
                kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                w2.r rVar = new w2.r(j0Var2, arrayList5, xVar, arrayList4, 16);
                ArrayList arrayList6 = new ArrayList();
                arrayList6.addAll(arrayList4);
                arrayList6.addAll(arrayList5);
                xVar.f10138a = new n4.k0(arrayList6, rVar);
                d5.b bVar25 = j0Var2.f7785b;
                bVar25.getClass();
                bVar25.R.setAdapter((RecyclerView.Adapter) xVar.f10138a);
                d5.b bVar26 = j0Var2.f7785b;
                bVar26.getClass();
                bVar26.R.setVisibility(0);
                return wVar;
            case 4:
                j0.e(j0Var, (ArrayList) obj, false);
                return wVar;
            case 5:
                h5.d dVar = (h5.d) obj;
                ArrayList arrayList7 = dVar.f8492c;
                if (arrayList7 != null && !arrayList7.isEmpty()) {
                    d5.b bVar27 = j0Var.f7785b;
                    bVar27.getClass();
                    bVar27.g.setVisibility(0);
                    d5.b bVar28 = j0Var.f7785b;
                    bVar28.getClass();
                    bVar28.D0.setText(j0Var.getString(R.string.best_alternatives));
                    d5.b bVar29 = j0Var.f7785b;
                    bVar29.getClass();
                    bVar29.f6892u.setOnClickListener(new b5.a(16, j0Var, dVar));
                    ArrayList arrayList8 = dVar.f8492c;
                    arrayList8.getClass();
                    if (arrayList8.size() > 20) {
                        ArrayList arrayList9 = dVar.f8492c;
                        arrayList9.getClass();
                        j0.e(j0Var, new ArrayList(arrayList9.subList(0, 20)), true);
                    } else {
                        j0.e(j0Var, dVar.f8492c, true);
                    }
                }
                return wVar;
            case 6:
                v5.m mVar4 = (v5.m) obj;
                if (mVar4 instanceof v5.j) {
                    return wVar;
                }
                if (mVar4 instanceof v5.l) {
                    l0 l0Var = (l0) ((v5.l) mVar4).f13168a;
                    ArrayList arrayList10 = l0Var.f7807a;
                    ArrayList arrayList11 = l0Var.f7808b;
                    if (arrayList10 == null || arrayList10.isEmpty()) {
                        if (arrayList11 == null || arrayList11.isEmpty()) {
                            return wVar;
                        }
                        d5.b bVar30 = j0Var.f7785b;
                        bVar30.getClass();
                        if (bVar30.f6877m.getChildCount() != 0) {
                            return wVar;
                        }
                        d5.b bVar31 = j0Var.f7785b;
                        bVar31.getClass();
                        bVar31.f6880n0.setTypeface(o4.b.f11719r);
                        if (j0Var.getActivity() != null) {
                            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(j0Var.requireContext());
                            horizontalScrollView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                            horizontalScrollView.setHorizontalScrollBarEnabled(false);
                            LinearLayout linearLayout2 = new LinearLayout(j0Var.requireContext());
                            linearLayout2.setOrientation(0);
                            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                            horizontalScrollView.addView(linearLayout2);
                            d5.b bVar32 = j0Var.f7785b;
                            bVar32.getClass();
                            bVar32.f6877m.addView(horizontalScrollView);
                            Iterator it = arrayList11.iterator();
                            it.getClass();
                            while (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                h5.k kVar = (h5.k) next;
                                int dimension2 = (int) j0Var.getResources().getDimension(R.dimen.margin_m);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                                if (kVar.equals(t6.l.i0(arrayList11))) {
                                    layoutParams.setMargins(dimension2, 0, dimension2, 0);
                                } else {
                                    layoutParams.setMargins(dimension2, 0, 0, 0);
                                }
                                View viewInflate2 = j0Var.getLayoutInflater().inflate(R.layout.chip_floating_category, (ViewGroup) null, false);
                                if (viewInflate2 != null) {
                                    TextView textView7 = (TextView) viewInflate2;
                                    textView7.setLayoutParams(layoutParams);
                                    textView7.setTypeface(o4.b.f11719r);
                                    textView7.setText(String.valueOf(kVar.f8633b));
                                    textView7.setOnClickListener(new b5.a(8, j0Var, kVar));
                                    linearLayout2.addView(textView7);
                                } else {
                                    androidx.window.layout.c.k("rootView");
                                }
                            }
                        }
                        d5.b bVar33 = j0Var.f7785b;
                        bVar33.getClass();
                        bVar33.f6879n.setVisibility(0);
                        return wVar;
                    }
                    ArrayList<h5.x0> arrayList12 = l0Var.f7807a;
                    d5.b bVar34 = j0Var.f7785b;
                    bVar34.getClass();
                    if (bVar34.f6877m.getChildCount() != 0) {
                        return wVar;
                    }
                    d5.b bVar35 = j0Var.f7785b;
                    bVar35.getClass();
                    bVar35.f6880n0.setVisibility(8);
                    if (j0Var.getActivity() != null) {
                        int i20 = 0;
                        for (h5.x0 x0Var : arrayList12) {
                            int i21 = i20 + 1;
                            View viewInflate3 = j0Var.getLayoutInflater().inflate(R.layout.home_recycler_view_top, (ViewGroup) null, false);
                            int i22 = R.id.iv_more_home_recycler_view_top;
                            if (((ImageView) ViewBindings.findChildViewById(viewInflate3, R.id.iv_more_home_recycler_view_top)) != null) {
                                i22 = R.id.rl_title_home_recycler_view_top;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(viewInflate3, R.id.rl_title_home_recycler_view_top);
                                if (relativeLayout2 != null) {
                                    i22 = R.id.rv_home_recycler_view_top;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate3, R.id.rv_home_recycler_view_top);
                                    if (recyclerView != null) {
                                        i22 = R.id.tv_title_home_recycler_view_top;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(viewInflate3, R.id.tv_title_home_recycler_view_top);
                                        if (textView8 != null) {
                                            LinearLayout linearLayout3 = (LinearLayout) viewInflate3;
                                            if (i20 > 0) {
                                                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i11, i11);
                                                layoutParams2.setMargins(0, (int) j0Var.getResources().getDimension(R.dimen.margin_l), 0, 0);
                                                linearLayout3.setLayoutParams(layoutParams2);
                                            }
                                            n4.t0 t0Var3 = new n4.t0(new w(j0Var, i13), new c0(j0Var, i13), 20);
                                            t0Var3.a(x0Var.f8789b);
                                            textView8.setTypeface(o4.b.f11719r);
                                            textView8.setText(x0Var.f8788a.f8633b);
                                            relativeLayout2.setOnClickListener(new b5.a(10, j0Var, x0Var));
                                            recyclerView.setAdapter(t0Var3);
                                            recyclerView.setNestedScrollingEnabled(false);
                                            recyclerView.setLayoutManager(new LinearLayoutManager(j0Var.getContext(), 0, false));
                                            DefaultItemAnimator defaultItemAnimator2 = new DefaultItemAnimator();
                                            defaultItemAnimator2.setSupportsChangeAnimations(false);
                                            recyclerView.setItemAnimator(defaultItemAnimator2);
                                            d5.b bVar36 = j0Var.f7785b;
                                            bVar36.getClass();
                                            bVar36.f6877m.addView(linearLayout3);
                                            j0Var.f7789j.add(t0Var3);
                                            i20 = i21;
                                            i11 = -2;
                                            i13 = 8;
                                        }
                                    }
                                }
                            }
                            androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i22)));
                        }
                    }
                    d5.b bVar37 = j0Var.f7785b;
                    bVar37.getClass();
                    bVar37.f6879n.setVisibility(0);
                    return wVar;
                }
                if (mVar4 instanceof v5.k) {
                    return wVar;
                }
                androidx.window.layout.c.b();
                return null;
            case 7:
                v5.m mVar5 = (v5.m) obj;
                if (mVar5 instanceof v5.j) {
                    return wVar;
                }
                if (!(mVar5 instanceof v5.l)) {
                    if (mVar5 instanceof v5.k) {
                        return wVar;
                    }
                    androidx.window.layout.c.b();
                    return null;
                }
                m0 m0Var = (m0) ((v5.l) mVar5).f13168a;
                ArrayList arrayList13 = m0Var.f7813a;
                d5.b bVar38 = j0Var.f7785b;
                bVar38.getClass();
                if (bVar38.f6889s.getChildCount() == 0 && j0Var.getContext() != null) {
                    if (arrayList13.isEmpty()) {
                        d5.b bVar39 = j0Var.f7785b;
                        bVar39.getClass();
                        bVar39.f6889s.setVisibility(8);
                        d5.b bVar40 = j0Var.f7785b;
                        bVar40.getClass();
                        bVar40.F.setVisibility(8);
                    } else {
                        int dimension3 = (int) j0Var.getResources().getDimension(R.dimen.margin_m);
                        if (arrayList13.size() >= 5) {
                            d5.b bVar41 = j0Var.f7785b;
                            bVar41.getClass();
                            bVar41.B0.setVisibility(0);
                        }
                        if (o7.u.Z(j0Var.getString(R.string.screen_type), "phone", true)) {
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams3.setMargins(0, dimension3, 0, 0);
                            Iterator it2 = arrayList13.iterator();
                            it2.getClass();
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                next2.getClass();
                                h5.t0 t0Var4 = (h5.t0) next2;
                                boolean zB = t0Var4.b();
                                d5.b bVar42 = j0Var.f7785b;
                                if (zB) {
                                    bVar42.getClass();
                                    LinearLayout linearLayout4 = bVar42.f6889s;
                                    Context contextRequireContext3 = j0Var.requireContext();
                                    contextRequireContext3.getClass();
                                    linearLayout4.addView(j0Var.Y(layoutParams3, t0Var4, contextRequireContext3));
                                } else {
                                    bVar42.getClass();
                                    LinearLayout linearLayout5 = bVar42.f6889s;
                                    Context contextRequireContext4 = j0Var.requireContext();
                                    contextRequireContext4.getClass();
                                    linearLayout5.addView(j0Var.X(layoutParams3, t0Var4, contextRequireContext4));
                                }
                            }
                        } else {
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams4.setMargins(0, dimension3, 0, dimension3);
                            for (int i23 = 0; i23 < arrayList13.size(); i23 += 2) {
                                LinearLayout linearLayout6 = new LinearLayout(j0Var.getContext());
                                linearLayout6.setOrientation(0);
                                linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                layoutParams4.setMargins(0, dimension3, 0, dimension3);
                                layoutParams5.weight = 1.0f;
                                if (((h5.t0) arrayList13.get(i23)).b()) {
                                    Object obj5 = arrayList13.get(i23);
                                    obj5.getClass();
                                    Context contextRequireContext5 = j0Var.requireContext();
                                    contextRequireContext5.getClass();
                                    linearLayout6.addView(j0Var.Y(layoutParams4, (h5.t0) obj5, contextRequireContext5));
                                } else {
                                    Object obj6 = arrayList13.get(i23);
                                    obj6.getClass();
                                    Context contextRequireContext6 = j0Var.requireContext();
                                    contextRequireContext6.getClass();
                                    linearLayout6.addView(j0Var.X(layoutParams5, (h5.t0) obj6, contextRequireContext6));
                                }
                                int i24 = i23 + 1;
                                if (i24 < arrayList13.size()) {
                                    LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
                                    layoutParams6.setMargins(dimension3, dimension3, 0, dimension3);
                                    layoutParams6.weight = 1.0f;
                                    if (!((h5.t0) arrayList13.get(i24)).b()) {
                                        Object obj7 = arrayList13.get(i24);
                                        obj7.getClass();
                                        Context contextRequireContext7 = j0Var.requireContext();
                                        contextRequireContext7.getClass();
                                        linearLayout6.addView(j0Var.X(layoutParams6, (h5.t0) obj7, contextRequireContext7));
                                    }
                                } else {
                                    RelativeLayout relativeLayout3 = d5.q0.a(j0Var.getLayoutInflater().inflate(R.layout.review, (ViewGroup) null, false)).f7295a;
                                    relativeLayout3.setLayoutParams(layoutParams5);
                                    relativeLayout3.setVisibility(4);
                                    linearLayout6.addView(relativeLayout3);
                                }
                                d5.b bVar43 = j0Var.f7785b;
                                bVar43.getClass();
                                bVar43.f6889s.addView(linearLayout6);
                            }
                        }
                    }
                }
                h5.t0 t0Var5 = m0Var.f7814b;
                if (j0Var.getActivity() == null || j0Var.requireActivity().isFinishing() || t0Var5 == null) {
                    return wVar;
                }
                if (t0Var5.g >= 1) {
                    d5.b bVar44 = j0Var.f7785b;
                    bVar44.getClass();
                    com.mbridge.msdk.dycreator.baseview.a.r(j0Var, R.drawable.vector_star_on, (ImageView) bVar44.f6898x.f);
                }
                if (t0Var5.g >= 2) {
                    d5.b bVar45 = j0Var.f7785b;
                    bVar45.getClass();
                    com.mbridge.msdk.dycreator.baseview.a.r(j0Var, R.drawable.vector_star_on, (ImageView) bVar45.f6898x.g);
                }
                if (t0Var5.g >= 3) {
                    d5.b bVar46 = j0Var.f7785b;
                    bVar46.getClass();
                    com.mbridge.msdk.dycreator.baseview.a.r(j0Var, R.drawable.vector_star_on, (ImageView) bVar46.f6898x.h);
                }
                if (t0Var5.g >= 4) {
                    d5.b bVar47 = j0Var.f7785b;
                    bVar47.getClass();
                    com.mbridge.msdk.dycreator.baseview.a.r(j0Var, R.drawable.vector_star_on, (ImageView) bVar47.f6898x.f7085i);
                }
                if (t0Var5.g == 5) {
                    d5.b bVar48 = j0Var.f7785b;
                    bVar48.getClass();
                    com.mbridge.msdk.dycreator.baseview.a.r(j0Var, R.drawable.vector_star_on, (ImageView) bVar48.f6898x.f7086j);
                }
                d5.b bVar49 = j0Var.f7785b;
                bVar49.getClass();
                ((TextView) bVar49.f6898x.f7083c).setText(j0Var.getString(R.string.edit_your_review));
                return wVar;
            case 8:
                v5.m mVar6 = (v5.m) obj;
                if (kotlin.jvm.internal.l.a(mVar6, v5.j.f13166a)) {
                    return wVar;
                }
                if (!(mVar6 instanceof v5.l)) {
                    if (kotlin.jvm.internal.l.a(mVar6, v5.k.f13167a)) {
                        return wVar;
                    }
                    androidx.window.layout.c.b();
                    return null;
                }
                Iterator it3 = ((Iterable) j0Var.G().f7708r.getValue()).iterator();
                while (true) {
                    if (it3.hasNext()) {
                        int i25 = i15 + 1;
                        h5.t0 t0Var6 = (h5.t0) it3.next();
                        String str3 = t0Var6.f8740b;
                        h5.d1 d1Var = (h5.d1) ((v5.l) mVar6).f13168a;
                        if (kotlin.jvm.internal.l.a(str3, d1Var.f8502a)) {
                            t0Var6.f8749o = d1Var.f8505d;
                            t0Var = t0Var6;
                            i12 = i15;
                        } else {
                            i15 = i25;
                        }
                    }
                }
                if (i12 < 0 || t0Var == null || i12 >= ((ArrayList) j0Var.G().f7708r.getValue()).size()) {
                    return wVar;
                }
                j0.o(j0Var, t0Var, i12);
                if (((h5.d1) ((v5.l) mVar6).f13168a).f8505d == 1) {
                    FragmentActivity activity2 = j0Var.getActivity();
                    activity2.getClass();
                    String string3 = j0Var.getString(R.string.follow_succesfully);
                    string3.getClass();
                    ((l4.w) activity2).C(string3);
                    return wVar;
                }
                FragmentActivity activity3 = j0Var.getActivity();
                activity3.getClass();
                String string4 = j0Var.getString(R.string.unfollow_succesfully);
                string4.getClass();
                ((l4.w) activity3).C(string4);
                return wVar;
            case 9:
                final v5.m mVar7 = (v5.m) obj;
                if (mVar7 instanceof v5.j) {
                    return wVar;
                }
                if (!(mVar7 instanceof v5.l)) {
                    if (mVar7 instanceof v5.k) {
                        return wVar;
                    }
                    androidx.window.layout.c.b();
                    return null;
                }
                Object obj8 = ((v5.l) mVar7).f13168a;
                if (((Collection) obj8).isEmpty()) {
                    d5.b bVar50 = j0Var.f7785b;
                    bVar50.getClass();
                    bVar50.G.f7052c.setVisibility(8);
                    j0Var.I(R.id.action_remote_install);
                    return wVar;
                }
                Iterator it4 = ((ArrayList) obj8).iterator();
                it4.getClass();
                while (it4.hasNext()) {
                    Object next3 = it4.next();
                    next3.getClass();
                    if (((h5.j1) next3).e == 1) {
                        d5.b bVar51 = j0Var.f7785b;
                        bVar51.getClass();
                        bVar51.G.f7052c.setVisibility(0);
                        d5.b bVar52 = j0Var.f7785b;
                        bVar52.getClass();
                        ((ImageView) bVar52.G.f7057l).setVisibility(0);
                        j0Var.m0(R.id.action_remote_install);
                        d5.b bVar53 = j0Var.f7785b;
                        bVar53.getClass();
                        bVar53.G.f7052c.setOnClickListener(new View.OnClickListener() { // from class: e5.f0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                int i26 = i15;
                                v5.m mVar8 = mVar7;
                                j0 j0Var3 = j0Var;
                                switch (i26) {
                                    case 0:
                                        float f = UptodownApp.E;
                                        if (k4.c.s()) {
                                            j0Var3.n0((ArrayList) ((v5.l) mVar8).f13168a);
                                            break;
                                        }
                                        break;
                                    default:
                                        float f10 = UptodownApp.E;
                                        if (k4.c.s()) {
                                            j0Var3.n0((ArrayList) ((v5.l) mVar8).f13168a);
                                            break;
                                        }
                                        break;
                                }
                            }
                        });
                        d5.b bVar54 = j0Var.f7785b;
                        bVar54.getClass();
                        ((ImageView) bVar54.G.f7057l).setOnClickListener(new View.OnClickListener() { // from class: e5.f0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                int i26 = i14;
                                v5.m mVar8 = mVar7;
                                j0 j0Var3 = j0Var;
                                switch (i26) {
                                    case 0:
                                        float f = UptodownApp.E;
                                        if (k4.c.s()) {
                                            j0Var3.n0((ArrayList) ((v5.l) mVar8).f13168a);
                                            break;
                                        }
                                        break;
                                    default:
                                        float f10 = UptodownApp.E;
                                        if (k4.c.s()) {
                                            j0Var3.n0((ArrayList) ((v5.l) mVar8).f13168a);
                                            break;
                                        }
                                        break;
                                }
                            }
                        });
                        return wVar;
                    }
                }
                d5.b bVar55 = j0Var.f7785b;
                bVar55.getClass();
                bVar55.G.f7052c.setVisibility(8);
                j0Var.I(R.id.action_remote_install);
                return wVar;
            case 10:
                j0Var.D().A0 = ((Number) obj).intValue();
                y7.e eVar = r7.i0.f12407a;
                Object objZ = r7.y.z(new y(j0Var, null, 3), w7.n.f13548a, cVar);
                return objZ == aVar ? objZ : wVar;
            case 11:
                v5.m mVar8 = (v5.m) obj;
                if (mVar8 instanceof v5.j) {
                    return wVar;
                }
                if (!(mVar8 instanceof v5.l)) {
                    if (mVar8 instanceof v5.k) {
                        return wVar;
                    }
                    androidx.window.layout.c.b();
                    return null;
                }
                p0 p0Var = (p0) ((v5.l) mVar8).f13168a;
                boolean z10 = p0Var.f7830a;
                int i26 = p0Var.f7831b;
                if (z10) {
                    FragmentActivity activity4 = j0Var.getActivity();
                    activity4.getClass();
                    String string5 = j0Var.requireContext().getString(R.string.review_sended);
                    string5.getClass();
                    ((l4.w) activity4).C(string5);
                    return wVar;
                }
                if (!z10 && i26 == 0) {
                    FragmentActivity activity5 = j0Var.getActivity();
                    activity5.getClass();
                    String string6 = j0Var.getString(R.string.error_review_already_submitted);
                    string6.getClass();
                    ((l4.w) activity5).C(string6);
                    return wVar;
                }
                if (i26 == 401) {
                    Context contextRequireContext8 = j0Var.requireContext();
                    contextRequireContext8.getClass();
                    h5.c1.b(contextRequireContext8);
                    j0Var.S();
                    return wVar;
                }
                if (i26 == 403) {
                    FragmentActivity activity6 = j0Var.getActivity();
                    activity6.getClass();
                    String string7 = j0Var.getString(R.string.email_validation_msg);
                    string7.getClass();
                    ((l4.w) activity6).C(string7);
                    return wVar;
                }
                FragmentActivity activity7 = j0Var.getActivity();
                activity7.getClass();
                String string8 = j0Var.getString(R.string.error_generico);
                string8.getClass();
                ((l4.w) activity7).C(string8);
                return wVar;
            default:
                j0Var.D().z0 = ((Number) obj).intValue();
                y7.e eVar2 = r7.i0.f12407a;
                Object objZ2 = r7.y.z(new y(j0Var, null, 4), w7.n.f13548a, cVar);
                return objZ2 == aVar ? objZ2 : wVar;
        }
    }
}
