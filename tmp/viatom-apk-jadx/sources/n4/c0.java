package n4;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import java.util.ArrayList;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11312a;

    /* renamed from: b, reason: collision with root package name */
    public final l4.q f11313b;

    /* renamed from: c, reason: collision with root package name */
    public int f11314c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f11315d;

    public c0(MainActivity mainActivity, l4.q qVar) {
        mainActivity.getClass();
        qVar.getClass();
        this.f11312a = mainActivity;
        this.f11313b = qVar;
        this.f11315d = new ArrayList();
    }

    public final void a(int i10) {
        if (i10 > -1) {
            ArrayList arrayList = this.f11315d;
            if (i10 < arrayList.size()) {
                arrayList.remove(i10);
                this.f11314c--;
                notifyDataSetChanged();
                l4.w wVar = this.f11313b.f10746a;
                if (wVar.C.isEmpty()) {
                    return;
                }
                Object objRemove = wVar.C.remove(0);
                objRemove.getClass();
                h5.g0 g0Var = (h5.g0) objRemove;
                new c1.l(wVar, g0Var.f8558a, new i0.k(8, wVar, g0Var), LifecycleOwnerKt.getLifecycleScope(wVar));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11315d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        Object obj = this.f11315d.get(absoluteAdapterPosition);
        obj.getClass();
        h5.g0 g0Var = (h5.g0) obj;
        if (viewHolder instanceof y5.s) {
            y5.s sVar = (y5.s) viewHolder;
            sVar.f13999a.setText(g0Var.f8559b);
            j4.d0 d0VarE = j4.y.d().e(g0Var.f8560c);
            d0VarE.f(R.drawable.shape_bg_placeholder);
            float f = UptodownApp.E;
            Context context = this.f11312a;
            d0VarE.g(k4.c.y(context));
            d0VarE.e(sVar.f14001c, null);
            sVar.f14000b.setText(context.getString(R.string.preregister_available_to_download));
            sVar.f14002d.setText(context.getString(R.string.updates_button_download_app));
        }
        if (absoluteAdapterPosition > this.f11314c) {
            Context context2 = viewHolder.itemView.getContext();
            context2.getClass();
            View view = viewHolder.itemView;
            view.getClass();
            float f10 = UptodownApp.E;
            boolean z9 = true;
            try {
                SharedPreferences sharedPreferences = context2.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("animations")) {
                    z9 = sharedPreferences.getBoolean("animations", true);
                }
            } catch (Exception unused) {
            }
            if (z9) {
                float f11 = UptodownApp.E;
                view.startAnimation(AnimationUtils.loadAnimation(context2, R.anim.slide_in_bottom));
                view.setVisibility(0);
            } else {
                view.setVisibility(0);
            }
            this.f11314c = absoluteAdapterPosition;
        }
        viewHolder.itemView.setOnClickListener(new f5(14, this, g0Var));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        View viewInflate = LayoutInflater.from(this.f11312a).inflate(R.layout.floating_notification, viewGroup, false);
        viewInflate.getClass();
        return new y5.s(viewInflate);
    }
}
