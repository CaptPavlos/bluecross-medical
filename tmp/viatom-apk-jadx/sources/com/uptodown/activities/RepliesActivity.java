package com.uptodown.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.work.multiprocess.RemoteWorkManager;
import c5.e0;
import c5.x;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.util.views.UsernameTextView;
import d5.p0;
import e5.v0;
import h5.c1;
import h5.e1;
import h5.t0;
import j4.d0;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import l4.m7;
import l4.n5;
import l4.o6;
import l4.q7;
import l4.s1;
import l4.s7;
import l4.t7;
import l4.w;
import l4.x2;
import l4.x4;
import l4.y7;
import n4.h0;
import o4.b;
import r7.i0;
import s6.m;
import u7.m0;
import w6.c;
import w7.n;
import y7.d;
import y7.e;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class RepliesActivity extends w {
    public static final /* synthetic */ int L = 0;
    public h0 J;
    public final m H = new m(new x2(this, 10));
    public final ViewModelLazy I = new ViewModelLazy(y.a(y7.class), new t7(this, 0), new s7(this), new t7(this, 1));
    public final n5 K = new n5(this, 6);

    public final p0 n0() {
        return (p0) this.H.getValue();
    }

    public final y7 o0() {
        return (y7) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7277a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Intent intent = getIntent();
        c cVar = null;
        if (intent != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey("review")) {
                o0().f11039m.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("review", t0.class) : extras.getParcelable("review"));
            }
            if (extras.containsKey("appName")) {
                o0().f11037k.f(extras.getString("appName"));
            }
            if (extras.containsKey("username")) {
                o0().f11038l.f(extras.getString("username"));
            }
            if (extras.containsKey("appIconUrl")) {
                o0().f11040n.f(extras.getString("appIconUrl"));
            }
            if (extras.containsKey("userAvatarUrl")) {
                o0().f11041o.f(extras.getString("userAvatarUrl"));
            }
            if (extras.containsKey("appId")) {
                m0 m0Var = o0().f11042p;
                Long lValueOf = Long.valueOf(extras.getLong("appId"));
                m0Var.getClass();
                m0Var.g(null, lValueOf);
            }
            if (extras.containsKey("appUrl")) {
                o0().f11043q.f(extras.getString("appUrl"));
            }
        }
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            n0().f7286n.setNavigationIcon(drawable);
            n0().f7286n.setNavigationContentDescription(getString(R.string.back));
        }
        int i10 = 0;
        n0().f7286n.setNavigationOnClickListener(new m7(this, i10));
        n0().f7290r.setTypeface(b.f11719r);
        n0().f7287o.setTypeface(b.f11720s);
        n0().f7288p.setTypeface(b.f11719r);
        n0().f7288p.setText((CharSequence) o0().f11037k.getValue());
        d0 d0VarE = j4.y.d().e((String) o0().f11040n.getValue());
        d0VarE.f(R.drawable.shape_bg_placeholder);
        float f = UptodownApp.E;
        d0VarE.g(k4.c.y(this));
        d0VarE.e(n0().f7279c, null);
        int i11 = 1;
        n0().f.setOnClickListener(new m7(this, i11));
        n0().g.setVisibility(0);
        int i12 = 2;
        n0().g.setOnClickListener(new m7(this, i12));
        n0().f7289q.setTypeface(b.f11720s);
        t0();
        int i13 = 3;
        n0().f7280d.setOnClickListener(new m7(this, i13));
        int i14 = 4;
        n0().f7281i.setOnClickListener(new m7(this, i14));
        n0().f7278b.setTypeface(b.f11720s);
        n0().f7278b.setOnEditorActionListener(new s1(this, i11));
        u0();
        n0().f7285m.setLayoutManager(new LinearLayoutManager(this, 1, false));
        n0().f7285m.setItemAnimator(new DefaultItemAnimator());
        n0().f7282j.getViewTreeObserver().addOnScrollChangedListener(new o6(this, i11));
        if (o0().f11039m.getValue() != null) {
            Object value = o0().f11039m.getValue();
            value.getClass();
            long j10 = ((t0) value).f8739a;
            y7 y7VarO0 = o0();
            y7VarO0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(y7VarO0);
            e eVar = i0.f12407a;
            r7.y.q(viewModelScope, d.f14116a, null, new e0(y7VarO0, this, j10, null), 2);
            Object value2 = o0().f11039m.getValue();
            value2.getClass();
            s0((t0) value2);
        } else {
            finish();
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar2 = i0.f12407a;
        s7.c cVar2 = n.f13548a;
        r7.y.q(lifecycleScope, cVar2, null, new q7(this, cVar, i10), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new q7(this, cVar, i11), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new q7(this, cVar, i12), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new q7(this, cVar, i13), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new q7(this, cVar, i14), 2);
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        u0();
        t0();
    }

    public final void p0() {
        Object systemService = getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).hideSoftInputFromWindow(n0().f7278b.getWindowToken(), 0);
        if (n0().f7278b.getText() == null || o7.m.v0(n0().f7278b.getText().toString()).toString().length() <= 0) {
            if (o7.m.v0(n0().f7278b.getText().toString()).toString().length() == 0) {
                String string = getString(R.string.empty_answer_error);
                string.getClass();
                C(string);
                return;
            }
            return;
        }
        String string2 = n0().f7278b.getText().toString();
        String strA = t1.A(this, "last_review_text");
        String strA2 = t1.A(this, "last_review_timestamp");
        if (strA2 == null) {
            strA2 = "0";
        }
        if (string2 != null && string2.equalsIgnoreCase(strA) && System.currentTimeMillis() - Long.parseLong(strA2) < RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS) {
            n0().f7278b.setText("");
            return;
        }
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        String string3 = n0().f7278b.getText().toString();
        string3.getClass();
        t1.R(applicationContext, "last_review_text", string3);
        Context applicationContext2 = getApplicationContext();
        applicationContext2.getClass();
        String strValueOf = String.valueOf(System.currentTimeMillis());
        strValueOf.getClass();
        t1.R(applicationContext2, "last_review_timestamp", strValueOf);
        y7 y7VarO0 = o0();
        String string4 = n0().f7278b.getText().toString();
        Object value = o0().f11039m.getValue();
        value.getClass();
        long j10 = ((t0) value).f8739a;
        y7VarO0.getClass();
        string4.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(y7VarO0);
        e eVar = i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new v0(this, string4, j10, y7VarO0, null, 2), 2);
    }

    public final void q0() {
        if (isFinishing()) {
            return;
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) LoginActivity.class);
        float f = UptodownApp.E;
        startActivity(intent, k4.c.a(this));
    }

    public final void r0(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        new x(this, LifecycleOwnerKt.getLifecycleScope(this)).a(str, new x4(this, 7));
    }

    public final void s0(final t0 t0Var) {
        CharSequence charSequence;
        boolean zB = t0Var.b();
        int i10 = t0Var.h;
        final int i11 = 5;
        final int i12 = 4;
        final int i13 = 3;
        final int i14 = 2;
        final int i15 = 0;
        final int i16 = 1;
        if (!zB) {
            if (i10 > 0) {
                n0().f7283k.f7307q.setTypeface(b.f11720s);
                if (t0Var.h == 1) {
                    n0().f7283k.f7307q.setText(getString(R.string.replies_counter_single));
                } else {
                    n0().f7283k.f7307q.setText(getString(R.string.replies_counter_multiple, String.valueOf(t0Var.h)));
                }
            } else {
                n0().f7283k.f7302l.setVisibility(8);
            }
            n0().f7283k.f7302l.setVisibility(8);
            n0().f7283k.f7301k.setOnClickListener(new View.OnClickListener(this) { // from class: l4.n7

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f10658b;

                {
                    this.f10658b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    int i17 = i13;
                    h5.t0 t0Var2 = t0Var;
                    RepliesActivity repliesActivity = this.f10658b;
                    switch (i17) {
                        case 0:
                            int i18 = RepliesActivity.L;
                            float f = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity2 = this.f10658b;
                                if (h5.c1.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(R.string.login_required_like_title);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(R.string.login_required_like_msg);
                                    string2.getClass();
                                    a.a.q(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity2, 5, false).F(repliesActivity2.n0().f7284l.e);
                                    h5.t0 t0Var3 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var3.f8739a))) {
                                        y7 y7VarO0 = repliesActivity2.o0();
                                        y7VarO0.getClass();
                                        r7.w viewModelScope = ViewModelKt.getViewModelScope(y7VarO0);
                                        y7.e eVar = r7.i0.f12407a;
                                        r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(t0Var3, repliesActivity2, y7VarO0, (w6.c) null, 16), 2);
                                        repliesActivity2.n0().f7284l.f7341p.setText(String.valueOf(t0Var3.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i19 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 2:
                            int i20 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 3:
                            int i21 = RepliesActivity.L;
                            float f10 = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity3 = this.f10658b;
                                if (h5.c1.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(R.string.login_required_like_title);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(R.string.login_required_like_msg);
                                    string4.getClass();
                                    a.a.q(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity3, 5, false).F(repliesActivity3.n0().f7283k.e);
                                    h5.t0 t0Var4 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var4.f8739a))) {
                                        y7 y7VarO02 = repliesActivity3.o0();
                                        y7VarO02.getClass();
                                        r7.w viewModelScope2 = ViewModelKt.getViewModelScope(y7VarO02);
                                        y7.e eVar2 = r7.i0.f12407a;
                                        r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p(t0Var4, repliesActivity3, y7VarO02, (w6.c) null, 16), 2);
                                        repliesActivity3.n0().f7283k.f7305o.setText(String.valueOf(t0Var4.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i22 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        default:
                            int i23 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                    }
                }
            });
            if (v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a))) {
                n0().f7283k.e.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_heart_red));
            }
            n0().f7283k.f7305o.setTypeface(b.f11720s);
            n0().f7283k.f7305o.setText(String.valueOf(t0Var.f8744j));
            n0().f7283k.f.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
            n0().f7283k.g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
            n0().f7283k.h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
            n0().f7283k.f7299i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
            n0().f7283k.f7300j.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off));
            if (t0Var.g >= 2) {
                n0().f7283k.g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
            }
            if (t0Var.g >= 3) {
                n0().f7283k.h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
            }
            if (t0Var.g >= 4) {
                n0().f7283k.f7299i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
            }
            if (t0Var.g == 5) {
                n0().f7283k.f7300j.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on));
            }
            final e1 e1VarH = c1.h(this);
            if (e1VarH == null || !l.a(e1VarH.f8512a, t0Var.f8740b)) {
                n0().f7283k.f7298d.setVisibility(0);
                if (t0Var.f8749o == 1) {
                    n0().f7283k.f7298d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_following));
                } else {
                    n0().f7283k.f7298d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_follow));
                }
            } else {
                n0().f7283k.f7298d.setVisibility(8);
            }
            n0().f7283k.f7298d.setOnClickListener(new View.OnClickListener() { // from class: l4.o7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i17 = i16;
                    RepliesActivity repliesActivity = this;
                    h5.e1 e1Var = e1VarH;
                    switch (i17) {
                        case 0:
                            if (e1Var == null) {
                                int i18 = RepliesActivity.L;
                                repliesActivity.q0();
                                break;
                            } else {
                                repliesActivity.K.e(-1);
                                break;
                            }
                        default:
                            if (e1Var == null) {
                                int i19 = RepliesActivity.L;
                                repliesActivity.q0();
                                break;
                            } else {
                                repliesActivity.K.e(-1);
                                break;
                            }
                    }
                }
            });
            n0().f7283k.f7309s.setTypeface(b.f11719r);
            n0().f7283k.f7304n.setTypeface(b.f11720s);
            n0().f7283k.f7303m.setTypeface(b.f11720s);
            n0().f7283k.f7306p.setTypeface(b.f11720s);
            CharSequence charSequence2 = (CharSequence) o0().f11041o.getValue();
            if (charSequence2 == null || charSequence2.length() == 0) {
                String strE = c1.e(t0Var.f8742d);
                if (strE == null || strE.length() == 0) {
                    charSequence = null;
                    d0 d0VarF = j4.y.d().f();
                    float f = UptodownApp.E;
                    d0VarF.g(k4.c.y(this));
                    d0VarF.e(n0().f7283k.f7297c, null);
                } else {
                    d0 d0VarE = j4.y.d().e(c1.e(t0Var.f8742d));
                    float f10 = UptodownApp.E;
                    d0VarE.g(k4.c.y(this));
                    charSequence = null;
                    d0VarE.e(n0().f7283k.f7297c, null);
                }
            } else {
                d0 d0VarE2 = j4.y.d().e(c1.e((String) o0().f11041o.getValue()));
                float f11 = UptodownApp.E;
                d0VarE2.g(k4.c.y(this));
                charSequence = null;
                d0VarE2.e(n0().f7283k.f7297c, null);
            }
            String str = t0Var.f8741c;
            if (str == null || str.length() == 0) {
                CharSequence charSequence3 = (CharSequence) o0().f11038l.getValue();
                if (charSequence3 != null && charSequence3.length() != 0) {
                    n0().f7283k.f7309s.setText((CharSequence) o0().f11038l.getValue());
                    int i17 = UsernameTextView.f6728j;
                    l1.b.j(n0().f7283k.f7309s, t0Var.b(), t0Var.f8748n);
                }
            } else {
                n0().f7283k.f7309s.setText(t0Var.f8741c);
                int i18 = UsernameTextView.f6728j;
                l1.b.j(n0().f7283k.f7309s, t0Var.b(), t0Var.f8748n);
            }
            String str2 = t0Var.f8743i;
            if (str2 != null && str2.length() != 0) {
                n0().f7283k.f7304n.setText(t0Var.f8743i);
            }
            String str3 = t0Var.f;
            if (str3 == null || str3.length() == 0) {
                n0().f7283k.f7303m.setVisibility(8);
            } else {
                n0().f7283k.f7303m.setMaxLines(Integer.MAX_VALUE);
                TextView textView = n0().f7283k.f7303m;
                Spanned spannedA = t0Var.a();
                textView.setText(spannedA != null ? o7.m.v0(spannedA) : charSequence);
                if (t0Var.h > 0) {
                    n0().f7283k.f7306p.setText(String.valueOf(t0Var.h));
                }
            }
            if (t0Var.f8745k == 1) {
                n0().f7283k.f7296b.setVisibility(0);
            }
            String str4 = t0Var.f8740b;
            if (str4 == null || str4.length() == 0) {
                return;
            }
            n0().f7283k.f7309s.setOnClickListener(new View.OnClickListener(this) { // from class: l4.n7

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f10658b;

                {
                    this.f10658b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    int i172 = i12;
                    h5.t0 t0Var2 = t0Var;
                    RepliesActivity repliesActivity = this.f10658b;
                    switch (i172) {
                        case 0:
                            int i182 = RepliesActivity.L;
                            float f12 = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity2 = this.f10658b;
                                if (h5.c1.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(R.string.login_required_like_title);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(R.string.login_required_like_msg);
                                    string2.getClass();
                                    a.a.q(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity2, 5, false).F(repliesActivity2.n0().f7284l.e);
                                    h5.t0 t0Var3 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var3.f8739a))) {
                                        y7 y7VarO0 = repliesActivity2.o0();
                                        y7VarO0.getClass();
                                        r7.w viewModelScope = ViewModelKt.getViewModelScope(y7VarO0);
                                        y7.e eVar = r7.i0.f12407a;
                                        r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(t0Var3, repliesActivity2, y7VarO0, (w6.c) null, 16), 2);
                                        repliesActivity2.n0().f7284l.f7341p.setText(String.valueOf(t0Var3.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i19 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 2:
                            int i20 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 3:
                            int i21 = RepliesActivity.L;
                            float f102 = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity3 = this.f10658b;
                                if (h5.c1.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(R.string.login_required_like_title);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(R.string.login_required_like_msg);
                                    string4.getClass();
                                    a.a.q(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity3, 5, false).F(repliesActivity3.n0().f7283k.e);
                                    h5.t0 t0Var4 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var4.f8739a))) {
                                        y7 y7VarO02 = repliesActivity3.o0();
                                        y7VarO02.getClass();
                                        r7.w viewModelScope2 = ViewModelKt.getViewModelScope(y7VarO02);
                                        y7.e eVar2 = r7.i0.f12407a;
                                        r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p(t0Var4, repliesActivity3, y7VarO02, (w6.c) null, 16), 2);
                                        repliesActivity3.n0().f7283k.f7305o.setText(String.valueOf(t0Var4.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i22 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        default:
                            int i23 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                    }
                }
            });
            n0().f7283k.f7297c.setOnClickListener(new View.OnClickListener(this) { // from class: l4.n7

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f10658b;

                {
                    this.f10658b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    int i172 = i11;
                    h5.t0 t0Var2 = t0Var;
                    RepliesActivity repliesActivity = this.f10658b;
                    switch (i172) {
                        case 0:
                            int i182 = RepliesActivity.L;
                            float f12 = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity2 = this.f10658b;
                                if (h5.c1.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(R.string.login_required_like_title);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(R.string.login_required_like_msg);
                                    string2.getClass();
                                    a.a.q(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity2, 5, false).F(repliesActivity2.n0().f7284l.e);
                                    h5.t0 t0Var3 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var3.f8739a))) {
                                        y7 y7VarO0 = repliesActivity2.o0();
                                        y7VarO0.getClass();
                                        r7.w viewModelScope = ViewModelKt.getViewModelScope(y7VarO0);
                                        y7.e eVar = r7.i0.f12407a;
                                        r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(t0Var3, repliesActivity2, y7VarO0, (w6.c) null, 16), 2);
                                        repliesActivity2.n0().f7284l.f7341p.setText(String.valueOf(t0Var3.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i19 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 2:
                            int i20 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 3:
                            int i21 = RepliesActivity.L;
                            float f102 = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity3 = this.f10658b;
                                if (h5.c1.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(R.string.login_required_like_title);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(R.string.login_required_like_msg);
                                    string4.getClass();
                                    a.a.q(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity3, 5, false).F(repliesActivity3.n0().f7283k.e);
                                    h5.t0 t0Var4 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var4.f8739a))) {
                                        y7 y7VarO02 = repliesActivity3.o0();
                                        y7VarO02.getClass();
                                        r7.w viewModelScope2 = ViewModelKt.getViewModelScope(y7VarO02);
                                        y7.e eVar2 = r7.i0.f12407a;
                                        r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p(t0Var4, repliesActivity3, y7VarO02, (w6.c) null, 16), 2);
                                        repliesActivity3.n0().f7283k.f7305o.setText(String.valueOf(t0Var4.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i22 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        default:
                            int i23 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                    }
                }
            });
            return;
        }
        if (i10 > 0) {
            n0().f7284l.f7343r.setTypeface(b.f11720s);
            if (t0Var.h == 1) {
                n0().f7284l.f7343r.setText(getString(R.string.replies_counter_single));
            } else {
                n0().f7284l.f7343r.setText(getString(R.string.replies_counter_multiple, String.valueOf(t0Var.h)));
            }
        } else {
            n0().f7284l.f7338m.setVisibility(8);
        }
        n0().f7284l.f7337l.setOnClickListener(new View.OnClickListener(this) { // from class: l4.n7

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RepliesActivity f10658b;

            {
                this.f10658b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                int i172 = i15;
                h5.t0 t0Var2 = t0Var;
                RepliesActivity repliesActivity = this.f10658b;
                switch (i172) {
                    case 0:
                        int i182 = RepliesActivity.L;
                        float f12 = UptodownApp.E;
                        if (k4.c.s()) {
                            RepliesActivity repliesActivity2 = this.f10658b;
                            if (h5.c1.h(repliesActivity2) == null) {
                                String string = repliesActivity2.getString(R.string.login_required_like_title);
                                string.getClass();
                                String string2 = repliesActivity2.getString(R.string.login_required_like_msg);
                                string2.getClass();
                                a.a.q(repliesActivity2, string, string2);
                                break;
                            } else {
                                new c1.w4(repliesActivity2, 5, false).F(repliesActivity2.n0().f7284l.e);
                                h5.t0 t0Var3 = t0Var;
                                if (!v5.n.f13172d.contains(Long.valueOf(t0Var3.f8739a))) {
                                    y7 y7VarO0 = repliesActivity2.o0();
                                    y7VarO0.getClass();
                                    r7.w viewModelScope = ViewModelKt.getViewModelScope(y7VarO0);
                                    y7.e eVar = r7.i0.f12407a;
                                    r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(t0Var3, repliesActivity2, y7VarO0, (w6.c) null, 16), 2);
                                    repliesActivity2.n0().f7284l.f7341p.setText(String.valueOf(t0Var3.f8744j + 1));
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        int i19 = RepliesActivity.L;
                        repliesActivity.r0(t0Var2.f8740b);
                        break;
                    case 2:
                        int i20 = RepliesActivity.L;
                        repliesActivity.r0(t0Var2.f8740b);
                        break;
                    case 3:
                        int i21 = RepliesActivity.L;
                        float f102 = UptodownApp.E;
                        if (k4.c.s()) {
                            RepliesActivity repliesActivity3 = this.f10658b;
                            if (h5.c1.h(repliesActivity3) == null) {
                                String string3 = repliesActivity3.getString(R.string.login_required_like_title);
                                string3.getClass();
                                String string4 = repliesActivity3.getString(R.string.login_required_like_msg);
                                string4.getClass();
                                a.a.q(repliesActivity3, string3, string4);
                                break;
                            } else {
                                new c1.w4(repliesActivity3, 5, false).F(repliesActivity3.n0().f7283k.e);
                                h5.t0 t0Var4 = t0Var;
                                if (!v5.n.f13172d.contains(Long.valueOf(t0Var4.f8739a))) {
                                    y7 y7VarO02 = repliesActivity3.o0();
                                    y7VarO02.getClass();
                                    r7.w viewModelScope2 = ViewModelKt.getViewModelScope(y7VarO02);
                                    y7.e eVar2 = r7.i0.f12407a;
                                    r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p(t0Var4, repliesActivity3, y7VarO02, (w6.c) null, 16), 2);
                                    repliesActivity3.n0().f7283k.f7305o.setText(String.valueOf(t0Var4.f8744j + 1));
                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        int i22 = RepliesActivity.L;
                        repliesActivity.r0(t0Var2.f8740b);
                        break;
                    default:
                        int i23 = RepliesActivity.L;
                        repliesActivity.r0(t0Var2.f8740b);
                        break;
                }
            }
        });
        if (v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a))) {
            n0().f7284l.e.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_heart_red));
        }
        n0().f7284l.f7341p.setTypeface(b.f11720s);
        n0().f7284l.f7341p.setText(String.valueOf(t0Var.f8744j));
        n0().f7284l.f.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
        n0().f7284l.g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
        n0().f7284l.h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
        n0().f7284l.f7334i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
        n0().f7284l.f7335j.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_off_turbo));
        if (t0Var.g >= 2) {
            n0().f7284l.g.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
        }
        if (t0Var.g >= 3) {
            n0().f7284l.h.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
        }
        if (t0Var.g >= 4) {
            n0().f7284l.f7334i.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
        }
        if (t0Var.g == 5) {
            n0().f7284l.f7335j.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.vector_star_on_turbo));
        }
        final e1 e1VarH2 = c1.h(this);
        if (e1VarH2 == null || !l.a(e1VarH2.f8512a, t0Var.f8740b)) {
            n0().f7284l.f7333d.setVisibility(0);
            if (t0Var.f8749o == 1) {
                n0().f7284l.f7333d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_following));
            } else {
                n0().f7284l.f7333d.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_follow));
            }
        } else {
            n0().f7284l.f7333d.setVisibility(8);
        }
        n0().f7284l.f7333d.setOnClickListener(new View.OnClickListener() { // from class: l4.o7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i172 = i15;
                RepliesActivity repliesActivity = this;
                h5.e1 e1Var = e1VarH2;
                switch (i172) {
                    case 0:
                        if (e1Var == null) {
                            int i182 = RepliesActivity.L;
                            repliesActivity.q0();
                            break;
                        } else {
                            repliesActivity.K.e(-1);
                            break;
                        }
                    default:
                        if (e1Var == null) {
                            int i19 = RepliesActivity.L;
                            repliesActivity.q0();
                            break;
                        } else {
                            repliesActivity.K.e(-1);
                            break;
                        }
                }
            }
        });
        n0().f7284l.t.setTypeface(b.f11719r);
        n0().f7284l.f7340o.setTypeface(b.f11720s);
        n0().f7284l.f7339n.setTypeface(b.f11720s);
        n0().f7284l.f7342q.setTypeface(b.f11720s);
        CharSequence charSequence4 = (CharSequence) o0().f11041o.getValue();
        if (charSequence4 == null || charSequence4.length() == 0) {
            String strE2 = c1.e(t0Var.f8742d);
            if (strE2 == null || strE2.length() == 0) {
                d0 d0VarF2 = j4.y.d().f();
                float f12 = UptodownApp.E;
                d0VarF2.g(k4.c.y(this));
                d0VarF2.e(n0().f7284l.f7332c, null);
            } else {
                d0 d0VarE3 = j4.y.d().e(c1.e(t0Var.f8742d));
                float f13 = UptodownApp.E;
                d0VarE3.g(k4.c.y(this));
                d0VarE3.e(n0().f7284l.f7332c, null);
            }
        } else {
            d0 d0VarE4 = j4.y.d().e(c1.e((String) o0().f11041o.getValue()));
            float f14 = UptodownApp.E;
            d0VarE4.g(k4.c.y(this));
            d0VarE4.e(n0().f7284l.f7332c, null);
        }
        String str5 = t0Var.f8741c;
        if (str5 == null || str5.length() == 0) {
            CharSequence charSequence5 = (CharSequence) o0().f11038l.getValue();
            if (charSequence5 != null && charSequence5.length() != 0) {
                n0().f7284l.t.setText((CharSequence) o0().f11038l.getValue());
                int i19 = UsernameTextView.f6728j;
                l1.b.j(n0().f7284l.t, t0Var.b(), t0Var.f8748n);
            }
        } else {
            n0().f7284l.t.setText(t0Var.f8741c);
            int i20 = UsernameTextView.f6728j;
            l1.b.j(n0().f7284l.t, t0Var.b(), t0Var.f8748n);
        }
        String str6 = t0Var.f8743i;
        if (str6 != null && str6.length() != 0) {
            n0().f7284l.f7340o.setText(t0Var.f8743i);
        }
        String str7 = t0Var.f;
        if (str7 == null || str7.length() == 0) {
            n0().f7284l.f7339n.setVisibility(8);
        } else {
            n0().f7284l.f7339n.setMaxLines(Integer.MAX_VALUE);
            TextView textView2 = n0().f7284l.f7339n;
            Spanned spannedA2 = t0Var.a();
            textView2.setText(spannedA2 != null ? o7.m.v0(spannedA2) : null);
            if (t0Var.h > 1) {
                n0().f7284l.f7342q.setText(String.valueOf(t0Var.h));
            }
        }
        if (t0Var.f8745k == 1) {
            n0().f7284l.f7331b.setVisibility(0);
        }
        String str8 = t0Var.f8740b;
        if (str8 != null && str8.length() != 0) {
            n0().f7284l.t.setOnClickListener(new View.OnClickListener(this) { // from class: l4.n7

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f10658b;

                {
                    this.f10658b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    int i172 = i16;
                    h5.t0 t0Var2 = t0Var;
                    RepliesActivity repliesActivity = this.f10658b;
                    switch (i172) {
                        case 0:
                            int i182 = RepliesActivity.L;
                            float f122 = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity2 = this.f10658b;
                                if (h5.c1.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(R.string.login_required_like_title);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(R.string.login_required_like_msg);
                                    string2.getClass();
                                    a.a.q(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity2, 5, false).F(repliesActivity2.n0().f7284l.e);
                                    h5.t0 t0Var3 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var3.f8739a))) {
                                        y7 y7VarO0 = repliesActivity2.o0();
                                        y7VarO0.getClass();
                                        r7.w viewModelScope = ViewModelKt.getViewModelScope(y7VarO0);
                                        y7.e eVar = r7.i0.f12407a;
                                        r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(t0Var3, repliesActivity2, y7VarO0, (w6.c) null, 16), 2);
                                        repliesActivity2.n0().f7284l.f7341p.setText(String.valueOf(t0Var3.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i192 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 2:
                            int i202 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 3:
                            int i21 = RepliesActivity.L;
                            float f102 = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity3 = this.f10658b;
                                if (h5.c1.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(R.string.login_required_like_title);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(R.string.login_required_like_msg);
                                    string4.getClass();
                                    a.a.q(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity3, 5, false).F(repliesActivity3.n0().f7283k.e);
                                    h5.t0 t0Var4 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var4.f8739a))) {
                                        y7 y7VarO02 = repliesActivity3.o0();
                                        y7VarO02.getClass();
                                        r7.w viewModelScope2 = ViewModelKt.getViewModelScope(y7VarO02);
                                        y7.e eVar2 = r7.i0.f12407a;
                                        r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p(t0Var4, repliesActivity3, y7VarO02, (w6.c) null, 16), 2);
                                        repliesActivity3.n0().f7283k.f7305o.setText(String.valueOf(t0Var4.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i22 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        default:
                            int i23 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                    }
                }
            });
            n0().f7284l.f7332c.setOnClickListener(new View.OnClickListener(this) { // from class: l4.n7

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ RepliesActivity f10658b;

                {
                    this.f10658b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    int i172 = i14;
                    h5.t0 t0Var2 = t0Var;
                    RepliesActivity repliesActivity = this.f10658b;
                    switch (i172) {
                        case 0:
                            int i182 = RepliesActivity.L;
                            float f122 = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity2 = this.f10658b;
                                if (h5.c1.h(repliesActivity2) == null) {
                                    String string = repliesActivity2.getString(R.string.login_required_like_title);
                                    string.getClass();
                                    String string2 = repliesActivity2.getString(R.string.login_required_like_msg);
                                    string2.getClass();
                                    a.a.q(repliesActivity2, string, string2);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity2, 5, false).F(repliesActivity2.n0().f7284l.e);
                                    h5.t0 t0Var3 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var3.f8739a))) {
                                        y7 y7VarO0 = repliesActivity2.o0();
                                        y7VarO0.getClass();
                                        r7.w viewModelScope = ViewModelKt.getViewModelScope(y7VarO0);
                                        y7.e eVar = r7.i0.f12407a;
                                        r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(t0Var3, repliesActivity2, y7VarO0, (w6.c) null, 16), 2);
                                        repliesActivity2.n0().f7284l.f7341p.setText(String.valueOf(t0Var3.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            int i192 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 2:
                            int i202 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        case 3:
                            int i21 = RepliesActivity.L;
                            float f102 = UptodownApp.E;
                            if (k4.c.s()) {
                                RepliesActivity repliesActivity3 = this.f10658b;
                                if (h5.c1.h(repliesActivity3) == null) {
                                    String string3 = repliesActivity3.getString(R.string.login_required_like_title);
                                    string3.getClass();
                                    String string4 = repliesActivity3.getString(R.string.login_required_like_msg);
                                    string4.getClass();
                                    a.a.q(repliesActivity3, string3, string4);
                                    break;
                                } else {
                                    new c1.w4(repliesActivity3, 5, false).F(repliesActivity3.n0().f7283k.e);
                                    h5.t0 t0Var4 = t0Var;
                                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var4.f8739a))) {
                                        y7 y7VarO02 = repliesActivity3.o0();
                                        y7VarO02.getClass();
                                        r7.w viewModelScope2 = ViewModelKt.getViewModelScope(y7VarO02);
                                        y7.e eVar2 = r7.i0.f12407a;
                                        r7.y.q(viewModelScope2, y7.d.f14116a, null, new b9.p(t0Var4, repliesActivity3, y7VarO02, (w6.c) null, 16), 2);
                                        repliesActivity3.n0().f7283k.f7305o.setText(String.valueOf(t0Var4.f8744j + 1));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4:
                            int i22 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                        default:
                            int i23 = RepliesActivity.L;
                            repliesActivity.r0(t0Var2.f8740b);
                            break;
                    }
                }
            });
        }
        n0().f7284l.f7336k.setOnClickListener(new m7(this, i11));
        n0().f7284l.f7336k.setVisibility(0);
        ImageView imageView = n0().f7284l.f7332c;
        int dimension = (int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_xs);
        imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_stroke_review_avatar_turbo));
        imageView.setPadding(dimension, dimension, dimension, dimension);
        n0().f7284l.f7330a.setVisibility(0);
        n0().f7283k.f7295a.setVisibility(8);
    }

    public final void t0() {
        e1 e1VarH = c1.h(this);
        if ((e1VarH != null ? e1VarH.f8514c : null) == null) {
            n0().e.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_user_default));
            return;
        }
        d0 d0VarE = j4.y.d().e(c1.e(e1VarH.f8514c));
        d0VarE.f(R.drawable.shape_bg_placeholder);
        float f = UptodownApp.E;
        d0VarE.g(k4.c.y(this));
        d0VarE.e(n0().e, null);
        if (e1VarH.d()) {
            ImageView imageView = n0().e;
            int dimension = (int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_xs);
            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_stroke_review_small_avatar_turbo));
            imageView.setPadding(dimension, dimension, dimension, dimension);
        }
    }

    public final void u0() {
        e1 e1VarH = c1.h(this);
        if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
            String str = e1VarH.f8512a;
            str.getClass();
            if (str.length() > 0) {
                n0().f7281i.setVisibility(8);
                return;
            }
        }
        n0().f7281i.setVisibility(0);
    }
}
