package n4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public g5.j f11438a;

    /* renamed from: b, reason: collision with root package name */
    public g5.a f11439b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f11440c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11440c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        TextView textView;
        LinearLayout linearLayout;
        y5.c cVar = (y5.c) viewHolder;
        cVar.getClass();
        Object obj = this.f11440c.get(i10);
        obj.getClass();
        h5.h hVar = (h5.h) obj;
        RelativeLayout relativeLayout = cVar.f13823d;
        y5.f.b(relativeLayout, cVar.f13821b, hVar);
        relativeLayout.setOnLongClickListener(new b5.c(cVar, hVar, i10, 7));
        TextView textView2 = cVar.f;
        TextView textView3 = cVar.g;
        y5.f.f(hVar, textView2, textView3);
        cVar.e(cVar.e, hVar.i());
        ProgressBar progressBar = cVar.f13824i;
        if (progressBar == null || (textView = cVar.f13825j) == null || (linearLayout = cVar.f13826k) == null) {
            cVar.d(hVar.f8595w, cVar.h, textView3);
        } else {
            cVar.c(hVar, progressBar, cVar.e, cVar.g, textView, cVar.h, linearLayout);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.app_info_item_small, viewGroup, false);
        viewG.getClass();
        return new y5.c(viewG, this.f11438a, this.f11439b);
    }
}
