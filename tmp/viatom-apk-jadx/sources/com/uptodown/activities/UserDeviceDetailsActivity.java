package com.uptodown.activities;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.activities.UserDeviceDetailsActivity;
import d5.e1;
import h5.h1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.y;
import l4.b;
import l4.bb;
import l4.cb;
import l4.db;
import l4.ib;
import l4.n5;
import l4.w;
import l4.x2;
import l4.x4;
import l4.ya;
import n4.b1;
import r7.i0;
import s6.m;
import u7.m0;
import w6.c;
import w7.n;
import x5.f;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UserDeviceDetailsActivity extends w {
    public static final /* synthetic */ int N = 0;
    public b1 J;
    public final m H = new m(new x2(this, 19));
    public final ViewModelLazy I = new ViewModelLazy(y.a(ib.class), new db(this, 0), new cb(this), new db(this, 1));
    public final n5 K = new n5(this, 12);
    public final b L = new b(this, 6);
    public final x4 M = new x4(this, 12);

    public final e1 n0() {
        return (e1) this.H.getValue();
    }

    public final ib o0() {
        return (ib) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7018a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        getOnBackPressedDispatcher().addCallback(this.L);
        final int i10 = 1;
        final int i11 = 0;
        int i12 = 2;
        c cVar = null;
        if (getIntent() != null && (extras = getIntent().getExtras()) != null && extras.containsKey("user_device")) {
            m0 m0Var = o0().f10503a;
            Parcelable parcelable = Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("user_device", h1.class) : extras.getParcelable("user_device");
            parcelable.getClass();
            m0Var.getClass();
            m0Var.g(null, parcelable);
            final h1 h1Var = (h1) o0().f10503a.getValue();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                n0().f7024k.setNavigationIcon(drawable);
                n0().f7024k.setNavigationContentDescription(getString(R.string.back));
            }
            n0().f7024k.setNavigationOnClickListener(new ya(this, i11));
            n0().f7036x.setTypeface(o4.b.f11719r);
            n0().f7024k.setNavigationOnClickListener(new ya(this, i10));
            n0().f7028o.setTypeface(o4.b.f11719r);
            n0().t.setTypeface(o4.b.f11720s);
            n0().f7033u.setTypeface(o4.b.f11720s);
            n0().f7025l.setTypeface(o4.b.f11720s);
            n0().f7026m.setTypeface(o4.b.f11720s);
            n0().f7031r.setTypeface(o4.b.f11720s);
            n0().f7032s.setTypeface(o4.b.f11720s);
            n0().f7029p.setTypeface(o4.b.f11720s);
            n0().f7030q.setTypeface(o4.b.f11720s);
            n0().f7035w.setTypeface(o4.b.f11720s);
            n0().f7034v.setTypeface(o4.b.f11719r);
            n0().f7027n.setTypeface(o4.b.f11719r);
            n0().g.setTypeface(o4.b.f11720s);
            n0().h.setTypeface(o4.b.f11720s);
            n0().f7034v.setOnClickListener(new View.OnClickListener(this) { // from class: l4.za

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UserDeviceDetailsActivity f11078b;

                {
                    this.f11078b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i13 = i11;
                    h5.h1 h1Var2 = h1Var;
                    UserDeviceDetailsActivity userDeviceDetailsActivity = this.f11078b;
                    switch (i13) {
                        case 0:
                            int i14 = UserDeviceDetailsActivity.N;
                            String string = userDeviceDetailsActivity.getString(R.string.unlink_device_confirmation);
                            string.getClass();
                            userDeviceDetailsActivity.K(string, new androidx.work.impl.utils.c(9, userDeviceDetailsActivity, h1Var2));
                            break;
                        default:
                            int i15 = UserDeviceDetailsActivity.N;
                            if (!userDeviceDetailsActivity.isFinishing()) {
                                AlertDialog alertDialog = userDeviceDetailsActivity.f10935w;
                                if (alertDialog != null) {
                                    alertDialog.dismiss();
                                }
                                AlertDialog.Builder builder = new AlertDialog.Builder(userDeviceDetailsActivity);
                                View viewInflate = userDeviceDetailsActivity.getLayoutInflater().inflate(R.layout.dialog_rename, (ViewGroup) null, false);
                                int i16 = R.id.et_dialog_rename;
                                EditText editText = (EditText) ViewBindings.findChildViewById(viewInflate, R.id.et_dialog_rename);
                                if (editText != null) {
                                    i16 = R.id.tv_cancel;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_cancel);
                                    if (textView != null) {
                                        i16 = R.id.tv_ok;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ok);
                                        if (textView2 != null) {
                                            i16 = R.id.tv_title_dialog_rename;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dialog_rename);
                                            if (textView3 != null) {
                                                LinearLayout linearLayout = (LinearLayout) viewInflate;
                                                a4.f fVar = new a4.f(linearLayout, editText, textView, textView2, textView3);
                                                textView3.setTypeface(o4.b.f11719r);
                                                textView2.setTypeface(o4.b.f11719r);
                                                textView2.setOnClickListener(new e5.j(userDeviceDetailsActivity, h1Var2, fVar, 10));
                                                textView.setTypeface(o4.b.f11719r);
                                                int i17 = 3;
                                                textView.setOnClickListener(new ya(userDeviceDetailsActivity, i17));
                                                builder.setView(linearLayout);
                                                userDeviceDetailsActivity.f10935w = builder.create();
                                                if (!userDeviceDetailsActivity.isFinishing() && userDeviceDetailsActivity.f10935w != null) {
                                                    userDeviceDetailsActivity.j0();
                                                    editText.postDelayed(new androidx.work.impl.c(h1Var2, fVar, userDeviceDetailsActivity, i17), 100L);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i16)));
                                break;
                            }
                            break;
                    }
                }
            });
            n0().f7019b.setOnClickListener(new View.OnClickListener(this) { // from class: l4.za

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UserDeviceDetailsActivity f11078b;

                {
                    this.f11078b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i13 = i10;
                    h5.h1 h1Var2 = h1Var;
                    UserDeviceDetailsActivity userDeviceDetailsActivity = this.f11078b;
                    switch (i13) {
                        case 0:
                            int i14 = UserDeviceDetailsActivity.N;
                            String string = userDeviceDetailsActivity.getString(R.string.unlink_device_confirmation);
                            string.getClass();
                            userDeviceDetailsActivity.K(string, new androidx.work.impl.utils.c(9, userDeviceDetailsActivity, h1Var2));
                            break;
                        default:
                            int i15 = UserDeviceDetailsActivity.N;
                            if (!userDeviceDetailsActivity.isFinishing()) {
                                AlertDialog alertDialog = userDeviceDetailsActivity.f10935w;
                                if (alertDialog != null) {
                                    alertDialog.dismiss();
                                }
                                AlertDialog.Builder builder = new AlertDialog.Builder(userDeviceDetailsActivity);
                                View viewInflate = userDeviceDetailsActivity.getLayoutInflater().inflate(R.layout.dialog_rename, (ViewGroup) null, false);
                                int i16 = R.id.et_dialog_rename;
                                EditText editText = (EditText) ViewBindings.findChildViewById(viewInflate, R.id.et_dialog_rename);
                                if (editText != null) {
                                    i16 = R.id.tv_cancel;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_cancel);
                                    if (textView != null) {
                                        i16 = R.id.tv_ok;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_ok);
                                        if (textView2 != null) {
                                            i16 = R.id.tv_title_dialog_rename;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_title_dialog_rename);
                                            if (textView3 != null) {
                                                LinearLayout linearLayout = (LinearLayout) viewInflate;
                                                a4.f fVar = new a4.f(linearLayout, editText, textView, textView2, textView3);
                                                textView3.setTypeface(o4.b.f11719r);
                                                textView2.setTypeface(o4.b.f11719r);
                                                textView2.setOnClickListener(new e5.j(userDeviceDetailsActivity, h1Var2, fVar, 10));
                                                textView.setTypeface(o4.b.f11719r);
                                                int i17 = 3;
                                                textView.setOnClickListener(new ya(userDeviceDetailsActivity, i17));
                                                builder.setView(linearLayout);
                                                userDeviceDetailsActivity.f10935w = builder.create();
                                                if (!userDeviceDetailsActivity.isFinishing() && userDeviceDetailsActivity.f10935w != null) {
                                                    userDeviceDetailsActivity.j0();
                                                    editText.postDelayed(new androidx.work.impl.c(h1Var2, fVar, userDeviceDetailsActivity, i17), 100L);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                                androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i16)));
                                break;
                            }
                            break;
                    }
                }
            });
            n0().f7020c.setOnClickListener(new ya(this, i12));
            n0().f7028o.setText(h1Var.f8607c);
            n0().f7033u.setText(h1Var.g);
            n0().f7026m.setText(h1Var.f8608d);
            n0().f7032s.setText(h1Var.e);
            TextView textView = n0().f7030q;
            long j10 = h1Var.h;
            textView.setText(j10 <= 0 ? null : new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(new Date(j10)));
            n0().f7023j.setLayoutManager(new LinearLayoutManager(this, 1, false));
            n0().f7023j.setItemAnimator(new DefaultItemAnimator());
            int dimension = (int) getResources().getDimension(R.dimen.margin_m);
            n0().f7023j.addItemDecoration(new f(dimension, dimension));
            ib ibVarO0 = o0();
            ibVarO0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(ibVarO0);
            e eVar = i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new c5.m(this, h1Var, ibVarO0, cVar, 18), 2);
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar2 = i0.f12407a;
        s7.c cVar2 = n.f13548a;
        r7.y.q(lifecycleScope, cVar2, null, new bb(this, cVar, i11), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new bb(this, cVar, i10), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new bb(this, cVar, i12), 2);
    }
}
