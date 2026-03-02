package u5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f12912a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f12913b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12914c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12915d;
    public final TextView e;
    public final TextView f;
    public final ProgressBar g;
    public final LinearLayout h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f12916i;

    public b(View view) {
        super(view);
        View viewFindViewById = view.findViewById(R.id.tv_name);
        viewFindViewById.getClass();
        this.f12912a = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_short_desc);
        viewFindViewById2.getClass();
        this.f12913b = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_description);
        viewFindViewById3.getClass();
        this.f12914c = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_percent);
        viewFindViewById4.getClass();
        this.f12915d = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.tv_version);
        viewFindViewById5.getClass();
        this.e = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.tv_autor);
        viewFindViewById6.getClass();
        this.f = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.pb_download);
        viewFindViewById7.getClass();
        this.g = (ProgressBar) viewFindViewById7;
        this.h = (LinearLayout) view.findViewById(R.id.ll_screenshots);
        View viewFindViewById8 = view.findViewById(R.id.rl_contaier_valoration_tv_app_detail);
        viewFindViewById8.getClass();
        this.f12916i = (RelativeLayout) viewFindViewById8;
    }

    public final void a(int i10) {
        TextView textView = this.f12915d;
        ProgressBar progressBar = this.g;
        if (i10 <= 0) {
            progressBar.setVisibility(8);
            textView.setVisibility(8);
        } else {
            progressBar.setVisibility(0);
            progressBar.setProgress(i10);
            textView.setVisibility(0);
            textView.setText(String.format("%s%%", Arrays.copyOf(new Object[]{String.valueOf(i10)}, 1)));
        }
    }
}
