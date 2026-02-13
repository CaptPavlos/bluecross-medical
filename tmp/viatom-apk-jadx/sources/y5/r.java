package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g5.j f13980a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f13981b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f13982c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(View view, g5.j jVar) {
        super(view);
        jVar.getClass();
        this.f13980a = jVar;
        View viewFindViewById = view.findViewById(R.id.tv_floating_categories);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.f13981b = textView;
        View viewFindViewById2 = view.findViewById(R.id.ll_floating_categories);
        viewFindViewById2.getClass();
        this.f13982c = (LinearLayout) viewFindViewById2;
        textView.setTypeface(o4.b.f11719r);
    }

    public final void a(ArrayList arrayList) {
        arrayList.getClass();
        this.f13981b.setText(this.itemView.getContext().getString(R.string.it_may_interest_you));
        ViewGroup viewGroup = this.f13982c;
        if (viewGroup.getChildCount() == 0) {
            Iterator it = arrayList.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                h5.k kVar = (h5.k) next;
                View viewInflate = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.chip_floating_category, viewGroup, false);
                viewInflate.getClass();
                TextView textView = (TextView) viewInflate;
                textView.setTypeface(o4.b.f11719r);
                textView.setText(kVar.f8633b);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int dimension = (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m);
                if (kVar.equals(t6.l.i0(arrayList))) {
                    layoutParams.setMargins(dimension, 0, dimension, 0);
                } else {
                    layoutParams.setMargins(dimension, 0, 0, 0);
                }
                textView.setLayoutParams(layoutParams);
                textView.setOnClickListener(new f5(23, this, kVar));
                viewGroup.addView(textView);
            }
        }
    }
}
