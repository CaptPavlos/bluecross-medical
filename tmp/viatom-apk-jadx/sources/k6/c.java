package k6;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b9.s;
import c.g;
import c.h;
import c6.i;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.uptodown.R;
import d5.n;
import f6.m;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.l;
import r7.i0;
import r7.w;
import r7.y;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends l9.a implements c.b {

    /* renamed from: m, reason: collision with root package name */
    public ConstraintLayout f10067m;

    /* renamed from: n, reason: collision with root package name */
    public RecyclerView f10068n;

    /* renamed from: o, reason: collision with root package name */
    public d f10069o;

    /* renamed from: p, reason: collision with root package name */
    public g f10070p;

    public final void a() {
        CharSequence query;
        SearchView searchView = this.e;
        if (searchView == null || (query = searchView.getQuery()) == null) {
            return;
        }
        g gVar = this.f10070p;
        if (gVar == null) {
            l.i("switchAdapter");
            throw null;
        }
        d dVar = this.f10069o;
        if (dVar == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList arrayListC = dVar.c(query.toString());
        boolean z9 = query.length() > 0;
        gVar.f958a = arrayListC;
        if (!z9) {
            gVar.a();
        }
        gVar.notifyDataSetChanged();
    }

    @Override // c.b
    public final void g(h hVar) {
        String string;
        String string2;
        k8.d dVar = hVar.f964a;
        FragmentActivity activity = getActivity();
        if (activity != null && (dVar instanceof k8.h) && activity.getSupportFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D) == null) {
            String str = dVar.f10089b;
            k8.h hVar2 = (k8.h) dVar;
            String str2 = hVar2.f10094c;
            d dVar2 = this.f10069o;
            if (dVar2 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA = dVar2.a(hVar2.f10095d, 1);
            d dVar3 = this.f10069o;
            if (dVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA2 = dVar3.a(hVar2.g, 2);
            d dVar4 = this.f10069o;
            if (dVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA3 = dVar4.a(hVar2.h, 3);
            d dVar5 = this.f10069o;
            if (dVar5 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA4 = dVar5.a(hVar2.f10096i, 4);
            d dVar6 = this.f10069o;
            if (dVar6 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA5 = dVar6.a(hVar2.f10101n, 5);
            String str3 = hVar2.f10097j;
            d dVar7 = this.f10069o;
            if (dVar7 == null) {
                l.i("viewModel");
                throw null;
            }
            n nVar = dVar7.f10071a;
            int i10 = hVar2.f10099l;
            if (i10 < 0) {
                string = "";
            } else {
                float f = i10 / 86400.0f;
                if (f >= 1.0f) {
                    StringBuilder sb = new StringBuilder();
                    if (Float.isNaN(f)) {
                        com.google.gson.internal.a.n("Cannot round NaN value.");
                        return;
                    }
                    sb.append(Math.round(f));
                    sb.append(' ');
                    sb.append(nVar.g().f7555i);
                    string = sb.toString();
                } else {
                    string = i10 + ' ' + nVar.g().f7556j;
                }
            }
            d dVar8 = this.f10069o;
            if (dVar8 == null) {
                l.i("viewModel");
                throw null;
            }
            n nVar2 = dVar8.f10071a;
            String str4 = string;
            Boolean bool = hVar2.f10100m;
            String str5 = l.a(bool, Boolean.TRUE) ? nVar2.g().f7559m : l.a(bool, Boolean.FALSE) ? nVar2.g().f7560n : "";
            d dVar9 = this.f10069o;
            if (dVar9 == null) {
                l.i("viewModel");
                throw null;
            }
            e2.c cVar = hVar2.f10102o;
            if (cVar == null || (string2 = Integer.valueOf(cVar.f7630a).toString()) == null) {
                string2 = "";
            }
            if (string2.length() != 0) {
                string2 = string2 + ' ' + dVar9.f10071a.g().f7555i;
            }
            i6.b bVar = new i6.b(str, str2, strA, (String) null, strA2, strA3, strA4, strA5, str3, str4, str5, string2, dVar.f10088a, hVar.f967d, hVar2.f10103p, 8);
            i6.d dVar10 = new i6.d();
            Bundle bundle = new Bundle();
            bundle.putParcelable("partner_detail_args", bVar);
            dVar10.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().add(dVar10, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D).commit();
        }
    }

    @Override // c.b
    public final void h(h hVar) {
        int i10 = hVar.f967d;
        k8.d dVar = hVar.f964a;
        d dVar2 = this.f10069o;
        if (dVar2 == null) {
            l.i("viewModel");
            throw null;
        }
        m mVar = dVar2.f10072b;
        if (i10 == 2) {
            Boolean bool = hVar.f965b;
            Boolean bool2 = Boolean.TRUE;
            if (l.a(bool, bool2)) {
                mVar.A.set(dVar.f10088a);
                UUID uuid = s.f936a;
                String str = "Non IAB_" + dVar.f10088a;
                String strValueOf = String.valueOf(l.a(hVar.f965b, bool2));
                strValueOf.getClass();
                s.f937b.h(str, strValueOf);
                return;
            }
        }
        if (i10 == 2 && l.a(hVar.f965b, Boolean.FALSE)) {
            mVar.A.unset(dVar.f10088a);
            UUID uuid2 = s.f936a;
            String str2 = "Non IAB_" + dVar.f10088a;
            String strValueOf2 = String.valueOf(l.a(hVar.f965b, Boolean.TRUE));
            strValueOf2.getClass();
            s.f937b.h(str2, strValueOf2);
            return;
        }
        if (i10 == 1) {
            Boolean bool3 = hVar.f965b;
            Boolean bool4 = Boolean.TRUE;
            if (l.a(bool3, bool4)) {
                mVar.f8116z.set(dVar.f10088a);
                UUID uuid3 = s.f936a;
                String str3 = "Vendors_" + dVar.f10088a;
                String strValueOf3 = String.valueOf(l.a(hVar.f965b, bool4));
                strValueOf3.getClass();
                s.f937b.h(str3, strValueOf3);
                return;
            }
        }
        if (i10 == 1 && l.a(hVar.f965b, Boolean.FALSE)) {
            mVar.f8116z.unset(dVar.f10088a);
            UUID uuid4 = s.f936a;
            String str4 = "Vendors_" + dVar.f10088a;
            String strValueOf4 = String.valueOf(l.a(hVar.f965b, Boolean.TRUE));
            strValueOf4.getClass();
            s.f937b.h(str4, strValueOf4);
            return;
        }
        if (i10 == 3) {
            Boolean bool5 = hVar.f965b;
            Boolean bool6 = Boolean.TRUE;
            if (l.a(bool5, bool6)) {
                mVar.B.set(dVar.f10088a);
                UUID uuid5 = s.f936a;
                String str5 = "Google_" + dVar.f10088a;
                String strValueOf5 = String.valueOf(l.a(hVar.f965b, bool6));
                strValueOf5.getClass();
                s.f937b.h(str5, strValueOf5);
                return;
            }
        }
        if (i10 == 3 && l.a(hVar.f965b, Boolean.FALSE)) {
            mVar.B.unset(dVar.f10088a);
            UUID uuid6 = s.f936a;
            String str6 = "Google_" + dVar.f10088a;
            String strValueOf6 = String.valueOf(l.a(hVar.f965b, Boolean.TRUE));
            strValueOf6.getClass();
            s.f937b.h(str6, strValueOf6);
            return;
        }
        if (i10 == 4) {
            Boolean bool7 = hVar.f965b;
            Boolean bool8 = Boolean.TRUE;
            if (l.a(bool7, bool8)) {
                mVar.t.set(dVar.f10088a);
                mVar.f8113v.setItems(t6.l.u0(((k8.h) dVar).f10095d));
                UUID uuid7 = s.f936a;
                String str7 = "Vendors_" + dVar.f10088a;
                String strValueOf7 = String.valueOf(l.a(hVar.f965b, bool8));
                strValueOf7.getClass();
                s.f937b.h(str7, strValueOf7);
                return;
            }
        }
        if (i10 == 4 && l.a(hVar.f965b, Boolean.FALSE)) {
            mVar.t.unset(dVar.f10088a);
            mVar.f8113v.unset(t6.l.u0(((k8.h) dVar).f10095d));
            UUID uuid8 = s.f936a;
            String str8 = "Vendors_" + dVar.f10088a;
            String strValueOf8 = String.valueOf(l.a(hVar.f965b, Boolean.TRUE));
            strValueOf8.getClass();
            s.f937b.h(str8, strValueOf8);
        }
    }

    @Override // l9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        this.f10069o = (d) new ViewModelProvider(viewModelStore, new i(5)).get(d.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_partners, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        d dVar = this.f10069o;
        if (dVar == null) {
            l.i("viewModel");
            throw null;
        }
        SearchView searchView = this.e;
        dVar.f10077k = searchView == null ? false : searchView.hasFocus();
    }

    @Override // l9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        SearchView searchView;
        Integer num;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f10067m = (ConstraintLayout) view.findViewById(R.id.partners_container);
        this.f10068n = (RecyclerView) view.findViewById(R.id.rv_partners_list);
        d dVar = this.f10069o;
        if (dVar == null) {
            l.i("viewModel");
            throw null;
        }
        w viewModelScope = ViewModelKt.getViewModelScope(dVar);
        e eVar = i0.f12407a;
        y7.d dVar2 = y7.d.f14116a;
        a6.c cVar = new a6.c(dVar, null, 10);
        final int i10 = 2;
        y.q(viewModelScope, dVar2, null, cVar, 2);
        TextView textView = this.f11096b;
        if (textView != null) {
            d dVar3 = this.f10069o;
            if (dVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            textView.setText(l1.b.c(dVar3.f10071a.f().f7563a));
        }
        ImageView imageView = this.f11097c;
        if (imageView != null) {
            imageView.setOnClickListener(new e5.s(this, 4));
            d dVar4 = this.f10069o;
            if (dVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(dVar4.f10071a.f().g);
        }
        d dVar5 = this.f10069o;
        if (dVar5 == null) {
            l.i("viewModel");
            throw null;
        }
        final int i11 = 0;
        if (!dVar5.e().isEmpty() || !dVar5.b().isEmpty()) {
            Toolbar toolbar = this.f11095a;
            final ImageView imageView2 = toolbar == null ? null : (ImageView) toolbar.findViewById(R.id.toolbar_menu);
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.list_partner_menu, (ViewGroup) null);
            final CardView cardView = (CardView) viewInflate.findViewById(R.id.cv_menu_item);
            final TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_menu_all);
            final TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_menu_iab);
            final TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_menu_non_iab);
            final TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_menu_google);
            d dVar6 = this.f10069o;
            if (dVar6 == null) {
                l.i("viewModel");
                throw null;
            }
            if (dVar6.e().isEmpty()) {
                textView4.setVisibility(8);
            }
            d dVar7 = this.f10069o;
            if (dVar7 == null) {
                l.i("viewModel");
                throw null;
            }
            if (dVar7.b().isEmpty()) {
                textView5.setVisibility(8);
            }
            final int i12 = 1;
            final PopupWindow popupWindow = new PopupWindow(viewInflate, 600, -2, true);
            popupWindow.setElevation(10.0f);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: k6.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i11) {
                        case 0:
                            popupWindow.dismiss();
                            c cVar2 = this;
                            TextView textView6 = cVar2.f11096b;
                            if (textView6 != null) {
                                textView6.setText(cVar2.getString(R.string.all_partners_toolbar_title));
                            }
                            d dVar8 = cVar2.f10069o;
                            if (dVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar8.f10076j = 1;
                            cVar2.a();
                            return;
                        case 1:
                            popupWindow.dismiss();
                            c cVar3 = this;
                            TextView textView7 = cVar3.f11096b;
                            if (textView7 != null) {
                                textView7.setText(cVar3.getString(R.string.iab_partners_toolbar_title));
                            }
                            d dVar9 = cVar3.f10069o;
                            if (dVar9 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar9.f10076j = 2;
                            cVar3.a();
                            return;
                        case 2:
                            popupWindow.dismiss();
                            c cVar4 = this;
                            TextView textView8 = cVar4.f11096b;
                            if (textView8 != null) {
                                textView8.setText(cVar4.getString(R.string.non_iab_partners_toolbar_title));
                            }
                            d dVar10 = cVar4.f10069o;
                            if (dVar10 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar10.f10076j = 3;
                            cVar4.a();
                            return;
                        default:
                            popupWindow.dismiss();
                            c cVar5 = this;
                            TextView textView9 = cVar5.f11096b;
                            if (textView9 != null) {
                                textView9.setText(cVar5.getString(R.string.google_partners_toolbar_title));
                            }
                            d dVar11 = cVar5.f10069o;
                            if (dVar11 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar11.f10076j = 4;
                            cVar5.a();
                            return;
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: k6.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i12) {
                        case 0:
                            popupWindow.dismiss();
                            c cVar2 = this;
                            TextView textView6 = cVar2.f11096b;
                            if (textView6 != null) {
                                textView6.setText(cVar2.getString(R.string.all_partners_toolbar_title));
                            }
                            d dVar8 = cVar2.f10069o;
                            if (dVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar8.f10076j = 1;
                            cVar2.a();
                            return;
                        case 1:
                            popupWindow.dismiss();
                            c cVar3 = this;
                            TextView textView7 = cVar3.f11096b;
                            if (textView7 != null) {
                                textView7.setText(cVar3.getString(R.string.iab_partners_toolbar_title));
                            }
                            d dVar9 = cVar3.f10069o;
                            if (dVar9 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar9.f10076j = 2;
                            cVar3.a();
                            return;
                        case 2:
                            popupWindow.dismiss();
                            c cVar4 = this;
                            TextView textView8 = cVar4.f11096b;
                            if (textView8 != null) {
                                textView8.setText(cVar4.getString(R.string.non_iab_partners_toolbar_title));
                            }
                            d dVar10 = cVar4.f10069o;
                            if (dVar10 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar10.f10076j = 3;
                            cVar4.a();
                            return;
                        default:
                            popupWindow.dismiss();
                            c cVar5 = this;
                            TextView textView9 = cVar5.f11096b;
                            if (textView9 != null) {
                                textView9.setText(cVar5.getString(R.string.google_partners_toolbar_title));
                            }
                            d dVar11 = cVar5.f10069o;
                            if (dVar11 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar11.f10076j = 4;
                            cVar5.a();
                            return;
                    }
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() { // from class: k6.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i10) {
                        case 0:
                            popupWindow.dismiss();
                            c cVar2 = this;
                            TextView textView6 = cVar2.f11096b;
                            if (textView6 != null) {
                                textView6.setText(cVar2.getString(R.string.all_partners_toolbar_title));
                            }
                            d dVar8 = cVar2.f10069o;
                            if (dVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar8.f10076j = 1;
                            cVar2.a();
                            return;
                        case 1:
                            popupWindow.dismiss();
                            c cVar3 = this;
                            TextView textView7 = cVar3.f11096b;
                            if (textView7 != null) {
                                textView7.setText(cVar3.getString(R.string.iab_partners_toolbar_title));
                            }
                            d dVar9 = cVar3.f10069o;
                            if (dVar9 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar9.f10076j = 2;
                            cVar3.a();
                            return;
                        case 2:
                            popupWindow.dismiss();
                            c cVar4 = this;
                            TextView textView8 = cVar4.f11096b;
                            if (textView8 != null) {
                                textView8.setText(cVar4.getString(R.string.non_iab_partners_toolbar_title));
                            }
                            d dVar10 = cVar4.f10069o;
                            if (dVar10 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar10.f10076j = 3;
                            cVar4.a();
                            return;
                        default:
                            popupWindow.dismiss();
                            c cVar5 = this;
                            TextView textView9 = cVar5.f11096b;
                            if (textView9 != null) {
                                textView9.setText(cVar5.getString(R.string.google_partners_toolbar_title));
                            }
                            d dVar11 = cVar5.f10069o;
                            if (dVar11 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar11.f10076j = 4;
                            cVar5.a();
                            return;
                    }
                }
            });
            final int i13 = 3;
            textView5.setOnClickListener(new View.OnClickListener() { // from class: k6.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i13) {
                        case 0:
                            popupWindow.dismiss();
                            c cVar2 = this;
                            TextView textView6 = cVar2.f11096b;
                            if (textView6 != null) {
                                textView6.setText(cVar2.getString(R.string.all_partners_toolbar_title));
                            }
                            d dVar8 = cVar2.f10069o;
                            if (dVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar8.f10076j = 1;
                            cVar2.a();
                            return;
                        case 1:
                            popupWindow.dismiss();
                            c cVar3 = this;
                            TextView textView7 = cVar3.f11096b;
                            if (textView7 != null) {
                                textView7.setText(cVar3.getString(R.string.iab_partners_toolbar_title));
                            }
                            d dVar9 = cVar3.f10069o;
                            if (dVar9 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar9.f10076j = 2;
                            cVar3.a();
                            return;
                        case 2:
                            popupWindow.dismiss();
                            c cVar4 = this;
                            TextView textView8 = cVar4.f11096b;
                            if (textView8 != null) {
                                textView8.setText(cVar4.getString(R.string.non_iab_partners_toolbar_title));
                            }
                            d dVar10 = cVar4.f10069o;
                            if (dVar10 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar10.f10076j = 3;
                            cVar4.a();
                            return;
                        default:
                            popupWindow.dismiss();
                            c cVar5 = this;
                            TextView textView9 = cVar5.f11096b;
                            if (textView9 != null) {
                                textView9.setText(cVar5.getString(R.string.google_partners_toolbar_title));
                            }
                            d dVar11 = cVar5.f10069o;
                            if (dVar11 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            dVar11.f10076j = 4;
                            cVar5.a();
                            return;
                    }
                }
            });
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: k6.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Integer num2;
                        Integer num3;
                        c cVar2 = this.f10063a;
                        d9.d dVar8 = cVar2.f11100j;
                        if (dVar8 != null && (num3 = dVar8.g) != null) {
                            cardView.setBackgroundTintList(ColorStateList.valueOf(num3.intValue()));
                        }
                        d9.d dVar9 = cVar2.f11100j;
                        if (dVar9 != null && (num2 = dVar9.f7477k) != null) {
                            int iIntValue = num2.intValue();
                            textView2.setTextColor(ColorStateList.valueOf(iIntValue));
                            textView3.setTextColor(ColorStateList.valueOf(iIntValue));
                            textView4.setTextColor(ColorStateList.valueOf(iIntValue));
                            textView5.setTextColor(ColorStateList.valueOf(iIntValue));
                        }
                        popupWindow.showAsDropDown(imageView2);
                    }
                });
            }
        }
        SearchView searchView2 = this.e;
        if (searchView2 != null) {
            searchView2.setVisibility(0);
        }
        SearchView searchView3 = this.e;
        if (searchView3 != null) {
            d dVar8 = this.f10069o;
            if (dVar8 == null) {
                l.i("viewModel");
                throw null;
            }
            searchView3.setQueryHint(dVar8.f10071a.f().f7565c);
        }
        SearchView searchView4 = this.e;
        if (searchView4 != null) {
            searchView4.setOnQueryTextListener(new y2.c(this, 20));
        }
        d dVar9 = this.f10069o;
        if (dVar9 == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList arrayListC = dVar9.c("");
        d dVar10 = this.f10069o;
        if (dVar10 == null) {
            l.i("viewModel");
            throw null;
        }
        String str = dVar10.f10071a.f().f7564b;
        d9.d dVar11 = this.f11100j;
        this.f10070p = new g(arrayListC, this, str, dVar11 == null ? null : dVar11.f7475i, dVar11 == null ? null : dVar11.e, dVar11 == null ? null : dVar11.f, dVar11 == null ? null : dVar11.f7471a, this.f11101k, this.f11102l, 8);
        RecyclerView recyclerView = this.f10068n;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            g gVar = this.f10070p;
            if (gVar == null) {
                l.i("switchAdapter");
                throw null;
            }
            recyclerView.setAdapter(gVar);
        }
        d9.d dVar12 = this.f11100j;
        if (dVar12 != null && (num = dVar12.g) != null) {
            int iIntValue = num.intValue();
            ConstraintLayout constraintLayout = this.f10067m;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(iIntValue);
            }
        }
        d dVar13 = this.f10069o;
        if (dVar13 == null) {
            l.i("viewModel");
            throw null;
        }
        if (!dVar13.f10077k || (searchView = this.e) == null) {
            return;
        }
        searchView.requestFocus();
    }
}
