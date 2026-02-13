package com.uptodown.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.VirusTotalReport;
import d5.k1;
import h5.f;
import h5.h;
import h5.o0;
import j$.util.concurrent.ConcurrentHashMap;
import j4.d0;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.y;
import l4.dc;
import l4.ec;
import l4.gc;
import l4.hc;
import l4.kb;
import l4.w;
import l4.x2;
import o4.b;
import r7.i0;
import s6.m;
import u7.m0;
import v5.n;
import w6.c;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class VirusTotalReport extends w {
    public static final /* synthetic */ int J = 0;
    public final m H = new m(new x2(this, 23));
    public final ViewModelLazy I = new ViewModelLazy(y.a(hc.class), new ec(this, 0), new dc(this), new ec(this, 1));

    public final k1 n0() {
        return (k1) this.H.getValue();
    }

    public final hc o0() {
        return (hc) this.I.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7177a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Intent intent = getIntent();
        c cVar = null;
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("appInfo")) {
                o0().f10474c.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", h.class) : extras.getParcelable("appInfo"));
            }
            if (extras != null && extras.containsKey("app_selected")) {
                o0().f10475d.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("app_selected", f.class) : extras.getParcelable("app_selected"));
            }
            if (extras != null && extras.containsKey("old_version_name")) {
                o0().f.f(extras.getString("old_version_name"));
            }
            if (extras != null && extras.containsKey("oldVersionId")) {
                m0 m0Var = o0().h;
                Boolean bool = Boolean.TRUE;
                m0Var.getClass();
                m0Var.g(null, bool);
                m0 m0Var2 = o0().g;
                Long lValueOf = Long.valueOf(extras.getLong("oldVersionId"));
                m0Var2.getClass();
                m0Var2.g(null, lValueOf);
            }
            if (extras != null && extras.containsKey("appReportVT")) {
                o0().e.f(Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appReportVT", o0.class) : extras.getParcelable("appReportVT"));
            }
            if (extras != null && extras.containsKey("isVirusTotalReportAvaialable")) {
                m0 m0Var3 = o0().f10476i;
                Boolean boolValueOf = Boolean.valueOf(extras.getBoolean("isVirusTotalReportAvaialable"));
                m0Var3.getClass();
                m0Var3.g(null, boolValueOf);
            }
        }
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            n0().f7182j.setNavigationIcon(drawable);
            n0().f7182j.setNavigationContentDescription(getString(R.string.back));
        }
        final int i10 = 1;
        n0().f7182j.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.cc

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ VirusTotalReport f10308b;

            {
                this.f10308b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                VirusTotalReport virusTotalReport = this.f10308b;
                switch (i11) {
                    case 0:
                        int i12 = VirusTotalReport.J;
                        String string = virusTotalReport.getString(R.string.url_is_utd_safe);
                        string.getClass();
                        v5.c.e(virusTotalReport, string, null);
                        break;
                    case 1:
                        int i13 = VirusTotalReport.J;
                        virusTotalReport.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        int i14 = VirusTotalReport.J;
                        if (virusTotalReport.o0().e.getValue() != null) {
                            Object value = virusTotalReport.o0().e.getValue();
                            value.getClass();
                            virusTotalReport.c0(((h5.o0) value).f8675a);
                            break;
                        }
                        break;
                }
            }
        });
        n0().y.setTypeface(b.f11719r);
        if (o0().f10474c.getValue() != null) {
            Object value = o0().f10474c.getValue();
            value.getClass();
            String strI = ((h) value).i();
            if (strI == null || strI.length() == 0) {
                n0().f7178b.f7328c.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vector_app_icon_placeholder));
            } else {
                j4.y yVarD = j4.y.d();
                Object value2 = o0().f10474c.getValue();
                value2.getClass();
                d0 d0VarE = yVarD.e(((h) value2).i());
                float f = UptodownApp.E;
                d0VarE.g(k4.c.y(this));
                d0VarE.e(n0().f7178b.f7328c, null);
            }
        } else if (o0().f10475d.getValue() != null) {
            ConcurrentHashMap concurrentHashMap = n.f13169a;
            Object value3 = o0().f10475d.getValue();
            value3.getClass();
            n0().f7178b.f7328c.setImageDrawable(n.c(this, ((f) value3).f8526c));
        }
        n0().f7178b.f7329d.setTypeface(b.f11719r);
        if (o0().f10474c.getValue() != null) {
            TextView textView = n0().f7178b.f7329d;
            Object value4 = o0().f10474c.getValue();
            value4.getClass();
            textView.setText(((h) value4).f8567b);
        } else if (o0().f10475d.getValue() != null) {
            TextView textView2 = n0().f7178b.f7329d;
            Object value5 = o0().f10475d.getValue();
            value5.getClass();
            textView2.setText(((f) value5).f8525b);
        }
        n0().f7178b.e.setTypeface(b.f11720s);
        CharSequence charSequence = (CharSequence) o0().f.getValue();
        if (charSequence != null && charSequence.length() != 0) {
            n0().f7178b.e.setText((CharSequence) o0().f.getValue());
        } else if (o0().f10474c.getValue() != null) {
            TextView textView3 = n0().f7178b.e;
            Object value6 = o0().f10474c.getValue();
            value6.getClass();
            textView3.setText(((h) value6).f8568c);
        } else if (o0().f10475d.getValue() != null) {
            TextView textView4 = n0().f7178b.e;
            Object value7 = o0().f10475d.getValue();
            value7.getClass();
            textView4.setText(((f) value7).e);
        }
        n0().f7184l.setTypeface(b.f11720s);
        n0().f7183k.setTypeface(b.f11719r);
        final int i11 = 2;
        n0().f7183k.setOnClickListener(new View.OnClickListener(this) { // from class: l4.cc

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ VirusTotalReport f10308b;

            {
                this.f10308b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                VirusTotalReport virusTotalReport = this.f10308b;
                switch (i112) {
                    case 0:
                        int i12 = VirusTotalReport.J;
                        String string = virusTotalReport.getString(R.string.url_is_utd_safe);
                        string.getClass();
                        v5.c.e(virusTotalReport, string, null);
                        break;
                    case 1:
                        int i13 = VirusTotalReport.J;
                        virusTotalReport.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        int i14 = VirusTotalReport.J;
                        if (virusTotalReport.o0().e.getValue() != null) {
                            Object value8 = virusTotalReport.o0().e.getValue();
                            value8.getClass();
                            virusTotalReport.c0(((h5.o0) value8).f8675a);
                            break;
                        }
                        break;
                }
            }
        });
        n0().f7193v.setTypeface(b.f11720s);
        n0().f7192u.setTypeface(b.f11719r);
        n0().f7195x.setTypeface(b.f11720s);
        n0().f7194w.setTypeface(b.f11719r);
        n0().f7190r.setTypeface(b.f11720s);
        n0().f7189q.setTypeface(b.f11720s);
        n0().f7188p.setTypeface(b.f11720s);
        n0().f7196z.setTypeface(b.f11720s);
        n0().f7187o.setTypeface(b.f11720s);
        n0().e.setOnClickListener(new e5.n(25));
        if (o0().e.getValue() != null) {
            q0();
            r0();
            p0();
        } else {
            if (((Boolean) o0().f10476i.getValue()).booleanValue()) {
                hc hcVarO0 = o0();
                Object value8 = o0().f10474c.getValue();
                value8.getClass();
                long j10 = ((h) value8).A;
                long jLongValue = ((Number) o0().g.getValue()).longValue();
                boolean zBooleanValue = ((Boolean) o0().h.getValue()).booleanValue();
                hcVarO0.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(hcVarO0);
                e eVar = i0.f12407a;
                r7.y.q(viewModelScope, d.f14116a, null, new gc(hcVarO0, this, zBooleanValue, j10, jLongValue, null), 2);
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
                e eVar2 = i0.f12407a;
                r7.y.q(lifecycleScope, w7.n.f13548a, null, new kb(this, cVar, i11), 2);
            }
            n0().f7180d.setVisibility(8);
            final int i12 = 0;
            n0().f7191s.setVisibility(0);
            n0().f7191s.setTypeface(b.f11720s);
            TextView textView5 = n0().f7191s;
            String string = getString(R.string.vt_report_not_avaialable);
            string.getClass();
            String str = String.format(string, Arrays.copyOf(new Object[]{getString(R.string.privacy_policies), getString(R.string.is_uptodown_safe)}, 2));
            String string2 = getString(R.string.app_technical_data_avaialable_at_utd_description);
            string2.getClass();
            textView5.setText(l5.w(this, str.concat(String.format(string2, Arrays.copyOf(new Object[]{getString(R.string.app_technical_data_avaialable_at_utd), "packagename"}, 2)))));
            n0().f7191s.setOnClickListener(new View.OnClickListener(this) { // from class: l4.cc

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ VirusTotalReport f10308b;

                {
                    this.f10308b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i112 = i12;
                    VirusTotalReport virusTotalReport = this.f10308b;
                    switch (i112) {
                        case 0:
                            int i122 = VirusTotalReport.J;
                            String string3 = virusTotalReport.getString(R.string.url_is_utd_safe);
                            string3.getClass();
                            v5.c.e(virusTotalReport, string3, null);
                            break;
                        case 1:
                            int i13 = VirusTotalReport.J;
                            virusTotalReport.getOnBackPressedDispatcher().onBackPressed();
                            break;
                        default:
                            int i14 = VirusTotalReport.J;
                            if (virusTotalReport.o0().e.getValue() != null) {
                                Object value82 = virusTotalReport.o0().e.getValue();
                                value82.getClass();
                                virusTotalReport.c0(((h5.o0) value82).f8675a);
                                break;
                            }
                            break;
                    }
                }
            });
            p0();
        }
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar22 = i0.f12407a;
        r7.y.q(lifecycleScope2, w7.n.f13548a, null, new kb(this, cVar, i11), 2);
    }

    public final void p0() {
        o0 o0Var = (o0) o0().e.getValue();
        String str = o0Var != null ? o0Var.f8675a : null;
        if (str == null || str.length() == 0) {
            h hVar = (h) o0().f10474c.getValue();
            String str2 = hVar != null ? hVar.G : null;
            if (str2 == null || str2.length() == 0) {
                n0().h.setVisibility(8);
            } else {
                TextView textView = n0().f7193v;
                Object value = o0().f10474c.getValue();
                value.getClass();
                textView.setText(((h) value).G);
            }
        } else {
            TextView textView2 = n0().f7193v;
            Object value2 = o0().e.getValue();
            value2.getClass();
            textView2.setText(((o0) value2).f8675a);
        }
        h hVar2 = (h) o0().f10474c.getValue();
        String str3 = hVar2 != null ? hVar2.D : null;
        if (str3 == null || str3.length() == 0) {
            TextView textView3 = n0().f7195x;
            f fVar = (f) o0().f10475d.getValue();
            textView3.setText(fVar != null ? fVar.f8531l : null);
        } else {
            TextView textView4 = n0().f7195x;
            h hVar3 = (h) o0().f10474c.getValue();
            textView4.setText(hVar3 != null ? hVar3.D : null);
        }
        n0().e.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q0() {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.VirusTotalReport.q0():void");
    }

    public final void r0() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) getResources().getDimension(R.dimen.margin_s), 0, 0);
        if (o0().e.getValue() != null) {
            Object value = o0().e.getValue();
            value.getClass();
            if (((o0) value).e != null) {
                Object value2 = o0().e.getValue();
                value2.getClass();
                ArrayList arrayList = ((o0) value2).e;
                arrayList.getClass();
                if (arrayList.size() > 0) {
                    Object value3 = o0().e.getValue();
                    value3.getClass();
                    ArrayList arrayList2 = ((o0) value3).e;
                    arrayList2.getClass();
                    int size = arrayList2.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        View viewInflate = getLayoutInflater().inflate(R.layout.scan_positive, (ViewGroup) n0().f7179c, false);
                        viewInflate.getClass();
                        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                        relativeLayout.setLayoutParams(layoutParams);
                        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_antivirus_name);
                        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_virus_name);
                        Object value4 = o0().e.getValue();
                        value4.getClass();
                        ArrayList arrayList3 = ((o0) value4).e;
                        arrayList3.getClass();
                        textView.setText(((h5.y) arrayList3.get(i10)).f8792a);
                        Object value5 = o0().e.getValue();
                        value5.getClass();
                        ArrayList arrayList4 = ((o0) value5).e;
                        arrayList4.getClass();
                        textView2.setText(((h5.y) arrayList4.get(i10)).f8793b);
                        n0().f7179c.addView(relativeLayout);
                    }
                }
            }
        }
    }
}
