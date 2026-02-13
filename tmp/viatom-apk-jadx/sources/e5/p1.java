package e5;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.activities.MainActivity;
import java.util.ArrayList;
import java.util.Iterator;
import l4.i2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p1 implements g5.h, g5.m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1 f7832a;

    public /* synthetic */ p1(t1 t1Var) {
        this.f7832a = t1Var;
    }

    @Override // g5.h
    public void a(h5.h hVar) {
        hVar.getClass();
        n4.h hVar2 = this.f7832a.f7867b;
        if (hVar2 != null) {
            Iterator it = hVar2.e.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                int i11 = i10 + 1;
                n4.g gVar = (n4.g) it.next();
                if (gVar != null && gVar.f11346b == 0) {
                    ArrayList arrayList = ((n4.f) gVar.a()).f11336a;
                    if (arrayList == null) {
                        kotlin.jvm.internal.l.i("homeFeatures");
                        throw null;
                    }
                    arrayList.add(hVar);
                    hVar2.notifyItemChanged(i10);
                    return;
                }
                i10 = i11;
            }
        }
    }

    @Override // g5.h
    public void b(h5.x0 x0Var) {
        this.f7832a.e = x0Var;
    }

    @Override // g5.h
    public void c(h5.x0 x0Var) {
        n4.h hVar = this.f7832a.f7867b;
        if (hVar != null) {
            hVar.c(x0Var, hVar.g);
        }
    }

    @Override // g5.h
    public void d(ArrayList arrayList) {
        arrayList.getClass();
        this.f7832a.f7868c = arrayList;
    }

    @Override // g5.h
    public void e(ArrayList arrayList) {
        ArrayList arrayList2;
        arrayList.getClass();
        int size = arrayList.size();
        t1 t1Var = this.f7832a;
        if (size > 3) {
            ArrayList arrayList3 = new ArrayList();
            t1Var.f = arrayList3;
            arrayList3.add(arrayList.get(0));
            ArrayList arrayList4 = t1Var.f;
            arrayList4.getClass();
            arrayList4.add(arrayList.get(1));
            ArrayList arrayList5 = t1Var.f;
            arrayList5.getClass();
            arrayList5.add(arrayList.get(2));
        } else {
            t1Var.f = arrayList;
        }
        n4.h hVar = t1Var.f7867b;
        if (hVar == null || (arrayList2 = t1Var.f) == null || arrayList2.isEmpty()) {
            return;
        }
        Object obj = arrayList2.get(0);
        obj.getClass();
        hVar.c((h5.x0) obj, hVar.f11360l);
        if (arrayList2.size() > 1) {
            Object obj2 = arrayList2.get(1);
            obj2.getClass();
            hVar.c((h5.x0) obj2, hVar.f11361m);
        }
        if (arrayList2.size() > 2) {
            Object obj3 = arrayList2.get(2);
            obj3.getClass();
            hVar.c((h5.x0) obj3, hVar.f11362n);
        }
    }

    @Override // g5.m
    public void f(h5.h hVar) {
        t1 t1Var = this.f7832a;
        if (t1Var.getActivity() instanceof MainActivity) {
            long j10 = hVar.f8566a;
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(t1Var);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(lifecycleScope, y7.d.f14116a, null, new g1(t1Var, j10, "impress", (w6.c) null, 1), 2);
        }
    }

    @Override // g5.h
    public void g() throws Resources.NotFoundException {
        t1 t1Var = this.f7832a;
        if (t1Var.f7868c.isEmpty()) {
            t1Var.b().f7348d.setVisibility(8);
            t1Var.b().f7346b.setVisibility(0);
        } else {
            n4.h hVar = t1Var.f7867b;
            if (hVar != null) {
                ArrayList arrayList = t1Var.f7868c;
                h5.x0 x0Var = t1Var.e;
                h5.x0 x0Var2 = t1Var.g;
                String string = t1Var.getString(R.string.trending_today);
                string.getClass();
                arrayList.getClass();
                hVar.e = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                n4.f fVar = new n4.f();
                fVar.f11338c = string;
                fVar.f11336a = arrayList;
                fVar.f11337b = arrayList2;
                n4.g gVar = new n4.g();
                gVar.f11345a = fVar;
                gVar.f11346b = 0;
                hVar.e.add(gVar);
                hVar.b(x0Var);
                hVar.e.add(null);
                hVar.f = hVar.e.size() - 1;
                hVar.b(x0Var2);
                hVar.e.add(null);
                hVar.f11361m = hVar.e.size() - 1;
                hVar.e.add(null);
                hVar.g = hVar.e.size() - 1;
                hVar.e.add(null);
                hVar.f11362n = hVar.e.size() - 1;
                hVar.e.add(null);
                hVar.h = hVar.e.size() - 1;
                hVar.e.add(null);
                hVar.f11357i = hVar.e.size() - 1;
                hVar.e.add(null);
                hVar.f11358j = hVar.e.size() - 1;
                hVar.e.add(null);
                hVar.f11359k = hVar.e.size() - 1;
            }
            t1Var.b().f7348d.setAdapter(t1Var.f7867b);
            t1Var.b().f7348d.setVisibility(0);
            t1Var.b().f7346b.setVisibility(8);
        }
        t1Var.b().f7347c.setVisibility(8);
        if (t1Var.getActivity() == null || !(t1Var.getActivity() instanceof MainActivity)) {
            return;
        }
        if (t1Var.h) {
            t1Var.h = false;
            FragmentActivity activity = t1Var.getActivity();
            activity.getClass();
            ((MainActivity) activity).T0();
        }
        if (a.a.f0a) {
            FragmentActivity activity2 = t1Var.getActivity();
            activity2.getClass();
            MainActivity mainActivity = (MainActivity) activity2;
            RelativeLayout relativeLayout = mainActivity.V;
            if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                return;
            }
            RelativeLayout relativeLayout2 = mainActivity.V;
            relativeLayout2.getClass();
            relativeLayout2.setVisibility(8);
            return;
        }
        FragmentActivity activity3 = t1Var.getActivity();
        activity3.getClass();
        MainActivity mainActivity2 = (MainActivity) activity3;
        if (mainActivity2.V == null) {
            mainActivity2.V = (RelativeLayout) mainActivity2.findViewById(R.id.rl_container_error_no_connection);
            View viewInflate = LayoutInflater.from(mainActivity2).inflate(R.layout.error_no_connection, (ViewGroup) mainActivity2.V, false);
            RelativeLayout relativeLayout3 = mainActivity2.V;
            relativeLayout3.getClass();
            relativeLayout3.addView(viewInflate);
            RelativeLayout relativeLayout4 = mainActivity2.V;
            relativeLayout4.getClass();
            ((TextView) relativeLayout4.findViewById(R.id.tv_msg_enc)).setTypeface(o4.b.f11719r);
            RelativeLayout relativeLayout5 = mainActivity2.V;
            relativeLayout5.getClass();
            ((TextView) relativeLayout5.findViewById(R.id.tv_my_apps_label_enc)).setTypeface(o4.b.f11719r);
            RelativeLayout relativeLayout6 = mainActivity2.V;
            relativeLayout6.getClass();
            TextView textView = (TextView) relativeLayout6.findViewById(R.id.tv_updates_available_enc);
            textView.setTypeface(o4.b.f11720s);
            textView.setOnClickListener(new i2(0, mainActivity2));
            RelativeLayout relativeLayout7 = mainActivity2.V;
            relativeLayout7.getClass();
            TextView textView2 = (TextView) relativeLayout7.findViewById(R.id.tv_installed_enc);
            textView2.setTypeface(o4.b.f11720s);
            textView2.setOnClickListener(new i2(1, mainActivity2));
            RelativeLayout relativeLayout8 = mainActivity2.V;
            relativeLayout8.getClass();
            TextView textView3 = (TextView) relativeLayout8.findViewById(R.id.tv_downloads_enc);
            textView3.setTypeface(o4.b.f11720s);
            textView3.setOnClickListener(new i2(2, mainActivity2));
            RelativeLayout relativeLayout9 = mainActivity2.V;
            relativeLayout9.getClass();
            ((TextView) relativeLayout9.findViewById(R.id.tv_settings_enc)).setTypeface(o4.b.f11719r);
            RelativeLayout relativeLayout10 = mainActivity2.V;
            relativeLayout10.getClass();
            ((LinearLayout) relativeLayout10.findViewById(R.id.ll_container_settings_enc)).setOnClickListener(new i2(3, mainActivity2));
            RelativeLayout relativeLayout11 = mainActivity2.V;
            relativeLayout11.getClass();
            TextView textView4 = (TextView) relativeLayout11.findViewById(R.id.tv_refresh_enc);
            textView4.setTypeface(o4.b.f11719r);
            textView4.setOnClickListener(new i2(4, mainActivity2));
            RelativeLayout relativeLayout12 = mainActivity2.V;
            relativeLayout12.getClass();
            mainActivity2.X = (ProgressBar) relativeLayout12.findViewById(R.id.pb_loading_refresh_enc);
            RelativeLayout relativeLayout13 = mainActivity2.V;
            relativeLayout13.getClass();
            ((RelativeLayout) relativeLayout13.findViewById(R.id.rl_container_progressbar_enc)).setOnClickListener(new n(9));
        }
        RelativeLayout relativeLayout14 = mainActivity2.V;
        relativeLayout14.getClass();
        relativeLayout14.setVisibility(0);
        ProgressBar progressBar = mainActivity2.X;
        progressBar.getClass();
        progressBar.setVisibility(4);
    }

    @Override // g5.h
    public void h(h5.h hVar) {
        hVar.getClass();
        n4.h hVar2 = this.f7832a.f7867b;
        if (hVar2 != null) {
            n4.g gVar = new n4.g();
            gVar.f11345a = hVar;
            gVar.f11346b = 3;
            hVar2.e.set(hVar2.h, gVar);
            hVar2.notifyItemChanged(hVar2.h);
        }
    }

    @Override // g5.h
    public void i(h5.x0 x0Var) {
        this.f7832a.g = x0Var;
    }

    @Override // g5.h
    public void j(ArrayList arrayList) {
        n4.h hVar;
        arrayList.getClass();
        t1 t1Var = this.f7832a;
        t1Var.f7869d = arrayList;
        if (arrayList.isEmpty() || (hVar = t1Var.f7867b) == null) {
            return;
        }
        ArrayList arrayList2 = t1Var.f7869d;
        arrayList2.getClass();
        Iterator it = arrayList2.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            h5.x0 x0Var = (h5.x0) next;
            int i10 = x0Var.f8788a.f8632a;
            if (i10 == 521) {
                hVar.c(x0Var, hVar.f11357i);
            } else if (i10 == 523) {
                hVar.c(x0Var, hVar.f11358j);
            } else if (i10 != 524) {
                hVar.b(x0Var);
            } else {
                hVar.c(x0Var, hVar.f11359k);
            }
        }
    }

    @Override // g5.h
    public void k(h5.x0 x0Var) {
        n4.h hVar = this.f7832a.f7867b;
        if (hVar != null) {
            hVar.c(x0Var, hVar.f);
        }
    }

    @Override // g5.h
    public void l(ArrayList arrayList) {
        arrayList.getClass();
    }
}
