package e5;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b2 extends Fragment {

    /* renamed from: d, reason: collision with root package name */
    public String f7689d;
    public n4.p0 e;

    /* renamed from: j, reason: collision with root package name */
    public final ActivityResultLauncher f7691j;

    /* renamed from: a, reason: collision with root package name */
    public final s6.m f7686a = new s6.m(new a3.i0(this, 14));

    /* renamed from: b, reason: collision with root package name */
    public final s6.f f7687b = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.y.a(f2.class), new a9.f(new a9.f(this, 5), 6), null);

    /* renamed from: c, reason: collision with root package name */
    public h5.k f7688c = new h5.k(0, (String) null, 7);
    public final w1 f = new w1(this);
    public final w1 g = new w1(this);
    public final v1 h = new v1(this);

    /* renamed from: i, reason: collision with root package name */
    public final v1 f7690i = new v1(this);

    public b2() {
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new androidx.core.view.inputmethod.a(this, 9));
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f7691j = activityResultLauncherRegisterForActivityResult;
    }

    public final d5.y0 a() {
        return (d5.y0) this.f7686a.getValue();
    }

    public final void b() {
        if (getContext() != null) {
            f2 f2VarD = d();
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            h5.k kVar = this.f7688c;
            f2VarD.getClass();
            kVar.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarD);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, y7.d.f14116a, null, new e2(f2VarD, contextRequireContext, kVar, null, 0), 2);
        }
    }

    public final int c(String str) {
        n4.p0 p0Var;
        int i10 = -1;
        if (str != null && str.length() != 0 && (p0Var = this.e) != null) {
            p0Var.getClass();
            Iterator it = p0Var.f11458k.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                int i12 = i11 + 1;
                Object obj = ((n4.n0) it.next()).f11441a;
                if (obj instanceof h5.h) {
                    obj.getClass();
                    String str2 = ((h5.h) obj).f8595w;
                    if (str2 != null && kotlin.jvm.internal.l.a(str2, str)) {
                        i10 = i11;
                    }
                }
                i11 = i12;
            }
        }
        return i10;
    }

    public final f2 d() {
        return (f2) this.f7687b.getValue();
    }

    public final void e(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a6.j(this, str, (w6.c) null, 15), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            h5.k kVar = (h5.k) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) bundle.getParcelable("category", h5.k.class) : bundle.getParcelable("category"));
            if (kVar != null) {
                this.f7688c = kVar;
            }
        }
        h5.k kVar2 = this.f7688c;
        if (kVar2.f8632a == 0) {
            kVar2.f8632a = -1;
        }
        a().f.setNavigationIcon(ContextCompat.getDrawable(requireContext(), R.drawable.core_vector_back));
        a().f.setNavigationContentDescription(getString(R.string.back));
        final int i10 = 1;
        a().f.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: e5.u1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b2 f7880b;

            {
                this.f7880b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentManager supportFragmentManager;
                int i11 = i10;
                b2 b2Var = this.f7880b;
                switch (i11) {
                    case 0:
                        float f = UptodownApp.E;
                        if (k4.c.s()) {
                            Context contextRequireContext = b2Var.requireContext();
                            contextRequireContext.getClass();
                            if (h5.c1.h(contextRequireContext) == null) {
                                Intent intent = new Intent(b2Var.requireContext(), (Class<?>) LoginActivity.class);
                                ActivityResultLauncher activityResultLauncher = b2Var.f7691j;
                                FragmentActivity fragmentActivityRequireActivity = b2Var.requireActivity();
                                fragmentActivityRequireActivity.getClass();
                                activityResultLauncher.launch(intent, k4.c.b(fragmentActivityRequireActivity));
                                break;
                            } else if (b2Var.d().f7750d.getValue() instanceof v5.l) {
                                Object value = b2Var.d().f7750d.getValue();
                                value.getClass();
                                if (!((Boolean) ((v5.l) value).f13168a).booleanValue()) {
                                    f2 f2VarD = b2Var.d();
                                    Context contextRequireContext2 = b2Var.requireContext();
                                    contextRequireContext2.getClass();
                                    int i12 = b2Var.f7688c.f8632a;
                                    f2VarD.getClass();
                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarD);
                                    y7.e eVar = r7.i0.f12407a;
                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new d2(contextRequireContext2, i12, f2VarD, null, 0), 2);
                                    break;
                                } else {
                                    f2 f2VarD2 = b2Var.d();
                                    Context contextRequireContext3 = b2Var.requireContext();
                                    contextRequireContext3.getClass();
                                    int i13 = b2Var.f7688c.f8632a;
                                    f2VarD2.getClass();
                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f2VarD2);
                                    y7.e eVar2 = r7.i0.f12407a;
                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new d2(contextRequireContext3, i13, f2VarD2, null, 2), 2);
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        if (!(b2Var.getActivity() instanceof MainActivity)) {
                            FragmentActivity activity = b2Var.getActivity();
                            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                                supportFragmentManager.popBackStack();
                                break;
                            }
                        } else {
                            FragmentActivity activity2 = b2Var.getActivity();
                            activity2.getClass();
                            ((MainActivity) activity2).P0();
                            break;
                        }
                        break;
                    default:
                        float f10 = UptodownApp.E;
                        if (k4.c.s()) {
                            b2Var.a().h.setVisibility(8);
                            b2Var.a().f7407d.setVisibility(0);
                            b2Var.a().g.setVisibility(8);
                            b2Var.b();
                            break;
                        }
                        break;
                }
            }
        });
        a().f7408i.setTypeface(o4.b.f11719r);
        a().h.setTypeface(o4.b.f11719r);
        final int i11 = 2;
        a().h.setOnClickListener(new View.OnClickListener(this) { // from class: e5.u1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b2 f7880b;

            {
                this.f7880b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentManager supportFragmentManager;
                int i112 = i11;
                b2 b2Var = this.f7880b;
                switch (i112) {
                    case 0:
                        float f = UptodownApp.E;
                        if (k4.c.s()) {
                            Context contextRequireContext = b2Var.requireContext();
                            contextRequireContext.getClass();
                            if (h5.c1.h(contextRequireContext) == null) {
                                Intent intent = new Intent(b2Var.requireContext(), (Class<?>) LoginActivity.class);
                                ActivityResultLauncher activityResultLauncher = b2Var.f7691j;
                                FragmentActivity fragmentActivityRequireActivity = b2Var.requireActivity();
                                fragmentActivityRequireActivity.getClass();
                                activityResultLauncher.launch(intent, k4.c.b(fragmentActivityRequireActivity));
                                break;
                            } else if (b2Var.d().f7750d.getValue() instanceof v5.l) {
                                Object value = b2Var.d().f7750d.getValue();
                                value.getClass();
                                if (!((Boolean) ((v5.l) value).f13168a).booleanValue()) {
                                    f2 f2VarD = b2Var.d();
                                    Context contextRequireContext2 = b2Var.requireContext();
                                    contextRequireContext2.getClass();
                                    int i12 = b2Var.f7688c.f8632a;
                                    f2VarD.getClass();
                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarD);
                                    y7.e eVar = r7.i0.f12407a;
                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new d2(contextRequireContext2, i12, f2VarD, null, 0), 2);
                                    break;
                                } else {
                                    f2 f2VarD2 = b2Var.d();
                                    Context contextRequireContext3 = b2Var.requireContext();
                                    contextRequireContext3.getClass();
                                    int i13 = b2Var.f7688c.f8632a;
                                    f2VarD2.getClass();
                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f2VarD2);
                                    y7.e eVar2 = r7.i0.f12407a;
                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new d2(contextRequireContext3, i13, f2VarD2, null, 2), 2);
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        if (!(b2Var.getActivity() instanceof MainActivity)) {
                            FragmentActivity activity = b2Var.getActivity();
                            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                                supportFragmentManager.popBackStack();
                                break;
                            }
                        } else {
                            FragmentActivity activity2 = b2Var.getActivity();
                            activity2.getClass();
                            ((MainActivity) activity2).P0();
                            break;
                        }
                        break;
                    default:
                        float f10 = UptodownApp.E;
                        if (k4.c.s()) {
                            b2Var.a().h.setVisibility(8);
                            b2Var.a().f7407d.setVisibility(0);
                            b2Var.a().g.setVisibility(8);
                            b2Var.b();
                            break;
                        }
                        break;
                }
            }
        });
        a().g.setTypeface(o4.b.f11720s);
        a().g.setVisibility(8);
        w6.c cVar = null;
        a().e.setItemAnimator(null);
        final int i12 = 0;
        a().e.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        if (this.f7688c.f8632a != -1) {
            a().e.setPadding(0, 0, 0, 0);
        }
        a().e.addOnScrollListener(new x1(this));
        if (this.f7688c.f8635d) {
            a().f7408i.setVisibility(4);
            a().f7405b.setVisibility(0);
            a().f7405b.setOnClickListener(new View.OnClickListener(this) { // from class: e5.u1

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b2 f7880b;

                {
                    this.f7880b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentManager supportFragmentManager;
                    int i112 = i12;
                    b2 b2Var = this.f7880b;
                    switch (i112) {
                        case 0:
                            float f = UptodownApp.E;
                            if (k4.c.s()) {
                                Context contextRequireContext = b2Var.requireContext();
                                contextRequireContext.getClass();
                                if (h5.c1.h(contextRequireContext) == null) {
                                    Intent intent = new Intent(b2Var.requireContext(), (Class<?>) LoginActivity.class);
                                    ActivityResultLauncher activityResultLauncher = b2Var.f7691j;
                                    FragmentActivity fragmentActivityRequireActivity = b2Var.requireActivity();
                                    fragmentActivityRequireActivity.getClass();
                                    activityResultLauncher.launch(intent, k4.c.b(fragmentActivityRequireActivity));
                                    break;
                                } else if (b2Var.d().f7750d.getValue() instanceof v5.l) {
                                    Object value = b2Var.d().f7750d.getValue();
                                    value.getClass();
                                    if (!((Boolean) ((v5.l) value).f13168a).booleanValue()) {
                                        f2 f2VarD = b2Var.d();
                                        Context contextRequireContext2 = b2Var.requireContext();
                                        contextRequireContext2.getClass();
                                        int i122 = b2Var.f7688c.f8632a;
                                        f2VarD.getClass();
                                        r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarD);
                                        y7.e eVar = r7.i0.f12407a;
                                        r7.y.q(viewModelScope, y7.d.f14116a, null, new d2(contextRequireContext2, i122, f2VarD, null, 0), 2);
                                        break;
                                    } else {
                                        f2 f2VarD2 = b2Var.d();
                                        Context contextRequireContext3 = b2Var.requireContext();
                                        contextRequireContext3.getClass();
                                        int i13 = b2Var.f7688c.f8632a;
                                        f2VarD2.getClass();
                                        r7.w viewModelScope2 = ViewModelKt.getViewModelScope(f2VarD2);
                                        y7.e eVar2 = r7.i0.f12407a;
                                        r7.y.q(viewModelScope2, y7.d.f14116a, null, new d2(contextRequireContext3, i13, f2VarD2, null, 2), 2);
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            if (!(b2Var.getActivity() instanceof MainActivity)) {
                                FragmentActivity activity = b2Var.getActivity();
                                if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                                    supportFragmentManager.popBackStack();
                                    break;
                                }
                            } else {
                                FragmentActivity activity2 = b2Var.getActivity();
                                activity2.getClass();
                                ((MainActivity) activity2).P0();
                                break;
                            }
                            break;
                        default:
                            float f10 = UptodownApp.E;
                            if (k4.c.s()) {
                                b2Var.a().h.setVisibility(8);
                                b2Var.a().f7407d.setVisibility(0);
                                b2Var.a().g.setVisibility(8);
                                b2Var.b();
                                break;
                            }
                            break;
                    }
                }
            });
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        s7.c cVar2 = w7.n.f13548a;
        r7.y.q(lifecycleScope, cVar2, null, new z1(this, cVar, i12), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new z1(this, cVar, i10), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        RelativeLayout relativeLayout = a().f7404a;
        relativeLayout.getClass();
        return relativeLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.e == null) {
            b();
            return;
        }
        if (a().e.getAdapter() == null) {
            a().e.setAdapter(this.e);
            return;
        }
        n4.p0 p0Var = this.e;
        if (p0Var != null) {
            p0Var.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        bundle.putParcelable("category", this.f7688c);
        super.onSaveInstanceState(bundle);
    }
}
