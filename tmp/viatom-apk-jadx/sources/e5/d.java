package e5;

import android.R;
import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public h5.d f7718b;

    /* renamed from: c, reason: collision with root package name */
    public n4.p0 f7719c;

    /* renamed from: a, reason: collision with root package name */
    public final s6.m f7717a = new s6.m(new a3.i0(this, 9));

    /* renamed from: d, reason: collision with root package name */
    public final c f7720d = new c(this);
    public final b e = new b(this);

    public static final void a(d dVar, h5.h hVar, h5.h hVar2, String str) {
        if (dVar.getActivity() == null || dVar.requireActivity().isFinishing() || !(dVar.getActivity() instanceof l4.w)) {
            return;
        }
        FragmentActivity activity = dVar.getActivity();
        activity.getClass();
        ((l4.w) activity).Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(dVar.requireContext());
        a3.z0 z0VarK = a3.z0.k(dVar.getLayoutInflater());
        TextView textView = (TextView) z0VarK.f198d;
        TextView textView2 = (TextView) z0VarK.e;
        textView.setTypeface(o4.b.f11720s);
        String str2 = hVar != null ? hVar.f8567b : null;
        textView.setText("Comparing:\n" + str2 + " vs " + hVar2.f8567b + "\n\n" + str);
        ((TextView) z0VarK.f197c).setVisibility(8);
        textView2.setTypeface(o4.b.f11719r);
        textView2.setText(dVar.getString(R.string.ok));
        textView2.setOnClickListener(new a(dVar, 1));
        builder.setView((LinearLayout) z0VarK.f);
        AlertDialog alertDialogCreate = builder.create();
        FragmentActivity activity2 = dVar.getActivity();
        activity2.getClass();
        ((l4.w) activity2).f10935w = alertDialogCreate;
        if (dVar.requireActivity().isFinishing()) {
            return;
        }
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            a3.a.A(window, 0);
        }
        alertDialogCreate.show();
    }

    public final void b(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a6.j(str, this, (w6.c) null, 10), 2);
    }

    public final d5.y0 c() {
        return (d5.y0) this.f7717a.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h5.d dVar = this.f7718b;
        if (dVar == null) {
            kotlin.jvm.internal.l.i("alternatives");
            throw null;
        }
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        h5.x0 x0Var = new h5.x0(null, null, 7);
        ArrayList arrayList = dVar.f8492c;
        arrayList.getClass();
        x0Var.f8789b = arrayList;
        String str = dVar.f8490a;
        String str2 = dVar.f8491b;
        x0Var.f8788a = new h5.k(-4, str, str2);
        b bVar = new b(this);
        float f = UptodownApp.E;
        n4.p0 p0Var = new n4.p0(this.f7720d, this.e, bVar, null, str2, null, null, str, false, null);
        this.f7719c = p0Var;
        p0Var.a(x0Var);
        c().e.setAdapter(this.f7719c);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        c().f.setVisibility(0);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.core_vector_back);
        if (drawable != null) {
            c().f.setNavigationIcon(drawable);
            c().f.setNavigationContentDescription(getString(com.uptodown.R.string.back));
        }
        c().f.setNavigationOnClickListener(new a(this, 0));
        c().g.setTypeface(o4.b.f11720s);
        c().g.setVisibility(8);
        c().e.setItemAnimator(null);
        c().e.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        if (c().e.getItemDecorationCount() == 0) {
            c().e.addItemDecoration(new x5.k(false, false));
        }
        c().e.setPadding(0, 0, 0, 0);
        RelativeLayout relativeLayout = c().f7404a;
        relativeLayout.getClass();
        return relativeLayout;
    }
}
