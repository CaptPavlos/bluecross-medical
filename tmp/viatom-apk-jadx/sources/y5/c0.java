package y5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.j f13827a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f13828b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13829c;

    /* renamed from: d, reason: collision with root package name */
    public final n4.t0 f13830d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(View view, g5.j jVar, g5.a aVar) {
        super(view);
        jVar.getClass();
        aVar.getClass();
        this.f13827a = jVar;
        View viewFindViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        viewFindViewById.getClass();
        this.f13828b = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f13829c = textView;
        View viewFindViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        viewFindViewById3.getClass();
        RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        n4.t0 t0Var = new n4.t0(jVar, aVar, 20);
        this.f13830d = t0Var;
        textView.setTypeface(o4.b.f11719r);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(t0Var);
    }
}
