package l9;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final List f11107a;

    public d(List list) {
        list.getClass();
        this.f11107a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f11107a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        g gVar = (g) viewHolder;
        gVar.getClass();
        TextView textView = gVar.f11113b;
        TextView textView2 = gVar.f11114c;
        TextView textView3 = gVar.f11115d;
        TextView textView4 = gVar.e;
        TextView textView5 = gVar.f;
        f fVar = (f) this.f11107a.get(i10);
        fVar.getClass();
        TextView textView6 = gVar.f11118k;
        textView6.setText(fVar.f11108a);
        TextView textView7 = gVar.f11117j;
        textView7.setText(fVar.f11109b);
        TextView textView8 = gVar.f11116i;
        textView8.setText(fVar.f11110c);
        TextView textView9 = gVar.h;
        textView9.setText(fVar.f11111d);
        TextView textView10 = gVar.g;
        textView10.setText(fVar.e);
        d9.d dVar = i9.a.e;
        if (dVar != null) {
            Integer num = dVar.f7475i;
            if (num != null) {
                int iIntValue = num.intValue();
                textView6.setTextColor(iIntValue);
                textView5.setTextColor(iIntValue);
                textView7.setTextColor(iIntValue);
                textView4.setTextColor(iIntValue);
                textView8.setTextColor(iIntValue);
                textView3.setTextColor(iIntValue);
                textView9.setTextColor(iIntValue);
                textView2.setTextColor(iIntValue);
                textView10.setTextColor(iIntValue);
                textView.setTextColor(iIntValue);
            }
            Integer num2 = dVar.f7471a;
            if (num2 != null) {
                gVar.f11112a.setBackgroundColor(num2.intValue());
            }
        }
        d9.c cVar = i9.a.f9108d;
        if (cVar == null) {
            return;
        }
        Typeface typeface = cVar.f7470b;
        if (typeface != null) {
            textView6.setTypeface(typeface);
            textView5.setTypeface(typeface);
            textView7.setTypeface(typeface);
            textView4.setTypeface(typeface);
            textView8.setTypeface(typeface);
            textView3.setTypeface(typeface);
            textView9.setTypeface(typeface);
            textView2.setTypeface(typeface);
            textView10.setTypeface(typeface);
        }
        Typeface typeface2 = cVar.f7469a;
        if (typeface2 == null) {
            return;
        }
        textView.setTypeface(typeface2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.list_item_disclosure, viewGroup, false);
        viewG.getClass();
        return new g(viewG);
    }
}
