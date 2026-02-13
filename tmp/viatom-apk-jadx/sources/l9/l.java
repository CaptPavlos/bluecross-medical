package l9;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import d9.q;
import java.util.List;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final List f11136a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11137b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f11138c;

    /* renamed from: d, reason: collision with root package name */
    public final Typeface f11139d;

    public l(List list, Context context, Integer num, Typeface typeface) {
        list.getClass();
        this.f11136a = list;
        this.f11137b = context;
        this.f11138c = num;
        this.f11139d = typeface;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11136a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        k kVar = (k) viewHolder;
        kVar.getClass();
        q qVar = (q) this.f11136a.get(i10);
        Context context = this.f11137b;
        context.getClass();
        qVar.getClass();
        SpannableString spannableString = new SpannableString(qVar.f7575a);
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        TextView textView = kVar.f11135b;
        textView.setText(spannableString);
        Integer num = this.f11138c;
        if (num != null) {
            textView.setTextColor(num.intValue());
        }
        Typeface typeface = kVar.f11134a;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        if (qVar.f7576b.length() > 0) {
            kVar.itemView.setOnClickListener(new f5(9, context, qVar));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.list_publisher_link, viewGroup, false);
        viewG.getClass();
        return new k(viewG, this.f11139d);
    }
}
