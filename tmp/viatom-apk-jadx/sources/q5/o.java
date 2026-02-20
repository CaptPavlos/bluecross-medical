package q5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import java.io.File;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public int f12275a;

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj instanceof h5.q) {
            h5.q qVar = (h5.q) obj;
            u5.f fVar = (u5.f) viewHolder;
            Context context = viewHolder.view.getContext();
            TextView textView = fVar.f12927a;
            TextView textView2 = fVar.f12928b;
            ProgressBar progressBar = fVar.f12930d;
            TextView textView3 = fVar.f12929c;
            if (context != null) {
                textView.setText(qVar.f8709n + ' ' + qVar.f);
                textView.setTypeface(o4.b.f11720s);
                textView2.setTypeface(o4.b.f11720s);
                textView3.setTypeface(o4.b.f11720s);
                if (qVar.i() > 0 && qVar.i() < 100) {
                    textView2.setText(String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(qVar.i())}, 1)));
                    textView3.setVisibility(8);
                    progressBar.setProgress(qVar.i());
                    progressBar.setVisibility(0);
                    return;
                }
                u4.a aVarA = r0.f.A();
                if (aVarA != null && u.Z(aVarA.f12891a, qVar.f8701b, true)) {
                    long j10 = qVar.e;
                    if (j10 > 0 && aVarA.f12892b == j10) {
                        progressBar.setIndeterminate(true);
                        progressBar.setVisibility(0);
                        textView3.setText(R.string.installing);
                        textView2.setText(l1.b.M(context, qVar.j()));
                        return;
                    }
                }
                File fileG = qVar.g();
                if (fileG != null) {
                    long jLastModified = fileG.lastModified();
                    DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
                    textView3.setVisibility(0);
                    textView3.setText(dateTimeInstance.format(new Date(jLastModified)));
                    textView2.setText(l1.b.M(context, qVar.k()));
                    progressBar.setVisibility(4);
                }
            }
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.tv_download_item, viewGroup, false);
        this.f12275a = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        ContextCompat.getColor(viewGroup.getContext(), R.color.blue_primary_pressed);
        viewG.setFocusable(true);
        viewG.setFocusableInTouchMode(true);
        viewG.setBackgroundColor(this.f12275a);
        return new u5.f(viewG);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
