package z5;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import h5.q;
import java.util.concurrent.atomic.AtomicBoolean;
import l4.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public h5.h f14413a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f14414b;

    /* renamed from: c, reason: collision with root package name */
    public final i0.k f14415c;

    /* renamed from: d, reason: collision with root package name */
    public View f14416d;
    public RelativeLayout e;
    public ImageView f;
    public TextView g;
    public TextView h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f14417i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f14418j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f14419k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f14420l;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f14421m;

    /* renamed from: n, reason: collision with root package name */
    public ProgressBar f14422n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f14423o;

    /* renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f14424p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14425q;

    public d(h5.h hVar, RelativeLayout relativeLayout, i0.k kVar) {
        hVar.getClass();
        relativeLayout.getClass();
        this.f14413a = hVar;
        this.f14414b = relativeLayout;
        this.f14415c = kVar;
        this.f14424p = new AtomicBoolean(false);
    }

    public static final void a(w wVar, d dVar) {
        ImageView imageView = dVar.f14420l;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
        imageView.setBackground(ContextCompat.getDrawable(wVar, R.drawable.ripple_wishlist));
        ImageView imageView2 = dVar.f14420l;
        if (imageView2 == null) {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
        imageView2.setImageResource(R.drawable.vector_heart_blue);
        ImageView imageView3 = dVar.f14420l;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        } else {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(l4.w r8) {
        /*
            r7 = this;
            java.lang.String r0 = "SettingsPreferences"
            java.lang.String r1 = "animations"
            r8.getClass()
            android.widget.RelativeLayout r2 = r7.f14414b
            int r3 = r2.getVisibility()
            r4 = 0
            if (r3 != 0) goto L70
            float r3 = com.uptodown.UptodownApp.E
            r3 = 1
            android.content.SharedPreferences r5 = r8.getSharedPreferences(r0, r4)     // Catch: java.lang.Exception -> L22
            boolean r6 = r5.contains(r1)     // Catch: java.lang.Exception -> L22
            if (r6 == 0) goto L22
            boolean r5 = r5.getBoolean(r1, r3)     // Catch: java.lang.Exception -> L22
            goto L23
        L22:
            r5 = r3
        L23:
            if (r5 == 0) goto L6a
            float r5 = com.uptodown.UptodownApp.E
            java.util.concurrent.atomic.AtomicBoolean r5 = r7.f14424p
            boolean r5 = r5.compareAndSet(r4, r3)
            if (r5 == 0) goto L6a
            e5.d0 r2 = new e5.d0
            r2.<init>(r7, r3)
            android.widget.RelativeLayout r5 = r7.e
            if (r5 == 0) goto L63
            l4.t2 r6 = new l4.t2
            r6.<init>(r8, r7, r2)
            r2 = 2130772034(0x7f010042, float:1.7147175E38)
            android.view.animation.Animation r2 = android.view.animation.AnimationUtils.loadAnimation(r8, r2)
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r0, r4)     // Catch: java.lang.Exception -> L53
            boolean r0 = r8.contains(r1)     // Catch: java.lang.Exception -> L53
            if (r0 == 0) goto L53
            boolean r8 = r8.getBoolean(r1, r3)     // Catch: java.lang.Exception -> L53
            goto L54
        L53:
            r8 = r3
        L54:
            if (r8 == 0) goto L5f
            float r8 = com.uptodown.UptodownApp.E
            r2.setAnimationListener(r6)
            r5.startAnimation(r2)
            goto L6f
        L5f:
            r6.onAnimationEnd(r2)
            goto L6f
        L63:
            java.lang.String r8 = "rlAppInfoSelected"
            kotlin.jvm.internal.l.i(r8)
            r8 = 0
            throw r8
        L6a:
            r8 = 8
            r2.setVisibility(r8)
        L6f:
            return r3
        L70:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.d.b(l4.w):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(h5.h r18, l4.w r19) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.d.c(h5.h, l4.w):void");
    }

    public final void d(q qVar, w wVar) {
        ProgressBar progressBar = this.f14422n;
        if (progressBar == null) {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
        ImageView imageView = this.f;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
            throw null;
        }
        a.a.P(progressBar, imageView);
        TextView textView = this.f14417i;
        if (textView == null) {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw null;
        }
        textView.setVisibility(8);
        LinearLayout linearLayout = this.f14421m;
        if (linearLayout == null) {
            kotlin.jvm.internal.l.i("llAppInfoSelected");
            throw null;
        }
        int i10 = 0;
        linearLayout.setVisibility(0);
        TextView textView2 = this.h;
        if (textView2 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        textView2.setText(R.string.option_button_cancel);
        TextView textView3 = this.h;
        if (textView3 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        textView3.setOnClickListener(new a(this, wVar, i10));
        TextView textView4 = this.h;
        if (textView4 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        l5.F(textView4);
        if (qVar.i() == 0) {
            TextView textView5 = this.f14423o;
            if (textView5 == null) {
                kotlin.jvm.internal.l.i("tvProgressAppInfoSelected");
                throw null;
            }
            textView5.setText(wVar.getString(R.string.status_download_update_pending));
            ProgressBar progressBar2 = this.f14422n;
            if (progressBar2 != null) {
                progressBar2.setIndeterminate(true);
                return;
            } else {
                kotlin.jvm.internal.l.i("pbAppInfoSelected");
                throw null;
            }
        }
        ProgressBar progressBar3 = this.f14422n;
        if (progressBar3 == null) {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
        progressBar3.setIndeterminate(false);
        TextView textView6 = this.f14423o;
        if (textView6 == null) {
            kotlin.jvm.internal.l.i("tvProgressAppInfoSelected");
            throw null;
        }
        textView6.setText(wVar.getString(R.string.percent_of_total_size, Integer.valueOf(qVar.i()), l1.b.M(wVar, qVar.k())));
        ProgressBar progressBar4 = this.f14422n;
        if (progressBar4 != null) {
            progressBar4.setProgress(qVar.i());
        } else {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
    }

    public final void e(String str) {
        ProgressBar progressBar = this.f14422n;
        if (progressBar == null) {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
        ImageView imageView = this.f;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
            throw null;
        }
        a.a.x(progressBar, imageView);
        TextView textView = this.h;
        if (textView == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        textView.setText(str);
        TextView textView2 = this.h;
        if (textView2 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        l5.E(textView2);
        LinearLayout linearLayout = this.f14421m;
        if (linearLayout == null) {
            kotlin.jvm.internal.l.i("llAppInfoSelected");
            throw null;
        }
        linearLayout.setVisibility(8);
        TextView textView3 = this.f14417i;
        if (textView3 != null) {
            textView3.setVisibility(0);
        } else {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw null;
        }
    }

    public final void f() {
        ProgressBar progressBar = this.f14422n;
        if (progressBar == null) {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
        ImageView imageView = this.f;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
            throw null;
        }
        a.a.P(progressBar, imageView);
        TextView textView = this.f14417i;
        if (textView == null) {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw null;
        }
        textView.setVisibility(8);
        LinearLayout linearLayout = this.f14421m;
        if (linearLayout == null) {
            kotlin.jvm.internal.l.i("llAppInfoSelected");
            throw null;
        }
        linearLayout.setVisibility(0);
        TextView textView2 = this.f14417i;
        if (textView2 == null) {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw null;
        }
        textView2.setText(this.f14414b.getContext().getString(R.string.installing));
        TextView textView3 = this.h;
        if (textView3 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        textView3.setVisibility(8);
        ProgressBar progressBar2 = this.f14422n;
        if (progressBar2 != null) {
            progressBar2.setIndeterminate(true);
        } else {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
    }

    public final void g(w wVar) {
        ImageView imageView = this.f14420l;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
        imageView.setBackground(ContextCompat.getDrawable(wVar, R.drawable.ripple_wishlist_added));
        ImageView imageView2 = this.f14420l;
        if (imageView2 == null) {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
        imageView2.setImageResource(R.drawable.vector_heart_white);
        ImageView imageView3 = this.f14420l;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        } else {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(h5.q r10, int r11, l4.w r12) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.d.h(h5.q, int, l4.w):void");
    }
}
