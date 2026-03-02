package u5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import h5.y0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public Context f12917a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f12918b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f12919c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f12920d;
    public TextView e;
    public TextView f;

    public final boolean a(h5.f fVar) {
        ApplicationInfo applicationInfoB;
        try {
            PackageManager packageManager = this.f12917a.getPackageManager();
            packageManager.getClass();
            String str = fVar.f8526c;
            str.getClass();
            applicationInfoB = l5.a.b(packageManager, str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfoB = null;
        }
        return fVar.f8532m == 0 && applicationInfoB != null && applicationInfoB.enabled;
    }

    public final void b(y0 y0Var, TextView textView, TextView textView2) {
        Context context = this.f12917a;
        if (y0Var == null || y0Var.b()) {
            textView.setText(context.getString(R.string.status_download_installed));
            textView.setTextColor(ContextCompat.getColor(context, R.color.download_installed_status));
            textView.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_status_download_installed));
        } else {
            textView.setText(context.getString(R.string.status_download_update));
            l5.G(textView);
        }
        textView.setVisibility(0);
        textView2.setVisibility(8);
    }
}
