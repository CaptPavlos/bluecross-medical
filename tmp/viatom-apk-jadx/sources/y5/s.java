package y5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f13999a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f14000b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f14001c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f14002d;

    public s(View view) {
        super(view);
        View viewFindViewById = view.findViewById(R.id.tv_name_app_fn);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f13999a = textView;
        View viewFindViewById2 = view.findViewById(R.id.tv_desc_app_fn);
        viewFindViewById2.getClass();
        TextView textView2 = (TextView) viewFindViewById2;
        this.f14000b = textView2;
        View viewFindViewById3 = view.findViewById(R.id.iv_logo_app_fn);
        viewFindViewById3.getClass();
        this.f14001c = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_install_fn);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        this.f14002d = textView3;
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11719r);
    }
}
