package com.uptodown.activities;

import a3.i0;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.activities.ContactUsActivity;
import d5.i;
import l4.w;
import o4.b;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ContactUsActivity extends w {
    public static final /* synthetic */ int J = 0;
    public final m H = new m(new i0(this, 20));
    public boolean I;

    public final i n0() {
        return (i) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7105a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            n0().e.setNavigationIcon(drawable);
            n0().e.setNavigationContentDescription(getString(R.string.back));
        }
        final int i10 = 0;
        n0().e.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.x

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContactUsActivity f10976b;

            {
                this.f10976b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                ContactUsActivity contactUsActivity = this.f10976b;
                switch (i11) {
                    case 0:
                        int i12 = ContactUsActivity.J;
                        contactUsActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        if (!contactUsActivity.I) {
                            contactUsActivity.n0().f7108d.setVisibility(0);
                            contactUsActivity.I = true;
                            Editable text = contactUsActivity.n0().f7106b.getText();
                            if (text != null && text.length() != 0) {
                                Editable text2 = contactUsActivity.n0().f7107c.getText();
                                if (text2 != null && text2.length() != 0) {
                                    y7.e eVar = r7.i0.f12407a;
                                    r7.y.q(r7.y.a(y7.d.f14116a), null, null, new a6.c(contactUsActivity, null, 15), 3);
                                    break;
                                } else {
                                    String string = contactUsActivity.getString(R.string.falta_texto_sugerencia);
                                    string.getClass();
                                    contactUsActivity.C(string);
                                }
                            } else {
                                String string2 = contactUsActivity.getString(R.string.falta_email_sugerencia);
                                string2.getClass();
                                contactUsActivity.C(string2);
                            }
                            contactUsActivity.I = false;
                            contactUsActivity.n0().f7108d.setVisibility(8);
                            break;
                        }
                        break;
                }
            }
        });
        n0().g.setTypeface(b.f11719r);
        n0().f7106b.setTypeface(b.f11720s);
        n0().f7106b.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: l4.y

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContactUsActivity f11011b;

            {
                this.f11011b = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z9) {
                int i11 = i10;
                ContactUsActivity contactUsActivity = this.f11011b;
                switch (i11) {
                    case 0:
                        int i12 = ContactUsActivity.J;
                        if (!z9) {
                            contactUsActivity.n0().f7106b.setHint(contactUsActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            contactUsActivity.n0().f7106b.setHint("");
                            break;
                        }
                    default:
                        int i13 = ContactUsActivity.J;
                        if (!z9) {
                            contactUsActivity.n0().f7107c.setHint(contactUsActivity.getString(R.string.hint_text_suggestion));
                            break;
                        } else {
                            contactUsActivity.n0().f7107c.setHint("");
                            break;
                        }
                }
            }
        });
        n0().f7107c.setTypeface(b.f11720s);
        final int i11 = 1;
        n0().f7107c.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: l4.y

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContactUsActivity f11011b;

            {
                this.f11011b = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z9) {
                int i112 = i11;
                ContactUsActivity contactUsActivity = this.f11011b;
                switch (i112) {
                    case 0:
                        int i12 = ContactUsActivity.J;
                        if (!z9) {
                            contactUsActivity.n0().f7106b.setHint(contactUsActivity.getString(R.string.hint_email_registro));
                            break;
                        } else {
                            contactUsActivity.n0().f7106b.setHint("");
                            break;
                        }
                    default:
                        int i13 = ContactUsActivity.J;
                        if (!z9) {
                            contactUsActivity.n0().f7107c.setHint(contactUsActivity.getString(R.string.hint_text_suggestion));
                            break;
                        } else {
                            contactUsActivity.n0().f7107c.setHint("");
                            break;
                        }
                }
            }
        });
        n0().f.setTypeface(b.f11719r);
        n0().f.setOnClickListener(new View.OnClickListener(this) { // from class: l4.x

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContactUsActivity f10976b;

            {
                this.f10976b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                ContactUsActivity contactUsActivity = this.f10976b;
                switch (i112) {
                    case 0:
                        int i12 = ContactUsActivity.J;
                        contactUsActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        if (!contactUsActivity.I) {
                            contactUsActivity.n0().f7108d.setVisibility(0);
                            contactUsActivity.I = true;
                            Editable text = contactUsActivity.n0().f7106b.getText();
                            if (text != null && text.length() != 0) {
                                Editable text2 = contactUsActivity.n0().f7107c.getText();
                                if (text2 != null && text2.length() != 0) {
                                    y7.e eVar = r7.i0.f12407a;
                                    r7.y.q(r7.y.a(y7.d.f14116a), null, null, new a6.c(contactUsActivity, null, 15), 3);
                                    break;
                                } else {
                                    String string = contactUsActivity.getString(R.string.falta_texto_sugerencia);
                                    string.getClass();
                                    contactUsActivity.C(string);
                                }
                            } else {
                                String string2 = contactUsActivity.getString(R.string.falta_email_sugerencia);
                                string2.getClass();
                                contactUsActivity.C(string2);
                            }
                            contactUsActivity.I = false;
                            contactUsActivity.n0().f7108d.setVisibility(8);
                            break;
                        }
                        break;
                }
            }
        });
    }
}
