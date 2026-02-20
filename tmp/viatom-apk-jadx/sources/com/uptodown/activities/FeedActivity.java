package com.uptodown.activities;

import a3.i0;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.uptodown.R;
import d0.i;
import d5.l;
import e5.n;
import e5.s;
import kotlin.jvm.internal.y;
import l4.a0;
import l4.c0;
import l4.d0;
import l4.e0;
import l4.f0;
import l4.w;
import n4.c;
import o4.b;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class FeedActivity extends w {
    public static final /* synthetic */ int L = 0;
    public c J;
    public final m H = new m(new i0(this, 21));
    public final ViewModelLazy I = new ViewModelLazy(y.a(f0.class), new e0(this, 0), new d0(this), new e0(this, 1));
    public final i K = new i((Object) this, 23);

    public final l n0() {
        return (l) this.H.getValue();
    }

    public final f0 o0() {
        return (f0) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7197a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        n0().f7200d.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.core_vector_back));
        n0().f7200d.setNavigationContentDescription(getString(R.string.back));
        n0().f7200d.setNavigationOnClickListener(new s(this, 7));
        n0().f.setTypeface(b.f11719r);
        n0().e.setTypeface(b.f11720s);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        n0().f7199c.setLayoutManager(linearLayoutManager);
        n0().f7199c.addOnScrollListener(new a0(linearLayoutManager, this));
        n0().f7198b.setOnClickListener(new n(3));
        o0().a(this);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        s7.c cVar = w7.n.f13548a;
        w6.c cVar2 = null;
        r7.y.q(lifecycleScope, cVar, null, new c0(this, cVar2, 0), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new c0(this, cVar2, 1), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new c0(this, cVar2, 2), 3);
    }
}
