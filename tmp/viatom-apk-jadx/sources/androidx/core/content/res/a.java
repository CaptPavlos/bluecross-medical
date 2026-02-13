package androidx.core.content.res;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.uptodown.R;
import com.uptodown.core.activities.InstallerActivity;
import l4.kb;
import p4.m0;
import r7.i0;
import r7.y;
import w6.c;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f474a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f475b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f476c;

    public /* synthetic */ a(Object obj, int i10, int i11) {
        this.f474a = i11;
        this.f476c = obj;
        this.f475b = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f474a;
        int i11 = this.f475b;
        Object obj = this.f476c;
        switch (i10) {
            case 0:
                ((ResourcesCompat.FontCallback) obj).lambda$callbackFailAsync$1(i11);
                break;
            case 1:
                ((SideSheetBehavior) obj).lambda$setState$0(i11);
                break;
            case 2:
                InstallerActivity installerActivity = (InstallerActivity) obj;
                int i12 = InstallerActivity.f6676m0;
                if (installerActivity.Q == null) {
                    e eVar = i0.f12407a;
                    installerActivity.Q = y.q(y.a(d.f14116a), null, null, new kb(installerActivity, (c) null, 7), 3);
                }
                TextView textView = installerActivity.F;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                LinearLayout linearLayout = installerActivity.U;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                TextView textView2 = installerActivity.D;
                if (textView2 != null) {
                    textView2.setText(installerActivity.getString(R.string.unzipping_status, Integer.valueOf(i11)));
                }
                ProgressBar progressBar = installerActivity.f6679p;
                if (progressBar != null) {
                    progressBar.setIndeterminate(false);
                }
                ProgressBar progressBar2 = installerActivity.f6679p;
                if (progressBar2 != null) {
                    progressBar2.setProgress(i11);
                }
                installerActivity.getWindow().addFlags(128);
                ImageView imageView = installerActivity.H;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    break;
                }
                break;
            default:
                m0 m0Var = (m0) obj;
                ProgressBar progressBar3 = m0Var.f11995q;
                if (progressBar3 != null) {
                    progressBar3.setProgress(i11);
                }
                TextView textView3 = m0Var.f11994p;
                if (textView3 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i11);
                    sb.append('%');
                    textView3.setText(sb.toString());
                    break;
                }
                break;
        }
    }
}
