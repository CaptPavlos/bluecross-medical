package l;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
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
import d5.n;
import f6.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.l;
import r0.f;
import r7.i0;
import r7.w;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class d extends l9.a implements c.b {

    /* renamed from: m, reason: collision with root package name */
    public ConstraintLayout f10149m;

    /* renamed from: n, reason: collision with root package name */
    public Button f10150n;

    /* renamed from: o, reason: collision with root package name */
    public Button f10151o;

    /* renamed from: p, reason: collision with root package name */
    public RecyclerView f10152p;

    /* renamed from: q, reason: collision with root package name */
    public e f10153q;

    /* renamed from: r, reason: collision with root package name */
    public e6.d f10154r;

    /* renamed from: s, reason: collision with root package name */
    public g f10155s;

    public final ColorStateList a() {
        d9.d dVar = this.f11100j;
        if (dVar == null) {
            return null;
        }
        Integer num = dVar.f7482p;
        Integer num2 = dVar.f7481o;
        if (num2 == null || num == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{num2.intValue(), num.intValue()});
    }

    public final void b(LinkedHashSet linkedHashSet) {
        boolean z9;
        Button button = this.f10151o;
        boolean z10 = false;
        if (button != null) {
            if (linkedHashSet.isEmpty()) {
                z9 = false;
                button.setEnabled(z9);
            } else {
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    if (((Boolean) it.next()).booleanValue()) {
                        z9 = true;
                        break;
                    }
                }
                z9 = false;
                button.setEnabled(z9);
            }
        }
        Button button2 = this.f10150n;
        if (button2 == null) {
            return;
        }
        if (!linkedHashSet.isEmpty()) {
            Iterator it2 = linkedHashSet.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (!((Boolean) it2.next()).booleanValue()) {
                    z10 = true;
                    break;
                }
            }
        }
        button2.setEnabled(z10);
    }

    public final ColorStateList c() {
        d9.d dVar = this.f11100j;
        if (dVar == null) {
            return null;
        }
        Integer num = dVar.f7480n;
        Integer num2 = dVar.f7479m;
        if (num2 == null || num == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{num2.intValue(), num.intValue()});
    }

    public final void d() {
        g gVar = this.f10155s;
        if (gVar == null) {
            l.i("switchAdapter");
            throw null;
        }
        e eVar = this.f10153q;
        if (eVar == null) {
            l.i("viewModel");
            throw null;
        }
        gVar.f958a = eVar.b("");
        gVar.a();
        gVar.notifyDataSetChanged();
        SearchView searchView = this.e;
        if (searchView != null) {
            searchView.setQuery("", false);
        }
        e eVar2 = this.f10153q;
        if (eVar2 != null) {
            b(eVar2.c());
        } else {
            l.i("viewModel");
            throw null;
        }
    }

    public final void e() {
        CharSequence query;
        SearchView searchView = this.e;
        if (searchView == null || (query = searchView.getQuery()) == null) {
            return;
        }
        g gVar = this.f10155s;
        if (gVar == null) {
            l.i("switchAdapter");
            throw null;
        }
        e eVar = this.f10153q;
        if (eVar == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList arrayListB = eVar.b(query.toString());
        boolean z9 = query.length() > 0;
        gVar.f958a = arrayListB;
        if (!z9) {
            gVar.a();
        }
        gVar.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b
    public final void g(h hVar) {
        String str;
        String str2;
        String string;
        String string2;
        k8.d dVar = hVar.f964a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (!(dVar instanceof k8.h)) {
            if ((dVar instanceof k8.e) && activity.getSupportFragmentManager().findFragmentByTag("j") == null) {
                FragmentTransaction fragmentTransactionBeginTransaction = activity.getSupportFragmentManager().beginTransaction();
                String str3 = dVar.f10089b;
                k8.e eVar = (k8.e) dVar;
                String strA = eVar.a();
                String strB = eVar.b();
                e6.d dVar2 = this.f10154r;
                if (dVar2 == null) {
                    l.i("optionsViewModel");
                    throw null;
                }
                String str4 = dVar2.f.e().f7541i;
                e6.d dVar3 = this.f10154r;
                if (dVar3 == null) {
                    l.i("optionsViewModel");
                    throw null;
                }
                String str5 = dVar3.f.e().f7546n;
                int i10 = dVar.f10088a;
                int i11 = hVar.f967d;
                e eVar2 = this.f10153q;
                if (eVar2 != null) {
                    fragmentTransactionBeginTransaction.add(f.f(str3, strA, strB, str4, str5, i10, i11, true, eVar2.f10161j), "j").commit();
                    return;
                } else {
                    l.i("viewModel");
                    throw null;
                }
            }
            return;
        }
        if (activity.getSupportFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D) == null) {
            String str6 = dVar.f10089b;
            k8.h hVar2 = (k8.h) dVar;
            String str7 = hVar2.f10094c;
            e eVar3 = this.f10153q;
            if (eVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA2 = eVar3.a(hVar2.e, 1);
            e eVar4 = this.f10153q;
            if (eVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA3 = eVar4.a(hVar2.g, 2);
            e eVar5 = this.f10153q;
            if (eVar5 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA4 = eVar5.a(hVar2.h, 3);
            e eVar6 = this.f10153q;
            if (eVar6 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA5 = eVar6.a(hVar2.f10096i, 4);
            e eVar7 = this.f10153q;
            if (eVar7 == null) {
                l.i("viewModel");
                throw null;
            }
            String strA6 = eVar7.a(hVar2.f10101n, 5);
            String str8 = hVar2.f10097j;
            e eVar8 = this.f10153q;
            if (eVar8 == null) {
                l.i("viewModel");
                throw null;
            }
            n nVar = eVar8.f10159d;
            int i12 = hVar2.f10099l;
            if (i12 < 0) {
                str = str8;
                str2 = "viewModel";
                string = "";
            } else {
                str = str8;
                float f = i12 / 86400.0f;
                if (f >= 1.0f) {
                    StringBuilder sb = new StringBuilder();
                    if (Float.isNaN(f)) {
                        com.google.gson.internal.a.n("Cannot round NaN value.");
                        return;
                    }
                    str2 = "viewModel";
                    sb.append(Math.round(f));
                    sb.append(' ');
                    sb.append(nVar.g().f7555i);
                    string = sb.toString();
                } else {
                    str2 = "viewModel";
                    string = i12 + ' ' + nVar.g().f7556j;
                }
            }
            e eVar9 = this.f10153q;
            if (eVar9 == null) {
                l.i(str2);
                throw null;
            }
            n nVar2 = eVar9.f10159d;
            Boolean bool = hVar2.f10100m;
            String str9 = l.a(bool, Boolean.TRUE) ? nVar2.g().f7559m : l.a(bool, Boolean.FALSE) ? nVar2.g().f7560n : "";
            e2.c cVar = hVar2.f10102o;
            i6.b bVar = new i6.b(str6, str7, (String) null, strA2, strA3, strA4, strA5, strA6, str, string, str9, (cVar == null || (string2 = Integer.valueOf(cVar.f7630a).toString()) == null) ? "" : string2, dVar.f10088a, hVar.f967d, hVar2.f10103p, 4);
            i6.d dVar4 = new i6.d();
            Bundle bundle = new Bundle();
            bundle.putParcelable("partner_detail_args", bVar);
            dVar4.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().add(dVar4, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    @Override // c.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(c.h r10) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l.d.h(c.h):void");
    }

    @Override // l9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        this.f10153q = (e) new ViewModelProvider(viewModelStore, new i(7)).get(e.class);
        ViewModelStore viewModelStore2 = activity.getViewModelStore();
        viewModelStore2.getClass();
        this.f10154r = (e6.d) new ViewModelProvider(viewModelStore2, new i(1)).get(e6.d.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(com.uptodown.R.layout.dialog_leg_interest, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        e eVar = this.f10153q;
        if (eVar == null) {
            l.i("viewModel");
            throw null;
        }
        SearchView searchView = this.e;
        eVar.f10162k = searchView == null ? false : searchView.hasFocus();
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, java.util.Collection] */
    @Override // l9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        SearchView searchView;
        Integer num;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f10149m = (ConstraintLayout) view.findViewById(com.uptodown.R.id.leg_interest_container);
        this.f10150n = (Button) view.findViewById(com.uptodown.R.id.btn_remove_objections);
        this.f10151o = (Button) view.findViewById(com.uptodown.R.id.btn_object_to_all);
        this.f10152p = (RecyclerView) view.findViewById(com.uptodown.R.id.rv_vendors_leg_interest_list);
        e eVar = this.f10153q;
        if (eVar == null) {
            l.i("viewModel");
            throw null;
        }
        w viewModelScope = ViewModelKt.getViewModelScope(eVar);
        y7.e eVar2 = i0.f12407a;
        final int i10 = 2;
        y.q(viewModelScope, y7.d.f14116a, null, new a6.c(eVar, null, 11), 2);
        TextView textView = this.f11096b;
        if (textView != null) {
            e eVar3 = this.f10153q;
            if (eVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            textView.setText(eVar3.e().f7518a);
        }
        ImageView imageView = this.f11097c;
        final int i11 = 0;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: l.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f10141b;

                {
                    this.f10141b = this;
                }

                /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LinkedHashMap linkedHashMap;
                    LinkedHashMap linkedHashMap2;
                    int i12 = i11;
                    d dVar = this.f10141b;
                    switch (i12) {
                        case 0:
                            dVar.dismiss();
                            return;
                        case 1:
                            e eVar4 = dVar.f10153q;
                            if (eVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = eVar4.f10156a;
                            k8.c cVar = mVar.f8097a;
                            if (cVar != null && (linkedHashMap = cVar.h) != null) {
                                for (Map.Entry entry : linkedHashMap.entrySet()) {
                                    if (!((k8.h) entry.getValue()).e.isEmpty()) {
                                        mVar.C.unset(((k8.h) entry.getValue()).f10088a);
                                    }
                                }
                            }
                            for (o8.g gVar : eVar4.f10158c.f11810a) {
                                if (!gVar.g.isEmpty()) {
                                    mVar.D.unset(gVar.f11806a);
                                }
                            }
                            LinkedHashMap linkedHashMapG = eVar4.g();
                            if (linkedHashMapG != null) {
                                Iterator it = linkedHashMapG.entrySet().iterator();
                                while (it.hasNext()) {
                                    mVar.f8111s.unset(Integer.parseInt((String) ((Map.Entry) it.next()).getKey()));
                                }
                            }
                            mVar.f8114w.unsetAllOwnedItems();
                            UUID uuid = s.f936a;
                            i9.a.k();
                            s.f937b.h(androidx.constraintlayout.core.widgets.analyzer.a.H(9), "_legitimatePurposesConsents");
                            dVar.d();
                            return;
                        default:
                            e eVar5 = dVar.f10153q;
                            if (eVar5 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = eVar5.f10156a;
                            k8.c cVar2 = mVar2.f8097a;
                            if (cVar2 != null && (linkedHashMap2 = cVar2.h) != null) {
                                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                                    if (!((k8.h) entry2.getValue()).e.isEmpty()) {
                                        mVar2.C.set(((k8.h) entry2.getValue()).f10088a);
                                    }
                                }
                            }
                            for (o8.g gVar2 : eVar5.f10158c.f11810a) {
                                if (!gVar2.g.isEmpty()) {
                                    mVar2.D.set(gVar2.f11806a);
                                }
                            }
                            LinkedHashMap linkedHashMapG2 = eVar5.g();
                            if (linkedHashMapG2 != null) {
                                Iterator it2 = linkedHashMapG2.entrySet().iterator();
                                while (it2.hasNext()) {
                                    mVar2.f8111s.set(Integer.parseInt((String) ((Map.Entry) it2.next()).getKey()));
                                }
                            }
                            mVar2.f8114w.setAllOwnedItems();
                            UUID uuid2 = s.f936a;
                            i9.a.k();
                            s.f937b.h(androidx.constraintlayout.core.widgets.analyzer.a.H(8), "_legitimatePurposesConsents");
                            dVar.d();
                            return;
                    }
                }
            });
            e eVar4 = this.f10153q;
            if (eVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(eVar4.e().f7524k);
        }
        e eVar5 = this.f10153q;
        if (eVar5 == null) {
            l.i("viewModel");
            throw null;
        }
        final int i12 = 1;
        if (!eVar5.f10158c.f11810a.isEmpty()) {
            Toolbar toolbar = this.f11095a;
            final ImageView imageView2 = toolbar == null ? null : (ImageView) toolbar.findViewById(com.uptodown.R.id.toolbar_menu);
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            View viewInflate = LayoutInflater.from(getContext()).inflate(com.uptodown.R.layout.list_leg_interest_menu, (ViewGroup) null);
            final CardView cardView = (CardView) viewInflate.findViewById(com.uptodown.R.id.cv_menu_item);
            final TextView textView2 = (TextView) viewInflate.findViewById(com.uptodown.R.id.tv_menu_all);
            final TextView textView3 = (TextView) viewInflate.findViewById(com.uptodown.R.id.tv_menu_iab);
            final TextView textView4 = (TextView) viewInflate.findViewById(com.uptodown.R.id.tv_menu_non_iab);
            final PopupWindow popupWindow = new PopupWindow(viewInflate, 600, -2, true);
            popupWindow.setElevation(10.0f);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: l.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i11) {
                        case 0:
                            popupWindow.dismiss();
                            d dVar = this;
                            TextView textView5 = dVar.f11096b;
                            if (textView5 != null) {
                                textView5.setText(dVar.getString(com.uptodown.R.string.leg_interest_all_partners_toolbar_title));
                            }
                            e eVar6 = dVar.f10153q;
                            if (eVar6 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar6.f10161j = 1;
                            dVar.e();
                            return;
                        case 1:
                            popupWindow.dismiss();
                            d dVar2 = this;
                            TextView textView6 = dVar2.f11096b;
                            if (textView6 != null) {
                                textView6.setText(dVar2.getString(com.uptodown.R.string.leg_interest_iab_partners_toolbar_title));
                            }
                            e eVar7 = dVar2.f10153q;
                            if (eVar7 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar7.f10161j = 2;
                            dVar2.e();
                            return;
                        default:
                            popupWindow.dismiss();
                            d dVar3 = this;
                            TextView textView7 = dVar3.f11096b;
                            if (textView7 != null) {
                                textView7.setText(dVar3.getString(com.uptodown.R.string.leg_interest_non_iab_partners_toolbar_title));
                            }
                            e eVar8 = dVar3.f10153q;
                            if (eVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar8.f10161j = 3;
                            dVar3.e();
                            return;
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: l.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i12) {
                        case 0:
                            popupWindow.dismiss();
                            d dVar = this;
                            TextView textView5 = dVar.f11096b;
                            if (textView5 != null) {
                                textView5.setText(dVar.getString(com.uptodown.R.string.leg_interest_all_partners_toolbar_title));
                            }
                            e eVar6 = dVar.f10153q;
                            if (eVar6 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar6.f10161j = 1;
                            dVar.e();
                            return;
                        case 1:
                            popupWindow.dismiss();
                            d dVar2 = this;
                            TextView textView6 = dVar2.f11096b;
                            if (textView6 != null) {
                                textView6.setText(dVar2.getString(com.uptodown.R.string.leg_interest_iab_partners_toolbar_title));
                            }
                            e eVar7 = dVar2.f10153q;
                            if (eVar7 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar7.f10161j = 2;
                            dVar2.e();
                            return;
                        default:
                            popupWindow.dismiss();
                            d dVar3 = this;
                            TextView textView7 = dVar3.f11096b;
                            if (textView7 != null) {
                                textView7.setText(dVar3.getString(com.uptodown.R.string.leg_interest_non_iab_partners_toolbar_title));
                            }
                            e eVar8 = dVar3.f10153q;
                            if (eVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar8.f10161j = 3;
                            dVar3.e();
                            return;
                    }
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() { // from class: l.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i10) {
                        case 0:
                            popupWindow.dismiss();
                            d dVar = this;
                            TextView textView5 = dVar.f11096b;
                            if (textView5 != null) {
                                textView5.setText(dVar.getString(com.uptodown.R.string.leg_interest_all_partners_toolbar_title));
                            }
                            e eVar6 = dVar.f10153q;
                            if (eVar6 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar6.f10161j = 1;
                            dVar.e();
                            return;
                        case 1:
                            popupWindow.dismiss();
                            d dVar2 = this;
                            TextView textView6 = dVar2.f11096b;
                            if (textView6 != null) {
                                textView6.setText(dVar2.getString(com.uptodown.R.string.leg_interest_iab_partners_toolbar_title));
                            }
                            e eVar7 = dVar2.f10153q;
                            if (eVar7 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar7.f10161j = 2;
                            dVar2.e();
                            return;
                        default:
                            popupWindow.dismiss();
                            d dVar3 = this;
                            TextView textView7 = dVar3.f11096b;
                            if (textView7 != null) {
                                textView7.setText(dVar3.getString(com.uptodown.R.string.leg_interest_non_iab_partners_toolbar_title));
                            }
                            e eVar8 = dVar3.f10153q;
                            if (eVar8 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            eVar8.f10161j = 3;
                            dVar3.e();
                            return;
                    }
                }
            });
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: l.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Integer num2;
                        Integer num3;
                        d dVar = this.f10145a;
                        d9.d dVar2 = dVar.f11100j;
                        if (dVar2 != null && (num3 = dVar2.g) != null) {
                            cardView.setBackgroundTintList(ColorStateList.valueOf(num3.intValue()));
                        }
                        d9.d dVar3 = dVar.f11100j;
                        if (dVar3 != null && (num2 = dVar3.f7477k) != null) {
                            int iIntValue = num2.intValue();
                            textView2.setTextColor(ColorStateList.valueOf(iIntValue));
                            textView3.setTextColor(ColorStateList.valueOf(iIntValue));
                            textView4.setTextColor(ColorStateList.valueOf(iIntValue));
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
            e eVar6 = this.f10153q;
            if (eVar6 == null) {
                l.i("viewModel");
                throw null;
            }
            searchView3.setQueryHint(eVar6.e().f);
        }
        SearchView searchView4 = this.e;
        if (searchView4 != null) {
            searchView4.setOnQueryTextListener(new d0.i(this, 21));
        }
        e eVar7 = this.f10153q;
        if (eVar7 == null) {
            l.i("viewModel");
            throw null;
        }
        ArrayList arrayListB = eVar7.b("");
        e eVar8 = this.f10153q;
        if (eVar8 == null) {
            l.i("viewModel");
            throw null;
        }
        String str = eVar8.e().f7519b;
        e eVar9 = this.f10153q;
        if (eVar9 == null) {
            l.i("viewModel");
            throw null;
        }
        String str2 = eVar9.e().f7520c;
        d9.d dVar = this.f11100j;
        this.f10155s = new g(arrayListB, this, str, str2, dVar == null ? null : dVar.f7475i, dVar == null ? null : dVar.e, dVar == null ? null : dVar.f, dVar == null ? null : dVar.f7471a, this.f11101k, this.f11102l);
        RecyclerView recyclerView = this.f10152p;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            g gVar = this.f10155s;
            if (gVar == null) {
                l.i("switchAdapter");
                throw null;
            }
            recyclerView.setAdapter(gVar);
        }
        Button button = this.f10151o;
        if (button != null) {
            e eVar10 = this.f10153q;
            if (eVar10 == null) {
                l.i("viewModel");
                throw null;
            }
            button.setText(eVar10.e().e);
        }
        e eVar11 = this.f10153q;
        if (eVar11 == null) {
            l.i("viewModel");
            throw null;
        }
        b(eVar11.c());
        Button button2 = this.f10151o;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener(this) { // from class: l.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f10141b;

                {
                    this.f10141b = this;
                }

                /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LinkedHashMap linkedHashMap;
                    LinkedHashMap linkedHashMap2;
                    int i122 = i12;
                    d dVar2 = this.f10141b;
                    switch (i122) {
                        case 0:
                            dVar2.dismiss();
                            return;
                        case 1:
                            e eVar42 = dVar2.f10153q;
                            if (eVar42 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = eVar42.f10156a;
                            k8.c cVar = mVar.f8097a;
                            if (cVar != null && (linkedHashMap = cVar.h) != null) {
                                for (Map.Entry entry : linkedHashMap.entrySet()) {
                                    if (!((k8.h) entry.getValue()).e.isEmpty()) {
                                        mVar.C.unset(((k8.h) entry.getValue()).f10088a);
                                    }
                                }
                            }
                            for (o8.g gVar2 : eVar42.f10158c.f11810a) {
                                if (!gVar2.g.isEmpty()) {
                                    mVar.D.unset(gVar2.f11806a);
                                }
                            }
                            LinkedHashMap linkedHashMapG = eVar42.g();
                            if (linkedHashMapG != null) {
                                Iterator it = linkedHashMapG.entrySet().iterator();
                                while (it.hasNext()) {
                                    mVar.f8111s.unset(Integer.parseInt((String) ((Map.Entry) it.next()).getKey()));
                                }
                            }
                            mVar.f8114w.unsetAllOwnedItems();
                            UUID uuid = s.f936a;
                            i9.a.k();
                            s.f937b.h(androidx.constraintlayout.core.widgets.analyzer.a.H(9), "_legitimatePurposesConsents");
                            dVar2.d();
                            return;
                        default:
                            e eVar52 = dVar2.f10153q;
                            if (eVar52 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = eVar52.f10156a;
                            k8.c cVar2 = mVar2.f8097a;
                            if (cVar2 != null && (linkedHashMap2 = cVar2.h) != null) {
                                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                                    if (!((k8.h) entry2.getValue()).e.isEmpty()) {
                                        mVar2.C.set(((k8.h) entry2.getValue()).f10088a);
                                    }
                                }
                            }
                            for (o8.g gVar22 : eVar52.f10158c.f11810a) {
                                if (!gVar22.g.isEmpty()) {
                                    mVar2.D.set(gVar22.f11806a);
                                }
                            }
                            LinkedHashMap linkedHashMapG2 = eVar52.g();
                            if (linkedHashMapG2 != null) {
                                Iterator it2 = linkedHashMapG2.entrySet().iterator();
                                while (it2.hasNext()) {
                                    mVar2.f8111s.set(Integer.parseInt((String) ((Map.Entry) it2.next()).getKey()));
                                }
                            }
                            mVar2.f8114w.setAllOwnedItems();
                            UUID uuid2 = s.f936a;
                            i9.a.k();
                            s.f937b.h(androidx.constraintlayout.core.widgets.analyzer.a.H(8), "_legitimatePurposesConsents");
                            dVar2.d();
                            return;
                    }
                }
            });
        }
        Button button3 = this.f10150n;
        if (button3 != null) {
            e eVar12 = this.f10153q;
            if (eVar12 == null) {
                l.i("viewModel");
                throw null;
            }
            button3.setText(eVar12.e().f7521d);
        }
        Button button4 = this.f10150n;
        if (button4 != null) {
            button4.setOnClickListener(new View.OnClickListener(this) { // from class: l.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d f10141b;

                {
                    this.f10141b = this;
                }

                /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Iterable, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LinkedHashMap linkedHashMap;
                    LinkedHashMap linkedHashMap2;
                    int i122 = i10;
                    d dVar2 = this.f10141b;
                    switch (i122) {
                        case 0:
                            dVar2.dismiss();
                            return;
                        case 1:
                            e eVar42 = dVar2.f10153q;
                            if (eVar42 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = eVar42.f10156a;
                            k8.c cVar = mVar.f8097a;
                            if (cVar != null && (linkedHashMap = cVar.h) != null) {
                                for (Map.Entry entry : linkedHashMap.entrySet()) {
                                    if (!((k8.h) entry.getValue()).e.isEmpty()) {
                                        mVar.C.unset(((k8.h) entry.getValue()).f10088a);
                                    }
                                }
                            }
                            for (o8.g gVar2 : eVar42.f10158c.f11810a) {
                                if (!gVar2.g.isEmpty()) {
                                    mVar.D.unset(gVar2.f11806a);
                                }
                            }
                            LinkedHashMap linkedHashMapG = eVar42.g();
                            if (linkedHashMapG != null) {
                                Iterator it = linkedHashMapG.entrySet().iterator();
                                while (it.hasNext()) {
                                    mVar.f8111s.unset(Integer.parseInt((String) ((Map.Entry) it.next()).getKey()));
                                }
                            }
                            mVar.f8114w.unsetAllOwnedItems();
                            UUID uuid = s.f936a;
                            i9.a.k();
                            s.f937b.h(androidx.constraintlayout.core.widgets.analyzer.a.H(9), "_legitimatePurposesConsents");
                            dVar2.d();
                            return;
                        default:
                            e eVar52 = dVar2.f10153q;
                            if (eVar52 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = eVar52.f10156a;
                            k8.c cVar2 = mVar2.f8097a;
                            if (cVar2 != null && (linkedHashMap2 = cVar2.h) != null) {
                                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                                    if (!((k8.h) entry2.getValue()).e.isEmpty()) {
                                        mVar2.C.set(((k8.h) entry2.getValue()).f10088a);
                                    }
                                }
                            }
                            for (o8.g gVar22 : eVar52.f10158c.f11810a) {
                                if (!gVar22.g.isEmpty()) {
                                    mVar2.D.set(gVar22.f11806a);
                                }
                            }
                            LinkedHashMap linkedHashMapG2 = eVar52.g();
                            if (linkedHashMapG2 != null) {
                                Iterator it2 = linkedHashMapG2.entrySet().iterator();
                                while (it2.hasNext()) {
                                    mVar2.f8111s.set(Integer.parseInt((String) ((Map.Entry) it2.next()).getKey()));
                                }
                            }
                            mVar2.f8114w.setAllOwnedItems();
                            UUID uuid2 = s.f936a;
                            i9.a.k();
                            s.f937b.h(androidx.constraintlayout.core.widgets.analyzer.a.H(8), "_legitimatePurposesConsents");
                            dVar2.d();
                            return;
                    }
                }
            });
        }
        d9.d dVar2 = this.f11100j;
        if (dVar2 != null && (num = dVar2.g) != null) {
            int iIntValue = num.intValue();
            ConstraintLayout constraintLayout = this.f10149m;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(iIntValue);
            }
        }
        Button button5 = this.f10151o;
        if (button5 != null) {
            ColorStateList colorStateListC = c();
            if (colorStateListC != null) {
                button5.setTextColor(colorStateListC);
            }
            ColorStateList colorStateListA = a();
            if (colorStateListA != null) {
                button5.setBackgroundTintList(colorStateListA);
            }
        }
        Button button6 = this.f10150n;
        if (button6 != null) {
            ColorStateList colorStateListC2 = c();
            if (colorStateListC2 != null) {
                button6.setTextColor(colorStateListC2);
            }
            ColorStateList colorStateListA2 = a();
            if (colorStateListA2 != null) {
                button6.setBackgroundTintList(colorStateListA2);
            }
        }
        Typeface typeface = this.f11102l;
        if (typeface != null) {
            Button button7 = this.f10151o;
            if (button7 != null) {
                button7.setTypeface(typeface);
            }
            Button button8 = this.f10150n;
            if (button8 != null) {
                button8.setTypeface(typeface);
            }
        }
        e eVar13 = this.f10153q;
        if (eVar13 == null) {
            l.i("viewModel");
            throw null;
        }
        if (!eVar13.f10162k || (searchView = this.e) == null) {
            return;
        }
        searchView.requestFocus();
    }
}
