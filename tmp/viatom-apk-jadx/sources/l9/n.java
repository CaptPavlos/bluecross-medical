package l9;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import d9.r;
import java.util.ArrayList;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f11145a;

    /* renamed from: b, reason: collision with root package name */
    public final e6.c f11146b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f11147c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f11148d;
    public final Typeface e;

    public n(ArrayList arrayList, e6.c cVar, Integer num, Integer num2, Typeface typeface) {
        this.f11145a = arrayList;
        this.f11146b = cVar;
        this.f11147c = num;
        this.f11148d = num2;
        this.e = typeface;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11145a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        m mVar = (m) viewHolder;
        mVar.getClass();
        r rVar = (r) this.f11145a.get(i10);
        rVar.getClass();
        TextView textView = mVar.h;
        textView.setText(rVar.f7578b);
        TextView textView2 = mVar.g;
        textView2.setText(rVar.f7579c);
        Integer num = mVar.f11141b;
        if (num != null) {
            int iIntValue = num.intValue();
            textView.setTextColor(iIntValue);
            textView2.setTextColor(iIntValue);
            mVar.f.setColorFilter(iIntValue);
        }
        Integer num2 = mVar.f11142c;
        if (num2 != null) {
            mVar.f11144i.setBackgroundColor(num2.intValue());
        }
        Typeface typeface = mVar.f11143d;
        if (typeface != null) {
            textView.setTypeface(typeface);
            textView2.setTypeface(typeface);
        }
        mVar.e.setOnClickListener(new f5(10, mVar, rVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.list_item_stack, viewGroup, false);
        viewG.getClass();
        return new m(viewG, this.f11146b, this.f11147c, this.f11148d, this.e);
    }
}
