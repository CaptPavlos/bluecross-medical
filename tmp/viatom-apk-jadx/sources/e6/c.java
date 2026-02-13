package e6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import b9.s;
import com.uptodown.R;
import f6.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import k8.e;
import k8.h;
import kotlin.jvm.internal.l;
import l9.n;
import o7.u;
import o8.g;
import o8.i;
import r0.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends l9.a implements c.b {
    public TextView A;
    public d B;
    public n C;

    /* renamed from: m, reason: collision with root package name */
    public RecyclerView f7927m;

    /* renamed from: n, reason: collision with root package name */
    public RecyclerView f7928n;

    /* renamed from: o, reason: collision with root package name */
    public RecyclerView f7929o;

    /* renamed from: p, reason: collision with root package name */
    public RecyclerView f7930p;

    /* renamed from: q, reason: collision with root package name */
    public ConstraintLayout f7931q;

    /* renamed from: r, reason: collision with root package name */
    public LinearLayout f7932r;

    /* renamed from: s, reason: collision with root package name */
    public LinearLayout f7933s;
    public Button t;

    /* renamed from: u, reason: collision with root package name */
    public Button f7934u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f7935v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f7936w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f7937x;
    public TextView y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f7938z;

    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Iterable, java.lang.Object] */
    public final String a() {
        int size;
        LinkedHashMap linkedHashMap;
        d dVar = this.B;
        if (dVar == null) {
            l.i("viewModel");
            throw null;
        }
        i iVar = dVar.f7940b;
        k8.c cVar = dVar.f7939a.f8097a;
        if (cVar == null || (linkedHashMap = cVar.h) == null) {
            size = 0;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((h) entry.getValue()).f10098k == null) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            size = linkedHashMap2.size();
        }
        ?? r6 = iVar.f11815c.f11810a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : r6) {
            Set setU0 = t6.l.u0(((g) obj).f);
            ?? r10 = iVar.f11814b.h;
            if (!setU0.isEmpty()) {
                Iterator it = setU0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (r10.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        String strValueOf = String.valueOf(dVar.f7941c.f8073a.size() + arrayList.size() + size + (dVar.f7942d != null ? 1 : 0));
        d dVar2 = this.B;
        if (dVar2 == null) {
            l.i("viewModel");
            throw null;
        }
        String strB0 = u.b0(dVar2.f.e().f7538b, "${partners}", strValueOf, true);
        String string = getString(R.string.consent_storage_method);
        string.getClass();
        return u.b0(u.b0(strB0, "${consentStorageMethod}", string, true), "${consentStorageDuration}", "13", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b
    public final void g(c.h hVar) {
        k8.d dVar = hVar.f964a;
        FragmentActivity activity = getActivity();
        if (activity != null && (dVar instanceof e) && activity.getSupportFragmentManager().findFragmentByTag("j") == null) {
            FragmentTransaction fragmentTransactionBeginTransaction = activity.getSupportFragmentManager().beginTransaction();
            String str = dVar.f10089b;
            e eVar = (e) dVar;
            String strA = eVar.a();
            String strB = eVar.b();
            d dVar2 = this.B;
            if (dVar2 == null) {
                l.i("viewModel");
                throw null;
            }
            String str2 = dVar2.f.e().f7541i;
            d dVar3 = this.B;
            if (dVar3 != null) {
                fragmentTransactionBeginTransaction.add(f.f(str, strA, strB, str2, dVar3.f.e().f7546n, dVar.f10088a, hVar.f967d, false, 1), "j").commit();
            } else {
                l.i("viewModel");
                throw null;
            }
        }
    }

    @Override // c.b
    public final void h(c.h hVar) {
        k8.d dVar = hVar.f964a;
        d dVar2 = this.B;
        if (dVar2 == null) {
            l.i("viewModel");
            throw null;
        }
        m mVar = dVar2.f7939a;
        if (dVar instanceof k8.f) {
            int i10 = dVar.f10088a;
            Boolean bool = hVar.f965b;
            Boolean bool2 = Boolean.TRUE;
            if (l.a(bool, bool2)) {
                mVar.f8110r.set(i10);
            } else {
                mVar.f8110r.unset(i10);
            }
            UUID uuid = s.f936a;
            String strValueOf = String.valueOf(l.a(hVar.f965b, bool2));
            strValueOf.getClass();
            s.f937b.h("Purposes_" + i10, strValueOf);
            return;
        }
        if (dVar instanceof k8.b) {
            int i11 = dVar.f10088a;
            Boolean bool3 = hVar.f965b;
            Boolean bool4 = Boolean.TRUE;
            if (l.a(bool3, bool4)) {
                mVar.f8109q.set(i11);
            } else {
                mVar.f8109q.unset(i11);
            }
            UUID uuid2 = s.f936a;
            String strValueOf2 = String.valueOf(l.a(hVar.f965b, bool4));
            strValueOf2.getClass();
            s.f937b.h("Special Features_" + i11, strValueOf2);
        }
    }

    @Override // l9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = activity.getViewModelStore();
        viewModelStore.getClass();
        d dVar = (d) new ViewModelProvider(viewModelStore, new c6.i(1)).get(d.class);
        this.B = dVar;
        if (dVar != null) {
            dVar.f7949o.observe(this, new b(this, 0));
        } else {
            l.i("viewModel");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_options, viewGroup, false);
        viewInflate.getClass();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getClass();
        if (menuItem.getItemId() == 16908332) {
            requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0234  */
    @Override // l9.a, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onViewCreated(android.view.View r20, android.os.Bundle r21) {
        /*
            Method dump skipped, instructions count: 1446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.c.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
