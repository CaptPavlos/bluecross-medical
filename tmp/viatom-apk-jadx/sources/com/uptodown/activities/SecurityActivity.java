package com.uptodown.activities;

import a6.c;
import android.app.NotificationManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d5.x0;
import e5.n;
import e5.s;
import h5.f;
import h5.f0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import l4.a4;
import l4.d9;
import l4.e9;
import l4.f5;
import l4.f9;
import l4.g9;
import l4.n5;
import l4.x2;
import l4.x4;
import n4.m0;
import o4.b;
import r7.i0;
import s6.m;
import v5.a;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class SecurityActivity extends a4 {
    public static final /* synthetic */ int Z = 0;
    public final m U = new m(new x2(this, 14));
    public final ViewModelLazy V = new ViewModelLazy(y.a(g9.class), new f9(this, 0), new e9(this), new f9(this, 1));
    public m0 W;
    public final x4 X;
    public final n5 Y;

    public SecurityActivity() {
        int i10 = 9;
        this.X = new x4(this, i10);
        this.Y = new n5(this, i10);
    }

    public final x0 B0() {
        return (x0) this.U.getValue();
    }

    public final void C0() {
        g9 g9Var = (g9) this.V.getValue();
        g9Var.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayListI = a.i(this);
        ArrayList arrayList2 = UptodownApp.f6636n0;
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                f0 f0Var = (f0) next;
                Iterator it2 = arrayListI.iterator();
                it2.getClass();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    next2.getClass();
                    f fVar = (f) next2;
                    if (l.a(f0Var.f8545b, fVar.f8538s)) {
                        fVar.f8539u = f0Var;
                        arrayList.add(fVar);
                    }
                }
            }
        }
        l5.J(arrayList, this);
        u7.m0 m0Var = g9Var.f10436a;
        v5.l lVar = new v5.l(arrayList);
        m0Var.getClass();
        m0Var.g(null, lVar);
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = B0().f7395a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            B0().e.setNavigationIcon(drawable);
            B0().e.setNavigationContentDescription(getString(R.string.back));
        }
        x0 x0VarB0 = B0();
        Toolbar toolbar = x0VarB0.e;
        TextView textView = x0VarB0.f;
        RecyclerView recyclerView = x0VarB0.f7398d;
        toolbar.setNavigationOnClickListener(new s(this, 18));
        x0VarB0.f7399i.setTypeface(b.f11719r);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) recyclerView.getItemAnimator();
        simpleItemAnimator.getClass();
        simpleItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.addItemDecoration(new x5.f((int) getResources().getDimension(R.dimen.margin_m), 0));
        x0VarB0.f7396b.setOnClickListener(new n(23));
        x0VarB0.h.setTypeface(b.f11719r);
        x0VarB0.g.setTypeface(b.f11720s);
        textView.setTypeface(b.f11719r);
        textView.setOnClickListener(new f5(6, this, x0VarB0));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new c(this, null, 28), 2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        keyEvent.getClass();
        if (i10 != 82) {
            return super.onKeyDown(i10, keyEvent);
        }
        B0().e.showOverflowMenu();
        return true;
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        u0();
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
    }

    @Override // l4.a4
    public final void z0() {
        C0();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new d9(this, null, 0), 2);
    }
}
