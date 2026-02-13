package e5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h1<VB extends ViewBinding> extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public h5.k f7765a;

    /* renamed from: b, reason: collision with root package name */
    public n4.h f7766b;
    public h5.x0 e;
    public h5.x0 f;
    public boolean g;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f7767c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f7768d = new ArrayList();
    public final e1 h = new e1(this);

    /* renamed from: i, reason: collision with root package name */
    public final e1 f7769i = new e1(this);

    /* renamed from: j, reason: collision with root package name */
    public final f1 f7770j = new f1(this);

    /* renamed from: k, reason: collision with root package name */
    public final f1 f7771k = new f1(this);

    public abstract ViewBinding a();

    public abstract String b();

    public final void c() {
        if (this.g) {
            d().setVisibility(8);
            return;
        }
        this.g = true;
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        h5.k kVar = this.f7765a;
        kVar.getClass();
        w2.r rVar = new w2.r(contextRequireContext, this.f7771k, kVar);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        lifecycleScope.getClass();
        r7.y.q(lifecycleScope, null, null, new a6.c(rVar, null, 5), 3);
    }

    public abstract View d();

    public abstract TextView e();

    public abstract RecyclerView f();

    public abstract TextView i();

    public abstract void j(h5.k kVar);

    public abstract void k(h5.x0 x0Var);

    public abstract void l(String str);

    public final void m(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a6.j(str, this, (w6.c) null, 12), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            h5.k kVar = new h5.k(0, (String) null, 7);
            this.f7765a = kVar;
            kVar.c(arguments);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        e().setTypeface(o4.b.f11720s);
        i().setTypeface(o4.b.f11719r);
        i().setOnClickListener(new s(this, 1));
        f().setItemAnimator(null);
        f().setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        f().addItemDecoration(new x5.h((int) getResources().getDimension(R.dimen.margin_m)));
        d().setVisibility(0);
        View root = a().getRoot();
        root.getClass();
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        float f = UptodownApp.E;
        e4.e eVar = UptodownApp.U;
        if (eVar != null) {
            ((i4.g) eVar).e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        e4.e eVar;
        super.onResume();
        float f = UptodownApp.E;
        e4.e eVar2 = UptodownApp.T;
        if (eVar2 != null) {
            ((i4.g) eVar2).e();
        }
        if (getContext() != null) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            if (k4.c.e(contextRequireContext)) {
                Context contextRequireContext2 = requireContext();
                contextRequireContext2.getClass();
                String str = "1";
                try {
                    SharedPreferences sharedPreferences = contextRequireContext2.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences.contains("data_saver_options")) {
                        String string = sharedPreferences.getString("data_saver_options", "1");
                        string.getClass();
                        str = string;
                    }
                } catch (Exception unused) {
                }
                if (Integer.parseInt(str) > 0 && (eVar = UptodownApp.U) != null) {
                    ((i4.g) eVar).f();
                }
            }
        }
        c();
    }
}
