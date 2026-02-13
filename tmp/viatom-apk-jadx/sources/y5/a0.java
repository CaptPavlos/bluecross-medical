package y5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.j f13798a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f13799b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f13800c;

    /* renamed from: d, reason: collision with root package name */
    public final n4.j f13801d;
    public final LinearLayout e;
    public final x5.b f;
    public boolean g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(View view, g5.j jVar, g5.a aVar, g5.m mVar) throws IllegalStateException {
        super(view);
        aVar.getClass();
        mVar.getClass();
        this.f13798a = jVar;
        View viewFindViewById = view.findViewById(R.id.tv_title_header);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f13799b = textView;
        View viewFindViewById2 = view.findViewById(R.id.rv_home_features);
        viewFindViewById2.getClass();
        RecyclerView recyclerView = (RecyclerView) viewFindViewById2;
        this.f13800c = recyclerView;
        n4.j jVar2 = new n4.j(jVar, aVar);
        this.f13801d = jVar2;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        View viewFindViewById3 = view.findViewById(R.id.ll_categories);
        viewFindViewById3.getClass();
        this.e = (LinearLayout) viewFindViewById3;
        x5.b bVar = new x5.b();
        this.f = bVar;
        this.h = 102;
        textView.setTypeface(o4.b.f11719r);
        bVar.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(jVar2);
        recyclerView.addOnScrollListener(new z(this, mVar));
        recyclerView.post(new y(0, this, mVar));
    }
}
