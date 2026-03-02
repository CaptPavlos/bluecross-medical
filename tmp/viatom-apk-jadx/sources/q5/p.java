package q5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import h5.c0;
import java.util.Arrays;
import java.util.Locale;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public String f12276a;

    /* renamed from: b, reason: collision with root package name */
    public h5.f f12277b;

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        c0 c0Var = (c0) obj;
        u5.g gVar = (u5.g) viewHolder;
        Context context = viewHolder.view.getContext();
        context.getClass();
        String str = this.f12276a;
        h5.f fVar = this.f12277b;
        RelativeLayout relativeLayout = gVar.f12931a;
        ImageView imageView = gVar.f12932b;
        TextView textView = gVar.f12933c;
        ProgressBar progressBar = gVar.f;
        TextView textView2 = gVar.f12934d;
        TextView textView3 = gVar.e;
        TextView textView4 = gVar.g;
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            str.getClass();
            ApplicationInfo applicationInfo = l5.a.f(packageManager, str, 0).applicationInfo;
            imageView.setImageDrawable(applicationInfo != null ? applicationInfo.loadIcon(context.getPackageManager()) : null);
        } catch (Exception unused) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_uptodown_logo_disabled));
        }
        textView.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
        textView.setText(fVar != null ? fVar.f8525b : null);
        textView3.setText(c0Var.f8485a);
        progressBar.setVisibility(4);
        textView4.setVisibility(0);
        textView.setTextColor(ContextCompat.getColor(context, R.color.main_dark_grey));
        textView2.setTextColor(ContextCompat.getColor(context, R.color.main_dark_grey));
        textView3.setTextColor(ContextCompat.getColor(context, R.color.main_dark_grey));
        relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        if ((fVar != null ? Long.valueOf(fVar.f8527d) : null) != null && fVar.f8527d == c0Var.f8488d) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.white));
            textView2.setTextColor(ContextCompat.getColor(context, R.color.white));
            textView3.setTextColor(ContextCompat.getColor(context, R.color.white));
            relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.main_blue));
            textView4.setVisibility(8);
            return;
        }
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        String str2 = c0Var.g;
        str2.getClass();
        h5.q qVarY = gVarL.y(str2);
        gVarL.b();
        boolean z9 = qVarY != null && qVarY.i() > 0 && qVarY.i() < 100;
        if (qVarY == null) {
            textView4.setText(R.string.updates_button_download_app);
            textView4.setBackgroundColor(ContextCompat.getColor(context, R.color.accent_green));
            return;
        }
        if (z9) {
            textView2.setText(String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(qVarY.i())}, 1)));
            textView3.setVisibility(8);
            progressBar.setProgress(qVarY.i());
            progressBar.setVisibility(0);
            textView4.setText(android.R.string.cancel);
            textView4.setBackgroundColor(ContextCompat.getColor(context, R.color.main_light_grey));
            return;
        }
        textView3.setVisibility(0);
        long j10 = c0Var.f8486b;
        if (j10 > 0) {
            textView2.setText(l1.b.M(context, j10));
        }
        u4.a aVarA = r0.f.A();
        if (!u.Z(aVarA != null ? aVarA.f12891a : null, qVarY.f8701b, true)) {
            textView4.setText(R.string.option_button_install);
            textView4.setBackgroundColor(ContextCompat.getColor(context, R.color.main_blue));
        } else {
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(0);
            textView3.setText(R.string.installing);
            textView2.setText("");
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getClass();
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_old_version_item, viewGroup, false);
        viewInflate.setFocusable(true);
        viewInflate.setFocusableInTouchMode(true);
        viewInflate.setBackgroundColor(ContextCompat.getColor(viewGroup.getContext(), R.color.white));
        return new u5.g(viewInflate);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
