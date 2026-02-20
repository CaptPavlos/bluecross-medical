package n4;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import l4.f5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11444a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f11445b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11446c;

    public o(ArrayList arrayList, d0.i iVar, String str) {
        iVar.getClass();
        this.f11444a = arrayList;
        this.f11445b = iVar;
        this.f11446c = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f11444a;
        if (arrayList == null) {
            return 0;
        }
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        y5.f0 f0Var = (y5.f0) viewHolder;
        f0Var.getClass();
        ArrayList arrayList = this.f11444a;
        h5.z zVar = arrayList != null ? (h5.z) arrayList.get(i10) : null;
        zVar.getClass();
        String str = this.f11446c;
        str.getClass();
        TextView textView = f0Var.f13859b;
        textView.setText(zVar.f8800a);
        f0Var.f13860c.setText(zVar.f8801b);
        f0Var.itemView.setOnClickListener(new f5(29, f0Var, zVar));
        if (o7.u.Z(zVar.f8802c, "ar", false)) {
            if (str.equals("ar")) {
                return;
            }
            SpannableString spannableString = new SpannableString(zVar.f8800a);
            spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, spannableString.length(), 33);
            textView.setText(spannableString);
            return;
        }
        if (str.equals("ar")) {
            SpannableString spannableString2 = new SpannableString(zVar.f8800a);
            spannableString2.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, spannableString2.length(), 33);
            textView.setText(spannableString2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View viewG = com.mbridge.msdk.dycreator.baseview.a.g(viewGroup, R.layout.language_item, viewGroup, false);
        viewG.getClass();
        d0.i iVar = this.f11445b;
        iVar.getClass();
        y5.f0 f0Var = new y5.f0(viewG);
        f0Var.f13858a = iVar;
        View viewFindViewById = viewG.findViewById(R.id.tv_language_name_original);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        f0Var.f13859b = textView;
        View viewFindViewById2 = viewG.findViewById(R.id.tv_language_name_localized);
        viewFindViewById2.getClass();
        TextView textView2 = (TextView) viewFindViewById2;
        f0Var.f13860c = textView2;
        textView.setTypeface(o4.b.f11720s);
        textView2.setTypeface(o4.b.f11720s);
        return f0Var;
    }
}
