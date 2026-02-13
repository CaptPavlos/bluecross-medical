package u5;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f12927a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f12928b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12929c;

    /* renamed from: d, reason: collision with root package name */
    public final ProgressBar f12930d;

    public f(View view) {
        super(view);
        View viewFindViewById = view.findViewById(R.id.tv_nombre_app);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f12927a = textView;
        View viewFindViewById2 = view.findViewById(R.id.tv_size_download);
        viewFindViewById2.getClass();
        TextView textView2 = (TextView) viewFindViewById2;
        this.f12928b = textView2;
        View viewFindViewById3 = view.findViewById(R.id.tv_date_download);
        viewFindViewById3.getClass();
        TextView textView3 = (TextView) viewFindViewById3;
        this.f12929c = textView3;
        View viewFindViewById4 = view.findViewById(R.id.progressbar_downloading);
        viewFindViewById4.getClass();
        this.f12930d = (ProgressBar) viewFindViewById4;
        textView.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
    }
}
