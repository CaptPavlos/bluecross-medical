package e5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.UserActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m1 extends Fragment {

    /* renamed from: c, reason: collision with root package name */
    public n4.c f7817c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7818d;

    /* renamed from: a, reason: collision with root package name */
    public final s6.m f7815a = new s6.m(new a3.i0(this, 11));

    /* renamed from: b, reason: collision with root package name */
    public final s6.f f7816b = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.y.a(l4.f0.class), new a9.f(new a9.f(this, 3), 4), null);
    public final d0.i e = new d0.i(this, 11);

    public final d5.m a() {
        return (d5.m) this.f7815a.getValue();
    }

    public final l4.f0 b() {
        return (l4.f0) this.f7816b.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        RelativeLayout relativeLayout = a().f7209a;
        relativeLayout.getClass();
        return relativeLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        h5.e1 e1VarH = h5.c1.h(contextRequireContext);
        if (e1VarH != null) {
            a().f7212d.setVisibility(8);
        } else {
            a().f7215k.setVisibility(8);
            a().e.setVisibility(8);
            a().f7212d.setVisibility(0);
        }
        if (e1VarH == null || this.f7818d) {
            return;
        }
        this.f7818d = true;
        l4.f0 f0VarB = b();
        Context contextRequireContext2 = requireContext();
        contextRequireContext2.getClass();
        f0VarB.a(contextRequireContext2);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        viewLifecycleOwner.getClass();
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new k1(this, null, 0), 3);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        a().f7216l.setTypeface(o4.b.f11719r);
        a().f7215k.setTypeface(o4.b.f11720s);
        a().f7213i.setTypeface(o4.b.f11719r);
        a().f7214j.setTypeface(o4.b.f11719r);
        final int i10 = 1;
        final int i11 = 0;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        a().g.setLayoutManager(linearLayoutManager);
        a().g.addOnScrollListener(new j1(linearLayoutManager, this));
        a().e.setOnClickListener(new n(0));
        a().f7214j.setOnClickListener(new View.OnClickListener(this) { // from class: e5.i1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m1 f7779b;

            {
                this.f7779b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i12 = i11;
                m1 m1Var = this.f7779b;
                switch (i12) {
                    case 0:
                        if (m1Var.getActivity() instanceof MainActivity) {
                            FragmentActivity activity = m1Var.getActivity();
                            activity.getClass();
                            ((MainActivity) activity).p0();
                            break;
                        }
                        break;
                    case 1:
                        if (m1Var.getActivity() instanceof MainActivity) {
                            FragmentActivity activity2 = m1Var.getActivity();
                            activity2.getClass();
                            MainActivity mainActivity = (MainActivity) activity2;
                            Intent intent = new Intent(mainActivity, (Class<?>) LoginActivity.class);
                            ActivityResultLauncher activityResultLauncher = mainActivity.f6653x0;
                            float f = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(mainActivity));
                            break;
                        }
                        break;
                    default:
                        if (m1Var.getActivity() instanceof MainActivity) {
                            FragmentActivity activity3 = m1Var.getActivity();
                            activity3.getClass();
                            MainActivity mainActivity2 = (MainActivity) activity3;
                            Intent intent2 = new Intent(mainActivity2, (Class<?>) UserActivity.class);
                            ActivityResultLauncher activityResultLauncher2 = mainActivity2.f6654y0;
                            float f10 = UptodownApp.E;
                            activityResultLauncher2.launch(intent2, k4.c.b(mainActivity2));
                            break;
                        }
                        break;
                }
            }
        });
        a().f7213i.setOnClickListener(new View.OnClickListener(this) { // from class: e5.i1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m1 f7779b;

            {
                this.f7779b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i12 = i10;
                m1 m1Var = this.f7779b;
                switch (i12) {
                    case 0:
                        if (m1Var.getActivity() instanceof MainActivity) {
                            FragmentActivity activity = m1Var.getActivity();
                            activity.getClass();
                            ((MainActivity) activity).p0();
                            break;
                        }
                        break;
                    case 1:
                        if (m1Var.getActivity() instanceof MainActivity) {
                            FragmentActivity activity2 = m1Var.getActivity();
                            activity2.getClass();
                            MainActivity mainActivity = (MainActivity) activity2;
                            Intent intent = new Intent(mainActivity, (Class<?>) LoginActivity.class);
                            ActivityResultLauncher activityResultLauncher = mainActivity.f6653x0;
                            float f = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(mainActivity));
                            break;
                        }
                        break;
                    default:
                        if (m1Var.getActivity() instanceof MainActivity) {
                            FragmentActivity activity3 = m1Var.getActivity();
                            activity3.getClass();
                            MainActivity mainActivity2 = (MainActivity) activity3;
                            Intent intent2 = new Intent(mainActivity2, (Class<?>) UserActivity.class);
                            ActivityResultLauncher activityResultLauncher2 = mainActivity2.f6654y0;
                            float f10 = UptodownApp.E;
                            activityResultLauncher2.launch(intent2, k4.c.b(mainActivity2));
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 2;
        a().f.setOnClickListener(new View.OnClickListener(this) { // from class: e5.i1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m1 f7779b;

            {
                this.f7779b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i122 = i12;
                m1 m1Var = this.f7779b;
                switch (i122) {
                    case 0:
                        if (m1Var.getActivity() instanceof MainActivity) {
                            FragmentActivity activity = m1Var.getActivity();
                            activity.getClass();
                            ((MainActivity) activity).p0();
                            break;
                        }
                        break;
                    case 1:
                        if (m1Var.getActivity() instanceof MainActivity) {
                            FragmentActivity activity2 = m1Var.getActivity();
                            activity2.getClass();
                            MainActivity mainActivity = (MainActivity) activity2;
                            Intent intent = new Intent(mainActivity, (Class<?>) LoginActivity.class);
                            ActivityResultLauncher activityResultLauncher = mainActivity.f6653x0;
                            float f = UptodownApp.E;
                            activityResultLauncher.launch(intent, k4.c.b(mainActivity));
                            break;
                        }
                        break;
                    default:
                        if (m1Var.getActivity() instanceof MainActivity) {
                            FragmentActivity activity3 = m1Var.getActivity();
                            activity3.getClass();
                            MainActivity mainActivity2 = (MainActivity) activity3;
                            Intent intent2 = new Intent(mainActivity2, (Class<?>) UserActivity.class);
                            ActivityResultLauncher activityResultLauncher2 = mainActivity2.f6654y0;
                            float f10 = UptodownApp.E;
                            activityResultLauncher2.launch(intent2, k4.c.b(mainActivity2));
                            break;
                        }
                        break;
                }
            }
        });
        a().h.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.main_blue), ContextCompat.getColor(requireContext(), R.color.main_blue_pressed));
        a().h.setOnRefreshListener(new androidx.core.view.inputmethod.a(this, 8));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        s7.c cVar = w7.n.f13548a;
        w6.c cVar2 = null;
        r7.y.q(lifecycleScope, cVar, null, new k1(this, cVar2, i10), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new k1(this, cVar2, i12), 2);
    }
}
