package e5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t1 extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public n4.h f7867b;
    public h5.x0 e;
    public ArrayList f;
    public h5.x0 g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7870i;

    /* renamed from: a, reason: collision with root package name */
    public final s6.m f7866a = new s6.m(new a3.i0(this, 13));

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f7868c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f7869d = new ArrayList();
    public boolean h = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7871j = true;

    /* renamed from: k, reason: collision with root package name */
    public final o1 f7872k = new o1(this);

    /* renamed from: l, reason: collision with root package name */
    public final o1 f7873l = new o1(this);

    /* renamed from: m, reason: collision with root package name */
    public final p1 f7874m = new p1(this);

    /* renamed from: n, reason: collision with root package name */
    public final p1 f7875n = new p1(this);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(e5.t1 r8, y6.c r9) {
        /*
            boolean r0 = r9 instanceof e5.r1
            if (r0 == 0) goto L13
            r0 = r9
            e5.r1 r0 = (e5.r1) r0
            int r1 = r0.f7848d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7848d = r1
            goto L18
        L13:
            e5.r1 r0 = new e5.r1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f7846b
            int r1 = r0.f7848d
            s6.w r2 = s6.w.f12711a
            r3 = 2
            r4 = 0
            r5 = 1
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L39
            if (r1 == r5) goto L33
            if (r1 != r3) goto L2d
            s6.a.e(r9)
            return r2
        L2d:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            return r4
        L33:
            java.util.ArrayList r1 = r0.f7845a
            s6.a.e(r9)
            goto L5d
        L39:
            s6.a.e(r9)
            android.content.Context r9 = r8.getContext()
            if (r9 == 0) goto L71
            r8.f7870i = r5
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            y7.e r9 = r7.i0.f12407a
            y7.d r9 = y7.d.f14116a
            e5.s1 r7 = new e5.s1
            r7.<init>(r8, r1, r4)
            r0.f7845a = r1
            r0.f7848d = r5
            java.lang.Object r9 = r7.y.z(r7, r9, r0)
            if (r9 != r6) goto L5d
            goto L70
        L5d:
            y7.e r9 = r7.i0.f12407a
            s7.c r9 = w7.n.f13548a
            e5.s1 r5 = new e5.s1
            r5.<init>(r1, r8, r4)
            r0.f7845a = r4
            r0.f7848d = r3
            java.lang.Object r8 = r7.y.z(r5, r9, r0)
            if (r8 != r6) goto L71
        L70:
            return r6
        L71:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.t1.a(e5.t1, y6.c):java.lang.Object");
    }

    public final d5.t b() {
        return (d5.t) this.f7866a.getValue();
    }

    public final void c() {
        if (getContext() != null) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            new c5.t(contextRequireContext, this.f7875n, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void d(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a6.j(str, this, (w6.c) null, 13), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = true;
        this.f7867b = new n4.h(this.f7872k, this.f7873l, this.f7874m, t1.class.getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        b().e.setTypeface(o4.b.f11720s);
        b().f.setTypeface(o4.b.f11719r);
        b().f.setOnClickListener(new s(this, 2));
        b().f7348d.setItemAnimator(null);
        b().f7348d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        b().f7348d.addItemDecoration(new x5.h((int) getResources().getDimension(R.dimen.margin_m)));
        b().f7348d.addOnScrollListener(new q1(this));
        c();
        FrameLayout frameLayout = b().f7345a;
        frameLayout.getClass();
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        float f = UptodownApp.E;
        e4.e eVar = UptodownApp.T;
        if (eVar != null) {
            ((i4.g) eVar).e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        e4.e eVar;
        super.onResume();
        float f = UptodownApp.E;
        e4.e eVar2 = UptodownApp.U;
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
                if (Integer.parseInt(str) <= 0 || (eVar = UptodownApp.T) == null) {
                    return;
                }
                ((i4.g) eVar).f();
            }
        }
    }
}
