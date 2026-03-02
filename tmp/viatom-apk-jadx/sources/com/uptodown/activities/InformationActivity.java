package com.uptodown.activities;

import a3.i0;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import com.uptodown.activities.InformationActivity;
import d5.v;
import l4.w;
import o4.b;
import s6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class InformationActivity extends w {
    public static final /* synthetic */ int I = 0;
    public final m H = new m(new i0(this, 26));

    public final v n0() {
        return (v) this.H.getValue();
    }

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = n0().f7371a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            n0().f7372b.setNavigationIcon(drawable);
            n0().f7372b.setNavigationContentDescription(getString(R.string.back));
        }
        final int i10 = 0;
        n0().f7372b.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: l4.d1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InformationActivity f10315b;

            {
                this.f10315b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                InformationActivity informationActivity = this.f10315b;
                switch (i11) {
                    case 0:
                        int i12 = InformationActivity.I;
                        informationActivity.finish();
                        break;
                    default:
                        int i13 = InformationActivity.I;
                        String string = informationActivity.getString(R.string.url_dev_on_board);
                        string.getClass();
                        String string2 = informationActivity.getString(R.string.support_title);
                        string2.getClass();
                        v5.c.e(informationActivity, string, string2);
                        break;
                }
            }
        });
        n0().f7375i.setTypeface(b.f11719r);
        n0().f7373c.setTypeface(b.f11720s);
        n0().f7374d.setTypeface(b.f11720s);
        n0().e.setTypeface(b.f11720s);
        n0().g.setTypeface(b.f11720s);
        n0().h.setTypeface(b.f11720s);
        n0().f.setTypeface(b.f11720s);
        TextView textView = n0().f;
        String string = getString(R.string.information_activity_dev_on_board_more_info);
        string.getClass();
        textView.setText(l5.w(this, string));
        final int i11 = 1;
        n0().f.setOnClickListener(new View.OnClickListener(this) { // from class: l4.d1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InformationActivity f10315b;

            {
                this.f10315b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                InformationActivity informationActivity = this.f10315b;
                switch (i112) {
                    case 0:
                        int i12 = InformationActivity.I;
                        informationActivity.finish();
                        break;
                    default:
                        int i13 = InformationActivity.I;
                        String string2 = informationActivity.getString(R.string.url_dev_on_board);
                        string2.getClass();
                        String string22 = informationActivity.getString(R.string.support_title);
                        string22.getClass();
                        v5.c.e(informationActivity, string2, string22);
                        break;
                }
            }
        });
    }
}
