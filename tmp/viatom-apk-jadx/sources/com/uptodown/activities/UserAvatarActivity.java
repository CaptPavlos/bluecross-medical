package com.uptodown.activities;

import a6.n;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.activities.UserAvatarActivity;
import d5.b1;
import h5.c1;
import h5.e1;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.y;
import l4.ka;
import l4.ma;
import l4.na;
import l4.pa;
import l4.w;
import l4.x2;
import l4.x4;
import n4.z0;
import o4.b;
import s6.m;
import w6.c;
import x5.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UserAvatarActivity extends w {
    public static final /* synthetic */ int O = 0;
    public z0 J;
    public z0 K;
    public int L;
    public final m H = new m(new x2(this, 17));
    public final ViewModelLazy I = new ViewModelLazy(y.a(pa.class), new na(this, 0), new ma(this), new na(this, 1));
    public final AtomicBoolean M = new AtomicBoolean(false);
    public final x4 N = new x4(this, 10);

    public final b1 n0() {
        return (b1) this.H.getValue();
    }

    public final pa o0() {
        return (pa) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f6906a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        o0().e.f(c1.h(this));
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        b1 b1VarN0 = n0();
        if (drawable != null) {
            b1VarN0.g.setNavigationIcon(drawable);
            b1VarN0.g.setNavigationContentDescription(getString(R.string.back));
        }
        Toolbar toolbar = b1VarN0.g;
        RecyclerView recyclerView = b1VarN0.e;
        TextView textView = b1VarN0.f6910i;
        RecyclerView recyclerView2 = b1VarN0.f;
        final int i10 = 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.ja

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserAvatarActivity f10534b;

            {
                this.f10534b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                w6.c cVar = null;
                UserAvatarActivity userAvatarActivity = this.f10534b;
                switch (i11) {
                    case 0:
                        int i12 = UserAvatarActivity.O;
                        userAvatarActivity.finish();
                        break;
                    case 1:
                        int i13 = UserAvatarActivity.O;
                        r7.y.q(LifecycleOwnerKt.getLifecycleScope(userAvatarActivity), null, null, new ka(userAvatarActivity, cVar, 0), 3);
                        break;
                    default:
                        int i14 = UserAvatarActivity.O;
                        v5.c.e(userAvatarActivity, com.google.android.gms.internal.measurement.l5.A(userAvatarActivity), null);
                        break;
                }
            }
        });
        b1VarN0.f6912k.setTypeface(b.f11719r);
        b1VarN0.f6911j.setTypeface(b.f11719r);
        textView.setTypeface(b.f11719r);
        b1VarN0.h.setTypeface(b.f11719r);
        b1VarN0.f6913l.setTypeface(b.f11719r);
        final int i11 = 1;
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: l4.ja

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ UserAvatarActivity f10534b;

            {
                this.f10534b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                w6.c cVar = null;
                UserAvatarActivity userAvatarActivity = this.f10534b;
                switch (i112) {
                    case 0:
                        int i12 = UserAvatarActivity.O;
                        userAvatarActivity.finish();
                        break;
                    case 1:
                        int i13 = UserAvatarActivity.O;
                        r7.y.q(LifecycleOwnerKt.getLifecycleScope(userAvatarActivity), null, null, new ka(userAvatarActivity, cVar, 0), 3);
                        break;
                    default:
                        int i14 = UserAvatarActivity.O;
                        v5.c.e(userAvatarActivity, com.google.android.gms.internal.measurement.l5.A(userAvatarActivity), null);
                        break;
                }
            }
        });
        if (o0().e.getValue() != null) {
            Object value = o0().e.getValue();
            value.getClass();
            if (((e1) value).d()) {
                final int i12 = 2;
                b1VarN0.f6907b.setOnClickListener(new View.OnClickListener(this) { // from class: l4.ja

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ UserAvatarActivity f10534b;

                    {
                        this.f10534b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i112 = i12;
                        w6.c cVar = null;
                        UserAvatarActivity userAvatarActivity = this.f10534b;
                        switch (i112) {
                            case 0:
                                int i122 = UserAvatarActivity.O;
                                userAvatarActivity.finish();
                                break;
                            case 1:
                                int i13 = UserAvatarActivity.O;
                                r7.y.q(LifecycleOwnerKt.getLifecycleScope(userAvatarActivity), null, null, new ka(userAvatarActivity, cVar, 0), 3);
                                break;
                            default:
                                int i14 = UserAvatarActivity.O;
                                v5.c.e(userAvatarActivity, com.google.android.gms.internal.measurement.l5.A(userAvatarActivity), null);
                                break;
                        }
                    }
                });
            }
        }
        int i13 = getResources().getDisplayMetrics().widthPixels;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.margin_m);
        int i14 = 6;
        while (true) {
            if ((i13 - ((i14 + 1) * dimensionPixelSize)) / i14 > getResources().getDimensionPixelSize(R.dimen.icon_size_l)) {
                break;
            }
            i14--;
            if (i14 <= 0) {
                i14 = 1;
                break;
            }
        }
        this.L = (i13 - ((i14 + 1) * dimensionPixelSize)) / i14;
        recyclerView.setLayoutManager(new GridLayoutManager(this, i14));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.setItemAnimator(defaultItemAnimator);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, 0, false));
        recyclerView2.addItemDecoration(new l(this));
        recyclerView2.setItemAnimator(defaultItemAnimator);
        c cVar = null;
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), null, null, new n(this, cVar, 22), 3);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), w7.n.f13548a, null, new ka(this, cVar, 1), 2);
    }
}
