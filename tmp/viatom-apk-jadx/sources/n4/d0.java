package n4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11321a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.y f11322b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f11323c;

    public d0(ArrayList arrayList, Context context, g5.y yVar) {
        arrayList.getClass();
        yVar.getClass();
        this.f11321a = context;
        this.f11322b = yVar;
        this.f11323c = new ArrayList();
        a(arrayList);
    }

    public final void a(ArrayList arrayList) {
        this.f11323c = new ArrayList();
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            this.f11323c.add((h5.g0) next);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11323c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        return i10 == this.f11323c.size() ? 4 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        if (!(viewHolder instanceof y5.u0)) {
            if (viewHolder instanceof y5.f1) {
                ((y5.f1) viewHolder).a();
                return;
            } else {
                if (viewHolder instanceof y5.h0) {
                    return;
                }
                com.google.gson.internal.a.n("ViewHolder unknown!!");
                return;
            }
        }
        y5.u0 u0Var = (y5.u0) viewHolder;
        Object obj = this.f11323c.get(i10);
        obj.getClass();
        h5.g0 g0Var = (h5.g0) obj;
        j4.d0 d0VarE = j4.y.d().e(g0Var.f8560c);
        d0VarE.f(R.drawable.shape_bg_placeholder);
        float f = UptodownApp.E;
        Context context = u0Var.f14026b;
        d0VarE.g(k4.c.y(context));
        d5.j jVar = u0Var.f14025a;
        ImageView imageView = (ImageView) jVar.f;
        TextView textView = (TextView) jVar.f7135c;
        d0VarE.e(imageView, null);
        ((TextView) jVar.e).setText(g0Var.f8559b);
        ((TextView) jVar.f7136d).setText(g0Var.f8561d);
        if (u0Var.f14028d) {
            textView.setText(context.getString(R.string.cancel_registration));
            l5.H(textView);
        } else {
            textView.setText(context.getString(R.string.pre_registration_title));
            l5.E(textView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        if (i10 != 0) {
            if (i10 != 4) {
                com.google.gson.internal.a.n("viewType unknown");
                return null;
            }
            View viewB = c.i.b(viewGroup, R.layout.pb_loading_more_content, viewGroup, false);
            viewB.getClass();
            return new y5.h0(viewB);
        }
        Context context = this.f11321a;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.preregistration_item, viewGroup, false);
        int i11 = R.id.iv_icon_upcoming_release_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewInflate, R.id.iv_icon_upcoming_release_item);
        if (imageView != null) {
            i11 = R.id.ll_upcoming_release;
            if (((LinearLayout) ViewBindings.findChildViewById(viewInflate, R.id.ll_upcoming_release)) != null) {
                i11 = R.id.rl_container_upcoming_release_item;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(viewInflate, R.id.rl_container_upcoming_release_item);
                if (relativeLayout != null) {
                    i11 = R.id.tv_action_upcoming_release_item;
                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_action_upcoming_release_item);
                    if (textView != null) {
                        i11 = R.id.tv_author_upcoming_release_item;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_author_upcoming_release_item);
                        if (textView2 != null) {
                            i11 = R.id.tv_name_upcoming_release_item;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, R.id.tv_name_upcoming_release_item);
                            if (textView3 != null) {
                                return new y5.u0(new d5.j((RelativeLayout) viewInflate, imageView, relativeLayout, textView, textView2, textView3, 5), context, this.f11322b);
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i11)));
        return null;
    }
}
