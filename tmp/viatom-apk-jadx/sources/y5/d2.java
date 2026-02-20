package y5;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d2 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.j f13841a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f13842b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f13843c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f13844d;
    public final n4.k1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(View view, g5.j jVar, g5.a aVar, String str) throws IllegalStateException {
        super(view);
        jVar.getClass();
        aVar.getClass();
        str.getClass();
        this.f13841a = jVar;
        View viewFindViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        viewFindViewById.getClass();
        this.f13842b = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.f13843c = textView;
        View viewFindViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        viewFindViewById3.getClass();
        RecyclerView recyclerView = (RecyclerView) viewFindViewById3;
        boolean z9 = false;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.f13844d = linearLayoutManager;
        Context context = view.getContext();
        context.getClass();
        n4.k1 k1Var = new n4.k1(jVar, aVar, context, str);
        this.e = k1Var;
        new x5.b().attachToRecyclerView(recyclerView);
        textView.setTypeface(o4.b.f11719r);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(k1Var);
        Context context2 = view.getContext();
        context2.getClass();
        try {
            SharedPreferences sharedPreferences = context2.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("app_detail_inflate_view_failed")) {
                z9 = sharedPreferences.getBoolean("app_detail_inflate_view_failed", false);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            return;
        }
        recyclerView.addOnScrollListener(new c2(this));
    }
}
