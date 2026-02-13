package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import y5.w1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11307a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.b f11308b;

    public b1(ArrayList arrayList, g5.b bVar) {
        arrayList.getClass();
        bVar.getClass();
        this.f11307a = arrayList;
        this.f11308b = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11307a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        w1 w1Var = (w1) viewHolder;
        w1Var.getClass();
        Object obj = this.f11307a.get(i10);
        obj.getClass();
        h5.g1 g1Var = (h5.g1) obj;
        d5.d1 d1Var = w1Var.f14060a;
        d1Var.f.setText(g1Var.f8562a);
        TextView textView = d1Var.e;
        long j10 = g1Var.f8564c;
        textView.setText(j10 <= 0 ? null : new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j10)));
        j4.d0 d0VarE = j4.y.d().e(g1Var.f8565d);
        float f = UptodownApp.E;
        Context context = w1Var.itemView.getContext();
        context.getClass();
        d0VarE.g(k4.c.y(context));
        d0VarE.e(d1Var.f6985d, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.user_device_app_item, viewGroup, false);
        int i11 = R.id.iv_action_user_device_app_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_action_user_device_app_item);
        if (imageView != null) {
            i11 = R.id.iv_icon_user_device_app_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(viewG, R.id.iv_icon_user_device_app_item);
            if (imageView2 != null) {
                i11 = R.id.ll_info_user_device_app_item;
                if (((LinearLayout) ViewBindings.findChildViewById(viewG, R.id.ll_info_user_device_app_item)) != null) {
                    i11 = R.id.rl_container_user_device_app_item;
                    if (((RelativeLayout) ViewBindings.findChildViewById(viewG, R.id.rl_container_user_device_app_item)) != null) {
                        i11 = R.id.tv_last_update_user_device_app_item;
                        TextView textView = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_last_update_user_device_app_item);
                        if (textView != null) {
                            i11 = R.id.tv_name_user_device_app_item;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(viewG, R.id.tv_name_user_device_app_item);
                            if (textView2 != null) {
                                return new w1(new d5.d1((RelativeLayout) viewG, imageView, imageView2, textView, textView2, 0), this.f11308b);
                            }
                        }
                    }
                }
            }
        }
        androidx.window.layout.c.k("Missing required view with ID: ".concat(viewG.getResources().getResourceName(i11)));
        return null;
    }
}
