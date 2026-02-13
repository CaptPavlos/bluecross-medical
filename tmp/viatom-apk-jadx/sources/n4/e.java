package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11328a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.b f11329b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f11330c;

    public e(ArrayList arrayList, Context context, g5.b bVar) {
        bVar.getClass();
        this.f11328a = context;
        this.f11329b = bVar;
        this.f11330c = arrayList;
        notifyDataSetChanged();
    }

    public final ArrayList a() {
        ArrayList arrayList = this.f11330c;
        if (arrayList != null) {
            return arrayList;
        }
        kotlin.jvm.internal.l.i(DataSchemeDataSource.SCHEME_DATA);
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return a().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        if (!(viewHolder instanceof y5.w)) {
            com.google.gson.internal.a.n("ViewHolder unknown!!");
            return;
        }
        y5.w wVar = (y5.w) viewHolder;
        Object obj = a().get(i10);
        obj.getClass();
        h5.f fVar = (h5.f) obj;
        wVar.e.setText(fVar.f8525b);
        TextView textView = wVar.f;
        Context context = wVar.f14050c;
        context.getClass();
        textView.setText(l1.b.M(context, fVar.f8533n));
        ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
        wVar.f14051d.setImageDrawable(v5.n.c(context, fVar.f8526c));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.free_up_item, viewGroup, false);
        viewG.getClass();
        return new y5.w(viewG, this.f11329b, this.f11328a);
    }
}
