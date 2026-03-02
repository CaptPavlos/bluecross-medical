package n4;

import android.content.Context;
import android.view.LayoutInflater;
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
public final class g0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11347a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.b f11348b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11349c;

    public g0(ArrayList arrayList, g5.b bVar) {
        arrayList.getClass();
        this.f11347a = arrayList;
        this.f11348b = bVar;
        this.f11349c = arrayList.size() - 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11347a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        f0 f0Var = (f0) viewHolder;
        f0Var.getClass();
        Object obj = this.f11347a.get(i10);
        obj.getClass();
        h5.h hVar = (h5.h) obj;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        d5.j jVar = f0Var.f11339b;
        RelativeLayout relativeLayout = (RelativeLayout) jVar.f7134b;
        Context context = f0Var.itemView.getContext();
        context.getClass();
        y5.f.a(layoutParams, context, i10, f0Var.f11341d.f11349c);
        relativeLayout.setLayoutParams(layoutParams);
        j4.d0 d0VarE = j4.y.d().e(hVar.f8575l);
        d0VarE.f(R.drawable.shape_bg_placeholder);
        float f = UptodownApp.E;
        Context context2 = f0Var.itemView.getContext();
        context2.getClass();
        d0VarE.g(k4.c.y(context2));
        d0VarE.e((ImageView) jVar.g, null);
        j4.d0 d0VarE2 = j4.y.d().e(hVar.f());
        d0VarE2.f(R.drawable.shape_bg_placeholder);
        j4.c0 c0Var = d0VarE2.f9930b;
        c0Var.f = true;
        c0Var.g = 17;
        d0VarE2.f9931c = true;
        Context context3 = f0Var.itemView.getContext();
        context3.getClass();
        d0VarE2.g(k4.c.x(context3));
        d0VarE2.e((ImageView) jVar.f, null);
        ((TextView) jVar.f7136d).setText(hVar.f8567b);
        ((TextView) jVar.f7135c).setText(hVar.f);
        ((RelativeLayout) jVar.f7134b).setOnClickListener(new e0(f0Var, i10, 0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        return new f0(this, d5.j.f(LayoutInflater.from(viewGroup.getContext()), null), this.f11348b);
    }
}
