package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11293a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f11294b;

    public a(ArrayList arrayList, d0.i iVar) {
        iVar.getClass();
        this.f11293a = arrayList;
        this.f11294b = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f11293a;
        if (arrayList == null) {
            return 0;
        }
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        y5.b bVar = (y5.b) viewHolder;
        bVar.getClass();
        ArrayList arrayList = this.f11293a;
        h5.w wVar = arrayList != null ? (h5.w) arrayList.get(i10) : null;
        wVar.getClass();
        bVar.f13808b.setOnClickListener(new f5(21, bVar, wVar));
        String strA = wVar.a();
        if (strA != null) {
            bVar.f13809c.setText(strA.substring(o7.m.m0(".", strA, 6) + 1));
        }
        bVar.f13810d.setText(wVar.a());
        TextView textView = bVar.e;
        long j10 = wVar.f8782b;
        Context context = bVar.itemView.getContext();
        context.getClass();
        textView.setText(l1.b.M(context, j10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.app_file_item, viewGroup, false);
        viewG.getClass();
        d0.i iVar = this.f11294b;
        iVar.getClass();
        y5.b bVar = new y5.b(viewG);
        bVar.f13807a = iVar;
        View viewFindViewById = viewG.findViewById(R.id.rl_app_file_item);
        viewFindViewById.getClass();
        bVar.f13808b = (RelativeLayout) viewFindViewById;
        View viewFindViewById2 = viewG.findViewById(R.id.tv_type_app_file_item);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        bVar.f13809c = textView;
        View viewFindViewById3 = viewG.findViewById(R.id.tv_name_app_file_item);
        viewFindViewById3.getClass();
        TextView textView2 = (TextView) viewFindViewById3;
        bVar.f13810d = textView2;
        View viewFindViewById4 = viewG.findViewById(R.id.tv_size_app_file_item);
        viewFindViewById4.getClass();
        TextView textView3 = (TextView) viewFindViewById4;
        bVar.e = textView3;
        textView.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11719r);
        textView3.setTypeface(o4.b.f11720s);
        return bVar;
    }
}
