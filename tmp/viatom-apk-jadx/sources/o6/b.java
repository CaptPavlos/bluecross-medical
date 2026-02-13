package o6;

import android.R;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.g;
import c.h;
import c.i;
import e6.d;
import f6.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import k8.e;
import kotlin.jvm.internal.l;
import r0.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends l9.a implements c.b {

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f11737v = 0;

    /* renamed from: m, reason: collision with root package name */
    public Button f11738m;

    /* renamed from: n, reason: collision with root package name */
    public Button f11739n;

    /* renamed from: o, reason: collision with root package name */
    public RecyclerView f11740o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f11741p;

    /* renamed from: q, reason: collision with root package name */
    public ConstraintLayout f11742q;

    /* renamed from: r, reason: collision with root package name */
    public int f11743r;

    /* renamed from: s, reason: collision with root package name */
    public g f11744s;
    public c t;

    /* renamed from: u, reason: collision with root package name */
    public d f11745u;

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
        Button button = this.f11739n;
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
        Button button2 = this.f11738m;
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
        g gVar = this.f11744s;
        if (gVar == null) {
            l.i("switchAdapter");
            throw null;
        }
        c cVar = this.t;
        if (cVar == null) {
            l.i("viewModel");
            throw null;
        }
        int i10 = this.f11743r;
        ArrayList arrayListC = cVar.c(i10);
        arrayListC.addAll(cVar.d(i10));
        gVar.f958a = arrayListC;
        gVar.notifyDataSetChanged();
        c cVar2 = this.t;
        if (cVar2 != null) {
            b(cVar2.b(this.f11743r));
        } else {
            l.i("viewModel");
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b
    public final void g(h hVar) {
        k8.d dVar = hVar.f964a;
        FragmentActivity activity = getActivity();
        if (activity != null && (dVar instanceof e) && activity.getSupportFragmentManager().findFragmentByTag("j") == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = activity.getSupportFragmentManager().beginTransaction();
            String str = dVar.f10089b;
            e eVar = (e) dVar;
            String strA = eVar.a();
            String strB = eVar.b();
            c cVar = this.t;
            if (cVar == null) {
                l.i("viewModel");
                throw null;
            }
            String str2 = cVar.a().f7581b;
            c cVar2 = this.t;
            if (cVar2 != null) {
                fragmentTransactionBeginTransaction.add(f.f(str, strA, strB, str2, cVar2.a().e, dVar.f10088a, hVar.f967d, false, 1), "j").commit();
            } else {
                l.i("viewModel");
                throw null;
            }
        }
    }

    @Override // c.b
    public final void h(h hVar) {
        k8.d dVar = hVar.f964a;
        c cVar = this.t;
        if (cVar == null) {
            l.i("viewModel");
            throw null;
        }
        m mVar = cVar.f11746a;
        int iC = i.c(hVar.f967d);
        if (iC != 4) {
            if (iC == 7) {
                if (l.a(hVar.f965b, Boolean.TRUE)) {
                    mVar.f8109q.set(dVar.f10088a);
                } else {
                    mVar.f8109q.unset(dVar.f10088a);
                }
            }
        } else if (l.a(hVar.f965b, Boolean.TRUE)) {
            mVar.f8110r.set(dVar.f10088a);
        } else {
            mVar.f8110r.unset(dVar.f10088a);
        }
        c cVar2 = this.t;
        if (cVar2 != null) {
            b(cVar2.b(this.f11743r));
        } else {
            l.i("viewModel");
            throw null;
        }
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
        this.t = (c) new ViewModelProvider(viewModelStore, new c6.i(9)).get(c.class);
        ViewModelStore viewModelStore2 = activity.getViewModelStore();
        viewModelStore2.getClass();
        this.f11745u = (d) new ViewModelProvider(viewModelStore2, new c6.i(1)).get(d.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(com.uptodown.R.layout.dialog_stacks, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onDismiss(dialogInterface);
        d dVar = this.f11745u;
        if (dVar != null) {
            dVar.f7949o.postValue(Boolean.TRUE);
        } else {
            l.i("optionsViewModel");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getClass();
        if (menuItem.getItemId() == 16908332) {
            requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // l9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Map map;
        k8.g gVar;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f11738m = (Button) view.findViewById(com.uptodown.R.id.btn_agree_to_all);
        this.f11739n = (Button) view.findViewById(com.uptodown.R.id.btn_disagree_to_all);
        this.f11740o = (RecyclerView) view.findViewById(com.uptodown.R.id.rv_switch_item_list);
        this.f11741p = (TextView) view.findViewById(com.uptodown.R.id.tv_stack_name);
        this.f11742q = (ConstraintLayout) view.findViewById(com.uptodown.R.id.stacks_container);
        Bundle arguments = getArguments();
        int i10 = arguments == null ? 0 : arguments.getInt("stack_id");
        this.f11743r = i10;
        TextView textView = this.f11741p;
        if (textView != null) {
            c cVar = this.t;
            if (cVar == null) {
                l.i("viewModel");
                throw null;
            }
            k8.c cVar2 = cVar.f11746a.f8097a;
            textView.setText((cVar2 == null || (map = cVar2.f10085i) == null || (gVar = (k8.g) map.get(String.valueOf(i10))) == null) ? null : gVar.f10089b);
        }
        TextView textView2 = this.f11096b;
        if (textView2 != null) {
            c cVar3 = this.t;
            if (cVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            textView2.setText(cVar3.a().f7580a);
        }
        ImageView imageView = this.f11097c;
        if (imageView != null) {
            final int i11 = 0;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: o6.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f11736b;

                {
                    this.f11736b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i12 = i11;
                    int i13 = 0;
                    b bVar = this.f11736b;
                    switch (i12) {
                        case 0:
                            bVar.dismiss();
                            return;
                        case 1:
                            c cVar4 = bVar.t;
                            if (cVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = cVar4.f11746a;
                            int i14 = bVar.f11743r;
                            ArrayList arrayListC = cVar4.c(i14);
                            int size = arrayListC.size();
                            int i15 = 0;
                            while (i15 < size) {
                                Object obj = arrayListC.get(i15);
                                i15++;
                                mVar.f8110r.unset(((h) obj).f964a.f10088a);
                            }
                            ArrayList arrayListD = cVar4.d(i14);
                            int size2 = arrayListD.size();
                            while (i13 < size2) {
                                Object obj2 = arrayListD.get(i13);
                                i13++;
                                mVar.f8109q.unset(((h) obj2).f964a.f10088a);
                            }
                            bVar.d();
                            return;
                        default:
                            c cVar5 = bVar.t;
                            if (cVar5 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = cVar5.f11746a;
                            int i16 = bVar.f11743r;
                            ArrayList arrayListC2 = cVar5.c(i16);
                            int size3 = arrayListC2.size();
                            int i17 = 0;
                            while (i17 < size3) {
                                Object obj3 = arrayListC2.get(i17);
                                i17++;
                                mVar2.f8110r.set(((h) obj3).f964a.f10088a);
                            }
                            ArrayList arrayListD2 = cVar5.d(i16);
                            int size4 = arrayListD2.size();
                            while (i13 < size4) {
                                Object obj4 = arrayListD2.get(i13);
                                i13++;
                                mVar2.f8109q.set(((h) obj4).f964a.f10088a);
                            }
                            bVar.d();
                            return;
                    }
                }
            });
            c cVar4 = this.t;
            if (cVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(cVar4.a().f);
        }
        d9.d dVar = this.f11100j;
        if (dVar != null) {
            Integer num = dVar.g;
            if (num != null) {
                int iIntValue = num.intValue();
                ConstraintLayout constraintLayout = this.f11742q;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(iIntValue);
                }
            }
            Integer num2 = dVar.f7475i;
            if (num2 != null) {
                int iIntValue2 = num2.intValue();
                TextView textView3 = this.f11741p;
                if (textView3 != null) {
                    textView3.setTextColor(iIntValue2);
                }
            }
            Typeface typeface = this.f11102l;
            if (typeface != null) {
                TextView textView4 = this.f11741p;
                if (textView4 != null) {
                    textView4.setTypeface(typeface);
                }
                Button button = this.f11738m;
                if (button != null) {
                    button.setTypeface(typeface);
                }
                Button button2 = this.f11739n;
                if (button2 != null) {
                    button2.setTypeface(typeface);
                }
            }
            Button button3 = this.f11738m;
            if (button3 != null) {
                ColorStateList colorStateListC = c();
                if (colorStateListC != null) {
                    button3.setTextColor(colorStateListC);
                }
                ColorStateList colorStateListA = a();
                if (colorStateListA != null) {
                    button3.setBackgroundTintList(colorStateListA);
                }
            }
            Button button4 = this.f11739n;
            if (button4 != null) {
                ColorStateList colorStateListC2 = c();
                if (colorStateListC2 != null) {
                    button4.setTextColor(colorStateListC2);
                }
                ColorStateList colorStateListA2 = a();
                if (colorStateListA2 != null) {
                    button4.setBackgroundTintList(colorStateListA2);
                }
            }
        }
        c cVar5 = this.t;
        if (cVar5 == null) {
            l.i("viewModel");
            throw null;
        }
        int i12 = this.f11743r;
        ArrayList arrayListC = cVar5.c(i12);
        arrayListC.addAll(cVar5.d(i12));
        d9.d dVar2 = this.f11100j;
        this.f11744s = new g(arrayListC, this, (String) null, dVar2 == null ? null : dVar2.f7475i, dVar2 == null ? null : dVar2.e, dVar2 == null ? null : dVar2.f, dVar2 == null ? null : dVar2.f7471a, (Typeface) null, this.f11102l, 268);
        RecyclerView recyclerView = this.f11740o;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            g gVar2 = this.f11744s;
            if (gVar2 == null) {
                l.i("switchAdapter");
                throw null;
            }
            recyclerView.setAdapter(gVar2);
        }
        Button button5 = this.f11739n;
        if (button5 != null) {
            button5.setText(getString(com.uptodown.R.string.disagree_to_all));
        }
        c cVar6 = this.t;
        if (cVar6 == null) {
            l.i("viewModel");
            throw null;
        }
        b(cVar6.b(this.f11743r));
        Button button6 = this.f11739n;
        if (button6 != null) {
            final int i13 = 1;
            button6.setOnClickListener(new View.OnClickListener(this) { // from class: o6.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f11736b;

                {
                    this.f11736b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i122 = i13;
                    int i132 = 0;
                    b bVar = this.f11736b;
                    switch (i122) {
                        case 0:
                            bVar.dismiss();
                            return;
                        case 1:
                            c cVar42 = bVar.t;
                            if (cVar42 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = cVar42.f11746a;
                            int i14 = bVar.f11743r;
                            ArrayList arrayListC2 = cVar42.c(i14);
                            int size = arrayListC2.size();
                            int i15 = 0;
                            while (i15 < size) {
                                Object obj = arrayListC2.get(i15);
                                i15++;
                                mVar.f8110r.unset(((h) obj).f964a.f10088a);
                            }
                            ArrayList arrayListD = cVar42.d(i14);
                            int size2 = arrayListD.size();
                            while (i132 < size2) {
                                Object obj2 = arrayListD.get(i132);
                                i132++;
                                mVar.f8109q.unset(((h) obj2).f964a.f10088a);
                            }
                            bVar.d();
                            return;
                        default:
                            c cVar52 = bVar.t;
                            if (cVar52 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = cVar52.f11746a;
                            int i16 = bVar.f11743r;
                            ArrayList arrayListC22 = cVar52.c(i16);
                            int size3 = arrayListC22.size();
                            int i17 = 0;
                            while (i17 < size3) {
                                Object obj3 = arrayListC22.get(i17);
                                i17++;
                                mVar2.f8110r.set(((h) obj3).f964a.f10088a);
                            }
                            ArrayList arrayListD2 = cVar52.d(i16);
                            int size4 = arrayListD2.size();
                            while (i132 < size4) {
                                Object obj4 = arrayListD2.get(i132);
                                i132++;
                                mVar2.f8109q.set(((h) obj4).f964a.f10088a);
                            }
                            bVar.d();
                            return;
                    }
                }
            });
        }
        Button button7 = this.f11738m;
        if (button7 != null) {
            c cVar7 = this.t;
            if (cVar7 == null) {
                l.i("viewModel");
                throw null;
            }
            button7.setText(cVar7.a().f7582c);
        }
        Button button8 = this.f11738m;
        if (button8 == null) {
            return;
        }
        final int i14 = 2;
        button8.setOnClickListener(new View.OnClickListener(this) { // from class: o6.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f11736b;

            {
                this.f11736b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i122 = i14;
                int i132 = 0;
                b bVar = this.f11736b;
                switch (i122) {
                    case 0:
                        bVar.dismiss();
                        return;
                    case 1:
                        c cVar42 = bVar.t;
                        if (cVar42 == null) {
                            l.i("viewModel");
                            throw null;
                        }
                        m mVar = cVar42.f11746a;
                        int i142 = bVar.f11743r;
                        ArrayList arrayListC2 = cVar42.c(i142);
                        int size = arrayListC2.size();
                        int i15 = 0;
                        while (i15 < size) {
                            Object obj = arrayListC2.get(i15);
                            i15++;
                            mVar.f8110r.unset(((h) obj).f964a.f10088a);
                        }
                        ArrayList arrayListD = cVar42.d(i142);
                        int size2 = arrayListD.size();
                        while (i132 < size2) {
                            Object obj2 = arrayListD.get(i132);
                            i132++;
                            mVar.f8109q.unset(((h) obj2).f964a.f10088a);
                        }
                        bVar.d();
                        return;
                    default:
                        c cVar52 = bVar.t;
                        if (cVar52 == null) {
                            l.i("viewModel");
                            throw null;
                        }
                        m mVar2 = cVar52.f11746a;
                        int i16 = bVar.f11743r;
                        ArrayList arrayListC22 = cVar52.c(i16);
                        int size3 = arrayListC22.size();
                        int i17 = 0;
                        while (i17 < size3) {
                            Object obj3 = arrayListC22.get(i17);
                            i17++;
                            mVar2.f8110r.set(((h) obj3).f964a.f10088a);
                        }
                        ArrayList arrayListD2 = cVar52.d(i16);
                        int size4 = arrayListD2.size();
                        while (i132 < size4) {
                            Object obj4 = arrayListD2.get(i132);
                            i132++;
                            mVar2.f8109q.set(((h) obj4).f964a.f10088a);
                        }
                        bVar.d();
                        return;
                }
            }
        });
    }
}
