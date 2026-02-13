package com.uptodown.activities;

import a3.i0;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.GdprPrivacySettings;
import d5.m1;
import k4.c;
import l4.b1;
import l4.w;
import o4.b;
import s6.m;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class GdprPrivacySettings extends w {
    public static final /* synthetic */ int I = 0;
    public final m H = new m(new i0(this, 25));

    public final m1 n0() {
        return (m1) this.H.getValue();
    }

    public final void o0() {
        boolean zIsChecked = n0().g.isChecked();
        if (t1.r(this, "gdpr_crashlytics_allowed", false) != zIsChecked) {
            t1.N(this, "gdpr_crashlytics_allowed", zIsChecked);
        }
        boolean zIsChecked2 = n0().e.isChecked();
        if (t1.r(this, "gdpr_analytics_allowed", false) != zIsChecked2) {
            t1.N(this, "gdpr_analytics_allowed", zIsChecked2);
        }
        boolean zIsChecked3 = n0().f.isChecked();
        if (t1.r(this, "gdpr_tracking_allowed", false) != zIsChecked3) {
            t1.N(this, "gdpr_tracking_allowed", zIsChecked3);
        }
        if (!t1.r(this, "gdpr_tracking_allowed", false)) {
            setResult(0);
            return;
        }
        float f = UptodownApp.E;
        c.E(this);
        c.j(this);
        setResult(-1);
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7221a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        n0().f7222b.setOnClickListener(new b1(this, 0));
        n0().f7232p.setTypeface(b.f11719r);
        n0().f7237v.setTypeface(b.f11719r);
        n0().f7225i.setTypeface(b.f11720s);
        n0().f7235s.setTypeface(b.f11719r);
        n0().f7229m.setTypeface(b.f11720s);
        n0().f7234r.setTypeface(b.f11719r);
        n0().f7228l.setTypeface(b.f11720s);
        n0().t.setTypeface(b.f11719r);
        n0().f7230n.setTypeface(b.f11720s);
        n0().f7233q.setTypeface(b.f11719r);
        n0().f7227k.setTypeface(b.f11720s);
        n0().f7236u.setTypeface(b.f11719r);
        n0().f7231o.setTypeface(b.f11720s);
        n0().h.setTypeface(b.f11719r);
        n0().f7226j.setTypeface(b.f11719r);
        n0().f7238w.setText("⚠ " + getString(R.string.tracking_disabled_warning_gdpr) + " ⚠");
        n0().f7238w.setTypeface(b.f11720s);
        n0().e.setChecked(t1.r(this, "gdpr_analytics_allowed", false));
        n0().g.setChecked(t1.r(this, "gdpr_crashlytics_allowed", false));
        n0().f.setChecked(t1.r(this, "gdpr_tracking_allowed", false));
        if (t1.r(this, "gdpr_requested", false)) {
            q0(n0().e, n0().f7228l, n0().e.isChecked());
            q0(n0().g, n0().f7230n, n0().g.isChecked());
            q0(n0().f, n0().f7229m, n0().f.isChecked());
        } else {
            q0(n0().e, n0().f7228l, true);
            q0(n0().g, n0().f7230n, true);
            q0(n0().f, n0().f7229m, true);
            n0().e.setChecked(true);
            n0().g.setChecked(true);
            n0().f.setChecked(true);
        }
        if (n0().f.isChecked()) {
            n0().f7238w.setVisibility(8);
        } else {
            n0().f7238w.setVisibility(0);
        }
        final int i10 = 0;
        n0().e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: l4.c1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GdprPrivacySettings f10278b;

            {
                this.f10278b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                int i11 = i10;
                GdprPrivacySettings gdprPrivacySettings = this.f10278b;
                switch (i11) {
                    case 0:
                        int i12 = GdprPrivacySettings.I;
                        gdprPrivacySettings.q0(gdprPrivacySettings.n0().e, gdprPrivacySettings.n0().f7228l, z9);
                        gdprPrivacySettings.p0();
                        break;
                    case 1:
                        int i13 = GdprPrivacySettings.I;
                        gdprPrivacySettings.q0(gdprPrivacySettings.n0().g, gdprPrivacySettings.n0().f7230n, z9);
                        gdprPrivacySettings.p0();
                        break;
                    default:
                        int i14 = GdprPrivacySettings.I;
                        gdprPrivacySettings.q0(gdprPrivacySettings.n0().f, gdprPrivacySettings.n0().f7229m, z9);
                        gdprPrivacySettings.p0();
                        if (!gdprPrivacySettings.n0().f.isChecked()) {
                            gdprPrivacySettings.n0().f7238w.setVisibility(0);
                            break;
                        } else {
                            gdprPrivacySettings.n0().f7238w.setVisibility(8);
                            break;
                        }
                }
            }
        });
        final int i11 = 1;
        n0().g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: l4.c1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GdprPrivacySettings f10278b;

            {
                this.f10278b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                int i112 = i11;
                GdprPrivacySettings gdprPrivacySettings = this.f10278b;
                switch (i112) {
                    case 0:
                        int i12 = GdprPrivacySettings.I;
                        gdprPrivacySettings.q0(gdprPrivacySettings.n0().e, gdprPrivacySettings.n0().f7228l, z9);
                        gdprPrivacySettings.p0();
                        break;
                    case 1:
                        int i13 = GdprPrivacySettings.I;
                        gdprPrivacySettings.q0(gdprPrivacySettings.n0().g, gdprPrivacySettings.n0().f7230n, z9);
                        gdprPrivacySettings.p0();
                        break;
                    default:
                        int i14 = GdprPrivacySettings.I;
                        gdprPrivacySettings.q0(gdprPrivacySettings.n0().f, gdprPrivacySettings.n0().f7229m, z9);
                        gdprPrivacySettings.p0();
                        if (!gdprPrivacySettings.n0().f.isChecked()) {
                            gdprPrivacySettings.n0().f7238w.setVisibility(0);
                            break;
                        } else {
                            gdprPrivacySettings.n0().f7238w.setVisibility(8);
                            break;
                        }
                }
            }
        });
        n0().f7223c.setOnClickListener(new b1(this, i11));
        final int i12 = 2;
        n0().f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: l4.c1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ GdprPrivacySettings f10278b;

            {
                this.f10278b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                int i112 = i12;
                GdprPrivacySettings gdprPrivacySettings = this.f10278b;
                switch (i112) {
                    case 0:
                        int i122 = GdprPrivacySettings.I;
                        gdprPrivacySettings.q0(gdprPrivacySettings.n0().e, gdprPrivacySettings.n0().f7228l, z9);
                        gdprPrivacySettings.p0();
                        break;
                    case 1:
                        int i13 = GdprPrivacySettings.I;
                        gdprPrivacySettings.q0(gdprPrivacySettings.n0().g, gdprPrivacySettings.n0().f7230n, z9);
                        gdprPrivacySettings.p0();
                        break;
                    default:
                        int i14 = GdprPrivacySettings.I;
                        gdprPrivacySettings.q0(gdprPrivacySettings.n0().f, gdprPrivacySettings.n0().f7229m, z9);
                        gdprPrivacySettings.p0();
                        if (!gdprPrivacySettings.n0().f.isChecked()) {
                            gdprPrivacySettings.n0().f7238w.setVisibility(0);
                            break;
                        } else {
                            gdprPrivacySettings.n0().f7238w.setVisibility(8);
                            break;
                        }
                }
            }
        });
        n0().f7224d.setOnClickListener(new b1(this, i12));
        n0().h.setOnClickListener(new b1(this, 3));
        n0().f7226j.setOnClickListener(new b1(this, 4));
    }

    @Override // l4.w, p4.m0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (t1.r(this, "gdpr_requested", false)) {
            return;
        }
        t1.N(this, "gdpr_requested", true);
        t1.N(this, "gdpr_analytics_allowed", true);
        t1.N(this, "gdpr_crashlytics_allowed", true);
        t1.N(this, "gdpr_tracking_allowed", true);
    }

    public final void p0() {
        if (n0().f7226j.getVisibility() == 0) {
            n0().h.setText(R.string.save);
            n0().h.setOnClickListener(new b1(this, 5));
            n0().f7226j.setVisibility(8);
        }
    }

    public final void q0(SwitchCompat switchCompat, TextView textView, boolean z9) {
        if (z9) {
            switchCompat.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
            textView.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        } else {
            switchCompat.setTextColor(ContextCompat.getColor(this, R.color.main_light_grey));
            textView.setTextColor(ContextCompat.getColor(this, R.color.main_light_grey));
        }
    }
}
