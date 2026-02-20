package com.uptodown.activities;

import a6.c;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.uptodown.R;
import com.uptodown.activities.PasswordEditActivity;
import d5.h0;
import kotlin.jvm.internal.y;
import l4.t5;
import l4.v5;
import l4.w;
import l4.w5;
import l4.x2;
import l4.z5;
import o4.b;
import r7.i0;
import s6.m;
import w7.n;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PasswordEditActivity extends w {
    public static final /* synthetic */ int J = 0;
    public final ViewModelLazy H = new ViewModelLazy(y.a(z5.class), new w5(this, 0), new v5(this), new w5(this, 1));
    public final m I = new m(new x2(this, 6));

    public static final void n0(PasswordEditActivity passwordEditActivity, String str) {
        if (str.length() <= 0 || str.length() < 6) {
            passwordEditActivity.o0().f7093j.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            passwordEditActivity.o0().f7093j.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() <= 0 || str.length() > 99) {
            passwordEditActivity.o0().f7092i.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            passwordEditActivity.o0().f7092i.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.equals(passwordEditActivity.o0().f7089b.getText().toString())) {
            passwordEditActivity.o0().h.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, R.drawable.vector_checked), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            passwordEditActivity.o0().h.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, R.drawable.vector_unchecked), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public final h0 o0() {
        return (h0) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = o0().f7088a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        RelativeLayout relativeLayout2 = o0().f7088a;
        relativeLayout2.getClass();
        setContentView(relativeLayout2);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        final int i10 = 0;
        if (drawable != null) {
            o0().g.setNavigationIcon(drawable);
            o0().g.setNavigationContentDescription(getString(R.string.back));
            o0().g.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.s5

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ PasswordEditActivity f10817b;

                {
                    this.f10817b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i11 = i10;
                    PasswordEditActivity passwordEditActivity = this.f10817b;
                    switch (i11) {
                        case 0:
                            int i12 = PasswordEditActivity.J;
                            passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
                            break;
                        case 1:
                            int i13 = PasswordEditActivity.J;
                            passwordEditActivity.p0(passwordEditActivity.o0().f7090c, passwordEditActivity.o0().e);
                            break;
                        case 2:
                            int i14 = PasswordEditActivity.J;
                            passwordEditActivity.p0(passwordEditActivity.o0().f7089b, passwordEditActivity.o0().f7091d);
                            break;
                        default:
                            int i15 = PasswordEditActivity.J;
                            Activity activity = o4.b.g;
                            PasswordEditActivity passwordEditActivity2 = this.f10817b;
                            r0.f.q(passwordEditActivity2, passwordEditActivity2.o0().f7090c);
                            if (passwordEditActivity2.o0().f7090c.getText().toString().length() != 0 && passwordEditActivity2.o0().f7089b.getText().toString().length() != 0) {
                                if (passwordEditActivity2.o0().f7090c.getText().toString().length() >= 6) {
                                    if (passwordEditActivity2.o0().f7090c.getText().toString().length() <= 99) {
                                        if (!kotlin.jvm.internal.l.a(passwordEditActivity2.o0().f7090c.getText().toString(), passwordEditActivity2.o0().f7089b.getText().toString())) {
                                            String string = passwordEditActivity2.getString(R.string.password_edit_not_match);
                                            string.getClass();
                                            passwordEditActivity2.C(string);
                                            break;
                                        } else {
                                            z5 z5Var = (z5) passwordEditActivity2.H.getValue();
                                            String string2 = passwordEditActivity2.o0().f7090c.getText().toString();
                                            String string3 = passwordEditActivity2.o0().f7089b.getText().toString();
                                            z5Var.getClass();
                                            string2.getClass();
                                            string3.getClass();
                                            kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                                            kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                                            r7.w viewModelScope = ViewModelKt.getViewModelScope(z5Var);
                                            y7.e eVar = r7.i0.f12407a;
                                            r7.y.q(viewModelScope, y7.d.f14116a, null, new y5(z5Var, passwordEditActivity2, string2, string3, xVar, vVar, null), 2);
                                            break;
                                        }
                                    } else {
                                        String string4 = passwordEditActivity2.getString(R.string.validation_hundred_chars_max);
                                        string4.getClass();
                                        passwordEditActivity2.C(string4);
                                        break;
                                    }
                                } else {
                                    String string5 = passwordEditActivity2.getString(R.string.validation_six_chars_min);
                                    string5.getClass();
                                    passwordEditActivity2.C(string5);
                                    break;
                                }
                            } else {
                                String string6 = passwordEditActivity2.getString(R.string.error_email_vacio_recuperar_pass);
                                string6.getClass();
                                passwordEditActivity2.C(string6);
                                break;
                            }
                            break;
                    }
                }
            });
        }
        o0().f7095l.setTypeface(b.f11719r);
        o0().f7090c.setTypeface(b.f11720s);
        o0().f7089b.setTypeface(b.f11720s);
        o0().f7094k.setTypeface(b.f11719r);
        o0().f7093j.setTypeface(b.f11720s);
        o0().f7092i.setTypeface(b.f11720s);
        o0().h.setTypeface(b.f11720s);
        final int i11 = 1;
        o0().e.setOnClickListener(new View.OnClickListener(this) { // from class: l4.s5

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PasswordEditActivity f10817b;

            {
                this.f10817b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                PasswordEditActivity passwordEditActivity = this.f10817b;
                switch (i112) {
                    case 0:
                        int i12 = PasswordEditActivity.J;
                        passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i13 = PasswordEditActivity.J;
                        passwordEditActivity.p0(passwordEditActivity.o0().f7090c, passwordEditActivity.o0().e);
                        break;
                    case 2:
                        int i14 = PasswordEditActivity.J;
                        passwordEditActivity.p0(passwordEditActivity.o0().f7089b, passwordEditActivity.o0().f7091d);
                        break;
                    default:
                        int i15 = PasswordEditActivity.J;
                        Activity activity = o4.b.g;
                        PasswordEditActivity passwordEditActivity2 = this.f10817b;
                        r0.f.q(passwordEditActivity2, passwordEditActivity2.o0().f7090c);
                        if (passwordEditActivity2.o0().f7090c.getText().toString().length() != 0 && passwordEditActivity2.o0().f7089b.getText().toString().length() != 0) {
                            if (passwordEditActivity2.o0().f7090c.getText().toString().length() >= 6) {
                                if (passwordEditActivity2.o0().f7090c.getText().toString().length() <= 99) {
                                    if (!kotlin.jvm.internal.l.a(passwordEditActivity2.o0().f7090c.getText().toString(), passwordEditActivity2.o0().f7089b.getText().toString())) {
                                        String string = passwordEditActivity2.getString(R.string.password_edit_not_match);
                                        string.getClass();
                                        passwordEditActivity2.C(string);
                                        break;
                                    } else {
                                        z5 z5Var = (z5) passwordEditActivity2.H.getValue();
                                        String string2 = passwordEditActivity2.o0().f7090c.getText().toString();
                                        String string3 = passwordEditActivity2.o0().f7089b.getText().toString();
                                        z5Var.getClass();
                                        string2.getClass();
                                        string3.getClass();
                                        kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                                        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                                        r7.w viewModelScope = ViewModelKt.getViewModelScope(z5Var);
                                        y7.e eVar = r7.i0.f12407a;
                                        r7.y.q(viewModelScope, y7.d.f14116a, null, new y5(z5Var, passwordEditActivity2, string2, string3, xVar, vVar, null), 2);
                                        break;
                                    }
                                } else {
                                    String string4 = passwordEditActivity2.getString(R.string.validation_hundred_chars_max);
                                    string4.getClass();
                                    passwordEditActivity2.C(string4);
                                    break;
                                }
                            } else {
                                String string5 = passwordEditActivity2.getString(R.string.validation_six_chars_min);
                                string5.getClass();
                                passwordEditActivity2.C(string5);
                                break;
                            }
                        } else {
                            String string6 = passwordEditActivity2.getString(R.string.error_email_vacio_recuperar_pass);
                            string6.getClass();
                            passwordEditActivity2.C(string6);
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 2;
        o0().f7091d.setOnClickListener(new View.OnClickListener(this) { // from class: l4.s5

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PasswordEditActivity f10817b;

            {
                this.f10817b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                PasswordEditActivity passwordEditActivity = this.f10817b;
                switch (i112) {
                    case 0:
                        int i122 = PasswordEditActivity.J;
                        passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i13 = PasswordEditActivity.J;
                        passwordEditActivity.p0(passwordEditActivity.o0().f7090c, passwordEditActivity.o0().e);
                        break;
                    case 2:
                        int i14 = PasswordEditActivity.J;
                        passwordEditActivity.p0(passwordEditActivity.o0().f7089b, passwordEditActivity.o0().f7091d);
                        break;
                    default:
                        int i15 = PasswordEditActivity.J;
                        Activity activity = o4.b.g;
                        PasswordEditActivity passwordEditActivity2 = this.f10817b;
                        r0.f.q(passwordEditActivity2, passwordEditActivity2.o0().f7090c);
                        if (passwordEditActivity2.o0().f7090c.getText().toString().length() != 0 && passwordEditActivity2.o0().f7089b.getText().toString().length() != 0) {
                            if (passwordEditActivity2.o0().f7090c.getText().toString().length() >= 6) {
                                if (passwordEditActivity2.o0().f7090c.getText().toString().length() <= 99) {
                                    if (!kotlin.jvm.internal.l.a(passwordEditActivity2.o0().f7090c.getText().toString(), passwordEditActivity2.o0().f7089b.getText().toString())) {
                                        String string = passwordEditActivity2.getString(R.string.password_edit_not_match);
                                        string.getClass();
                                        passwordEditActivity2.C(string);
                                        break;
                                    } else {
                                        z5 z5Var = (z5) passwordEditActivity2.H.getValue();
                                        String string2 = passwordEditActivity2.o0().f7090c.getText().toString();
                                        String string3 = passwordEditActivity2.o0().f7089b.getText().toString();
                                        z5Var.getClass();
                                        string2.getClass();
                                        string3.getClass();
                                        kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                                        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                                        r7.w viewModelScope = ViewModelKt.getViewModelScope(z5Var);
                                        y7.e eVar = r7.i0.f12407a;
                                        r7.y.q(viewModelScope, y7.d.f14116a, null, new y5(z5Var, passwordEditActivity2, string2, string3, xVar, vVar, null), 2);
                                        break;
                                    }
                                } else {
                                    String string4 = passwordEditActivity2.getString(R.string.validation_hundred_chars_max);
                                    string4.getClass();
                                    passwordEditActivity2.C(string4);
                                    break;
                                }
                            } else {
                                String string5 = passwordEditActivity2.getString(R.string.validation_six_chars_min);
                                string5.getClass();
                                passwordEditActivity2.C(string5);
                                break;
                            }
                        } else {
                            String string6 = passwordEditActivity2.getString(R.string.error_email_vacio_recuperar_pass);
                            string6.getClass();
                            passwordEditActivity2.C(string6);
                            break;
                        }
                        break;
                }
            }
        });
        o0().f7090c.addTextChangedListener(new t5(this, i10));
        o0().f7089b.addTextChangedListener(new t5(this, i11));
        final int i13 = 3;
        o0().f7094k.setOnClickListener(new View.OnClickListener(this) { // from class: l4.s5

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PasswordEditActivity f10817b;

            {
                this.f10817b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i13;
                PasswordEditActivity passwordEditActivity = this.f10817b;
                switch (i112) {
                    case 0:
                        int i122 = PasswordEditActivity.J;
                        passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i132 = PasswordEditActivity.J;
                        passwordEditActivity.p0(passwordEditActivity.o0().f7090c, passwordEditActivity.o0().e);
                        break;
                    case 2:
                        int i14 = PasswordEditActivity.J;
                        passwordEditActivity.p0(passwordEditActivity.o0().f7089b, passwordEditActivity.o0().f7091d);
                        break;
                    default:
                        int i15 = PasswordEditActivity.J;
                        Activity activity = o4.b.g;
                        PasswordEditActivity passwordEditActivity2 = this.f10817b;
                        r0.f.q(passwordEditActivity2, passwordEditActivity2.o0().f7090c);
                        if (passwordEditActivity2.o0().f7090c.getText().toString().length() != 0 && passwordEditActivity2.o0().f7089b.getText().toString().length() != 0) {
                            if (passwordEditActivity2.o0().f7090c.getText().toString().length() >= 6) {
                                if (passwordEditActivity2.o0().f7090c.getText().toString().length() <= 99) {
                                    if (!kotlin.jvm.internal.l.a(passwordEditActivity2.o0().f7090c.getText().toString(), passwordEditActivity2.o0().f7089b.getText().toString())) {
                                        String string = passwordEditActivity2.getString(R.string.password_edit_not_match);
                                        string.getClass();
                                        passwordEditActivity2.C(string);
                                        break;
                                    } else {
                                        z5 z5Var = (z5) passwordEditActivity2.H.getValue();
                                        String string2 = passwordEditActivity2.o0().f7090c.getText().toString();
                                        String string3 = passwordEditActivity2.o0().f7089b.getText().toString();
                                        z5Var.getClass();
                                        string2.getClass();
                                        string3.getClass();
                                        kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                                        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                                        r7.w viewModelScope = ViewModelKt.getViewModelScope(z5Var);
                                        y7.e eVar = r7.i0.f12407a;
                                        r7.y.q(viewModelScope, y7.d.f14116a, null, new y5(z5Var, passwordEditActivity2, string2, string3, xVar, vVar, null), 2);
                                        break;
                                    }
                                } else {
                                    String string4 = passwordEditActivity2.getString(R.string.validation_hundred_chars_max);
                                    string4.getClass();
                                    passwordEditActivity2.C(string4);
                                    break;
                                }
                            } else {
                                String string5 = passwordEditActivity2.getString(R.string.validation_six_chars_min);
                                string5.getClass();
                                passwordEditActivity2.C(string5);
                                break;
                            }
                        } else {
                            String string6 = passwordEditActivity2.getString(R.string.error_email_vacio_recuperar_pass);
                            string6.getClass();
                            passwordEditActivity2.C(string6);
                            break;
                        }
                        break;
                }
            }
        });
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = i0.f12407a;
        r7.y.q(lifecycleScope, n.f13548a, null, new c(this, null, 22), 2);
    }

    public final void p0(EditText editText, ImageView imageView) {
        if (editText.getInputType() == 129) {
            editText.setInputType(145);
            imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_password_visible));
            editText.setSelection(editText.length());
        } else {
            editText.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
            imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_password_hidden));
            editText.setSelection(editText.length());
        }
    }
}
