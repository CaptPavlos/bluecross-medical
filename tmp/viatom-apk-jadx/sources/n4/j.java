package n4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final g5.j f11381a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.a f11382b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11383c;

    public j(g5.j jVar, g5.a aVar) {
        aVar.getClass();
        this.f11381a = jVar;
        this.f11382b = aVar;
        this.f11383c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11383c.size() * 100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        String strO;
        i iVar = (i) viewHolder;
        iVar.getClass();
        ArrayList arrayList = this.f11383c;
        int size = i10 % arrayList.size();
        Object obj = arrayList.get(size);
        obj.getClass();
        h5.h hVar = (h5.h) obj;
        ImageView imageView = iVar.f11372c;
        TextView textView = iVar.f11373d;
        float f = UptodownApp.E;
        int i11 = UptodownApp.S;
        int dimension = (int) iVar.itemView.getContext().getResources().getDimension(R.dimen.margin_s);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i11, -2);
        layoutParams.setMargins(dimension, 0, dimension, 0);
        iVar.itemView.setLayoutParams(layoutParams);
        int i12 = 2;
        if (hVar.f8589s0 != h5.g.f) {
            textView.setText(hVar.f8587r0);
            textView.setVisibility(0);
            textView.setTextColor(ContextCompat.getColor(iVar.itemView.getContext(), R.color.white));
            int iOrdinal = hVar.f8589s0.ordinal();
            if (iOrdinal == 0) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), R.drawable.shape_bg_accent_green));
            } else if (iOrdinal == 1) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), R.drawable.shape_bg_tag_promoted));
            } else if (iOrdinal == 2) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), R.drawable.shape_bg_tag_latest));
            } else if (iOrdinal == 3) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), R.drawable.bg_dev_on_board));
                textView.setTextColor(ContextCompat.getColor(iVar.itemView.getContext(), R.color.main_dark_grey));
            } else if (iOrdinal == 4) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), R.drawable.shape_bg_tag_trending));
            }
        }
        iVar.e.setText(hVar.f8567b);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, UptodownApp.O));
        j4.y yVarD = j4.y.d();
        if (hVar.f8576m != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(hVar.f8576m);
            strO = a3.a.o(sb, UptodownApp.I, ":webp");
        } else {
            strO = null;
        }
        j4.d0 d0VarE = yVarD.e(strO);
        d0VarE.f9931c = true;
        Context context = iVar.itemView.getContext();
        context.getClass();
        d0VarE.g(k4.c.x(context));
        d0VarE.e(imageView, null);
        imageView.setOnClickListener(new f5(12, iVar, hVar));
        imageView.setOnLongClickListener(new b5.c(iVar, hVar, size, i12));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.home_fragment_header_image, viewGroup, false);
        viewG.getClass();
        return new i(viewG, this.f11381a, this.f11382b);
    }
}
