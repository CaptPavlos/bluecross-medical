package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.c f11486a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.a f11487b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11488c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f11489d;

    public t0(g5.c cVar, g5.a aVar, int i10) {
        cVar.getClass();
        aVar.getClass();
        this.f11486a = cVar;
        this.f11487b = aVar;
        this.f11488c = i10;
        this.f11489d = new ArrayList();
    }

    public final void a(ArrayList arrayList) {
        arrayList.getClass();
        ArrayList arrayList2 = this.f11489d;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11489d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        s0 s0Var = (s0) viewHolder;
        Object obj = this.f11489d.get(i10);
        obj.getClass();
        h5.h hVar = (h5.h) obj;
        int i11 = i10 + 1;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) s0Var.itemView.getContext().getResources().getDimension(R.dimen.top_horizontal_card_width), -2);
        View view = s0Var.itemView;
        Context context = view.getContext();
        context.getClass();
        t0 t0Var = s0Var.f11483j;
        y5.f.a(layoutParams, context, i11, t0Var.f11488c);
        view.setLayoutParams(layoutParams);
        View view2 = s0Var.itemView;
        view2.getClass();
        y5.f.b(view2, s0Var.f11479b, hVar);
        s0Var.itemView.setOnLongClickListener(new b5.c(t0Var, hVar, i11, 6));
        y5.f.f(hVar, s0Var.e, s0Var.f);
        s0Var.e(s0Var.f11480c, hVar.h());
        s0Var.c(hVar, s0Var.f11481d, s0Var.f11480c, s0Var.f, s0Var.g, s0Var.f11482i, s0Var.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.card, viewGroup, false);
        viewG.getClass();
        return new s0(this, viewG, this.f11486a);
    }
}
