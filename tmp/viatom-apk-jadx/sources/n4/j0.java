package n4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11384a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11385b;

    /* renamed from: c, reason: collision with root package name */
    public final g5.o f11386c;

    public j0(ArrayList arrayList, Context context, g5.o oVar) {
        this.f11384a = arrayList;
        this.f11385b = context;
        this.f11386c = oVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11384a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        y5.b1 b1Var = (y5.b1) viewHolder;
        b1Var.getClass();
        Object obj = this.f11384a.get(i10);
        obj.getClass();
        h5.f fVar = (h5.f) obj;
        ImageView imageView = b1Var.e;
        Context context = this.f11385b;
        context.getClass();
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            String str = fVar.f8526c;
            str.getClass();
            ApplicationInfo applicationInfo = l5.a.f(packageManager, str, 0).applicationInfo;
            if (applicationInfo != null) {
                imageView.setImageDrawable(applicationInfo.loadIcon(context.getPackageManager()));
            }
        } catch (Exception e) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_uptodown_logo_disabled));
            e.printStackTrace();
        }
        b1Var.f13816b.setText(fVar.f8525b);
        b1Var.f13817c.setText(fVar.e);
        b1Var.f13818d.setText(l1.b.M(context, fVar.f8533n));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        viewGroup.getClass();
        View viewInflate = LayoutInflater.from(this.f11385b).inflate(R.layout.rollback_item, viewGroup, false);
        viewInflate.getClass();
        return new y5.b1(viewInflate, this.f11386c);
    }
}
