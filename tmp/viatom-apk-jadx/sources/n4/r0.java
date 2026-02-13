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
public final class r0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.c f11472a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.a f11473b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11474c;

    public r0(g5.j jVar, g5.a aVar) {
        jVar.getClass();
        aVar.getClass();
        this.f11472a = jVar;
        this.f11473b = aVar;
        this.f11474c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11474c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        q0 q0Var = (q0) viewHolder;
        Object obj = this.f11474c.get(i10);
        obj.getClass();
        h5.h hVar = (h5.h) obj;
        int i11 = i10 + 1;
        RelativeLayout relativeLayout = q0Var.f11468k;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i11 >= 10) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginStart((int) q0Var.itemView.getContext().getResources().getDimension(R.dimen.top_card_margin_index_ten));
            relativeLayout.setLayoutParams(layoutParams2);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.setMarginStart((int) q0Var.itemView.getContext().getResources().getDimension(R.dimen.top_download_horizontal_card_margin));
            relativeLayout.setLayoutParams(layoutParams3);
        }
        View view = q0Var.itemView;
        Context context = view.getContext();
        context.getClass();
        y5.f.a(layoutParams, context, i11, 20);
        view.setLayoutParams(layoutParams);
        q0Var.f.setText(String.valueOf(i11));
        View view2 = q0Var.itemView;
        view2.getClass();
        y5.f.b(view2, q0Var.f11463b, hVar);
        q0Var.itemView.setOnLongClickListener(new b5.c(q0Var.f11469l, hVar, i10, 5));
        y5.f.f(hVar, q0Var.e, q0Var.g);
        q0Var.e(q0Var.f11464c, hVar.h());
        q0Var.c(hVar, q0Var.f11465d, q0Var.f11464c, q0Var.g, q0Var.f11466i, q0Var.h, q0Var.f11467j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.card_top_download, viewGroup, false);
        viewG.getClass();
        return new q0(this, viewG, this.f11472a);
    }
}
