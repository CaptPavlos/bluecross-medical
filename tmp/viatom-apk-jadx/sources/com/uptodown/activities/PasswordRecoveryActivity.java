package com.uptodown.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.activities.PasswordRecoveryActivity;
import d5.i0;
import e5.n;
import l4.w;
import l4.x2;
import o4.b;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PasswordRecoveryActivity extends w {
    public static final /* synthetic */ int I = 0;
    public final m H = new m(new x2(this, 7));

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
    
        if (r7.y.z(r2, r0, r1) == r11) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object n0(com.uptodown.activities.PasswordRecoveryActivity r13, y6.c r14) {
        /*
            boolean r1 = r14 instanceof l4.b6
            if (r1 == 0) goto L13
            r1 = r14
            l4.b6 r1 = (l4.b6) r1
            int r2 = r1.g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L13
            int r2 = r2 - r3
            r1.g = r2
            goto L18
        L13:
            l4.b6 r1 = new l4.b6
            r1.<init>(r13, r14)
        L18:
            java.lang.Object r0 = r1.e
            int r2 = r1.g
            r9 = 2
            r8 = 1
            r10 = 0
            x6.a r11 = x6.a.f13718a
            if (r2 == 0) goto L41
            if (r2 == r8) goto L32
            if (r2 != r9) goto L2c
            s6.a.e(r0)
            goto L94
        L2c:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r0)
            return r10
        L32:
            kotlin.jvm.internal.x r2 = r1.f10253d
            kotlin.jvm.internal.x r4 = r1.f10252c
            kotlin.jvm.internal.x r5 = r1.f10251b
            kotlin.jvm.internal.v r6 = r1.f10250a
            s6.a.e(r0)
            r7 = r6
            r6 = r5
            r5 = r2
            goto L78
        L41:
            s6.a.e(r0)
            kotlin.jvm.internal.v r0 = new kotlin.jvm.internal.v
            r0.<init>()
            kotlin.jvm.internal.x r3 = new kotlin.jvm.internal.x
            r3.<init>()
            kotlin.jvm.internal.x r5 = new kotlin.jvm.internal.x
            r5.<init>()
            kotlin.jvm.internal.x r6 = new kotlin.jvm.internal.x
            r6.<init>()
            y7.e r2 = r7.i0.f12407a
            s7.c r12 = w7.n.f13548a
            c5.c r2 = new c5.c
            r7 = 0
            r4 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            r1.f10250a = r0
            r1.f10251b = r3
            r1.f10252c = r5
            r1.f10253d = r6
            r1.g = r8
            java.lang.Object r2 = r7.y.z(r2, r12, r1)
            if (r2 != r11) goto L74
            goto L93
        L74:
            r7 = r0
            r4 = r5
            r5 = r6
            r6 = r3
        L78:
            y7.e r0 = r7.i0.f12407a
            y7.d r0 = y7.d.f14116a
            l4.c6 r2 = new l4.c6
            r8 = 0
            r3 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r1.f10250a = r10
            r1.f10251b = r10
            r1.f10252c = r10
            r1.f10253d = r10
            r1.g = r9
            java.lang.Object r0 = r7.y.z(r2, r0, r1)
            if (r0 != r11) goto L94
        L93:
            return r11
        L94:
            s6.w r0 = s6.w.f12711a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PasswordRecoveryActivity.n0(com.uptodown.activities.PasswordRecoveryActivity, y6.c):java.lang.Object");
    }

    public final i0 o0() {
        return (i0) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = o0().f7109a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_password_recovery);
        if (toolbar != null) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription(getString(R.string.back));
                final int i10 = 0;
                toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.a6

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ PasswordRecoveryActivity f10218b;

                    {
                        this.f10218b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i11 = i10;
                        PasswordRecoveryActivity passwordRecoveryActivity = this.f10218b;
                        switch (i11) {
                            case 0:
                                int i12 = PasswordRecoveryActivity.I;
                                passwordRecoveryActivity.getOnBackPressedDispatcher().onBackPressed();
                                break;
                            default:
                                int i13 = PasswordRecoveryActivity.I;
                                if (!o7.u.Z(passwordRecoveryActivity.o0().f7111c.getText().toString(), "", true) && !o7.u.Z(passwordRecoveryActivity.o0().f7110b.getText().toString(), "", true)) {
                                    if (!o7.u.Z(passwordRecoveryActivity.o0().f7111c.getText().toString(), passwordRecoveryActivity.o0().f7110b.getText().toString(), true)) {
                                        String string = passwordRecoveryActivity.getString(R.string.error_emails_no_coinciden);
                                        if (string != null) {
                                            passwordRecoveryActivity.C(string);
                                            break;
                                        }
                                    } else {
                                        r7.y.q(LifecycleOwnerKt.getLifecycleScope(passwordRecoveryActivity), null, null, new a6.c(passwordRecoveryActivity, null, 23), 3);
                                        break;
                                    }
                                } else {
                                    String string2 = passwordRecoveryActivity.getString(R.string.error_email_vacio_recuperar_pass);
                                    if (string2 != null) {
                                        passwordRecoveryActivity.C(string2);
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                });
            }
            TextView textView = (TextView) findViewById(R.id.tv_title_toolbar_password_recovery);
            if (textView != null) {
                textView.setTypeface(b.f11719r);
            }
        }
        o0().f7111c.setTypeface(b.f11720s);
        o0().f7110b.setTypeface(b.f11720s);
        o0().e.setTypeface(b.f11719r);
        final int i11 = 1;
        o0().e.setOnClickListener(new View.OnClickListener(this) { // from class: l4.a6

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PasswordRecoveryActivity f10218b;

            {
                this.f10218b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                PasswordRecoveryActivity passwordRecoveryActivity = this.f10218b;
                switch (i112) {
                    case 0:
                        int i12 = PasswordRecoveryActivity.I;
                        passwordRecoveryActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        int i13 = PasswordRecoveryActivity.I;
                        if (!o7.u.Z(passwordRecoveryActivity.o0().f7111c.getText().toString(), "", true) && !o7.u.Z(passwordRecoveryActivity.o0().f7110b.getText().toString(), "", true)) {
                            if (!o7.u.Z(passwordRecoveryActivity.o0().f7111c.getText().toString(), passwordRecoveryActivity.o0().f7110b.getText().toString(), true)) {
                                String string = passwordRecoveryActivity.getString(R.string.error_emails_no_coinciden);
                                if (string != null) {
                                    passwordRecoveryActivity.C(string);
                                    break;
                                }
                            } else {
                                r7.y.q(LifecycleOwnerKt.getLifecycleScope(passwordRecoveryActivity), null, null, new a6.c(passwordRecoveryActivity, null, 23), 3);
                                break;
                            }
                        } else {
                            String string2 = passwordRecoveryActivity.getString(R.string.error_email_vacio_recuperar_pass);
                            if (string2 != null) {
                                passwordRecoveryActivity.C(string2);
                                break;
                            }
                        }
                        break;
                }
            }
        });
        o0().f7112d.setOnClickListener(new n(17));
    }
}
