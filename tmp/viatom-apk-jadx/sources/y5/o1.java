package y5;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.b f13957a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f13958b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13959c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13960d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    public o1(View view, g5.b bVar) {
        super(view);
        this.f13957a = bVar;
        View viewFindViewById = view.findViewById(R.id.iv_icon_installed_app_item);
        viewFindViewById.getClass();
        this.f13958b = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_name_installed_app_item);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f13959c = textView;
        View viewFindViewById3 = view.findViewById(R.id.tv_version_installed_app_item);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        this.f13960d = textView2;
        View viewFindViewById4 = view.findViewById(R.id.tv_size_installed_app_item);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        this.e = textView3;
        View viewFindViewById5 = view.findViewById(R.id.tv_last_update_installed_app_item);
        viewFindViewById5.getClass();
        TextView textView4 = (TextView) viewFindViewById5;
        this.f = textView4;
        View viewFindViewById6 = view.findViewById(R.id.tv_excluded_installed_app_item);
        viewFindViewById6.getClass();
        TextView textView5 = (TextView) viewFindViewById6;
        this.g = textView5;
        View viewFindViewById7 = view.findViewById(R.id.rl_installed_app_item);
        viewFindViewById7.getClass();
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11719r);
        textView3.setTypeface(o4.b.f11720s);
        textView4.setTypeface(o4.b.f11720s);
        textView5.setTypeface(o4.b.f11719r);
        ((RelativeLayout) viewFindViewById7).setOnClickListener(new p(this, 2));
    }
}
