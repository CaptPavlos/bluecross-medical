package n4;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import y5.y1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11316a;

    /* renamed from: b, reason: collision with root package name */
    public final i0.k f11317b;

    public c1(ArrayList arrayList, i0.k kVar) {
        this.f11316a = arrayList;
        this.f11317b = kVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11316a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        y1 y1Var = (y1) viewHolder;
        y1Var.getClass();
        Object obj = this.f11316a.get(i10);
        obj.getClass();
        h5.h1 h1Var = (h5.h1) obj;
        d5.d1 d1Var = y1Var.f14076a;
        TextView textView = d1Var.f;
        ImageView imageView = d1Var.f6984c;
        textView.setText(h1Var.f8607c);
        TextView textView2 = d1Var.e;
        long j10 = h1Var.h;
        textView2.setText(j10 <= 0 ? null : new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j10)));
        int i11 = h1Var.f;
        if (i11 == 0) {
            com.mbridge.msdk.dycreator.baseview.a.p(y1Var.itemView, R.drawable.vector_user_device_mobile_item, imageView);
        } else if (i11 == 1) {
            com.mbridge.msdk.dycreator.baseview.a.p(y1Var.itemView, R.drawable.vector_user_device_tablet_item, imageView);
        } else {
            if (i11 != 2) {
                return;
            }
            com.mbridge.msdk.dycreator.baseview.a.p(y1Var.itemView, R.drawable.vector_user_device_tv_item, imageView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        return new y1(d5.d1.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_device_item, viewGroup, false)), this.f11317b);
    }
}
