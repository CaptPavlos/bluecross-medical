package u5;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f12931a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f12932b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f12933c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f12934d;
    public final TextView e;
    public final ProgressBar f;
    public final TextView g;

    public g(View view) {
        super(view);
        View viewFindViewById = view.findViewById(R.id.rl_tv_old_version_item);
        viewFindViewById.getClass();
        this.f12931a = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.iv_icono_version);
        viewFindViewById2.getClass();
        this.f12932b = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_name_version);
        viewFindViewById3.getClass();
        TextView textView = (TextView) viewFindViewById3;
        this.f12933c = textView;
        View viewFindViewById4 = view.findViewById(R.id.tv_size_version);
        viewFindViewById4.getClass();
        TextView textView2 = (TextView) viewFindViewById4;
        this.f12934d = textView2;
        View viewFindViewById5 = view.findViewById(R.id.tv_version);
        viewFindViewById5.getClass();
        TextView textView3 = (TextView) viewFindViewById5;
        this.e = textView3;
        View viewFindViewById6 = view.findViewById(R.id.progressbar_downloading_version);
        viewFindViewById6.getClass();
        this.f = (ProgressBar) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.tv_action_old_version_item);
        viewFindViewById7.getClass();
        TextView textView4 = (TextView) viewFindViewById7;
        this.g = textView4;
        textView.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
    }
}
