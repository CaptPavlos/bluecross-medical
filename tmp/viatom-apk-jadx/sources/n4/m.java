package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.c f11430a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.a f11431b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f11432c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11433d;

    public m(g5.j jVar, g5.a aVar) {
        jVar.getClass();
        aVar.getClass();
        this.f11430a = jVar;
        this.f11431b = aVar;
        this.f11432c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11432c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        if (!(viewHolder instanceof k)) {
            if (viewHolder instanceof l) {
                int i11 = i10 + 1;
                if (kotlin.jvm.internal.l.a(this.f11432c.get(i10), t6.l.i0(this.f11432c))) {
                    Object obj = this.f11432c.get(i10);
                    obj.getClass();
                    ((l) viewHolder).g((h5.h) obj, i11, i10, true);
                    return;
                } else {
                    Object obj2 = this.f11432c.get(i10);
                    obj2.getClass();
                    ((l) viewHolder).g((h5.h) obj2, i11, i10, false);
                    return;
                }
            }
            return;
        }
        k kVar = (k) viewHolder;
        Object obj3 = this.f11432c.get(i10);
        obj3.getClass();
        h5.h hVar = (h5.h) obj3;
        ImageView imageView = kVar.e;
        TextView textView = kVar.h;
        ImageView imageView2 = kVar.f11402d;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        View view = kVar.itemView;
        Context context = view.getContext();
        context.getClass();
        y5.f.a(layoutParams, context, i10 + 1, 20);
        view.setLayoutParams(layoutParams);
        String strE = hVar.e();
        if (strE == null || strE.length() == 0) {
            com.mbridge.msdk.dycreator.baseview.a.p(kVar.itemView, R.drawable.shape_bg_placeholder, imageView2);
        } else {
            j4.d0 d0VarE = j4.y.d().e(hVar.f());
            float f = UptodownApp.E;
            Context context2 = kVar.itemView.getContext();
            context2.getClass();
            d0VarE.g(k4.c.x(context2));
            j4.c0 c0Var = d0VarE.f9930b;
            c0Var.f = true;
            c0Var.g = 17;
            d0VarE.f9931c = true;
            d0VarE.f(R.drawable.shape_bg_placeholder);
            d0VarE.e(imageView2, null);
        }
        View view2 = kVar.itemView;
        view2.getClass();
        y5.f.b(view2, kVar.f11400b, hVar);
        kVar.itemView.setOnLongClickListener(new b5.c(kVar, hVar, i10, 3));
        TextView textView2 = kVar.g;
        textView2.getClass();
        textView.getClass();
        y5.f.f(hVar, textView2, textView);
        imageView.getClass();
        kVar.e(imageView, hVar.i());
        kVar.c(hVar, kVar.f, imageView, textView, kVar.f11404j, kVar.f11403i, kVar.f11405k);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        boolean z9 = this.f11433d;
        g5.a aVar = this.f11431b;
        g5.c cVar = this.f11430a;
        if (z9) {
            View viewB = c.i.b(viewGroup, R.layout.home_card_top_featured_item, viewGroup, false);
            viewB.getClass();
            return new l(viewB, cVar, aVar);
        }
        View viewB2 = c.i.b(viewGroup, R.layout.home_card_featured_item, viewGroup, false);
        viewB2.getClass();
        return new k(viewB2, cVar, aVar);
    }
}
