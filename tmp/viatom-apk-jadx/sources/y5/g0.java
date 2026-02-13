package y5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f13865a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f13866b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f13867c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13868d;

    public g0(View view) {
        super(view);
        View viewFindViewById = view.findViewById(R.id.rl_old_versions_footer);
        viewFindViewById.getClass();
        this.f13865a = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.rl_back_versions);
        viewFindViewById2.getClass();
        this.f13866b = (RelativeLayout) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.rl_forward_versions);
        viewFindViewById3.getClass();
        this.f13867c = (RelativeLayout) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.tv_current_page_versions);
        viewFindViewById4.getClass();
        TextView textView = (TextView) viewFindViewById4;
        this.f13868d = textView;
        textView.setTypeface(o4.b.f11719r);
    }
}
