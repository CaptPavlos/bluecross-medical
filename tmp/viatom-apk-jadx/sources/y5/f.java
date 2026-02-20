package y5;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class f extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13857a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(View view, Context context) {
        super(view);
        view.getClass();
        context.getClass();
        this.f13857a = context;
    }

    public static void a(RelativeLayout.LayoutParams layoutParams, Context context, int i10, int i11) {
        context.getClass();
        int dimension = (int) context.getResources().getDimension(R.dimen.margin_m);
        String string = null;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("Language")) {
                string = sharedPreferences.getString("Language", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!kotlin.jvm.internal.l.a(string, "ar")) {
            if (i10 == i11) {
                layoutParams.setMargins(dimension, 0, dimension, 0);
                return;
            } else {
                layoutParams.setMargins(dimension, 0, 0, 0);
                return;
            }
        }
        if (i10 == i11) {
            layoutParams.setMargins(dimension, 0, 0, 0);
        } else if (i10 == 1) {
            layoutParams.setMargins(dimension, 0, dimension, 0);
        } else {
            layoutParams.setMargins(dimension, 0, 0, 0);
        }
    }

    public static void b(View view, g5.c cVar, h5.h hVar) {
        view.getClass();
        cVar.getClass();
        hVar.getClass();
        view.setOnClickListener(new f5(22, cVar, hVar));
    }

    public static void f(h5.h hVar, TextView textView, TextView textView2) {
        hVar.getClass();
        textView.getClass();
        textView2.getClass();
        textView.setText(hVar.f8567b);
        String str = hVar.f;
        if (str == null || str.length() == 0) {
            str = hVar.f8578n;
        }
        textView2.setText(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(h5.h r17, android.widget.ProgressBar r18, android.widget.ImageView r19, android.widget.TextView r20, android.widget.TextView r21, android.widget.TextView r22, android.widget.LinearLayout r23) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r1.getClass()
            r2.getClass()
            r19.getClass()
            r3.getClass()
            r4.getClass()
            r6.getClass()
            t3.h r7 = v5.g.f13148u
            android.content.Context r8 = r0.f13857a
            v5.g r7 = r7.l(r8)
            r7.a()
            java.lang.String r9 = r1.f8595w
            if (r9 == 0) goto L36
            long r10 = r1.B
            h5.q r7 = r7.B(r10, r9)
            goto L37
        L36:
            r7 = 0
        L37:
            float r9 = com.uptodown.UptodownApp.E
            java.lang.String r9 = "downloadApkWorker"
            boolean r9 = k4.c.n(r8, r9)
            r10 = 0
            r11 = 1
            if (r9 == 0) goto L51
            long r12 = r1.f8566a
            h5.q r9 = com.uptodown.workers.DownloadWorker.f6738d
            if (r9 == 0) goto L51
            long r14 = r9.h
            int r9 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r9 != 0) goto L51
            r9 = r11
            goto L52
        L51:
            r9 = r10
        L52:
            if (r7 == 0) goto L5c
            boolean r12 = r7.m()
            if (r12 != r11) goto L5c
            r12 = r11
            goto L5d
        L5c:
            r12 = r10
        L5d:
            r13 = 8
            if (r7 == 0) goto Lab
            if (r9 != 0) goto L65
            if (r12 == 0) goto Lab
        L65:
            int r1 = r7.i()
            long r14 = r7.k()
            a.a.P(r18, r19)
            r3.setVisibility(r13)
            if (r5 == 0) goto L78
            r5.setVisibility(r13)
        L78:
            r6.setVisibility(r10)
            if (r1 != 0) goto L8b
            r2.setIndeterminate(r11)
            r1 = 2131952624(0x7f1303f0, float:1.9541696E38)
            java.lang.String r1 = r8.getString(r1)
            r4.setText(r1)
            return
        L8b:
            r2.setIndeterminate(r10)
            r2.setProgress(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = l1.b.M(r8, r14)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r10] = r1
            r3[r11] = r2
            r1 = 2131952473(0x7f130359, float:1.954139E38)
            java.lang.String r1 = r8.getString(r1, r3)
            r4.setText(r1)
            return
        Lab:
            java.lang.String r1 = r1.f8595w
            a.a.x(r18, r19)
            r6.setVisibility(r13)
            if (r5 == 0) goto Lb8
            r0.d(r1, r5, r3)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.f.c(h5.h, android.widget.ProgressBar, android.widget.ImageView, android.widget.TextView, android.widget.TextView, android.widget.TextView, android.widget.LinearLayout):void");
    }

    public final void d(String str, TextView textView, TextView textView2) {
        textView.getClass();
        textView2.getClass();
        Context context = this.f13857a;
        PackageInfo packageInfoF = null;
        if (str != null && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfoF = l5.a.f(packageManager, str, 0);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (packageInfoF == null) {
            textView.setText(context.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(context, R.color.main_blue));
            textView.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_stroke_blue_primary));
            textView.setTypeface(o4.b.f11719r);
            textView.setVisibility(8);
            textView2.setVisibility(0);
            return;
        }
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        str.getClass();
        h5.y0 y0VarM = gVarL.M(str);
        h5.f fVarR = gVarL.r(str);
        gVarL.b();
        if (fVarR == null) {
            textView.setVisibility(0);
            textView2.setVisibility(8);
            return;
        }
        if (fVarR.f8532m != 0 || fVarR.d()) {
            textView.setVisibility(8);
            textView2.setVisibility(0);
            return;
        }
        if (y0VarM != null && !y0VarM.b()) {
            textView.setText(context.getString(R.string.status_download_update));
            l5.G(textView);
        } else if (fVarR.B) {
            textView.setText(context.getString(R.string.dark_mode_disabled));
            textView.setTextColor(ContextCompat.getColor(context, R.color.main_light_grey));
            textView.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_status_download_installed));
        } else {
            textView.setText(context.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(context, R.color.main_blue));
            textView.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_stroke_blue_primary));
        }
        textView.setTypeface(o4.b.f11719r);
        textView.setVisibility(0);
        textView2.setVisibility(8);
    }

    public final void e(ImageView imageView, String str) {
        imageView.getClass();
        Context context = this.f13857a;
        if (str == null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_app_icon_placeholder));
            return;
        }
        j4.d0 d0VarE = j4.y.d().e(str);
        d0VarE.f(R.drawable.shape_bg_placeholder);
        float f = UptodownApp.E;
        d0VarE.g(k4.c.y(context));
        d0VarE.e(imageView, null);
    }
}
