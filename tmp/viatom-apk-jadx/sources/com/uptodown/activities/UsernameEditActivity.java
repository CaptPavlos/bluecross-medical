package com.uptodown.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import b9.p;
import com.uptodown.R;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.util.views.UsernameTextView;
import d5.i1;
import h5.e1;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.x;
import kotlin.jvm.internal.y;
import l4.bc;
import l4.kb;
import l4.w;
import l4.wb;
import l4.x2;
import l4.yb;
import l4.zb;
import o4.b;
import r7.i0;
import s6.m;
import w6.c;
import w7.n;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UsernameEditActivity extends w {
    public static final /* synthetic */ int K = 0;
    public e1 H;
    public final ViewModelLazy I = new ViewModelLazy(y.a(bc.class), new zb(this, 0), new yb(this), new zb(this, 1));
    public final m J = new m(new x2(this, 22));

    public final i1 n0() {
        return (i1) this.J.getValue();
    }

    public final void o0(String str) {
        if (str.length() <= 0 || str.length() < 3) {
            n0().f7125q.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            n0().f7125q.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() <= 99) {
            n0().f7124p.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            n0().f7124p.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() > 0) {
            Pattern patternCompile = Pattern.compile("^[a-zA-Z0-9_]+$");
            patternCompile.getClass();
            if (patternCompile.matcher(str).matches()) {
                n0().f7128u.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
        }
        n0().f7128u.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        UsernameEditActivity usernameEditActivity;
        String str;
        Bundle extras;
        Spanned spannedFromHtml;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7113a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        final int i10 = 1;
        final int i11 = 2;
        c cVar = null;
        if (getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user")) {
            usernameEditActivity = this;
        } else {
            int i12 = Build.VERSION.SDK_INT;
            this.H = (e1) (i12 >= 34 ? (Parcelable) extras.getParcelable("user", e1.class) : extras.getParcelable("user"));
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            final int i13 = 0;
            if (drawable != null) {
                n0().f7123o.setNavigationIcon(drawable);
                n0().f7123o.setNavigationContentDescription(getString(R.string.back));
                n0().f7123o.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.ub

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ UsernameEditActivity f10893b;

                    {
                        this.f10893b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SharedPreferences sharedPreferences;
                        int i14 = i13;
                        UsernameEditActivity usernameEditActivity2 = this.f10893b;
                        switch (i14) {
                            case 0:
                                int i15 = UsernameEditActivity.K;
                                usernameEditActivity2.getOnBackPressedDispatcher().onBackPressed();
                                break;
                            case 1:
                                int i16 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 2:
                                int i17 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 3:
                                int i18 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 4:
                                if (usernameEditActivity2.H != null) {
                                    SharedPreferences sharedPreferences2 = usernameEditActivity2.getSharedPreferences("SharedPreferencesUser", 0);
                                    try {
                                        sharedPreferences = usernameEditActivity2.getSharedPreferences("SettingsPreferences", 0);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                                    if (string != null || sharedPreferences2.getString("is_turbo", null) != null) {
                                        h5.e1 e1Var = usernameEditActivity2.H;
                                        e1Var.getClass();
                                        if (e1Var.d()) {
                                        }
                                    }
                                }
                                v5.c.e(usernameEditActivity2, com.google.android.gms.internal.measurement.l5.A(usernameEditActivity2), null);
                                break;
                            case 5:
                                int i19 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            default:
                                int i20 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                        }
                    }
                });
            }
            n0().f7126r.setTypeface(b.f11719r);
            n0().t.setTypeface(b.f11720s);
            n0().f7127s.setTypeface(b.f11720s);
            final int i14 = 4;
            n0().f.setOnClickListener(new View.OnClickListener(this) { // from class: l4.ub

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UsernameEditActivity f10893b;

                {
                    this.f10893b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SharedPreferences sharedPreferences;
                    int i142 = i14;
                    UsernameEditActivity usernameEditActivity2 = this.f10893b;
                    switch (i142) {
                        case 0:
                            int i15 = UsernameEditActivity.K;
                            usernameEditActivity2.getOnBackPressedDispatcher().onBackPressed();
                            break;
                        case 1:
                            int i16 = UsernameEditActivity.K;
                            usernameEditActivity2.l0();
                            break;
                        case 2:
                            int i17 = UsernameEditActivity.K;
                            usernameEditActivity2.l0();
                            break;
                        case 3:
                            int i18 = UsernameEditActivity.K;
                            usernameEditActivity2.l0();
                            break;
                        case 4:
                            if (usernameEditActivity2.H != null) {
                                SharedPreferences sharedPreferences2 = usernameEditActivity2.getSharedPreferences("SharedPreferencesUser", 0);
                                try {
                                    sharedPreferences = usernameEditActivity2.getSharedPreferences("SettingsPreferences", 0);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                                if (string != null || sharedPreferences2.getString("is_turbo", null) != null) {
                                    h5.e1 e1Var = usernameEditActivity2.H;
                                    e1Var.getClass();
                                    if (e1Var.d()) {
                                    }
                                }
                            }
                            v5.c.e(usernameEditActivity2, com.google.android.gms.internal.measurement.l5.A(usernameEditActivity2), null);
                            break;
                        case 5:
                            int i19 = UsernameEditActivity.K;
                            usernameEditActivity2.l0();
                            break;
                        default:
                            int i20 = UsernameEditActivity.K;
                            usernameEditActivity2.l0();
                            break;
                    }
                }
            });
            n0().f7114b.setTypeface(b.f11720s);
            EditText editText = n0().f7114b;
            e1 e1Var = this.H;
            e1Var.getClass();
            editText.setText(e1Var.f8515d);
            n0().f7129v.setTypeface(b.f11719r);
            n0().f7125q.setTypeface(b.f11720s);
            n0().f7124p.setTypeface(b.f11720s);
            n0().f7128u.setTypeface(b.f11720s);
            n0().f7130w.setTypeface(b.f11719r);
            n0().f7131x.setTypeface(b.f11719r);
            n0().y.setTypeface(b.f11719r);
            n0().f7132z.setTypeface(b.f11719r);
            UsernameTextView usernameTextView = n0().f7130w;
            e1 e1Var2 = this.H;
            e1Var2.getClass();
            usernameTextView.setText(e1Var2.f8515d);
            UsernameTextView usernameTextView2 = n0().f7131x;
            e1 e1Var3 = this.H;
            e1Var3.getClass();
            usernameTextView2.setText(e1Var3.f8515d);
            UsernameTextView usernameTextView3 = n0().y;
            e1 e1Var4 = this.H;
            e1Var4.getClass();
            usernameTextView3.setText(e1Var4.f8515d);
            UsernameTextView usernameTextView4 = n0().f7132z;
            e1 e1Var5 = this.H;
            e1Var5.getClass();
            usernameTextView4.setText(e1Var5.f8515d);
            final v vVar = new v();
            final x xVar = new x();
            xVar.f10138a = "type0";
            n0().f7119k.setOnClickListener(new View.OnClickListener(this) { // from class: l4.vb

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UsernameEditActivity f10931b;

                {
                    this.f10931b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i15 = i10;
                    UsernameEditActivity usernameEditActivity2 = this.f10931b;
                    kotlin.jvm.internal.x xVar2 = xVar;
                    kotlin.jvm.internal.v vVar2 = vVar;
                    switch (i15) {
                        case 0:
                            int i16 = UsernameEditActivity.K;
                            Activity activity = o4.b.g;
                            UsernameEditActivity usernameEditActivity3 = this.f10931b;
                            r0.f.q(usernameEditActivity3, usernameEditActivity3.n0().f7114b);
                            if (usernameEditActivity3.n0().f7114b.getText().toString().length() != 0) {
                                if (usernameEditActivity3.n0().f7114b.getText().toString().length() >= 3) {
                                    if (usernameEditActivity3.n0().f7114b.getText().toString().length() <= 99) {
                                        String string = usernameEditActivity3.n0().f7114b.getText().toString();
                                        Pattern patternCompile = Pattern.compile("^[a-zA-Z0-9_]+$");
                                        patternCompile.getClass();
                                        string.getClass();
                                        if (!patternCompile.matcher(string).matches()) {
                                            String string2 = usernameEditActivity3.getString(R.string.validation_username_chars_type);
                                            string2.getClass();
                                            usernameEditActivity3.C(string2);
                                            break;
                                        } else {
                                            bc bcVar = (bc) usernameEditActivity3.I.getValue();
                                            String string3 = usernameEditActivity3.n0().f7114b.getText().toString();
                                            h5.e1 e1Var6 = usernameEditActivity3.H;
                                            int i17 = vVar2.f10136a;
                                            String str2 = (String) xVar2.f10138a;
                                            bcVar.getClass();
                                            string3.getClass();
                                            str2.getClass();
                                            kotlin.jvm.internal.v vVar3 = new kotlin.jvm.internal.v();
                                            kotlin.jvm.internal.x xVar3 = new kotlin.jvm.internal.x();
                                            r7.w viewModelScope = ViewModelKt.getViewModelScope(bcVar);
                                            y7.e eVar = r7.i0.f12407a;
                                            r7.y.q(viewModelScope, y7.d.f14116a, null, new c5.k(bcVar, usernameEditActivity3, string3, i17, xVar3, vVar3, e1Var6, str2, null), 2);
                                            break;
                                        }
                                    } else {
                                        String string4 = usernameEditActivity3.getString(R.string.validation_hundred_chars_max);
                                        string4.getClass();
                                        usernameEditActivity3.C(string4);
                                        break;
                                    }
                                } else {
                                    String string5 = usernameEditActivity3.getString(R.string.validation_three_chars_min);
                                    string5.getClass();
                                    usernameEditActivity3.C(string5);
                                    break;
                                }
                            } else {
                                String string6 = usernameEditActivity3.getString(R.string.error_email_vacio_recuperar_pass);
                                string6.getClass();
                                usernameEditActivity3.C(string6);
                                break;
                            }
                        case 1:
                            int i18 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 0;
                            xVar2.f10138a = "type0";
                            break;
                        case 2:
                            int i19 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 1;
                            xVar2.f10138a = "type1";
                            break;
                        case 3:
                            int i20 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 2;
                            xVar2.f10138a = "type2";
                            break;
                        default:
                            int i21 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            vVar2.f10136a = 3;
                            xVar2.f10138a = "type3";
                            break;
                    }
                }
            });
            n0().f7120l.setOnClickListener(new View.OnClickListener(this) { // from class: l4.vb

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UsernameEditActivity f10931b;

                {
                    this.f10931b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i15 = i11;
                    UsernameEditActivity usernameEditActivity2 = this.f10931b;
                    kotlin.jvm.internal.x xVar2 = xVar;
                    kotlin.jvm.internal.v vVar2 = vVar;
                    switch (i15) {
                        case 0:
                            int i16 = UsernameEditActivity.K;
                            Activity activity = o4.b.g;
                            UsernameEditActivity usernameEditActivity3 = this.f10931b;
                            r0.f.q(usernameEditActivity3, usernameEditActivity3.n0().f7114b);
                            if (usernameEditActivity3.n0().f7114b.getText().toString().length() != 0) {
                                if (usernameEditActivity3.n0().f7114b.getText().toString().length() >= 3) {
                                    if (usernameEditActivity3.n0().f7114b.getText().toString().length() <= 99) {
                                        String string = usernameEditActivity3.n0().f7114b.getText().toString();
                                        Pattern patternCompile = Pattern.compile("^[a-zA-Z0-9_]+$");
                                        patternCompile.getClass();
                                        string.getClass();
                                        if (!patternCompile.matcher(string).matches()) {
                                            String string2 = usernameEditActivity3.getString(R.string.validation_username_chars_type);
                                            string2.getClass();
                                            usernameEditActivity3.C(string2);
                                            break;
                                        } else {
                                            bc bcVar = (bc) usernameEditActivity3.I.getValue();
                                            String string3 = usernameEditActivity3.n0().f7114b.getText().toString();
                                            h5.e1 e1Var6 = usernameEditActivity3.H;
                                            int i17 = vVar2.f10136a;
                                            String str2 = (String) xVar2.f10138a;
                                            bcVar.getClass();
                                            string3.getClass();
                                            str2.getClass();
                                            kotlin.jvm.internal.v vVar3 = new kotlin.jvm.internal.v();
                                            kotlin.jvm.internal.x xVar3 = new kotlin.jvm.internal.x();
                                            r7.w viewModelScope = ViewModelKt.getViewModelScope(bcVar);
                                            y7.e eVar = r7.i0.f12407a;
                                            r7.y.q(viewModelScope, y7.d.f14116a, null, new c5.k(bcVar, usernameEditActivity3, string3, i17, xVar3, vVar3, e1Var6, str2, null), 2);
                                            break;
                                        }
                                    } else {
                                        String string4 = usernameEditActivity3.getString(R.string.validation_hundred_chars_max);
                                        string4.getClass();
                                        usernameEditActivity3.C(string4);
                                        break;
                                    }
                                } else {
                                    String string5 = usernameEditActivity3.getString(R.string.validation_three_chars_min);
                                    string5.getClass();
                                    usernameEditActivity3.C(string5);
                                    break;
                                }
                            } else {
                                String string6 = usernameEditActivity3.getString(R.string.error_email_vacio_recuperar_pass);
                                string6.getClass();
                                usernameEditActivity3.C(string6);
                                break;
                            }
                        case 1:
                            int i18 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 0;
                            xVar2.f10138a = "type0";
                            break;
                        case 2:
                            int i19 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 1;
                            xVar2.f10138a = "type1";
                            break;
                        case 3:
                            int i20 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 2;
                            xVar2.f10138a = "type2";
                            break;
                        default:
                            int i21 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            vVar2.f10136a = 3;
                            xVar2.f10138a = "type3";
                            break;
                    }
                }
            });
            final int i15 = 3;
            n0().f7121m.setOnClickListener(new View.OnClickListener(this) { // from class: l4.vb

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UsernameEditActivity f10931b;

                {
                    this.f10931b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i152 = i15;
                    UsernameEditActivity usernameEditActivity2 = this.f10931b;
                    kotlin.jvm.internal.x xVar2 = xVar;
                    kotlin.jvm.internal.v vVar2 = vVar;
                    switch (i152) {
                        case 0:
                            int i16 = UsernameEditActivity.K;
                            Activity activity = o4.b.g;
                            UsernameEditActivity usernameEditActivity3 = this.f10931b;
                            r0.f.q(usernameEditActivity3, usernameEditActivity3.n0().f7114b);
                            if (usernameEditActivity3.n0().f7114b.getText().toString().length() != 0) {
                                if (usernameEditActivity3.n0().f7114b.getText().toString().length() >= 3) {
                                    if (usernameEditActivity3.n0().f7114b.getText().toString().length() <= 99) {
                                        String string = usernameEditActivity3.n0().f7114b.getText().toString();
                                        Pattern patternCompile = Pattern.compile("^[a-zA-Z0-9_]+$");
                                        patternCompile.getClass();
                                        string.getClass();
                                        if (!patternCompile.matcher(string).matches()) {
                                            String string2 = usernameEditActivity3.getString(R.string.validation_username_chars_type);
                                            string2.getClass();
                                            usernameEditActivity3.C(string2);
                                            break;
                                        } else {
                                            bc bcVar = (bc) usernameEditActivity3.I.getValue();
                                            String string3 = usernameEditActivity3.n0().f7114b.getText().toString();
                                            h5.e1 e1Var6 = usernameEditActivity3.H;
                                            int i17 = vVar2.f10136a;
                                            String str2 = (String) xVar2.f10138a;
                                            bcVar.getClass();
                                            string3.getClass();
                                            str2.getClass();
                                            kotlin.jvm.internal.v vVar3 = new kotlin.jvm.internal.v();
                                            kotlin.jvm.internal.x xVar3 = new kotlin.jvm.internal.x();
                                            r7.w viewModelScope = ViewModelKt.getViewModelScope(bcVar);
                                            y7.e eVar = r7.i0.f12407a;
                                            r7.y.q(viewModelScope, y7.d.f14116a, null, new c5.k(bcVar, usernameEditActivity3, string3, i17, xVar3, vVar3, e1Var6, str2, null), 2);
                                            break;
                                        }
                                    } else {
                                        String string4 = usernameEditActivity3.getString(R.string.validation_hundred_chars_max);
                                        string4.getClass();
                                        usernameEditActivity3.C(string4);
                                        break;
                                    }
                                } else {
                                    String string5 = usernameEditActivity3.getString(R.string.validation_three_chars_min);
                                    string5.getClass();
                                    usernameEditActivity3.C(string5);
                                    break;
                                }
                            } else {
                                String string6 = usernameEditActivity3.getString(R.string.error_email_vacio_recuperar_pass);
                                string6.getClass();
                                usernameEditActivity3.C(string6);
                                break;
                            }
                        case 1:
                            int i18 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 0;
                            xVar2.f10138a = "type0";
                            break;
                        case 2:
                            int i19 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 1;
                            xVar2.f10138a = "type1";
                            break;
                        case 3:
                            int i20 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 2;
                            xVar2.f10138a = "type2";
                            break;
                        default:
                            int i21 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            vVar2.f10136a = 3;
                            xVar2.f10138a = "type3";
                            break;
                    }
                }
            });
            n0().f7122n.setOnClickListener(new View.OnClickListener(this) { // from class: l4.vb

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UsernameEditActivity f10931b;

                {
                    this.f10931b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i152 = i14;
                    UsernameEditActivity usernameEditActivity2 = this.f10931b;
                    kotlin.jvm.internal.x xVar2 = xVar;
                    kotlin.jvm.internal.v vVar2 = vVar;
                    switch (i152) {
                        case 0:
                            int i16 = UsernameEditActivity.K;
                            Activity activity = o4.b.g;
                            UsernameEditActivity usernameEditActivity3 = this.f10931b;
                            r0.f.q(usernameEditActivity3, usernameEditActivity3.n0().f7114b);
                            if (usernameEditActivity3.n0().f7114b.getText().toString().length() != 0) {
                                if (usernameEditActivity3.n0().f7114b.getText().toString().length() >= 3) {
                                    if (usernameEditActivity3.n0().f7114b.getText().toString().length() <= 99) {
                                        String string = usernameEditActivity3.n0().f7114b.getText().toString();
                                        Pattern patternCompile = Pattern.compile("^[a-zA-Z0-9_]+$");
                                        patternCompile.getClass();
                                        string.getClass();
                                        if (!patternCompile.matcher(string).matches()) {
                                            String string2 = usernameEditActivity3.getString(R.string.validation_username_chars_type);
                                            string2.getClass();
                                            usernameEditActivity3.C(string2);
                                            break;
                                        } else {
                                            bc bcVar = (bc) usernameEditActivity3.I.getValue();
                                            String string3 = usernameEditActivity3.n0().f7114b.getText().toString();
                                            h5.e1 e1Var6 = usernameEditActivity3.H;
                                            int i17 = vVar2.f10136a;
                                            String str2 = (String) xVar2.f10138a;
                                            bcVar.getClass();
                                            string3.getClass();
                                            str2.getClass();
                                            kotlin.jvm.internal.v vVar3 = new kotlin.jvm.internal.v();
                                            kotlin.jvm.internal.x xVar3 = new kotlin.jvm.internal.x();
                                            r7.w viewModelScope = ViewModelKt.getViewModelScope(bcVar);
                                            y7.e eVar = r7.i0.f12407a;
                                            r7.y.q(viewModelScope, y7.d.f14116a, null, new c5.k(bcVar, usernameEditActivity3, string3, i17, xVar3, vVar3, e1Var6, str2, null), 2);
                                            break;
                                        }
                                    } else {
                                        String string4 = usernameEditActivity3.getString(R.string.validation_hundred_chars_max);
                                        string4.getClass();
                                        usernameEditActivity3.C(string4);
                                        break;
                                    }
                                } else {
                                    String string5 = usernameEditActivity3.getString(R.string.validation_three_chars_min);
                                    string5.getClass();
                                    usernameEditActivity3.C(string5);
                                    break;
                                }
                            } else {
                                String string6 = usernameEditActivity3.getString(R.string.error_email_vacio_recuperar_pass);
                                string6.getClass();
                                usernameEditActivity3.C(string6);
                                break;
                            }
                        case 1:
                            int i18 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 0;
                            xVar2.f10138a = "type0";
                            break;
                        case 2:
                            int i19 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 1;
                            xVar2.f10138a = "type1";
                            break;
                        case 3:
                            int i20 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 2;
                            xVar2.f10138a = "type2";
                            break;
                        default:
                            int i21 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            vVar2.f10136a = 3;
                            xVar2.f10138a = "type3";
                            break;
                    }
                }
            });
            e1 e1Var6 = this.H;
            e1Var6.getClass();
            if (!e1Var6.d()) {
                n0().f7127s.setVisibility(0);
                TextView textView = n0().f7127s;
                String string = getString(R.string.username_turbo_styles_locked);
                string.getClass();
                if (i12 >= 24) {
                    spannedFromHtml = Html.fromHtml(string, 0, null, new x5.m(this));
                    spannedFromHtml.getClass();
                } else {
                    spannedFromHtml = Html.fromHtml(string, null, new x5.m(this));
                    spannedFromHtml.getClass();
                }
                textView.setText(spannedFromHtml);
                final int i16 = 5;
                n0().f7127s.setOnClickListener(new View.OnClickListener(this) { // from class: l4.ub

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ UsernameEditActivity f10893b;

                    {
                        this.f10893b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SharedPreferences sharedPreferences;
                        int i142 = i16;
                        UsernameEditActivity usernameEditActivity2 = this.f10893b;
                        switch (i142) {
                            case 0:
                                int i152 = UsernameEditActivity.K;
                                usernameEditActivity2.getOnBackPressedDispatcher().onBackPressed();
                                break;
                            case 1:
                                int i162 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 2:
                                int i17 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 3:
                                int i18 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 4:
                                if (usernameEditActivity2.H != null) {
                                    SharedPreferences sharedPreferences2 = usernameEditActivity2.getSharedPreferences("SharedPreferencesUser", 0);
                                    try {
                                        sharedPreferences = usernameEditActivity2.getSharedPreferences("SettingsPreferences", 0);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    String string2 = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                                    if (string2 != null || sharedPreferences2.getString("is_turbo", null) != null) {
                                        h5.e1 e1Var7 = usernameEditActivity2.H;
                                        e1Var7.getClass();
                                        if (e1Var7.d()) {
                                        }
                                    }
                                }
                                v5.c.e(usernameEditActivity2, com.google.android.gms.internal.measurement.l5.A(usernameEditActivity2), null);
                                break;
                            case 5:
                                int i19 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            default:
                                int i20 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                        }
                    }
                });
                final int i17 = 6;
                n0().t.setOnClickListener(new View.OnClickListener(this) { // from class: l4.ub

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ UsernameEditActivity f10893b;

                    {
                        this.f10893b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SharedPreferences sharedPreferences;
                        int i142 = i17;
                        UsernameEditActivity usernameEditActivity2 = this.f10893b;
                        switch (i142) {
                            case 0:
                                int i152 = UsernameEditActivity.K;
                                usernameEditActivity2.getOnBackPressedDispatcher().onBackPressed();
                                break;
                            case 1:
                                int i162 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 2:
                                int i172 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 3:
                                int i18 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 4:
                                if (usernameEditActivity2.H != null) {
                                    SharedPreferences sharedPreferences2 = usernameEditActivity2.getSharedPreferences("SharedPreferencesUser", 0);
                                    try {
                                        sharedPreferences = usernameEditActivity2.getSharedPreferences("SettingsPreferences", 0);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    String string2 = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                                    if (string2 != null || sharedPreferences2.getString("is_turbo", null) != null) {
                                        h5.e1 e1Var7 = usernameEditActivity2.H;
                                        e1Var7.getClass();
                                        if (e1Var7.d()) {
                                        }
                                    }
                                }
                                v5.c.e(usernameEditActivity2, com.google.android.gms.internal.measurement.l5.A(usernameEditActivity2), null);
                                break;
                            case 5:
                                int i19 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            default:
                                int i20 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                        }
                    }
                });
                n0().f.setVisibility(8);
                n0().f7119k.setChecked(true);
                n0().f7115c.setVisibility(0);
                n0().f7120l.setEnabled(false);
                n0().f7116d.setVisibility(0);
                n0().f7121m.setEnabled(false);
                n0().e.setVisibility(0);
                n0().f7122n.setEnabled(false);
                n0().g.setOnClickListener(new View.OnClickListener(this) { // from class: l4.ub

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ UsernameEditActivity f10893b;

                    {
                        this.f10893b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SharedPreferences sharedPreferences;
                        int i142 = i10;
                        UsernameEditActivity usernameEditActivity2 = this.f10893b;
                        switch (i142) {
                            case 0:
                                int i152 = UsernameEditActivity.K;
                                usernameEditActivity2.getOnBackPressedDispatcher().onBackPressed();
                                break;
                            case 1:
                                int i162 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 2:
                                int i172 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 3:
                                int i18 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 4:
                                if (usernameEditActivity2.H != null) {
                                    SharedPreferences sharedPreferences2 = usernameEditActivity2.getSharedPreferences("SharedPreferencesUser", 0);
                                    try {
                                        sharedPreferences = usernameEditActivity2.getSharedPreferences("SettingsPreferences", 0);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    String string2 = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                                    if (string2 != null || sharedPreferences2.getString("is_turbo", null) != null) {
                                        h5.e1 e1Var7 = usernameEditActivity2.H;
                                        e1Var7.getClass();
                                        if (e1Var7.d()) {
                                        }
                                    }
                                }
                                v5.c.e(usernameEditActivity2, com.google.android.gms.internal.measurement.l5.A(usernameEditActivity2), null);
                                break;
                            case 5:
                                int i19 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            default:
                                int i20 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                        }
                    }
                });
                n0().h.setOnClickListener(new View.OnClickListener(this) { // from class: l4.ub

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ UsernameEditActivity f10893b;

                    {
                        this.f10893b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SharedPreferences sharedPreferences;
                        int i142 = i11;
                        UsernameEditActivity usernameEditActivity2 = this.f10893b;
                        switch (i142) {
                            case 0:
                                int i152 = UsernameEditActivity.K;
                                usernameEditActivity2.getOnBackPressedDispatcher().onBackPressed();
                                break;
                            case 1:
                                int i162 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 2:
                                int i172 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 3:
                                int i18 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 4:
                                if (usernameEditActivity2.H != null) {
                                    SharedPreferences sharedPreferences2 = usernameEditActivity2.getSharedPreferences("SharedPreferencesUser", 0);
                                    try {
                                        sharedPreferences = usernameEditActivity2.getSharedPreferences("SettingsPreferences", 0);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    String string2 = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                                    if (string2 != null || sharedPreferences2.getString("is_turbo", null) != null) {
                                        h5.e1 e1Var7 = usernameEditActivity2.H;
                                        e1Var7.getClass();
                                        if (e1Var7.d()) {
                                        }
                                    }
                                }
                                v5.c.e(usernameEditActivity2, com.google.android.gms.internal.measurement.l5.A(usernameEditActivity2), null);
                                break;
                            case 5:
                                int i19 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            default:
                                int i20 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                        }
                    }
                });
                n0().f7117i.setOnClickListener(new View.OnClickListener(this) { // from class: l4.ub

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ UsernameEditActivity f10893b;

                    {
                        this.f10893b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SharedPreferences sharedPreferences;
                        int i142 = i15;
                        UsernameEditActivity usernameEditActivity2 = this.f10893b;
                        switch (i142) {
                            case 0:
                                int i152 = UsernameEditActivity.K;
                                usernameEditActivity2.getOnBackPressedDispatcher().onBackPressed();
                                break;
                            case 1:
                                int i162 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 2:
                                int i172 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 3:
                                int i18 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            case 4:
                                if (usernameEditActivity2.H != null) {
                                    SharedPreferences sharedPreferences2 = usernameEditActivity2.getSharedPreferences("SharedPreferencesUser", 0);
                                    try {
                                        sharedPreferences = usernameEditActivity2.getSharedPreferences("SettingsPreferences", 0);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    String string2 = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                                    if (string2 != null || sharedPreferences2.getString("is_turbo", null) != null) {
                                        h5.e1 e1Var7 = usernameEditActivity2.H;
                                        e1Var7.getClass();
                                        if (e1Var7.d()) {
                                        }
                                    }
                                }
                                v5.c.e(usernameEditActivity2, com.google.android.gms.internal.measurement.l5.A(usernameEditActivity2), null);
                                break;
                            case 5:
                                int i19 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                            default:
                                int i20 = UsernameEditActivity.K;
                                usernameEditActivity2.l0();
                                break;
                        }
                    }
                });
            }
            n0().f7114b.addTextChangedListener(new wb(this, 1));
            n0().f7129v.setOnClickListener(new View.OnClickListener(this) { // from class: l4.vb

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ UsernameEditActivity f10931b;

                {
                    this.f10931b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i152 = i13;
                    UsernameEditActivity usernameEditActivity2 = this.f10931b;
                    kotlin.jvm.internal.x xVar2 = xVar;
                    kotlin.jvm.internal.v vVar2 = vVar;
                    switch (i152) {
                        case 0:
                            int i162 = UsernameEditActivity.K;
                            Activity activity = o4.b.g;
                            UsernameEditActivity usernameEditActivity3 = this.f10931b;
                            r0.f.q(usernameEditActivity3, usernameEditActivity3.n0().f7114b);
                            if (usernameEditActivity3.n0().f7114b.getText().toString().length() != 0) {
                                if (usernameEditActivity3.n0().f7114b.getText().toString().length() >= 3) {
                                    if (usernameEditActivity3.n0().f7114b.getText().toString().length() <= 99) {
                                        String string2 = usernameEditActivity3.n0().f7114b.getText().toString();
                                        Pattern patternCompile = Pattern.compile("^[a-zA-Z0-9_]+$");
                                        patternCompile.getClass();
                                        string2.getClass();
                                        if (!patternCompile.matcher(string2).matches()) {
                                            String string22 = usernameEditActivity3.getString(R.string.validation_username_chars_type);
                                            string22.getClass();
                                            usernameEditActivity3.C(string22);
                                            break;
                                        } else {
                                            bc bcVar = (bc) usernameEditActivity3.I.getValue();
                                            String string3 = usernameEditActivity3.n0().f7114b.getText().toString();
                                            h5.e1 e1Var62 = usernameEditActivity3.H;
                                            int i172 = vVar2.f10136a;
                                            String str2 = (String) xVar2.f10138a;
                                            bcVar.getClass();
                                            string3.getClass();
                                            str2.getClass();
                                            kotlin.jvm.internal.v vVar3 = new kotlin.jvm.internal.v();
                                            kotlin.jvm.internal.x xVar3 = new kotlin.jvm.internal.x();
                                            r7.w viewModelScope = ViewModelKt.getViewModelScope(bcVar);
                                            y7.e eVar = r7.i0.f12407a;
                                            r7.y.q(viewModelScope, y7.d.f14116a, null, new c5.k(bcVar, usernameEditActivity3, string3, i172, xVar3, vVar3, e1Var62, str2, null), 2);
                                            break;
                                        }
                                    } else {
                                        String string4 = usernameEditActivity3.getString(R.string.validation_hundred_chars_max);
                                        string4.getClass();
                                        usernameEditActivity3.C(string4);
                                        break;
                                    }
                                } else {
                                    String string5 = usernameEditActivity3.getString(R.string.validation_three_chars_min);
                                    string5.getClass();
                                    usernameEditActivity3.C(string5);
                                    break;
                                }
                            } else {
                                String string6 = usernameEditActivity3.getString(R.string.error_email_vacio_recuperar_pass);
                                string6.getClass();
                                usernameEditActivity3.C(string6);
                                break;
                            }
                        case 1:
                            int i18 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 0;
                            xVar2.f10138a = "type0";
                            break;
                        case 2:
                            int i19 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 1;
                            xVar2.f10138a = "type1";
                            break;
                        case 3:
                            int i20 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7122n.setChecked(false);
                            vVar2.f10136a = 2;
                            xVar2.f10138a = "type2";
                            break;
                        default:
                            int i21 = UsernameEditActivity.K;
                            usernameEditActivity2.n0().f7119k.setChecked(false);
                            usernameEditActivity2.n0().f7120l.setChecked(false);
                            usernameEditActivity2.n0().f7121m.setChecked(false);
                            vVar2.f10136a = 3;
                            xVar2.f10138a = "type3";
                            break;
                    }
                }
            });
            n0().f7114b.addTextChangedListener(new wb(this, 0));
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            e eVar = i0.f12407a;
            usernameEditActivity = this;
            r7.y.q(lifecycleScope, n.f13548a, null, new p(usernameEditActivity, vVar, xVar, cVar, 20), 2);
            bc bcVar = (bc) usernameEditActivity.I.getValue();
            bcVar.getClass();
            r7.y.q(ViewModelKt.getViewModelScope(bcVar), d.f14116a, null, new c5.m(usernameEditActivity, new ArrayList(), bcVar, cVar, 19), 2);
        }
        e1 e1Var7 = usernameEditActivity.H;
        if (e1Var7 != null && (str = e1Var7.f8515d) != null && str.length() != 0) {
            e1 e1Var8 = usernameEditActivity.H;
            e1Var8.getClass();
            String str2 = e1Var8.f8515d;
            str2.getClass();
            o0(str2);
        }
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar2 = i0.f12407a;
        r7.y.q(lifecycleScope2, n.f13548a, null, new kb(this, cVar, i10), 2);
    }
}
