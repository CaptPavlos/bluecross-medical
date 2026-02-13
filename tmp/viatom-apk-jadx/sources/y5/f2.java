package y5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import j$.util.concurrent.ConcurrentHashMap;
import l4.o9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f2 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f13862a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(View view, o9 o9Var) {
        super(view);
        o9Var.getClass();
        View viewFindViewById = view.findViewById(R.id.ll_no_tracking_container_updates);
        viewFindViewById.getClass();
        this.f13862a = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_no_tracking_msg_updates);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_gdpr_set_up_updates);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        textView.setTypeface(o4.b.f11720s);
        ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
        textView.setText(v5.n.a(view.getContext().getString(R.string.gdpr_no_tracking_enabled)));
        textView2.setTypeface(o4.b.f11719r);
        textView2.setOnClickListener(new p(o9Var, 7));
    }
}
