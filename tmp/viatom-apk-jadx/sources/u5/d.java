package u5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import h5.y0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12921a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f12922b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12923c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12924d;
    public final TextView e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(View view, Context context) {
        super(view);
        context.getClass();
        this.f12921a = context;
        this.f12922b = (ImageView) view.findViewById(R.id.iv_logo_home_card_item);
        TextView textView = (TextView) view.findViewById(R.id.tv_name_home_card_item);
        this.f12923c = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_desc_home_card_item);
        this.f12924d = textView2;
        TextView textView3 = (TextView) view.findViewById(R.id.tv_status_home_card_item);
        this.e = textView3;
        if (textView != null) {
            textView.setTypeface(o4.b.f11719r);
        }
        if (textView2 != null) {
            textView2.setTypeface(o4.b.f11720s);
        }
        if (textView3 != null) {
            textView3.setTypeface(o4.b.f11720s);
        }
    }

    public final boolean a(h5.f fVar) {
        ApplicationInfo applicationInfoB;
        try {
            PackageManager packageManager = this.f12921a.getPackageManager();
            packageManager.getClass();
            String str = fVar.f8526c;
            str.getClass();
            applicationInfoB = l5.a.b(packageManager, str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfoB = null;
        }
        return fVar.f8532m == 0 && applicationInfoB != null && applicationInfoB.enabled;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.d.b(java.lang.Object):void");
    }

    public final void c(y0 y0Var, TextView textView, TextView textView2) {
        Context context = this.f12921a;
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

    public final void d() {
        ImageView imageView = this.f12922b;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        TextView textView = this.f12923c;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        TextView textView2 = this.f12924d;
        if (textView2 != null) {
            textView2.setText((CharSequence) null);
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            textView3.setText((CharSequence) null);
        }
    }
}
