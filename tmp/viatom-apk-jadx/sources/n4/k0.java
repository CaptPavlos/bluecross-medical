package n4;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.views.FullHeightImageView;
import h5.l1;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11406a;

    /* renamed from: b, reason: collision with root package name */
    public final w2.r f11407b;

    public k0(ArrayList arrayList, w2.r rVar) {
        this.f11406a = arrayList;
        this.f11407b = rVar;
    }

    public final void a(Object obj) {
        ArrayList arrayList = this.f11406a;
        Integer numValueOf = arrayList != null ? Integer.valueOf(arrayList.indexOf(obj)) : null;
        if (numValueOf == null || numValueOf.intValue() == -1) {
            return;
        }
        if (arrayList != null) {
            arrayList.remove(numValueOf.intValue());
        }
        notifyItemRemoved(numValueOf.intValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f11406a;
        if (arrayList == null) {
            return 0;
        }
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        ArrayList arrayList = this.f11406a;
        return (arrayList != null ? arrayList.get(i10) : null) instanceof l1 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        Object obj;
        int i11;
        y5.c1 c1Var = (y5.c1) viewHolder;
        c1Var.getClass();
        ArrayList arrayList = this.f11406a;
        if ((arrayList != null ? arrayList.get(i10) : null) instanceof l1) {
            obj = arrayList != null ? arrayList.get(i10) : null;
            obj.getClass();
            l1 l1Var = (l1) obj;
            c1Var.itemView.setOnClickListener(new y5.i0(2, c1Var, l1Var));
            j4.d0 d0VarE = j4.y.d().e(l1Var.a());
            float f = UptodownApp.E;
            Context context = c1Var.itemView.getContext();
            context.getClass();
            d0VarE.g(k4.c.x(context));
            View view = c1Var.itemView;
            view.getClass();
            d0VarE.e((FullHeightImageView) view, new t1.c(c1Var, l1Var, 14, false));
            return;
        }
        obj = arrayList != null ? arrayList.get(i10) : null;
        obj.getClass();
        h5.u0 u0Var = (h5.u0) obj;
        c1Var.itemView.setOnClickListener(new y5.i0(3, c1Var, u0Var));
        View view2 = c1Var.itemView;
        view2.getClass();
        ((FullHeightImageView) view2).setMinimumWidth(c1Var.f13832b);
        j4.d0 d0VarE2 = j4.y.d().e(u0Var.a());
        float f10 = UptodownApp.E;
        Context context2 = c1Var.itemView.getContext();
        context2.getClass();
        String str = "1";
        try {
            SharedPreferences sharedPreferences = context2.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("data_saver_options")) {
                String string = sharedPreferences.getString("data_saver_options", "1");
                string.getClass();
                str = string;
            }
        } catch (Exception unused) {
        }
        d0VarE2.g((Integer.parseInt(str) <= 0 || ((i11 = a.a.f1b) != 0 && (!a.a.f0a || (!a.a.f3d && i11 < 4300)))) ? new z5.f((int) context2.getResources().getDimension(R.dimen.border_radius_xs)) : new z5.f((int) context2.getResources().getDimension(R.dimen.border_radius_s)));
        View view3 = c1Var.itemView;
        view3.getClass();
        d0VarE2.e((FullHeightImageView) view3, new t1.c(c1Var, u0Var, 13, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.screenshot_item, viewGroup, false);
        viewG.getClass();
        w2.r rVar = this.f11407b;
        rVar.getClass();
        y5.c1 c1Var = new y5.c1(viewG);
        c1Var.f13831a = rVar;
        return c1Var;
    }
}
