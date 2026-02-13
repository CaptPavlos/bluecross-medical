package n4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11460a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11461b;

    /* renamed from: c, reason: collision with root package name */
    public final d0.i f11462c;

    public q(ArrayList arrayList, Context context, d0.i iVar) {
        iVar.getClass();
        this.f11460a = arrayList;
        this.f11461b = context;
        this.f11462c = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11460a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        y5.n0 n0Var = (y5.n0) viewHolder;
        n0Var.getClass();
        Object obj = this.f11460a.get(i10);
        obj.getClass();
        h5.b0 b0Var = (h5.b0) obj;
        n0Var.f13945b.setText(b0Var.f8474c);
        n0Var.f13946c.setText(b0Var.f8475d);
        String str = b0Var.f8473b;
        str.getClass();
        Date date = new Date(Long.parseLong(str));
        n0Var.f.setText(DateFormat.getDateTimeInstance().format(Long.valueOf(date.getTime())));
        String str2 = b0Var.e;
        TextView textView = n0Var.f13947d;
        textView.setVisibility(8);
        TextView textView2 = n0Var.e;
        textView2.setVisibility(8);
        if (str2 == null || o7.m.d0(str2, "no_action", false)) {
            return;
        }
        List listS0 = o7.m.s0(str2, new String[]{";"});
        int size = listS0.size();
        if (size == 1) {
            textView.setText(n0Var.a((String) listS0.get(0)));
            textView.setVisibility(0);
        } else {
            if (size != 2) {
                return;
            }
            textView.setText(n0Var.a((String) listS0.get(0)));
            textView2.setText(n0Var.a((String) listS0.get(1)));
            textView.setVisibility(0);
            textView2.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        View viewInflate = LayoutInflater.from(this.f11461b).inflate(R.layout.notification_registry_item, viewGroup, false);
        viewInflate.getClass();
        return new y5.n0(viewInflate, this.f11462c);
    }
}
