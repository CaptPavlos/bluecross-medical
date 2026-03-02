package r4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import b5.e;
import com.uptodown.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final t4.c f12378a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f12379b;

    public c(ArrayList arrayList, t4.c cVar) {
        this.f12378a = cVar;
        this.f12379b = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f12379b;
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        e eVar = (e) viewHolder;
        eVar.getClass();
        CheckBox checkBox = eVar.f853a;
        ArrayList arrayList = this.f12379b;
        arrayList.getClass();
        checkBox.setText(((u4.e) arrayList.get(i10)).e);
        checkBox.setChecked(((u4.e) arrayList.get(i10)).f12905b);
        checkBox.setEnabled(((u4.e) arrayList.get(i10)).f12907d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.split_item, viewGroup, false);
        viewG.getClass();
        t4.c cVar = this.f12378a;
        cVar.getClass();
        e eVar = new e(viewG);
        View viewFindViewById = viewG.findViewById(R.id.cb_split_item);
        viewFindViewById.getClass();
        CheckBox checkBox = (CheckBox) viewFindViewById;
        eVar.f853a = checkBox;
        viewG.setOnClickListener(new b5.a(2, eVar, cVar));
        checkBox.setTypeface(o4.b.f11720s);
        return eVar;
    }
}
