package n4;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11374a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11375b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.n f11376c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11377d;

    public i0(ArrayList arrayList, Context context, g5.n nVar) {
        nVar.getClass();
        this.f11374a = arrayList;
        this.f11375b = context;
        this.f11376c = nVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11374a.size() + (this.f11377d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        ArrayList arrayList = this.f11374a;
        if (i10 == arrayList.size()) {
            return 2;
        }
        return ((h5.t0) arrayList.get(i10)).b() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        if (viewHolder instanceof y5.z0) {
            Object obj = this.f11374a.get(i10);
            obj.getClass();
            h5.t0 t0Var = (h5.t0) obj;
            if (!t0Var.b()) {
                y5.z0 z0Var = (y5.z0) viewHolder;
                z0Var.a(t0Var, i10);
                ImageView imageView = z0Var.f14088m;
                Context context = z0Var.f14080a;
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                ImageView imageView2 = z0Var.f14089n;
                imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                ImageView imageView3 = z0Var.f14090o;
                imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                ImageView imageView4 = z0Var.f14091p;
                imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                ImageView imageView5 = z0Var.f14092q;
                imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                if (t0Var.g >= 2) {
                    imageView2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                }
                if (t0Var.g >= 3) {
                    imageView3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                }
                if (t0Var.g >= 4) {
                    imageView4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                }
                if (t0Var.g == 5) {
                    imageView5.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                    return;
                }
                return;
            }
            y5.z0 z0Var2 = (y5.z0) viewHolder;
            z0Var2.a(t0Var, i10);
            ImageView imageView6 = z0Var2.f14088m;
            Context context2 = z0Var2.f14080a;
            imageView6.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_star_on_turbo));
            ImageView imageView7 = z0Var2.f14089n;
            imageView7.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_star_off_turbo));
            ImageView imageView8 = z0Var2.f14090o;
            imageView8.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_star_off_turbo));
            ImageView imageView9 = z0Var2.f14091p;
            imageView9.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_star_off_turbo));
            ImageView imageView10 = z0Var2.f14092q;
            imageView10.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_star_off_turbo));
            if (t0Var.g >= 2) {
                imageView7.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_star_on_turbo));
            }
            if (t0Var.g >= 3) {
                imageView8.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_star_on_turbo));
            }
            if (t0Var.g >= 4) {
                imageView9.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_star_on_turbo));
            }
            if (t0Var.g == 5) {
                imageView10.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.vector_star_on_turbo));
            }
            z0Var2.f14093r.setVisibility(0);
            ImageView imageView11 = z0Var2.f14082c;
            imageView11.getClass();
            int dimension = (int) imageView11.getContext().getResources().getDimension(R.dimen.border_radius_xs);
            imageView11.setForeground(ContextCompat.getDrawable(imageView11.getContext(), R.drawable.shape_stroke_review_avatar_turbo));
            imageView11.setPadding(dimension, dimension, dimension, dimension);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        g5.n nVar = this.f11376c;
        Context context = this.f11375b;
        return i10 != 1 ? i10 != 2 ? new y5.z0(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.review, viewGroup, false), context, nVar) : new y5.h0(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.pb_loading_more_content, viewGroup, false)) : new y5.z0(com.mbridge.msdk.dycreator.baseview.a.x(viewGroup, R.layout.review_turbo, viewGroup, false), context, nVar);
    }
}
