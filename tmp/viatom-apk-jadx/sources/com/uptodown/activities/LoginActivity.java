package com.uptodown.activities;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import b9.h;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.PasswordRecoveryActivity;
import e5.n;
import e5.s;
import h5.e1;
import java.util.regex.Pattern;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.x;
import kotlin.jvm.internal.y;
import l4.b;
import l4.b2;
import l4.e2;
import l4.f2;
import l4.s1;
import l4.v1;
import l4.w1;
import l4.x1;
import r7.i0;
import r7.w;
import s6.m;
import s7.c;
import y5.g;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class LoginActivity extends b2 {
    public static final /* synthetic */ int P = 0;
    public Drawable N;
    public final m L = new m(new g(this, 1));
    public final ViewModelLazy M = new ViewModelLazy(y.a(f2.class), new x1(this, 0), new w1(this), new x1(this, 1));
    public final b O = new b(this, 2);

    @Override // l4.b2
    public final void n0() {
        v0().f7401b.setVisibility(8);
    }

    @Override // l4.b2, l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getOnBackPressedDispatcher().addCallback(this, this.O);
        RelativeLayout relativeLayout = v0().f7400a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        this.N = drawable;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, ContextCompat.getColor(this, R.color.toolbar_icon));
            v0().e.setNavigationIcon(this.N);
            v0().e.setNavigationContentDescription(getString(R.string.back));
        }
        final int i10 = 0;
        v0().e.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.q1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10751b;

            {
                this.f10751b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                int i11 = i10;
                LoginActivity loginActivity = this.f10751b;
                switch (i11) {
                    case 0:
                        int i12 = LoginActivity.P;
                        loginActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i13 = LoginActivity.P;
                        Intent intent = new Intent(loginActivity.getApplicationContext(), (Class<?>) PasswordRecoveryActivity.class);
                        float f = UptodownApp.E;
                        loginActivity.startActivity(intent, k4.c.a(loginActivity));
                        break;
                    case 2:
                        int i14 = LoginActivity.P;
                        LoginActivity loginActivity2 = this.f10751b;
                        loginActivity2.x0();
                        f2 f2VarW0 = loginActivity2.w0();
                        String string = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        f2VarW0.getClass();
                        string.getClass();
                        boolean zMatches = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@“]+(\\.[^<>()\\[\\]\\\\.,;:\\s@“]+)*)|(“.+“))@((\\[\\d{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(string).matches();
                        f2 f2VarW02 = loginActivity2.w0();
                        String string2 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                        String string3 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        String string4 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                        f2VarW02.getClass();
                        string2.getClass();
                        string3.getClass();
                        string4.getClass();
                        if (string2.length() > 0 && string3.length() > 0 && string4.length() > 5 && zMatches && ((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string5 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                            String string6 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                            String string7 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                            f2 f2VarW03 = loginActivity2.w0();
                            f2VarW03.getClass();
                            string5.getClass();
                            string6.getClass();
                            string7.getClass();
                            kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                            kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                            kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                            r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarW03);
                            y7.e eVar = r7.i0.f12407a;
                            r7.y.q(viewModelScope, y7.d.f14116a, null, new e2(f2VarW03, loginActivity2, string5, string7, string6, vVar, xVar, xVar2, (w6.c) null), 2);
                            break;
                        } else if (!((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string8 = loginActivity2.getString(R.string.falta_condiciones_uso);
                            string8.getClass();
                            loginActivity2.C(string8);
                            break;
                        } else if (((EditText) loginActivity2.v0().f7403d.h).length() >= 6) {
                            if (((EditText) loginActivity2.v0().f7403d.h).length() <= 99) {
                                if (!zMatches) {
                                    String string9 = loginActivity2.getString(R.string.error_email_not_valid);
                                    string9.getClass();
                                    loginActivity2.C(string9);
                                    break;
                                } else {
                                    String string10 = loginActivity2.getString(R.string.faltan_datos_registro);
                                    string10.getClass();
                                    loginActivity2.C(string10);
                                    break;
                                }
                            } else {
                                String string11 = loginActivity2.getString(R.string.validation_hundred_chars_max);
                                string11.getClass();
                                loginActivity2.C(string11);
                                break;
                            }
                        } else {
                            String string12 = loginActivity2.getString(R.string.validation_six_chars_min);
                            string12.getClass();
                            loginActivity2.C(string12);
                            break;
                        }
                        break;
                    case 3:
                        loginActivity.O.handleOnBackPressed();
                        break;
                    case 4:
                        int i15 = LoginActivity.P;
                        if (((LinearLayout) loginActivity.v0().f7403d.f7082b).getVisibility() != 0) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            alphaAnimation.setInterpolator(new AccelerateInterpolator());
                            alphaAnimation.setDuration(200L);
                            alphaAnimation.setAnimationListener(new t1(loginActivity, 0));
                            ((LinearLayout) loginActivity.v0().f7402c.f882a).startAnimation(alphaAnimation);
                            break;
                        }
                        break;
                    default:
                        int i16 = LoginActivity.P;
                        loginActivity.y0();
                        break;
                }
            }
        });
        v0().f.setTypeface(o4.b.f11719r);
        ((TextView) v0().f7402c.h).setTypeface(o4.b.f11719r);
        ((TextView) v0().f7402c.e).setTypeface(o4.b.f11720s);
        ((TextView) v0().f7403d.f7084d).setTypeface(o4.b.f11720s);
        v0().f7401b.setOnClickListener(new n(8));
        final int i11 = 4;
        ((TextView) v0().f7402c.h).setOnClickListener(new View.OnClickListener(this) { // from class: l4.q1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10751b;

            {
                this.f10751b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                int i112 = i11;
                LoginActivity loginActivity = this.f10751b;
                switch (i112) {
                    case 0:
                        int i12 = LoginActivity.P;
                        loginActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i13 = LoginActivity.P;
                        Intent intent = new Intent(loginActivity.getApplicationContext(), (Class<?>) PasswordRecoveryActivity.class);
                        float f = UptodownApp.E;
                        loginActivity.startActivity(intent, k4.c.a(loginActivity));
                        break;
                    case 2:
                        int i14 = LoginActivity.P;
                        LoginActivity loginActivity2 = this.f10751b;
                        loginActivity2.x0();
                        f2 f2VarW0 = loginActivity2.w0();
                        String string = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        f2VarW0.getClass();
                        string.getClass();
                        boolean zMatches = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@“]+(\\.[^<>()\\[\\]\\\\.,;:\\s@“]+)*)|(“.+“))@((\\[\\d{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(string).matches();
                        f2 f2VarW02 = loginActivity2.w0();
                        String string2 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                        String string3 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        String string4 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                        f2VarW02.getClass();
                        string2.getClass();
                        string3.getClass();
                        string4.getClass();
                        if (string2.length() > 0 && string3.length() > 0 && string4.length() > 5 && zMatches && ((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string5 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                            String string6 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                            String string7 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                            f2 f2VarW03 = loginActivity2.w0();
                            f2VarW03.getClass();
                            string5.getClass();
                            string6.getClass();
                            string7.getClass();
                            kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                            kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                            kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                            r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarW03);
                            y7.e eVar = r7.i0.f12407a;
                            r7.y.q(viewModelScope, y7.d.f14116a, null, new e2(f2VarW03, loginActivity2, string5, string7, string6, vVar, xVar, xVar2, (w6.c) null), 2);
                            break;
                        } else if (!((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string8 = loginActivity2.getString(R.string.falta_condiciones_uso);
                            string8.getClass();
                            loginActivity2.C(string8);
                            break;
                        } else if (((EditText) loginActivity2.v0().f7403d.h).length() >= 6) {
                            if (((EditText) loginActivity2.v0().f7403d.h).length() <= 99) {
                                if (!zMatches) {
                                    String string9 = loginActivity2.getString(R.string.error_email_not_valid);
                                    string9.getClass();
                                    loginActivity2.C(string9);
                                    break;
                                } else {
                                    String string10 = loginActivity2.getString(R.string.faltan_datos_registro);
                                    string10.getClass();
                                    loginActivity2.C(string10);
                                    break;
                                }
                            } else {
                                String string11 = loginActivity2.getString(R.string.validation_hundred_chars_max);
                                string11.getClass();
                                loginActivity2.C(string11);
                                break;
                            }
                        } else {
                            String string12 = loginActivity2.getString(R.string.validation_six_chars_min);
                            string12.getClass();
                            loginActivity2.C(string12);
                            break;
                        }
                        break;
                    case 3:
                        loginActivity.O.handleOnBackPressed();
                        break;
                    case 4:
                        int i15 = LoginActivity.P;
                        if (((LinearLayout) loginActivity.v0().f7403d.f7082b).getVisibility() != 0) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            alphaAnimation.setInterpolator(new AccelerateInterpolator());
                            alphaAnimation.setDuration(200L);
                            alphaAnimation.setAnimationListener(new t1(loginActivity, 0));
                            ((LinearLayout) loginActivity.v0().f7402c.f882a).startAnimation(alphaAnimation);
                            break;
                        }
                        break;
                    default:
                        int i16 = LoginActivity.P;
                        loginActivity.y0();
                        break;
                }
            }
        });
        ((TextView) v0().f7402c.f).setTypeface(o4.b.f11719r);
        final int i12 = 5;
        ((TextView) v0().f7402c.f).setOnClickListener(new View.OnClickListener(this) { // from class: l4.q1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10751b;

            {
                this.f10751b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                int i112 = i12;
                LoginActivity loginActivity = this.f10751b;
                switch (i112) {
                    case 0:
                        int i122 = LoginActivity.P;
                        loginActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i13 = LoginActivity.P;
                        Intent intent = new Intent(loginActivity.getApplicationContext(), (Class<?>) PasswordRecoveryActivity.class);
                        float f = UptodownApp.E;
                        loginActivity.startActivity(intent, k4.c.a(loginActivity));
                        break;
                    case 2:
                        int i14 = LoginActivity.P;
                        LoginActivity loginActivity2 = this.f10751b;
                        loginActivity2.x0();
                        f2 f2VarW0 = loginActivity2.w0();
                        String string = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        f2VarW0.getClass();
                        string.getClass();
                        boolean zMatches = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@“]+(\\.[^<>()\\[\\]\\\\.,;:\\s@“]+)*)|(“.+“))@((\\[\\d{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(string).matches();
                        f2 f2VarW02 = loginActivity2.w0();
                        String string2 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                        String string3 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        String string4 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                        f2VarW02.getClass();
                        string2.getClass();
                        string3.getClass();
                        string4.getClass();
                        if (string2.length() > 0 && string3.length() > 0 && string4.length() > 5 && zMatches && ((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string5 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                            String string6 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                            String string7 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                            f2 f2VarW03 = loginActivity2.w0();
                            f2VarW03.getClass();
                            string5.getClass();
                            string6.getClass();
                            string7.getClass();
                            kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                            kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                            kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                            r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarW03);
                            y7.e eVar = r7.i0.f12407a;
                            r7.y.q(viewModelScope, y7.d.f14116a, null, new e2(f2VarW03, loginActivity2, string5, string7, string6, vVar, xVar, xVar2, (w6.c) null), 2);
                            break;
                        } else if (!((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string8 = loginActivity2.getString(R.string.falta_condiciones_uso);
                            string8.getClass();
                            loginActivity2.C(string8);
                            break;
                        } else if (((EditText) loginActivity2.v0().f7403d.h).length() >= 6) {
                            if (((EditText) loginActivity2.v0().f7403d.h).length() <= 99) {
                                if (!zMatches) {
                                    String string9 = loginActivity2.getString(R.string.error_email_not_valid);
                                    string9.getClass();
                                    loginActivity2.C(string9);
                                    break;
                                } else {
                                    String string10 = loginActivity2.getString(R.string.faltan_datos_registro);
                                    string10.getClass();
                                    loginActivity2.C(string10);
                                    break;
                                }
                            } else {
                                String string11 = loginActivity2.getString(R.string.validation_hundred_chars_max);
                                string11.getClass();
                                loginActivity2.C(string11);
                                break;
                            }
                        } else {
                            String string12 = loginActivity2.getString(R.string.validation_six_chars_min);
                            string12.getClass();
                            loginActivity2.C(string12);
                            break;
                        }
                        break;
                    case 3:
                        loginActivity.O.handleOnBackPressed();
                        break;
                    case 4:
                        int i15 = LoginActivity.P;
                        if (((LinearLayout) loginActivity.v0().f7403d.f7082b).getVisibility() != 0) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            alphaAnimation.setInterpolator(new AccelerateInterpolator());
                            alphaAnimation.setDuration(200L);
                            alphaAnimation.setAnimationListener(new t1(loginActivity, 0));
                            ((LinearLayout) loginActivity.v0().f7402c.f882a).startAnimation(alphaAnimation);
                            break;
                        }
                        break;
                    default:
                        int i16 = LoginActivity.P;
                        loginActivity.y0();
                        break;
                }
            }
        });
        ((EditText) v0().f7402c.f884c).setTypeface(o4.b.f11720s);
        final int i13 = 3;
        ((EditText) v0().f7402c.f884c).setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: l4.r1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10783b;

            {
                this.f10783b = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z9) {
                int i14 = i13;
                LoginActivity loginActivity = this.f10783b;
                switch (i14) {
                    case 0:
                        int i15 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint(loginActivity.getString(R.string.hint_nombre_usuario_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint("");
                            break;
                        }
                    case 1:
                        int i16 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.g).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.g).setHint("");
                            break;
                        }
                    case 2:
                        int i17 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.h).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.h).setHint("");
                            break;
                        }
                    case 3:
                        int i18 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint("");
                            break;
                        }
                    default:
                        int i19 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint("");
                            break;
                        }
                }
            }
        });
        ((EditText) v0().f7402c.f883b).setTypeface(o4.b.f11720s);
        ((EditText) v0().f7402c.f883b).setImeOptions(6);
        ((EditText) v0().f7402c.f883b).setOnEditorActionListener(new s1(this, i10));
        ((EditText) v0().f7402c.f883b).setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: l4.r1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10783b;

            {
                this.f10783b = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z9) {
                int i14 = i11;
                LoginActivity loginActivity = this.f10783b;
                switch (i14) {
                    case 0:
                        int i15 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint(loginActivity.getString(R.string.hint_nombre_usuario_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint("");
                            break;
                        }
                    case 1:
                        int i16 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.g).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.g).setHint("");
                            break;
                        }
                    case 2:
                        int i17 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.h).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.h).setHint("");
                            break;
                        }
                    case 3:
                        int i18 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint("");
                            break;
                        }
                    default:
                        int i19 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint("");
                            break;
                        }
                }
            }
        });
        Drawable[] compoundDrawables = ((EditText) v0().f7402c.f883b).getCompoundDrawables();
        compoundDrawables.getClass();
        Drawable drawable2 = compoundDrawables[0];
        if (drawable2 != null) {
            drawable2.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        }
        TextView textView = (TextView) findViewById(R.id.tv_pass_forget_login);
        final int i14 = 1;
        if (textView != null) {
            textView.setTypeface(o4.b.f11719r);
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: l4.q1

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ LoginActivity f10751b;

                {
                    this.f10751b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    int i112 = i14;
                    LoginActivity loginActivity = this.f10751b;
                    switch (i112) {
                        case 0:
                            int i122 = LoginActivity.P;
                            loginActivity.getOnBackPressedDispatcher().onBackPressed();
                            break;
                        case 1:
                            int i132 = LoginActivity.P;
                            Intent intent = new Intent(loginActivity.getApplicationContext(), (Class<?>) PasswordRecoveryActivity.class);
                            float f = UptodownApp.E;
                            loginActivity.startActivity(intent, k4.c.a(loginActivity));
                            break;
                        case 2:
                            int i142 = LoginActivity.P;
                            LoginActivity loginActivity2 = this.f10751b;
                            loginActivity2.x0();
                            f2 f2VarW0 = loginActivity2.w0();
                            String string = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                            f2VarW0.getClass();
                            string.getClass();
                            boolean zMatches = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@“]+(\\.[^<>()\\[\\]\\\\.,;:\\s@“]+)*)|(“.+“))@((\\[\\d{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(string).matches();
                            f2 f2VarW02 = loginActivity2.w0();
                            String string2 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                            String string3 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                            String string4 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                            f2VarW02.getClass();
                            string2.getClass();
                            string3.getClass();
                            string4.getClass();
                            if (string2.length() > 0 && string3.length() > 0 && string4.length() > 5 && zMatches && ((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                                String string5 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                                String string6 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                                String string7 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                                f2 f2VarW03 = loginActivity2.w0();
                                f2VarW03.getClass();
                                string5.getClass();
                                string6.getClass();
                                string7.getClass();
                                kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                                kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                                kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                                r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarW03);
                                y7.e eVar = r7.i0.f12407a;
                                r7.y.q(viewModelScope, y7.d.f14116a, null, new e2(f2VarW03, loginActivity2, string5, string7, string6, vVar, xVar, xVar2, (w6.c) null), 2);
                                break;
                            } else if (!((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                                String string8 = loginActivity2.getString(R.string.falta_condiciones_uso);
                                string8.getClass();
                                loginActivity2.C(string8);
                                break;
                            } else if (((EditText) loginActivity2.v0().f7403d.h).length() >= 6) {
                                if (((EditText) loginActivity2.v0().f7403d.h).length() <= 99) {
                                    if (!zMatches) {
                                        String string9 = loginActivity2.getString(R.string.error_email_not_valid);
                                        string9.getClass();
                                        loginActivity2.C(string9);
                                        break;
                                    } else {
                                        String string10 = loginActivity2.getString(R.string.faltan_datos_registro);
                                        string10.getClass();
                                        loginActivity2.C(string10);
                                        break;
                                    }
                                } else {
                                    String string11 = loginActivity2.getString(R.string.validation_hundred_chars_max);
                                    string11.getClass();
                                    loginActivity2.C(string11);
                                    break;
                                }
                            } else {
                                String string12 = loginActivity2.getString(R.string.validation_six_chars_min);
                                string12.getClass();
                                loginActivity2.C(string12);
                                break;
                            }
                            break;
                        case 3:
                            loginActivity.O.handleOnBackPressed();
                            break;
                        case 4:
                            int i15 = LoginActivity.P;
                            if (((LinearLayout) loginActivity.v0().f7403d.f7082b).getVisibility() != 0) {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                                alphaAnimation.setInterpolator(new AccelerateInterpolator());
                                alphaAnimation.setDuration(200L);
                                alphaAnimation.setAnimationListener(new t1(loginActivity, 0));
                                ((LinearLayout) loginActivity.v0().f7402c.f882a).startAnimation(alphaAnimation);
                                break;
                            }
                            break;
                        default:
                            int i16 = LoginActivity.P;
                            loginActivity.y0();
                            break;
                    }
                }
            });
        }
        ((TextView) v0().f7403d.f7087k).setTypeface(o4.b.f11719r);
        final int i15 = 2;
        ((TextView) v0().f7403d.f7087k).setOnClickListener(new View.OnClickListener(this) { // from class: l4.q1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10751b;

            {
                this.f10751b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                int i112 = i15;
                LoginActivity loginActivity = this.f10751b;
                switch (i112) {
                    case 0:
                        int i122 = LoginActivity.P;
                        loginActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i132 = LoginActivity.P;
                        Intent intent = new Intent(loginActivity.getApplicationContext(), (Class<?>) PasswordRecoveryActivity.class);
                        float f = UptodownApp.E;
                        loginActivity.startActivity(intent, k4.c.a(loginActivity));
                        break;
                    case 2:
                        int i142 = LoginActivity.P;
                        LoginActivity loginActivity2 = this.f10751b;
                        loginActivity2.x0();
                        f2 f2VarW0 = loginActivity2.w0();
                        String string = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        f2VarW0.getClass();
                        string.getClass();
                        boolean zMatches = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@“]+(\\.[^<>()\\[\\]\\\\.,;:\\s@“]+)*)|(“.+“))@((\\[\\d{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(string).matches();
                        f2 f2VarW02 = loginActivity2.w0();
                        String string2 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                        String string3 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        String string4 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                        f2VarW02.getClass();
                        string2.getClass();
                        string3.getClass();
                        string4.getClass();
                        if (string2.length() > 0 && string3.length() > 0 && string4.length() > 5 && zMatches && ((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string5 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                            String string6 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                            String string7 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                            f2 f2VarW03 = loginActivity2.w0();
                            f2VarW03.getClass();
                            string5.getClass();
                            string6.getClass();
                            string7.getClass();
                            kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                            kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                            kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                            r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarW03);
                            y7.e eVar = r7.i0.f12407a;
                            r7.y.q(viewModelScope, y7.d.f14116a, null, new e2(f2VarW03, loginActivity2, string5, string7, string6, vVar, xVar, xVar2, (w6.c) null), 2);
                            break;
                        } else if (!((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string8 = loginActivity2.getString(R.string.falta_condiciones_uso);
                            string8.getClass();
                            loginActivity2.C(string8);
                            break;
                        } else if (((EditText) loginActivity2.v0().f7403d.h).length() >= 6) {
                            if (((EditText) loginActivity2.v0().f7403d.h).length() <= 99) {
                                if (!zMatches) {
                                    String string9 = loginActivity2.getString(R.string.error_email_not_valid);
                                    string9.getClass();
                                    loginActivity2.C(string9);
                                    break;
                                } else {
                                    String string10 = loginActivity2.getString(R.string.faltan_datos_registro);
                                    string10.getClass();
                                    loginActivity2.C(string10);
                                    break;
                                }
                            } else {
                                String string11 = loginActivity2.getString(R.string.validation_hundred_chars_max);
                                string11.getClass();
                                loginActivity2.C(string11);
                                break;
                            }
                        } else {
                            String string12 = loginActivity2.getString(R.string.validation_six_chars_min);
                            string12.getClass();
                            loginActivity2.C(string12);
                            break;
                        }
                        break;
                    case 3:
                        loginActivity.O.handleOnBackPressed();
                        break;
                    case 4:
                        int i152 = LoginActivity.P;
                        if (((LinearLayout) loginActivity.v0().f7403d.f7082b).getVisibility() != 0) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            alphaAnimation.setInterpolator(new AccelerateInterpolator());
                            alphaAnimation.setDuration(200L);
                            alphaAnimation.setAnimationListener(new t1(loginActivity, 0));
                            ((LinearLayout) loginActivity.v0().f7402c.f882a).startAnimation(alphaAnimation);
                            break;
                        }
                        break;
                    default:
                        int i16 = LoginActivity.P;
                        loginActivity.y0();
                        break;
                }
            }
        });
        ((EditText) v0().f7403d.f7085i).setTypeface(o4.b.f11720s);
        ((EditText) v0().f7403d.f7085i).setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: l4.r1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10783b;

            {
                this.f10783b = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z9) {
                int i142 = i10;
                LoginActivity loginActivity = this.f10783b;
                switch (i142) {
                    case 0:
                        int i152 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint(loginActivity.getString(R.string.hint_nombre_usuario_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint("");
                            break;
                        }
                    case 1:
                        int i16 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.g).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.g).setHint("");
                            break;
                        }
                    case 2:
                        int i17 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.h).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.h).setHint("");
                            break;
                        }
                    case 3:
                        int i18 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint("");
                            break;
                        }
                    default:
                        int i19 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint("");
                            break;
                        }
                }
            }
        });
        ((TextView) v0().f7403d.f7083c).setTypeface(o4.b.f11719r);
        ((TextView) v0().f7403d.f7083c).setOnClickListener(new View.OnClickListener(this) { // from class: l4.q1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10751b;

            {
                this.f10751b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                int i112 = i13;
                LoginActivity loginActivity = this.f10751b;
                switch (i112) {
                    case 0:
                        int i122 = LoginActivity.P;
                        loginActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i132 = LoginActivity.P;
                        Intent intent = new Intent(loginActivity.getApplicationContext(), (Class<?>) PasswordRecoveryActivity.class);
                        float f = UptodownApp.E;
                        loginActivity.startActivity(intent, k4.c.a(loginActivity));
                        break;
                    case 2:
                        int i142 = LoginActivity.P;
                        LoginActivity loginActivity2 = this.f10751b;
                        loginActivity2.x0();
                        f2 f2VarW0 = loginActivity2.w0();
                        String string = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        f2VarW0.getClass();
                        string.getClass();
                        boolean zMatches = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@“]+(\\.[^<>()\\[\\]\\\\.,;:\\s@“]+)*)|(“.+“))@((\\[\\d{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(string).matches();
                        f2 f2VarW02 = loginActivity2.w0();
                        String string2 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                        String string3 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                        String string4 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                        f2VarW02.getClass();
                        string2.getClass();
                        string3.getClass();
                        string4.getClass();
                        if (string2.length() > 0 && string3.length() > 0 && string4.length() > 5 && zMatches && ((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string5 = ((EditText) loginActivity2.v0().f7403d.f7085i).getText().toString();
                            String string6 = ((EditText) loginActivity2.v0().f7403d.g).getText().toString();
                            String string7 = ((EditText) loginActivity2.v0().f7403d.h).getText().toString();
                            f2 f2VarW03 = loginActivity2.w0();
                            f2VarW03.getClass();
                            string5.getClass();
                            string6.getClass();
                            string7.getClass();
                            kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                            kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                            kotlin.jvm.internal.x xVar2 = new kotlin.jvm.internal.x();
                            r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarW03);
                            y7.e eVar = r7.i0.f12407a;
                            r7.y.q(viewModelScope, y7.d.f14116a, null, new e2(f2VarW03, loginActivity2, string5, string7, string6, vVar, xVar, xVar2, (w6.c) null), 2);
                            break;
                        } else if (!((CheckBox) loginActivity2.v0().f7403d.f).isChecked()) {
                            String string8 = loginActivity2.getString(R.string.falta_condiciones_uso);
                            string8.getClass();
                            loginActivity2.C(string8);
                            break;
                        } else if (((EditText) loginActivity2.v0().f7403d.h).length() >= 6) {
                            if (((EditText) loginActivity2.v0().f7403d.h).length() <= 99) {
                                if (!zMatches) {
                                    String string9 = loginActivity2.getString(R.string.error_email_not_valid);
                                    string9.getClass();
                                    loginActivity2.C(string9);
                                    break;
                                } else {
                                    String string10 = loginActivity2.getString(R.string.faltan_datos_registro);
                                    string10.getClass();
                                    loginActivity2.C(string10);
                                    break;
                                }
                            } else {
                                String string11 = loginActivity2.getString(R.string.validation_hundred_chars_max);
                                string11.getClass();
                                loginActivity2.C(string11);
                                break;
                            }
                        } else {
                            String string12 = loginActivity2.getString(R.string.validation_six_chars_min);
                            string12.getClass();
                            loginActivity2.C(string12);
                            break;
                        }
                        break;
                    case 3:
                        loginActivity.O.handleOnBackPressed();
                        break;
                    case 4:
                        int i152 = LoginActivity.P;
                        if (((LinearLayout) loginActivity.v0().f7403d.f7082b).getVisibility() != 0) {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            alphaAnimation.setInterpolator(new AccelerateInterpolator());
                            alphaAnimation.setDuration(200L);
                            alphaAnimation.setAnimationListener(new t1(loginActivity, 0));
                            ((LinearLayout) loginActivity.v0().f7402c.f882a).startAnimation(alphaAnimation);
                            break;
                        }
                        break;
                    default:
                        int i16 = LoginActivity.P;
                        loginActivity.y0();
                        break;
                }
            }
        });
        ((EditText) v0().f7403d.g).setTypeface(o4.b.f11720s);
        ((EditText) v0().f7403d.g).setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: l4.r1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10783b;

            {
                this.f10783b = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z9) {
                int i142 = i14;
                LoginActivity loginActivity = this.f10783b;
                switch (i142) {
                    case 0:
                        int i152 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint(loginActivity.getString(R.string.hint_nombre_usuario_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint("");
                            break;
                        }
                    case 1:
                        int i16 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.g).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.g).setHint("");
                            break;
                        }
                    case 2:
                        int i17 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.h).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.h).setHint("");
                            break;
                        }
                    case 3:
                        int i18 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint("");
                            break;
                        }
                    default:
                        int i19 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint("");
                            break;
                        }
                }
            }
        });
        ((EditText) v0().f7403d.h).setTypeface(o4.b.f11720s);
        ((EditText) v0().f7403d.h).setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: l4.r1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LoginActivity f10783b;

            {
                this.f10783b = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z9) {
                int i142 = i15;
                LoginActivity loginActivity = this.f10783b;
                switch (i142) {
                    case 0:
                        int i152 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint(loginActivity.getString(R.string.hint_nombre_usuario_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.f7085i).setHint("");
                            break;
                        }
                    case 1:
                        int i16 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.g).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.g).setHint("");
                            break;
                        }
                    case 2:
                        int i17 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7403d.h).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7403d.h).setHint("");
                            break;
                        }
                    case 3:
                        int i18 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint(loginActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f884c).setHint("");
                            break;
                        }
                    default:
                        int i19 = LoginActivity.P;
                        if (!z9) {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint(loginActivity.getString(R.string.hint_pass_login_registro));
                            break;
                        } else {
                            ((EditText) loginActivity.v0().f7402c.f883b).setHint("");
                            break;
                        }
                }
            }
        });
        Drawable[] compoundDrawables2 = ((EditText) v0().f7403d.h).getCompoundDrawables();
        compoundDrawables2.getClass();
        Drawable drawable3 = compoundDrawables2[0];
        if (drawable3 != null) {
            drawable3.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        }
        ((CheckBox) v0().f7403d.f).setTypeface(o4.b.f11720s);
        ((CheckBox) v0().f7403d.f).setMovementMethod(LinkMovementMethod.getInstance());
        d5.y yVarV0 = v0();
        yVarV0.getClass();
        h hVar = yVarV0.f7402c;
        ((TextView) hVar.g).setTypeface(o4.b.f11719r);
        int i16 = 11;
        ((RelativeLayout) hVar.f885d).setOnClickListener(new s(this, i16));
        d5.h hVar2 = yVarV0.f7403d;
        ((TextView) hVar2.e).setTypeface(o4.b.f11719r);
        ((RelativeLayout) hVar2.f7086j).setOnClickListener(new s(this, i16));
        ((TextView) findViewById(R.id.tv_title_download_benefit)).setTypeface(o4.b.f11719r);
        ((TextView) findViewById(R.id.tv_desc_download_benefit)).setTypeface(o4.b.f11720s);
        ((TextView) findViewById(R.id.tv_title_discover_benefit)).setTypeface(o4.b.f11719r);
        ((TextView) findViewById(R.id.tv_desc_discover_benefit)).setTypeface(o4.b.f11720s);
        ((TextView) findViewById(R.id.tv_title_share_benefit)).setTypeface(o4.b.f11719r);
        ((TextView) findViewById(R.id.tv_desc_share_benefit)).setTypeface(o4.b.f11720s);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        c cVar = w7.n.f13548a;
        w6.c cVar2 = null;
        r7.y.q(lifecycleScope, cVar, null, new v1(this, cVar2, i10), 2);
        r7.y.q(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new v1(this, cVar2, i14), 2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        Drawable drawable = this.N;
        if (drawable != null) {
            drawable.getClass();
            DrawableCompat.setTintList(drawable, null);
        }
        getWindow().getDecorView().setSystemUiVisibility(0);
        super.onDestroy();
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        SharedPreferences sharedPreferences;
        super.onResume();
        x0();
        SharedPreferences sharedPreferences2 = getSharedPreferences("SharedPreferencesUser", 0);
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
        if ((string == null && sharedPreferences2.getString("is_turbo", null) == null) ? false : true) {
            finish();
        }
    }

    @Override // l4.b2
    public final void r0(e1 e1Var) {
        String str;
        if (e1Var != null) {
            e1Var.e(this);
        }
        if (e1Var != null) {
            try {
                str = e1Var.f8515d;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            e1Var.getClass();
            String str2 = e1Var.f8515d;
            str2.getClass();
            AccountManager.get(getBaseContext()).addAccountExplicitly(new Account(str2, getString(R.string.account)), null, null);
        }
    }

    @Override // l4.b2
    public final void s0(e1 e1Var, String str) {
        n0();
        ((EditText) v0().f7403d.f7085i).setText(e1Var != null ? e1Var.f8515d : null);
        ((EditText) v0().f7403d.g).setText(e1Var != null ? e1Var.f8513b : null);
        ((EditText) v0().f7403d.g).setEnabled(false);
        if (str != null) {
            C(str);
        }
    }

    @Override // l4.b2
    public final void t0() {
        v0().f7401b.setVisibility(0);
    }

    @Override // l4.b2
    public final void u0() {
        String string = getString(R.string.login_successful);
        string.getClass();
        C(string);
    }

    public final d5.y v0() {
        return (d5.y) this.L.getValue();
    }

    public final f2 w0() {
        return (f2) this.M.getValue();
    }

    public final void x0() {
        Object systemService = getSystemService("input_method");
        systemService.getClass();
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        inputMethodManager.hideSoftInputFromWindow(((EditText) v0().f7403d.g).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(((EditText) v0().f7403d.f7085i).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(((EditText) v0().f7403d.h).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(((EditText) v0().f7402c.f884c).getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(((EditText) v0().f7402c.f883b).getWindowToken(), 0);
    }

    public final void y0() {
        x0();
        f2 f2VarW0 = w0();
        String string = ((EditText) v0().f7402c.f884c).getText().toString();
        String string2 = ((EditText) v0().f7402c.f883b).getText().toString();
        f2VarW0.getClass();
        string.getClass();
        string2.getClass();
        if (string.length() <= 0 || string2.length() <= 0) {
            String string3 = getString(R.string.faltan_datos_login);
            string3.getClass();
            C(string3);
            return;
        }
        String string4 = ((EditText) v0().f7402c.f884c).getText().toString();
        String string5 = ((EditText) v0().f7402c.f883b).getText().toString();
        f2 f2VarW02 = w0();
        f2VarW02.getClass();
        string4.getClass();
        string5.getClass();
        v vVar = new v();
        vVar.f10136a = -2;
        x xVar = new x();
        x xVar2 = new x();
        x xVar3 = new x();
        w viewModelScope = ViewModelKt.getViewModelScope(f2VarW02);
        e eVar = i0.f12407a;
        r7.y.q(viewModelScope, d.f14116a, null, new e2(f2VarW02, this, string4, string5, xVar3, vVar, xVar, xVar2, (w6.c) null), 2);
    }
}
