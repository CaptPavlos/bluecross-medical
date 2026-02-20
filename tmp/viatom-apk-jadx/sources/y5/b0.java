package y5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.j f13811a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f13812b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13813c;

    /* renamed from: d, reason: collision with root package name */
    public final n4.r0 f13814d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(View view, g5.j jVar, g5.a aVar) {
        super(view);
        jVar.getClass();
        aVar.getClass();
        this.f13811a = jVar;
        View viewFindViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        viewFindViewById.getClass();
        this.f13812b = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f13813c = textView;
        View viewFindViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        viewFindViewById3.getClass();
        RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        n4.r0 r0Var = new n4.r0(jVar, aVar);
        this.f13814d = r0Var;
        textView.setTypeface(o4.b.f11719r);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(r0Var);
    }
}
