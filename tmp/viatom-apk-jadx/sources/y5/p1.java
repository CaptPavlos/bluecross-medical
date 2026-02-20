package y5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import l4.o9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final o9 f13965a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f13966b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f13967c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f13968d;
    public final TextView e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(View view, o9 o9Var) {
        super(view);
        o9Var.getClass();
        this.f13965a = o9Var;
        View viewFindViewById = view.findViewById(R.id.tv_updates_available_updates_header);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f13966b = textView;
        View viewFindViewById2 = view.findViewById(R.id.ll_no_pending_updates_header);
        viewFindViewById2.getClass();
        this.f13967c = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.tv_last_check_updates_header);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        this.f13968d = textView2;
        View viewFindViewById4 = view.findViewById(R.id.tv_check_updates_header);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        this.e = textView3;
        textView.setTypeface(o4.b.f11719r);
        textView2.setTypeface(o4.b.f11720s);
        textView3.setTypeface(o4.b.f11719r);
    }
}
