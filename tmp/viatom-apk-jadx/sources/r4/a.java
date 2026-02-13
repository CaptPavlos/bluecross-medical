package r4;

import android.net.nsd.NsdServiceInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import l4.n5;
import o7.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f12372a;

    /* renamed from: b, reason: collision with root package name */
    public n5 f12373b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f12372a;
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        b5.b bVar = (b5.b) viewHolder;
        bVar.getClass();
        TextView textView = bVar.f845a;
        ArrayList arrayList = this.f12372a;
        arrayList.getClass();
        String serviceName = ((NsdServiceInfo) arrayList.get(i10)).getServiceName();
        serviceName.getClass();
        textView.setText(serviceName.substring(0, m.k0(serviceName, "_d:_", 0, false, 6)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        View viewX = com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.device_item, viewGroup, false);
        n5 n5Var = this.f12373b;
        b5.b bVar = new b5.b(viewX);
        View viewFindViewById = viewX.findViewById(R.id.tv_device_name);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        bVar.f845a = textView;
        viewX.setOnClickListener(new b5.a(0, n5Var, bVar));
        textView.setTypeface(o4.b.f11720s);
        return bVar;
    }
}
